package com.devsuperior.dsmovie.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devsuperior.dsmovie.entities.UserEntity;
import com.devsuperior.dsmovie.projections.UserDetailsProjection;
import com.devsuperior.dsmovie.repositories.UserRepository;
import com.devsuperior.dsmovie.tests.UserDetailsFactory;
import com.devsuperior.dsmovie.tests.UserFactory;
import com.devsuperior.dsmovie.utils.CustomUserUtil;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class UserServiceTests {

	@InjectMocks
	private UserService service;
	
	@Mock
	private UserRepository repository;
	
	@Mock
	private CustomUserUtil customUserUtil;
	
	private String existingUsername, noExistingUsername;
	private UserEntity user;
	private List<UserDetailsProjection> userDeatils;
	
	@BeforeEach
	void setup() throws Exception {

		existingUsername = "maria@gmail.com";
		noExistingUsername = "user@gmail.com";
		
		user = UserFactory.createUserEntity();
		
		userDeatils = UserDetailsFactory.createCustomAdminClientUser(existingUsername);
		
		Mockito.when(repository.searchUserAndRolesByUsername(existingUsername)).thenReturn(userDeatils);
		Mockito.when(repository.searchUserAndRolesByUsername(noExistingUsername)).thenReturn(new ArrayList<>());
		
		Mockito.when(repository.findByUsername(existingUsername)).thenReturn(Optional.of(user));
		Mockito.when(repository.findByUsername(noExistingUsername)).thenReturn(Optional.empty());
				
	}

	@Test
	public void authenticatedShouldReturnUserEntityWhenUserExists() {
		
		Mockito.when(customUserUtil.getLoggedUsername()).thenReturn(existingUsername);

		UserEntity result = service.authenticated();

		Assertions.assertNotNull(result);
		Assertions.assertEquals(result.getUsername(), existingUsername);
		
	}

	@Test
	public void authenticatedShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists() {
		
		Mockito.doThrow(ClassCastException.class).when(customUserUtil).getLoggedUsername();

		Assertions.assertThrows(UsernameNotFoundException.class, () -> {
			
			@SuppressWarnings("unused")
			UserEntity result = service.authenticated();
			
		} );
	}

	@Test
	public void loadUserByUsernameShouldReturnUserDetailsWhenUserExists() {
		
		UserDetails result = service.loadUserByUsername(existingUsername);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(result.getUsername(), existingUsername);
		
	}

	@Test
	public void loadUserByUsernameShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists() {
	
		Assertions.assertThrows(UsernameNotFoundException.class, () -> {
			service.loadUserByUsername(noExistingUsername);
		});
	}
}

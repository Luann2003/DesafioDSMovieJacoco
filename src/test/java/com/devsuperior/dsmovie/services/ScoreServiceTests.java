package com.devsuperior.dsmovie.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.MovieEntity;
import com.devsuperior.dsmovie.entities.ScoreEntity;
import com.devsuperior.dsmovie.entities.UserEntity;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dsmovie.tests.MovieFactory;
import com.devsuperior.dsmovie.tests.ScoreFactory;
import com.devsuperior.dsmovie.tests.UserFactory;

@ExtendWith(SpringExtension.class)
public class ScoreServiceTests {

	@InjectMocks
	private ScoreService service;
	
	@Mock
	private ScoreRepository repository;
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private MovieService movieService;

	@Mock
	private MovieRepository movieRepository;
	
	private Long existingId, nonExistingId;
	
	private MovieEntity movie;
	private ScoreEntity scoreEntity;
	private ScoreDTO scoreDTO;
	private UserEntity userEntity;
	
	@BeforeEach
	void setup() throws Exception {
		
		existingId = 1L;
		nonExistingId = 2L;
		
		movie = MovieFactory.createMovieEntity();
		scoreDTO = ScoreFactory.createScoreDTO();
		scoreEntity = ScoreFactory.createScoreEntity();
		userEntity = UserFactory.createUserEntity();
		
		Mockito.when(movieRepository.findById(existingId)).thenReturn(Optional.of(movie));
		Mockito.when(movieRepository.findById(nonExistingId)).thenReturn(Optional.empty());
		
		Mockito.when(repository.saveAndFlush(any())).thenReturn(scoreEntity);
		
		Mockito.when(movieRepository.save(any())).thenReturn(movie);
	}	

	@Test
	public void saveScoreShouldReturnMovieDTO() {
		
		MovieDTO result = service.saveScore(scoreDTO);
		assertNotNull(result);
		
	}

	@Test
	public void saveScoreShouldThrowResourceNotFoundExceptionWhenNonExistingMovieId() {
		
		Mockito.when(userService.authenticated()).thenReturn(userEntity);
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			@SuppressWarnings("unused")
			MovieDTO resultId = movieService.findById(nonExistingId);
		});
	}
}

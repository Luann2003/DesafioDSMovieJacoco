# DesafioDSMovieJacoco
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Luann2003/DesafioDSMovieJacoco/blob/main/LICENSE) 

## Sobre o Projeto

Este é um projeto que visa demonstrar a importância da cobertura de testes unitários e o uso do Jacoco para medir essa cobertura. O projeto consiste em uma aplicação que lida com informações de filmes, como pesquisa, atualização e classificação de filmes.

### Testes Unitários

Para garantir a qualidade do código e a funcionalidade correta da aplicação, foram implementados testes unitários abrangentes. Os testes abordam várias partes da aplicação, incluindo o `MovieService`, o `ScoreService` e o `UserService`. Os testes são organizados da seguinte forma:

#### MovieServiceTests

- `findAllShouldReturnPagedMovieDTO`: Verifica se o método `findAll` do `MovieService` retorna um objeto `PagedMovieDTO`.
- `findByIdShouldReturnMovieDTOWhenIdExists`: Testa se o método `findById` do `MovieService` retorna um `MovieDTO` quando um ID válido é fornecido.
- `findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist`: Verifica se o método `findById` do `MovieService` lança uma exceção `ResourceNotFoundException` quando um ID inexistente é fornecido.
- `insertShouldReturnMovieDTO`: Garante que o método `insert` do `MovieService` retorne um `MovieDTO` após a inserção de um filme.
- `updateShouldReturnMovieDTOWhenIdExists`: Testa se o método `update` do `MovieService` retorna um `MovieDTO` quando um ID existente é fornecido.
- `updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist`: Verifica se o método `update` do `MovieService` lança uma exceção `ResourceNotFoundException` quando um ID inexistente é fornecido.
- `deleteShouldDoNothingWhenIdExists`: Garante que o método `delete` do `MovieService` não execute nada de anormal quando um ID existente é fornecido.
- `deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist`: Testa se o método `delete` do `MovieService` lança uma exceção `ResourceNotFoundException` quando um ID inexistente é fornecido.
- `deleteShouldThrowDatabaseExceptionWhenDependentId`: Verifica se o método `delete` do `MovieService` lança uma exceção `DatabaseException` quando há dependências com o ID fornecido.

#### ScoreServiceTests

- `saveScoreShouldReturnMovieDTO`: Testa se o método `saveScore` do `ScoreService` retorna um `MovieDTO`.
- `saveScoreShouldThrowResourceNotFoundExceptionWhenNonExistingMovieId`: Verifica se o método `saveScore` do `ScoreService` lança uma exceção `ResourceNotFoundException` quando um ID de filme inexistente é fornecido.

#### UserServiceTests

- `authenticatedShouldReturnUserEntityWhenUserExists`: Testa se o método `authenticated` do `UserService` retorna uma entidade de usuário quando um usuário existe.
- `authenticatedShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists`: Verifica se o método `authenticated` do `UserService` lança uma exceção `UsernameNotFoundException` quando um usuário não existe.
- `loadUserByUsernameShouldReturnUserDetailsWhenUserExists`: Testa se o método `loadUserByUsername` do `UserService` retorna detalhes de usuário quando um usuário existe.
- `loadUserByUsernameShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists`: Verifica se o método `loadUserByUsername` do `UserService` lança uma exceção `UsernameNotFoundException` quando um usuário não existe.

### Cobertura de Testes com Jacoco

Para avaliar a cobertura de testes, utilizamos o Jacoco, uma ferramenta poderosa para medir a cobertura de código. Nosso objetivo é alcançar uma cobertura de 100% em todos os testes unitários. 
Os testes e a cobertura de código estão integrados ao nosso fluxo de desenvolvimento, garantindo que todas as novas funcionalidades e correções de bugs sejam devidamente testadas e documentadas.

Esperamos que este projeto sirva como um exemplo prático da importância dos testes unitários e da avaliação da cobertura de código em um ambiente de desenvolvimento.

```bash
# Clone o repositório
git clone https://github.com/Luann2003/DesafioDSMovieJacoco.git

# Navegue até o diretório do projeto
cd DesafioDSMovieJacoco

# Compile e execute o programa
java main.java
```
# Autor
Luan Victor de Ramos Luciano

https://www.linkedin.com/in/luan-luciano-1603b4197/


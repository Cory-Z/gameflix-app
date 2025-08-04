package com.gameflix.authapi;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.gameflix.authapi.model.Movie;
import com.gameflix.authapi.service.MovieService;

@SpringBootTest
@ActiveProfiles("test")
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getAllMovies_ShouldReturnList() {
        List<Movie> movies = movieService.getAllMovies();
        Assertions.assertNotNull(movies, "Movies list should not be null");
    }

    @Test
    void getAllMovies_ShouldNotBeEmpty() {
        List<Movie> movies = movieService.getAllMovies();
        Assertions.assertFalse(movies.isEmpty(), "Movies list should not be empty");
    }

    @Test
    void getAllMovies_ShouldContainExpectedMovie() {
        List<Movie> movies = movieService.getAllMovies();
        boolean containsExpected = movies.stream()
                .anyMatch(movie -> movie.getTitle().equalsIgnoreCase("Inception"));
        Assertions.assertTrue(containsExpected, "Movies list should contain 'Inception'");
    }
}
package com.gameflix.authapi;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.gameflix.authapi.model.Movie;
import com.gameflix.authapi.service.MovieService;
public class MovieServiceTest {


    private final MovieService movieService = new MovieService();

    @Test
    void getAllMovies_ShouldReturnList() {
        System.out.println("Running getAllMovies_ShouldReturnList...");
        List<Movie> movies = movieService.getAllMovies();
        Assertions.assertNotNull(movies, "Movies list should not be null");
    }

    @Test
    void getAllMovies_ShouldNotBeEmpty() {
        System.out.println("Running getAllMovies_ShouldNotBeEmpty...");
        List<Movie> movies = movieService.getAllMovies();
        Assertions.assertFalse(movies.isEmpty(), "Movies list should not be empty");
    }

    @Test
    void getAllMovies_ShouldContainExpectedMovie() {
        System.out.println("Running getAllMovies_ShouldContainExpectedMovie...");
        List<Movie> movies = movieService.getAllMovies();
        boolean containsExpected = movies.stream()
                .anyMatch(movie -> movie.getTitle().equalsIgnoreCase("Incept
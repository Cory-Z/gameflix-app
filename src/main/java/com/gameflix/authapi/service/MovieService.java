package com.gameflix.authapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gameflix.authapi.model.Movie;

@Service
public class MovieService {
    public List<Movie> getAllMovies() {
        return List.of(new Movie("Inception"), new Movie("Interstellar"));
    }
}
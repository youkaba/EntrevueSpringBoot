package com.example.entrevueSpringBoot.service;


import com.example.entrevueSpringBoot.dto.MovieDTO;
import com.example.entrevueSpringBoot.mappers.MovieMapper;
import com.example.entrevueSpringBoot.model.Movie;
import com.example.entrevueSpringBoot.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    private final MovieMapper movieMapper;

    public Movie createMovie(MovieDTO movieRequest) {
        return movieRepository.save(movieMapper.toMovie(movieRequest));
    }

    public Movie searchMovieById(Long id) {
        return movieRepository.findMovieById(id).orElse(null);
    }
}

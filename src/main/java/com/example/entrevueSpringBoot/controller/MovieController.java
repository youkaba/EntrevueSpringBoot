package com.example.entrevueSpringBoot.controller;

import com.example.entrevueSpringBoot.dto.MovieDTO;
import com.example.entrevueSpringBoot.model.Movie;
import com.example.entrevueSpringBoot.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("api/film")
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody MovieDTO movieDtoRequest) {
        log.info("new movie creation {}", movieDtoRequest);
        return ResponseEntity.status(CREATED)
                .body(movieService.createMovie(movieDtoRequest));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Movie getMovieById(@PathVariable Long id) {
        log.info("search movie by id {}", id);
        return movieService.searchMovieById(id);
    }
}

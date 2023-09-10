package dev.jpjbriones.movies.controller;

import dev.jpjbriones.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<?> getAll() {
        return movieService.findAll();
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return movieService.findById(id);
    }

}

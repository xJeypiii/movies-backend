package dev.jpjbriones.movies.service;

import dev.jpjbriones.movies.model.ApiResponse;
import dev.jpjbriones.movies.model.Movie;
import dev.jpjbriones.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(movieRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getLocalizedMessage(), false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> findById(String id) {
        try {
            Optional<Movie> movie = movieRepository.findById(id);
            if(movie.isPresent()) {
                return new ResponseEntity<>(movie.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ApiResponse("Movie not found.", false), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getLocalizedMessage(), false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

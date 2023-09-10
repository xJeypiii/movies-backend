package dev.jpjbriones.movies.service;

import dev.jpjbriones.movies.model.ApiResponse;
import dev.jpjbriones.movies.model.Movie;
import dev.jpjbriones.movies.model.Review;
import dev.jpjbriones.movies.repository.MovieRepository;
import dev.jpjbriones.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public ResponseEntity<?> createReview(String id, String body) {
        try {
            Optional<Movie> movie = movieRepository.findById(id);
            if(movie.isEmpty()) {
                return new ResponseEntity<>(new ApiResponse("Movie not found.", false), HttpStatus.NOT_FOUND);
            }

            Review review = new Review();
            review.setValue(body);
            review.setMovie(movie.get());

            Review result = reviewRepository.save(review);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getLocalizedMessage(), false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

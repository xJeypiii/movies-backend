package dev.jpjbriones.movies.controller;

import dev.jpjbriones.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/movies/{id}/reviews")
    public ResponseEntity<?> createReview(@PathVariable String id, @RequestBody Map<String, String> payload) {
        return reviewService.createReview(id, payload.get("body"));
    }
}

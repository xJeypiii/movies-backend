package dev.jpjbriones.movies.repository;

import dev.jpjbriones.movies.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}

package dev.jpjbriones.movies.repository;

import dev.jpjbriones.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {

}

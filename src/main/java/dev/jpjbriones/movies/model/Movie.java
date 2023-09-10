package dev.jpjbriones.movies.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    private String id;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;

    @ManyToMany
    @JoinTable(
            name = "movies_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @ElementCollection
    @CollectionTable(name="backdrops", joinColumns=@JoinColumn(name="movie_id"))
    @Column(name="value")
    private List<String> backdrops;

    @ElementCollection
    @CollectionTable(name="reviews", joinColumns=@JoinColumn(name="movie_id"))
    @Column(name="value")
    private List<String> reviews;

}

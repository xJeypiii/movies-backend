package dev.jpjbriones.movies.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String value;

//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "movies_genres",
//            joinColumns = @JoinColumn(name = "genre_id"),
//            inverseJoinColumns = @JoinColumn(name = "movie_id"))
//    List<Movie> movies;
}

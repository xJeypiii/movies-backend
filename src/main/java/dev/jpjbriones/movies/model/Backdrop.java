package dev.jpjbriones.movies.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "backdrops")
public class Backdrop {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String value;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Movie movie;
}

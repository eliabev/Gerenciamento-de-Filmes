package com.casa.solus.gerenciamento.filmes;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Filmes {

    @Id
    @SequenceGenerator(
            name = "filme_sequence",
            sequenceName = "filme_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "filme_sequence"
    )
    private Long id;
    private String name;
    private LocalDate releaseDate;
    private String director;

    public Filmes() {
    }

    public Filmes(String name, LocalDate releaseDate, String director) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.director = director;
    }

    public Filmes(Long id, String name, LocalDate releaseDate, String director) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.director = director;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Filmes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", director='" + director + '\'' +
                '}';
    }
}

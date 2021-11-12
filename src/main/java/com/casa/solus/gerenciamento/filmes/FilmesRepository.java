package com.casa.solus.gerenciamento.filmes;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes, Long> {

//    @Query("SELECT f FROM Filmes WHERE f.id =?1")
 //   Optional<Filmes> findFilmesById (Long id);

    @Query("SELECT f FROM Filmes f WHERE f.name =?1")
    Optional<Filmes> findFilmeByName(String name);
}
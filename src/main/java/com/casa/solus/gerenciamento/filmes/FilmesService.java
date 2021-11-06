package com.casa.solus.gerenciamento.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesService {

    private final FilmesRepository filmesRepository;

    @Autowired
    public FilmesService(FilmesRepository filmesRepository) {
        this.filmesRepository = filmesRepository;
    }

    public List<Filmes> getFilmes() {
        return filmesRepository.findAll();
    }
}

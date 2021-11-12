package com.casa.solus.gerenciamento.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewFilme(Filmes filme) {
        Optional<Filmes> filmeOptional = filmesRepository.findFilmeByName(filme.getName());
        if (filmeOptional.isPresent()) {
            throw new IllegalStateException("Name already exists");
        }
        filmesRepository.save(filme);
    }
}

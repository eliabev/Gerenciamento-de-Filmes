package com.casa.solus.gerenciamento.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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

    public void deleteFilme(Long filmeId) {
        filmesRepository.findById(filmeId);
        boolean exists = filmesRepository.existsById(filmeId);
        if (!exists) {
            throw new IllegalStateException("film with id " + filmeId + " doesn't exist");
        }
        filmesRepository.deleteById(filmeId);
    }

    @Transactional
    public void updateFilme(Long filmeId, String name, String director) {
        Filmes filme = filmesRepository.findById(filmeId)
                .   orElseThrow(() -> new IllegalStateException(
                        "student with id " + filmeId + " doesn't exist"
                ));
        if (name != null && name.length() > 0 && !Objects.equals(filme.getName(), name)) {
            filme.setName(name);
        }

        if (director != null && director.length() > 0 && !Objects.equals(filme.getDirector(), director)) {
            filme.setDirector(director);
        }
    }
}

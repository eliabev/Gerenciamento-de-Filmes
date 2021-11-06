package com.casa.solus.gerenciamento.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/filmes")
public class FilmesController {

    private final FilmesService filmesService;

    @Autowired
    public FilmesController(FilmesService filmesService) {
        this.filmesService = filmesService;
    }

    @GetMapping
    public List<Filmes> getFilmes() {
        return filmesService.getFilmes();
    }
}

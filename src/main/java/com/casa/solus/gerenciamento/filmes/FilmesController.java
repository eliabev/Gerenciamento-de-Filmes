package com.casa.solus.gerenciamento.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerNewFilme (@RequestBody Filmes filme) {
        filmesService.addNewFilme(filme);
    }

    @DeleteMapping(path = "{filmeId}")
    public void deleteFilme(@PathVariable("filmeId") Long filmeId) {
        filmesService.deleteFilme(filmeId);
    }

    @PutMapping(path = "{filmeId}")
    public void updateFilme (
            @PathVariable("filmeId") Long filmeId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String director) {
        filmesService.updateFilme(filmeId, name, director);
    }

}

package com.casa.solus.gerenciamento.filmes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class FilmesConfig {

    @Bean
    CommandLineRunner commandLineRunner(FilmesRepository filmesRepository) {
        return args -> {
            Filmes ilhaDoMedo = new Filmes(
                    "Ilha do Medo",
                    LocalDate.of(2010, Month.FEBRUARY, 14),
                    "Martin Scorcese"
            );
            Filmes coringa = new Filmes(
                    "Coringa",
                    LocalDate.of(2019, Month.APRIL, 2),
                    "Todd Phillips"
            );

            filmesRepository.saveAll(List.of(ilhaDoMedo, coringa));
        };
    }
}

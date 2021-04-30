package it.prova.raccoltafilmspringbootservletspringdata.repository.film;

import it.prova.raccoltafilmspringbootservletspringdata.model.Film;

import java.util.List;

public interface CustomFilmRepository {
    List<Film> findByExample(Film example);
}

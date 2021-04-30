package it.prova.raccoltafilmspringbootservletspringdata.repository.utente;

import it.prova.raccoltafilmspringbootservletspringdata.model.Utente;

import java.util.List;

public interface CustomUtenteRepository {
    List<Utente> findByExample(Utente example);
}

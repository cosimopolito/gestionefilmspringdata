package it.prova.raccoltafilmspringbootservletspringdata.repository.film;

        import org.springframework.data.jpa.repository.EntityGraph;
        import org.springframework.data.repository.CrudRepository;

        import it.prova.raccoltafilmspringbootservletspringdata.model.Film;

        import java.util.Optional;

public interface FilmRepository extends CrudRepository<Film, Long>, CustomFilmRepository{
        @EntityGraph(attributePaths = { "regista" })
        Optional<Film> findById(Long id);
}

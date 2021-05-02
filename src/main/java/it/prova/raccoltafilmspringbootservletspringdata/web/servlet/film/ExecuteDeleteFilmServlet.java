package it.prova.raccoltafilmspringbootservletspringdata.web.servlet.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.raccoltafilmspringbootservletspringdata.dto.FilmDTO;
import it.prova.raccoltafilmspringbootservletspringdata.model.Film;
import it.prova.raccoltafilmspringbootservletspringdata.service.FilmService;

@Component
public class ExecuteDeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private FilmService filmService;

	public ExecuteDeleteFilmServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idFilmParam = request.getParameter("idFilmDaEliminare");

		try {
			Film filmDaEliminare = filmService.caricaSingoloElemento((Long.parseLong(idFilmParam)));
			filmService.rimuovi(filmDaEliminare);
			request.setAttribute("film_list_attribute",
					FilmDTO.createFilmDTOListFromModelList(filmService.listAllElements(), false));
			request.setAttribute("successMessage", "Operazione effettuata con successo");
			request.getRequestDispatcher("/film/list.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}
	}

}

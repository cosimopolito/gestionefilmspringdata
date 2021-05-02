package it.prova.raccoltafilmspringbootservletspringdata.web.servlet.film;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
public class PrepareDeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private FilmService filmService;

	public PrepareDeleteFilmServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idFilmParam = request.getParameter("idFilm");

		try {
			Film filmDaEliminare = filmService.caricaSingoloElemento(Long.parseLong(idFilmParam));
			request.setAttribute("filmDaEliminare", FilmDTO.buildFilmDTOFromModel(filmDaEliminare, false));
			RequestDispatcher rd = request.getRequestDispatcher("/film/delete.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}
	}

}

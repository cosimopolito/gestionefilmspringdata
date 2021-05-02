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
import it.prova.raccoltafilmspringbootservletspringdata.dto.RegistaDTO;
import it.prova.raccoltafilmspringbootservletspringdata.model.Film;
import it.prova.raccoltafilmspringbootservletspringdata.service.FilmService;
import it.prova.raccoltafilmspringbootservletspringdata.service.RegistaService;

@Component
public class PrepareUpdateFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private FilmService filmService;
	@Autowired
	private RegistaService registaService;

	public PrepareUpdateFilmServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idFilmParam = request.getParameter("idFilm");

		try {
			Film filmDaModificare = filmService.caricaSingoloElementoEager(Long.parseLong(idFilmParam));
			request.setAttribute("registi_list_attribute",
					RegistaDTO.createRegistaDTOListFromModelList(registaService.listAllElements()));
			request.setAttribute("filmDaModificare", FilmDTO.buildFilmDTOFromModel(filmDaModificare, true));
			RequestDispatcher rd = request.getRequestDispatcher("/film/edit.jsp");
			rd.forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("ExecuteSearchFilmServlet").forward(request, response);
			return;
		}
	}

}

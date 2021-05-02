package it.prova.raccoltafilmspringbootservletspringdata.web.servlet.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilmspringbootservletspringdata.dto.RegistaDTO;
import it.prova.raccoltafilmspringbootservletspringdata.model.Regista;
import it.prova.raccoltafilmspringbootservletspringdata.model.Sesso;
import it.prova.raccoltafilmspringbootservletspringdata.service.RegistaService;
import it.prova.raccoltafilmspringbootservletspringdata.utility.Utility;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.raccoltafilmspringbootservletspringdata.dto.FilmDTO;
import it.prova.raccoltafilmspringbootservletspringdata.model.Film;
import it.prova.raccoltafilmspringbootservletspringdata.service.FilmService;

@Component
public class ExecuteSearchFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private FilmService filmService;
	@Autowired
	private RegistaService registaService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titoloParam = request.getParameter("titolo");
		String genereParam = request.getParameter("genere");
		String dataPubblicazioneParam = request.getParameter("dataPubblicazione");
		String minutiDurataParam = request.getParameter("minutiDurata");
		String registaParam = request.getParameter("regista.id");
		Regista regista = new Regista();
		regista.setId(Utility.parseNumberLongFromString(registaParam));
 		Film example = new Film(titoloParam, genereParam, Utility.parseDateFromString(dataPubblicazioneParam),
				Utility.parseNumberIntegerFromString(minutiDurataParam), regista);
		try {

			request.setAttribute("film_list_attribute",
					FilmDTO.createFilmDTOListFromModelList(filmService.findByExample(example), false));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/film/search.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/film/list.jsp").forward(request, response);
	}

}

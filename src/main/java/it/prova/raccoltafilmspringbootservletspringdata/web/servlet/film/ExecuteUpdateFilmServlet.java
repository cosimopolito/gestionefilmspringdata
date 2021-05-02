package it.prova.raccoltafilmspringbootservletspringdata.web.servlet.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.raccoltafilmspringbootservletspringdata.dto.FilmDTO;
import it.prova.raccoltafilmspringbootservletspringdata.dto.RegistaDTO;
import it.prova.raccoltafilmspringbootservletspringdata.service.FilmService;
import it.prova.raccoltafilmspringbootservletspringdata.service.RegistaService;

@Component
public class ExecuteUpdateFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private FilmService filmService;
	@Autowired
	private RegistaService registaService;

	public ExecuteUpdateFilmServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("id");
		String titoloParam = request.getParameter("titolo");
		String genereParam = request.getParameter("genere");
		String minutiDurataParam = request.getParameter("minutiDurata");
		String dataPubblicazioneParam = request.getParameter("dataPubblicazione");
		String registaIdParam = request.getParameter("regista.id");

		FilmDTO filmDTOInstance = FilmDTO.createFilmDTOFromParams(titoloParam, genereParam, minutiDurataParam,
				dataPubblicazioneParam, registaIdParam);
		filmDTOInstance.setId(Long.parseLong(idParam));

		filmDTOInstance.validate();

		try {
			if (filmDTOInstance.hasErrors()) {
				request.setAttribute("filmDaModificare", filmDTOInstance);
				request.setAttribute("registi_list_attribute",
						RegistaDTO.createRegistaDTOListFromModelList(registaService.listAllElements()));
				request.getRequestDispatcher("/film/edit.jsp").forward(request, response);
				return;
			}
			filmService.aggiorna(filmDTOInstance.buildFilmModel());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/film/edit.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		// uso il sendRedirect con parametro per evitare il problema del double save on
		// refresh
		response.sendRedirect("ExecuteListFilmServlet?operationResult=SUCCESS");
	}

}

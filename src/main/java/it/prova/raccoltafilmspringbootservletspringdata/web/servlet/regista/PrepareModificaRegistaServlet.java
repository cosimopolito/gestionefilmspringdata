package it.prova.raccoltafilmspringbootservletspringdata.web.servlet.regista;

import it.prova.raccoltafilmspringbootservletspringdata.dto.RegistaDTO;
import it.prova.raccoltafilmspringbootservletspringdata.model.Regista;
import it.prova.raccoltafilmspringbootservletspringdata.service.RegistaService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class PrepareModificaRegistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RegistaService registaService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParameter = request.getParameter("idRegista");

		Regista result = null;

		if (!NumberUtils.isCreatable(idParameter)) {

			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/regista/list.jsp").forward(request, response);
			return;

		}
		RequestDispatcher rd = null;

		try {

			result = registaService.caricaSingoloElemento(Long.parseLong(idParameter));
			request.setAttribute("regista_attribute", RegistaDTO.buildRegistaDTOFromModel(result));

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		rd = request.getRequestDispatcher("/regista/edit.jsp");
		rd.forward(request, response);	}


}

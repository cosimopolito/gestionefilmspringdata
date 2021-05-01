package it.prova.raccoltafilmspringbootservletspringdata.web.servlet.regista;

import it.prova.raccoltafilmspringbootservletspringdata.dto.RegistaDTO;
import it.prova.raccoltafilmspringbootservletspringdata.model.Regista;
import it.prova.raccoltafilmspringbootservletspringdata.service.RegistaService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ExecuteDeleteRegistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RegistaService registaService;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idRegistaParam = request.getParameter("idDeleteInput");

		if (!NumberUtils.isCreatable(idRegistaParam)) {
			request.setAttribute("errorMessage", "Attenzione, si è verificato un errore.");
			request.getRequestDispatcher("regista/search.jsp").forward(request, response);
			return;
		}

		try {

			Regista registaInstance = registaService.caricaSingoloElemento(Long.parseLong(idRegistaParam));
			registaService.rimuovi(registaInstance);
			request.setAttribute("listaRegistiAttribute", RegistaDTO.createRegistaDTOListFromModelList(registaService.listAllElements()));
			request.setAttribute("successMessage", "Operazione eseguita con successo!");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("regista/list.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("ExecuteListRegistaServlet").forward(request, response);	}

}

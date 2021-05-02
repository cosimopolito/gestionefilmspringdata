package it.prova.raccoltafilmspringbootservletspringdata.web.servlet.regista;

import it.prova.raccoltafilmspringbootservletspringdata.dto.RegistaDTO;
import it.prova.raccoltafilmspringbootservletspringdata.model.Regista;
import it.prova.raccoltafilmspringbootservletspringdata.model.Sesso;
import it.prova.raccoltafilmspringbootservletspringdata.service.RegistaService;
import it.prova.raccoltafilmspringbootservletspringdata.utility.Utility;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ExecuteModificaRegistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RegistaService registaService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String nickNameParam = request.getParameter("nickName");
		String dataDiNascitaParam = request.getParameter("dataDiNascita");
		String sessoParam = request.getParameter("sesso");
		RegistaDTO registaDTOInstance = RegistaDTO.createRegistaDTOFromParams(nomeParam, cognomeParam, nickNameParam,
				dataDiNascitaParam, sessoParam);
		registaDTOInstance.setId(Long.parseLong(idParam));
		registaDTOInstance.validate();

		if (registaDTOInstance.hasErrors()) {
			request.setAttribute("regista_attribute", registaDTOInstance);
			request.getRequestDispatcher("/regista/edit.jsp").forward(request, response);
			return;
		}

		try {
			registaService.aggiorna(registaDTOInstance.buildRegistaModel());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/regista/edit.jsp").forward(request, response);
			return;
		}

		response.sendRedirect("ExecuteListRegistaServlet?operationResult=SUCCESS");
	}

}

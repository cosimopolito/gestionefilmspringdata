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
public class PrepareDeleteRegistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RegistaService registaService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParameter = request.getParameter("idRegista");
		Regista registaInstance = registaService.caricaSingoloElementoConFilms(Long.parseLong(idParameter));

        if (!NumberUtils.isCreatable(idParameter)) {

            // qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
            request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
            request.getRequestDispatcher("/regista/list.jsp").forward(request, response);
            return;
        }

        try {

            if (!registaInstance.getFilms().isEmpty()) {
                request.setAttribute("errorMessageEager",
                        "Attenzione impossibile rimuovere regista, sono presenti film.");
                request.setAttribute("registi_list_attribute",
                        RegistaDTO.createRegistaDTOListFromModelList(registaService.listAllElements()));
                request.getRequestDispatcher("/regista/list.jsp").forward(request, response);
                return;
            }


        } catch (Exception e) {

            e.printStackTrace();
            request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
            request.getRequestDispatcher("home").forward(request, response);
            return;
        }

        request.setAttribute("regista_delete", RegistaDTO.buildRegistaDTOFromModel(registaInstance));

        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("/regista/delete.jsp");
        rd.forward(request, response);	}

}

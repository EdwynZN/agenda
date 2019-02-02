package net.tecgurus.agenda.controladores;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import com.google.gson.Gson;
import net.tecgurus.agenda.service.ContactoService;

/**
 * Servlet implementation class ContactosControladores
 */
@WebServlet("/ContactosControladores")
public class ContactosControladores extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Autowired
	private ContactoService contactoService;
	
	//Permite usar la anotación Autowired en el contexto de los servlets.
    public void init (ServletConfig servletConfig) {
    	SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletConfig.getServletContext());
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		if(accion != null) {
			switch(accion) {
				case "buscar":
					Integer idUsuario = Integer.valueOf(request.getParameter("idUsuario"));
					Integer limite = Integer.valueOf(request.getParameter("limite"));
					Integer pagina = Integer.valueOf(request.getParameter("pagina"));
					String busqueda = request.getParameter("busqueda");
					
					Map<String, Object> respuesta = contactoService.buscar(busqueda, idUsuario, 
																			pagina, limite);
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					response.getWriter().write(new Gson().toJson(respuesta));
					response.setStatus(200);
					break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package net.tecgurus.agenda.controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import net.tecgurus.agenda.model.Contacto;
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
				case "buscar":{
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
				}break;
				
				case "traerContacto": {
					
					String idUser = request.getParameter("idUser");
					String idContact = request.getParameter("idContact");
					Contacto contacto = contactoService.traerPorId(Integer.parseInt(idUser), Integer.parseInt(idContact));
					
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					response.getWriter().write(new Gson().toJson(contacto));
					response.setStatus(200);
					
				} break;
				
				case "eliminarContacto": {
					String idUser = request.getParameter("idUser");
					String idContact = request.getParameter("idContact");
					
					contactoService.eliminarContacto(Integer.parseInt(idUser), Integer.parseInt(idContact));
					
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					response.getWriter().write(new Gson().toJson("Contato eliminado"));
					response.setStatus(200);
				} break;
				
				default: {
					System.out.println("no match index");
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					response.getWriter().write("No match index");
					response.setStatus(404);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		System.out.println("accion: " + accion);
		
		switch(accion) {
			case"agregarContacto": {
				System.out.println("agregar contacto");
				
				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String email = request.getParameter("email");
				String telefono = request.getParameter("telefono");
				String direccion = request.getParameter("direccion");
				String fechaNacimiento = request.getParameter("cumple");
				String idUsuario = request.getParameter("idUsuario");
				System.out.println("fecha: " + fechaNacimiento);
				Date currentDate = null;
				try {
					currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento);
				} catch (ParseException e) {
					e.printStackTrace();
				}
	
				Contacto contacto = new Contacto();
				contacto.setNombre(nombre);
				contacto.setApellido(apellidos);
				contacto.setEmail(email);
				contacto.setTelefono(telefono);
				contacto.setDireccion(direccion);
				contacto.setFechaNacimiento(currentDate);
				contacto.setId_usuario(Integer.parseInt(idUsuario));
	
				contactoService.insertarContacto(contacto);
	
				System.out.println("agregar contacto");
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(contacto));
				response.setCharacterEncoding("utf-8");
				response.setStatus(200);
			}break;
			
			case "actualizarContacto" : {
				System.out.println("Actualizar");
				Integer id = Integer.parseInt(request.getParameter("id"));
				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String email = request.getParameter("email");
				String telefono = request.getParameter("telefono");
				String direccion = request.getParameter("direccion");
				String fechaNacimiento = request.getParameter("cumple");
				Integer idUsuario = Integer.valueOf(request.getParameter("idUsuario"));

				System.out.println("fecha: " + fechaNacimiento);
				Date currentDate = null;
				try {
					currentDate = new SimpleDateFormat("yyy-MM-dd").parse(fechaNacimiento);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				Contacto contacto = new Contacto();
				contacto.setId(id);
				contacto.setNombre(nombre);
				contacto.setApellido(apellidos);
				contacto.setEmail(email);
				contacto.setTelefono(telefono);
				contacto.setDireccion(direccion);
				contacto.setFechaNacimiento(currentDate);
				contacto.setId_usuario(idUsuario);

				contactoService.actualizarContacto(contacto);
				
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(new Gson().toJson(contactoService.traerPorId(idUsuario, id)));
				response.setStatus(200);
			} break;
			
			default: {
				System.out.println("no match index");
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("No match index");
				response.setStatus(404);
			}
		
		}
	}

}

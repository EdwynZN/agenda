package net.tecgurus.agenda.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.tecgurus.agenda.dao.ContactoDao;
import net.tecgurus.agenda.model.Contacto;

@Component
public class ContactoService {
	@Autowired
	public ContactoDao contactoDao;
	
	public void insertarContacto(Contacto contacto) {
		contactoDao.insertarContacto(contacto);
	}
	
	public Map<String, Object> buscar(String busqueda, Integer id, Integer pagina, Integer limite){
		long elementos = contactoDao.buscarCount(busqueda, id);
		double totalPaginas = (double)elementos/(double)limite;
		int offset = (pagina-1)*limite;

		if(totalPaginas%1 != 0) totalPaginas++;
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("paginas", (int) totalPaginas);
		respuesta.put("contacto", contactoDao.buscar(busqueda, id, offset, limite));
		
		return respuesta;
	}
	
	public Long buscarCount(String busqueda, Integer id){
		return contactoDao.buscarCount(busqueda, id);
	}
	
	public Contacto traerPorId(Integer idUsuario, Integer idContacto) {
		return contactoDao.traerPorId(idUsuario, idContacto);
	}
	
	public void actualizarContacto(Contacto contacto) {
		contactoDao.actualizarContacto(contacto);
	}
	
	public void eliminarContacto(Integer idUsuario, Integer idContacto) {
		contactoDao.eliminarContacto(idUsuario, idContacto);
	}
}

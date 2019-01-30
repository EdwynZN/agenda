package net.tecgurus.agenda.service;

import java.util.List;

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
	
	public List<Contacto> buscar(String busqueda, Integer id){
		return contactoDao.buscar(busqueda, id);
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

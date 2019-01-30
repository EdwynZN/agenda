package net.tecgurus.agenda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.tecgurus.agenda.mapper.ContactoMapper;
import net.tecgurus.agenda.model.Contacto;

@Component
public class ContactoDao {
	
	@Autowired
	private ContactoMapper contactoMapper;
	
	public void insertarContacto(Contacto contacto) {
		contactoMapper.insertarContacto(contacto);
	}
	
	public List<Contacto> buscar(String busqueda, Integer id){
		return contactoMapper.buscar(busqueda, id);
	}
	
	public Contacto traerPorId(Integer idUsuario, Integer idContacto) {
		return contactoMapper.traerPorId(idUsuario, idContacto);
	}
	
	public void actualizarContacto(Contacto contacto) {
		contactoMapper.actualizarContacto(contacto);
	}
	
	public void eliminarContacto(Integer idUsuario, Integer idContacto) {
		contactoMapper.eliminarContacto(idUsuario, idContacto);
	}
}

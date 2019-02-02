package net.tecgurus.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.tecgurus.agenda.dao.UsuarioDao;
import net.tecgurus.agenda.model.Usuario;

@Component
public class UsuarioService {
	@Autowired
	private UsuarioDao usuarioDao;
	
	public void insertarUsuario(Usuario usuario) {
		usuarioDao.insertarUsuario(usuario);
	}
	
	public Usuario iniciarSesion(String cuenta,String password) {
		return usuarioDao.iniciarSesion(cuenta, password);
	}

	public void actualizarUsuario(Usuario usuario, String password) {
		usuarioDao.actualizarUsuario(usuario, password);
	}
	
	public void eliminarUsuario(Integer idUsuario) {
		usuarioDao.eliminarUsuario(idUsuario);
	}
}

package net.tecgurus.agenda.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.tecgurus.agenda.mapper.UsuarioMapper;
import net.tecgurus.agenda.model.Usuario;

@Component
public class UsuarioDao {
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	public void insertarUsuario(Usuario usuario) {
		usuarioMapper.insertarUsuario(usuario);
	}
	
	public Usuario iniciarSesion(String cuenta,String password) {
		return null;
	}

	public void actualizarUsuario(Usuario usuario, String password) {
		usuarioMapper.actualizarUsuario(usuario, password);
	}
	
	public void eliminarUsuario(Integer idUsuario) {
		usuarioMapper.eliminarUsuario(idUsuario);
	}
}

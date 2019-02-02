package net.tecgurus.agenda.service;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import net.tecgurus.agenda.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/applicationContext.xml"})
public class UsuarioServiceTest {
	@Autowired
	UsuarioService usuarioService;
	
	private Usuario usuario = new Usuario(2, "nTest", "aTest", "dTEst", "tTEst", 
											"eTest", new Date(), "12345");
	@Test
	public void insertarUsuarioTest() {
		usuarioService.insertarUsuario(usuario);
	}
	
	@Test
	public void iniciarSesionTest() {
	}

	@Test
	public void actualizarUsuarioTest() {
		usuarioService.actualizarUsuario(usuario, usuario.getPass());
	}
	
	@Test
	public void eliminarUsuarioTest() {
		usuarioService.eliminarUsuario(usuario.getId());
	}
}
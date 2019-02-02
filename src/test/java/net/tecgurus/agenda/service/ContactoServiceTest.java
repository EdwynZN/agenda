package net.tecgurus.agenda.service;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import net.tecgurus.agenda.model.Contacto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/applicationContext.xml"})
public class ContactoServiceTest {
	@Autowired
	private ContactoService contactoService;
	
	private int idUsuario = 1;
	private int idContacto = 2;
	
	@Test
	public void insertarContactoTest() {
		Contacto contacto = new Contacto(1, 1, "NTest", "aTest", 
				"dTest", "tTest", "eTest1", new Date());
		contactoService.insertarContacto(contacto);
	}
	
	@Test
	public void buscarTest() {
		//contactoService.buscar(null, 1).forEach(System.out::println);
	}
	
	@Test
	public void buscarCountTest(){
		System.out.println(contactoService.buscarCount(null, 1));
	}
	
	@Test
	public void traerPorIdTest() {
		System.out.println(contactoService.traerPorId(idUsuario, idContacto));
	}
	
	@Test
	public void actualizarContactoTest() {
		Contacto contacto = new Contacto(2, 1, "NTest2", "aTest3", 
				"dTest2", "tTest2", "eTest2", new Date());
		contactoService.actualizarContacto(contacto);
		buscarTest();
	}
	
	@Test
	public void eliminarContactoTest() {
		contactoService.eliminarContacto(idUsuario, idContacto);
		buscarTest();
	}
}

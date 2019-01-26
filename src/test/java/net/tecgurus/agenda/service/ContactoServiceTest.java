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
	ContactoService contactoService;
	
	@Test
	public void insertarContactoTest() {
		Contacto contacto = new Contacto(1, 1, "NTest", "aTest", 
				"dTest", "tTest", "eTest", new Date());
		contactoService.insertarContacto(contacto);
	}
	
	@Test
	public void buscarTest() {
		contactoService.buscar(null, 1).forEach(System.out::println);
	}
}

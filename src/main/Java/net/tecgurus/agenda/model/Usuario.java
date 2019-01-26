package net.tecgurus.agenda.model;

import java.util.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Scope("prototype")
public @Data class Usuario {
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String email;
	private Date fechaNacimiento;
	private String pass;
}

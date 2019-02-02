package net.tecgurus.agenda.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.tecgurus.agenda.model.Usuario;

public interface UsuarioMapper {
	
	@Insert("INSERT INTO usuarios(nombre, apellido, direccion, telefono, email, fechaNacimiento, pass)"
			+ " values(#{nombre}, #{apellido}, #{direccion}, #{telefono}, #{email}, #{fechaNacimiento}, #{pass})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertarUsuario(Usuario usuario);
	
	@Select("SELECT * FROM usuarios WHERE email = #{cuenta} AND pass = #{password}")
	public Usuario iniciarSesion(@Param("cuenta") String cuenta, @Param("password") String password);
	
	@Update("UPDATE contactos SET nombre = #{nombre}, apellido = #{apellido},"
			+ " direccion = #{direccion}, telefono = #{telefono},"
			+ " email = #{email}, fechaNacimiento = #{fechaNacimiento}, pass = #{pass}"
			+ " WHERE id = #{id} AND pass = #{password}")
	public void actualizarUsuario(Usuario usuario, @Param("password") String password);
	
	@Delete("DELETE from usuarios WHERE id = #{idUsuario}")
	public void eliminarUsuario(Integer idUsuario);
	
}

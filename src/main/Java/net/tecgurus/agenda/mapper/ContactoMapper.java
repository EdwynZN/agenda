package net.tecgurus.agenda.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.tecgurus.agenda.model.Contacto;

public interface ContactoMapper {
	
	@Insert("INSERT INTO contactos(nombre, apellido, direccion, telefono, email,"
			+ " fechaNacimiento, id_usuario) values(#{nombre}, #{apellido}, #{telefono},"
			+ " #{direccion}, #{email}, #{fechaNacimiento}, #{id_usuario})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertarContacto(Contacto contacto);
	
	public List<Contacto> buscar(@Param("busqueda") String busqueda, @Param("id") int id);
	
	public Long buscarCount(@Param("busqueda") String busqueda, Integer id);
	
	@Select("SELECT * FROM contactos WHERE id_usuario = #{idUsuario} AND id = #{idContacto}")
	public Contacto traerPorId(@Param("idUsuario") int idUsuario, @Param("idContacto") int idContacto);
	
	@Update("UPDATE contactos SET nombre = #{nombre}, apellido = #{apellido}, direccion = #{direccion},"
			+ " telefono = #{telefono}, fechaNacimiento = #{fechaNacimiento}"
			+ " WHERE id_usuario = #{id_usuario} AND id = #{id}")
	public void actualizarContacto(Contacto contacto);
	
	@Delete("DELETE FROM contactos WHERE id_usuario = #{idUsuario} AND id = #{idContacto}")
	public void eliminarContacto(@Param("idUsuario") int idUsuario, @Param("idContacto") int idContacto);
}

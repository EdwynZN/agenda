package net.tecgurus.agenda.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.tecgurus.agenda.mapper.ContactoMapper;
import net.tecgurus.agenda.model.Contacto;

@Component
public class ContactoDao {
	
	@Autowired
	private ContactoMapper contactoMapper;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public void insertarContacto(Contacto contacto) {
		contactoMapper.insertarContacto(contacto);
	}
	
	public List<Contacto> buscar(String busqueda, Integer idUsuario, Integer offset, Integer limit){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		System.out.println("DAO: "+  busqueda);
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("busqueda", busqueda);
		parametros.put("idUsuario", idUsuario);
		
		return sqlSession.selectList("buscar", parametros, new RowBounds(offset, limit));
	}
	
	public Long buscarCount(String busqueda, Integer id){
		return contactoMapper.buscarCount(busqueda, id);
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

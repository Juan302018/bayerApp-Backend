package cl.bayer.customer.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.bayer.customer.model.entity.Material;
import cl.bayer.customer.model.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	
	@Query(value="select * from usuario where nombre_usuario =:username",nativeQuery=true)
	public Usuario findByNombreUsuario(@Param("username") String username);
}

package cl.bayer.customer.model.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.bayer.customer.model.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	
	@Query(value="select * from usuario where nombre_usuario =:username",nativeQuery=true)
	public Usuario findByNombreUsuario(@Param("username") String username);

	@Query(value="select * from usuario where email =:email",nativeQuery=true)
	
	public Usuario findByEmailUsuario(@Param("email") String email);
}

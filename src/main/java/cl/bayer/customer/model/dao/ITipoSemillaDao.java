package cl.bayer.customer.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.bayer.customer.model.entity.TipoSemilla;


public interface ITipoSemillaDao extends CrudRepository<TipoSemilla, Long> {
	
	@Query(value="select * from tipo_semilla where id_especie =:idEspecie",  nativeQuery=true)
	public List<TipoSemilla> findByEspecie(@Param("idEspecie") Long idEspecie);

}

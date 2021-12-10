package cl.bayer.customer.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.bayer.customer.model.entity.VariedadSemilla;

public interface IVariedadSemillaDao extends CrudRepository<VariedadSemilla, Long> {
	@Query(value="select * from variedad_semilla where id_tipo =:idTipo",  nativeQuery=true)
	public List<VariedadSemilla> findByTipo(@Param("idTipo") Long idTipo);
}

package cl.bayer.customer.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.bayer.customer.model.entity.Material;

public interface IMaterialDao extends CrudRepository<Material, Long> {

	@Query("from Material mate where mate.especie.id_especie =:idEspecie")
	List<Material> listarMaterialesPorEspecie(@Param("idEspecie") Long idEspecie);
	
	@Query("from Material mate where mate.tipo.id_tipo =:idTipo")
	List<Material> listarMaterialesPorTipo(@Param("idTipo") Long idTipo);
	
	@Query("from Material mate where mate.variedad.id_variedad =:idVariedad")
	List<Material> listarMaterialesPorVariedad(@Param("idVariedad") Long idVariedad);

}

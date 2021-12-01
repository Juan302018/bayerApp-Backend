package cl.bayer.customer.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.bayer.customer.model.entity.Material;

public interface IMaterialDao extends CrudRepository<Material, Long> {

	@Query("from Material mate where mate.especieSemilla.id =:idEspecie")
	List<Material> listarMaterialesPorEspecie(@Param("idEspecie") Long idEspecie);
	
	@Query("from Material mate where mate.tipoSemilla.id =:idTipo")
	List<Material> listarMaterialesPorTipo(@Param("idTipo") Long idTipo);
	
	@Query("from Material mate where mate.variedadSemilla.id =:idVariedad")
	List<Material> listarMaterialesPorVariedad(@Param("idVariedad") Long idVariedad);
	
	@Query("from Material mate where mate.especieSemilla.id =:idEspecie and mate.tipoSemilla.id =:idTipo and mate.variedadSemilla.id =:idVariedad")
	public List<Material> findByEspecieByTipoByVariedad(@Param("idEspecie") Long idEspecie, @Param("idTipo") Long idTipo, @Param("idVariedad") Long idVariedad);

}

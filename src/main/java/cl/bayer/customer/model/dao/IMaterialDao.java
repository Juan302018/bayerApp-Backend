package cl.bayer.customer.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.bayer.customer.model.entity.Material;

public interface IMaterialDao extends CrudRepository<Material, Long> {

	@Query(value="select * from material where id_especie =:idEspecie",nativeQuery=true)
	List<Material> listarMaterialesPorEspecie(@Param("idEspecie") Long idEspecie);
	
	@Query(value="select * from material where id_tipo =:idTipo",nativeQuery=true)
	List<Material> listarMaterialesPorTipo(@Param("idTipo") Long idTipo);
	
	@Query(value="select * from material where id_variedad =:idVariedad",nativeQuery=true)
	List<Material> listarMaterialesPorVariedad(@Param("idVariedad") Long idVariedad);
	
	//@Query(value="select * from mw_issue where issue_date LIKE %:date% and target LIKE %:target% and context LIKE %:context% and text LIKE %:text% and cause LIKE %:cause% and issue_type LIKE %:type%", nativeQuery=true)
	
	@Query(value="select * from material where id_especie =:idEspecie and id_tipo=:idTipo and id_variedad =:idVariedad",  nativeQuery=true)
	public List<Material> findByEspecieByTipoByVariedad(@Param("idEspecie") Long idEspecie, @Param("idTipo") Long idTipo, @Param("idVariedad") Long idVariedad);
	
	@Query(value="select * from material where id_especie =:idEspecie and id_tipo=:idTipo",  nativeQuery=true)
	public List<Material> findByEspecieByTipo(@Param("idEspecie") Long idEspecie, @Param("idTipo") Long idTipo);
	
	@Query(value="select * from material where id_especie =:idEspecie and id_variedad=:idVariedad",  nativeQuery=true)
	public List<Material> findByEspecieByVariedad(@Param("idEspecie") Long idEspecie, @Param("idVariedad") Long idVariedad);
	
	@Query(value="select * from material where id_tipo =:idTipo and id_variedad=:idVariedad",  nativeQuery=true)
	public List<Material> findByTipoByVariedad(@Param("idTipo") Long idTipo, @Param("idVariedad") Long idVariedad);
 
}

package cl.bayer.customer.services;

import java.util.List;

import cl.bayer.customer.model.entity.Material;


public interface IMaterialService{
	
public List<Material> findAll();
	
	public Material findById(Long id);
	
	public Material save(Material material);
	
	public void delete(Long id);

	public List<Material> findByEspecie(Long idEspecie);
	
	public List<Material> findByTipo(Long idTipo);
	
	public List<Material> findByVariedad(Long idVariedad);
	
	public List<Material> findByEspecieByTipoByVariedad(Long idEspecie,Long idTipo,Long idVariedad);
}

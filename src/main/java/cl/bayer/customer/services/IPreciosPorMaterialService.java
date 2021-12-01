package cl.bayer.customer.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.bayer.customer.model.entity.PreciosPorMaterial;

@Service
public interface IPreciosPorMaterialService {
	
	public List<PreciosPorMaterial> findAll();
	
	public PreciosPorMaterial findById(Long id);
	
	public PreciosPorMaterial save(PreciosPorMaterial preciosPorMaterial);
	
	public void delete(Long id);

}

package cl.bayer.customer.services;

import java.util.List;

import cl.bayer.customer.model.entity.Unidad;

public interface IUnidadService {
	
	    public List<Unidad> findAll();
		
		public Unidad findById(Long id);
		
		public Unidad save(Unidad unidad);
		
		public void delete(Long id);

}

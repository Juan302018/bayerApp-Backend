package cl.bayer.customer.services;

import java.util.List;

import cl.bayer.customer.model.entity.VariedadSemilla;

public interface IVariedadService {
	
	 public List<VariedadSemilla> findAll();
		
		public VariedadSemilla findById(Long id);
		
		public VariedadSemilla save(VariedadSemilla variedadSemilla);
		
		public void delete(Long id);

}

package cl.bayer.customer.services;

import java.util.List;
import cl.bayer.customer.model.entity.EspecieSemilla;

public interface IEspecieService {
	
	 public List<EspecieSemilla> findAll();
		
		public EspecieSemilla findById(Long id);
		
		public EspecieSemilla save(EspecieSemilla especieSemilla);
		
		public void delete(Long id);

}

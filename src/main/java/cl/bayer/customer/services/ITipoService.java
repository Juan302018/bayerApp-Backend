package cl.bayer.customer.services;

import java.util.List;
import cl.bayer.customer.model.entity.TipoSemilla;

public interface ITipoService {
	
	 public List<TipoSemilla> findAll();
		
		public TipoSemilla findById(Long id);
		
		public List<TipoSemilla> findByIdEspecie(Long idEspecie);
		
		public TipoSemilla save(TipoSemilla tipoSemilla);
		
		public void delete(Long id);

}

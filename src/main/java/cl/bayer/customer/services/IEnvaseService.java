package cl.bayer.customer.services;

import java.util.List;

import cl.bayer.customer.model.entity.Envase;

public interface IEnvaseService {
	
    public List<Envase> findAll();
	
	public Envase findById(Long id);
	
	public Envase save(Envase envase);
	
	public void delete(Long id);
	
	public List<Envase> findListById(Long id);


}

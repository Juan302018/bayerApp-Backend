package cl.bayer.customer.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cl.bayer.customer.model.dao.IUnidadDao;
import cl.bayer.customer.model.entity.Unidad;
import cl.bayer.customer.services.IUnidadService;

public class UnidadService  implements IUnidadService{
	
	@Autowired
	private IUnidadDao unidadDao;

	@Override
	@Transactional(readOnly=true)
	public List<Unidad> findAll() {
		return (List<Unidad>) unidadDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Unidad findById(Long id) {
		return unidadDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Unidad save(Unidad unidad) {
		return unidadDao.save(unidad);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		unidadDao.deleteById(id);
		
	}

}

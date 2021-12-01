package cl.bayer.customer.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cl.bayer.customer.model.dao.IPreciosPorMaterialDao;
import cl.bayer.customer.model.entity.PreciosPorMaterial;
import cl.bayer.customer.services.IPreciosPorMaterialService;

public class PreciosPorMaterialService implements IPreciosPorMaterialService{

	@Autowired
	private IPreciosPorMaterialDao preciosPorMaterialDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<PreciosPorMaterial> findAll() {
		return (List<PreciosPorMaterial>) preciosPorMaterialDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public PreciosPorMaterial findById(Long id) {
		return preciosPorMaterialDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public PreciosPorMaterial save(PreciosPorMaterial preciosPorMaterial) {
		return preciosPorMaterialDao.save(preciosPorMaterial);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		preciosPorMaterialDao.deleteById(id);
		
	}

}

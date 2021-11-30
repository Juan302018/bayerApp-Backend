package cl.bayer.customer.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bayer.customer.model.dao.IMaterialDao;
import cl.bayer.customer.model.entity.Material;
import cl.bayer.customer.services.IMaterialService;

@Service
public class MaterialServiceImpl implements IMaterialService{

	@Autowired
	private IMaterialDao materialDao;

	@Transactional(readOnly=true)
	public List<Material> findAll() {

		return (List<Material>) materialDao.findAll();
	}
	
	@Transactional(readOnly=true)
	public Material findById(Long id) {

		return materialDao.findById(id).orElse(null);
	}

	@Transactional
	public Material save(Material material) {

		return materialDao.save(material);
	}

	@Transactional
	public void delete(Long id) {

		materialDao.deleteById(id);
		
	}
	@Override
	@Transactional(readOnly=true)
	public List<Material> findByEspecie(Long idEspecie) {
		
		return materialDao.listarMaterialesPorEspecie(idEspecie);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Material> findByTipo(Long idTipo) {
		return materialDao.listarMaterialesPorTipo(idTipo);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Material> findByVariedad(Long idVariedad) {
		return materialDao.listarMaterialesPorVariedad(idVariedad);
	}

	
}
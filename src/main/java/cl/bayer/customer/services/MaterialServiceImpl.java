package cl.bayer.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bayer.customer.model.dao.IMaterialDao;
import cl.bayer.customer.model.entity.Material;

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

	
}
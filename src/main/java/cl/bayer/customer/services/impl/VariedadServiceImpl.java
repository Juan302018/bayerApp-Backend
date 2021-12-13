package cl.bayer.customer.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bayer.customer.model.dao.IVariedadSemillaDao;
import cl.bayer.customer.model.entity.VariedadSemilla;
import cl.bayer.customer.services.IVariedadService;

@Service
public class VariedadServiceImpl implements IVariedadService{
	
	@Autowired
	private IVariedadSemillaDao variedadSemillaDao;

	@Override
	@Transactional(readOnly=true)
	public List<VariedadSemilla> findAll() {
		return (List<VariedadSemilla>) variedadSemillaDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public VariedadSemilla findById(Long id) {
		return variedadSemillaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public VariedadSemilla save(VariedadSemilla variedadSemilla) {
		return variedadSemillaDao.save(variedadSemilla);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		variedadSemillaDao.deleteById(id);
		
	}

	@Override
	public List<VariedadSemilla> findByTipoVariedad(Long idTipo) {
		return variedadSemillaDao.findByTipo(idTipo);
	}

}

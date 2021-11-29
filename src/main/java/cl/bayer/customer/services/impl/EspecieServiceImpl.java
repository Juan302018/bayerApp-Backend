package cl.bayer.customer.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bayer.customer.model.dao.IEspecieSemillaDao;
import cl.bayer.customer.model.entity.EspecieSemilla;
import cl.bayer.customer.services.IEspecieService;

@Service
public class EspecieServiceImpl implements IEspecieService{
	
	@Autowired
	private IEspecieSemillaDao especieSemillaDao;

	@Override
	@Transactional(readOnly=true)
	public List<EspecieSemilla> findAll() {
		return (List<EspecieSemilla>) especieSemillaDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public EspecieSemilla findById(Long id) {
		return especieSemillaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public EspecieSemilla save(EspecieSemilla especieSemilla) {
		return especieSemillaDao.save(especieSemilla);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		especieSemillaDao.deleteById(id);
		
	}

}

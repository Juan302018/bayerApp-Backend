package cl.bayer.customer.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bayer.customer.model.dao.IEnvaseDao;
import cl.bayer.customer.model.entity.Envase;
import cl.bayer.customer.services.IEnvaseService;

@Service
public class EnvaseServiceImpl implements IEnvaseService{
	
	@Autowired
	private IEnvaseDao envaseDao;

	@Override
	@Transactional(readOnly=true)
	public List<Envase> findAll() {
		return (List<Envase>) envaseDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Envase findById(Long id) {
		return envaseDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Envase save(Envase envase) {
		return envaseDao.save(envase);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		envaseDao.deleteById(id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Envase> findListById(Long id) {
		return (List<Envase>) envaseDao.findById(id).orElse(null);
	}

}

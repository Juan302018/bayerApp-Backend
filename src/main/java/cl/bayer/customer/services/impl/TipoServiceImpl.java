package cl.bayer.customer.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bayer.customer.model.dao.ITipoSemillaDao;
import cl.bayer.customer.model.entity.TipoSemilla;
import cl.bayer.customer.services.ITipoService;

@Service
public class TipoServiceImpl implements ITipoService{
	
	@Autowired
	private ITipoSemillaDao tipoSemillaDao;

	@Override
	@Transactional(readOnly=true)
	public List<TipoSemilla> findAll() {
		return (List<TipoSemilla>) tipoSemillaDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public TipoSemilla findById(Long id) {
		return tipoSemillaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public TipoSemilla save(TipoSemilla tipoSemilla) {
		return tipoSemillaDao.save(tipoSemilla);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		tipoSemillaDao.deleteById(id);
		
	}

	@Override
	public List<TipoSemilla> findByIdEspecie(Long idEspecie) {
		return tipoSemillaDao.findByEspecie(idEspecie);
	}

}

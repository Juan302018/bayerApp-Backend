package cl.bayer.customer.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cl.bayer.customer.model.dao.IUsuarioDao;
import cl.bayer.customer.model.entity.Usuario;
import cl.bayer.customer.services.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioDao usuarioDao;

	
	@Transactional(readOnly=true)
	public Usuario findByNombreUsuario(String username) {
		// TODO Auto-generated method stub
		return usuarioDao.findByNombreUsuario(username);
	}

}

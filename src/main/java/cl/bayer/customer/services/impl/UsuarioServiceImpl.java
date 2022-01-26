package cl.bayer.customer.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cl.bayer.customer.model.dao.IUsuarioDao;
import cl.bayer.customer.model.entity.Usuario;
import cl.bayer.customer.model.entity.VariedadSemilla;
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
	
	
	@Transactional(readOnly=true)
	public Usuario findByEmailUsuario(String email) {
		// TODO Auto-generated method stub
		return usuarioDao.findByEmailUsuario(email);
	}

	@Transactional(readOnly=true)
	public Optional<Usuario> findById(Long id) {
		return usuarioDao.findById(id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDao.deleteById(id);
		
	}

	
}

package cl.bayer.customer.services;

import cl.bayer.customer.model.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByNombreUsuario(String username);
}

package cl.bayer.customer.services;


import java.util.Optional;

import cl.bayer.customer.model.entity.Usuario;

public interface IUsuarioService{
	public Usuario findByNombreUsuario(String username);
	public Usuario findByEmailUsuario(String email);
	void delete(Long id);
	public Optional<Usuario> findById(Long id);
	public Usuario save(Usuario usuario);
}

package cl.bayer.customer.model.dao;

import org.springframework.data.repository.CrudRepository;

import cl.bayer.customer.model.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}

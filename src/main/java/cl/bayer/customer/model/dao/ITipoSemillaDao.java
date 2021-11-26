package cl.bayer.customer.model.dao;

import org.springframework.data.repository.CrudRepository;

import cl.bayer.customer.model.entity.TipoSemilla;

public interface ITipoSemillaDao extends CrudRepository<TipoSemilla, Long> {

}

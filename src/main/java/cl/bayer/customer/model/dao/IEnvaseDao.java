package cl.bayer.customer.model.dao;

import org.springframework.data.repository.CrudRepository;

import cl.bayer.customer.model.entity.Envase;

public interface IEnvaseDao extends CrudRepository<Envase, Long> {

}

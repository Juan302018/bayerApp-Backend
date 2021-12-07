package cl.bayer.customer.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.bayer.customer.model.entity.Envase;

public interface IEnvaseDao extends CrudRepository<Envase, Long> {

}

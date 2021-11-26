package cl.bayer.customer.model.dao;

import org.springframework.data.repository.CrudRepository;

import cl.bayer.customer.model.entity.Unidad;

public interface IUnidadDao extends CrudRepository<Unidad, Long> {

}

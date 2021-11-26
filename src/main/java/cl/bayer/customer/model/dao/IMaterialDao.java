package cl.bayer.customer.model.dao;

import org.springframework.data.repository.CrudRepository;

import cl.bayer.customer.model.entity.Material;

public interface IMaterialDao extends CrudRepository<Material, Long> {

}

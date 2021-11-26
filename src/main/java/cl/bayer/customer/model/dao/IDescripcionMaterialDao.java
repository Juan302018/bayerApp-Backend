package cl.bayer.customer.model.dao;

import org.springframework.data.repository.CrudRepository;

import cl.bayer.customer.model.entity.DescripcionMaterial;

public interface IDescripcionMaterialDao extends CrudRepository<DescripcionMaterial, Long> {

}

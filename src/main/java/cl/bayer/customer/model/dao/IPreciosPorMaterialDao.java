package cl.bayer.customer.model.dao;

import org.springframework.data.repository.CrudRepository;

import cl.bayer.customer.model.entity.PreciosPorMaterial;

public interface IPreciosPorMaterialDao extends CrudRepository<PreciosPorMaterial, Long> {

}

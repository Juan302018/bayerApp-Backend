package cl.bayer.customer.model.dao;

import org.springframework.data.repository.CrudRepository;

import cl.bayer.customer.model.entity.Compra;

public interface ICompraDao extends CrudRepository<Compra, Long> {

}

package cl.bayer.customer.model.dao;

import org.springframework.data.repository.CrudRepository;

import cl.bayer.customer.model.entity.DetallePedido;

public interface IDetallePedidoDao extends CrudRepository<DetallePedido, Long> {

}

package cl.bayer.customer.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.bayer.customer.model.entity.VariedadSemilla;

public interface IVariedadSemillaDao extends CrudRepository<VariedadSemilla, Long> {

}

package cl.bayer.customer.repo;

import cl.bayer.customer.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMaterialRepo extends JpaRepository<Material, Long> {

}

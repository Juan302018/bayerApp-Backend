package cl.bayer.customer.servicess;

import java.util.List;

public interface ICRUD<M> {

	M registrar(M obj);

	List<M> listar();
	
	M modificar(M obj);

	M leerPorId(Long id);
	
	boolean eliminar(Long id);
}

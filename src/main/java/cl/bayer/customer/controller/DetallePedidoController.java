package cl.bayer.customer.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.bayer.customer.exception.ModelNotFoundException;
import cl.bayer.customer.model.dao.IDetallePedidoDao;
import cl.bayer.customer.model.entity.Compra;
import cl.bayer.customer.model.entity.DetallePedido;
import cl.bayer.customer.model.entity.Envase;
import cl.bayer.customer.model.entity.Material;
import cl.bayer.customer.model.entity.VariedadSemilla;
import cl.bayer.customer.services.IEnvaseService;
import cl.bayer.customer.services.IMaterialService;
import cl.bayer.customer.services.IVariedadService;

@RestController
@RequestMapping("/detalle-pedido")
public class DetallePedidoController {

	@Autowired
	private IDetallePedidoDao service;
	
	@Autowired
	private IMaterialService serviceMaterial;
	
	@Autowired
	private IVariedadService serviceVariedad;
	
	@GetMapping
	public ResponseEntity<List<DetallePedido>> listarEnvases() {
		List<DetallePedido> lista = (List<DetallePedido>) service.findAll();
		if (!lista.isEmpty()) {
			return new ResponseEntity<List<DetallePedido>>(lista, HttpStatus.OK);
		} else {
			throw new ModelNotFoundException("DATA NO ENCONTRADA! " + lista.isEmpty());
		}	
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(consumes={"application/json"})
	public ResponseEntity<Map<String, Object>> registrar(@RequestBody List<DetallePedido> detallePedidoList){
		Map<String, Object> response = new HashMap<String, Object>();
		Compra compra= new Compra();
		
		for (int i = 0; i < detallePedidoList.size(); i++) {
			DetallePedido detallePedido = detallePedidoList.get(i);
			detallePedido.setCompra(compra);
			Material material = serviceMaterial.findById(detallePedido.getMaterialId());
			detallePedido.setMaterial(material);
			VariedadSemilla variedadSemilla = serviceVariedad.findById(detallePedido.getVariedadId());
			detallePedido.setVariedad(variedadSemilla);
			
			service.save(detallePedido);
	    }
		
		response.put("idCompra",compra.getId());
		response.put("mensaje", "La compra ha sido creada con exito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;
     }
	
	@PutMapping
	public ResponseEntity<DetallePedido> modificar(@RequestBody DetallePedido detallePedido){
		DetallePedido objEnvase = service.save(detallePedido);
		return new ResponseEntity<DetallePedido>(objEnvase, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<DetallePedido> eliminar(@PathVariable("id") Long id) {
		Optional<DetallePedido> detallePedido = service.findById(id);
		if (detallePedido.get() == null) {
			throw new ModelNotFoundException("ID ENAVSE NO ENCONTRADO!" + id);
		}
		service.deleteById(id);
		return new ResponseEntity<DetallePedido>(HttpStatus.OK);
	}
}

package cl.bayer.customer.controller;

import java.net.URI;
import java.util.List;

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
import cl.bayer.customer.model.entity.VariedadSemilla;
import cl.bayer.customer.services.IVariedadService;

@RestController
@RequestMapping("/variedad-semilla")
public class VariedadController {
	
	@Autowired
	private IVariedadService service;
	
	@GetMapping
	public ResponseEntity<List<VariedadSemilla>> listarVariedades() {
		List<VariedadSemilla> lista = service.findAll();
		if (!lista.isEmpty()) {
			return new ResponseEntity<List<VariedadSemilla>>(lista, HttpStatus.OK);
		} else {
			throw new ModelNotFoundException("DATA NO ENCONTRADA! " + lista.isEmpty());
		}	
	}
	
	@PostMapping
	public ResponseEntity<VariedadSemilla> registrar(@RequestBody VariedadSemilla variedadSemilla){
		VariedadSemilla objVariedadSemilla = service.save(variedadSemilla);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(variedadSemilla.getId()).toUri();
		return ResponseEntity.created(location).build();
     }
	
	@PutMapping
	public ResponseEntity<VariedadSemilla> modificar(@RequestBody VariedadSemilla variedadSemilla){
		VariedadSemilla objVariedadSemilla = service.save(variedadSemilla);
		return new ResponseEntity<VariedadSemilla>(objVariedadSemilla, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<VariedadSemilla> eliminar(@PathVariable("id") Long id) {
		VariedadSemilla variedadSemilla = service.findById(id);
		if (variedadSemilla.getId() == null) {
			throw new ModelNotFoundException("ID VARIEDAD NO ENCONTRADO!" + id);
		}
		service.delete(id);
		return new ResponseEntity<VariedadSemilla>(HttpStatus.OK);
	}


}

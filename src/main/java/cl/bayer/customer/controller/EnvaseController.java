package cl.bayer.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.net.URI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import cl.bayer.customer.model.entity.Envase;
import cl.bayer.customer.services.IEnvaseService;
import  cl.bayer.customer.exception.ModelNotFoundException;

@RestController
@RequestMapping("/envase")
public class EnvaseController {
	
	@Autowired
	private IEnvaseService service;
	
	@GetMapping
	public ResponseEntity<List<Envase>> listarEnvases() {
		List<Envase> lista = service.findAll();
		if (!lista.isEmpty()) {
			return new ResponseEntity<List<Envase>>(lista, HttpStatus.OK);
		} else {
			throw new ModelNotFoundException("DATA NO ENCONTRADA! " + lista.isEmpty());
		}	
	}
	
	@PostMapping
	public ResponseEntity<Envase> registrar(@RequestBody Envase envase){
		Envase objEnvase = service.save(envase);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(envase.getId()).toUri();
		return ResponseEntity.created(location).build();
     }
	
	@PutMapping
	public ResponseEntity<Envase> modificar(@RequestBody Envase envase){
		Envase objEnvase = service.save(envase);
		return new ResponseEntity<Envase>(objEnvase, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Envase> eliminar(@PathVariable("id") Long id) {
		Envase envase = service.findById(id);
		if (envase.getId() == null) {
			throw new ModelNotFoundException("ID ENAVSE NO ENCONTRADO!" + id);
		}
		service.delete(id);
		return new ResponseEntity<Envase>(HttpStatus.OK);
	}

}

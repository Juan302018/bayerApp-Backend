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
import cl.bayer.customer.model.entity.EspecieSemilla;
import cl.bayer.customer.services.IEspecieService;

@RestController
@RequestMapping("/especie-semilla")
public class EspecieController {
	
	@Autowired
	private IEspecieService service;
	
	@GetMapping
	public ResponseEntity<List<EspecieSemilla>> listarEspecies() {
		List<EspecieSemilla> lista = service.findAll();
		if (!lista.isEmpty()) {
			return new ResponseEntity<List<EspecieSemilla>>(lista, HttpStatus.OK);
		} else {
			throw new ModelNotFoundException("DATA NO ENCONTRADA! " + lista.isEmpty());
		}	
	}
	
	@PostMapping
	public ResponseEntity<EspecieSemilla> registrar(@RequestBody EspecieSemilla especieSemilla){
		EspecieSemilla objEspecieSemilla = service.save(especieSemilla);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(especieSemilla.getId()).toUri();
		return ResponseEntity.created(location).build();
     }
	
	@PutMapping
	public ResponseEntity<EspecieSemilla> modificar(@RequestBody EspecieSemilla especieSemilla){
		EspecieSemilla objEspecieSemilla = service.save(especieSemilla);
		return new ResponseEntity<EspecieSemilla>(objEspecieSemilla, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<EspecieSemilla> eliminar(@PathVariable("id") Long id) {
		EspecieSemilla especieSemilla = service.findById(id);
		if (especieSemilla.getId() == null) {
			throw new ModelNotFoundException("ID ESPECIE NO ENCONTRADO!" + id);
		}
		service.delete(id);
		return new ResponseEntity<EspecieSemilla>(HttpStatus.OK);
	}


}

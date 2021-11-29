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
import cl.bayer.customer.model.entity.TipoSemilla;
import cl.bayer.customer.services.ITipoService;

@RestController
@RequestMapping("/tipo-semilla")
public class TipoController {
	
	@Autowired
	private ITipoService service;
	
	@GetMapping
	public ResponseEntity<List<TipoSemilla>> listarTipos() {
		List<TipoSemilla> lista = service.findAll();
		if (!lista.isEmpty()) {
			return new ResponseEntity<List<TipoSemilla>>(lista, HttpStatus.OK);
		} else {
			throw new ModelNotFoundException("DATA NO ENCONTRADA! " + lista.isEmpty());
		}	
	}
	
	@PostMapping
	public ResponseEntity<TipoSemilla> registrar(@RequestBody TipoSemilla tipoSemilla){
		TipoSemilla objTipoSemilla = service.save(tipoSemilla);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(tipoSemilla.getId()).toUri();
		return ResponseEntity.created(location).build();
     }
	
	@PutMapping
	public ResponseEntity<TipoSemilla> modificar(@RequestBody TipoSemilla tipoSemilla){
		TipoSemilla objTipoSemilla = service.save(tipoSemilla);
		return new ResponseEntity<TipoSemilla>(objTipoSemilla, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<TipoSemilla> eliminar(@PathVariable("id") Long id) {
		TipoSemilla tipoSemilla = service.findById(id);
		if (tipoSemilla.getId() == null) {
			throw new ModelNotFoundException("ID TIPO NO ENCONTRADO!" + id);
		}
		service.delete(id);
		return new ResponseEntity<TipoSemilla>(HttpStatus.OK);
	}

}

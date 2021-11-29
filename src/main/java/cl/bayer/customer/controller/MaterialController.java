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

import  cl.bayer.customer.exception.ModelNotFoundException;
import cl.bayer.customer.model.entity.Material;
import cl.bayer.customer.services.IMaterialService;;

@RestController
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private IMaterialService service;
	
	@GetMapping
	public ResponseEntity<List<Material>> listarMateriales() {
		List<Material> lista = service.findAll();
		if (!lista.isEmpty()) {
			return new ResponseEntity<List<Material>>(lista, HttpStatus.OK);
		} else {
			throw new ModelNotFoundException("DATA NO ENCONTRADA! " + lista.isEmpty());
		}	
	}
	
	@PostMapping
	public ResponseEntity<Material> registrar(@RequestBody Material material){
		Material objMaterial = service.save(material);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(material.getId()).toUri();
		return ResponseEntity.created(location).build();
     }
	
	@PutMapping
	public ResponseEntity<Material> modificar(@RequestBody Material material){
		Material objMaterial = service.save(material);
		return new ResponseEntity<Material>(objMaterial, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Material> eliminar(@PathVariable("id") Long id) {
		Material material = service.findById(id);
		if (material.getId() == null) {
			throw new ModelNotFoundException("ID MATERIAL NO ENCONTRADO!" + id);
		}
		service.delete(id);
		return new ResponseEntity<Material>(HttpStatus.OK);
	}
}

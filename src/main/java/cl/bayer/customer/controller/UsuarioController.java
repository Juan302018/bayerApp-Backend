package cl.bayer.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.bayer.customer.exception.ModelNotFoundException;
import cl.bayer.customer.model.entity.Usuario;
import cl.bayer.customer.services.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	
	@PostMapping("/detallePorNombre/{username}")
	public ResponseEntity<Usuario> findByNombreUsuario(@PathVariable("username") String username) {
		Usuario usuario = service.findByNombreUsuario(username);
		if (usuario == null) {
			throw new ModelNotFoundException("USUARIO NO ENCONTRADO!");
		}
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
	}
}

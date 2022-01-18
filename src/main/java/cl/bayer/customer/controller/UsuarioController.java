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
import cl.bayer.customer.model.entity.Usuario;
import cl.bayer.customer.services.ITipoService;
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

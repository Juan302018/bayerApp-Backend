package cl.bayer.customer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.bayer.customer.dto.FiltroDTO;
import cl.bayer.customer.exception.ModelNotFoundException;
import cl.bayer.customer.model.entity.Envase;
import cl.bayer.customer.model.entity.EspecieSemilla;
import cl.bayer.customer.model.entity.Material;
import cl.bayer.customer.model.entity.TipoSemilla;
import cl.bayer.customer.model.entity.VariedadSemilla;
import cl.bayer.customer.services.IEnvaseService;
import cl.bayer.customer.services.IEspecieService;
import cl.bayer.customer.services.IMaterialService;
import cl.bayer.customer.services.ITipoService;
import cl.bayer.customer.services.IVariedadService;

@RestController
@RequestMapping("/filtro")
public class FiltroController {
	
	@Autowired
	private IMaterialService serviceMaterial;
	
	@Autowired
	private IEnvaseService serviceEnvase;
	
	@Autowired
	private IEspecieService serviceEspecie;
	
	@Autowired
	private ITipoService serviceTipo;
	
	@Autowired
	private IVariedadService serviceVariedad;
	
	@GetMapping("/inicial")
	public ResponseEntity<FiltroDTO> listaInicial() {
		FiltroDTO filtro = new FiltroDTO();
		/*List<Material> materiales = serviceMaterial.findAll();
	    List<Envase> envases = serviceEnvase.findAll();*/
		List<EspecieSemilla> especies = serviceEspecie.findAll();
		List<TipoSemilla> tipos = serviceTipo.findAll();
		List<VariedadSemilla> variadades = serviceVariedad.findAll();
		filtro.setEspecies(especies);
		filtro.setTipos(tipos);
		filtro.setVariadades(variadades);
		if (!especies.isEmpty() && !tipos.isEmpty() && !variadades.isEmpty()) {
			return new ResponseEntity<FiltroDTO>(filtro, HttpStatus.OK);
		} else {
			throw new ModelNotFoundException("DATA NO ENCONTRADA!");
			}
	}
	
	@PostMapping("/lista-filtro/{idEspecie}/{idTipo}/{idVariedad}")
	public ResponseEntity<FiltroDTO> listarFiltros(@PathVariable("idEspecie") Long idEspecie, @PathVariable("idTipo") Long idTipo, @PathVariable("idVariedad") Long idVariedad) {
		FiltroDTO filtro = new FiltroDTO();
		List<Material> materialesPorEspecie = serviceMaterial.findByEspecie(idEspecie);
		List<Material> materialesPorTipo = serviceMaterial.findByTipo(idTipo);
		List<Material> materialesPorVariedad = serviceMaterial.findByVariedad(idVariedad);
		filtro.setMaterialesPorEspecies(materialesPorEspecie);
		filtro.setMaterialesPortipos(materialesPorTipo);
		filtro.setMaterialesPorVariedad(materialesPorVariedad);
		if (!materialesPorEspecie.isEmpty() || !materialesPorTipo.isEmpty() || !materialesPorVariedad.isEmpty()) {
			return new ResponseEntity<FiltroDTO>(filtro, HttpStatus.OK);
		} else {
			throw new ModelNotFoundException("DATA NO ENCONTRADA!");
			}
	}
	}

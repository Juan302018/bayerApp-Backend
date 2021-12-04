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
import cl.bayer.customer.model.entity.PreciosPorMaterial;
import cl.bayer.customer.model.entity.TipoSemilla;
import cl.bayer.customer.model.entity.Unidad;
import cl.bayer.customer.model.entity.VariedadSemilla;
import cl.bayer.customer.services.IEnvaseService;
import cl.bayer.customer.services.IEspecieService;
import cl.bayer.customer.services.IMaterialService;
import cl.bayer.customer.services.IPreciosPorMaterialService;
import cl.bayer.customer.services.ITipoService;
import cl.bayer.customer.services.IUnidadService;
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
	
	@Autowired
	private IUnidadService serviceUnidad;
	
	@Autowired
	private IPreciosPorMaterialService servicePreciosPorMaterial;
	
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
	
	@GetMapping("/todos")
	public ResponseEntity<FiltroDTO> listaTodos() {
		FiltroDTO filtro = new FiltroDTO();
		List<Material> materiales = serviceMaterial.findAll();
	    List<Envase> envases = serviceEnvase.findAll();
		List<EspecieSemilla> especies = serviceEspecie.findAll();
		List<TipoSemilla> tipoSemillas = serviceTipo.findAll();
		List<VariedadSemilla> variedadSemillas = serviceVariedad.findAll();
		List<Unidad> unidades = serviceUnidad.findAll();
		List<PreciosPorMaterial> preciosPorMateriales = servicePreciosPorMaterial.findAll();
		
		for(int i=0;i<materiales.size();i++) {
			Envase envase = serviceEnvase.findById(materiales.get(i).getCodigoEnvase());
			EspecieSemilla especie = serviceEspecie.findById(materiales.get(i).getCodigoEspecie());
			TipoSemilla tipoSemilla = serviceTipo.findById(materiales.get(i).getCodigoTipo());
			VariedadSemilla variedadSemilla = serviceVariedad.findById(materiales.get(i).getCodigoVariedad());
			Unidad unidad = serviceUnidad.findById(materiales.get(i).getCodigoUnidad());
			PreciosPorMaterial precioPorMaterial = servicePreciosPorMaterial.findById(materiales.get(i).getCodigoPrecioMaterial());
			envases.add(envase);
			especies.add(especie);
			tipoSemillas.add(tipoSemilla);
			variedadSemillas.add(variedadSemilla);
			unidades.add(unidad);
			preciosPorMateriales.add(precioPorMaterial);
			
		}
		filtro.setMateriales(materiales);
		filtro.setEnvases(envases);
		filtro.setEspecies(especies);
		filtro.setTipos(tipoSemillas);
		filtro.setVariadades(variedadSemillas);
		filtro.setUnidades(unidades);
		filtro.setPreciosPorMateriales(preciosPorMateriales);
		if ( !materiales.isEmpty()) {
			return new ResponseEntity<FiltroDTO>(filtro, HttpStatus.OK);
		} else {
			throw new ModelNotFoundException("DATA NO ENCONTRADA!");
			}
	}
	
@PostMapping("/lista-filtro/{idEspecie}/{idTipo}/{idVariedad}")
	public ResponseEntity<List<Material>> listarFiltros(@PathVariable("idEspecie") Long idEspecie, @PathVariable("idTipo") Long idTipo, @PathVariable("idVariedad") Long idVariedad) {
		
		
		List<Material> materialesPorEspeciePorVariedadPorTipo = serviceMaterial.findByEspecieByTipoByVariedad(idEspecie,idTipo,idVariedad);
		
		for(int i=0;i<materialesPorEspeciePorVariedadPorTipo.size();i++) {
			Envase envase = serviceEnvase.findById(materialesPorEspeciePorVariedadPorTipo.get(i).getCodigoEnvase());
			EspecieSemilla especie = serviceEspecie.findById(materialesPorEspeciePorVariedadPorTipo.get(i).getCodigoEspecie());
			TipoSemilla tipoSemilla = serviceTipo.findById(materialesPorEspeciePorVariedadPorTipo.get(i).getCodigoTipo());
			VariedadSemilla variedadSemilla = serviceVariedad.findById(materialesPorEspeciePorVariedadPorTipo.get(i).getCodigoVariedad());
			Unidad unidad = serviceUnidad.findById(materialesPorEspeciePorVariedadPorTipo.get(i).getCodigoUnidad());
			PreciosPorMaterial precioPorMaterial = servicePreciosPorMaterial.findById(materialesPorEspeciePorVariedadPorTipo.get(i).getCodigoPrecioMaterial());
			materialesPorEspeciePorVariedadPorTipo.get(i).setEnvase(envase);
			materialesPorEspeciePorVariedadPorTipo.get(i).setEspecieSemilla(especie);
			materialesPorEspeciePorVariedadPorTipo.get(i).setTipoSemilla(tipoSemilla);
			materialesPorEspeciePorVariedadPorTipo.get(i).setVariedadSemilla(variedadSemilla);
			materialesPorEspeciePorVariedadPorTipo.get(i).setUnidad(unidad);
			materialesPorEspeciePorVariedadPorTipo.get(i).setPreciosPorMaterial(precioPorMaterial);
			
		}
		
		

		if (!materialesPorEspeciePorVariedadPorTipo.isEmpty()) {
			return new ResponseEntity<List<Material>>(materialesPorEspeciePorVariedadPorTipo, HttpStatus.OK);
		} else {
			throw new ModelNotFoundException("DATA NO ENCONTRADA!");
			}
	}
	
	}

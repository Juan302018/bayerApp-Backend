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
		List<VariedadSemilla> variedades = serviceVariedad.findAll();
		filtro.setEspecies(especies);
		filtro.setTipos(tipos);
		filtro.setVariedades(variedades);
		if (!especies.isEmpty() && !tipos.isEmpty() && !variedades.isEmpty()) {
			return new ResponseEntity<FiltroDTO>(filtro, HttpStatus.OK);
		} else {
			throw new ModelNotFoundException("DATA NO ENCONTRADA!");
			}
	}
	
	@GetMapping("/todos")
	public ResponseEntity<FiltroDTO> listaTodos() {
		FiltroDTO filtro = new FiltroDTO();
		List<Material> materiales = serviceMaterial.findAll();
		filtro.setMateriales(materiales);
		List<Material> materialObtenido=filtro.getMateriales();
		List<Envase> envases = new ArrayList<>();
		List<EspecieSemilla> especies = new ArrayList<>();
		List<TipoSemilla> tipoSemillas = new ArrayList<>();
		List<VariedadSemilla> variedadSemillas = new ArrayList<>();
		List<Unidad> unidades = new ArrayList<>();
		List<PreciosPorMaterial> preciosPorMateriales = new ArrayList<>();
		
		for(int i=0;i<materialObtenido.size();i++) {
			Envase envase = serviceEnvase.findById(materialObtenido.get(i).getCodigoEnvase());
			EspecieSemilla especie = serviceEspecie.findById(materialObtenido.get(i).getCodigoEspecie());
			TipoSemilla tipoSemilla = serviceTipo.findById(materialObtenido.get(i).getCodigoTipo());
			VariedadSemilla variedadSemilla = serviceVariedad.findById(materialObtenido.get(i).getCodigoVariedad());
			Unidad unidad = serviceUnidad.findById(materialObtenido.get(i).getCodigoUnidad());
			PreciosPorMaterial precioPorMaterial = servicePreciosPorMaterial.findById(materialObtenido.get(i).getCodigoPrecioMaterial());
			envases.add(envase);
			especies.add(especie);
			tipoSemillas.add(tipoSemilla);
			variedadSemillas.add(variedadSemilla);
			unidades.add(unidad);
			preciosPorMateriales.add(precioPorMaterial);
			
		}
		
		filtro.setEnvases(envases);
		filtro.setEspecies(especies);
		filtro.setTipos(tipoSemillas);
		filtro.setVariedades(variedadSemillas);
		filtro.setUnidades(unidades);
		filtro.setPreciosPorMateriales(preciosPorMateriales);
		if ( !materiales.isEmpty()) {
			return new ResponseEntity<FiltroDTO>(filtro, HttpStatus.OK);
		} else {
			throw new ModelNotFoundException("DATA NO ENCONTRADA!");
			}
	}
	
  @SuppressWarnings("null")
@PostMapping("/lista-filtro/{idEspecie}/{idTipo}/{idVariedad}")
	public ResponseEntity<FiltroDTO> listarFiltros(@PathVariable("idEspecie") Long idEspecie, @PathVariable("idTipo") Long idTipo, @PathVariable("idVariedad") Long idVariedad) {
		FiltroDTO filtro = new FiltroDTO();
		
		List<Material> materialesPorEspeciePorVariedadPorTipo = serviceMaterial.findByEspecieByTipoByVariedad(idEspecie,idTipo,idVariedad);
		filtro.setMateriales(materialesPorEspeciePorVariedadPorTipo);
		List<Material> materialObtenido=filtro.getMateriales();
		List<Envase> envases = new ArrayList<>();
		List<EspecieSemilla> especies = new ArrayList<>();
		List<TipoSemilla> tipoSemillas = new ArrayList<>();
		List<VariedadSemilla> variedadSemillas = new ArrayList<>();
		List<Unidad> unidades = new ArrayList<>();
		List<PreciosPorMaterial> preciosPorMateriales = new ArrayList<>();
		
		for(int i=0;i<materialObtenido.size();i++) {
			Envase envase = serviceEnvase.findById(materialObtenido.get(i).getCodigoEnvase());
			EspecieSemilla especie = serviceEspecie.findById(materialObtenido.get(i).getCodigoEspecie());
			TipoSemilla tipoSemilla = serviceTipo.findById(materialObtenido.get(i).getCodigoTipo());
			VariedadSemilla variedadSemilla = serviceVariedad.findById(materialObtenido.get(i).getCodigoVariedad());
			Unidad unidad = serviceUnidad.findById(materialObtenido.get(i).getCodigoUnidad());
			PreciosPorMaterial precioPorMaterial = servicePreciosPorMaterial.findById(materialObtenido.get(i).getCodigoPrecioMaterial());
			envases.add(envase);
			especies.add(especie);
			tipoSemillas.add(tipoSemilla);
			variedadSemillas.add(variedadSemilla);
			unidades.add(unidad);
			preciosPorMateriales.add(precioPorMaterial);
			
		}
	
		filtro.setEnvases(envases);
		filtro.setEspecies(especies);
		filtro.setTipos(tipoSemillas);
		filtro.setVariedades(variedadSemillas);
		filtro.setUnidades(unidades);
		filtro.setPreciosPorMateriales(preciosPorMateriales);

		if (!materialesPorEspeciePorVariedadPorTipo.isEmpty()) {
			return new ResponseEntity<FiltroDTO>(filtro, HttpStatus.OK);
		} else {
			throw new ModelNotFoundException("DATA NO ENCONTRADA!");
			}
	}
	
	}

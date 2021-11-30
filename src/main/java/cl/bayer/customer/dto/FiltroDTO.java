package cl.bayer.customer.dto;

import java.util.List;

import cl.bayer.customer.model.entity.Envase;
import cl.bayer.customer.model.entity.EspecieSemilla;
import cl.bayer.customer.model.entity.Material;
import cl.bayer.customer.model.entity.TipoSemilla;
import cl.bayer.customer.model.entity.VariedadSemilla;

public class FiltroDTO {
	
	private List<Material> materiales;
	private List<Material> materialesPorEspecies;
	private List<Material> materialesPortipos;
	private List<Material> materialesPorVariedad;
	private List<Envase> envases;
	private List<EspecieSemilla> especies;
	private List<TipoSemilla> tipos;
	private List<VariedadSemilla> variadades;
	
	public List<Material> getMateriales() {
		return materiales;
	}
	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}
	public List<Envase> getEnvases() {
		return envases;
	}
	public void setEnvases(List<Envase> envases) {
		this.envases = envases;
	}
	public List<EspecieSemilla> getEspecies() {
		return especies;
	}
	public void setEspecies(List<EspecieSemilla> especies) {
		this.especies = especies;
	}
	public List<TipoSemilla> getTipos() {
		return tipos;
	}
	public void setTipos(List<TipoSemilla> tipos) {
		this.tipos = tipos;
	}
	public List<VariedadSemilla> getVariadades() {
		return variadades;
	}
	public void setVariadades(List<VariedadSemilla> variadades) {
		this.variadades = variadades;
	}
	public List<Material> getMaterialesPorEspecies() {
		return materialesPorEspecies;
	}
	public void setMaterialesPorEspecies(List<Material> materialesPorEspecies) {
		this.materialesPorEspecies = materialesPorEspecies;
	}
	public List<Material> getMaterialesPortipos() {
		return materialesPortipos;
	}
	public void setMaterialesPortipos(List<Material> materialesPortipos) {
		this.materialesPortipos = materialesPortipos;
	}
	public List<Material> getMaterialesPorVariedad() {
		return materialesPorVariedad;
	}
	public void setMaterialesPorVariedad(List<Material> materialesPorVariedad) {
		this.materialesPorVariedad = materialesPorVariedad;
	}

}

package cl.bayer.customer.dto;

import java.util.List;

import cl.bayer.customer.model.entity.Envase;
import cl.bayer.customer.model.entity.EspecieSemilla;
import cl.bayer.customer.model.entity.Material;
import cl.bayer.customer.model.entity.PreciosPorMaterial;
import cl.bayer.customer.model.entity.TipoSemilla;
import cl.bayer.customer.model.entity.Unidad;
import cl.bayer.customer.model.entity.VariedadSemilla;

public class FiltroDTO {
	
	private List<Material> materiales;
	private List<Envase> envases;
	private List<EspecieSemilla> especies;
	private List<TipoSemilla> tipos;
	private List<VariedadSemilla> variadades;
	private List<Unidad> unidades;
	private List<PreciosPorMaterial> preciosPorMateriales;
	
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
	public List<Unidad> getUnidades() {
		return unidades;
	}
	public void setUnidades(List<Unidad> unidades) {
		this.unidades = unidades;
	}
	public List<PreciosPorMaterial> getPreciosPorMateriales() {
		return preciosPorMateriales;
	}
	public void setPreciosPorMateriales(List<PreciosPorMaterial> preciosPorMateriales) {
		this.preciosPorMateriales = preciosPorMateriales;
	}
	
}

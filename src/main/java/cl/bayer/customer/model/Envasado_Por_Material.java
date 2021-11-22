package cl.bayer.customer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "envasado_por_material")
public class Envasado_Por_Material implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEnvPorMaterial;
	
	@Column(name = "Tamaño", nullable = true, length = 15)
	private String tamano;
	
	@Column(name = "Envase", nullable = false, length = 50)
	private String envase;
	
	@Column(name = "Unid. Por Envase", nullable = false, length = 50)
	private float unidPorEnvase;
	
	@Column(name = "Activo", nullable = false, length = 30)
	private boolean activo;
	
	@Column(name = "Material", nullable = false, length = 150)
	private Long material;
	
	public Envasado_Por_Material() {
		super();
	}
	
	public Long getIdEnvPorMaterial() {
		return idEnvPorMaterial;
	}

	public void setIdEnvPorMaterial(Long idEnvPorMaterial) {
		this.idEnvPorMaterial = idEnvPorMaterial;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public String getEnvase() {
		return envase;
	}

	public void setEnvase(String envase) {
		this.envase = envase;
	}

	public float getUnidPorEnvase() {
		return unidPorEnvase;
	}

	public void setUnidPorEnvase(float unidPorEnvase) {
		this.unidPorEnvase = unidPorEnvase;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Long getMaterial() {
		return material;
	}

	public void setMaterial(Long material) {
		this.material = material;
	}
		
}

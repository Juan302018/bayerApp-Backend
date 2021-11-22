package cl.bayer.customer.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "material")
public class Material implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMaterial;
	
	@Column(name = "Tamaño", nullable = true, length = 15)
	private String tamano;
	
	@Column(name = "Variedad", nullable = false, length = 50)
	private String variedad;
	
	@Column(name = "Especie", nullable = false, length = 50)
	private String especie;
	
	@Column(name = "Tipo", nullable = false, length = 150)
	private String tipo;
	
	@OneToOne
	@JoinColumn(name = "idEnvPorMaterial", nullable = true, foreignKey = @ForeignKey(name = "FK_material"))
	private Envasado_Por_Material envPorMaterial;
	
	public Material() {
		super();
	}

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Envasado_Por_Material getEnvPorMaterial() {
		return envPorMaterial;
	}

	public void setEnvPorMaterial(Envasado_Por_Material envPorMaterial) {
		this.envPorMaterial = envPorMaterial;
	}
	
}

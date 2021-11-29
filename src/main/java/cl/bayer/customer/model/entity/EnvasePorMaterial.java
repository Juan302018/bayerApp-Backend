package cl.bayer.customer.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="envase_por_material")
public class EnvasePorMaterial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "id_envase_material")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_descripcion_material",foreignKey = @ForeignKey(name = "FK_descripcion_material"))
	@JsonBackReference
	private DescripcionMaterial descripcionMaterial;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_envase",foreignKey = @ForeignKey(name = "FK_envase"))
	@JsonBackReference
	private Envase envase;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public DescripcionMaterial getDescripcionMaterial() {
		return descripcionMaterial;
	}


	public void setDescripcionMaterial(DescripcionMaterial descripcionMaterial) {
		this.descripcionMaterial = descripcionMaterial;
	}


	public Envase getEnvase() {
		return envase;
	}


	public void setEnvase(Envase envase) {
		this.envase = envase;
	}
	
	

	
}

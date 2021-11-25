package cl.bayer.customer.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PreciosPorMaterial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_precio_material")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_envase_material",foreignKey = @ForeignKey(name = "FK_envase_material"))
	private EnvasePorMaterial envasePorMaterial;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_unidad",foreignKey = @ForeignKey(name = "FK_unidad"))
	private Unidad unidad;
	
	
	@Column(name = "valor_unidad")
	private int valorUnidad;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public EnvasePorMaterial getEnvasePorMaterial() {
		return envasePorMaterial;
	}


	public void setEnvasePorMaterial(EnvasePorMaterial envasePorMaterial) {
		this.envasePorMaterial = envasePorMaterial;
	}


	public Unidad getUnidad() {
		return unidad;
	}


	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}


	public int getValorUnidad() {
		return valorUnidad;
	}


	public void setValorUnidad(int valorUnidad) {
		this.valorUnidad = valorUnidad;
	}
	
	
	
	
	
	

}

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
@Table(name="descripcion_material")
public class DescripcionMaterial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_descripcion_material")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_material",foreignKey = @ForeignKey(name = "FK_material"))
	@JsonBackReference
	private Material material;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_tipo",foreignKey = @ForeignKey(name = "FK_tipo"))
	@JsonBackReference
	private TipoSemilla tipoSemilla;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}


	public TipoSemilla getTipoSemilla() {
		return tipoSemilla;
	}


	public void setTipoSemilla(TipoSemilla tipoSemilla) {
		this.tipoSemilla = tipoSemilla;
	}
	
	
	

}

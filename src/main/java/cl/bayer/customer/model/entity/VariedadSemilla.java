package cl.bayer.customer.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="variedad_semilla")
public class VariedadSemilla implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_variedad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre_variedad")
	private String nombreVariedad;
	
	@OneToMany(mappedBy="variedadSemilla",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Material> materiales;
	
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

	public String getNombreVariedad() {
		return nombreVariedad;
	}

	public void setNombreVariedad(String nombreVariedad) {
		this.nombreVariedad = nombreVariedad;
	}

	public TipoSemilla getTipoSemilla() {
		return tipoSemilla;
	}

	public void setTipoSemilla(TipoSemilla tipoSemilla) {
		this.tipoSemilla = tipoSemilla;
	}
	
	

}

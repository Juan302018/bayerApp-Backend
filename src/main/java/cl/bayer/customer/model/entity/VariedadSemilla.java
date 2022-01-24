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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@OneToMany(mappedBy="variedadSemilla",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Material> materiales;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_tipo",foreignKey = @ForeignKey(name = "FK_tipo"))
	private TipoSemilla tipoSemilla;
	
	public VariedadSemilla() {
		super();
	}

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

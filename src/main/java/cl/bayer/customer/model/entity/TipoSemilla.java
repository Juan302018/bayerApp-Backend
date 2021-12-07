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
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="tipo_semilla")
public class TipoSemilla implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tipo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_especie",foreignKey = @ForeignKey(name = "FK_especie"))
	@JsonBackReference
	private EspecieSemilla especieSemilla;
	
	@OneToMany(mappedBy="tipoSemilla",fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Material> materiales;
	
	@NotEmpty
	@Column(name="nombre_tipo")
	private String nombreTipo;
	
	

	public TipoSemilla() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EspecieSemilla getEspecieSemilla() {
		return especieSemilla;
	}

	public void setEspecieSemilla(EspecieSemilla especieSemilla) {
		this.especieSemilla = especieSemilla;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
	

}

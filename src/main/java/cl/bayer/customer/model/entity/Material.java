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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="material")
public class Material implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "id_material")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "codigo_material")
	private Long codigoMaterial;
	
	@Column(name = "tamano_material")
	private String tamanoMaterial;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo",foreignKey = @ForeignKey(name = "fk_tipo_semilla_material"))
	@JsonBackReference
	private TipoSemilla tipoSemilla;
	
	@Column(name="id_tipo", updatable=false, insertable=false) 
    private Long codigoTipo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_especie",foreignKey = @ForeignKey(name = "fk_especie_semilla_material"))
	@JsonBackReference
	private EspecieSemilla especieSemilla;
	
	@Column(name="id_especie", updatable=false, insertable=false) 
    private Long codigoEspecie;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_variedad",foreignKey = @ForeignKey(name = "fk_variedad_semilla_material"))
	@JsonBackReference
	private VariedadSemilla variedadSemilla;
	
	@Column(name="id_variedad", updatable=false, insertable=false) 
    private Long codigoVariedad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_envase",foreignKey = @ForeignKey(name = "fk_envase_material"))
	@JsonBackReference
	private Envase envase;
	
	@Column(name="id_envase", updatable=false, insertable=false) 
    private Long codigoEnvase;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_unidad",foreignKey = @ForeignKey(name = "fk_unidad_material"))
	@JsonBackReference
	private Unidad unidad;
	
	@Column(name="id_unidad", updatable=false, insertable=false) 
    private Long codigoUnidad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_precio_material",foreignKey = @ForeignKey(name = "fk_precio_material"))
	@JsonBackReference
	private PreciosPorMaterial preciosPorMaterial;
	
	
	@Column(name="id_precio_material", updatable=false, insertable=false) 
    private Long codigoPrecioMaterial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigoMaterial() {
		return codigoMaterial;
	}

	public void setCodigoMaterial(Long codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}

	public String getTamanoMaterial() {
		return tamanoMaterial;
	}

	public void setTamanoMaterial(String tamanoMaterial) {
		this.tamanoMaterial = tamanoMaterial;
	}

	public TipoSemilla getTipoSemilla() {
		return tipoSemilla;
	}

	public void setTipoSemilla(TipoSemilla tipoSemilla) {
		this.tipoSemilla = tipoSemilla;
	}

	public EspecieSemilla getEspecieSemilla() {
		return especieSemilla;
	}

	public void setEspecieSemilla(EspecieSemilla especieSemilla) {
		this.especieSemilla = especieSemilla;
	}

	public VariedadSemilla getVariedadSemilla() {
		return variedadSemilla;
	}

	public void setVariedadSemilla(VariedadSemilla variedadSemilla) {
		this.variedadSemilla = variedadSemilla;
	}

	public Envase getEnvase() {
		return envase;
	}

	public void setEnvase(Envase envase) {
		this.envase = envase;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public PreciosPorMaterial getPreciosPorMaterial() {
		return preciosPorMaterial;
	}

	public void setPreciosPorMaterial(PreciosPorMaterial preciosPorMaterial) {
		this.preciosPorMaterial = preciosPorMaterial;
	}

	public Long getCodigoTipo() {
		return codigoTipo;
	}

	public void setCodigoTipo(Long codigoTipo) {
		this.codigoTipo = codigoTipo;
	}

	public Long getCodigoEspecie() {
		return codigoEspecie;
	}

	public void setCodigoEspecie(Long codigoEspecie) {
		this.codigoEspecie = codigoEspecie;
	}

	public Long getCodigoVariedad() {
		return codigoVariedad;
	}

	public void setCodigoVariedad(Long codigoVariedad) {
		this.codigoVariedad = codigoVariedad;
	}

	public Long getCodigoEnvase() {
		return codigoEnvase;
	}

	public void setCodigoEnvase(Long codigoEnvase) {
		this.codigoEnvase = codigoEnvase;
	}

	public Long getCodigoUnidad() {
		return codigoUnidad;
	}

	public void setCodigoUnidad(Long codigoUnidad) {
		this.codigoUnidad = codigoUnidad;
	}

	public Long getCodigoPrecioMaterial() {
		return codigoPrecioMaterial;
	}

	public void setCodigoPrecioMaterial(Long codigoPrecioMaterial) {
		this.codigoPrecioMaterial = codigoPrecioMaterial;
	}
	
	
	
}

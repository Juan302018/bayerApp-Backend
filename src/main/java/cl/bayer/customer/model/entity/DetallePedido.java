package cl.bayer.customer.model.entity;

import java.io.Serializable;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="detalle_pedido")
public class DetallePedido implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_detalle")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "id_compra",foreignKey = @ForeignKey(name = "FK_compra"))
	private Compra compra;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "id_material",foreignKey = @ForeignKey(name = "FK_material"))
	private Material material;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "id_variedad",foreignKey = @ForeignKey(name = "FK_variedad"))
	private VariedadSemilla variedad;
	
	@Column(name="compraId", updatable=false, insertable=false)
	private Long compraId;
	
	@Column(name="materialId", updatable=false, insertable=false)
	private Long materialId;
	
	@Column(name="variedadId", updatable=false, insertable=false)
	private Long variedadId;
	
	@NotNull
	private int cantidad;
	
	@NotNull
	@Column(name = "precio_unitario")
	private int precioUnitario;
	
	
	@NotNull
	@Column(name = "precio_total")
	private Long precioTotal;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public Long getPrecioTotal() {
		return precioTotal;
	}


	public void setPrecioTotal(Long precioTotal) {
		this.precioTotal = precioTotal;
	}


	public Long getCompraId() {
		return compraId;
	}


	public void setCompraId(Long compraId) {
		this.compraId = compraId;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}


	public Long getMaterialId() {
		return materialId;
	}


	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}


	public Long getVariedadId() {
		return variedadId;
	}


	public void setVariedadId(Long variedadId) {
		this.variedadId = variedadId;
	}


	public VariedadSemilla getVariedad() {
		return variedad;
	}


	public void setVariedad(VariedadSemilla variedad) {
		this.variedad = variedad;
	}
	
	

	
	
	
	
	
	
	
	

}

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_compra",foreignKey = @ForeignKey(name = "FK_compra"))
	@JsonBackReference
	private Compra compra;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_material",foreignKey = @ForeignKey(name = "FK_material"))
	@JsonBackReference
	private Material material;
	
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
	
	
	
	
	

}

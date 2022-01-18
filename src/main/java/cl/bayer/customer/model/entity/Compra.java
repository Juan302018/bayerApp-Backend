package cl.bayer.customer.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

@Entity
@Table(name="compra")
public class Compra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_compra")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompra;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_usuario",foreignKey = @ForeignKey(name = "FK_usuario"))
	@JsonBackReference
	private Usuario usuario;
	
	@OneToMany(mappedBy="compra",fetch=FetchType.LAZY)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<DetallePedido> detallePedido;
	
	@Column(name = "fecha_compra")
	@NotNull
	private String fechaCompra;
	
	@Column(name = "fecha_entrega")
	private String fechaEntrega;

	public Long getId() {
		return idCompra;
	}

	public void setId(Long id) {
		this.idCompra = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(String string) {
		this.fechaCompra = string;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	
	
	
	
}

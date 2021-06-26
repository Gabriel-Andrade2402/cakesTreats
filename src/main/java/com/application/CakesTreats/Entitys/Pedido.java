package com.application.CakesTreats.Entitys;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.application.CakesTreats.Enums.STATUS;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Pedidos")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private STATUS status;
	@JsonIgnore
	@ManyToOne
	private Usuarios usuario;
	private String dataPedida;
	private String dataEntregue;
	@OneToOne
	private Produto produto;

	public Pedido(Long id, STATUS status, Usuarios usuario, String dataPedida, String dataEntregue, Produto produto) {
		this.id = id;
		this.status = status;
		this.usuario = usuario;
		this.dataPedida = dataPedida;
		this.dataEntregue = dataEntregue;
		this.produto = produto;
	}
	public Pedido() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	
	public String getDataPedida() {
		return dataPedida;
	}

	public void setDataPedida(String dataPedida) {
		this.dataPedida = dataPedida;
	}

	public String getDataEntregue() {
		return dataEntregue;
	}

	public void setDataEntregue(String dataEntregue) {
		this.dataEntregue = dataEntregue;
	}

	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEntregue == null) ? 0 : dataEntregue.hashCode());
		result = prime * result + ((dataPedida == null) ? 0 : dataPedida.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (dataEntregue == null) {
			if (other.dataEntregue != null)
				return false;
		} else if (!dataEntregue.equals(other.dataEntregue))
			return false;
		if (dataPedida == null) {
			if (other.dataPedida != null)
				return false;
		} else if (!dataPedida.equals(other.dataPedida))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (status != other.status)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", status=" + status + ", usuario=" + usuario + ", dataPedida=" + dataPedida
				+ ", dataEntregue=" + dataEntregue + ", produto=" + produto + "]";
	}

	

}

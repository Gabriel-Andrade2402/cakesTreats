package com.application.CakesTreats.Entitys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.application.CakesTreats.Enums.CascaOVO;
import com.application.CakesTreats.Enums.STATUS;
import com.application.CakesTreats.Enums.TIPO;
import com.application.CakesTreats.Enums.TipoOVO;
import com.application.CakesTreats.Enums.UM;


@Entity
@Table(name = "Produtos")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double preco;
	private TIPO tipo;
	private TipoOVO tipoOvo;
	private CascaOVO cascaOvo;
	private STATUS status;
	private UM unidadeMedida;
	@OneToOne
	private Sabores sabor;
	public Produto(Long id, String nome, Double preco, TIPO tipo, TipoOVO tipoOvo, CascaOVO cascaOvo, STATUS status,
			UM unidadeMedida, Sabores sabor) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
		this.tipoOvo = tipoOvo;
		this.cascaOvo = cascaOvo;
		this.status = status;
		this.unidadeMedida = unidadeMedida;
		this.sabor = sabor;
	}
	public Produto() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public TIPO getTipo() {
		return tipo;
	}
	public void setTipo(TIPO tipo) {
		this.tipo = tipo;
	}
	public TipoOVO getTipoOvo() {
		return tipoOvo;
	}
	public void setTipoOvo(TipoOVO tipoOvo) {
		this.tipoOvo = tipoOvo;
	}
	public CascaOVO getCascaOvo() {
		return cascaOvo;
	}
	public void setCascaOvo(CascaOVO cascaOvo) {
		this.cascaOvo = cascaOvo;
	}
	public STATUS getStatus() {
		return status;
	}
	public void setStatus(STATUS status) {
		this.status = status;
	}
	public UM getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(UM unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public Sabores getSabor() {
		return sabor;
	}
	public void setSabor(Sabores sabor) {
		this.sabor = sabor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cascaOvo == null) ? 0 : cascaOvo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((sabor == null) ? 0 : sabor.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((tipoOvo == null) ? 0 : tipoOvo.hashCode());
		result = prime * result + ((unidadeMedida == null) ? 0 : unidadeMedida.hashCode());
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
		Produto other = (Produto) obj;
		if (cascaOvo != other.cascaOvo)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (sabor == null) {
			if (other.sabor != null)
				return false;
		} else if (!sabor.equals(other.sabor))
			return false;
		if (status != other.status)
			return false;
		if (tipo != other.tipo)
			return false;
		if (tipoOvo != other.tipoOvo)
			return false;
		if (unidadeMedida != other.unidadeMedida)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", tipo=" + tipo + ", tipoOvo=" + tipoOvo
				+ ", cascaOvo=" + cascaOvo + ", status=" + status + ", unidadeMedida=" + unidadeMedida + ", sabor="
				+ sabor + "]";
	}
	
	
	
	

}

package com.entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Produto {

	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="idProduto")
	private int idProduto;
	
	@Column(name="descrProduto", columnDefinition = "VARCHAR(100)", nullable = false)
	private String descrProduto;
	
	@Column(name="dtUltCompra", columnDefinition = "DATE", nullable = false)
	private Date dtUltCompra;
	
	@Column(name="Qtde", columnDefinition = "INT", nullable = false)
	private int qtde;

	public Produto() {
		super();
	}

	public Produto(String descrProduto, Date dtUltCompra, int qtde) {
		super();
		this.descrProduto = descrProduto;
		this.dtUltCompra = dtUltCompra;
		this.qtde = qtde;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescrProduto() {
		return descrProduto;
	}

	public void setDescrProduto(String descrProduto) {
		this.descrProduto = descrProduto;
	}

	public Date getDtUltCompra() {
		return dtUltCompra;
	}

	public void setDtUltCompra(Date dtUltCompra) {
		this.dtUltCompra = dtUltCompra;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", descrProduto=" + descrProduto + ", dtUltCompra=" + dtUltCompra
				+ ", qtde=" + qtde + "]";
	}
	
	
}

package com.entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.NamedQueries;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "find Pessoa id"  , query = "Select p from Pessoa p where p.idPessoa = :id"),
	@NamedQuery(name = "find Pessoa cpf"  , query = "Select p from Pessoa p where p.cpf = :cpf"),
	@NamedQuery(name = "find Pessoa nome", query = "Select p from Pessoa p where p.nome like :nome"),
	@NamedQuery(name = "list Pessoa", query = "Select p from Pessoa p"),
	@NamedQuery(name = "delete Pessoa"  , query = "Delete from Pessoa p where p.idPessoa = :id"),	
})
public class Pessoa {
	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "idPessoa")
	private int idPessoa;
	
	@Column(name="Nome", columnDefinition ="VARCHAR(100)", nullable = false)
	private String nome;
	
	@Column(name="CPF", columnDefinition ="VARCHAR(11)", nullable = false)
	private String cpf;
	
	@Column(name="RG", columnDefinition ="VARCHAR(11)", nullable = false)
	private String rg; 
	
	@Column(name="dtNascimento", columnDefinition ="DATE", nullable = false)
	private Date dtNascimento; 
	
	
	@Column(name="Altura", columnDefinition ="DECIMAL(10,2)", nullable = false)
	private double altura;

	@Column(name="Peso", columnDefinition ="DECIMAL(10,2)", nullable = false)
	private double peso;
	
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String cpf, String rg, Date dtNascimento, double altura, double peso) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.altura = altura;
		this.peso = peso;
		this.dtNascimento = dtNascimento;
	}

	
	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", dtNascimento="
				+ dtNascimento + ", altura=" + altura + ", peso=" + peso + "]";
	}

	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
}

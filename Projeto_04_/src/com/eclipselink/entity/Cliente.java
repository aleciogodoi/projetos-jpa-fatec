package com.eclipselink.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Inheritance;


@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )

public abstract class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int idCliente;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;

	public Cliente() {
		super();
	}

	public Cliente(int idCliente, String nome, String endereco, String telefone, String email) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	public int getIdClient() {
		return idCliente;
	}

	public void setIdClient(int idClient) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [idClient=" + idCliente + ", Nome=" + nome + ", Endereço=" + endereco + ", Telefone=" + telefone
				+ ", Email=" + email + "]";
	}

}
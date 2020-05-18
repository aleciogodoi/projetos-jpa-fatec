package com.eclipselink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int idFuncionario;
	private String nome;
	private double salario;
	private String cargo;

	public Funcionario(int id, String nome, double salario, String cargo) {
      super( );
      this.idFuncionario = id;
      this.nome = nome;
      this.salario = salario;
      this.cargo = cargo;
	}

	public Funcionario() {
		super();
	}

	public int getId() {
		return idFuncionario;
	}

	public void setId(int id) {
		this.idFuncionario = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + idFuncionario + ", nome=" + nome + ", salario=" + salario + ", cargo=" + cargo + "]";
	}

}

package com.eclipselink.entity;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Cliente {
	private String rg;
	private String cpf;
	private String sexo;
	private Date dtNascimento;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(int idCliente, String nome, String endereco, String telefone, String email,
				String rg, String cpf, String sexo, Date data) {
		super(idCliente, nome, endereco, telefone, email);
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dtNascimento = data;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Pessoa Física [rg=" + rg + ", cpf=" + cpf + ", sexo=" + sexo + "]";
	}
	
}

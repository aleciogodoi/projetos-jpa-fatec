package com.eclipselink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Disciplina {

	@GeneratedValue( strategy = GenerationType.AUTO )
	@Id
	private int idDisciplina;
	private String nomeDisciplina;
    
	public Disciplina() {
		super();
	}

	public Disciplina(int idDisciplina, String nomeDisciplina) {
		super();
		this.idDisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}


	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + idDisciplina + ", nomeDisciplina=" + nomeDisciplina + "]";
	}
	
}

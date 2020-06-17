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
public class Tarefa {
	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "idTarefa")
	private int idTarefa;
	
	@Column(name="DscTarefa", columnDefinition ="VARCHAR(255)", nullable = false)
	private String dscTarefa;
	
	@Column(name="Finalizada", nullable = false)
	private boolean Finalizada; 

	@Column(name="dtInicio", columnDefinition ="DATE", nullable = false)
	private Date dtInicio; 

	@Column(name="dtFim", columnDefinition ="DATE", nullable = false)
	private Date dtFim; 
	
	public Tarefa() {
		super();
	}

	public int getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getDscTarefa() {
		return dscTarefa;
	}

	public void setDscTarefa(String dscTarefa) {
		this.dscTarefa = dscTarefa;
	}

	public boolean isFinalizada() {
		return Finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		Finalizada = finalizada;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	@Override
	public String toString() {
		return "Tarefa [idTarefa=" + idTarefa + ", Descr. Tarefa=" + dscTarefa + ", Finalizada=" + Finalizada
				+ ", Dt. Inicio=" + dtInicio + ", Dt. Fim=" + dtFim + "]";
	}

	
	
}

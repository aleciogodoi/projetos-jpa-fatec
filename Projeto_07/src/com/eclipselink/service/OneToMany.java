package com.eclipselink.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.eclipselink.entity.Departamento;
import com.eclipselink.entity.Funcionario;

public class OneToMany {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		// Cria funcionarios
		Funcionario func01 = new Funcionario(1, "José das Couves", 1027.54, "Gerente");
		Funcionario func02 = new Funcionario(2, "Maria Antonia", 14321.57, "Diretor");
		Funcionario func03 = new Funcionario(3, "Ana Cristina", 7219.98, "Desenvolvedor");
		Funcionario func04 = new Funcionario(4, "Rafaela Almeida", 1027.54, "Gerente");
		Funcionario func05 = new Funcionario(5, "Manuel Henrique", 14321.57, "Diretor");
		Funcionario func06 = new Funcionario(6, "Pedro Augusto", 7219.98, "Coordenador");
		
		// Grava funcionarios
		entitymanager.persist(func01);
		entitymanager.persist(func02);
		entitymanager.persist(func03);
		entitymanager.persist(func04);
		entitymanager.persist(func05);
		entitymanager.persist(func06);
		
		// Lista de funcionarios
		List<Funcionario> funcionarios01 = new ArrayList();
		funcionarios01.add(func01);
		funcionarios01.add(func02);
		funcionarios01.add(func03);
		
		List<Funcionario> funcionarios02 = new ArrayList();
		funcionarios02.add(func03);
		funcionarios02.add(func04);
		funcionarios02.add(func05);

		// Cria departamentos
		Departamento depto01 = new Departamento(1, "TI", funcionarios01);
		Departamento depto02 = new Departamento(2, "Estoque", funcionarios02);
		Departamento depto03 = new Departamento(3, "Administração", funcionarios02);

		// Grava departamentos
		entitymanager.persist(depto01);
		entitymanager.persist(depto02);
		entitymanager.persist(depto03);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}
}

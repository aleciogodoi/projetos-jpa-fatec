package com.servicos;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entidades.Produto;

public class TesteProduto {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
		
		// Inicio Transação
		entitymanager.getTransaction().begin();
		
		// Produtos em memória
		Produto prod01 = new Produto("TV Galaxy ZX48", Date.valueOf(LocalDate.of(2020, 6, 1)), 10);
		Produto prod02 = new Produto("Celular Samsung XP321", Date.valueOf(LocalDate.of(2020, 6, 2)), 5);
		Produto prod03 = new Produto("Microondas", Date.valueOf(LocalDate.of(2020, 6, 1)), 20);
		
		entitymanager.persist(prod01);
		entitymanager.persist(prod02);
		entitymanager.persist(prod03);

		// Fim transação
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

}

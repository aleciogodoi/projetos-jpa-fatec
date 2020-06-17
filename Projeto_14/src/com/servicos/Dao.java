package com.servicos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

import com.entidades.Tarefa;

public class Dao {
	
	public static void insertTarefa(Tarefa tarefa) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(tarefa);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	public static void deleteTarefa(int idTarefa) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Tarefa tarefa = entitymanager.find(Tarefa.class, 1);
		entitymanager.remove(tarefa);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();		
	}

	
	public static void updateTarefa(Tarefa tarefa) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(tarefa);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	public static Tarefa findTarefaId(int idTarefa) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();

		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Tarefa> from = criteriaQuery.from(Tarefa.class);

		CriteriaQuery<Object> select = criteriaQuery.select(from);		
		select.where(criteriaBuilder.equal(from.get("idTarefa"), idTarefa));
		TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
		Tarefa tarefa = (Tarefa) typedQuery.getSingleResult();

		entitymanager.close();
		emfactory.close();
		
		return tarefa;	
	}

	public static List<Tarefa> findDscTarefa(String dscTarefa) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();

		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Tarefa> from = criteriaQuery.from(Tarefa.class);

		CriteriaQuery<Object> select = criteriaQuery.select(from);		
		select.where(criteriaBuilder.like(from.get("dscTarefa"), dscTarefa));
		TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
		List<Object> resultlist = typedQuery.getResultList();
		
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		for (Object o : resultlist) {
			Tarefa tarefa = (Tarefa) o;
			tarefas.add(tarefa);
		}
		entitymanager.close();
		emfactory.close();
		return tarefas;	
	}

	public static List<Tarefa> findBetweenDate(Date dtInicio, Date dtFim) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();

		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Tarefa> from = criteriaQuery.from(Tarefa.class);
		
		CriteriaQuery<Object> select = criteriaQuery.select(from);
		select.where(criteriaBuilder.between(from.get("dtInicio"), dtInicio, dtFim));
		TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
		List<Object> resultlist = typedQuery.getResultList();
	
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		for (Object o : resultlist) {
			Tarefa tarefa = (Tarefa) o;
			tarefas.add(tarefa);
		}
		entitymanager.close();
		emfactory.close();		
		return tarefas;
	}
	
	public static List<Tarefa> allTarefas() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
	
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Tarefa> from = criteriaQuery.from(Tarefa.class);
		
		CriteriaQuery<Object> select = criteriaQuery.select(from);
		TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
		List<Object> resultlist = typedQuery.getResultList();
	
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		for (Object o : resultlist) {
			Tarefa tarefa = (Tarefa) o;
			tarefas.add(tarefa);
		}
		
		entitymanager.close();
		emfactory.close();
		return tarefas;
	} 
	
}

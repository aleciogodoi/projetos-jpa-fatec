package com.servicos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entidades.Pessoa;

public class Dao {
	
	public static void insertPessoa(Pessoa pessoa) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(pessoa);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	public static void deletePessoa(int idPessoa) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createNamedQuery("delete Pessoa");
		query.setParameter("id", idPessoa );
		query.executeUpdate();
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();		
	}

	public static void updatePessoa(Pessoa pessoa) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Pessoa pessoaUpdate = entitymanager.find( Pessoa.class, pessoa.getIdPessoa() );
		pessoaUpdate.setNome(pessoa.getNome());
		pessoaUpdate.setCpf(pessoa.getCpf());
		pessoaUpdate.setRg(pessoa.getRg());
		pessoaUpdate.setDtNascimento(pessoa.getDtNascimento());
		pessoaUpdate.setPeso(pessoa.getPeso());
		pessoaUpdate.setAltura(pessoa.getAltura());
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	public static Pessoa findPessoaId(int idPessoa) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
	
		Pessoa pessoa = new Pessoa();
		
		try {
			Query query = entitymanager.createNamedQuery("find Pessoa id");
			query.setParameter("id", idPessoa );		
			pessoa = (Pessoa) query.getSingleResult();
		} catch (Exception e) {
			pessoa = null;
		} finally {
			entitymanager.close();
			emfactory.close();
		}
		return pessoa;
	}

	public static Pessoa findPessoaCpf(String cpf) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
	
		Pessoa pessoa = new Pessoa();
		
		try {
			Query query = entitymanager.createNamedQuery("find Pessoa cpf");
			query.setParameter("cpf", cpf );		
			pessoa = (Pessoa) query.getSingleResult();
		} catch (Exception e) {
			pessoa = null;
		} finally {
			entitymanager.close();
			emfactory.close();
		}
		return pessoa;	
	}
	
	public static Pessoa findPessoaNome(String nome) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
	
		Pessoa pessoa = new Pessoa();
		
		try {
			Query query = entitymanager.createNamedQuery("find Pessoa nome");
			query.setParameter("nome", nome );		
			pessoa = (Pessoa) query.getSingleResult();
		} catch (Exception e) {
			pessoa = null;
		} finally {
			entitymanager.close();
			emfactory.close();
		}
		return pessoa;			
	}
	
	
	public static List<Pessoa> allPessoas() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("list Pessoa");
		List<Pessoa> pessoas = (List<Pessoa>) query.getResultList();
		
		entitymanager.close();
		emfactory.close();
		return pessoas;
	} 
	
}

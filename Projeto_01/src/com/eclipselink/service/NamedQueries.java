package com.eclipselink.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.eclipselink.entity.Funcionario;

public class NamedQueries {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("find Funcionario id");

		// Consulta por id
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
		query.setParameter("id", id);
		List<Funcionario> funcionario = (List<Funcionario>)query.getResultList();
		
		if (funcionario != null) {
			for (Funcionario f : funcionario) {
				System.out.print("Employee ID :" + f.getId());
				System.out.println("\t Employee Name :" + f.getNome());
			}
		}
		
		// Consulta por nome
		Query query2 = entitymanager.createNamedQuery("find Funcionario nome");
		String nome = JOptionPane.showInputDialog("Nome");
		query2.setParameter("nome", nome);
		List<Funcionario> funcionario2 = (List<Funcionario>)query2.getResultList();
		
		if (funcionario2 != null) {
			for (Funcionario f : funcionario2) {
				System.out.print("Employee ID :" + f.getId());
				System.out.println("\t Employee Name :" + f.getNome());
			}
		}
	}
}

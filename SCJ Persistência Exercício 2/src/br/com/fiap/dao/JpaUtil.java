package br.com.fiap.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SCJ Persistência Exercício 2");

	public static EntityManager getEntityManager() { 
		return emf.createEntityManager();
	}
}
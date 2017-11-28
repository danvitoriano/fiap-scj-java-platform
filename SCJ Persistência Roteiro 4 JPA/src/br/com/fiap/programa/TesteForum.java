package br.com.fiap.programa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import br.com.fiap.entity.Forum;
import br.com.fiap.entity.Usuario;
import br.com.fiap.helper.ForumHelper;

public class TesteForum {
	
	public static void main(String[] args) {
	
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("SCJ Persistência Aula 4 JPA");
		EntityManager entityManager =
				entityManagerFactory.createEntityManager();
		
		ForumHelper dao = new ForumHelper(entityManager);
		Forum forum = new Forum(); forum.setAssunto("JPA"); 
		forum.setDescricao("Java Persistence API");
		System.out.println(dao.salvar(forum));
		
		Usuario usuario = new Usuario(); 
		usuario.setNome("Joaquim"); 
		usuario.setEmail("joaquim@fiap.com.br");
		System.out.println(dao.adicionarUsuario(forum.getId(), usuario));
		
		entityManager.close();
		entityManagerFactory.close();
	} 
}
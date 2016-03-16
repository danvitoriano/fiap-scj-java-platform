package core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.fiap.Forum;
import br.fiap.Usuario;

public class Main {

	public static void main(String[] args) {


		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("SCJ Persistência Aula 3");
		EntityManager entityManager =
				entityManagerFactory.createEntityManager();
		ForumJavaPersistenceDAO p = new ForumJavaPersistenceDAO(entityManager);
		Forum forum=p.createForum("teste2", "desc2");
		Usuario usuario = p.createUsuario("joão2", "joão2@teste.com");
		p.addUsuarioToForum(forum, usuario);

	}

}

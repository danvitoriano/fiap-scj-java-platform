package br.com.fiap.core;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Forum;
import br.com.fiap.entity.MatriculaId;
import br.com.fiap.entity.Usuario;

public class Main {

	public static void main(String[] args) {


		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("SCJ Persistência Aula 3");
		EntityManager entityManager =
				entityManagerFactory.createEntityManager();
		
		
		ClienteJavaPersistenceDAO c1 = new ClienteJavaPersistenceDAO(entityManager);
		c1.criarCliente("José" , 1234, new Date());
		
		
		AlunoJavaPersistenceDAO p1 = new AlunoJavaPersistenceDAO(entityManager);
		
		Aluno aluno1 = p1.criarAluno("José");
		p1.criarMatricula("Lins", 123451, aluno1);
		
		Aluno aluno2 = p1.criarAluno("José");
		p1.criarMatricula("Lins", 67891, aluno2);
		
		System.out.println(p1.buscarAluno(1).getNome());
		System.out.println(p1.buscarMatricula(new MatriculaId(123451, "Lins")).getAluno().getNome());
		
		ForumJavaPersistenceDAO p = new ForumJavaPersistenceDAO(entityManager);
		Forum forum=p.criarForum("teste2", "desc2");
		Usuario usuario = p.criarUsuario("João", "joão@teste.com");
		p.addUsuarioToForum(forum, usuario);

	}

}

package br.com.fiap.core;

import java.util.Date;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Matricula;
import br.com.fiap.entity.MatriculaId;

public class AlunoJavaPersistenceDAO {

	private EntityManager em;

	public AlunoJavaPersistenceDAO(EntityManager em) {
		this.em = em;
	}

	public Aluno criarAluno(String nome){
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
				
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		
		return aluno;
	}
	
	public Matricula criarMatricula(String campus, int numero, Aluno aluno){
		Matricula matricula = new Matricula();
		matricula.setId(new MatriculaId(numero, campus));
		matricula.setAluno(aluno);
		matricula.setData(new Date());
		em.getTransaction().begin();
		em.persist(matricula);
		em.getTransaction().commit();
		
		return matricula;
	}

	public Aluno buscarAluno(int id){
		return em.find(Aluno.class, id);
	}
	
	public Matricula buscarMatricula(MatriculaId id){
		return em.find(Matricula.class, id);
	}
	
	public Aluno alterarNomeAluno(int id, String nome){
		Aluno aluno = this.buscarAluno(id);
		aluno.setNome(nome);
		
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		
		return aluno;
	}

	public void apagarAluno(int id){
		Aluno aluno = this.buscarAluno(id);
		em.remove(aluno);
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
	}
	


	public void closeEntityManager() {
		this.em.close();
	}


}
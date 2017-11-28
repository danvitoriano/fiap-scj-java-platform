package br.com.fiap.programa;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Tarefa;
import br.com.fiap.helper.Helper;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SCJ Persistência Roteiro 6 JPA");
		EntityManager em = emf.createEntityManager();
		Cache cache = emf.getCache();
				
		incluirFuncionario(em);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setMatricula("12345");
		funcionario.setNome("Andre Gonçalves");
		
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Desenvolvimento Front-End");
		tarefa.setDuracao(234);
		tarefa.getFuncionarios().add(funcionario);
		
		incluirFuncionario(em, funcionario, tarefa);
		em.close();
		System.out.println("Funcionario "+funcionario.getNome()+ " está em Cache? " + cache.contains(Funcionario.class, funcionario.getId()));
		 em = emf.createEntityManager();
		buscarFuncionario(em, funcionario);
		System.out.println("Funcionario "+funcionario.getNome()+ " está em Cache? " + cache.contains(Funcionario.class, funcionario.getId()));
		buscarFuncionario(em, funcionario);
		buscarFuncionario(em, funcionario);
		buscarFuncionario(em, funcionario);
		buscarFuncionario(em, funcionario);
		System.out.println("Funcionario "+funcionario.getNome()+ " está em Cache? " + cache.contains(Funcionario.class, funcionario.getId()));
		
		buscarFuncionario(em, funcionario);
		buscarTarefa(em, tarefa);
		
		System.out.println("Funcionario "+funcionario.getNome()+ " está em Cache? " + cache.contains(Funcionario.class, funcionario.getId()));
		
		em = emf.createEntityManager();
		LocalDateTime inicio = LocalDateTime.now();
		listarFuncionarios(em);
		
		System.out.println("Funcionario "+funcionario.getNome()+ " está em Cache? " + cache.contains(Funcionario.class, funcionario.getId()));
		
		
		buscarFuncionario(em, "2000");
		
		System.out.println("Funcionario "+funcionario.getNome()+ " está em Cache? " + cache.contains(Funcionario.class, funcionario.getId()));
		
		
		LocalDateTime fim = LocalDateTime.now();
		System.out.println(ChronoUnit.MILLIS.between(inicio, fim));
		
		inicio = LocalDateTime.now();
		listarFuncionarios(em);
		buscarFuncionario(em, "2000");
		fim = LocalDateTime.now();
		System.out.println(ChronoUnit.MILLIS.between(inicio, fim));
		
		System.out.println("Funcionario "+funcionario.getNome()+ " está em Cache? " + cache.contains(Funcionario.class, funcionario.getId()));
		
		
		em.close();
		emf.close();
	}
	
	private static void incluirFuncionario(EntityManager em, Funcionario funcionario, Tarefa tarefa) {
		Helper dao = new Helper(em);
	
		funcionario.getTarefas().add(tarefa);
		
		try {
			dao.salvar(funcionario);
			System.out.println("Funcionario OK");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	private static void incluirFuncionario(EntityManager em) {
		Helper dao = new Helper(em);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setMatricula("2000");
		funcionario.setNome("Alberto Santos");
		
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Teste Unitário");
		tarefa.setDuracao(100);
		tarefa.getFuncionarios().add(funcionario);
		funcionario.getTarefas().add(tarefa);
		
		try {
			dao.salvar(funcionario);
			System.out.println("Funcionario OK");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void listarFuncionarios(EntityManager em) {
		Helper dao = new Helper(em);
		List<Funcionario> funcionarios = dao.listarTodos();
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getMatricula() + ": " + funcionario.getNome());
		}
	}

	private static void buscarFuncionario(EntityManager em, String matricula) {
		Helper dao = new Helper(em);
		Funcionario f = dao.buscarFuncionario(matricula);
		System.out.println(f.getMatricula() + ": " + f.getNome());
	}
	
	private static void buscarFuncionario(EntityManager em, Funcionario funcionario) {
		Helper dao = new Helper(em);
		funcionario = dao.buscarFuncionario(funcionario.getId());
		System.out.println(funcionario.getMatricula() + ": " + funcionario.getNome());
	}
	
	private static void buscarTarefa(EntityManager em, Tarefa tarefa) {
		Helper dao = new Helper(em);
		tarefa = dao.buscarTarefa(tarefa.getId());
		System.out.println(tarefa.getDescricao() + ": " + tarefa.getDuracao());
	}

}
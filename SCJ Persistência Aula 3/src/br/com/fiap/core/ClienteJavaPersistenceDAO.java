package br.com.fiap.core;

import java.util.Date;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Cliente;

public class ClienteJavaPersistenceDAO {

	private EntityManager em;

	public ClienteJavaPersistenceDAO(EntityManager em) {
		this.em = em;
	}

	public Cliente criarCliente(String nome, int chaveAcesso, Date dataNascimento){
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setChaveAcesso(chaveAcesso);
		cliente.setDataNascimento(dataNascimento);
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		return cliente;
	}
	
	public Cliente buscarCliente(int id){
		return em.find(Cliente.class, id);
	}
	
	public Cliente alterarCliente(Cliente cliente){
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		return cliente;
	}

	public void apagarCliente(int id){
		Cliente cliente = this.buscarCliente(id);
		em.remove(cliente);
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}
	


	public void closeEntityManager() {
		this.em.close();
	}


}
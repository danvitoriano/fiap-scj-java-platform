package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Clientes;

public class Helper {
	private EntityManager em;

	public Helper(EntityManager em){
		this.em = em;
	}

	public void salvar(Clientes clientes) throws Exception { 
		try {
			em.getTransaction().begin(); 
			em.persist(clientes); 
			em.getTransaction().commit();
		} 
		catch (Exception e) {
			throw e;
		} finally { 
			em.close();
		} 
	}

	public List<Clientes> listarClientes(){

		TypedQuery<Clientes> tQuery = em.createQuery("select f from Clientes f", Clientes.class); 
		return tQuery.getResultList();
	}

	public Clientes buscarCliente(Integer idCliente){


		TypedQuery<Clientes> tQuery = em.createQuery("select f from Clientes f where id = :id", Clientes.class);
		tQuery.setParameter("id", idCliente); 
		return tQuery.getSingleResult(); 

	}


}
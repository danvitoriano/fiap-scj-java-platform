package br.com.fiap.helper;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Forum;
import br.com.fiap.entity.Usuario;

public class ForumHelper { 

	private EntityManager em;

	public ForumHelper(EntityManager em){ 
		this.em = em;
	}

	public String salvar(Forum forum){ 
		try{
			em.getTransaction().begin();
			em.persist(forum);
			em.getTransaction().commit();
			return "Forum salvo"; 
		}catch(Exception e){
			return e.getMessage(); 
		}
	}
	
	public String adicionarUsuario(int idForum, Usuario usuario){ 
		try {
			Forum f = em.find(Forum.class, idForum); 
			usuario.setForum(f);
			f.getUsuarios().add(usuario);
			em.getTransaction().begin();
			em.persist(f);
			em.getTransaction().commit();
			return "Inclusao realizada"; 
		} catch(Exception e){
			return e.getMessage();
		}
	} 
}

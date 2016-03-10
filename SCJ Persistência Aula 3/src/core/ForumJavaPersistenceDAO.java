package core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.fiap.Forum;
import br.fiap.Usuario;

public class ForumJavaPersistenceDAO {

	private EntityManager em;

	public ForumJavaPersistenceDAO(EntityManager em) {
		this.em = em;
	}

	public Forum createForum(String assunto, String descricao){
		Forum forum = new Forum();
		forum.setDescricao(descricao);
		forum.setAssunto(assunto);
		em.getTransaction().begin();
		em.persist(forum);
		em.getTransaction().commit();
		return forum;
	}
	public Usuario createUsuario(String nome,String email){
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		return usuario;
	}

	public Forum findForum(int id){
		return em.find(Forum.class, id);
	}
	public Usuario findUsuario(int id){
		return em.find(Usuario.class, id);
	}
	public Forum changeDescricaoForum(int id, String descricao){
		Forum forum = this.findForum(id);
		forum.setDescricao(descricao);
		em.getTransaction().begin();
		em.persist(forum);
		em.getTransaction().commit();
		return forum;
	}

	public void deleteForum(int id){
		Forum forum = this.findForum(id);
		em.remove(forum);
		em.getTransaction().begin();
		em.persist(forum);
		em.getTransaction().commit();
	}
	public Forum addUsuarioToForum(Forum forum,Usuario usuario){
		if (forum.getUsuarios()==null){
			forum.setUsuarios(new ArrayList<Usuario>());
		}
		forum.getUsuarios().add(usuario);
		em.getTransaction().begin();
		em.persist(forum);
		em.getTransaction().commit();
		return forum;
	}
	public List<Usuario> listUsuariosFromForum(int id){
		List<Usuario> usuarios = this.findForum(id).getUsuarios();
		return usuarios;
	}
	public void closeEntityManager() {
		this.em.close();
	}


}
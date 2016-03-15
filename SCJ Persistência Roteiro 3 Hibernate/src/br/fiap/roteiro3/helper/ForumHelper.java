package br.fiap.roteiro3.helper;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.fiap.roteiro3.config.HibernateUtil;
import br.fiap.roteiro3.entity.Forum;
import br.fiap.roteiro3.entity.Usuario;

public class ForumHelper {

	Session session = null;
	Transaction transaction = null;

	public String salvar(Forum forum){ 
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession(); 
			transaction = session.beginTransaction();
			session.save(forum);
			transaction.commit();
			return "Forum salvo"; 
		}catch(Exception e){
			return e.getMessage();
		} 
	}

	public String salvar(Usuario forum){ 
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession(); 
			transaction = session.beginTransaction();
			session.save(forum);
			transaction.commit();
			return "Usuario salvo"; 
		}catch(Exception e){
			return e.getMessage(); 
		}
	}
	public String adicionarUsuario(int idForum, int idUsuario){ 
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession(); 
			transaction = session.beginTransaction();
			Forum f = (Forum) session.load(Forum.class, idForum);
			Usuario u = (Usuario) session.load(Usuario.class, idForum);
			f.getUsuarios().add(u); 
			session.save(f);
			transaction.commit();
			return "Associação realizada";
		} catch(Exception e){ 
			return e.getMessage();
		} 
	}

	public String adicionarUsuario(int idForum, Usuario usuario){ 
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession(); 
			transaction = session.beginTransaction();
			Forum f = (Forum) session.load(Forum.class, idForum);
			usuario.setForum(f);
			f.getUsuarios().add(usuario); 
			session.update(f); 
			transaction.commit();
			return "Inclusao realizada";
		} catch(Exception e){ 
			return e.getMessage();
		} 
	}

	public Set<Usuario> listarUsuarios(int idForum){ 
		Set<Usuario> usuarios = new HashSet<Usuario>(); 
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			Forum f = (Forum)session.load(Forum.class, idForum);
			usuarios = f.getUsuarios();
		} catch (Exception e) {
		}
		return usuarios;
	} 
}



package br.fiap.roteiro3.helper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.fiap.roteiro3.config.HibernateUtil;
import br.fiap.roteiro3.entity.Forum;
import br.fiap.roteiro3.entity.Usuario;

public class ForumHelper {

	Session session = null;
	Transaction transaction = null;

	public void encerrar(){
		session.close();
	}

	private Session getSession() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		return session;
	}
	
	public String salvar(Forum forum){ 
		try{
			session = getSession();
			transaction = session.beginTransaction();
			session.save(forum);
			transaction.commit();
			return "Forum salvo"; 
		}catch(Exception e){
			return e.getMessage();
		} 
	}

	public String salvar(Usuario usuario){ 
		try{
			session = getSession();
			transaction = session.beginTransaction();
			session.save(usuario);
			transaction.commit();
			return "Usuário salvo"; 
		}catch(Exception e){
			return e.getMessage(); 
		}
	}

	public String adicionarUsuario(int idForum, int idUsuario){ 
		try {
			session = getSession();
			transaction = session.beginTransaction();
			Forum f = (Forum) session.load(Forum.class, idForum);
			Usuario u = (Usuario) session.load(Usuario.class, idForum);
			f.getUsuarios().add(u); 
			session.save(f);
			transaction.commit();

			return "Associação realizada";

		} catch(Exception e){ 
			return e.getMessage();
		} 
	}

	public String adicionarUsuario(int idForum, Usuario usuario){ 
		try {
			session = getSession();
			transaction = session.beginTransaction();
			Forum f = (Forum) session.load(Forum.class, idForum);
			usuario.setForum(f);
			f.getUsuarios().add(usuario); 
			session.update(f); 
			transaction.commit();

			return "Inclusão realizada";

		} catch(Exception e){ 
			return e.getMessage();
		} 
	}

	public List<Usuario> listarUsuarios(int idForum){ 
		List<Usuario> usuarios = new ArrayList<Usuario>(); 
		try {
			session = getSession();
			Forum f = (Forum) session.load(Forum.class, idForum);
			usuarios = f.getUsuarios();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	} 

	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuariosHql(){ 
		List<Usuario> usuarios = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			Query<Usuario> query = 
					session.createQuery("from Usuario where nome = :nome and (email is not null and email like :email) ");

			query.setParameter("nome", "paulo");
			query.setParameter("email", "%@%");
			query.setCacheable(true);

			usuarios = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	} 

	@SuppressWarnings("unchecked")
	public List<Object[]> listarUsuariosNative(){ 
		List<Object[]> usuarios = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query<Object[]> queryN = session.createNativeQuery(
					"select * from usuario u where u.nome = :nome and u.email is not null and email like :email")
					.setParameter("nome", "paulo")
					.setParameter("email", "%@%");
					
			usuarios = queryN.list();


		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	} 
}



package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import br.fiap.Pessoa;

public class PessoasHelper {
	Session session = null;

	public PessoasHelper(){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
	public List<Pessoa> getPessoas(){
		List<Pessoa> lista = new ArrayList<Pessoa>();
		try{   
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from Pessoa");
			lista = q.list();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return lista;
	}
	
	public List<Pessoa> getPessoas(String bairro){
		List<Pessoa> lista = new ArrayList<Pessoa>();
		try{   
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from Pessoa where endereco=?")
					.setString(0,bairro);
			lista = q.list();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return lista;
	}
	
	public void removerPessoa(String bairro){
		try{   
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from Pessoa where endereco=?")
					.setString(0,bairro);
			Iterator iterador = q.iterate();
			while (iterador.hasNext()){
				Pessoa pessoa = (Pessoa) iterador.next();
				if (pessoa.getEndereco().equals("Sé")){
					iterador.remove();
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public Pessoa getPessoa(int id){
		Pessoa pessoa = new Pessoa();
		try {
			Transaction tx = session.beginTransaction();
			session.load(pessoa, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pessoa;
		
	}
	public String salvarPessoa(Pessoa p){
		try{  
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
			return "Dados inseridos "+p.getId();
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}
}

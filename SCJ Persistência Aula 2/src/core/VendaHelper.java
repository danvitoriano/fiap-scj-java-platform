package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import br.fiap.Pessoa;
import br.fiap.Venda;

public class VendaHelper {
	Session session = null;

	public VendaHelper(){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
	public List<Pessoa> getVendas(){
		List<Pessoa> lista = new ArrayList<Pessoa>();
		try{   
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from Venda");
			lista = q.list();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return lista;
	}
	
	public List<Pessoa> getVenda(String produto){
		List<Pessoa> lista = new ArrayList<Pessoa>();
		try{   
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from Venda where produto=?")
					.setString(0,produto);
			lista = q.list();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return lista;
	}
	

	
	public Venda getVenda(int id){
		Venda venda = new Venda();
		try {
			Transaction tx = session.beginTransaction();
			session.load(venda, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return venda;
		
	}
	
	public String salvarVenda(Venda v){
		try{  
			Transaction tx = session.beginTransaction();
			session.save(v);
			tx.commit();
			return "Dados inseridos "+v.getId();
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}
}

package br.fiap.roteiro3.helper;

import java.util.List;
import br.fiap.roteiro3.entity.Forum;
import br.fiap.roteiro3.entity.Usuario;

public class TesteForum {

	private static ForumHelper helper = new ForumHelper();


	public static void main(String[] args) {

		incluirUsuarionoForumAlternativo();
		incluirForum();
		incluirUsuarionoForum(); 
		
		listarUsuariosPorForum();
		listarUsuariosPorForum();
		
		listarUsuariosHql();
		listarUsuariosHql();
		
		listarUsuariosNative();
		listarUsuariosNative();
	}

	private static void incluirForum(){
		Forum forum = new Forum();
		forum.setAssunto("Avaliação"); 
		forum.setDescricao("Avaliação da disciplina Persistência");
		System.out.println(helper.salvar(forum));
	}

	private static void incluirUsuarionoForum(){ 
		Usuario u1 = new Usuario();
		u1.setNome("teresa"); 
		u1.setEmail("teresa@mail.com");
		Usuario u2 = new Usuario();
		u2.setNome("jonas"); 
		u2.setEmail("jonas@mail.com"); 
		Usuario u3 = new Usuario(); 
		u3.setNome("abilio");
		u3.setEmail("abilio@mail.com");
		System.out.println(helper.adicionarUsuario(1, u1));
		System.out.println(helper.adicionarUsuario(1, u2));
		System.out.println(helper.adicionarUsuario(1, u3)); 
	}

	private static void incluirUsuarionoForumAlternativo(){ 
		Forum f1 = new Forum();
		f1.setAssunto("Java");
		f1.setDescricao("Grupo de Duvidas do Java");
		System.out.println(helper.salvar(f1));		

		Usuario u1 = new Usuario();
		u1.setNome("paulo"); 
		u1.setEmail("paulo.peter@mail.com");
		u1.setForum(f1);

		System.out.println(helper.salvar(u1));
	}


	private static void listarUsuariosPorForum(){ 

		ForumHelper helper = new ForumHelper(); 
		List<Usuario> usuarios = helper.listarUsuarios(2);
		for(Usuario usuario: usuarios){
			System.out.println("ID Usuario: " + usuario.getId()); System.out.println("Nome Usuario: " + usuario.getNome()); System.out.println("Email Usuario: " + usuario.getEmail()); System.out.println("--------------------------------");
		} 
	}

	private static void listarUsuariosHql(){ 
		ForumHelper helper = new ForumHelper(); 
		List<Usuario> usuarios = helper.listarUsuariosHql();
		System.out.println("Consulta Modo HQL");
		for(Usuario usuario: usuarios){
			System.out.println("ID Usuario: " + usuario.getId()); System.out.println("Nome Usuario: " + usuario.getNome()); System.out.println("Email Usuario: " + usuario.getEmail()); System.out.println("--------------------------------");
		} 
	}

	private static void listarUsuariosNative(){ 
		ForumHelper helper = new ForumHelper(); 
		System.out.println("Consulta Modo Nativo");
		List<Object[]> usuariosObj = helper.listarUsuariosNative();
		for(Object[] obj: usuariosObj) {
			System.out.println("ID Usuario: " + obj[0]); System.out.println("Nome Usuario: " + obj[1]); System.out.println("Email Usuario: " + obj[2]); 
			System.out.println("--------------------------------");
		} 
	}
}
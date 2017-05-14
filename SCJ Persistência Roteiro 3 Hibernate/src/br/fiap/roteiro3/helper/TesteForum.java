package br.fiap.roteiro3.helper;

import java.util.Set;

import br.fiap.roteiro3.entity.Forum;
import br.fiap.roteiro3.entity.Usuario;

public class TesteForum {

	public static void main(String[] args) {
		incluirForum(); 
		incluirUsuarionoForum(); 
		listarUsuariosPorForum();
	}

	private static void incluirForum(){
		Forum forum = new Forum();
		forum.setId(20);
		forum.setAssunto("Avaliação"); 
		forum.setDescricao("Avaliação da disciplina Persistência");
		ForumHelper helper = new ForumHelper(); 
		System.out.println(helper.salvar(forum));
	}

	private static void incluirUsuarionoForum(){ 
		ForumHelper helper = new ForumHelper(); 
		Usuario u1 = new Usuario();
		u1.setNome("teresa"); 
		u1.setEmail("teresa@mail.com");
		u1.setId(10);
		Usuario u2 = new Usuario();
		u2.setNome("jonas"); 
		u2.setEmail("jonas@mail.com"); 
		u2.setId(20);
		Usuario u3 = new Usuario(); 
		u3.setNome("abilio");
		u3.setEmail("abilio@mail.com");
		u3.setId(30);
		System.out.println(helper.adicionarUsuario(20, u1));
		System.out.println(helper.adicionarUsuario(20, u2));
		System.out.println(helper.adicionarUsuario(20, u3)); 
	}

	private static void listarUsuariosPorForum(){ 
		ForumHelper helper = new ForumHelper(); 
		Set<Usuario> usuarios = helper.listarUsuarios(20);
		for(Usuario usuario: usuarios){
			System.out.println("ID Usuario: " + usuario.getId()); System.out.println("Nome Usuario: " + usuario.getNome()); System.out.println("Email Usuario: " + usuario.getEmail()); System.out.println("--------------------------------");
		} 
	}
}
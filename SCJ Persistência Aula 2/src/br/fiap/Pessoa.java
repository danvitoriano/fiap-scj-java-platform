package br.fiap;
public class Pessoa  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String apelido;
	private String endereco;
	
	public Pessoa() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	//getters e setters
	
	
	
	
}

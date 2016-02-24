package br.fiap;
public class Cliente  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6846730435507404589L;
	private int id;
	private String nome;
	private String endereco;
	
	//Setters & Getters
	
	public Cliente(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}

	public Cliente() {
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
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	//getters e setters
	
	
	
	
}

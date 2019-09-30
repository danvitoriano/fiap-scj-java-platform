package ex1;

public class Cliente {
	
	private String nome;
	private String numeroRg;
	private String numeroCpf;
	private String endereco;
	
	public static void main(String[] args) {
		new Cliente("123");
	}
	
	public Cliente(){
		
	}
	
	public Cliente(String numeroRg){
		this();
		this.numeroRg=numeroRg;
		System.out.println(this.numeroRg);
	}
	
	public Cliente(String numeroRg, String numeroCpf, String endereco, String nome){
		this(numeroRg);
		this.numeroCpf=numeroCpf;
		this.endereco=endereco;
		this.nome=nome;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumeroRg() {
		return numeroRg;
	}
	public void setNumeroRg(String numeroRg) {
		this.numeroRg = numeroRg;
	}
	public String getNumeroCpf() {
		return numeroCpf;
	}
	public void setNumeroCpf(String numeroCpf) {
		this.numeroCpf = numeroCpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

}

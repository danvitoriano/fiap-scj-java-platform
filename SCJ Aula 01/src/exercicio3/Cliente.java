package exercicio3;
import java.math.BigDecimal;

public class Cliente {
	
	private String nome;
	private BigDecimal numeroRg;
	private BigDecimal numeroCpf;
	private String endereco;
	
	public Cliente(){
		
	}
	
	public Cliente(BigDecimal numeroRg){
		this();
		this.numeroRg=numeroRg;
	}
	
	public Cliente(BigDecimal numeroRg, BigDecimal numeroCpf, String endereco, String nome){
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
	public BigDecimal getNumeroRg() {
		return numeroRg;
	}
	public void setNumeroRg(BigDecimal numeroCpf) {
		this.numeroRg = numeroRg;
	}
	public BigDecimal getNumeroCPF() {
		return numeroCpf;
	}
	public void setNumeroCPF(BigDecimal numeroCpf) {
		this.numeroCpf = numeroCpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	

}

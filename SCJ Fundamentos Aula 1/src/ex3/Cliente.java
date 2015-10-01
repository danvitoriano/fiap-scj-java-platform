package ex3;

import java.math.BigDecimal;

public class Cliente {
	
	private String nome;
	private BigDecimal numeroRg;
	private BigDecimal numeroCpf;
	
	public Cliente(){
		
	}
	
	public Cliente(BigDecimal numeroRg){
		this();
		this.numeroRg=numeroRg;
	}
	
	public Cliente(BigDecimal numeroRg, BigDecimal numeroCpf, String nome, String endereco){
		this(numeroRg);
		this.numeroCpf=numeroCpf;
		this.nome=nome;
		this.endereco=endereco;
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
	public void setNumeroRg(BigDecimal numeroRg) {
		this.numeroRg = numeroRg;
	}
	public BigDecimal getNumeroCpf() {
		return numeroCpf;
	}
	public void setNumeroCpf(BigDecimal numeroCpf) {
		this.numeroCpf = numeroCpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	private String endereco;
	
	

}

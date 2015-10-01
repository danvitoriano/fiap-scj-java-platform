package ex1;

import java.math.BigDecimal;

public class Cliente {
	
	private String nome;
	private BigDecimal numeroRg;
	private BigDecimal numeroCpf;
	
	
	
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

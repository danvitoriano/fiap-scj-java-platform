public class Pessoa
{
	private String nome;

	
	boolean ativo=true;
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ativo: "+ativo+" Nome:"+nome;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setInativo() {
		this.ativo = false;
	}

	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}


	public void setNome( String nome )
	{
		// this.nome -> atributo da classe
		// nome -> variável local ao método 
		this.nome = nome;
	}


	/**		
	 * @return String - Nome do usuário
	 */
	public String getNome() {
		return this.nome;
	}


}

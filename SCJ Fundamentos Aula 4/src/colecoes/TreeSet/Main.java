package colecoes.TreeSet;

import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SortedSet<String> nomes = new TreeSet<String>();
		
		nomes.add("Maria");
		nomes.add("Jos�");
		nomes.add("Henrique");
		nomes.add("Matias");
		nomes.add("Nascimento");
		nomes.add("Maria");
		
		System.out.println(nomes);
		System.out.println(nomes.contains("Jos�"));
		
		
		
	}

}

package colecoes.IdentityHashMap;

import java.util.IdentityHashMap;
import java.util.Map;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String> nomes = new IdentityHashMap<Integer, String>();
		
		nomes.put(1,"Valor 1");
		nomes.put(1,"Valor 2");
		nomes.put(3,"Valor 3");
		nomes.put(4,"Valor 3");
		
		System.out.println(nomes);
		System.out.println(nomes.size());
		System.out.println(nomes.get(1));
		
	}

}

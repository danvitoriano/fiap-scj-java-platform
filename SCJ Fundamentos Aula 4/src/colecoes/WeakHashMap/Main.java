package colecoes.WeakHashMap;

import java.util.Map;
import java.util.WeakHashMap;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String> nomes = new WeakHashMap<String, String>();
		
		String chave = new String("6");
		nomes.put("4","Matias");
		nomes.put("5","Nascimento");
		nomes.put(chave,"Maria");
		
		System.out.println(nomes);
		chave=null;
		System.gc();
		System.out.println(nomes);
		
	}

}

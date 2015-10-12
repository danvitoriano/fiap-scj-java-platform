package ex1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Integer> lista1 = new ArrayList<>();
		LinkedList<Integer> lista2 = new LinkedList<>();
		
		LocalDateTime inicio = LocalDateTime.now();

		for (int i=1;i<=1000000;i++){
			lista1.add(i);
		}
		
		LocalDateTime fim = LocalDateTime.now();
		
		long tempoInsercao = ChronoUnit.MILLIS.between(inicio, fim);
		System.out.println("Tempo de Inserção [ArrayList]: "+tempoInsercao);
		
		inicio = LocalDateTime.now();	
		for (int i=1;i<=1000000;i++){
			lista2.add(i);
		}
		fim = LocalDateTime.now();
		tempoInsercao = ChronoUnit.MILLIS.between(inicio, fim);
		System.out.println("Tempo de Inserção [LinkedList]: "+tempoInsercao);
		
		inicio = LocalDateTime.now();	
		lista1.get(500000);
		fim = LocalDateTime.now();
		tempoInsercao = ChronoUnit.MILLIS.between(inicio, fim);
		System.out.println("Tempo de Consulta [ArrayList]: "+tempoInsercao);
		
		inicio = LocalDateTime.now();	
		lista2.get(500000);
		fim = LocalDateTime.now();
		tempoInsercao = ChronoUnit.MILLIS.between(inicio, fim);
		System.out.println("Tempo de Consulta [LinkedList]: "+tempoInsercao);

	}

}

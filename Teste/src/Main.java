import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import pessoal.meuPacote.Cliente;

public class Main {

	// ao invés de 
	public static final int ESTACAO_INVERNO = 0;
	public static final int ESTACAO_PRIMAVERA = 1;
	public static final int ESTACAO_VERAO = 2;
	public static final int ESTACAO_OUTONO = 3;
	

	// utilize
	enum Estacao { INVERNO, PRIMAVERA, VERAO, OUTONO };

	public static void main(String[] args) {


		try {
			
			
			Thread t = new Thread();
			int prioridade = t.getPriority();
			
			
			//Thread.sleep(3000);
			
			t.interrupt();


		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void copiarArquivos(Path origem, Path destino) throws IOException {
		// se é um diretório, tentamos criar. se já existir, não tem problema.
		if(Files.isDirectory(origem)){
			Files.createDirectories(destino);

			// listamos todas as entradas do diretório
			DirectoryStream<Path> entradas = Files.newDirectoryStream(origem);

			for (Path entrada : entradas) {
				// para cada entrada, achamos o arquivo equivalente dentro de cada arvore
				Path novaOrigem = origem.resolve(entrada.getFileName());
				Path novoDestino = destino.resolve(entrada.getFileName());

				// invoca o metodo de maneira recursiva
				copiarArquivos(novaOrigem, novoDestino);
			}
		} else {
			// copiamos o arquivo
			Files.copy(origem, destino);
		}
	}

	public static void apagarArquivos(Path origem) throws IOException {
		// se é um diretório, tentamos criar. se já existir, não tem problema.
		if(Files.isDirectory(origem)){


			// listamos todas as entradas do diretório
			DirectoryStream<Path> entradas = Files.newDirectoryStream(origem);

			for (Path entrada : entradas) {
				// para cada entrada, achamos o arquivo equivalente dentro de cada arvore
				Path novaOrigem = origem.resolve(entrada.getFileName());

				// invoca o metodo de maneira recursiva
				apagarArquivos(novaOrigem);
			}
		} else {
			// copiamos o arquivo
			Files.delete(origem);
		}
	}

	public static void alterarNome(Cliente cliente){
		cliente.setNome("José");
	}

	public static void incrementar(int a){
		a++;
	}


	public static void teste() throws Exception{


		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("entrada.txt");
			out = new FileOutputStream("saida.txt");
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}

		throw new IOException("Arquivo não encontrado");


	}

	public static void teste2() {
		int a=10/0;
	}
}

package out30;

import java.util.HashSet;
import java.util.Iterator;

public class TestaHashSet {
	public static void main(String[] args) {
		String nomesLidos[] = lerNomes();
		
		HashSet nomes = new HashSet();
		for (int i = 0; i < nomesLidos.length; i++) {
			nomes.add(nomesLidos[i]);
		}
		
		Iterator iterator = nomes.iterator();
		int iCont = 1;
		String nome;
		while (iterator.hasNext()){
		   nome = (String) iterator.next();
		   System.out.println("nome[" + iCont++ + "] = " + nome);
		}	}

	public static String[] lerNomes() {
		String nomes[] = {"Carlos", "Josias","Marcos",  "Armando"};
		return nomes;
	}	} 

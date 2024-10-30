package out30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class CadastraFuncionario {
	public static void main(String[] args) {
		String nomes[] = { "Carlos" ,  "Josias" ,  "Carlos" , "Marcos",  "Armando",  "Armando"};

		HashSet<Funcionario> funcionarios = new HashSet<Funcionario>();
		int codigo=1;
		for (int i = 0; i < nomes.length; i++) {
			Funcionario novo = new Funcionario(codigo++, nomes[i]);
			funcionarios.add(novo);
		}
		System.out.println("Antes da ordenação");
		imprimirFuncionarios(funcionarios);		
		
		ArrayList<Funcionario> funcionariosOrdenados = gerarListaFuncionarios(funcionarios);
		Collections.sort(funcionariosOrdenados);
		
		System.out.println("\nApós a ordenação");
		System.out.format("%-8S %-20S" , "Código", "Nome" );
		System.out.println();
		for (int i = 0; i < funcionariosOrdenados.size(); i++) {
			System.out.println(funcionariosOrdenados.get(i));
		}
	}
	private static ArrayList<Funcionario> gerarListaFuncionarios(HashSet funcionarios) {
		ArrayList<Funcionario> funcArray = new ArrayList<Funcionario>();
		Iterator iTer = funcionarios.iterator();			
		Funcionario f;			

		while (iTer.hasNext()){
			f = (Funcionario) iTer.next();
			funcArray.add(f);
		}
		return funcArray;
	}
	private static void imprimirFuncionarios(HashSet funcionarios) {
		Iterator iterator = funcionarios.iterator();
		int iCont = 1;
		String nome;		
		while (iterator.hasNext()){
			Funcionario novoCast = (Funcionario) iterator.next();
			System.out.println(novoCast);
		}	
	}	
} 





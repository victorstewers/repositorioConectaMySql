package out30;

import java.util.*; 
public class TesteAluno {
	public static void main (String[] args) {
		Aluno3 aluno1 = new Aluno3("Orlando", 123);
		Aluno3 aluno2 = new Aluno3("Rafael", 258);
		Aluno3 aluno3 = new Aluno3("Amanda", 642);
		Aluno3 aluno4 = new Aluno3("Bruna", 634);
		Aluno3 aluno5 = new Aluno3("Orlando", 345);
		Aluno3 aluno6 = new Aluno3("Rafaela", 942);
		Aluno3 aluno7 = new Aluno3("Amanda", 650);		
		ArrayList alunos = new ArrayList();
		alunos.add(aluno1);	alunos.add(aluno2);		alunos.add(aluno3);
		alunos.add(aluno4);	alunos.add(aluno5);		alunos.add(aluno6);
		alunos.add(aluno7);
		System.out.println("Imprimindo alunos antes da ordenação");
		Iterator iTer1 = alunos.iterator();
		while (iTer1.hasNext()){
			System.out.println(iTer1.next());
		}

		Collections.sort(alunos);

		System.out.println("\nImprimindo alunos depois da ordenação");
		Iterator iTer2 = alunos.iterator();
		while (iTer2.hasNext()){
			System.out.println(iTer2.next());
		}			
	}	
}
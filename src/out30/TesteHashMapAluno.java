package out30;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TesteHashMapAluno {
	/*
	 public Aluno(int id, String nome, String telefone, double nota) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.nota = nota;
	}
	 */
	public static void main(String args[]) {
		int id1 = 1;
		Aluno aluno1 = new Aluno(id1, "Victor","968531010",7.0);
		
		int id2 = 2;
		Aluno aluno2 = new Aluno(id2, "Pedro","922531010",6.0);
		
		int id3 = 3;
		Aluno aluno3 = new Aluno(id3, "Felipe","93331010",10.0);
		

		HashMap alunos = new HashMap();
		alunos.put(id1, aluno1);
		alunos.put(id2, aluno2);
		alunos.put(id3, aluno3);
		imprimirMapAlunos(alunos);
		int chave = 3;
		removerElemento(alunos, chave);
		imprimirMapAlunos(alunos);
	}

	public static void imprimirMapAlunos(HashMap alunos) {
		Set chaves = alunos.keySet();
		Iterator iTer = chaves.iterator();

		int chave;
		Aluno a;

		System.out.println("\n --- HashMap de Alunos ---");

		while (iTer.hasNext()) {
			chave = (int)iTer.next();
			a = (Aluno) alunos.get(chave);
			System.out.println("Chave: " + chave);
			System.out.println(a + "\n");
		}
	}

	public static void removerElemento(HashMap map, int chave) {
		Aluno alunoRemovido = null;

		if (map.containsKey(chave)) {
			System.out.println("\n --- Aluno removida ---");
			alunoRemovido = (Aluno) map.remove(chave);
			System.out.println(alunoRemovido);
		} else {
			System.out.println("ID (chave) não encontrada no 					hashMap");
		}
	}
}



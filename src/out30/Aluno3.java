package out30;

public class Aluno3 implements Comparable{
	private String nome;
	private long RA;

	public Aluno3(String nome, long RA){
		this.nome = nome;
		this.RA = RA;
	}
	public String getNome() {		return nome;	}
	public void setNome(String nome) {
		this.nome = nome;		}
	public long getRA() {
		return RA;		}
	public void setRA(long ra) {
		RA = ra;
	}
	public boolean equals(Object obj){
		if (obj instanceof Aluno3){
			Aluno3 aluno = (Aluno3) obj;			
			if(this.getNome().equalsIgnoreCase(aluno.getNome())
					&& this.getRA() == aluno.getRA()){
				return true;
			}
			else{
				return false;
			}
		}
		else
			return false;
	}
	public int compareTo(Object obj){
		Aluno3 aluno = (Aluno3) obj;
		int resp = this.getNome().compareTo(aluno.getNome());
		if (resp != 0){	return resp;	}
		else{
			if (this.getRA() < aluno.getRA()){
				return -1;		}
			else if (this.getRA() > aluno.getRA()){
				return 1;			}
			else{
				return 0;	}		}	}
	public int hashCode(){
		return (int)this.RA + this.getNome().hashCode();
	}
	public String toString(){
		String aluno = "nome: " + this.getNome() + "\n" + "RA: " + 		this.getRA();
		return aluno;	}	}
package out30;

import java.util.Objects;

public class Funcionario implements Comparable<Funcionario>{
	private int codigo;
	private String nome;
	private String cidade;
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return codigo == other.codigo && Objects.equals(nome, other.nome);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public Funcionario(int codigo, String nome, String cidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
	}
	public Funcionario(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int compareTo(Funcionario o) {
		int resp = this.getNome().compareTo(o.getNome());
		if (resp != 0){	
			return resp;	
		}
		else{
			if (this.getCodigo() < o.getCodigo()){	
				return -1;	
			}
			else if (this.getCodigo() > o.getCodigo()){	
				return 1;	
			}
			else
				return 0;
		}	
	}
	@Override
	public String toString() {
		return String.format("%-8d", codigo) + String.format(" %-20S", nome) ;
	}	
}

package out23Funcionario;

import java.util.Objects;

import out16.ConectaMySQL;

public class Funcionario {
	private int idFuncionario;
	private String funcionarioNome;
	private int funcionarioIdade;
	private String funcionarioSetor;
	private String funcionarioFone;

	/**
	 * 
	 */
	public Funcionario() {

	}
	

	/**
	 * @param idFuncionario
	 * @param funcionarioNome
	 * @param funcionarioIdade
	 * @param funcionarioSetor
	 */
	public Funcionario(int idFuncionario, String funcionarioNome, int funcionarioIdade, String funcionarioSetor) {
		this.idFuncionario = idFuncionario;
		this.funcionarioNome = funcionarioNome;
		this.funcionarioIdade = funcionarioIdade;
		this.funcionarioSetor = funcionarioSetor;
	}
	

	/**
	 * @param funcionarioNome
	 * @param funcionarioIdade
	 */
	public Funcionario(String funcionarioNome, int funcionarioIdade) {
		super();
		this.funcionarioNome = funcionarioNome;
		this.funcionarioIdade = funcionarioIdade;
	}


	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getFuncionarioNome() {
		return funcionarioNome;
	}

	public void setFuncionarioNome(String funcionarioNome) {
		this.funcionarioNome = funcionarioNome;
	}

	public int getFuncionarioIdade() {
		return funcionarioIdade;
	}

	public void setFuncionarioIdade(int funcionarioIdade) {
		this.funcionarioIdade = funcionarioIdade;
	}

	public String getFuncionarioSetor() {
		return funcionarioSetor;
	}

	public void setFuncionarioSetor(String funcionarioSetor) {
		this.funcionarioSetor = funcionarioSetor;
	}

	public String getFuncionarioFone() {
		return funcionarioFone;
	}

	public void setFuncionarioFone(String fone) {
		this.funcionarioFone = fone;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", funcionarioNome=" + funcionarioNome
				+ ", funcionarioIdade=" + funcionarioIdade + ", funcionarioSetor=" + funcionarioSetor + "]";
	}

	public void imprimirFuncionario() {
		System.out.format("\n%d %s %d %s", getIdFuncionario(), getFuncionarioNome(), getFuncionarioIdade(),
				getFuncionarioSetor());
	}

	@Override
	public int hashCode() {
		return Objects.hash(funcionarioFone, funcionarioNome);
	}

	// Sobrescrita do método equals da classe Object
	public boolean equals(Object o) {
		// Devemos verificar se o objeto "o" eh uma instancia da classe Pessoa
		if (o instanceof Funcionario) {
			// Devemos fazer o cast de Object para Pessoa
			Funcionario p = (Funcionario) o;
			if (this.getFuncionarioNome().equals(p.getFuncionarioNome())
					&& this.getFuncionarioFone().equals(p.getFuncionarioFone())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}

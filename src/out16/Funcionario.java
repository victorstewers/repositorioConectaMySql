package out16;

public class Funcionario {
	private int idFuncionario;
	private String funcionarioNome;
	private int funcionarioIdade;
	private String funcionarioSetor;
	
	
	/**
	 * 
	 */
	public Funcionario() {
		
	}
	
	
	public Funcionario(int idFuncionario, String funcionarioNome, int funcionarioIdade, String funcionarioSetor) {
		
		this.idFuncionario = idFuncionario;
		this.funcionarioNome = funcionarioNome;
		this.funcionarioIdade = funcionarioIdade;
		this.funcionarioSetor = funcionarioSetor;
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


	@Override
	public String toString() {
		return "ID = " + this.idFuncionario + ", Nome = " + this.funcionarioNome + ", "
				+ "Setor = " + this.funcionarioSetor + ", Idade = " + this.funcionarioIdade;
	}
	public void imprimirFuncionario() {
		System.out.format("\n%-4d %-45s %-4d %-50s",
				getIdFuncionario(),getFuncionarioNome(),getFuncionarioIdade(),getFuncionarioSetor());
	}
	
	
}

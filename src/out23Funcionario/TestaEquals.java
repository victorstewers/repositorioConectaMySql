package out23Funcionario;

public class TestaEquals {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario();
		Funcionario f2 = new Funcionario();
		f1.setFuncionarioFone("1010");
		f2.setFuncionarioFone("1010");
		f1.setFuncionarioNome("Victor");
		f2.setFuncionarioNome("Victor");
		
		System.out.println(f1.equals(f2));

		
	}
	Funcionario f1 = new Funcionario();
	Funcionario f2 = new Funcionario();
    
}

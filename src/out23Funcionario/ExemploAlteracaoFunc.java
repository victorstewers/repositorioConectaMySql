package out23Funcionario;
import out16.ConectaMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import out16.Aluno;
import out16.ConectaMySQL;
import out16.ExConsultaNomeCompleto;

public class ExemploAlteracaoFunc { 
	public static void main(String[] args) { 
		try {realizaOperacao();
		} 
		catch (Exception e) {e.printStackTrace();
		} 
	}
	private static void realizaOperacao() throws Exception {
		ConectaMySQL cm = new ConectaMySQL();
		Connection cn = cm.openDB();
		Statement st = null; try {
			st = cn.createStatement();
			String nome = JOptionPane.showInputDialog(
					"Digite o nome do funcionario a ser alterado");
			ExConsultaNomeCompletoFunc consulta = new ExConsultaNomeCompletoFunc();
			Funcionario alterado = consulta.consultarNomeCompleto(nome);
			if(consulta!=null) {
				int resp = JOptionPane.showConfirmDialog(null, 
						"Confirma a alteração do funcionario: \n" + alterado);
				if (resp==0) {
					alterarFuncionario(alterado);
				} 
				else {
					JOptionPane.showMessageDialog(null, "O aluno: " 
							+ alterado.getFuncionarioNome() + " NÃO foi alterado"); 
				} } 
			else {
				JOptionPane.showMessageDialog(null, "O aluno: " 
						+ alterado.getFuncionarioNome() + " NÃO foi encontrado"); }}
		catch (SQLException e) {
			throw new Exception("Falha ao acessar base de dados.\n" 
					+ e.getMessage());
		} finally {
			st.close();
			cn.close();
		}
	}

	public static Funcionario alterarFuncionario(Funcionario alterado) throws SQLException {
		ConectaMySQL cm = new ConectaMySQL();
		Connection con = cm.openDB();
		PreparedStatement pstm = con.prepareStatement("UPDATE senac.funcionarios SET "
				+ " funcionarioNome=?, funcionarioIdade=?, funcionarioSetor=? WHERE idFuncionario=?");
		String nome = JOptionPane.showInputDialog("Digite o novo Nome: ", alterado.getFuncionarioNome());
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite o telefone: ", alterado.getFuncionarioIdade()));
	    String setor = JOptionPane.showInputDialog("Digite o setor : ", alterado.getFuncionarioSetor());
		pstm.setString(1, nome);pstm.setInt(2, idade);
		pstm.setString(3, setor);pstm.setInt(4, (int)alterado.getIdFuncionario());
		Funcionario aposAlteracao = new Funcionario((int)alterado.getIdFuncionario(), nome, idade, setor);
		pstm.execute();
		JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso!!!");
		return aposAlteracao;
	}
}
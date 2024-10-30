package out23Funcionario;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


import out16.ConectaMySQL;


public class ExemploExclusaoFuncionario {
	public static void main(String[] args) {
		try {
			realizaOperacao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void realizaOperacao() throws Exception {
		ConectaMySQL cm = new ConectaMySQL();
		Connection cn = cm.openDB();
		Statement st = null;
		String queryCmd = "select * from senac.funcionarios where " + "funcionarioNome like ? ";
		st = cn.prepareStatement(queryCmd);
		try {
			String nome = JOptionPane.showInputDialog("Digite o nome do funcionario a ser excluído: ", "Priscila Presley");
			ExConsultaNomeCompletoFunc consulta = new ExConsultaNomeCompletoFunc();
			Funcionario excluido = consulta.consultarNomeCompleto(nome);
			if (excluido == null) {
				JOptionPane.showMessageDialog(null, nome + " não encontrado");
				return;
			}
			int resp = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do funcionario: \n" + excluido);
			if (resp == 0) {
				st.executeUpdate("DELETE FROM senac.funcionarios WHERE idFuncionario='" + excluido.getIdFuncionario() + "'");
				JOptionPane.showMessageDialog(null,
						"O aluno: " + excluido.getFuncionarioNome() + " Foi excluído com sucesso!!!");
			} else
				JOptionPane.showMessageDialog(null, "O aluno: " + excluido.getFuncionarioNome() + " NÃO foi excluído");
		} catch (SQLException e) {
			throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
		} finally {
			if (st != null)
				st.close();
			if (cn != null)
				cn.close();
		}
	}
}


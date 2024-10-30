package out16;

import java.sql.*;
import javax.swing.JOptionPane;

public class ExemploExclusao {
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
		String queryCmd = "select * from senac.alunos where " + "alunoNome like ? ";
		st = cn.prepareStatement(queryCmd);
		try {
			String nome = JOptionPane.showInputDialog("Digite o nome do aluno a ser excluído: ", "Priscila Presley");
			ExConsultaNomeCompleto consulta = new ExConsultaNomeCompleto();
			Aluno excluido = consulta.consultarNomeCompleto(nome);
			if (excluido == null) {
				JOptionPane.showMessageDialog(null, nome + " não encontrado");
				return;
			}
			int resp = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do aluno: \n" + excluido);
			if (resp == 0) {
				st.executeUpdate("DELETE FROM Alunos WHERE idAluno='" + excluido.getIdAluno() + "'");
				JOptionPane.showMessageDialog(null,
						"O aluno: " + excluido.getAlunoNome() + " Foi excluído com sucesso!!!");
			} else
				JOptionPane.showMessageDialog(null, "O aluno: " + excluido.getAlunoNome() + " NÃO foi excluído");
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
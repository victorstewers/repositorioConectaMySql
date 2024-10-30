package out16;
import java.sql.*;

import javax.swing.*;
public class ExemploPreparedStatementFuncionario {
	public static void main(String[] args) {        
		try {
			ConectaMySQL conexao = new ConectaMySQL();
			Connection cn = conexao.openDB();
			PreparedStatement ps = cn.prepareStatement("INSERT INTO senac.funcionarios " +
					"(funcionarioNome, funcionarioIdade, funcionarioSetor)" + "VALUES (?, ?, ?)"); 
			ps.setString(1, JOptionPane.showInputDialog("Nome:", "Nome Sobrenome"));//nome
			ps.setInt(2, Integer.parseInt(JOptionPane.showInputDialog("Funcionario Idade:",30)));//idade
			ps.setString(3,JOptionPane.showInputDialog(
					"Funcionari Setor:", "Setor"));//setor
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
			conexao.closeDB(cn, ps, null);
//			System.out.println("ConexÃ£o encerrada.");            
		} catch (SQLException e) {
			System.out.println("Falha ao realizar a operaÃ§Ã£o.");
			e.printStackTrace();
		}    
	}		
}


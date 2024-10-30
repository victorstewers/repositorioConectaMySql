package out16;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ExemploResultSetFuncionario {
	public static void main(String[] args) {        
		try {
			ConectaMySQL conexao = new ConectaMySQL();
			Connection cn = conexao.openDB();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM senac.funcionarios");
			System.out.format("%-4S %-30S %-25S %-4S" , 
					"id", "Nome completo", "Idade", "Setor" ); 
			System.out.print("\n-----------------------------"
					+ "--------------------------------------\n");
			while (rs.next()) {
				int id = rs.getInt("idFuncionario");
				String nome = rs.getString("funcionarioNome");
				int idade = rs.getInt("funcionarioIdade");
				String nota = rs.getString("funcionarioSetor");
				Funcionario novo = new Funcionario(id, nome, idade, nota);
								
				//System.out.println(novo);
				novo.imprimirFuncionario();
			} 
			conexao.closeDB(cn, st, rs);
		} catch (SQLException e) {
			System.out.println("Falha ao realizar a operaÃ§Ã£o.");
			e.printStackTrace();        
		}    
	}
	
}
package out16;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ExemploResultSetAluno {
	public static void main(String[] args) {        
		try {
			ConectaMySQL conexao = new ConectaMySQL();
			Connection cn = conexao.openDB();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Alunos");
			System.out.format("%-4S %-30S %-25S %-4S" , 
					"id", "Nome completo", "Telefone", "Nota" ); 
			System.out.print("\n-----------------------------"
					+ "--------------------------------------\n");
			while (rs.next()) {
				int id = rs.getInt("idAluno");
				String nome = rs.getString("alunoNome");
				String telefone = rs.getString("alunoTelefone");
				double nota = rs.getDouble("alunoNota");
				Aluno novo = new Aluno(id, nome, telefone, nota);
								
				//System.out.println(novo);
				novo.imprimirAluno();
			} 
			conexao.closeDB(cn, st, rs);
		} catch (SQLException e) {
			System.out.println("Falha ao realizar a operaÃ§Ã£o.");
			e.printStackTrace();        
		}    
	}
	
}
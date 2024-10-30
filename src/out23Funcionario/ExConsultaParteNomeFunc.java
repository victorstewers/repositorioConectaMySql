package out23Funcionario;
import out16.ConectaMySQL;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import out16.MetodosComuns;
public class ExConsultaParteNomeFunc{ 
	ConectaMySQL cm = new ConectaMySQL();
	public static void main(String[] args) throws Exception{
		MetodosComuns mc = new MetodosComuns();
		List<Funcionario> funcionarios = new ExConsultaParteNomeFunc()
				.consultar(JOptionPane.showInputDialog(
						"Digite o nome do funcionario a ser consultado:"));
		System.out.println("Data: " + mc.lerData() + " Hora: " + mc.lerHora());
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario); }}
	public List<Funcionario> consultar(String nome) throws Exception {
		String queryCmd = "select * from senac.funcionarios where "
				+ "funcionarioNome like ? ";
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Connection con = null;
		try { 
			con = cm.openDB();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ps1.setString(1, (nome != null ? '%'+nome.trim()+'%' : ""));
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("idFuncionario");
				String funcNome = rs.getString("funcionarioNome");
				int funcIdade = rs.getInt("funcionarioIdade");
				String funcSetor = rs.getString("funcionarioSetor");
				Funcionario novo = new Funcionario(id, funcNome, funcIdade, funcSetor);
				funcionarios.add(novo); }
		} catch (SQLException e) {
			throw new Exception(e); // encapsula excecao original
		} finally {
			cm.closeDB(); }
		return funcionarios; 
	} 
}

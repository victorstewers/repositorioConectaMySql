package out23Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


import out16.ConectaMySQL;


public class ExConsultaNomeCompletoFunc {
	public static void main(String[] args) throws Exception {
		Funcionario funcionario = new ExConsultaNomeCompletoFunc().consultarNomeCompleto(JOptionPane.showInputDialog("Digite o nome a ser consultado", "Marcela Maria"));
		System.out.println("Data e Hora da consulta: " + lerHora());
		if (funcionario != null) {
			
		
			System.out.println(funcionario);
			funcionario.imprimirFuncionario();
		}
		else {
			System.out.println("Aluno não encontrado");
		}
	}

	public static String lerHora() {
		DateFormat dia = new SimpleDateFormat("dd/MM/YYYY");
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return dia.format(date) + " - " + dateFormat.format(date);
	}

	Funcionario consultarNomeCompleto(String nome) throws Exception {
		Funcionario novo = null;
		String queryCmd = "select * from senac.funcionarios where funcionarioNome like ?";
		Connection con = null;
		ConectaMySQL conexao = null;
		try {
			conexao = new ConectaMySQL();// VER
			con = conexao.openDB();
			PreparedStatement ps1 = con.prepareStatement(queryCmd);
			ps1.setString(1, (nome != null ? nome.trim() : ""));
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("idFuncionario");
				String nom = rs.getString("funcionarioNome");
				int idad = rs.getInt("funcionarioIdade");
				String setor = rs.getString("funcionarioSetor");
				novo = new Funcionario(id, nom, idad, setor);
			}
		} catch (SQLException e) {
			throw new Exception(e);
		} finally {
			conexao.closeDB();
		}
		return novo;
	}
}

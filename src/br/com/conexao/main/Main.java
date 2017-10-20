package br.com.conexao.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Conex�o com o banco
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria", "root", "root");
		// Utiliza��o da conex�o
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");
		while (rs.next()) {
			int nCliente = rs.getInt("nCliente");
			String nome = rs.getString("nome");
			String data = rs.getString("data_nasc");
			System.out.println("Id:" + nCliente + " Nome:" + nome + " DATA:" + data);
		}
		rs.close();
		con.close(); // Fechamento da conex�o

	}
}

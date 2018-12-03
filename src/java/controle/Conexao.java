package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static String url = "jdbc:postgresql://localhost/bd_jdbc01";
	public static String user = "jcx1";
	public static String pass = "jcx1";
	
	private static Connection conexao;
	
	public static Connection getConnection() throws SQLException {
		if (conexao == null){
			conexao = fazerConexao();
		}
		return conexao;
	}

	private static Connection fazerConexao() throws SQLException {
		try {
			conexao = DriverManager.getConnection(url, user, pass);
			System.out.println("Banco conectado!!!!");
		} catch (SQLException e) {
			System.out.println("Erro de conexão!!!!");
		}
		return conexao;
	}			
}
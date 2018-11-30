package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Conta;

public class ContaDAO {
	
private Connection conn;
	
	public ContaDAO() throws SQLException{
		conn = Conexao.getConnection();
		conn.setAutoCommit(false);
	}
	
	public void inserirConta(Conta conta) throws SQLException {
		String sql = "Insert into conta values(default, ?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, conta.getNumeroConta());
		pst.setDouble(2, conta.getSaldo());
		pst.setInt(3, conta.getIdCliente());
		pst.execute();
		conn.commit();
		pst.close();
		System.out.println("Conta cadastrada.");
	}

}

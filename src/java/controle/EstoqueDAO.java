package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Estoque;

public class EstoqueDAO {

	private Connection conn;
	
	public EstoqueDAO() throws SQLException{
		conn = Conexao.getConnection();
		conn.setAutoCommit(false);
	}
	
	public void inserirEstoque(Estoque estoque) throws SQLException {
		String sql = "Insert into estoque values(default, ?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, estoque.getQuantidade() );
		pst.setInt(2, estoque.getIdProduto() );
		
		pst.execute();
		conn.commit();
		pst.close();
		System.out.println("Estoque " + estoque.getQuantidade() + " cadastrado(a).");
	}
		
}

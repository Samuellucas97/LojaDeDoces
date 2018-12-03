package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import modelo.Produto;

public class ProdutoDAO {
	
	private Connection conn;
	
	public ProdutoDAO() throws SQLException{
		conn = Conexao.getConnection();
		conn.setAutoCommit(false);
	}
	
	public void inserirProduto(Produto produto) throws SQLException {
		String sql = "Insert into produto values(default, ?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, produto.getNomeProduto());
		pst.setString(2, produto.getDataDeValidade());
		pst.setFloat(3, produto.getPreco());
		pst.setInt(4, produto.getIdFabricante());
		pst.setInt(5, produto.getIdProduto());
		
		pst.execute();
		conn.commit();
		pst.close();
		System.out.println("Produto " + produto.getNomeProduto()+ "" +
				produto.getDataDeValidade() + " " + produto.getPreco() + " " +
				produto.getIdFabricante() + " " + produto.getIdProduto() + " " + " cadastrado(a).");
	}
	
	public void alterarProduto(Produto produto) throws SQLException{
		String sql = "update Produto set nome = ? where cpf = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, produto.getNomeProduto());
		pstmt.setString(2, produto.getDataDeValidade());
		pstmt.setFloat(3, produto.getPreco());
		pstmt.setInt(4, produto.getIdFabricante());
		pstmt.setInt(5, produto.getIdProduto());
		
		pstmt.execute();
		conn.commit();
		pstmt.close();
		System.out.println("Produto " + produto.getNomeProduto()+ "" +
				produto.getDataDeValidade() + " " + produto.getPreco() + " " +
				produto.getIdFabricante() + " " + produto.getIdProduto() + " " + " alterado(a).");
	}
	
	public void deletarProduto(Produto produto) throws SQLException{
		String sql = "delete from produto where cpf = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.execute();
		conn.commit();
		pstmt.close();
		System.out.println("Produto " + produto.getNomeProduto()+ "" +
				produto.getDataDeValidade() + " " + produto.getPreco() + " " +
				produto.getIdFabricante() + " " + produto.getIdProduto() + " " + " deletado(a).");
	}
	
	public List<Produto> listar() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null; 
		pst = conn.prepareStatement("Select * from produto");
		List<Produto> produtos = new ArrayList<Produto>();
		rs = pst.executeQuery(); 
		
		while(rs.next()){ 
			Produto c = new Produto();
			c.setIdProduto(rs.getInt("idProduto"));
			c.setNomeProduto(rs.getString("nomeProduto"));
			produtos.add(c);
		}
		return produtos;
	}

	public int buscarProduto(JTextField tproduto) throws SQLException {
		int id=0;
		String nomeProduto = tproduto.getText();
		PreparedStatement pst = null; 
		ResultSet rs = null;
		String sql = "Select idCliente From Cliente Where nome like '%" + nomeProduto + "%'";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()){
			id = rs.getInt("idProduto");
		}
		return id;
	}

}

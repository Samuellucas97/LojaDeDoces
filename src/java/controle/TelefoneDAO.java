package controle;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import modelo.Telefone;

public class TelefoneDAO {


	private Connection conn;
	
	public TelefoneDAO() throws SQLException{
		conn = Conexao.getConnection();
		conn.setAutoCommit(false);
	}
	
	public void inserirTelefone(Telefone telefone) throws SQLException {
		String sql = "Insert into telefone values(default, ?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, telefone.getNumero() );
		pst.setInt(2, telefone.getIdCliente() );
		
		pst.execute();
		conn.commit();
		pst.close();
		System.out.println("Telefone " + telefone.getNumero() + " " +  
				telefone.getIdCliente() + " cadastrado(a).");
	}
	
	public void alterarTelefone(Telefone telefone) throws SQLException{
		String sql = "update telefone set nome = ? where cpf = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, telefone.getNumero() );
		pstmt.setInt(2, telefone.getIdCliente() );
		
		pstmt.execute();
		conn.commit();
		pstmt.close();
		System.out.println("Telefone " + telefone.getNumero() + " " +  
				telefone.getIdCliente() + " alterado(a).");
	}
	
	public void deletarTelefone(Telefone telefone) throws SQLException{
		String sql = "delete from telefone where numero = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.execute();
		conn.commit();
		pstmt.close();
		
		System.out.println("Telefone " + telefone.getNumero() + " " +  
				telefone.getIdCliente() +  " deletado(a).");
	}
	
	public List<Telefone> listar() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null; 
		pst = conn.prepareStatement("Select * from Telefone");
		List<Telefone> funcionarios = new ArrayList<Telefone>();
		rs = pst.executeQuery(); 
		
		while(rs.next()){ 
			Telefone c = new Telefone();
			c.setIdTelefone(rs.getInt("idTelefone"));
			c.setNumero(rs.getString("numero"));
			c.setIdCliente(rs.getInt("idCliente"));
			
			funcionarios.add(c);
		}
		return funcionarios;
	}

	public int buscarTelefone(JTextField ttelefone) throws SQLException {
		int id=0;
		String numero = ttelefone.getText();
		PreparedStatement pst = null; 
		ResultSet rs = null;
		String sql = "Select idTelefone From Telefone Where nome like '%" + numero + "%'";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()){
			id = rs.getInt("idTelefone");
		}
		return id;
	}
	
}

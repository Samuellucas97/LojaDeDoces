package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import modelo.Fabricante;

public class FabricanteDAO {
	
	private Connection conn;
	
	public FabricanteDAO() throws SQLException{
		conn = Conexao.getConnection();
		conn.setAutoCommit(false);
	}
	
	public void inserirFabricante(Fabricante fabricante) throws SQLException {
		String sql = "Insert into cargo values(default, ?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, fabricante.getNomeFabricante() );
		
		pst.execute();
		conn.commit();
		pst.close();
		System.out.println("Fabricante " + fabricante.getNomeFabricante() + " cadastrado(a).");
	}
	
	public void alterarFabricante(Fabricante fabricante) throws SQLException{
		String sql = "update fabricante set nome = ? where cpf = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, fabricante.getNomeFabricante() );
		pstmt.execute();
		conn.commit();
		pstmt.close();
		System.out.println("Fabricante " + fabricante.getNomeFabricante() + " alterado(a).");
	}
	
	public void deletarFabricante(Fabricante fabricante) throws SQLException{
		String sql = "delete from fabricante where cpf = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.execute();
		conn.commit();
		pstmt.close();
		System.out.println("Fabricante " + fabricante.getNomeFabricante() + " deletado(a).");
	}
	
	public List<Fabricante> listar() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null; 
		pst = conn.prepareStatement("Select * from fabricante");
		List<Fabricante> fabricantes = new ArrayList<Fabricante>();
		rs = pst.executeQuery(); 
		
		while(rs.next()){ 
			Fabricante c = new Fabricante();
			c.setIdFabricante(rs.getInt("idFabricante"));
			c.setNomeFabricante(rs.getString("nomeFabricante"));
			fabricantes.add(c);
		}
		return fabricantes;
	}

	public int buscarFabricante(JTextField tcargo) throws SQLException {
		int id=0;
		String nomeFabricante = tcargo.getText();
		PreparedStatement pst = null; 
		ResultSet rs = null;
		String sql = "Select idFabricante From Fabricante Where nome like '%" + nomeFabricante + "%'";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()){
			id = rs.getInt("idFabricante");
		}
		return id;
	}
	
}

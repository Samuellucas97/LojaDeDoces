package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import modelo.Cargo;

public class CargoDAO {
	
	private Connection conn;
	
	public CargoDAO() throws SQLException{
		conn = Conexao.getConnection();
		conn.setAutoCommit(false);
	}
	
	public void inserirCargo(Cargo cargo) throws SQLException {
		String sql = "Insert into cargo values(default, ?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, cargo.getNomeCargo() );
		
		pst.execute();
		conn.commit();
		pst.close();
		System.out.println("Cargo " + cargo.getNomeCargo() + " cadastrado(a).");
	}
	
	public void alterarCargo(Cargo cargo) throws SQLException{
		String sql = "update cliente set nome = ? where cpf = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cargo.getNomeCargo() );
		pstmt.execute();
		conn.commit();
		pstmt.close();
		System.out.println("Cargo " + cargo.getNomeCargo() + " alterado(a).");
	}
	
	public void deletarCargo(Cargo cargo) throws SQLException{
		String sql = "delete from cliente where cpf = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.execute();
		conn.commit();
		pstmt.close();
		System.out.println("Cargo " + cargo.getNomeCargo() + " deletado(a).");
	}
	
	public List<Cargo> listar() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null; 
		pst = conn.prepareStatement("Select * from cargo");
		List<Cargo> cargos = new ArrayList<Cargo>();
		rs = pst.executeQuery(); 
		
		while(rs.next()){ 
			Cargo c = new Cargo();
			c.setIdCargo(rs.getInt("idCargo"));
			c.setNomeCargo(rs.getString("nomeCargo"));
			cargos.add(c);
		}
		return cargos;
	}

	public int buscarCargo(JTextField tcargo) throws SQLException {
		int id=0;
		String nomeCargo = tcargo.getText();
		PreparedStatement pst = null; 
		ResultSet rs = null;
		String sql = "Select idCargo From Cargo Where nome like '%" + nomeCargo + "%'";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()){
			id = rs.getInt("idCargo");
		}
		return id;
	}
}

package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import modelo.Cliente;

public class ClienteDAO {
	
	private Connection conn;
	
	public ClienteDAO() throws SQLException{
		conn = Conexao.getConnection();
		conn.setAutoCommit(false);
	}
	
	public void inserirCliente(Cliente cliente) throws SQLException {
		String sql = "Insert into cliente values(default, ?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, cliente.getNome());
		pst.setString(2, cliente.getCpf());
		pst.execute();
		conn.commit();
		pst.close();
		System.out.println("Cliente " + cliente.getNome()+ " cadastrado(a).");
	}
	
	public void alterarCliente(Cliente cliente) throws SQLException{
		String sql = "update cliente set nome = ? where cpf = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cliente.getNome());
		pstmt.setString(2, cliente.getCpf());
		pstmt.execute();
		conn.commit();
		pstmt.close();
		System.out.println("Cliente " + cliente.getNome()+ " alterado(a).");
	}
	
	public void deletarCliente(Cliente cliente) throws SQLException{
		String sql = "delete from cliente where cpf = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql); 
		pstmt.setString(1, cliente.getCpf());
		pstmt.execute();
		conn.commit();
		pstmt.close();
		System.out.println("Cliente " + cliente.getCpf()+ " deletado(a).");
	}
	
	public List<Cliente> listar() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null; 
		pst = conn.prepareStatement("Select * from cliente");
		List<Cliente> clientes = new ArrayList<Cliente>();
		rs = pst.executeQuery(); 
		
		while(rs.next()){ 
			Cliente c = new Cliente();
			c.setIdcliente(rs.getInt("idcliente"));
			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			clientes.add(c);
		}
		return clientes;
	}

	public int buscarCliente(JTextField tcliente) throws SQLException {
		int id=0;
		String nome = tcliente.getText();
		PreparedStatement pst = null; 
		ResultSet rs = null;
		String sql = "Select idCliente From Cliente Where nome like '%" + nome + "%'";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()){
			id = rs.getInt("idCliente");
		}
		return id;
	}
}

package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import modelo.Funcionario;

public class FuncionarioDAO {

	private Connection conn;
	
	public FuncionarioDAO() throws SQLException{
		conn = Conexao.getConnection();
		conn.setAutoCommit(false);
	}
	
	public void inserirFuncionario(Funcionario funcionario) throws SQLException {
		String sql = "Insert into funcionario values(default, ?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, funcionario.getNomeFuncionario() );
		pst.setString(2, funcionario.getCpf() );
		pst.setString(3, funcionario.getDataDeNascimento() );
		pst.setInt(4, funcionario.getIdCargo() );
		
		
		pst.execute();
		conn.commit();
		pst.close();
		System.out.println("Funcionario " + funcionario.getNomeFuncionario() + " " + 
				funcionario.getCpf() + " " + funcionario.getDataDeNascimento() + " " +  
				funcionario.getIdCargo() + " cadastrado(a).");
	}
	
	public void alterarFuncionario(Funcionario funcionario) throws SQLException{
		String sql = "update cliente set nome = ? where cpf = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, funcionario.getNomeFuncionario() );
		pstmt.setString(2, funcionario.getCpf() );
		pstmt.setString(3, funcionario.getDataDeNascimento() );
		pstmt.setInt(4, funcionario.getIdCargo() );
		
		pstmt.execute();
		conn.commit();
		pstmt.close();
		System.out.println("Funcionario " + funcionario.getNomeFuncionario() + " " + 
							funcionario.getCpf() + " " + 
							funcionario.getDataDeNascimento() + " " + 
							funcionario.getIdCargo() + " alterado(a).");
	}
	
	public void deletarFuncionario(Funcionario funcionario) throws SQLException{
		String sql = "delete from funcionario where cpf = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.execute();
		conn.commit();
		pstmt.close();
		
		System.out.println("Funcionario " + funcionario.getNomeFuncionario() + " " + 
				funcionario.getCpf() + " " + 
				funcionario.getDataDeNascimento() + " " + 
				funcionario.getIdCargo() +  " deletado(a).");
	}
	
	public List<Funcionario> listar() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null; 
		pst = conn.prepareStatement("Select * from Funcionario");
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		rs = pst.executeQuery(); 
		
		while(rs.next()){ 
			Funcionario c = new Funcionario();
			c.setIdFuncionario(rs.getInt("idFuncionario"));
			c.setCpf(rs.getString("nomeCargo"));
			funcionarios.add(c);
		}
		return funcionarios;
	}

	public int buscarFuncionario(JTextField tfuncionario) throws SQLException {
		int id=0;
		String nomeFuncionario = tfuncionario.getText();
		PreparedStatement pst = null; 
		ResultSet rs = null;
		String sql = "Select idFuncionario From Funcionario Where nome like '%" + nomeFuncionario + "%'";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()){
			id = rs.getInt("idFuncionario");
		}
		return id;
	}
}

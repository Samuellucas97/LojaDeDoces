package modelo;

/**
 * Representa um funcionário
 * @author samuellucas97
 *
 */
public class Funcionario {
	
	/// ATRIBUTOS
	
	private int idFuncionario;
	private String nomeFuncionario;
	private String cpf;
	private String dataDeNascimento;
	private int idCargo;
	
	/// GETTERS E SETTERS
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public int getIdCargo() {
		return idCargo;
	}
	
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
}

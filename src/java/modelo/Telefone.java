package modelo;

/**
 * Representa um telefone
 * @author samuellucas97
 *
 */
public class Telefone {
	
	/// ATRIBUTOS
	
	private int idTelefone;
	private String numero;
	private int idCliente;
	
	/// GETTERS E SETTERS 
	
	public int getIdTelefone(){
		return idTelefone;
	}
	
	public void setIdTelefone(int idTelefone){
		this.idTelefone = idTelefone;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
}

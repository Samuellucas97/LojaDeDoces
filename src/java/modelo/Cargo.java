package modelo;

/**
 * Representa um cargo
 * @author samuellucas97
 *
 */
public class Cargo {
	
	/// ATRIBUTOS
	
	private int idCargo;
	private String nomeCargo;
	
	/// GETTERS E SETTERS
	
	public int getIdCargo() {
		return idCargo;
	}
	
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	
	public String getNomeCargo() {
		return nomeCargo;
	}
	
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	
}

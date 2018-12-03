package modelo;

/**
 * Representa um estoque
 * @author samuellucas97
 *
 */
public class Estoque {

	/// ATRIBUTOS 
	
	private int idEstoque;
	private int quantidade;
	private int idProduto;
	
	/// GETTERS E SETTERS
	
	public int getIdEstoque() {
		return idEstoque;
	}
	
	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
}

package modelo;

/**
 * Representa um produto
 * @author samuellucas97
 *
 */
public class Produto {

	/// ATRIBUTOS 
	
	private int idProduto;
	private String nomeProduto;
	private float preco;
	private String dataDeValidade;
	private int idFabricante;
	
	/// GETTERS E SETTERS
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public String getDataDeValidade() {
		return dataDeValidade;
	}
	
	public void setDataDeValidade(String dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}
	
	public int getIdFabricante() {
		return idFabricante;
	}
	
	public void setIdFabricante(int idFabricante) {
		this.idFabricante = idFabricante;
	}
		
}

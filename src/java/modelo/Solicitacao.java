package modelo;

/**
 * Representa um solicitação de um cliente
 * @author samuellucas97
 *
 */
public class Solicitacao {

	/// ATRIBUTOS
	
	private int idSolicitacao;
	private String descricao;
	private int quantidade;
	private int idFuncionario;
	private int idCliente;
	private int idProduto;
	
	/// GETTERS E SETTERS 
	
	public int getIdSolicitacao() {
		return idSolicitacao;
	}
	
	public void setIdSolicitacao(int idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

}

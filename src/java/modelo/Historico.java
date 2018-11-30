package modelo;

import java.util.Date;

public class Historico {
	
	private int idHistorico;
	private int tipoOperacao;
	private double valor;
	private Date dataOperacao;
	private Conta conta;
	
	public int getIdHistorico() {
		return idHistorico;
	}
	
	public void setIdHistorico(int idHistorico) {
		this.idHistorico = idHistorico;
	}
	
	public int getTipoOperacao() {
		return tipoOperacao;
	}
	
	public void setTipoOperacao(int tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Date getDataOperacao() {
		return dataOperacao;
	}
	
	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}

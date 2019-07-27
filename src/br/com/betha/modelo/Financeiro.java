package br.com.betha.modelo;

/**
 * @author Jorge Motta
 * Projeto AlfaSJ
 * 06/01/18
 * 
 */
public class Financeiro {
	
	private	int		associado_id;
	private	String	id_banco;
	private	String	banco;
	private	String	agencia;
	private	String	conta;
	private	String	tipoConta;
	private	String	pisPasep;
	private	String	senhaFin;
	
	private	java.util.Date	Data;

	public int getAssociado_id() {
		return associado_id;
	}

	public void setAssociado_id(int associado_id) {
		this.associado_id = associado_id;
	}
	
	public String getId_banco() {
		return id_banco;
	}

	public void setId_banco(String id_banco) {
		this.id_banco = id_banco;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getPisPasep() {
		return pisPasep;
	}

	public void setPisPasep(String pisPasep) {
		this.pisPasep = pisPasep;
	}

	public String getSenhaFin() {
		return senhaFin;
	}

	public void setSenhaFin(String senhaFin) {
		this.senhaFin = senhaFin;
	}

	public java.util.Date getData() {
		return Data;
	}

	public void setData(java.util.Date data) {
		Data = data;
	}
	
}

package br.com.betha.modelo;

/**
 * @author Jorge Motta
 * 23/07/19
 */
public class OrdemServico {
	
	private	int		os_id;
	private	int		os_user;
	private	String	os_status;
	private	int		os_id_cli;
	private	String	os_dt_emissao;
	private	String	os_dt_fechamento;
	private	String	os_tp_equip;
	private	String	os_marca_equip;
	private	String	os_problema;
	private	String	os_exec;
	
	public int getOs_id() {
		return os_id;
	}
	public void setOs_id(int os_id) {
		this.os_id = os_id;
	}
	public int getOs_user() {
		return os_user;
	}
	public void setOs_user(int os_user) {
		this.os_user = os_user;
	}
	public String getOs_status() {
		return os_status;
	}
	public void setOs_status(String os_status) {
		this.os_status = os_status;
	}
	public int getOs_id_cli() {
		return os_id_cli;
	}
	public void setOs_id_cli(int os_id_cli) {
		this.os_id_cli = os_id_cli;
	}
	public String getOs_dt_emissao() {
		return os_dt_emissao;
	}
	public void setOs_dt_emissao(String os_dt_emissao) {
		this.os_dt_emissao = os_dt_emissao;
	}
	public String getOs_dt_fechamento() {
		return os_dt_fechamento;
	}
	public void setOs_dt_fechamento(String os_dt_fechamento) {
		this.os_dt_fechamento = os_dt_fechamento;
	}
	public String getOs_tp_equip() {
		return os_tp_equip;
	}
	public void setOs_tp_equip(String os_tp_equip) {
		this.os_tp_equip = os_tp_equip;
	}
	public String getOs_marca_equip() {
		return os_marca_equip;
	}
	public void setOs_marca_equip(String os_marca_equip) {
		this.os_marca_equip = os_marca_equip;
	}
	public String getOs_problema() {
		return os_problema;
	}
	public void setOs_problema(String os_problema) {
		this.os_problema = os_problema;
	}
	public String getOs_exec() {
		return os_exec;
	}
	public void setOs_exec(String os_exec) {
		this.os_exec = os_exec;
	}
	

}
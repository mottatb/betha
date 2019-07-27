package br.com.betha.modelo;

/**
 * @author Jorge Motta
 * 11/07/19
 * 
 */
public class User {
	
	private	int		us_id;
	private	String	us_nome;
	private	String	us_login;
	private	String	us_password;
	private	String	us_cargo;
	private	int		us_level;
	
	public int getUs_id() {
		return us_id;
	}
	public void setUs_id(int us_id) {
		this.us_id = us_id;
	}
	public String getUs_nome() {
		return us_nome;
	}
	public void setUs_nome(String us_nome) {
		this.us_nome = us_nome;
	}
	public String getUs_login() {
		return us_login;
	}
	public void setUs_login(String us_login) {
		this.us_login = us_login;
	}
	public String getUs_password() {
		return us_password;
	}
	public void setUs_password(String us_password) {
		this.us_password = us_password;
	}
	public String getUs_cargo() {
		return us_cargo;
	}
	public void setUs_cargo(String us_cargo) {
		this.us_cargo = us_cargo;
	}
	public int getUs_level() {
		return us_level;
	}
	public void setUs_level(int us_level) {
		this.us_level = us_level;
	}
	
}

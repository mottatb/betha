/**
 * Classe Bean responsavel pelos campos da tabela page (Links)
 */
package br.com.betha.modelo;

/**
 * @author Jorge Motta
 * Projeto AlfaSJ
 * 05/12/18
 * 
 */
public class Page {
	
	private	int		page_id;
	private	String	page_title;
	private	String	page_content;
	private	int		page_area;
	private	String	page_url;
	private	int		page_show;
	
	
	public int getPage_id() {
		return page_id;
	}
	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}
	public String getPage_title() {
		return page_title;
	}
	public void setPage_title(String page_title) {
		this.page_title = page_title;
	}
	public String getPage_content() {
		return page_content;
	}
	public void setPage_content(String page_content) {
		this.page_content = page_content;
	}
	public int getPage_area() {
		return page_area;
	}
	public void setPage_area(int page_area) {
		this.page_area = page_area;
	}
	public String getPage_url() {
		return page_url;
	}
	public void setPage_url(String page_url) {
		this.page_url = page_url;
	}
	public int getPage_show() {
		return page_show;
	}
	public void setPage_show(int page_show) {
		this.page_show = page_show;
	}
	
}

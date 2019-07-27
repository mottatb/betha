/**
 * 
 */
package br.com.betha.modelo;

/**
 * @author Jorge Motta
 * Projeto AlfaSJ
 * 07/12/18
 * 
 */
public class ItemPedido {
	
	private int lista_id;
	private int lista_item;
	private String lista_item_ref;
	private double lista_preco;
	private String lista_title;
	private int lista_pedido;
	private int lista_qtde;
	private int sub_categoria;
	private String lista_foto;
	private String lista_atributos;
	private String lista_atributo_ped;
	
	public int getLista_id() {
		return lista_id;
	}
	public void setLista_id(int lista_id) {
		this.lista_id = lista_id;
	}
	public int getLista_item() {
		return lista_item;
	}
	public void setLista_item(int lista_item) {
		this.lista_item = lista_item;
	}
	public String getLista_item_ref() {
		return lista_item_ref;
	}
	public void setLista_item_ref(String lista_item_ref) {
		this.lista_item_ref = lista_item_ref;
	}
	public double getLista_preco() {
		return lista_preco;
	}
	public void setLista_preco(double d) {
		this.lista_preco = d;
	}
	public String getLista_title() {
		return lista_title;
	}
	public void setLista_title(String lista_title) {
		this.lista_title = lista_title;
	}
	public int getLista_pedido() {
		return lista_pedido;
	}
	public void setLista_pedido(int lista_pedido) {
		this.lista_pedido = lista_pedido;
	}
	public int getLista_qtde() {
		return lista_qtde;
	}
	public void setLista_qtde(int lista_qtde) {
		this.lista_qtde = lista_qtde;
	}
	public int getSub_categoria() {
		return sub_categoria;
	}
	public void setSub_categoria(int sub_categoria) {
		this.sub_categoria = sub_categoria;
	}
	public String getLista_foto() {
		return lista_foto;
	}
	public void setLista_foto(String lista_foto) {
		this.lista_foto = lista_foto;
	}
	public String getLista_atributos() {
		return lista_atributos;
	}
	public void setLista_atributos(String lista_atributos) {
		this.lista_atributos = lista_atributos;
	}
	public String getLista_atributo_ped() {
		return lista_atributo_ped;
	}
	public void setLista_atributo_ped(String lista_atributo_ped) {
		this.lista_atributo_ped = lista_atributo_ped;
	}

}

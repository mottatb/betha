package br.com.betha.dao;

/**
 * @author Jorge Motta
 * 23/07/19
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.com.betha.modelo.Cliente;
import br.com.betha.util.ConnectionFactory;


public class ClienteDao {
	
	static Logger log = Logger.getLogger(ClienteDao.class.getName());
	
	private Connection connection;
	
	public ClienteDao() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ClienteDao(HttpServletRequest request, HttpServletResponse response) {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Cliente getCliente(Cliente cli) {
		
		PreparedStatement stmt = null;
		try {
			
			String sql = "select * from cliente "
							+ " where cliente_id = '" + cli.getCliente_id()+ "'";
			
			this.connection = ConnectionFactory.getConnection();
			stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				
				cli.setCliente_nome(rs.getString("cliente_nome"));
				cli.setCliente_sobrenome(rs.getString("cliente_sobrenome"));
				cli.setCliente_doc(rs.getString("cliente_doc"));
				cli.setCliente_email(rs.getString("cliente_email"));
				cli.setCliente_telefone(rs.getString("cliente_telefone"));
//				cli.setCliente_celular(rs.getString("cliente_celular"));
				cli.setCliente_datacad(rs.getString("cliente_datacad"));
				
			}
			
			return cli;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
	
}

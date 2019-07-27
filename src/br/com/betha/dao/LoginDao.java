package br.com.betha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.com.betha.modelo.User;
import br.com.betha.util.ConnectionFactory;


public class LoginDao {
	
	static Logger log = Logger.getLogger(LoginDao.class.getName());
	
	private Connection connection;
	
	public LoginDao() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public LoginDao(HttpServletRequest request, HttpServletResponse response) {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User getAssociado(User user) throws SQLException {
		
		PreparedStatement stmt = null;
		try {
			
			this.connection = ConnectionFactory.getConnection();
			
			stmt = this.connection.prepareStatement
					("SELECT * FROM `user`"
							+ " WHERE us_login = '" + user.getUs_login() + "'"
							+ " and us_password = '" + user.getUs_password() + "'"
							+ " LIMIT 1");
			
			//implementar segurança caso hajam 2 usuarios com mesmo nome e senha
			//perguntar o codigo do usuario para confirmar cadastro
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				//popula o objeto associado
				user.setUs_id(rs.getInt("us_id"));
				user.setUs_nome(rs.getString("us_nome"));
				user.setUs_cargo(rs.getString("us_cargo"));
			}

			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}

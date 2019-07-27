package br.com.betha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.com.betha.modelo.User;
import br.com.betha.util.ConnectionFactory;

public class UserDao {

	static Logger log = Logger.getLogger(UserDao.class.getName());

	private Connection connection;

	public UserDao() {}

	public UserDao(HttpServletRequest request, HttpServletResponse response) { }

	public User getUser(User user) throws SQLException {

		PreparedStatement stmt = null;
		try {

			this.connection = ConnectionFactory.getConnection();

			String sql = "SELECT * FROM `user`"
						+ " WHERE us_login = '" + user.getUs_login() + "'";

			stmt = this.connection.prepareStatement
					(sql);

			log.debug(sql);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				log.info("dados do user "+rs.getString("us_nome"));
				
				user.setUs_id(Integer.parseInt(rs.getString("us_id")));
				user.setUs_nome(rs.getString("us_nome"));
				user.setUs_cargo(rs.getString("us_cargo"));
				user.setUs_login(rs.getString("us_login"));
				user.setUs_password(rs.getString("us_password"));
				user.setUs_level(Integer.parseInt(rs.getString("us_level")));
				
				return user;
			} else {
				user.setUs_id(0);
			}

			rs.close();
			stmt.close();

			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<User> getlstUser () {
		
		PreparedStatement stmt = null;
		try {
			
			ArrayList<User> lstUser = new ArrayList<User>();
			
			//busca a lista de bancos ativos
			String sql = "select * from user "; 
			
			log.debug(sql);
			
			this.connection = ConnectionFactory.getConnection();
			stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				User user = new User();
				
				user.setUs_id(rs.getInt("us_id"));
				user.setUs_nome(rs.getString("us_nome"));
				user.setUs_login(rs.getString("us_login"));
				
				lstUser.add(user);
			}
			
			return lstUser;
					
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}

	public ArrayList<String> getDashDados (User user) {
		
		ArrayList<String> listaDash = new ArrayList<String>();
		
		PreparedStatement stmt = null;
		try {
			
			String sql = "select count(*) from ordem_servico ";
			
			log.debug(sql);
			
			this.connection = ConnectionFactory.getConnection();
			stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				listaDash.add(rs.getString(1));
			}
			
			/////////////////////////
			
			sql = " select count(*) from ordem_servico where os_user = '"+ user.getUs_id() +"'";
			
			log.debug(sql);
			
			this.connection = ConnectionFactory.getConnection();
			stmt = this.connection.prepareStatement(sql);
			
			rs = stmt.executeQuery();

			if(rs.next()) {
				listaDash.add(rs.getString(1));
			}
			
			return listaDash;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

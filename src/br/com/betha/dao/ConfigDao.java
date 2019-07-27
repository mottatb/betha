package br.com.betha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.com.betha.util.ConnectionFactory;

public class ConfigDao {

	static Logger log = Logger.getLogger(ConfigDao.class.getName());

	private Connection connection;

	public ConfigDao() {
		
	}

	public ConfigDao(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	public int buscaRegimeTribConfig() {
		
		PreparedStatement stmt = null;
		try {
			String sql = "select config_regimeTrib from config";
			
			this.connection = ConnectionFactory.getConnection();
			stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				return rs.getInt("config_regimeTrib");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0; 
	}


}

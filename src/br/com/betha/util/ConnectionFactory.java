package br.com.betha.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * @author Jorge Motta <br>
 * 16/02/17 <br>
 * Cria a conexao usada no sistema.<br>
 */

/*
 * vim /etc/my.cnf
 */

public class ConnectionFactory {
	
	static Logger log = Logger.getLogger(ConnectionFactory.class.getName());
	
	private static Connection connection = null;
    
	private static String server = "localhost";
	private static String user = "root";
	private static String pass = "base";
	
    private static String base = "betha_sistemas";
    
    private static String url = "jdbc:mysql://" + server + "/" + base + "?useSSL=false";
    
    public static Connection getConnection() {
    	
            try {
            	Class.forName("com.mysql.jdbc.Driver");
            	
            	if (connection == null) {
            		
            		DriverManager.setLoginTimeout(0);
            		connection = DriverManager.getConnection(url, user, pass);
            		
            		System.out.println("Conexao era null e foi criada com Sucesso: " + connection.isValid(0) + " " + url);
            		log.debug("Conexao era null e foi criada com Sucesso: " + connection.isValid(0) + " " + url);

            	}
            	
            	if (connection.isClosed()) {
            		
            		DriverManager.setLoginTimeout(0);
            		connection = DriverManager.getConnection(url, user, pass);
            		
            		System.out.println("Conexao estava fechada e foi criada com Sucesso: " + connection.isValid(0) + " " + url);
            		log.debug("Conexao estava fechada e foi criada com Sucesso: " + connection.isValid(0) + " " + url);
            		
            	}
            	
            	return connection;
            } catch (SQLException ex) {
            	System.out.println("SQLException - Houve um erro ao conectar com o Banco de Dados.\n" + ex);
            	log.debug("SQLException - Houve um erro ao conectar com o Banco de Dados.\n" + ex);
            } catch (ClassNotFoundException e) {
            	System.out.println("ClassNotFoundException");
            	log.debug("ClassNotFoundException");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Exception - Ocorreu um erro inesperado." + e);
				log.debug("Exception - Ocorreu um erro inesperado." + e);
				e.printStackTrace();
			}
        
        return connection;
    }
    
}

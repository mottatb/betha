package br.com.betha.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import br.com.betha.util.ConnectionFactoryMongoDB;

/**
 * @author Jorge Motta <br>
 * Projeto Tuter <br>
 * 16/02/17 <br>
 * Cria a conexao usada no sistema.<br>
 */

/*
 * vim /etc/my.cnf
 */

public class ConnectionFactoryMongoDB {
	
	static Logger log = Logger.getLogger(ConnectionFactoryMongoDB.class.getName());
	
	private static Connection connection = null;
    
	private static String server = "174.142.130.85";
	private static String pass = "NMGJPM[[n36[a";
	
    private static String base = "alfasjco_banco";
//    private static String base = "alfasjco_teste";
    
    private static String user = "alfasjco_admin";

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
    
    /**
     * 
     * @param PagSeguro true
     * @return Conexao
     */
    public static Connection getConnection(boolean PagSeguro) {
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		String user = "alfasjco_pg";
    		String pass = "5?uR6ot,xL1$";

    		
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
    
//    public static boolean isDbConnected() {
//    	
//        boolean isConnected = false;
//        
//        try {
//            final PreparedStatement statement = (PreparedStatement) connection.prepareStatement("SELECT 1");
//            isConnected = true;
//        } catch (SQLException | NullPointerException e) {
//            // handle SQL error here!
//        }
//        return isConnected;
//    }
    
    /*
    public static void setLocal(boolean local){
    	
    	if (local){
    		server = "localhost";
    		base = "tuter";
    	    user = "tuter";
    	    pass = "baseTuter2";
    	}
    	
    }
    */
}

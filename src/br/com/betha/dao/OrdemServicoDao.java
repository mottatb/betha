package br.com.betha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import br.com.betha.modelo.OrdemServico;
import br.com.betha.modelo.User;
import br.com.betha.util.ConnectionFactory;

public class OrdemServicoDao {

	static Logger log = Logger.getLogger(OrdemServicoDao.class.getName());

	private Connection connection;

	public OrdemServicoDao() {	}

	public OrdemServicoDao(HttpServletRequest request, HttpServletResponse response) {	}

	/**
	 * @param os
	 * @return boolean - adiciona associado na tabela temp e retorna true
	 * @throws SQLException
	 */
	public char adicionaCadastro(OrdemServico os) throws SQLException {
		
		PreparedStatement stmt = null;
		try {

			String Data_atual = "";

			Calendar cal = new GregorianCalendar();
			int hora = cal.get(Calendar.HOUR);
			int min = cal.get(Calendar.MINUTE);
			int seg = cal.get(Calendar.SECOND);
			int dia = cal.get(Calendar.DAY_OF_MONTH);
			int mes = cal.get(Calendar.MONTH);
			int ano = cal.get(Calendar.YEAR);

			Data_atual = ""+ano+"-"+(mes+1)+"-"+dia+" "+hora+":"+min+":"+seg;
			String sql = "";
			
			connection = br.com.betha.util.ConnectionFactory.getConnection();
			
			sql = "insert into ordem_servico"
						+ " (os_user, os_status, os_id_cli, os_dt_emissao, os_tp_equip, os_marca_equip, os_problema, os_exec)"
						+ " values (?,?,?,?,?,?,?,?)";
			
			stmt = connection.prepareStatement(sql);

//			log.debug(AssociadoDao.class.getName()+" - " + associado.getNome());
			
			stmt.setInt(1, os.getOs_user());
			stmt.setString(2, os.getOs_status());
			stmt.setInt(3, os.getOs_id_cli());
			stmt.setString(4, Data_atual);
			stmt.setString(5, os.getOs_tp_equip());
			stmt.setString(6, os.getOs_marca_equip());
			stmt.setString(7, os.getOs_problema());
			stmt.setString(8, os.getOs_exec());

			stmt.execute();
			stmt.close();
			
			return 'C'; //Cadastrado com Sucessso
		} catch (MySQLIntegrityConstraintViolationException e) {
			log.error(e.getMessage());
			return 'D'; //Login Duplicado
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public char atualizaCadastro(OrdemServico os) throws SQLException {
		
		PreparedStatement stmt = null;
		try {

			connection = br.com.betha.util.ConnectionFactory.getConnection();
			
			String dtFechamento = os.getOs_dt_fechamento()!=null?" os_dt_fechamento = '" + os.getOs_dt_fechamento() + "', ":"  ";
			
			String sql = "update ordem_servico set "
							+ " os_user = '" + os.getOs_user() + "',"
							+ dtFechamento
							+ " os_tp_equip = '" + os.getOs_tp_equip() + "',"
							+ " os_marca_equip = '" + os.getOs_marca_equip() + "',"
							+ " os_problema = '" + os.getOs_problema() + "',"
							+ " os_exec= '" + os.getOs_exec() + "',"
							+ " os_status = '" + os.getOs_status() + "'"
							+ " where os_id = '" + os.getOs_id() + "'";
			
			//log.debug(sql);
			
			stmt = connection.prepareStatement(sql);

			stmt.execute();
			stmt.close();
			
			return 'C'; //Cadastrado com Sucessso
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<OrdemServico> getlstOS (User user) {
		
		ArrayList<OrdemServico> listaOS = new ArrayList<OrdemServico>();
		
		PreparedStatement stmt = null;
		try {
			
			//busca todas as Ordens de Serviço do Usuario em questao
			String sql = " select * from ordem_servico where os_user = '" + user.getUs_id() + "'";
			
			log.debug(sql);
			
			this.connection = ConnectionFactory.getConnection();
			stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				OrdemServico os = new OrdemServico();
				
				os.setOs_id(rs.getInt("os_id"));
				os.setOs_dt_emissao(rs.getString("os_dt_emissao"));
				os.setOs_tp_equip(rs.getString("os_tp_equip"));
				os.setOs_marca_equip(rs.getString("os_marca_equip"));
				os.setOs_problema(rs.getString("os_problema"));
				os.setOs_status(rs.getString("os_status"));
				
				listaOS.add(os);
			}
			
			return listaOS;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public OrdemServico getOS (int id_os) {
		
		PreparedStatement stmt = null;
		try {
			
			//busca todas as Ordens de Serviço do Usuario em questao
			String sql = " select * from ordem_servico where os_id = '" + id_os + "'";
			
			log.debug(sql);
			
			this.connection = ConnectionFactory.getConnection();
			stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();

			OrdemServico os = new OrdemServico();
			
			if(rs.next()) {
				
				os.setOs_id_cli(rs.getInt("os_id_cli"));
				os.setOs_id(rs.getInt("os_id"));
				os.setOs_user(rs.getInt("os_user"));
				os.setOs_dt_emissao(rs.getString("os_dt_emissao"));
				os.setOs_tp_equip(rs.getString("os_tp_equip"));
				os.setOs_marca_equip(rs.getString("os_marca_equip"));
				os.setOs_problema(rs.getString("os_problema"));
				os.setOs_exec(rs.getString("os_exec"));
				os.setOs_status(rs.getString("os_status"));
				
			} else {
				return null;
			}
			
			return os;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

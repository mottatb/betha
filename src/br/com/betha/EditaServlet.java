package br.com.betha;

/**
 * @author Jorge Motta
 * 23/07/19
 * 
 */


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import br.com.betha.dao.ClienteDao;
import br.com.betha.dao.OrdemServicoDao;
import br.com.betha.dao.UserDao;
import br.com.betha.modelo.Cliente;
import br.com.betha.modelo.OrdemServico;

@WebServlet("/editarOS")
public class EditaServlet extends HttpServlet {

	static Logger log = Logger.getLogger(EditaServlet.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		
        String paginaResultado = "";
        HttpSession session = request.getSession(true);
        paginaResultado = "/sistema/alteraOS.jsp";
        
        OrdemServico os = new OrdemServico();
        OrdemServicoDao osDao  = new OrdemServicoDao();
        
        Cliente cli = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        
        //envia lista de tecnicos para poder alterar, caso necessario
        UserDao userDao = new UserDao();
		session.setAttribute("lstTecnico", userDao.getlstUser());
        
        try {
	        if ((String) request.getParameter("os")!=null) {
	        	os = osDao.getOS(Integer.parseInt(request.getParameter("os")));
	        	
	        	//seta o cliente da OS para buscar os dados
	        	cli.setCliente_id(os.getOs_id_cli());
	        	cli = clienteDao.getCliente(cli);
	        	
	        	session.setAttribute("OSX", os);
	        	session.setAttribute("ClienteOS", cli);
	        	session.setAttribute("idOS", os.getOs_id());
	        	
			} else {
				if ((String) request.getParameter("problema")!=null) {
					int cadastra = 0;
					
					os.setOs_id(Integer.parseInt(request.getParameter("idOS")));
					
					os.setOs_problema(request.getParameter("problema"));
					cadastra ++;
					
					if ((String)request.getParameter("idCli") != null) {
						os.setOs_id_cli(Integer.parseInt(request.getParameter("idCli")));
						cadastra ++;
					}
					
					if ((String) request.getParameter("tpEquip")!=null) {
						os.setOs_tp_equip(request.getParameter("tpEquip"));
						cadastra ++;
					}
					
					if ((String) request.getParameter("marcaEquip")!=null) {
						os.setOs_marca_equip(request.getParameter("marcaEquip"));
						cadastra ++;
					}
					
					if ((String) request.getParameter("executado")!=null) {
						os.setOs_exec(request.getParameter("executado"));
					}

					if ((String) request.getParameter("status")!=null) {
						os.setOs_status(request.getParameter("status"));
						cadastra ++;
					}

					if ((String) request.getParameter("tecnico")!=null) {
						os.setOs_user(Integer.parseInt(request.getParameter("tecnico")));
						cadastra ++;
					}
					if ((String) request.getParameter("dt_fechamento")!=null) {
						os.setOs_dt_fechamento(request.getParameter("dt_fechamento"));
						cadastra ++;
					}

					if(cadastra>5) {
						osDao.atualizaCadastro(os);
						paginaResultado = "/sistema/consultarOS.jsp";
					} else {
						session.setAttribute("erro", "Erro ao Atualizar ");
					}

				}
			}
		} catch (Exception e) {
			log.debug(OrdemServicoServlet.class.getName()+" - "+e);
			e.printStackTrace();
		}
		
		//chama a pagina jsp
		request.getRequestDispatcher(paginaResultado).forward(request, response);
    }
}

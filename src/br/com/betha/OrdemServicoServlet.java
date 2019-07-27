package br.com.betha;

/**
 * @author Jorge Motta
 * 26/07/19
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
import br.com.betha.modelo.Cliente;
import br.com.betha.modelo.OrdemServico;

@WebServlet("/OSX")
public class OrdemServicoServlet extends HttpServlet {

	static Logger log = Logger.getLogger(OrdemServicoServlet.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession(true);
        String paginaResultado = "";
        
        OrdemServico ordemServico = new OrdemServico();
        OrdemServicoDao osDao  = new OrdemServicoDao();
        
        Cliente cli = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        
        try {
        	
	        if ((String) request.getParameter("os")!=null) {
	        	ordemServico = osDao.getOS(Integer.parseInt(request.getParameter("os")));
	        	
	        	//seta o cliente da OS para buscar os dados
	        	cli.setCliente_id(ordemServico.getOs_id_cli());
	        	cli = clienteDao.getCliente(cli);
	        	
	        	session.setAttribute("OSX", ordemServico);
	        	session.setAttribute("cliente", cli);
			}
    		
	        
			//seta a pagina jsp a ser chamada
	        paginaResultado = "sistema/OSX.jsp";
    		
		} catch (Exception e) {
			log.debug(OrdemServicoServlet.class.getName()+" - "+e);
			e.printStackTrace();
		}
		
		//chama a pagina jsp
		request.getRequestDispatcher(paginaResultado).forward(request, response);
        
    }
}

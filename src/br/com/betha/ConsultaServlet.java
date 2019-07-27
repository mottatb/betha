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

import br.com.betha.dao.OrdemServicoDao;
import br.com.betha.dao.UserDao;
import br.com.betha.modelo.User;

@WebServlet("/consultarOS")
public class ConsultaServlet extends HttpServlet {

	static Logger log = Logger.getLogger(ConsultaServlet.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		
        String paginaResultado = "";
        HttpSession session = request.getSession(true);
        paginaResultado = "/sistema/consultarOS.jsp";
        
		try {
			
			User user = new User();
        	user = (User) session.getAttribute("User");
        	
        	UserDao userDao = new UserDao();
			user = userDao.getUser(user);
			
			OrdemServicoDao osDao = new OrdemServicoDao();
			
			session.setAttribute("lstOS", osDao.getlstOS(user));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//chama a pagina jsp
		request.getRequestDispatcher(paginaResultado).forward(request, response);
    }
}

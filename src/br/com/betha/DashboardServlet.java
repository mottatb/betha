package br.com.betha;

/**
 * @author Jorge Motta
 * Projeto AlfaSJ
 * 22/12/18
 */


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import br.com.betha.dao.UserDao;
import br.com.betha.modelo.User;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

	static Logger log = Logger.getLogger(DashboardServlet.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		
        HttpSession session = request.getSession(true);
        String paginaResultado = "";
        
        try {
        	
        	User user = new User();
        	user = (User) session.getAttribute("User");
        	
        	UserDao userDao = new UserDao();
			user = userDao.getUser(user);
        	
        	session.setAttribute("dadosDash", userDao.getDashDados(user));
			paginaResultado = "/sistema/dashboard.jsp";

        } catch (SQLException e) {
        	e.printStackTrace();
        }

        //chama a pagina jsp
        request.getRequestDispatcher(paginaResultado).forward(request, response);
	}
}
	
	
	
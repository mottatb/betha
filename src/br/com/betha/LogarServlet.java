package br.com.betha;

/**
 * @author Jorge Motta
 * Projeto AlfaSJ
 * 04/11/18
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

import br.com.betha.dao.LoginDao;
import br.com.betha.dao.UserDao;
import br.com.betha.modelo.User;

@WebServlet("/LOGAR")
public class LogarServlet extends HttpServlet {

	static Logger log = Logger.getLogger(LogarServlet.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		
		String paginaResultado = "login.jsp";
        HttpSession session = request.getSession(true);
        
		try {
			String sTemp = (String) request.getParameter("envio");
			
			if (sTemp!=null) {
				session.setAttribute("envio",sTemp);
			}
			
			//verifica se é um logoff
			if ((String) request.getParameter("logoff")!=null) {
				request.getSession().invalidate();
				request.getSession().isNew();
				paginaResultado = "inicial";
				
				return;
				
			} else {
				
				//inicia procedimento para verificar login
				User user = new User();
				String erroLogin = "";
				
				//verifica se login e senha foram preenchidos
				if (((String) request.getParameter("login")!=null)&&((String) request.getParameter("senha")!=null)) {
					user.setUs_login(request.getParameter("login"));
					user.setUs_password(request.getParameter("senha"));
					
					LoginDao loginDao = new LoginDao();
					user = loginDao.getAssociado(user);
					
					//verifica se associado esta cadastrado
					if (user.getUs_nome()!=null) {
						
						UserDao userDao = new UserDao();
						user = userDao.getUser(user);
						
						//associado esta cadastrado e será setado na sessao
						session.setAttribute("User",user);
			        	session.setAttribute("dadosDash", userDao.getDashDados(user));
						
						paginaResultado = "/sistema/dashboard.jsp";
						
					} else {
						
						//caso nao cadastrado, retorna erro
						paginaResultado = "/index.jsp";
						session.setAttribute("erroLogin",erroLogin);
						log.debug(paginaResultado);
					}
				}
			}
		} catch (Exception e) {
			log.error(LogarServlet.class.getName()+"-"+e);
			e.printStackTrace();
		}
		
		//chama a pagina jsp
		request.getRequestDispatcher(paginaResultado).forward(request, response);
    }
}

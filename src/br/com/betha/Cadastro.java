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

@WebServlet("/cadastrarOS")
public class Cadastro extends HttpServlet {

	static Logger log = Logger.getLogger(Cadastro.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		
        String paginaResultado = "";
        HttpSession session = request.getSession(true);
        paginaResultado = "/sistema/cadastrarOS.jsp";
        
		try {
			
			int cadastra = 0;
			
			OrdemServico os = new OrdemServico();
			
			//caso campo problema preenchido, inicia verificações
			if ((String) request.getParameter("problema")!=null) {
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

				OrdemServicoDao osDao = new OrdemServicoDao();
				
				if(cadastra>5) {
					osDao.adicionaCadastro(os);
					paginaResultado = "/sistema/consultarOS.jsp";
				} else {
					session.setAttribute("erro", "Erro ao Cadastrar ");
				}

			} else if ((String)request.getParameter("idCli") != null) {
				//caso idCli preenchido, retorna os dados do cliente para cadastras a nova OS
				
				Cliente cli = new Cliente();
				ClienteDao clienteDao = new ClienteDao();
				
				cli.setCliente_id(Integer.parseInt((String)request.getParameter("idCli")));
				cli = clienteDao.getCliente(cli);
				
				if ((String) request.getParameter("nomeCli")!=null) {
					cli.setCliente_nome(request.getParameter("nomeCli"));
					cadastra ++;
				}
				
				if ((String) request.getParameter("sobreNome")!=null) {
					cli.setCliente_sobrenome(request.getParameter("sobreNome"));
					cadastra ++;
				}
				
				if ((String) request.getParameter("doc")!=null) {
					cli.setCliente_doc(request.getParameter("doc"));
					cadastra ++;
				}
				
				if ((String) request.getParameter("fone")!=null) {
					cli.setCliente_telefone(request.getParameter("fone"));
					cadastra ++;
				}
				if ((String) request.getParameter("email")!=null) {
					cli.setCliente_email(request.getParameter("email"));
					cadastra ++;
				}
				
				session.setAttribute("Cliente",cli);
				session.setAttribute("erro", "");
				
			} else {
				//neste caso é a primeira passada para iniciar o cadastro
				
				UserDao userDao = new UserDao();
				session.setAttribute("lstTecnico", userDao.getlstUser());
				session.setAttribute("erro", "");
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//chama a pagina jsp
		request.getRequestDispatcher(paginaResultado).forward(request, response);
    }
}

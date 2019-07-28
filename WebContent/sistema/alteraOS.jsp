<%@page import="java.util.ArrayList"%>
<%@page import="br.com.betha.modelo.User"%>
<%@page import="br.com.betha.modelo.OrdemServico"%>
<%@page import="br.com.betha.modelo.Cliente"%>
<%@page import="br.com.betha.modelo.OrdemServico"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
	<%
		int idOS = (int)session.getAttribute("idOS");
	
		String erro = (String)session.getAttribute("erro");
		//verificar erro
	
		User user = (User) session.getAttribute("User");
		session.setAttribute("User", user);
	
		Cliente cli = (Cliente) session.getAttribute("ClienteOS");
		session.setAttribute("ClienteOS", cli);
	
		ArrayList<User> lstTecnico = (ArrayList<User>) session.getAttribute("lstTecnico");
		OrdemServico os = (OrdemServico) session.getAttribute("OSX");
	
		session.setAttribute("Cliente", cli);
		
		boolean logado = user == null ? false : true;
	%>
	<title>Cadastro de OS | Betha Sistemas</title>
	<meta name="theme-color" content="#3A2F0B">
	<meta name="apple-mobile-web-app-status-bar-style" content="#3A2F0B">
	<meta name="apple-mobile-web-app-status-bar-style" content="#3A2F0B">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="oportunidade, renda extra, milionário, crescimento, ganhe dinheiro, vendas diretas, semijoias, ouro, platina, plaquê, folheado a ouro, ródio, folheado, venda semijoias, ganhe dinheiro com vendas, monte sua equipe, marketing multinivel, monte sua rede, ajude outros a crescerem, mude sua vida, transformar vidas" />
	
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<link href="sistema/css/bootstrap.css" rel="stylesheet"
		type="text/css" media="all">
	<!-- Custom Theme files -->
	<link href="sistema/css/style.css" rel="stylesheet" type="text/css"	media="all" />
	<!--js-->
	<script src="sistema/js/jquery-2.1.1.min.js"></script>
	<!--icons-css-->
	<link href="sistema/css/font-awesome.css" rel="stylesheet">
	<!--Google Fonts-->
	<link href='//fonts.googleapis.com/css?family=Carrois+Gothic' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600' rel='stylesheet' type='text/css'>
	<!--static chart-->
	<script src="sistema/js/Chart.min.js"></script>
	<!--//charts-->
	<!-- geo chart -->
	<script src="//cdn.jsdelivr.net/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
	<script>window.modernizr || document.write('<script src="lib/modernizr/modernizr-custom.js"><\/script>')</script>
	<!--<script src="lib/html5shiv/html5shiv.js"></script>-->
	<!-- Chartinator  -->
	<script src="sistema/js/chartinator.js"></script>
	
	
	<!--skycons-icons-->
	<script src="sistema/js/skycons.js"></script>
	<!--//skycons-icons-->
	
	<script type="text/javascript" src="sistema/js/jquery.min.js"></script>
	<script type="text/javascript" src="sistema/js/jquery.validate.js"></script>
	<script type="text/javascript" src="sistema/js/jquery.mask.min.js" /></script>
	
</head>
<body>
	<div class="page-container">
		<div class="left-content">
			<div class="mother-grid-inner">
				<!--header start here-->
				<div class="header-main">
					<div class="header-left">
						<div class="logo-name">
							<a href="dashboard">
								<h2>Betha Sistemas</h2> <!--<img id="logo" src="" alt="Logo"/>-->
							</a>
						</div>
					</div>
					<div class="header-right">
						<div class="profile_details">
							<ul>
								<li class="dropdown profile_details_drop">
								<a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									aria-expanded="false">
										<div class="profile_img">
											<span class="prfil-img"> <i class="fa fa-user fa-2x" aria-hidden="true"></i><a href="LOGAR?logoff=true">&nbsp;<i class="fa fa-sign-out fa-2x" aria-hidden="true"></i></a></span>
											<div class="user-name">
												<p><%=user.getUs_nome()%></p>
											</div>
											<div class="clearfix"></div>
										</div>
								</a>
								</li>
							</ul>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>
				<!--heder end here-->
				<!-- script-for sticky-nav -->
				<script>
					$(document).ready(function() {
						 var navoffeset=$(".header-main").offset().top;
						 $(window).scroll(function(){
							var scrollpos=$(window).scrollTop(); 
							if(scrollpos >=navoffeset){
								$(".header-main").addClass("fixed");
							}else{
								$(".header-main").removeClass("fixed");
							}
						 });
					});
				</script>
				<!-- /script-for sticky-nav -->
				<!--inner block start here-->

				<div class="inner-block">
					<div class="blank">
						<h2>Altera Ordem de Serviço</h2>
						<div class="inbox-details-body">
							<!-- <div class="alert alert-info">Caso haja a necessidade, altere seus dados.</div> -->
							
							<form action="cadastrarOS" method="post">
								<div class="col-xs-12 market-update-gd">
									<input type="text" name="idCli" id="idCli" placeholder="Codigo do Cliente" value="<%= os!=null?os.getOs_id_cli():""%>">
									<input type="submit" value="Buscar Cliente">
									<br>
									<br>
								</div>
							</form>
							<form action="editarOS" method="post">
								<div class="col-md-6 market-update-gd">
									<input type="hidden" id="idOS" name="idOS" value="<%= idOS %>">
									<input type="hidden" id="idCli" name="idCli" value="<%= os!=null?os.getOs_id_cli():""%>">
									<input disabled="disabled" type="text" name="nomeCli" id="nomeCli" placeholder="Nome do Cliente" value="<%= cli!=null?cli.getCliente_nome():""%>">
								</div>
								<div class="col-md-6 market-update-gd">
									<input disabled="disabled" type="text" name="sobreNome" id="sobreNome" placeholder="Sobrenome" value="<%= cli!=null?cli.getCliente_sobrenome():""%>">
								</div>
								<div class="col-md-6 market-update-gd">
									<input disabled="disabled" type="text" name="doc" id="doc" placeholder="Documento (CPF/CNPJ ou outro)" value="<%= cli!=null?cli.getCliente_doc():""%>">
								</div>
								<div class="col-md-6 market-update-gd">
									<input disabled="disabled" type="text" name="fone" id="fone" placeholder="Telefone para contato" value="<%= cli!=null?cli.getCliente_telefone():""%>">
								</div>
								<div class="col-xs-12 market-update-gd">
									<input disabled="disabled" type="text" name="email" id="email" placeholder="e-mail" value="<%= cli!=null?cli.getCliente_email():""%>">
								</div>
								
								<div class="col-xs-12 market-update-gd">
									<hr>
								</div>
								
								<div class="col-md-6 market-update-gd">
									<input type="text" name="tpEquip" id="tpEquip" placeholder="Tipo do Equipamento:" value="<%= os.getOs_tp_equip() %>">
								</div>
								<div class="col-md-6 market-update-gd">
									<input type="text" name="marcaEquip" id="marcaEquip" placeholder="Marca do Equipamento" value="<%= os.getOs_marca_equip() %>">
								</div>
								
								<div class="col-xs-12 market-update-gd">
									<textarea name="problema" id="problema" placeholder="Problema apresentado:" rows="10" cols="40" maxlength="500"><%= os.getOs_problema() %></textarea>
								</div>
								
								<div class="col-xs-12 market-update-gd">
									<textarea name="executado" id="executado" placeholder="Execução:" rows="10" cols="40" maxlength="500"><%= os.getOs_exec() %></textarea>
								</div>
								<div class="col-md-6 market-update-gd">
									<select name="status" id="status" class="form-control">
										<option value="<%= os.getOs_status()!=null?os.getOs_status():"" %>"> <%= os.getOs_status()!=null?os.getOs_status():"Status da OS" %> </option>
										<option value="Aberto">Aberto</option>
										<option value="Pendente">Pendente</option>
										<option value="Cancelado">Cancelado</option>
										<option value="Concluido">Concluido</option>
									</select>
								</div>
								<div class="col-md-6 market-update-gd">
									<select name="tecnico" id="tecnico" class="form-control">
										<option value="<%= os==null?"":os.getOs_user() %>"></option>
									<% for(int i=0;i<lstTecnico.size();i++){ %>
										<option value="<%= lstTecnico.get(i).getUs_id() %>"><%= lstTecnico.get(i).getUs_id() %> - <%= lstTecnico.get(i).getUs_nome() %></option>
									<% } %>
									</select>
								</div>
								<div class="col-xs-12 market-update-gd">
									<hr>
									<input type="submit" value="Alterar OS">
								</div>
							</form>
						</div>

					</div>
				</div>
				<br>
				<br>
				<br>
				<!--inner block end here-->
				<!--copy rights start here-->
				<div class="copyrights">
				</div>
				<!--COPY rights end here-->
			</div>
		</div>
		<!--slider menu-->
		<div class="sidebar-menu">
		<div class="logo">
			<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
			</a> <a href="#"> <span id="logo"></span> <!--<img id="logo" src="" alt="Logo"/>-->
			</a>
		</div>
		<div class="menu">
			<ul id="menu">
				<li id="menu-home"><a href="dashboard"><i
						class="fa fa-tachometer"></i><span>Dashboard</span></a></li>
				<!-- <li><a href="#"><i class="fa fa-cogs"></i><span>Components</span><span class="fa fa-angle-right" style="float: right"></span></a> 
		          <ul>
		            <li><a href="grids.html">Grids</a></li>
		            <li><a href="portlet.html">Portlets</a></li>		            
		          </ul>
		        </li>-->
				<li><a href="cadastrarOS"> <i class="fa fa-book"
						aria-hidden="true"></i> <span>Cadastrar OS</span></a></li>
				<li><a href="consultarOS"> <i class="fa fa-book"
						aria-hidden="true"></i> <span>Consultar OS</span></a></li>
			</ul>
		</div>
	</div>
	<div class="clearfix"></div>
	<div></div>
	<!--slide bar menu end here-->
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "fixed"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "fixed"
							});
						}, 400);
					}
					toggle = !toggle;
				});
	</script>
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	<script src="js/bootstrap.js">
		
	</script>
	<!-- mother grid end here-->
</body>
</html>

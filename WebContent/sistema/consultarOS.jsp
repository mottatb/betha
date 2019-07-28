<%@page import="br.com.betha.modelo.OrdemServico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.betha.modelo.User"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<%
	ArrayList<OrdemServico> lstOS = (ArrayList<OrdemServico>) session.getAttribute("lstOS");
	
	String images = "/images";

	User user = (User) session.getAttribute("User");
	session.setAttribute("User", user);

	boolean logado = user == null ? false : true;
%>
<title>Consulta de OS | Betha Sistemas</title>
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
<script	src="//cdn.jsdelivr.net/modernizr/2.8.3/modernizr.min.js"	type="text/javascript"></script>
<script>window.modernizr || document.write('<script src="sistema/lib/modernizr/modernizr-custom.js"><\/script>')</script>
<!--<script src="sistema/lib/html5shiv/html5shiv.js"></script>-->
<!-- Chartinator  -->
<script src="sistema/js/chartinator.js"></script>


<!--skycons-icons-->
<script src="sistema/js/skycons.js"></script>
<!--//skycons-icons-->
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

						<!--notification menu end -->
						<div class="profile_details">
							<ul>
								<li class="dropdown profile_details_drop"><a href="#"
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
							<div class="clearfix"> </div>				
						</div>
				     <div class="clearfix"> </div>	
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
    	<h2>Ordens de Serviço Cadastradas</h2>
    	<section>
        <table id="pedidos" class="table table-bordered table-hover">
                    <thead>
                    <tr>
                      <th>Código</th>
                      <th>Data / Hora</th>
                      <th>Equipamento</th>
                      <th>Problema</th>
                      <th>Status</th>
                      <th> - </th>
                      <th> - </th>
                    </tr>
                    </thead>
                    <tbody>
                    <% if (lstOS != null){
	                    for(int i=0;i<lstOS.size();i++){
	               %>
	                    <tr>
	                    
	                      <td><%= lstOS.get(i).getOs_id() %></td>
	                      <td><%= lstOS.get(i).getOs_dt_emissao() %></td>
	                      <td><%= lstOS.get(i).getOs_tp_equip() +" - "+ lstOS.get(i).getOs_marca_equip()%></td>
	                      <td><%= lstOS.get(i).getOs_problema().length()>30?lstOS.get(i).getOs_problema().substring(0,30):lstOS.get(i).getOs_problema() %></td>
	                      <td><%= lstOS.get(i).getOs_status() %></td>
	                      
	                      <td><a href="OSX?os=<%= lstOS.get(i).getOs_id() %>" class="btn btn-primary btn-default"
	                      			 role="button" aria-disabled="true"><i class="fa fa-eye" aria-hidden="true"></i> Detalhes</a></td>
	                      <td><a href="editarOS?os=<%= lstOS.get(i).getOs_id() %>" class="btn btn-primary btn-default"
	                      			 role="button" aria-disabled="true"><i aria-hidden="true"></i> Editar</a></td>
	                    </tr>
	                <% }
	                }%>
                    </tbody>
                  </table>
	</section>
    </div>
</div>
	<!--copy rights start here-->
	<div class="copyrights">
		<p>&nbsp;&nbsp;&nbsp;2019 Betha Sistemas. Todos os Direitos Reservados</p>
	</div>
	<!--COPY rights end here-->
<!--COPY rights end here-->
</div>
</div>
<!--slider menu-->
    <div class="sidebar-menu">
		  	<div class="logo">
		  		<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> <a href="#"> <span id="logo" ></span> 
			      <!--<img id="logo" src="" alt="Logo"/>--></a>
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
	<div class="clearfix"> </div>
</div>
<!--slide bar menu end here-->
<script>
var toggle = true;
            
$(".sidebar-icon").click(function() {                
  if (toggle)
  {
    $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
    $("#menu span").css({"position":"absolute"});
  }
  else
  {
    $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
    setTimeout(function() {
      $("#menu span").css({"position":"relative"});
    }, 400);
  }               
                toggle = !toggle;
            });
</script>
<!--scrolling js-->
		<script src="js/jquery.nicescroll.js"></script>
		<script src="js/scripts.js"></script>
		<!--//scrolling js-->
<script src="js/bootstrap.js"> </script>
<!-- mother grid end here-->
</body>
</html>        
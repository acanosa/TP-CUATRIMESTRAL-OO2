<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="ISO-8859-1">
		<title>Hotel San Martin</title>
		<%@page import= "datos.Usuario" %>
		<% Usuario usuario= new Usuario(); %>
		<link href="estilo.css" rel="stylesheet"/>
	</head>
	<body>
		<div id="div1" class="div-centrado">
			<h4>Hotel San Martin</h4> <BR><BR>
		</div>
		
		<div id="div2" class="div-centrado">
			<h4>Iniciar Sesion</h4>
		</div>
		
		<div class="div-centrado" >
			<FORM method=POST action="/TP-Cuatrimestral/IniciarSesion">
				<div class="div-texto">
					<label for="barra1"> Usuario: </label>	
					<INPUT name="usuario" type="text" class="BarraTexto" id="barra1">
				</div>	
				<div class="div-texto">
					<label for="barra2">Password: </label> 	
					<input name="clave" type="password" class="BarraTexto" id="barra2">
				</div>
				<div class="div-centrado">
					<INPUT type="submit" value="Iniciar Sesion">
				<br>			 
				</div>
			</FORM>
		</div>
			<% boolean sesion=false; %>
			<br>
			<br>
			<br>
			<form method= "GET" action="/TP-Cuatrimestral/registroCliente.jsp">
				<input type="submit" value="Registrarse">
			</form>
	</body>
</html>
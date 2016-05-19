<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel San Martin</title>
<%@page import= "datos.Usuario" %>
		<% String estado=""; %>
		<% Usuario usuario= new Usuario(); %>
		<link href="estilo.css" rel="stylesheet"/>
	</head>
	<body>
		
		<div id="div2" class="div-centrado">
			<h4>Registrarse</h4>
		</div>
	<div class="div-centrado" >
		<FORM method=POST action="/TP-Cuatrimestral/RegistrarCliente">
		<div>
		
				<label> Ingrese nombre: </label>
				<INPUT name="nombre" type="text">
		
		</div>
		<div>
			
			<label> Ingrese apellido: </label>
			<INPUT name="apellido" type="text">
				
		</div>
		<div>
			
			<label> Ingrese dni: </label>
			<INPUT name="dni" type="text">
			
		</div>
		<div>
			
			<label> Ingrese usuario: </label>
			<INPUT name="usuario" type="text">
			
		</div>
		<div>
			
			<label> Ingrese clave: </label>
			<INPUT name="clave" type="password">
			
		</div>
		<div>
			<input type="submit" value="confirmar">
			
		</div>
			</FORM>
	</div>
</body>
</html>


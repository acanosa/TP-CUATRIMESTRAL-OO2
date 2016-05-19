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
	<div>
		<FORM method=POST action="/TP-Cuatrimestral/inicio.jsp">
			<label> Ingrese nombre: </label>
			<INPUT name="nombre" type="text">
		</FORM>
	</div>
	<div>
		<FORM method=POST action="/TP-Cuatrimestral/inicio.jsp">
			<label> Ingrese apellido: </label>
			<INPUT name="apellido" type="text">
		</FORM>
	</div>
	<div>
		<FORM method=POST action="/TP-Cuatrimestral/inicio.jsp">
			<label> Ingrese dni: </label>
			<INPUT name="dni" type="text">
		</FORM>
	</div>
	<div>
		<FORM method=POST action="/TP-Cuatrimestral/inicio.jsp">
			<label> Ingrese usuario: </label>
			<INPUT name="usuario" type="text">
		</FORM>
	</div>
	<div>
		<FORM method=POST action="/TP-Cuatrimestral/inicio.jsp">
			<label> Ingrese clave: </label>
			<INPUT name="clave" type="text">
		</FORM>
	</div>
	<div>
	<form>
 		 <input type="radio" name="gender" value="administrador" checked> Administrador <br>
  		 <input type="radio" name="gender" value="limpieza" class="radio">  Limpieza <br>
   		 <input type="radio" name="gender" value="mantenimiento" class="radio2"> Mantenimiento <br>  
	</form> 
	</div>
	<br>
	<div>
		<form method= GET action="/TP-Cuatrimestral/inicio.jsp">
				<input type="submit" value="confirmar">
		</form>
		</div>
</div>
</body>
</html>
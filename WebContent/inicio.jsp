<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@page import= "datos.Usuario" %>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inicio</title>
	<link href="estilo.css" rel="stylesheet"></link>
</head>
<body>
	
	<div class="div-izquierda">
		<% Usuario u= (Usuario) request.getAttribute("Usuario");%>
		<h2> Nombre: <%= u.getNombre() %></h2>
		<h2> Apellido: <%= u.getApellido() %></h2>
		<h2> DNI: <%= u.getDni() %></h2>
		<h2> Usuario: <%= u.getUsuario() %></h2>
		<h2> Tipo usuario: <%= u.getTipoUsuario().getTipo() %> </h2> <!-- muestra tipo usuario -->
	</div>
	
	
	

</body>
</html>
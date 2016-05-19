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
				<h4>Rellenar el Siguiente formulario</h4>
			</div>
			<div class="div-centrado" >
			<div>
		
		<form method= GET action="/TP-Cuatrimestral/habitacionDisponible.jsp">
			</div>
				<label> Ingrese dia de check in: </label>
				<INPUT name="checkIn" type="text">
			<div>
			</div>
			<div>
		
				<label> Ingrese dia de check out: </label>
				<INPUT name="cheakOut" type="text">
		
			</div>
			<div>
		
				<label> Ingrese el numero de huespedes para la habitacion: </label>
				<INPUT name="habitacion" type="text">
		
			</div>
			<div>
		
				<label> Ingrese tipo de habitacion: </label>
				<INPUT name="clave" type="text">
			
			</div>
			<div>
		
				<input type="submit" value="ir a habitaciones disponibles">
		
			</div>
		</form>
</div>
</body>
</html>
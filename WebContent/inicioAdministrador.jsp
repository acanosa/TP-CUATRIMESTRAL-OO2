<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<% String nombre= "Alejandro"; %>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title> <% out.println("Administrador " + nombre); %></title>
	<link href="estilo.css" rel="stylesheet"/>
</head>
<body>
	<div id="cuerpoPagina">
		<div id="divAdmin">
			<IMG src="/TP-Cuatrimestral/images/admin.png" height="32" width="32">
			<label style="font-size: 23"> <% out.println("ADMIN: "+ nombre); %> </label>
			
		</div>
		<div>
			<table style= "width:50%; text-align: center;" align=center >
				<tr>
					<th> Administracion</th>
					<th> Mantenimiento</th>
					<th> Limpieza</th>
				</tr>
				<tr>
					<td style="padding:  5px;">	
						<form method=post action="registrarAdministrador.jsp"></form>	
							<input type="submit" value="Agregar Administrador"/>
					</td>
					<td>	
						<form method=post action="registrarMantenimiento.jsp"></form>	
								<input type="submit" value="Agregar empleado mantenimiento"/>
					</td>	
					<td>	
					<form method=post action="registrarMucama.jsp"></form>	
							<input type="submit" value="Agregar mucama" style="text-align: center"/>
					</td>	
				 </tr>
				 <tr>
					<td style="padding:  5px;">	
						<form method=post action="consultarAdministrador.jsp"></form>	
							<input type="submit" value="Consultar Administrador"/>
					</td>
					<td>	
						<form method=post action="/TP-Cuatrimestral/consultarMantenimiento.jsp"></form>	
								<input type="submit" value="Consultar empleado mantenimiento"/>
					</td>	
					<td>	
					<form method=post action="/TP-Cuatrimestral/consultarMucama.jsp"></form>	
							<input type="submit" value="Consultar mucama" style="text-align: center"/>
					</td>	
				 </tr>
				 <tr>
					<td style="padding:  5px;">	
						<form method=post action="/TP-Cuatrimestral/eliminarAdministrador.jsp"></form>	
							<input type="submit" value="Eliminar Administrador"/>
					</td>
					<td>	
						<form method=post action="/TP-Cuatrimestral/eliminarMantenimiento.jsp"></form>	
								<input type="submit" value="Eliminar empleado mantenimiento"/>
					</td>	
					<td>	
					<form method=post action="/TP-Cuatrimestral/eliminarMucama.jsp"></form>	
							<input type="submit" value="Eliminar mucama" style="text-align: center"/>
					</td>	
				 </tr>
				 <tr>
				 	<td style= "width:50%"> 		
				 		<form method= GET action="/TP-Cuatrimestral/registroEmpleado.jsp">
						<input type="submit" value="Agregar empleado">
						</form> 
					</td>
				 </tr>
			</table>
			
			<div>
				<table style="text-align: center;" align: left>
					
					<tr>
						<td> <a  href="/Estadisticas"> Ver estadisticas...</a> </td>
					</tr>
					<tr>
						<td> <a  href="/abmPromociones"> modificar promociones...</a> </td>
					</tr>
				</table>
			</div>
			<div id="div2" >
				<a  href="/cerrarSesion"> Cerrar sesion...</a>
			
			</div>
		</div>
	</div>
	<div class="pie">
		<%@ include file="/pie.jsp" %>
	</div>
</body>
</html>
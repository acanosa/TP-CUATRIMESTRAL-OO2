<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Estadias</title>
</head>
<body>
 <link rel="stylesheet" href="/TP-Cuatrimestal/estilo.css" type="text/css"/> 
<!--  <%@ include file="/encabezado.jsp" %>-->
<br>
<br>
 <div style="width: 400px; margin: 0 auto;">
  <form method="post" action=" /TP-Cuatrimestral/ConsultarEstadiaJSP">
     <input type="hidden"  name="jstl"  value="0"/>
       <table border="0">
         <tr>
            <h3><em> Consulta de Estadias:</em></h3><br>
            <td><em><strong>$ desde</strong></em></td>
            <td><input name="desde"></td>

         </tr>
         <br>
         
          <tr>
            <td><em><strong> $ hasta</strong></em></td>
            <td><input name="hasta"></td>

         </tr>
            
         <tr>
            
            <td><input type="submit" value="Consultar"></td>
            
         </tr>
         
       </table>
  
 </form>
   </div>

</body>
</html>
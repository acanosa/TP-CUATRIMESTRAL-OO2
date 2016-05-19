<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sistema Inmobiliario</title>
<style type="text/css">
<!--
body {
	font: 100%/1.4 Verdana, Arial, Helvetica, sans-serif;
	background: #42413C;
	margin: 0;
	padding: 0;
	color: #000;
}

/* ~~ Selectores de elemento/etiqueta ~~ */
ul, ol, dl { /* Debido a las diferencias existentes entre los navegadores, es recomendable no añadir relleno ni márgenes en las listas. Para lograr coherencia, puede especificar las cantidades deseadas aquí o en los elementos de lista (LI, DT, DD) que contienen. Recuerde que lo que haga aquí se aplicará en cascada en la lista .nav, a no ser que escriba un selector más específico. */
	padding: 0;
	margin: 0;
}
h1, h2, h3, h4, h5, h6, p {
	margin-top: 0;	 /* la eliminación del margen superior resuelve un problema que origina que los márgenes escapen de la etiqueta div contenedora. El margen inferior restante lo mantendrá separado de los elementos de que le sigan. */
	padding-right: 15px;
	padding-left: 15px; /* la adición de relleno a los lados del elemento dentro de las divs, en lugar de en las divs propiamente dichas, elimina todas las matemáticas de modelo de cuadro. Una div anidada con relleno lateral también puede usarse como método alternativo. */
	color: #FFF;
	background-color: #F30;
	text-align: center;
}
a img { /* este selector elimina el borde azul predeterminado que se muestra en algunos navegadores alrededor de una imagen cuando está rodeada por un vínculo */
	border: none;
	background-color: #F30;
}

/* ~~ La aplicación de estilo a los vínculos del sitio debe permanecer en este orden (incluido el grupo de selectores que crea el efecto hover -paso por encima-). ~~ */
a:link {
	color: #42413C;
	text-decoration: underline; /* a no ser que aplique estilos a los vínculos para que tengan un aspecto muy exclusivo, es recomendable proporcionar subrayados para facilitar una identificación visual rápida */
}
a:visited {
	color: #6E6C64;
	text-decoration: underline;
}
a:hover, a:active, a:focus { /* este grupo de selectores proporcionará a un usuario que navegue mediante el teclado la misma experiencia de hover (paso por encima) que experimenta un usuario que emplea un ratón. */
	text-decoration: none;
}

/* ~~ Este contenedor de anchura fija rodea a todas las demás divs ~~ */
.container {
	width: 960px;
	background: #FFFFFF;
	margin: 0 auto; /* el valor automático de los lados, unido a la anchura, centra el diseño */
}

/* ~~ No se asigna una anchura al encabezado. Se extenderá por toda la anchura del diseño. Contiene un marcador de posición de imagen que debe sustituirse por su propio logotipo vinculado. ~~ */
.header {
	background-color: #F30;
}

/* ~~ Estas son las columnas para el diseño. ~~ 

1) El relleno sólo se sitúa en la parte superior y/o inferior de las divs. Los elementos situados dentro de estas divs tienen relleno a los lados. Esto le ahorra las "matemáticas de modelo de cuadro". Recuerde que si añade relleno o borde lateral a la div propiamente dicha, éste se añadirá a la anchura que defina para crear la anchura *total*. También puede optar por eliminar el relleno del elemento en la div y colocar una segunda div dentro de ésta sin anchura y el relleno necesario para el diseño deseado.

2) No se asigna margen a las columnas, ya que todas ellas son flotantes. Si es preciso añadir un margen, evite colocarlo en el lado hacia el que se produce la flotación (por ejemplo: un margen derecho en una div configurada para flotar hacia la derecha). En muchas ocasiones, puede usarse relleno como alternativa. En el caso de divs para las que deba incumplirse esta regla, deberá añadir una declaración "display:inline" a la regla de la div para evitar un error que provoca que algunas versiones de Internet Explorer dupliquen el margen.

3) Dado que las clases se pueden usar varias veces en un documento (y que también se pueden aplicar varias clases a un elemento), se ha asignado a las columnas nombres de clases en lugar de ID. Por ejemplo, dos divs de barra lateral podrían apilarse si fuera necesario. Si lo prefiere, éstas pueden cambiarse a ID fácilmente, siempre y cuando las utilice una sola vez por documento.

4) Si prefiere que la navegación esté a la derecha en lugar de a la izquierda, simplemente haga que estas columnas floten en dirección opuesta (todas a la derecha en lugar de todas a la izquierda) y éstas se representarán en orden inverso. No es necesario mover las divs por el código fuente HTML.

*/
.sidebar1 {
	float: left;
	width: 100.01px;
	padding-bottom: 10px;
	height: 25.7px;
	background-color: #F30;
}
.content {
	width: 500px;
	float: left;
	height: 350px;
	margin: 175px;
	padding: 50px;
	background-color: #F30;
	text-align: center;
}
.sidebar2 {
	float: left;
	width: 188px;
	height: 15.7px;
	padding-top: 10px;
	padding-right: 0;
	padding-bottom: 10px;
	padding-left: 0px;
	background-color: #F30;
}

/* ~~ Este selector agrupado da espacio a las listas del área de .content ~~ */
.content ul, .content ol { 
	padding: 0 15px 15px 40px; /* este relleno reproduce en espejo el relleno derecho de la regla de encabezados y de párrafo incluida más arriba. El relleno se ha colocado en la parte inferior para que el espacio existente entre otros elementos de la lista y a la izquierda cree la sangría. Estos pueden ajustarse como se desee. */
}

/* ~~ Los estilos de lista de navegación (pueden eliminarse si opta por usar un menú desplegable predefinido como el de Spry) ~~ */
ul.nav {
	list-style: none; /* esto elimina el marcador de lista */
	border-top: 1px solid #666; /* esto crea el borde superior de los vínculos (los demás se sitúan usando un borde inferior en el LI) */
	margin-bottom: 15px; /* esto crea el espacio entre la navegación en el contenido situado debajo */
}
ul.nav li {
	border-bottom: 1px solid #666; /* esto crea la separación de los botones */
}
ul.nav a, ul.nav a:visited { /* al agrupar estos selectores, se asegurará de que los vínculos mantengan el aspecto de botón incluso después de haber sido visitados */
	padding: 5px 5px 5px 15px;
	display: block; /* esto da al anclaje propiedades de bloque, de manera que llene todo el LI en el que está contenido para que toda el área reaccione a un clic de ratón. */
	width: 160px;  /*esta anchura hace que se pueda hacer clic en todo el botón para IE6. Puede eliminarse si no es necesario proporcionar compatibilidad con IE6. Calcule la anchura adecuada restando el relleno de este vínculo de la anchura del contenedor de barra lateral. */
	text-decoration: none;
	background: #C6D580;
}
ul.nav a:hover, ul.nav a:active, ul.nav a:focus { /* esto cambia el color de fondo y del texto tanto para usuarios que naveguen con ratón como para los que lo hagan con teclado */
	background: #ADB96E;
	color: #FFF;
}

/* ~~ Los estilos de pie de página ~~ */
.footer {
	position: relative;/* esto da a IE6 hasLayout para borrar correctamente */
	clear: both; /* esta propiedad de borrado fuerza a .container a conocer dónde terminan las columnas y a contenerlas */
	height: 28.4px;
	width: 960px;
	padding-top: 10px;
	padding-right: 0;
	padding-bottom: 10px;
	padding-left: 0;
	background-color: #F30;
	color: #FFF;
}

/* ~~ Clases float/clear varias ~~ */
.fltrt {  /* esta clase puede utilizarse para que un elemento flote en la parte derecha de la página. El elemento flotante debe preceder al elemento junto al que debe aparecer en la página. */
	float: right;
	margin-left: 8px;
}
.fltlft { /* esta clase puede utilizarse para que un elemento flote en la parte izquierda de la página. El elemento flotante debe preceder al elemento junto al que debe aparecer en la página. */
	float: left;
	margin-right: 8px;
}
.clearfloat { /* esta clase puede situarse en una <br /> o div vacía como elemento final tras la última div flotante (dentro de .container) si .footer se elimina o se saca fuera de .container */
	clear:both;
	height:0;
	font-size: 1px;
	line-height: 0px;
}
.container .footer .footer {
	text-align: center;
}
.container .content h1 strong {
	color: #F30;
}
.container .content .registro form table tr td label {
	color: #FFF;
}

.registro{
	margin: 50px;
	}

-->
</style>
<link rel="stylesheet" href="/SistemaInmobiliario/diseño/Nivo-Slider-master/themes/default/default.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/SistemaInmobiliario/diseño/Nivo-Slider-master/themes/light/light.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/SistemaInmobiliario/diseño/Nivo-Slider-master/themesdark/dark.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/SistemaInmobiliario/diseño/Nivo-Slider-master/themes/bar/bar.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/SistemaInmobiliario/diseño/Nivo-Slider-master/nivo-slider.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/SistemaInmobiliario/diseño/Nivo-Slider-master/demo/style.css" type="text/css" media="screen">
<script src="/SistemaInmobiliario/diseño/js/SpryMenuBar.js" type="text/javascript"></script>

<link href="/SistemaInmobiliario/diseño/css/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css">

</head>

<body>

<div class="container">
  <div class="header"><a href="#"><img src="/SistemaInmobiliario/diseño/img/logo.png" alt="Insertar logotipo aquí" name="Insert_logo" width="960" height="120" id="Insert_logo" style="background: #C6D580; display:block;"></a> 
    <!-- end .header --></div>
    
  <div class="sidebar1">
   
    
    <!-- end .sidebar1 --></div>
    <div class="menu">
      <ul id="MenuBar1" class="MenuBarHorizontal">
      <li><a href="http://localhost:8080/SistemaInmobiliario/inicio.jsp" style="text-align: center">Inicio</a></li>
        <li><a href="#" class="MenuBarItemSubmenu" style="text-align: center">Usuario</a>
<ul>
           <li><a href="http://localhost:8080/SistemaInmobiliario/registro.jsp" style="text-align: center">Registro</a></li>
           <li><a href="http://localhost:8080/SistemaInmobiliario/iniciarsesion.jsp" style="text-align: center">Iniciar Sesion</a></li>
           <li><a href="http://localhost:8080/SistemaInmobiliario/cerrarsesion.jsp" style="text-align: center">Cerrar Sesion</a></li>
        </ul>
        </li>
        <li><a href="#" class="MenuBarItemSubmenu" style="text-align: center">Reserva</a>
         <ul>
            <li><a href="http://localhost:8080/SistemaInmobiliario/hacer%20reserva.jsp" style="text-align: center">Realizar</a></li>
            <li><a href="http://localhost:8080/SistemaInmobiliario/modificar%20reserva.jsp" style="text-align: center">Modificar</a></li>
            <li><a href="#" style="text-align: center">Cancelar</a></li>
            <li><a href="#" style="text-align: center">Consultar</a></li>
        </ul>
        </li>
        <li><a href="http://localhost:8080/SistemaInmobiliario/menu.jsp" style="text-align: center">Menu</a></li>
        <li><a href="http://localhost:8080/SistemaInmobiliario/contacto.jsp" style="text-align: center">Contacto</a></li>
        <li><a href="#" class="MenuBarItemSubmenu" style="text-align: center">Acerca de</a>
         <ul>
            <li><a href="http://localhost:8080/SistemaInmobiliario/acercade.jsp" style="text-align: center">Inmobiliaria</a></li>
            <li><a href="#" style="text-align: center">Promociones</a></li>
            <li><a href="#" style="text-align: center">Manual de Errores</a></li>
            
        </ul>
       </ul>
    </div>
 <div class="sidebar2">
    
    <!-- end .sidebar2 --></div>
  <div class="content">
  <div class="registro"> 
    
    <form name="form1" method="post" action="/SistemaInmobiliario/CerrarSesion/">
    
    <h3 style="text-align: center; font-size: 130%;">&nbsp;</h3>
    <h3 style="text-align: center; font-size: 150%;"><u><strong>Cerrar Sesion</strong></u></h3>
    <p style="text-align: center; font-size: 150%;">&nbsp;</p>
    <p style="text-align: center; font-size: 130%;">
		
           <%            
            session.removeAttribute("usuario");
            session.removeAttribute("clave");
            session.invalidate();
        %>
    <center>
        <h1 style="font-size: 130%; text-align: center;">Ha Cerrado sesion Correctamente</h1>
        <p style="font-size: 130%">&nbsp;</p>
        <p style="text-align: center">Para volver a Iniciar Sesion, haz click </p><a href="http://localhost:8080/SistemaInmobiliario/iniciarsesion.jsp">aqui</a>.
        </center>
       
       
       
   
        
		 

    </form>
    </div>
  <!-- end .content --></div>
  
  <div class="footer">
    <p class="footer">@2015 Todos los derechos reservados</p>
    <!-- end .footer --></div>
  <!-- end .container --></div>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"/SistemaRestaurant/static/js/SpryMenuBarDownHover.gif", imgRight:"/SistemaRestaurant/static/js/SpryMenuBarRightHover.gif"});
</script>
<script type="text/javascript" src="/SistemaRestaurant/static/Nivo-Slider-master/demo/scripts/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="/SistemaRestaurant/static/Nivo-Slider-master/jquery.nivo.slider.js"></script>
    <script type="text/javascript">
$(window).load(function() {
        $('#slider').nivoSlider();
    });
    </script>
</body>
</html>
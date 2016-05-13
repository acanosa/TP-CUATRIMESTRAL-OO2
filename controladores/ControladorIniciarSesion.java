package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Usuario;
import negocio.Facade;
import negocio.LoginABM;
import negocio.UsuarioABM;

public class ControladorIniciarSesion extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		iniciarSesion(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		iniciarSesion(request,response);
	}
	
	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		response.setContentType("text/jsp;charset=UTF-8");
		Facade facade= new Facade();
		LoginABM abmLogin= facade.getLoginABM();
		UsuarioABM abmUsuario=facade.getUsuarioABM();
		
		String usuario= (String) request.getAttribute("usuario");
		String clave= (String) request.getAttribute("clave");
		
		Usuario u= abmUsuario.traerUsuario(usuario,clave);
			if(u!= null)
			{
				
				request.setAttribute("Usuario", u);
				request.setAttribute("sesion", true);
				getServletContext().getRequestDispatcher("/TP-Cuatrimestral/inicio.jsp").forward(request, response);
			}
			else{
				request.setAttribute("estado", "ERROR: usuario incorrecto o clave incorrectos");
			}
			
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}

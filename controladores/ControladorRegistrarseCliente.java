package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Login;
import negocio.Facade;
import negocio.LoginABM;
import negocio.UsuarioABM;

public class ControladorRegistrarseCliente extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		registrarse(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		registrarse(request,response);
	}
	
	private void registrarse(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
			response.setContentType("text/html;charset=UTF-8");
			Facade facade= new Facade();
			LoginABM abmLogin= facade.getLoginABM();
			UsuarioABM abmUsuario=facade.getUsuarioABM();
		try{
			String nombre= (String) request.getParameter("nombre");
			String apellido= (String) request.getParameter("apellido");
			int dni= Integer.parseInt(request.getParameter("dni"));
			String usuario= (String) request.getParameter("usuario");
			String clave= (String) request.getParameter("clave");
			
			if(abmLogin.traerLogin(usuario) != null)
			{
				
				request.getRequestDispatcher("/registroFallido.jsp").forward(request,response);
				
			}
			else{
				long id=abmLogin.agregarLogin(usuario, clave, 4);
				Login login=abmLogin.traerLogin(id);
				abmUsuario.agregarUsuario(nombre, apellido, false, dni, login);
				//abmLogin.traerDatosUsuario(id);
				request.getRequestDispatcher("/inicio.jsp").forward(request, response);
			}
		
		}catch (Exception e){
			//request.getRequestDispatcher("/registroFallido.jsp").forward(request,response);
			response.sendError(500, e.getMessage());
			e.printStackTrace();
		}
	
	}
	

}

package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Login;
import negocio.Facade;
import negocio.LoginABM;


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
		
		
		HttpSession session=request.getSession();
		
		response.setContentType("text/html;charset=UTF-8");
		Facade facade= new Facade();
		LoginABM abmLogin= facade.getLoginABM();
		try{
			String usuario= (String) request.getParameter("usuario");
			String clave= (String) request.getParameter("clave");
			Login l= abmLogin.traerLogin(usuario,clave);
			
			response.setStatus(200);
				
			if(l != null)
				{
					request.setAttribute("Usuario", l.getUsuario());
					switch(l.getPrivilegio())
					{
						case 1:
							request.getRequestDispatcher("/inicioAdministrador.jsp").forward(request, response);
						break;
						case 2:
							request.getRequestDispatcher("/inicioLimpieza.jsp").forward(request, response);
							break;
						case 3:
							request.getRequestDispatcher("/inicioMantenimiento.jsp").forward(request, response);
							break;
						case 4:
							request.getRequestDispatcher("/inicioCliente.jsp").forward(request, response);
							break;
					}
				}
				
		
			
		}catch(Exception e){
			 request.getRequestDispatcher("/inicioFallido.jsp").forward(request , response);
		}
	}
	

}

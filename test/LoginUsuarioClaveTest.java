package test;

import datos.Login;
import negocio.LoginABM;
import negocio.UsuarioABM;

public class LoginUsuarioClaveTest {
	
	public static void main(String args[]) throws Exception{
		
		LoginABM abm=new LoginABM();
		UsuarioABM abmUsuario= new UsuarioABM();
		try{
			String usuario="canosa";
			String clave="123";
			
			System.out.println("Usuario: " + abm.traerLogin(usuario, clave));
			System.out.println("Usuario: " + abm.traerLogin("cliente", "123"));
			System.out.println("Usuario: " + abm.traerLogin("cliente"));
			//System.out.println("Usuario: " + abm.traerLogin(1));
		
			long id=abm.agregarLogin("pablo", "123", 1);
			Login login=abm.traerLogin(id);
			abmUsuario.agregarUsuario("pablo", "kiec", false, 27588965,login);
			System.out.println(login);
			System.out.println(abmUsuario.traerUsuario("pablo"));
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

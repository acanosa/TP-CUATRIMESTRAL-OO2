package test;

import datos.Login;
import negocio.LoginABM;

public class LoginTest { //funciona todo
	
	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){
		
		LoginABM abm = new LoginABM();
		
		try{
		
			String usuario="canosa";
			String clave="123";
			int privilegio=1;
			
			
			
			long idLogin=abm.agregarLogin(usuario,clave,privilegio);//objeto1
			System.out.println(abm.traerLogin(idLogin));
			
			limpiarPantalla();//10 enters
			
			Login login=abm.traerLogin(idLogin);
			
			login.setClave("alejandro");
			abm.modificarLogin(login);
			System.out.println(abm.traerLogin(idLogin));
	
			limpiarPantalla();//10 enters
			
			abm.agregarLogin("Cliente1", "345", 4);
			
			System.out.println(abm.traerLogins());
			
			limpiarPantalla();//10 enters
			
			
				
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

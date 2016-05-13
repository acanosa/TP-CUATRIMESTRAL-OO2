package test;

import datos.Usuario;
import negocio.UsuarioABM;

public class UsuarioTest {//
	
	public static void limpiarPantalla() //Funciona
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){
		
		UsuarioABM abm= new UsuarioABM();
		
		try{
			String usuario="canosa";
			String clave="123";
			String nombre="Alejandro";
			String apellido="Canosa";
			int dni=38701487;
			boolean baja=false;
			
			System.out.println(abm.traerUsuario(usuario,clave));
			
			long idUsuario=abm.agregarUsuario(nombre,apellido,baja,dni,usuario,clave);//objeto1
			System.out.println(abm.traerUsuario(idUsuario));
			
			limpiarPantalla();//10 enters
			
			Usuario t= new Usuario("Mariano","Loguercio",false,25701487,"Marian","456");
			long idUsuario2=abm.agregarUsuario(t);//objeto1
			System.out.println(abm.traerUsuario(idUsuario2));
			
			limpiarPantalla();//10 enters
	
			Usuario Usuario=abm.traerUsuario(idUsuario);
			
			Usuario.setNombre("Agustin");
			abm.modificarUsuario(Usuario);
			System.out.println(abm.traerUsuario(idUsuario));
	
			limpiarPantalla();//10 enters
			
			abm.modificarNombreUsuario(Usuario,"ale191");
			System.out.println(abm.traerUsuario(idUsuario));
	
			limpiarPantalla();//10 enters
			
			long idUsuario3=abm.agregarUsuario("Fernando","Berritella",false,17801032,"Fer","789");
			System.out.println(abm.traerUsuario(idUsuario3));
			
			
			System.out.println(abm.traerUsuario(idUsuario));
			abm.eliminarUsuario(idUsuario);
			System.out.println(abm.traerUsuario(idUsuario)); //no esta el boolean en el toString pero se setea en 1 la baja
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
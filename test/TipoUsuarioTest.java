package test;

import datos.TipoUsuario;
import negocio.TipoUsuarioABM;

public class TipoUsuarioTest {//funciona
	
	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){
		
		TipoUsuarioABM abm = new TipoUsuarioABM();
		
		try{	
			
			long idTipoUsuario=1;
			long idTipoUsuario2=2;
			
			System.out.println(abm.traerTipoUsuario(idTipoUsuario));
			System.out.println(abm.traerTipoUsuario(idTipoUsuario2));
			limpiarPantalla();
			System.out.println(abm.traerTipoUsuarios());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

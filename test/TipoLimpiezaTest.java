package test;

import datos.TipoLimpieza;
import negocio.TipoLimpiezaABM;

public class TipoLimpiezaTest {//funciona
	
	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){
		
		TipoLimpiezaABM abm = new TipoLimpiezaABM();
		
		try{
		
			
			String descripcion="Limpieza general";
			
			
			long idTipoLimpieza=abm.agregarTipoLimpieza(descripcion);//objeto1
			System.out.println(abm.traerTipoLimpieza(idTipoLimpieza));
			
			limpiarPantalla();//10 enters
			
			TipoLimpieza t= new TipoLimpieza("Limpieza de los baños");
			long idTipoLimpieza2=abm.agregarTipoLimpieza(t);//objeto1
			System.out.println(abm.traerTipoLimpieza(idTipoLimpieza2));
			
			limpiarPantalla();//10 enters

			TipoLimpieza TipoLimpieza=abm.traerTipoLimpieza(idTipoLimpieza);
			
			TipoLimpieza.setDescripcion("Limpieza de alfombras");
			abm.modificarTipoLimpieza(TipoLimpieza);
			System.out.println(abm.traerTipoLimpieza(idTipoLimpieza));
	
			limpiarPantalla();//10 enters
			
			abm.agregarTipoLimpieza("Barrida general");
			System.out.println(abm.traerTipoLimpiezas());
			
			
			limpiarPantalla();//10 enters
			
			System.out.println(abm.traerTipoLimpiezas());
			abm.eliminarTipoLimpieza(abm.traerTipoLimpieza(idTipoLimpieza));
			System.out.println(abm.traerTipoLimpiezas());
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

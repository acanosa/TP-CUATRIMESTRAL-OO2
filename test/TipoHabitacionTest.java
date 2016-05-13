package test;

import java.util.GregorianCalendar;

import datos.TipoHabitacion;
import negocio.TipoHabitacionABM;

public class TipoHabitacionTest {//funciona
	
	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){
		
		TipoHabitacionABM abm = new TipoHabitacionABM();
		
		try{
		
			
			String descripcion="Habitacion 2 baños 2 camas";
			float precioTemporadaAlta= 1000f;
			float precioTemporadaBaja=500f;
			
			
			long idTipoHabitacion=abm.agregarTipoHabitacion(descripcion, precioTemporadaAlta, precioTemporadaBaja);//objeto1
			System.out.println(abm.traerTipoHabitacion(idTipoHabitacion));
			
			limpiarPantalla();//10 enters
			
			TipoHabitacion t= new TipoHabitacion("Habitacion vip", 10000f, 6000f);
			long idTipoHabitacion2=abm.agregarTipoHabitacion(t);//objeto1
			System.out.println(abm.traerTipoHabitacion(idTipoHabitacion2));
			
			limpiarPantalla();//10 enters

			TipoHabitacion TipoHabitacion=abm.traerTipoHabitacion(idTipoHabitacion);
			
			TipoHabitacion.setPrecioTemporadaAlta(15000f);
			abm.modificarTipoHabitacion(TipoHabitacion);
			System.out.println(abm.traerTipoHabitacion(idTipoHabitacion));
	
			limpiarPantalla();//10 enters
			
			abm.agregarTipoHabitacion("Habitacion 1 baño 2 camas", 800f, 200f);
			System.out.println(abm.traerTipoHabitaciones());
			
			
			limpiarPantalla();//10 enters
			
			System.out.println(abm.traerTipoHabitaciones());
			abm.eliminarTipoHabitacion(abm.traerTipoHabitacion(idTipoHabitacion));
			System.out.println(abm.traerTipoHabitaciones());
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

package test;

import datos.Habitacion;
import negocio.HabitacionABM;

public class HabitacionTest {//funciona
	
	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){
		
		HabitacionABM abm = new HabitacionABM();
		
		try{	
			
			long idHabitacion=1;
			
			System.out.println(abm.traerHabitacion(idHabitacion));
			
			Habitacion h= abm.traerHabitacion(idHabitacion);
			h.setCapacidadMaxima(7);
			abm.modificar(h);
			
			System.out.println(abm.traerHabitacion(h.getIdHabitacion()));
			
			limpiarPantalla();
			
			System.out.println(abm.traerHabitaciones());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

package test;

import datos.Habitacion;
import negocio.HabitacionABM;

public class TestHabitacion {
	
	public static void main(String args[]) throws Exception //funciona
	{
		try{
			HabitacionABM abm=new HabitacionABM();
			Habitacion h=abm.traerHabitacion(1);
			System.out.println(abm.traerHabitacion());
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("Habitacion 3--> "+ abm.traerHabitacion(3));
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("\n");
			//System.out.println("Habitacion 3 estadias -->" +abm.)
			System.out.println("anterior --> " +abm.traerHabitacion(h.getIdHabitacion()));
			h.setPrecioNoche(360);
			h.setPrecioTemporada(3670);
			abm.modificar(h);
			System.out.println("modificada --> " +abm.traerHabitacion(h.getIdHabitacion()));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
	}

}

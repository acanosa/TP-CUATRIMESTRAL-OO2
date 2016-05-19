package test;

import negocio.HabitacionABM;

public class HabitacionTest {
	
	public static void main(String args[]) throws Exception{
		
		HabitacionABM abm=new HabitacionABM();
		
		try{
			
			System.out.println(abm.traerHabitaciones());
			//System.out.println("Usuario: " + abm.traerHabitacion(1));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

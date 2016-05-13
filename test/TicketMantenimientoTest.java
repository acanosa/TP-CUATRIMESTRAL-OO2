package test;

import java.util.GregorianCalendar;

import datos.TicketMantenimiento;
import negocio.TicketMantenimientoABM;

public class TicketMantenimientoTest {//funciona

	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){
		
		TicketMantenimientoABM abm = new TicketMantenimientoABM();
		
		try{
		
			
			boolean reparado=false;
			String observacion="En curso";
			String problema="Cañeria rota";
			String lugar="Baño";
			GregorianCalendar fechaGeneracion= new GregorianCalendar();
			GregorianCalendar fechaInicio= new GregorianCalendar();
			GregorianCalendar fechaFin= new GregorianCalendar();
			
			
			long idTicketMantenimiento=abm.agregarTicketMantenimiento(fechaGeneracion, lugar, problema, observacion, reparado, fechaInicio, fechaFin);//objeto1
			System.out.println(abm.traerTicketMantenimiento(idTicketMantenimiento));
			
			limpiarPantalla();//10 enters
			
			TicketMantenimiento t= new TicketMantenimiento(fechaGeneracion, "Entrada", "Alfombra rota","En curso",false , fechaInicio, fechaFin);
			long idTicketMantenimiento2=abm.agregarTicketMantenimiento(t);//objeto1
			System.out.println(abm.traerTicketMantenimiento(idTicketMantenimiento2));
			
			limpiarPantalla();//10 enters

			TicketMantenimiento TicketMantenimiento=abm.traerTicketMantenimiento(idTicketMantenimiento);
			
			TicketMantenimiento.setReparado(true);
			TicketMantenimiento.setObservacion("Terminado");
			abm.modificarTicketMantenimiento(TicketMantenimiento);
			System.out.println(abm.traerTicketMantenimiento(idTicketMantenimiento));
	
			limpiarPantalla();//10 enters
			
			abm.agregarTicketMantenimiento(fechaGeneracion, "Comedor", "Luz rota","En curso",false , fechaInicio, fechaFin);
			System.out.println(abm.traerTicketsMantenimiento());
			
			
			limpiarPantalla();//10 enters
			
			System.out.println(abm.traerTicketsMantenimiento());
			abm.eliminarTicketMantenimiento(abm.traerTicketMantenimiento(idTicketMantenimiento));
			System.out.println(abm.traerTicketsMantenimiento());
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}

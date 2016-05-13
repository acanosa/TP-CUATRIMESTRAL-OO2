package test;

import java.util.GregorianCalendar;

import datos.TicketLimpieza;
import negocio.TicketLimpiezaABM;

public class TicketLimpiezaTest {//funciona
	
	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){
		
		TicketLimpiezaABM abm = new TicketLimpiezaABM();
		
		try{
		
			
			boolean realizado=false;
			GregorianCalendar fecha= new GregorianCalendar();
			
			
			
			long idTicketLimpieza=abm.agregarTicketLimpieza(fecha,realizado);//objeto1
			System.out.println(abm.traerTicketLimpieza(idTicketLimpieza));
			
			limpiarPantalla();//10 enters
			
			TicketLimpieza t= new TicketLimpieza(false, new GregorianCalendar());
			long idTicketLimpieza2=abm.agregarTicketLimpieza(t);//objeto1
			System.out.println(abm.traerTicketLimpieza(idTicketLimpieza2));
			
			limpiarPantalla();//10 enters

			TicketLimpieza TicketLimpieza=abm.traerTicketLimpieza(idTicketLimpieza);
			
			TicketLimpieza.setRealizado(true);
			abm.modificarTicketLimpieza(TicketLimpieza);
			System.out.println(abm.traerTicketLimpieza(idTicketLimpieza));
	
			limpiarPantalla();//10 enters
			
			abm.agregarTicketLimpieza(new GregorianCalendar(2016,4,16),false);
			System.out.println(abm.traerTicketsLimpieza());
			
			
			limpiarPantalla();//10 enters
			
			System.out.println(abm.traerTicketsLimpieza());
			abm.eliminarTicketLimpieza(abm.traerTicketLimpieza(idTicketLimpieza));
			System.out.println(abm.traerTicketsLimpieza());
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

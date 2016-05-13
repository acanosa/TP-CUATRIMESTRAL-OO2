package test;

import java.util.GregorianCalendar;

import datos.TicketConsumo;
import negocio.TicketConsumoABM;

public class TicketConsumoTest {//funciona
	
	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){
		
		TicketConsumoABM abm = new TicketConsumoABM();
		
		try{
		
			float precio=25;
			String descripcion="1 Coca - Cola";
			GregorianCalendar fecha= new GregorianCalendar();
			
			
			
			long idTicketConsumo=abm.agregarTicketConsumo(descripcion,precio,fecha);//objeto1
			System.out.println(abm.traerTicketConsumo(idTicketConsumo));
			
			limpiarPantalla();//10 enters
			
			TicketConsumo t= new TicketConsumo("1 Agua" , 30, new GregorianCalendar());
			long idTicketConsumo2=abm.agregarTicketConsumo(t);//objeto1
			System.out.println(abm.traerTicketConsumo(idTicketConsumo2));
			
			limpiarPantalla();//10 enters

			TicketConsumo TicketConsumo=abm.traerTicketConsumo(idTicketConsumo);
			
			TicketConsumo.setPrecio(15);
			abm.modificarTicketConsumo(TicketConsumo);
			System.out.println(abm.traerTicketConsumo(idTicketConsumo));
	
			limpiarPantalla();//10 enters
			
			abm.agregarTicketConsumo("1 alfajor", 20, fecha);
			System.out.println(abm.traerTicketsConsumo());
			
			
			limpiarPantalla();//10 enters
			
			System.out.println(abm.traerTicketsConsumo());
			abm.eliminarTicketConsumo(abm.traerTicketConsumo(idTicketConsumo));
			System.out.println(abm.traerTicketsConsumo());
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

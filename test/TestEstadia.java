package test;

import java.util.GregorianCalendar;

import datos.Estadia;
import negocio.EstadiaABM;

public class TestEstadia {

	public static void main(String args[]) throws Exception //funciona
	{
		EstadiaABM abm=new EstadiaABM();
		
		try{
		GregorianCalendar fechaInicio = new GregorianCalendar(2016,1,10);
		GregorianCalendar fechaFin = new GregorianCalendar(2016,1,25);
		GregorianCalendar fechaPedido= new GregorianCalendar(2016,0,19);
		boolean facturado=false;
		
		long id=abm.agregar(fechaInicio, fechaFin, fechaPedido, facturado);
		
		System.out.println(abm.traerEstadia(id));
		
		GregorianCalendar fechaInicio2 = new GregorianCalendar(2016,3,10);
		GregorianCalendar fechaFin2 = new GregorianCalendar(2016,4,20);
		GregorianCalendar fechaPedido2= new GregorianCalendar(2016,2,20);
		boolean facturado2=false;
		
		Estadia estadia=new Estadia(fechaInicio2,fechaFin2,fechaPedido2,facturado2);
		
		abm.agregar(estadia);
		System.out.println(abm.traerEstadia(estadia.getIdEstadia()));
		
		GregorianCalendar extension= new GregorianCalendar(2016,5,30);
		
		abm.extenderEstadia(estadia, extension);
		System.out.println(abm.traerEstadia(estadia.getIdEstadia()));
		
		abm.cancelarEstadia(abm.traerEstadia(id));
		System.out.println(abm.traerEstadias());
		
		
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	
}

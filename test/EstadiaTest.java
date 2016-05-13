package test;

import java.util.GregorianCalendar;

import datos.Estadia;
import negocio.EstadiaABM;

public class EstadiaTest {// funciona
	
	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){
		
		EstadiaABM abm = new EstadiaABM();
		
		try{
		
			GregorianCalendar fechaCheckIn= new GregorianCalendar();
			GregorianCalendar fechaCheckOut= new GregorianCalendar(2016,9,25);
			GregorianCalendar fechaPedido= new GregorianCalendar();
			boolean facturado=false;
			
			
			
			long idEstadia=abm.agregarEstadia(fechaCheckIn,fechaCheckOut,fechaPedido,facturado);//objeto1
			System.out.println(abm.traerEstadia(idEstadia));
			
			
			
			Estadia e= new Estadia(fechaCheckIn,fechaCheckOut,new GregorianCalendar(2016,2,22),facturado); //objeto 2
			long idEstadia2=abm.agregarEstadia(e);
			System.out.println(abm.traerEstadia(idEstadia2));
			
	
			limpiarPantalla();//10 enters
			
			GregorianCalendar extender=new GregorianCalendar(2016,10,25);
			Estadia e2=abm.traerEstadia(idEstadia2);
			abm.extenderEstadia(e2, extender);
			System.out.println(abm.traerEstadia(idEstadia2));
			
			limpiarPantalla();//10 enters
			
			System.out.println(abm.traerEstadias());
			abm.cancelarEstadia(e);
			System.out.println(abm.traerEstadias());
			
			System.out.println(abm.traerEstadia(idEstadia2));
			e.setFacturado(true);		//modifico objeto 2, muestro antes/despues
			abm.modificarEstadia(e);
			System.out.println(abm.traerEstadia(idEstadia2));
			
			limpiarPantalla();
			
			System.out.println(abm.traerEstadias());
			abm.eliminarEstadia(abm.traerEstadia(idEstadia));//muestro lista objetos y elimino 1
			System.out.println(abm.traerEstadias()); //vuelvo a mostrar lista
			
			//probar que pasa si estadia fechaCheckOut tiene fecha menor a la actual
			Estadia e3= new Estadia(new GregorianCalendar(2015,3,1),new GregorianCalendar(2015,3,16),new GregorianCalendar(2015,2,22),true); //objeto 2
			abm.agregarEstadia(e3);
			abm.cancelarEstadia(e3);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

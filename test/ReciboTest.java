package test;

import java.util.GregorianCalendar;

import datos.Recibo;
import negocio.ReciboABM;

public class ReciboTest {  //funciona todo
	
	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){ //
		
		ReciboABM abm = new ReciboABM();
		
		try{
		
			GregorianCalendar fecha= new GregorianCalendar();
			float importe=25;
			String formaPago="efectivo";
			
			
			
			long idRecibo=abm.agregarRecibo(fecha,importe,formaPago);//objeto1
			System.out.println(abm.traerRecibo(idRecibo));
			
			limpiarPantalla();//10 enters
			
			Recibo Recibo=abm.traerRecibo(idRecibo);
			
			Recibo.setImporte(10000);
			abm.modificarRecibo(Recibo);
			System.out.println(abm.traerRecibo(idRecibo));
	
			limpiarPantalla();//10 enters
			
			abm.agregarRecibo(fecha, 600, "tarjeta debito");
			System.out.println(abm.traerRecibos());
			
			
			limpiarPantalla();//10 enters
			
			System.out.println(abm.traerRecibos());
			abm.eliminarRecibo(abm.traerRecibo(idRecibo));
			System.out.println(abm.traerRecibos());
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}

package test;

import java.util.GregorianCalendar;

import datos.Factura;
import negocio.FacturaABM;
import funciones.Funciones;

public class FacturaTest { //testear traerListasFactura y pagar factura (posible controlador)
	
	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){
		
		FacturaABM abm = new FacturaABM();
		
		try{
			GregorianCalendar fecha=new GregorianCalendar();
			float total=3.4f;
			boolean facturada=false;
			
			
			long idFactura=abm.agregarFactura(fecha,total,facturada);// f1
			
			
			Factura f= new Factura(fecha,total,facturada);//f2
			long idFactura2=abm.agregarFactura(f);
			
			
			System.out.println(abm.traerFactura(idFactura));
			limpiarPantalla();
			float modificar= 2348.25f;//para f2!
			
			
			f.setTotal(modificar);
			abm.modificarFactura(f);
			Factura f2= new Factura(f.getFecha(),f.getTotal(),f.isPagado()); //f3
			f2.setTotal(total + 300.00f);
			
			System.out.println(abm.traerFactura(f.getIdFactura()));
			limpiarPantalla();
			
			String descripcion2="Reservada";
			long id2= abm.agregarFactura(f2);
			System.out.println(abm.traerFactura(id2));
			
			//limpiarPantalla();
			
			//System.out.println(abm.traerListasFactura(idFactura));
			
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

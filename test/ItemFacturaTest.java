package test;

import java.util.GregorianCalendar;

import datos.ItemFactura;
import negocio.ItemFacturaABM;

public class ItemFacturaTest { //funciona todo
	

	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){
		
		ItemFacturaABM abm = new ItemFacturaABM();
		
		try{
		
			String detalle="Coca Cola";
			float importe=21f;
			int cantidad=2;
			
			
			
			long idItemFactura=abm.agregarItemFactura(detalle,importe,cantidad);//objeto1
			System.out.println(abm.traerItemFactura(idItemFactura));
			
			
			
			ItemFactura i= new ItemFactura("Seven up",importe,3); //objeto 2
			long idItemFactura2=abm.agregarItemFactura(i);
			
	
			limpiarPantalla();//10 enters
			
			
			String modificar="Agua";
			System.out.println(abm.traerItemFactura(idItemFactura2));
			i.setDetalle(modificar);		//modifico objeto 2, muestro antes/despues
			abm.modificarItemFactura(i);
			System.out.println(abm.traerItemFactura(idItemFactura2));
			
			limpiarPantalla();
			
			System.out.println(abm.traerItemFacturas());
			abm.eliminarItemFactura(idItemFactura);//muestro lista objetos y elimino 1
			System.out.println(abm.traerItemFacturas()); //vuelvo a mostrar lista
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

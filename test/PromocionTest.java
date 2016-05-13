package test;

import java.util.GregorianCalendar;

import datos.Promocion;
import negocio.PromocionABM;

public class PromocionTest {
	
	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){ //funciona todo
		
		PromocionABM abm = new PromocionABM();
		
		try{
		
			GregorianCalendar fechaInicio= new GregorianCalendar();
			GregorianCalendar fechaFin= new GregorianCalendar();
			float descuento=25;
			
			
			
			long idPromocion=abm.agregarPromocion(fechaInicio, fechaFin, descuento);//objeto1
			System.out.println(abm.traerPromocion(idPromocion));
			
			limpiarPantalla();//10 enters
			
			Promocion Promocion=abm.traerPromocion(idPromocion);
			
			Promocion.setDescuento(10);
			abm.modificarPromocion(Promocion);
			System.out.println(abm.traerPromocion(idPromocion));
	
			limpiarPantalla();//10 enters
			
			abm.agregarPromocion(fechaInicio, fechaFin, 99);
			System.out.println(abm.traerPromociones());
			
			
			limpiarPantalla();//10 enters
			
			System.out.println(abm.traerPromociones());
			abm.eliminarPromocion(abm.traerPromocion(idPromocion));
			System.out.println(abm.traerPromociones());
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

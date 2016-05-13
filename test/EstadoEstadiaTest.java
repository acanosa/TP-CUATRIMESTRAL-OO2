package test;

import negocio.EstadoEstadiaABM;
import datos.EstadoEstadia;

public class EstadoEstadiaTest {
	
	public static void main(String args[]) throws Exception{ //funciona todo
		
		EstadoEstadiaABM abm = new EstadoEstadiaABM();
		
		try{
			String descripcion="Reservada";
			
			long idEstadoEstadia=abm.agregarEstadoEstadia(descripcion);
			
			System.out.println(abm.traerEstadoEstadia(idEstadoEstadia));
			
			EstadoEstadia e= abm.traerEstadoEstadia(idEstadoEstadia);
			String modificar="cancelada";
			e.setDescripcion(modificar);
			abm.modificarEstadoEstadia(e);
			System.out.println(abm.traerEstadoEstadia(e.getIdEstadoEstadia()));
			
			String descripcion2="Reservada";
			long id2= abm.agregarEstadoEstadia(descripcion2);
			System.out.println(abm.traerEstadoEstadia(id2));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

package test;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.EstadiaABM;

public class TestCliente {
	
	public static void main(String args[]) throws Exception //funciona todo el abm
	{
		ClienteABM abm= new ClienteABM();
		
		try{
		String nombre="Alejandro";
		String apellido="Canosa";
		int dni=38701487;
		
		long id= abm.agregar(apellido, nombre, dni);//funciona excepcion con dni
		
		System.out.println(abm.traerCliente(id));
		System.out.println("\n");
		System.out.println("\n");
		
		
		Cliente c=new Cliente("Mariano","Loguercio",37501487);
		abm.agregar(c);
		
		System.out.println(abm.traerCliente(c.getIdCliente()));
		System.out.println("\n");
		System.out.println("\n");
	
		System.out.println(abm.traerClientes());
		System.out.println("\n");
		System.out.println("\n");
		
		
	
		System.out.println(abm.traerCliente(dni));
		
		abm.eliminar(c.getIdCliente());
		System.out.println("\n");
		System.out.println("\n");
	
		System.out.println(abm.traerClientes());
		System.out.println("\n");
		System.out.println("\n");
		
		Cliente c2=abm.traerCliente(38701487);
		c2.setDni(39845321);
		abm.modificar(c2);
		System.out.println(abm.traerCliente(c2.getIdCliente()));
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}

}

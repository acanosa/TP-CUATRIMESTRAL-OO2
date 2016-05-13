package test;

import datos.Cliente;
import negocio.ClienteABM;

public class ClienteTest {//funciona
	
	public static void limpiarPantalla()
	{
		for(int i=0; i<10;i++){
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){
		
		ClienteABM abm = new ClienteABM();
		
		try{
		
			String nombre="Alejandro";
			String apellido="Canosa";
			int dni=38701487;
			
			
			
			long idCliente=abm.agregarCliente(nombre,apellido,dni);//objeto1
			System.out.println(abm.traerCliente(idCliente));
			
			
			
			Cliente c= new Cliente("Gonzalo","Berro",39807132); //objeto 2
			long idCliente2=abm.agregarCliente(c);
			System.out.println(abm.traerCliente(39807132));
			
	
			limpiarPantalla();//10 enters
			
			System.out.println(abm.traerCliente(idCliente2));
			c.setNombre("Martin");		//modifico objeto 2, muestro antes/despues
			abm.modificarCliente(c);
			System.out.println(abm.traerCliente(idCliente2));
			
			limpiarPantalla();
			
			System.out.println(abm.traerClientes());
			abm.eliminarCliente(idCliente);//muestro lista objetos y elimino 1, setea boolean en true
			System.out.println(abm.traerClientes()); //vuelvo a mostrar lista
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

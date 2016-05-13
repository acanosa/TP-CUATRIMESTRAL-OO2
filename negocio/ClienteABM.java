package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.TicketConsumo;

public class ClienteABM {
	ClienteDao dao=new ClienteDao();
	
	public Cliente traerCliente(long idCliente)throws Exception{
		Cliente c= dao.traerCliente(idCliente);
		if(c==null) throw new Exception("ERROR: No se encuentra el cliente con id "+idCliente);
		return c;
	}
	
	public Cliente traerCliente(int dni) throws Exception{
		
		Cliente c=dao.traerCliente(dni);
		if(c==null) throw new Exception ("ERROR: No se encuentra el cliente con dni= " +dni);
		return c;
		
	}
	
	public long agregar(String apellido, String nombre, int dni)throws Exception{
		if(dao.traerCliente(dni)!=null) throw new Exception("ERROR: Ya existe un cliente con ese dni "+dni);
		Cliente c=new Cliente(nombre, apellido,dni);
		
		return dao.agregarCliente(c);
	}
	
	public long agregar(Cliente c)throws Exception{
		if(dao.traerCliente(c.getDni())!=null) throw new Exception("ERROR: Ya existe un cliente con ese dni "+c.getDni());
		return dao.agregarCliente(c);
	}
	
	public void modificar(Cliente c)throws Exception{
	if(dao.traerCliente(c.getDni())!=null && dao.traerCliente(c.getIdCliente())!=null) throw new Exception("ERROR: Ya existe un cliente con dni "+c.getDni()+" y el mismo id "+c.getIdCliente());
		dao.actualizarCliente(c);
	}
	
	public  void eliminar(long l)throws Exception{
		Cliente c=dao.traerCliente(l);
		if(c==null) throw new Exception("ERROR: No se encuentra el cliente con id "+l);
		dao.eliminarCliente(c);
	}

	public List<Cliente> traerClientes(){
		return dao.traerClientes();
	}
}

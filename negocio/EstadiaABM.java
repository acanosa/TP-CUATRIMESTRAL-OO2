package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.ClienteDao;
import dao.EstadiaDao;
import datos.Cliente;
import datos.Estadia;
import datos.EstadoEstadia;
import datos.Habitacion;
import datos.TicketConsumo;
import funciones.Funciones;

public class EstadiaABM {
	
	EstadiaDao dao=new EstadiaDao();
	
	public Estadia traerEstadia(long idEstadia)throws Exception{
		Estadia e= dao.traerEstadia(idEstadia);
		if(e==null) throw new Exception("ERROR: No se encuentra la estadia con ese id "+idEstadia);// implementar si c es null lanzar Exception
		return e;
}
	public long agregar(GregorianCalendar fechaCheckIn, GregorianCalendar fechaCheckOut, GregorianCalendar fechaPedido,boolean facturado)throws Exception{
		Estadia e=new Estadia(fechaCheckIn,  fechaCheckOut, fechaPedido, facturado);
		
		return dao.agregarEstadia(e);
	}
	
	public long agregar(Estadia e)throws Exception
	{
		if(e==null) throw new Exception ("ERROR: objeto nulo");
		return dao.agregarEstadia(e);
	}
	
	
	public void eliminarEstadia(Estadia estadia)throws Exception{
		
		dao.eliminarEstadia(estadia);
		
	}
	
	public Estadia traerEstadiaYHabitaciones(long idEstadia)
	{
		return dao.traerEstadiaYHabitaciones(idEstadia);
	}
	
	public void extenderEstadia(Estadia estadia, GregorianCalendar fechaCheckOut)
	{
		estadia.setFechaCheckOut(fechaCheckOut);
		dao.actualizarEstadia(estadia);
	}
	
	public void cancelarEstadia(Estadia estadia) throws Exception
	{
		eliminarEstadia(estadia);
	}
	
	public List<Estadia> traerEstadias()
	{
		return dao.traerEstadias();
	}
	
	public EstadoEstadia obtenerEstado(Estadia estadia) throws Exception{
		if(dao.traerEstadoEstadia(estadia) == null) throw new Exception ("ERROR: estadia sin estado");
		return dao.traerEstadoEstadia(estadia);
	}

}
package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.TicketMantenimientoDao;
import datos.TicketMantenimiento;

public class TicketMantenimientoABM {
	
TicketMantenimientoDao dao=new TicketMantenimientoDao();
	
	public long agregarTicketMantenimiento(GregorianCalendar fechaGeneracion, String lugar, String problema, String observacion, boolean reparado, GregorianCalendar fechaInicio, GregorianCalendar fechaFin)
	throws Exception
	{
		TicketMantenimiento t= new TicketMantenimiento(fechaGeneracion, lugar, problema, observacion,reparado, fechaInicio, fechaFin);
		return dao.agregarTicketMantenimiento(t);
	}
	
	public long agregarTicketMantenimiento(TicketMantenimiento t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		return dao.agregarTicketMantenimiento(t);
	}
	
	public TicketMantenimiento traerTicketMantenimiento(long idTicketMantenimiento) throws Exception
	{
		if(dao.traerTicketMantenimiento(idTicketMantenimiento)==null) throw new Exception("ERROR: no se encuentra TicketMantenimiento con ese id");
		return dao.traerTicketMantenimiento(idTicketMantenimiento);
	}
	
	public void modificarTicketMantenimiento(TicketMantenimiento t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		dao.actualizarTicketMantenimiento(t);
	}
	
	public void eliminarTicketMantenimiento(TicketMantenimiento t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		dao.eliminarTicketMantenimiento(t);
	}
	
	public List<TicketMantenimiento> traerTicketsMantenimiento()
	{
		return dao.traerTicketsMantenimiento();
	}
	
	

}

package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.TicketLimpiezaDao;
import datos.TicketLimpieza;

public class TicketLimpiezaABM {
	
	TicketLimpiezaDao dao=new TicketLimpiezaDao();
	
	public long agregarTicketLimpieza(GregorianCalendar fecha, boolean realizado)
	{
		TicketLimpieza t= new TicketLimpieza(realizado,fecha);
		return dao.agregarTicketLimpieza(t);
	}
	
	public long agregarTicketLimpieza(TicketLimpieza t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		return dao.agregarTicketLimpieza(t);
	}
	
	public TicketLimpieza traerTicketLimpieza(long idTicketLimpieza) throws Exception
	{
		if(dao.traerTicketLimpieza(idTicketLimpieza)==null) throw new Exception("ERROR: no se encuentra TicketLimpieza con ese id");
		return dao.traerTicketLimpieza(idTicketLimpieza);
	}
	
	public void modificarTicketLimpieza(TicketLimpieza t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		dao.actualizarTicketLimpieza(t);
	}
	
	public void eliminarTicketLimpieza(TicketLimpieza t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		dao.eliminarTicketLimpieza(t);
	}
	
	public List<TicketLimpieza> traerTicketsLimpieza()
	{
		return dao.traerTicketsLimpieza();
	}
	
	

}

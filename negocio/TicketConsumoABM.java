package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.TicketConsumoDao;
import datos.TicketConsumo;
import datos.TicketConsumo;

public class TicketConsumoABM {
	
	TicketConsumoDao dao=new TicketConsumoDao();
	
	public long agregarTicketConsumo(String descripcion, float precio, GregorianCalendar fecha)
	{
		TicketConsumo tc= new TicketConsumo(descripcion,precio,fecha);
		return dao.agregarTicketConsumo(tc);
	}
	
	public long agregarTicketConsumo(TicketConsumo tc) throws Exception
	{
		if(tc==null) throw new Exception("ERROR: objeto nulo");
		return dao.agregarTicketConsumo(tc);
	}
	
	public TicketConsumo traerTicketConsumo(long idTicketConsumo) throws Exception
	{
		if(dao.traerTicketConsumo(idTicketConsumo)==null) throw new Exception("ERROR: no se encuentra TicketConsumo con ese id");
		return dao.traerTicketConsumo(idTicketConsumo);
	}
	
	public void modificarTicketConsumo(TicketConsumo tc) throws Exception
	{
		if(tc==null) throw new Exception("ERROR: objeto nulo");
		dao.actualizarTicketConsumo(tc);
	}
	
	public void eliminarTicketConsumo(TicketConsumo tc) throws Exception
	{
		if(tc==null) throw new Exception("ERROR: objeto nulo");
		dao.eliminarTicketConsumo(tc);
	}
	
	public List<TicketConsumo> traerTicketsConsumo()
	{
		return dao.traerTicketsConsumo();
	}
	
	
	
}

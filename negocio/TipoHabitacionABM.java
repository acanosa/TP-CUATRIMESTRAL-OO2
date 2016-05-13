package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.TipoHabitacionDao;
import datos.TipoHabitacion;


public class TipoHabitacionABM {
	
	TipoHabitacionDao dao= new TipoHabitacionDao();
	
	public long agregarTipoHabitacion(String descripcion, float precioTemporadaAlta, float precioTemporadaBaja)
	{
		TipoHabitacion t= new TipoHabitacion(descripcion, precioTemporadaAlta, precioTemporadaBaja);
		return dao.agregarTipoHabitacion(t);
	}
	
	public long agregarTipoHabitacion(TipoHabitacion t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		return dao.agregarTipoHabitacion(t);
	}
	
	public TipoHabitacion traerTipoHabitacion(long idTipoHabitacion) throws Exception
	{
		if(dao.traerTipoHabitacion(idTipoHabitacion)==null) throw new Exception("ERROR: no se encuentra TipoHabitacion con ese id");
		return dao.traerTipoHabitacion(idTipoHabitacion);
	}
	
	public void modificarTipoHabitacion(TipoHabitacion t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		dao.actualizarTipoHabitacion(t);
	}
	
	public void eliminarTipoHabitacion(TipoHabitacion t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		dao.eliminarTipoHabitacion(t);
	}
	
	public List<TipoHabitacion> traerTipoHabitaciones()
	{
		return dao.traerTipoHabitaciones();
	}

}

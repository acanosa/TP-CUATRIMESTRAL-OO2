package negocio;

import java.util.List;

import dao.HabitacionDao;
import datos.Cliente;
import datos.Estadia;
import datos.Habitacion;

public class HabitacionABM {
	HabitacionDao dao = new HabitacionDao();
	
	public Habitacion traerHabitacion(long idHabitacion)throws Exception{
		Habitacion h= dao.traerHabitacion(idHabitacion);
		if(h==null) throw new Exception("ERROR: No se encuentra la habitacion con ese id "+idHabitacion);// implementar si c es null lanzar Exception
		return h;
	}
	
	public List<Habitacion> traerHabitaciones()throws Exception{
		return dao.traerHabitaciones();
	}
	public void modificar(Habitacion h)throws Exception{
		if(h==null) throw new Exception("ERROR: objeto nulo");
			dao.actualizar(h);
		}
	public Habitacion traerEstadias(long idHabitacion)throws Exception{
		return dao.traerEstadias(idHabitacion);
		
	}
	
}

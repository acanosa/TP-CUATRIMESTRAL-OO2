package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.EstadoEstadiaDao;
import datos.EstadoEstadia;

public class EstadoEstadiaABM {
	
		EstadoEstadiaDao dao= new EstadoEstadiaDao();
		
		public long agregarEstadoEstadia(String descripcion)
		{
			EstadoEstadia e=new EstadoEstadia(descripcion);
			return dao.agregarEstadoEstadia(e);
		}
		
		public EstadoEstadia traerEstadoEstadia(long idEstadoEstadia) throws Exception
		{
			if(dao.traerEstadoEstadia(idEstadoEstadia) == null) throw new Exception ("ERROR: no existe EstadoEstadia con ese id");
			return dao.traerEstadoEstadia(idEstadoEstadia);
		}
		
		public void modificarEstadoEstadia(EstadoEstadia e) throws Exception
		{
			if(e==null) throw new Exception("ERROR: objeto nulo");
			if(dao.traerEstadoEstadia(e.getIdEstadoEstadia()) == null) throw new Exception("ERROR: no se encuentra EstadoEstadia con ese id");
			dao.actualizarEstadoEstadia(e);
		}

}

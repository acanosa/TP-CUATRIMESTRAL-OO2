package negocio;

import java.util.List;

import dao.TipoLimpiezaDao;
import datos.TipoLimpieza;

public class TipoLimpiezaABM {

	TipoLimpiezaDao dao= new TipoLimpiezaDao();
	
	public long agregarTipoLimpieza(String descripcion)
	{
		TipoLimpieza t= new TipoLimpieza(descripcion);
		return dao.agregarTipoLimpieza(t);
	}
	
	public long agregarTipoLimpieza(TipoLimpieza t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		return dao.agregarTipoLimpieza(t);
	}
	
	public TipoLimpieza traerTipoLimpieza(long idTipoLimpieza) throws Exception
	{
		if(dao.traerTipoLimpieza(idTipoLimpieza)==null) throw new Exception("ERROR: no se encuentra TipoLimpieza con ese id");
		return dao.traerTipoLimpieza(idTipoLimpieza);
	}
	
	public void modificarTipoLimpieza(TipoLimpieza t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		dao.actualizarTipoLimpieza(t);
	}
	
	public void eliminarTipoLimpieza(TipoLimpieza t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		dao.eliminarTipoLimpieza(t);
	}
	
	public List<TipoLimpieza> traerTipoLimpiezas()
	{
		return dao.traerTipoLimpiezas();
	}
	
}

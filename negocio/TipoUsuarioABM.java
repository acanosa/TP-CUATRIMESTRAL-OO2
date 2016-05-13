package negocio;

import java.util.List;

import dao.TipoUsuarioDao;
import datos.TipoUsuario;

public class TipoUsuarioABM {
	
	TipoUsuarioDao dao= new TipoUsuarioDao();
	
	public long agregarTipoUsuario(String descripcion)
	{
		TipoUsuario t= new TipoUsuario(descripcion);
		return dao.agregarTipoUsuario(t);
	}
	
	public long agregarTipoUsuario(TipoUsuario t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		return dao.agregarTipoUsuario(t);
	}
	
	public TipoUsuario traerTipoUsuario(long idTipoUsuario) throws Exception
	{
		if(dao.traerTipoUsuario(idTipoUsuario)==null) throw new Exception("ERROR: no se encuentra TipoUsuario con ese id");
		return dao.traerTipoUsuario(idTipoUsuario);
	}
	
	public void modificarTipoUsuario(TipoUsuario t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		dao.actualizarTipoUsuario(t);
	}
	
	public void eliminarTipoUsuario(TipoUsuario t) throws Exception
	{
		if(t==null) throw new Exception("ERROR: objeto nulo");
		dao.eliminarTipoUsuario(t);
	}
	
	public List<TipoUsuario> traerTipoUsuarios()
	{
		return dao.traerTipoUsuarios();
	}
	

}

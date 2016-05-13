package negocio;

import java.util.List;

import dao.TipoUsuarioDao;
import datos.TipoUsuario;

public class TipoUsuarioABM {
	
	TipoUsuarioDao dao= new TipoUsuarioDao();
	
	public TipoUsuario traerTipoUsuario(long idTipoUsuario) throws Exception
	{
		if(dao.traerTipoUsuario(idTipoUsuario)==null) throw new Exception("ERROR: no se encuentra TipoUsuario con ese id");
		return dao.traerTipoUsuario(idTipoUsuario);
	}
	
	public List<TipoUsuario> traerTipoUsuarios()
	{
		return dao.traerTipoUsuarios();
	}
	

}

package negocio;

import dao.UsuarioDao;
import datos.Usuario;

public class UsuarioABM {
	
	UsuarioDao dao= new UsuarioDao();
	
	public Usuario traerUsuario(long idUsuario)throws Exception{
		Usuario u= dao.traerUsuario(idUsuario);
		if(u==null) throw new Exception("ERROR: No se encuentra el Usuario con id "+idUsuario);
		return u;
	}
	
	public Usuario traerUsuario(String usuario) throws Exception{
		
		Usuario u=dao.traerUsuario(usuario);
		if(u==null) throw new Exception ("ERROR: No se encuentra el Usuario con nombre= " +usuario);
		return u;	
	}
	
	public long agregar(String apellido, String nombre, int dni,String usuario, String clave)throws Exception{
		Usuario u=new Usuario(nombre, apellido,dni,usuario,clave);
		return dao.agregarUsuario(u);
	}
	
	public long agregar(Usuario u)throws Exception{
		return dao.agregarUsuario(u);
	}
	
	public void modificar(Usuario u)throws Exception{
		if(u==null) throw new Exception ("ERROR: objeto nulo");
		if(dao.traerUsuario(u.getIdUsuario()) == null) throw new Exception ("ERROR: usuario no registrado");
		dao.actualizarUsuario(u);
	}
	
	public void modificarNombreUsuario(Usuario u, String usuario) throws Exception
	{
		if(dao.traerUsuario(usuario) != null) throw new Exception ("ERROR: este usuario ya existe");
		u.setUsuario(usuario);
		dao.actualizarUsuario(u);
	}
	
	public  void eliminar(long idUsuario)throws Exception{
		Usuario u=dao.traerUsuario(idUsuario);
		if(u==null) throw new Exception("ERROR: No se encuentra el Usuario con id "+idUsuario);
		dao.eliminarUsuario(u);
	}

}

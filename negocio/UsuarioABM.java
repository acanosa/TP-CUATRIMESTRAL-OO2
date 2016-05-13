package negocio;

import dao.UsuarioDao;
import datos.Usuario;

public class UsuarioABM {
	
	UsuarioDao dao= new UsuarioDao();
	
	public Usuario traerUsuario(long idUsuario){
		Usuario u= dao.traerUsuario(idUsuario);
		return u;
	}
	
	public Usuario traerUsuario(String usuario,String clave){ //validar Login
		
		Usuario u=dao.traerUsuario(usuario, clave);
		return u;	
	}
	
	public Usuario traerUsuario(String usuario){//modificar usuario
		
		Usuario u=dao.traerUsuario(usuario);
		return u;	
	}
	
	public long agregarUsuario(String nombre, String apellido, boolean baja, int dni,String usuario, String clave)throws Exception{
		Usuario u=new Usuario(nombre, apellido,baja,dni,usuario,clave);
		return dao.agregarUsuario(u);
	}
	
	public long agregarUsuario(Usuario u)throws Exception{
		return dao.agregarUsuario(u);
	}
	
	public void modificarUsuario(Usuario u)throws Exception{
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
	
	public  void eliminarUsuario(long idUsuario)throws Exception{
		Usuario u=dao.traerUsuario(idUsuario);
		if(u==null) throw new Exception("ERROR: No se encuentra el Usuario con id "+idUsuario);
		dao.eliminarUsuario(u);
	}

}

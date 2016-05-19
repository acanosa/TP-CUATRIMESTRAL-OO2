package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.LoginDao;
import datos.Login;
import datos.Login;
import datos.Usuario;
import negocio.UsuarioABM;

public class LoginABM {
	
	LoginDao dao=new LoginDao();
	UsuarioABM abmUsuario= new UsuarioABM();
	public long agregarLogin(String usuario, String clave, int privilegio)
	{
		Login l=new Login(usuario, clave, privilegio);
		return dao.agregarLogin(l);
	}
	
	public Login traerLogin(long idLogin) throws Exception
	{
		//if(dao.traerLogin(idLogin) == null) throw new Exception ("ERROR: no existe Login con ese id");
		Login login=dao.traerLogin(idLogin);
		login= traerDatosUsuario(idLogin);
		return login;
	}
	
	public Login traerLogin(String usuario,String clave) throws Exception //para logueo
	{
		//if(dao.traerLogin(usuario,clave) == null) throw new Exception ("ERROR: usuario o clave incorrectos");
		Login login=dao.traerLogin(usuario,clave);
		login= traerDatosUsuario(login.getIdLogin());
		return login;
	}
	
	public Login traerLogin(String usuario) throws Exception //para verificar que no haya mas de 1 persona con mismo usuario
	{
		//if(dao.traerLogin(usuario,clave) == null) throw new Exception ("ERROR: usuario o clave incorrectos");
		Login login=dao.traerLogin(usuario);
		//login= traerDatosUsuario(login.getIdLogin());
		return login;
	}
	
	public Login traerDatosUsuario(long idLogin)
	{
		return dao.traerDatosUsuario(idLogin);
	}
	
	public List<Login> traerLogins()
	{
		return dao.traerLogins();
	}
	
	public void modificarLogin(Login l) throws Exception
	{
		if(l==null) throw new Exception("ERROR: objeto nulo");
		if(dao.traerLogin(l.getIdLogin()) == null) throw new Exception("ERROR: no se encuentra Login con ese id");
		dao.actualizarLogin(l);
	}
	
	
	
	

}

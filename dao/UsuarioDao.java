package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Usuario;

public class UsuarioDao {
	
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion()
	{
		session= HibernateUtil.getSessionFactory().openSession();
		tx= session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso a datos", he);
	}
	
	public long agregarUsuario(Usuario objeto) throws HibernateException
	{
		long id=0;
		try{
			iniciaOperacion();
			id= Long.parseLong(session.save(objeto).toString());
			tx.commit();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return id;
	}
	
	public Usuario traerUsuario(long idUsuario)throws HibernateException{
		Usuario u=null;
		try{
			iniciaOperacion();
			u= (Usuario) session.createQuery("from Usuario u where u.idUsuario=" +idUsuario).uniqueResult();
					
		}catch (HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return u;
	}
	
	public Usuario traerUsuario(String usuario, String clave) throws HibernateException{
		Usuario u=null;
		try{
			iniciaOperacion();
			u= (Usuario) session.createQuery("from Usuario u where u.usuario = '" + usuario+"' AND u.clave= '" + clave +"'").uniqueResult();
			
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return u;
	}
	
	public Usuario traerUsuario(String usuario) throws HibernateException{
		Usuario u=null;
		try{
			iniciaOperacion();
			u= (Usuario) session.createQuery("from Usuario u where u.usuario = '" + usuario+"'").uniqueResult();
			
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return u;
	}
	
	public void eliminarUsuario(Usuario u) throws HibernateException
	{
		
		try{
			iniciaOperacion();
			u.setBaja(true);
			session.update(u);
			tx.commit();
			
		}catch(HibernateException he){
			
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
	}
	
	public void actualizarUsuario(Usuario u) throws HibernateException{
		
		try{
			iniciaOperacion();
			session.update(u);
			tx.commit();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
	}

}

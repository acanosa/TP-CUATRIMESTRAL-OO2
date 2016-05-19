package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Login;
import datos.Login;

public class LoginDao {
	
	private static Session session;
	private  Transaction tx;
	private void iniciaOperacion() throws HibernateException
	{
		session= HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException
	{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos", he);
	}
	
	public long agregarLogin(Login objeto)
	{
		long id=0;
		try{
			iniciaOperacion();
			id= Long.parseLong(session.save(objeto).toString());
			tx.commit();
		}catch (HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return id;
	}
	
	public Login traerLogin(long idLogin) throws HibernateException
	{
		Login objeto=null;
		try{
			iniciaOperacion();
			objeto= (Login) session.createQuery("from Login l where l.idLogin= " + idLogin).uniqueResult();
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
		return objeto;	
	}
	
	public Login traerLogin(String usuario, String clave) throws HibernateException
	{
		Login objeto=null;
		try{
			iniciaOperacion();
			objeto= (Login) session.createQuery("from Login l where l.usuario= '" + usuario + "' and l.clave= '" +clave+"'").uniqueResult();
			//Hibernate.initialize(objeto.getDatosUsuario()); //traigo los datos del usuario
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
		return objeto;	
	}
	
	public Login traerLogin(String usuario) throws HibernateException
	{
		Login objeto=null;
		try{
			iniciaOperacion();
			objeto= (Login) session.createQuery("from Login l where l.usuario= '" + usuario + "'").uniqueResult();
			//Hibernate.initialize(objeto.getDatosUsuario()); //traigo los datos del usuario
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
		return objeto;	
	}
	
	public void actualizarLogin(Login objeto) throws HibernateException
	{
		try{
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
		}finally
		{
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Login> traerLogins()
	{
		List<Login> Logins=null;
		try{
			iniciaOperacion();
			Logins=session.createQuery("from Login l order by l.idLogin asc").list();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return Logins;
	}

	public Login traerDatosUsuario(long idLogin) {
		// TODO Auto-generated method stub
		Login objeto=null;
		try{
			iniciaOperacion();
			objeto= (Login) session.createQuery("from Login l where l.idLogin=" +idLogin).uniqueResult();
			Hibernate.initialize(objeto.getDatosUsuario()); //traigo los datos del usuario
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
		return objeto;	
	}
	

}

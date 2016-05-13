package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.EstadoEstadia;

public class EstadoEstadiaDao {

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
	
	public long agregarEstadoEstadia(EstadoEstadia objeto)
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
	
	public EstadoEstadia traerEstadoEstadia(long idEstadoEstadia) throws HibernateException
	{
		EstadoEstadia objeto=null;
		try{
			iniciaOperacion();
			objeto= (EstadoEstadia) session.createQuery("from EstadoEstadia e where e.idEstadoEstadia= " + idEstadoEstadia).uniqueResult();
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
		return objeto;	
	}
	
	public void actualizarEstadoEstadia(EstadoEstadia objeto) throws HibernateException
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
	
	
	
}

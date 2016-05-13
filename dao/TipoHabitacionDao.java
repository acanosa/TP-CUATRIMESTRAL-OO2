package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TipoHabitacion;

public class TipoHabitacionDao {
	
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
	
	public long agregarTipoHabitacion(TipoHabitacion objeto)
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
	
	public TipoHabitacion traerTipoHabitacion(long idTipoHabitacion) throws HibernateException
	{
		TipoHabitacion objeto=null;
		try{
			iniciaOperacion();
			objeto= (TipoHabitacion) session.createQuery("from TipoHabitacion tc where tc.idTipoHabitacion= " + idTipoHabitacion).uniqueResult();
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
		return objeto;	
	}
	
	public void actualizarTipoHabitacion(TipoHabitacion objeto) throws HibernateException
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
	
	public void eliminarTipoHabitacion(TipoHabitacion objeto) throws HibernateException
	{
		try{
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally
		{
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoHabitacion> traerTipoHabitaciones()
	{
		List<TipoHabitacion> lista=null;
		try{
			iniciaOperacion();
			lista=session.createQuery("from TipoHabitacion tc order by tc.idTipoHabitacion asc").list();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return lista;
	}

}

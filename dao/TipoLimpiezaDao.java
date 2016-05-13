package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TipoLimpieza;

public class TipoLimpiezaDao {
	
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
	
	public long agregarTipoLimpieza(TipoLimpieza objeto)
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
	
	public TipoLimpieza traerTipoLimpieza(long idTipoLimpieza) throws HibernateException
	{
		TipoLimpieza objeto=null;
		try{
			iniciaOperacion();
			objeto= (TipoLimpieza) session.createQuery("from TipoLimpieza tc where tc.idTipoLimpieza= " + idTipoLimpieza).uniqueResult();
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
		return objeto;	
	}
	
	public void actualizarTipoLimpieza(TipoLimpieza objeto) throws HibernateException
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
	
	public void eliminarTipoLimpieza(TipoLimpieza objeto) throws HibernateException
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
	public List<TipoLimpieza> traerTipoLimpiezas()
	{
		List<TipoLimpieza> lista=null;
		try{
			iniciaOperacion();
			lista=session.createQuery("from TipoLimpieza tc order by tc.idTipoLimpieza asc").list();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return lista;
	}

}

package dao;

import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Promocion;

public class PromocionDao {

	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion()
	{
		session= HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
	}
	
	private void manejaExcepcion (HibernateException he) throws HibernateException
	{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos", he);
	}
	
	public long agregarPromocion(Promocion objeto) throws HibernateException
	{
		long id=0;
		try{
			iniciaOperacion();
			id=Long.parseLong(session.save(objeto).toString());
			tx.commit();
			
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return id;
	}
	
	public Promocion traerPromocion(long idPromocion)
	{
		Promocion p=null;
		try{
			iniciaOperacion();
			p=(Promocion) session.get(Promocion.class, idPromocion);
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return p;
	}
	
	@SuppressWarnings("unchecked")
	public List<Promocion> traerPromociones() throws HibernateException
	{
		List<Promocion> promociones=null;
		try{
			iniciaOperacion();
			promociones= session.createQuery("from Promocion p order by idPromocion asc").list();
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return promociones;
	}
	
	public void actualizarPromocion(Promocion objeto) throws HibernateException
	{
		try{
			iniciaOperacion();
			session.update(objeto);
			tx.commit();	
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
	}
	
	public void eliminarPromocion(Promocion objeto) throws HibernateException
	{
		try{
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
	}
	
	
	
	
}

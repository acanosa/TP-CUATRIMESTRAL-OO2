package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TicketLimpieza;

public class TicketLimpiezaDao {
	
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
	
	public long agregarTicketLimpieza(TicketLimpieza objeto)
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
	
	public TicketLimpieza traerTicketLimpieza(long idTicketLimpieza) throws HibernateException
	{
		TicketLimpieza objeto=null;
		try{
			iniciaOperacion();
			objeto= (TicketLimpieza) session.createQuery("from TicketLimpieza t where t.idTicketLimpieza= " + idTicketLimpieza).uniqueResult();
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
		return objeto;	
	}
	
	public void actualizarTicketLimpieza(TicketLimpieza objeto) throws HibernateException
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
	
	public void eliminarTicketLimpieza(TicketLimpieza objeto) throws HibernateException
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
	public List<TicketLimpieza> traerTicketsLimpieza()
	{
		List<TicketLimpieza> ticketsLimpieza=null;
		try{
			iniciaOperacion();
			ticketsLimpieza=session.createQuery("from TicketLimpieza t order by t.idTicketLimpieza asc").list();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return ticketsLimpieza;
	}

}

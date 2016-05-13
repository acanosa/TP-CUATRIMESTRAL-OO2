package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TicketConsumo;

public class TicketConsumoDao {
	
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
	
	public long agregarTicketConsumo(TicketConsumo objeto)
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
	
	public TicketConsumo traerTicketConsumo(long idTicketConsumo) throws HibernateException
	{
		TicketConsumo objeto=null;
		try{
			iniciaOperacion();
			objeto= (TicketConsumo) session.createQuery("from TicketConsumo tc where tc.idTicketConsumo= " + idTicketConsumo).uniqueResult();
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
		return objeto;	
	}
	
	public void actualizarTicketConsumo(TicketConsumo objeto) throws HibernateException
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
	
	public void eliminarTicketConsumo(TicketConsumo objeto) throws HibernateException
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
	public List<TicketConsumo> traerTicketsConsumo()
	{
		List<TicketConsumo> ticketsConsumo=null;
		try{
			iniciaOperacion();
			ticketsConsumo=session.createQuery("from TicketConsumo tc order by tc.idTicketConsumo asc").list();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return ticketsConsumo;
	}
	
}

package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TicketMantenimiento;

public class TicketMantenimientoDao {
	
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
	
	public long agregarTicketMantenimiento(TicketMantenimiento objeto)
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
	
	public TicketMantenimiento traerTicketMantenimiento(long idTicketMantenimiento) throws HibernateException
	{
		TicketMantenimiento objeto=null;
		try{
			iniciaOperacion();
			objeto= (TicketMantenimiento) session.createQuery("from TicketMantenimiento tc where tc.idTicketMantenimiento= " + idTicketMantenimiento).uniqueResult();
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
		return objeto;	
	}
	
	public void actualizarTicketMantenimiento(TicketMantenimiento objeto) throws HibernateException
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
	
	public void eliminarTicketMantenimiento(TicketMantenimiento objeto) throws HibernateException
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
	public List<TicketMantenimiento> traerTicketsMantenimiento()
	{
		List<TicketMantenimiento> ticketsMantenimiento=null;
		try{
			iniciaOperacion();
			ticketsMantenimiento=session.createQuery("from TicketMantenimiento tc order by tc.idTicketMantenimiento asc").list();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return ticketsMantenimiento;
	}

}

package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Factura;

public class FacturaDao {
	
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
	
	public long agregarFactura(Factura objeto)
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
	
	public Factura traerFactura(long idFactura) throws HibernateException
	{
		Factura objeto=null;
		try{
			iniciaOperacion();
			objeto= (Factura) session.createQuery("from Factura f where f.idFactura= " + idFactura).uniqueResult();
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
		return objeto;	
	}
	
	public void actualizarFactura(Factura objeto) throws HibernateException
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

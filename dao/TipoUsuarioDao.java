package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TipoUsuario;

public class TipoUsuarioDao {

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
	
	public TipoUsuario traerTipoUsuario(long idTipoUsuario) throws HibernateException
	{
		TipoUsuario objeto=null;
		try{
			iniciaOperacion();
			objeto= (TipoUsuario) session.createQuery("from TipoUsuario tc where tc.idTipoUsuario= " + idTipoUsuario).uniqueResult();
		}catch(HibernateException he)
		{
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
		return objeto;	
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoUsuario> traerTipoUsuarios()
	{
		List<TipoUsuario> lista=null;
		try{
			iniciaOperacion();
			lista=session.createQuery("from TipoUsuario tc order by tc.idTipoUsuario asc").list();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return lista;
	}
	

}

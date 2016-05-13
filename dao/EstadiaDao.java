package dao;

import java.util.GregorianCalendar;
import java.util.List;

import datos.Cliente;
import datos.Estadia;
import datos.EstadoEstadia;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class EstadiaDao {
	private static Session session;
	private Transaction tx;
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public long agregarEstadia(Estadia objeto) {
		long id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	public void actualizarEstadia(Estadia objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
			}
		}
		public void eliminarEstadia(Estadia objeto) throws HibernateException {
			
			try {
				iniciaOperacion();
				session.delete(objeto);
				tx.commit();
			} catch (HibernateException he) {
				manejaExcepcion(he);
				throw he;
			} finally {
				session.close();
			}
		}
		public Estadia traerEstadia(long idEstadia) throws HibernateException {
			Estadia objeto = null;
			try {
				iniciaOperacion();
				objeto = (Estadia) session.get(Estadia.class, idEstadia);
			} finally {
				session.close();
			}
				return objeto;
		}
		
		/*public Estadia traerEstadia(GregorianCalendar fechaCheckIn)
		{
			Estadia objeto= null;
			try{
				iniciaOperacion();
				String hql="from Estadia e where e.fechaCheckIn =" +fechaCheckIn;
				objeto=(Estadia) session.createQuery(hql).uniqueResult();
				
			}
			catch(HibernateException he)
			{
				manejaExcepcion(he);
				throw he;
			}
			finally{
				session.close();
			}
			return objeto;
		}*/
		
		public Estadia traerEstadiaYHabitaciones(long idEstadia)
		{
			Estadia estadia=null;
			
			try{
				iniciaOperacion();
				String hql= "from Estadia e where e.idEstadia= "+idEstadia;
				estadia= (Estadia) session.createQuery(hql).uniqueResult();
				Hibernate.initialize(estadia.getHabitaciones());
				
			}catch(HibernateException he)
			{
				manejaExcepcion(he);
				throw he;
			}
			finally{
				session.close();
			}
			return estadia;
		}
		
		@SuppressWarnings("unchecked")
		public List<Estadia> traerEstadias()
		{
			List<Estadia> estadias=null;
			try{
				iniciaOperacion();
				estadias=session.createQuery("from Estadia e order by e.fechaCheckIn asc").list();
			}catch(HibernateException he){
				manejaExcepcion(he);
				throw he;
			}finally{
				session.close();
			}
			return estadias;
		}
		
		public EstadoEstadia traerEstadoEstadia(Estadia objeto){
			EstadoEstadia e=null;
			try{
				iniciaOperacion();
				String hql="from EstadoEstadia e where e.idEstadoEstadia=" +objeto.getEstado().getIdEstadoEstadia();
				e= (EstadoEstadia) session.createQuery(hql).uniqueResult();
			}catch(HibernateException he)
			{
				manejaExcepcion(he);
				throw he;
			}finally{
				session.close();
			}
			return e;
		}
		
		public void actualizarEstadoEstadia(EstadoEstadia objeto)
		{
			try{
				iniciaOperacion();
				session.update(objeto);
				tx.commit();
			}catch(HibernateException he){
				manejaExcepcion(he);
				throw he;
			}finally{
				session.close();
			}
		}

}

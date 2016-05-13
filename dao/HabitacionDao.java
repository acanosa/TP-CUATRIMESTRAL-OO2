package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import datos.Cliente;
import datos.Habitacion;
import datos.Estadia;

public class HabitacionDao {
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
	
	public void actualizar(Habitacion objeto) throws HibernateException {
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
		public void eliminar(Habitacion objeto) throws HibernateException {
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
		
			public Habitacion traerHabitacion(long idHabitacion) throws HibernateException {
				Habitacion objeto = null;
			try {
				iniciaOperacion();
				objeto = (Habitacion) session.get(Habitacion.class, idHabitacion);
			} finally {
				session.close();
			}
				return objeto;
		}
		
	
			@SuppressWarnings("unchecked")
				public List<Habitacion> traerHabitaciones() throws HibernateException {
				List<Habitacion> lista=null;
					try {
						iniciaOperacion();
						lista=session.createQuery("from Habitacion h order by h.idHabitacion asc").list();
					} finally {
						session.close();
					}
						return lista;
			}
			
			
			public Habitacion traerEstadias(long idHabitacion) throws HibernateException {
				Habitacion objeto=null;
				try {
					iniciaOperacion();
					objeto= (Habitacion) session.createQuery("from Habitacion h where idHabitacion=" + idHabitacion).uniqueResult();
					Hibernate.initialize(objeto.getLstEstadias());
				} finally {
					session.close();
				}
					return objeto;
		}
			
	
}

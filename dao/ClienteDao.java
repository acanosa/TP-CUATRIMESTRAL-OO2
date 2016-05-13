package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import datos.Cliente;

	public class ClienteDao {
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
		
		public long agregarCliente(Cliente objeto) {
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
		
		public void actualizarCliente(Cliente objeto) throws HibernateException {
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
			public void eliminarCliente(Cliente objeto) throws HibernateException {
				objeto.setBorrado(true);
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
			
				public Cliente traerCliente(long idCliente) throws HibernateException {
					Cliente objeto = null;
				try {
					iniciaOperacion();
					objeto = (Cliente) session.get(Cliente.class, idCliente);
				} finally {
					session.close();
				}
					return objeto;
			}
				public Cliente traerCliente(int dni) throws HibernateException {
					Cliente objeto = null;
					try {
					iniciaOperacion();
					objeto = (Cliente) session.createQuery("from Cliente c where c.dni="+dni).uniqueResult();
					} finally {
						session.close();
					}
						return objeto;
				}
			
		
				@SuppressWarnings("unchecked")
					public List<Cliente> traerClientes() throws HibernateException {
					List<Cliente> lista=null;
						try {
							iniciaOperacion();
							lista=session.createQuery("from Cliente c order by idCliente asc").list();
						} finally {
							session.close();
						}
							return lista;
				}
				
	}
	

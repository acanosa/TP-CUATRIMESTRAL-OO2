package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ItemFactura;

public class ItemFacturaDao {
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
		
		public long agregarItemFactura(ItemFactura objeto) {
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
		
		public void actualizarItemFactura(ItemFactura objeto) throws HibernateException {
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
		public void eliminarItemFactura(ItemFactura objeto) throws HibernateException {
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
			
		public ItemFactura traerItemFactura(long idItemFactura) throws HibernateException {
			ItemFactura objeto = null;
			try {
				iniciaOperacion();
				objeto = (ItemFactura) session.get(ItemFactura.class, idItemFactura);
			}catch(HibernateException he){
				manejaExcepcion(he);
				throw he;
			}finally {
				session.close();
			}
					return objeto;
			}
			
		
		@SuppressWarnings("unchecked")
		public List<ItemFactura> traerItemFacturas() throws HibernateException {
			List<ItemFactura> lista=null;
			try {
				iniciaOperacion();
				lista=session.createQuery("from ItemFactura i order by i.idItemFactura asc").list();
			} finally {
				session.close();
			}
			return lista;
		}
			

}

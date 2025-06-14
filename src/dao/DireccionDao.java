package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Direccion;

public class DireccionDao {
	private static Session session;
	private Transaction tx;
	private static DireccionDao instancia = null; // Patrón Singleton

	protected DireccionDao() {
	}

	public static DireccionDao getInstance() {
		if (instancia == null)
			instancia = new DireccionDao();
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("LOG: ERROR en la capa de acceso a datos", he);
	}

	public Direccion traer(int idDireccion) {
		Direccion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Direccion) session.createQuery("from Direccion d where d.id=:idDireccion")
						.setParameter("idDireccion", idDireccion).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Direccion> traer() throws HibernateException {
		List<Direccion> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Direccion", Direccion.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
}

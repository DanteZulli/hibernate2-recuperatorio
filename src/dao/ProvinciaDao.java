package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Provincia;

public class ProvinciaDao {
	private static Session session;
	private Transaction tx;
	private static ProvinciaDao instancia = null; // Patrón Singleton

	protected ProvinciaDao() {
	}

	public static ProvinciaDao getInstance() {
		if (instancia == null)
			instancia = new ProvinciaDao();
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

	public Provincia traer(int idProvincia) {
		Provincia objeto = null;
		try {
			iniciaOperacion();
			objeto = (Provincia) session.createQuery("from Provincia p where p.id=:idProvincia")
						.setParameter("idProvincia", idProvincia).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Provincia> traer() throws HibernateException {
		List<Provincia> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Provincia", Provincia.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
}

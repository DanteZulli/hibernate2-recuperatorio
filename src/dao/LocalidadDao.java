package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Localidad;

public class LocalidadDao {
	private static Session session;
	private Transaction tx;
	private static LocalidadDao instancia = null; // Patrón Singleton

	protected LocalidadDao() {
	}

	public static LocalidadDao getInstance() {
		if (instancia == null)
			instancia = new LocalidadDao();
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

	public Localidad traer(int idLocalidad) {
		Localidad objeto = null;
		try {
			iniciaOperacion();
			objeto = (Localidad) session.createQuery("from Localidad l where l.id=:idLocalidad")
						.setParameter("idLocalidad", idLocalidad).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Localidad> traer() throws HibernateException {
		List<Localidad> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Localidad", Localidad.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
}

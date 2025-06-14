package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Etiqueta;

public class EtiquetaDao {
	private static Session session;
	private Transaction tx;
	private static EtiquetaDao instancia = null; // Patrón Singleton

	protected EtiquetaDao() {
	}

	public static EtiquetaDao getInstance() {
		if (instancia == null)
			instancia = new EtiquetaDao();
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

	public Etiqueta traer(int idEtiqueta) {
		Etiqueta objeto = null;
		try {
			iniciaOperacion();
			objeto = (Etiqueta) session.createQuery("from Etiqueta e where e.id=:idEtiqueta")
						.setParameter("idEtiqueta", idEtiqueta).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Etiqueta> traer() throws HibernateException {
		List<Etiqueta> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Etiqueta", Etiqueta.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
}

package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Revision;

public class RevisionDao {
	private static Session session;
	private Transaction tx;
	private static RevisionDao instancia = null; // Patrón Singleton

	protected RevisionDao() {
	}

	public static RevisionDao getInstance() {
		if (instancia == null)
			instancia = new RevisionDao();
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

	public Revision traer(int idRevision) {
		Revision objeto = null;
		try {
			iniciaOperacion();
			objeto = (Revision) session.createQuery("from Revision r where r.id=:idRevision")
						.setParameter("idRevision", idRevision).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Revision> traer() throws HibernateException {
		List<Revision> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Revision", Revision.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
}

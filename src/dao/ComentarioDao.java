package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Comentario;

public class ComentarioDao {
	private static Session session;
	private Transaction tx;
	private static ComentarioDao instancia = null; // Patrón Singleton

	protected ComentarioDao() {
	}

	public static ComentarioDao getInstance() {
		if (instancia == null)
			instancia = new ComentarioDao();
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

	public Comentario traer(int idComentario) {
		Comentario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Comentario) session.createQuery("from Comentario c where c.id=:idComentario")
						.setParameter("idComentario", idComentario).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Comentario> traer() throws HibernateException {
		List<Comentario> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Comentario", Comentario.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
}

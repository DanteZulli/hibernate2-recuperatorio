package dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import datos.Comentario;

public class ComentarioDao extends Dao<Comentario> {
	private static ComentarioDao instancia = null; // Patrón Singleton

	protected ComentarioDao() {
		super();
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

	public List<Comentario> obtenerComentariosPorFechas(Timestamp fechaInicio, Timestamp fechaFin) {
		List<Comentario> comentarios = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();

			// Usamos la clase Comentario y el atributo createAt
			String hql = "FROM Comentario c WHERE c.createAt BETWEEN :fechaInicio AND :fechaFin";
			Query<Comentario> query = session.createQuery(hql, Comentario.class);
			query.setParameter("fechaInicio", fechaInicio);
			query.setParameter("fechaFin", fechaFin);

			comentarios = query.getResultList();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return comentarios;
	}

	public List<Comentario> obtenerComentarioPorFechaYMensaje(Timestamp fecha, String mensaje) {
		List<Comentario> comentarios = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			String hql = "FROM Comentario c WHERE c.createAt = :fecha AND c.mensaje = :mensaje";
			Query<Comentario> query = session.createQuery(hql, Comentario.class);
			query.setParameter("fecha", fecha);
			query.setParameter("mensaje", mensaje);
			comentarios = query.getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comentarios;
	}
}

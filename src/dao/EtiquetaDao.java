package dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import datos.Etiqueta;

public class EtiquetaDao extends Dao<Etiqueta> {
	private static EtiquetaDao instancia = null; // Patrón Singleton

	protected EtiquetaDao() {
		super();
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
	
	public List<Etiqueta> obtenerEtiquetasPorFechas(Timestamp fechaInicio, Timestamp fechaFin) {
	    List<Etiqueta> etiquetas = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        session.beginTransaction();

	        // Usamos la clase Etiqueta y el atributo createAt
	        String hql = "FROM Etiqueta e WHERE e.createAt BETWEEN :fechaInicio AND :fechaFin";
	        Query<Etiqueta> query = session.createQuery(hql, Etiqueta.class);
	        query.setParameter("fechaInicio", fechaInicio);
	        query.setParameter("fechaFin", fechaFin);

	        etiquetas = query.getResultList();

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return etiquetas;
	}
}

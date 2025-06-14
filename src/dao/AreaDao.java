package dao;

import java.util.List;

import org.hibernate.HibernateException;

import datos.Area;

public class AreaDao extends Dao<Area> {
	private static AreaDao instancia = null; // Patrón Singleton

	protected AreaDao() {
		super();
	}

	public static AreaDao getInstance() {
		if (instancia == null)
			instancia = new AreaDao();
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

	public Area traer(int idArea) {
		Area objeto = null;
		try {
			iniciaOperacion();
			objeto = (Area) session.createQuery("from Area a where a.id=:idArea")
						.setParameter("idArea", idArea).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Area> traer() throws HibernateException {
		List<Area> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Area", Area.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
}

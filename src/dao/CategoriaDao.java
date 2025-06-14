package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Categoria;

public class CategoriaDao {
	private static Session session;
	private Transaction tx;
	private static CategoriaDao instancia = null; // Patrón Singleton

	protected CategoriaDao() {
	}

	public static CategoriaDao getInstance() {
		if (instancia == null)
			instancia = new CategoriaDao();
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

	public Categoria traer(int idCategoria) {
		Categoria objeto = null;
		try {
			iniciaOperacion();
			objeto = (Categoria) session.createQuery("from Categoria c where c.id=:idCategoria")
						.setParameter("idCategoria", idCategoria).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Categoria> traer() throws HibernateException {
		List<Categoria> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Categoria", Categoria.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
}

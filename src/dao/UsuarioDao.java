package dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import datos.Usuario;

public class UsuarioDao extends Dao<Usuario> {
	private static UsuarioDao instancia = null; // Patrón Singleton

	protected UsuarioDao() {
		super();
	}

	public static UsuarioDao getInstance() {
		if (instancia == null)
			instancia = new UsuarioDao();
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

	public Usuario traer(int idUsuario) {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session.createQuery("from Usuario u where u.id=:idUsuario")
					.setParameter("idUsuario", idUsuario)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Usuario> traer() throws HibernateException {
		List<Usuario> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Usuario", Usuario.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Usuario> traerPorNombre(String nombre) throws HibernateException {
		List<Usuario> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Usuario u where u.nombre like :nombre", Usuario.class)
					.setParameter("nombre", "%" + nombre + "%")
					.list();
		} finally {
			session.close();
		}
		return lista;
	}

	public Usuario traerPorEmail(String email) throws HibernateException {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session.createQuery("from Usuario u where u.email = :email")
					.setParameter("email", email)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Usuario> traerAdministradores() throws HibernateException {
		List<Usuario> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Usuario u where u.esAdmin = true", Usuario.class)
					.list();
		} finally {
			session.close();
		}
		return lista;
	}

	public Usuario traerPorNombreUsuario(String nombreUsuario) throws HibernateException {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session.createQuery("from Usuario u where u.nombreUsuario = :nombreUsuario")
					.setParameter("nombreUsuario", nombreUsuario)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Usuario> obtenerUsuarioPorFechas(Timestamp fechaInicio, Timestamp fechaFin) {
	    List<Usuario> usuario = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        session.beginTransaction();
	        
	        // Usamos el nombre de la clase: Ticket
	        // Usamos el nombre del atributo: fechaCreacion
	        String hql = "FROM Usuario t WHERE t.createAt BETWEEN :fechaInicio AND :fechaFin";
	        Query<Usuario> query = session.createQuery(hql, Usuario.class);
	        query.setParameter("fechaInicio", fechaInicio);
	        query.setParameter("fechaFin", fechaFin);

	        usuario = query.getResultList();

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return usuario;
	}
	
	public List<Usuario> buscarPorFechaYNombre(Timestamp fecha, String nombre) {
	    List<Usuario> usuarios = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        session.beginTransaction();

	        String hql = "FROM Usuario u WHERE u.createAt = :fecha AND u.nombre = :nombre";
	        Query<Usuario> query = session.createQuery(hql, Usuario.class);
	        query.setParameter("fecha", fecha);
	        query.setParameter("nombre", nombre);

	        usuarios = query.getResultList();

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return usuarios;
	}
}

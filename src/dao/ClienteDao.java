package dao;

import java.util.List;

import org.hibernate.HibernateException;

import datos.Cliente;

public class ClienteDao extends Dao<Cliente> {
	private static ClienteDao instancia = null; // Patrón Singleton

	protected ClienteDao() {
		super();
	}

	public static ClienteDao getInstance() {
		if (instancia == null)
			instancia = new ClienteDao();
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

	public Cliente traer(int nroCliente) {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.nroCliente = :nroCliente")
					.setParameter("nroCliente", nroCliente)
					.uniqueResult();

			// Forzar carga de relaciones para evitar LazyInitializationException
			if (objeto != null && objeto.getDireccion() != null && objeto.getDireccion().getLocalidad() != null) {
				objeto.getDireccion().getLocalidad().getNombre();
			}
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Cliente> traer() throws HibernateException {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente c left join fetch c.direccion d left join fetch d.localidad l left join fetch l.provincia", Cliente.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
}

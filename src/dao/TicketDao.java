package dao;

import java.util.List;

import org.hibernate.HibernateException;

import datos.Ticket;
import datos.Usuario;
import datos.Tecnico;

public class TicketDao extends Dao<Ticket> {
	private static TicketDao instancia = null; // Patrón Singleton

	protected TicketDao() {
		super();
	}

	public static TicketDao getInstance() {
		if (instancia == null)
			instancia = new TicketDao();
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

	public Ticket traer(int idTicket) {
		Ticket objeto = null;
		try {
			iniciaOperacion();
			objeto = (Ticket) session.createQuery("from Ticket t where t.id=:idTicket")
					.setParameter("idTicket", idTicket).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Ticket> traer() throws HibernateException {
		List<Ticket> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Ticket", Ticket.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

	// Nuevos métodos de consulta
	public List<Ticket> traerPorEstado(String estado) throws HibernateException {
		List<Ticket> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Ticket t where t.estado=:estado", Ticket.class)
					.setParameter("estado", estado).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Ticket> traerPorPrioridad(String prioridad) throws HibernateException {
		List<Ticket> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Ticket t where t.prioridad=:prioridad", Ticket.class)
					.setParameter("prioridad", prioridad).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Ticket> traerPorCreador(Usuario creador) throws HibernateException {
		List<Ticket> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Ticket t where t.creador=:creador", Ticket.class)
					.setParameter("creador", creador).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Ticket> traerPorTecnico(Tecnico tecnico) throws HibernateException {
		List<Ticket> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Ticket t where t.asignado=:tecnico", Ticket.class)
					.setParameter("tecnico", tecnico).list();
		} finally {
			session.close();
		}
		return lista;
	}
}

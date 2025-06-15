package dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import datos.Ticket;

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
	
	public List<Ticket> obtenerTicketsPorFechas(Timestamp fechaInicio, Timestamp fechaFin) {
	    List<Ticket> tickets = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        session.beginTransaction();
	        
	        // Usamos el nombre de la clase: Ticket
	        // Usamos el nombre del atributo: fechaCreacion
	        String hql = "FROM Ticket t WHERE t.fechaCreacion BETWEEN :fechaInicio AND :fechaFin";
	        Query<Ticket> query = session.createQuery(hql, Ticket.class);
	        query.setParameter("fechaInicio", fechaInicio);
	        query.setParameter("fechaFin", fechaFin);

	        tickets = query.getResultList();

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return tickets;
	}
	
	public List<Ticket> obtenerTicketsPorFechaYEstado(Timestamp fecha, String estado) {
	    List<Ticket> tickets = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        session.beginTransaction();

	        // Consulta: buscamos por fecha exacta y por estado
	        String hql = "FROM Ticket t WHERE t.createAt = :fecha AND t.estado = :estado";
	        Query<Ticket> query = session.createQuery(hql, Ticket.class);
	        query.setParameter("fecha", fecha);
	        query.setParameter("estado", estado);

	        tickets = query.getResultList();

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return tickets;
	}
}

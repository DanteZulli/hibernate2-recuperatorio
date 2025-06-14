package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Ticket;

public class TicketDao {
	private static Session session;
	private Transaction tx;
	private static TicketDao instancia = null; // Patrón Singleton

	protected TicketDao() {
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
}

package negocio;

import java.util.List;

import dao.TicketDao;
import datos.Ticket;

public class TicketABM {
	private static TicketABM instancia = null; // Patrón Singleton

	protected TicketABM() {
	}

	public static TicketABM getInstance() {
		if (instancia == null)
			instancia = new TicketABM();
		return instancia;
	}

	public Ticket traer(int idTicket) {
		return TicketDao.getInstance().traer(idTicket);
	}

	public List<Ticket> traer() {
		return TicketDao.getInstance().traer();
	}

	// Alta de Ticket
	public int alta(Ticket ticket) {
		return TicketDao.getInstance().agregar(ticket);
	}

	// Baja de Ticket
	public void baja(Ticket ticket) {
		TicketDao.getInstance().eliminar(ticket);
	}

	// Modificación de Ticket
	public void modificacion(Ticket ticket) {
		TicketDao.getInstance().actualizar(ticket);
	}
}

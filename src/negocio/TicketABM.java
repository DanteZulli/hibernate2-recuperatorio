package negocio;

import java.sql.Timestamp;
import java.util.List;

import dao.TicketDao;
import datos.Ticket;
import datos.Usuario;
import datos.Tecnico;

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
<<<<<<< HEAD
	
	public List<Ticket> obtenerTicketsPorFechas(Timestamp fechaInicio, Timestamp fechaFin) throws Exception {
	    List<Ticket> tickets = TicketDao.getInstance().obtenerTicketsPorFechas(fechaInicio, fechaFin);

	    if (tickets == null || tickets.isEmpty()) {
	        throw new Exception("No se encontraron tickets en el intervalo de fechas especificado.");
	    }

	    return tickets;
	}
	
		public List<Ticket> obtenerTicketsPorFechaYEstado(Timestamp fecha, String estado) throws Exception {
	    List<Ticket> tickets = TicketDao.getInstance().obtenerTicketsPorFechaYEstado(fecha, estado);

	    if (tickets == null || tickets.isEmpty()) {
	        throw new Exception("No se encontraron tickets para la fecha y estado especificados.");
	    }

	    return tickets;
	}

	
=======

	// Nuevos métodos de consulta
	public List<Ticket> traerPorEstado(String estado) {
		return TicketDao.getInstance().traerPorEstado(estado);
	}

	public List<Ticket> traerPorPrioridad(String prioridad) {
		return TicketDao.getInstance().traerPorPrioridad(prioridad);
	}

	public List<Ticket> traerPorCreador(Usuario creador) {
		return TicketDao.getInstance().traerPorCreador(creador);
	}

	public List<Ticket> traerPorTecnico(Tecnico tecnico) {
		return TicketDao.getInstance().traerPorTecnico(tecnico);
	}
>>>>>>> 8b5b0fdf7509e7f24de0fb40358ec441f8113bcd
}

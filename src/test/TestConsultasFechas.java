package test;

import java.sql.Timestamp;
import java.util.List;

import datos.Comentario;
import datos.Etiqueta;
import datos.Ticket;
import datos.Usuario;
import negocio.ComentarioABM;
import negocio.EtiquetaABM;
import negocio.TicketABM;
import negocio.UsuarioABM;

/**
 * 1.5. Mínimo cuatro consultas por intervalo de fechas
 * 1.6. Mínimo cuatro consultas por una fecha y un atributo de clase
 */
public class TestConsultasFechas {

	public static void main(String[] args) throws Exception {

		System.out.println("=== 1.5. Mínimo cuatro consultas por intervalo de fechas ===\n");

		Timestamp fechaInicio = Timestamp.valueOf("2024-03-15 10:00:00");
		Timestamp fechaFin = Timestamp.valueOf("2025-06-14 23:59:59");
		Timestamp fechaFija = Timestamp.valueOf("2024-03-16 10:00:00");


		// 1. Tickets por intervalo de fechas
		System.out.println("Tickets por intervalo de fechas:");
		List<Ticket> tickets = TicketABM.getInstance().obtenerTicketsPorFechas(fechaInicio, fechaFin);
		for (Ticket t : tickets) {
			System.out.println(t);
		}

		// 2. Usuarios por intervalo de fechas
		System.out.println("Usuarios por intervalo de fechas:");
		List<Usuario> usuarios = UsuarioABM.getInstance().obtenerUsuarioPorFechas(fechaInicio, fechaFin);
		for (Usuario u : usuarios) {
			System.out.println(u);
		}

		// 3. Tickets por intervalo de fechas y prioridad
		System.out.println("Tickets por intervalo de fechas y prioridad 'Alta':");
		List<Ticket> ticketsAlta = TicketABM.getInstance().obtenerTicketsPorFechasYPrioridad(fechaInicio, fechaFin,
				"Alta");
		for (Ticket t : ticketsAlta) {
			System.out.println(t);
		}

		// 4. Usuarios administradores por intervalo de fechas
		System.out.println("Usuarios administradores por intervalo de fechas:");
		List<Usuario> usuariosAdmins = UsuarioABM.getInstance().obtenerUsuariosAdministradoresPorFechas(fechaInicio,
				fechaFin);
		for (Usuario u : usuariosAdmins) {
			System.out.println(u);
		}

		System.out.println("=== 1.6. Mínimo cuatro consultas por una fecha y un atributo de clase ===\n");

		// 1. Tickets por fecha y estado
		System.out.println("Tickets por fecha y estado:");
		List<Ticket> ticketsEstado = TicketABM.getInstance().obtenerTicketsPorFechaYEstado(fechaFija, "Abierto");
		for (Ticket t : ticketsEstado) {
			System.out.println(t);
		}

		// 2. Tickets por intervalo de fechas y estado
		System.out.println("Tickets por intervalo de fechas y estado 'Abierto':");
		List<Ticket> ticketsEstadoFechas = TicketABM.getInstance().obtenerTicketsPorFechasYEstado(fechaInicio, fechaFin,
				"Abierto");
		for (Ticket t : ticketsEstadoFechas) {
			System.out.println(t);
		}

		// 3. Usuarios por fecha y nombre
		System.out.println("Usuarios por fecha y nombre:");
		List<Usuario> usuariosNombre = UsuarioABM.getInstance().obtenerUsuarioPorFechaYNombre(fechaFija,
				"Juan Perez");
		for (Usuario u : usuariosNombre) {
			System.out.println(u);
		}

		// 4. Usuarios por fecha y plan
		System.out.println("Usuarios por fecha y plan:");
		List<Usuario> usuariosPlan = UsuarioABM.getInstance().obtenerUsuarioPorFechaYPlan(fechaFija, "Básico");
		for (Usuario u : usuariosPlan) {
			System.out.println(u);
		}
	}
}

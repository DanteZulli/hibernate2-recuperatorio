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

public class TestConsultasFechas {

	public static void main(String[] args) throws Exception {
		// ----------------------------------------------------------------------
		// 1.5. Mínimo cuatro consultas por intervalo de fechas
		// ----------------------------------------------------------------------
		Timestamp fechaInicio = Timestamp.valueOf("2024-03-15 10:00:00");
		Timestamp fechaFin = Timestamp.valueOf("2025-06-14 23:59:59");

		// 1. Tickets por intervalo de fechas
		List<Ticket> tickets = TicketABM.getInstance().obtenerTicketsPorFechas(fechaInicio, fechaFin);
		System.out.println("Tickets por intervalo de fechas:");
		for (Ticket t : tickets) {
			System.out.println(t);
		}

		// 2. Usuarios por intervalo de fechas
		List<Usuario> usuarios = UsuarioABM.getInstance().obtenerUsuarioPorFechas(fechaInicio, fechaFin);
		System.out.println("Usuarios por intervalo de fechas:");
		for (Usuario u : usuarios) {
			System.out.println(u);
		}

		// 3. Comentarios por intervalo de fechas
		List<Comentario> comen = ComentarioABM.getInstance().obtenerComentarioPorFechas(fechaInicio, fechaFin);
		System.out.println("Comentarios por intervalo de fechas:");
		for (Comentario c : comen) {
			System.out.println(c);
		}

		// 4. Etiquetas por intervalo de fechas
		List<Etiqueta> etiquetas = EtiquetaABM.getInstance().obtenerEtiquetaPorFechas(fechaInicio, fechaFin);
		System.out.println("Etiquetas por intervalo de fechas:");
		for (Etiqueta e : etiquetas) {
			System.out.println(e);
		}

		// ----------------------------------------------------------------------
		// 1.6. Mínimo cuatro consultas por una fecha y un atributo de clase
		// ----------------------------------------------------------------------

		// 1. Tickets por fecha y estado
		List<Ticket> ticketsEstado = TicketABM.getInstance().obtenerTicketsPorFechaYEstado(fechaFin, "Abierto");
		System.out.println("Tickets por fecha y estado:");
		for (Ticket t : ticketsEstado) {
			System.out.println(t);
		}

		// 2. Usuarios por fecha y nombre
		List<Usuario> usuariosNombre = UsuarioABM.getInstance().obtenerUsuarioPorFechaYNombre(fechaInicio, "Juan");
		System.out.println("Usuarios por fecha y nombre:");
		for (Usuario u : usuariosNombre) {
			System.out.println(u);
		}

		// 3. Comentarios por fecha y mensaje
		List<Comentario> comentariosMensaje = ComentarioABM.getInstance().obtenerComentarioPorFechaYMensaje(fechaFin,
				"Corte general");
		System.out.println("Comentarios por fecha y mensaje:");
		for (Comentario c : comentariosMensaje) {
			System.out.println(c);
		}

		// 4. Etiquetas por fecha y nombre
		List<Etiqueta> etiquetasNombre = EtiquetaABM.getInstance().obtenerEtiquetaPorFechaYNombre(fechaFin,
				"Importante");
		System.out.println("Etiquetas por fecha y nombre:");
		for (Etiqueta e : etiquetasNombre) {
			System.out.println(e);
		}
	}
}

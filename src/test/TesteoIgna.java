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

public class TesteoIgna {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		///// -----------------------------------------------------------------------------------------
		// 1.5. Mínimo cuatro consultas por intervalo de fechas
		///// -----------------------------------------------------------------------------------------
		Timestamp fechaInicio = Timestamp.valueOf("2024-03-15 10:00:00");
		Timestamp fechaFin = Timestamp.valueOf("2025-06-14 23:59:59");
		List<Ticket> tickets;
		try {
			tickets = TicketABM.getInstance().obtenerTicketsPorFechas(fechaInicio, fechaFin);
			for (Ticket t : tickets) {
				System.out.println(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		}
		// ------------------------------------------------------------------

		List<Usuario> usuario;
		try {
			usuario = UsuarioABM.getInstance().obtenerUsuarioPorFechas(fechaInicio, fechaFin);
			for (Usuario t : usuario) {
				System.out.println(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		}

		///// -----------------------------------------------------------------------------------------

		List<Comentario> comen;
		try {
			comen = ComentarioABM.getInstance().obtenerComentarioPorFechas(fechaInicio, fechaFin);
			for (Comentario t : comen) {
				System.out.println(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		}

		///// -----------------------------------------------------------------------------------------

		List<Etiqueta> etiqueta;
		try {
			etiqueta = EtiquetaABM.getInstance().obtenerEtiquetaPorFechas(fechaInicio, fechaFin);
			for (Etiqueta t : etiqueta) {
				System.out.println(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		}
		///// -----------------------------------------------------------------------------------------
		// 1.6. Mínimo cuatro consultas por una fecha y un atributo de clase
		///// -----------------------------------------------------------------------------------------

		try {
			tickets = TicketABM.getInstance().obtenerTicketsPorFechaYEstado(fechaFin, "Abierto");
			for (Ticket t : tickets) {
				System.out.println(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		}

		///// -----------------------------------------------------------------------------------------

		try {
			usuario = UsuarioABM.getInstance().obtenerUsuarioPorFechaYNombre(fechaInicio, "Juan");
			for (Usuario t : usuario) {
				System.out.println(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		}
		///// -----------------------------------------------------------------------------------------

		/*try {
		List<Comentario> comen;
		try {
			comen = ComentarioABM.getInstance().obtenerComentarioPorFechas(fechaInicio, fechaFin);
			for (Comentario t : comen) {
				System.out.println(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		}
		///// -----------------------------------------------------------------------------------------

		List<Etiqueta> etiqueta;
		try {
			etiqueta = EtiquetaABM.getInstance().obtenerEtiquetaPorFechas(fechaInicio, fechaFin);
			for (Etiqueta t : etiqueta) {
				System.out.println(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		}
		
		*/
	}

}

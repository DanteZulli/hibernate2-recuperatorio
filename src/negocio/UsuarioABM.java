package negocio;

import java.sql.Timestamp;
import java.util.List;

import dao.TicketDao;
import dao.UsuarioDao;
import datos.Ticket;
import datos.Usuario;

public class UsuarioABM {
	private static UsuarioABM instancia = null; // Patrón Singleton

	protected UsuarioABM() {
	}

	public static UsuarioABM getInstance() {
		if (instancia == null)
			instancia = new UsuarioABM();
		return instancia;
	}

	public Usuario traer(int idUsuario) {
		return UsuarioDao.getInstance().traer(idUsuario);
	}

	public List<Usuario> traer() {
		return UsuarioDao.getInstance().traer();
	}

	// Alta de Usuario
	public int alta(Usuario usuario) {
		return UsuarioDao.getInstance().agregar(usuario);
	}

	// Baja de Usuario
	public void baja(Usuario usuario) {
		UsuarioDao.getInstance().eliminar(usuario);
	}

	// Modificación de Usuario
	public void modificacion(Usuario usuario) {
		UsuarioDao.getInstance().actualizar(usuario);
	}

	// Consultas específicas
	public List<Usuario> traerPorNombre(String nombre) {
		return UsuarioDao.getInstance().traerPorNombre(nombre);
	}

	public Usuario traerPorEmail(String email) {
		return UsuarioDao.getInstance().traerPorEmail(email);
	}

	public List<Usuario> traerAdministradores() {
		return UsuarioDao.getInstance().traerAdministradores();
	}

	public Usuario traerPorNombreUsuario(String nombreUsuario) {
		return UsuarioDao.getInstance().traerPorNombreUsuario(nombreUsuario);
	}
	
	public List<Usuario> obtenerUsuarioPorFechas(Timestamp fechaInicio, Timestamp fechaFin) throws Exception {
	    List<Usuario> usuario = UsuarioDao.getInstance().obtenerUsuarioPorFechas(fechaInicio, fechaFin);

	    if (usuario == null || usuario.isEmpty()) {
	        throw new Exception("No se encontraron usuarios en el intervalo de fechas especificado.");
	    }

	    return usuario;
	}
	
	public List<Usuario> obtenerUsuarioPorFechaYNombre(Timestamp fecha, String nombre) throws Exception {
	    List<Usuario> usuario = UsuarioDao.getInstance().buscarPorFechaYNombre(fecha, nombre);

	    if (usuario == null || usuario.isEmpty()) {
	        throw new Exception("No se encontraron usuarios para la fecha y nombre especificados.");
	    }

	    return usuario;
	}
}

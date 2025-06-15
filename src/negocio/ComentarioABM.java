package negocio;

import java.sql.Timestamp;
import java.util.List;

import dao.ComentarioDao;
import dao.UsuarioDao;
import datos.Comentario;
import datos.Usuario;

public class ComentarioABM {
	private static ComentarioABM instancia = null; // Patrón Singleton

	protected ComentarioABM() {
	}

	public static ComentarioABM getInstance() {
		if (instancia == null)
			instancia = new ComentarioABM();
		return instancia;
	}

	public Comentario traer(int idComentario) {
		return ComentarioDao.getInstance().traer(idComentario);
	}

	public List<Comentario> traer() {
		return ComentarioDao.getInstance().traer();
	}

	// Alta de Comentario
	public int alta(Comentario comentario) {
		return ComentarioDao.getInstance().agregar(comentario);
	}

	// Baja de Comentario
	public void baja(Comentario comentario) {
		ComentarioDao.getInstance().eliminar(comentario);
	}

	// Modificación de Comentario
	public void modificacion(Comentario comentario) {
		ComentarioDao.getInstance().actualizar(comentario);
	}
	
	public List<Comentario> obtenerComentarioPorFechas(Timestamp fechaInicio, Timestamp fechaFin) throws Exception {
	    List<Comentario> comentario = ComentarioDao.getInstance().obtenerComentariosPorFechas(fechaInicio, fechaFin);

	    if (comentario == null || comentario.isEmpty()) {
	        throw new Exception("No se encontraron Comentarios en el intervalo de fechas especificado.");
	    }

	    return comentario;
	}
}

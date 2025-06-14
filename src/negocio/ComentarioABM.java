package negocio;

import java.util.List;

import dao.ComentarioDao;
import datos.Comentario;

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
}

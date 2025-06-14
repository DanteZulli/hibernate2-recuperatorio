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
}

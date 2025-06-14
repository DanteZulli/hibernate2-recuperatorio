package negocio;

import java.util.List;

import dao.RevisionDao;
import datos.Revision;

public class RevisionABM {
	private static RevisionABM instancia = null; // Patrón Singleton

	protected RevisionABM() {
	}

	public static RevisionABM getInstance() {
		if (instancia == null)
			instancia = new RevisionABM();
		return instancia;
	}

	public Revision traer(int idRevision) {
		return RevisionDao.getInstance().traer(idRevision);
	}

	public List<Revision> traer() {
		return RevisionDao.getInstance().traer();
	}
}

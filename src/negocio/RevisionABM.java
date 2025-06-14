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

	// Alta de Revision
	public int alta(Revision revision) {
		return RevisionDao.getInstance().agregar(revision);
	}

	// Baja de Revision
	public void baja(Revision revision) {
		RevisionDao.getInstance().eliminar(revision);
	}

	// Modificación de Revision
	public void modificacion(Revision revision) {
		RevisionDao.getInstance().actualizar(revision);
	}
}

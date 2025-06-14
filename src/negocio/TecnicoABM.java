package negocio;

import java.util.List;

import dao.TecnicoDao;
import datos.Tecnico;

public class TecnicoABM {
	private static TecnicoABM instancia = null; // Patrón Singleton

	protected TecnicoABM() {
	}

	public static TecnicoABM getInstance() {
		if (instancia == null)
			instancia = new TecnicoABM();
		return instancia;
	}

	public Tecnico traer(int idTecnico) {
		return TecnicoDao.getInstance().traer(idTecnico);
	}

	public List<Tecnico> traer() {
		return TecnicoDao.getInstance().traer();
	}

	// Alta de Tecnico
	public int alta(Tecnico tecnico) {
		return TecnicoDao.getInstance().agregar(tecnico);
	}

	// Baja de Tecnico
	public void baja(Tecnico tecnico) {
		TecnicoDao.getInstance().eliminar(tecnico);
	}

	// Modificación de Tecnico
	public void modificacion(Tecnico tecnico) {
		TecnicoDao.getInstance().actualizar(tecnico);
	}
}

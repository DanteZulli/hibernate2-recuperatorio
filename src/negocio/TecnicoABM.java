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
}

package negocio;

import java.util.List;

import dao.EtiquetaDao;
import datos.Etiqueta;

public class EtiquetaABM {
	private static EtiquetaABM instancia = null; // Patrón Singleton

	protected EtiquetaABM() {
	}

	public static EtiquetaABM getInstance() {
		if (instancia == null)
			instancia = new EtiquetaABM();
		return instancia;
	}

	public Etiqueta traer(int idEtiqueta) {
		return EtiquetaDao.getInstance().traer(idEtiqueta);
	}

	public List<Etiqueta> traer() {
		return EtiquetaDao.getInstance().traer();
	}
}

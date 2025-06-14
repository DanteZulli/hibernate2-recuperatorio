package negocio;

import java.util.List;

import dao.DireccionDao;
import datos.Direccion;

public class DireccionABM {
	private static DireccionABM instancia = null; // Patrón Singleton

	protected DireccionABM() {
	}

	public static DireccionABM getInstance() {
		if (instancia == null)
			instancia = new DireccionABM();
		return instancia;
	}

	public Direccion traer(int idDireccion) {
		return DireccionDao.getInstance().traer(idDireccion);
	}

	public List<Direccion> traer() {
		return DireccionDao.getInstance().traer();
	}
}

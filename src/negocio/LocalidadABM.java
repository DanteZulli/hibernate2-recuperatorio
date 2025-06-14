package negocio;

import java.util.List;

import dao.LocalidadDao;
import datos.Localidad;

public class LocalidadABM {
	private static LocalidadABM instancia = null; // Patrón Singleton

	protected LocalidadABM() {
	}

	public static LocalidadABM getInstance() {
		if (instancia == null)
			instancia = new LocalidadABM();
		return instancia;
	}

	public Localidad traer(int idLocalidad) {
		return LocalidadDao.getInstance().traer(idLocalidad);
	}

	public List<Localidad> traer() {
		return LocalidadDao.getInstance().traer();
	}
}

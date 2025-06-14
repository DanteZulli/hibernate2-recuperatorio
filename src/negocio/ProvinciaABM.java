package negocio;

import java.util.List;

import dao.ProvinciaDao;
import datos.Provincia;

public class ProvinciaABM {
	private static ProvinciaABM instancia = null; // Patrón Singleton

	protected ProvinciaABM() {
	}

	public static ProvinciaABM getInstance() {
		if (instancia == null)
			instancia = new ProvinciaABM();
		return instancia;
	}

	public Provincia traer(int idProvincia) {
		return ProvinciaDao.getInstance().traer(idProvincia);
	}

	public List<Provincia> traer() {
		return ProvinciaDao.getInstance().traer();
	}

	// Alta de Provincia
	public int alta(Provincia provincia) {
		return ProvinciaDao.getInstance().agregar(provincia);
	}

	// Baja de Provincia
	public void baja(Provincia provincia) {
		ProvinciaDao.getInstance().eliminar(provincia);
	}

	// Modificación de Provincia
	public void modificacion(Provincia provincia) {
		ProvinciaDao.getInstance().actualizar(provincia);
	}
}

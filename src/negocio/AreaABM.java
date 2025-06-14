package negocio;

import java.util.List;

import dao.AreaDao;
import datos.Area;

public class AreaABM {
	private static AreaABM instancia = null; // Patrón Singleton

	protected AreaABM() {
	}

	public static AreaABM getInstance() {
		if (instancia == null)
			instancia = new AreaABM();
		return instancia;
	}

	public Area traer(int idArea) {
		return AreaDao.getInstance().traer(idArea);
	}

	public List<Area> traer() {
		return AreaDao.getInstance().traer();
	}

	// Alta de Area
	public int alta(Area area) {
		return AreaDao.getInstance().agregar(area);
	}

	// Baja de Area
	public void baja(Area area) {
		AreaDao.getInstance().eliminar(area);
	}

	// Modificación de Area
	public void modificacion(Area area) {
		AreaDao.getInstance().actualizar(area);
	}
}

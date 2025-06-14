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
}

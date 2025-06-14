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

	// Alta de Direccion
	public int alta(Direccion direccion) {
		return DireccionDao.getInstance().agregar(direccion);
	}

	// Baja de Direccion
	public void baja(Direccion direccion) {
		DireccionDao.getInstance().eliminar(direccion);
	}

	// Modificación de Direccion
	public void modificacion(Direccion direccion) {
		DireccionDao.getInstance().actualizar(direccion);
	}
}

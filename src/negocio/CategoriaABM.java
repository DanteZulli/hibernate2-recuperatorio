package negocio;

import java.util.List;

import dao.CategoriaDao;
import datos.Categoria;

public class CategoriaABM {
	private static CategoriaABM instancia = null; // Patrón Singleton

	protected CategoriaABM() {
	}

	public static CategoriaABM getInstance() {
		if (instancia == null)
			instancia = new CategoriaABM();
		return instancia;
	}

	public Categoria traer(int idCategoria) {
		return CategoriaDao.getInstance().traer(idCategoria);
	}

	public List<Categoria> traer() {
		return CategoriaDao.getInstance().traer();
	}
}

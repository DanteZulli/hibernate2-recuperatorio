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

	// Alta de Categoria
	public int alta(Categoria categoria) {
		return CategoriaDao.getInstance().agregar(categoria);
	}

	// Baja de Categoria
	public void baja(Categoria categoria) {
		CategoriaDao.getInstance().eliminar(categoria);
	}

	// Modificación de Categoria
	public void modificacion(Categoria categoria) {
		CategoriaDao.getInstance().actualizar(categoria);
	}

	// Nuevo método de consulta
	public List<Categoria> traerPorNombre(String nombre) {
		return CategoriaDao.getInstance().traerPorNombre(nombre);
	}
}

package negocio;

import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	private static ClienteABM instancia = null; // Patrón Singleton

	protected ClienteABM() {
	}

	public static ClienteABM getInstance() {
		if (instancia == null)
			instancia = new ClienteABM();
		return instancia;
	}

	public Cliente traer(int idCliente) {
		return ClienteDao.getInstance().traer(idCliente);
	}

	public List<Cliente> traer() {
		return ClienteDao.getInstance().traer();
	}

	// Alta de Cliente
	public int alta(Cliente cliente) {
		return ClienteDao.getInstance().agregar(cliente);
	}

	// Baja de Cliente
	public void baja(Cliente cliente) {
		ClienteDao.getInstance().eliminar(cliente);
	}

	// Modificación de Cliente
	public void modificacion(Cliente cliente) {
		ClienteDao.getInstance().actualizar(cliente);
	}
}

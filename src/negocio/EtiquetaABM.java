package negocio;

import java.sql.Timestamp;
import java.util.List;

import dao.EtiquetaDao;
import dao.TicketDao;
import datos.Etiqueta;
import datos.Ticket;

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

	// Alta de Etiqueta
	public int alta(Etiqueta etiqueta) {
		return EtiquetaDao.getInstance().agregar(etiqueta);
	}

	// Baja de Etiqueta
	public void baja(Etiqueta etiqueta) {
		EtiquetaDao.getInstance().eliminar(etiqueta);
	}

	// Modificación de Etiqueta
	public void modificacion(Etiqueta etiqueta) {
		EtiquetaDao.getInstance().actualizar(etiqueta);
	}
	
	public List<Etiqueta> obtenerEtiquetaPorFechas(Timestamp fechaInicio, Timestamp fechaFin) throws Exception {
	    List<Etiqueta> etiqueta = EtiquetaDao.getInstance().obtenerEtiquetasPorFechas(fechaInicio, fechaFin);

	    if (etiqueta == null || etiqueta.isEmpty()) {
	        throw new Exception("No se encontraron tickets en el intervalo de fechas especificado.");
	    }

	    return etiqueta;
	}
}

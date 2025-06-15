package negocio;

import java.sql.Timestamp;
import java.util.List;

import dao.EtiquetaDao;
import datos.Etiqueta;

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

	public List<Etiqueta> obtenerEtiquetaPorFechas(Timestamp fechaInicio, Timestamp fechaFin) {
		List<Etiqueta> etiqueta = EtiquetaDao.getInstance().obtenerEtiquetasPorFechas(fechaInicio, fechaFin);

		if (etiqueta == null || etiqueta.isEmpty()) {
			System.out.println("No se encontraron etiquetas en el intervalo de fechas especificado.");
			return java.util.Collections.emptyList();
		}

		return etiqueta;
	}

	public List<Etiqueta> obtenerEtiquetaPorFechaYNombre(Timestamp fecha, String nombre) {
		List<Etiqueta> etiquetas = EtiquetaDao.getInstance().obtenerEtiquetaPorFechaYNombre(fecha, nombre);
		if (etiquetas == null || etiquetas.isEmpty()) {
			System.out.println("No se encontraron etiquetas para la fecha y nombre especificados.");
			return java.util.Collections.emptyList();
		}
		return etiquetas;
	}
}

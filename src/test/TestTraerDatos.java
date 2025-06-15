package test;

import datos.Usuario;
import datos.Cliente;
import datos.Tecnico;
import datos.Ticket;
import datos.Area;
import datos.Categoria;
import datos.Comentario;
import datos.Direccion;
import datos.Etiqueta;
import datos.Localidad;
import datos.Provincia;
import datos.Revision;
import negocio.UsuarioABM;
import negocio.ClienteABM;
import negocio.TecnicoABM;
import negocio.TicketABM;
import negocio.AreaABM;
import negocio.CategoriaABM;
import negocio.ComentarioABM;
import negocio.DireccionABM;
import negocio.EtiquetaABM;
import negocio.LocalidadABM;
import negocio.ProvinciaABM;
import negocio.RevisionABM;

/**
 * 1.1. Traer todos los objetos de cada una de las clases datos
 */
public class TestTraerDatos {
    public static void main(String[] args) throws Exception {
        System.out.println("\n--- 1.1. Traer todos los objetos de cada clase de datos ---\n");

        System.out.println("Usuarios:");
        for (Usuario u : UsuarioABM.getInstance().traer()) {
            System.out.println(u);
        }

        System.out.println("\nClientes:");
        for (Cliente c : ClienteABM.getInstance().traer()) {
            System.out.println(c);
        }

        System.out.println("\nTécnicos:");
        for (Tecnico t : TecnicoABM.getInstance().traer()) {
            System.out.println(t);
        }

        System.out.println("\nTickets:");
        for (Ticket t : TicketABM.getInstance().traer()) {
            System.out.println(t);
        }

        System.out.println("\nÁreas:");
        for (Area a : AreaABM.getInstance().traer()) {
            System.out.println(a);
        }

        System.out.println("\nCategorías:");
        for (Categoria cat : CategoriaABM.getInstance().traer()) {
            System.out.println(cat);
        }

        System.out.println("\nComentarios:");
        for (Comentario com : ComentarioABM.getInstance().traer()) {
            System.out.println(com);
        }

        System.out.println("\nDirecciones:");
        for (Direccion d : DireccionABM.getInstance().traer()) {
            System.out.println(d);
        }

        System.out.println("\nEtiquetas:");
        for (Etiqueta e : EtiquetaABM.getInstance().traer()) {
            System.out.println(e);
        }

        System.out.println("\nLocalidades:");
        for (Localidad l : LocalidadABM.getInstance().traer()) {
            System.out.println(l);
        }

        System.out.println("\nProvincias:");
        for (Provincia p : ProvinciaABM.getInstance().traer()) {
            System.out.println(p);
        }

        System.out.println("\nRevisiones:");
        for (Revision r : RevisionABM.getInstance().traer()) {
            System.out.println(r);
        }
    }
}
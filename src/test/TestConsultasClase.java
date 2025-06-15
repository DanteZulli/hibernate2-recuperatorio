package test;


import negocio.*;
import datos.*;
import java.util.List;

/**
 * 1.3 Mínimo cuatro consultas por algún atributo del tipo clase
 * 1.4 Mínimo cuatro consultas por algún atributo de la subclase
 */
public class TestConsultasClase {
    public static void main(String[] args) throws Exception {
        System.out.println("=== 1.3. Consultas por atributo de clase base (Usuario) ===\n");

        // 1. Traer usuarios por nombre
        System.out.println("1. Usuarios que contienen 'Juan' en su nombre:");
        List<Usuario> usuariosPorNombre = UsuarioABM.getInstance().traerPorNombre("Juan");
        for (Usuario u : usuariosPorNombre) {
            System.out.println("LOG: " + u);
        }

        // 2. Traer tickets por prioridad
        System.out.println("\n2. Tickets por Prioridad:");
        List<Ticket> ticketsPorPrioridad = TicketABM.getInstance().traerPorPrioridad("Alta");
        for (Ticket t : ticketsPorPrioridad) {
            System.out.println("LOG - Ticket por prioridad: " + t);
        }

        // 3. Traer usuarios administradores
        System.out.println("\n3. Usuarios administradores:");
        List<Usuario> administradores = UsuarioABM.getInstance().traerAdministradores();
        for (Usuario u : administradores) {
            System.out.println("LOG: " + u);
        }

        // 4. Traer usuario por nombre de usuario
        System.out.println("\n4. Usuario con nombre de usuario 'jperez':");
        Usuario usuarioPorUsername = UsuarioABM.getInstance().traerPorNombreUsuario("jperez");
        System.out.println("LOG: " + usuarioPorUsername);

        System.out.println("\n=== 1.4. Consultas por atributo de subclases (Cliente, Tecnico) ===\n");

        // 1. Traer clientes por plan
        System.out.println("1. Clientes con plan 'Básico':");
        List<Cliente> clientesPorPlan = ClienteABM.getInstance().traerPorPlan("Básico");
        for (Cliente c : clientesPorPlan) {
            System.out.println("LOG: " + c);
        }

        // 2. Traer clientes particulares
        System.out.println("\n2. Clientes particulares:");
        List<Cliente> clientesParticulares = ClienteABM.getInstance().traerParticulares();
        for (Cliente c : clientesParticulares) {
            System.out.println("LOG: " + c);
        }

        // 3. Traer técnicos por empresa
        System.out.println("\n3. Técnicos de la empresa 'TechPro':");
        List<Tecnico> tecnicosPorEmpresa = TecnicoABM.getInstance().traerPorEmpresa("TechPro");
        for (Tecnico t : tecnicosPorEmpresa) {
            System.out.println("LOG: " + t);
        }

        // 4. Traer técnicos por área
        System.out.println("\n4. Técnicos del área 'Soporte Técnico':");
        Area areaSoporte = AreaABM.getInstance().traer(1);
        List<Tecnico> tecnicosPorArea = TecnicoABM.getInstance().traerPorArea(areaSoporte);
        for (Tecnico t : tecnicosPorArea) {
            System.out.println("LOG: " + t);
        }
    }

}

package test;

import negocio.*;
import datos.*;
import java.util.List;

public class TestConsultasVariadas {
    public static void main(String[] args) {
        System.out.println("=== Consultas Variadas ===\n");
        
        // 1. Consultas de Tickets
        System.out.println("1. Tickets por Estado:");
        List<Ticket> ticketsPorEstado = TicketABM.getInstance().traerPorEstado("Abierto");
        for (Ticket t : ticketsPorEstado) {
            System.out.println("LOG - Ticket por estado: " + t);
        }



        // 2. Consultas de Categorías
        System.out.println("\n3. Categorías por Nombre:");
        List<Categoria> categoriasPorNombre = CategoriaABM.getInstance().traerPorNombre("Redes");
        for (Categoria c : categoriasPorNombre) {
            System.out.println("LOG - Categoría por nombre: " + c);
        }

        // 3. Consultas de Direcciones
        System.out.println("\n4. Direcciones Fiscales:");
        List<Direccion> direccionesFiscales = DireccionABM.getInstance().traerFiscales();
        for (Direccion d : direccionesFiscales) {
            System.out.println("LOG - Dirección fiscal: " + d);
        }

        // 4. Consultas de Localidades
        System.out.println("\n5. Localidades por Provincia:");
        Provincia provincia = ProvinciaABM.getInstance().traer(1); // Asumiendo que existe una provincia con ID 1
        List<Localidad> localidadesPorProvincia = LocalidadABM.getInstance().traerPorProvincia(provincia);
        for (Localidad l : localidadesPorProvincia) {
            System.out.println("LOG - Localidad por provincia: " + l);
        }

        // 5. Consultas de Tickets con Relaciones
        System.out.println("\n6. Tickets por Creador:");
        Cliente cliente = ClienteABM.getInstance().traer(1); // Asumiendo que existe un cliente con ID 1
        List<Ticket> ticketsPorCreador = TicketABM.getInstance().traerPorCreador(cliente);
        for (Ticket t : ticketsPorCreador) {
            System.out.println("LOG - Ticket por creador: " + t);
        }

        System.out.println("\n7. Tickets por Técnico Asignado:");
        Tecnico tecnico = TecnicoABM.getInstance().traer(1); // Asumiendo que existe un técnico con ID 1
        List<Ticket> ticketsPorTecnico = TicketABM.getInstance().traerPorTecnico(tecnico);
        for (Ticket t : ticketsPorTecnico) {
            System.out.println("LOG - Ticket por técnico: " + t);
        }

        // 6. Consultas de Técnicos con Relaciones
        
    }
} 
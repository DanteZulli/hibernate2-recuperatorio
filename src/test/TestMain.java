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

public class TestMain {
    public static void main(String[] args) {
        // ----------------------------------------------------------------------
        // 1.1. Traer todos los objetos de cada una de las clases datos
        // ----------------------------------------------------------------------
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

        // ----------------------------------------------------------------------
        // 1.2. ABM para Cliente, Tecnico, Ticket y Area
        // ----------------------------------------------------------------------
        System.out.println("\n--- 1.2. ABM para Cliente, Tecnico, Ticket y Area ---\n");

        // ===================== PROVINCIAS Y LOCALIDADES =====================
        Provincia provincia = new Provincia();
        provincia.setNombre("Buenos Aires");
        int idProvincia = ProvinciaABM.getInstance().alta(provincia);
        provincia.setId(idProvincia);

        Localidad localidad = new Localidad();
        localidad.setNombre("La Plata");
        localidad.setProvincia(provincia);
        int idLocalidad = LocalidadABM.getInstance().alta(localidad);
        localidad.setId(idLocalidad);

        // ===================== DIRECCIONES =====================
        Direccion direccion1 = new Direccion();
        direccion1.setCalle("Calle 1");
        direccion1.setNro("123");
        direccion1.setCodigoPostal("1900");
        direccion1.setLocalidad(localidad);
        direccion1.setFiscal(true);
        int idDireccion1 = DireccionABM.getInstance().alta(direccion1);
        direccion1.setId(idDireccion1);

        Direccion direccion2 = new Direccion();
        direccion2.setCalle("Calle 2");
        direccion2.setNro("456");
        direccion2.setCodigoPostal("1901");
        direccion2.setLocalidad(localidad);
        direccion2.setFiscal(false);
        int idDireccion2 = DireccionABM.getInstance().alta(direccion2);
        direccion2.setId(idDireccion2);

        Direccion direccion3 = new Direccion();
        direccion3.setCalle("Calle 3");
        direccion3.setNro("789");
        direccion3.setCodigoPostal("1902");
        direccion3.setLocalidad(localidad);
        direccion3.setFiscal(true);
        int idDireccion3 = DireccionABM.getInstance().alta(direccion3);
        direccion3.setId(idDireccion3);

        // ===================== ÁREAS =====================
        Area area1 = new Area();
        area1.setNombre("Soporte");
        int idArea1 = AreaABM.getInstance().alta(area1);
        area1.setId(idArea1);

        Area area2 = new Area();
        area2.setNombre("Desarrollo");
        int idArea2 = AreaABM.getInstance().alta(area2);
        area2.setId(idArea2);

        Area area3 = new Area();
        area3.setNombre("Infraestructura");
        int idArea3 = AreaABM.getInstance().alta(area3);
        area3.setId(idArea3);

        // Modificación de área
        area1.setNombre("Soporte Técnico");
        AreaABM.getInstance().modificacion(area1);
        System.out.println("Área modificada: " + area1);

        // Baja de área
        AreaABM.getInstance().baja(area3);
        System.out.println("Área eliminada: " + area3);

        // ===================== CLIENTES =====================
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan Perez");
        cliente1.setNombreUsuario("jperez");
        cliente1.setContrasenia("1234");
        cliente1.setEmail("juan@mail.com");
        cliente1.setEsAdmin(false);
        cliente1.setNroCliente(1001);
        cliente1.setPlan("Premium");
        cliente1.setParticular(true);
        cliente1.setDireccion(direccion1);
        int idCliente1 = ClienteABM.getInstance().alta(cliente1);
        cliente1.setId(idCliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Maria Gomez");
        cliente2.setNombreUsuario("mgomez");
        cliente2.setContrasenia("abcd");
        cliente2.setEmail("maria@mail.com");
        cliente2.setEsAdmin(false);
        cliente2.setNroCliente(1002);
        cliente2.setPlan("Básico");
        cliente2.setParticular(false);
        cliente2.setDireccion(direccion2);
        int idCliente2 = ClienteABM.getInstance().alta(cliente2);
        cliente2.setId(idCliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setNombre("Carlos Ruiz");
        cliente3.setNombreUsuario("cruiz");
        cliente3.setContrasenia("xyz");
        cliente3.setEmail("carlos@mail.com");
        cliente3.setEsAdmin(false);
        cliente3.setNroCliente(1003);
        cliente3.setPlan("Premium");
        cliente3.setParticular(true);
        cliente3.setDireccion(direccion3);
        int idCliente3 = ClienteABM.getInstance().alta(cliente3);
        cliente3.setId(idCliente3);

        // Modificación de cliente
        cliente1.setPlan("Básico");
        ClienteABM.getInstance().modificacion(cliente1);
        System.out.println("Cliente modificado: " + cliente1);

        // Baja de cliente
        ClienteABM.getInstance().baja(cliente3);
        System.out.println("Cliente eliminado: " + cliente3);

        // ===================== TÉCNICOS =====================
        Tecnico tecnico1 = new Tecnico();
        tecnico1.setNombre("Ana López");
        tecnico1.setNombreUsuario("alopez");
        tecnico1.setContrasenia("abcd");
        tecnico1.setEmail("ana@mail.com");
        tecnico1.setEsAdmin(false);
        tecnico1.setNroContacto("123456789");
        tecnico1.setEmpresa("Soluciones IT");
        tecnico1.setArea(area1);
        int idTecnico1 = TecnicoABM.getInstance().alta(tecnico1);
        tecnico1.setId(idTecnico1);

        Tecnico tecnico2 = new Tecnico();
        tecnico2.setNombre("Pedro Torres");
        tecnico2.setNombreUsuario("ptorres");
        tecnico2.setContrasenia("qwerty");
        tecnico2.setEmail("pedro@mail.com");
        tecnico2.setEsAdmin(false);
        tecnico2.setNroContacto("987654321");
        tecnico2.setEmpresa("TechPro");
        tecnico2.setArea(area2);
        int idTecnico2 = TecnicoABM.getInstance().alta(tecnico2);
        tecnico2.setId(idTecnico2);

        Tecnico tecnico3 = new Tecnico();
        tecnico3.setNombre("Laura Díaz");
        tecnico3.setNombreUsuario("ldiaz");
        tecnico3.setContrasenia("pass");
        tecnico3.setEmail("laura@mail.com");
        tecnico3.setEsAdmin(false);
        tecnico3.setNroContacto("555555555");
        tecnico3.setEmpresa("Soluciones IT");
        tecnico3.setArea(area1);
        int idTecnico3 = TecnicoABM.getInstance().alta(tecnico3);
        tecnico3.setId(idTecnico3);

        // Modificación de técnico
        tecnico1.setEmpresa("TechPro");
        TecnicoABM.getInstance().modificacion(tecnico1);
        System.out.println("Técnico modificado: " + tecnico1);

        // Baja de técnico
        TecnicoABM.getInstance().baja(tecnico3);
        System.out.println("Técnico eliminado: " + tecnico3);

        // ===================== CATEGORÍAS =====================
        Categoria categoria1 = new Categoria();
        categoria1.setNombre("Redes");
        categoria1.setDescripcion("Problemas de red");
        int idCategoria1 = CategoriaABM.getInstance().alta(categoria1);
        categoria1.setId(idCategoria1);

        Categoria categoria2 = new Categoria();
        categoria2.setNombre("Hardware");
        categoria2.setDescripcion("Problemas de hardware");
        int idCategoria2 = CategoriaABM.getInstance().alta(categoria2);
        categoria2.setId(idCategoria2);

        // ===================== TICKETS =====================
        Ticket ticket1 = new Ticket();
        ticket1.setTitulo("Problema de conexión");
        ticket1.setDescripcion("No puedo conectarme a la red");
        ticket1.setEstado("Abierto");
        ticket1.setPrioridad("Alta");
        ticket1.setCreador(cliente1);
        ticket1.setAsignado(tecnico1);
        ticket1.setCategoria(categoria1);
        int idTicket1 = TicketABM.getInstance().alta(ticket1);
        ticket1.setId(idTicket1);

        Ticket ticket2 = new Ticket();
        ticket2.setTitulo("Falla de impresora");
        ticket2.setDescripcion("La impresora no responde");
        ticket2.setEstado("Abierto");
        ticket2.setPrioridad("Media");
        ticket2.setCreador(cliente2);
        ticket2.setAsignado(tecnico2);
        ticket2.setCategoria(categoria2);
        int idTicket2 = TicketABM.getInstance().alta(ticket2);
        ticket2.setId(idTicket2);

        Ticket ticket3 = new Ticket();
        ticket3.setTitulo("Corte de luz");
        ticket3.setDescripcion("Se cortó la luz en el sector");
        ticket3.setEstado("Abierto");
        ticket3.setPrioridad("Alta");
        ticket3.setCreador(cliente1);
        ticket3.setAsignado(tecnico2);
        ticket3.setCategoria(categoria1);
        int idTicket3 = TicketABM.getInstance().alta(ticket3);
        ticket3.setId(idTicket3);

        // Modificación de ticket
        ticket1.setEstado("En Proceso");
        TicketABM.getInstance().modificacion(ticket1);
        System.out.println("Ticket modificado: " + ticket1);

        // Baja de ticket
        TicketABM.getInstance().baja(ticket3);
        System.out.println("Ticket eliminado: " + ticket3);
    }
}

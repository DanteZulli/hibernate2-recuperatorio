package datos;

import java.sql.Timestamp;
import java.util.Set;
import java.util.HashSet;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private Set<Ticket> tickets = new HashSet<>();
    private Timestamp createAt;
    private Timestamp updateAt;

    public Categoria() {
    }

    public Categoria(int id, String nombre, String descripcion, Set<Ticket> tickets, Timestamp createAt, Timestamp updateAt) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tickets = tickets;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +

                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
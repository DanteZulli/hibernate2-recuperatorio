package datos;

import java.sql.Timestamp;
import java.util.List;

public class Etiqueta {
    private int id;
    private String nombre;
    private List<Ticket> tickets;
    private Timestamp createAt;
    private Timestamp updateAt;

    public Etiqueta() {
    }

    public Etiqueta(int id, String nombre, List<Ticket> tickets, Timestamp createAt, Timestamp updateAt) {
        this.id = id;
        this.nombre = nombre;   
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
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
        return "Etiqueta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                /*", tickets=" + tickets +*/
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}

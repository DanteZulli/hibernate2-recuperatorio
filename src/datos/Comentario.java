package datos;

import java.sql.Timestamp;

public class Comentario {
    private int id;
    private String mensaje;
    private Timestamp  fecha;
    private Ticket ticket;
    private Usuario usuario;
    private Timestamp createAt;
    private Timestamp updateAt;

    public Comentario() {
    }

    public Comentario(int id, String mensaje, Timestamp fecha, Ticket ticket, Usuario usuario, Timestamp createAt, Timestamp updateAt) {
        this.id = id;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.ticket = ticket;
        this.usuario = usuario;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        return "Comentario{" +
                "id=" + id +
                ", mensaje='" + mensaje + '\'' +
                ", fecha=" + fecha +
                ", ticket=" + ticket +
                ", usuario=" + usuario +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}

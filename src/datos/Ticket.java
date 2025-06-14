package datos;

import java.sql.Timestamp;
import java.util.Set;
import java.util.HashSet;

public class Ticket {
    private int id;
    private String titulo;
    private String descripcion;
    private String estado;
    private String prioridad;
    private Timestamp fechaCreacion;
    private Timestamp fechaResolucion;
    private Usuario creador;
    private Usuario asignado;
    private Categoria categoria;
    private Set<Etiqueta> etiquetas = new HashSet<>();
    private Set<Comentario> comentarios = new HashSet<>();
    private Set<Revision> revisiones = new HashSet<>();
    private Timestamp createAt;
    private Timestamp updateAt;

    public Ticket() {
    }

    public Ticket(int id, String titulo, String descripcion, String estado, String prioridad, Timestamp fechaCreacion, Timestamp fechaResolucion, Usuario creador, Usuario asignado, Categoria categoria, Set<Etiqueta> etiquetas, Set<Comentario> comentarios, Set<Revision> revisiones, Timestamp createAt, Timestamp updateAt) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fechaCreacion = fechaCreacion;
        this.fechaResolucion = fechaResolucion;
        this.creador = creador;
        this.asignado = asignado;
        this.categoria = categoria;
        this.etiquetas = etiquetas;
        this.comentarios = comentarios;
        this.revisiones = revisiones;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Timestamp fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public Usuario getAsignado() {
        return asignado;
    }

    public void setAsignado(Usuario asignado) {
        this.asignado = asignado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(Set<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Set<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(Set<Revision> revisiones) {
        this.revisiones = revisiones;
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
        return "Ticket{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaResolucion=" + fechaResolucion +
                ", creadorId=" + (creador != null ? creador.getId() : "null") +
                ", asignadoId=" + (asignado != null ? asignado.getId() : "null") +
                ", categoriaId=" + (categoria != null ? categoria.getId() : "null") +
                // No accedes a etiquetas, comentarios o revisiones para evitar LazyInitializationException
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }


}

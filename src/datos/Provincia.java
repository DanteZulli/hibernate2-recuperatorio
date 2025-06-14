package datos;

import java.sql.Timestamp;
import java.util.Set;
import java.util.HashSet;

public class Provincia {
    private int id;
    private String nombre;
    private Set<Localidad> localidades = new HashSet<>();
    private Timestamp createAt;
    private Timestamp updateAt;

    public Provincia() {
    }

    public Provincia(int id, String nombre, Set<Localidad> localidades, Timestamp createAt, Timestamp updateAt) {
        this.id = id;
        this.nombre = nombre;
        this.localidades = localidades;
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

    public Set<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(Set<Localidad> localidades) {
        this.localidades = localidades;
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
        return "Provincia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}

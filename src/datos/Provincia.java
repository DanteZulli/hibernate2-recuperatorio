package datos;

import java.sql.Timestamp;
import java.util.List;

public class Provincia {
    private int id;
    private String nombre;
    private List<Localidad> localidades;
    private Timestamp createAt;
    private Timestamp updateAt;

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

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
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
                ", localidades=" + localidades +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}

package datos;

import java.sql.Timestamp;
import java.util.List;

public class Area {
    private int id;
    private String nombre;
    private List<Tecnico> tecnicos;
    private Timestamp createAt;
    private Timestamp updateAt;

    public Area() {
    }

    public Area(int id, String nombre, List<Tecnico> tecnicos, Timestamp createAt, Timestamp updateAt) {
        this.id = id;
        this.nombre = nombre;
        this.tecnicos = tecnicos;
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

    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
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
        return "Area{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                /*", tecnicos=" + tecnicos +*/
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}

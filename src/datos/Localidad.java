package datos;

import java.sql.Timestamp;

public class Localidad {
    private int id;
    private String nombre;
    private Provincia provincia;
    private Timestamp createAt;
    private Timestamp updateAt;

    public Localidad() {
    }

    public Localidad(int id, String nombre, Provincia provincia, Timestamp createAt, Timestamp updateAt) {
        this.id = id;
        this.nombre = nombre;   
        this.provincia = provincia;
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

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
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
        return "Localidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", provincia=" + provincia +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}

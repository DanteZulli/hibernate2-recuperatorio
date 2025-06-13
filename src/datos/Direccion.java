package datos;

import java.sql.Timestamp;

public class Direccion {
    private int id;
    private String calle;
    private String nro;
    private String codigoPostal;
    private Localidad localidad;
    private boolean fiscal;
    private Timestamp createAt;
    private Timestamp updateAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public boolean isFiscal() {
        return fiscal;
    }

    public void setFiscal(boolean fiscal) {
        this.fiscal = fiscal;
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
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", nro='" + nro + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", localidad=" + localidad +
                ", fiscal=" + fiscal +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
package datos;

public class Tecnico extends Usuario {
    private String nroContacto;
    private String empresa;
    private Area area;

    public String getNroContacto() {
        return nroContacto;
    }

    public void setNroContacto(String nroContacto) {
        this.nroContacto = nroContacto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "nroContacto='" + nroContacto + '\'' +
                ", empresa='" + empresa + '\'' +
                ", area=" + area +
                '}';
    }
}
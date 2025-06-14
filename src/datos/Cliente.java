package datos;

public class Cliente extends Usuario {
    private int nroCliente;
    private String plan;
    private boolean particular;
    private Direccion direccion;

    public Cliente() {
    }

    public Cliente(int nroCliente, String plan, boolean particular, Direccion direccion) {
        this.nroCliente = nroCliente;
        this.plan = plan;
        this.particular = particular;
        this.direccion = direccion;
    }

    public int getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(int nroCliente) {
        this.nroCliente = nroCliente;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public boolean isParticular() {
        return particular;
    }

    public void setParticular(boolean particular) {
        this.particular = particular;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nroCliente=" + nroCliente +
                ", plan='" + plan + '\'' +
                ", particular=" + particular +
               /* ", direccion=" + direccion +*/
                '}';
    }
}

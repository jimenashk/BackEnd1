public class Vuelo {

    private String fechaIda;
    private String fechaRegreso;
    private String origen;
    private String destino;

    public Vuelo(String fechaIda, String fechaRegreso, String origen, String destino) {
        this.fechaIda = fechaIda;
        this.fechaRegreso = fechaRegreso;
        this.origen = origen;
        this.destino = destino;

    }

    public String getFechaIda() {
        return fechaIda;
    }

    public void setFechaIda(String fechaIda) {
        this.fechaIda = fechaIda;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return  "Vuelo" +
                "fechaIda='" + fechaIda + '\'' +
                ", fechaRegreso='" + fechaRegreso + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\''
                ;

    }
}

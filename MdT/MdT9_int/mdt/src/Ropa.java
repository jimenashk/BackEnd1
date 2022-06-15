public class Ropa {

    private String talle;
    private String tipo;
    private Boolean esNuevo;
    private String importada;

    public Ropa(String talle, String tipo, Boolean esNuevo, String importada) {
        this.talle = talle;
        this.tipo = tipo;
        this.esNuevo = esNuevo;
        this.importada = importada;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(Boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public String getImportada() {
        return importada;
    }

    public void setImportada(String importada) {
        this.importada = importada;
    }

    @Override
    public String toString() {
        return "Ropa{" +
                "talle='" + talle + '\'' +
                ", tipo='" + tipo + '\'' +
                ", esNuevo=" + esNuevo +
                ", importada='" + importada + '\'' +
                '}';
    }
}

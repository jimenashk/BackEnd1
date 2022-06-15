package indumentaria;

import java.util.Objects;

public class Prenda {
    private String talle;
    private String tipo;
    private boolean esNuevo;
    private boolean esImportada;

    public Prenda(String talle, String tipo, boolean esNuevo, boolean esImportada) {
        this.talle = talle;
        this.tipo = tipo;
        this.esNuevo = esNuevo;
        this.esImportada = esImportada;
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

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public boolean isEsImportada() {
        return esImportada;
    }

    public void setEsImportada(boolean esImportada) {
        this.esImportada = esImportada;
    }
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenda laPrenda = (Prenda) o;
        return esNuevo == laPrenda.esNuevo && esImportada == laPrenda.esImportada && talle.equals(laPrenda.talle) && tipo.equals((laPrenda.tipo));
    }
    public int hashCode(){
        return Objects.hash(talle, tipo, esNuevo, esImportada);
    }

    @Override
    public String toString() {
        return "\nPrenda:" +
                "\n\tTalle: '" + talle + "'" +
                "\n\tTipo: '" + tipo + "'" +
                "\n\tEs nuevo: " + esNuevo +
                "\n\tEs importada: " + esImportada;
    }

}

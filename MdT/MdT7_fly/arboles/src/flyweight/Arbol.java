package flyweight;

import java.util.Objects;

public class Arbol {

    private int alto;
    private int ancho;
    private String color;
    private String tipo;

    public Arbol(int alto, int ancho, String color, String tipo) {
        this.alto = alto;
        this.ancho = ancho;
        this.color = color;
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alto, ancho, color, tipo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() !=getClass()) return false;
        Arbol arbol  =(Arbol) o;
        return alto == arbol.alto && ancho == arbol.ancho && color.equals(arbol.color) && tipo.equals(arbol.tipo);


    }

    @Override
    public String toString() {
        return "\nArbol: " +
                "\n\tAlto: " + alto +
                "\n\tAncho: " + ancho +
                "\n\tColor: " + color +
                "\n\tTipo: " + tipo;

            }
}

package MdT;

public class MenuVegetariano extends Menu{
    private int cantidadSalsas;

    public int getCantidadSalsas() {
        return cantidadSalsas;
    }

    public void setCantidadSalsas(int cantidadSalsas) {
        this.cantidadSalsas = cantidadSalsas;
    }

    public MenuVegetariano(double precioBase, int cantidadSalsas) {
        super(precioBase);
        this.cantidadSalsas = cantidadSalsas;


    }
}

package MdT;

public class CocineroMenuVegetariano extends CocineroDeMenu {
    @Override
    protected String armar(Menu menu) {
        return "1-Agregar especias.\n 2-Preparar ingredientes. \n 3-Cocinar ingredientes";
    }

    @Override
    protected double calcularPrecio(Menu menu) {
        double resp = 0;
        if (menu instanceof MenuVegetariano) {
            double precioBase = menu.getPrecioBase();
            double recargoPorEspecias = precioBase * 0.01;
            double recargoPorSalsas = 2 * ((MenuVegetariano) menu).getCantidadSalsas();
            resp = precioBase + recargoPorEspecias + recargoPorSalsas;
        }
        return resp;
    }


}

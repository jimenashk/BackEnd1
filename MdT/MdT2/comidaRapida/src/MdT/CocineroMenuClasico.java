package MdT;

public class CocineroMenuClasico extends CocineroDeMenu{
    @Override
    protected String armar(Menu menu) {
        return "1- Preparar Ingredientes. \n 2- Cocinar Ingredientes.";
    }

    @Override
    protected double calcularPrecio(Menu menu) {
        return menu.getPrecioBase();
    }
}

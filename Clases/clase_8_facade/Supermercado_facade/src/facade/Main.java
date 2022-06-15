package facade;

public class Main {
    public static void main(String[] args) {
        FacadeDescuento facade = new FacadeDescuento();
        Tarjeta tarj1 = new Tarjeta("54652328465547", "Star Bank");
        Producto prod1 = new Producto("arvejas", "Lata");
        System.out.println("Descuento: " + facade.descuento(tarj1, prod1, 12) + " %.");
    }
}

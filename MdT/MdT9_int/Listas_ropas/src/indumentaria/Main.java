package indumentaria;

public class Main {

    public static void main(String[] args) {

        LocalDeIndumentaria local = new LocalDeIndumentaria();

        for (int i = 0; i < 10000; i++) {
            local.agregarPrenda("L", "Remera", true, true);
            local.agregarPrenda("M", "Remera", false, false);
            local.agregarPrenda("S", "Remera", true, false);
            local.agregarPrenda("XL", "Remera", false, true);
        }

        local.mostrarPrendas();
    }
}

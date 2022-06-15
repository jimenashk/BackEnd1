public class Main {
    public static void main(String[] args) {
        RopaFactory ropaFactory = new RopaFactory();

        Ropa pantalon = ropaFactory.getRopa("M", "pantalon", true, "Nacional");
        Ropa pantalon2 = ropaFactory.getRopa("M", "pantalon", false, "Nacional");
        Ropa pantalon3 = ropaFactory.getRopa("M", "pantalon", false, "Nacional");
        Ropa pantalon4 = ropaFactory.getRopa("M", "pantalon", false, "Internacional");
        Ropa pantalon5 = ropaFactory.getRopa("S", "pantalon", true, "Internacional");
        Ropa remera = ropaFactory.getRopa("S", "remera", true, "INTERNACIONAL");
        Ropa remera2 = ropaFactory.getRopa("S", "remera", true, "INTERNACIONAL");

        System.out.println(ropaFactory.getListaTalleS());
        System.out.println(ropaFactory.getListaTalleM());
        System.out.println(ropaFactory.getListaRopaImportada());
        System.out.println(ropaFactory.getListaRopaEnMalasCondiciones());

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }
}
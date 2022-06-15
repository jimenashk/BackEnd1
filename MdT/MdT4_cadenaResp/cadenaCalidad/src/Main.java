public class Main {
    public static void main(String[] args) {
        CompruebaCalidad proceso = new CompruebaCalidad();
        proceso.comprobar(new Articulo("Destornilladores", 1200, 1300, "sano"));
        proceso.comprobar(new Articulo("Tornillos", 1000, 1300, "sano"));
        proceso.comprobar(new Articulo("burletes", 1100, 800, "sano"));
        proceso.comprobar(new Articulo("rodillos", 1800, 1200, "roto"));

    }
}

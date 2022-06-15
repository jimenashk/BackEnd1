import flyweight.Bosque;

public class Main {
    public static void main(String[] args) {
        Bosque bosque = new Bosque();
        Runtime runtime = Runtime.getRuntime();

        bosque.plantarArboles();
        bosque.mostrarArboles();
        System.out.println("");
        System.out.println("Memoria Usada: " + (runtime.totalMemory()-runtime.freeMemory() / 1024 * 1024));
    }
}

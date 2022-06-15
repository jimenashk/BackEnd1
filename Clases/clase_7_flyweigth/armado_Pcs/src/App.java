public class App {
    public static void main(String[] args) {
        ComputadoraFactory computer = new ComputadoraFactory();
        Computadora c1 = computer.getComputadora(16, 500);
        System.out.println("");
        Computadora c2 = computer.getComputadora(2, 256);
        System.out.println("");
        Computadora c3 = computer.getComputadora(16, 500);
        System.out.println("");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
    }
}

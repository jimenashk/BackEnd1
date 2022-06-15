public class Main {
    public static void main(String[] args) {
        Efectivo efectivo = new Efectivo("martin", "Lopez", 5645, 400d, 40, 50);
        Contratado contratado = new Contratado("Monica", "Rodriguez", 9858, 128, 7);
        Efectivo efectivoError = new Efectivo("martin", "Lopez", 5645, 400d, 40, 50);

        efectivo.liquidarSueldo();
        contratado.liquidarSueldo();
        efectivoError.liquidarSueldo();
    }
}

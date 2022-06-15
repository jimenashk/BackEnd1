public class Credito extends Tarjeta{

    private double limite;
    private double saldoUsado;

    public Credito(int nroFrente, int codSeguridad, int anioExpiracion, int mesExpiracion, String tipo, double limite, double saldoUsado) {
        super(nroFrente, codSeguridad, anioExpiracion, mesExpiracion, tipo);
        this.limite = limite;
        this.saldoUsado = saldoUsado;
    }

    @Override
    public boolean chequearAutorizacion(double importe) {
        return saldoUsado + importe <= limite;
    }

    @Override
    public void procesarPago(double importe, int numero) {

        if (fechaValida()) {

           if (chequearAutorizacion(importe)) {
               saldoUsado += importe;
               System.out.println("El pago de su tarjeta de " + getTipo() + " con numero: " + getNroFrente() + " fue procesado correctamente, " +
               "\n\t -Su pago es de: " + saldoUsado );
           } else {
               System.out.println(" No se ha podido autorizar la transaccion");
           }
        } else {
            System.out.println("Su tarjeta de " + getTipo() + " se encuetra vencida, comuniquese con su banco emisor");
        }

    }
}

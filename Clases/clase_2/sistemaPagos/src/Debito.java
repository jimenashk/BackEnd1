public class Debito extends Tarjeta{

    private double saldoDisponible;

    public Debito(int nroFrente, int codSeguridad, int anioExpiracion, int mesExpiracion, String tipo, double saldoDisponible) {
        super(nroFrente, codSeguridad, anioExpiracion, mesExpiracion, tipo);
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public boolean chequearAutorizacion(double importe) {
        return this.saldoDisponible >= importe;
    }

    @Override
    public void procesarPago(double importe, int numero) {
        if (fechaValida()){
            if (chequearAutorizacion(importe)) {
                saldoDisponible -= importe;
                System.out.println("El pago de la tarjeta de " + getTipo() + " con numero: " + getNroFrente() + " fue procesado correctamente." +
                        "\n\t -Su saldo actual es de: " + saldoDisponible);
            } else {
                System.out.println("El monto ingresado excede el saldo de su tarjeta de " + getTipo() + " nro: " + getNroFrente() + ". No se ha podido procesar el pago");
            }
        } else {
            System.out.println("Su tarjeta de " + getTipo() + " se encuentra vencida, comuniquese con su banco emisor");
        }
        }

    }


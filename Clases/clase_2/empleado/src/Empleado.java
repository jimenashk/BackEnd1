public abstract class Empleado {

    private String nombre;
    private String apellido;
    private int numeroCuenta;

    public Empleado(String nombre, String apellido, int numeroCuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCuenta = numeroCuenta;
    }

    public String liquidarSueldo() {
        double sueldoTotal = calcularSueldo();
        String resp = "Error";
        if (sueldoTotal < 0.1) {
            try {
                throw new Exception("---ERROR--- el sueldo no puede ser 0 o menor.  ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String recibo = generarRecibo(sueldoTotal);
            resp = depositarImporte(sueldoTotal, recibo);
        }
        return resp;
    }


    public abstract double calcularSueldo();

    public abstract String generarRecibo(double monto);

    public String depositarImporte(double monto, String recibo) {
        String resp = "Error";
        if (monto > 0) {
            resp = "La liquidacion generada es un documento " + recibo + ". \n-Saldo a liquidar: $" + monto;
            System.out.println(resp);
        }
        return resp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

   }


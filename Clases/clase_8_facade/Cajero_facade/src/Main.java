public class Main {

    public static void main(String[] args) {
        //creo lo 3 servicios:

        AutenticationService autenticador = new AutenticationService();
        CuentaService servicioDeCuentas = new CuentaService();
        CajaService caja = new CajaService();

        //creo 2 cuentas y las guardo en lista
        Cuenta cuenta1  =new Cuenta(1, 1000);
        Cuenta cuenta2  =new Cuenta(2, 1000);
        servicioDeCuentas.addCuenta(cuenta1);
        servicioDeCuentas.addCuenta(cuenta2);

        //creo el servicio facade
        CajeroService cajero = new CajeroService(autenticador,servicioDeCuentas,caja);

        //uso el servicio
        cajero.procesarExtraccion(1, "asd", 500);
        cajero.procesarExtraccion(1, "adf", 300);
        cajero.procesarExtraccion(1, "asw", 800);
        System.out.println("");
        cajero.procesarExtraccion(5, "asew", 800);
    }



    }


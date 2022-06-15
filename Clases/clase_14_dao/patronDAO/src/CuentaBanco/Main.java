package CuentaBanco;

public class Main {
    public static void main(String[] args) {

        //vinculacion dinamica. el metodo s comporta dif segun al objeto q apunta
        //ej este metodo no me deja extraer mas de 1000 en cuentacaja ahorro
        Cuenta cuenta = new CuentaCajaAhorro();
        cuenta.setSaldo(1000);
        //polimorfismo
        cuenta.extraer(1100);

        cuenta.extraer(1100);
        System.out.println(cuenta.getSaldo());

        //ya no hace falta pasar todos los parametros a cada objetno nuevo q instanciamos

       /* Cuenta cuenta2 = new CuentaCorriente();
        cuenta2.setSaldo(cuenta.getSaldo());
        cuenta= cuenta2;
        */

        //con composite y strategy ahora procedemos asi

        Cuenta cuenta3 = new Cuenta();
        cuenta3.setSaldo(2000);
        cuenta3.setNumero(1101);
        //cambio la estrategia de caja d ahorro a cuenta corriente y ahora si me va a dar el monto
        //solicitado quedando $-100
        cuenta3.setEstrategia(new EstrategiaCuentaCorriente());

        cuenta3.extraer(2100);
        System.out.println(cuenta3.getSaldo());




    }
}

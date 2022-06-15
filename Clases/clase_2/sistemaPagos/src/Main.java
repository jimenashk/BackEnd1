public class Main {
    public static void main(String[] args) {

        Debito debito = new Debito(400056, 890, 2025, 4, "Debito", 10000d);
        debito.procesarPago(5000d, debito.getNroFrente());
        debito.procesarPago(3000d, debito.getNroFrente());
        debito.procesarPago(3000d, debito.getNroFrente());
        System.out.println("");

        Credito credito = new Credito(8061685, 235, 2024, 8, "Credito", 10000d, 0d);
        credito.procesarPago(5000d, credito.getNroFrente());
        credito.procesarPago(3000d, credito.getNroFrente());
        credito.procesarPago(1500d, credito.getNroFrente());
        System.out.println("");

        Debito debitoVencido = new Debito(65478, 897, 2022, 2, "Debito", 10000d);
        debitoVencido.procesarPago(5000d, debitoVencido.getNroFrente());
        //debitoVencido.setMesExpiracion(1);
        debitoVencido.procesarPago(500d, debitoVencido.getNroFrente());
        System.out.println("");

        Credito creditoVencido = new Credito(35486, 456, 2020, 07, "Credito", 10000d, 0d);
        creditoVencido.procesarPago(1000d, creditoVencido.getNroFrente());

    }
}

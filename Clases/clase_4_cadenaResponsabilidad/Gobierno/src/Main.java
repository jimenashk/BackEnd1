public class Main {

    public static void main(String[] args) {

        Documento documento1 = new Documento("Estadisticas Educacion", 1);
        Documento documento2 = new Documento("Estadisticas Inseguridad", 2);
        Documento documento3 = new Documento("Estadisticas Inflacion", 3);

        Diputado diputado = new Diputado(new Ministro(new Presidente(null)));

        diputado.leerDocumento(documento1);
        System.out.println("");
        diputado.leerDocumento(documento2);
        System.out.println("");
        diputado.leerDocumento(documento3);
    }
}

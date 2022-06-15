public class ManejadorEnvase extends Manejador{

    @Override
    public void comprobar(Articulo arti) {
        if (!arti.getEnvase().equalsIgnoreCase("sano") && !arti.getEnvase().equalsIgnoreCase("casi sano")){
            System.out.println("La calidad del envase no es la esperada. Rechazado");
        } else {
            if (this.getSiguienteManejador() != null){
                this.getSiguienteManejador().comprobar(arti);
            }
        }
    }
}

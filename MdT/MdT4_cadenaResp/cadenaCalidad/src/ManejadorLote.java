public class ManejadorLote extends Manejador {
    @Override
    public void comprobar(Articulo arti) {
        if (arti.getLote() < 1000){
            int difmenorLote = 1000 - arti.getLote();
            System.out.println("Rechazado por el numero de lote inferior de " + difmenorLote);
        } else {
            if (this.getSiguienteManejador() != null){
                this.getSiguienteManejador().comprobar(arti);
            }
        }
    }
}

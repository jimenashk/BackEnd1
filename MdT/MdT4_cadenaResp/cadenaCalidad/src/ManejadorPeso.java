public class ManejadorPeso extends Manejador {

    @Override
    public void comprobar(Articulo arti) {
        if (arti.getPeso() < 1200){
            int difMenorPeso = 1200 - arti.getPeso();
            System.out.println("rechazado por el peso inferior de " + difMenorPeso);

        } else {
            if (this.getSiguienteManejador() != null){
                this.getSiguienteManejador().comprobar(arti);
            }
        }
    }
}

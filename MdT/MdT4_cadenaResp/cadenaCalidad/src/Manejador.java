public abstract class Manejador {
    private Manejador siguienteManejador;

    public Manejador getSiguienteManejador() {
        return siguienteManejador;
    }

    public void setSiguienteManejador(Manejador m) {
        this.siguienteManejador = m;
    }
    public abstract void comprobar(Articulo arti);
}

import java.util.Calendar;

public abstract class Tarjeta {

    private int nroFrente;
    private int codSeguridad;
    private int anioExpiracion;
    private int mesExpiracion;
    private String tipo;

    public Tarjeta(int nroFrente, int codSeguridad, int anioExpiracion, int mesExpiracion, String tipo) {
        this.nroFrente = nroFrente;
        this.codSeguridad = codSeguridad;
        this.anioExpiracion = anioExpiracion;
        this.mesExpiracion = mesExpiracion;
        this.tipo = tipo;
    }

    public int getNroFrente() {
        return nroFrente;
    }

    public void setNroFrente(int nroFrente) {
        this.nroFrente = nroFrente;
    }

    public int getCodSeguridad() {
        return codSeguridad;
    }

    public void setCodSeguridad(int codSeguridad) {
        this.codSeguridad = codSeguridad;
    }

    public int getAnioExpiracion() {
        return anioExpiracion;
    }

    public void setAnioExpiracion(int anioExpiracion) {
        this.anioExpiracion = anioExpiracion;
    }

    public int getMesExpiracion() {
        return mesExpiracion;
    }

    public void setMesExpiracion(int mesExpiracion) {
        this.mesExpiracion = mesExpiracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract boolean chequearAutorizacion(double importe);

    public abstract void procesarPago(double importe, int numero);

    public boolean fechaValida(){
        boolean respuesta = false;

        Calendar date = Calendar.getInstance();
        int anio = date.get(Calendar.YEAR);
        int mes = date.get(Calendar.MONTH);

        if (this.anioExpiracion > anio) {
            respuesta = true;
        }
        if (this.anioExpiracion == anio && this.mesExpiracion > mes){
            respuesta = true;
        }
        return respuesta;
    }
}

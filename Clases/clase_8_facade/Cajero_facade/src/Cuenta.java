public class Cuenta {

    private Integer indetificacionusuario;  //DNI
    private double saldoActual;

    public Cuenta(Integer indetificacionusuario, double saldoActual) {
        this.indetificacionusuario = indetificacionusuario;
        this.saldoActual = saldoActual;
    }

    public Integer getIndetificacionusuario() {
        return indetificacionusuario;
    }

    public void setIndetificacionusuario(Integer indetificacionusuario) {
        this.indetificacionusuario = indetificacionusuario;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }
}

public abstract class EmpleadoGobierno {

    private EmpleadoGobierno sigEmpleadoGobierno;

    public EmpleadoGobierno getSigEmpleadoGobierno() {
        return sigEmpleadoGobierno;
    }

    public void setSigEmpleadoGobierno(EmpleadoGobierno sigEmpleadoGobierno) {
        this.sigEmpleadoGobierno = sigEmpleadoGobierno;
    }

    public EmpleadoGobierno(EmpleadoGobierno sigEmpleadoGobierno) {
        this.sigEmpleadoGobierno = sigEmpleadoGobierno;


    }
    public abstract void leerDocumento(Documento documento);
}


public class Presidente extends EmpleadoGobierno{

    public Presidente(EmpleadoGobierno sigEmpleadoGobierno) {
        super(sigEmpleadoGobierno);
    }

    @Override
    public void leerDocumento(Documento documento) {
        System.out.println("El presidente lee el Documento");
        if (this.getSigEmpleadoGobierno() !=null){
            this.getSigEmpleadoGobierno().leerDocumento(documento);
        }
    }
}

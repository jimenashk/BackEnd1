public class CompruebaMail {
    private Manejador inicial;

    public CompruebaMail(){
        inicial= new ManejadorGerencia();
        Manejador comercial= new ManejadorComercial();
        Manejador tecnico= new ManejadorTecnico();
        Manejador spam= new ManejadorSpam();

        inicial.setSiguienteManejador(comercial);
        comercial.setSiguienteManejador(tecnico);
        tecnico.setSiguienteManejador(spam);
    }

    public String comprobar(Mail elMail){
        return inicial.comprobar(elMail);
    }
}

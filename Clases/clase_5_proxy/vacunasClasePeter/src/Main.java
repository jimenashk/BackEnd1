import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Pepe", "Lopez", "12345", "Pfizer", new Date(121, 6, 5));
        Persona persona2 = new Persona("Pepa", "Perez", "68845", "Moderna", new Date(121, 6, 5));
        Registro registro = new RegistroVacunaProxy();
        //Registro registro2 = new RegistroVacunaProxy();
       // registro.registrar(persona1.datos());
        registro.registrar(persona2.datos());

    }
}

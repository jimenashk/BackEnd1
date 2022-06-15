import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona("Pepe", "Lopez", "123456", "Pfizer",  new Date(2022-1900, 5-1, 19));
        Persona persona2 = new Persona("Pepa", "Juarez", "654789", "Moderna",  new Date(2022-1900, 3-1, 16));
        RegistroVacunaProxy proxy = new RegistroVacunaProxy();

        proxy.vacunar(persona1);
        proxy.vacunar(persona2);
    }
}

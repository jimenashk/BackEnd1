import java.util.Date;

public class RegistroVacunaProxy implements Registro{
    @Override
    public String vacunar(Persona persona) {
        //controlar fecha vacunacion
        Date hoy = new Date();
        String mensaje = "Vuelva cuando sea su turno:";
        if (hoy.after(persona.getFechaAsignada())){
            RegistroVacuna registro = new RegistroVacuna();
            mensaje = registro.vacunar(persona);
        }
        return mensaje;

    }
}

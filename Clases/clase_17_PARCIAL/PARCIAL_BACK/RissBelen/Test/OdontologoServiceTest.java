import Parcial.Dao.OdontologoDaoH2;
import Parcial.Modelo.Odontologo;
import Parcial.Servicio.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    public void odontologoserviceValidar() {

        Odontologo odontologo1 = new Odontologo(1, "Pedro", "Echegaray", "4562");
        Odontologo odontologo2 = new Odontologo(2, "Juan", "Echegaray", "1235");
        Odontologo odontologo3 = new Odontologo(3, "Marta", "Echegaray", "4585");


        Odontologo resultado = odontologoService.guardar(odontologo1);
        Odontologo resultado2 = odontologoService.guardar(odontologo2);
        Odontologo resultado3 = odontologoService.guardar(odontologo3);


        Assertions.assertEquals(odontologo1, resultado);
        Assertions.assertEquals(odontologo1.getNombre(), resultado.getNombre());
        Assertions.assertEquals(odontologo2, resultado2);
        Assertions.assertEquals(odontologo2.getNombre(), resultado2.getNombre());
        Assertions.assertEquals(odontologo3, resultado3);
        Assertions.assertEquals(odontologo2.getNombre(), resultado2.getNombre());


    }
}
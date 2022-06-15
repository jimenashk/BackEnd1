import Parcial.dao.OdontologoDaoH2;
import Parcial.model.Odontologo;
import Parcial.service.OdontologoService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OdontologoServiceTest {

    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    public void validarOdontologoService() {

        Odontologo odontologo1 = new Odontologo(1, "Marcela", "Perez", "4565");
        Odontologo odontologo2 = new Odontologo(2, "Luis", "Roca", "8954");
        Odontologo odontologo3 = new Odontologo(3, "Liliana", "Molina", "9861");

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
    @Test
    void buscarTodos(){
        odontologoService.buscarTodos();
    }

    }


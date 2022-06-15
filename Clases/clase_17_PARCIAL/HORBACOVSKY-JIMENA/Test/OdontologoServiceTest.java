import Parcial.daos.IDao;
import Parcial.daos.impl.OdontologoDAOH2;
import Parcial.entidades.Odontologo;
import Parcial.servicios.OdontologoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoServiceTest {

    OdontologoService odontologoServiceTest =  new OdontologoService();
    private IDao<Odontologo> odontologoIDaoTest = (IDao<Odontologo>) new OdontologoDAOH2();

    @BeforeEach
    public void cargarOdontologos(){
        Odontologo odontologo1 = new Odontologo(3876,"Jeremias","Romero");
        Odontologo odontologo2 = new Odontologo(6521,"Lucia","Martinez");
        Odontologo odontologo3 = new Odontologo(9654,"Julia","Pereira");


        odontologoServiceTest.setOdontologoIDao(odontologoIDaoTest);

        odontologoServiceTest.registrarOdontologo(odontologo1);
        odontologoServiceTest.registrarOdontologo(odontologo2);
        odontologoServiceTest.registrarOdontologo(odontologo3);

    }

    @Test
    void buscarTodos(){
        odontologoServiceTest.buscarTodos();
    }


}
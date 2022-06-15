import clinicaDental.dao.impl.PacienteDaoH2;
import clinicaDental.model.Domicilio;
import clinicaDental.model.Paciente;
import clinicaDental.service.PacienteService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)

public class PacienteServiceTest {

    private static PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @BeforeClass
    public static void cargandoDatosSeteados() {
        Domicilio domicilio = new Domicilio("Mitre", "4568", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Facundo", "Rodriguez", "65321548", new Date(), domicilio));
        Domicilio domicilio1 = new Domicilio("Av. Sarmiento", "658", "Cordoba", "Cordoba Capital");
        Paciente p1 = pacienteService.guardar(new Paciente("Monica", "Perez", "13654879", new Date(), domicilio));

    }

    @Test
    public void agregaryBuscarPacienteTest(){
        Domicilio domicilio = new Domicilio("Calle A", "555", "Lanus", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Lucia", "Ramirez", "13265478", new Date(), domicilio));

        Assert.assertNotNull(pacienteService.buscar(p.getId()));
    }


    @Test
    public void eliminarPacienteTest() {
        pacienteService.eliminar(2);
        Assert.assertTrue(pacienteService.buscar(3) == null);

    }

    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() > 0);
        System.out.println(pacientes);
    }


}

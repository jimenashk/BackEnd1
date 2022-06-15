package aerolinea.test;
import aerolinea.daos.IDao;
import aerolinea.daos.impl.AvionDaoH2;
import aerolinea.model.Avion;
import aerolinea.service.AvionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AvionServiceTest {

    AvionService avionService = new AvionService(new AvionDaoH2());

    @Test
    public void validarAvionService() {

        Avion avion1 = new Avion("Jet-Pack", "Force-XL654", "ABC6542", "2022-02-16");
        Avion avion2 = new Avion("Cargo-XL", "Traine-WSL", "DFC658", "2015-12-26");
        Avion avion3 = new Avion("Turbo-KLG", "Jumbo-KD65", "WED325", "2018-09-15");


        Avion resultado = avionService.registrarAvion(avion1);
        Avion resultado2 = avionService.registrarAvion(avion2);
        Avion resultado3 = avionService.registrarAvion(avion3);


        Assertions.assertEquals(avion1, resultado);
        Assertions.assertEquals(avion1.getMarca(), resultado.getMarca());
        Assertions.assertEquals(avion2, resultado2);
        Assertions.assertEquals(avion2.getMarca(), resultado2.getMarca());
        Assertions.assertEquals(avion3, resultado3);
        Assertions.assertEquals(avion2.getMarca(), resultado2.getMarca());
    }

}

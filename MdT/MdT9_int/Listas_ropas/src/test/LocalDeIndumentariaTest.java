package test;

import indumentaria.LocalDeIndumentaria;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocalDeIndumentariaTest {
    @Test

    public void agregar1Prenda(){
        LocalDeIndumentaria local = new LocalDeIndumentaria();
        String talle = "L";
        String tipo = "Remera";
        boolean esNueva = true;
        boolean esImportada = false;

        local.agregarPrenda(talle, tipo, esNueva, esImportada);
        assertEquals(local.cantidadPrendas(), 1);
    }

}
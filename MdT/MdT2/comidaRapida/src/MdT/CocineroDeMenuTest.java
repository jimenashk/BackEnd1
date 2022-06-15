package MdT;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CocineroDeMenuTest {

    @Test
    public void prepararmenuClasicoTest() {
        CocineroDeMenu cocinero = new CocineroMenuClasico();
        String respEsperada = "1- Preparar Ingredientes. \n 2- Cocinar Ingredientes." +
                "El precio del menu es de: 100.0";
        Menu menuClasico = new Menu(100);
        String respActual = cocinero.preparar(menuClasico);
        assertEquals(respEsperada, respActual);

    }

    @Test
    public void prepararMenuInfantiltest(){
        CocineroDeMenu cocinero= new CocineroMenuInfantil();
        String respEsperada= "1-Colocar juguetes. \n2-Preparar ingredientes\n3-Cocinar ingredientes" +
                "El precio del menu es: 115.0";
        Menu menuInfantil= new MenuInfantil(100, 5);
        String respActual= cocinero.preparar(menuInfantil);
        assertEquals(respEsperada, respActual);

    }
}
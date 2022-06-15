package facade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeDescuentoTest {

    @Test
    public void descuento30(){
        //dado
        FacadeDescuento facade  =new FacadeDescuento();
        Tarjeta tarj = new Tarjeta("5413864958997", "Star Bank");
        Producto m1 = new Producto("Arvejas en lata", "latas");
        int cantidad= 5;
        int descuentoEsperado = 30;
        //cuando
        int descuentoCalculado = facade.descuento(tarj, m1, cantidad);
        //entonces
        Assertions.assertEquals(descuentoEsperado, descuentoCalculado);
    }

    @Test
    public void descuento10(){
        //probando un descuento diferent econ otro banco
        //dado
        FacadeDescuento facade  =new FacadeDescuento();
        Tarjeta tarj = new Tarjeta("5413864958997", "Luna Bank");
        Producto m1 = new Producto("Arvejas en lata", "latas");
        int cantidad= 5;
        int descuentoEsperado = 10;
        //cuando
        int descuentoCalculado = facade.descuento(tarj, m1, cantidad);
        //entonces
        Assertions.assertEquals(descuentoEsperado, descuentoCalculado);
    }

}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompruebaMailTest {

    @Test
    public void deberiaSerComercial(){
        CompruebaMail proceso= new CompruebaMail();
        Mail elCorreo= new Mail("jimena@gmail.com", "comercial@colmena.com", "Ayuda de comercio");
        String respEsperada= "Enviando a comercial";
        String resultado= proceso.comprobar(elCorreo);
        Assertions.assertEquals(respEsperada, resultado);

    }

    @Test
    public void deberiaSerSpam(){
        CompruebaMail proceso= new CompruebaMail();
        Mail elCorreo= new Mail("jimena@gmail.com", "comercial@colmena.com", "Ayuda");
        String respEsperada= "Marcado como spam";
        String resultado= proceso.comprobar(elCorreo);
        Assertions.assertEquals(respEsperada, resultado);

    }

}
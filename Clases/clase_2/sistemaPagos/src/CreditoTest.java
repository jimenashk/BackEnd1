import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreditoTest {
    @Test

    public void esFechaCorrecta(){
        Credito creditoTest  = new Credito(2, 548, 2025, 7, "Credito", 10000d, 0d);
        assertTrue(creditoTest.chequearAutorizacion(1000));
        assertFalse(creditoTest.chequearAutorizacion(30000));
    }
}

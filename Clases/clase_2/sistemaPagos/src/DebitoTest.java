import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DebitoTest {
    @Test

    public void esFechaCorrecta(){
        Debito debitoTest = new Debito(655522025, 545, 2025, 5, "Debito", 10000d);
        assertTrue(debitoTest.chequearAutorizacion(1000d));
        assertFalse(debitoTest.chequearAutorizacion(30000d));

    }
}

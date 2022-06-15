import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class AnimalTest {
    @Test

    public void siElAnimalEsPesado() {
        Animal caballo = new Animal("caballo", "grande", 3000);
        Animal perro = new Animal("perro", "mediano", 20);

        boolean esPesado = caballo.esPesado();
        boolean esPesado1 = perro.esPesado();

        assertEquals(true, caballo.esPesado());
        assertFalse(esPesado1);
    }
    }



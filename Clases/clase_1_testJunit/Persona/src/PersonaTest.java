import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaTest {
    @Test

    public void nombreCorrecto(){
        Persona persona1 = new Persona("Jose", "Perez", 29);
        Persona persona2 = new Persona("Maria", "Rodriguez", 15);

        assertEquals(persona1.mostrarNombre(), "Jose, Perez");
        //assertEquals(persona1.mostrarNombre(), "Jose Rodriguez");

        assertTrue(persona1.esMayor());
        assertFalse(persona2.esMayor());
        //assertFalse(persona1.esMayor());
    }

}
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

public class FlyweightFactoryTest {

    @Test
    public void trianguloVerde(){
        //dado
        Triangulo t1  =FlyweightFactory.getTriangulo("verde");
        Triangulo t2 = FlyweightFactory.getTriangulo("verde");
        int respEsperada = 1;
        //cuando

        //entonces
        Assertions.assertEquals(respEsperada, FlyweightFactory.trianguloMap.size());
    }

}
package flyweight;

import java.util.Random;

public class Bosque {

    private ArbolFactory fabricaDeArboles = new ArbolFactory();
    private final int LIMITE_ARBOLES = 1000000;

    public void plantarArboles(){
        for (int i = 0; i < LIMITE_ARBOLES; i++) {
            fabricaDeArboles.agregarArbol(tipoRandom());

        }
    }
    public void mostrarArboles(){
        fabricaDeArboles.mostrarArbol();
    }

    private String tipoRandom(){
        String[] tipos = {"ornamental", "frutal rojo", "frutal celeste"};
        Random rand = new Random();
        return tipos[rand.nextInt(3)];
    }
}

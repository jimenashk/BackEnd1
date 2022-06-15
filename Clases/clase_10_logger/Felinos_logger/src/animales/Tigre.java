package animales;

import animales.Felino;

public class Tigre extends Felino {

    public Tigre(String nombre, int edad) throws Exception {
        super(nombre, edad);
    }

    @Override
    public void correr() {
        logger.info("El Tigre " + nombre + " esta corriendo.");

    }

    @Override
    public void esMayorA10() {
        if (this.edad >10){
            logger.info(" El Tigre " + nombre + " tiene mas de 10 años.");
        }

    }
}



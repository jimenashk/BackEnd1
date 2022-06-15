package animales;

import animales.Felino;

public class Leon extends Felino {

    private boolean esAlfa;

    public Leon(String nombre, int edad, boolean esAlfa) throws Exception {
        super(nombre, edad);
        this.esAlfa = esAlfa;
        logger.debug("Instanciando leon " + nombre);
    }

    @Override
    public void correr() {
        logger.info("El Leon " + nombre + " esta corriendo.");

    }

    @Override
    public void esMayorA10() {
        if (this.edad > 100 && esAlfa){
            logger.info("El Leon " + nombre + " es el alfa y tiene mas de 10 años.");
        }

    }
}
package Felinos;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        try {
            Tigre tigre1 = new Tigre("Tigre1", 5);
            Tigre tigre2 = new Tigre("Tigre2", 15);

            Leon leon1 = new Leon("Leon1",15,true);
            Leon leon2 = new Leon("Leon2",5,false);

            logger.info("Los Tigres corren.");
            tigre1.correr();
            tigre2.correr();
            logger.info("Los leones corren");
            leon1.correr();
            leon2.correr();
            logger.info("Los Leones son viejos y alfa?");
            leon1.esMayor();
            leon2.esMayor();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
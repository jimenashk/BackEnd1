package ClasedeLoggin;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {
    //debo pasar el log de log4j como atributo e instanciarlo como static
    private static final Logger logger= Logger.getLogger(App.class);
    private List<Integer> listaEnteros;

    public App() {
        listaEnteros = new ArrayList<>();
    }

    public void agregarEntero(Integer n){
        listaEnteros.add(n);
        if (listaEnteros.size()>5){
            //escribir en el log
            logger.info("La lista tiene mas de 5 elementos, elementos totales de la lista: " + listaEnteros.size());
        }
        if (listaEnteros.size()>10){
            logger.info(("La lista tiene mas de 10 elementos, elementos totales de la lista: " + listaEnteros.size()));
        }
        //listaEnteros.isEmpty();
    }
}

package ClasedeLoggin;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ListaPromedio {

    private static final Logger logger = Logger.getLogger(ListaPromedio.class);
    private List<Integer> enteros = new ArrayList<>();

    public ListaPromedio(List<Integer> enteros) throws Exception{
        this.enteros = enteros;
        if (enteros.size()>5){
            logger.info("La lista tiene mas de 5 elementos");
        }
        if (enteros.size()>10){
            logger.info("La lista tiene mas de 10 elementos");
        }
        if (enteros.size() == 0){
            throw new Exception();
        }
    }

    public int promedio(){
        int sum = 0;
        for (Integer entero : enteros) {
            sum = sum + entero;
        }
        int promedio = sum / enteros.size();
        logger.info("El promedio de la lista es: " + promedio);
        return promedio;
    }

    public List<Integer> getEnteros(){
        return enteros;
    }
}

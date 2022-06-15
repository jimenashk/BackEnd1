import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RopaFactory {

    private static Map<String, Ropa> prendas = new HashMap<>();
    private List<Ropa> listaTalleXS = new ArrayList<>();
    private List<Ropa> listaTalleS = new ArrayList<>();
    private List<Ropa> listaTalleM = new ArrayList<>();
    private List<Ropa> listaRopaImportada = new ArrayList<>();
    private List<Ropa> listaRopaEnMalasCondiciones = new ArrayList<>();

    public Ropa getRopa(String talle, String tipo, Boolean esNuevo, String importada) {

        String clave = tipo + talle + esNuevo + importada;


        if (!prendas.containsKey(clave)) {
            Ropa ropa = new Ropa(talle, tipo, esNuevo, importada);
            prendas.put(clave, ropa);
            System.out.println("Prenda creada");
            if (talle.equalsIgnoreCase("XS")) {
                listaTalleXS.add(prendas.get(clave));
            }
            if (talle.equalsIgnoreCase("S")) {
                listaTalleS.add(prendas.get(clave));
            }
            if (talle.equalsIgnoreCase("M")) {
                listaTalleM.add(prendas.get(clave));
            }
            if (importada.equalsIgnoreCase("INTERNACIONAL")) {
                listaRopaImportada.add(prendas.get(clave));
            }
            if (!esNuevo) {
                listaRopaEnMalasCondiciones.add(prendas.get(clave));
            }
            return prendas.get(clave);
        }
        System.out.println("Prenda obtenida");
        return prendas.get(clave);
    }

    public List<Ropa> getListaTalleXS() {
        return listaTalleXS;
    }

    public List<Ropa> getListaTalleS() {
        return listaTalleS;
    }

    public List<Ropa> getListaTalleM() {
        return listaTalleM;
    }

    public List<Ropa> getListaRopaImportada() {
        return listaRopaImportada;
    }

    public List<Ropa> getListaRopaEnMalasCondiciones() {
        return listaRopaEnMalasCondiciones;
    }
}

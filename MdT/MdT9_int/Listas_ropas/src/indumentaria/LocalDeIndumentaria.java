package indumentaria;

import java.util.ArrayList;
import java.util.List;

public class LocalDeIndumentaria {

    private List<Prenda> prendas;
    private PrendaFactory factory;

    public LocalDeIndumentaria() {
        this.prendas = new ArrayList<>();
        this.factory = new PrendaFactory();
    }

    public void agregarPrenda(String talle, String tipo, boolean esNuevo, boolean esImportada){
        prendas.add(factory.crearPrenda(talle, tipo, esNuevo, esImportada));
    }

    public int cantidadPrendas(){
        return prendas.size();
    }

    public void mostrarPrendas(){
        for (Prenda p : prendas) {
            System.out.println(p.toString());

        }
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory()-runtime.freeMemory()) / (1024 * 1024));
    }
}

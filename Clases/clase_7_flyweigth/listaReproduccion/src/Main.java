public class Main {
    public static void main(String[] args) {
        ListaDeReproduccion listaDeCanciones= new ListaDeReproduccion("Musica de Jime");
        CancionFactory factory = new CancionFactory();

        listaDeCanciones.addCancion(factory, "Breezeblock", "Alt J", "indie");
        System.out.println("");
        listaDeCanciones.addCancion(factory, "As it was", "Harry Styles", "pop");
        System.out.println("");
        listaDeCanciones.addCancion(factory, "Elusive", "Black Wave", "r&b");
        System.out.println("");
        listaDeCanciones.addCancion(factory, "Cola", "Arlo Parks", "indie Pop");
        System.out.println("");
        listaDeCanciones.addCancion(factory, "Green & Gold", "Lianne La havas", "indie Pop");
        System.out.println("");
        //System.out.println(listaDeCanciones.getLista().get(0).getNombre());
        //System.out.println(listaDeCanciones.getLista().get(1).getNombre());
        //System.out.println(listaDeCanciones.getLista().get(2).getNombre());
        //System.out.println(listaDeCanciones.getLista().get(3).getNombre());
        //System.out.println(listaDeCanciones.getLista().get(4).getNombre());
        //System.out.println("");
        listaDeCanciones.mostrarLista();
    }
}

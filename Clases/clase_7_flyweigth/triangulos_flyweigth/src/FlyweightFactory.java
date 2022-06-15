import java.util.HashMap;

public class FlyweightFactory {

    //guardar los triangulos creados
    //metodo factory para crear

    public static final HashMap<String, Triangulo> trianguloMap = new HashMap<>();

    public static Triangulo getTriangulo(String color){
        if (!trianguloMap.containsKey(color)){
            trianguloMap.put(color, new Triangulo(color));
            System.out.println("El Triangulo creado es de color: " + color);
            return trianguloMap.get(color);
                    }
        System.out.println("El triangulo recuperado es de color: " + color);
        return trianguloMap.get(color);


    }
}

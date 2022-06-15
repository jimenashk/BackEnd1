package serializacion;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    //metodo para q m traiga 15 perritos
 private static  List<Perro> crearColeccion15Perros(){
     List<Perro> perritos = new ArrayList<>();
     String nombre;
     int edad;
     HashMap<Integer, String> nombrePosibles = new HashMap<>();
     nombrePosibles.put(1, "Dana");
     nombrePosibles.put(2, "Sasha");
     nombrePosibles.put(3, "Daisy");
     nombrePosibles.put(4, "Niska");
     nombrePosibles.put(5, "Puky");
     nombrePosibles.put(6, "Garfield");
     nombrePosibles.put(7, "Bijou");
     nombrePosibles.put(8, "Calipso");
     nombrePosibles.put(9, "Mojito");
     nombrePosibles.put(10, "Gogol");
     nombrePosibles.put(11, "Michu");
     nombrePosibles.put(12, "Lupita");
     nombrePosibles.put(13, "Roco");
     nombrePosibles.put(14, "Aika");
     nombrePosibles.put(15, "Uma");
     nombrePosibles.put(16, "Priya");
     nombrePosibles.put(17, "blacky");
     nombrePosibles.put(18, "loba");
     nombrePosibles.put(19, "Danushka");
     nombrePosibles.put(20, "Tuki");

     for (int i = 1; i <= 15; i++) {
         //buscar una edad random
         edad = (int)(Math.random()*17-1)+1;
         //buscar un nombre random
         nombre = nombrePosibles.get((int)(Math.random()*20-1)+1);

         //crear el objeto perro con los datos anteriores
         Perro can = new Perro(edad, nombre);
         //agregar el objeto a la coleccion
         perritos.add(can);
     }
     return perritos;

 }
    public static void main(String[] args) {

        //crear coleccion de perros
        List<Perro> canes = new ArrayList<>();
        canes = crearColeccion15Perros();
        //canes.add(new Perro(5, "Luba"));
       // canes.add(new Perro(2, "Milo"));
        //canes.add(new Perro(4, "Lucy"));
        //canes.add(new Perro(9, "Miyagi"));
       // canes.add(new Perro(1, "Yuko"));

        //guardar en archivo la coleccion
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("PerritosGuardados.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(canes);
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //recuperar la coleccion desde un archivo a otra coleccion en Java
        List<Perro> canesRecuperados = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("PerritosGuardados.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            canesRecuperados = (List<Perro>) ois.readObject();
            ois.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //mostrar la coleccion recuperada mediante consola
        for (Perro perro : canesRecuperados) {
            System.out.println(perro.toString());

        }
    }
}

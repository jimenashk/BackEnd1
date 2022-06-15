import java.io.*;

public class Main {
    public static void main(String[] args) {
        //crear una empresa
        Empresa empresa = new Empresa("14-65452354-7", "Super-Mall S.A");
        //cargar los 4 empleados
        Empleado empleado1 = new Empleado("Mariana", "Perez", 1, 70500);
        Empleado empleado2 = new Empleado("Lucas", "Martinez", 2, 55000);
        Empleado empleado3 = new Empleado("Matias", "Roque", 3, 45250);
        Empleado empleado4 = new Empleado("Natalia", "Molina", 4, 65500);

        empresa.agregarEmpleado(empleado1);
        empresa.agregarEmpleado(empleado2);
        empresa.agregarEmpleado(empleado3);
        empresa.agregarEmpleado(empleado4);

        System.out.println("-CUIT: "+ empresa.getCuit()+ " -Razon Social: " + empresa.getRazonSocial() );

        //guardar los empleados en un archivo separados por ";"
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("Empleados.txt");

            //buffer lugar temporario hasta q s define hacia dnd va la info
            //para escribir el archivo, el buffer se encarga de escribir o leer el mismo
            //escribe varios bytes al mismo tiempo
            BufferedOutputStream buffer = new BufferedOutputStream(fos);

            for (Empleado empleado : empresa.getEmpleados()) {
                //recorriendo empleado a empleado
                String linea = empleado.toString() + "\n";
                buffer.write(linea.getBytes());
                System.out.println(linea);
            }
            buffer.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

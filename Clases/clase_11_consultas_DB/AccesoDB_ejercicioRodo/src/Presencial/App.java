package Presencial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.PrimitiveIterator;

public class App {
    //preparar sentencias sql para trabajar cn la tabla
    //CREAR LA TABLA USUARIO. el drop es para borrar si existia alguna anterior con
    //ese nombre, y la vuelve a crear

    private static final  String SQL_CREATE_TABLE= "DROP TABLE IF EXISTS USUARIO; CREATE TABLE USUARIO"
            + "("
            + " ID INT PRIMARY KEY,"
            + " PRIMER_NOMBRE varchar(100) NOT NULL,"  //el not null es para q si o si s ingrese algun valor en ese campo
            + " APELLIDO varchar(100) NOT NULL,"
            + " EDAD INT NOT NULL"
            + " )";

    //ingresar a tabla usuarios, un usuario:
    private static final String SQL_INSERT1="INSERT INTO USUARIO (ID, PRIMER_NOMBRE, APELLIDO, EDAD) VALUES (1, 'Pedro', 'Tapia', 55)";
    private static final String SQL_INSERT2="INSERT INTO USUARIO (ID, PRIMER_NOMBRE, APELLIDO, EDAD) VALUES (2, 'Maria', 'Lopez', 24)";
    private static final String SQL_INSERT3="INSERT INTO USUARIO (ID, PRIMER_NOMBRE, APELLIDO, EDAD) VALUES (3, 'Laura', 'Razzo', 45)";
    //Como hacer consulta en sql
    private static final String SQL_SELECT= " SELECT * FROM USUARIO";

    //configurar conexion a base d datos:
    //agregar throws exception para que el"for name" y el "get connection" no me tiren error
    public static Connection getConection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/base", "sa", "sa");
    }

        //ejecutar un metodo main c/ una exception para hacer pruebas y conectarnos
        public static void main(String[] args) throws Exception {
            Connection connection = null; //no apunta a nada
            //hacer try and catch porque hay una excepcion
            try {
                //invocamos la conexion de la linea 34
                connection = getConection();
                //preparo para ejecutar la consulta
                Statement statement = connection.createStatement();
                statement.execute(SQL_CREATE_TABLE); //LLAMO LA TABLA

                Statement statement2 = connection.createStatement();
                statement2.execute(SQL_INSERT1); //checkeo la insercion dl usuario en la linea 22
                statement2.execute(SQL_INSERT2);
                statement2.execute(SQL_INSERT3);

                //traer la informacion de la tabla con resultSet
                Statement statement3 = connection.createStatement();
                //vamos a guardar lo q viene de la tabla
                ResultSet rs = statement3.executeQuery(SQL_SELECT); //Llamo al select d la linea 24 para ver lo q ingrese

                //mostrar la info
                //moverse un elemento mas en la fila y t devuelve si hay un elemento
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("ID") + " -Nombre: " + rs.getString(2));
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                connection.close(); //se ejecuta siempre el finally, se libera la conexion
            }

    }

}

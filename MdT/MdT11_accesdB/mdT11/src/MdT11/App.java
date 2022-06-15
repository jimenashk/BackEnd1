package MdT11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.PrimitiveIterator;

public class App {

    private static final  String SQL_CREATE_TABLE="DROP TABLE IF EXISTS FIGURAS; CREATE TABLE FIGURAS "
            + "("
            + " ID INT PRIMARY KEY,"
            + " FIGURA varchar(100) NOT NULL,"  //el not null es para q si o si s ingrese algun valor en ese campo
            + " COLOR varchar(100) NOT NULL"
            + " )";

    private static final String SQL_INSERT1="INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES (1, 'Circulo', 'Rojo')";
    private static final String SQL_INSERT2="INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES (2, 'Circulo', 'Verde')";
    private static final String SQL_INSERT3="INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES (3, 'Cuadrado', 'Azul')";
    private static final String SQL_INSERT4="INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES (4, 'Cuadrado', 'Amarillo')";
    private static final String SQL_INSERT5="INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES (5, 'Cuadrado', 'Naranja')";

    private static final String SQL_SELECT= " SELECT * FROM FIGURAS";


    public static Connection getConection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/base", "sa", "sa");
    }

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        try {
            connection = getConection();

            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            Statement statement2 = connection.createStatement();
            statement2.execute(SQL_INSERT1);
            statement2.execute(SQL_INSERT2);
            statement2.execute(SQL_INSERT3);
            statement2.execute(SQL_INSERT4);
            statement2.execute(SQL_INSERT5);

           Statement statement3 = connection.createStatement();
           ResultSet rs = statement3.executeQuery(SQL_SELECT);


            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") + " -Figura: " + rs.getString(2) + " -Color: " + rs.getString(3));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            connection.close();
        }

    }

}

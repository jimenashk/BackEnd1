import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestBD {
    public static void main(String[] args) throws Exception{
        //crear conexion con la base de datos
        Class.forName("org.h2.Driver").newInstance();
        Connection connection = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "myPassword");
        Statement stat = connection.createStatement();

        //crear tabla en la base de datos
        String createTable = "DROP TABLE IF EXISTS TEST; CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255))";
        stat.execute(createTable);

        //insertar datos en la tabla, insertar filas
        String insertFila = "INSERT INTO TEST VALUES(1, ' HOLA :)')";
        String insertFila2 = "INSERT INTO TEST VALUES(2, ' CHAU')";

        stat.execute(insertFila);
        stat.execute(insertFila2);

        //sentencia query para obtener los datos q ingresamos en la BD
        String sql = "SELECT * FROM TEST";
        stat.executeQuery(sql);
        ResultSet rd = stat.executeQuery(sql);
        while(rd.next()){
            System.out.println(rd.getInt(1) + rd.getString(2));

        }


    }
}

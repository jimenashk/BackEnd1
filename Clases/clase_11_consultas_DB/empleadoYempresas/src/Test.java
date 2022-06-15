import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.lang.Class;

public class Test {

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS EMPLEADO; CREATE TABLE EMPLEADO "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " EMPRESA varchar(100) NOT NULL, "
            + " EDAD INT NOT NULL,"
            + " FECHA_INICIO varchar(100) NOT NULL"
            + " )";

    private static final String SQL_INSERT1 = "INSERT INTO EMPLEADO (ID, NOMBRE, EMPRESA, EDAD, FECHA_INICIO) VALUES (1,'Javier','Digital',28,'12/10/2020')";
    private static final String SQL_INSERT2 = "INSERT INTO EMPLEADO (ID, NOMBRE, EMPRESA, EDAD, FECHA_INICIO) VALUES (2,'Pepe','Facebook',40,'09/11/2020')";
    private static final String SQL_INSERT3 = "INSERT INTO EMPLEADO (ID, NOMBRE, EMPRESA, EDAD, FECHA_INICIO) VALUES (3,'Diego','Google',33,'12/20/2021')";

    private static final String SQL_SELECT= " SELECT * FROM EMPLEADO";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/base", "sa", "sa");
    }

    public static void main(String[] args) throws Exception {
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            Statement statement1 = connection.createStatement();
            statement1.execute(SQL_INSERT1);

            Statement statement2 = connection.createStatement();
            statement2.execute(SQL_INSERT2);


            Statement statement3 = connection.createStatement();
            statement3.execute(SQL_INSERT3);

            Statement sqlSmt = connection.createStatement();
            ResultSet rs = sqlSmt.executeQuery(SQL_SELECT);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + "-Nombre: " +  rs.getString(2) + " -Empresa: " +  rs.getString(3) + " -Edad: " +  rs.getInt(4) + " -Fecha Ingreso: " + rs.getString(5));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }
}
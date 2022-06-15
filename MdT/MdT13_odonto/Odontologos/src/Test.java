import ConsultasYTransaccionesDB.Odontologo;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Test {

    private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS ODONTOLOGO; CREATE TABLE ODONTOLOGO"
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL,"
            + " APELLIDO varchar(100) NOT NULL,"
            + " MATRICULA varchar(100) NOT NULL"
            + ")";

    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGO (ID, NOMBRE, APELLIDO, MATRICULA) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE ODONTOLOGO SET MATRICULA=? WHERE ID=?";

    public static void main(String[] args) throws Exception {
        Odontologo odontologo = new Odontologo("Liliana", "Grosso", "12345ABC");

        Connection connection = null;

        try {
            //conectamos y creamos la tabla
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE);

            //insertar datos en la tabla
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1, 1);
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.setString(4, odontologo.getMatricula());

            psInsert.execute();

            connection.setAutoCommit(false);

            PreparedStatement ps1 = connection.prepareStatement(SQL_UPDATE);
            String nuevaMatricula = "-Nueva Matricula:ABC6548";
            ps1.setString(1, nuevaMatricula);
            ps1.setInt(2, 1);
            ps1.execute();


            //generamos un error para chekear el funcionamiento del rollback
            //int a = 4 /1;

            connection.commit();
            connection.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback(); //no olvidarse esta linea!!!!

        } finally {
            connection.close();
        }

        Connection connection1 = getConnection();
        Statement statement = connection1.createStatement();
        String sql = "SELECT * FROM ODONTOLOGO";
        ResultSet rd = statement.executeQuery(sql);

        while (rd.next()) {
            System.out.println(rd.getString(1)
                    + " " + rd.getString(2)
                    + " " + rd.getString(3)
                    + " " +  rd.getString(4));


        }
    }

        //metodo de connection
        private static Connection getConnection() throws Exception{
            Class.forName("org.h2.Driver").newInstance();
            return DriverManager.getConnection("jdbc:h2:" +
                    "~/test", "sa", "");
        }


        }




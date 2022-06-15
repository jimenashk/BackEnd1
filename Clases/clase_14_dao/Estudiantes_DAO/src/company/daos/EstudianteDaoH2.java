package company.daos;

import company.entidades.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDaoH2 implements IDao<Estudiante> {
    //conectamos con la base d datos q creamos para estudiantes
    private final static  String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_estudiantes";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Estudiante guardad(Estudiante estudiante) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        //1 levantar el driver y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 crear una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO estudiantes VALUES (?,?,?)");
            preparedStatement.setLong(1, estudiante.getId());
            preparedStatement.setString(2, estudiante.getNombre());
            preparedStatement.setString(3, estudiante.getApellido());

            //ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiante;

    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //1 levantar el driver y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 crear una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM estudiantes WHERE ID=?");
            preparedStatement.setLong(1, id);

            //ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public Estudiante buscar(Long id) {  //me trae solo UN estudiante
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Estudiante estudiante = null;

        //1 levantar el driver y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes WHERE ID=?");
            preparedStatement.setLong(1, id);

            //ejecutar la sentencia
            ResultSet resul = preparedStatement.executeQuery();

            //evaluar los resultados
            while(resul.next()){
                Long idEstudiante = resul.getLong("id");
                String nombre = resul.getString("nombre");
                String apellido = resul.getString("apellido");
                estudiante = new Estudiante();
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);
            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiante;
        }


    @Override
    public List<Estudiante> buscarTodos() { //me trae TODOS los estudiantes
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        List<Estudiante> estudiantes = new ArrayList();


        //1 levantar el driver y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes");

            //ejecutar la sentencia
            ResultSet resul = preparedStatement.executeQuery();

            //evaluar los resultados
            while(resul.next()){
                Long idEstudiante = resul.getLong("id");
                String nombre = resul.getString("nombre");
                String apellido = resul.getString("apellido");

                Estudiante estudiante = new Estudiante();
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);

                estudiantes.add(estudiante);
            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiantes;
    }
}

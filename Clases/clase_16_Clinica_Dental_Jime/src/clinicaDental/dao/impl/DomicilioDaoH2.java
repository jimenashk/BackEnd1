package clinicaDental.dao.impl;

import clinicaDental.dao.IDao;
import clinicaDental.model.Domicilio;
import clinicaDental.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    //con la instruccion INIT=RUNSCRIPT cuando se conecta a la base ejecuta el script de sql que esta en dicho archivo
    private final static String DB_URL = "jdbc:h2:~/db_dental;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    private static Logger logger = Logger.getLogger(DomicilioDaoH2.class);

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        logger.debug("Ejecucion metodo guardar-Domicilio");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia especificando que el ID lo auto incrementa la base de datos y que nos devuelva esa Key es decir ID
            preparedStatement = connection.prepareStatement("INSERT INTO domicilios(calle,numero,localidad,provincia) VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            //preparedStatement.setInt(1,domicilio.getId());
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setString(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());

            //3 Ejecutar una sentencia SQL y obtener los ID que se autogeneraron en la base de datos
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next())
                domicilio.setId(keys.getInt(1));

            preparedStatement.close();
            logger.info("Domicilio guardado con exito");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("ERROR: " + throwables.getMessage());
        }
        return domicilio;
    }

    @Override
    public Domicilio buscar(int id) {
        logger.debug("Ejecucion metodo buscar-Domicilio");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Domicilio domicilio = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT id,calle,numero,localidad,provincia FROM domicilios where id = ?");
            preparedStatement.setInt(1,id);

            ResultSet resul = preparedStatement.executeQuery();

            while(resul.next()){
                int idDomicilio = resul.getInt("id");
                String calle = resul.getString("calle");
                String numero = resul.getString("numero");
                String localidad = resul.getString("localidad");
                String provincia = resul.getString("provincia");

                domicilio = new Domicilio(idDomicilio,calle,numero,localidad,provincia);

        }
            preparedStatement.close();
            logger.info("Se encontro el domicilio con exito");

    } catch (SQLException | ClassNotFoundException throwables) {
        throwables.printStackTrace();
    }
        return domicilio;
    }

    @Override
    public void eliminar(int id) {
        logger.debug("Ejecucion metodo eliminar-Domicilio");
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM domicilios where id = ?");
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            logger.info("Se elimino el domicilio correctamente");

         } catch (SQLException | ClassNotFoundException throwables) {
        throwables.printStackTrace();
        logger.error("ERROR: " + throwables.getMessage());
    }

    }

    @Override
    public List<Domicilio> buscarTodos() {
        logger.debug("Ejecucion metodo buscarTodos-Domicilios");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Domicilio> domicilios = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT *  FROM domicilios");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int idDomicilio = result.getInt("id");
                String calle = result.getString("calle");
                String numero = result.getString("numero");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");

                Domicilio domicilio = new Domicilio(idDomicilio, calle, numero, localidad, provincia);

                domicilios.add(domicilio);
            }
                preparedStatement.close();
            logger.info("se listaron los domicilios correctamente");
            logger.info("Conexion finalizada.");

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
                logger.error("ERROR: " + throwables.getMessage());
            }

            return domicilios;

            }


}

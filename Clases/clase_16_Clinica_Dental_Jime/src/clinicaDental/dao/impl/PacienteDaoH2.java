package clinicaDental.dao.impl;

import clinicaDental.dao.IDao;
import clinicaDental.model.Domicilio;
import clinicaDental.model.Paciente;
import clinicaDental.util.Util;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    //con la instruccion INIT=RUNSCRIPT cuando se conecta a la base ejecuta el script de sql que esta en dicho archivo
    private final static String DB_URL = "jdbc:h2:~/db_dental;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    private DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
    private static Logger logger = Logger.getLogger(PacienteDaoH2.class);

    @Override
    public Paciente guardar(Paciente paciente) {
        logger.debug("Ejecucion metodo guardar-Paciente");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //guardar el domicilio del paciente
            //necesitamos el ID del domicilio que se generará en la base de datos para luego
            //insertar ese id en el campo domicilio_id de la tabla pacientes
            Domicilio domicilio = domicilioDaoH2.guardar(paciente.getDomicilio());
            paciente.getDomicilio().setId(domicilio.getId());

            //2 sentencia especificando que el ID lo auto incrementa la base de datos y que nos devuelva esa Key es decir ID
            preparedStatement = connection.prepareStatement("INSERT INTO pacientes(nombre,apellido,dni,fecha_ingreso,domicilio_id) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            //preparedStatement.setInt(1,paciente.getId());
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDni());
            //Hay que convertir el Date en sql.Date ya que son dos clases diferentes en Java
            preparedStatement.setDate(4, Util.utilDateToSqlDate(paciente.getFechaIngreso()));
            //Tenemos que pasarle la clave foranea del ID del domicilio es decir el campo domicilio_id
            preparedStatement.setInt(5, paciente.getDomicilio().getId());

            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()) {
                paciente.setId(keys.getInt(1));

                preparedStatement.close();
                logger.info("Paciente guardado con exito");
            }

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
                logger.error("ERROR: " + throwables);
            }
            return paciente;
        }

    @Override
    public Paciente buscar(int id) {
        logger.debug("Ejecucion metodo buscar-Paciente");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente =null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT id,nombre,apellido,dni,fecha_ingreso,domicilio_id  FROM pacientes where id = ?");
            preparedStatement.setInt(1,id);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                int idPaciente = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String dni = result.getString("dni");
                Date fechaIngreso = result.getDate("fecha_ingreso");
                int idDomicilio = result.getInt("domicilio_id");
                //Con el domicilio_id traemos el domicilio de la tabla domicilio a traves de DAO de Domicilios
                Domicilio domicilio = domicilioDaoH2.buscar(idDomicilio);
                paciente = new Paciente(idPaciente,nombre,apellido,dni,fechaIngreso,domicilio);
            }

            preparedStatement.close();
            logger.info("Paciente encontrado con exito");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("ERROR: " + throwables.getMessage());
        }

        return paciente;
    }

    @Override
    public void eliminar(int id) {
        logger.debug("Ejecucion metodo eliminar-Paciente");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM pacientes where id = ?");
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            logger.info("Paciente eliminado con exito");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("ERROR: " + throwables.getMessage());
        }

    }

    @Override
    public List<Paciente> buscarTodos() {
        logger.info("Ejecucion metodo buscarTodos-Pacientes");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Paciente> pacientes = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT *  FROM pacientes");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                int idPaciente = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String dni = result.getString("dni");
                Date fechaIngreso = result.getDate("fecha_ingreso");
                int idDomicilio = result.getInt("domicilio_id");
                //con el domicilio_id traemos el domicilio de la tabla domicilio
                Domicilio domicilio = domicilioDaoH2.buscar(idDomicilio);
                Paciente paciente = new Paciente(idPaciente,nombre,apellido,dni,fechaIngreso,domicilio);
                pacientes.add(paciente);

                preparedStatement.close();
                logger.info("Pacientes listados con exito");
                logger.info("Conexion finalizada");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("ERROR: " + throwables.getMessage());
        }

        return pacientes;
    }


}

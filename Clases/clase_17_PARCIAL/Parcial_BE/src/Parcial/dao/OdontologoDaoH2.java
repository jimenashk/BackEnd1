package Parcial.dao;

import Parcial.model.Odontologo;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2  implements  IDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO odontologos VALUES (?,?,?,?)");
            preparedStatement.setInt(1, odontologo.getId());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.setString(4, odontologo.getNumeroMatricula());
            logger.debug("Ejecucion metodo guardar-Odontologo");

            preparedStatement.executeUpdate();
            logger.info("Odontologo guardado con exito");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR: " + e.getMessage());
        } finally {
            try {
                connection.close();
                logger.info("Conexion finalizada");
            } catch (SQLException ex) {
                ex.printStackTrace();
                logger.error("ERROR: " + ex.getMessage());
            }

        return odontologo;
    }

}

    @Override
    public List<Odontologo> buscarTodos() {
        logger.debug("Ejecucion metodo listar-Odontologos");
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM odontologos");

            ResultSet resul = preparedStatement.executeQuery();
            while (resul.next()) {
                Integer id = resul.getInt("id");
                String nombre = resul.getString("nombre");
                String apellido = resul.getString("apellido");
                String matricula = resul.getString("matricula");
                Odontologo odontologo = new Odontologo(id,nombre,apellido,matricula);
                odontologos.add(odontologo);
                logger.info("Se guardo con exito el odontologo: " + nombre + " " + apellido);

            }
            preparedStatement.close();
            logger.info("Odontologos Listados con exito");

        } catch (Exception e){
            e.printStackTrace();
            logger.error("ERROR: " + e.getMessage());
        }finally {
            try {
               connection.close();
                logger.info("conexion finalizada");
            } catch (SQLException e){
                logger.error("ERROR SQL: " + e.getMessage());
            }
        }
        return odontologos;
    }

    private static Connection getConnection() throws Exception{
        logger.info("Conectandose a la base de datos");
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/odonto_logia;INIT= RUNSCRIPT FROM 'create.sql'","sa","");

    }
}

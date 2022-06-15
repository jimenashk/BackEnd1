package Parcial.Dao;

import Parcial.Modelo.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {
    private static final Logger logger= Logger.getLogger(OdontologoDaoH2.class);
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Metodo guardar de odontologoDaoH2");
        Connection connection=null;
        try {
            connection=getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO odontologos VALUES(?,?,?,?)");
            preparedStatement.setInt(1,odontologo.getId());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());
            preparedStatement.setString(4,odontologo.getNumeroMatricula());

              preparedStatement.executeUpdate();
              logger.info("Odontologo guardado");

        }catch (Exception e){
            e.printStackTrace();
            logger.error("error: "+ e.getMessage());
        }finally {
            try {
                connection.close();
                logger.info("Conexion cerrada");
            }catch (SQLException ex){
                ex.printStackTrace();
                logger.error("error: "+ex.getMessage());
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        logger.info("Metodo listar()");
        List<Odontologo> odontologos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");

            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                Integer id = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String matricula = result.getString("matricula");
                odontologos.add(new Odontologo(id,nombre,apellido,matricula));
                logger.info("Se guardo con exito el odontologo: "+ nombre);
            }
            preparedStatement.close();

        }  catch (Exception e) {
            e.printStackTrace();
            logger.error("error: "+ e.getMessage());
        } finally {
            try {
                connection.close();
                logger.info("conexion cerrada");
            } catch (SQLException e) {
                logger.error("error SQL: "+e.getMessage());
            }
        }
        return odontologos;
        }




    private static Connection getConnection() throws Exception{
        logger.info("Conectandose a la base de datos");
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/RissBelen;INIT= RUNSCRIPT FROM 'create.sql'","sa","sa");

    }

}

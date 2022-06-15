package aerolinea.daos.impl;

import aerolinea.daos.IDao;
import aerolinea.model.Avion;
import org.apache.log4j.Logger;
import java.sql.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class AvionDaoH2 implements IDao<Avion> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_aviones;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";
    private static Logger logger = Logger.getLogger(AvionDaoH2.class);

    @Override
    public Avion guardar(Avion avion) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO avion(marca, modelo, matricula, fecha_alta_servicio) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            //preparedStatement.setLong(1, avion.getId());

            //instanciar
            preparedStatement.setString(1, avion.getMarca());
            preparedStatement.setString(2, avion.getModelo());
            preparedStatement.setString(3, avion.getMatricula());
            preparedStatement.setString(4, avion.getFechaAltaServicio());

            logger.debug("------------- CARGANDO AVION ------------------");

            //ejecutar y obtener
            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next())
                avion.setId(keys.getLong(1));
            logger.info("Se cargo el Avion " + avion.getMarca() + " " + avion.getModelo() + ", con id " + avion.getId());

            preparedStatement.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            logger.error(e);

        }
        return avion;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM avion WHERE id = ?");
            logger.debug("------------- BUSCANDO AVION ------------------");
            //set
            preparedStatement.setLong(1, id);
            //ejecuto
            preparedStatement.executeUpdate();
            preparedStatement.close();
            logger.info("------------- AVION ELIMINADO ------------------");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error(throwables);
        }

    }

    @Override
    public Avion buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Avion avion = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM avion WHERE id = ?");
            //seteo
            preparedStatement.setLong(1, id);
            //ejecuto
            ResultSet resul = preparedStatement.executeQuery();
            //evaluamos
            while (resul.next()) {
                Long idAvion = resul.getLong("id");
                String marca = resul.getString("marca");
                String modelo = resul.getString("modelo");
                String matricula = resul.getString("matricula");
                String fechaAltaServicio = resul.getString("Fecha alta Servicio");

                avion = new Avion(marca, modelo, matricula, fechaAltaServicio);
                logger.info("AVION ENCONTRADO");
                logger.info("El Avion:" + idAvion + " " + marca + " " + modelo + ", con numero de matricula " + matricula + " Fue encontrado");

            }
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            logger.error(throwables);
            throwables.printStackTrace();

        }
        return avion;
    }


    @Override
    public List<Avion> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Avion> aviones = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM avion");
            //ejecuto
            ResultSet resul = preparedStatement.executeQuery();
            logger.info("Aviones encontrados con exito");
            //evaluo
            while (resul.next()) {
                Long idAvion = resul.getLong("id");
                String marca = resul.getString("marca");
                String modelo = resul.getString("modelo");
                String matricula = resul.getString("matricula");
                String fechaAlta = resul.getString("Fecha Alta Servicio");
                // si encuentra
                Avion avion = new Avion(marca, modelo, matricula, fechaAlta);
                //guardo en array
                aviones.add(avion);
                logger.info("Avion:" + idAvion + " " + marca + " " + modelo + ", numero matricula " + matricula + " Fue encontrado");

            }
            preparedStatement.close();


            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error(throwables);

        }
        return aviones;
    }
}
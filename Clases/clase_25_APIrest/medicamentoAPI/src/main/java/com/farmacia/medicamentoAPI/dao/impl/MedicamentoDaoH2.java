package com.farmacia.medicamentoAPI.dao.impl;
import com.farmacia.medicamentoAPI.bd.BD;
import com.farmacia.medicamentoAPI.dao.IDao;
import com.farmacia.medicamentoAPI.model.Medicamento;
import org.apache.log4j.Logger;
import java.sql.*;
import java.lang.*;

public class MedicamentoDaoH2 implements IDao<Medicamento> {

    //para loguear no olvidar:
    private static Logger logger = Logger.getLogger(MedicamentoDaoH2.class);

    public MedicamentoDaoH2(BD bd) {

    }

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        logger.debug("Ejecucion metodo guardar-medicamento");

        Connection connection = null;

        try {
            //conectarnos a la base
            connection = getConnection();
            //preparar la operacion
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicamentos (id, nombre, laboratorio, cantidad, precio, codigo_numero) VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, medicamento.getNombre());
            preparedStatement.setString(3, medicamento.getLaboratorio());
            preparedStatement.setInt(4, medicamento.getCantidad());
            preparedStatement.setDouble(5, medicamento.getPrecio());
            preparedStatement.setInt(6, medicamento.getCodigoNumerico());

            //ejecutar
            preparedStatement.executeUpdate();
            preparedStatement.close();
            logger.info("Medicamento guardado con exito");


        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR: "+ e.getMessage());

        } finally {
            try {
                connection.close();
            } catch (SQLException t) {
                t.printStackTrace();
                logger.error("ERROR SQL: "+ t.getMessage());

            }
        }
        return medicamento;
    }

    @Override
    public Medicamento buscar(Integer id) {
        logger.debug("Ejecucion metodo buscar-medicamento, ID: " + id);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Medicamento medicamento = null;

        try {
            connection = getConnection();

            //preparar la operacion
            preparedStatement = connection.prepareStatement("SELECT id, nombre, laboratorio, cantidad, precio, codigo_numero FROM medicamentos where id = ?");
            preparedStatement.setInt(1, id);

            //ejecutar
            ResultSet result = preparedStatement.executeQuery();

            //Obtener resultados
            while (result.next()) {
                int idMedicamento = result.getInt("id");
                String nombre = result.getString("nombre");
                String laboratorio = result.getString("laboratorio");
                Integer cantidad = result.getInt("cantidad");
                Double precio = result.getDouble("precio");
                int codigo = result.getInt("codigo_numero");
                medicamento = new Medicamento(idMedicamento, nombre, laboratorio, cantidad, precio, codigo);
            }

            preparedStatement.close();
            logger.info("Medicamento encontrado con exito");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR: "+ e.getMessage());

        }

        return medicamento;
    }

   private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/farma", "sa", "");
    }
}

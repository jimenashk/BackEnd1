package com.dh.integradora.dao.impl;

import com.dh.integradora.dao.IDao;
import com.dh.integradora.dominio.Domicilio;
import com.dh.integradora.dominio.Odontologo;
import com.dh.integradora.dominio.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clase23", "sa", "");
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public List<Odontologo> listarElementos() {
        Connection connection = null;
        List<Odontologo> listaOdontologos = new ArrayList<>();
        Odontologo odontologo;


        //conectarnos
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes");
            ResultSet rs = preparedStatement.executeQuery();
            //ejecutar recorrido
            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                listaOdontologos.add(odontologo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaOdontologos;
    }


    @Override
    public Odontologo buscarId(int id) {
        return null;
    }

    @Override
    public Odontologo buscarEmail(String email) {
        return null;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return null;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        return null;
    }
}

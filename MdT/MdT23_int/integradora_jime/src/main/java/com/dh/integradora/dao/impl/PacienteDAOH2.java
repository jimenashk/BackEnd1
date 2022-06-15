package com.dh.integradora.dao.impl;

import com.dh.integradora.dao.IDao;
import com.dh.integradora.dao.impl.DomicilioDAOH2;
import com.dh.integradora.dominio.Domicilio;
import com.dh.integradora.dominio.Odontologo;
import com.dh.integradora.dominio.Paciente;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteDAOH2 implements IDao<Paciente> {

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clase23", "sa", "");
    }

    @Override
    public List<Paciente> listarElementos() {
        Connection connection = null;
        List<Paciente> listaPacientes = new ArrayList<>();
        Paciente paciente;
        Domicilio domicilio;

        //conectarnos
        try {
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes");
            ResultSet rs = preparedStatement.executeQuery();
            //ejecutar recorrido
            while (rs.next()) {
                domicilio = domicilioDAOH2.buscarId(rs.getInt(7));
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6).toLocalDate(), domicilio);
                listaPacientes.add(paciente);
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
        return listaPacientes;
    }

    @Override
    public Paciente buscarId(int id) {
        Connection connection = null;
        Paciente paciente =null;
        Domicilio domicilio;

        try {
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            connection= getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                domicilio = domicilioDAOH2.buscarId(rs.getInt(7));
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6).toLocalDate(), domicilio);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return paciente;
    }


    @Override
    public Paciente buscarEmail(String email) {
        Connection connection = null;
        Paciente paciente = null;
        Domicilio domicilio;
        Odontologo odontologo;

        //conectarnos
        try {
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes WHERE email=?");
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            //ejecutar recorrido
            while (rs.next()) {
                domicilio = domicilioDAOH2.buscarId(rs.getInt(7));
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6).toLocalDate(), domicilio);

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
        return paciente;
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;

        try {
            connection = getConnection();
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();

            Domicilio domicilio = domicilioDAOH2.guardar(paciente.getDomicilio());
            paciente.getDomicilio().setId(domicilio.getId());

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pacientes (nombre, apellido, email, dni, fecha_ingreso, domicilio_id) VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getEmail());
            preparedStatement.setInt(4, paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(6, paciente.getDomicilio().getId());
            preparedStatement.executeUpdate();
            ResultSet claves = preparedStatement.getGeneratedKeys();

            while (claves.next()) {
                paciente.setId(claves.getInt(1));
            }
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return paciente;
    }


    @Override
    public Paciente actualizar(Paciente paciente) {
        Connection connection = null;

        try {
            connection = getConnection();
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            Domicilio domicilio = domicilioDAOH2.actualizar(paciente.getDomicilio());

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE pacientes SET (nombre=?, apellido=?, email=?, dni=?, fecha_ingreso=?, domicilio_id=? WHERE id=?");

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getEmail());
            preparedStatement.setInt(4, paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(6, paciente.getDomicilio().getId());
            preparedStatement.setInt(7, paciente.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;

        try {
            connection = getConnection();
            //eliminar el domicilio co nel id en this.domicilios.getId()
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM pacientes WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
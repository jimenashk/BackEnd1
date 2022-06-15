package com.dh.integradora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class IntegradoraApplication{
//en esta clase creamos metodo para conectar cn la base e invocams el mismo metodo para iniciar la conexion
	private static void cargarBD() {
		//metodo estatico porq invocams este metodo en etsa misma clase
		Connection connection = null;

		try {
			//conectarns para crear la BD
			//poner q s va a dar inicio dsd el file create.sql
			Class.forName("org.h2.Driver").newInstance();
			connection= DriverManager.getConnection("jdbc:h2:~/clase23;INIT=RUNSCRIPT FROM 'create.sql'","sa","");

		} catch (Exception e) {
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

	}

	public static void main(String[] args) {
		cargarBD();
		SpringApplication.run(IntegradoraApplication.class, args);
	}

}
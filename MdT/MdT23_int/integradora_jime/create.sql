DROP TABLE IF EXISTS domicilios;
CREATE TABLE domicilios (ID INT AUTO_INCREMENT PRIMARY KEY,
CALLE varchar(200) NOT NULL,
NUMERO INT NOT NULL,
LOCALIDAD varchar(100) NOT NULL,
PROVINCIA varchar(100) NOT NULL);

DROP TABLE IF EXISTS pacientes;
CREATE TABLE pacientes (ID INT AUTO_INCREMENT PRIMARY KEY,
NOMBRE varchar(100) NOT NULL,
APELLIDO varchar(100) NOT NULL,
EMAIL varchar(100) NOT NULL,
DNI INT NOT NULL,
FECHA_INGRESO DATE NOT NULL,
DOMICILIO_ID INT NOT NULL);

INSERT INTO domicilios (calle, numero, localidad, provincia)
VALUES('Calle A', 4578, 'Cordoba Capital', 'Cordoba');
INSERT INTO domicilios (calle, numero, localidad, provincia)
VALUES('Calle B', 3656, 'Buenos Aires', 'Buenos Aires');

INSERT INTO pacientes (apellido, nombre, email, dni, fecha_ingreso, domicilio_id)
VALUES ('Diego', 'Romero', 'hola@invierno.com', 13654897, '2022-03-01', 1);
INSERT INTO pacientes (apellido, nombre, email, dni, fecha_ingreso, domicilio_id)
VALUES ('Mariela', 'Perez', 'chau@verano.com', 246589754, '2022-06-15', 2);
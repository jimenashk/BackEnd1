CREATE TABLE IF NOT EXISTS avion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca varchar(255) NOT NULL,
    modelo varchar(255) NOT NULL,
    matricula varchar(255) NOT NULL,
    fecha_alta_servicio VARCHAR(255) NOT NULL
 );


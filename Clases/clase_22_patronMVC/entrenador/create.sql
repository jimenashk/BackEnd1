DROP TABLE IF EXISTS entrenadores;
CREATE TABLE entrenadores (ID INT AUTO_INCREMENT PRIMARY KEY,
NOMBRE varchar(100) NOT NULL);
INSERT INTO entrenadores (nombre) VALUES ('Pedro');
INSERT INTO entrenadores (nombre) VALUES ('Juan');
INSERT INTO entrenadores (nombre) VALUES ('Emilia');
INSERT INTO entrenadores (nombre) VALUES ('Diego');
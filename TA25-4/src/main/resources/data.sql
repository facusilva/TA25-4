DROP TABLE IF EXISTS pelicula;
DROP TABLE IF EXISTS sala;

CREATE TABLE pelicula(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre varchar(100),
    calificacion_edad int
);

CREATE TABLE sala(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(100),
    pelicula int,
    FOREIGN KEY (pelicula) REFERENCES pelicula(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pelicula (nombre, calificacion_edad) VALUES ('malditos bastardos', 18);
INSERT INTO sala (nombre, pelicula) VALUES ('sala01', 1);
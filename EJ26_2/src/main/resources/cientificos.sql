DROP DATABASE IF EXISTS cientificos;
CREATE DATABASE cientificos;

USE cientificos;


DROP TABLE IF EXISTS cientificos;
DROP TABLE IF EXISTS asignado;
DROP TABLE IF EXISTS proyecto;

 
CREATE TABLE cientificos (
  dni VARCHAR(8) NOT NULL PRIMARY KEY,
  nom_apels VARCHAR(100)
);



CREATE TABLE proyecto (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre varchar(100),
  horas int
);



CREATE TABLE asignado (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cientifico VARCHAR(8),
  proyecto int,
  precio int,
  FOREIGN KEY (cientifico) REFERENCES cientificos(dni) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (proyecto) REFERENCES proyecto(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO cientificos (dni,nom_apels) VALUES
	("111","Pieza1"),
    ("222","Pieza2"),
    ("333","Pieza3"),
    ("444","Pieza4"),
    ("555","Pieza5");
    
    
INSERT INTO proyecto (nombre,horas) VALUES
	("Proyecto1",5),
    ("Proyecto2",6),
    ("Proyecto3",7),
    ("Proyecto4",10),
    ("Proyecto5",50);
   
    
INSERT INTO asignado (cientifico, proyecto) VALUES
	("111", 1),
    ("222", 2),
    ("333", 3),
    ("444", 4),
    ("555", 5);
    

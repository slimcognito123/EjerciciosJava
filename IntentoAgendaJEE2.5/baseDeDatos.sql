create database if NOT EXISTS agendaweb;
use agendaweb;

create table IF NOT EXISTS usuarios (
nombre VARCHAR(25) PRIMARY KEY,
password VARCHAR(25) NOT NULL);

create table if NOT EXISTS contactos(
id INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(25),
apellidos VARCHAR(25),
telefono CHAR(9),
fecha DATE,
nombreUsuario VARCHAR(25),
CONSTRAINT fk_nom FOREIGN KEY (nombreUsuario) REFERENCES USUARIOS(nombre)
);

INSERT IGNORE INTO USUARIOS VALUES("victor","victor");
INSERT IGNORE INTO CONTACTOS VALUES(null, "paco", "porras", "91959586","2000-02-02", "victor");




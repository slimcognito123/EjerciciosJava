create database if not exists AgendaBD2;
use AgendaBD2;

create table if not exists Agenda(
	id int Auto_increment PRIMARY KEY,
	nombre varchar(30) not null DEFAULT "",
	apellidos varchar(60) not null DEFAULT "",
	telefono varchar(13) not null DEFAULT "",
	FNaci varchar(11) not null DEFAULT "",
	user VARCHAR(20) NOT NULL
);

create TABLE IF NOT EXISTS usuarios(
	NomUsuario VARCHAR(20) not NULL PRIMARY KEY,
	password VARCHAR(20) not NULL
);

alter table Agenda add CONSTRAINT fk_user FOREIGN KEY (user) REFERENCES usuarios(NomUsuario);


insert ignore into usuarios values("patata","contrasena");

insert ignore into Agenda values ("80082504T","Jesus ma","Martin diaz", "000000001","1996-01-23","patata");
insert ignore into Agenda values ("23456726G","Patata Kawaii","Desu-ne nya-nya", "444444444","1990-06-04","patata");
insert ignore into Agenda values ("11111111P","Pepito","Perez :3", "674936475","1995-11-25","patata");

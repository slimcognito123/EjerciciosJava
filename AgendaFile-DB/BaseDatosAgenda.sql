create database if not exists AgendaBD;
use AgendaBD;
create table if not exists Agenda(
  DNI char(9) not null primary key,
  nombre varchar(30) not null,
  apellidos varchar(60) not null,
  telefono varchar(13) not null,
  FNaci varchar(11) not null
);
insert ignore into Agenda values ("80082504T","Jesus ma","Martin diaz", "000000001","1996-01-23");
insert ignore into Agenda values ("23456726G","Patata Kawaii","Desu-ne nya-nya", "444444444","1990-06-04");
insert ignore into Agenda values ("11111111P","Pepito","Perez :3", "674936475","1995-11-25");
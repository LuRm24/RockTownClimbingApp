create database rocktown;
use rocktown;

create table actividad (
	 id bigint primary key auto_increment,
     descripcion varchar(255),
     nombre varchar(255)
);

insert into actividad (nombre, descripcion) values ("Cumpleaños", "Cumpleaños infantiles");

/*
clases de escalada
clases dirigdas adultos
clases dirigidas niños
entrada libre
cumpleaños
*/

drop database if exists rocktown;
create database rocktown;
use rocktown;

create table if not exists actividad (
	 id bigint primary key auto_increment,
     descripcion varchar(255) not null,
     nombre varchar(255) not null
);

insert into actividad (nombre, descripcion) values ("Cumpleaños", "Cumpleaños infantiles");
insert into actividad (nombre, descripcion) values ("Clases dirigidas adultos", "Clases dirigidas para adultos (A partir de 12 años)");
insert into actividad (nombre, descripcion) values ("Clases dirigidas niños", "Clases dirigidas para niños (A partir de 3 años)");
insert into actividad (nombre, descripcion) values ("Entrada libre", "Entrada libre a las instalaciones");

create table if not exists sala (
	id bigint primary key auto_increment,
     descripcion varchar(255) not null,
     nombre varchar(255) not null
);

insert into sala (nombre, descripcion) values ('Planta Superior', 'Estructura de escalada para nivel principiante');
insert into sala (nombre, descripcion) values ('Planta Inverior', 'Estructura de escalada para nivel avanzado');

create table if not exists horario_disponible (
	id bigint primary key auto_increment,
    dia_semana tinyint not null,
    hora_inicio time(6) not null,
    hora_fin time(6) not null,
    actividad_id bigint not null,
    sala_id bigint not null,
    constraint fk_horario_actividad foreign key (actividad_id) references actividad (id),
    constraint fk_horario_sala foreign key (sala_id) references sala (id),
    constraint chk_dia_semana check (dia_semana in (1, 2, 3, 4, 5, 6))
);

create table if not exists empleado (
	id bigint primary key auto_increment,
	nombre varchar(50) not null,
    apellidos varchar(100) not null,
    rol varchar(50) not null, 
    dni char(9) unique not null,
    direccion varchar(100) not null
);

create table if not exists actividad_empleado(
	id_empleado bigint,
    id_horario_disponible bigint, -- relacionado con el horario (diasemana, hora, sala, etc)
    constraint pk_actividad_empleado primary key (id_empleado, id_horario_disponible),
    constraint fk_actividad_empleado foreign key (id_empleado) references empleado (id),
    constraint fk_actividad_horario foreign key (id_horario_disponible) references horario_disponible (id)
);

create table if not exists tipo_entrada(
	id bigint primary key auto_increment,
    tipo enum('entrada', 'bono', 'abono', 'clase', 'cumpleaños') not null,
    descripcion varchar(100) not null,
    publico_destino enum('adulto', 'niño', 'todos') default 'todos',
    frecuencia enum('día', 'mes', 'trimestre', 'semestre', 'año', 'bono', 'evento') default 'día',
    precio decimal(6, 2) not null,
    notas varchar(255)
);

create table if not exists cumpleanos (
    id INT PRIMARY KEY,
    comida_incluida BOOLEAN DEFAULT FALSE,
    bebida_incluida BOOLEAN DEFAULT TRUE,
    max_niños INT DEFAULT 20,
    notas_especificas TEXT,
    constraint fk_cumpleanos_entrada foreign key (id) REFERENCES tipo_entrada (id)
);
    
create table if not exists cliente (
	id bigint primary key auto_increment, 
	nombre varchar(50) not null,
    apellidos varchar(100) not null,
    telefono char(9),
    dni char(9) unique not null,
    fecha_bono date,
    tipo_entrada bigint not null,
    sesiones_gastadas int,
    pie_gato boolean default false,
    menor_edad boolean,
    constraint fk_cliente_entrada foreign key (tipo_entrada) references tipo_entrada (id)
);

create table if not exists usuario (
	id bigint primary key auto_increment, 
    nombre_usuario varchar(50) unique not null,
	email varchar(100) unique,
    contraseña_hash varchar(255) not null,
    rol enum('admin', 'monitor') not null
);


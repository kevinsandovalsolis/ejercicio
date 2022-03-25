CREATE TABLE estado (
	id_estado int not null AUTO_INCREMENT,
	estado varchar,
	PRIMARY KEY (id_estado)
);

CREATE TABLE usuario (
	id_usuario varchar not null,
    nombre varchar,
    correo varchar ,
    password varchar,
	fecha_creacion timestamp,
	fecha_actualizacion timestamp,
	id_estado varchar,
	token varchar,
	PRIMARY KEY (id_usuario),
	FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);

CREATE TABLE telefono (
	id_telefono int not null AUTO_INCREMENT
	id_usuario varchar not null,
    numero varchar,
    codigo_ciudad varchar,
    codigo_pais varchar,
	PRIMARY KEY (id_telefono),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE acceso (
	id_acceso int not null AUTO_INCREMENT,
	id_usuario varchar,
    fecha_ingreso timestamp,
	PRIMARY KEY (id_acceso),
	FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);


insert into estado values (1,'Activo');
insert into estado values (2,'No Activo');


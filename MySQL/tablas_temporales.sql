USE mi_bd;

#Utiliza TABLE para consultar la tabla productos de manera simple, ordenando los productos de forma descendente por precio y solo 10 filas.
TABLE productos
order by precio desc
LIMIT 10;

VALUES ROW('tv', 5000), ROW('monitor', 'abc'), ROW('notebook', 3500);

#Crea una tabla temporal de los empleados donde unifiques su nombre y apellido en una sola columna.
CREATE TEMPORARY TABLE temporal_empleado AS 
SELECT 
concat(nombre," ", apellido)
FROM empleados;
TABLE temporal_empleado;

#DROP TEMPORARY TABLE IF EXISTS tabla_temporal;
#SELECT * FROM tabla_temporal;
#TABLE tabla_temporal;
#DESCRIBE tabla_temporal;

#Crea una tabla temporal de la tabla clientes donde solo tengas la columna nombre.
CREATE TEMPORARY TABLE tabla_temporal_clientes AS 
SELECT 
nombre
FROM clientes;
TABLE tabla_temporal_clientes;

#Realiza la unión entre las tablas temporales de empleados y clientes usando TABLE.
TABLE temporal_empleado UNION TABLE tabla_temporal_clientes;

#Crea una tabla temporal escuela primaria que tenga las siguientes columnas: id(int), nombre(varchar), apellido(varchar), edad(int) y grado(int). Y que tenga los siguientes valores:
CREATE TEMPORARY TABLE temporal_primaria (
Id INT auto_increment key,
nombre VARCHAR(50),
apellido VARCHAR(50),
edad INT,
grado INT
);
DROP TEMPORARY TABLE IF EXISTS temporal_primaria;

insert into temporal_primaria (nombre, apellido, edad, grado) values ('Alejandro', "González", 11, 5);
insert into temporal_primaria (nombre, apellido, edad, grado) values ('Isabella', "López", 10, 4);
insert into temporal_primaria (nombre, apellido, edad, grado) values ('Lucas', "Martínez", 11, 5);
insert into temporal_primaria (nombre, apellido, edad, grado) values ('Sofía', "Rodríguez", 10, 4);
insert into temporal_primaria (nombre, apellido, edad, grado) values ('Mateo', "Pérez", 12, 6);
insert into temporal_primaria (nombre, apellido, edad, grado) values ('Valentina', "Fernández", 12, 6);
insert into temporal_primaria (nombre, apellido, edad, grado) values ('Diego', "Torres", 10, 4);
insert into temporal_primaria (nombre, apellido, edad, grado) values ('Martina', "Gómez", 11, 5);
insert into temporal_primaria (nombre, apellido, edad, grado) values ('Joaquín', "Hernández", 10, 4);
insert into temporal_primaria (nombre, apellido, edad, grado) values ('Valeria', "Díaz", 11, 5);
select * from temporal_primaria;

#Agrega un cliente nuevo con el nombre “Ana Rodríguez” y con dirección en “San Martín 2515, Mar del Plata”. Luego realiza la intersección entre la tabla temporal de empleados y clientes.
insert into clientes (nombre, direccion) values ('Ana Rodríguez', 'San Martín 2515 Mar del Plata');




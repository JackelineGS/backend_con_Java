DROP DATABASE mi_bd;
CREATE DATABASE IF NOT EXISTS mi_bd;
USE mi_bd;
CREATE TABLE empleados (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(50),
apellido VARCHAR(50),
edad INT,
salario DECIMAL(10,2),
fecha_contratacion DATE 
);

#Modifica la columna "edad" para que no pueda tener valores nulos.
ALTER TABLE empleados 
MODIFY edad INT NOT NULL;

#Modifica la columna "salario" para que tenga un valor predeterminado de 0 en lugar de nulo.
ALTER TABLE empleados
MODIFY salario DECIMAL(10,2) DEFAULT 0.00;

#Agrega una columna llamada "departamento" de tipo VARCHAR(50) para almacenar el departamento al que pertenece cada empleado.
ALTER TABLE empleados
ADD departamento VARCHAR(50);

#Agrega una columna llamada "correo_electronico" de tipo VARCHAR(100) para almacenar las direcciones de correo electrónico de los empleados.
ALTER TABLE empleados
ADD correo_electronico VARCHAR(100);

#Elimina la columna "fecha_contratacion" de la tabla "empleados".
ALTER TABLE empleados
DROP fecha_contratacion;

#Vuelve a crear la columna "fecha_contratacion" de la tabla "empleados" pero con un valor por default que sea la fecha actual. Para eso puedes usar las funciones “CURRENT_DATE” o “NOW()”.
ALTER TABLE empleados
ADD fecha_contratacion DATE DEFAULT(current_date()); -- Se puede usar NOW() si se desea incluir fecha y hora.

SELECT * FROM empleados;

#Crea una nueva tabla llamada "departamentos" con las siguientes columnas: id (clave primaria, tipo INT AUTO_INCREMENT) nombre (tipo VARCHAR(50))
CREATE TABLE IF NOT EXISTS departamentos(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

#Agrega una nueva columna llamada "departamento_id" en la tabla "empleados" que servirá como clave foránea para hacer referencia al departamento al que pertenece cada empleado.
ALTER TABLE empleados
ADD departamento_id INT;

#Modifica la tabla “empleados” y establece una restricción de clave foránea en la columna "departamento_id" para que haga referencia a la columna "id" en la tabla "departamentos".
ALTER TABLE empleados
ADD FOREIGN KEY (departamento_id) REFERENCES departamentos(id);

#Elimina el campo “departamentos” de la tabla empleados, ahora usaremos la clave foránea para poder relacionar ambas tablas
ALTER TABLE empleados
DROP departamento;

#Inserta un departamento llamado "Ventas" en la tabla "departamentos".
INSERT INTO departamentos (nombre)
VALUES ('Ventas'); 

#Inserta un departamento llamado "Recursos Humanos" en la tabla "departamentos".
INSERT INTO departamentos (nombre)
VALUES ('Recursos Humanos'); 

-- En caso de Error Code: 1175. You are using safe update mode
-- SET SQL_SAFE_UPDATES = 0;

SELECT * FROM empleados;
#Inserta un empleado en la tabla "empleados" con los siguientes valores: Nombre: Ana; Apellido: Rodríguez; Edad: 28; Salario: 3000.00; Correo electrónico: anarodriguez@mail.com; departamento_id: (debe coincidir con el ID del departamento "Ventas" que insertaste anteriormente, puedes saber el id haciendo una consulta a la tabla “SELECT * FROM departamentos”).
-- Insertar empleado: Ana Rodriguez

INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Ana', 'Rodriguez', 28, 3000.00, 'anarodriguez@mail.com', 1);

-- Insertar empleado: Carlos López
INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Carlos', 'López', 32, 3200.50, 'carloslopez@mail.com', 2);

-- Insertar empleado: Laura Pérez
INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Laura', 'Pérez', 26, 2800.75, 'lauraperez@mail.com', 1);

-- Insertar empleado: Martín González
INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Martín', 'González', 30, 3100.25, 'martingonzalez@mail.com', 2);

#Actualiza el salario del empleado con nombre "Ana" para aumentarlo en un 10%.
UPDATE empleados
SET salario = salario + (salario*0.10)
WHERE nombre = 'Ana';

#Crea un departamento llamado “Contabilidad”. 
INSERT INTO departamentos (nombre)
VALUES ('Contabilidad'); 

#Cambia el departamento del empleado con nombre "Carlos" de "Recursos Humanos" a "Contabilidad"
UPDATE empleados
SET departamento_id = 3
WHERE nombre = 'Carlos';

#Elimina al empleado con nombre "Laura"
DELETE FROM empleados
WHERE nombre = 'Laura';

# Crea una tabla llamada "clientes" con columnas para el "id" (entero autoincremental), "nombre" (cadena de hasta 50 caracteres), y "direccion" (cadena de hasta 100 caracteres).
CREATE TABLE clientes(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50), 
    direccion VARCHAR(50)
);

#Crea una tabla llamada "productos" con columnas para el "id" (entero autoincremental), "nombre" (cadena de hasta 50 caracteres), y "precio" (decimal con 10 dígitos, 2 decimales).
CREATE TABLE productos(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50), 
    precio DECIMAL(10,2)
);

#Crea una tabla llamada "ventas" con columnas para "id" (entero autoincremental), "producto_id" (entero), "cliente_id" (entero), "cantidad" (entero), “precio_unitario” (decimal con 10 dígitos, 2 decimales), "monto_total" (decimal con 10 dígitos, 2 decimales), y "empleado_id" (entero).
CREATE TABLE ventas(
	id INT AUTO_INCREMENT PRIMARY KEY,
    producto_id INT, 
    cliente_id INT, 
    cantidad INT, 
    precio_unitario DECIMAL(10,2),
    monto_total DECIMAL(10,2),
    empleado_id INT
);

#En la tabla creada Ventas, establece restricciones de clave foránea en las columnas "producto_id," "cliente_id," y "empleado_id" para hacer referencia a las tablas correspondientes. 
ALTER TABLE ventas
ADD FOREIGN KEY (producto_id) REFERENCES productos(id);

ALTER TABLE ventas
ADD FOREIGN KEY (cliente_id) REFERENCES clientes(id);

ALTER TABLE ventas
ADD FOREIGN KEY (empleado_id) REFERENCES empleados(id);

#Inserta un nuevo cliente en la tabla "clientes" con el nombre "Juan Pérez" y la dirección "Libertad 3215, Mar del Plata"
INSERT INTO clientes (nombre, direccion)
VALUES ('Juan Perez', 'Libertad 3215, Mar del Plata');

#Inserta un nuevo producto en la tabla "productos" con el nombre "Laptop" y un precio de 1200.00 .
INSERT INTO productos (nombre, precio)
VALUES ('Laptop', 1200.00);

#Modifica la columna monto_total de la tabla ventas para que por defecto sea el resultado de multiplicar la cantidad por el precio del producto_id
ALTER TABLE ventas
MODIFY monto_total INT GENERATED ALWAYS AS (cantidad * precio_unitario) STORED;

#Crea una venta en la tabla "ventas" donde el cliente "Juan Pérez" compra "Laptop" por una cantidad de 2 unidades y el vendedor tenga el nombre “Ana" y apellido "Rodriguez”. Ten en cuenta que debes “tener” los ID y valores correspondientes previamente, luego aprenderemos a recuperarlos con subconsultas.
INSERT INTO ventas (cliente_id, producto_id, cantidad, precio_unitario, empleado_id)
VALUES (1, 1, 2, 1200.00, 1);

SELECT * FROM ventas;

#Inserta un nuevo producto en la tabla "productos" con el nombre "Teléfono móvil" y un precio de 450.00.
INSERT INTO productos(nombre, precio)
VALUES ('Teléfono móvil', 450.00);

#Inserta un nuevo cliente en la tabla "clientes" con el nombre "María García" y la dirección "Constitución 456, Luján".
INSERT INTO clientes(nombre, direccion)
VALUES ('María García', 'Constitución 456, Luján');

#Modifica la columna correo_electronico de la tabla empleados para que se genere automáticamente concatenado el nombre, apellido y el string “@mail.com”.
ALTER TABLE empleados 
MODIFY correo_electronico VARCHAR(100)
GENERATED ALWAYS AS (concat(nombre, apellido, '@mail.com')) STORED;

#Inserta un nuevo empleado en la tabla "empleados" con el nombre "Luis” y apellido “Fernández", edad 28, salario 2800.00 y que pertenezca al departamento “ventas”.
INSERT INTO empleados(nombre, apellido, edad, salario, departamento_id)
VALUES ('Luis', 'Fernandez', 28, 2800.00, (SELECT id FROM departamentos WHERE nombre = 'Ventas'));

#Actualiza el precio del producto "Laptop" a 1350.00 en la tabla "productos".
UPDATE productos
SET precio = 1350.00
WHERE nombre = 'Laptop';

#Modifica la dirección del cliente "Juan Pérez" a "Alberti 1789, Mar del Plata" en la tabla "clientes".
UPDATE clientes
SET direccion = 'Alberti 1789, Mar del Plata'
WHERE nombre = 'Juan Perez';

#Incrementa el salario de todos los empleados en un 5% en la tabla "empleados".
UPDATE empleados
SET salario = salario * 1.05;

#Inserta un nuevo producto en la tabla "productos" con el nombre "Tablet" y un precio de 350.00.
INSERT INTO productos(nombre, precio)
VALUES ('Tablet', 350.00);

#Inserta un nuevo cliente en la tabla "clientes" con el nombre "Ana López" y la dirección "Beltrán 1452, Godoy Cruz".
INSERT INTO clientes(nombre, direccion)
VALUES ('Ana López', 'Beltrán 1452, Godoy Cruz');

#Inserta un nuevo empleado en la tabla "empleados" con el nombre "Marta", apellido "Ramírez", edad 32, salario 3100.00 y que pertenezca al departamento “ventas”.
INSERT INTO empleados(nombre, apellido, edad, salario, departamento_id)
VALUES ('Marta', 'Ramirez', 32, 3100.00, (SELECT id FROM departamentos WHERE nombre = 'Ventas'));

#Actualiza el precio del producto "Teléfono móvil" a 480.00 en la tabla "productos".
UPDATE productos
SET precio = 480.00
WHERE nombre = 'Teléfono móvil';

#Modifica la dirección del cliente "María García" a "Avenida 789, Ciudad del Este" en la tabla "clientes".
UPDATE clientes
SET direccion = 'Avenida 789, Ciudad del Este'
WHERE nombre = 'María García';

#Incrementa el salario de todos los empleados en el departamento de "Ventas" en un 7% en la tabla "empleados".
UPDATE empleados
SET salario = salario * 1.07
WHERE departamento_id = (SELECT id FROM departamentos WHERE nombre = 'Ventas');

#Inserta un nuevo producto en la tabla "productos" con el nombre "Impresora" y un precio de 280.00.
INSERT INTO productos(nombre, precio)
VALUES ('Impresora', 280.00);

#Inserta un nuevo cliente en la tabla "clientes" con el nombre "Carlos Sánchez" y la dirección "Saavedra 206, Las Heras".
INSERT INTO clientes(nombre, direccion)
VALUES ('Carlos Sánchez', 'Saavedra 206, Las Heras');

#Inserta un nuevo empleado en la tabla "empleados" con el nombre "Lorena", apellido "Guzmán", edad 26, salario 2600.00 y que pertenezca al departamento “ventas”.
INSERT INTO empleados(nombre, apellido, edad, salario, departamento_id)
VALUES ('Lorena', 'Guzmán', 26, 2600.00, (SELECT id FROM departamentos WHERE nombre = 'Ventas'));

#Haz una consulta simple de los datos de la tabla empleados y verifica que se presente de la siguiente manera:
SELECT * FROM empleados; 
#Haz una consulta simple de los datos de la tabla clientes y verifica que se presente de la siguiente manera:
SELECT * FROM clientes;
#Haz una consulta simple de los datos de la tabla productos y verifica que se presente de la siguiente manera:
SELECT * FROM productos;

#COMPLEMENTARIAS
#Inserta una venta en la tabla "ventas" donde el cliente "Juan Pérez" compra una "Laptop" con una cantidad de 2 y el vendedor tiene el nombre "Ana" y apellido "Rodríguez".
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Laptop'),
	(SELECT id FROM clientes WHERE nombre = 'Juan Perez'),
	2,
	(SELECT precio FROM productos WHERE nombre = 'Laptop'),
	(SELECT id FROM empleados WHERE nombre = 'Ana' AND apellido = 'Rodríguez')
);

#Inserta una venta en la tabla "ventas" donde el cliente "María García" compra un "Teléfono móvil" con una cantidad de 3 y el vendedor tiene el nombre "Carlos" y apellido "López".
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Teléfono móvil'),
	(SELECT id FROM clientes WHERE nombre = 'María García'),
	3,
	(SELECT precio FROM productos WHERE nombre = 'Teléfono móvil'),
	(SELECT id FROM empleados WHERE nombre = 'Carlos' AND apellido = 'López')
);

#Crea una venta en la tabla "ventas" donde el cliente "Carlos Sánchez" compra una "Impresora" con una cantidad de 1 y el vendedor tiene el nombre "Marta" y apellido "Ramírez".
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Impresora'),
	(SELECT id FROM clientes WHERE nombre = 'Carlos Sánchez'),
	1,
	(SELECT precio FROM productos WHERE nombre = 'Impresora'),
	(SELECT id FROM empleados WHERE nombre = 'Marta' AND apellido = 'Ramirez')
);

#Inserta una venta en la tabla "ventas" donde el cliente "Ana López" compra una "Laptop" con una cantidad de 1 y el vendedor tiene el nombre "Carlos" y apellido "López".
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Laptop'),
	(SELECT id FROM clientes WHERE nombre = 'Ana López'),
	1,
	(SELECT precio FROM productos WHERE nombre = 'Laptop'),
	(SELECT id FROM empleados WHERE nombre = 'Carlos' AND apellido = 'López')
);

#Crea una venta en la tabla "ventas" donde el cliente "Juan Pérez" compra una "Tablet" con una cantidad de 2 y el vendedor tiene el nombre "Luis" y apellido "Fernández".
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Tablet'),
	(SELECT id FROM clientes WHERE nombre = 'Juan Perez'),
	2,
	(SELECT precio FROM productos WHERE nombre = 'Tablet'),
	(SELECT id FROM empleados WHERE nombre = 'Luis' AND apellido = 'Fernandez')
);

# Inserta una venta en la tabla "ventas" donde el cliente "María García" compra un "Teléfono móvil" con una cantidad de 1 y el vendedor tiene el nombre "Marta" y apellido "Ramírez".
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Teléfono móvil'),
	(SELECT id FROM clientes WHERE nombre = 'María García'),
	1,
	(SELECT precio FROM productos WHERE nombre = 'Teléfono móvil'),
	(SELECT id FROM empleados WHERE nombre = 'Marta' AND apellido = 'Ramirez')
);

# Crea una venta en la tabla "ventas" donde el cliente "Carlos Sánchez" compra una "Impresora" con una cantidad de 2 y el vendedor tiene el nombre "Lorena" y apellido "Guzmán".
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Impresora'),
	(SELECT id FROM clientes WHERE nombre = 'Carlos Sánchez'),
	2,
	(SELECT precio FROM productos WHERE nombre = 'Impresora'),
	(SELECT id FROM empleados WHERE nombre = 'Lorena' AND apellido = 'Guzmán')
);

# Haz una consulta simple de los datos de la tabla ventas y verifica que se presente de la siguiente manera:
SELECT * FROM ventas;
SELECT * FROM empleados;

UPDATE ventas
SET empleado_id = 7
WHERE id = 6;
-- Hay alguna dificultad con el empleado Luis 

#Lista los nombres de los empleados sin duplicados
SELECT DISTINCT nombre
FROM empleados;

#Obtén una lista de correos electrónicos únicos de todos los empleados.
SELECT DISTINCT correo_electronico
FROM empleados;

#Encuentra la lista de edades distintas entre los empleados.
SELECT DISTINCT edad
FROM empleados;

#Muestra los nombres de los empleados que tienen un salario superior a $3200.
SELECT nombre
FROM empleados
WHERE salario > 3200.00;

#Obtén una lista de empleados que tienen 28 años de edad.
SELECT *
FROM empleados
WHERE edad = 28;

#Lista a los empleados cuyos salarios sean menores a $2700.
SELECT *
FROM empleados
WHERE salario < 2700.00;

#Encuentra todas las ventas donde la cantidad de productos vendidos sea mayor que 2.
SELECT *
FROM ventas
WHERE cantidad > 2;

#Muestra las ventas donde el precio unitario sea igual a $480.00.
SELECT *
FROM ventas
WHERE precio_unitario = 480.00;

#Obtén una lista de ventas donde el monto total sea menor que $1000.00.
SELECT *
FROM ventas
WHERE monto_total < 1000.00;

#Encuentra las ventas realizadas por el empleado con el ID 1.
SELECT *
FROM ventas
WHERE empleado_id = 1;

#Muestra los nombres de los empleados que trabajan en el Departamento 1 y tienen un salario superior a $3000.
SELECT nombre
FROM empleados
WHERE departamento_id = 1 AND salario > 3000.00;

#Lista los empleados que tienen 32 años de edad o trabajan en el Departamento 3.
SELECT *
FROM empleados
WHERE departamento_id = 3 OR edad = 32;

#Lista las ventas donde el producto sea el ID 1 y la cantidad sea mayor o igual a 2.
SELECT *
FROM ventas
WHERE producto_id = 1 AND cantidad >= 2;

#Muestra las ventas donde el cliente sea el ID 1 o el empleado sea el ID 2.
SELECT *
FROM ventas
WHERE empleado_id = 2 OR cliente_id = 1;

#Obtén una lista de ventas donde el cliente sea el ID 2 y la cantidad sea mayor que 2.
SELECT *
FROM ventas
WHERE cliente_id = 2 AND cantidad > 2;

#Encuentra las ventas realizadas por el empleado con el ID 1 y donde el monto total sea mayor que $2000.00.
SELECT *
FROM ventas
WHERE empleado_id = 1 AND monto_total > 2000.00;

#Encuentra a los empleados cuyas edades están entre 29 y 33 años. Muestra el nombre y la edad de los registros que cumplan esa condición. 
SELECT nombre
FROM empleados
WHERE edad BETWEEN 29 AND 33;

#Encuentra las ventas donde la cantidad de productos vendidos esté entre 2 y 3.
SELECT *
FROM ventas
WHERE cantidad BETWEEN 2 AND 3;

#Muestra las ventas donde el precio unitario esté entre $300.00 y $500.00.
SELECT *
FROM ventas
WHERE precio_unitario BETWEEN 300.00 AND 500.00;






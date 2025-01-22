USE mi_bd;
#Encuentra los empleados cuyos IDs son 1, 3 o 5.
SELECT *
FROM empleados
WHERE id IN (1,3,5);

#Busca los productos con IDs 2, 4 o 6 en la tabla de productos.
SELECT *
FROM productos
WHERE id IN (2,4,6);
 
#Encuentra las ventas que tienen los clientes con IDs 1, 3 o 5.
SELECT *
FROM ventas
WHERE cliente_id IN (1,3,5);
 
#Encuentra los empleados cuyos nombres comienzan con "L". -- Clausula like
SELECT * 
FROM empleados
WHERE UPPER(nombre) LIKE 'L%';

-- Alternativa UPPER/LOWER
#Busca los productos cuyos nombres contengan la palabra "Teléfono".
SELECT *
FROM productos
WHERE nombre COLLATE utf8mb4_general_ci LIKE '%Telefono%';

#Encuentra los clientes cuyas direcciones contienen la palabra "Calle".
SELECT *
FROM clientes
WHERE direccion LIKE '%calle%';

-- Order By
#Ordena los empleados por salario de manera ascendente.
SELECT *
FROM empleados
ORDER BY salario; 

#Ordena los productos por nombre de manera descendente.
SELECT *
FROM productos
ORDER BY nombre DESC;

#Ordena las ventas por cantidad de manera ascendente y luego por precio_unitario de manera descendente.
SELECT *
FROM ventas 
ORDER BY cantidad ASC, precio_unitario DESC;

-- Limit
#Muestra los 5 productos más caros de la tabla "productos".
SELECT *
FROM productos
ORDER BY precio DESC 
LIMIT 5;

#Muestra los 10 primeros empleados en orden alfabético por apellido.
SELECT *
FROM empleados
ORDER BY apellido 
LIMIT 10; 

#Muestra las 3 ventas con el monto total más alto.
SELECT *
FROM ventas
ORDER BY monto_total DESC 
LIMIT 3;

-- Ejercicios AS
#Crea una consulta que muestre el salario de los empleados junto con el salario aumentado en un 10% nombrando a la columna como “Aumento del 10%”.
SELECT nombre, salario, salario * 1.10 AS 'Aumento del 10%'
FROM empleados;

#Crea una consulta que calcule el monto total de las compras realizadas por cliente y que la columna se llame “Monto total gastado”.
SELECT (SELECT nombre FROM clientes WHERE id = ventas.cliente_id) AS 'Cliente', 
		SUM(monto_total) AS 'Monto total gastado'
FROM ventas
GROUP BY cliente_id;

#Muestra los nombres completos de los empleados concatenando los campos "nombre" y "apellido" y que la columna se llame “Nombre y apellido”.
SELECT CONCAT(nombre, ' ', apellido) AS 'Nombre y apellido'
FROM empleados;

-- Ejercicios CASE
#Crea una consulta que muestre el nombre de los productos y los categorice como "Caro" si el precio es mayor o igual a $500, "Medio" si es mayor o igual a $200 y menor que $500, y "Barato" en otros casos.
SELECT nombre, precio,
CASE
WHEN precio >= 500 THEN 'Caro'
WHEN precio >= 200 AND precio < 500 THEN 'Medio'
ELSE 'Bajo'
END AS "Categoria Precio"
FROM productos ORDER BY precio DESC;

#Crea una consulta que muestre el nombre de los empleados y los categorice como "Joven" si tienen menos de 30 años, "Adulto" si tienen entre 30 y 40 años, y "Mayor" si tienen más de 40 años.
SELECT nombre,edad,
CASE
WHEN edad < 30 THEN 'Joven'
WHEN edad >= 30 AND edad <= 40 THEN 'Adulto'
ELSE 'Mayor'
END AS "Categoria Edad"

FROM empleados ORDER BY edad DESC;

#Crea una consulta que muestre el ID de la venta y los categorice como "Poca cantidad" si la cantidad es menor que 3, "Cantidad moderada" si es igual o mayor que 3 y menor que 6, y "Mucha cantidad" en otros casos.
SELECT id,cantidad,
CASE
WHEN cantidad < 3 THEN 'Poca cantidad'
WHEN cantidad >= 3 AND cantidad < 6 THEN 'Cantidad moderada'
ELSE 'Mucha cantidad'
END AS "Tamaño venta"

FROM ventas ORDER BY cantidad DESC;

#Crea una consulta que muestre el nombre de los clientes y los categorice como "Comienza con A" si su nombre comienza con la letra 'A', "Comienza con M" si comienza con 'M' y "Otros" en otros casos.
SELECT nombre,
CASE
WHEN nombre LIKE "A%" THEN 'Empieza por A'
WHEN nombre LIKE "M%" THEN 'Empieza por M'
ELSE 'Otro'
END AS "Inicial"

FROM clientes ORDER BY nombre ASC;

#Crea una consulta que muestre el nombre de los empleados y los categorice como "Salario alto" si el salario es mayor o igual a $3500, "Salario medio" si es mayor o igual a $3000 y menor que $3500, y "Salario bajo" en otros casos.

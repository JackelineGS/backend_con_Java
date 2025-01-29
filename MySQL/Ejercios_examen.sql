use jardineria;
#Calcula la fecha del primer y último pago realizado por cada uno de los clientes. 
#El listado deberá mostrar el nombre y los apellidos de cada cliente.

SELECT c.nombre_contacto, c.apellido_contacto, 
MAX(p.fecha_pago) AS primer_pago, 
MIN(p.fecha_pago) AS ultimo_pago FROM cliente c
JOIN pago p  
ON c.codigo_cliente = p.codigo_cliente
group by c.nombre_contacto, c.apellido_contacto;

#Lista las ventas totales de los productos que hayan facturado más de 3000 euros. 
#Se mostrará el nombre, unidades vendidas, total facturado y total facturado con impuestos (21% IVA).
SELECT precio_venta, 

#Los clientes cuyo límite de crédito sea mayor que los pagos que haya realizado. (Sin utilizar INNER JOIN).

#Devuelve el nombre, los apellidos y el email de los empleados que están a cargo de Alberto Soria.

#Devuelve un listado que muestre solamente los clientes que sí han realizado ningún pago. (Recomendamos resolver este ejercicio con Subconsultas del tipo IN y NOT IN).

#Devuelve un listado de los productos (código y nombre)  que han aparecido en un pedido alguna vez.(Recomendamos resolver este ejercicio con Subconsultas del tipo EXISTS y NOT EXISTS).

#Devuelve el nombre del producto que tenga el precio de venta más caro. (Recomendamos resolver este ejercicio con Subconsultas del tipo ALL y ANY).

#Devuelve el nombre del producto que tenga el precio de venta más caro (puedes realizarlo ordenando la tabla).
CREATE DATABASE IF NOT EXISTS mi_bd2;
USE mi_bd2;

#Crea una tabla triangulos_rectangulos con dos columnas: longitud_lado_adyacente y longitud_lado_opuesto, ambos de tipo INT.

CREATE TABLE triangulos_rectangulos (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
longitud_lado_adyacente INT,
longitud_lado_opuesto INT
);

#Rellena la tabla triangulos_rectangulos con 10 filas con enteros aleatorios entre 1 y 100
INSERT INTO triangulos_rectangulos (longitud_lado_adyacente, longitud_lado_opuesto)
VALUES (FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)), 
(FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)), 
(FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)), 
(FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
(FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
(FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
(FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
(FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
(FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100)),
(FLOOR(1 + RAND() * 100), FLOOR(1 + RAND() * 100));

SELECT * FROM triangulos_rectangulos;

#Crea una vista donde agregues la columna “hipotenusa” calculándola a partir de los otros dos lados. Utiliza el teorema de Pitágoras para realizar el cálculo: Siendo el lado adyacente “A” y el opuesto “B” y la hipotenusa “C” la fórmula quedaría de la siguiente forma:
#C =A2+B2​
CREATE OR REPLACE VIEW triangulos_hipotenusa AS
SELECT longitud_lado_adyacente AS A, longitud_lado_opuesto AS B, SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto,2)) AS C FROM triangulos_rectangulos;
TABLE triangulos_hipotenusa;
#DROP view triangulos_hipotenusa;

#Reemplaza la vista y ahora agrégale dos columnas para calcular el ángulo α en radianes y grados. Aquí tienes dos fórmulas:
#En radianes: =arcsen(BC) =arccos(AC) = arctan(BA)  

CREATE OR REPLACE VIEW triangulos_hipotenusa2 AS
SELECT  
ACOS(A/C) AS angulo_alpha_radianes,
DEGREES(ACOS(A/C)) AS angulo_alpha_grados
-- DEGREES(ACOS(A/C)), 
-- DEGREES(ATAN(B/A)),
 FROM triangulos_hipotenusa;
Table triangulos_hipotenusa2;

CREATE OR REPLACE VIEW triangulo_hipotenusa3 AS
SELECT
DEGREES(ACOS(A / C)) AS angulo_beta_en_grados,
ACOS(A / C) as angulo_beta_en_radianes
-- DEGREES(ATAN(A / B)) AS angulo_gamma_en_grados
FROM triangulo_hipotenusa;

table triangulo_hipotenusa3;


CREATE OR REPLACE VIEW triangulo_hipotenusa AS
SELECT
id,
longitud_lado_adyacente as adyacente,
longitud_lado_opuesto as opuesto,
ROUND(SQRT(POW(longitud_lado_adyacente,2)+POW(longitud_lado_opuesto,2)),2) as hipotenusa
FROM triangulos_rectangulos tr;

CREATE OR REPLACE VIEW triangulo_hipotenusa_angulos_a AS
SELECT id,
adyacente,
opuesto,
ROUND(DEGREES(ATAN(opuesto/adyacente)),2) as alpha
FROM triangulo_hipotenusa th;


CREATE OR REPLACE VIEW triangulo_hipotenusa_angulos_b AS
SELECT id,
adyacente,
opuesto,
ROUND(DEGREES(ATAN(adyacente/opuesto)),2) as betha
FROM triangulo_hipotenusa th;

SELECT tha.adyacente, tha.opuesto, tha.alpha, thb.betha, tha.alpha + thb.betha + 90 as grados_completos
FROM triangulo_hipotenusa_angulos_a as tha
INNER JOIN triangulo_hipotenusa_angulos_b as thb
ON tha.id = thb.id
GROUP BY tha.id;



#Reemplaza la vista y ahora agrégale dos columnas para calcular el ángulo β en radianes y grados. Aquí tienes dos fórmulas:
#En radianes: β =arccos(BC)=arcsen(AC) = arctan(AB)  

#Reemplaza la vista y ahora agrégale dos columnas para calcular el ángulo γ en radianes y grados. Como se trata de triángulos rectángulos, el ángulo es de 90°, pero aplica una fórmula de igual manera, usa la regla de que la suma de los ángulos de un triángulo suma 180°.

#Crea una tabla triangulos_rectangulos_2 con dos columnas: angulo_alfa y una hipotenusa ambos de tipo INT.

#Rellena la tabla triangulos_rectangulos_2 con 10 filas con enteros aleatorios entre 1 y 89 para angulo_alfa y enteros aleatorios entre 1 y 100 para la columna hipotenusa.

#Crea una vista donde agregues la columna lado_adyacente donde calcules su longitud.

#Agrega a la vista la columna lado_opuesto donde calcules su longitud.

#Agrega a la vista la columna angulo_beta donde calcules su valor en grados.

#Agrega a la vista la columna angulo_gamma donde calcules su valor en grados.

#Redondea todos los valores con hasta dos números decimales.
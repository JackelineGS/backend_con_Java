use nba;

#Mostrar el nombre y peso de los diez jugadores que sean pivots (‘C’) y que pesen más de 200 libras, ordenados por peso.
SELECT Nombre, Posicion, Peso FROM jugadores WHERE Posicion = 'C' and Peso >= 200 order by peso DESC LIMIT 10;

#Mostrar el nombre de los equipos del este (East).
SELECT Nombre FROM equipos WHERE Conferencia = 'East';

#Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.
SELECT Nombre FROM equipos
Where Ciudad LIKE 'c%';

#Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.
SELECT Puntos_por_partido
FROM estadisticas
JOIN jugadores ON
jugadores.codigo = estadisticas.jugador
WHERE jugadores.Nombre ='Pau Gasol' AND estadisticas.temporada='04/05';

#Mostrar los diez jugadores con más puntos en toda su carrera con un redondeo de dos decimales.
SELECT jugadores.Nombre, ROUND(AVG(estadisticas.Puntos_por_partido),2) AS total_puntos
FROM estadisticas
JOIN jugadores ON
jugadores.codigo = estadisticas.jugador
GROUP BY jugadores.Nombre
ORDER BY total_puntos DESC
LIMIT 10;

#Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
SELECT e.Nombre, e.Conferencia, e.Division
FROM jugadores j
JOIN equipos e ON j.Nombre_equipo = e.Nombre
WHERE j.Altura = (SELECT MAX(Altura) FROM jugadores);

#Mostrar los 10 partidos (equipo_local, equipo_visitante y diferencia) con mayor diferencia de puntos.
SELECT equipo_local, equipo_visitante, ABS(puntos_local - puntos_visitante) AS diferencia
FROM partidos
order by diferencia DESC
LIMIT 10;

#Muestra el nombre del equipo con la mayor diferencia de puntos totales de la temporada temporada "00/01".
SELECT p.temporada, e.nombre,
SUM(p.puntos_local-p.puntos_visitante) as diferencia_acumulada
FROM equipos e
JOIN partidos p ON p.equipo_local = e.nombre OR p.equipo_visitante = e.nombre
WHERE p.temporada='00/01'
GROUP BY e.Nombre
ORDER BY diferencia_acumulada DESC
LIMIT 1;
#Encuentra el nombre de los diez equipos que mejor porcentaje de victorias tengan en la temporada "98/99". El número de porcentaje debe estar escrito del 1 al 100 con hasta dos decimales y acompañado por el símbolo “%”.

#Calcula el promedio de puntos por partido de los jugadores que son pivotes ('C') y tienen más de 7 pies de altura, y redondea el resultado a dos decimales.
SELECT
e.nombre AS Equipo,
COUNT(*) AS Partidos_Jugados,
SUM(
CASE
WHEN (e.nombre = p.equipo_local AND p.puntos_local > p.puntos_visitante)
OR
(e.nombre = p.equipo_visitante AND p.puntos_visitante > p.puntos_local)
THEN 1
ELSE 0
END
) AS Partidos_Ganados,
ROUND(
(SUM(
CASE
WHEN (e.nombre = p.equipo_local AND p.puntos_local > p.puntos_visitante)
OR
(e.nombre = p.equipo_visitante AND p.puntos_visitante > p.puntos_local)
THEN 1
ELSE 0
END
) / COUNT(*)) * 100,
2
) AS Porcentaje_Victorias
FROM
equipos e
JOIN
partidos p ON p.equipo_local = e.nombre OR p.equipo_visitante = e.nombre
GROUP BY
e.nombre
ORDER BY
Porcentaje_Victorias DESC
LIMIT 10;

#Muestra el nombre del jugador que ha registrado el mayor número de asistencias en un solo partido.

#Encuentra el total de partidos en los que el equipo local anotó más de 100 puntos y el equipo visitante anotó menos de 90 puntos.

#Calcula la diferencia de puntos promedio en todos los partidos de la temporada “00/01” y redondea el resultado a dos decimales.

#Encuentra el nombre del equipo que ha tenido al menos un jugador que ha promediado más de 10 rebotes por partido en la temporada “97/98”.
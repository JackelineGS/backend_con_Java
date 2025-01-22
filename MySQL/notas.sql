#Seleccionamos las variables que vamos a usar
SELECT user.idUser, idResearcher, user.first_name AS Nombre, user.last_name AS Apellido, researcher.status AS Estatus, researchunit.name AS Unidad, directions.name AS Dirección, COUNT(author_has_publications.User_idUser) AS Publicaciones, user.country AS País, user.profession AS Profesión, user.date_of_birth AS Cumpleaños, researcher.urlOrcid AS ORCID
#Unimos las bases de datos que necesitamos
FROM user 
left join researcher on idUser = idResearcher
left join researchunit on ResearchUnit_idResearchUnit = idResearchUnit
left join directions on Directions_idDirections = idDirections
left join author_has_publications on author_has_publications.User_idUser = user.idUser
#agrupamos por cada usuario
group by user.idUser


#Ordenamos de forma anscendente por número de publicaciones
order by Publicaciones DESC
#Limitamos solo a los 100 primeros investigadore
#limit 100



#IDEAS PARA CREAR TABLAS
#1. Sobre los objetivos que tenemos y ver como lo estamos evaluando
#2. Como establecer informes periodicos de como vamos
#3. Cuanto gastamos y cuanto se traduce en investigación... 1 paper por 10 mil soles? Cuanto nos cuenta un desarrollo tecnológico?
#4. Ver cuanto nos demoran los proyectos en general? Cuanto demora enviarlo por primer ves? cuanto demoran en revisión y choteadas, cuanto demora en aceptarlo?


#numero de proyectos totales
#fecha de inicio
#Fecha de cierre
#Diferencia en meses
#Propio

;


#Aquí cosas que estamos aprendiendo

#Cuando busque una cadena de texto que tenga la letra a en el nombre
#where first_name LIKE "%a%"

#Para las fechas
#where date_of_birth<"1991-05-14"

#buscar un rango de fechas
#where date_of_birth BETWEEN "1991-05-12" AND "1991-05-14"

#escoger una fecha solo del año
#where YEAR(date_of_birth) BETWEEN "1990" AND "2022"
 
#hacer varios filtros
#where date_of_birth<"1991-05-14"
#or 
#date_of_birth is NULL

#select first_name AS Nombre, last_name AS Apellido, dni AS DNI
#from user
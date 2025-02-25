# Maquetacion del proyecto

El proyecto sigue una arquitectura basada en capas, es una arquitectura de tipo MVC(Modelo-Vista-Controlador)

## Controladores: 
Aqui se almacenan las clases responsables de gestionar las solicitudes del usuario (a travez de una interfaz gráfica o API). 
Actua como intermediario entre la capa de presentación y las capas lógicas del sistema, procesando peticiones y devolviendo 
las respuestas adecuadas.  
## Servicios:
Contienen la lógica del negocio de la aplicación
Aqui se implementan reglas que definen cómo se deben procesar los datos
Se encargan de la comunicación entre los controladores y los repositorios
## Repositorios:
En este paquete se almacenarán los repositorios que servirán como interfaces entre el modelo de objetos y la base de datos relacional
Permiten realizar operaciones como insertar, actualizar, eliminar y consultar datos. 
## Entidades: 
En este paquete se almacenarán aquellas clases que es necesario persistir en la base de datos
Generalmente están mapeadas a tablas de la base de datos mediante JPA(Java Persistence API) o Hibernate 
Se definen con anotaciones como @Entity, @Table, @Id, etc.
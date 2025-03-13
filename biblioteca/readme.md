# MAQUETACIÓN DE PROYECTOS

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

# CAPA DE SERVICIOS 

#### Declaración de la clase:
Se usa la anotación @Service 
#### Importación de dependencias:
Se importa la clase del repositorio correspondiente
"import org.springframework.stereotype.Service;" 
#### Definición de los métodos: 
Implementar metodos basicos como crear, eliminar, modificar o consultar información.
#### Gestión de dependencias:
Se deben importar todas las clases necesarias, para acceder a los métodos del repositorio, es necesario instanciar un atributo de la clase repositorio correspondiente.
"import org.springframework...;"
#### Inyección de dependencias: 
Utilizamos la anotación @Autowired para que el servidor de aplicaciones inicialice la variable automaticamente. Colocamos la anotación antes de llamar a los repositorios.

### Anotaciones que vamos a utilizar: 
@Service
@Autowired
@Transactional
@Async
@Lob @Basic 

Spring Data JPA heredan métodos predefinidos de las interfaces JpaRepository y CrudRepository. Estos permiten realizar operaciones básicas de CRUD de manera eficiente: 

save(): guarda y actualiza la base de datos
findById(id): Busca una entidad por su identificador único
getReferenceById(id): alternativa a findById()
findAll(): Obtiene todas las entidades de un tipo determinado
deleteById(id): Elimina una entidad por su identificador único
count(): devuelve la cantidad total de entidades de un tipo
existsById(id): Verifica si una entidad con el identificador dado existe en la base de datos.

### Excepciones 
Se creo un archivo llamado MyException para lanzar excepciones

# CONTROLADORES

Los controladores son los componentes encargados de manejar las solicitudes del usuario y conectarlas con la capa de servicio que contiene la lógica de negocio.
Los controladores son intermediarios entre la interfaz de usuario y procesamiento interno de la aplicación, sea a travéz de HTML o API REST. La función es: 
- Recibir y procesar las solicitudes del usuario
- Coordinar la comunicación con los servicios del backend
- Gestionar información que se envía y recibe

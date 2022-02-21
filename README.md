##Summary
Esto proyecto es un microservicio con spring boot en la cual el manejo de dependencia se hace con maven.
El proyecto se documentó siguiendo la técnica de apifirst, el fichero se llama swagger.yml, es con la versión openAPi 3.0.2, 
Estos fueron generado con el plugin de maven.
La capa de persistencia está hecha con JPA **spring data jpa**. La base de datos es **H2**, esa se carga con el fichero data.sql que esta
en los recursos de la app.
Para los mappers he utilizado mapstruct.

Una vez que el servicio inicia, puedes acceder al swagger UI y a la consola de H2 utilizando la siguientes URL:

```
http://localhost:8080/swagger-ui.html#/
http://localhost:8080/h2-console
```
Las credenciales de base datos en el fichero ```application.yml```

##Instalación
Para correr este servicio se necesita JDK versión 8+ y Maven versión 3+

```sh
$ mvn spring-boot:run
```

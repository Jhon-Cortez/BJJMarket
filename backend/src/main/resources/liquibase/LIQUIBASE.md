# Liquibase

El sisguiente archivo markdown busca explicar mediante una documentación de la implementación de Liquibase al trabajo propuesto.

## Docker Compose

En la raiz del proyecto se encuentra un archivo llamado docker compose, lo que busca este archivo es poder gestionar de una manera mas comoda y facil los contenedores relacionados al proyecto.

Alli se encuentran dos contenedores, (cabe recalcar que estos son para que funcionen de manera local):

- Sql Server (DB)
- Liquibase

## Contenedor de Liquibase

```yml
liquibase:
    # Descargamos la imagen que vamos a usar
    image: liquibase/liquibase:5.0.1
    # Le damos un nombre al contenedor
    container_name: liquibase-container
    # Creamos y mosntamos los volumenes para la persistencia de la información
    volumes:
        # Creamos un espacio dentro de contenedor de docker y mostamos el resto alli dentro
      - ./backend/src/main/resources/liquibase:/workspace/
        # es un driver JDBC permite que Java/Liquibase hable con SQL Server, traduce consultas y respuestas, maneja autenticación y conexión, sin él Liquibase no puede conectarse a la BD
      - ./backend/src/main/resources/liquibase/drivers/mssql-jdbc-13.4.0.jre8.jar:/liquibase/lib/mssql.jar
        # Define el comando que se ejecutará automáticamente cuando el contenedor inicie.
    command: >
        # Le indicamos que use el archivo de configuracion de conexion con la db.
      --defaultsFile=/workspace/liquibase.properties
        # Como al crear los volumenes, liquibase puede leer los archivos que mostamos a el, entonces le indica que busque los archivos relacionados (create-tables.xml), dentro de alli.
      --searchPath=/workspace
      update
    #   Indica la dependecia, primero ejecute el contenedor de sql server o que primero este duncionando, corriendo.
    depends_on:
      - sql-server
```

## Archivos relacionados

### Configuraciones de conexión

Dentro de la ruta `backend/src/main/resources/liquibase/liquibase.properties`, se encuentra las credenciales de conexión y demas archivos relacionados, para conectarse a la db. Por ejemplo, nombre de usuario, contraseña, el archivo `.jar`

### Changelogs

Dentro de la ruta `backend/src/main/resources/liquibase/changelogs/`, alli se deben crear los archivos de `.xml`. Estoa archivos son los que nos permiten gestionar la base de datos.

### `master.xml`

Dentro de la ruta `backend/src/main/resources/liquibase/master.xml`, alli es donde se deben llamar los (o un mejor termino para mayor comprension), importar estos archivos mediante las etiquetas `<include ...>`

### Drivers

Dentro de la ruta `backend/src/main/resources/liquibase/drivers/`, alli se debe ubicar el driver que facilita la conexión con la base de datos.

## Nota

> [!NOTE]
> Se debe tener en cuenta la ubicacion de estos archivos, si se piensan modificar nombres o ubicaciones de los archivos necesarios para funcionar, se deberan modificar las rutas en el contenedor.
# Liquibase

El sisguiente archivo markdown busca explicar mediante una documentación de la implementación de Liquibase al trabajo propuesto.

## Docker Compose

En la raiz del proyecto se encuentra un archivo llamado docker compose, lo que busca este archivo es poder gestionar de una manera mas comoda y facil los contenedores relacionados al proyecto.

Alli se encuentran dos contenedores, (cabe recalcar que estos son para que funcionen de manera local):

- PostgreSQL (DB)
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
        # Define el comando que se ejecutará automáticamente cuando el contenedor inicie.
    command: >
        # Le indicamos que use el archivo de configuracion de conexion con la db.
      --defaultsFile=/workspace/liquibase.properties
        # Como al crear los volumenes, liquibase puede leer los archivos que mostamos a el, entonces le indica que busque los archivos relacionados (create-tables.xml), dentro de alli.
      --searchPath=/workspace
      update
    # Indica la dependencia: PostgreSQL debe estar saludable primero.
    depends_on:
      - postgres
```

## Archivos relacionados

### Configuraciones de conexión

La conexión de Liquibase se define en el servicio `liquibase` de `docker-compose.yml`. Así el despliegue no depende de un archivo local ignorado por Git.

### Changelogs

Dentro de la ruta `backend/src/main/resources/liquibase/changelogs/`, alli se deben crear los archivos de `.xml`. Estoa archivos son los que nos permiten gestionar la base de datos.

### `master.xml`

Dentro de la ruta `backend/src/main/resources/liquibase/master.xml`, alli es donde se deben llamar los (o un mejor termino para mayor comprension), importar estos archivos mediante las etiquetas `<include ...>`

El contenedor oficial de Liquibase incluye el driver JDBC de PostgreSQL, por lo que no se requiere montar uno adicional.

## Nota

> [!WARNING]
> Se debe tener en cuenta la ubicacion de estos archivos. Si se modifican nombres o ubicaciones, se deben actualizar las rutas del contenedor.

> [!NOTE]
> PostgreSQL crea la base de datos configurada al iniciar. Liquibase se ejecuta cuando el healthcheck de PostgreSQL es exitoso.

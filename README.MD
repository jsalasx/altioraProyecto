# Apply Altiora

## Tecnologías utilizadas

- Quarkus - Java 17
- Nextjs 14 - Node 20.11
- Mysql 8.3
- Docker
- DockerCompose

## Despligue

### Compiliar el JAR de Quarkus

- Ingresamos al directorio
```cd altiora```
- Limpiamos la carpeta target
```./mvnw clean```
- Compilamos el proyecto
```./mvnw package```


### Regresar al directorio raiz

```cd ..```

### Ejecutar el docker-compose para levantar los servicios del proyecto
docker-compose up

# Nota Importante:
- UrlFront: http://localhost:3099
- UrlBack: http://localhost:8099
- UrlDB: http://localhost:3399




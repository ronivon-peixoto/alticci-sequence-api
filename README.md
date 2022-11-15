# Alticci Sequence API
Example of cache usage in recursive processing.

### Technologies used
Java 11 (11.0.12-open), Maven (3.6.3) Spring Boot(2.7.5), OpenAPI 3, Swagger-UI and Docker.

## Running the application
OS X & Linux & Windows:

```sh
mvn clean install
docker build -t <TAG_NAME> .
docker run -p 8080:8080 <TAG_NAME>:latest
```

## API Documentation
API documentation can be accessed from the local page (Swagger UI): [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

# Api Clima

Este es una pequeña api en la cual se pretender implementar algunos servicios tales como:

- Consumo de api desde Open Weather.
- Solicitudes Get a diferentes apis de Open Weather.
- Implementacion de JWT.
- Implmentacion de Swagger.
- Implementacion de Cache de datos.
- Implementacion de Limitacion de Tasa de la api.

## Requisitos

- Java 17 o superior
- Maven
- PostgreSQL
- Docker
- Dependencias necesarias para implementar Swagger, PostgreSql, Cache
- Habilitar en application.properties @EnableScheduling, para poder tener configuracion sobre limpieza automatica de cache.

### Url para ir a la documentacion de Swagger UI

http://localhost:8082/swagger-ui/index.html

### Configuracion para la delimitacion de peticiones
configuracion para la delimitacion de peticiones por usuario:
resilience4j.ratelimiter.instances.apiRateLimiter.limitForPeriod=5
resilience4j.ratelimiter.instances.apiRateLimiter.limitRefreshPeriod=3600s

Te dejo el archivo .env para que puedas ver los parametros de conexion hacia la db y tambien de adjunto un docker compose para que puede crear la imagen de una y ejecutar mi humilde proyecto..
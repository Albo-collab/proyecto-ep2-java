# Proyecto EP2 - Microservicio de Productos

Microservicio REST desarrollado con **Java 17 y Spring Boot** para la Evaluación Parcial 2 de JVY0101 (Duoc UC).
Permite gestionar productos con operaciones CRUD y persistencia en una base de datos relacional.

## Integrantes
- NOMBRE APELLIDO 1
- NOMBRE APELLIDO 2

## Tecnologías
- Java 17
- Spring Boot (Web, Data JPA)
- MySQL
- Maven
- Git / GitHub

## Requisitos
- Java 17 o superior (`java -version`)
- Maven 3.8+ (`mvn -version`)
- MySQL en ejecución (puerto 3306)
- Git

## Cómo ejecutar

1. Clonar el repositorio:
```bash
   git clone https://github.com/TU-USUARIO/proyecto-ep2-java.git
   cd proyecto-ep2-java
```
2. Configurar la base de datos en `src/main/resources/application.properties`
   (cambiar usuario y contraseña de MySQL por los tuyos).
3. Compilar y empaquetar:
```bash
   mvn clean package
```
4. Ejecutar:
```bash
   java -jar target/NOMBRE-DEL-JAR.jar
```
   También se puede ejecutar con `mvn spring-boot:run`.
5. La API queda disponible en `http://localhost:8081/api/productos`

## Endpoints

| Método | URL | Descripción |
|--------|-----|-------------|
| GET | /api/productos | Listar todos los productos |
| GET | /api/productos/{id} | Obtener un producto por id |
| POST | /api/productos | Crear un producto |
| PUT | /api/productos/{id} | Actualizar un producto |
| DELETE | /api/productos/{id} | Eliminar un producto |

## Ejemplo de JSON (POST)
```json
{
  "nombre": "Producto de ejemplo",
  "precio": 1500
}
```

## Estructura del proyecto
```
model/       -> entidades JPA
repository/  -> acceso a datos
service/     -> lógica de negocio
controller/  -> endpoints REST
```

## Ramas
- `main`: versión estable
- `develop`: integración
- `feature/*`: desarrollo de cada funcionalidad

# Proyecto EP2 - Microservicio de Productos y Categorías

Microservicio REST desarrollado con **Java 17 y Spring Boot** para la Evaluación Parcial 2 de JVY0101 (Duoc UC).
Permite gestionar **productos** y **categorías** con operaciones CRUD y persistencia en MySQL.
Relación: una categoría tiene muchos productos (`@OneToMany` / `@ManyToOne`).

## Integrantes
- IVO ARIAS

## Tecnologías
- Java 17
- Spring Boot (Web MVC, Data JPA)
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
   git clone https://github.com/Albo-collab/proyecto-ep2-java.git
   cd proyecto-ep2-java
```

2. Configurar la base de datos en `src/main/resources/application.properties`
   (cambiar usuario y contraseña de MySQL por los propios).
   La base `proyecto_ep2` se crea automáticamente al iniciar.

3. Compilar y empaquetar:
```bash
   mvn clean package
```

4. Ejecutar:
```bash
   java -jar target/proyecto-ep2-0.0.1-SNAPSHOT.jar
```
   También se puede ejecutar con `mvn spring-boot:run`.

5. La API queda disponible en `http://localhost:8081`.

## Endpoints

### Categorías
| Método | URL | Descripción | Códigos |
|--------|-----|-------------|---------|
| GET | /api/categorias | Listar todas las categorías | 200 |
| GET | /api/categorias/{id} | Obtener una categoría por id | 200, 404 |
| POST | /api/categorias | Crear una categoría | 201 |
| PUT | /api/categorias/{id} | Actualizar una categoría | 200, 404 |
| DELETE | /api/categorias/{id} | Eliminar una categoría | 204, 404, 409 |

### Productos
| Método | URL | Descripción | Códigos |
|--------|-----|-------------|---------|
| GET | /api/productos | Listar todos los productos | 200 |
| GET | /api/productos/{id} | Obtener un producto por id | 200, 404 |
| POST | /api/productos | Crear un producto | 201, 404 |
| PUT | /api/productos/{id} | Actualizar un producto | 200, 404 |
| DELETE | /api/productos/{id} | Eliminar un producto | 204, 404 |

## Ejemplos de JSON

Primero se crea la categoría (`POST /api/categorias`):
```json
{
  "nombre": "Bebidas",
  "descripcion": "Bebidas frías"
}
```

Luego el producto, asociado a la categoría (`POST /api/productos`):
```json
{
  "nombre": "Jugo de naranja",
  "precio": 1500,
  "descripcion": "Jugo natural",
  "categoria": { "id": 1 }
}
```

## Estructura del proyecto
```
model/       -> entidades JPA (Producto, Categoria)
repository/  -> acceso a datos (Spring Data JPA)
service/     -> lógica de negocio
controller/  -> endpoints REST
exception/   -> manejo global de errores (404, 409)
```

## Ramas
- `main`: versión estable
- `develop`: integración
- `feature/*`: desarrollo de cada funcionalidad

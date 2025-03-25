# ⚙️ API REST - Gestión de Vehículos para Empresas de Transporte 🚗

Este proyecto es el backend de la aplicación **Gestión de Vehículos para Empresas de Transporte**, desarrollado con **Java (Spring Boot)** y **MySQL**.

---

## 💡 Solución Implementada
El backend está desarrollado utilizando **Java (Spring Boot)** y se conecta a una base de datos **MySQL** para almacenar y gestionar la información. Ofrece endpoints RESTful para realizar operaciones CRUD sobre los siguientes recursos:
- **Vehículos**: Registrar, actualizar, eliminar y consultar información de los vehículos.
- **Conductores**: Gestionar los datos de los conductores asignados a los vehículos.
- **Mantenimiento**: Registra el mantenimiento de los vehículos.
- **Rutas**: Administrar las rutas asignadas a los vehículos.
- **Estadísticas**: Obtiene la cantidad total de vehiculos, conductores, mantenimiento y rutas que tiene el sistema.
  
---

## 🔧 Tecnologías Utilizadas
- **Lenguaje**: Java 17
- **Framework**: Spring Boot 3.4.3
- **Base de Datos**: MySQL
- **Dependencias Principales**:
  - **Spring Data JPA**: Para interactuar con la base de datos.
  - **Spring Web**: Para crear APIs RESTful.
  - **Lombok**: Para reducir código repetitivo (getters, setters, constructores).
  - **MySQL Connector**: Para la conexión con la base de datos MySQL.
  - **Spring DevTools**: Para recargar automáticamente cambios durante el desarrollo.
  - **Spring Boot Starter Test**: Para pruebas unitarias e integración.

---

## 🚀 Cómo Configurar y Ejecutar el Proyecto

### Requisitos Previos
- **Java JDK 17**: Para ejecutar el backend.
- **MySQL**: Para la base de datos

---

## 🚀 Instalación y Ejecución
1. **Clonar el repositorio**:
   
   ```bash
   git clone https://github.com/Daniel-JA03/api_rest_gestion_vehiculos.git
   cd api_rest_gestion_vehiculos

2. **Configurar la base de datos**:
    - Crear una base de datos MySQL llamada `gestion_vehiculos`.
    - Actualizar las credenciales en `src/main/resources/application.properties`.

    
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/gestion_vehiculos
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    ```
3. **Ejecutar el proyecto**:

    ```bash
   ./mvnw spring-boot:run
    ```

4. **La API estará disponible en**:

    ```bash
   http://localhost:8080
    ```

---

## 📝 Endpoints Disponibles

### 🤵 Conductores

| MÉTODO  | ENDPOINT                              | RUTA                                             | DESCRIPCIÓN                         |
|---------|---------------------------------------|-------------------------------------------------|-------------------------------------|
| **GET**    | `/api/v1/conductores`               | `http://localhost:8080/api/v1/conductores`       | Obtener todos los conductores      |
| **POST**   | `/api/v1/conductores`               | `http://localhost:8080/api/v1/conductores`       | Crear un nuevo conductor           |
| **GET**    | `/api/v1/conductores/{id_conductor}` | `http://localhost:8080/api/v1/conductores/1`     | Obtener un conductor por ID        |
| **PUT**    | `/api/v1/conductores/{id_conductor}` | `http://localhost:8080/api/v1/conductores/1`     | Actualizar un conductor existente  |
| **DELETE** | `/api/v1/conductores/{id_conductor}` | `http://localhost:8080/api/v1/conductores/1`     | Eliminar un conductor              |

---

## 📜 Ejemplo para listar conductores (GET)

### 🔹 Solicitud:
  
  ```http
  GET /api/v1/conductores HTTP/1.1
  Host: localhost:8080
  ```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
[
  {
    "id_conductor": 1,
    "nombre": "Daniel Aaron ",
    "licencia": "ABC12458",
    "telefono": "978651179",
    "email": "danielJ@gmail.com"
  },
  {
    "id_conductor": 2,
    "nombre": "Angel Nicolas",
    "licencia": "FGV85462",
    "telefono": "987654324",
    "email": "angel@gmail.com"
  }
]
```

---

## 📜 Ejemplo para crear un conductor (POST)

### 🔹 Solicitud:
```http
POST /api/v1/conductores HTTP/1.1
Host: localhost:8080
```

```json
{
  "nombre": "David Abel",
  "licencia": "DAJ96514",
  "telefono": "991504077",
  "email": "davidA@gmail.com"
}
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
    "id_conductor": 7,
    "nombre": "David Abel",
    "licencia": "DAJ96514",
    "telefono": "991504077",
    "email": "davidA@gmail.com"
}
```

---

## 📜 Ejemplo para obtener un conductor por ID (GET)

### 🔹 Solicitud:
```http
GET /api/v1/conductores/1 HTTP/1.1
Host: localhost:8080
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
  "id_conductor": 1,
  "nombre": "Daniel Aaron",
  "licencia": "ABC12458",
  "telefono": "978651179",
  "email": "danielJ@gmail.com"
}
```

---

## 📜 Ejemplo para actualizar un conductor (PUT)

### 🔹 Solicitud:
```http
PUT /api/v1/conductores/3 HTTP/1.1
Host: localhost:8080
```

```json
{
    "nombre": "Daniel Aaron",
    "licencia": "FAE32146",
    "telefono": "945147325",
    "email": "danielJ@gmail.com"
}
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
    " id_conductor": 1,
    "nombre": "Daniel Aaron",
    "licencia": "FAE32146",
    "telefono": "945147325",
    "email": "danielJ@gmail.com"
}
```

---

## 📜 Ejemplo para eliminar un conductor (DELETE)

### 🔹 Solicitud:
```http
DELETE /api/v1/conductores/3 HTTP/1.1
Host: localhost:8080
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
    "deleted": true
}
```


### 🚘 Vehículos

| MÉTODO  | ENDPOINT                              | RUTA                                             | DESCRIPCIÓN                         |
|---------|---------------------------------------|-------------------------------------------------|-------------------------------------|
| **GET**    | `/api/v1/vehiculos`               | `http://localhost:8080/api/v1/vehiculos`       | Obtener todos los vehículos      |
| **POST**   | `/api/v1/vehiculos`               | `http://localhost:8080/api/v1/vehiculos`       | Agregar un nuevo vehículos           |
| **GET**    | `/api/v1/vehiculos/{id_vehiculo}` | `http://localhost:8080/api/v1/vehiculos/1`     | Obtener un vehículo por ID        |
| **PUT**    | `/api/v1/vehiculos/{id_vehiculo}` | `http://localhost:8080/api/v1/vehiculos/1`     | Actualizar un vehículo existente  |
| **DELETE** | `/api/v1/vehiculos/{id_vehiculo}` | `http://localhost:8080/api/v1/vehiculos/1`     | Eliminar un vehículo              |

---

## 📜 Ejemplo para listar vehículos (GET)

### 🔹 Solicitud:
  
  ```http
  GET /api/v1/vehiculos HTTP/1.1
  Host: localhost:8080
  ```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
[
  {
        "id_vehiculo": 1,
        "placa": "ADS321",
        "marca": "Porsche",
        "modelo": "911 Turbo S",
        "anio": 2019,
        "conductor": {
            "id_conductor": 1,
            "nombre": "Daniel Aaron",
            "email": "danielJ@gmail.com"
        }
    },
    {
        "id_vehiculo": 2,
        "placa": "GIE711",
        "marca": "Mercedes Benz",
        "modelo": "Sedán Clase C",
        "anio": 2000,
        "conductor": {
            "id_conductor": 2,
            "nombre": "Angel Nicolas",
            "email": "angel@gmail.com"
        }
    },
]
```

---

## 📜 Ejemplo para crear un vehículo (POST)

### 🔹 Solicitud:
```http
POST /api/v1/vehiculos HTTP/1.1
Host: localhost:8080
```

```json
{
    "placa": "LMV321",
    "marca": "Mercedes Benz",
    "modelo": "Sedán Clase D",
    "anio": 2019, 
    "estado": "ACTIVO",
    "conductor": {
        "id_conductor": 3
    }
}
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
    "id_vehiculo": 7,
    "placa": "LMV321",
    "marca": "Mercedes Benz",
    "modelo": "Sedán Clase D",
    "anio": 2019,
    "conductor": {
        "id_conductor": 3
    }
}
```

---

## 📜 Ejemplo para obtener un vehículo por ID (GET)

### 🔹 Solicitud:
```http
GET /api/v1/vehiculos/1 HTTP/1.1
Host: localhost:8080
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
    "id_vehiculo": 1,
    "placa": "ADS321",
    "marca": "Porsche",
    "modelo": "911 Turbo S",
    "anio": 2019,
    "conductor": {
        "id_conductor": 1,
        "nombre": "Daniel Aaron",
        "email": "danielJ@gmail.com"
    }
}
```

---

## 📜 Ejemplo para actualizar un vehículo (PUT)

### 🔹 Solicitud:
```http
PUT /api/v1/vehiculos/1 HTTP/1.1
Host: localhost:8080
```

```json
{
    "placa": "ADS321",
    "marca": "Porsche",
    "modelo": "912 Turbo S",
    "anio": 2019,
    "conductor": {
        "id_conductor": 1,
        "nombre": "Daniel Aaron",
        "email": "danielJ@gmail.com"
    }
}
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
    "id_vehiculo": 1,
    "placa": "ADS321",
    "marca": "Porsche",
    "modelo": "912 Turbo S",
    "anio": 2019,
    "conductor": {
        "id_conductor": 1,
        "nombre": "Daniel Aaron",
        "email": "danielJ@gmail.com"
    }
}
```

---

## 📜 Ejemplo para eliminar un vehículo (DELETE)

### 🔹 Solicitud:
```http
DELETE /api/v1/vehiculos/6 HTTP/1.1
Host: localhost:8080
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
    "deleted": true
}
```

### 🛣️ Rutas

| MÉTODO  | ENDPOINT                              | RUTA                                             | DESCRIPCIÓN                         |
|---------|---------------------------------------|-------------------------------------------------|-------------------------------------|
| **GET**    | `/api/v1/rutas`               | `http://localhost:8080/api/v1/rutas`       | Obtener todos las rutas      |
| **POST**   | `/api/v1/rutas`               | `http://localhost:8080/api/v1/rutas`       | Agregar un nueva ruta           |
| **GET**    | `/api/v1/rutas/{id_ruta}` | `http://localhost:8080/api/v1/rutas/1`     | Obtener ruta por ID        |
| **PUT**    | `/api/v1/rutas/{id_ruta}` | `http://localhost:8080/api/v1/rutas/1`     | Actualizar una ruta existente  |
| **DELETE** | `/api/v1/rutas/{id_ruta}` | `http://localhost:8080/api/v1/rutas/1`     | Eliminar ruta              |

---

## 📜 Ejemplo para listar rutas (GET)

### 🔹 Solicitud:
  
  ```http
  GET /api/v1/rutas HTTP/1.1
  Host: localhost:8080
  ```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
[
  {
        "id_ruta": 1,
        "origen": "Los Olivos",
        "destino": "Miraflores",
        "conductor": {
            "id_conductor": 1,
            "nombre": "Daniel Aaron",
            "telefono": "945147325",
            "email": "danielJ@gmail.com"
        }
    },
    {
        "id_ruta": 2,
        "origen": "Huachipa",
        "destino": "Independencia",
        "conductor": {
            "id_conductor": 2,
            "nombre": "Angel Nicolas",
            "telefono": "987654324",
            "email": "angel@gmail.com"
        }
    },
]
```

---

## 📜 Ejemplo para crear una ruta (POST)

### 🔹 Solicitud:
```http
POST /api/v1/rutas HTTP/1.1
Host: localhost:8080
```

```json
{
  "origen": "Comas",
    "destino": "Cercado de Lima",
    "conductor": {
        "id_conductor": 4
    }
}
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
    "id_ruta": 8,
    "origen": "Comas",
    "destino": "Cercado de Lima",
    "conductor": {
        "id_conductor": 4
    }
}
```

---

## 📜 Ejemplo para obtener una ruta por ID (GET)

### 🔹 Solicitud:
```http
GET /api/v1/rutas/1 HTTP/1.1
Host: localhost:8080
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
   "id_ruta": 1,
    "origen": "Los Olivos",
    "destino": "Miraflores",
    "conductor": {
        "id_conductor": 1,
        "nombre": "Daniel Aaron",
        "telefono": "945147325",
        "email": "danielJ@gmail.com"
    }
}
```

---

## 📜 Ejemplo para actualizar una ruta (PUT)

### 🔹 Solicitud:
```http
PUT /api/v1/rutas/1 HTTP/1.1
Host: localhost:8080
```

```json
{
    "origen": "Los Olivos",
    "destino": "La Molina",
    "conductor": {
        "id_conductor": 1,
        "nombre": "Daniel Aaron",
        "telefono": "945147325",
        "email": "danielJ@gmail.com"
    }
}
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
    "id_ruta": 1,
    "origen": "Los Olivos",
    "destino": "La Molina",
    "conductor": {
        "id_conductor": 1,
        "nombre": "Daniel Aaron",
        "telefono": "945147325",
        "email": "danielJ@gmail.com"
    }
}
```

---

## 📜 Ejemplo para eliminar una ruta (DELETE)

### 🔹 Solicitud:
```http
DELETE /api/v1/rutas/8 HTTP/1.1
Host: localhost:8080
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
    "deleted": true
}
```

### 🔧 Mantenimientos

| MÉTODO  | ENDPOINT                                    | RUTA                                                      | DESCRIPCIÓN                                      |
|---------|---------------------------------------------|-----------------------------------------------------------|--------------------------------------------------|
| **GET**    | `/api/v1/mantenimientos`                  | `http://localhost:8080/api/v1/mantenimientos`             | Obtener todos los mantenimientos                |
| **POST**   | `/api/v1/mantenimientos`                  | `http://localhost:8080/api/v1/mantenimientos`             | Agregar un nuevo mantenimiento                  |
| **GET**    | `/api/v1/mantenimientos/{id_mantenimiento}` | `http://localhost:8080/api/v1/mantenimientos/1`           | Obtener mantenimiento por ID                    |
| **PUT**    | `/api/v1/mantenimientos/{id_mantenimiento}` | `http://localhost:8080/api/v1/mantenimientos/1`           | Actualizar un mantenimiento existente           |
| **DELETE** | `/api/v1/mantenimientos/{id_mantenimiento}` | `http://localhost:8080/api/v1/mantenimientos/1`           | Eliminar mantenimiento                          |
| **GET**    | `/api/v1/mantenimientos/tipos`            | `http://localhost:8080/api/v1/mantenimientos/tipos`       | Obtener todos los tipos de mantenimientos       |
| **GET**    | `/api/v1/mantenimientos/estados`          | `http://localhost:8080/api/v1/mantenimientos/estados`     | Obtener todos los estados de mantenimientos     |

---

## 📜 Ejemplo para listar mantenimientos (GET)

### 🔹 Solicitud:
  
  ```http
  GET /api/v1/mantenimientos HTTP/1.1
  Host: localhost:8080
  ```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
[
  {
        "id_mantenimiento": 1,
        "tipo": "PREVENTIVO",
        "fecha": "2025-03-22",
        "costo": 360.8,
        "descripcion": "Cambio de frenos y cambio de neumáticos",
        "estado": "EN_MANTENIMIENTO",
        "vehiculo": {
            "id_vehiculo": 1,
            "placa": "ADS321",
            "marca": "Porsche"
        }
    },
    {
        "id_mantenimiento": 2,
        "tipo": "PREVENTIVO",
        "fecha": "2025-03-23",
        "costo": 300.5,
        "descripcion": "Cambio de aceite y filtro",
        "estado": "EN_MANTENIMIENTO",
        "vehiculo": {
            "id_vehiculo": 2,
            "placa": "GIE711",
            "marca": "Mercedes Benz"
        }
    },
]
```

---

## 📜 Ejemplo para crear una mantenimiento (POST)

### 🔹 Solicitud:
```http
POST /api/v1/mantenimientos HTTP/1.1
Host: localhost:8080
```

```json
{
  "tipo": "CORRECTIVO",
  "fecha": "2025-03-15",
  "costo": 350.75,
  "descripcion": "Cambio de frenos",
  "estado": "PENDIENTE",
  "vehiculo": {
            "id_vehiculo": 4,
            "placa": "HFR257",
            "marca": "Audi"
  }
}
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
    "id_mantenimiento": 6,
    "tipo": "CORRECTIVO",
    "fecha": "2025-03-15",
    "costo": 350.75,
    "descripcion": "Cambio de frenos",
    "estado": "PENDIENTE",
    "vehiculo": {
        "id_vehiculo": 4,
        "placa": "HFR257",
        "marca": "Audi"
    }
}
```

---

## 📜 Ejemplo para obtener un mantenimiento por ID (GET)

### 🔹 Solicitud:
```http
GET /api/v1/mantenimientos/1 HTTP/1.1
Host: localhost:8080
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
   "id_mantenimiento": 1,
    "tipo": "PREVENTIVO",
    "fecha": "2025-03-22",
    "costo": 360.8,
    "descripcion": "Cambio de frenos y cambio de neumáticos",
    "estado": "EN_MANTENIMIENTO",
    "vehiculo": {
        "id_vehiculo": 1,
        "placa": "ADS321",
        "marca": "Porsche"
    }
}
```

---

## 📜 Ejemplo para actualizar un mantenimiento (PUT)

### 🔹 Solicitud:
```http
PUT /api/v1/mantenimientos/1 HTTP/1.1
Host: localhost:8080
```

```json
{
    "tipo": "PREVENTIVO",
    "fecha": "2025-03-22",
    "costo": 360.8,
    "descripcion": "Cambio de neumáticos",
    "estado": "EN_MANTENIMIENTO",
    "vehiculo": {
        "id_vehiculo": 5,
        "placa": "BGE547",
        "marca": "Audi"
    }
}
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
    "id_mantenimiento": 1,
    "tipo": "PREVENTIVO",
    "fecha": "2025-03-22",
    "costo": 360.8,
    "descripcion": "Cambio de neumáticos",
    "estado": "EN_MANTENIMIENTO",
    "vehiculo": {
        "id_vehiculo": 5,
        "placa": "BGE547",
        "marca": "Audi"
    }
}
```

---

## 📜 Ejemplo para eliminar una ruta (DELETE)

### 🔹 Solicitud:
```http
DELETE /api/v1/mantenimientos/5 HTTP/1.1
Host: localhost:8080
```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
{
    "deleted": true
}
```

---

## 📜 Ejemplo para listar tipo de mantenimiento (GET)

### 🔹 Solicitud:
  
  ```http
  GET /api/v1/mantenimientos/tipos HTTP/1.1
  Host: localhost:8080
  ```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
[
  "PREVENTIVO",
  "CORRECTIVO"
]
```

---

## 📜 Ejemplo para listar estados de mantenimiento (GET)

### 🔹 Solicitud:
  
  ```http
  GET /api/v1/mantenimientos/estados HTTP/1.1
  Host: localhost:8080
  ```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
[
    "COMPLETADO",
    "EN_MANTENIMIENTO",
    "PENDIENTE"
]
```


### 📊 Estadísticas

| MÉTODO  | ENDPOINT                                    | RUTA                                                      | DESCRIPCIÓN                                      |
|---------|---------------------------------------------|-----------------------------------------------------------|--------------------------------------------------|
| **GET**    | `/api/v1/stats`                  | `http://localhost:8080/api/v1/stats`             | Obtiene la cantidad total de vehiculos, conductores, mantenimiento y rutas que tiene el sistema  |

---


## 📜 Ejemplo para listar estadisticas del sistema (GET)

### 🔹 Solicitud:
  
  ```http
  GET /api/v1/stats HTTP/1.1
  Host: localhost:8080
  ```

### 🔹 Respuesta:
- ✅ **Código 200 OK**  
```json
  {
    "totalConductores": 6,
    "totalRutas": 7,
    "totalMantenimientos": 5,
    "totalVehiculos": 6
  }
```


## 📌 Futuras Mejoras

A continuación, se presentan algunas mejoras planificadas para futuras versiones de la API:

### 🔒 Implementación de Seguridad con JWT y Spring Security
Actualmente, todos los endpoints están abiertos, pero en futuras versiones se implementará **Spring Security** junto con **JWT (JSON Web Token)** para gestionar la autenticación y autorización.  
- Solo los administradores podrán realizar ciertas acciones críticas, como la gestión de vehículos, conductores y mantenimientos.
- Se añadirá un sistema de roles y permisos para restringir el acceso a determinados endpoints.

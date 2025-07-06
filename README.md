# 📚 Backend - Sistema de Gestión Académica

Este proyecto es un backend desarrollado en **Spring Boot** que gestiona un sistema académico completo. Incluye CRUD para las entidades principales y catálogos auxiliares (listas desplegables) necesarios para el funcionamiento del sistema.

---

## 🧱 Entidades principales

- **Alumno**: Registro de datos personales del estudiante
- **Profesor**: Datos de los docentes
- **Curso**: Cursos académicos ofertados
- **Salón**: Salones o aulas asignados a los cursos
- **Inscripción**: Asignación de alumnos a cursos

---

## 📋 Listas auxiliares

Estas entidades son referenciales y se usan en formularios desplegables:

- **Estado**: Activo, Inactivo, etc.
- **Género**: Masculino, Femenino, Otro...
- **Tipo de Salón**: Laboratorio, Aula común, etc.
- **Distrito**: Distritos geográficos
- **País**: Nacionalidades disponibles

---

## 🔐 Seguridad

- Autenticación con **JWT**
- Filtros personalizados:
  - `JWTAuthenticationFilter`
  - `JWTAuthorizationFilter`
- Configuración de **CORS** permitiendo acceso desde `http://localhost:4200`

---

## 📡 Endpoints principales

| Método | Endpoint                          | Descripción                         |
|--------|-----------------------------------|-------------------------------------|
| GET    | `/api/alumno/lista`               | Lista todos los alumnos             |
| POST   | `/api/alumno/crear`               | Crea un nuevo alumno                |
| PUT    | `/api/alumno/editar/{id}`         | Edita un alumno existente           |
| GET    | `/api/profesor/lista`             | Lista todos los profesores          |
| POST   | `/api/inscripcion/crear`          | Crea una inscripción                |
| GET    | `/api/curso/lista`                | Lista todos los cursos              |
| GET    | `/api/salon/lista`                | Lista todos los salones             |

---

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security (JWT)
- Maven
- MySQL

---

## 🔧 Instrucciones para ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Jheremy-Conca/backend-gestion-inscripciones.git

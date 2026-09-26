# Literature Manager

![Java](https://img.shields.io/badge/Java-Backend-ED8B00?logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven&logoColor=white)
![API](https://img.shields.io/badge/Gutendex-API-2563eb)
![JSON](https://img.shields.io/badge/JSON-Gson-111827)

Aplicación Java para **gestión de libros y consulta de literatura en línea**. Combina operaciones CRUD en memoria con integración a la API pública de Gutendex para buscar obras y autores.

## Funcionalidades

- Registrar libros con título, autor y año.
- Listar catálogo local.
- Editar registros existentes.
- Eliminar libros por identificador.
- Buscar libros en línea mediante Gutendex.
- Procesar respuestas JSON con Gson.
- Interfaz interactiva por consola.

## Tecnologías

- Java
- Maven
- Gson
- `HttpURLConnection`
- Gutendex API

## Arquitectura simplificada

```text
LiteratureManager
├── Book                # Modelo de dominio
├── BookController      # Lógica de gestión
├── CRUD local          # Alta, listado, edición y eliminación
└── Gutendex API        # Búsqueda remota de literatura
```

## Ejecución

El código principal se encuentra dentro de `demo/`.

```bash
git clone https://github.com/Luisf2020/DesafioLiteratura.git
cd DesafioLiteratura/demo
./mvnw spring-boot:run
```

En Windows:

```powershell
mvnw.cmd spring-boot:run
```

## Competencias demostradas

- Modelado básico orientado a objetos.
- Consumo de APIs REST.
- Procesamiento JSON.
- Operaciones CRUD.
- Gestión de dependencias con Maven.
- Manejo de errores en integración HTTP.

## Autor

**Luis Felipe Zuniga León**  
Ingeniería de Sistemas · Desarrollo de Software · Full Stack

---

Proyecto de portafolio y formación técnica en Java e integración de APIs.
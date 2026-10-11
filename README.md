# Literature Manager

![stack: Java](https://img.shields.io/badge/stack--Java-0d9488?style=flat-square) ![stack: Maven](https://img.shields.io/badge/stack--Maven-0d9488?style=flat-square) ![stack: Gson](https://img.shields.io/badge/stack--Gson-0d9488?style=flat-square) ![stack: Gutendex API](https://img.shields.io/badge/stack--Gutendex%20API-0d9488?style=flat-square) ![IA: asistido](https://img.shields.io/badge/IA--asistido-6366f1?style=flat-square)

Gestor de libros que combina un catalogo local con la busqueda en linea de obras y autores mediante la API publica Gutendex.

**Tipo:** Aplicacion de consola (Java) · **Complejidad:** Intermedio

## Problema que resuelve

Reunir en un solo flujo el registro de libros propios y la consulta de un catalogo externo sin salir de la terminal.

## Solucion implementada

Aplicacion Java con operaciones CRUD en memoria y un cliente HTTP que consulta Gutendex y procesa las respuestas JSON con Gson.

### Funcionalidades principales

- Alta, listado, edicion y borrado de libros
- Busqueda en linea en la API Gutendex
- Parseo de JSON con Gson
- Menu interactivo por consola

## Stack

- Java
- Maven
- Gson
- Gutendex API

## Estructura

```
demo/
  src/main/java/com/example/demo/LiteratureManager.java
  src/main/resources/application.properties
  src/test/java/.../DemoApplicationTests.java
  pom.xml
```

## Puesta en marcha

```bash
cd demo
./mvnw spring-boot:run
```

## Complejidad del proyecto

**Nivel: Intermedio** — Integracion con una API externa, serializacion JSON y CRUD sobre modelo propio.

El nivel describe la complejidad tecnica del proyecto, no el grado de dominio de quien lo escribio.

## Despliegue

Aplicacion de consola; no genera una pagina web.  
El codigo fuente esta disponible en este repositorio.

## Transparencia sobre IA

Este proyecto se desarrollo con asistencia de inteligencia artificial (generacion de codigo,
revision y documentacion). El codigo fue leido, ejecutado y probado manualmente. No se declaran
clientes, metricas ni resultados que no puedan verificarse.

## Autor

**Luis Felipe Zuniga Leon** — Desarrollador de software asistido por IA

- GitHub: <https://github.com/Luisf2020>
- Correo: developerluis2@gmail.com
- WhatsApp: +504 3237 0056

---

_Proyecto de portafolio. El desarrollo se apoyo en herramientas de IA bajo revision tecnica humana._

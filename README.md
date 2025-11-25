# 🧬 API REST - Mutant Detector
### 🎯 MercadoLibre Technical Challenge

---

## 📝 Descripción del Proyecto

API REST profesional desarrollada para detectar mutantes según el desafío técnico de **MercadoLibre**.

Analiza secuencias de ADN en formato **NxN** y determina si pertenecen a un mutante mediante la detección de más de una secuencia de 4 bases iguales de forma:

- ➡️ **Horizontal**
- ⬇️ **Vertical**
- ↘️ **Diagonal principal**
- ↙️ **Diagonal inversa**

Incluye arquitectura en capas, validaciones robustas, persistencia en base **H2**, cacheo de ADN con hashing **SHA-256** y documentación interactiva con **Swagger**.

> 💡 *Este proyecto fue desarrollado como trabajo práctico integrador para la Tecnicatura Universitaria en Programación.*

---

## ⚙️ Tecnologías Utilizadas

| Tecnología | Versión | Propósito |
|-----------|---------|-----------|
| ☕ **Java** | 17 | Lenguaje base |
| 🍃 **Spring Boot** | 3.2.0 | Framework principal |
| 🌐 **Spring Web** | - | API REST |
| 💾 **Spring Data JPA** | - | Persistencia |
| 🗄️ **H2 Database** | - | Base de datos en memoria |
| 🔧 **Lombok** | - | Reducción de boilerplate |
| 📚 **Springdoc OpenAPI** | 2.3.0 | Documentación Swagger |
| 🐳 **Docker** | - | Containerización |
| 📦 **Maven** | - | Gestión de dependencias |

---

## 🏗️ Arquitectura del Proyecto

```
com.utn.mutant
├── 📂 model/
│   └── DnaRecord.java (@Entity)
│
├── 📂 dto/
│   └── DnaRequest.java (entrada del ADN)
│
├── 📂 repository/
│   └── DnaRecordRepository.java (JpaRepository)
│
├── 📂 service/
│   ├── MutantService.java (lógica + hashing + persistencia)
│   └── StatsService.java (estadísticas)
│
├── 📂 util/
│   └── MutantDetector.java (algoritmo de detección)
│
├── 📂 controller/
│   ├── MutantController.java
│   └── StatsController.java
│
├── 📂 config/
│   └── CorsConfig.java
│
└── MutantApplication.java (main)
```

### 🎨 Patrón de Arquitectura en Capas

| Capa | Responsabilidad |
|------|----------------|
| 🎮 **Presentación** | Controladores REST |
| 💼 **Negocio** | Servicios (detección, estadísticas, hashing) |
| 💾 **Persistencia** | Repositorio JPA |
| 🔧 **Utilidades** | Algoritmo puro de detección |
| 🌍 **Configuración** | CORS configurado globalmente |
| 📊 **Modelo** | Entidad + DTO |

---

## 🚀 Instrucciones para Clonar y Ejecutar

### 1️⃣ Clonar el Repositorio

```bash
git clone https://github.com/GuevaraMansuino/TrabajoMutantes
cd TrabajoMutantes
```

### 2️⃣ Compilar el Proyecto

```bash
mvn clean install
```

### 3️⃣ Ejecutar la Aplicación

```bash
mvn spring-boot:run
```

### 4️⃣ Acceder a los Servicios

| Servicio | URL |
|----------|-----|
| 🧬 **POST /mutant** | `http://localhost:8080/mutant` |
| 📊 **GET /stats** | `http://localhost:8080/stats` |
| 📖 **Swagger UI** | `http://localhost:8080/swagger-ui.html` |
| 🗄️ **Consola H2** | `http://localhost:8080/h2-console` |

#### 🔑 Configuración H2

```properties
JDBC URL: jdbc:h2:mem:mutantsdb
Username: sa
Password: (vacío)
```

---

## 🌐 Endpoints de la API

| Método | Endpoint | Descripción | Códigos de Respuesta |
|--------|----------|-------------|---------------------|
| `POST` | `/mutant` | Determina si el ADN es mutante | `200` OK / `403` Forbidden / `400` Bad Request |
| `GET` | `/stats` | Retorna estadísticas globales | `200` OK |

---

## 📋 Ejemplos de Uso

### ✅ POST /mutant (Mutante – 200 OK)

```json
{
  "dna": [
    "ATGCGA",
    "CAGTGC",
    "TTATGT",
    "AGAAGG",
    "CCCCTA",
    "TCACTG"
  ]
}
```

**Respuesta:**
```
HTTP 200 OK
```

---

### ❌ POST /mutant (No Mutante – 403 Forbidden)

```json
{
  "dna": [
    "ATGCGA",
    "CAGTGC",
    "TTATGT",
    "AGACAG",
    "GCTTCA",
    "TCACTG"
  ]
}
```

**Respuesta:**
```
HTTP 403 Forbidden
```

---

### ⚠️ POST /mutant (Error – 400 Bad Request)

```json
{
  "dna": [
    "ATG",
    "CAG",
    "TTGAA"
  ]
}
```

**Respuesta:**
```json
{
  "error": "invalid dna structure"
}
```

---

### 📊 GET /stats (Ejemplo de Respuesta)

```json
{
  "count_mutant_dna": 40,
  "count_human_dna": 100,
  "ratio": 0.4
}
```

---

## 🔧 Validaciones Implementadas

### 🔹 DNARequest

- ✅ ADN obligatorio
- ✅ Debe ser **NxN** (cuadrado)
- ✅ Solo caracteres válidos: `A`, `T`, `C`, `G`
- ✅ No se aceptan valores vacíos o nulos

### 🔹 MutantDetector

- ✅ Verificación **horizontal**
- ✅ Verificación **vertical**
- ✅ Verificación **diagonal principal**
- ✅ Verificación **diagonal inversa**
- ✅ Detección de más de una secuencia

### 🔹 Persistencia

- ✅ Hash **SHA-256** para evitar guardar ADN duplicado
- ✅ Cache de resultados para no recalcular

---

## 🎯 Funcionalidades Implementadas

| Feature | Estado |
|---------|--------|
| Detección de mutantes mediante algoritmo optimizado | ✅ |
| Verificación en 4 direcciones | ✅ |
| Hashing SHA-256 + almacenamiento único | ✅ |
| Estadísticas completas | ✅ |
| Persistencia con H2 | ✅ |
| Arquitectura profesional en capas | ✅ |
| CORS habilitado | ✅ |
| Documentación con Swagger | ✅ |
| Docker para deploy en Render | ✅ |
| Manejo de errores uniforme | ✅ |
| Respuestas HTTP semánticas (200, 403, 400) | ✅ |

---

## 🧪 Cómo Probar la API

### 🔷 Opción 1 — Swagger (Recomendado)

Acceder a: **http://localhost:8080/swagger-ui.html**

---

### 🔷 Opción 2 — Postman

Importar colección y realizar peticiones a los endpoints.

---

### 🔷 Opción 3 — cURL

#### ✅ Mutante

```bash
curl -X POST http://localhost:8080/mutant \
-H "Content-Type: application/json" \
-d '{"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}'
```

#### ❌ No Mutante

```bash
curl -X POST http://localhost:8080/mutant \
-H "Content-Type: application/json" \
-d '{"dna":["ATGCGA","CAGTGC","TTATGT","AGACAG","GCTTCA","TCACTG"]}'
```

---

## 💭 Conclusiones Personales

Con este proyecto aprendí:

- 🎯 Aplicar correctamente el desafío técnico de **MercadoLibre**
- ⚡ Implementar algoritmos optimizados en **Java**
- 🏗️ Arquitectura profesional en capas
- 📦 Uso de **DTOs** para desacoplar capas
- ⚠️ Manejo de errores centralizado
- 💾 Persistencia con **JPA**
- 📚 Documentación profesional con **Swagger**
- 🚀 Deploy real con **Docker + Render**

> 💡 *Este trabajo me permitió afianzar mis habilidades para desarrollar APIs robustas, escalables y utilizadas en entornos productivos.*

---

## 👤 Autor

**Geronimo Guevara Mansuino**

- 🎓 **Legajo:** 52661
- 📚 **Materia:** Programación III
- 🏛️ **Institución:** Tecnicatura Universitaria en Programación – UTN

---

## 📄 Licencia

> 📌 Proyecto desarrollado para fines académicos.

---

<div align="center">

### ⭐ Si te gustó este proyecto, dejá una estrella en GitHub

**Hecho con ❤️ por [Geronimo Guevara Mansuino](https://github.com/GuevaraMansuino)**

</div>
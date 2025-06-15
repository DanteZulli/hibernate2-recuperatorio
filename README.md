# 🛠️ Sistema de Gestión de Tickets - Grupo 25 (OBJ2) - Hibernate Nivel 2 (Recuperatorio)

## 📐 Diagrama de Clases (Mermaid)

A continuación se muestra el diagrama de clases principal del dominio del sistema, generado a partir de las clases en `src/datos` y sus relaciones según los mapeos de Hibernate en `src/mapeos`

```mermaid
classDiagram
    %% Clases principales del dominio con visibilidad y multiplicidad
    class Usuario {
        +int id
        +String nombre
        +String nombreUsuario
        -String contrasenia
        +String email
        +boolean esAdmin
        +Timestamp createAt
        +Timestamp updateAt
    }
    class Cliente {
        +int nroCliente
        +String plan
        +boolean particular
        +Direccion direccion
    }
    class Tecnico {
        +String nroContacto
        +String empresa
        +Area area
    }
    class Direccion {
        +int id
        +String calle
        +String nro
        +String codigoPostal
        +Localidad localidad
        +boolean fiscal
        +Timestamp createAt
        +Timestamp updateAt
    }
    class Localidad {
        +int id
        +String nombre
        +Provincia provincia
        +Timestamp createAt
        +Timestamp updateAt
    }
    class Provincia {
        +int id
        +String nombre
        +Set~Localidad~ localidades
        +Timestamp createAt
        +Timestamp updateAt
    }
    class Area {
        +int id
        +String nombre
        +Set~Tecnico~ tecnicos
        +Timestamp createAt
        +Timestamp updateAt
    }
    class Ticket {
        +int id
        +String titulo
        +String descripcion
        +String estado
        +String prioridad
        +Timestamp fechaCreacion
        +Timestamp fechaResolucion
        +Usuario creador
        +Usuario asignado
        +Categoria categoria
        +Set~Etiqueta~ etiquetas
        +Set~Comentario~ comentarios
        +Set~Revision~ revisiones
        +Timestamp createAt
        +Timestamp updateAt
    }
    class Categoria {
        +int id
        +String nombre
        +String descripcion
        +Set~Ticket~ tickets
        +Timestamp createAt
        +Timestamp updateAt
    }
    class Etiqueta {
        +int id
        +String nombre
        +List~Ticket~ tickets
        +Timestamp createAt
        +Timestamp updateAt
    }
    class Comentario {
        +int id
        +String mensaje
        +Timestamp fecha
        +Ticket ticket
        +Usuario usuario
        +Timestamp createAt
        +Timestamp updateAt
    }
    class Revision {
        +int id
        +LocalDateTime fechaCambio
        +String campoModificado
        +String valorAnterior
        +String valorNuevo
        +String observaciones
        +Ticket ticket
        +Usuario usuarioModificacion
        +Timestamp createAt
        +Timestamp updateAt
    }

    %% Herencia
    Usuario <|-- Cliente
    Usuario <|-- Tecnico

    %% Relaciones con multiplicidad
    Cliente "1" --> "1" Direccion : tiene
    Direccion "*" --> "1" Localidad : pertenece a
    Localidad "*" --> "1" Provincia : pertenece a
    Provincia "1" --> "*" Localidad : contiene
    Tecnico "*" --> "1" Area : pertenece a
    Area "1" --> "*" Tecnico : contiene
    Ticket "*" --> "1" Usuario : creador
    Ticket "*" --> "0..1" Usuario : asignado
    Ticket "*" --> "1" Categoria : pertenece a
    Ticket "*" --> "*" Etiqueta : tiene
    Ticket "1" --> "*" Comentario : tiene
    Ticket "1" --> "*" Revision : tiene
    Categoria "1" --> "*" Ticket : contiene
    Etiqueta "*" --> "*" Ticket : etiqueta
    Comentario "*" --> "1" Ticket : sobre
    Comentario "*" --> "1" Usuario : escrito por
    Revision "*" --> "1" Ticket : sobre
    Revision "*" --> "1" Usuario : modificado por
```

## 📋 Requisitos Previos

- Java JDK 12
- MySQL 8.0+

## ⚙️ Configuración de la Base de Datos

La configuración de la base de datos se realiza mediante el archivo `src/hibernate.cfg.xml`. Asegúrate de que los valores coincidan con tu entorno de MySQL. Ejemplo de configuración:

```xml
<property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
<property name="connection.url">jdbc:mysql://localhost:3306/hibernate2_db?createDatabaseIfNotExist=true&amp;serverTimezone=America/Argentina/Buenos_Aires</property>
<property name="connection.username">root</property>
<property name="connection.password"></property>
<property name="dialect">org.hibernate.dialect.MySQLDialect</property>
```

> 📌 **Nota:** Podés modificar estos valores en `src/hibernate.cfg.xml` según tu entorno y credenciales.

## 🗄️ Inicialización de la Base de Datos

El proyecto incluye un script SQL (`db.sql`) que contiene el **esquema** de la base de datos necesario para la aplicación.  
Para inicializar la base de datos:

1. Abrí tu gestor de base de datos (por ejemplo, MySQL Workbench, DBeaver, consola, etc.).
2. Ejecutá el script `db.sql` ubicado en la raíz del proyecto para crear las tablas y relaciones necesarias.

> ⚠️ **Importante:** El script no carga datos de prueba, solo estructura la base de datos.

## 🚀 Ejecución del Proyecto

1. Cloná el repositorio:
   ```bash
   git clone [url-del-repositorio]
   cd hibernate2-recuperatorio
   ```

2. Asegurate de que MySQL esté corriendo y la base de datos esté inicializada (ver sección anterior).

3. Compilá el proyecto y ejecutalo desde la terminal:
   ```bash
   javac -cp "lib/*" -d bin src/datos/*.java src/dao/*.java src/mapeos/*.java src/negocio/*.java
   java -cp "bin:lib/*" [paquete.claseMain]
   ```
   > Reemplazá `[paquete.claseMain]` por el nombre completo de la clase principal (por ejemplo, `negocio.Main`).

   También podés ejecutar el proyecto desde tu IDE favorito (VSCode, Eclipse, etc.) configurando el classpath para incluir la carpeta `lib` y seleccionando la clase principal.

## 📦 Dependencias

Todas las dependencias externas (JARs) necesarias se encuentran en la carpeta `lib/`.  
Incluyen Hibernate, el conector de MySQL y cualquier otra librería requerida.

- **¿Cómo agregarlas en tu IDE?**
  - **VSCode:** Usá la extensión "Java Projects" y agregá todos los JARs de la carpeta `lib` al classpath del proyecto.
  - **Eclipse:** Click derecho en el proyecto → Build Path → Configure Build Path → pestaña "Libraries" → "Add external JARs..." y seleccioná todos los archivos de `lib/`.

> 📝 **Nota:** Las dependencias son las mismas que están disponibles en el campus (las de Java 12)

## 🧰 Tecnologías Utilizadas

- **Java 12**
- **Hibernate 5.x** (ORM)
- **MySQL 8.0+**
- **JDBC**
- **Librerías auxiliares** (ver carpeta `lib/`)
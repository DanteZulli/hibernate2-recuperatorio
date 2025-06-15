# 🛠️ Sistema de Gestión de Tickets - Grupo 25 (OBJ2) - Hibernate Nivel 2 (Recuperatorio)

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
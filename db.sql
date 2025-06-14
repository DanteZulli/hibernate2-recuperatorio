    CREATE DATABASE `hibernate2_db`  /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
    USE `hibernate2_db`;
    -- hibernate2_db.areas definition

    CREATE TABLE `areas` (
    `id` int NOT NULL AUTO_INCREMENT,
    `create_at_area` datetime(6) DEFAULT NULL,
    `nombre` varchar(50) NOT NULL,
    `update_at_area` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    -- hibernate2_db.categorias definition

    CREATE TABLE `categorias` (
    `id` int NOT NULL AUTO_INCREMENT,
    `create_at_categoria` datetime(6) DEFAULT NULL,
    `descripcion` varchar(200) DEFAULT NULL,
    `nombre` varchar(50) NOT NULL,
    `update_at_categoria` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    -- hibernate2_db.etiquetas definition

    CREATE TABLE `etiquetas` (
    `id` int NOT NULL AUTO_INCREMENT,
    `create_at_etiqueta` datetime(6) DEFAULT NULL,
    `nombre` varchar(50) NOT NULL,
    `update_at_etiqueta` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    -- hibernate2_db.provincias definition

    CREATE TABLE `provincias` (
    `id` int NOT NULL AUTO_INCREMENT,
    `create_at_provincia` datetime(6) DEFAULT NULL,
    `nombre` varchar(100) NOT NULL,
    `update_at_provincia` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    -- hibernate2_db.usuarios definition

    CREATE TABLE `usuarios` (
    `id` int NOT NULL AUTO_INCREMENT,
    `contrasenia` varchar(255) NOT NULL,
    `create_at_usuario` datetime(6) DEFAULT NULL,
    `email` varchar(255) NOT NULL,
    `es_admin` bit(1) NOT NULL,
    `nombre` varchar(100) NOT NULL,
    `nombre_usuario` varchar(50) NOT NULL,
    `update_at_usuario` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UKkfsp0s1tflm1cwlj8idhqsad0` (`email`),
    UNIQUE KEY `UKof5vabgukahdwmgxk4kjrbu98` (`nombre_usuario`)
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    -- hibernate2_db.localidades definition

    CREATE TABLE `localidades` (
    `id` int NOT NULL AUTO_INCREMENT,
    `create_at_localidad` datetime(6) DEFAULT NULL,
    `nombre` varchar(100) NOT NULL,
    `update_at_localidad` datetime(6) DEFAULT NULL,
    `provincia_id` int NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKpsu514uguuo384j979ub9dp4y` (`provincia_id`),
    CONSTRAINT `FKpsu514uguuo384j979ub9dp4y` FOREIGN KEY (`provincia_id`) REFERENCES `provincias` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    -- hibernate2_db.tecnicos definition

    CREATE TABLE `tecnicos` (
    `empresa` varchar(255) NOT NULL,
    `nro_contacto` varchar(255) NOT NULL,
    `usuario_id` int NOT NULL,
    `area_id` int NOT NULL,
    PRIMARY KEY (`usuario_id`),
    KEY `FKjqop6odsida66vfxguq2ynqkk` (`area_id`),
    CONSTRAINT `FKh0hbi1db3op7h3fjd8u6rhm8l` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
    CONSTRAINT `FKjqop6odsida66vfxguq2ynqkk` FOREIGN KEY (`area_id`) REFERENCES `areas` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    -- hibernate2_db.tickets definition

    CREATE TABLE `tickets` (
    `id` int NOT NULL AUTO_INCREMENT,
    `create_at_ticket` datetime(6) DEFAULT NULL,
    `descripcion` varchar(1000) NOT NULL,
    `estado` varchar(255) NOT NULL,
    `fecha_creacion` datetime(6) NOT NULL,
    `fecha_resolucion` datetime(6) DEFAULT NULL,
    `prioridad` varchar(255) NOT NULL,
    `titulo` varchar(100) NOT NULL,
    `update_at_ticket` datetime(6) DEFAULT NULL,
    `asignado_id` int DEFAULT NULL,
    `categoria_id` int NOT NULL,
    `creador_id` int NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKckcsymxrd8rgy4ibgs4w948v0` (`asignado_id`),
    KEY `FK945st5u4inomber9a3k8loqq6` (`categoria_id`),
    KEY `FK1jl1wdve9ticosmxkcxkxuosr` (`creador_id`),
    CONSTRAINT `FK1jl1wdve9ticosmxkcxkxuosr` FOREIGN KEY (`creador_id`) REFERENCES `usuarios` (`id`),
    CONSTRAINT `FK945st5u4inomber9a3k8loqq6` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`),
    CONSTRAINT `FKckcsymxrd8rgy4ibgs4w948v0` FOREIGN KEY (`asignado_id`) REFERENCES `usuarios` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    -- hibernate2_db.comentarios definition

    CREATE TABLE `comentarios` (
    `id` int NOT NULL AUTO_INCREMENT,
    `create_at_comentario` datetime(6) DEFAULT NULL,
    `fecha` datetime(6) NOT NULL,
    `mensaje` varchar(500) NOT NULL,
    `update_at_comentario` datetime(6) DEFAULT NULL,
    `ticket_id` int NOT NULL,
    `usuario_id` int NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK8lqn8iqppt0iix31t39p30j51` (`ticket_id`),
    KEY `FKdts62yj83qe3k748cgcjvm48r` (`usuario_id`),
    CONSTRAINT `FK8lqn8iqppt0iix31t39p30j51` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`),
    CONSTRAINT `FKdts62yj83qe3k748cgcjvm48r` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    -- hibernate2_db.direcciones definition

    CREATE TABLE `direcciones` (
    `id` int NOT NULL AUTO_INCREMENT,
    `calle` varchar(100) NOT NULL,
    `codigo_postal` varchar(10) NOT NULL,
    `create_at_direccion` datetime(6) DEFAULT NULL,
    `fiscal` bit(1) NOT NULL,
    `nro` varchar(255) NOT NULL,
    `update_at_direccion` datetime(6) DEFAULT NULL,
    `localidad_id` int NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKhhtl5u75eacbbsrt3xtv433ci` (`localidad_id`),
    CONSTRAINT `FKhhtl5u75eacbbsrt3xtv433ci` FOREIGN KEY (`localidad_id`) REFERENCES `localidades` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    -- hibernate2_db.revisiones definition

    CREATE TABLE `revisiones` (
    `id` int NOT NULL AUTO_INCREMENT,
    `campo_modificado` varchar(255) NOT NULL,
    `create_at_revision` datetime(6) DEFAULT NULL,
    `fecha_cambio` datetime(6) NOT NULL,
    `observaciones` varchar(500) DEFAULT NULL,
    `update_at_revision` datetime(6) DEFAULT NULL,
    `valor_anterior` varchar(255) DEFAULT NULL,
    `valor_nuevo` varchar(255) DEFAULT NULL,
    `ticket_id` int NOT NULL,
    `usuario_id` int NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKsob0ayav2fvtyn89d7ttalkpi` (`ticket_id`),
    KEY `FK4fqsn7cxu3ckqaqkh8ptca9s1` (`usuario_id`),
    CONSTRAINT `FK4fqsn7cxu3ckqaqkh8ptca9s1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
    CONSTRAINT `FKsob0ayav2fvtyn89d7ttalkpi` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    -- hibernate2_db.ticket_etiqueta definition

    CREATE TABLE `ticket_etiqueta` (
    `ticket_id` int NOT NULL,
    `etiqueta_id` int NOT NULL,
    KEY `FK9186ekwo0m6609369ygyr11uw` (`etiqueta_id`),
    KEY `FKhheam8x0jmq0y3opjk19tboub` (`ticket_id`),
    CONSTRAINT `FK9186ekwo0m6609369ygyr11uw` FOREIGN KEY (`etiqueta_id`) REFERENCES `etiquetas` (`id`),
    CONSTRAINT `FKhheam8x0jmq0y3opjk19tboub` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    -- hibernate2_db.clientes definition

    CREATE TABLE `clientes` (
    `nro_cliente` int DEFAULT NULL,
    `particular` bit(1) NOT NULL,
    `plan` varchar(255) NOT NULL,
    `usuario_id` int NOT NULL,
    `direccion_id` int NOT NULL,
    PRIMARY KEY (`usuario_id`),
    UNIQUE KEY `UK3dmsyrbi62horvak3coxevtvp` (`direccion_id`),
    UNIQUE KEY `UK1630iv682nxk0kul2o3e4x3p1` (`nro_cliente`),
    CONSTRAINT `FKilcxbho9ygadia7u8bl6dxnlb` FOREIGN KEY (`direccion_id`) REFERENCES `direcciones` (`id`),
    CONSTRAINT `FKk6iwsq3kts1bblivkjy6epajx` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
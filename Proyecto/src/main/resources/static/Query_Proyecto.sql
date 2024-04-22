-- Dropping existing schema and user if they exist
DROP SCHEMA IF EXISTS Titox;
DROP USER IF EXISTS 'usuario_proyecto'@'%';

-- Creating new schema
CREATE SCHEMA Titox;

-- Setting context to the new schema
USE Titox;

-- Creating a new user with specified credentials
CREATE USER 'usuario_proyecto'@'%' IDENTIFIED BY 'proyecto123';

-- Granting all privileges on the new schema to the new user
GRANT ALL PRIVILEGES ON Titox.* TO 'usuario_proyecto'@'%';

-- Applying the privileges
FLUSH PRIVILEGES;

-- Creating 'reparaciones' table with a primary key
CREATE TABLE reparaciones (
                              reparacion_id INT NOT NULL AUTO_INCREMENT,
                              nombre VARCHAR(255),
                              apellido VARCHAR(255),
                              correo_electronico VARCHAR(255),
                              fecha DATE,
                              Detalles_Reparacion VARCHAR(255),
                              activo boolean,
                              PRIMARY KEY (reparacion_id)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- Creating 'usuario' table with a primary key
CREATE TABLE usuario (
                         id_usuario INT NOT NULL AUTO_INCREMENT,
                         usuario VARCHAR(255),
                         correo VARCHAR(255) NOT NULL,
                         password VARCHAR(255) NOT NULL,
                         PRIMARY KEY (id_usuario)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE rol (
                     id_rol INT NOT NULL AUTO_INCREMENT,
                     nombre VARCHAR(255),
                     id_usuario INT,
                     PRIMARY KEY (id_rol),
                     FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
                         ON DELETE CASCADE
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


-- Creating 'catalogo' table with a primary key
CREATE TABLE catalogo(
                         id_catalogo INT NOT NULL AUTO_INCREMENT,
                         titulo VARCHAR(255),
                         descripcion VARCHAR(255),
                         tipo_articulo VARCHAR(255),
                         imagen_catalogo VARCHAR(1024),
                         precio INT,
                         cantidad INT,
                         activo BOOLEAN,
                         PRIMARY KEY (id_catalogo)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- Inserting data into 'reparaciones' table
INSERT INTO reparaciones (nombre, apellido, correo_electronico, fecha, Detalles_Reparacion)
VALUES
    ('Alissa', 'Castillo', 'alissacastillo818@gmail.com', '2002-03-28', 'Se le jodio el ds al pendejo de mi novio');

-- Inserting data into 'usuario' table
INSERT INTO usuario (usuario, correo_electronico, contraseña)
VALUES
    ('Steven', 'stguerraf2@gmail.com', 'johannesnepe');

INSERT INTO catalogo (titulo,descripcion, tipo_articulo ,imagen_catalogo, precio, cantidad, activo)
VALUES
    ('God of War', 'An action-adventure game featuring the character Kratos in a mythological world.','videojuego','https://media.wired.com/photos/639bf35a24c352e627eccc43/191:100/w_1280,c_limit/Ragnaro%CC%88k-culture-ar1qdh.jpg', 30000 , 100, TRUE);



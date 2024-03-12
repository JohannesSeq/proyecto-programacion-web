-- Creación de la tabla usuarios
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    usuario VARCHAR(255) NOT NULL,
    correo VARCHAR(255) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL
);

-- Creación de la tabla reparaciones
CREATE TABLE reparaciones (
    id_reparacion SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    fecha_reparacion DATE NOT NULL,
    detalles_reparacion TEXT NOT NULL
);

-- Creación de la tabla videojuegos
CREATE TABLE videojuegos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    fecha_lanzamiento DATE NOT NULL,
    cantidad_en_stock INT NOT NULL
);

-- Creación de la tabla consolas
CREATE TABLE consolas (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    cantidad_en_stock INT NOT NULL
);
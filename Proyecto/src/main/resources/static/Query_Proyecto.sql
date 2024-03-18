/*Se crea la base de datos */
drop schema if exists proyecto;
drop user if exists usuario_proyecto;
CREATE SCHEMA proyecto;

/*Se crea un usuario para la base de datos llamado "usuario_prueba" y tiene la contraseña "Usuario_Clave."*/
create user 'usuario_proyecto'@'%' identified by 'proyecto123';

/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
grant all privileges on proyecto.* to 'usuario_proyecto'@'%';
flush privileges;


CREATE TABLE reparaciones (
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    correo_electronico VARCHAR(255),
    fecha date,
    Detalles_Reparacion VARCHAR(255)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE usuario (
    usuario VARCHAR(255),
    correo_electronico VARCHAR(255),
    contraseña VARCHAR(255)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO reparaciones (nombre, apellido, correo_electronico, fecha, Detalles_Reparacion)
VALUES 
('Alissa', 'Castillo', 'alissacastillo818@gmail.com', '2002-03-28', 'Se le jodio el ds al pendejo de mi novio');

INSERT INTO usuario (usuario, correo_electronico, contraseña)
VALUES 
('Steven', 'stguerraf2@gmail.com', 'johannesnepe')

CREATE DATABASE IF NOT EXISTS vivero;
USE vivero;

CREATE TABLE IF NOT EXISTS oficina (
    id_oficina INT PRIMARY KEY AUTO_INCREMENT,
    codigo_oficina VARCHAR(10),
    ciudad VARCHAR(30),
    país VARCHAR(50),
    region VARCHAR(50),
    codigo_postal VARCHAR(10),
    telefono VARCHAR(20)
);

INSERT INTO oficina VALUES (1, 'BCN-ES','Barcelona','España','Barcelona','08019','+34 93 3561182');
INSERT INTO oficina VALUES (2, 'BOS-USA','Boston','EEUU','MA','02108','+1 215 837 0825');
INSERT INTO oficina VALUES (3, 'LON-UK','Londres','Inglaterra','EMEA','EC2N 1HN','+44 20 78772041');
INSERT INTO oficina VALUES (4, 'MAD-ES','Madrid','España','Madrid','28032','+34 91 7514487');
INSERT INTO oficina VALUES (5, 'PAR-FR','Paris','Francia','EMEA','75017','+33 14 723 4404');
INSERT INTO oficina VALUES (6, 'SFC-USA','San Francisco','EEUU','CA','94080','+1 650 219 4782');
INSERT INTO oficina VALUES (7, 'SYD-AU','Sydney','Australia','APAC','NSW 2010','+61 2 9264 2451');
INSERT INTO oficina VALUES (8, 'TAL-ES','Talavera de la Reina','España','Castilla-LaMancha','45632','+34 925 867231');
INSERT INTO oficina VALUES (9, 'TOK-JP','Tokyo','Japón','Chiyoda-Ku','102-8578','+81 33 224 5000');

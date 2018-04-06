/*
Operaciones Crud

*/

-- Es un cometario de linea

SELECT `id`, `nombre`, `precio` FROM `material` ORDER BY `id` DESC LIMIT 500;

--Buscar

SELECT `id`, `nombre`, `precio` FROM `material` where `nombre` LIKE '%a%' ORDER BY `id` DESC LIMIT 500;


-- Detalle

SELECT `id, `nombre`, `precio` FROM `material` where `id=8`;


--UPDATE


UPDATE `nidea`.`material` SET `nombre`='cerveza' WHERE  `id`=8;

--Delete

DELETE FROM `nidea`.`material` WHERE  `id`=8;

-- Crear

INSERT INTO `nidea`.`material` (`nombre`, `precio`) VALUES ('cerveza', '5');
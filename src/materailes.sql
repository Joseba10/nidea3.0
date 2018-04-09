-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         5.7.14 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para spoty
CREATE DATABASE IF NOT EXISTS `spoty` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `spoty`;

-- Volcando estructura para tabla spoty.material
CREATE TABLE IF NOT EXISTS `material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla spoty.material: 16 rows
DELETE FROM `material`;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` (`id`, `nombre`, `precio`) VALUES
	(1, 'madera', 3.56),
	(2, 'acero', 12.67),
	(4, 'titanio', 27.00),
	(5, 'carton piedra', 6.00),
	(6, 'cristal', 6.00),
	(7, 'platino', 27.00),
	(8, 'aire', 0.00),
	(9, 'plastilina', 24.00),
	(10, 'melamina', 5.20),
	(11, 'Tungsteno', 180.00),
	(12, 'Redstone', 6.00),
	(13, 'formica', 8.00),
	(14, 'hierro', 7.00),
	(15, 'polietileno', 80.00),
	(16, 'materiaDefectuoso', 1.25),
	(17, 'fibra de carbono', 90.00);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

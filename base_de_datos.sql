-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.20-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para nidea
DROP DATABASE IF EXISTS `nidea`;
CREATE DATABASE IF NOT EXISTS `nidea` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `nidea`;

-- Volcando estructura para tabla nidea.material
DROP TABLE IF EXISTS `material`;
CREATE TABLE IF NOT EXISTS `material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla nidea.material: 18 rows
DELETE FROM `material`;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` (`id`, `nombre`, `precio`) VALUES
	(22, 'madera', 14.68),
	(24, 'acero', 15.75),
	(27, 'titanio', 27.00),
	(31, 'carton piedra', 3.00),
	(29, 'Cristal', 6.00),
	(7, 'platino', 27.00),
	(9, 'plastilina', 24.00),
	(10, 'melamina', 5.20),
	(11, 'Tungsteno', 180.00),
	(12, 'Redstone', 6.00),
	(13, 'formica', 8.00),
	(14, 'hierro', 7.00),
	(15, 'polietileno', 80.00),
	(16, 'materiaDefectuoso', 1.25),
	(17, 'fibra de carbono', 90.00),
	(25, 'tela', 20.00),
	(8, 'cerveza', 5.00),
	(21, 'jujermaster', 5.00),
	(33, 'enanoe', 2.00),
	(34, 'pc', 500.00);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

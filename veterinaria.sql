/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.8.4-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: veterinaria
-- ------------------------------------------------------
-- Server version	11.8.4-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `consultamascota`
--

DROP TABLE IF EXISTS `consultamascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `consultamascota` (
  `idConsulta` int(11) NOT NULL AUTO_INCREMENT,
  `idMascota` int(11) NOT NULL,
  `idDueño` int(11) DEFAULT NULL,
  `NombreMascota` varchar(45) NOT NULL,
  `razaMascota` varchar(45) DEFAULT NULL,
  `edadMascota` varchar(2) NOT NULL,
  `generoMascota` varchar(15) NOT NULL,
  `fechaConsulta` datetime NOT NULL,
  `razonConsulta` varchar(500) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `tratamiento` varchar(500) DEFAULT NULL,
  `diagnostico` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`idConsulta`,`idMascota`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultamascota`
--

LOCK TABLES `consultamascota` WRITE;
/*!40000 ALTER TABLE `consultamascota` DISABLE KEYS */;
set autocommit=0;
INSERT INTO `consultamascota` VALUES
(1,1,1,'rex','Poodle','6','Hembra','2025-12-17 00:00:00','vomito','3000214','Sin asignar','Pendiente de revisiÃ³n'),
(2,2,1,'Paco','Golden Retriever','9','Macho','2025-12-03 00:00:00','vacuna ','321654987','Sin asignar','Pendiente de revisión'),
(3,3,1,'Luna','Bichon','2','Hembra','2025-12-04 00:00:00','mi mascota no quiere comer','357896510','Sin asignar','Pendiente de revisión'),
(12,6,1,'Firulais','Golden Retriever','8','Macho','2025-12-12 00:00:00','mi mascota no quiere comer','32158746','mandar chocolate caliente','Pendiente de revisiÃ³n'),
(13,100,15,'bruno','Perro','5','Macho','2025-12-04 00:00:00','riguides mental','3250127984','Sin asignar','Pendiente de revisión');
/*!40000 ALTER TABLE `consultamascota` ENABLE KEYS */;
UNLOCK TABLES;
commit;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-12-02 15:11:56

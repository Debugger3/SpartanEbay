CREATE DATABASE  IF NOT EXISTS `ooad_project` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ooad_project`;
-- MySQL dump 10.13  Distrib 5.5.44, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: ooad_project
-- ------------------------------------------------------
-- Server version	5.5.44-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `advertisement`
--

DROP TABLE IF EXISTS `advertisement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertisement` (
  `adv_row` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `cost` int(10) DEFAULT NULL,
  `adv_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`adv_row`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertisement`
--

LOCK TABLES `advertisement` WRITE;
/*!40000 ALTER TABLE `advertisement` DISABLE KEYS */;
INSERT INTO `advertisement` VALUES (1,'2016-02-29','2016-07-29',500,'s109'),(2,NULL,NULL,0,'s110'),(3,NULL,NULL,0,'s111'),(4,NULL,NULL,0,'s112'),(5,NULL,NULL,0,'i1234'),(6,'0000-00-00','0000-00-00',200,'s123'),(7,'0000-00-00','0000-00-00',100,'S126'),(8,NULL,NULL,0,'s151'),(9,'0000-00-00','0000-00-00',500,'I131'),(10,'2016-10-10','2016-11-11',0,'kjff'),(11,NULL,NULL,0,'Cloth1'),(12,NULL,NULL,0,'Monitor1'),(13,NULL,NULL,0,'Mobile1'),(14,NULL,NULL,0,'Perfume1'),(15,NULL,NULL,0,'Curtain1'),(16,NULL,NULL,0,'Watch1'),(17,NULL,NULL,0,'Camcorder1'),(18,NULL,NULL,0,'TShirt1'),(19,'2016-04-25','2016-05-25',0,'Shoe1'),(21,'0000-00-00','0000-00-00',0,'Shoe2'),(22,'2015-12-27','2017-01-01',0,'It01'),(23,'2015-12-27','2017-01-01',0,'It02'),(24,'2015-12-27','2017-01-01',0,'It03');
/*!40000 ALTER TABLE `advertisement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-29 13:20:22

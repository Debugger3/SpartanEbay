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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `rowAccount` int(11) NOT NULL AUTO_INCREMENT,
  `accountNumber` varchar(20) NOT NULL,
  `accountHolderName` varchar(50) DEFAULT NULL,
  `userId` varchar(25) DEFAULT NULL,
  `cvv` varchar(5) DEFAULT NULL,
  `expYear` varchar(4) DEFAULT NULL,
  `pin` int(11) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `accountOwnerFlag` varchar(1) DEFAULT NULL,
  `cardNumber` varchar(45) NOT NULL,
  `expMonth` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`rowAccount`),
  UNIQUE KEY `accountNumber_UNIQUE` (`accountNumber`),
  UNIQUE KEY `cardNumber_UNIQUE` (`cardNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'account1','sanat jain','Seller13','717','2034',1234,2146623504,'1','1234123412341234','12'),(2,'a2','ebay','ebay','212','2056',1145,1034517,'1','1111222233334444','2'),(3,'32181384854',NULL,'Seller12',NULL,NULL,NULL,17200,NULL,'9999888877776666',NULL),(4,'123','aaa','Seller1','',NULL,NULL,0,'','9999999999999999',''),(5,'55','lll','Seller2','','',0,0,'','2222222222222222',NULL),(6,'44','kkk','T123','','',0,300800,'','1111563288889635',''),(7,'11','ppp','Seller14','','',0,0,'','8888777744446666',NULL),(8,'88','lko','Seller15','','',0,0,'','5656969687874125',NULL),(9,'00','lll','Seller16','','',0,0,'','1254985632569874',NULL),(10,'90','uuuu','SellerTest1','','',0,8500,'','7896526398741256',NULL),(11,'2222','dinesha','S123','123','2034',1111,86500,'1','1234569632111145','10'),(12,'3333','seller','S612','','',0,23500,'1','',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
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

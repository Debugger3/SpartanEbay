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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `rowOrderId` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(45) DEFAULT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `itemId` varchar(45) DEFAULT NULL,
  `sellerId` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `orderDate` varchar(45) DEFAULT NULL,
  `paymentId` varchar(45) DEFAULT NULL,
  `orderFlag` varchar(1) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `dealId` int(11) DEFAULT NULL,
  `rateFlag` varchar(1) DEFAULT 'N',
  PRIMARY KEY (`rowOrderId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (4,'673ccc50-3fc4-43f5-808f-7e200eba9a6f','aditi.raghuvanshi@iiitb.org','Shoe2','Seller12',1,'Received','Tue Apr 26 01:32:26 IST 2016','70a12b6e-119f-4777-8e0d-2ea574635037','B',10000,NULL,NULL,'Y'),(5,'673ccc50-3fc4-43f5-808f-7e200eba9a6f','aditi.raghuvanshi@iiitb.org','Shoe1','Seller12',1,'Received','Tue Apr 26 01:32:26 IST 2016','70a12b6e-119f-4777-8e0d-2ea574635037','B',2200,NULL,NULL,'Y'),(6,'673ccc50-3fc4-43f5-808f-7e200eba9a6f','aditi.raghuvanshi@iiitb.org','TShirt1','Seller12',1,'Received','Tue Apr 26 01:32:26 IST 2016','70a12b6e-119f-4777-8e0d-2ea574635037','B',0,NULL,NULL,'Y'),(7,'ODADIT2604201631321','aditi.raghuvanshi@iiitb.org','Watch1','Seller12',2,'Payment Successful','Tue Apr 26 14:52:18 IST 2016','PDADIT2604201631321','B',1200,NULL,NULL,'N'),(8,'ODADIT2604201631321','aditi.raghuvanshi@iiitb.org','Watch1','Seller12',1,'Payment Successful','Tue Apr 26 14:52:18 IST 2016','PDADIT2604201631321','B',0,NULL,NULL,'N'),(9,'ODADIT2604201681713','aditi.raghuvanshi@iiitb.org','It01','sam',1,'Received','Tue Apr 26 20:15:39 IST 2016','PDADIT2604201681713','B',900,NULL,0,'Y');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
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

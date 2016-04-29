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
-- Table structure for table `subcategory`
--

DROP TABLE IF EXISTS `subcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcategory` (
  `subcatId` int(11) NOT NULL AUTO_INCREMENT,
  `subcatName` varchar(50) DEFAULT NULL,
  `subcatDesc` varchar(100) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `advertise_cost` int(10) DEFAULT '0',
  PRIMARY KEY (`subcatId`),
  KEY `categoryId` (`categoryId`),
  CONSTRAINT `categoryId` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcategory`
--

LOCK TABLES `subcategory` WRITE;
/*!40000 ALTER TABLE `subcategory` DISABLE KEYS */;
INSERT INTO `subcategory` VALUES (1,'LCD, LED and Televisions','LCD, LED and Televisions',1,300),(2,'Gaming Consoles','Gaming Consoles',1,100),(3,'Home Theatre & Accessories','Home Theatre & Accessories',1,300),(4,'Portable Audio & Video','Portable Audio & Video',1,50),(5,'Clothing & Accessories','Clothing & Accessories',2,100),(6,'Watches','Watches',2,50),(7,'Shoes','Shoes',2,50),(8,'Jewellery and Precious stones','Jewellery and Precious stones',2,500),(9,'Digital Cameras','Digital Cameras',3,200),(10,'Camera, Camcorder Accessories','Camera, Camcorder Accessories',3,100),(11,'SLR Camera Lenses','SLR Camera Lenses',3,30),(12,'Film Cameras, SLRs','Film Cameras, SLRs',3,50),(13,'Kitchen and Dining','Kitchen and Dining',4,100),(14,'Furniture','Furniture',4,200),(15,'Home Appliances','Home Appliances',4,100),(16,'Home Decor','Home Decor',4,200),(17,'Pen Drives','Pen Drives',5,50),(18,'Memory Cards','Memory Cards',5,30),(19,'Hard Drives','Hard Drives',5,30),(20,'Internal Hard Drives','Internal Hard Drives',5,50),(21,'iPads & Tablets','iPads & Tablets',6,400),(22,'Laptops','Laptops',6,500),(23,'Wireless Networking','Wireless Networking',6,300),(24,'PC Tools & Laptop Accessories','PC Tools & Laptop Accessories',6,200),(25,'Mobile Phones','Mobile Phones',7,300),(26,'Mobile Accessories','Mobile Accessories',7,30),(27,'Cases, Pouches','Cases, Pouches',7,10),(28,'Bluetooth Devices','Bluetooth Devices',7,100),(29,'Bath and Spa','Bath and Spa',8,20),(30,'Perfumes','Perfumes',8,100),(31,'Make up','Make up',8,200),(32,'Body and Skin Care','Body and Skin Care',8,100),(33,'Cars','good cars',9,1000),(34,'Airoplanes','AIro',9,2000);
/*!40000 ALTER TABLE `subcategory` ENABLE KEYS */;
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

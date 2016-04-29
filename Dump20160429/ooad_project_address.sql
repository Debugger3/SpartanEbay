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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `addr_id` int(100) NOT NULL AUTO_INCREMENT,
  `addr` varchar(1000) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `country` varchar(6) DEFAULT NULL,
  `pincode` int(7) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `contactName` varchar(50) DEFAULT NULL,
  `userID` varchar(50) DEFAULT NULL,
  `shipcost` float DEFAULT '50',
  PRIMARY KEY (`addr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Ebay warehouse','Bengaluru','Karnataka','India',560100,9987491199,'Admin','admin',50),(2,'Ebay warehouse','Bengaluru','Karnataka','India',560100,9987491199,'Admin','admin',50),(3,'IIITB, electronic city phase-1','Bengaluru','Karnataka','India',560100,9987491199,'Ankita Jaiswal','810311',50),(4,'electronic city','bangalore','','India',560100,0,'john','T123',50),(5,'gwalior','gwalior','mp','India',474002,8959898181,'sanat jain','sanat',50),(6,'indore','indore','mp','India',452001,87698789676,'priyanka','priyanka.tiwari@iiitb.org',50),(7,'jhansi road','gwalior','mp','India',474002,895989881,'sanat','Sanat.Jain@iiitb.org',50),(8,'iiitb','bangalore','karnataka','India',560100,1234567890,'raja','rajakumar.s@iiitb.org',50),(9,'bangalore white field','bangalore','karnataka','India',560115,28591111,'sanat','Sanat.Jain@iiitb.org',50),(10,'iiitb','bangalore','karnataka','India',560100,987456321,'aditi','aditi.raghuvanshi@iiitb.org',50),(11,'electronics city 502','bangalore','karnataka','India',560100,1111111111,'Dinesha','dinesha@iiitb.ac.in',50),(12,'electronic city','hyderabad','telangana','India',560100,987654321,'sai krishna','saikrishna1793.sk@gmail.com',50),(13,'123 indore','indore','mp','India',452017,8959898181,'sanat','sanat1111jain@gmail.com',50),(14,'IIITB Girl Hostel','Bengaluru','Karnataka','India',560100,9876111,'Priyanka','priyanka.tiwari@iiitb.org',50);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
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

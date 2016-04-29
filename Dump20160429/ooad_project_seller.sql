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
-- Table structure for table `seller`
--

DROP TABLE IF EXISTS `seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seller` (
  `rowSellerId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `shipping_address` varchar(100) DEFAULT NULL,
  `seller_id` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `accountNo` varchar(20) DEFAULT NULL,
  `contactnumber` varchar(45) DEFAULT NULL,
  `emailid` varchar(45) DEFAULT NULL,
  `natureofbusiness` varchar(45) DEFAULT NULL,
  `sellerrating` decimal(2,1) DEFAULT '0.0',
  `categoryofproducts` varchar(45) DEFAULT NULL,
  `ratingCount` int(11) DEFAULT '0',
  PRIMARY KEY (`rowSellerId`),
  UNIQUE KEY `seller_id_UNIQUE` (`seller_id`),
  UNIQUE KEY `emailid_UNIQUE` (`emailid`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller`
--

LOCK TABLES `seller` WRITE;
/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
INSERT INTO `seller` VALUES (28,'T123','iiitb','T123','john',NULL,'87654','T123@gmail.com','fashion',0.0,'Fashion',0),(30,'Seller13 Name','Address13','Seller13','seller13',NULL,NULL,'seller13@iiitb.org','All textile product',0.0,'All product',0),(31,'Seller14 Name','Address14`','Seller14','seller14',NULL,'8989824335','seller14@iiitb.org','textile',0.0,'Product',0),(32,'Seller12 Name1','Address121','Seller12','seller12',NULL,'8989824335','seller12@iiitb.org','All textile product',2.7,'All product',3),(33,'aditi','iiitb','aditi','aditi','','96865','aditi.raghuvanshi@iiitb.org','kbck',0.0,'Fashion',0),(34,'sanat','IIITB','sanat','JAIN','','9869687','sanat.jain@iiit.org','caterer',0.0,'Home & Appliances',0),(35,'meenal','iiitb','meenal','bbb',NULL,'9887987','meenal.shukla@iiitb.org','kjskjs',0.0,'Fashion',0),(36,'pallu','iiitb','pallu','aaa','','1234','palvinder.kaur.bhatia@iiitb.org','verter',0.0,'Electicals',0),(37,'priyanka','iiitb','priya','ppp',NULL,'12344','priyanka.tiwari@iiitb.org','kjnjj',0.0,'Fashion',0),(38,'John','AD 235','sam','sam',NULL,'111111122','mil@a.com','All type of products',1.0,'All type of Category',1);
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;
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

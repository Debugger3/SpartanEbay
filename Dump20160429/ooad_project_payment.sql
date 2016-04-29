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
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `rowPayment` int(11) NOT NULL AUTO_INCREMENT,
  `paymentId` varchar(45) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `orderId` varchar(45) DEFAULT NULL,
  `paymentType` varchar(25) DEFAULT NULL,
  `debitAccount` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`rowPayment`),
  UNIQUE KEY `paymentId_UNIQUE` (`paymentId`,`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'3204fb42-98e4-4cd2-84dd-fa36054fcab3',100,'2f210ef3-7792-4a94-b25f-203fefbbfdf5','debit',''),(2,'93403c99-3aa8-4f13-8597-844f594e0da1',100,'71989612-baa1-4286-a1ec-4d73814070a2','debit','account1'),(3,'49ecffe4-a2b1-4ff6-9a9f-f4bbd1af5688',200,'219b5aa6-1d3f-4520-bec1-dd930c72937c','debit','account1'),(4,'cb2b6e4c-4f32-476a-abd3-c19cde9411d4',1000,'df62274b-0534-4799-9a39-a4683c91996e','debit','account1'),(5,'5fa91de4-6dd4-411c-b759-0e85e9cc52e3',1000,'1d9ea331-7cc1-47c2-a274-8c0e82ec1580','debit','account1'),(6,'0223e593-a9ce-4e51-bb20-cc2305dbfa32',1000,'6d5ef004-7d05-48f4-af14-b591ebab273c','debit','account1'),(7,'164f1bdd-d28c-4416-8e81-ed13c0c2ce86',100,'52689992-59a4-41aa-a014-5edb1c62febc','debit','account1'),(8,'5b49b5ef-4fbf-46d5-b1ad-18c7e9f8930c',100,'da98c949-f8a7-4b50-a75a-7c508099ee4e','debit','account1'),(9,'834f589b-8d7e-4dc1-b2fb-4e7741ba4bfe',500,'f4f8c6c6-8a72-48e7-be8a-5664ac0065fc','debit','account1'),(10,'5f73ae83-6a9c-4b1e-938b-41a8f2996e28',500,'55dee0c8-d8a7-4c11-9efb-bc9f91755f02','debit','account1'),(11,'3195b76a-e8bd-4fbc-8704-7e6490440319',500,'846d6847-68a8-48f4-a35d-5ef8398edbfc','debit','account1'),(12,'5c8d548d-b304-4072-861f-9a673d84a28b',100,'d07486c0-d9ac-4dba-b71b-a22379655878','debit','account1'),(13,'af63dd01-bc4e-4d04-841d-24843fabe497',100,'b83ec125-aca6-476c-b709-2f7240953ac3','debit','account1'),(14,'efd3ab42-b7a4-4669-bd9c-d3b29a8857c8',600,'fb665b40-56eb-426f-865f-44b0e7fffc6b','debit','account1'),(15,'d434204a-3b6f-4d93-b5a1-5555e2642bf1',800,'bf6d87ca-0261-4186-8540-a12326389a0c','debit','account1'),(16,'283ae5b6-f15f-4ac4-a004-3c771693718b',900,'59420969-da90-4217-bb96-dc7c7f5bb746','debit','account1'),(17,'12ebcc7b-7008-4560-8fc5-92f38a8ec912',20000,'0bdd0107-fc26-4f1c-96f5-1f5596bc204b','debit','account1'),(18,'403f71fe-dfca-4ec5-a198-2a9be3f693ef',20000,'90f465ab-6843-4ea0-8359-5cd5ceff9f4e','debit','account1'),(19,'57ed155d-44d0-44d1-9c28-69c60715836f',20000,'af6c9923-24cc-4ed7-9c3c-3b1c8eb14746','debit','account1'),(20,'c4369603-613f-47a6-8aba-35e68f1db9c2',20000,'b5820354-ec5d-47b3-bfac-1199951c7285','debit','account1'),(21,'98f1689b-55b2-4eb8-84d6-8862a765cd20',20000,'a7b219ac-012e-42f5-b68a-cdad1ad1a161','debit','account1'),(22,'17f33ada-0023-426b-9773-213a4814fe07',20000,'8664931a-db5c-43fa-90e1-62440fe97421','debit','account1'),(23,'09c14177-fc86-4866-aa0e-ccb830ca7f8a',20000,'0d8ec894-f88e-4ef0-88e3-56efc047f65e','debit','account1'),(24,'e3272918-b33b-453b-a65c-f6a0a255a1dd',20000,'5cbbcab1-1998-456f-a9bd-3f831bf3a84c','debit','account1'),(25,'e842ee55-2ce0-48e0-bd54-2bc85ea5c8d9',20000,'761ffe4c-7d55-48e1-9e53-e1d085c1a51a','debit','account1'),(26,'092babe7-f86f-4ecc-9f82-5d154bb489a6',20000,'f239283f-2d0e-4bc0-ad95-217bb3442a9b','debit','account1'),(27,'cbe56c7b-3180-416c-8781-11c8d22c8769',100,'806cc8f1-e5ec-4c99-a50a-56a063486fdb','debit','account1'),(28,'b7d90552-f625-4edc-be09-06998a043f9b',5000,'a66cdd61-9a58-4be1-bdb6-8331fc6c0f56','debit','account1'),(29,'d6d30d98-9894-4183-a4b7-bb2ff2f57fff',6000,'559710d3-5641-4dcc-8be8-0c4c106bb93c','debit','account1'),(30,'4fcb5eaf-1037-4366-ae1e-b12e698738a7',500,'f81e0c3c-6fe6-4d90-8c95-660e1ce4b960','debit','account1'),(31,'4733e1f0-feb9-4769-a40b-7a82dbd09ed0',2000000,'3346f67a-db3a-4d41-b78b-cc936864a027','debit','account1'),(32,'d2dc8443-1dc1-4396-8847-540eed1b1021',3000000,'96b6bb97-d7c3-4bd3-b21b-665ad9db6066','debit','account1'),(33,'c706be9a-9a48-4086-a404-a50405a39974',800,'224b5429-eeea-4178-9151-a2e1b19c4118','debit','account1'),(34,'efe9d802-5e4c-4c5f-8150-b635471f07d4',45000,'06bc1787-a5cf-4d37-8b30-14164b3d46df','debit','account1'),(35,'1ccb1e91-4586-4f9e-9f20-6a573955a456',1360,'2e25ee13-ab81-45a6-90c6-2f59d3f89ced','debit','account1'),(36,'eb1c7a90-6685-4e96-8cd9-3dd8070aae90',8500,'45129d26-d25a-4273-be77-2edc732f3f25','debit','account1'),(37,'3456c5a5-fe4f-4b66-bcd2-f2cdc48fb119',13500,'656df13b-1bf3-41e4-82f1-cac7cf3f0033','debit','2222'),(38,'8d668e80-bb2c-438c-a25a-43a451e9b415',161000,'71718f9a-6bb9-42de-b6b8-34f922945e66','debit','account1'),(39,'bb90a931-48c7-4367-ab14-d957239ad28f',5400,'f0e42a40-c105-40db-aa40-3fae906bb5ef','debit','account1'),(40,'b20f1cde-4fc7-4677-bd74-7bdaa985e601',5400,'f6051801-b148-48f8-934c-4cb8c91762e2','debit','account1'),(41,'30a9649d-8f95-4587-bde6-780411bcabc5',14176,'aa69d7ac-d806-451d-beec-7c362f42bdee','debit','account1'),(42,'d094e363-cee9-40ba-845a-cc17d8890ec3',40000,'0f6d1cbf-e0e9-4aba-8d3a-7c23fb1163bf','debit','account1'),(43,'68d87ad6-d81c-45c0-8e40-3dd0c286614f',100,'7de46153-7ff0-4797-aded-278e9bfc7e8b','debit','account1'),(44,'c972a8af-f039-419e-a291-0faf00dc7f2a',1398,'5ff7021a-16f4-4271-9fc1-a71ce86687af','debit','account1'),(45,'ff56ec16-5773-41e8-b443-c80a263fcb84',750000,'f72e18c1-e291-4429-9868-2bdafbefe44f','debit','account1'),(46,'34e5a709-158a-4aac-bb7b-11931d963e7c',77,'7f0a6f3c-2dee-40c0-a397-d6ec167ebda5','debit','account1'),(47,'f6666243-7864-450f-98ca-3378a733182c',77,'3fb7020f-1a69-4e4f-93a0-20815c026a1f','debit','account1'),(48,'ef2f05ff-f17f-4fb9-bedd-d71923b2c35d',77,'9ec8d982-2896-4e5e-a98d-a94f505266c2','debit','account1'),(49,'a48a8c70-3dc1-44a7-ad4e-eb1cdd81a61f',77,'e08d5783-10cd-46b0-ae68-1419e5eb872c','debit','account1'),(50,'d3510048-fe19-4c80-848b-cd55fd5796ec',77,'51d136e5-1cb0-41cb-9aaa-c683da89d253','debit','account1'),(51,'4b30dbd3-6cec-432d-9e5f-ce8a4e125287',77,'e8c75ce1-d6c5-4b24-8d0c-4e55d3b7a573','debit','account1'),(52,'21fbab70-3399-4c65-8208-8bd66ad62c26',77,'d9ca7c6e-b16b-41d9-a631-cd6a1aae9204','debit','account1'),(53,'d7579aaa-bcdc-429b-9c3a-c68566ea8425',77,'fe8ae065-20c4-4fa6-b667-93dd896e2d0b','debit','account1'),(54,'8d6fbdbd-3c8e-4bb3-816f-51a4ce66f477',77,'a313c306-9d68-4f1d-9c5f-8cfb0be49776','debit','account1'),(55,'bc5be9fc-2779-432e-88e0-957665968b01',93800,'f9e6a0fd-6cf7-48d7-85b9-e90ee8dcf2b6','debit','account1'),(56,'70a12b6e-119f-4777-8e0d-2ea574635037',12250,'673ccc50-3fc4-43f5-808f-7e200eba9a6f','debit','account1'),(57,'PDADIT2604201631321',2450,'ODADIT2604201631321','debit','account1'),(58,'PDADIT2604201681713',950,'ODADIT2604201681713','debit','account1');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
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

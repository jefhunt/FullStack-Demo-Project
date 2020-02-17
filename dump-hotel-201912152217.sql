-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: hotel
-- ------------------------------------------------------
-- Server version	5.7.26

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
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `hotel_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `host_name` varchar(255) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `name` varchar(255) NOT NULL,
  `neighbourhood` varchar(255) NOT NULL,
  `neighbourhood_group` varchar(255) NOT NULL,
  `price` bigint(20) NOT NULL,
  `room_type` varchar(255) NOT NULL,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'Francesca',1.44255,103.7958,'COZICOMFORT','Woodlands','North Region',83,'PRIVATE'),(2,'Sujatha',1.33235,103.78521,'Bukit Timah','Bukit Timah','Central Region',81,'PRIVATE'),(3,'Francesca',1.44246,103.79667,'COMFORT Heights','Woodlands','North Region',69,'PRIVATE'),(4,'Belinda',1.34541,103.95712,'Ensuite EXPO','Tampines','East Region',206,'PRIVATE'),(5,'Belinda',1.34567,103.95963,'B&B Airport','Tampines','East Region',94,'PRIVATE'),(6,'Belinda',1.34702,103.96103,'Airport EXPO','Tampines','East Region',104,'PRIVATE'),(7,'Belinda',1.34348,103.96337,'Jumbo EXPO','Tampines','East Region',208,'PRIVATE'),(8,'Bianca',1.32304,103.91363,'\"The Breezy East \"\"Leopard\"\"\"','Bedok','East Region',50,'PRIVATE'),(9,'Bianca',1.32458,103.91163,'\"The Breezy East \"\"Plumeria\"\"\"','Bedok','East Region',54,'PRIVATE'),(10,'Bianca',1.32545,103.91191,'\"The Breezy East \"\"Red Palm\"\"\"','Bedok','East Region',42,'PRIVATE'),(11,'K2 Guesthouse',1.28875,103.80814,'City Airbnb','Bukit Merah','Central Region',44,'PRIVATE'),(12,'K2 Guesthouse',1.28837,103.81099,'15Outram MRT','Bukit Merah','Central Region',40,'PRIVATE'),(13,'Belinda',1.34561,103.95984,'Booking MRT','Tampines','East Region',417,'PRIVATE'),(14,'Elizabeth',1.31125,103.83816,'Newton subway','Newton','Central Region',65,'PRIVATE'),(15,'K2 Guesthouse',1.28976,103.80896,'Sentosa Hilltop','Bukit Merah','Central Region',44,'PRIVATE'),(16,'K2 Guesthouse',1.28677,103.81244,'REDHILL INSEAD','Bukit Merah','Central Region',40,'PRIVATE'),(17,'K2 Guesthouse',1.28537,103.81087,'Redhill MRT Orange','Bukit Merah','Central Region',31,'PRIVATE'),(18,'Belinda',1.34943,103.95951,'BridgeWater EXPO','Tampines','East Region',49,'PRIVATE'),(19,'Aresha',1.3142,103.90232,'Authentic Peranakan Shophouse','Geylang','Central Region',81,'PRIVATE'),(20,'Elizabeth',1.3115,103.83759,'Newton Train Station','Newton','Central Region',60,'PRIVATE'),(21,'Elizabeth',1.31159,103.83805,'Newton MRT','Newton','Central Region',60,'PRIVATE'),(22,'Adi',1.29345,103.83562,'Heritage Apartment Orchard','River Valley','Central Region',56,'PRIVATE'),(23,'Belinda',1.34838,103.9592,'Lincoln Street','Tampines','East Region',104,'PRIVATE'),(24,'Susan',1.34816,103.93238,'New Vauxhall','Tampines','East Region',37,'PRIVATE'),(25,'Lena',1.34135,103.71139,'Boon Lay MRT','Jurong West','West Region',53,'PRIVATE'),(26,'Frederic',1.33171,103.79383,'Boutiquet Arena','Bukit Timah','Central Region',276,'HOME_APARTMENT'),(27,'Roger',1.30109,103.85234,'Oxford Street View','Rochor','Central Region',167,'PRIVATE'),(28,'Grace',1.31016,103.79853,'Holland Village','Bukit Timah','Central Region',100,'PRIVATE'),(29,'Audrey',1.30901,103.79639,'HDB prime town','Queenstown','Central Region',208,'SHARED'),(30,'Shirlnet',1.36743,103.87288,'Homestay Serangoon','Serangoon','North-East Region',26,'PRIVATE'),(31,'Jimm',1.30792,103.92287,'Condo Beach','Bedok','East Region',176,'HOME_APARTMENT'),(32,'Richard',1.30377,103.89956,'East Coast Boutique','Marine Parade','Central Region',165,'PRIVATE'),(33,'Christiana',1.35001,103.87161,'Cozy Estate','Serangoon','North-East Region',44,'PRIVATE'),(34,'Sharon',1.37527,103.94562,'Good sea view Resort','Pasir Ris','East Region',206,'PRIVATE'),(35,'Homestay In Central Singapore',1.34143,103.84945,'MRT Orchard Road','Toa Payoh','Central Region',51,'PRIVATE'),(36,'Kaurus',1.28315,103.84213,'Chinatown Queen','Outram','Central Region',44,'PRIVATE'),(37,'Immellymel',1.39963,103.9064,'Common\'s Estate','Punggol','North-East Region',167,'PRIVATE'),(38,'Jenny',1.28342,103.78585,'Cosy Bright Empire','Queenstown','Central Region',128,'PRIVATE'),(39,'Dara',1.30292,103.82253,'Orchard Luxury','Tanglin','Central Region',2604,'HOME_APARTMENT');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hotel'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-15 22:17:58

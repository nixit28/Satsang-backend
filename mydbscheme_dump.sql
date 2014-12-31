-- MySQL dump 10.14  Distrib 5.5.40-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: Satsang
-- ------------------------------------------------------
-- Server version	5.5.40-MariaDB

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
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Category` (
  `id_category` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
INSERT INTO `Category` VALUES (1,'વૈરાગ્ય'),(2,'ભક્તિ'),(3,'જ્ઞાન'),(4,'ધર્મ'),(5,'સમજણ'),(6,'ઉપાસના');
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Granth`
--

DROP TABLE IF EXISTS `Granth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Granth` (
  `id_granth` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_granth`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Granth`
--

LOCK TABLES `Granth` WRITE;
/*!40000 ALTER TABLE `Granth` DISABLE KEYS */;
INSERT INTO `Granth` VALUES (1,'ગુણાતીતાનંદ સ્વામીની વાતો');
/*!40000 ALTER TABLE `Granth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Katha`
--

DROP TABLE IF EXISTS `Katha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Katha` (
  `id_katha` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `img_url` varchar(145) DEFAULT NULL,
  `id_orator` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_katha`),
  KEY `fk_Katha_Orator_idx` (`id_orator`),
  CONSTRAINT `fk_Katha_Orator` FOREIGN KEY (`id_orator`) REFERENCES `Orator` (`id_orator`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Katha`
--

LOCK TABLES `Katha` WRITE;
/*!40000 ALTER TABLE `Katha` DISABLE KEYS */;
INSERT INTO `Katha` VALUES (1,'Vandu Sahajanand Ras Rup',NULL,1);
/*!40000 ALTER TABLE `Katha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orator`
--

DROP TABLE IF EXISTS `Orator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Orator` (
  `id_orator` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `image_url` varchar(145) DEFAULT NULL,
  `nick_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_orator`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orator`
--

LOCK TABLES `Orator` WRITE;
/*!40000 ALTER TABLE `Orator` DISABLE KEYS */;
INSERT INTO `Orator` VALUES (1,'સદગુરુ શ્રી ગુણાતીતાનંદ સ્વામી','http://db.tt/dmYrpo9x','Hariswarup Swami'),(2,'પુરાણી શ્રી હરીસ્વરુપ્દાસ સ્વામી','http://db.tt/dmYrpo9x','Gyan Swami'),(3,'સદગુરુ શ્રી ધર્મજીવનદાસ સ્વામી','http://www.gurukulworld.org/rajkot/aboutus/Sources/pioneer.jpg','Shastiji Maharaj'),(4,'સદગુરુ શ્રી જોગી સ્વામી','http://db.tt/vwbnXxIP','Jogi Swami'),(6,'Sadguru Shree Gyanjivandasjiswami 1','http://en.wikipedia.org/wiki/File:GyanjivandasjiSwami.png1','Gyan Swami1'),(8,'ગુણાતીતાનંદ સ્વામી',NULL,NULL);
/*!40000 ALTER TABLE `Orator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Quote`
--

DROP TABLE IF EXISTS `Quote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Quote` (
  `id_quote` int(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `quote` mediumtext,
  `id_orator` int(11) DEFAULT NULL,
  `id_granth` int(11) DEFAULT NULL,
  `date_publish` date DEFAULT NULL,
  `type` varchar(45) DEFAULT 'TEXT',
  PRIMARY KEY (`id_quote`),
  KEY `fk_Quotes_Orator_idx` (`id_orator`),
  KEY `fk_Quotes_Granth_idx` (`id_granth`),
  CONSTRAINT `fk_Quotes_Granth` FOREIGN KEY (`id_granth`) REFERENCES `Granth` (`id_granth`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Quotes_Orator` FOREIGN KEY (`id_orator`) REFERENCES `Orator` (`id_orator`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Quote`
--

LOCK TABLES `Quote` WRITE;
/*!40000 ALTER TABLE `Quote` DISABLE KEYS */;
INSERT INTO `Quote` VALUES (1,'કરોડ કામ બગાડીને પણ એક મોક્ષ સુધારવો ને કદાપિ કરોડ કામ સુધાર્યાં ને એક મોક્ષ બગાડ્યો તો તેમાં શું કર્યું ?',1,1,'2014-12-28','text');
/*!40000 ALTER TABLE `Quote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Quote_Category`
--

DROP TABLE IF EXISTS `Quote_Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Quote_Category` (
  `id_quote` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  PRIMARY KEY (`id_quote`,`id_category`),
  KEY `fk_Category_Quote_idx` (`id_category`),
  CONSTRAINT `fk_Category_Quote` FOREIGN KEY (`id_category`) REFERENCES `Category` (`id_category`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Quote_Category` FOREIGN KEY (`id_quote`) REFERENCES `Quote` (`id_quote`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Quote_Category`
--

LOCK TABLES `Quote_Category` WRITE;
/*!40000 ALTER TABLE `Quote_Category` DISABLE KEYS */;
INSERT INTO `Quote_Category` VALUES (1,3),(1,5);
/*!40000 ALTER TABLE `Quote_Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tracks`
--

DROP TABLE IF EXISTS `Tracks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tracks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `track_no` int(11) NOT NULL DEFAULT '0',
  `id_katha` int(11) NOT NULL,
  `base_url` varchar(150) NOT NULL,
  `part` int(11) DEFAULT NULL,
  `file_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Tracks_Katha_idx` (`id_katha`),
  CONSTRAINT `fk_Tracks_Katha` FOREIGN KEY (`id_katha`) REFERENCES `Katha` (`id_katha`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tracks`
--

LOCK TABLES `Tracks` WRITE;
/*!40000 ALTER TABLE `Tracks` DISABLE KEYS */;
INSERT INTO `Tracks` VALUES (6,1,1,'http://archive.org/download/VanduSahajanand/',1,'01 Vandu Sahajanand part 1-1.mp3'),(7,2,1,'http://archive.org/download/VanduSahajanand/',1,'02 Vandu Sahajanand part 1-2.mp3'),(8,3,1,'http://archive.org/download/VanduSahajanand/',1,'03 Vandu Sahajanand part 2-1.mp3'),(9,4,1,'http://archive.org/download/VanduSahajanand/',1,'04 Vandu Sahajanand part 2-2.mp3'),(10,5,1,'http://archive.org/download/VanduSahajanand/',1,'05 Vandu Sahajanand part 3-1.mp3'),(11,6,1,'http://archive.org/download/VanduSahajanand/',1,'06 Vandu Sahajanand part 3-2.mp3'),(12,7,1,'http://archive.org/download/VanduSahajanand/',1,'07 Vandu Sahajanand part 4-1.mp3'),(13,8,1,'http://archive.org/download/VanduSahajanand/',1,'08 Vandu Sahajanand part 4-2.mp3'),(14,9,1,'http://archive.org/download/VanduSahajanand/',1,'09 Vandu Sahajanand part 5-1.mp3'),(15,10,1,'http://archive.org/download/VanduSahajanand/',1,'10 Vandu Sahajanand part 5-2.mp3'),(16,11,1,'http://archive.org/download/VanduSahajanand/',1,'11 Vandu Sahajanand part 6_1.mp3'),(17,12,1,'http://archive.org/download/VanduSahajanand/',1,'12 Vandu Sahajanand part 6_2.mp3'),(18,13,1,'http://archive.org/download/VanduSahajanand/',1,'13 Vandu Sahajanand part 7-1.mp3'),(19,14,1,'http://archive.org/download/VanduSahajanand/',1,'14 Vandu Sahajanand part 7-2.mp3'),(20,15,1,'http://archive.org/download/VanduSahajanand/',1,'15 Vandu Sahajanand part 8-1.mp3'),(21,16,1,'http://archive.org/download/VanduSahajanand/',1,'16 Vandu Sahajanand part 8-2.mp3'),(22,17,1,'http://archive.org/download/VanduSahajanand/',1,'17 Vandu Sahajanand part 9-1.mp3'),(23,18,1,'http://archive.org/download/VanduSahajanand/',1,'18 Vandu Sahajanand part 9-2.mp3'),(24,19,1,'http://archive.org/download/VanduSahajanand/',1,'19 Vandu Sahajanand part 10-1.mp3'),(25,20,1,'http://archive.org/download/VanduSahajanand/',1,'20 Vandu Sahajanand part 10-2.mp3'),(26,21,1,'http://archive.org/download/VanduSahajanand/',1,'21 Vandu Sahajanand part 11-1.mp3'),(27,22,1,'http://archive.org/download/VanduSahajanand/',1,'22 Vandu Sahajanand part 11-2.mp3'),(28,23,1,'http://archive.org/download/VanduSahajanand/',1,'23 Vandu Sahajanand part 12-1.mp3'),(29,24,1,'http://archive.org/download/VanduSahajanand/',1,'24 Vandu Sahajanand part 12-2.mp3'),(30,25,1,'http://archive.org/download/VanduSahajanand/',1,'25 Vandu Sahajanand part 13-1.mp3'),(31,26,1,'http://archive.org/download/VanduSahajanand/',1,'26 Vandu Sahajanand part 13-2.mp3'),(32,27,1,'http://archive.org/download/VanduSahajanand/',1,'27 Vandu Sahajanand part 14-1.mp3'),(33,28,1,'http://archive.org/download/VanduSahajanand/',1,'28 Vandu Sahajanand part 14-2.mp3'),(34,29,1,'http://archive.org/download/VanduSahajanand/',1,'29 Vandu Sahajanand part 15-1.mp3'),(35,30,1,'http://archive.org/download/VanduSahajanand/',1,'30 Vandu Sahajanand part 15-2.mp3'),(36,31,1,'http://archive.org/download/VanduSahajanand/',1,'31 Vandu Sahajanand part 16-1.mp3'),(37,32,1,'http://archive.org/download/VanduSahajanand/',1,'32 Vandu Sahajanand part 16-2.mp3');
/*!40000 ALTER TABLE `Tracks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-30 20:59:19

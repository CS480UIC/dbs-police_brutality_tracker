-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: policebrutalitydatabase
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `force_type`
--

DROP TABLE IF EXISTS `force_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `force_type` (
  `force_id` int NOT NULL AUTO_INCREMENT,
  `force_used` varchar(60) NOT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`force_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `force_type`
--

LOCK TABLES `force_type` WRITE;
/*!40000 ALTER TABLE `force_type` DISABLE KEYS */;
INSERT INTO `force_type` VALUES (1,'firearm','use of firearm'),(2,'mace','use of pepper spray / mace'),(3,'physical assault','use of fists, legs and other parts of body to cause damage'),(4,'melee weapon','use of object such as baton to hit or strike person'),(5,'vehicle','use of vehicle to hit or strike person');
/*!40000 ALTER TABLE `force_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `infractions`
--

DROP TABLE IF EXISTS `infractions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `infractions` (
  `infractions_id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `officer_involved` int NOT NULL,
  `force_type` int NOT NULL,
  `victim` int NOT NULL,
  `reported_by` int DEFAULT NULL,
  `location` varchar(60) NOT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`infractions_id`),
  KEY `force_type` (`force_type`),
  KEY `officer_involved` (`officer_involved`),
  KEY `reported_by` (`reported_by`),
  KEY `victim` (`victim`),
  CONSTRAINT `infractions_ibfk_1` FOREIGN KEY (`force_type`) REFERENCES `force_type` (`force_id`),
  CONSTRAINT `infractions_ibfk_2` FOREIGN KEY (`officer_involved`) REFERENCES `police_officers` (`officer_id`),
  CONSTRAINT `infractions_ibfk_3` FOREIGN KEY (`reported_by`) REFERENCES `users` (`user_id`),
  CONSTRAINT `infractions_ibfk_4` FOREIGN KEY (`victim`) REFERENCES `victims` (`victim_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `infractions`
--

LOCK TABLES `infractions` WRITE;
/*!40000 ALTER TABLE `infractions` DISABLE KEYS */;
/*!40000 ALTER TABLE `infractions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `police_officers`
--

DROP TABLE IF EXISTS `police_officers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `police_officers` (
  `officer_id` int NOT NULL AUTO_INCREMENT,
  `officer_name` varchar(60) NOT NULL,
  `department` varchar(60) NOT NULL,
  `officer_rank` varchar(60) NOT NULL,
  PRIMARY KEY (`officer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `police_officers`
--

LOCK TABLES `police_officers` WRITE;
/*!40000 ALTER TABLE `police_officers` DISABLE KEYS */;
INSERT INTO `police_officers` VALUES (1,'John Smith','Chicago','Private'),(2,'Smith Johnson','Rockford','Sergeant'),(3,'John Smithson','Los Angeles','Corporal'),(4,'John Johnson','New York','Private'),(5,'Smithy Smithson','Orlando','Private');
/*!40000 ALTER TABLE `police_officers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) NOT NULL,
  `user_password_hash` char(16) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `victims`
--

DROP TABLE IF EXISTS `victims`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `victims` (
  `victim_name` varchar(255) NOT NULL,
  `victim_id` int NOT NULL AUTO_INCREMENT,
  `ethnicity` varchar(255) DEFAULT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`victim_id`),
  CONSTRAINT `victims_chk_1` CHECK (((`gender` in (_utf8mb4'Male',_utf8mb4'Female',_utf8mb4'Other')) or (`gender` is null)))
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `victims`
--

LOCK TABLES `victims` WRITE;
/*!40000 ALTER TABLE `victims` DISABLE KEYS */;
INSERT INTO `victims` VALUES ('John Cena',1,'white','male','2981 Saint Marys Avenue'),('Herbert Hoover',2,'white','male','2094 Hinkle Deegan Lake Road'),('Jill Biden',3,'','female','1735 Brookview Drive'),('Aaron Carlson',4,'white','male','4742 Alpaca Way'),('Anon E. Mouse',5,'','female','372 Mount Olive Road');
/*!40000 ALTER TABLE `victims` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-02 23:05:39

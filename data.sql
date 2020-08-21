
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: zoo
-- ------------------------------------------------------
-- Server version	8.0.19


--
-- Table structure for table `Food`
--
DROP TABLE IF EXISTS `Animal`;

DROP TABLE IF EXISTS `Food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Food` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

--
-- Dumping data for table `Food`
--

/*!40000 ALTER TABLE `Food` DISABLE KEYS */;
INSERT INTO `Food` VALUES (1,'honey','VEGGIE'),(2,'salmon','FISH'),(3,'pedigree 77','MEAT'),(4,'beef','MEAT');
/*!40000 ALTER TABLE `Food` ENABLE KEYS */;


--
-- Table structure for table `Animal`
--


CREATE TABLE `Animal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `foodId` int DEFAULT NULL,
  `foodType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
--   KEY `foodId_idx` (`foodId`),
  CONSTRAINT `foodId` FOREIGN KEY (`foodId`) REFERENCES `Food` (`id`)
) ;

--
-- Dumping data for table `Animal`
--

/*!40000 ALTER TABLE `Animal` DISABLE KEYS */;
INSERT INTO `Animal` VALUES (1,'Fluffy','DOG',4,'MEAT'),(2,'tess','GIRAFFE',NULL,'VEGGIE'),(3,'blub','BEAR',2,'FISH'),(4,'ugly','LION',4,'MEAT'),(5,'jaws','LION',NULL,'MEAT');
/*!40000 ALTER TABLE `Animal` ENABLE KEYS */;


--
-- Table structure for table `Ticket`
--

DROP TABLE IF EXISTS `Ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;


--
-- Dumping data for table `Ticket`
--
/*!40000 ALTER TABLE `Ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `Ticket` ENABLE KEYS */;


-- Dump completed on 2020-05-08 15:33:21

--
-- Table structure for table `Visitor`
--

DROP TABLE IF EXISTS `Visitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Visitor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `visitorType` varchar(45) DEFAULT NULL,
  `ticketId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
    CONSTRAINT `ticketId` FOREIGN KEY (`ticketId`) REFERENCES `Ticket` (`id`)
) ;

insert into Visitor(id,name,visitorType,ticketId)values(1,"Tom", "ADULT",null );
insert into Visitor(id,name,visitorType,ticketId)values(2,"Jan", "ADULT",null);
insert into Visitor(id,name,visitorType,ticketId)values(3,"Liam", "CHILD",null);

-- MariaDB dump 10.17  Distrib 10.4.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: workers
-- ------------------------------------------------------
-- Server version	10.4.11-MariaDB-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `workers`
--

DROP TABLE IF EXISTS `workers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workers` (
  `ID` text DEFAULT NULL,
  `Speciality` text DEFAULT NULL,
  `Name` text DEFAULT NULL,
  `Login` text DEFAULT NULL,
  `Password` text DEFAULT NULL,
  `LastAuth` datetime DEFAULT NULL,
  `AuthStatus` text DEFAULT NULL,
  `PK` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`PK`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workers`
--

LOCK TABLES `workers` WRITE;
/*!40000 ALTER TABLE `workers` DISABLE KEYS */;
INSERT INTO `workers` VALUES ('ID 101','Продавец','Иванов Иван Иванович','Ivanov@namecomp.ru','2L6KZG','2022-10-23 00:00:00','Успешно',1),('ID 102','Продавец','Петров Петр Петрович','petrov@namecomp.ru','uzWC67','2022-05-15 13:13:00','Успешно',2),('ID 103','Администратор','Федоров Федор Федорович','fedorov@namecomp.ru','8ntwUp','2022-10-23 00:00:00','Успешно',3),('ID 104','Старший смены','Миронов Вениамин Куприянович','mironov@namecomp.ru','YOyhfR','2022-05-15 13:13:00','Успешно',4),('ID 105','Старший смены','Ширяев Ермолай Вениаминович','shiryev@namecomp.ru','RSbvHv','2022-05-15 13:13:00','Неуспешно',5),('ID 106','Старший смены','Игнатов Кассиан Васильевич','ignatov@namecomp.ru','rwVDh9','2022-10-23 00:00:00','Успешно',6),('ID 107','Продавец','Хохлов Владимир Мэлсович','hohlov@namecomp.ru','LdNyos','2022-10-23 00:00:00','Успешно',7),('ID 108','Продавец','Стрелков Мстислав Георгьевич','strelkov@namecomp.ru','gynQMT','2022-05-15 13:13:00','Неуспешно',8),('ID 109','Продавец','Беляева Лилия Наумовна','belyeva@@namecomp.ru','AtnDjr','2022-05-15 13:13:00','Успешно',9),('ID 110','Продавец','Смирнова Ульяна Гордеевна','smirnova@@namecomp.ru','JlFRCZ','2022-05-15 13:13:00','Успешно',10);
/*!40000 ALTER TABLE `workers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-23 21:35:23

-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: barbar_sns
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'test001','aaaa','佐藤佑太','barbar.walk123+001@gmail.com','/assets/profileimg/messages-3.jpg','性別：男性\r\n年齢：25歳\r\n出身地：東京都\r\n職業：大学生\r\n趣味：サッカー、読書、旅行\r\n自己紹介：東京在住の大学生です。サッカーが大好きで、週末にはよく友達と一緒に試合に出かけます。\r\nまた、新しい本を読むことも好きで、最近は小説をよく読んでいます。将来の夢はサッカー選手になることです！\r\n','2024-05-10 13:45:47','2024-05-10 14:04:54'),(2,'test002','aaaa','鈴木優希','barbar.walk123+002@gmail.com','/assets/profileimg/messages-1.jpg','性別：女性\r\n年齢：22歳\r\n出身地：大阪府\r\n職業：大学生\r\n趣味：料理、音楽鑑賞、映画鑑賞\r\n自己紹介：大阪出身の大学生です。料理が得意で、よく友達を自宅に招待してパーティーを開きます。\r\n音楽や映画も大好きで、週末には友達と一緒にライブや映画館に行くことが多いです。将来の夢はフードライターになることです！\r\n','2024-05-10 13:46:06','2024-05-10 14:05:35'),(3,'test003','aaaa','高橋美咲','barbar.walk123+003@gmail.com','/assets/profileimg/messages-2.jpg','性別：女性\r\n年齢：28歳\r\n出身地：京都府\r\n職業：会社員（広告代理店）\r\n趣味：写真撮影、カフェ巡り、手芸\r\n自己紹介：京都出身の広告代理店勤務のOLです。休日はよく友達と一緒にカフェ巡りを楽しんでいます。\r\n写真撮影も趣味で、美しい景色や料理を撮影するのが好きです。また、手芸も得意で、よく自宅で布小物を作っています。\r\n','2024-05-10 13:46:25','2024-05-10 14:06:11'),(4,'test004','aaaa','田中大翔','barbar.walk123+004@gmail.com',NULL,NULL,'2024-05-10 13:46:43','2024-05-10 13:46:43'),(5,'test005','aaaa','渡辺陽菜','barbar.walk123+005@gmail.com',NULL,NULL,'2024-05-10 13:47:01','2024-05-10 13:47:01'),(6,'test006','aaaa','山本大輝','barbar.walk123+006@gmail.com',NULL,NULL,'2024-05-10 13:48:53','2024-05-10 13:48:53'),(7,'test007','aaaa','中村美優','barbar.walk123+007@gmail.com',NULL,NULL,'2024-05-10 13:49:08','2024-05-10 13:49:08'),(8,'test008','aaaa','小林颯太','barbar.walk123+008@gmail.com',NULL,NULL,'2024-05-10 13:49:29','2024-05-10 13:49:29'),(9,'test009','aaaa','加藤葵','barbar.walk123+009@gmail.com',NULL,NULL,'2024-05-10 13:49:51','2024-05-10 13:49:51'),(10,'test010','aaaa','吉田真央','barbar.walk123+010@gmail.com',NULL,NULL,'2024-05-10 13:50:08','2024-05-10 13:50:08');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-10 16:32:37

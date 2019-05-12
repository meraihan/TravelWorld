/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.26-0ubuntu0.16.04.1 : Database - travel_world
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`travel_world` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `travel_world`;

/*Table structure for table `area` */

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(128) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `area` */

insert  into `area`(`id`,`location`,`created_at`,`updated_at`,`deleted_at`) values (1,'Dhaka','2019-05-12 08:20:00','2019-05-12 08:20:00','2019-05-12 08:20:00'),(2,'Khulna','2019-05-12 08:20:02','2019-05-12 08:20:02','2019-05-12 08:20:02'),(3,'Sylhet','2019-05-12 08:20:07','2019-05-12 08:20:07','2019-05-12 08:20:07');

/*Table structure for table `posts` */

DROP TABLE IF EXISTS `posts`;

CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post` varchar(255) NOT NULL,
  `status` enum('PUBLIC','PRIVATE') NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `posts_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `area` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `posts` */

insert  into `posts`(`id`,`post`,`status`,`user_id`,`location_id`,`created_at`,`updated_at`,`deleted_at`) values (1,'aaaaaaaaa','PUBLIC',1,1,'2019-05-12 08:20:22','2019-05-12 08:20:22','2019-05-12 08:20:22'),(2,'bbbbbbbbbb','PRIVATE',1,2,'2019-05-12 08:20:33','2019-05-12 08:20:33','2019-05-12 08:20:33'),(3,'ccccccccccc','PUBLIC',2,3,'2019-05-12 08:20:48','2019-05-12 08:20:48','2019-05-12 08:20:48');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(128) DEFAULT NULL,
  `user_name` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(128) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` enum('MALE','FEMALE','OTHER') DEFAULT NULL,
  `is_active` tinyint(4) NOT NULL,
  `role` varchar(32) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`full_name`,`user_name`,`password`,`email`,`address`,`gender`,`is_active`,`role`,`created_at`,`deleted_at`,`updated_at`) values (1,'Sayed Mahmud','meraihan','$2a$10$P/7uBuitgfcpS2E4TdFSkOlQ5YSO0fiO.eVAh8hFmsC37dLHqkl2W','asdasd',NULL,'MALE',1,'USER','2019-05-12 08:10:07','2019-05-12 08:10:10','2019-05-12 08:10:13'),(2,'Iren Sultana','iren','$2a$10$P/7uBuitgfcpS2E4TdFSkOlQ5YSO0fiO.eVAh8hFmsC37dLHqkl2W','asd',NULL,'MALE',1,'USER','2019-05-12 08:42:37','2019-05-12 08:42:39','2019-05-12 08:42:40'),(3,'Sayed Mahmud Raihan','aaa','$2a$10$1zNfThxIiMI5pXPoZ4xiT.4echCsuqY8AMfD0KHxGkPvy0lr2C3je','ponyirenpony@gmail.com',NULL,'MALE',1,'USER','2019-05-12 10:13:43','2019-05-12 10:13:45','2019-05-12 10:13:47'),(4,'Sayed Mahmud Raihan','raihan','$2a$10$fNWQK5FQLJ0nTClLbgKPj.mHujmY431BB9Bs6myH2rb8PiOYPbCOy','ponyirenpony@gmail.com',NULL,'FEMALE',1,'USER','2019-05-12 10:13:49','2019-05-12 10:13:51','2019-05-12 10:13:52');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

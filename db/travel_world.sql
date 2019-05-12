/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.13-MariaDB : Database - travel_world
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

insert  into `area`(`id`,`location`,`created_at`,`updated_at`,`deleted_at`) values (1,'Khulna','2019-05-11 15:25:48','2019-05-11 15:25:48','2019-05-11 15:25:48'),(2,'Sylhet','2019-05-11 15:25:51','2019-05-11 15:25:51','2019-05-11 15:25:51'),(3,'Dhaka','2019-05-11 15:25:55','2019-05-11 15:25:55','2019-05-11 15:25:55');

/*Table structure for table `posts` */

DROP TABLE IF EXISTS `posts`;

CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post` varchar(255) NOT NULL,
  `status` enum('PUBLIC','PRIVATE') NOT NULL,
  `user_id` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `posts_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `area` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `posts` */

insert  into `posts`(`id`,`post`,`status`,`user_id`,`location_id`,`created_at`,`updated_at`,`deleted_at`) values (1,'aaaaaaaaaaa','PRIVATE',1,3,'2019-05-11 15:26:12','2019-05-11 15:26:12','2019-05-11 15:26:12'),(3,'ccccccc','PUBLIC',1,3,'2019-05-11 15:26:52','2019-05-11 15:26:52','2019-05-11 15:26:52');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(128) DEFAULT NULL,
  `user_name` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(128) NOT NULL,
  `is_active` tinyint(4) DEFAULT NULL,
  `role` enum('ADMIN','USER') DEFAULT NULL,
  `gender` enum('MALE','FEMALE','OTHER') DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`full_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`full_name`,`user_name`,`password`,`email`,`is_active`,`role`,`gender`,`address`,`created_at`,`updated_at`,`deleted_at`) values (1,'Sayed Mahmud','meraihan','$2a$10$P/7uBuitgfcpS2E4TdFSkOlQ5YSO0fiO.eVAh8hFmsC37dLHqkl2W','a@gmail.com',NULL,'USER','MALE','aaaaa','2019-05-11 10:53:32','2019-05-11 10:53:32','2019-05-11 10:53:32'),(2,'Iren Sultana','iren','$2a$10$HGCtS/1g7OdD.YmDEUst3euJoNIOgCbRMBIIwrkITt7jtnCfqXdsG','a@gmail.com',NULL,'USER','FEMALE',NULL,'2019-05-11 11:30:54','2019-05-11 11:30:57','2019-05-11 11:31:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

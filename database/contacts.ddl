CREATE DATABASE  IF NOT EXISTS `contacts`;
USE `contacts`;


DROP TABLE IF EXISTS `ContactNames`;
CREATE TABLE `ContactNames` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) 


DROP TABLE IF EXISTS `PhoneNumbers`;
CREATE TABLE `PhoneNumbers` (
  `contactId` int(11) unsigned NOT NULL,
  `phoneNumber` varchar(255) NOT NULL,
  FOREIGN KEY (contactId) REFERENCES contactnames(id),
  PRIMARY KEY (`contactId`,`phoneNumber`)
) 

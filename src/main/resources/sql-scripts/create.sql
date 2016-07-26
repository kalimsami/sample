/*
Navicat MySQL Data Transfer

Source Server         : localhost_3309
Source Server Version : 50617
Source Host           : localhost:3309
Source Database       : shoppree

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-02-05 22:42:54
*/
DROP DATABASE IF EXISTS `shoppree`;
CREATE DATABASE shoppree;

USE SHOPPREE;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `benefits_desc`
-- ----------------------------
DROP TABLE IF EXISTS `benefits_desc`;
CREATE TABLE `benefits_desc` (
  `benefit_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `benefit_desc` varchar(300) NOT NULL,
  `category` varchar(100) NOT NULL,
  `business_id` bigint(11) NOT NULL,
  `dateTimeStamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userId` int(10) DEFAULT NULL,
  PRIMARY KEY (`benefit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for `benefits_loc`
-- ----------------------------
DROP TABLE IF EXISTS `benefits_loc`;
CREATE TABLE `benefits_loc` (
  `benefits_loc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_line` varchar(500) NOT NULL,
  `latitude` varchar(100) DEFAULT NULL,
  `longitude` varchar(100) DEFAULT NULL,
  `benefit_id` bigint(11) NOT NULL,
  `business_id` bigint(11) NOT NULL,
  `dateTimeStamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userId` int(10) NOT NULL,
  PRIMARY KEY (`benefits_loc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for `business_details`
-- ----------------------------
DROP TABLE IF EXISTS `business_details`;
CREATE TABLE `business_details` (
  `business_id` int(11) NOT NULL AUTO_INCREMENT,
  `businessName` varchar(100) NOT NULL,
  `details` varchar(5000) NOT NULL,
  `businessLogo` varchar(50) NOT NULL,
  `website` varchar(100) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `dateTimeStamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userId` int(10) NOT NULL,
  PRIMARY KEY (`business_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_type` varchar(50) NOT NULL,
  `category_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- ----------------------------
-- Table structure for `imported_products`
-- ----------------------------
DROP TABLE IF EXISTS `imported_products`;
CREATE TABLE `imported_products` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


-- ----------------------------
-- Table structure for `loyality_card_items`
-- ----------------------------
DROP TABLE IF EXISTS `loyality_card_items`;
CREATE TABLE `loyality_card_items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `no_of_purchases` varchar(100) NOT NULL,
  `item_image` varchar(100) NOT NULL,
  `red_product_id` varchar(300) NOT NULL,
  `dateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `loyality_card_points`
-- ----------------------------
DROP TABLE IF EXISTS `loyality_card_points`;
CREATE TABLE `loyality_card_points` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `points_count` varchar(100) NOT NULL,
  `currency_count` varchar(100) NOT NULL,
  `currency` varchar(100) NOT NULL,
  `card_image` varchar(100) NOT NULL,
  `red_money_value` varchar(100) NOT NULL,
  `red_currency` varchar(100) NOT NULL,
  `red_points` varchar(100) NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


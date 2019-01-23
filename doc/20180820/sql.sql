




CREATE DATABASE IF NOT EXISTS kargo_digitalAds DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use kargo_digitalAds;


DROP TABLE IF EXISTS `ads_agency`;
CREATE TABLE `ads_agency` (
  `agency_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agency_name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `created_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`agency_id`),
  UNIQUE KEY `uniq_name` (`agency_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `ads_brand`;
CREATE TABLE `ads_brand` (
  `brand_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `created_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`brand_id`),
  UNIQUE KEY `uniq_name` (`brand_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `ads_campaign` (
  `campaign_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `campaign_name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `brand_id` bigint(20) NOT NULL DEFAULT '0',
  `agency_id` bigint(20) NOT NULL DEFAULT '0',
  `limit_day_of_week` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'M,T,W,TH,F,S,SU',
  `cost_type` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'CPC,CPM',
  `unit_cost` decimal(18,2) NOT NULL DEFAULT '0.00',
  `budget` decimal(18,2) NOT NULL DEFAULT '0.00',
  `total_impressions` decimal(18,2) NOT NULL DEFAULT '0.00',
  `start_date` date NOT NULL DEFAULT '1970-01-01',
  `end_date` date NOT NULL DEFAULT '1970-01-01',
  `expired_type` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'DATE,FUND',
  `is_active_camp` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '',
  `ads_desc` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `ads_url` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `ads_image` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `created_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`campaign_id`),
  UNIQUE KEY `uniq_name` (`campaign_name`),
  KEY `idx_start_date` (`start_date`),
  KEY `idx_end_date` (`end_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `ads_campaign_channel_relationship` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `campaign_id` bigint(20) NOT NULL DEFAULT '0',
  `channel_id` bigint(20) NOT NULL DEFAULT '0',
  `created_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_campaign` (`campaign_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `ads_campaign_history` (
  `history_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `campaign_id` bigint(20) NOT NULL DEFAULT '0',
  `campaign_name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `brand_id` bigint(20) NOT NULL DEFAULT '0',
  `agency_id` bigint(20) NOT NULL DEFAULT '0',
  `limit_day_of_week` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'M,T,W,TH,F,S,SU',
  `cost_type` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'CPC,CPM',
  `unit_cost` decimal(18,2) NOT NULL DEFAULT '0.00',
  `budget` decimal(18,2) NOT NULL DEFAULT '0.00',
  `total_impressions` decimal(18,2) NOT NULL DEFAULT '0.00',
  `start_date` date NOT NULL DEFAULT '1970-01-01',
  `end_date` date NOT NULL DEFAULT '1970-01-01',
  `expired_type` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'DATE,FUND',
  `is_active_camp` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '',
  `ads_desc` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `ads_url` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `ads_image` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `reason` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `created_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`history_id`),
  KEY `idx_campaign` (`campaign_id`),
  KEY `idx_start_date` (`start_date`),
  KEY `idx_end_date` (`end_date`),
  KEY `idx_name` (`campaign_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `ads_channel` (
  `channel_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `channel_name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `mid` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `created_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`channel_id`),
  UNIQUE KEY `uniq_name` (`channel_name`),
  UNIQUE KEY `uniq_mid` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `ads_message_open_click_info_new` (
  `click_info_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `campaign_id` bigint(20) NOT NULL DEFAULT '0',
  `kcid` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `wechat_order_id` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `open_id` varchar(80) COLLATE utf8_bin NOT NULL DEFAULT '',
  `txn_amt` decimal(18,2) NOT NULL DEFAULT '0.00',
  `txn_date` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `mid` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `tid` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `store_id` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `store_name` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `ad_route` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `type` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `mobile_os` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `created_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`click_info_id`),
  KEY `idx_mid` (`mid`),
  KEY `idx_date` (`txn_date`),
  KEY `idx_campaign` (`campaign_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `ads_message_wechat_cs_info_new` (
  `cs_info_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `campaign_id` bigint(20) NOT NULL DEFAULT '0',
  `kcid` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `wechat_order_id` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `open_id` varchar(80) COLLATE utf8_bin NOT NULL DEFAULT '',
  `txn_amt` decimal(18,2) NOT NULL DEFAULT '0.00',
  `txn_date` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `mid` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `tid` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `store_id` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `store_name` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `ad_route` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `wechat_response` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `impression_status` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '',
  `created_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cs_info_id`),
  KEY `idx_mid` (`mid`),
  KEY `idx_date` (`txn_date`),
  KEY `idx_campaign` (`campaign_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `dead_queue_message_info_new` (
  `dead_info_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `campaign_id` bigint(20) NOT NULL DEFAULT '0',
  `kcid` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `wechat_order_id` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `open_id` varchar(80) COLLATE utf8_bin NOT NULL DEFAULT '',
  `txn_amt` decimal(18,2) NOT NULL DEFAULT '0.00',
  `txn_date` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `mid` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `tid` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `store_id` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `store_name` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `ad_route` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `decline_type` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `err_code` varchar(150) COLLATE utf8_bin NOT NULL DEFAULT '',
  `err_message` varchar(600) COLLATE utf8_bin NOT NULL DEFAULT '',
  `created_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`dead_info_id`),
  KEY `idx_date` (`txn_date`),
  KEY `idx_compaign` (`campaign_id`),
  KEY `idx_mid` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



CREATE DATABASE IF NOT EXISTS kargo_etlAds DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use kargo_etlAds;


/*
 Navicat MySQL Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 50634
 Source Host           : 115.29.196.109:3306
 Source Schema         : kargo_etlAds

 Target Server Type    : MySQL
 Target Server Version : 50634
 File Encoding         : 65001

 Date: 06/09/2018 15:49:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fact_ads_message_open_click_info
-- ----------------------------
DROP TABLE IF EXISTS `fact_ads_message_open_click_info`;
CREATE TABLE `fact_ads_message_open_click_info` (
  `click_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL DEFAULT '1970-01-01',
  `campaign_id` bigint(20) NOT NULL DEFAULT '0',
  `mid` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `sum_txn_amt` decimal(18,2) NOT NULL DEFAULT '0.00',
  `sum_total_clicks` bigint(20) NOT NULL DEFAULT '0',
  `created_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`click_id`),
  KEY `idx_date` (`date`),
  KEY `idx_campaign` (`campaign_id`),
  KEY `idx_mid` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for fact_ads_message_wechat_cs_info
-- ----------------------------
DROP TABLE IF EXISTS `fact_ads_message_wechat_cs_info`;
CREATE TABLE `fact_ads_message_wechat_cs_info` (
  `success_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL DEFAULT '1970-01-01',
  `campaign_id` bigint(20) NOT NULL DEFAULT '0',
  `mid` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `sum_txn_amt` decimal(18,2) NOT NULL DEFAULT '0.00',
  `sum_total_successful_push` bigint(20) NOT NULL DEFAULT '0',
  `created_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`success_id`),
  KEY `idx_date` (`date`),
  KEY `idx_campaign` (`campaign_id`),
  KEY `idx_mid` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for fact_dead_queue_message_info
-- ----------------------------
DROP TABLE IF EXISTS `fact_dead_queue_message_info`;
CREATE TABLE `fact_dead_queue_message_info` (
  `fail_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL DEFAULT '1970-01-01',
  `campaign_id` bigint(20) NOT NULL DEFAULT '0',
  `mid` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  `sum_txn_amt` decimal(18,2) NOT NULL DEFAULT '0.00',
  `sum_total_failed_push` bigint(20) NOT NULL DEFAULT '0',
  `created_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`fail_id`),
  KEY `idx_date` (`date`),
  KEY `idx_campaign` (`campaign_id`),
  KEY `idx_mid` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;





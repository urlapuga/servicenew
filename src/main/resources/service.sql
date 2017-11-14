/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : service

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-11-14 17:03:33
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `addr_adress`
-- ----------------------------
DROP TABLE IF EXISTS `addr_adress`;
CREATE TABLE `addr_adress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `building` int(5) DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `building` (`building`),
  CONSTRAINT `building` FOREIGN KEY (`building`) REFERENCES `addr_buildings` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addr_adress
-- ----------------------------
INSERT INTO `addr_adress` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `addr_buildings`
-- ----------------------------
DROP TABLE IF EXISTS `addr_buildings`;
CREATE TABLE `addr_buildings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(10) DEFAULT NULL,
  `street` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `street` (`street`),
  CONSTRAINT `street` FOREIGN KEY (`street`) REFERENCES `addr_streets` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addr_buildings
-- ----------------------------
INSERT INTO `addr_buildings` VALUES ('1', '23а', '1');

-- ----------------------------
-- Table structure for `addr_cities`
-- ----------------------------
DROP TABLE IF EXISTS `addr_cities`;
CREATE TABLE `addr_cities` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addr_cities
-- ----------------------------
INSERT INTO `addr_cities` VALUES ('1', 'Киев');

-- ----------------------------
-- Table structure for `addr_streets`
-- ----------------------------
DROP TABLE IF EXISTS `addr_streets`;
CREATE TABLE `addr_streets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `city` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `city` (`city`),
  CONSTRAINT `city` FOREIGN KEY (`city`) REFERENCES `addr_cities` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addr_streets
-- ----------------------------
INSERT INTO `addr_streets` VALUES ('1', 'проспект Степана Бандеры', '1');

-- ----------------------------
-- Table structure for `app_user`
-- ----------------------------
DROP TABLE IF EXISTS `app_user`;
CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sso_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sso_id` (`sso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of app_user
-- ----------------------------
INSERT INTO `app_user` VALUES ('1', 'ssoid', 'pass', 'test', 'testlast', 'urlapuga@gmail.com');

-- ----------------------------
-- Table structure for `app_user_user_profile`
-- ----------------------------
DROP TABLE IF EXISTS `app_user_user_profile`;
CREATE TABLE `app_user_user_profile` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`user_profile_id`),
  KEY `FK_USER_PROFILE` (`user_profile_id`),
  CONSTRAINT `FK_APP_USER` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of app_user_user_profile
-- ----------------------------
INSERT INTO `app_user_user_profile` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `chat_messages`
-- ----------------------------
DROP TABLE IF EXISTS `chat_messages`;
CREATE TABLE `chat_messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timecreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `text` varchar(255) DEFAULT NULL,
  `fromuser` int(255) DEFAULT NULL,
  `touser` int(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `room` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fromuser` (`fromuser`),
  KEY `touser` (`touser`),
  KEY `room` (`room`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat_messages
-- ----------------------------
INSERT INTO `chat_messages` VALUES ('1', '2017-10-10 12:22:14', 'testMessage', '3', '4', null, '1');
INSERT INTO `chat_messages` VALUES ('2', '2017-10-10 15:36:44', 'tesMessage2', '4', '3', '', '1');
INSERT INTO `chat_messages` VALUES ('8', '2017-10-10 18:07:47', '12345', '2', '1', null, '1');
INSERT INTO `chat_messages` VALUES ('9', '2017-10-10 18:08:46', '122', '3', '1', null, '1');
INSERT INTO `chat_messages` VALUES ('10', '2017-10-10 18:08:53', '1', '1', '1', null, '1');
INSERT INTO `chat_messages` VALUES ('13', '2017-10-10 18:10:06', '123', '1', '1', null, '1');

-- ----------------------------
-- Table structure for `chat_room_users`
-- ----------------------------
DROP TABLE IF EXISTS `chat_room_users`;
CREATE TABLE `chat_room_users` (
  `id` int(11) NOT NULL,
  `room_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `chat_id` (`room_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `chat_id` FOREIGN KEY (`room_id`) REFERENCES `chat_rooms` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `employees` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat_room_users
-- ----------------------------
INSERT INTO `chat_room_users` VALUES ('1', '1', '3');

-- ----------------------------
-- Table structure for `chat_rooms`
-- ----------------------------
DROP TABLE IF EXISTS `chat_rooms`;
CREATE TABLE `chat_rooms` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat_rooms
-- ----------------------------
INSERT INTO `chat_rooms` VALUES ('1', 'test');

-- ----------------------------
-- Table structure for `cold_calls`
-- ----------------------------
DROP TABLE IF EXISTS `cold_calls`;
CREATE TABLE `cold_calls` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT NULL,
  `result` int(11) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `manager` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cold_calls
-- ----------------------------

-- ----------------------------
-- Table structure for `companies`
-- ----------------------------
DROP TABLE IF EXISTS `companies`;
CREATE TABLE `companies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `director` int(3) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=cp1251;

-- ----------------------------
-- Records of companies
-- ----------------------------
INSERT INTO `companies` VALUES ('1', 'svarka', 'code', '0441112233', '5', 'email');
INSERT INTO `companies` VALUES ('2', 'any company', '1231', '0441112233', '4', 'email');
INSERT INTO `companies` VALUES ('3', 'test company', 'код', '0441112233', '4', 'email');
INSERT INTO `companies` VALUES ('6', '12', '3', '3', '0', '3');

-- ----------------------------
-- Table structure for `device_models`
-- ----------------------------
DROP TABLE IF EXISTS `device_models`;
CREATE TABLE `device_models` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of device_models
-- ----------------------------
INSERT INTO `device_models` VALUES ('1', 'Catalyst 3750 series');

-- ----------------------------
-- Table structure for `device_types`
-- ----------------------------
DROP TABLE IF EXISTS `device_types`;
CREATE TABLE `device_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of device_types
-- ----------------------------
INSERT INTO `device_types` VALUES ('1', 'switch');

-- ----------------------------
-- Table structure for `devices`
-- ----------------------------
DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `model` int(11) DEFAULT NULL,
  `ipaddress` varchar(20) DEFAULT NULL,
  `login` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `address` int(10) DEFAULT NULL,
  `floor` int(2) DEFAULT NULL,
  `lat` varchar(255) DEFAULT NULL,
  `lng` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type` (`type`),
  KEY `model` (`model`),
  CONSTRAINT `model` FOREIGN KEY (`model`) REFERENCES `device_models` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `type` FOREIGN KEY (`type`) REFERENCES `device_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of devices
-- ----------------------------
INSERT INTO `devices` VALUES ('1', '1', '1', '10.4.1.1', 'login', 'password', '1', '1', '50.491', '30.494');
INSERT INTO `devices` VALUES ('2', '1', '1', '10.4.1.12', 'login', 'password', '1', '2', '50.489706', '30.494');

-- ----------------------------
-- Table structure for `employees`
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `phonenumber` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  `login` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `emlid` (`id`) USING BTREE,
  KEY `FK1ekpcbo0lmdx6ou8e3fh9j4lq` (`company_id`),
  KEY `FKngcpgx7fx5kednw3m7u0u8of3` (`position_id`),
  CONSTRAINT `companyid` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('0', '', 'no employee', '0', '0', '1', '0', '0', '0');
INSERT INTO `employees` VALUES ('3', 'Andrey', 'Ponomarenko', '380638339275', 'urlapuga@gmail.com', '1', '1', '1', '1');
INSERT INTO `employees` VALUES ('4', 'Dima', 'Marchenko', '380638339275', 'malief@gmail.com', '1', '2', 'testlogin', 'gfhjkm');
INSERT INTO `employees` VALUES ('5', 'Kiril', 'Maliev', '380638339275', 'dmarchenko@gmail.com', '1', '2', 'nickname', 'gfhjkm');
INSERT INTO `employees` VALUES ('6', 'ira', 'lastname', '380638339275', 'ira@email.domain', '1', '4', 'ira', 'ira');
INSERT INTO `employees` VALUES ('7', 'managername', 'managersurname', '380638339275', 'manager@email.com', '1', '5', 'manager', 'managerpas');
INSERT INTO `employees` VALUES ('8', 'managername2', 'managersurname2', '380638339275', 'manager@email.com', '1', '5', 'manager', 'managerpas');
INSERT INTO `employees` VALUES ('9', 'managername3', 'managersurname3s', '380638339275', 'manager@email.com', '1', '5', 'manager', 'managerpas');

-- ----------------------------
-- Table structure for `files`
-- ----------------------------
DROP TABLE IF EXISTS `files`;
CREATE TABLE `files` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `type` int(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of files
-- ----------------------------

-- ----------------------------
-- Table structure for `files_subscribers`
-- ----------------------------
DROP TABLE IF EXISTS `files_subscribers`;
CREATE TABLE `files_subscribers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subscriber` int(255) DEFAULT NULL,
  `file` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of files_subscribers
-- ----------------------------

-- ----------------------------
-- Table structure for `files_types`
-- ----------------------------
DROP TABLE IF EXISTS `files_types`;
CREATE TABLE `files_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of files_types
-- ----------------------------

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `next_val` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1', '12');

-- ----------------------------
-- Table structure for `ip_type`
-- ----------------------------
DROP TABLE IF EXISTS `ip_type`;
CREATE TABLE `ip_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ip_type
-- ----------------------------
INSERT INTO `ip_type` VALUES ('1', 'dhcp');
INSERT INTO `ip_type` VALUES ('2', 'static');

-- ----------------------------
-- Table structure for `logg`
-- ----------------------------
DROP TABLE IF EXISTS `logg`;
CREATE TABLE `logg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `when_done` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `who` int(11) DEFAULT NULL,
  `what` varchar(100) DEFAULT NULL,
  `what_id` varchar(100) DEFAULT NULL,
  `action` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employeeloged` (`who`),
  CONSTRAINT `employeeloged` FOREIGN KEY (`who`) REFERENCES `employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logg
-- ----------------------------
INSERT INTO `logg` VALUES ('15', '2017-11-10 17:07:57', '3', 'login', null, 'success');
INSERT INTO `logg` VALUES ('16', '2017-11-10 17:21:25', '3', 'login', '', 'success');
INSERT INTO `logg` VALUES ('17', '2017-11-10 17:21:25', '3', 'login', '', 'success');
INSERT INTO `logg` VALUES ('18', '2017-11-10 17:32:19', '3', 'login', '', 'success');
INSERT INTO `logg` VALUES ('19', '2017-11-13 11:46:14', '3', 'login', '', 'success');
INSERT INTO `logg` VALUES ('20', '2017-11-13 15:15:55', '3', 'login', '', 'success');
INSERT INTO `logg` VALUES ('21', '2017-11-13 16:09:12', '3', 'login', '', 'success');
INSERT INTO `logg` VALUES ('22', '2017-11-13 16:40:25', '3', 'login', '', 'success');

-- ----------------------------
-- Table structure for `optic_lines`
-- ----------------------------
DROP TABLE IF EXISTS `optic_lines`;
CREATE TABLE `optic_lines` (
  `devicefrom` int(5) DEFAULT NULL,
  `deviceto` int(5) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unik` (`devicefrom`,`deviceto`) USING BTREE,
  KEY `idfrom` (`devicefrom`) USING BTREE,
  KEY `idto` (`deviceto`) USING BTREE,
  CONSTRAINT `idfrom` FOREIGN KEY (`devicefrom`) REFERENCES `devices` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idto` FOREIGN KEY (`deviceto`) REFERENCES `devices` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of optic_lines
-- ----------------------------
INSERT INTO `optic_lines` VALUES ('1', '2', '1');

-- ----------------------------
-- Table structure for `page_element`
-- ----------------------------
DROP TABLE IF EXISTS `page_element`;
CREATE TABLE `page_element` (
  `page_id` int(11) NOT NULL,
  `element_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`page_id`),
  KEY `element` (`element_id`),
  CONSTRAINT `element` FOREIGN KEY (`element_id`) REFERENCES `site_elements` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `page` FOREIGN KEY (`page_id`) REFERENCES `site_pages` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of page_element
-- ----------------------------
INSERT INTO `page_element` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `payments`
-- ----------------------------
DROP TABLE IF EXISTS `payments`;
CREATE TABLE `payments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,0) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `coment` varchar(30) DEFAULT NULL,
  `from` varchar(30) DEFAULT NULL,
  `to` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of payments
-- ----------------------------
INSERT INTO `payments` VALUES ('1', '100', '2017-10-02 13:09:17', 'test', '1', '1');
INSERT INTO `payments` VALUES ('2', '200', '2017-10-02 13:09:24', 'test2', '2', '2');

-- ----------------------------
-- Table structure for `pinger`
-- ----------------------------
DROP TABLE IF EXISTS `pinger`;
CREATE TABLE `pinger` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `status` int(1) unsigned zerofill DEFAULT '1',
  `alertstatus` int(1) unsigned zerofill DEFAULT '0',
  `coment` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `dateadded` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `lastpingchage` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pinger
-- ----------------------------
INSERT INTO `pinger` VALUES ('1', '10.4.1.33', '0', '1', 'mysql', '2017-09-27 12:12:27', '2017-10-31 10:37:27');
INSERT INTO `pinger` VALUES ('2', '10.4.1.32', '0', '0', 'server', '2017-09-27 12:12:27', '2017-10-31 10:37:37');

-- ----------------------------
-- Table structure for `positions`
-- ----------------------------
DROP TABLE IF EXISTS `positions`;
CREATE TABLE `positions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `page` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=cp1251;

-- ----------------------------
-- Records of positions
-- ----------------------------
INSERT INTO `positions` VALUES ('0', ' fired', 'fired');
INSERT INTO `positions` VALUES ('1', 'Директор', 'director');
INSERT INTO `positions` VALUES ('2', 'Техник', 'technician');
INSERT INTO `positions` VALUES ('3', 'Оператор', 'operator');
INSERT INTO `positions` VALUES ('4', 'Старший менеджер', 'supermanager');
INSERT INTO `positions` VALUES ('5', 'Менеджер', 'managers');
INSERT INTO `positions` VALUES ('6', 'Старший техник', 'supertechnician');
INSERT INTO `positions` VALUES ('7', 'Бухгалтер', 'buhgalter');
INSERT INTO `positions` VALUES ('8', 'Статист', 'statistics');

-- ----------------------------
-- Table structure for `potential_clients`
-- ----------------------------
DROP TABLE IF EXISTS `potential_clients`;
CREATE TABLE `potential_clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_done` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `done_by` int(11) DEFAULT NULL,
  `adress` int(11) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of potential_clients
-- ----------------------------
INSERT INTO `potential_clients` VALUES ('1', 'Клиент1', '2017-10-04 16:40:22', '2017-10-18 11:37:10', null, '1', '380638339275');

-- ----------------------------
-- Table structure for `rekvizity`
-- ----------------------------
DROP TABLE IF EXISTS `rekvizity`;
CREATE TABLE `rekvizity` (
  `id` int(11) NOT NULL,
  `subscriber` int(255) DEFAULT NULL,
  `fopname` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `rr` int(20) DEFAULT NULL,
  `bank` varchar(255) DEFAULT NULL,
  `mfo` int(10) DEFAULT NULL,
  `edrpou` int(10) DEFAULT NULL,
  `edr` varchar(255) DEFAULT NULL,
  `nalogform` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `data` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `pdv` int(1) DEFAULT NULL,
  `site` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rekvizity
-- ----------------------------
INSERT INTO `rekvizity` VALUES ('1', '1', 'fop name', 'фффііі', '12345', 'bank', '12341231', '498126405', '3440987632929840', 'forma naloga', 'director', '0444444444', '2017-11-02 14:39:18', '1', '');

-- ----------------------------
-- Table structure for `site_elements`
-- ----------------------------
DROP TABLE IF EXISTS `site_elements`;
CREATE TABLE `site_elements` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `html` varchar(255) DEFAULT NULL,
  `includes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site_elements
-- ----------------------------
INSERT INTO `site_elements` VALUES ('1', '1', '1', '1');

-- ----------------------------
-- Table structure for `site_heatmaps`
-- ----------------------------
DROP TABLE IF EXISTS `site_heatmaps`;
CREATE TABLE `site_heatmaps` (
  `id` int(11) NOT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `site` int(5) DEFAULT NULL,
  `heat` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site_heatmaps
-- ----------------------------
INSERT INTO `site_heatmaps` VALUES ('0', '2017-10-23 17:38:14', '0', '1096:237,1090:243,1081:246,1062:254,1042:263,992:284,981:291,961:305,935:317,910:338,886:353,865:367,840:388,797:417,734:457,642:532,615:555,553:611,480:671,460:687,453:691,441:701,422:713,391:733,374:741,368:742,367:742,367:741,373:735,388:715,454:671,527:643,576:624,618:612,793:591,896:573,1016:556,1136:541,1273:513,1406:486,1525:460,1630:434,1734:413,1824:398,1912:387,1973:376,1993:373,1994:372,1993:372,1986:372,1972:370,1921:366,1882:366,1793:363,1707:356,1587:351,1484:343,1426:341,1311:334,1173:326,1096:322,1015:322,942:322,872:323,814:325,782:325,755:325,727:327,695:338,664:347,640:357,628:361,625:362,625:362,626:362,631:362,643:356,682:338,744:301,846:234,944:148,1054:57,1107:12');

-- ----------------------------
-- Table structure for `site_keywords`
-- ----------------------------
DROP TABLE IF EXISTS `site_keywords`;
CREATE TABLE `site_keywords` (
  `id` int(11) NOT NULL,
  `site` int(3) DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site_keywords
-- ----------------------------

-- ----------------------------
-- Table structure for `site_languages`
-- ----------------------------
DROP TABLE IF EXISTS `site_languages`;
CREATE TABLE `site_languages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lang` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site_languages
-- ----------------------------

-- ----------------------------
-- Table structure for `site_menu`
-- ----------------------------
DROP TABLE IF EXISTS `site_menu`;
CREATE TABLE `site_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `site_menu_styles`
-- ----------------------------
DROP TABLE IF EXISTS `site_menu_styles`;
CREATE TABLE `site_menu_styles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site_menu_styles
-- ----------------------------

-- ----------------------------
-- Table structure for `site_pages`
-- ----------------------------
DROP TABLE IF EXISTS `site_pages`;
CREATE TABLE `site_pages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `site` int(255) DEFAULT NULL,
  `pagenumber` int(5) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `background` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `anchor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `site` (`site`),
  CONSTRAINT `site` FOREIGN KEY (`site`) REFERENCES `site_site` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site_pages
-- ----------------------------
INSERT INTO `site_pages` VALUES ('1', '0', '2', '2', 'red', 'О нас', 'second');
INSERT INTO `site_pages` VALUES ('2', '0', '3', '3', 'green', 'Команда', 'third');
INSERT INTO `site_pages` VALUES ('3', '0', '1', 'text', 'blue', 'Главная', 'main');
INSERT INTO `site_pages` VALUES ('4', '0', '4', '4', 'white', 'Преимущества', 'four');
INSERT INTO `site_pages` VALUES ('5', '0', '5', 'text5', 'black', 'Как с нами работать', 'five');

-- ----------------------------
-- Table structure for `site_site`
-- ----------------------------
DROP TABLE IF EXISTS `site_site`;
CREATE TABLE `site_site` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `company` int(255) DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  `menu` int(1) DEFAULT NULL,
  `menustyle` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `company` (`company`),
  CONSTRAINT `company` FOREIGN KEY (`company`) REFERENCES `companies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site_site
-- ----------------------------
INSERT INTO `site_site` VALUES ('0', 'sakskysite', '1', 'site', '1', 'menu', null);

-- ----------------------------
-- Table structure for `site_styles`
-- ----------------------------
DROP TABLE IF EXISTS `site_styles`;
CREATE TABLE `site_styles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site_styles
-- ----------------------------

-- ----------------------------
-- Table structure for `site_textids`
-- ----------------------------
DROP TABLE IF EXISTS `site_textids`;
CREATE TABLE `site_textids` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `textid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site_textids
-- ----------------------------

-- ----------------------------
-- Table structure for `site_texts`
-- ----------------------------
DROP TABLE IF EXISTS `site_texts`;
CREATE TABLE `site_texts` (
  `id` int(11) NOT NULL,
  `lang_id` int(11) DEFAULT NULL,
  `text_id` int(11) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site_texts
-- ----------------------------

-- ----------------------------
-- Table structure for `subscriber_status`
-- ----------------------------
DROP TABLE IF EXISTS `subscriber_status`;
CREATE TABLE `subscriber_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of subscriber_status
-- ----------------------------
INSERT INTO `subscriber_status` VALUES ('0', 'disabled');
INSERT INTO `subscriber_status` VALUES ('1', 'active');

-- ----------------------------
-- Table structure for `subscriber_tarifs`
-- ----------------------------
DROP TABLE IF EXISTS `subscriber_tarifs`;
CREATE TABLE `subscriber_tarifs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subscriber_id` int(11) DEFAULT NULL,
  `tarif_id` int(11) DEFAULT NULL,
  `device` int(11) DEFAULT NULL,
  `port` int(11) DEFAULT NULL,
  `active` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sub_id` (`subscriber_id`),
  KEY `tarif_id` (`tarif_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subscriber_tarifs
-- ----------------------------
INSERT INTO `subscriber_tarifs` VALUES ('1', '1', '1', '1', '2', '1');
INSERT INTO `subscriber_tarifs` VALUES ('2', '1', '3', '2', '1', '1');
INSERT INTO `subscriber_tarifs` VALUES ('3', '1', '4', '1', '4', '1');
INSERT INTO `subscriber_tarifs` VALUES ('4', '1', '0', '1', '1', '1');

-- ----------------------------
-- Table structure for `subscribers`
-- ----------------------------
DROP TABLE IF EXISTS `subscribers`;
CREATE TABLE `subscribers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `email` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `device` int(11) DEFAULT NULL,
  `port` int(11) DEFAULT NULL,
  `ipaddress` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `macaddress` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `date_registered` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `datepayedto` datetime DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL DEFAULT '0',
  `tarif` int(11) NOT NULL DEFAULT '0',
  `iptype` int(11) NOT NULL DEFAULT '1',
  `address` int(255) DEFAULT NULL,
  `room` int(4) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `balance` double(20,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `device` (`device`),
  KEY `statuss` (`status`),
  KEY `iptype` (`iptype`),
  KEY `adres` (`address`),
  KEY `tarif` (`tarif`),
  CONSTRAINT `adres` FOREIGN KEY (`address`) REFERENCES `addr_adress` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `device` FOREIGN KEY (`device`) REFERENCES `devices` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `iptype` FOREIGN KEY (`iptype`) REFERENCES `ip_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `statuss` FOREIGN KEY (`status`) REFERENCES `subscriber_status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tarif` FOREIGN KEY (`tarif`) REFERENCES `tarifs` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=cp1251;

-- ----------------------------
-- Records of subscribers
-- ----------------------------
INSERT INTO `subscribers` VALUES ('1', 'Andrey Ponomarenko', 'urlapuga@gmail.com', '102', '1', '2', '192.168.1.1', 'aa:bb:cc:dd:ee:ff', '2017-11-14 10:20:57', '2017-10-17 12:14:52', '1', '3', '1', '1', '1', '1CE756F532F42E647BA27D6728B2B50E0079A243', '0');
INSERT INTO `subscribers` VALUES ('2', '1', '1', '1', '1', '1', '1', '1', '2017-11-14 10:20:58', '2017-10-17 12:14:52', '1', '1', '1', '1', '1', null, '0');
INSERT INTO `subscribers` VALUES ('3', '33', '1', '23', null, null, null, null, '2017-11-14 10:20:59', null, '1', '1', '1', '1', '12', null, '0');
INSERT INTO `subscribers` VALUES ('4', '33', null, '23', null, null, null, null, '2017-11-14 10:20:59', null, '1', '0', '1', '1', '12', null, '0');
INSERT INTO `subscribers` VALUES ('5', '33', null, '23', null, null, null, null, '2017-11-14 10:21:00', null, '0', '0', '1', '1', '12', null, '0');
INSERT INTO `subscribers` VALUES ('6', '33', null, '23', null, null, null, null, '2017-11-14 10:21:00', null, '0', '0', '1', '1', '12', null, '0');
INSERT INTO `subscribers` VALUES ('7', 'phone', '1', 'name', null, null, null, null, '2017-11-14 10:21:01', null, '1', '0', '1', '1', '1', null, '0');
INSERT INTO `subscribers` VALUES ('8', '3', null, '2', null, null, null, null, '2017-11-14 10:21:01', null, '1', '0', '1', '1', '1', null, '0');
INSERT INTO `subscribers` VALUES ('9', '1', '1', '1', '1', null, null, null, '2017-11-14 10:21:02', '2017-11-01 14:51:21', '1', '0', '1', '1', '1', null, '0');
INSERT INTO `subscribers` VALUES ('10', '3', null, '2', null, null, null, null, '2017-11-14 10:21:02', null, '1', '1', '1', '1', '1', null, '0');
INSERT INTO `subscribers` VALUES ('11', '3', null, '2', null, null, null, null, '2017-11-14 10:21:03', null, '1', '0', '1', '1', '1', null, '0');
INSERT INTO `subscribers` VALUES ('12', '3', null, '2', null, null, null, null, '2017-11-14 10:21:03', null, '1', '0', '1', '1', '1', null, '0');
INSERT INTO `subscribers` VALUES ('13', '111?', 'mail', '0638339275', '1', null, '123', '1', '2017-11-14 10:21:04', null, '0', '0', '1', '1', '1', null, '0');
INSERT INTO `subscribers` VALUES ('14', '1', null, '1', null, null, null, null, '2017-11-14 10:21:04', null, '1', '0', '1', '1', '1', null, '0');
INSERT INTO `subscribers` VALUES ('15', '1', '2', '3', null, null, null, null, '2017-11-14 10:21:05', '2017-11-03 17:17:13', '0', '0', '1', '1', '1', null, '0');

-- ----------------------------
-- Table structure for `tarifs`
-- ----------------------------
DROP TABLE IF EXISTS `tarifs`;
CREATE TABLE `tarifs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `cost` int(10) DEFAULT NULL,
  `speed` int(11) DEFAULT NULL,
  `companyid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tarifs
-- ----------------------------
INSERT INTO `tarifs` VALUES ('0', 'Нет тарифа', '0', '0', '1');
INSERT INTO `tarifs` VALUES ('1', 'Безліміт 10', '255', '10', '1');
INSERT INTO `tarifs` VALUES ('3', 'Безліміт 20', '325', '20', '1');
INSERT INTO `tarifs` VALUES ('4', 'Безліміт 50', '385', '50', '1');
INSERT INTO `tarifs` VALUES ('5', 'Безліміт 100', '480', '100', '1');

-- ----------------------------
-- Table structure for `task_status`
-- ----------------------------
DROP TABLE IF EXISTS `task_status`;
CREATE TABLE `task_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of task_status
-- ----------------------------
INSERT INTO `task_status` VALUES ('0', 'new');
INSERT INTO `task_status` VALUES ('1', 'in progres');
INSERT INTO `task_status` VALUES ('2', 'done');
INSERT INTO `task_status` VALUES ('3', 'canceled');

-- ----------------------------
-- Table structure for `task_type`
-- ----------------------------
DROP TABLE IF EXISTS `task_type`;
CREATE TABLE `task_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `page` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_type
-- ----------------------------
INSERT INTO `task_type` VALUES ('1', 'подключение', 'connect');
INSERT INTO `task_type` VALUES ('2', 'обслуживание', 'connect');
INSERT INTO `task_type` VALUES ('3', 'разработка', 'connect');
INSERT INTO `task_type` VALUES ('4', 'ремонт', 'connect');
INSERT INTO `task_type` VALUES ('5', 'задача менеджера', 'connect');

-- ----------------------------
-- Table structure for `tasks`
-- ----------------------------
DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(200) DEFAULT NULL,
  `employee` int(11) DEFAULT NULL,
  `employee_task_to` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `type` int(1) DEFAULT NULL,
  `datecreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateto` datetime DEFAULT NULL,
  `dateactionperformed` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `coment` varchar(255) DEFAULT NULL,
  `company` int(255) DEFAULT NULL,
  `subscriber` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl1pbmstu4ffdvpxjowynv7yt9` (`employee`),
  KEY `FKtra97eucsqdnhoagqmp0b732s` (`employee_task_to`),
  KEY `FKlrw802q2gbvoc16pf2gcdb4e0` (`status`),
  CONSTRAINT `employee` FOREIGN KEY (`employee`) REFERENCES `employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `employeetaskto` FOREIGN KEY (`employee_task_to`) REFERENCES `employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tasks
-- ----------------------------
INSERT INTO `tasks` VALUES ('6', 'подключение интернета 318', '3', '3', '2', '1', '2017-09-29 12:54:22', '2017-09-29 12:54:22', '2017-10-25 16:31:53', null, '1', '1');
INSERT INTO `tasks` VALUES ('7', 'настройка роутера , 301', '3', '3', '2', '2', '2017-09-29 12:54:22', '2017-09-29 12:54:22', '2017-10-25 17:40:00', null, '1', '1');
INSERT INTO `tasks` VALUES ('8', 'прозвонить клиента', '6', '7', '0', '5', '2017-10-09 10:58:07', '2017-09-29 12:54:22', '2017-10-25 16:31:54', null, '1', '1');
INSERT INTO `tasks` VALUES ('9', 'подключение интернета 318', '3', '8', '0', '1', '2017-09-29 12:54:22', '2017-09-29 12:54:22', '2017-10-25 16:31:55', '', '1', '1');
INSERT INTO `tasks` VALUES ('10', 'подключение интернета 318', '3', '0', '0', '1', '2017-09-29 12:54:22', '2017-09-29 12:54:22', '2017-10-25 16:31:55', '', '1', '1');
INSERT INTO `tasks` VALUES ('11', 'настройка роутера , 301', '3', '7', '0', '2', '2017-09-29 12:54:22', '2017-09-29 12:54:22', '2017-10-25 16:31:57', '', '1', '1');
INSERT INTO `tasks` VALUES ('12', 'прозвонить клиента', '6', '8', '0', '5', '2017-10-09 10:58:07', '2017-09-29 12:54:22', '2017-10-25 16:31:56', '', '1', '1');
INSERT INTO `tasks` VALUES ('13', 'прозвонить клиента', '6', '9', '0', '5', '2017-10-09 10:58:07', '2017-09-29 12:54:22', '2017-10-25 16:31:56', '', '1', '1');
INSERT INTO `tasks` VALUES ('14', 'подключение интернета 318', '3', '7', '1', '1', '2017-09-29 12:54:22', '2017-09-29 12:54:22', '2017-10-25 16:31:58', '', '1', '1');
INSERT INTO `tasks` VALUES ('15', 'настройка роутера , 301', '3', '7', '1', '2', '2017-09-29 12:54:22', '2017-09-29 12:54:22', '2017-10-25 16:31:59', '', '1', '1');
INSERT INTO `tasks` VALUES ('16', 'прозвонить клиента', '6', '8', '1', '5', '2017-10-09 10:58:07', '2017-09-29 12:54:22', '2017-10-25 16:32:01', '', '1', '1');
INSERT INTO `tasks` VALUES ('17', 'прозвонить клиента', '6', '9', '1', '5', '2017-10-09 10:58:07', '2017-09-29 12:54:22', '2017-10-25 16:31:59', '', '1', '1');
INSERT INTO `tasks` VALUES ('18', 'подключение интернета 318', '3', '7', '1', '1', '2017-09-29 12:54:22', '2017-09-29 12:54:22', '2017-10-25 16:32:00', '', '1', '1');
INSERT INTO `tasks` VALUES ('19', 'настройка роутера , 301', '3', '8', '1', '2', '2017-09-29 12:54:22', '2017-09-29 12:54:22', '2017-10-25 16:32:02', '', '1', '1');
INSERT INTO `tasks` VALUES ('20', 'прозвонить клиента', '6', '9', '1', '5', '2017-10-09 10:58:07', '2017-09-29 12:54:22', '2017-10-25 16:32:03', '', '1', '1');
INSERT INTO `tasks` VALUES ('21', 'прозвонить клиента', '6', '7', '1', '5', '2017-10-09 10:58:07', '2017-09-29 12:54:22', '2017-10-25 16:32:04', '', '1', '1');
INSERT INTO `tasks` VALUES ('23', '1', null, null, '0', '1', '2017-10-25 16:41:12', '2017-04-10 06:19:00', null, null, null, '1');
INSERT INTO `tasks` VALUES ('24', 'ïîìîãèòå', null, null, '0', '2', '2017-11-01 15:57:15', null, null, null, null, null);
INSERT INTO `tasks` VALUES ('25', '123', null, null, '0', '1', '2017-11-01 16:01:16', null, null, null, null, '13');
INSERT INTO `tasks` VALUES ('26', '111', null, null, '0', '1', '2017-11-01 16:08:33', null, null, null, null, '13');
INSERT INTO `tasks` VALUES ('27', '????', null, null, '0', '1', '2017-11-01 17:10:14', null, null, null, null, '13');
INSERT INTO `tasks` VALUES ('28', '123', null, null, '0', '1', '2017-11-06 14:01:56', null, null, null, null, '1');
INSERT INTO `tasks` VALUES ('29', 'Ð°Ð°Ð°', null, null, '0', '1', '2017-11-07 16:37:37', null, null, null, null, '1');
INSERT INTO `tasks` VALUES ('30', 'Ð°Ð°', null, null, '0', '1', '2017-11-07 17:22:33', null, null, null, null, '1');
INSERT INTO `tasks` VALUES ('31', 'Ð°Ð°Ð°', null, null, '0', '1', '2017-11-07 17:22:47', null, null, null, null, '1');
INSERT INTO `tasks` VALUES ('32', 'фвф', null, null, '0', '1', '2017-11-08 10:08:09', null, null, null, null, '1');

-- ----------------------------
-- Table structure for `tasks_copy1`
-- ----------------------------
DROP TABLE IF EXISTS `tasks_copy1`;
CREATE TABLE `tasks_copy1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(200) DEFAULT NULL,
  `employee` int(11) DEFAULT NULL,
  `employee_task_to` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `type` int(1) unsigned zerofill DEFAULT '0',
  `datecreated` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `dateto` datetime DEFAULT NULL,
  `dateactionperformed` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FKl1pbmstu4ffdvpxjowynv7yt9` (`employee`),
  KEY `FKtra97eucsqdnhoagqmp0b732s` (`employee_task_to`),
  KEY `FKlrw802q2gbvoc16pf2gcdb4e0` (`status`),
  CONSTRAINT `tasks_copy1_ibfk_1` FOREIGN KEY (`employee`) REFERENCES `employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tasks_copy1_ibfk_2` FOREIGN KEY (`employee_task_to`) REFERENCES `employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tasks_copy1
-- ----------------------------
INSERT INTO `tasks_copy1` VALUES ('6', 'подключение интернета 318', null, null, '0', '1', '2017-09-29 12:54:22', null, null);
INSERT INTO `tasks_copy1` VALUES ('7', 'настройка роутера , 301', null, null, '0', '2', '2017-09-29 12:54:22', null, null);
INSERT INTO `tasks_copy1` VALUES ('23', '111', null, null, '0', null, '2017-09-29 12:54:22', null, null);
INSERT INTO `tasks_copy1` VALUES ('24', '12341', null, null, '0', null, '2017-09-29 12:54:22', null, '2017-09-29 12:55:40');

-- ----------------------------
-- Table structure for `user_profile`
-- ----------------------------
DROP TABLE IF EXISTS `user_profile`;
CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_profile
-- ----------------------------
INSERT INTO `user_profile` VALUES ('2', 'ADMIN');
INSERT INTO `user_profile` VALUES ('3', 'DBA');
INSERT INTO `user_profile` VALUES ('1', 'USER');

-- ----------------------------
-- View structure for `allmanagerwork`
-- ----------------------------
DROP VIEW IF EXISTS `allmanagerwork`;
CREATE ALGORITHM=UNDEFINED DEFINER=`user`@`%` SQL SECURITY DEFINER VIEW `allmanagerwork` AS select cast(`tasks`.`dateto` as date) AS `date`,count(0) AS `made`,`employees`.`lastname` AS `lastname`,`tasks`.`id` AS `id` from (`tasks` left join `employees` on((`tasks`.`employee_task_to` = `employees`.`id`))) where (`tasks`.`status` = 2) group by `tasks`.`employee_task_to`,cast(`tasks`.`dateto` as date);

-- ----------------------------
-- View structure for `connectionsperdate`
-- ----------------------------
DROP VIEW IF EXISTS `connectionsperdate`;
CREATE ALGORITHM=UNDEFINED DEFINER=`user`@`%` SQL SECURITY DEFINER VIEW `connectionsperdate` AS select `tasks`.`id` AS `id`,cast(`tasks`.`dateactionperformed` as date) AS `date`,count(0) AS `amount` from (`tasks` join `task_type`) where ((`tasks`.`type` = 1) and (`tasks`.`status` = 2)) group by cast(`tasks`.`dateactionperformed` as date);

-- ----------------------------
-- View structure for `idbalancecost`
-- ----------------------------
DROP VIEW IF EXISTS `idbalancecost`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `idbalancecost` AS select `subscribers`.`id` AS `id`,`subscribers`.`balance` AS `balance`,sum(`tarifs`.`cost`) AS `cost` from ((`subscribers` left join `subscriber_tarifs` on((`subscriber_tarifs`.`subscriber_id` = `subscribers`.`id`))) left join `tarifs` on((`tarifs`.`id` = `subscriber_tarifs`.`tarif_id`))) where ((`subscriber_tarifs`.`active` = '1') and (`subscribers`.`status` = '1')) group by `subscribers`.`id`,`subscribers`.`balance`;

-- ----------------------------
-- View structure for `subscribertarifsview`
-- ----------------------------
DROP VIEW IF EXISTS `subscribertarifsview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `subscribertarifsview` AS select `subscribers`.`id` AS `id`,`tarifs`.`name` AS `name`,`tarifs`.`speed` AS `speed`,`tarifs`.`cost` AS `cost`,`subscriber_tarifs`.`device` AS `device`,`subscriber_tarifs`.`port` AS `port`,`subscriber_tarifs`.`active` AS `active`,`subscriber_tarifs`.`id` AS `subscribertarifid`,`tarifs`.`id` AS `tarifid` from ((`subscribers` join `subscriber_tarifs` on((`subscriber_tarifs`.`subscriber_id` = `subscribers`.`id`))) join `tarifs` on((`tarifs`.`id` = `subscriber_tarifs`.`tarif_id`)));

-- ----------------------------
-- View structure for `subscriberview`
-- ----------------------------
DROP VIEW IF EXISTS `subscriberview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `subscriberview` AS select `subscribers`.`id` AS `id`,`subscribers`.`name` AS `name`,`subscribers`.`phone` AS `phone`,`subscribers`.`ipaddress` AS `ipaddress`,`addr_cities`.`name` AS `cityname`,`addr_streets`.`name` AS `streetname`,`addr_buildings`.`number` AS `number`,`addr_adress`.`room` AS `room`,`tarifs`.`name` AS `tarif`,`subscriber_status`.`name` AS `statusname`,`addr_cities`.`id` AS `city`,`addr_streets`.`id` AS `street`,`addr_buildings`.`id` AS `building` from ((((((`subscribers` join `addr_adress` on((`subscribers`.`address` = `addr_adress`.`id`))) join `addr_buildings` on((`addr_adress`.`building` = `addr_buildings`.`id`))) join `addr_streets` on((`addr_buildings`.`street` = `addr_streets`.`id`))) join `addr_cities` on((`addr_streets`.`city` = `addr_cities`.`id`))) join `tarifs` on((`subscribers`.`tarif` = `tarifs`.`id`))) join `subscriber_status` on((`subscribers`.`status` = `subscriber_status`.`id`)));

-- ----------------------------
-- Function structure for `zero`
-- ----------------------------
DROP FUNCTION IF EXISTS `zero`;
DELIMITER ;;
CREATE DEFINER=`user`@`%` FUNCTION `zero`() RETURNS tinyint(1)
BEGIN
	#Routine body goes here...

	RETURN 0;
END
;;
DELIMITER ;

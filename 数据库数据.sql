/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - xianguoegou
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xianguoegou` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `xianguoegou`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `county` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_address` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=40051 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `address` */

insert  into `address`(`id`,`province`,`city`,`county`,`content`,`uid`) values (40001,'安徽','合肥','蜀山区','锋尚名居',10001),(40002,'安徽','合肥','蜀山区','新都庄园',10002),(40003,'江苏','南京','浦口区','漓江山水花园',10003),(40004,'安徽','合肥','蜀山区','爱建园文化佳园',10004),(40005,'江苏','南京','浦口区','东方城市花园',10005),(40006,'安徽','合肥','蜀山区','奥林匹克花园',10006),(40007,'安徽','合肥','蜀山区','祥和名邸小区',10007),(40008,'安徽','合肥','蜀山区','仁恒河滨花园',10008),(40009,'江苏','南京','浦口区','怡东花园',10009),(40010,'安徽','合肥','蜀山区','古北河滨城',10010),(40011,'安徽','合肥','蜀山区','新天地河滨花园',10011),(40012,'安徽','合肥','蜀山区','仁恒河滨花园',10012),(40013,'江苏','南京','浦口区','回龙湾小区',10013),(40014,'江苏','南京','浦口区','西区天山',10014),(40015,'安徽','合肥','蜀山区','水榭花都',10015),(40016,'安徽','合肥','蜀山区','世纪城众',10016),(40017,'江苏','南京','浦口区','美凤凰城',10017),(40018,'安徽','合肥','蜀山区','龙电花园',10018),(40019,'安徽','合肥','蜀山区','万科花园',10019),(40020,'安徽','合肥','蜀山区','新城锦华北园',10020),(40021,'安徽','合肥','蜀山区','锋尚名居',10021),(40022,'安徽','合肥','蜀山区','新都庄园',10022),(40023,'江苏','南京','浦口区','漓江山水花园',10023),(40024,'安徽','合肥','蜀山区','爱建园文化佳园',10024),(40025,'江苏','南京','浦口区','东方城市花园',10025),(40026,'安徽','合肥','蜀山区','奥林匹克花园',10026),(40027,'安徽','合肥','蜀山区','祥和名邸小区',10027),(40028,'安徽','合肥','蜀山区','仁恒河滨花园',10028),(40029,'江苏','南京','浦口区','怡东花园',10029),(40030,'安徽','合肥','蜀山区','古北河滨城',10030),(40031,'安徽','合肥','蜀山区','新天地河滨花园',10031),(40032,'安徽','合肥','蜀山区','仁恒河滨花园',10032),(40033,'江苏','南京','浦口区','回龙湾小区',10033),(40034,'江苏','南京','浦口区','西区天山',10034),(40035,'安徽','合肥','蜀山区','水榭花都',10035),(40036,'安徽','合肥','蜀山区','世纪城众',10036),(40037,'江苏','南京','浦口区','美凤凰城',10037),(40038,'安徽','合肥','蜀山区','龙电花园',10038),(40039,'安徽','合肥','蜀山区','万科花园',10039),(40040,'安徽','合肥','蜀山区','新城锦华北园',10040),(40041,'安徽','合肥','蜀山区','锋尚名居',10041),(40042,'安徽','合肥','蜀山区','新都庄园',10042),(40043,'江苏','南京','浦口区','漓江山水花园',10043),(40044,'安徽','合肥','蜀山区','爱建园文化佳园',10044),(40045,'江苏','南京','浦口区','东方城市花园',10045),(40046,'安徽','合肥','蜀山区','奥林匹克花园',10046),(40047,'安徽','合肥','蜀山区','祥和名邸小区',10047),(40048,'安徽','合肥','蜀山区','仁恒河滨花园',10048),(40049,'江苏','南京','浦口区','怡东花园',10049),(40050,'安徽','合肥','蜀山区','古北河滨城',10050);

/*Table structure for table `advertising` */

DROP TABLE IF EXISTS `advertising`;

CREATE TABLE `advertising` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `pic` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `creattime` datetime DEFAULT NULL,
  `ismarket` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_advertising` (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `advertising` */

insert  into `advertising`(`id`,`adname`,`content`,`gid`,`pic`,`creattime`,`ismarket`) values (1,'葡萄','真正的土味葡萄,给你最多的营养,最大的满足',1,'1.jpg','2012-04-03 23:30:11',0),(2,'青提','真正的土味青提,给你最多的营养,最大的满足',5,'2.jpg','2017-06-07 18:05:29',0),(3,'香瓜','瓜熟蒂落,香飘万里',8,'3.jpg','2013-02-23 12:10:09',0),(4,'木瓜','一品木瓜,难忘金沙',10,'4.jpg','2014-01-10 15:04:15',0),(5,'柚子','客天下金柚,有你有他柚客家',15,'5.jpg','2019-07-29 13:15:23',0),(6,'梅子','健康、快捷、绿色、休闲',18,'6.jpg','2011-07-19 08:13:58',1),(7,'橄榄','胖胖的,就是惹人喜欢! 它,跟我一样甜,你喜欢吗?',20,'7.jpg','2012-01-11 10:49:06',0),(8,'苹果','新鲜得令你馋涎欲滴。',21,'8.jpg','2016-06-22 00:51:34',0),(9,'梨','新鲜得令你馋涎欲滴。',22,'9.jpg','2015-10-20 12:01:18',0),(10,'海棠果','新鲜得令你馋涎欲滴。',23,'10.jpg','2010-09-04 13:05:59',0);

/*Table structure for table `good` */

DROP TABLE IF EXISTS `good`;

CREATE TABLE `good` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gtid` int(11) DEFAULT NULL,
  `gname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `nownumber` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `lasttime` date DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `pic` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `ismarket` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_good` (`gtid`),
  KEY `FK_good1` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `good` */

insert  into `good`(`id`,`gtid`,`gname`,`content`,`nownumber`,`number`,`lasttime`,`sid`,`price`,`pic`,`ismarket`) values (1,1,'葡萄','非常新鲜',278,300,'2014-02-11',20001,10.15,'1.jpg',0),(2,1,'草莓','刚采摘的，不新鲜可换',123,200,'2011-06-16',20002,13.52,'2.jpg',0),(3,1,'黑莓','刚采摘的，不新鲜可换',1212,2000,'2018-10-01',20003,14.18,'3.jpg',0),(4,1,'桑葚','刚采摘的，不新鲜可换',200,220,'2012-05-28',20004,6.01,'4.jpg',0),(5,1,'青提','当天采摘当天发货',513,700,'2012-03-24',20005,13.59,'5.jpg',0),(6,2,'西瓜','8424西瓜，非常甜',13,250,'2012-07-15',20006,9.69,'6.jpg',1),(7,2,'甜瓜','薄皮脆嫩果肉蜜',123,300,'2012-10-23',20007,12.11,'7.jpg',0),(8,2,'香瓜','瓜园基地传统种植，不打农药不催熟无激素',1535,2000,'2019-02-03',20008,10.15,'8.jpg',0),(9,2,'哈密瓜','新鲜采摘，当季直供',15,80,'2013-01-14',20009,13.52,'9.jpg',0),(10,2,'木瓜','肉质软嫩甜如冰糖',48,180,'2017-04-09',20010,14.18,'10.jpg',0),(11,3,'蜜橘','清爽宜人/饱满多汁/鲜嫩爽口',513,600,'2015-03-21',20011,6.01,'11.jpg',1),(12,3,'砂糖桔','自然成熟新鲜发货香甜多计',18,150,'2010-10-09',20012,13.59,'12.jpg',1),(13,3,'金橘','自然生长 新鲜采摘 酸爽可口',15,700,'2013-09-13',20013,9.69,'13.jpg',1),(14,3,'葡萄','酸甜多汁新鲜无籽现摘现发',35,600,'2012-05-02',20014,12.11,'14.jpg',0),(15,3,'柚子','泰国蜜柚给你舌尖甜蜜的好滋味',531,600,'2017-10-15',20015,10.98,'15.jpg',0),(16,4,'桃','果香浓郁、肉厚多汁',84,600,'2014-01-26',20016,9.69,'16.jpg',0),(17,4,'杏子','水润嫩滑之后留下的馥郁芳香小小个头竟有如此尝过不忘的魅力',486,700,'2016-11-27',20017,9.69,'17.jpg',0),(18,4,'梅子','当天采摘当天发货',48,500,'2012-01-17',20018,9.69,'18.jpg',0),(19,4,'大枣','当天采摘当天发货',84,400,'2016-02-16',20019,12.11,'19.jpg',1),(20,4,'橄榄','当天采摘当天发货',684,1000,'2013-09-12',20020,10.98,'20.jpg',1),(21,5,'苹果','当天采摘当天发货',48,180,'2015-10-16',20020,9.69,'21.jpg',1),(22,5,'梨','自然生长 新鲜采摘',86,100,'2017-09-26',20020,12.11,'22.jpg',1),(23,5,'海棠果','自然生长 新鲜采摘',84,100,'2018-04-07',20020,10.98,'23.jpg',0),(24,5,'柿子','自然生长 新鲜采摘',64,100,'2019-01-21',20020,10.98,'24.jpg',0),(25,5,'杨桃','自然生长 新鲜采摘',15,100,'2018-08-22',20020,13.88,'25.jpg',0);

/*Table structure for table `goodtype` */

DROP TABLE IF EXISTS `goodtype`;

CREATE TABLE `goodtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gtname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `goodtype` */

insert  into `goodtype`(`id`,`gtname`) values (1,'浆果类'),(2,'瓜果类'),(3,'橘果类'),(4,'核果类'),(5,'仁果类');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `creattime` date DEFAULT NULL,
  `orderid` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=30021 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `order` */

insert  into `order`(`id`,`aid`,`creattime`,`orderid`) values (30001,40001,'2018-06-15','3000120180615'),(30002,40002,'2016-08-27','3000220160827'),(30003,40003,'2018-09-10','3000320180910'),(30004,40004,'2012-07-16','3000420120716'),(30005,40005,'2017-07-28','3000520170728'),(30006,40006,'2014-04-05','3000620140405'),(30007,40007,'2015-01-07','3000720150107'),(30008,40008,'2019-05-26','3000820190526'),(30009,40009,'2019-04-23','3000920190423'),(30010,40010,'2016-08-26','3001020160826'),(30011,40011,'2011-09-04','3001120110904'),(30012,40012,'2014-08-02','3001220140802'),(30013,40013,'2015-04-06','3001320150406'),(30014,40014,'2015-09-14','3001420150914'),(30015,40015,'2012-02-10','3001520120210'),(30016,40016,'2016-05-01','3001620160501'),(30017,40017,'2014-11-17','3001720141117'),(30018,40018,'2016-06-23','3001820160623'),(30019,40019,'2015-01-01','3001920150101'),(30020,40020,'2011-01-08','3002020110108');

/*Table structure for table `ordermore` */

DROP TABLE IF EXISTS `ordermore`;

CREATE TABLE `ordermore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `omnumber` int(11) DEFAULT NULL,
  `oid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ordermore` (`gid`),
  KEY `FK_ordermore1` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ordermore` */

insert  into `ordermore`(`id`,`gid`,`omnumber`,`oid`) values (1,12,2,30002),(2,14,6,30003),(3,23,8,30004),(4,6,10,30005),(5,21,4,30006),(6,17,2,30007),(7,17,10,30010),(8,15,4,30011),(9,14,9,30012),(10,20,6,30013),(11,11,3,30014),(12,18,8,30015),(13,12,3,30014),(14,22,9,30015),(15,6,7,30016),(16,9,8,30017),(17,16,2,30018),(18,9,9,30019),(19,6,7,30020),(20,3,10,30001),(21,24,2,30002),(22,5,2,30003),(23,22,6,30004),(24,24,8,30005),(25,13,2,30006),(26,18,5,30007),(27,1,2,30008),(28,18,2,30005),(29,16,9,30006),(30,3,2,30007),(31,24,5,30008),(32,19,4,30009),(33,5,7,30010),(34,26,6,30011),(35,22,2,30012),(36,3,8,30013),(37,2,9,30014),(38,7,5,30001),(39,4,5,30002),(40,22,2,30003),(41,25,10,30004),(42,25,3,30005),(43,14,4,30006),(44,13,9,30015),(45,13,8,30016),(46,22,2,30017),(47,19,1,30018),(48,7,3,30019),(49,10,2,30020),(50,18,1,30005);

/*Table structure for table `password` */

DROP TABLE IF EXISTS `password`;

CREATE TABLE `password` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `pwd` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `password` */

insert  into `password`(`id`,`uid`,`pwd`) values (1,10001,'123456'),(2,10002,'123456'),(3,10003,'123456'),(4,10004,'123456'),(5,10005,'123456'),(6,10006,'123456'),(7,10007,'123456'),(8,10008,'123456'),(9,10009,'123456'),(10,10010,'123456'),(11,10011,'123456'),(12,10012,'123456'),(13,10013,'123456'),(14,10014,'123456'),(15,10015,'123456'),(16,10016,'123456'),(17,10017,'123456'),(18,10018,'123456'),(19,10019,'123456'),(20,10020,'123456'),(21,10021,'123456'),(22,10022,'123456'),(23,10023,'123456'),(24,10024,'123456'),(25,10025,'123456'),(26,10026,'123456'),(27,10027,'123456'),(28,10028,'123456'),(29,10029,'123456'),(30,10030,'123456'),(31,10031,'123456'),(32,10032,'123456'),(33,10033,'123456'),(34,10034,'123456'),(35,10035,'123456'),(36,10036,'123456'),(37,10037,'123456'),(38,10038,'123456'),(39,10039,'123456'),(40,10040,'123456'),(41,10041,'123456'),(42,10042,'123456'),(43,10043,'123456'),(44,10044,'123456'),(45,10045,'123456'),(46,10046,'123456'),(47,10047,'123456'),(48,10048,'123456'),(49,10049,'123456'),(50,10050,'123456');

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `province` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `county` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `contentaddress` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `level` int(1) DEFAULT NULL,
  `pic` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `uzcbirthday` date DEFAULT NULL,
  `ischeck` int(1) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_supplier` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=20066 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `supplier` */

insert  into `supplier`(`id`,`sname`,`content`,`uid`,`province`,`city`,`county`,`contentaddress`,`level`,`pic`,`uzcbirthday`,`ischeck`,`isdelete`) values (20001,'日日鲜','最灵繁的人也看不见自己的背脊。——非洲',10008,'安徽','合肥','蜀山区','锋尚名居',0,NULL,'2014-04-17',0,0),(20002,'心随果动','最困难的事情就是认识自己。——希腊',10009,'安徽','合肥','蜀山区','新都庄园',3,NULL,'2017-09-10',1,0),(20003,'坤发水果店','有勇气承担命运这才是英雄好汉。——黑塞',10010,'江苏','南京','浦口区','漓江山水花园',2,NULL,'2013-06-04',1,1),(20004,'汇鲜果蔬','与肝胆人共事，无字句处读书。——周恩来',10011,'安徽','合肥','蜀山区','爱建园文化佳园',5,NULL,'2019-09-25',1,0),(20005,'乐客水果超市','阅读使人充实，会谈使人敏捷，写作使人精确。——培根',10012,'江苏','南京','浦口区','东方城市花园',0,NULL,'2016-11-04',1,1),(20006,'田园蔬果网','最大的骄傲于最大的自卑都表示心灵的最软弱无力。——斯宾诺莎',10047,'安徽','合肥','蜀山区','奥林匹克花园',5,NULL,'2019-08-15',1,0),(20007,'爱尚水果超市','自知之明是最难得的知识。——西班牙',10048,'安徽','合肥','蜀山区','祥和名邸小区',0,NULL,'2016-04-04',0,1),(20008,'水果汇','勇气通往天堂，怯懦通往地狱。——塞内加',10015,'安徽','合肥','蜀山区','仁恒河滨花园',2,NULL,'2012-04-02',1,1),(20009,'盛鑫水果店','有时候读书是一种巧妙地避开思考的方法。——赫尔普斯',10016,'江苏','南京','浦口区','怡东花园',3,NULL,'2019-05-12',1,1),(20010,'天使之吻水果店','阅读一切好书如同和过去最杰出的人谈话。——笛卡儿',10017,'安徽','合肥','蜀山区','古北河滨城',0,NULL,'2014-07-11',0,1),(20011,'恒康水果店','越是没有本领的就越加自命不凡。——邓拓',10023,'安徽','合肥','蜀山区','新天地河滨花园',4,NULL,'2014-08-13',1,1),(20012,'新香园水果店','越是无能的人，越喜欢挑剔别人的错儿。——爱尔兰',10024,'安徽','合肥','蜀山区','仁恒河滨花园',3,NULL,'2016-07-14',1,1),(20013,'溢香园','知人者智，自知者明。胜人者有力，自胜者强。——老子',10025,'江苏','南京','浦口区','回龙湾小区',1,NULL,'2016-10-09',1,0),(20014,'飘香蔬果店','意志坚强的人能把世界放在手中像泥块一样任意揉捏。——歌德',10026,'江苏','南京','浦口区','西区天山',0,NULL,'2011-07-15',0,1),(20015,'绿惠水果店','最具挑战性的挑战莫过于提升自我。——迈克尔·F·斯特利',10031,'安徽','合肥','蜀山区','水榭花都',1,NULL,'2011-11-21',1,0),(20016,'果果集中营','业余生活要有意义，不要越轨。——华盛顿',10032,'安徽','合肥','蜀山区','世纪城众',1,NULL,'2016-09-22',1,0),(20017,'思念果品行','一个人即使已登上顶峰，也仍要自强不息。——罗素·贝克',10033,'江苏','南京','浦口区','美凤凰城',0,NULL,'2019-09-28',1,1),(20018,'飞果行天下','最大的挑战和突破在于用人，而用人最大的突破在于信任人。——马云',10036,'安徽','合肥','蜀山区','龙电花园',3,NULL,'2016-05-25',1,0),(20019,'天府农庄','自己活着，就是为了使别人过得更美好。——雷锋',10037,'安徽','合肥','蜀山区','万科花园',0,NULL,'2011-08-26',0,0),(20020,'亿万蔬果超市','要掌握书，莫被书掌握；要为生而读，莫为读而生。——布尔沃',10038,'安徽','合肥','蜀山区','新城锦华北园',5,NULL,'2014-06-11',1,0),(20021,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20022,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20023,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20024,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20025,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20026,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20027,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20028,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20029,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20030,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20031,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20032,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20033,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20034,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20035,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20036,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20037,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20038,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20039,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20040,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20041,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20042,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20043,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20044,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20045,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `level` int(1) DEFAULT NULL,
  `role` int(1) DEFAULT NULL,
  `uzcbirthday` date DEFAULT NULL,
  `pic` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10051 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`uname`,`sex`,`birthday`,`age`,`phone`,`email`,`level`,`role`,`uzcbirthday`,`pic`,`isdelete`) values (10001,'王峻熙',1,'1974-05-03',46,'13906665572','44130535@qq.com',2,2,'2014-11-17','10001.png',1),(10002,'张嘉懿',1,'1972-03-13',48,'13956250370','13822334@qq.com',1,1,'2014-06-10','10002.png',1),(10003,'李煜城',1,'1987-08-21',33,'13971665557','20767574@qq.com',6,6,'2010-08-24','10003.png',1),(10004,'赵懿轩',0,'1984-05-25',36,'13941384060','50343488@qq.com',6,6,'2019-03-18','10004.png',1),(10005,'王烨华',1,'1988-09-25',32,'13923517076','64825823@qq.com',4,4,'2014-04-17','10005.png',0),(10006,'杨煜祺',1,'1993-05-18',27,'13964558256','52412742@qq.com',6,6,'2017-09-10','10006.png',0),(10007,'阎智宸',0,'1996-02-03',24,'13924412783','06220066@qq.com',1,1,'2013-06-04','10007.png',1),(10008,'孙正豪',0,'1995-11-06',25,'13916684217','36831131@qq.com',3,3,'2019-09-25','10008.png',1),(10009,'吴昊然',1,'1994-03-21',26,'13951388154','63028100@qq.com',0,0,'2016-11-04','10009.png',0),(10010,'郭志泽',1,'1980-03-04',40,'13906852248','04432232@qq.com',0,0,'2019-08-15','10010.png',0),(10011,'李明度',1,'1988-08-24',32,'13921426602','15603451@qq.com',3,3,'2016-04-04','10011.png',0),(10012,'杨弘',1,'1988-05-18',32,'13923044733','35082420@qq.com',4,4,'2012-04-02','10012.png',0),(10013,'靳烨伟',0,'1976-09-04',44,'13940513120','65667651@qq.com',5,5,'2019-05-12','10013.png',0),(10014,'马苑',0,'1992-07-14',28,'13968657434','62514326@qq.com',3,3,'2014-07-11','10014.png',1),(10015,'张鹏涛',0,'1981-07-23',39,'13947716610','54488704@qq.com',2,2,'2014-08-13','10015.png',0),(10016,'叶红艳',1,'1985-05-07',35,'13931481362','74002861@qq.com',6,6,'2016-07-14','10016.png',1),(10017,'张天',0,'1989-07-25',31,'13913312251','65528153@qq.com',1,1,'2016-10-09','10017.png',1),(10018,'孙志梅',1,'1984-07-05',36,'13905263680','35450502@qq.com',1,1,'2011-07-15','10018.png',0),(10019,'刘雪恩',0,'1993-01-22',27,'13978726112','65852104@qq.com',3,3,'2011-11-21','10019.png',1),(10020,'孙荣',1,'1996-01-18',24,'13902242886','38874034@qq.com',3,3,'2016-09-22','10020.png',0),(10021,'严正明',1,'1971-08-22',49,'13981317312','03645220@qq.com',6,6,'2019-09-28','10021.png',0),(10022,'樊梨花',0,'1989-04-21',31,'13905320387','06246642@qq.com',6,6,'2016-05-25','10022.png',1),(10023,'范海霞知',0,'1994-09-29',26,'13984848738','04547208@qq.com',1,1,'2011-08-26','10023.png',1),(10024,'卢玉霞',0,'1997-02-27',23,'13903326403','08718177@qq.com',3,3,'2014-06-11','10024.png',0),(10025,'张素珍',1,'1977-05-11',43,'13931046228','04533002@qq.com',5,5,'2020-08-02','10025.png',0),(10026,'刘晓芒',0,'1988-07-08',32,'13908622240','08622442@qq.com',6,6,'2011-02-11','10026.png',1),(10027,'杨素',1,'1987-03-13',33,'13960870326','88508006@qq.com',2,2,'2018-08-27','10027.png',1),(10028,'潘晓娟',1,'1992-09-06',28,'13982507840','22216880@qq.com',5,5,'2016-11-14','10028.png',0),(10029,'车路',1,'1979-09-22',41,'13940510537','88703150@qq.com',5,5,'2010-11-19','10029.png',1),(10030,'何云霞',1,'1980-09-21',40,'13948607614','60578547@qq.com',3,3,'2012-06-25','10030.png',0),(10031,'郭川川',0,'1988-09-08',32,'13924208355','72788236@qq.com',4,4,'2012-01-14','10031.png',1),(10032,'吴莎莎',0,'1996-02-11',24,'13986451403','55171881@qq.com',6,6,'2012-04-13','10032.png',0),(10033,'严夏红',0,'1976-06-08',44,'13905434381','10238553@qq.com',6,6,'2020-02-04','10033.png',0),(10034,'春专芝',0,'1977-01-16',43,'13907368766','37740035@qq.com',0,0,'2019-08-24','10034.png',1),(10035,'王晓正',1,'1974-09-09',46,'13982646880','38827185@qq.com',0,0,'2019-06-08','10035.png',0),(10036,'徐小明',0,'1986-09-15',34,'13976105747','24413678@qq.com',6,6,'2017-06-29','10036.png',1),(10037,'王仕兰',1,'1990-01-02',30,'13902531067','76323220@qq.com',6,6,'2014-10-24','10037.png',1),(10038,'张伶边',1,'1983-10-12',37,'13925406027','21422884@qq.com',6,6,'2018-03-21','10038.png',0),(10039,'董飘萨',0,'1984-01-27',36,'13967315077','11752574@qq.com',2,2,'2014-04-10','10039.png',0),(10040,'曹兰芳',0,'1993-07-18',27,'13974731431','33031772@qq.com',1,1,'2010-01-11','10040.png',0),(10041,'吴春芳',0,'1991-06-14',29,'13952718762','67454247@qq.com',4,4,'2018-04-23','10041.png',0),(10042,'王媛媛',1,'1980-06-20',40,'13908542141','23411182@qq.com',0,0,'2018-06-29','10042.png',0),(10043,'张秀艳',1,'1978-05-04',42,'13967412332','57115705@qq.com',5,5,'2017-09-09','10043.png',0),(10044,'吴少耀',0,'1978-08-06',42,'13900448580','61818611@qq.com',5,5,'2020-11-13','10044.png',0),(10045,'董亚娟',1,'1975-06-25',45,'13900648236','68262447@qq.com',5,5,'2013-11-26','10045.png',0),(10046,'杨翠霞',0,'1991-02-22',29,'13985788281','32201168@qq.com',2,2,'2019-04-11','10046.png',0),(10047,'薛爱珍',0,'1988-02-21',32,'13940217216','34875455@qq.com',3,3,'2020-01-21','10047.png',0),(10048,'董晓',0,'1983-10-24',37,'13955534822','12107741@qq.com',1,1,'2014-07-17','10048.png',1),(10049,'张骁',1,'1976-07-06',44,'13985142128','46867677@qq.com',3,3,'2012-11-10','10049.png',0),(10050,'邓力夫',1,'1985-04-20',35,'13903245368','18383747@qq.com',0,0,'2011-07-15','10050.png',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

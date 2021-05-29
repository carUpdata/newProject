/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : localhost:3306
 Source Schema         : new_info

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 29/05/2021 13:57:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for back_login
-- ----------------------------
DROP TABLE IF EXISTS `back_login`;
CREATE TABLE `back_login`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of back_login
-- ----------------------------
INSERT INTO `back_login` VALUES (1, 'admin', '123');
INSERT INTO `back_login` VALUES (2, 'xiaoming', '456');

-- ----------------------------
-- Table structure for car_info
-- ----------------------------
DROP TABLE IF EXISTS `car_info`;
CREATE TABLE `car_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `car_mile` int(11) DEFAULT NULL,
  `car_src` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of car_info
-- ----------------------------
INSERT INTO `car_info` VALUES (1, '奔驰', 1000, '10升', 1, 999);
INSERT INTO `car_info` VALUES (2, '奥迪', 500, '15升', 1, 888);
INSERT INTO `car_info` VALUES (3, '保时捷', 2000, '20升', 0, 666);
INSERT INTO `car_info` VALUES (4, '坦克', 1000, '30升', 0, 777);
INSERT INTO `car_info` VALUES (7, '捷豹', 100, '56升', 2, 798);
INSERT INTO `car_info` VALUES (8, '奔驰', 899, '10升', 3, 336);
INSERT INTO `car_info` VALUES (9, '大牛', 999, '60升', 3, 111);
INSERT INTO `car_info` VALUES (10, '花车', 1000, '50升', 4, 789);
INSERT INTO `car_info` VALUES (11, '滑板车', 1000, '50升', 6, 555);
INSERT INTO `car_info` VALUES (12, '飞车', 500, '500升', 5, 908);
INSERT INTO `car_info` VALUES (13, '滑板车', 5600, '4升', 6, 774);
INSERT INTO `car_info` VALUES (14, '自行车', 952, '60升', 3, 200);
INSERT INTO `car_info` VALUES (15, '小气车', 969, '10升', 4, 226);
INSERT INTO `car_info` VALUES (16, '飞行车', 360, '30升', 6, 651);

-- ----------------------------
-- Table structure for upkeep
-- ----------------------------
DROP TABLE IF EXISTS `upkeep`;
CREATE TABLE `upkeep`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_id` int(11) DEFAULT NULL,
  `upkeep_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `upkeep_distance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `upkeep_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `upkeep_cost` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `upkeep_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `user_idnumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of upkeep
-- ----------------------------
INSERT INTO `upkeep` VALUES (1, 999, '2021-01-02', '111', '111', '111', '111', '1111');
INSERT INTO `upkeep` VALUES (2, 888, '2021-01-02', '11', '111', '111', '111', '1111');
INSERT INTO `upkeep` VALUES (3, 666, '2021-01-02', '11', '111', '111', '111', '1112');
INSERT INTO `upkeep` VALUES (4, 777, '2021-01-02', '11', '111', '111', '111', '1112');
INSERT INTO `upkeep` VALUES (5, 798, '2021-01-02', '11', '111', '111', '111', '1112');
INSERT INTO `upkeep` VALUES (6, 336, '2021-01-02', '11', '111', '111', '111', '1113');
INSERT INTO `upkeep` VALUES (8, 111, '2021-01-02', '11', '111', '111', '111', '1114');
INSERT INTO `upkeep` VALUES (9, 789, '2021-01-02', '11', '111', '111', '111', '1112');
INSERT INTO `upkeep` VALUES (10, 555, '2021-01-02', '11', '111', '111', '111', '1113');
INSERT INTO `upkeep` VALUES (11, 908, '2021-01-02', '11', '111', '111', '111', '1114');
INSERT INTO `upkeep` VALUES (12, 651, '2021-01-02', '11', '111', '111', '111', '1114');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_idnumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, '1111', '小白', '0', '002');
INSERT INTO `user` VALUES (3, '1112', '小李', '1', '003');
INSERT INTO `user` VALUES (4, '1113', '小黑', '3', '004');

SET FOREIGN_KEY_CHECKS = 1;

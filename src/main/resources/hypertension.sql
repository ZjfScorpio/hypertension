/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : hypertension

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 27/05/2020 10:35:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `age` int(11) NOT NULL,
  `times` double NOT NULL,
  `rate` double NOT NULL,
  `date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `parents` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `grandparents` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `brothers` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 106 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (91, 'man', 12, 1, 0.147, '2020-05-25 12:50:28', 'none', 'none', 'none');
INSERT INTO `person` VALUES (92, 'man', 45, 1.98, 0.291, '2020-05-25 12:51:03', 'mother', 'many', 'many');
INSERT INTO `person` VALUES (93, 'woman', 20, 1.39, 0.204, '2020-05-25 12:51:34', 'father', 'one', 'many');
INSERT INTO `person` VALUES (94, 'man', 12, 1, 0.147, '2020-05-25 13:22:48', 'none', 'none', 'none');
INSERT INTO `person` VALUES (95, 'man', 12, 1.98, 0.291, '2020-05-25 13:45:31', 'mother', 'one', 'many');
INSERT INTO `person` VALUES (96, 'man', 45, 1, 0.147, '2020-05-25 13:51:49', 'none', 'none', 'none');
INSERT INTO `person` VALUES (97, 'woman', 12, 1.98, 0.291, '2020-05-25 16:52:53', 'mother', 'one', 'many');
INSERT INTO `person` VALUES (98, 'woman', 12, 1.98, 0.291, '2020-05-25 16:55:40', 'mother', 'many', 'one');
INSERT INTO `person` VALUES (99, 'man', 22, 1, 0.147, '2020-05-26 10:16:10', 'none', 'none', 'none');
INSERT INTO `person` VALUES (100, 'man', 12, 1, 0.147, '2020-05-26 11:04:55', 'none', 'none', 'none');
INSERT INTO `person` VALUES (101, 'man', 12, 1, 0.147, '2020-05-26 15:34:31', 'none', 'none', 'none');
INSERT INTO `person` VALUES (102, 'man', 12, 1, 0.147, '2020-05-26 16:04:44', 'none', 'none', 'none');
INSERT INTO `person` VALUES (103, 'man', 18, 1, 0.147, '2020-05-26 16:19:33', 'none', 'none', 'none');
INSERT INTO `person` VALUES (104, 'man', 12, 1, 0.147, '2020-05-26 16:38:02', 'none', 'none', 'none');
INSERT INTO `person` VALUES (105, 'man', 12, 1, 0.147, '2020-05-26 16:38:02', 'none', 'none', 'none');

SET FOREIGN_KEY_CHECKS = 1;

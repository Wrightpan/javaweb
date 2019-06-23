/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : book_store

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 20/06/2019 11:27:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `order_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buynum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('27db75e5-a1d8-4890-b3d6-cb30890bcb9d', '1', 1);
INSERT INTO `orderitem` VALUES ('72d6b367-73da-472a-a212-4e49ebf0fc04', '1', 1);
INSERT INTO `orderitem` VALUES ('97e70d70-2ef2-4979-83e3-e757e968c312', '1', 1);
INSERT INTO `orderitem` VALUES ('9e3f5e95-7df2-415f-868a-002341f7edd2', '2', 1);
INSERT INTO `orderitem` VALUES ('fadb1b09-5c1f-42cb-bd62-9cdbfb0f0bc4', '2', 1);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `money` double NULL DEFAULT NULL,
  `receiveAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiveName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receivePhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orderTime` timestamp(0) NULL DEFAULT '2016-01-01 00:00:00',
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('27db75e5-a1d8-4890-b3d6-cb30890bcb9d', 78, '123', '759', '852', '2019-06-12 03:29:48', 1);
INSERT INTO `orders` VALUES ('fadb1b09-5c1f-42cb-bd62-9cdbfb0f0bc4', 240, '102', '123', '789', '2019-06-12 03:31:23', 1);

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT 0,
  `category` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `imgurl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES (1, 'MATH', 78, NULL, 17, 'img\\1.jpg', '\\gitbook\\1.jsp');
INSERT INTO `products` VALUES (2, 'Python Crash Course', 240, NULL, 14, 'img\\2.jpg', '\\gitbook\\2.jsp');
INSERT INTO `products` VALUES (3, 'J2EE Development', 238, NULL, 16, 'img\\3.jpg', '\\gitbook\\3.jsp');
INSERT INTO `products` VALUES (4, 'C++ Primer Plus', 88, NULL, 18, 'img\\4.jpg', '\\gitbook\\4.jsp');
INSERT INTO `products` VALUES (5, '2MATH', 78, NULL, 17, 'img\\1.jpg', '\\gitbook\\1.jsp');
INSERT INTO `products` VALUES (6, '2Python Crash Course', 240, NULL, 18, 'img\\2.jpg', '\\gitbook\\2.jsp');
INSERT INTO `products` VALUES (7, '2J2EE Development', 238, NULL, 18, 'img\\3.jpg', '\\gitbook\\3.jsp');
INSERT INTO `products` VALUES (8, '2C++ Primer Plus', 88, NULL, 20, 'img\\4.jpg', '\\gitbook\\4.jsp');
INSERT INTO `products` VALUES (9, '3MATH', 78, NULL, 17, 'img\\1.jpg', '\\gitbook\\1.jsp');
INSERT INTO `products` VALUES (10, '3Python Crash Course', 240, NULL, 18, 'img\\2.jpg', '\\gitbook\\2.jsp');
INSERT INTO `products` VALUES (11, '3J2EE Development', 238, NULL, 16, 'img\\3.jpg', '\\gitbook\\3.jsp');
INSERT INTO `products` VALUES (12, '3C++ Primer Plus', 88, NULL, 18, 'img\\4.jpg', '\\gitbook\\4.jsp');
INSERT INTO `products` VALUES (13, '4MATH', 78, NULL, 17, 'img\\1.jpg', '\\gitbook\\1.jsp');
INSERT INTO `products` VALUES (14, '4Python Crash Course', 240, NULL, 18, 'img\\2.jpg', '\\gitbook\\2.jsp');
INSERT INTO `products` VALUES (15, '4J2EE Development', 238, NULL, 18, 'img\\3.jpg', '\\gitbook\\3.jsp');
INSERT INTO `products` VALUES (16, '4C++ Primer Plus', 88, NULL, 20, 'img\\4.jpg', '\\gitbook\\4.jsp');
INSERT INTO `products` VALUES (17, '5MATH', 78, NULL, 17, 'img\\1.jpg', '\\gitbook\\1.jsp');
INSERT INTO `products` VALUES (18, '5Python Crash Course', 240, NULL, 18, 'img\\2.jpg', '\\gitbook\\2.jsp');
INSERT INTO `products` VALUES (19, '5J2EE Development', 238, NULL, 16, 'img\\3.jpg', '\\gitbook\\3.jsp');
INSERT INTO `products` VALUES (20, '5C++ Primer Plus', 88, NULL, 18, 'img\\4.jpg', '\\gitbook\\4.jsp');
INSERT INTO `products` VALUES (21, '6MATH', 78, NULL, 17, 'img\\1.jpg', '\\gitbook\\1.jsp');
INSERT INTO `products` VALUES (22, '6Python Crash Course', 240, NULL, 18, 'img\\2.jpg', '\\gitbook\\2.jsp');
INSERT INTO `products` VALUES (23, '6J2EE Development', 238, NULL, 18, 'img\\3.jpg', '\\gitbook\\3.jsp');
INSERT INTO `products` VALUES (24, '6C++ Primer Plus', 88, NULL, 20, 'img\\4.jpg', '\\gitbook\\4.jsp');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduce` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activeCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  `role` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `registTime` timestamp(0) NOT NULL DEFAULT '2016-01-01 00:00:00',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '005', '005', '男', '005', '005', '005', '', 1, '', '2019-05-26 04:35:30');
INSERT INTO `user` VALUES (2, '00502', '00502', '女', '00502', '00502', '00502', 'admin', 1, 'admin', '2016-01-01 00:00:00');
INSERT INTO `user` VALUES (3, '0050201', '0050201', '', '0050201', '0050201', NULL, '', 1, '', '2019-06-04 08:28:27');
INSERT INTO `user` VALUES (5, '001', '001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-01-01 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;

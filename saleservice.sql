/*
 Navicat MySQL Data Transfer

 Source Server         : 106.13.105.44_3306
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : 106.13.105.44:3306
 Source Schema         : saleservice

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 22/05/2021 02:58:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sale_order
-- ----------------------------
DROP TABLE IF EXISTS `sale_order`;
CREATE TABLE `sale_order`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `want` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userid` int NULL DEFAULT NULL,
  `order_status` int NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sale_order
-- ----------------------------
INSERT INTO `sale_order` VALUES (39, '壁挂炉', '2021-04-30', '保养', 15, 1);
INSERT INTO `sale_order` VALUES (40, '壁挂炉', '2021-05-04', '安装', 15, 1);
INSERT INTO `sale_order` VALUES (41, '暖气片', '2021-05-12', '维修', 15, 3);
INSERT INTO `sale_order` VALUES (42, '空调', '2021-04-29', '安装', 15, 1);
INSERT INTO `sale_order` VALUES (43, '空调', '2021-04-28', '维修', 14, 2);
INSERT INTO `sale_order` VALUES (44, '空调', '2021-05-17', '维修', 14, 1);
INSERT INTO `sale_order` VALUES (45, '空调', '2021-05-17', '安装', 14, 1);
INSERT INTO `sale_order` VALUES (46, '空调', '2021-05-17', '保养', 14, 1);
INSERT INTO `sale_order` VALUES (47, '壁挂炉', '2021-05-17', '保养', 14, 1);
INSERT INTO `sale_order` VALUES (48, '壁挂炉', '2021-05-17', '安装', 14, 1);
INSERT INTO `sale_order` VALUES (49, '壁挂炉', '2021-05-17', '维修', 14, 2);
INSERT INTO `sale_order` VALUES (50, '空调', '2021-05-17', '维修', 7, 2);
INSERT INTO `sale_order` VALUES (51, '空调', '2021-05-17', '安装', 7, 1);
INSERT INTO `sale_order` VALUES (52, '空调', '2021-05-17', '保养', 7, 1);
INSERT INTO `sale_order` VALUES (53, '壁挂炉', '2021-05-17', '保养', 7, 1);
INSERT INTO `sale_order` VALUES (54, '暖气片', '2021-05-17', '保养', 7, 1);
INSERT INTO `sale_order` VALUES (55, '暖气片', '2021-05-17', '安装', 7, 1);
INSERT INTO `sale_order` VALUES (56, '壁挂炉', '2021-05-17', '维修', 7, 1);
INSERT INTO `sale_order` VALUES (57, '暖气片', '2021-05-17', '维修', 7, 1);
INSERT INTO `sale_order` VALUES (58, '空调', '2021-05-17', '维修', 8, 1);
INSERT INTO `sale_order` VALUES (59, '空调', '2021-05-17', '安装', 8, 1);
INSERT INTO `sale_order` VALUES (60, '空调', '2021-05-17', '保养', 8, 1);
INSERT INTO `sale_order` VALUES (61, '壁挂炉', '2021-05-17', '保养', 8, 1);
INSERT INTO `sale_order` VALUES (62, '暖气片', '2021-05-17', '安装', 8, 2);
INSERT INTO `sale_order` VALUES (63, '壁挂炉', '2021-05-17', '维修', 8, 1);
INSERT INTO `sale_order` VALUES (64, '空调', '2021-05-21', '维修', 21, 3);
INSERT INTO `sale_order` VALUES (65, '壁挂炉', '2021-05-21', '安装', 21, 1);
INSERT INTO `sale_order` VALUES (66, '空调', '2021-05-21', '保养', 21, 1);
INSERT INTO `sale_order` VALUES (67, '壁挂炉', '2021-05-21', '维修', 21, 3);
INSERT INTO `sale_order` VALUES (68, '空调', '2021-05-21', '安装', 21, 3);
INSERT INTO `sale_order` VALUES (69, '壁挂炉', '2021-05-21', '保养', 21, 3);
INSERT INTO `sale_order` VALUES (70, '暖气片', '2021-05-21', '维修', 21, 2);
INSERT INTO `sale_order` VALUES (71, '暖气片', '2021-05-21', '安装', 21, 1);
INSERT INTO `sale_order` VALUES (72, '暖气片', '2021-05-21', '保养', 21, 1);
INSERT INTO `sale_order` VALUES (73, '地暖', '2021-05-21', '维修', 21, 1);
INSERT INTO `sale_order` VALUES (74, '地暖', '2021-05-21', '安装', 21, 1);
INSERT INTO `sale_order` VALUES (75, '地暖', '2021-05-21', '保养', 21, 2);
INSERT INTO `sale_order` VALUES (76, '热水器', '2021-05-21', '维修', 21, 1);
INSERT INTO `sale_order` VALUES (77, '热水器', '2021-05-21', '安装', 21, 1);
INSERT INTO `sale_order` VALUES (78, '热水器', '2021-05-21', '保养', 21, 1);
INSERT INTO `sale_order` VALUES (79, '空调', '2021-05-21', '维修', 22, 1);
INSERT INTO `sale_order` VALUES (80, '空调', '2021-05-21', '安装', 22, 2);
INSERT INTO `sale_order` VALUES (81, '空调', '2021-05-21', '保养', 22, 2);
INSERT INTO `sale_order` VALUES (82, '壁挂炉', '2021-05-23', '维修', 22, 2);
INSERT INTO `sale_order` VALUES (83, '空调', '2021-05-23', '安装', 22, 1);
INSERT INTO `sale_order` VALUES (84, '地暖', '2021-05-19', '保养', 22, 2);
INSERT INTO `sale_order` VALUES (85, '热水器', '2021-05-31', '安装', 22, 1);
INSERT INTO `sale_order` VALUES (86, '暖气片', '2021-05-23', '安装', 22, 1);
INSERT INTO `sale_order` VALUES (87, '空调', '2021-05-29', '维修', 24, 3);
INSERT INTO `sale_order` VALUES (88, '空调', '2021-05-21', '安装', 24, 3);
INSERT INTO `sale_order` VALUES (89, '空调', '2021-05-21', '保养', 24, 3);
INSERT INTO `sale_order` VALUES (91, '空调', '2021-05-21', '安装', 24, 3);
INSERT INTO `sale_order` VALUES (97, '空调', '2021-05-27', '维修', 24, 2);
INSERT INTO `sale_order` VALUES (98, '壁挂炉', '2021-05-22', '安装', 24, 2);
INSERT INTO `sale_order` VALUES (99, '地暖', '2021-05-21', '保养', 24, 2);

-- ----------------------------
-- Table structure for sale_user
-- ----------------------------
DROP TABLE IF EXISTS `sale_user`;
CREATE TABLE `sale_user`  (
  `USER_ID` int NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_SEX` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  `USER_BIRTHDAY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_EMAIL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_MOBILE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_ADDRESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_TYPE` int NULL DEFAULT 2,
  PRIMARY KEY (`USER_ID`, `USER_NAME`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sale_user
-- ----------------------------
INSERT INTO `sale_user` VALUES (1, 'admin', 'admin', '2', NULL, NULL, NULL, NULL, 1);
INSERT INTO `sale_user` VALUES (21, '许澄邈', '123sss', '1', '1999-08-22', '123453355@qq.com', '13939678768', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (22, '刘德泽', '123zxw', '1', '1999-09-17', '242144111@qq.com', '15320231365', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (23, '程海超', '123zxw', '1', '1999-08-21', '445225555@qq.com', '13939678768', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (24, '张曦文', '1999zxwww', '1', '1999-08-22', '576743411@qq.com', '15320231352', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (25, '邓海阳', '2000dhy', '1', '2000-06-08', '576743413@qq.com', '13939678768', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (26, '邓海荣', '1999dhr', '1', '1999-08-02', '576743413@qq.com', '13939678768', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (27, '陈海逸', '1999chy', '2', '1999-08-14', '576743413@qq.com', '13939678768', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (28, '宋海昌', '1999shc', '1', '1999-08-16', '576743413@qq.com', '13939678768', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (29, '徐瀚钰', '1999xhy', '2', '1999-06-26', 'vshjvkjbvs@gmail.com', '13939678768', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (30, '徐瀚文', '1999xhw', '1', '1999-04-17', 'dhhfbbn@163.com', '15320325325', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (31, '陈涵亮', '1999chl', '1', '1999-10-15', 'chenhanliang@qq.com', '13564856523', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (32, '程涵煦', '1999chx', '2', '1999-09-24', 'chenghanxv@qq.com', '13526586498', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (33, '宋明宇', '1999smy', '1', '1999-03-20', 'songmingyu@qq.com', '15035624569', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (34, '徐涵衍', '1999xhy', '1', '1999-11-27', 'xvhanyan@163.com', '15025463215', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (35, '万浩波', '1999wbh', '1', '1999-10-22', 'wanhaobo@163.com', '15052365412', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (36, '何小天', '1999hxt', '1', '1999-10-15', 'hexiaotian@gmail.com', '13056235123', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (37, '孙秀云', '1999sxy', '2', '1999-12-18', 'sunxiuyun@163.com', '13125632542', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (38, '李文信', '1999lwx', '1', '1999-12-18', 'liwenxin@qq.com', '13525632565', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (39, '王仁兴', '1999wrx', '1', '1999-05-15', 'wangrenxing@qq.com', '13525623256', '重庆市永川区重大城科', 2);
INSERT INTO `sale_user` VALUES (40, '维修人员', '1999wrx', '2', '1999-01-01', 'wangrenxing@qq.com', '13525623256', '重庆市永川区重大城科', 3);

SET FOREIGN_KEY_CHECKS = 1;

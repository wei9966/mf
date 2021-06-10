/*
 Navicat Premium Data Transfer

 Source Server         : 本机数据库
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : mf_offer

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 09/06/2021 15:16:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mf_amoun
-- ----------------------------
DROP TABLE IF EXISTS `mf_amoun`;
CREATE TABLE `mf_amoun`  (
  `amoun_id` int(11) NOT NULL AUTO_INCREMENT,
  `amoun_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `amoun_price` decimal(10, 0) NULL DEFAULT NULL COMMENT '复膜单价',
  PRIMARY KEY (`amoun_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '复膜' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_bingding
-- ----------------------------
DROP TABLE IF EXISTS `mf_bingding`;
CREATE TABLE `mf_bingding`  (
  `binding_id` int(11) NOT NULL AUTO_INCREMENT,
  `binding_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `binding_price` decimal(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`binding_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '装订方式' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_collage
-- ----------------------------
DROP TABLE IF EXISTS `mf_collage`;
CREATE TABLE `mf_collage`  (
  `collage_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '拼版id',
  `collage_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拼版类型',
  PRIMARY KEY (`collage_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '拼版尺寸' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_color
-- ----------------------------
DROP TABLE IF EXISTS `mf_color`;
CREATE TABLE `mf_color`  (
  `color_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '墨色id',
  `color_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '墨色类型',
  PRIMARY KEY (`color_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '墨色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_machine
-- ----------------------------
DROP TABLE IF EXISTS `mf_machine`;
CREATE TABLE `mf_machine`  (
  `machine_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机台id',
  `machine_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机台类型',
  PRIMARY KEY (`machine_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '机台' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_offer
-- ----------------------------
DROP TABLE IF EXISTS `mf_offer`;
CREATE TABLE `mf_offer`  (
  `offer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '报价id',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '报价类型',
  `offer_produce_id` int(11) NULL DEFAULT 0 COMMENT '生产标志',
  `offer_time` datetime(0) NULL DEFAULT NULL COMMENT '报价日期',
  `offer_customer_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户名称',
  `offer_product_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `size_id` int(11) NULL DEFAULT NULL COMMENT '尺寸',
  `offer_number` int(11) NULL DEFAULT NULL COMMENT '产品数量',
  `offer_cover_grammage` int(11) NULL DEFAULT NULL COMMENT '封面克数',
  `paper_id_cover` int(11) NULL DEFAULT NULL COMMENT '封面纸型',
  `offer_cover_p` int(11) NULL DEFAULT NULL COMMENT '封面P数',
  `color_id_cover` int(11) NULL DEFAULT NULL COMMENT '封面墨色',
  `offer_cover_prive` float NULL DEFAULT NULL COMMENT '封面价格',
  `offer_core_grammage` int(11) NULL DEFAULT NULL COMMENT '内芯克数',
  `paper_id_core` int(11) NULL DEFAULT NULL COMMENT '内芯纸型',
  `offer_core_p` int(11) NULL DEFAULT NULL COMMENT '内芯P数',
  `color_id_core` int(11) NULL DEFAULT NULL COMMENT '内芯墨色',
  `offer_core_price` float NULL DEFAULT NULL COMMENT '内芯价格',
  `offer_inset_grammage` int(11) NULL DEFAULT NULL COMMENT '插页克数',
  `paper_id_inset` int(11) NULL DEFAULT NULL COMMENT '插页纸型',
  `offer_inset_p` int(11) NULL DEFAULT NULL COMMENT '插页p数',
  `color_id_inset` int(11) NULL DEFAULT NULL COMMENT '插页墨色',
  `offer_inset_price` float NULL DEFAULT NULL COMMENT '插页金额',
  `offer_amoun_price` float NULL DEFAULT NULL COMMENT '复膜金额',
  `amoun_id` int(11) NULL DEFAULT NULL,
  `offer_binding_price` float NULL DEFAULT NULL COMMENT '装订金额',
  `binding_id` int(11) NULL DEFAULT NULL,
  `offer_delivery_price` float NULL DEFAULT NULL COMMENT '配送金额',
  `offer_process_1_price` float NULL DEFAULT NULL COMMENT '工艺1金额',
  `offer_process_2_price` float NULL DEFAULT NULL COMMENT '工艺2金额',
  `offer_process_3_price` float NULL DEFAULT NULL COMMENT '工艺3金额',
  `offer_process_4_price` float NULL DEFAULT NULL COMMENT '工艺4金额',
  `offer_process_5_price` float NULL DEFAULT NULL COMMENT '工艺5金额',
  `offer_process_1_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工艺1名称',
  `offer_process_2_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工艺2名称',
  `offer_process_3_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工艺3名称',
  `offer_process_4_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工艺4名称',
  `offer_process_5_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工艺5名称',
  `offer_machining_price` float NULL DEFAULT NULL COMMENT '加工金额',
  `offer_total_price` float NULL DEFAULT NULL COMMENT '总金额',
  `offer_work_id` int(11) NULL DEFAULT NULL COMMENT '工单id',
  PRIMARY KEY (`offer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '明发报价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_offer_black
-- ----------------------------
DROP TABLE IF EXISTS `mf_offer_black`;
CREATE TABLE `mf_offer_black`  (
  `offer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '报价id',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '报价类型',
  `offer_produce_id` int(11) NULL DEFAULT 0 COMMENT '生产标志',
  `offer_time` datetime(0) NULL DEFAULT NULL COMMENT '报价日期',
  `offer_customer_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户名称',
  `offer_product_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `size_id` int(11) NULL DEFAULT NULL COMMENT '尺寸',
  `offer_number` int(11) NULL DEFAULT NULL COMMENT '产品数量',
  `offer_cover_grammage` int(11) NULL DEFAULT NULL COMMENT '封面克数',
  `paper_id_cover` int(11) NULL DEFAULT NULL COMMENT '封面纸型',
  `offer_cover_p` int(11) NULL DEFAULT NULL COMMENT '封面P数',
  `color_id_cover` int(11) NULL DEFAULT NULL COMMENT '封面墨色',
  `offer_cover_prive` float NULL DEFAULT NULL COMMENT '封面价格',
  `offer_core_grammage` int(11) NULL DEFAULT NULL COMMENT '内芯克数',
  `paper_id_core` int(11) NULL DEFAULT NULL COMMENT '内芯纸型',
  `offer_core_p` int(11) NULL DEFAULT NULL COMMENT '内芯P数',
  `color_id_core` int(11) NULL DEFAULT NULL COMMENT '内芯墨色',
  `offer_core_price` float NULL DEFAULT NULL COMMENT '内芯价格',
  `offer_inset_grammage` int(11) NULL DEFAULT NULL COMMENT '插页克数',
  `paper_id_inset` int(11) NULL DEFAULT NULL COMMENT '插页纸型',
  `offer_inset_p` int(11) NULL DEFAULT NULL COMMENT '插页p数',
  `color_id_inset` int(11) NULL DEFAULT NULL COMMENT '插页墨色',
  `offer_inset_price` float NULL DEFAULT NULL COMMENT '插页金额',
  `offer_amoun_price` float NULL DEFAULT NULL COMMENT '复膜金额',
  `amoun_id` int(11) NULL DEFAULT NULL,
  `offer_binding_price` float NULL DEFAULT NULL COMMENT '装订金额',
  `binding_id` int(11) NULL DEFAULT NULL,
  `offer_delivery_price` float NULL DEFAULT NULL COMMENT '配送金额',
  `offer_process_1_price` float NULL DEFAULT NULL COMMENT '工艺1金额',
  `offer_process_2_price` float NULL DEFAULT NULL COMMENT '工艺2金额',
  `offer_process_3_price` float NULL DEFAULT NULL COMMENT '工艺3金额',
  `offer_process_4_price` float NULL DEFAULT NULL COMMENT '工艺4金额',
  `offer_process_5_price` float NULL DEFAULT NULL COMMENT '工艺5金额',
  `offer_process_1_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工艺1名称',
  `offer_process_2_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工艺2名称',
  `offer_process_3_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工艺3名称',
  `offer_process_4_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工艺4名称',
  `offer_process_5_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工艺5名称',
  `offer_machining_price` float NULL DEFAULT NULL COMMENT '加工金额',
  `offer_total_price` float NULL DEFAULT NULL COMMENT '总金额',
  `offer_work_id` int(11) NULL DEFAULT NULL COMMENT '工单id',
  PRIMARY KEY (`offer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '明发黑白报价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_paper
-- ----------------------------
DROP TABLE IF EXISTS `mf_paper`;
CREATE TABLE `mf_paper`  (
  `paper_id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纸张类型',
  PRIMARY KEY (`paper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '纸张类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_permission
-- ----------------------------
DROP TABLE IF EXISTS `mf_permission`;
CREATE TABLE `mf_permission`  (
  `permissior_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `permissior_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限类型',
  PRIMARY KEY (`permissior_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_role
-- ----------------------------
DROP TABLE IF EXISTS `mf_role`;
CREATE TABLE `mf_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色类型',
  `permissior_id` int(11) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_running_bill
-- ----------------------------
DROP TABLE IF EXISTS `mf_running_bill`;
CREATE TABLE `mf_running_bill`  (
  `bill_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `bill_time` datetime(0) NULL DEFAULT NULL COMMENT '记录时间',
  `bill_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户名称',
  `bill_abstract` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '流水摘要',
  `bill_money` double NULL DEFAULT NULL COMMENT '流水金额',
  `bill_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收支类型',
  `bill_method` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收支方式',
  `bill_remarks` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '流水备注',
  PRIMARY KEY (`bill_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '明发流水表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_running_bill_black
-- ----------------------------
DROP TABLE IF EXISTS `mf_running_bill_black`;
CREATE TABLE `mf_running_bill_black`  (
  `bill_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `bill_time` datetime(0) NULL DEFAULT NULL COMMENT '记录时间',
  `bill_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户名称',
  `bill_abstract` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '流水摘要',
  `bill_money` double NULL DEFAULT NULL COMMENT '流水金额',
  `bill_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收支类型',
  `bill_method` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收支方式',
  `bill_remarks` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '流水备注',
  PRIMARY KEY (`bill_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '明发黑白流水表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_tonprice
-- ----------------------------
DROP TABLE IF EXISTS `mf_tonprice`;
CREATE TABLE `mf_tonprice`  (
  `tp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '吨价id',
  `tp_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '吨价类型',
  `tp_price` float NULL DEFAULT NULL COMMENT '吨价价格',
  PRIMARY KEY (`tp_id`) USING BTREE,
  INDEX `tp_id`(`tp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '吨价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_type
-- ----------------------------
DROP TABLE IF EXISTS `mf_type`;
CREATE TABLE `mf_type`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报价类型id',
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报价类型',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '报价类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_user
-- ----------------------------
DROP TABLE IF EXISTS `mf_user`;
CREATE TABLE `mf_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_work
-- ----------------------------
DROP TABLE IF EXISTS `mf_work`;
CREATE TABLE `mf_work`  (
  `work_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '工单编号',
  `work_time` datetime(0) NULL DEFAULT NULL COMMENT '工单打印时间',
  `work_customer_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户名',
  `work_product_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `work_number` int(11) NULL DEFAULT NULL COMMENT '产品数量',
  `work_delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '交货时间',
  `work_offer_time` datetime(0) NULL DEFAULT NULL COMMENT '报价时间',
  `machine_id` int(11) NULL DEFAULT NULL COMMENT '机台',
  `product_size_id` int(11) NULL DEFAULT NULL COMMENT '产品尺寸',
  `pane_size_id` int(11) NULL DEFAULT NULL COMMENT '拼板尺寸',
  `work_cover_grammage` int(11) NULL DEFAULT NULL COMMENT '封面克数',
  `work_core_grammage` int(11) NULL DEFAULT NULL COMMENT '内芯克数',
  `work_inset_grammage` int(11) NULL DEFAULT NULL COMMENT '插页克数',
  `core_paper_id` int(11) NULL DEFAULT NULL COMMENT '内芯纸型',
  `cover_paper_id` int(11) NULL DEFAULT NULL COMMENT '封面纸型',
  `inset_paper_id` int(11) NULL DEFAULT NULL COMMENT '插页纸型',
  `work_cover_leave` int(11) NULL DEFAULT NULL COMMENT '封面开别',
  `work_core_leave` int(11) NULL DEFAULT NULL COMMENT '内芯开别',
  `work_inset_leave` int(11) NULL DEFAULT NULL COMMENT '插页开别',
  `work_cover_play_number` int(11) NULL DEFAULT NULL COMMENT '封面放数',
  `work_core_play_number` int(11) NULL DEFAULT NULL COMMENT '内芯放数',
  `work_inset_play_number` int(11) NULL DEFAULT NULL COMMENT '内芯放数',
  `work_cover_alloys_number` int(11) NULL DEFAULT NULL COMMENT '封面合全开数',
  `work_core_alloys_number` int(11) NULL DEFAULT NULL COMMENT '内芯合全开数',
  `work_inset_alloys_number` int(11) NULL DEFAULT NULL COMMENT '插页合全开数',
  `cover_color_id` int(11) NULL DEFAULT NULL COMMENT '封面墨色',
  `inset_color_id` int(11) NULL DEFAULT NULL COMMENT '插页墨色',
  `core_color_id` int(11) NULL DEFAULT NULL COMMENT '内芯墨色',
  `work_cover_plate_number` int(11) NULL DEFAULT NULL COMMENT '封面印版数量',
  `work_core_plate_number` int(11) NULL DEFAULT NULL COMMENT '内芯印版数量',
  `work_inset_plate_number` int(11) NULL DEFAULT NULL COMMENT '插页印版数量',
  `work_cover_price` float NULL DEFAULT NULL COMMENT '封面价格',
  `work_core_price` float NULL DEFAULT NULL COMMENT '内芯价格',
  `work_post_process_price` float NULL DEFAULT NULL COMMENT '后加工价格',
  `work_total_price` float NULL DEFAULT NULL COMMENT '总价',
  `work_post_processing` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后加工',
  `work_remarks` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `work_offer_id` int(11) NULL DEFAULT NULL COMMENT '报价id',
  PRIMARY KEY (`work_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mf_work_hb
-- ----------------------------
DROP TABLE IF EXISTS `mf_work_hb`;
CREATE TABLE `mf_work_hb`  (
  `work_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '工单编号',
  `work_time` datetime(0) NULL DEFAULT NULL COMMENT '工单打印时间',
  `work_customer_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户名',
  `work_product_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `work_number` int(11) NULL DEFAULT NULL COMMENT '产品数量',
  `work_delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '交货时间',
  `work_offer_time` datetime(0) NULL DEFAULT NULL COMMENT '报价时间',
  `machine_id` int(11) NULL DEFAULT NULL COMMENT '机台',
  `product_size_id` int(11) NULL DEFAULT NULL COMMENT '产品尺寸',
  `pane_size_id` int(11) NULL DEFAULT NULL COMMENT '拼板尺寸',
  `work_cover_grammage` int(11) NULL DEFAULT NULL COMMENT '封面克数',
  `work_core_grammage` int(11) NULL DEFAULT NULL COMMENT '内芯克数',
  `work_inset_grammage` int(11) NULL DEFAULT NULL COMMENT '插页克数',
  `core_paper_id` int(11) NULL DEFAULT NULL COMMENT '内芯纸型',
  `cover_paper_id` int(11) NULL DEFAULT NULL COMMENT '封面纸型',
  `inset_paper_id` int(11) NULL DEFAULT NULL COMMENT '插页纸型',
  `work_cover_leave` int(11) NULL DEFAULT NULL COMMENT '封面开别',
  `work_core_leave` int(11) NULL DEFAULT NULL COMMENT '内芯开别',
  `work_inset_leave` int(11) NULL DEFAULT NULL COMMENT '插页开别',
  `work_cover_play_number` int(11) NULL DEFAULT NULL COMMENT '封面放数',
  `work_core_play_number` int(11) NULL DEFAULT NULL COMMENT '内芯放数',
  `work_inset_play_number` int(11) NULL DEFAULT NULL COMMENT '内芯放数',
  `work_cover_alloys_number` int(11) NULL DEFAULT NULL COMMENT '封面合全开数',
  `work_core_alloys_number` int(11) NULL DEFAULT NULL COMMENT '内芯合全开数',
  `work_inset_alloys_number` int(11) NULL DEFAULT NULL COMMENT '插页合全开数',
  `cover_color_id` int(11) NULL DEFAULT NULL COMMENT '封面墨色',
  `inset_color_id` int(11) NULL DEFAULT NULL COMMENT '插页墨色',
  `core_color_id` int(11) NULL DEFAULT NULL COMMENT '内芯墨色',
  `work_cover_plate_number` int(11) NULL DEFAULT NULL COMMENT '封面印版数量',
  `work_core_plate_number` int(11) NULL DEFAULT NULL COMMENT '内芯印版数量',
  `work_inset_plate_number` int(11) NULL DEFAULT NULL COMMENT '插页印版数量',
  `work_cover_price` float NULL DEFAULT NULL COMMENT '封面价格',
  `work_core_price` float NULL DEFAULT NULL COMMENT '内芯价格',
  `work_post_process_price` float NULL DEFAULT NULL COMMENT '后加工价格',
  `work_total_price` float NULL DEFAULT NULL COMMENT '总价',
  `work_post_processing` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后加工',
  `work_remarks` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `work_offer_id` int(11) NULL DEFAULT NULL COMMENT '报价id',
  PRIMARY KEY (`work_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `series` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_used` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Triggers structure for table mf_work
-- ----------------------------
DROP TRIGGER IF EXISTS `inswork`;
delimiter ;;
CREATE TRIGGER `inswork` AFTER INSERT ON `mf_work` FOR EACH ROW BEGIN
  UPDATE mf_offer set offer_work_id=new.work_id where offer_id=new.work_offer_id;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table mf_work_hb
-- ----------------------------
DROP TRIGGER IF EXISTS `insworkblack`;
delimiter ;;
CREATE TRIGGER `insworkblack` AFTER INSERT ON `mf_work_hb` FOR EACH ROW BEGIN
  UPDATE mf_offer_black set offer_work_id=new.work_id where offer_id=new.work_offer_id;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;

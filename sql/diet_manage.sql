/*
 Navicat Premium Data Transfer

 Source Server         : hxddbb
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : diet_manage

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 25/02/2022 20:25:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lb_appointment
-- ----------------------------
DROP TABLE IF EXISTS `lb_appointment`;
CREATE TABLE `lb_appointment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `patient_id` int(0) NULL DEFAULT NULL COMMENT '患者id',
  `doctor_id` int(0) NULL DEFAULT NULL COMMENT '医生id',
  `time` date NULL DEFAULT NULL COMMENT '预约时间',
  `expenses` decimal(10, 2) NULL DEFAULT NULL COMMENT '门诊费',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '就诊状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lb_appointment
-- ----------------------------
INSERT INTO `lb_appointment` VALUES (1, 1, 1, '2018-12-08', 30.00, NULL);
INSERT INTO `lb_appointment` VALUES (2, 3, 2, '2018-11-27', 30.00, '3');
INSERT INTO `lb_appointment` VALUES (3, 1, 1, '2019-03-07', 15.00, '3');
INSERT INTO `lb_appointment` VALUES (4, 4, 1, '2019-03-14', 30.00, NULL);
INSERT INTO `lb_appointment` VALUES (5, 5, 4, '2019-03-16', 10.00, NULL);
INSERT INTO `lb_appointment` VALUES (6, 4, 7, '2019-03-28', 15.00, NULL);
INSERT INTO `lb_appointment` VALUES (7, 5, 6, '2019-04-02', 30.00, NULL);
INSERT INTO `lb_appointment` VALUES (8, 3, 4, '2019-04-10', 10.00, NULL);
INSERT INTO `lb_appointment` VALUES (9, 2, 1, '2019-04-13', 30.00, NULL);
INSERT INTO `lb_appointment` VALUES (10, 1, 1, '2020-03-06', 10.00, NULL);
INSERT INTO `lb_appointment` VALUES (11, 5, 4, '2020-03-11', 10.00, NULL);
INSERT INTO `lb_appointment` VALUES (12, 1, 1, '2020-03-06', 10.00, NULL);
INSERT INTO `lb_appointment` VALUES (13, 9, 10, '2020-03-06', 100.00, '1');
INSERT INTO `lb_appointment` VALUES (15, 2, 2, '2020-04-30', 10.00, '3');
INSERT INTO `lb_appointment` VALUES (16, 2, 2, '2020-04-23', 10.00, '3');
INSERT INTO `lb_appointment` VALUES (17, 11, 17, '2022-02-19', 20.00, '2');
INSERT INTO `lb_appointment` VALUES (18, 11, 10, '2022-02-26', 12.00, '1');
INSERT INTO `lb_appointment` VALUES (19, 11, 17, '2022-02-22', 11.00, '1');
INSERT INTO `lb_appointment` VALUES (20, 12, 17, '2022-02-17', 312.00, '2');

-- ----------------------------
-- Table structure for lb_doctor
-- ----------------------------
DROP TABLE IF EXISTS `lb_doctor`;
CREATE TABLE `lb_doctor`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(0) NULL DEFAULT NULL COMMENT '年龄',
  `cert_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `sex` int(0) NULL DEFAULT NULL COMMENT '性别',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '登录',
  `text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '介绍',
  `expert` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lb_doctor
-- ----------------------------
INSERT INTO `lb_doctor` VALUES (1, '韩梅梅', 32, '320586198807191278', 1, '内科', '江苏/苏州', 3, '手动阀手动阀手动阀手动阀啊JKDASJDKLADLASLDKASL1312KASDKLASDKASJFLASFJKSGFJSDAKJFSAKFJSKFJSDKFJSDKLFJSDKLFJSCMxlSKkdosadkfsd看风使舵李开复十六分就开了反射定律攻击速度老师的课反对法工地上可22插卡式西欧的靠谱的看312课程搜房参考2', 1);
INSERT INTO `lb_doctor` VALUES (2, '李雷', 32, '320283198802102526', 0, '内科', '江苏/无锡', 4, '手动阀手动阀手动阀手动阀啊JKDASJDKLADLASLDKASL1312KASDKLASDKASJFLASFJKSGFJSDAKJFSAKFJSKFJSDKFJSDKLFJSDKLFJSCMxlSKkdosadkfsd看风使舵李开复十六分就开了反射定律攻击速度老师的课反对法工地上可22插卡式西欧的靠谱的看312课程搜房参考2', 1);
INSERT INTO `lb_doctor` VALUES (4, '赵志', 38, '310103198212062428', 0, '口腔科', '上海', 12, '手动阀手动阀手动阀手动阀啊JKDASJDKLADLASLDKASL1312KASDKLASDKASJFLASFJKSGFJSDAKJFSAKFJSKFJSDKFJSDKLFJSDKLFJSCMxlSKkdosadkfsd看风使舵李开复十六分就开了反射定律攻击速度老师的课反对法工地上可22插卡式西欧的靠谱的看312课程搜房参考2', 1);
INSERT INTO `lb_doctor` VALUES (5, '杨丽娟', 45, '320283197504207624', 1, '急诊科', '江苏/无锡', 18, '手动阀手动阀手动阀手动阀啊JKDASJDKLADLASLDKASL1312KASDKLASDKASJFLASFJKSGFJSDAKJFSAKFJSKFJSDKFJSDKLFJSDKLFJSCMxlSKkdosadkfsd看风使舵李开复十六分就开了反射定律攻击速度老师的课反对法工地上可22插卡式西欧的靠谱的看312课程搜房参考2', 1);
INSERT INTO `lb_doctor` VALUES (6, '王五', 45, '320283197508091516', 1, '神经内科', '江苏/无锡', 17, '手动阀手动阀手动阀手动阀啊JKDASJDKLADLASLDKASL1312KASDKLASDKASJFLASFJKSGFJSDAKJFSAKFJSKFJSDKFJSDKLFJSDKLFJSCMxlSKkdosadkfsd看风使舵李开复十六分就开了反射定律攻击速度老师的课反对法工地上可22插卡式西欧的靠谱的看312课程搜房参考2', 0);
INSERT INTO `lb_doctor` VALUES (7, '王一', 40, '320586198807191279', 1, '内科', '江苏/无锡', NULL, '手动阀手动阀手动阀手动阀啊JKDASJDKLADLASLDKASL1312KASDKLASDKASJFLASFJKSGFJSDAKJFSAKFJSKFJSDKFJSDKLFJSDKLFJSCMxlSKkdosadkfsd看风使舵李开复十六分就开了反射定律攻击速度老师的课反对法工地上可22插卡式西欧的靠谱的看312课程搜房参考2', 0);
INSERT INTO `lb_doctor` VALUES (10, '小刘', 30, '342425198906031111', 0, '口腔科', '苏州', 27, NULL, 1);
INSERT INTO `lb_doctor` VALUES (15, 'wcr', 23, '2141234124', 1, '内科', 'asdasd', NULL, NULL, 1);
INSERT INTO `lb_doctor` VALUES (16, 'lxx', 23, '2313123123', 0, '内科', 'awdawdf', NULL, NULL, 1);
INSERT INTO `lb_doctor` VALUES (17, 'rest', 23, '42356758234', 1, '妇产科', 'wdad', 41, NULL, 0);

-- ----------------------------
-- Table structure for lb_drugs
-- ----------------------------
DROP TABLE IF EXISTS `lb_drugs`;
CREATE TABLE `lb_drugs`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `type` int(0) NULL DEFAULT NULL COMMENT '药品类型',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `number` int(0) NULL DEFAULT NULL COMMENT '数量',
  `text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lb_drugs
-- ----------------------------
INSERT INTO `lb_drugs` VALUES (1, '乙酰氨基酚片', 4, 65.00, 199, '手动阀手动阀手动阀手动阀啊JKDASJDKLADLASLDKASL1312KASDKLASDKASJFLASFJKSGFJSDAKJFSAKFJSKFJSDKFJSDKLFJSDKLFJSCMxlSKkdosadkfsd看风使舵李开复十六分就开了反射定律攻击速度老师的课反对法工地上可22插卡式西欧的靠谱的看312课程搜房参考2');
INSERT INTO `lb_drugs` VALUES (2, '复方益肝灵片', 1, 20.00, 100, '手动阀手动阀手动阀手动阀啊JKDASJDKLADLASLDKASL1312KASDKLASDKASJFLASFJKSGFJSDAKJFSAKFJSKFJSDKFJSDKLFJSDKLFJSCMxlSKkdosadkfsd看风使舵李开复十六分就开了反射定律攻击速度老师的课反对法工地上可22插卡式西欧的靠谱的看312课程搜房参考2');
INSERT INTO `lb_drugs` VALUES (3, '胆维他片', 2, 50.00, 100, '手动阀手动阀手动阀手动阀啊JKDASJDKLADLASLDKASL1312KASDKLASDKASJFLASFJKSGFJSDAKJFSAKFJSKFJSDKFJSDKLFJSDKLFJSCMxlSKkdosadkfsd看风使舵李开复十六分就开了反射定律攻击速度老师的课反对法工地上可22插卡式西欧的靠谱的看312课程搜房参考2');
INSERT INTO `lb_drugs` VALUES (4, '抗菌消炎胶囊', 3, 45.00, 100, '手动阀手动阀手动阀手动阀啊JKDASJDKLADLASLDKASL1312KASDKLASDKASJFLASFJKSGFJSDAKJFSAKFJSKFJSDKFJSDKLFJSDKLFJSCMxlSKkdosadkfsd看风使舵李开复十六分就开了反射定律攻击速度老师的课反对法工地上可22插卡式西欧的靠谱的看312课程搜房参考2');
INSERT INTO `lb_drugs` VALUES (5, '健脑益气片', 4, 120.00, 100, '手动阀手动阀手动阀手动阀啊JKDASJDKLADLASLDKASL1312KASDKLASDKASJFLASFJKSGFJSDAKJFSAKFJSKFJSDKFJSDKLFJSDKLFJSCMxlSKkdosadkfsd看风使舵李开复十六分就开了反射定律攻击速度老师的课反对法工地上可22插卡式西欧的靠谱的看312课程搜房参考2');
INSERT INTO `lb_drugs` VALUES (7, '口服液', 5, 30.00, 100, '手动阀手动阀手动阀手动阀啊JKDASJDKLADLASLDKASL1312KASDKLASDKASJFLASFJKSGFJSDAKJFSAKFJSKFJSDKFJSDKLFJSDKLFJSCMxlSKkdosadkfsd看风使舵李开复十六分就开了反射定律攻击速度老师的课反对法工地上可22插卡式西欧的靠谱的看312课程搜房参考2');
INSERT INTO `lb_drugs` VALUES (13, '支气管舒张剂', 2, 60.00, 100, '手动阀手动阀手动阀手动阀啊JKDASJDKLADLASLDKASL1312KASDKLASDKASJFLASFJKSGFJSDAKJFSAKFJSKFJSDKFJSDKLFJSDKLFJSCMxlSKkdosadkfsd看风使舵李开复十六分就开了反射定律攻击速度老师的课反对法工地上可22插卡式西欧的靠谱的看312课程搜房参考2');
INSERT INTO `lb_drugs` VALUES (14, '阿莫西林', 1, 25.00, 50, '                                                        \r\n                        \r\n                        ');
INSERT INTO `lb_drugs` VALUES (15, '他克莫司', 5, 27.00, 100, '                                                        \r\n 抑制白癜风，配合照灯      ');

-- ----------------------------
-- Table structure for lb_hospitalization
-- ----------------------------
DROP TABLE IF EXISTS `lb_hospitalization`;
CREATE TABLE `lb_hospitalization`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `floor` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼层',
  `bed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '床号',
  `door` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间号',
  `medical_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病名称',
  `patient_id` int(0) NULL DEFAULT NULL COMMENT '患者id',
  `intime` date NULL DEFAULT NULL COMMENT '住院时间',
  `outtime` date NULL DEFAULT NULL COMMENT '出院时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lb_hospitalization
-- ----------------------------
INSERT INTO `lb_hospitalization` VALUES (1, '1', '4', '104', '头疼', 1, '2018-12-08', '2018-12-09');
INSERT INTO `lb_hospitalization` VALUES (2, '2', '3', '203', '呼吸系统疾病', 3, '2019-03-07', '2019-03-10');
INSERT INTO `lb_hospitalization` VALUES (3, '2', '1', '201', '慢性阻塞性肺疾病', 1, '2019-03-12', '2019-03-18');
INSERT INTO `lb_hospitalization` VALUES (4, '3', '1', '301', '胆石症', 4, '2019-03-14', '2019-03-25');
INSERT INTO `lb_hospitalization` VALUES (5, '3', '2', '302', '胆管疾病', 5, '2019-03-16', '2019-03-22');
INSERT INTO `lb_hospitalization` VALUES (6, '2', '2', '202', '肺结石', 3, '2019-04-10', NULL);
INSERT INTO `lb_hospitalization` VALUES (8, '1', '2', '102', '阑尾炎', 4, '2019-03-28', '2019-03-31');
INSERT INTO `lb_hospitalization` VALUES (10, '3', '3', '303', '脑血管疾病', 5, '2019-04-02', '2020-03-17');
INSERT INTO `lb_hospitalization` VALUES (11, '5', '4', '3', '心血管', 4, '2019-04-25', NULL);
INSERT INTO `lb_hospitalization` VALUES (12, '2', '1', '203', '感冒', 3, '2020-04-30', NULL);

-- ----------------------------
-- Table structure for lb_illness
-- ----------------------------
DROP TABLE IF EXISTS `lb_illness`;
CREATE TABLE `lb_illness`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lb_illness
-- ----------------------------
INSERT INTO `lb_illness` VALUES (1, '牙疼', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx');
INSERT INTO `lb_illness` VALUES (2, '头疼', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx');
INSERT INTO `lb_illness` VALUES (3, '呼吸性疾病', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx');
INSERT INTO `lb_illness` VALUES (4, '胆结石', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx');
INSERT INTO `lb_illness` VALUES (5, '胆管疾病', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx');
INSERT INTO `lb_illness` VALUES (6, '阑尾炎', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx');

-- ----------------------------
-- Table structure for lb_medicalhistory
-- ----------------------------
DROP TABLE IF EXISTS `lb_medicalhistory`;
CREATE TABLE `lb_medicalhistory`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `patient_id` int(0) NULL DEFAULT NULL COMMENT '患者id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病史名称',
  `time` date NULL DEFAULT NULL COMMENT '患病时间',
  `hospitalization_id` int(0) NULL DEFAULT NULL COMMENT '住院信息',
  `doctor_id` int(0) NULL DEFAULT NULL COMMENT '确诊人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lb_medicalhistory
-- ----------------------------
INSERT INTO `lb_medicalhistory` VALUES (1, 1, '头疼', '2018-12-08', 1, 1);
INSERT INTO `lb_medicalhistory` VALUES (2, 3, '呼吸系统疾病', '2019-03-07', 2, 2);
INSERT INTO `lb_medicalhistory` VALUES (3, 4, '胆结石', '2019-03-14', 4, 4);
INSERT INTO `lb_medicalhistory` VALUES (4, 5, '胆管疾病', '2019-03-16', 5, 7);
INSERT INTO `lb_medicalhistory` VALUES (8, 1, '阑尾炎', '2019-04-08', NULL, 5);
INSERT INTO `lb_medicalhistory` VALUES (9, 1, '感冒', '2020-03-06', NULL, 1);

-- ----------------------------
-- Table structure for lb_news
-- ----------------------------
DROP TABLE IF EXISTS `lb_news`;
CREATE TABLE `lb_news`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime(0) NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lb_option
-- ----------------------------
DROP TABLE IF EXISTS `lb_option`;
CREATE TABLE `lb_option`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lb_option
-- ----------------------------
INSERT INTO `lb_option` VALUES (1, '大血', '血液科室', 100.00);
INSERT INTO `lb_option` VALUES (2, '小血', '血液科室', 200.00);
INSERT INTO `lb_option` VALUES (3, 'B超（彩超）', '超生室', 300.00);
INSERT INTO `lb_option` VALUES (4, '心电图', '心电图室', 200.00);
INSERT INTO `lb_option` VALUES (5, '大便', '厕所门口自行拿管', 200.00);
INSERT INTO `lb_option` VALUES (6, '小便', '厕所门口自行拿管', 200.00);
INSERT INTO `lb_option` VALUES (7, 'CT', '放射科室', 200.00);
INSERT INTO `lb_option` VALUES (8, 'X光片', '放射科室', 200.00);
INSERT INTO `lb_option` VALUES (9, '核磁共振', '放射科室', 200.00);
INSERT INTO `lb_option` VALUES (10, '其他', '无', 0.00);
INSERT INTO `lb_option` VALUES (11, '伍德灯', '皮肤科', 27.00);

-- ----------------------------
-- Table structure for lb_patient
-- ----------------------------
DROP TABLE IF EXISTS `lb_patient`;
CREATE TABLE `lb_patient`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(0) NULL DEFAULT NULL COMMENT '年龄',
  `cert_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `sex` int(0) NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `hospitalization_id` int(0) NULL DEFAULT NULL COMMENT '住院信息',
  `drugsids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品信息',
  `isout` int(0) NULL DEFAULT NULL COMMENT '是否出院',
  `appointment_id` int(0) NULL DEFAULT NULL COMMENT '预约信息',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '登录',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lb_patient
-- ----------------------------
INSERT INTO `lb_patient` VALUES (1, '郝一', 22, '320283199805201625', 1, '江苏/无锡', 1, '2@0', 2, 12, 5);
INSERT INTO `lb_patient` VALUES (2, '李依依', 21, '320283199903106214', 1, '江苏/无锡', 0, '', 0, 16, 6);
INSERT INTO `lb_patient` VALUES (3, '赵康', 22, '320586199807122289', 0, '江苏/苏州', 3, '', 2, 8, 7);
INSERT INTO `lb_patient` VALUES (4, '吴威', 23, '310103199712241820', 0, '上海', 4, '', 2, 6, 8);
INSERT INTO `lb_patient` VALUES (5, '孙志', 31, '320283199011105234', 0, '江苏/无锡', 5, '', 1, 7, 19);
INSERT INTO `lb_patient` VALUES (9, '王小二', 22, '342425198906032222', 0, '苏州园区', NULL, NULL, 0, 13, 26);
INSERT INTO `lb_patient` VALUES (10, '2', 1, '342425198906032222', 1, '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `lb_patient` VALUES (11, '梁某', 22, '4228221998', 0, 'hjw', NULL, NULL, NULL, 19, 32);
INSERT INTO `lb_patient` VALUES (12, '王某', 23, '4228221999', 1, 'hjw', NULL, NULL, NULL, 20, 36);

-- ----------------------------
-- Table structure for lb_seek
-- ----------------------------
DROP TABLE IF EXISTS `lb_seek`;
CREATE TABLE `lb_seek`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `describes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `illname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `drugs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `options` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `days` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `patient_id` int(0) NULL DEFAULT NULL,
  `appointment_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lb_seek
-- ----------------------------
INSERT INTO `lb_seek` VALUES (1, '2e3wsdasda', '1212', '2@0', '1,6', '0', 1385.00, 1, NULL);
INSERT INTO `lb_seek` VALUES (2, 'dasdasdas', '脑膜炎', '2@0', '10', '10', 65.00, 1, NULL);
INSERT INTO `lb_seek` VALUES (3, '流鼻涕', '感冒', '2@0', '10', '0', 0.00, 1, NULL);
INSERT INTO `lb_seek` VALUES (4, '流鼻涕', '感冒', '2@0', '2', '0', 200.00, 1, NULL);
INSERT INTO `lb_seek` VALUES (5, '肚子疼', '肯能是急性阑尾炎', '2@0', '2', '0', 200.00, 1, NULL);
INSERT INTO `lb_seek` VALUES (8, '1231', '1131', '1@11', '2', '0', 200.00, 3, 2);
INSERT INTO `lb_seek` VALUES (9, '流鼻涕', '感冒', '2@10', '2', '0', 200.00, 2, 15);
INSERT INTO `lb_seek` VALUES (11, '流鼻涕', '感冒', NULL, '1', '0', 100.00, 2, 16);
INSERT INTO `lb_seek` VALUES (31, '皮肤发白', '局部白癜风', NULL, '11', '0', 27.00, 11, 17);
INSERT INTO `lb_seek` VALUES (33, '骨折', '骨折', '15@5', '8', '12', 200.00, 12, 20);

-- ----------------------------
-- Table structure for lb_user
-- ----------------------------
DROP TABLE IF EXISTS `lb_user`;
CREATE TABLE `lb_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `role` int(0) NULL DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lb_user
-- ----------------------------
INSERT INTO `lb_user` VALUES (1, 'admin1', '123456', 1);
INSERT INTO `lb_user` VALUES (2, 'admin2', '123456', 1);
INSERT INTO `lb_user` VALUES (3, 'hanmeimei', '123456', 2);
INSERT INTO `lb_user` VALUES (4, 'lilei', '123456', 2);
INSERT INTO `lb_user` VALUES (5, 'haoyi', '123456', 3);
INSERT INTO `lb_user` VALUES (6, 'liyiyi', '123456', 3);
INSERT INTO `lb_user` VALUES (7, 'zhangxiaoxiao', '123456', 3);
INSERT INTO `lb_user` VALUES (8, 'wumei', '123456', 3);
INSERT INTO `lb_user` VALUES (9, 'nini', '123456', 3);
INSERT INTO `lb_user` VALUES (10, 'admin3', '123456', 1);
INSERT INTO `lb_user` VALUES (11, 'admin4', '123456', 1);
INSERT INTO `lb_user` VALUES (12, 'zhaozhi', '12345', 2);
INSERT INTO `lb_user` VALUES (14, 'admin5', '123456', 1);
INSERT INTO `lb_user` VALUES (15, 'admin6', '123456', 1);
INSERT INTO `lb_user` VALUES (17, 'wangwu', '123456', 2);
INSERT INTO `lb_user` VALUES (18, 'yanglijuan', '123456', 2);
INSERT INTO `lb_user` VALUES (19, 'sunzhi', '123456', 3);
INSERT INTO `lb_user` VALUES (20, 'wangyiyi', '123456', 2);
INSERT INTO `lb_user` VALUES (24, 'tony', '1', 1);
INSERT INTO `lb_user` VALUES (26, 'wangxiao2', '1', 3);
INSERT INTO `lb_user` VALUES (27, 'xiaoniu', '123123', 2);
INSERT INTO `lb_user` VALUES (29, 'lxx', '123', 1);
INSERT INTO `lb_user` VALUES (32, 'lm', '123', 3);
INSERT INTO `lb_user` VALUES (36, 'wm', '123', 3);
INSERT INTO `lb_user` VALUES (41, 'rest', '123', 2);

SET FOREIGN_KEY_CHECKS = 1;

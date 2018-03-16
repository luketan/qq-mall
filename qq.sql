/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : qq

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-17 18:00:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c_admin
-- ----------------------------
DROP TABLE IF EXISTS `c_admin`;
CREATE TABLE `c_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `login_name` varchar(32) NOT NULL COMMENT '登录名称',
  `user_name` varchar(10) DEFAULT NULL COMMENT '真实名称',
  `password` varchar(64) DEFAULT NULL COMMENT '登录密码',
  `solt` varchar(32) DEFAULT NULL COMMENT '密码加盐',
  `telephone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `is_active` bit(1) DEFAULT NULL COMMENT '是否可用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `c_admin_login_name_uindex` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of c_admin
-- ----------------------------
INSERT INTO `c_admin` VALUES ('1', 'admin', 'amdin', '14e1b600b1fd579f47433b88e8d85291', null, '', '', '2017-05-19 15:59:44', '2017-05-22 01:22:41');

-- ----------------------------
-- Table structure for c_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `c_admin_role`;
CREATE TABLE `c_admin_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(12) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `c_user_role_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of c_admin_role
-- ----------------------------
INSERT INTO `c_admin_role` VALUES ('2', '1', '1');
INSERT INTO `c_admin_role` VALUES ('3', '1', '2');

-- ----------------------------
-- Table structure for c_role
-- ----------------------------
DROP TABLE IF EXISTS `c_role`;
CREATE TABLE `c_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `type` int(11) DEFAULT NULL COMMENT '关联系统',
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `c_role_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of c_role
-- ----------------------------
INSERT INTO `c_role` VALUES ('1', '1', 'admin', '超级管理员');
INSERT INTO `c_role` VALUES ('2', '1', 'manager', '系统管理员');
INSERT INTO `c_role` VALUES ('3', '1', 'saler', '销售人员');

-- ----------------------------
-- Table structure for c_role_security
-- ----------------------------
DROP TABLE IF EXISTS `c_role_security`;
CREATE TABLE `c_role_security` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `security_id` int(11) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `c_role_security_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

-- ----------------------------
-- Records of c_role_security
-- ----------------------------
INSERT INTO `c_role_security` VALUES ('1', '1', '1');
INSERT INTO `c_role_security` VALUES ('2', '1', '2');
INSERT INTO `c_role_security` VALUES ('3', '1', '3');
INSERT INTO `c_role_security` VALUES ('4', '1', '4');
INSERT INTO `c_role_security` VALUES ('5', '1', '5');
INSERT INTO `c_role_security` VALUES ('6', '1', '6');
INSERT INTO `c_role_security` VALUES ('7', '1', '7');
INSERT INTO `c_role_security` VALUES ('8', '1', '8');
INSERT INTO `c_role_security` VALUES ('9', '1', '9');
INSERT INTO `c_role_security` VALUES ('10', '1', '10');
INSERT INTO `c_role_security` VALUES ('11', '1', '11');
INSERT INTO `c_role_security` VALUES ('12', '1', '12');
INSERT INTO `c_role_security` VALUES ('13', '1', '13');
INSERT INTO `c_role_security` VALUES ('14', '1', '14');
INSERT INTO `c_role_security` VALUES ('15', '1', '15');
INSERT INTO `c_role_security` VALUES ('16', '1', '16');

-- ----------------------------
-- Table structure for c_security
-- ----------------------------
DROP TABLE IF EXISTS `c_security`;
CREATE TABLE `c_security` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点ID',
  `type` int(11) DEFAULT NULL COMMENT '权限类型(1.后台管理,2.商户管理)',
  `name` varchar(32) DEFAULT NULL COMMENT '权限名称',
  `code` varchar(32) DEFAULT NULL COMMENT '权限编码',
  `description` varchar(255) DEFAULT NULL COMMENT '权限说明',
  PRIMARY KEY (`id`),
  UNIQUE KEY `c_security_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='系统权限表';

-- ----------------------------
-- Records of c_security
-- ----------------------------
INSERT INTO `c_security` VALUES ('1', '0', '1', '系统', 'root', null);
INSERT INTO `c_security` VALUES ('2', '1', '1', '系统设置', 'system', null);
INSERT INTO `c_security` VALUES ('3', '1', '1', '商品管理', 'goods', null);
INSERT INTO `c_security` VALUES ('4', '1', '1', '订单管理', 'order', null);
INSERT INTO `c_security` VALUES ('5', '1', '1', '系统权限', 'security', null);
INSERT INTO `c_security` VALUES ('6', '1', '1', '管理员管理', 'admin', null);
INSERT INTO `c_security` VALUES ('7', '1', '1', '优惠券', 'coupon', null);
INSERT INTO `c_security` VALUES ('8', '1', '1', '用户反馈', 'feeBack', null);
INSERT INTO `c_security` VALUES ('9', '1', '1', '商品活动', 'goodsActivity', null);
INSERT INTO `c_security` VALUES ('10', '1', '1', '商品标签', 'goodsTag', null);
INSERT INTO `c_security` VALUES ('11', '1', '1', '商品品牌', 'goodsBrand', null);
INSERT INTO `c_security` VALUES ('12', '1', '1', '商品类型', 'goodsType', null);
INSERT INTO `c_security` VALUES ('13', '1', '1', '商品子类型', 'goodsSubType', null);
INSERT INTO `c_security` VALUES ('14', '1', '1', '快递公司管理', 'post', null);
INSERT INTO `c_security` VALUES ('15', '1', '1', '社区类型', 'societyType', null);
INSERT INTO `c_security` VALUES ('16', '1', '1', '社区子类型', 'societySubType', '');

-- ----------------------------
-- Table structure for tbl_wxmp_config
-- ----------------------------
DROP TABLE IF EXISTS `tbl_wxmp_config`;
CREATE TABLE `tbl_wxmp_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `appid` varchar(64) DEFAULT NULL,
  `appsecret` varchar(256) DEFAULT NULL,
  `token` varchar(2048) DEFAULT NULL,
  `baseHost` varchar(1024) DEFAULT NULL,
  `expDate` datetime DEFAULT NULL,
  `needJsTicket` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tbl_wxmp_config_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_wxmp_config
-- ----------------------------
INSERT INTO `tbl_wxmp_config` VALUES ('1', 'zbgj', 'wxd673003a72114833', 'c2204615efaf6a177a5aea198cd9ff39', '5Xm1oEacEe3-hRem05nQnucLco6dtZZLlPY0uABvyTppJijmdosmL3xcUrqdJIczhmtW8ScQLeMJp6nqwAcwAVOlgGcTDcg0Dvle7zCARR6OGA2SucwdUFHvv8wWwdiFKVUjACAVGF', 'www.honglinktech.com', '2017-09-17 18:30:00', '1');

-- ----------------------------
-- Table structure for tbl_wxmp_jsticket
-- ----------------------------
DROP TABLE IF EXISTS `tbl_wxmp_jsticket`;
CREATE TABLE `tbl_wxmp_jsticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `jsTicket` varchar(2048) DEFAULT NULL,
  `expDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tbl_wxmp_jsticket_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_wxmp_jsticket
-- ----------------------------
INSERT INTO `tbl_wxmp_jsticket` VALUES ('1', 'zbgj', 'sM4AOVdWfPE4DxkXGEs8VFLqAP_WT--B3XfZ0fN6hxWtcdpKW4ja35W_PX813e6K5rHEJeTFcGlkwhGQExEW2Q', '2017-09-17 18:30:00');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1');
INSERT INTO `test` VALUES ('2');

-- ----------------------------
-- Table structure for t_change_log
-- ----------------------------
DROP TABLE IF EXISTS `t_change_log`;
CREATE TABLE `t_change_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
  `object_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '记录对象Id(商品Id，帖子Id)',
  `type` int(5) unsigned NOT NULL DEFAULT '0' COMMENT '记录类型(1:虚拟币virtual_money,2:钱money,3:商城积分point，4社区经验exp，5社区级别le)',
  `log_type` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '日志类型()',
  `before_num` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '变更前的数量',
  `num` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '变更数量数目',
  `curr_num` decimal(10,0) unsigned NOT NULL DEFAULT '0' COMMENT '变更后的数量',
  `comments` varchar(500) NOT NULL DEFAULT '' COMMENT '变更批注',
  `create_time` timestamp NULL DEFAULT '1970-01-01 12:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_team_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='变更变更日志[逗比、经验、vip]  注意分表';

-- ----------------------------
-- Records of t_change_log
-- ----------------------------
INSERT INTO `t_change_log` VALUES ('1', '1', '0', '2', '2', '20.00', '-10', '10', '论坛帖子置顶', '2016-10-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('2', '1', '0', '2', '2', '10.00', '1', '11', '论坛帖子点赞', '2016-10-02 12:00:00');
INSERT INTO `t_change_log` VALUES ('3', '1', '0', '2', '2', '11.00', '1', '12', '论坛帖子点赞', '2016-10-03 12:00:00');
INSERT INTO `t_change_log` VALUES ('4', '1', '0', '2', '2', '12.00', '1', '13', '论坛帖子点赞', '2016-10-04 12:00:00');
INSERT INTO `t_change_log` VALUES ('5', '1', '0', '2', '2', '13.00', '1', '14', '论坛帖子点赞', '2016-10-05 12:00:00');
INSERT INTO `t_change_log` VALUES ('6', '1', '0', '2', '2', '14.00', '1', '15', '论坛帖子点赞', '2016-10-06 12:00:00');
INSERT INTO `t_change_log` VALUES ('7', '1', '0', '2', '2', '15.00', '1', '16', '论坛帖子点赞', '2016-10-07 12:00:00');
INSERT INTO `t_change_log` VALUES ('8', '1', '0', '2', '2', '16.00', '1', '17', '论坛帖子点赞', '2016-10-08 12:00:00');
INSERT INTO `t_change_log` VALUES ('9', '1', '0', '2', '2', '17.00', '1', '18', '论坛帖子点赞', '2016-10-09 12:00:00');
INSERT INTO `t_change_log` VALUES ('10', '1', '0', '2', '2', '18.00', '1', '19', '论坛帖子点赞', '2016-10-10 12:00:00');
INSERT INTO `t_change_log` VALUES ('11', '1', '0', '2', '2', '19.00', '1', '20', '论坛帖子点赞', '2016-10-11 12:00:00');
INSERT INTO `t_change_log` VALUES ('12', '1', '0', '2', '2', '20.00', '1', '21', '论坛帖子点赞', '2016-10-12 12:00:00');
INSERT INTO `t_change_log` VALUES ('13', '1', '0', '2', '0', '0.00', '0', '0', '', '1970-01-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('14', '1', '0', '2', '0', '0.00', '0', '0', '', '1970-01-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('15', '1', '0', '2', '0', '0.00', '0', '0', '', '1970-01-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('16', '1', '0', '2', '0', '0.00', '0', '0', '', '1970-01-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('17', '1', '0', '2', '0', '0.00', '0', '0', '', '1970-01-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('18', '1', '0', '2', '0', '0.00', '0', '0', '', '1970-01-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('19', '1', '0', '2', '0', '0.00', '0', '0', '', '1970-01-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('20', '1', '0', '2', '0', '0.00', '0', '0', '', '1970-01-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('21', '1', '0', '2', '0', '0.00', '0', '0', '', '1970-01-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('22', '1', '0', '2', '0', '0.00', '0', '0', '', '1970-01-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('23', '1', '0', '2', '0', '0.00', '0', '0', '', '1970-01-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('24', '1', '0', '2', '0', '0.00', '0', '0', '', '1970-01-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('25', '1', '0', '1', '1', '2.00', '5', '6', '充值', '1970-01-01 12:00:00');
INSERT INTO `t_change_log` VALUES ('26', '1', '0', '3', '1', '1.00', '4', '5', '积分赚了', '1970-01-01 12:00:00');

-- ----------------------------
-- Table structure for t_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_coupon`;
CREATE TABLE `t_coupon` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `condition` varchar(255) DEFAULT NULL COMMENT '条件文本',
  `detail` varchar(255) DEFAULT NULL COMMENT '详情',
  `goods_type` int(1) DEFAULT '0' COMMENT '条件商品类型ID',
  `max` int(11) DEFAULT '0' COMMENT '条件满多少可以用',
  `value` int(10) DEFAULT '0',
  `start_date` date DEFAULT NULL COMMENT '开始时间',
  `end_date` date DEFAULT NULL COMMENT '结束时间',
  `status` int(1) DEFAULT '1' COMMENT '状态（1是有效,2是无效）',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='优惠券';

-- ----------------------------
-- Records of t_coupon
-- ----------------------------
INSERT INTO `t_coupon` VALUES ('1', '女用玩具专用', '满99元可以用', null, '1003', '99', '10', '2016-10-09', '2016-12-30', null, '2016-10-10 20:35:18', '2016-11-20 16:20:45');
INSERT INTO `t_coupon` VALUES ('2', '全场适用', '无门槛券', null, '0', '0', '5', '2016-09-22', '2016-12-31', null, '2016-10-10 20:35:52', '2016-11-20 16:20:58');
INSERT INTO `t_coupon` VALUES ('3', '女用玩具专用', '满99元可以用', null, '1003', '99', '10', '2016-09-01', '2016-10-01', null, '1979-01-01 01:00:00', '2016-11-20 16:21:11');
INSERT INTO `t_coupon` VALUES ('4', '全场适用', '无门槛券', null, '0', '0', '8', '2016-11-03', '2016-11-26', null, '1979-01-01 01:00:00', '2016-11-20 16:21:00');

-- ----------------------------
-- Table structure for t_coupon_user
-- ----------------------------
DROP TABLE IF EXISTS `t_coupon_user`;
CREATE TABLE `t_coupon_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `coupon_id` int(10) NOT NULL COMMENT '券ID',
  `checked` int(1) DEFAULT '0' COMMENT '是否已经选中',
  `code` varchar(255) DEFAULT NULL COMMENT '唯一识别码',
  `status` int(1) DEFAULT '0' COMMENT '状态(0未使用，1是已使用)',
  `use_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '使用时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_coupon_user
-- ----------------------------
INSERT INTO `t_coupon_user` VALUES ('1', '1', '1', null, null, '0', null, null, '2016-10-10 21:00:00');
INSERT INTO `t_coupon_user` VALUES ('4', '1', '4', null, null, '1', null, null, '1979-01-01 01:00:00');
INSERT INTO `t_coupon_user` VALUES ('5', '1', '2', null, null, '0', null, null, '1979-01-01 01:00:00');
INSERT INTO `t_coupon_user` VALUES ('6', '1', '3', null, null, '0', null, null, '1979-01-01 01:00:00');

-- ----------------------------
-- Table structure for t_feed_back
-- ----------------------------
DROP TABLE IF EXISTS `t_feed_back`;
CREATE TABLE `t_feed_back` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '反馈ID',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `detail` varchar(225) DEFAULT NULL COMMENT '反馈详情',
  `reply` varchar(225) DEFAULT NULL COMMENT '系统回复',
  `reply_time` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  `read_is` int(1) DEFAULT '0' COMMENT '是否已读',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户反馈表';

-- ----------------------------
-- Records of t_feed_back
-- ----------------------------
INSERT INTO `t_feed_back` VALUES ('1', '1', '粉红色的粉红色的发送看见对方好几十块地方', '就复读阿女分局后发货死哦答复哦is大姐夫史蒂芬交水电费说的飞', '2016-10-14 00:15:22', '0', '2016-10-16 01:58:23', '2016-10-13 23:32:34');
INSERT INTO `t_feed_back` VALUES ('2', '1', '东方雨虹是丢放烟花', null, null, '0', '2016-10-16 01:57:56', '2016-10-14 23:32:34');
INSERT INTO `t_feed_back` VALUES ('3', '1', '欧hi偶然菩提突然', null, null, '0', '2016-10-16 01:57:59', '2016-10-14 01:55:47');
INSERT INTO `t_feed_back` VALUES ('4', '1', '个囧耳朵内部分都不叫偶if都不记得发金币欧迪芬', null, null, '0', '2016-10-16 01:58:12', '2016-10-15 06:25:35');

-- ----------------------------
-- Table structure for t_format
-- ----------------------------
DROP TABLE IF EXISTS `t_format`;
CREATE TABLE `t_format` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `goods_id` int(12) DEFAULT NULL COMMENT '产品ID',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `need_price` int(2) DEFAULT '0' COMMENT '是否可选样式价格',
  `sort` int(6) DEFAULT NULL COMMENT '排序',
  `delete_flag` tinyint(2) DEFAULT '0',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='产品款式';

-- ----------------------------
-- Records of t_format
-- ----------------------------
INSERT INTO `t_format` VALUES ('16', '10001', '工艺', '1', null, '0', '1979-01-01 01:00:00', '2016-11-02 00:30:49');
INSERT INTO `t_format` VALUES ('17', '10001', '材质', '0', null, '0', '1979-01-01 01:00:00', '2016-11-01 22:19:43');
INSERT INTO `t_format` VALUES ('18', '10001', '成色', '0', null, '0', '1979-01-01 01:00:00', '2016-10-27 01:37:21');
INSERT INTO `t_format` VALUES ('19', '10001', '规格', '0', null, '0', '1979-01-01 01:00:00', '2016-10-26 22:55:19');
INSERT INTO `t_format` VALUES ('20', '10001', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('21', '10002', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('22', '10017', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('23', '10018', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('24', '10019', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('25', '10020', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('26', '10021', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('27', '10022', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('28', '10024', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('29', '10025', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('30', '10026', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('31', '10027', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('32', '10028', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('33', '10030', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('34', '10031', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('35', '10031', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('36', '10032', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('37', '10032', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('38', '10033', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');
INSERT INTO `t_format` VALUES ('39', '10034', '规格', '0', null, '0', '2016-11-01 23:26:13', '2016-11-01 23:26:13');

-- ----------------------------
-- Table structure for t_format_sub
-- ----------------------------
DROP TABLE IF EXISTS `t_format_sub`;
CREATE TABLE `t_format_sub` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `format_id` int(12) NOT NULL COMMENT '规格ID',
  `format_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '费用',
  `vip_price` decimal(10,2) DEFAULT '0.00' COMMENT 'vip费用',
  `select` int(2) DEFAULT '1' COMMENT '是否可选',
  `args` varchar(128) DEFAULT NULL COMMENT '系数',
  `delete_flag` int(2) DEFAULT '0' COMMENT '删除标志',
  `sort` int(6) DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COMMENT='规格种类';

-- ----------------------------
-- Records of t_format_sub
-- ----------------------------
INSERT INTO `t_format_sub` VALUES ('31', '16', null, '光滑', '12.00', '0.00', '0', null, '1', null, '1979-01-01 01:00:00', '2016-11-02 00:31:03');
INSERT INTO `t_format_sub` VALUES ('32', '16', null, '抛光', '14.00', '0.00', '1', null, '1', null, '1979-01-01 01:00:00', '2016-11-02 00:31:04');
INSERT INTO `t_format_sub` VALUES ('33', '16', null, '磨砂', '17.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-02 00:31:06');
INSERT INTO `t_format_sub` VALUES ('34', '17', null, 'AU999', '1.50', '1.20', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('35', '17', null, 'AU9999', '1.80', '1.50', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-01 22:19:50');
INSERT INTO `t_format_sub` VALUES ('36', '18', null, '红色', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('37', '18', null, '黑色', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('38', '18', null, '褐色', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('39', '19', null, '玫红色（肚兜+系带T裤）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-01 23:37:51');
INSERT INTO `t_format_sub` VALUES ('40', '19', null, '大红色（肚兜+系带T裤）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('41', '20', null, '大红色（肚兜+系带T裤）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-01 23:32:15');
INSERT INTO `t_format_sub` VALUES ('42', '21', null, '大红色（肚兜+系带T裤）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-01 23:33:14');
INSERT INTO `t_format_sub` VALUES ('43', '22', null, '大红色（肚兜+系带T裤）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-01 23:33:37');
INSERT INTO `t_format_sub` VALUES ('44', '23', null, '大红色（肚兜+系带T裤）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-01 23:34:11');
INSERT INTO `t_format_sub` VALUES ('45', '24', null, '2件特惠（黑色+紫色）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-01 23:35:36');
INSERT INTO `t_format_sub` VALUES ('46', '25', null, '2件特惠（黑色+紫色）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('47', '26', null, '大红色（肚兜+系带T裤）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('48', '27', null, '玫红色（肚兜+系带T裤）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('49', '28', null, '大红色（肚兜+系带T裤）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-01 23:36:43');
INSERT INTO `t_format_sub` VALUES ('50', '29', null, '大红色（肚兜+系带T裤）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('51', '30', null, '大红色（肚兜+系带T裤）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('52', '31', null, '大红色（肚兜+系带T裤）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-01 23:37:36');
INSERT INTO `t_format_sub` VALUES ('53', '32', null, '大红色（肚兜+系带T裤）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('54', '33', null, '黑色', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-01 23:38:40');
INSERT INTO `t_format_sub` VALUES ('55', '34', null, '黑色', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('56', '35', null, '加1元送白色网衣', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('57', '36', null, '四合一+珍珠内裤', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('58', '37', null, '经典四合一24只', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('59', '38', null, '12只（热感）', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_format_sub` VALUES ('60', '39', null, 'BKK智能飞机杯', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-01 23:41:04');
INSERT INTO `t_format_sub` VALUES ('61', '39', null, '加12元购220ML润滑油', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-01 23:44:29');
INSERT INTO `t_format_sub` VALUES ('62', '39', null, '加15元购冈本套7只装', '0.00', '0.00', '1', null, '0', null, '1979-01-01 01:00:00', '2016-11-01 23:44:31');

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '商品名称',
  `sub_name` varchar(255) DEFAULT NULL COMMENT '子标题（提醒）',
  `detail` text COMMENT '商品详情',
  `sales_num` int(10) unsigned DEFAULT '0' COMMENT '售出数量',
  `keep_num` int(10) unsigned DEFAULT '0' COMMENT '库存数量',
  `mark_price` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '市场价',
  `former_price` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '原价',
  `price` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '现在价格',
  `discuss_num` int(10) unsigned DEFAULT '0' COMMENT '评论数量',
  `promo_name` varchar(225) DEFAULT NULL COMMENT '促销名字',
  `promo_price` decimal(10,2) unsigned zerofill DEFAULT NULL COMMENT '促销价',
  `promo_is` int(1) unsigned zerofill DEFAULT '0' COMMENT '是否促销',
  `hot_is` int(1) DEFAULT '0' COMMENT '是否热卖',
  `gifts_is` int(1) DEFAULT '0' COMMENT '是否是精品',
  `brand_id` int(10) DEFAULT NULL COMMENT '品牌ID',
  `brand_name` varchar(128) DEFAULT NULL COMMENT '品牌名称',
  `type_id` int(10) DEFAULT NULL COMMENT '类别ID',
  `type_name` varchar(128) DEFAULT NULL COMMENT '类别名称',
  `type_sub_id` int(10) DEFAULT NULL COMMENT '子类别(款式)ID',
  `type_sub_name` varchar(128) DEFAULT NULL COMMENT '子类别(款式)名称',
  `collect_num` int(10) DEFAULT '0' COMMENT '收藏数量',
  `status` int(11) DEFAULT '1' COMMENT '商品状态（1正常,2已售完，3已下架,4删除，5待审核）',
  `img_url` varchar(225) DEFAULT NULL COMMENT '主图路径',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10035 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('10001', '霏慕 中国古典肚兜性感挂脖绑带情趣诱惑肚兜T裤 2件套', '456', '<p><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/30978ef34c830ae7a2f514818ff39873.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/529f24aa8f4dc9e9b9b6a603534c1679.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/502ef6601f8fed8d47b3381dac4e83b8.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/c757d94279f0ef334f5a5628c25807b8.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/4d342531d5cfd0a84037dd68fab7994b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/8929b706b50aa7689ccdab526a96286d.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/3698d54a0ac0972c0ed0a61272205186.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/5b663be08086739652110c355bf1d7de.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/f67315463609cff0d824037a62997916.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/0b80314b4ec2a3778e89d664193928e8.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/2c1a527a8dc13543791c5876820da7d4.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/cbee8f76129bd2864bc9b1b6033afdf8.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/c83af12aa518e3458b5b966fbcecb6f6.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/337d135ca3004acca5e3b29b0a746117.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/a7010bd95e93fd228c108666b72fe1eb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/1823cc84d955735d580756c2974f60a2.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/68c7f047ba2e3aaa87c33fcb5610dec5.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/08f91a6b6558b635a760ff2c26b5f510.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/427d623f8a251cd45798b7c4fb4db938.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/d4acf8310ee439ba321182cdfa3ffd3e.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '100', '100', '49.00', '29.00', '19.00', '449', null, '00000000.00', '0', '1', '1', '37', 'Selebritee', '1001', '情趣内衣', '1', '睡裙睡袍', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/866976864088af42f9014313d06bbf77.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 16:25:44', '2016-01-19 01:16:08');
INSERT INTO `t_goods` VALUES ('10010', '久慕雅黛 古典复古和服风深V开衩短裙日式情趣内衣', null, '<p><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/3c21b28b145f9f75930c07a706e410ec.jpg\" /><img alt=\"短裙内衣\" src=\"http://mallimg01.touchcdn.com/third/a0c038062b1f0cd334bcbea2a793f940.jpg\" /><img alt=\"浪漫和服 \" src=\"http://mallimg01.touchcdn.com/third/36a667d64f5182364cc7eec413f98ff2.jpg\" /><img alt=\"复古新娘装\" src=\"http://mallimg01.touchcdn.com/third/c760dd96d0e7429396ce38bb69a59585.jpg\" /><img alt=\"久慕雅黛\" src=\"http://mallimg01.touchcdn.com/third/0f085cc3b4dfacbdedc72d0986073f1d.jpg\" /><img alt=\"情趣内衣\" src=\"http://mallimg01.touchcdn.com/third/e9ae674ee2dc503b5f042ac5cc191830.jpg\" /><img alt=\"性感睡衣\" src=\"http://mallimg01.touchcdn.com/third/73c8e278c3a2b34952702a554f686328.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/086450a388991fad49a671a0aadf52eb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/139d6862fa4ac3b87ddfff50dd383691.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/1612b50e644a4df41e30868dbce98dcc.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/a4ae87dd19b5114208fc8cc49ea35664.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/2a254cf19836d40b75634d218a4b3968.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/cf56b29c96530b23c02100ac751b9590.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f359a59179ddcd9c3bde365363fde85f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/b652ebc3be6bea72c3daa75207b0da1b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f90ad29c9b3ed3d4b626b7f891e3120b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/a85354059037746f46b57cd9ebefe835.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/6d585819e426680a9cfb5c983a38a7e9.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/3f7d95dbc4dbfbbb2c67042d4ca58d0d.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/7dbd40818c6b12fbcfc3519b1528ed72.jpg\" /></p>\n\n<p><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/d99cf42792b27ba11e9165cbd4477c3f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/a0f87d0c46189ac066f0e2c6a1a76d9a.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/c4968a5dc192b332b31228aa2d4fe79b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/94f8b70efb9ff55223679bbd13ca7398.jpg\" /></p>\n\n<p><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '129.00', '129.00', '59.00', '0', null, '00000000.00', '0', '1', '1', '33', '久慕雅黛', '1001', '情趣内衣', '1', '睡裙睡袍', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/e2d09b3577f70bcbf769bca6666c3c43.jpg?imageView/2/w/416/interlace/1', '1', '2016-10-21 02:18:35', '2016-03-20 01:55:40');
INSERT INTO `t_goods` VALUES ('10011', '性感日式印花和服宽松深V蝴蝶结复古和服风东京美娘款', null, '<p><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/dda87a916a70d882f73c0f1995edfbab.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/d29a8661fce1859689e1b646c412fe01.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/09ed9425e95eb9e38f03ea4218582d9a.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/1fb8fc4ee3b38520b4699665480ebf7b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/eb948b3099bb7d111e38b684ff3bf56b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/be67640335f0210db6532fd02cce0461.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/6ee1c1a4e4d400d60e97dad837f7cdaf.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/079821295b34ec56f29b74ea338a954f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/9cde6ab5cd0705424dfb78a50b8ff3d0.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/c282753da1abeb896b03ac9343dadbf2.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/2799cc468f217be17e6f910fdc7f190f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/1a301f3784da16aaa44cdce60f0a5cff.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/b624163ec811fa7797f9a703a39ed378.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/cb962e4a086337474c5360cc9287511b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/411d050a060b9be745ae608c449f8aaa.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/140014d065aabcb1aec370ffdcc558f4.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/63c1518c9ac419246efdffa39ce04a58.jpg\" />&nbsp;<img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/b544c73ac643d57db22b9462bbad978c.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '59.00', '59.00', '29.00', '0', null, '00000000.00', '0', '1', '1', '33', '久慕雅黛', '1001', '情趣内衣', '1', '睡裙睡袍', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/0e65fea48479e7da41432b9bb774bca0.jpg?imageView/2/w/416/interlace/1', '2', '2016-10-21 02:18:36', '2016-03-20 02:30:30');
INSERT INTO `t_goods` VALUES ('10012', '古典高档绣花年年有鱼喜庆露乳性感肚兜 2件套', null, '<p><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f80377df6b74e46e88f35d8de7dbe309.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/5588eb37e59db78062f4436a16381c65.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/4789f149d74f757947df2865f1201bfc.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/82cd5abe322061ee8bdadbe03d511fc6.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/af949eebb80732705f1e402cd3ef69ea.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/766400e3288935c6c650a0a56f98593e.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/76e5be5fc60eda488b7a4ea5d798fa5f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/8e37815d9db14fe13ed83737904a2f00.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/4b14ce102b33fb50d57bdc6f05eb17bf.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/b7a3f6da7a9c619c510fde0fb936364f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/9b4d477a70d3eef24ca27e45dc1a5a06.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f35da9df32760bc5b6da629b8f6efaea.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/81d975ec635892486ecb86ff1cebf958.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f4a0353266229179ba3badb893e40ad2.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/455aebe2c47462e1a55a4d59e7469322.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/ad8b18217bb4b9dd0d4ccc8600a19708.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/eb280bd020e418e27ec31a33627d852b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/67904293019533ef199a4725b99d32fc.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/603c36c4a79585db382569e231ad5ffb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/65bd39a45aa10c7dae69789f5122d9a9.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/da00500dfce8832802399614ce41da2e.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/a5a8bfe161f2aa59a49ce3629df3f01b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/5577748937897ab236b2b37f64c3d981.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f644f9d460f79c87327c51b59310b1c1.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/d6ddb238ca9bf123357c8fc9bf5e355d.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/ec85c75149c33a8a8639f297fe3b098c.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '50.00', '50.00', '25.00', '0', null, '00000000.00', '0', '0', '0', '33', '久慕雅黛', '1001', '情趣内衣', '1', '睡裙睡袍', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/b75134196cccd1a6fc88c1bfe2627b43.jpg?imageView/2/w/416/interlace/1', '3', '2016-10-21 02:18:38', '2016-03-20 02:51:35');
INSERT INTO `t_goods` VALUES ('10013', '日式和服开襟三点式绑带缎面印花和服套装 3件套', null, '<p><strong>为了满足大家的需求，现在已经有升级版的出炉了哦~升级版和原版的款式是相同的，只是面料和做工上有比较大的提升！ 面料更柔软，印花更逼真，做工更精细！ 为了掳获那个他，喜欢的MM赶紧下手哦！</strong></p>\n\n<p>&nbsp;</p>\n\n<p><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/72ba3eb9110e7f1b5949969b95aa9f10.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/103a0b59d6abe848581bbc71e6c41595.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/13e498a85d70600bf4aafc48dbbabd51.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/3c9b43d50561f91997fc0984a4587103.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/bdd59995ad97f2cdcb2508d88ab59821.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/6b7cbe45697be1de8d92d1770b5afdde.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/ce353190ad1992dcdb14db4564610f5b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/53a292e6f9d1e8475701968242440656.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/4ad70d216b0df841378173c898eb28dc.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/e253fbcc3451dd08e09d4aa33cd184ed.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/3f256e640e61e9959dff42647b960067.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/ad0bf2bf310f502ea740ab3552e758a0.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/ff7280f5528ff9661a48ceefd134e202.jpg\" /></p>\n\n<p><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '99.00', '99.00', '39.00', '0', null, '00000000.00', '0', '0', '0', '33', '久慕雅黛', '1001', '情趣内衣', '1', '睡裙睡袍', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/625edf645a7c9e04ff8ef24555eb3179.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 15:23:44', '2016-03-20 02:55:18');
INSERT INTO `t_goods` VALUES ('10014', '制服诱惑日系和服性感开襟深V包臀蝴蝶结和服 3件套', null, '<p><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/345bb204c6aa2e4d0aab047e17f70ea6.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/361fa9f35bee7e2f5db88ee113f4488e.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/9ffdb6cbfc857e34e1999e95b0194461.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/70573f6663454c8bb15b9c616e10d20b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/022dbe7c5729d31ed819b2d38abc5931.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/277401776bb6d3f006422c97c361677c.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/a74360d8a03366f94a6783b6aed60b29.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/67cea5648ea32fe673f92482af6521bf.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/32cc6ebe77014cdc6e969cb92297ed23.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/2a0c8e6876ef4cfcc8c8716bd8703dd2.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/0d8526da1274883071cc739469ada733.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '59.00', '59.00', '29.00', '0', null, '00000000.00', '0', '1', '1', '33', '久慕雅黛', '1001', '情趣内衣', '1', '睡裙睡袍', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/c1db41303a5eee78c6a162907b7abbbb.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 02:59:14', '2016-03-20 02:57:58');
INSERT INTO `t_goods` VALUES ('10015', 'EVO二代加温火焰无线充电遥控加热恒温跳蛋', null, '<p><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/28650c1bfe62bd77b57315d1e6a79316.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/73f2f542232f4ba9a22497bb51799d7c.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/82eaba9b2563253b70a68dbd2ef3aa91.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/ef572892b959210a50b15406e72739c8.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/317e457d5c3349b48227d85859c0f193.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/2c39b4c22f1c9c32730f597c47a02d59.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/39bc2f1c2866fbaa513072700194db83.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/b4607a420a1fc3ac77d468c866552f65.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/2b9204cddbb27ac37391c8a40cd28e31.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/ddd929b6e4e8d844b68fcf971bd42cfb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/a07395801eee186d2da17bc99bbdf482.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/e05b63961f044d473022671ca8c61c25.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/d6ed133567e6c59e1d136bad6e57fa46.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/d6e8073975504621d787237537b72e16.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/cec3b7e00495582d4e8d4b99359677fb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/4fda4228a953fd742548081aeac319a3.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/dc4fbed539d0cd4e5726d82290b09ff6.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/e84878c70cb093299d788532dde20c5f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/6ad05c99ba90bd4a57157e16225606d6.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/34e616a50af6034eef332d101ba956ae.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/04638d7256e22c0d4b60c5927b6211c6.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/445987bf80d7e15726b43812498ca4f7.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/5d56e623c09462cf4633bace18f024e8.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '280.00', '280.00', '168.00', '0', null, '00000000.00', '0', '0', '0', '36', '维多利亚的秘密', '1003', '女用玩具', '22', '情趣跳蛋', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/cb5c8464c08fea2958a9a44fb6378585.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 15:24:05', '2016-03-20 11:55:06');
INSERT INTO `t_goods` VALUES ('10016', '【包邮】雷霆炫动AV震动棒 女性G点刺激', null, '<p><img alt=\"雷霆炫动AV震动棒产品简介\" src=\"http://mallimg01.touchcdn.com/third/8a6f7b3e256a2ce0d654eafa6fb4377b.jpg\" /><img alt=\"产品特点解析\" src=\"http://mallimg01.touchcdn.com/third/5286498f09b3a82ae727ead74345cbed.jpg\" /><img alt=\"市面上代表性产品比较\" src=\"http://mallimg01.touchcdn.com/third/9ac7c7dbbe5aeee0e3e51328be58896a.jpg\" /><img alt=\"最好玩的AV棒之100种玩法\" src=\"http://mallimg01.touchcdn.com/third/bdb4a55cb5cf5d0e8605644b7b5bef3c.jpg\" /><img alt=\"最好玩的AV棒之1.6倍强劲动力\" src=\"http://mallimg01.touchcdn.com/third/68e91c0c88229e7cde1be7bae1ae0d3e.jpg\" /><img alt=\"最好玩的AV棒之专用百变头套\" src=\"http://mallimg01.touchcdn.com/third/43ac46b94a686defeda7cc49accb1834.jpg\" /><img alt=\"最好玩的AV棒之全防水\" src=\"http://mallimg01.touchcdn.com/third/08db274200a66608036159f14e1aeaad.jpg\" /><img alt=\"最好玩的AV棒之时尚造型\" src=\"http://mallimg01.touchcdn.com/third/1d8671cc20d24279a8acec3995ba0fac.jpg\" /><img alt=\"最好玩的AV棒之不震手人AV棒\" src=\"http://mallimg01.touchcdn.com/third/17e4b43a9eb9bfa13a7b86afeedb2893.jpg\" /><img alt=\"实拍细节展示\" src=\"http://mallimg01.touchcdn.com/third/1daf3f848694b817146234dcf55c9c90.jpg\" /><img alt=\"三种颜色可选\" src=\"http://mallimg01.touchcdn.com/third/8a93c558b54fff150195afc60e1e863f.jpg\" /><img alt=\"实拍细节展示1\" src=\"http://mallimg01.touchcdn.com/third/516bd02b4a082b1f7bf53928a9311093.jpg\" /><img alt=\"实拍细节展示2\" src=\"http://mallimg01.touchcdn.com/third/2ba6b9b8fd6fa7d5ac8ade3dc80a194b.jpg\" /><img alt=\"实拍细节展示3\" src=\"http://mallimg01.touchcdn.com/third/ae50272327be004549d01c8d49a74f42.jpg\" /><img alt=\"实拍细节展示4\" src=\"http://mallimg01.touchcdn.com/third/2fde337fb1c38762650e2655b498cd9d.jpg\" /><img alt=\"包装和颜色\" src=\"http://mallimg01.touchcdn.com/third/54b4107d213289981aa8e9ae0821385c.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/ebfa401d8101c8753952dc949f5e44bf.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/b080c164325d505dcead3cfe485977b6.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '158.00', '158.00', '79.00', '0', null, '00000000.00', '0', '0', '0', '36', '维多利亚的秘密', '1003', '女用玩具', '19', 'AV棒', '0', '1', 'http://mallimg01.touchcdn.com/gallery/TB2RsohcFXXXXakXXXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 15:25:47', '2016-03-20 11:57:52');
INSERT INTO `t_goods` VALUES ('10017', '【包邮】品色伸缩转珠震动按摩AV棒', '女主播倾力推荐，最好玩的AV棒！', '<p><img alt=\"雷霆炫动AV震动棒产品简介\" src=\"http://mallimg01.touchcdn.com/third/8a6f7b3e256a2ce0d654eafa6fb4377b.jpg\" /><img alt=\"产品特点解析\" src=\"http://mallimg01.touchcdn.com/third/5286498f09b3a82ae727ead74345cbed.jpg\" /><img alt=\"市面上代表性产品比较\" src=\"http://mallimg01.touchcdn.com/third/9ac7c7dbbe5aeee0e3e51328be58896a.jpg\" /><img alt=\"最好玩的AV棒之100种玩法\" src=\"http://mallimg01.touchcdn.com/third/bdb4a55cb5cf5d0e8605644b7b5bef3c.jpg\" /><img alt=\"最好玩的AV棒之1.6倍强劲动力\" src=\"http://mallimg01.touchcdn.com/third/68e91c0c88229e7cde1be7bae1ae0d3e.jpg\" /><img alt=\"最好玩的AV棒之专用百变头套\" src=\"http://mallimg01.touchcdn.com/third/43ac46b94a686defeda7cc49accb1834.jpg\" /><img alt=\"最好玩的AV棒之全防水\" src=\"http://mallimg01.touchcdn.com/third/08db274200a66608036159f14e1aeaad.jpg\" /><img alt=\"最好玩的AV棒之时尚造型\" src=\"http://mallimg01.touchcdn.com/third/1d8671cc20d24279a8acec3995ba0fac.jpg\" /><img alt=\"最好玩的AV棒之不震手人AV棒\" src=\"http://mallimg01.touchcdn.com/third/17e4b43a9eb9bfa13a7b86afeedb2893.jpg\" /><img alt=\"实拍细节展示\" src=\"http://mallimg01.touchcdn.com/third/1daf3f848694b817146234dcf55c9c90.jpg\" /><img alt=\"三种颜色可选\" src=\"http://mallimg01.touchcdn.com/third/8a93c558b54fff150195afc60e1e863f.jpg\" /><img alt=\"实拍细节展示1\" src=\"http://mallimg01.touchcdn.com/third/516bd02b4a082b1f7bf53928a9311093.jpg\" /><img alt=\"实拍细节展示2\" src=\"http://mallimg01.touchcdn.com/third/2ba6b9b8fd6fa7d5ac8ade3dc80a194b.jpg\" /><img alt=\"实拍细节展示3\" src=\"http://mallimg01.touchcdn.com/third/ae50272327be004549d01c8d49a74f42.jpg\" /><img alt=\"实拍细节展示4\" src=\"http://mallimg01.touchcdn.com/third/2fde337fb1c38762650e2655b498cd9d.jpg\" /><img alt=\"包装和颜色\" src=\"http://mallimg01.touchcdn.com/third/54b4107d213289981aa8e9ae0821385c.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/ebfa401d8101c8753952dc949f5e44bf.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/b080c164325d505dcead3cfe485977b6.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '148.00', '148.00', '79.00', '0', null, '00000000.00', '0', '0', '0', '36', '维多利亚的秘密', '1003', '女用玩具', '21', '转珠棒', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/0ff07592e560f8d86f35486eeda10e63.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 12:00:53', '2016-03-20 12:00:37');
INSERT INTO `t_goods` VALUES ('10018', '阿芙拉G点妖精10变频模式震动棒', null, '<p><img alt=\"精准刺激G点妖精30度棒头弯曲轻而易举的集中G点\" src=\"http://mallimg01.touchcdn.com/third/82d9e70f11ddca11c20e2675c462b1ce.jpg\" /><img alt=\"女人最爱时尚妖精\" src=\"http://mallimg01.touchcdn.com/third/b62a5c642493070e7d4b93bee5088ab2.jpg\" /><img alt=\"精准刺激G点冲击\" src=\"http://mallimg01.touchcdn.com/third/4b0c49d7782a7fcd55b31512875bc8ca.jpg\" /><img alt=\"十段变频丰富刺激\" src=\"http://mallimg01.touchcdn.com/third/e0425cbee22b58cef6813bbe66fc019a.jpg\" /><img alt=\"G点妖精振动棒带来狂潮激越的超HIGH体验\" src=\"http://mallimg01.touchcdn.com/third/4bdbca3fa4e688fb4d668b43569b63b9.jpg\" /><img alt=\"小巧玲珑的娇美身段多重流行元素融入外形设计\" src=\"http://mallimg01.touchcdn.com/third/4796d0c8fa847ae756f7e5117ec6f217.jpg\" /><img alt=\"拥有时而激越轻柔急促迟缓灵动变幻的\" src=\"http://mallimg01.touchcdn.com/third/564c36b0f647cc11b0d1cd66a38d4ff0.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/6d62ba33cea49ca422ef29942c83d052.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/3a2e4f187fce53820545009b822d5105.jpg\" /><img alt=\"超低静音静在快乐深处\" src=\"http://mallimg01.touchcdn.com/third/20dd466d0636de990ccdeb1a40f42a8d.jpg\" /><img alt=\"亲肤纯厚硅胶柔滑舒适\" src=\"http://mallimg01.touchcdn.com/third/1add8307f15adc4d90553911bdd153d7.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/7b35f17eba809035faf3053f45c7e636.jpg\" /><img alt=\"强劲动力轻松锁定G点高潮\" src=\"http://mallimg01.touchcdn.com/third/1df4097603ca02e0f13adb325af5d6d1.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/15e30e4e4f0fbd3ce990944405452369.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/4772f721da7867dbb9f1e78285000a28.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/cc9d27faf3af294aca71db9cb10c6738.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/3e8d1ef7194a72707972fabed315fa08.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/4d21a363caf3dc1f7361fb8ba6a94310.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/d8595e99139e2cd08714b72c365e74ad.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/4fc1f6fad55dc8460f26f1ffacf18ff5.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/8fbc036abe0c6d96e8b1bcec61f59c3b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/5057938529a56f6a37e06feb6ff8b7e5.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/e994017b6fafd44b94895b4f90eaaae4.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/ed6dc9c105079d95eb2034fd90a3f587.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/706d2508c6d5c4dfb3b65c4fd6c18ce2.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '69.00', '108.00', '69.00', '0', null, '00000000.00', '0', '0', '0', '0', '', '1003', '女用玩具', '20', 'G点刺激', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/284c2430c41f248460fe123125210438.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 12:20:53', '2016-03-20 12:04:00');
INSERT INTO `t_goods` VALUES ('10019', '【买1送2】纯情女仆女佣装分体露乳制服 3件套', '【制服有礼·特惠活动】爆款情趣制服限时送进口BK指甲油+陌陌水蜜桃味避孕套2只装！！活动时间：3.17-3.25！！礼品数量有限，送完即止哦~', '<p><img alt=\"体验师\" src=\"http://mallimg01.touchcdn.com/goods/fa4fefe552ecde1d8c361b0a694bd5db.jpg\" /><img alt=\"导购秀\" src=\"http://mallimg01.touchcdn.com/intro/TB2.6aLcpXXXXXjXpXXXXXXXXXX468359490.jpg\" /><img alt=\"产品信息\" src=\"http://mallimg01.touchcdn.com/intro/TB2pog.bVXXXXaBXpXXXXXXXXXX468359490.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/c647b8ae1cd639695dd86a113a046c45.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/7266c8c1f6613616754a2bcbb485dd68.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/c5d30a6e1735458c13854099e99e6712.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/756b7136fc43bff24d3996f3e3343066.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f57fd844862f91139f5cd54073166c9b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/9d0ec369d3417d4272d59c3a623bc22a.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/3b9a7eacbcd991d75f1e540ea06bd3df.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f7757db0e743da2455d6ea136035bcc5.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/15b659cb034cdba9364c02c7dc42c021.jpg\" /><img alt=\"女仆女佣装制服分体露乳\" src=\"http://mallimg01.touchcdn.com/third/e22d51c98f2a452dfcb434d478aed039.jpg\" /><img alt=\"纯情四件装 蓝粉两色 霏慕\" src=\"http://mallimg01.touchcdn.com/third/5d5c21ec19a7bf64509623d55d2e206e.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/28e34d92824b27fe9124948d52db54c0.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/fb0151712497d9c5d9f812dccdcd6124.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/7652d5d5194f90a6168b2e947767a007.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/fea036bf5feb3a92f99682323b176d74.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/cf982978666040680af607c833b8d266.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/16ec482ae39dc363dae8baab770655e3.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/24f60a90d2fdb212d2f668e6b210f558.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/bfc33802751cc9d7f58555e2c9c245bc.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/bfe7c974496fdc131da1b8127ede11b0.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/1d8f6c161fd842fdfd8e3f6e68c30e05.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/0762c5e40a54c6a31ddafa46168f5a77.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/e3c0c2c8c979ff79579a0cc77e690122.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/23768724228f4b77d68d5312e9d9b228.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/5ef73bae2d931407654c245ac6db4c51.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/89f5acd5ff1a4b37b799bb68c812fdae.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/1e8ff5687e35433ae5e91c4cd145ebb9.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/177a4c08bf313546644521202e315e23.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/c9e2ee3bafb0d9a426f426c19a3ff246.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/intro/TB2.Y4ecXXXXXbHXXXXXXXXXXXX468359490.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/intro/TB2XoBgcXXXXXaXXXXXXXXXXXXX468359490.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/intro/TB2SwJbcXXXXXcQXXXXXXXXXXXX468359490.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/intro/TB2eRRhcXXXXXXEXXXXXXXXXXXX468359490.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/intro/TB2AxAbVXXXXa2XpXXXXXXXXXX468359490.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '89.00', '89.00', '35.00', '0', null, '00000000.00', '0', '0', '0', '33', '久慕雅黛', '1001', '情趣内衣', '2', '制服扮演', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/2b4634844cbac41c89cb3d6d60f2e96b.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 15:29:08', '2016-03-20 12:05:41');
INSERT INTO `t_goods` VALUES ('10020', '印花豹纹无痕冰丝一片式性感防走光舒适透气情趣内裤', null, '<p><img alt=\"印花豹纹无痕\" src=\"http://mallimg01.touchcdn.com/third/fd3227902ced5dc98ef1bcc4cc1717cc.jpg\" /><img alt=\"冰丝一片式\" src=\"http://mallimg01.touchcdn.com/third/d4e1347462d1e7501fbd4cfb9fa7f682.jpg\" /><img alt=\"性感防走光\" src=\"http://mallimg01.touchcdn.com/third/3a70c937cdfab41a7559df4cfe8fe8f6.jpg\" /><img alt=\"舒适透气情趣内裤\" src=\"http://mallimg01.touchcdn.com/third/d4ac7bdcd8256aa4c3a818ad6be69384.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/227d25fd5daffd6a7e59b9fa74c219e7.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/88d95285d570010b16f67d879137a6db.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/e7789610ebd5c4a971aef64ff34f49eb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/322623905be45e833a0ff83635ba3074.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/7698a7b0ce1be093f31266aba1a46b80.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/86495455d1070111be41abb19de1a55e.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/0be7eca92b7dfe4ef923829a31eb396a.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/39437ebadbd0bddb08d04764f6e01aa2.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/d7b618e3c4a0cf68ab5f58389eedc62c.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/88dcfcc3d2246be946b9dcd68fe5f07b.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '58.00', '58.00', '29.00', '0', null, '00000000.00', '0', '0', '0', '0', '', '1001', '情趣内衣', '6', '女士内裤', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/fad231cc46a6370394305b348f90cb81.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 12:20:05', '2016-03-20 12:07:54');
INSERT INTO `t_goods` VALUES ('10021', '【买1送2】护士装 深V紧身性感大露背小护士装制服扮演', '【制服有礼·特惠活动】爆款情趣制服限时送进口BK指甲油+陌陌水蜜桃味避孕套2只装！！活动时间：3.17-3.25！！礼品数量有限，送完即止哦~', '<p><img alt=\"深V紧身后格挖空露背\" src=\"http://mallimg01.touchcdn.com/third/4195830ccb1a7e67ae459acdbb4bf8f1.jpg\" /><img alt=\"角色扮演小护士装\" src=\"http://mallimg01.touchcdn.com/third/a0d93dda73e0675fad0bf79b48ee127a.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/5fab0a0b3ef93e311dc2ceeee0563868.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/a9b57654dffd67dde034b00a09e7d1c8.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/9c0747ecd4daa0433861ec7e747b2423.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/a873f888464f53e2cabb3fe2cf418805.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/d27877e0c39cff97b18bcfa52796fc09.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/abd5da6ab4207ddf622a31cbf8217911.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/2a43f43f009ed8e79bf075ca98fc6792.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/2369fc619af34a3fca4d47a12aca8a5a.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/771d3e3aeb30184103e91d19d42969c4.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/8b19190b747eab676f8891341a563c63.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/339df1aab0b8aabf929e3fcde5a76d21.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/ba7675024969bf8fc8c584030e74a9ea.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/51783266e3bf0ac5c1fa8bf7159a281d.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/1ba61108a7e1ac85eebdc801ed5ec452.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/7809274a29bb7e21028b2bb66ec771b3.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '49.00', '49.00', '19.00', '0', null, '00000000.00', '0', '0', '0', '33', '久慕雅黛', '1001', '情趣内衣', '2', '制服扮演', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/c60834843534de6135db5dd35caf4366.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 15:32:40', '2016-03-20 12:10:41');
INSERT INTO `t_goods` VALUES ('10022', '【买1送2】中国风古典蕾丝柔纱透明旗袍 新婚制服扮演性感睡衣', '【制服有礼·特惠活动】爆款情趣制服限时送进口BK指甲油+陌陌水蜜桃味避孕套2只装！！活动时间：3.17-3.25！！礼品数量有限，送完即止哦~', '<p><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/774010328347bf9ddea8d692b2529109.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/ebc63085358374abe7b41eb866231213.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/8458aac11f474d452a98e68e5fc1acfe.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/e28c4d0b046fecfa2783990b65449547.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/7de7aefaed09164b7d5841779d9f4a96.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/8d2922859920c235fb4ec4d8640b51bc.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/e489b61eba4f67107578baf3a2b624d1.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/276c9748c65224d673be234f4e7a8063.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/a6f4c7b5d26bb826c143150791f35ec9.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/d895a0ffa6e18e4ee424967954f584e0.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/071ec0feaf97e487a42ef5a17502272a.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/63487333ded1eec71820d2514a83c986.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/eb7762f3a0697659e1e38282ba38103e.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/043a8e78d032d804bf53718448c5f0cc.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/013c52967fbc04b7d2602c785b1b6065.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/26251d0cd8f14ea753ab2d0ddfc0fb2a.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/a59d284b979da3decf3f5261e02d5413.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/9b75fd5593e65175e6a91eb07fd75f00.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/4b99c8af22ea9959b1cadb1c57bdfd7b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/f70608de2292ef51333342201b2e07d0.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/bc754c30b7d6bd62726a020bbaccdfe6.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/69366358f225bf034da32d8bede50498.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/94780a703ec3091f2c5116a1df38b6f5.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/345252bebd83398a6b48430f902e5cb7.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/efb9bc4ce5abcf03c7fe8ff52fcc16a8.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/37a879ea98aec10d79932202672f5f3f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/da5567667d5fbe56fe789b91d9dd6ed7.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/21737d09bb37d39c3a6e6c978b3057fd.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/764e2fd913e5d38aa383dda638ea629c.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/1aacc98afd0507ba785fd10dad802e28.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/56a27125c3e07b5e9d54c1f4a078c7fe.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/98db9c003e4fb2ac0a72411b247b34ef.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/7b1755a9959c688b732f2b8ac5e5b08c.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '59.00', '59.00', '29.00', '0', null, '00000000.00', '0', '0', '0', '33', '久慕雅黛', '1001', '情趣内衣', '2', '制服扮演', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/73688eac2b67ef212af124bf52bcbbf4.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 12:19:22', '2016-03-20 12:13:11');
INSERT INTO `t_goods` VALUES ('10023', '【包邮】私享玩趣 桑巴丽影 强力变频防水静音跳蛋', '10种变频，精致小巧，双重震动', '<p>&nbsp;</p>\n\n<p><img alt=\"似梦如幻，让我们一起舞动霓虹\" src=\"http://mallimg01.touchcdn.com/third/5f74dea06f7a23f4998127c07a45fc8a.jpg\" /><img alt=\"私享玩趣 桑巴丽影 强力变频防水静音跳蛋产品参数\" src=\"http://mallimg01.touchcdn.com/third/59dafbfbfc0a4c86fa43c78a379934d4.jpg\" /><img alt=\"设计理念\" src=\"http://mallimg01.touchcdn.com/third/089154b34a9f8cca7328706f8a7887ea.jpg\" /><img alt=\"专为东方女性设计，满足身体的各种愉悦需求\" src=\"http://mallimg01.touchcdn.com/third/fe3f4b1782dded03c127ef24d1e3e7c0.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/4f0bc7fe86017153070dcc369495b560.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/8ba0d988718ea87edcb02dd00339d23e.jpg\" /><img alt=\"台湾情趣热风登陆大陆彼岸\" src=\"http://mallimg01.touchcdn.com/third/7f3fcde247c3e1e309e30672a41f6583.jpg\" /><img alt=\"起源于巴西的桑巴，音乐热情奔放，姿态富有动感舞步，深受人们的钟爱\" src=\"http://mallimg01.touchcdn.com/third/4b2b0d0ef4070b804deb3732c7fc2fa7.jpg\" /><img alt=\"小身材，大作用\" src=\"http://mallimg01.touchcdn.com/third/2faa5b9065222352450546dc1a6fb07f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/a471b2404bb76f84e1f0f79d995d9cc0.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/6a18670644ab00e5af9304d9226b60fd.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/56ab5f97a9ff32dd5277169aed2cdf54.jpg\" /><img alt=\"全身心投入，想按哪就按哪\" src=\"http://mallimg01.touchcdn.com/third/82cdb9fe855d09c7c4205fcab20a266a.jpg\" /><img alt=\"携带方便\" src=\"http://mallimg01.touchcdn.com/third/b7fd57f86ce42d32081161390396191c.jpg\" /><img alt=\"安全材质\" src=\"http://mallimg01.touchcdn.com/third/d92ee5d5e53e0e9a977464eed67e49d2.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/11c1a6721049af210eab4a1a05e84416.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/7e22f1684de926d056fb433789121e8b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/dabb1fcbe4a279182bd5d4d7d42e4934.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/649ae726c6444e77eee2642766c336bb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/ccf43ce3808fd5dc733bb5d7a869c7a6.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/c882b34593649c3961e2f13483f2d9a1.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f5b32d81689e7fbd6963dbbf6261af1d.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f32dd8f0bdb456e312f9d00f52efd3d2.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/d722a56e1b63a251dce7dad755dccda3.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /></p>\n', '0', '100', '99.00', '99.00', '65.00', '0', null, '00000000.00', '0', '0', '0', '30', '尚牌', '1003', '女用玩具', '22', '情趣跳蛋', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/22c56205dc707ef0c4d5505dddc07f79.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 12:17:38', '2016-03-20 12:17:22');
INSERT INTO `t_goods` VALUES ('10024', '诺兰摇情AV棒 高潮静音震动按摩振动棒充电款', '完美尺寸专为东方女性身材打造 随意旋转', '<p><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/22c922132c97398cc84a153b29732935.jpg\" /><img alt=\"摇情震动棒让女人欲罢不能的秘密武器\" src=\"http://mallimg01.touchcdn.com/third/b1b62affcd77928ccc9baf9ebec1f4f0.jpg\" /><img alt=\"女性寂寞诉以谁知\" src=\"http://mallimg01.touchcdn.com/third/b39d9db62705917c34aa721638f800f9.jpg\" /><img alt=\"性爱生活还是那么无趣吗\" src=\"http://mallimg01.touchcdn.com/third/d819dd0e66abd84aee01a37c6602eb22.jpg\" /><img alt=\"简单粗暴没前戏性爱生活毫无情趣\" src=\"http://mallimg01.touchcdn.com/third/57dd4e1e43e46523765def31c6d80e2e.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/6994c036d317c313bf17368ccf19087c.jpg\" /><img alt=\"一体式设计可探入体内\" src=\"http://mallimg01.touchcdn.com/third/1b2cbbbd24cecc5c6f8d194ead1f5f86.jpg\" /><img alt=\"强震马达引爆高潮\" src=\"http://mallimg01.touchcdn.com/third/f8d12a3071ef47a76d2f413c99cf2e80.jpg\" /><img alt=\"智能7频震动模式\" src=\"http://mallimg01.touchcdn.com/third/21919fc036c6a4ec3b2bcc8a3b29189c.jpg\" /><img alt=\"全面防水设计充电孔亦防水\" src=\"http://mallimg01.touchcdn.com/third/55a83a413c83f9dabdbd312a9d8d1ce3.jpg\" /><img alt=\"超静音更安心\" src=\"http://mallimg01.touchcdn.com/third/457dc5226e161fe3945caed8fb4e32a4.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/de388b4e126debe13a57fc99574f480e.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/2f78bd14ec6a9f18758240f7dea75035.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/d55bab586a9f97bdcafda5e382fc8264.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/cfe6b12ad70b8d40f28da0bb5af1c6bc.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/cabaf1381178f4629a9523b9a5bfacaa.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/aa1e9f1ac50ca6a78cf4aae7ffaf1233.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/813ae4c7b172548bae4b88a70f7c58ba.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/e211efb135414aaedb623c181ae59c94.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/778a266caaeab73ddc7495fc75419d3b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/940e3e57ef4b16f2050f28a281babeeb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/6bf5e219d5865446b477acd897ed2145.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/02f2d77c65ed4546e101a165df68b54d.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/51a30be7dc6eea53c0c0b332d95d5211.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/839c9805ee1d7fdd41298a4fef096efa.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/2ebbe16ef109b8e6439fa7929ce62686.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/37f6d4a36d327e6266297819243d3824.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n\n<ul>\n	<li><a href=\"javascript:void(0);\">购物车0</a></li>\n	<li><a href=\"javascript:easemobIM();\">在线客服</a></li>\n	<li>&nbsp;</li>\n	<li>&nbsp;</li>\n	<li>&nbsp;</li>\n</ul>\n', '0', '100', '178.00', '398.00', '178.00', '0', null, '00000000.00', '0', '0', '0', '35', '史黛丝', '1003', '女用玩具', '19', 'AV棒', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/89ba5d2dd2fa7cadf603db8feb06a79b.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 12:28:52', '2016-03-20 12:25:33');
INSERT INTO `t_goods` VALUES ('10025', '艾丝葵 甜蜜习惯 蕾丝刺绣透明网眼丁字开档绑带T裤内裤', null, '<p><img alt=\"艾丝葵 甜蜜习惯\" src=\"http://mallimg01.touchcdn.com/third/25325cd9cd066884541004a4948deac0.jpg\" /><img alt=\" 蕾丝刺绣透明网眼\" src=\"http://mallimg01.touchcdn.com/third/1a5515156c86f4cc87f546000d718d59.jpg\" /><img alt=\"丁字开档绑带T裤内裤\" src=\"http://mallimg01.touchcdn.com/third/b55ffc92f2ef8d990f0111b41cddaad1.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/fb28d00b0cafa8f24092aaee244cdba8.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/32f1321067bdff21b1a7e608e66de33b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/b35852c52343b43024fe0007378cb177.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/e428e44786cca82d53659984b29042cc.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/9f97c4d9fdd5a4e0c3a1d57f08b71c81.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/351fcf38137df1e36283f796217baffa.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/5e43bbb2c5945ff295ae21afc61f4eeb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/c07f62193b050115e739e42d4f29de03.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/0af3b1d0d4c372c791ab570bff07a7db.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/9a2ee8849769ad43e31ee65375820eea.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '59.00', '59.00', '29.00', '0', null, '00000000.00', '0', '0', '0', '34', '好奇蜜斯', '1001', '情趣内衣', '6', '女士内裤', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/130b27b5d38de9d9c1017ed56d02dae7.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 15:33:33', '2016-03-20 12:31:43');
INSERT INTO `t_goods` VALUES ('10026', '针筒式灌肠器 肛门灌肠清洗器 SM调教后庭用品', null, '<p><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/5006113e7f9e0ac729d9cab4bea47031.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f84dd10ba46d587dc2ff7e5bae968292.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/2dfcd9291133df82f710f26d541388fb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/8e845709b2e73154784f60d23a64194e.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '19.00', '29.00', '19.00', '0', null, '00000000.00', '0', '0', '0', '38', '大象', '1007', 'SM玩具', '54', '口塞/肛塞', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/c294f52da9a6e0340fa7b5b867bd717b.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 20:50:02', '2016-03-20 12:35:01');
INSERT INTO `t_goods` VALUES ('10027', '荷兰COB女优签名版震动飞机杯', null, '<p><img alt=\"三维女神娇软来袭\" src=\"http://mallimg01.touchcdn.com/third/4964fe91942d99f5a89cd36c076d81dd.jpg\" /><img alt=\"荷兰COB女优签名版震动飞机杯\" src=\"http://mallimg01.touchcdn.com/third/074e8bb1cb1d4df79d7ce8173cdac814.jpg\" /><img alt=\"小鲜肉混血女优\" src=\"http://mallimg01.touchcdn.com/third/32375b9939b030a58df67d1773ac0438.jpg\" /><img alt=\"女王级混血女优\" src=\"http://mallimg01.touchcdn.com/third/6dc0ceffcc646b2ab55e8bf1384f80b8.jpg\" /><img alt=\"臣服吧男人们\" src=\"http://mallimg01.touchcdn.com/third/5287d554fd5e0d1101ca490cfcbbf8e4.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/1356cef552e0c2992e8f483fb8bda37f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/1199a6b1facf9bc6cf26edc434b0ea5b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/8150c9f27e406e7183cf2035a3e25c23.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/4bf56f146cad637717f866f66c591054.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/664580be6aec35a20409feff44d33649.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/e2c4f7ce46c5f554bfb1c38bbafc6da6.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/e2624f366eb00be43934af045760c0db.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/6b767f9755adc5c70a20e6d5322efd4c.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/a24b8181dd6635d32eae78364014e955.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/9de5766abed76430541f288b77230fb7.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/640f3ba075630bcdebfbf046b94d2c3c.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/49521744d74d465b4ec57644f730955e.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/41da80419d764617cf0306fa086f0d21.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/b38929651d4a60d5226e7ee2f3c9fdd0.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/b58d5d4fc7ce6f3ce86c6a1dbc2fa287.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/bd34ff2d8419f1de652e69b599ddf08a.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/de0c9c6fb9992e076f9ae1b957a8555f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/bce6955c868f37ae5680180da55c3188.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/071590d6a20279c1acb36f165e5779fe.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '99.00', '199.00', '99.00', '0', null, '00000000.00', '0', '0', '0', '35', '史黛丝', '1002', '男用玩具', '0', null, '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/dbdbae49f7d87854578c4cf52f0e5ffd.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 13:09:35', '2016-03-20 13:09:19');
INSERT INTO `t_goods` VALUES ('10028', '诺兰美人鱼蓝牙智能语音震动深喉飞机杯口交版', null, '<p><img alt=\"男用玩具诺兰美人鱼蓝牙智能语音震动深喉飞机杯\" src=\"http://mallimg01.touchcdn.com/third/78a499a0ff8c195d707bcc003dfca042.jpg\" /><img alt=\"美人鱼口爆神器飞机杯\" src=\"http://mallimg01.touchcdn.com/third/a85c2c7b733e249ab2d8abad5b80b6c2.jpg\" /><img alt=\"蓝牙延时专业设计气囊夹吸\" src=\"http://mallimg01.touchcdn.com/third/75deedc7e439d798729a06473b806c4b.jpg\" /><img alt=\"飞机杯强劲多频震动\" src=\"http://mallimg01.touchcdn.com/third/a52cbfd2c7a458a9d86db4365f48d521.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/5f4237b9d8f4fd89776ca1180c5e2979.jpg\" /><img alt=\"延时训练飞机杯\" src=\"http://mallimg01.touchcdn.com/third/5942dff8fa5cc73b5f53c2cb698bce35.jpg\" /><img alt=\"体验真人快感飞机杯\" src=\"http://mallimg01.touchcdn.com/third/1f75bc2c1abf05e6ab28b922906a0470.jpg\" /><img alt=\"模拟真人飞机杯\" src=\"http://mallimg01.touchcdn.com/third/0d949fefcddc6e06190c4ee551019653.jpg\" /><img alt=\"蓝牙互动情趣\" src=\"http://mallimg01.touchcdn.com/third/8b64fe36d59b88fae663756826850f23.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/9ebcb8977fdf139d07a506b734abb7f3.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/c0e7a2c423325cdc7030781b9b2b7342.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/3fba776f605b5cc6b56cd15af946c0da.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f04da4ed06fbd5e71933693ac27de0ac.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/2f01db24cd4537d7d07109a6460e6a19.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/5f4614d9e00d606288c3e15ddcff35e6.jpg\" /><img alt=\"深喉口交飞机杯\" src=\"http://mallimg01.touchcdn.com/third/a9ddf7e2df5dc0ab9a0cec1fc0c4a805.gif\" /><img alt=\"强劲多频震动情趣撸\" src=\"http://mallimg01.touchcdn.com/third/1ffc931eb212b31d62a2c8eb50ba5d1c.gif\" /><img alt=\"蓝牙互动\" src=\"http://mallimg01.touchcdn.com/third/4d4a5ac25ff3eace7f82828304220a02.gif\" /><img alt=\"气囊夹吸\" src=\"http://mallimg01.touchcdn.com/third/00f12d4ce64df6650cae42ab4652a0db.gif\" /><img alt=\"纯硅胶男用\" src=\"http://mallimg01.touchcdn.com/third/0c70a56d4ed2325b3ac47c1057384d45.gif\" /><img alt=\"使用便捷的飞机杯\" src=\"http://mallimg01.touchcdn.com/third/06cc784add5437d96f038350fafd3bf3.gif\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/921b4eae6460485431d6cfe4369dc8d9.gif\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/63b791c84bba4141e919e71f9648ea15.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/dc521e3c64cff8ca0520a18c23b77ff5.gif\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/5139f2c5b50cbfe6c9575292a2fd1287.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/bcd7511ce10fa2d0eaa1e419f051e2b2.gif\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/3da5c672b41bb1d52533e04b092870be.gif\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/5edde0bde9f54184e70bb70175e9a304.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/9ef10ae7c15c2b7e840b8ee3fc95993a.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/0e624afdc2f8efcc858741c365abf60f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/c5652cd978942650f4c79572501e71da.jpg\" /><img alt=\"性感粉色入口\" src=\"http://mallimg01.touchcdn.com/third/6e2351530a6f0b93d9d45bc6dbb4d065.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/98e352d769cbc62660761dc5df2a756d.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/74074629dc11637e1219efe93ce7dd63.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/98b40e744a8d4a22574f1a201f560aad.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/e47c2b88be100a7741527dbe206548ae.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f62ba35588e9543cded043ed27f107ec.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/cfd279045b7fc8733e986fc27881a9bb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/ea0a34183879722098f2e1f2753d7bdf.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/ed48abeca091bd17fa49dde62a2a1fe4.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '836.00', '836.00', '499.00', '0', null, null, '0', '0', '0', '0', null, '1002', '男用玩具', '10', '电动飞机杯', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/4704fb20bc7dae5fe74a1e063fca4556.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 15:08:24', '2016-03-20 15:08:24');
INSERT INTO `t_goods` VALUES ('10029', 'AV女优17岁少女小萝莉双姐妹名器倒模', null, '<p><img alt=\"AV女优17岁少女小萝莉双姐妹名器倒模\" src=\"http://mallimg01.touchcdn.com/third/7f4ed81bddc9851101bc0b739175ceae.jpg\" /><img alt=\"上付熟女名器\" src=\"http://mallimg01.touchcdn.com/third/3f2650583d6cb43e757ebe95c073f918.jpg\" /><img alt=\"下付处女名器\" src=\"http://mallimg01.touchcdn.com/third/9209a5c1c87600b5392f3b017eca691b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/79d0672331f6aec8c94ec93ecfdf75cb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/0e3b06a8563f9c08b42a049b15dfcf16.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/c9dfafc11b222ebb54f5663d5c3b6634.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/37412c82615b896fd1ab4856e69a7584.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '88.00', '88.00', '39.00', '0', null, null, '0', '0', '0', '30', '尚牌', '1002', '男用玩具', '12', '名器倒模', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/2bb05b248e64ce3c79d3537bba3f26e3.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 15:10:17', '2016-03-20 15:10:17');
INSERT INTO `t_goods` VALUES ('10030', '性感露乳露背 网纱透明裸色花仙子女仆装', null, '<p><img alt=\"均码裸色100%聚酯纤维\" src=\"http://mallimg01.touchcdn.com/third/a95ebdaf4956bbef4d0fa235da59b222.jpg\" /><img alt=\"露背网纱透明\" src=\"http://mallimg01.touchcdn.com/third/0cb2e1a0d50d98517992b3e0fdf89a8e.jpg\" /><img alt=\"裸色花仙子大码女仆装\" src=\"http://mallimg01.touchcdn.com/third/832f72f587fa84b9f6d888df34ddc865.jpg\" /><img alt=\"私诱\" src=\"http://mallimg01.touchcdn.com/third/952d88fa5832a23696830eecd63c3d46.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/0455e0089761f8a9141732a40aef7c3d.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/8ab1c323ca70bad762a696e1d7305833.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/e3a5e1b0d8650c96cccce9f6c551953f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/f164bba300ac404949e3b3d6170713a7.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/c5427ff371d86d6d0b79403d0176471f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/d01ddecb0428360704d5f8a43bb3376f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/80371b67419b96abaa5aa9e44a841e7b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/d3bd8b58e3a983d0f854ada3f4722246.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/3dce330e6b7ee4caeaedcc7377777f0a.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/0c7aa8192bc3c52559a6134545523478.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/c22bf41861974ad1080d628cea6b9897.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/990d6aa4423d46995edaa705a3682992.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/411d050a060b9be745ae608c449f8aaa.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/140014d065aabcb1aec370ffdcc558f4.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/63c1518c9ac419246efdffa39ce04a58.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/b544c73ac643d57db22b9462bbad978c.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '129.00', '129.00', '59.00', '0', null, null, '0', '0', '0', '35', '史黛丝', '1001', '情趣内衣', '2', '制服扮演', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/49984b72781c0d0b1b18c89ee318d07b.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 20:01:28', '2016-03-20 20:01:28');
INSERT INTO `t_goods` VALUES ('10031', '丝质格纹开档提花连身袜 两色 selebritee', null, '<p><img alt=\"单间开档连身袜，基本信息\" src=\"http://mallimg01.touchcdn.com/third/b9415740385eaa237920f0e9f4c6a8fb.jpg\" /><img alt=\"性感神秘，是多数人都青眯颜色，总能最融洽地配合，简洁之至，却极具诱惑力\" src=\"http://mallimg01.touchcdn.com/third/163b6d8c4e050e4060a75bc8ce2feecf.jpg\" /><img alt=\"菱格显瘦设计，精美细节，品质生活\" src=\"http://mallimg01.touchcdn.com/third/7cc9bce87eaa6e1961700891727cf46e.jpg\" /><img alt=\"玫瑰花朵设计\" src=\"http://mallimg01.touchcdn.com/third/8f14e998bdb009a062f9e02c48d758cd.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/6864aba6a7253c9e7b0193466ae4c907.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/df2c84496fdabd207ae0676656651575.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/2ab83503a1b9bdc9c442be9a7d0068c8.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/d5e0edc5f43ed91c711808c5dd408748.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/ecc9babd135fafd6bc106d71da1c7834.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/7f646343479bd1208c9e49df6c8f150d.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/7abaf290de8205d032aa75370332b92f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/9fd7fda33d604f4e11191bf5cf98c7a9.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/8b6652dca552d334a466a9102ea4ec24.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/6735fcbdf8accb0afbc6aa32535371e9.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/a613577175836068bfb40cc050d68ea4.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '119.00', '119.00', '49.00', '0', null, null, '0', '0', '0', '0', null, '1001', '情趣内衣', '0', null, '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/02f98b01062aeab43ed3016039ca578c.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 20:14:30', '2016-03-20 20:14:30');
INSERT INTO `t_goods` VALUES ('10032', '【包邮】杜蕾斯经典四合一 24只装避孕套', '2015年度爆款情趣套套，年度最强爆款！加10元得珍珠内裤需拍下对应款式！！！', '<p><img alt=\"1次选择4种享受\" src=\"http://mallimg01.touchcdn.com/third/9aadae02b56a96682e5540fe2dd3f89f.jpg\" /><img alt=\"杜蕾斯只为追求性福的你\" src=\"http://mallimg01.touchcdn.com/third/0a8d3f490045a887794861f68de0a74a.jpg\" /><img alt=\"经典设计和谐自然\" src=\"http://mallimg01.touchcdn.com/third/b509efe8ef0b2f17add82981480dca46.jpg\" /><img alt=\"润滑避孕安全呵护\" src=\"http://mallimg01.touchcdn.com/third/427425370f924b498f21fa3af0093eea.jpg\" /><img alt=\"卓越品质优质可靠\" src=\"http://mallimg01.touchcdn.com/third/c39c49a865eccb94f45004192b5614d4.jpg\" /><img alt=\"产品质量好是基础性价比高才是王道\" src=\"http://mallimg01.touchcdn.com/third/d87d7a463ea98abbe9c4ee2e337e1a7c.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/42276d0b4b9da71841321cbc831b31bb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/562ae04678bdfc71c346863612ee1f16.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/710dfaa491899fcc4237874df2f9ef3b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/a02c0586b2b9a0e973d483d694c5cdab.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/3d64a13dc6c4df93227ca3da166199eb.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/854b5ca17adf0f7c3308638fe23a648f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/eb568eacd57739eeb54c68addcc8954d.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/b2e63eb922f1b97e8d5fa12886e72b0c.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/6e840e6d7f67e896a7a736b9a829ce20.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/c13f0c82f44860df22204a72d41e8150.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/453fae04898229ea5c0fb1adc9d27e0b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/d9a447dc143a8e06e35726f5191ffc9c.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '69.00', '69.00', '39.00', '0', null, null, '0', '0', '0', '0', null, '1004', '避孕套', '32', '超值组合', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/be760b80bcd4067931b8ce7d4f5430f9.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 20:29:18', '2016-03-20 20:29:18');
INSERT INTO `t_goods` VALUES ('10033', '【新品】LULU 噜噜 003超薄避孕套 热感激情装12只', null, '<p><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/680e729aa81e4e14919731feb6e96fc0.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/481a6b12c00b3ee5a798a37c788a80c5.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/90c363ba4de9591cdad294ea9d02599e.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/97479f888733f9d24c2ca4e414187a5c.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/5c2da0cec9b2af0e5668b8e2f23e3e54.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/621d03dfba9d9ebf95ab082913cb743b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/16ecce11c7f6edd372aaf090ce233b51.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/14328bbc40518f7737489aac93829598.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/5cc6e6bbd0f8d767b35c89dfc67121ac.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/587eb76faea5cf97b95388aa67e48364.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/b8cb350468ef1f5c72bf7e1c221a48a1.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/6f437716b903a80bb6d218563c6e2497.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/32fabafda6a6d51e74e7e17745811790.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/5a17573c0bca40240bdeca4068cb094f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/b5e7caba0d2a16df3a0a9b33628f842a.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/f2270f5f12dc7b716f5a41228f50f2b6.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/85a08463e1358971dfffe7fc99a41557.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/4183d9dd33413e9e3981095f9af83316.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/82f4b9fe7ca29422f65099721bc5ce85.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/3908e426453796684c6d8d8c8cc851a3.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/24f593691338d2776c93a1e9193a813c.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/4bd4d82edc6585632159fd6ab0fd9c92.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/a8db30bd3e899bc85969114a50f13210.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/7b6bdf3eb45b0b72b20ddf14ff0d2b4d.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/e8f66cbb86a4d7504119c3663b3e4342.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/goods/604315bf645a46abbbd0bee1e545daea.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n', '0', '100', '41.00', '41.00', '29.00', '0', null, '00000000.00', '0', '0', '0', '28', '杜蕾斯', '1004', '避孕套', '32', '超值组合', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/f6031e0efdb9d15cbacb07b572a77073.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 20:40:58', '2016-03-20 20:33:42');
INSERT INTO `t_goods` VALUES ('10034', 'BKK智能飞机杯智能人机互动自慰杯虚拟现实3D场景', null, '<p><img alt=\"倍克贝克虚拟现实飞机杯\" src=\"http://mallimg01.touchcdn.com/third/80e53113aff2c16e8553b88a626adaa3.jpg\" /><img alt=\"颠覆性科技\" src=\"http://mallimg01.touchcdn.com/third/550b9fbeefc89d0631937b75651fad42.jpg\" /><img alt=\"科技改变生活\" src=\"http://mallimg01.touchcdn.com/third/ee667451f169409346f5dbefeb8a0a0a.jpg\" /><img alt=\"VR虚拟现实眼睛\" src=\"http://mallimg01.touchcdn.com/third/b869ff767f479b09b15160791652f955.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/72eac5da1eb0f7c10030a38403449203.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/adb0283361456b20c583d78d4a894d44.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/20e32fe0eec74738ac8c9c718eb80437.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/a0bcb8482e36152ade5af526f8427e47.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/68d0865818a9cb2c44b241962cf324e2.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/0a755055dda38662db0527bef973b198.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/18ef5b075423382cc218ea9289431535.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/db19a2305acad0a32c12931dc2926c2d.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/c05658941075d2e3fffb6a11cefc02e0.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/b0818fd0f81fbce7a6395d0d325519f9.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/e5e652d162c6f7f320b45cbb4dde10c8.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/5ff4c6bef28d70e122cf79fb25331104.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/885a09fa9d0a3a27cad5b964c1f9f6ad.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/0512de638ff772f7b7e46c78761aa025.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/99abef260e7e9525389c88ec6e5a86f0.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/65c8391cd1c212ba88764a25d64f47d1.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/ca9fdaa6a79ffd558f76a1c9d90ab23a.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/473ac676fbfa877464893e5f960e360b.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/96a99093f66d0e02927b560407246e7f.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/97d0e10bb492a4a035ca0f5025fc8195.jpg\" /><img alt=\"\" src=\"http://mallimg01.touchcdn.com/third/582d4d7e494c39fe63268c74e21e647a.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/privacy.jpg\" /><img alt=\"\" src=\"http://static.taqu.cn/img/custom-service.jpg\" /></p>\n\n<ul>\n	<li><a href=\"javascript:void(0);\">购物车0</a></li>\n	<li><a href=\"javascript:easemobIM();\">在线客服</a></li>\n	<li>&nbsp;</li>\n	<li>&nbsp;</li>\n	<li>&nbsp;</li>\n</ul>\n', '0', '100', '998.00', '998.00', '599.00', '0', null, '00000000.00', '0', '0', '0', '32', '进口品牌', '1002', '男用玩具', '10', '电动飞机杯', '0', '1', 'http://mallimg01.touchcdn.com/goods-gallery/fd944f54b22da916e62a79af9d455ab7.jpg?imageView/2/w/416/interlace/1', null, '2016-03-20 20:42:24', '2016-03-20 20:40:41');

-- ----------------------------
-- Table structure for t_goods_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_activity`;
CREATE TABLE `t_goods_activity` (
  `goods_id` int(10) NOT NULL COMMENT '商品ID',
  `activity_id` int(10) NOT NULL COMMENT '活动ID',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`goods_id`,`activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品活动';

-- ----------------------------
-- Records of t_goods_activity
-- ----------------------------
INSERT INTO `t_goods_activity` VALUES ('10001', '1', '2016-03-20 16:25:44', '2016-03-20 16:25:44');
INSERT INTO `t_goods_activity` VALUES ('10001', '2', '2016-03-20 16:25:44', '2016-03-20 16:25:44');
INSERT INTO `t_goods_activity` VALUES ('10001', '3', '2016-03-20 15:22:59', '2016-10-26 23:41:04');
INSERT INTO `t_goods_activity` VALUES ('10001', '4', '2016-03-20 15:22:59', '2016-10-26 23:41:06');
INSERT INTO `t_goods_activity` VALUES ('10001', '6', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_goods_activity` VALUES ('10001', '7', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_goods_activity` VALUES ('10001', '8', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_goods_activity` VALUES ('10011', '4', '2016-03-20 15:23:21', '2016-03-20 15:23:21');
INSERT INTO `t_goods_activity` VALUES ('10012', '1', '2016-03-20 02:52:34', '2016-03-20 02:52:34');
INSERT INTO `t_goods_activity` VALUES ('10012', '4', '2016-03-20 02:52:34', '2016-03-20 02:52:34');
INSERT INTO `t_goods_activity` VALUES ('10013', '1', '2016-03-20 15:23:44', '2016-03-20 15:23:44');
INSERT INTO `t_goods_activity` VALUES ('10013', '4', '2016-03-20 15:23:44', '2016-03-20 15:23:44');
INSERT INTO `t_goods_activity` VALUES ('10014', '1', '2016-03-20 02:59:14', '2016-03-20 02:59:14');
INSERT INTO `t_goods_activity` VALUES ('10014', '4', '2016-03-20 02:59:14', '2016-03-20 02:59:14');
INSERT INTO `t_goods_activity` VALUES ('10015', '1', '2016-03-20 15:24:05', '2016-03-20 15:24:05');
INSERT INTO `t_goods_activity` VALUES ('10015', '5', '2016-03-20 15:24:05', '2016-03-20 15:24:05');
INSERT INTO `t_goods_activity` VALUES ('10016', '3', '2016-03-20 15:25:47', '2016-03-20 15:25:47');
INSERT INTO `t_goods_activity` VALUES ('10017', '1', '2016-03-20 12:00:53', '2016-03-20 12:00:53');
INSERT INTO `t_goods_activity` VALUES ('10017', '4', '2016-03-20 12:00:53', '2016-03-20 12:00:53');
INSERT INTO `t_goods_activity` VALUES ('10018', '4', '2016-03-20 12:20:53', '2016-03-20 12:20:53');
INSERT INTO `t_goods_activity` VALUES ('10019', '3', '2016-03-20 15:29:08', '2016-03-20 15:29:08');
INSERT INTO `t_goods_activity` VALUES ('10019', '5', '2016-03-20 15:29:08', '2016-03-20 15:29:08');
INSERT INTO `t_goods_activity` VALUES ('10020', '4', '2016-03-20 12:20:05', '2016-03-20 12:20:05');
INSERT INTO `t_goods_activity` VALUES ('10020', '5', '2016-03-20 12:20:05', '2016-03-20 12:20:05');
INSERT INTO `t_goods_activity` VALUES ('10021', '1', '2016-03-20 15:32:40', '2016-03-20 15:32:40');
INSERT INTO `t_goods_activity` VALUES ('10021', '5', '2016-03-20 15:32:40', '2016-03-20 15:32:40');
INSERT INTO `t_goods_activity` VALUES ('10022', '4', '2016-03-20 12:19:22', '2016-03-20 12:19:22');
INSERT INTO `t_goods_activity` VALUES ('10022', '5', '2016-03-20 12:19:22', '2016-03-20 12:19:22');
INSERT INTO `t_goods_activity` VALUES ('10023', '3', '2016-03-20 12:17:38', '2016-03-20 12:17:38');
INSERT INTO `t_goods_activity` VALUES ('10024', '3', '2016-03-20 12:28:52', '2016-03-20 12:28:52');
INSERT INTO `t_goods_activity` VALUES ('10025', '1', '2016-03-20 15:33:33', '2016-03-20 15:33:33');
INSERT INTO `t_goods_activity` VALUES ('10026', '1', '2016-03-20 12:35:16', '2016-03-20 12:35:16');
INSERT INTO `t_goods_activity` VALUES ('10027', '4', '2016-03-20 13:09:35', '2016-03-20 13:09:35');
INSERT INTO `t_goods_activity` VALUES ('10028', '3', '2016-03-20 15:08:24', '2016-03-20 15:08:24');
INSERT INTO `t_goods_activity` VALUES ('10032', '3', '2016-03-20 20:29:18', '2016-03-20 20:29:18');
INSERT INTO `t_goods_activity` VALUES ('10033', '3', '2016-03-20 20:40:58', '2016-03-20 20:40:58');
INSERT INTO `t_goods_activity` VALUES ('10034', '3', '2016-03-20 20:42:24', '2016-03-20 20:42:24');

-- ----------------------------
-- Table structure for t_goods_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_brand`;
CREATE TABLE `t_goods_brand` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '品牌ID',
  `name` varchar(225) DEFAULT NULL COMMENT '品牌名称',
  `goods_type` int(10) DEFAULT NULL COMMENT '商品类型',
  `status` int(1) DEFAULT '1' COMMENT '状态(1正常，2删除)',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='商品品牌';

-- ----------------------------
-- Records of t_goods_brand
-- ----------------------------
INSERT INTO `t_goods_brand` VALUES ('28', '杜蕾斯', '1004', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('29', '冈本', '1004', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('30', '尚牌', '1004', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('31', '杰士邦', '1004', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('32', '进口品牌', '1004', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('33', '久慕雅黛', '1001', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('34', '好奇蜜斯', '1001', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('35', '史黛丝', '1001', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('36', '维多利亚的秘密', '1001', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('37', 'Selebritee', '1001', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('27', '大象', '1004', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('26', '名流', '1004', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('40', '日本NPG', '1002', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('41', 'TENGA', '1002', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('42', 'Leten', '1002', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('43', '香港诺兰', '1002', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('44', '迪梦姿', '1002', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('45', 'EVO', '1002', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('46', 'NANO', '1002', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('47', 'LELO', '1003', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('48', '夏奇', '1003', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('49', '蒂贝', '1003', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('50', '爱巢取悦', '1003', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('51', '雷霆', '1003', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('52', '私享玩趣', '1003', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('53', '品色', '1003', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('54', 'NANO', '1003', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('55', '耐氏', '1005', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('56', '藏帝', '1005', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('57', 'ZINI', '1005', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('58', 'MOVO', '1005', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('59', 'KEY', '1005', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('60', 'MOVO', '1006', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('61', 'EROS', '1006', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('62', '阿芙拉', '1006', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('63', 'ZINI', '1006', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('64', '骇客', '1006', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('65', 'EOL', '1006', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('66', 'PJUR', '1006', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('67', '皮克朋', '1007', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('68', '云曼', '1007', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('69', '阿芙拉', '1007', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');
INSERT INTO `t_goods_brand` VALUES ('70', 'TOUGHAGE骇客', '1007', '1', '2016-03-20 23:03:09', '2016-03-20 23:03:09');

-- ----------------------------
-- Table structure for t_goods_dis
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_dis`;
CREATE TABLE `t_goods_dis` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goods_id` int(10) NOT NULL COMMENT '商品ID',
  `user_id` int(10) NOT NULL COMMENT '用户ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `goods_format_id` int(10) DEFAULT NULL COMMENT '商品规格ID',
  `goods_format` varchar(50) DEFAULT NULL COMMENT '商品规格',
  `content` varchar(225) DEFAULT NULL COMMENT '评价内容',
  `reply_time` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  `reply` varchar(225) DEFAULT NULL COMMENT '系统回复',
  `type_value` varchar(5) DEFAULT '00000' COMMENT '评论值(掩码处理：物流，客服，质量）',
  `dis_value` int(1) DEFAULT NULL COMMENT '评论值(1满意，2一般，4不满意,8，16)',
  `img` int(1) DEFAULT '0' COMMENT '是否有图片',
  `good` int(10) DEFAULT '0' COMMENT '点赞',
  `low` int(10) DEFAULT '0' COMMENT '低级评论',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='商品评论表';

-- ----------------------------
-- Records of t_goods_dis
-- ----------------------------
INSERT INTO `t_goods_dis` VALUES ('1', '10001', '1', 'luke', '16', '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', '2016-10-27 23:31:54', '谢谢评价', '00000', '5', '1', '0', '0', '2016-10-27 23:31:54', '2016-10-28 00:05:21');
INSERT INTO `t_goods_dis` VALUES ('2', '10001', '2', 'master', null, '规格:玫红色（肚兜+系带T裤）', '数据库里大放送', null, null, '00000', '1', '1', '0', '0', '2016-10-27 23:31:54', '2016-10-28 00:05:23');
INSERT INTO `t_goods_dis` VALUES ('3', '10001', '3', 'test1', null, '规格:玫红色（肚兜+系带T裤）', '不错v欧派红包熔点高', null, null, '00000', '3', '0', '0', '0', '2016-10-27 23:31:54', '2016-10-28 02:26:59');
INSERT INTO `t_goods_dis` VALUES ('4', '10001', '4', 'test2', null, '规格:玫红色（肚兜+系带T裤）', '很难说好', null, null, '00000', '4', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-28 00:02:40');
INSERT INTO `t_goods_dis` VALUES ('5', '10001', '5', 'test3', null, '规格:玫红色（肚兜+系带T裤）', '一把爸爸', null, null, '00000', '3', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-28 00:03:31');
INSERT INTO `t_goods_dis` VALUES ('6', '10001', '5', 'sdfsd', null, '规格:玫红色（肚兜+系带T裤）', '如何能遇见你', null, null, '00000', '7', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:39:08');
INSERT INTO `t_goods_dis` VALUES ('7', '10001', '6', 'sdfsd', null, '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', null, null, '00000', '5', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:38:11');
INSERT INTO `t_goods_dis` VALUES ('8', '10001', '7', 'fghfrtgh', null, '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', null, null, '00000', '5', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:38:13');
INSERT INTO `t_goods_dis` VALUES ('9', '10001', '8', 'hrtyh', null, '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', null, null, '00000', '5', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:38:15');
INSERT INTO `t_goods_dis` VALUES ('10', '10001', '9', 'bnfgherh', null, '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', null, null, '00000', '5', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:38:17');
INSERT INTO `t_goods_dis` VALUES ('11', '10001', '10', 'gdfger', null, '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', null, null, '00000', '5', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:38:18');
INSERT INTO `t_goods_dis` VALUES ('12', '10001', '11', 'w43rtsgf', null, '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', null, null, '00000', '5', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:38:20');
INSERT INTO `t_goods_dis` VALUES ('13', '10001', '12', 'segewrger', null, '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', null, null, '00000', '5', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:38:22');
INSERT INTO `t_goods_dis` VALUES ('14', '10001', '13', '65u76', null, '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', null, null, '00000', '5', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:38:27');
INSERT INTO `t_goods_dis` VALUES ('15', '10001', '14', 'v34yt54', null, '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', null, null, '00000', '5', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:38:29');
INSERT INTO `t_goods_dis` VALUES ('16', '10001', '15', 'g45y', null, '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', null, null, '00000', '5', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:38:31');
INSERT INTO `t_goods_dis` VALUES ('17', '10001', '16', 'h4yu', null, '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', null, null, '00000', '5', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:38:32');
INSERT INTO `t_goods_dis` VALUES ('18', '10001', '17', 'h45yr', null, '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', null, null, '00000', '5', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:38:33');
INSERT INTO `t_goods_dis` VALUES ('19', '10001', '18', 'yh56uy65', null, '规格:玫红色（肚兜+系带T裤）', '挺好的真的很好', null, null, '00000', '5', '0', '0', '0', '1979-01-01 01:00:00', '2016-10-29 02:38:36');

-- ----------------------------
-- Table structure for t_goods_format
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_format`;
CREATE TABLE `t_goods_format` (
  `goods_id` int(10) NOT NULL COMMENT '商品ID',
  `format_id` int(10) NOT NULL COMMENT '规格ID',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`goods_id`,`format_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品规格';

-- ----------------------------
-- Records of t_goods_format
-- ----------------------------
INSERT INTO `t_goods_format` VALUES ('10001', '2', '2016-03-20 16:25:44', '2016-03-20 16:25:44');
INSERT INTO `t_goods_format` VALUES ('10002', '2', '1979-01-01 01:00:00', '2016-09-20 23:36:03');
INSERT INTO `t_goods_format` VALUES ('10017', '2', '2016-03-20 12:00:53', '2016-03-20 12:00:53');
INSERT INTO `t_goods_format` VALUES ('10018', '2', '2016-03-20 12:20:53', '2016-03-20 12:20:53');
INSERT INTO `t_goods_format` VALUES ('10019', '3', '2016-03-20 15:29:08', '2016-03-20 15:29:08');
INSERT INTO `t_goods_format` VALUES ('10020', '3', '2016-03-20 12:20:05', '2016-03-20 12:20:05');
INSERT INTO `t_goods_format` VALUES ('10021', '2', '2016-03-20 15:32:40', '2016-03-20 15:32:40');
INSERT INTO `t_goods_format` VALUES ('10022', '1', '2016-03-20 12:19:22', '2016-03-20 12:19:22');
INSERT INTO `t_goods_format` VALUES ('10024', '2', '2016-03-20 12:28:52', '2016-03-20 12:28:52');
INSERT INTO `t_goods_format` VALUES ('10025', '2', '2016-03-20 15:33:33', '2016-03-20 15:33:33');
INSERT INTO `t_goods_format` VALUES ('10026', '2', '2016-03-20 12:35:16', '2016-03-20 12:35:16');
INSERT INTO `t_goods_format` VALUES ('10027', '2', '2016-03-20 13:09:35', '2016-03-20 13:09:35');
INSERT INTO `t_goods_format` VALUES ('10028', '2', '2016-03-20 15:08:24', '2016-03-20 15:08:24');
INSERT INTO `t_goods_format` VALUES ('10030', '4', '2016-03-20 20:01:28', '2016-03-20 20:01:28');
INSERT INTO `t_goods_format` VALUES ('10031', '4', '2016-03-20 20:14:30', '2016-03-20 20:14:30');
INSERT INTO `t_goods_format` VALUES ('10031', '5', '2016-03-20 20:14:30', '2016-03-20 20:14:30');
INSERT INTO `t_goods_format` VALUES ('10032', '8', '2016-03-20 20:29:18', '2016-03-20 20:29:18');
INSERT INTO `t_goods_format` VALUES ('10032', '9', '2016-03-20 20:29:18', '2016-03-20 20:29:18');
INSERT INTO `t_goods_format` VALUES ('10033', '10', '2016-03-20 20:40:58', '2016-03-20 20:40:58');
INSERT INTO `t_goods_format` VALUES ('10034', '11', '2016-03-20 20:42:24', '2016-03-20 20:42:24');
INSERT INTO `t_goods_format` VALUES ('10034', '12', '2016-03-20 20:42:24', '2016-03-20 20:42:24');
INSERT INTO `t_goods_format` VALUES ('10034', '13', '2016-03-20 20:42:24', '2016-03-20 20:42:24');

-- ----------------------------
-- Table structure for t_goods_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_tag`;
CREATE TABLE `t_goods_tag` (
  `goods_id` int(10) NOT NULL COMMENT '商品ID',
  `tag_id` int(10) NOT NULL COMMENT '标签ID',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`goods_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品活动';

-- ----------------------------
-- Records of t_goods_tag
-- ----------------------------
INSERT INTO `t_goods_tag` VALUES ('10001', '1', '2016-03-20 16:25:44', '2016-03-20 16:25:44');
INSERT INTO `t_goods_tag` VALUES ('10001', '2', '2016-03-20 16:25:44', '2016-03-20 16:25:44');
INSERT INTO `t_goods_tag` VALUES ('10010', '1', '2016-03-20 15:22:59', '2016-03-20 15:22:59');
INSERT INTO `t_goods_tag` VALUES ('10010', '4', '2016-03-20 15:22:59', '2016-03-20 15:22:59');
INSERT INTO `t_goods_tag` VALUES ('10011', '4', '2016-03-20 15:23:21', '2016-03-20 15:23:21');
INSERT INTO `t_goods_tag` VALUES ('10012', '1', '2016-03-20 02:52:34', '2016-03-20 02:52:34');
INSERT INTO `t_goods_tag` VALUES ('10012', '4', '2016-03-20 02:52:34', '2016-03-20 02:52:34');
INSERT INTO `t_goods_tag` VALUES ('10013', '1', '2016-03-20 15:23:44', '2016-03-20 15:23:44');
INSERT INTO `t_goods_tag` VALUES ('10013', '4', '2016-03-20 15:23:44', '2016-03-20 15:23:44');
INSERT INTO `t_goods_tag` VALUES ('10014', '1', '2016-03-20 02:59:14', '2016-03-20 02:59:14');
INSERT INTO `t_goods_tag` VALUES ('10014', '4', '2016-03-20 02:59:14', '2016-03-20 02:59:14');
INSERT INTO `t_goods_tag` VALUES ('10015', '1', '2016-03-20 15:24:05', '2016-03-20 15:24:05');
INSERT INTO `t_goods_tag` VALUES ('10015', '5', '2016-03-20 15:24:05', '2016-03-20 15:24:05');
INSERT INTO `t_goods_tag` VALUES ('10016', '3', '2016-03-20 15:25:47', '2016-03-20 15:25:47');
INSERT INTO `t_goods_tag` VALUES ('10017', '1', '2016-03-20 12:00:53', '2016-03-20 12:00:53');
INSERT INTO `t_goods_tag` VALUES ('10017', '4', '2016-03-20 12:00:53', '2016-03-20 12:00:53');
INSERT INTO `t_goods_tag` VALUES ('10018', '4', '2016-03-20 12:20:53', '2016-03-20 12:20:53');
INSERT INTO `t_goods_tag` VALUES ('10019', '3', '2016-03-20 15:29:08', '2016-03-20 15:29:08');
INSERT INTO `t_goods_tag` VALUES ('10019', '5', '2016-03-20 15:29:08', '2016-03-20 15:29:08');
INSERT INTO `t_goods_tag` VALUES ('10020', '4', '2016-03-20 12:20:05', '2016-03-20 12:20:05');
INSERT INTO `t_goods_tag` VALUES ('10020', '5', '2016-03-20 12:20:05', '2016-03-20 12:20:05');
INSERT INTO `t_goods_tag` VALUES ('10021', '1', '2016-03-20 15:32:40', '2016-03-20 15:32:40');
INSERT INTO `t_goods_tag` VALUES ('10021', '5', '2016-03-20 15:32:40', '2016-03-20 15:32:40');
INSERT INTO `t_goods_tag` VALUES ('10022', '4', '2016-03-20 12:19:22', '2016-03-20 12:19:22');
INSERT INTO `t_goods_tag` VALUES ('10022', '5', '2016-03-20 12:19:22', '2016-03-20 12:19:22');
INSERT INTO `t_goods_tag` VALUES ('10023', '3', '2016-03-20 12:17:38', '2016-03-20 12:17:38');
INSERT INTO `t_goods_tag` VALUES ('10024', '3', '2016-03-20 12:28:52', '2016-03-20 12:28:52');
INSERT INTO `t_goods_tag` VALUES ('10025', '1', '2016-03-20 15:33:33', '2016-03-20 15:33:33');
INSERT INTO `t_goods_tag` VALUES ('10026', '1', '2016-03-20 12:35:16', '2016-03-20 12:35:16');
INSERT INTO `t_goods_tag` VALUES ('10027', '4', '2016-03-20 13:09:35', '2016-03-20 13:09:35');
INSERT INTO `t_goods_tag` VALUES ('10028', '3', '2016-03-20 15:08:24', '2016-03-20 15:08:24');
INSERT INTO `t_goods_tag` VALUES ('10032', '3', '2016-03-20 20:29:18', '2016-03-20 20:29:18');
INSERT INTO `t_goods_tag` VALUES ('10033', '3', '2016-03-20 20:40:58', '2016-03-20 20:40:58');
INSERT INTO `t_goods_tag` VALUES ('10034', '3', '2016-03-20 20:42:24', '2016-03-20 20:42:24');

-- ----------------------------
-- Table structure for t_goods_type
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_type`;
CREATE TABLE `t_goods_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '类别名称',
  `ico` varchar(32) DEFAULT NULL COMMENT '类型图标',
  `img` varchar(128) DEFAULT NULL COMMENT '类型图片',
  `sort` int(2) DEFAULT '0' COMMENT '排序',
  `summary` varchar(128) DEFAULT NULL,
  `search` varchar(225) DEFAULT NULL,
  `delete_flag` int(1) DEFAULT '0' COMMENT '状态(0正常，1删除)',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8 COMMENT='商品类别表';

-- ----------------------------
-- Records of t_goods_type
-- ----------------------------
INSERT INTO `t_goods_type` VALUES ('1001', '情趣服饰', '&#xe624;', null, '0', '睡裙/制服/网衣/T裤/黑丝/三点式', '[\'1-30\',\'30-60\',\'60-100\',\'100+\']', '0', '2016-10-22 02:54:34', '2016-01-19 00:11:14');
INSERT INTO `t_goods_type` VALUES ('1002', '男用玩具', '&#xe623;', null, '0', '持久锻炼/前列腺/包茎纠正/娃娃', '[\'1-30\',\'30-60\',\'60-100\',\'100+\']', '0', '2016-10-22 02:54:41', '2016-01-19 00:11:12');
INSERT INTO `t_goods_type` VALUES ('1003', '女用玩具', '&#xe605;', null, '0', '跳蚤/缩阴/后庭/三点式', '[\'1-30\',\'30-60\',\'60-100\',\'100+\']', '0', '2016-10-22 02:54:54', '2016-01-19 00:11:12');
INSERT INTO `t_goods_type` VALUES ('1004', '避孕套', '&#xe61d;', null, '0', '杜蕾斯/冈本/超薄/持久/颗粒', '[\'1-30\',\'30-60\',\'60-100\',\'100+\']', '0', '2016-10-22 02:54:58', '2016-01-19 00:13:01');
INSERT INTO `t_goods_type` VALUES ('1005', '延时催情', '&#xe609;', null, '0', '喷剂/私处养护/助情/女同', '[\'1-30\',\'30-60\',\'60-100\',\'100+\']', '0', '2016-10-22 02:55:04', '2016-01-19 00:13:01');
INSERT INTO `t_goods_type` VALUES ('1006', '调情助兴', '&#xe621;', null, '0', '润滑/香水/男同/情趣家具', '[\'1-30\',\'30-60\',\'60-100\',\'100+\']', '0', '2016-10-22 02:55:09', '2016-01-19 00:13:01');
INSERT INTO `t_goods_type` VALUES ('1007', '调教道具', '&#xe622;', null, '0', '套装/捆绑束缚/眼罩/肛塞', '[\'1-30\',\'30-60\',\'60-100\',\'100+\']', '0', '2016-10-22 02:55:19', '2016-01-19 00:13:01');

-- ----------------------------
-- Table structure for t_goods_type_sub
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_type_sub`;
CREATE TABLE `t_goods_type_sub` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) NOT NULL COMMENT '类型名称',
  `goods_type` int(10) DEFAULT NULL COMMENT '商品类型',
  `type_name` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `delete_flag` int(1) DEFAULT '0' COMMENT '删除标志',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='商品款式';

-- ----------------------------
-- Records of t_goods_type_sub
-- ----------------------------
INSERT INTO `t_goods_type_sub` VALUES ('1', '睡裙睡袍', '1001', '情趣内衣', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('2', '制服扮演', '1001', '情趣内衣', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('3', '网衣/连身袜', '1001', '情趣内衣', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('4', '三点/连体衣', '1001', '情趣内衣', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('5', '丝袜吊带袜', '1001', '情趣内衣', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('6', '女士内裤', '1001', '情趣内衣', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('7', '男士内裤', '1001', '情趣内衣', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('8', '马甲束腰', '1001', '情趣内衣', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('9', '情趣配件', '1001', '情趣内衣', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('10', '电动飞机杯', '1002', '男用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('11', '手动飞机杯', '1002', '男用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('12', '名器倒模', '1002', '男用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('13', '增大助勃器', '1002', '男用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('14', '水晶套', '1002', '男用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('15', '缩精环', '1002', '男用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('16', '前列腺按摩', '1002', '男用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('17', '包茎矫正', '1002', '男用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('18', '充气娃娃', '1002', '男用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('19', 'AV棒', '1003', '女用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('20', 'G点刺激', '1003', '女用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('21', '转珠棒', '1003', '女用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('22', '情趣跳蛋', '1003', '女用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('23', '仿真阳具', '1003', '女用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('24', '后庭玩具', '1003', '女用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('25', '缩阴丰胸', '1003', '女用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('26', '女同拉拉', '1003', '女用玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('28', '极致超薄', '1004', '避孕套', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('29', '持久紧绷', '1004', '避孕套', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('30', '加倍润滑', '1004', '避孕套', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('31', '螺纹颗粒', '1004', '避孕套', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('32', '超值组合', '1004', '避孕套', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('33', '原装进口', '1004', '避孕套', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('34', '芳香果味', '1004', '避孕套', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('35', '女性专用', '1004', '避孕套', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('36', '创意套套', '1004', '避孕套', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('37', '延时喷剂', '1005', '延时催情', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('38', '延时湿巾', '1005', '延时催情', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('39', '女用催情', '1005', '延时催情', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('40', '私处养护', '1005', '延时催情', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('41', '消毒清洗', '1005', '延时催情', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('42', '人体润滑液', '1006', '调情助兴', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('43', '口交润滑液', '1006', '调情助兴', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('44', '后庭润滑液', '1006', '调情助兴', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('45', '调情香水', '1006', '调情助兴', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('46', '性爱家具', '1006', '调情助兴', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('47', '个护修养', '1006', '调情助兴', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('48', '情趣礼盒', '1006', '调情助兴', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('49', '调教用具', '1007', 'SM玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('50', 'SM套装', '1007', 'SM玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('51', '捆绑束缚', '1007', 'SM玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('52', '羽毛棒/手拍', '1007', 'SM玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('53', '眼罩', '1007', 'SM玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');
INSERT INTO `t_goods_type_sub` VALUES ('54', '口塞/肛塞', '1007', 'SM玩具', '0', '2016-01-23 18:55:28', '2016-10-22 03:54:49');

-- ----------------------------
-- Table structure for t_g_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_g_activity`;
CREATE TABLE `t_g_activity` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '活动ID',
  `name` varchar(225) NOT NULL COMMENT '活动名称',
  `type` int(10) unsigned zerofill DEFAULT NULL COMMENT '活动类型(1打折,2包邮,3赠送,4满减)',
  `args` varchar(225) DEFAULT NULL COMMENT '活动系数',
  `max` int(11) DEFAULT '0' COMMENT '活动条件满多少可以用',
  `value` int(10) DEFAULT '0' COMMENT '活动值',
  `url` varchar(255) DEFAULT NULL COMMENT '活动链接地址',
  `detail` varchar(225) DEFAULT NULL COMMENT '活动详情',
  `available` int(1) unsigned zerofill DEFAULT '1' COMMENT '是否有时效(0无时效，1有时效)',
  `start_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '开始时间',
  `end_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '结束时间',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态(1正常，2删除)',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='活动';

-- ----------------------------
-- Records of t_g_activity
-- ----------------------------
INSERT INTO `t_g_activity` VALUES ('1', '情趣色子骰子筛子SM用品2粒夫妻情侣游戏惩罚纸牌扑克', '0000000003', null, '0', '0', null, null, '1', '2016-08-01 23:53:30', '2017-01-06 23:53:30', '1', '2016-03-11 23:53:30', '2016-11-08 01:06:34');
INSERT INTO `t_g_activity` VALUES ('2', '备年货满88元包邮', '0000000002', null, '88', '0', null, null, '1', '2016-02-01 23:53:30', '2017-01-06 23:53:30', '1', '2016-03-11 23:53:30', '2016-11-19 03:36:40');
INSERT INTO `t_g_activity` VALUES ('3', '包邮', '0000000002', null, '0', '0', null, null, '1', '2016-03-11 23:52:34', '2017-01-06 23:53:30', '0', '2016-03-11 23:53:30', '2016-11-08 01:06:38');
INSERT INTO `t_g_activity` VALUES ('4', '满99包邮', '0000000002', null, '99', '0', null, null, '0', '2016-08-01 23:53:30', '2017-01-06 23:53:30', '1', '1979-01-01 01:00:00', '2016-11-19 03:37:26');
INSERT INTO `t_g_activity` VALUES ('5', '制服有礼·特惠活动', '0000000003', null, '0', '0', null, '爆款情趣制服限时送进口BK指甲油+陌陌水蜜桃味避孕套2只装！！活动时间：3.17-3.25！！礼品数量有限，送完即止哦~', '1', '2016-10-01 01:00:00', '2017-01-06 23:53:30', '1', '2016-03-20 02:34:45', '2016-11-08 01:06:42');
INSERT INTO `t_g_activity` VALUES ('6', '满59减5', '0000000004', null, '59', '5', null, null, '0', '1979-01-01 01:00:00', '2017-01-06 23:53:30', '1', '1979-01-01 01:00:00', '2016-11-19 03:36:52');
INSERT INTO `t_g_activity` VALUES ('7', '满99减10', '0000000004', null, '99', '10', null, null, '0', '1979-01-01 01:00:00', '2017-01-06 23:53:30', '1', '1979-01-01 01:00:00', '2016-11-19 03:36:57');
INSERT INTO `t_g_activity` VALUES ('8', '满199减20', '0000000004', null, '199', '20', null, null, '0', '1979-01-01 01:00:00', '2017-01-06 23:53:30', '1', '1979-01-01 01:00:00', '2016-11-19 03:37:03');

-- ----------------------------
-- Table structure for t_g_format
-- ----------------------------
DROP TABLE IF EXISTS `t_g_format`;
CREATE TABLE `t_g_format` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) NOT NULL COMMENT '规格名称',
  `goods_type` int(10) DEFAULT NULL COMMENT '商品类型',
  `type_name` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `type` int(10) unsigned zerofill DEFAULT NULL COMMENT '规格类型(1同类商品包邮，2全包邮)',
  `args` varchar(128) DEFAULT NULL COMMENT '规格系数',
  `status` int(1) DEFAULT '1' COMMENT '状态(1正常，2删除，3下架)',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='商品规格';

-- ----------------------------
-- Records of t_g_format
-- ----------------------------
INSERT INTO `t_g_format` VALUES ('1', '玫红色（肚兜+系带T裤）', '1001', '情趣内衣', '0000000001', null, '1', '2016-01-19 01:20:36', '2016-03-13 00:30:26');
INSERT INTO `t_g_format` VALUES ('2', '大红色（肚兜+系带T裤）', '1001', '情趣内衣', '0000000001', null, '1', '2016-01-19 01:20:36', '2016-03-13 00:30:47');
INSERT INTO `t_g_format` VALUES ('3', '2件特惠（黑色+紫色）', '1001', '情趣内衣', '0000000002', '{opt:3,value:0.2,pOpt:1}', '1', '1979-01-01 01:00:00', '2016-03-19 00:03:30');
INSERT INTO `t_g_format` VALUES ('4', '黑色', '1001', '情趣内衣', '0000000001', null, '1', '2016-03-20 15:40:07', '2016-03-20 16:35:14');
INSERT INTO `t_g_format` VALUES ('5', '加1元送白色网衣', '1001', '情趣内衣', '0000000002', null, '1', '2016-03-20 16:31:15', '2016-03-20 16:36:55');
INSERT INTO `t_g_format` VALUES ('6', '粉色', '1001', '情趣内衣', '0000000001', null, '1', '2016-03-20 19:59:30', '2016-03-20 19:59:30');
INSERT INTO `t_g_format` VALUES ('7', '白色', '1001', '情趣内衣', '0000000001', null, '1', '2016-03-20 19:59:46', '2016-03-20 19:59:46');
INSERT INTO `t_g_format` VALUES ('8', '四合一+珍珠内裤', '1004', '避孕套', '0000000001', null, '1', '2016-03-20 20:25:57', '2016-03-20 20:25:57');
INSERT INTO `t_g_format` VALUES ('9', '经典四合一24只', '1004', '避孕套', '0000000001', null, '1', '2016-03-20 20:26:24', '2016-03-20 20:26:24');
INSERT INTO `t_g_format` VALUES ('10', '12只（热感）', '1004', '避孕套', '0000000001', null, '1', '2016-03-20 20:31:07', '2016-03-20 20:31:07');
INSERT INTO `t_g_format` VALUES ('11', 'BKK智能飞机杯', '1002', '男用玩具', '0000000001', null, '1', '2016-03-20 20:34:45', '2016-03-20 20:35:09');
INSERT INTO `t_g_format` VALUES ('12', '加12元购220ML润滑油', '1002', '男用玩具', '0000000001', null, '1', '2016-03-20 20:35:36', '2016-03-20 20:35:36');
INSERT INTO `t_g_format` VALUES ('13', '加15元购冈本套7只装', '1004', '避孕套', '0000000001', null, '1', '2016-03-20 20:36:20', '2016-03-20 20:36:20');

-- ----------------------------
-- Table structure for t_g_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_g_tag`;
CREATE TABLE `t_g_tag` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '标签名称',
  `type` int(11) NOT NULL COMMENT '标签类型(1商品标签，2是帖子标签)',
  `img` varchar(225) DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '状态(1正常，2删除)',
  `title` varchar(225) DEFAULT NULL,
  `subtitle` varchar(225) DEFAULT NULL,
  `show_main` int(1) DEFAULT '0' COMMENT '是否显示首页',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品表情';

-- ----------------------------
-- Records of t_g_tag
-- ----------------------------
INSERT INTO `t_g_tag` VALUES ('1', '豹纹', '1', null, '1', null, null, null, '2017-06-06 15:57:31', '1979-01-01 01:00:00');

-- ----------------------------
-- Table structure for t_hint
-- ----------------------------
DROP TABLE IF EXISTS `t_hint`;
CREATE TABLE `t_hint` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL COMMENT '内容',
  `sub_type` int(2) DEFAULT NULL COMMENT '论坛主题(不同的主题)',
  `remark` varchar(20) DEFAULT NULL,
  `type` int(2) NOT NULL DEFAULT '1' COMMENT '类型(1下拉更新,2转圈,3发帖,4回帖)',
  `create_time` timestamp NULL DEFAULT '1970-01-01 12:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1970-01-01 12:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`,`type`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='提示语';

-- ----------------------------
-- Records of t_hint
-- ----------------------------
INSERT INTO `t_hint` VALUES ('1', '皮肤真滑，在滑一次！', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('2', '‘操’之过急↖↑↗', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('3', '心急吃不了热豆腐', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('4', '快点快点，我要来了', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('5', '是精子总会发光的', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('6', '已经看到我的下限了', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('7', '道具选的好，老公回家早', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('8', '女神那里跑，我已经受不了', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('9', '放开人家', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('10', '九慢一快，现在真是慢的时候', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('11', '送礼选对道具，才是真兄弟', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('12', '每天都要操，花样很重要', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('13', '长短不是关键，技术还需锻炼', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('14', '刷情趣，是一种生活态度', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('15', '前戏是关键，老婆像初恋（333）', null, null, '1', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('16', '撸是你的事，脏就是你的错啦', null, null, '4', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('17', '随口说一声我也可能哭出声音', null, null, '4', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('18', '情趣清清，口下留情', null, null, '4', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('19', '不要让我看到少儿不宜', null, null, '4', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('20', '来卖萌，别来卖货', null, null, '4', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('21', '凶我我会哭的哟', null, null, '4', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('22', '贴小广告会被警察叔叔抓走的哟', null, null, '4', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('23', '美文，美女，还有文明的你', null, null, '4', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('24', '我有玻璃心，最怕锋利的贱', null, null, '4', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('25', '再刺激就要爆了', null, null, '4', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('26', '不要让我看到小儿不宜', null, null, '4', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('27', '我可爱，因为你文明', null, null, '4', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('28', '请骚候', null, null, '2', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('29', '女同学晒事业线圈子哟~男同学发帖可是会被禁言', null, '没有沟不会火', '3', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('30', '发帖必须手写情趣ID照哦（记得加情趣记得加情趣记得加情趣）', null, '有图有金币', '3', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('31', '女同学晒美腿圈子哟~男同学发帖可是会被禁言', null, '姐有大长腿', '3', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('32', '讲述自己虐恋路上的感悟，分享自己的SM经历，教程。求主求奴请去同城交友', null, '蜡烛爱上鞭', '3', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('33', '男生晒自拍专区，妹子禁止发帖。照片最好三张以上，清晰度高，带标题。晒最帅的自拍吧！', null, '不帅你抽我', '3', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('34', '不晒图，拒绝小黄文，发帖请注意尺度，否则会被版主大人删除', null, '我的羞羞日记', '3', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('35', '我们的口号是：秀恩爱，就虐单身狗', null, '家有仙妻', '3', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('36', '说说你尴尬的啪啪经历，不要怕羞不要怕糗，更不要大尺度不可描述哟', null, '那些糟糕的性经历', '3', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('37', '分享自己唯美的有趣的性幻想。发小黄文会被和谐的而且禁言哦！', null, '超级性幻想', '3', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('38', '吐槽身边发生过的性骚扰，让大家引以为戒', null, '拒绝性骚扰', '3', '2016-09-11 00:08:56', '2016-09-11 00:08:56');
INSERT INTO `t_hint` VALUES ('39', '请勿发布违法内容，会被删除禁言的哦', null, '动漫宅基腐', '3', '2016-09-11 00:08:56', '2016-09-11 00:08:56');

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(32) DEFAULT NULL COMMENT '模块名称（管理后台可见）',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `url` varchar(128) DEFAULT NULL COMMENT '模块跳转',
  `content` text COMMENT '内容（）',
  `type` int(11) DEFAULT NULL COMMENT '类型(1.首页)',
  `main_type` int(2) DEFAULT NULL COMMENT '主题类型(1首页)',
  `sort` int(2) DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_flag` int(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_security_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='api端模块管理';

-- ----------------------------
-- Records of t_module
-- ----------------------------
INSERT INTO `t_module` VALUES ('45', '轮播图', '', null, '{\r\n  imgs: [\r\n    {\r\n      imgUrl: \"img/main/39dc41f96634710a4c5c69e250b54257.jpg\", \r\n      url: \"#/tab/main_societyItem?id=10\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/a77f88d71a0ac277230d067da1be2b7e.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10015\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/c0941c32bab2a063fd94ce1fcd710e89.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10016\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/9298f2101fb7d8423ea1d7443ebac2d1.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10017\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/96c858c99f4b116e9c85aabc7a0baa3e.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10018\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/9bcce5cd870e95734441caf6d210a2ee.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }\r\n  ]\r\n}', '1', '1', '1', '', '1979-01-01 01:00:00', '2016-11-30 00:51:52', '0');
INSERT INTO `t_module` VALUES ('46', '类别', null, null, '{\r\n  subs: [\r\n    [\r\n      {\r\n        title: \"安全避孕\", \r\n        imgUrl: \"img/ico/174-condom (4).png\", \r\n        url: \"#/tab/main_goodsList?typeId=1004&title=安全避孕\"\r\n      }, \r\n      {\r\n        title: \"女人玩具\", \r\n        imgUrl: \"img/ico/sexy_girl.png\", \r\n        url: \"#/tab/main_goodsList?typeId=1003&title=女人玩具\"\r\n      }, \r\n      {\r\n        title: \"情趣内衣\", \r\n        imgUrl: \"img/ico/196-bra (5).png\", \r\n        url: \"#/tab/main_goodsList?typeId=1001&title=情趣内衣\"\r\n      }, \r\n      {\r\n        title: \"男人玩具\", \r\n        imgUrl: \"img/ico/star_wars.png\", \r\n        url: \"#/tab/main_goodsList?typeId=1002&title=男人玩具\"\r\n      }\r\n    ], \r\n    [\r\n      {\r\n        title: \"延时助情\", \r\n        imgUrl: \"img/ico/34-time-machine (2).png\", \r\n        url: \"#/tab/main_goodsList?typeId=1005&title=延时助情\"\r\n      }, \r\n      {\r\n        title: \"调情润滑\", \r\n        imgUrl: \"img/ico/spiral.png\", \r\n        url: \"#/tab/main_goodsList?typeId=1006&title=调情润滑\"\r\n      }, \r\n      {\r\n        title: \"更多\", \r\n        imgUrl: \"img/ico/index_all.png\", \r\n        url: \"#/tab/main_goodsType?title=更多\"\r\n      }\r\n    ]\r\n  ]\r\n}', '2', '1', '2', null, '1979-01-01 01:00:00', '2016-11-30 00:51:53', '0');
INSERT INTO `t_module` VALUES ('47', '广播', null, null, '{\r\n  imgs: [\r\n    {\r\n      title: \"制服诱惑日系和服\", \r\n      url: \"#/tab/main_goodsItem?id=10011\"\r\n    }, \r\n    {\r\n      title: \"制服<span style=\'color:red\'>诱惑</span>日系和服\", \r\n      url: \"#/tab/main_goodsItem?id=10011\"\r\n    }, \r\n    {\r\n      title: \"制服诱惑日系和服\", \r\n      url: \"#/tab/main_goodsItem?id=10015\"\r\n    }, \r\n    {\r\n      title: \"制服诱惑日系和服论坛\", \r\n      url: \"#/tab/main_societyItem?id=11\"\r\n    }, \r\n    {\r\n      title: \"制服诱惑日系和服\", \r\n      url: \"#/tab/main_goodsItem?id=10011\"\r\n    }\r\n  ]\r\n}', '3', '1', '3', null, '1979-01-01 01:00:00', '2016-11-30 00:51:54', '0');
INSERT INTO `t_module` VALUES ('48', '热门', null, null, '{\r\n  imgs: [\r\n    {\r\n      imgUrl: \"img/main/39dc41f96634710a4c5c69e250b54257.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }\r\n  ], \r\n  subs: [\r\n    [\r\n      {\r\n        imgUrl: \"img/main/qq/qq320160403172032.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"<span style=\'color:red\'>诱惑</span>轻解罗裳\", \r\n        itemDesc: \"良宵一刻\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/qq/qq420160403172127.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"听话女仆\", \r\n        itemDesc: \"会暖床会伺候\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/qq/qq520160403172156.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"性感T裤\", \r\n        itemDesc: \"下半身的诱惑\"\r\n      }\r\n    ]\r\n  ]\r\n}', '4', '1', '4', null, '1979-01-01 01:00:00', '2016-11-30 00:51:54', '0');
INSERT INTO `t_module` VALUES ('49', '1元购', '1元购', '#/tab/gou', '{\r\n  imgs: [\r\n    {\r\n      imgUrl: \"img/main/39dc41f96634710a4c5c69e250b54257.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/a77f88d71a0ac277230d067da1be2b7e.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/9bcce5cd870e95734441caf6d210a2ee.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }\r\n  ], \r\n  subs: [\r\n    [\r\n      {\r\n        imgUrl: \"img/main/qq/qq320160403172032.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"<span style=\'color:red\'>诱惑</span>轻解罗裳\", \r\n        itemDesc: \"良宵一刻\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/qq/qq420160403172127.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"听话女仆\", \r\n        itemDesc: \"会暖床会伺候\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/qq/qq520160403172156.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"性感T裤\", \r\n        itemDesc: \"下半身的诱惑\"\r\n      }\r\n    ], \r\n    [\r\n      {\r\n        imgUrl: \"img/main/qq/qq320160403172032.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"轻解罗裳\", \r\n        itemDesc: \"良宵一刻\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/qq/qq420160403172127.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"听话女仆\", \r\n        itemDesc: \"会暖床会伺候\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/qq/qq520160403172156.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"性感T裤\", \r\n        itemDesc: \"下半身的诱惑\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/qq/qq520160403172156.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"性感T裤\", \r\n        itemDesc: \"下半身的诱惑\"\r\n      }\r\n    ]\r\n  ]\r\n}', '4', '1', '5', null, '1979-01-01 01:00:00', '2016-11-30 00:51:55', '0');
INSERT INTO `t_module` VALUES ('50', '情趣服饰', '情趣服饰', '#/tab/main_goodsList?typeId=1001&title=情趣服饰', '{\r\n  imgs: [\r\n    {\r\n      imgUrl: \"img/main/a77f88d71a0ac277230d067da1be2b7e.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/9bcce5cd870e95734441caf6d210a2ee.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }\r\n  ], \r\n  subs: [\r\n    [\r\n      {\r\n        imgUrl: \"img/main/qq/qq320160403172032.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"<span style=\'color:red\'>诱惑</span>轻解罗裳\", \r\n        itemDesc: \"良宵一刻\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/qq/qq420160403172127.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"听话女仆\", \r\n        itemDesc: \"会暖床会伺候\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/qq/qq520160403172156.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"性感T裤\", \r\n        itemDesc: \"下半身的诱惑\"\r\n      }\r\n    ], \r\n    [\r\n      {\r\n        imgUrl: \"img/main/qq/qq320160403172032.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"轻解罗裳\", \r\n        itemDesc: \"良宵一刻\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/qq/qq420160403172127.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"听话女仆\", \r\n        itemDesc: \"会暖床会伺候\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/qq/qq520160403172156.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"性感T裤\", \r\n        itemDesc: \"下半身的诱惑\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/qq/qq520160403172156.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"性感T裤\", \r\n        itemDesc: \"下半身的诱惑\"\r\n      }\r\n    ]\r\n  ]\r\n}', '4', '1', '6', null, '1979-01-01 01:00:00', '2016-11-30 00:51:56', '0');
INSERT INTO `t_module` VALUES ('51', '套套', '套套天堂', '#/tab/main_goodsList?typeId=1004&title=套套天堂', '{\r\n  imgs: [\r\n    {\r\n      imgUrl: \"img/main/39dc41f96634710a4c5c69e250b54257.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/a77f88d71a0ac277230d067da1be2b7e.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/9bcce5cd870e95734441caf6d210a2ee.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }\r\n  ], \r\n  subs: [\r\n    [\r\n      {\r\n        imgUrl: \"img/main/tt/tt120160403171019.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"精致铁盒\", \r\n        itemDesc: \"芳香果味\", \r\n        col: \"66\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/tt/tt220160403171126.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"精致铁盒\", \r\n        itemDesc: \"芳香果味\"\r\n      }\r\n    ], \r\n    [\r\n      {\r\n        imgUrl: \"img/main/tt/tt320160403171234.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"小号紧型\", \r\n        itemDesc: \"持久不泄\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/tt/tt420160403170815.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"有型有色\", \r\n        itemDesc: \"颗粒香味套\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/tt/tt520160403171400.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"薄若无物\", \r\n        itemDesc: \"零距离感受\"\r\n      }\r\n    ]\r\n  ]\r\n}', '4', '1', '7', null, '1979-01-01 01:00:00', '2016-11-30 00:51:56', '0');
INSERT INTO `t_module` VALUES ('52', '女用玩具', '女用玩具', '#/tab/main_goodsList?typeId=1003&title=女用玩具', '{\r\n  imgs: [\r\n    {\r\n      imgUrl: \"img/main/39dc41f96634710a4c5c69e250b54257.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/a77f88d71a0ac277230d067da1be2b7e.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/9bcce5cd870e95734441caf6d210a2ee.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }\r\n  ], \r\n  subs: [\r\n    [\r\n      {\r\n        imgUrl: \"img/main/ny/ny120160403165811.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"拍打式AV棒\", \r\n        itemDesc: \"比震动更疯狂\", \r\n        col: \"66\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/ny/ny220160403165912.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"诺兰摇情\", \r\n        itemDesc: \"一键潮湿\"\r\n      }\r\n    ], \r\n    [\r\n      {\r\n        imgUrl: \"img/main/ny/ny320160403170431.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"转珠之王\", \r\n        itemDesc: \"次次爽翻天\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/ny/ny420160403170505.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"双头共震\", \r\n        itemDesc: \"任性不止一面\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/ny/ny520160403170603.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"时尚双震棒\", \r\n        itemDesc: \"30种变频\"\r\n      }\r\n    ]\r\n  ]\r\n}', '4', '1', '8', null, '1979-01-01 01:00:00', '2016-11-30 00:51:57', '0');
INSERT INTO `t_module` VALUES ('53', '男用玩具', '男用玩具', '#/tab/main_goodsList?typeId=1002&title=男用玩具', '{\r\n  imgs: [\r\n    {\r\n      imgUrl: \"img/main/39dc41f96634710a4c5c69e250b54257.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/a77f88d71a0ac277230d067da1be2b7e.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/9bcce5cd870e95734441caf6d210a2ee.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }\r\n  ], \r\n  subs: [\r\n    [\r\n      {\r\n        imgUrl: \"img/main/nan/nan120160403173103.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"震动吸允\", \r\n        itemDesc: \"充电电动杯\", \r\n        col: \"66\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/nan/nan220160403173157.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"名模露露\", \r\n        itemDesc: \"真人倒模\"\r\n      }\r\n    ], \r\n    [\r\n      {\r\n        imgUrl: \"img/main/nan/nan320160403173350.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"萌女名器\", \r\n        itemDesc: \"蜀黍的嫩模\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/nan/nan420160403173453.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"谜姬美臀\", \r\n        itemDesc: \"双面双穴\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/nan/nan520160403173535.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"深喉的快感\", \r\n        itemDesc: \"香唇的畅享\"\r\n      }\r\n    ]\r\n  ]\r\n}', '4', '1', '9', null, '1979-01-01 01:00:00', '2016-11-30 00:51:58', '0');
INSERT INTO `t_module` VALUES ('54', '调情助兴', '调情助兴', '#/tab/main_goodsList?typeId=1002&title=调情助兴', '{\r\n  imgs: [\r\n    {\r\n      imgUrl: \"img/main/39dc41f96634710a4c5c69e250b54257.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/a77f88d71a0ac277230d067da1be2b7e.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/9bcce5cd870e95734441caf6d210a2ee.jpg\", \r\n      url: \"#/tab/main_goodsItem?id=10019\"\r\n    }\r\n  ], \r\n  subs: [\r\n    [\r\n      {\r\n        imgUrl: \"img/main/tqzx/tq120160403174909.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"坚持不泄\", \r\n        itemDesc: \"持久加倍\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/tqzx/tq220160403175009.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"快速点燃\", \r\n        itemDesc: \"让她颤抖\"\r\n      }, \r\n      {\r\n        imgUrl: \"img/main/tqzx/tq320160403175102.jpg\", \r\n        url: \"#/tab/main_goodsItem?id=10019\", \r\n        itemTitle: \"冰雪交融\", \r\n        itemDesc: \"滑向巅峰\"\r\n      }\r\n    ]\r\n  ]\r\n}', '4', '1', '10', null, '1979-01-01 01:00:00', '2016-11-30 00:51:58', '0');
INSERT INTO `t_module` VALUES ('55', '推荐', '推荐', null, null, '5', '1', '11', null, '1979-01-01 01:00:00', '2016-11-30 00:51:59', '0');
INSERT INTO `t_module` VALUES ('56', '社区轮播图', null, '', '{\r\n  imgs: [\r\n    {\r\n      imgUrl: \"img/main/39dc41f96634710a4c5c69e250b54257.jpg\", \r\n      url: \"#/tab/society_societyItem?id=10\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/a77f88d71a0ac277230d067da1be2b7e.jpg\", \r\n      url: \"#/tab/society_goodsItem?id=10015\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/c0941c32bab2a063fd94ce1fcd710e89.jpg\", \r\n      url: \"#/tab/society_goodsItem?id=10016\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/9298f2101fb7d8423ea1d7443ebac2d1.jpg\", \r\n      url: \"#/tab/society_goodsItem?id=10017\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/96c858c99f4b116e9c85aabc7a0baa3e.jpg\", \r\n      url: \"#/tab/society_goodsItem?id=10018\"\r\n    }, \r\n    {\r\n      imgUrl: \"img/main/9bcce5cd870e95734441caf6d210a2ee.jpg\", \r\n      url: \"#/tab/society_goodsItem?id=10019\"\r\n    }\r\n  ]\r\n}', '1', '2', '1', null, '1979-01-01 01:00:00', '2016-11-30 01:40:10', '0');
INSERT INTO `t_module` VALUES ('57', '社区副', null, null, '{\r\n  imgs: [\r\n    {\r\n      clazz:\"ion-cash\", \r\n			color:\"balanced\",\r\n			col:\"col-25\",\r\n      url:\"#/tab/society_tyrant\",\r\n			title:\"土豪榜\"\r\n    }, \r\n    {\r\n      clazz:\"ion-heart\", \r\n			color:\"assertive\",\r\n			col:\"col-25\",\r\n      url: \"#/tab/society_charm\",\r\n			title:\"魅力榜\"\r\n    }, \r\n    {\r\n      clazz:\"ion-social-bitcoin-outline\",\r\n			color:\"energized\", \r\n			col:\"col-25\",\r\n      url:\"#/tab/society_regal\",\r\n			title:\"大富翁\"\r\n    }, \r\n    {\r\n			clazz:\"ion-ios-people\",\r\n			color:\"energized\", \r\n			col:\"col-25\",\r\n      url:\"#/tab/society_hotUser\",\r\n			title:\"焦点人物\"\r\n    }\r\n  ]\r\n}', '2', '2', '2', null, '1979-01-01 01:00:00', '2016-11-30 02:06:52', '0');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(64) DEFAULT NULL COMMENT '订单编号',
  `user_id` int(11) NOT NULL,
  `money` decimal(10,2) DEFAULT '0.00' COMMENT '商品总价',
  `total_money` decimal(10,2) DEFAULT '0.00' COMMENT '订单总价',
  `payment_Id` int(1) DEFAULT '0' COMMENT '支付方式（1是支付宝支付，2是微信支付,3货到付款）',
  `payment_name` varchar(32) DEFAULT NULL,
  `pay_status` int(1) DEFAULT '1' COMMENT '订单状态(1未支付,2支付成功,3支付未成功)',
  `status` int(1) DEFAULT '1' COMMENT '订单状态(1待付款，2待发货，3运送中，4已完成，9取消订单)',
  `post_id` int(11) DEFAULT NULL COMMENT '快递公司ID',
  `post_name` varchar(50) DEFAULT NULL COMMENT '快递公司名称',
  `post_code` varchar(50) DEFAULT NULL COMMENT '快递单号',
  `post_money` decimal(10,2) DEFAULT '0.00' COMMENT '邮费',
  `lost_post_money` decimal(10,2) DEFAULT '0.00' COMMENT '运费减免',
  `lost_money` decimal(10,2) DEFAULT '0.00' COMMENT '优惠金额',
  `invoice_is` int(1) DEFAULT NULL COMMENT '是否需要发票',
  `invoice_head` varchar(128) DEFAULT NULL COMMENT '发票抬头',
  `address_id` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL COMMENT '地址详细信息',
  `zipcode` varchar(6) DEFAULT NULL,
  `coupon_id` int(11) DEFAULT NULL COMMENT '优惠券id',
  `coupon` varchar(255) DEFAULT NULL COMMENT '优惠券信息',
  `push` int(1) DEFAULT '0' COMMENT '消息推送记录(0为推送，1已推送)',
  `read_is` int(1) DEFAULT '0' COMMENT '订单状态是否已读(0未读，1已读)',
  `delete_flag` int(1) DEFAULT '0' COMMENT '删除标志',
  `form` int(1) DEFAULT '1' COMMENT '订单来源(1直接购买,2社区赠送,3一元购)',
  `remark` varchar(225) DEFAULT NULL COMMENT '备注',
  `explain` varchar(225) DEFAULT NULL COMMENT '订单说明',
  `activitys` text COMMENT '活动l列表',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='订单信息';

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', 'GD878439578493', '1', '15.00', null, '1', null, '1', '1', '8', '韵达快递', '3101001894999', '8.00', null, null, null, null, '1', null, null, null, null, '0', '0', '0', '1', '要红色要大红色', null, null, '2016-09-22 01:55:58', '2016-09-21 00:57:11');
INSERT INTO `t_order` VALUES ('2', 'GD9598034589ig9034', '1', '29.00', null, '1', null, '2', '2', '8', '韵达快递', '280415419409', '0.00', null, null, null, null, '1', null, null, null, null, '0', '0', '0', '1', '速度要快', null, null, '2016-09-22 01:56:36', '2016-09-21 00:57:01');
INSERT INTO `t_order` VALUES ('6', '201611190650138167', '1', '362.00', '334.00', '2', '微信支付', '0', '1', null, null, null, '8.00', '8.00', '20.00', null, null, '2', '湖南省株洲市攸县 菜花坪东南村', null, '4', null, '0', '0', '0', '1', 'null', null, '[{\"id\":1,\"name\":\"情趣色子骰子筛子SM用品2粒夫妻情侣游戏惩罚纸牌扑克\",\"type\":3,\"max\":0,\"value\":0},{\"id\":2,\"name\":\"备年货满88元包邮\",\"type\":2,\"max\":88,\"value\":0},{\"id\":4,\"name\":\"满99包邮\",\"type\":2,\"max\":99,\"value\":0},{\"id\":6,\"name\":\"满59减5\",\"type\":4,\"max\":59,\"value\":5},{\"id\":7,\"name\":\"满99减10\",\"type\":4,\"max\":99,\"value\":10},{\"id\":8,\"name\":\"满199减20\",\"type\":4,\"max\":199,\"value\":20}]', '2016-11-19 06:50:13', '2016-11-19 06:50:13');
INSERT INTO `t_order` VALUES ('7', '201611201547068830', '1', '362.00', '342.00', '2', '微信支付', '0', '1', null, null, null, '8.00', '8.00', '20.00', null, null, '1', '广东省深圳市罗湖区 黄贝岭街道经二路龙景花园芳庭苑', null, null, null, '0', '0', '0', '1', 'null', null, '[{\"id\":1,\"name\":\"情趣色子骰子筛子SM用品2粒夫妻情侣游戏惩罚纸牌扑克\",\"type\":3,\"max\":0,\"value\":0},{\"id\":2,\"name\":\"备年货满88元包邮\",\"type\":2,\"max\":88,\"value\":0},{\"id\":4,\"name\":\"满99包邮\",\"type\":2,\"max\":99,\"value\":0},{\"id\":6,\"name\":\"满59减5\",\"type\":4,\"max\":59,\"value\":5},{\"id\":7,\"name\":\"满99减10\",\"type\":4,\"max\":99,\"value\":10},{\"id\":8,\"name\":\"满199减20\",\"type\":4,\"max\":199,\"value\":20}]', '2016-11-20 15:47:06', '2016-11-20 15:47:06');
INSERT INTO `t_order` VALUES ('8', '201611212311150737', '1', '79.00', '79.00', '2', '微信支付', '0', '1', null, null, null, '8.00', '0.00', '0.00', null, null, '2', '湖南省株洲市攸县 菜花坪东南村', null, '4', null, '0', '0', '0', '1', 'null', null, '[{\"id\":1,\"name\":\"情趣色子骰子筛子SM用品2粒夫妻情侣游戏惩罚纸牌扑克\",\"type\":3,\"max\":0,\"value\":0},{\"id\":4,\"name\":\"满99包邮\",\"type\":2,\"max\":99,\"value\":0}]', '2016-11-21 23:11:15', '2016-11-21 23:11:15');
INSERT INTO `t_order` VALUES ('9', '201611230003266547', '1', '138.00', '128.00', '2', '微信支付', '0', '1', null, null, null, '8.00', '8.00', '0.00', null, null, '2', '湖南省株洲市攸县 菜花坪东南村', null, '1', '女用玩具专用[满99元可以用]', '0', '0', '0', '1', 'null', null, '[{\"id\":4,\"name\":\"满99包邮\",\"type\":2,\"max\":99,\"value\":0}]', '2016-11-23 00:03:26', '2016-11-23 00:03:26');
INSERT INTO `t_order` VALUES ('10', '201611230006320001', '1', '138.00', '128.00', '2', '微信支付', '0', '1', null, null, null, '8.00', '8.00', '0.00', null, null, '2', '湖南省株洲市攸县 菜花坪东南村', null, '1', '女用玩具专用[满99元可以用]', '0', '0', '0', '1', 'null', null, '[{\"id\":4,\"name\":\"满99包邮\",\"type\":2,\"max\":99,\"value\":0}]', '2016-11-23 00:06:32', '2016-11-23 00:06:32');
INSERT INTO `t_order` VALUES ('11', '201611230006499426', '1', '69.00', '77.00', '2', '微信支付', '0', '1', null, null, null, '8.00', '0.00', '0.00', null, null, '2', '湖南省株洲市攸县 菜花坪东南村', null, null, null, '0', '0', '0', '1', '尔特让他', null, '[{\"id\":4,\"name\":\"满99包邮\",\"type\":2,\"max\":99,\"value\":0}]', '2016-11-23 00:06:49', '2016-11-23 00:06:49');
INSERT INTO `t_order` VALUES ('12', '201611230006506212', '1', '69.00', '77.00', '2', '微信支付', '0', '1', null, null, null, '8.00', '0.00', '0.00', null, null, '2', '湖南省株洲市攸县 菜花坪东南村', null, null, null, '0', '0', '0', '1', '尔特让他', null, '[{\"id\":4,\"name\":\"满99包邮\",\"type\":2,\"max\":99,\"value\":0}]', '2016-11-23 00:06:50', '2016-11-23 00:06:50');
INSERT INTO `t_order` VALUES ('14', '201611230212506029', '1', '348.00', '320.00', '2', '微信支付', '0', '1', null, null, null, '8.00', '8.00', '20.00', null, null, '2', '湖南省株洲市攸县 菜花坪东南村', null, '4', null, '0', '0', '0', '1', '我们爱你', null, '[{\"id\":1,\"name\":\"情趣色子骰子筛子SM用品2粒夫妻情侣游戏惩罚纸牌扑克\",\"type\":3,\"max\":0,\"value\":0},{\"id\":2,\"name\":\"备年货满88元包邮\",\"type\":2,\"max\":88,\"value\":0},{\"id\":4,\"name\":\"满99包邮\",\"type\":2,\"max\":99,\"value\":0},{\"id\":6,\"name\":\"满59减5\",\"type\":4,\"max\":59,\"value\":5},{\"id\":7,\"name\":\"满99减10\",\"type\":4,\"max\":99,\"value\":10},{\"id\":8,\"name\":\"满199减20\",\"type\":4,\"max\":199,\"value\":20}]', '2016-11-23 02:12:50', '2016-11-23 02:12:50');

-- ----------------------------
-- Table structure for t_order_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_order_activity`;
CREATE TABLE `t_order_activity` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '活动ID',
  `order_id` int(12) DEFAULT NULL COMMENT '订单ID',
  `activity_id` int(12) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL COMMENT '活动名称',
  `url` varchar(255) DEFAULT NULL COMMENT '活动链接地址',
  `detail` varchar(225) DEFAULT NULL COMMENT '活动详情',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='活动';

-- ----------------------------
-- Records of t_order_activity
-- ----------------------------
INSERT INTO `t_order_activity` VALUES ('1', null, null, '情趣色子骰子筛子SM用品2粒夫妻情侣游戏惩罚纸牌扑克', null, null, '2016-03-11 23:53:30');
INSERT INTO `t_order_activity` VALUES ('2', null, null, '备年货满88元包邮', null, null, '2016-03-11 23:53:30');
INSERT INTO `t_order_activity` VALUES ('3', null, null, '包邮', null, null, '2016-03-11 23:53:30');
INSERT INTO `t_order_activity` VALUES ('4', null, null, '满99包邮', null, null, '1979-01-01 01:00:00');
INSERT INTO `t_order_activity` VALUES ('5', null, null, '制服有礼·特惠活动', null, '爆款情趣制服限时送进口BK指甲油+陌陌水蜜桃味避孕套2只装！！活动时间：3.17-3.25！！礼品数量有限，送完即止哦~', '2016-03-20 02:34:45');
INSERT INTO `t_order_activity` VALUES ('6', null, null, '满59减5', null, null, '1979-01-01 01:00:00');
INSERT INTO `t_order_activity` VALUES ('7', null, null, '满99减10', null, null, '1979-01-01 01:00:00');
INSERT INTO `t_order_activity` VALUES ('8', null, null, '满199减20', null, null, '1979-01-01 01:00:00');

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单项Id',
  `order_id` int(11) NOT NULL COMMENT '主订单ID',
  `goods_id` int(11) NOT NULL COMMENT '产品单品ID',
  `goods_name` varchar(64) NOT NULL COMMENT '单品名称',
  `goods_img` varchar(128) DEFAULT NULL,
  `formats` varchar(225) DEFAULT '' COMMENT '商品规格名称',
  `activitys` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT '0' COMMENT '购买数量',
  `price` decimal(10,0) DEFAULT '0' COMMENT '成交价格',
  `market_price` decimal(10,0) DEFAULT '0' COMMENT '市场价格',
  `remark` varchar(225) DEFAULT NULL COMMENT '备注',
  `dis_is` int(1) DEFAULT '0' COMMENT '是否已经评论(0未评论,1已评论)',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='订单详情';

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES ('1', '1', '10001', '霏慕 中国古典肚兜性感挂脖绑带情趣诱惑肚兜T裤 2件套', 'http://mallimg01.touchcdn.com/goods-gallery/866976864088af42f9014313d06bbf77.jpg?imageView/2/w/416/interlace/1', '规格：大红色（肚兜+系带T裤）', null, '2', '19', '29', '', '0', '2016-11-19 05:58:03', '1979-01-01 01:00:00');
INSERT INTO `t_order_item` VALUES ('2', '1', '10010', '久慕雅黛 古典复古和服风深V开衩短裙日式情趣内衣', 'http://mallimg01.touchcdn.com/goods-gallery/e2d09b3577f70bcbf769bca6666c3c43.jpg?imageView/2/w/416/interlace/1', '规格：大红色（肚兜+系带T裤）', null, '2', '19', '29', null, '0', '2016-11-19 05:58:19', '1979-01-01 01:00:00');
INSERT INTO `t_order_item` VALUES ('3', '2', '10001', '霏慕 中国古典肚兜性感挂脖绑带情趣诱惑肚兜T裤 2件套', 'http://mallimg01.touchcdn.com/goods-gallery/866976864088af42f9014313d06bbf77.jpg?imageView/2/w/416/interlace/1', '规格：大红色（肚兜+系带T裤）', null, '4', '19', '29', null, '0', '2016-11-19 05:58:22', '1979-01-01 01:00:00');
INSERT INTO `t_order_item` VALUES ('6', '6', '10001', '霏慕 中国古典肚兜性感挂脖绑带情趣诱惑肚兜T裤 2件套', 'http://mallimg01.touchcdn.com/goods-gallery/866976864088af42f9014313d06bbf77.jpg?imageView/2/w/416/interlace/1', '规格：磨砂AU9999褐色大红色（肚兜+系带T裤）', null, '3', '17', '49', null, '0', '2016-11-19 06:50:13', '2016-11-19 06:50:13');
INSERT INTO `t_order_item` VALUES ('7', '6', '10027', '荷兰COB女优签名版震动飞机杯', 'http://mallimg01.touchcdn.com/goods-gallery/dbdbae49f7d87854578c4cf52f0e5ffd.jpg?imageView/2/w/416/interlace/1', '规格：大红色（肚兜+系带T裤）', null, '3', '99', '99', null, '0', '2016-11-19 06:50:13', '2016-11-19 06:50:13');
INSERT INTO `t_order_item` VALUES ('8', '6', '10001', '霏慕 中国古典肚兜性感挂脖绑带情趣诱惑肚兜T裤 2件套', 'http://mallimg01.touchcdn.com/goods-gallery/866976864088af42f9014313d06bbf77.jpg?imageView/2/w/416/interlace/1', '规格：抛光AU999黑色大红色（肚兜+系带T裤）大红色（肚兜+系带T裤）', null, '1', '14', '49', null, '0', '2016-11-19 06:50:13', '2016-11-19 06:50:13');
INSERT INTO `t_order_item` VALUES ('9', '7', '10001', '霏慕 中国古典肚兜性感挂脖绑带情趣诱惑肚兜T裤 2件套', 'http://mallimg01.touchcdn.com/goods-gallery/866976864088af42f9014313d06bbf77.jpg?imageView/2/w/416/interlace/1', '规格：磨砂AU9999褐色大红色（肚兜+系带T裤）', null, '3', '17', '49', null, '0', '2016-11-20 15:47:06', '2016-11-20 15:47:06');
INSERT INTO `t_order_item` VALUES ('10', '7', '10027', '荷兰COB女优签名版震动飞机杯', 'http://mallimg01.touchcdn.com/goods-gallery/dbdbae49f7d87854578c4cf52f0e5ffd.jpg?imageView/2/w/416/interlace/1', '规格：大红色（肚兜+系带T裤）', null, '3', '99', '99', null, '0', '2016-11-20 15:47:06', '2016-11-20 15:47:06');
INSERT INTO `t_order_item` VALUES ('11', '7', '10001', '霏慕 中国古典肚兜性感挂脖绑带情趣诱惑肚兜T裤 2件套', 'http://mallimg01.touchcdn.com/goods-gallery/866976864088af42f9014313d06bbf77.jpg?imageView/2/w/416/interlace/1', '规格：抛光AU999黑色大红色（肚兜+系带T裤）大红色（肚兜+系带T裤）', null, '1', '14', '49', null, '0', '2016-11-20 15:47:06', '2016-11-20 15:47:06');
INSERT INTO `t_order_item` VALUES ('12', '8', '10017', '【包邮】品色伸缩转珠震动按摩AV棒', 'http://mallimg01.touchcdn.com/goods-gallery/0ff07592e560f8d86f35486eeda10e63.jpg?imageView/2/w/416/interlace/1', '规格：大红色（肚兜+系带T裤）', null, '1', '79', '148', null, '0', '2016-11-21 23:11:15', '2016-11-21 23:11:15');
INSERT INTO `t_order_item` VALUES ('13', '9', '10018', '阿芙拉G点妖精10变频模式震动棒', 'http://mallimg01.touchcdn.com/goods-gallery/284c2430c41f248460fe123125210438.jpg?imageView/2/w/416/interlace/1', '规格：大红色（肚兜+系带T裤）', null, '2', '69', '69', null, '0', '2016-11-23 00:03:26', '2016-11-23 00:03:26');
INSERT INTO `t_order_item` VALUES ('14', '10', '10018', '阿芙拉G点妖精10变频模式震动棒', 'http://mallimg01.touchcdn.com/goods-gallery/284c2430c41f248460fe123125210438.jpg?imageView/2/w/416/interlace/1', '规格：大红色（肚兜+系带T裤）', null, '2', '69', '69', null, '0', '2016-11-23 00:06:32', '2016-11-23 00:06:32');
INSERT INTO `t_order_item` VALUES ('15', '11', '10018', '阿芙拉G点妖精10变频模式震动棒', 'http://mallimg01.touchcdn.com/goods-gallery/284c2430c41f248460fe123125210438.jpg?imageView/2/w/416/interlace/1', '规格：大红色（肚兜+系带T裤）', null, '1', '69', '69', null, '0', '2016-11-23 00:06:49', '2016-11-23 00:06:49');
INSERT INTO `t_order_item` VALUES ('16', '12', '10018', '阿芙拉G点妖精10变频模式震动棒', 'http://mallimg01.touchcdn.com/goods-gallery/284c2430c41f248460fe123125210438.jpg?imageView/2/w/416/interlace/1', '规格：大红色（肚兜+系带T裤）', null, '1', '69', '69', null, '0', '2016-11-23 00:06:50', '2016-11-23 00:06:50');
INSERT INTO `t_order_item` VALUES ('19', '14', '10001', '霏慕 中国古典肚兜性感挂脖绑带情趣诱惑肚兜T裤 2件套', 'http://mallimg01.touchcdn.com/goods-gallery/866976864088af42f9014313d06bbf77.jpg?imageView/2/w/416/interlace/1', '规格：磨砂AU9999褐色大红色（肚兜+系带T裤）', null, '3', '17', '49', null, '0', '2016-11-23 02:12:50', '2016-11-23 02:12:50');
INSERT INTO `t_order_item` VALUES ('20', '14', '10027', '荷兰COB女优签名版震动飞机杯', 'http://mallimg01.touchcdn.com/goods-gallery/dbdbae49f7d87854578c4cf52f0e5ffd.jpg?imageView/2/w/416/interlace/1', '规格：大红色（肚兜+系带T裤）', null, '3', '99', '99', null, '0', '2016-11-23 02:12:50', '2016-11-23 02:12:50');

-- ----------------------------
-- Table structure for t_order_item_format
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item_format`;
CREATE TABLE `t_order_item_format` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单项Id',
  `order_item_id` int(11) NOT NULL COMMENT '主订单ID',
  `format_sub_id` int(11) NOT NULL COMMENT '规格子类ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单商品的规格';

-- ----------------------------
-- Records of t_order_item_format
-- ----------------------------

-- ----------------------------
-- Table structure for t_payment
-- ----------------------------
DROP TABLE IF EXISTS `t_payment`;
CREATE TABLE `t_payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `type` int(1) DEFAULT '1' COMMENT '类型（2,余额支付）',
  `rev_account` varchar(255) DEFAULT NULL COMMENT '接收账号',
  `pay_url` varchar(255) DEFAULT NULL COMMENT '支付URL',
  `check` int(1) DEFAULT '0' COMMENT '是否选中',
  `delete_flag` int(1) DEFAULT '0' COMMENT '删除标志',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_payment
-- ----------------------------
INSERT INTO `t_payment` VALUES ('1', '&#xe61b;', '支付宝', '1', null, null, '0', '0', '2016-11-08 23:38:14', '2016-11-17 01:32:13');
INSERT INTO `t_payment` VALUES ('2', '&#xe61c;', '微信支付', '1', null, null, '1', '0', '2016-11-08 23:38:14', '2016-11-16 01:39:14');
INSERT INTO `t_payment` VALUES ('3', '', '使用余额支付', '2', null, null, '0', '0', '1979-01-01 01:00:00', '2016-11-16 01:39:17');

-- ----------------------------
-- Table structure for t_payment_user
-- ----------------------------
DROP TABLE IF EXISTS `t_payment_user`;
CREATE TABLE `t_payment_user` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `user_id` int(12) DEFAULT NULL COMMENT '用户ID',
  `payment_id` int(12) DEFAULT NULL COMMENT '支付ID',
  `checked` int(1) DEFAULT '0' COMMENT '是否选中',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 COMMENT='用户默认支付方式';

-- ----------------------------
-- Records of t_payment_user
-- ----------------------------
INSERT INTO `t_payment_user` VALUES ('81', '1', '2', '1', '2017-02-08 23:46:04');

-- ----------------------------
-- Table structure for t_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_pic`;
CREATE TABLE `t_pic` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `obj_id` int(10) DEFAULT NULL COMMENT '商品类型',
  `type` int(5) DEFAULT NULL COMMENT '图片类型(1是商品图，2是商品评论图片,3是论坛评论图片,4意见反馈图)',
  `url_type` int(1) DEFAULT '1' COMMENT '地址类型(1.完整，2.系统路径)',
  `pic_title` varchar(50) DEFAULT NULL COMMENT '图片标题',
  `pic_url` varchar(225) DEFAULT NULL COMMENT '图片地址',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=380 DEFAULT CHARSET=utf8 COMMENT='商品图片';

-- ----------------------------
-- Records of t_pic
-- ----------------------------
INSERT INTO `t_pic` VALUES ('258', '10010', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/62c05f953f710e43b3b1e7fa96f32645.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:22:59', '2016-10-14 00:53:56');
INSERT INTO `t_pic` VALUES ('257', '10010', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/196eec538da335c121a408aa6b467ef2.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:22:59', '2016-10-14 00:53:59');
INSERT INTO `t_pic` VALUES ('256', '10010', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/36cb608bf41aa5ad4295695f1babf5f6.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:22:59', '2016-10-14 00:54:00');
INSERT INTO `t_pic` VALUES ('306', '10010', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/5b108a2510375f01d43fe1dcd4e9eecd.jpg?imageView/2/w/416/interlace/1', '2016-03-20 16:25:44', '2016-10-14 00:54:01');
INSERT INTO `t_pic` VALUES ('305', '10001', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/14e6793976be8ee85e9ef438d7938e3f.jpg?imageView/2/w/416/interlace/1', '2016-03-20 16:25:44', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('304', '10001', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/9421a522eeac4883813867ccde5d1cb4.jpg?imageView/2/w/416/interlace/1', '2016-03-20 16:25:44', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('303', '10001', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/64c68633df54140dbd09cd021ee9b5b9.jpg?imageView/2/w/416/interlace/1', '2016-03-20 16:25:44', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('302', '10001', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/330f0592f39c14702da8f2fddc52a032.jpg?imageView/2/w/416/interlace/1', '2016-03-20 16:25:44', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('301', '10001', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/866976864088af42f9014313d06bbf77.jpg?imageView/2/w/416/interlace/1', '2016-03-20 16:25:44', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('255', '10010', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/e2d09b3577f70bcbf769bca6666c3c43.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:22:59', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('263', '10011', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/59918a6cf26d581a0735ab0528e85a55.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:23:21', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('262', '10011', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/820a0c2e6837cc7902742ae06147d0d8.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:23:21', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('261', '10011', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/ac66b58dbe03cc7ad793b46301350334.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:23:21', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('260', '10011', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/d62dd935bcd1961ab62d465682e457bb.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:23:21', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('259', '10011', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/0e65fea48479e7da41432b9bb774bca0.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:23:21', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('109', '10012', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/b75134196cccd1a6fc88c1bfe2627b43.jpg?imageView/2/w/416/interlace/1', '2016-03-20 02:52:34', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('108', '10012', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/7dc328546712541f0febe4a4545ce145.jpg?imageView/2/w/416/interlace/1', '2016-03-20 02:52:34', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('107', '10012', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/f9cab1f105d6a9f58eeafcd9290bbfd7.jpg?imageView/2/w/416/interlace/1', '2016-03-20 02:52:34', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('106', '10012', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/fdac73029cc79af334bf8b0640ee4bd8.jpg?imageView/2/w/416/interlace/1', '2016-03-20 02:52:34', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('105', '10012', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/14b0409f86e08e4753c34664a1086ca1.jpg?imageView/2/w/416/interlace/1', '2016-03-20 02:52:34', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('269', '10013', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/4776a61e272714388dc7b065a3ceb39b.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:23:44', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('268', '10013', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/2271392d21bdd999e6a3ea480b29aa9b.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:23:44', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('267', '10013', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/c14e199c7e637d3154b91fbb54288a3f.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:23:44', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('266', '10013', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/d00100bffed51b375b637692832c061d.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:23:44', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('265', '10013', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/cd45e792142d6258d7150949bac81365.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:23:44', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('264', '10013', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/625edf645a7c9e04ff8ef24555eb3179.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:23:44', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('139', '10014', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/c1db41303a5eee78c6a162907b7abbbb.jpg?imageView/2/w/416/interlace/1', '2016-03-20 02:59:14', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('138', '10014', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/65b373715dc92a9fea62d3fa5ccf0a61.jpg?imageView/2/w/416/interlace/1', '2016-03-20 02:59:14', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('137', '10014', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/af9450deb5a36dc7b23dc3c30a2c74da.jpg?imageView/2/w/416/interlace/1', '2016-03-20 02:59:14', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('136', '10014', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/65cad638981b745dc650721008a30cb6.jpg?imageView/2/w/416/interlace/1', '2016-03-20 02:59:14', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('135', '10014', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/fbad59b9eeaf23cc8abf49b0b7bd048f.jpg?imageView/2/w/416/interlace/1', '2016-03-20 02:59:14', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('134', '10014', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/2ad130751aaeff8423bf3d2e4733f10d.jpg?imageView/2/w/416/interlace/1', '2016-03-20 02:59:14', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('273', '10015', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/1e1092bb153104ceb46eb88ae13e8ea0.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:24:05', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('272', '10015', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/844e3fbdbf4b909d8bac331e2f40d923.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:24:05', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('271', '10015', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/7e66f120c4225ed0de8312eb06692805.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:24:05', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('270', '10015', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/cb5c8464c08fea2958a9a44fb6378585.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:24:05', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('153', '10017', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/0ff07592e560f8d86f35486eeda10e63.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:00:53', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('152', '10017', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/bdb7240ed32d79b9516c29fdd5f57617.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:00:53', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('151', '10017', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/7f0aea198c645bc806fc95aad92c32c7.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:00:53', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('150', '10017', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2Qg90cVXXXXcgXXXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:00:53', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('149', '10017', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/aee42dacf63319a947e1795f4ffe4a5a.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:00:53', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('212', '10018', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/284c2430c41f248460fe123125210438.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:20:53', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('211', '10018', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a269f6556513e98e491c8f9eead13e8d.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:20:53', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('210', '10018', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB28jACaXXXXXbZXXXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:20:53', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('209', '10018', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/d7e8d30814364036a2e194e9d4dc0be1.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:20:53', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('208', '10020', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/fad231cc46a6370394305b348f90cb81.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:20:05', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('207', '10020', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/b29a40a3f583579fdf76be66c108e667.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:20:05', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('206', '10020', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/781b0e3d85cbe3b456dc7b9d8c736aca.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:20:05', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('205', '10020', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/f0d8144291cf2cf8775dfe297d55e705.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:20:05', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('204', '10020', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/09d7fcf1ba283ac6bec39b689c78a212.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:20:05', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('294', '10021', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/780351631779514a70bae1fdf25c4139.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:32:40', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('293', '10021', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/baada555e4e8aa0769b89bffeea9f6e8.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:32:40', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('292', '10021', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/ccdc66ca73bab2f4cb67b4c04ab51509.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:32:40', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('291', '10021', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/0fbc9429d5ccf0748ca5a5df7e48ea97.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:32:40', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('290', '10021', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/7c2b63718f0408b5308439c6c14c3e31.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:32:40', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('289', '10021', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/448a62f36833a1e51906e2aad40234a5.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:32:40', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('288', '10021', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/c60834843534de6135db5dd35caf4366.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:32:40', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('191', '10023', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/22c56205dc707ef0c4d5505dddc07f79.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:17:38', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('190', '10023', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/11e332376331ea716547af3ca572924b.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:17:38', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('189', '10023', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2ErHcVXXXXcfXXXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:17:38', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('188', '10023', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2dQ5AcFXXXXXlXXXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:17:38', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('187', '10023', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/87a645ff5692188338007c6747922a93.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:17:38', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('203', '10022', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/73688eac2b67ef212af124bf52bcbbf4.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:19:22', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('202', '10022', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/76257f616ac0935d8098786e8631aae5.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:19:22', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('201', '10022', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/c9ad8d6827eeb4a43b263547c3d81f3d.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:19:22', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('200', '10022', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/6889d3e74226cabc3cfcbb3305e59e3e.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:19:22', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('199', '10022', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/f7bd93f7b426875ab217edb7bcc19b52.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:19:22', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('198', '10022', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/d7ed7e65c2012d4d2ccd18c261133f86.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:19:22', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('222', '10024', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/89ba5d2dd2fa7cadf603db8feb06a79b.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:28:52', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('221', '10024', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2exwdXXXXXbHXpXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:28:52', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('220', '10024', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2LP8AbXXXXXbuXpXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:28:52', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('219', '10024', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2OXxDbXXXXXXBXpXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:28:52', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('218', '10024', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2lihCdFXXXXX.XpXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:28:52', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('300', '10025', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/2d9c7b0bf25022e69e9ebe1c169a5ea7.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:33:33', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('299', '10025', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/0bf2de342ce2c3734b349a57e4078d15.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:33:33', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('298', '10025', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/85992d96e74d4ec58f23e31759a454db.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:33:33', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('297', '10025', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/fb81fb9786ceeb66e1b0d5dc62991d23.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:33:33', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('296', '10025', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/49578348f144fd8d914f155e25db57c0.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:33:33', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('295', '10025', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/130b27b5d38de9d9c1017ed56d02dae7.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:33:33', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('240', '10026', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/af4c84b6cba85c2008777d5993f901d8.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:35:16', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('239', '10026', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/322d6224f5ba4e438719a5fa4084c8a5.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:35:16', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('238', '10026', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/c294f52da9a6e0340fa7b5b867bd717b.jpg?imageView/2/w/416/interlace/1', '2016-03-20 12:35:16', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('248', '10027', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2vlMocVXXXXX6XXXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 13:09:35', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('247', '10027', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2P4wYcXXXXXblXXXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 13:09:35', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('246', '10027', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2oyc0cXXXXXabXXXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 13:09:35', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('245', '10027', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/dbdbae49f7d87854578c4cf52f0e5ffd.jpg?imageView/2/w/416/interlace/1', '2016-03-20 13:09:35', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('249', '10028', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/4704fb20bc7dae5fe74a1e063fca4556.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:08:24', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('250', '10028', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2D.P3cVXXXXXoXpXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:08:24', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('251', '10028', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB266f1cVXXXXXXpXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:08:24', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('252', '10028', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2bhkdcVXXXXaUXXXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:08:24', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('253', '10029', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/2bb05b248e64ce3c79d3537bba3f26e3.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:10:17', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('254', '10029', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/T2ZVO3XepXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:10:17', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('274', '10016', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2RsohcFXXXXakXXXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:25:47', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('275', '10016', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/aee42dacf63319a947e1795f4ffe4a5a.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:25:47', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('276', '10016', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB28ei4dFXXXXb1XpXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:25:47', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('277', '10016', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2NBfbdFXXXXXMXpXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:25:47', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('278', '10016', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/74012b98652380535147cb4fba4570e2.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:25:47', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('279', '10016', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/c92001650e0ee58156361d6138ce9a40.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:25:47', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('280', '10016', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/ee036ead0144bda69e833dfc38823314.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:25:47', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('281', '10019', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/2b4634844cbac41c89cb3d6d60f2e96b.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:29:08', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('282', '10019', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB20wxgcXXXXXakXXXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:29:08', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('283', '10019', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2mZaHcpXXXXaeXXXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:29:08', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('284', '10019', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2nHMxcpXXXXblXpXXXXXXXXXX468359490.png?imageView/2/w/416/interlace/1', '2016-03-20 15:29:08', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('285', '10019', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2.mubdXXXXXXbXpXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:29:08', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('286', '10019', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/992d2130577d06950b6050727a7d2ad4.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:29:08', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('287', '10019', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/f10826828ce2688f6749ed0916987e1c.jpg?imageView/2/w/416/interlace/1', '2016-03-20 15:29:08', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('307', '10030', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/49984b72781c0d0b1b18c89ee318d07b.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:01:28', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('308', '10030', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/00e263cb1ffd6b32177460c3aa670b37.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:01:28', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('309', '10030', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/c44ed5af3e70e1c9875aea82cc3eeaa3.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:01:28', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('310', '10030', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/b3c1d614f4d8ce9b6eb8bd8671536a60.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:01:28', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('311', '10031', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/02f98b01062aeab43ed3016039ca578c.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:14:30', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('312', '10031', '1', '1', null, 'http://mallimg01.touchcdn.com/gallery/TB2uXVWaVXXXXXkXXXXXXXXXXXX468359490.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:14:30', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('313', '10031', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/dfbdee83cd0a5f883e9e600be375587b.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:14:30', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('314', '10031', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/710ea84011e981257601d4e35447c0a2.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:14:30', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('315', '10031', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a0402f7f10a0970e71423aeb7b0a5106.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:14:30', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('316', '10032', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/be760b80bcd4067931b8ce7d4f5430f9.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:29:18', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('317', '10032', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/0a60c3e180b94f86ead9c20993b3ebff.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:29:18', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('318', '10032', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/2b62628cad1c183f1e1101ca9d0408b0.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:29:18', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('319', '10032', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/05c9b769dc0b02ec529b0a57d6815c14.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:29:18', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('320', '10032', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/999ce53bd13ce4c0a34757cd21ed85e8.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:29:18', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('321', '10032', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/f1a1567080d6b06e96651ac87b91ce89.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:29:18', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('327', '10033', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a53c917d0b68d4e9039e592198db1495.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:40:58', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('326', '10033', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:40:58', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('325', '10033', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/f6031e0efdb9d15cbacb07b572a77073.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:40:58', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('328', '10034', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/fd944f54b22da916e62a79af9d455ab7.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:42:24', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('329', '10034', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/db8f022e18472b764f5d6d7fa3d1641c.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:42:24', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('330', '10034', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/78023b2fe2c32dafe98335c73992cfe0.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:42:24', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('331', '10034', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/07ea462a5db849d6510faa2db5455358.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:42:24', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('332', '10034', '1', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/e1d3761ffeccceee9836f78a4ae0172d.jpg?imageView/2/w/416/interlace/1', '2016-03-20 20:42:24', '2016-10-13 02:00:35');
INSERT INTO `t_pic` VALUES ('333', '1', '5', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/07ea462a5db849d6510faa2db5455358.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 01:58:53');
INSERT INTO `t_pic` VALUES ('334', '1', '5', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/dfbdee83cd0a5f883e9e600be375587b.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 01:58:53');
INSERT INTO `t_pic` VALUES ('335', '1', '5', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/2b62628cad1c183f1e1101ca9d0408b0.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 01:58:54');
INSERT INTO `t_pic` VALUES ('336', '1', '5', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/05c9b769dc0b02ec529b0a57d6815c14.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 01:58:55');
INSERT INTO `t_pic` VALUES ('337', '1', '5', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 01:58:56');
INSERT INTO `t_pic` VALUES ('338', '2', '5', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/78023b2fe2c32dafe98335c73992cfe0.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 01:58:57');
INSERT INTO `t_pic` VALUES ('339', '1', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/999ce53bd13ce4c0a34757cd21ed85e8.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:00:26');
INSERT INTO `t_pic` VALUES ('340', '1', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/78023b2fe2c32dafe98335c73992cfe0.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:01:11');
INSERT INTO `t_pic` VALUES ('341', '1', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:01:44');
INSERT INTO `t_pic` VALUES ('342', '1', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/05c9b769dc0b02ec529b0a57d6815c14.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:02:27');
INSERT INTO `t_pic` VALUES ('343', '2', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:02:55');
INSERT INTO `t_pic` VALUES ('344', '2', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/f6031e0efdb9d15cbacb07b572a77073.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:03:24');
INSERT INTO `t_pic` VALUES ('345', '2', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/07ea462a5db849d6510faa2db5455358.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:47');
INSERT INTO `t_pic` VALUES ('346', '2', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/2b62628cad1c183f1e1101ca9d0408b0.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:50');
INSERT INTO `t_pic` VALUES ('347', '3', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:53');
INSERT INTO `t_pic` VALUES ('348', '3', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:54');
INSERT INTO `t_pic` VALUES ('349', '4', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:54');
INSERT INTO `t_pic` VALUES ('350', '4', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:55');
INSERT INTO `t_pic` VALUES ('351', '4', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:55');
INSERT INTO `t_pic` VALUES ('352', '7', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:56');
INSERT INTO `t_pic` VALUES ('353', '7', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:57');
INSERT INTO `t_pic` VALUES ('354', '8', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:57');
INSERT INTO `t_pic` VALUES ('355', '8', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:06:00');
INSERT INTO `t_pic` VALUES ('356', '10', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:58');
INSERT INTO `t_pic` VALUES ('357', '10', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:58');
INSERT INTO `t_pic` VALUES ('358', '11', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:59');
INSERT INTO `t_pic` VALUES ('359', '11', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:05:59');
INSERT INTO `t_pic` VALUES ('360', '12', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/999ce53bd13ce4c0a34757cd21ed85e8.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:07:30');
INSERT INTO `t_pic` VALUES ('361', '12', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/999ce53bd13ce4c0a34757cd21ed85e8.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:07:30');
INSERT INTO `t_pic` VALUES ('362', '13', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/999ce53bd13ce4c0a34757cd21ed85e8.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:07:31');
INSERT INTO `t_pic` VALUES ('363', '12', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/999ce53bd13ce4c0a34757cd21ed85e8.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:07:32');
INSERT INTO `t_pic` VALUES ('364', '13', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/999ce53bd13ce4c0a34757cd21ed85e8.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:07:32');
INSERT INTO `t_pic` VALUES ('365', '13', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/999ce53bd13ce4c0a34757cd21ed85e8.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:07:33');
INSERT INTO `t_pic` VALUES ('366', '14', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/999ce53bd13ce4c0a34757cd21ed85e8.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:07:33');
INSERT INTO `t_pic` VALUES ('367', '14', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/999ce53bd13ce4c0a34757cd21ed85e8.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:07:34');
INSERT INTO `t_pic` VALUES ('368', '15', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/999ce53bd13ce4c0a34757cd21ed85e8.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:07:41');
INSERT INTO `t_pic` VALUES ('369', '15', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/999ce53bd13ce4c0a34757cd21ed85e8.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:07:34');
INSERT INTO `t_pic` VALUES ('370', '16', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/a533a0600a8cb736c600e844a3f09e06.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:08:53');
INSERT INTO `t_pic` VALUES ('371', '16', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/05c9b769dc0b02ec529b0a57d6815c14.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:09:13');
INSERT INTO `t_pic` VALUES ('372', '16', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/07ea462a5db849d6510faa2db5455358.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:08:57');
INSERT INTO `t_pic` VALUES ('373', '16', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/78023b2fe2c32dafe98335c73992cfe0.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:09:13');
INSERT INTO `t_pic` VALUES ('374', '16', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/07ea462a5db849d6510faa2db5455358.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:09:13');
INSERT INTO `t_pic` VALUES ('375', '16', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/e1d3761ffeccceee9836f78a4ae0172d.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:09:13');
INSERT INTO `t_pic` VALUES ('376', '16', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/07ea462a5db849d6510faa2db5455358.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:09:13');
INSERT INTO `t_pic` VALUES ('377', '16', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/dfbdee83cd0a5f883e9e600be375587b.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:09:13');
INSERT INTO `t_pic` VALUES ('378', '16', '3', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/2b62628cad1c183f1e1101ca9d0408b0.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2016-12-10 02:09:13');
INSERT INTO `t_pic` VALUES ('379', '1', '4', '1', null, 'http://mallimg01.touchcdn.com/goods-gallery/dfbdee83cd0a5f883e9e600be375587b.jpg?imageView/2/w/416/interlace/1', '1979-01-01 01:00:00', '2017-01-05 00:20:49');

-- ----------------------------
-- Table structure for t_post_company
-- ----------------------------
DROP TABLE IF EXISTS `t_post_company`;
CREATE TABLE `t_post_company` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `director` varchar(15) DEFAULT NULL COMMENT '负责人',
  `telephone` varchar(15) DEFAULT NULL COMMENT '联系电话',
  `api_url` varchar(255) DEFAULT NULL COMMENT '接口地址',
  `api_account` varchar(64) DEFAULT NULL COMMENT '接口帐号',
  `api_code` varchar(64) DEFAULT NULL COMMENT '接口代码|KEY',
  `api_password` varchar(36) DEFAULT NULL COMMENT '接口密码',
  `code` varchar(32) DEFAULT NULL COMMENT '快递公司编码(要跟快递100对应)',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_delivery_company_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='快递公司表';

-- ----------------------------
-- Records of t_post_company
-- ----------------------------
INSERT INTO `t_post_company` VALUES ('1', '顺丰快递', '1234', '1234', '1234', 'http://m.kuaidi100.com', '1234', 'admin', 'admin', 'shunfeng', '2016-03-16 11:51:49');
INSERT INTO `t_post_company` VALUES ('2', '圆通快递', 'asdfasd', 'asdf', 'asd', 'http://m.kuaidi100.com', 'asdf', 'sdf', '123456', 'yuantong', '2016-03-16 11:51:49');
INSERT INTO `t_post_company` VALUES ('3', '申通快递', '', '', '', '', '', '15999967925', '123456', 'shengtong', '2016-03-16 11:51:49');
INSERT INTO `t_post_company` VALUES ('4', '中通快递', '', '', '', '', '', '13510156885', '123456', 'zhongtong', '2016-03-16 11:51:49');
INSERT INTO `t_post_company` VALUES ('6', 'EMS', 'asdfasd', 'asdfad', '13888888888', 'http://m.kuaidi100.com', '1234', 'admin', 'admin', 'ems', '2016-03-16 11:51:49');
INSERT INTO `t_post_company` VALUES ('7', 'DHL', '123', '123', '123', 'http://m.kuaidi100.com', '123', '13510156885', '123456', 'dhl', '2016-04-07 13:44:13');
INSERT INTO `t_post_company` VALUES ('8', '韵达快递', '', '', '', '', '', '13510156885', '123456', 'yunda', '2016-04-12 16:51:27');

-- ----------------------------
-- Table structure for t_post_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_post_detail`;
CREATE TABLE `t_post_detail` (
  `post_code` varchar(50) NOT NULL DEFAULT '' COMMENT '快递单号',
  `context` varchar(256) DEFAULT NULL COMMENT '物流详情描述',
  `address_node` varchar(256) DEFAULT NULL COMMENT '地址节点',
  `time_node` timestamp NOT NULL DEFAULT '1979-01-01 01:00:00' COMMENT '物流时间节点',
  `push_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT 'kd100推送时间',
  `is_sign_in` char(1) DEFAULT NULL COMMENT '是否签收',
  `company_code` varchar(100) DEFAULT NULL,
  `delete_flag` char(1) DEFAULT 'N' COMMENT '删除标志',
  KEY `no_idx` (`post_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='快递单详情表';

-- ----------------------------
-- Records of t_post_detail
-- ----------------------------
INSERT INTO `t_post_detail` VALUES ('2233434545', '在[广东深圳公司罗湖区草埔分部]进行签收扫描，快件已被 拍照 签收', null, '2016-04-05 13:27:33', '2016-04-05 18:16:33', 'Y', 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在【广东深圳公司罗湖区草埔分部】进行派件扫描；派送业务员：蔡光华；联系电话：13590333051', null, '2016-04-05 08:49:24', '2016-04-05 18:16:33', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在广东深圳公司罗湖区草埔分部进行派件扫描；派送业务员：蔡光华；联系电话：13590333051', null, '2016-04-02 10:05:53', '2016-04-05 18:16:33', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '到达目的地网点广东深圳公司罗湖区草埔分部，快件将很快进行派送', null, '2016-04-02 08:08:06', '2016-04-05 18:16:33', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在广东深圳公司罗湖区东昌分拨分部进行快件扫描，将发往：广东深圳公司罗湖区草埔分部', null, '2016-04-02 06:27:53', '2016-04-05 18:16:33', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在广东深圳公司进行快件扫描，将发往：广东深圳公司罗湖区东昌分拨分部', null, '2016-04-02 02:40:15', '2016-04-05 18:16:33', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在分拨中心广东深圳公司进行卸车扫描', null, '2016-04-02 02:18:15', '2016-04-05 18:16:33', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在广东东莞分拨中心进行装车扫描，即将发往：广东深圳公司', null, '2016-04-01 23:22:50', '2016-04-05 18:16:33', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在分拨中心广东东莞分拨中心进行卸车扫描', null, '2016-04-01 23:21:33', '2016-04-05 18:16:33', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在安徽合肥分拨中心进行装车扫描，即将发往：广东东莞分拨中心', null, '2016-03-31 20:11:07', '2016-04-05 18:16:33', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在分拨中心安徽合肥分拨中心进行称重扫描', null, '2016-03-31 20:10:04', '2016-04-05 18:16:33', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在安徽长丰县公司进行到件扫描', null, '2016-03-31 14:06:34', '2016-04-05 18:16:33', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在【广东深圳公司罗湖区草埔分部】进行签收扫描，快件已被 拍照 签收', null, '2016-04-05 13:27:33', '2016-04-05 18:17:57', 'Y', 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在广东深圳公司罗湖区草埔分部进行派件扫描；派送业务员：蔡光华；联系电话：13590333051', null, '2016-04-05 08:49:24', '2016-04-05 18:17:57', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在广东深圳公司罗湖区草埔分部进行派件扫描；派送业务员：蔡光华；联系电话：13590333051', null, '2016-04-02 10:05:53', '2016-04-05 18:17:57', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '到达目的地网点广东深圳公司罗湖区草埔分部，快件将很快进行派送', null, '2016-04-02 08:08:06', '2016-04-05 18:17:57', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在广东深圳公司罗湖区东昌分拨分部进行快件扫描，将发往：广东深圳公司罗湖区草埔分部', null, '2016-04-02 06:27:53', '2016-04-05 18:17:57', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在广东深圳公司进行快件扫描，将发往：广东深圳公司罗湖区东昌分拨分部', null, '2016-04-02 02:40:15', '2016-04-05 18:17:57', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在[分拨中心广东深圳公司]进行卸车扫描', null, '2016-04-02 02:18:15', '2016-04-05 18:17:57', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在广东东莞分拨中心进行装车扫描，即将发往：广东深圳公司', null, '2016-04-01 23:22:50', '2016-04-05 18:17:57', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在分拨中心广东东莞分拨中心进行卸车扫描', null, '2016-04-01 23:21:33', '2016-04-05 18:17:57', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在安徽合肥分拨中心进行装车扫描，即将发往：广东东莞分拨中心', null, '2016-03-31 20:11:07', '2016-04-05 18:17:57', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在分拨中心安徽合肥分拨中心进行称重扫描', null, '2016-03-31 20:10:04', '2016-04-05 18:17:57', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('2233434545', '在安徽长丰县公司进行到件扫描', null, '2016-03-31 14:06:34', '2016-04-05 18:17:57', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('280415419409', '杭州市|签收|杭州市【BEX杭州江干区九堡分部】，刘 已签收', 'BEX杭州江干区九堡分部', '2016-03-25 13:24:55', '2016-04-06 19:11:08', 'Y', 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('280415419409', '杭州市|派件|杭州市【BEX杭州江干区九堡分部】，【刘家看/18967124498】正在派件', 'BEX杭州江干区九堡分部', '2016-03-25 09:33:46', '2016-04-06 19:11:08', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('280415419409', '杭州市|到件|到杭州市【BEX杭州江干区九堡分部】', 'BEX杭州江干区九堡分部', '2016-03-25 07:42:15', '2016-04-06 19:11:08', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('280415419409', '杭州市|发件|杭州市【杭州转运中心】，正发往【BEX杭州江干区九堡分部】', '杭州转运中心', '2016-03-25 03:17:27', '2016-04-06 19:11:08', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('280415419409', '杭州市|到件|到杭州市【杭州转运中心】', '杭州转运中心', '2016-03-25 02:48:55', '2016-04-06 19:11:08', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('280415419409', '深圳市|发件|深圳市【深圳转运中心】，正发往【杭州转运中心】', '深圳转运中心', '2016-03-24 01:47:27', '2016-04-06 19:11:08', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('280415419409', '深圳市|到件|到深圳市【深圳转运中心】', '深圳转运中心', '2016-03-24 01:42:21', '2016-04-06 19:11:08', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('280415419409', '深圳市|收件|深圳市【深圳罗湖中心站】，【李艺/18826528012】已揽收', '深圳罗湖中心站', '2016-03-23 22:27:24', '2016-04-06 19:11:08', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '从湖南省衡阳分拨点发出，本次转运目的地：湖南永州公司', null, '2016-04-07 08:22:10', '2016-04-07 11:11:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在湖南长沙分拨中心进行装车扫描，即将发往：湖南省衡阳分拨点', null, '2016-04-06 23:57:57', '2016-04-07 11:11:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在分拨中心湖南长沙分拨中心进行称重扫描', null, '2016-04-06 23:50:14', '2016-04-07 11:11:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在湖南长沙分拨中心进行中转集包扫描，将发往：湖南省衡阳分拨点', null, '2016-04-06 23:42:04', '2016-04-07 11:11:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华金丽衢管理公司进行装车扫描，即将发往：湖南长沙分拨中心', null, '2016-04-04 23:18:19', '2016-04-07 11:11:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华金丽衢管理公司进行装车扫描，即将发往：湖南长沙分拨中心', null, '2016-04-04 22:44:48', '2016-04-07 11:11:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行到件扫描', null, '2016-04-04 21:49:33', '2016-04-07 11:11:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行到件扫描', null, '2016-04-04 21:46:38', '2016-04-07 11:11:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行下级地点扫描，将发往：湖南省衡阳分拨点', null, '2016-04-04 20:56:09', '2016-04-07 11:11:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行下级地点扫描，将发往：湖南长沙分拨中心', null, '2016-04-04 20:48:12', '2016-04-07 11:11:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行到件扫描', null, '2016-04-04 15:15:45', '2016-04-07 11:11:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '从湖南省衡阳分拨点发出，本次转运目的地：湖南永州公司', null, '2016-04-07 08:22:10', '2016-04-07 12:11:13', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]海关状态更新', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 06:44:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在湖南长沙分拨中心进行装车扫描，即将发往：湖南省衡阳分拨点', null, '2016-04-06 23:57:57', '2016-04-07 12:11:13', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]离开转运地 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 01:52:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在分拨中心湖南长沙分拨中心进行称重扫描', null, '2016-04-06 23:50:14', '2016-04-07 12:11:13', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]正在（已经）安排下一站的转运 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 01:51:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在湖南长沙分拨中心进行中转集包扫描，将发往：湖南省衡阳分拨点', null, '2016-04-06 23:42:04', '2016-04-07 12:11:13', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]快件已完成清关手续并从海关放行 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 00:05:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华金丽衢管理公司进行装车扫描，即将发往：湖南长沙分拨中心', null, '2016-04-04 23:18:19', '2016-04-07 12:11:13', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]快件到达中转中心 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-06 23:52:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华金丽衢管理公司进行装车扫描，即将发往：湖南长沙分拨中心', null, '2016-04-04 22:44:48', '2016-04-07 12:11:13', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]海关状态更新', '[HONG KONG - HONG KONG]', '2016-04-06 19:58:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行到件扫描', null, '2016-04-04 21:49:33', '2016-04-07 12:11:13', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]离开转运地 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 06:31:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行到件扫描', null, '2016-04-04 21:46:38', '2016-04-07 12:11:13', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]正在（已经）安排下一站的转运 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 02:48:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行下级地点扫描，将发往：湖南省衡阳分拨点', null, '2016-04-04 20:56:09', '2016-04-07 12:11:13', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]快件到达中转中心 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 02:28:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行下级地点扫描，将发往：湖南长沙分拨中心', null, '2016-04-04 20:48:12', '2016-04-07 12:11:13', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]离开转运地 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-06 00:26:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行到件扫描', null, '2016-04-04 15:15:45', '2016-04-07 12:11:13', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]正在（已经）安排下一站的转运 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-05 22:40:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]快件到达中转中心 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-05 21:05:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]离开转运地 VERONA - ITALY', '[VERONA - ITALY]', '2016-04-05 19:43:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]正在（已经）安排下一站的转运 VERONA - ITALY', '[VERONA - ITALY]', '2016-04-05 19:43:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]快件已从发件人处提取', '[VERONA - ITALY]', '2016-04-05 16:51:00', '2016-04-07 12:11:13', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '已签收,感谢使用顺丰,期待再次为您服务', null, '2016-03-23 11:36:08', '2016-04-07 12:16:42', 'Y', 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '正在派送途中,请您准备签收(派件人:许司强,电话:13561723026)', null, '2016-03-23 07:58:47', '2016-04-07 12:16:42', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '快件到达 【济南历城集散中心】', '【济南历城集散中心】', '2016-03-22 15:50:24', '2016-04-07 12:16:42', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '快件离开【潍坊奎文集散中心】,正发往 【济南历城集散中心】', '【潍坊奎文集散中心】', '2016-03-22 10:56:47', '2016-04-07 12:16:42', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '快件到达 【潍坊奎文集散中心】', '【潍坊奎文集散中心】', '2016-03-22 10:56:17', '2016-04-07 12:16:42', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '快件离开【深圳总集散中心】,正发往下一站', '【深圳总集散中心】', '2016-03-22 01:01:44', '2016-04-07 12:16:42', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '快件到达 【深圳总集散中心】', '【深圳总集散中心】', '2016-03-22 00:44:17', '2016-04-07 12:16:42', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '快件离开【深圳罗湖田贝花园营业部】,正发往下一站', '【深圳罗湖田贝花园营业部】', '2016-03-21 20:28:53', '2016-04-07 12:16:42', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '顺丰速运 已收取快件', null, '2016-03-21 14:22:41', '2016-04-07 12:16:42', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]海关状态更新', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 06:44:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]离开转运地 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 01:52:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]正在（已经）安排下一站的转运 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 01:51:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '从湖南省衡阳分拨点发出，本次转运目的地：湖南永州公司', null, '2016-04-07 08:22:10', '2016-04-07 12:42:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '已签收,感谢使用顺丰,期待再次为您服务', null, '2016-03-23 11:36:08', '2016-04-07 12:42:06', 'Y', 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]快件已完成清关手续并从海关放行 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 00:05:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在湖南长沙分拨中心进行装车扫描，即将发往：湖南省衡阳分拨点', null, '2016-04-06 23:57:57', '2016-04-07 12:42:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '正在派送途中,请您准备签收(派件人:许司强,电话:13561723026)', null, '2016-03-23 07:58:47', '2016-04-07 12:42:06', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]快件到达中转中心 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-06 23:52:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在分拨中心湖南长沙分拨中心进行称重扫描', null, '2016-04-06 23:50:14', '2016-04-07 12:42:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '快件到达 【济南历城集散中心】', '【济南历城集散中心】', '2016-03-22 15:50:24', '2016-04-07 12:42:06', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]海关状态更新', '[HONG KONG - HONG KONG]', '2016-04-06 19:58:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在湖南长沙分拨中心进行中转集包扫描，将发往：湖南省衡阳分拨点', null, '2016-04-06 23:42:04', '2016-04-07 12:42:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]离开转运地 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 06:31:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '快件离开【潍坊奎文集散中心】,正发往 【济南历城集散中心】', '【潍坊奎文集散中心】', '2016-03-22 10:56:47', '2016-04-07 12:42:06', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华金丽衢管理公司进行装车扫描，即将发往：湖南长沙分拨中心', null, '2016-04-04 23:18:19', '2016-04-07 12:42:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]正在（已经）安排下一站的转运 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 02:48:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '快件到达 【潍坊奎文集散中心】', '【潍坊奎文集散中心】', '2016-03-22 10:56:17', '2016-04-07 12:42:06', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华金丽衢管理公司进行装车扫描，即将发往：湖南长沙分拨中心', null, '2016-04-04 22:44:48', '2016-04-07 12:42:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]快件到达中转中心 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 02:28:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '快件离开【深圳总集散中心】,正发往下一站', '【深圳总集散中心】', '2016-03-22 01:01:44', '2016-04-07 12:42:06', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行到件扫描', null, '2016-04-04 21:49:33', '2016-04-07 12:42:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]离开转运地 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-06 00:26:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '快件到达 【深圳总集散中心】', '【深圳总集散中心】', '2016-03-22 00:44:17', '2016-04-07 12:42:06', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行到件扫描', null, '2016-04-04 21:46:38', '2016-04-07 12:42:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]正在（已经）安排下一站的转运 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-05 22:40:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '快件离开【深圳罗湖田贝花园营业部】,正发往下一站', '【深圳罗湖田贝花园营业部】', '2016-03-21 20:28:53', '2016-04-07 12:42:06', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行下级地点扫描，将发往：湖南省衡阳分拨点', null, '2016-04-04 20:56:09', '2016-04-07 12:42:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]快件到达中转中心 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-05 21:05:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('033499400503', '顺丰速运 已收取快件', null, '2016-03-21 14:22:41', '2016-04-07 12:42:06', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行下级地点扫描，将发往：湖南长沙分拨中心', null, '2016-04-04 20:48:12', '2016-04-07 12:42:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]离开转运地 VERONA - ITALY', '[VERONA - ITALY]', '2016-04-05 19:43:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行到件扫描', null, '2016-04-04 15:15:45', '2016-04-07 12:42:06', null, 'yunda', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]正在（已经）安排下一站的转运 VERONA - ITALY', '[VERONA - ITALY]', '2016-04-05 19:43:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]快件已从发件人处提取', '[VERONA - ITALY]', '2016-04-05 16:51:00', '2016-04-07 12:42:06', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]快件已完成清关手续并从海关放行 SHENZHEN - CHINA, PEOPLES REPUBLIC', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 17:33:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]清关流程', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 17:18:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]快件到达中转中心 SHENZHEN - CHINA, PEOPLES REPUBLIC', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 17:16:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]海关状态更新', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 06:44:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]离开转运地 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 01:52:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]正在（已经）安排下一站的转运 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 01:51:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]快件已完成清关手续并从海关放行 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 00:05:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]快件到达中转中心 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-06 23:52:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]海关状态更新', '[HONG KONG - HONG KONG]', '2016-04-06 19:58:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]离开转运地 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 06:31:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]正在（已经）安排下一站的转运 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 02:48:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]快件到达中转中心 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 02:28:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]离开转运地 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-06 00:26:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]正在（已经）安排下一站的转运 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-05 22:40:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]快件到达中转中心 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-05 21:05:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]离开转运地 VERONA - ITALY', '[VERONA - ITALY]', '2016-04-05 19:43:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]正在（已经）安排下一站的转运 VERONA - ITALY', '[VERONA - ITALY]', '2016-04-05 19:43:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]快件已从发件人处提取', '[VERONA - ITALY]', '2016-04-05 16:51:00', '2016-04-07 20:27:09', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]离开转运地 SHENZHEN - CHINA, PEOPLES REPUBLIC', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-08 00:44:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]正在（已经）安排下一站的转运 SHENZHEN - CHINA, PEOPLES REPUBLIC', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-08 00:44:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]快件已完成清关手续并从海关放行 SHENZHEN - CHINA, PEOPLES REPUBLIC', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 17:33:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]清关流程', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 17:18:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]快件到达中转中心 SHENZHEN - CHINA, PEOPLES REPUBLIC', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 17:16:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]海关状态更新', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 06:44:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]离开转运地 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 01:52:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]正在（已经）安排下一站的转运 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 01:51:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]快件已完成清关手续并从海关放行 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 00:05:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]快件到达中转中心 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-06 23:52:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]海关状态更新', '[HONG KONG - HONG KONG]', '2016-04-06 19:58:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]离开转运地 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 06:31:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]正在（已经）安排下一站的转运 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 02:48:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]快件到达中转中心 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 02:28:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]离开转运地 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-06 00:26:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]正在（已经）安排下一站的转运 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-05 22:40:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]快件到达中转中心 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-05 21:05:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]离开转运地 VERONA - ITALY', '[VERONA - ITALY]', '2016-04-05 19:43:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]正在（已经）安排下一站的转运 VERONA - ITALY', '[VERONA - ITALY]', '2016-04-05 19:43:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]快件已从发件人处提取', '[VERONA - ITALY]', '2016-04-05 16:51:00', '2016-04-08 08:13:37', null, 'dhl', 'Y');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[Shenzhen                           ]已派送并签收: ZHOU JINQIU', '[Shenzhen                           ]', '2016-04-08 11:08:00', '2016-04-08 13:28:26', 'Y', 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]快件正在派送中', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-08 10:05:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]快件已经到达派送作业地点 SHENZHEN - CHINA, PEOPLES REPUBLIC', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-08 08:34:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]离开转运地 SHENZHEN - CHINA, PEOPLES REPUBLIC', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-08 00:44:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]正在（已经）安排下一站的转运 SHENZHEN - CHINA, PEOPLES REPUBLIC', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-08 00:44:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]快件已完成清关手续并从海关放行 SHENZHEN - CHINA, PEOPLES REPUBLIC', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 17:33:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]清关流程', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 17:18:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]快件到达中转中心 SHENZHEN - CHINA, PEOPLES REPUBLIC', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 17:16:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]海关状态更新', '[SHENZHEN - CHINA, PEOPLES REPUBLIC]', '2016-04-07 06:44:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]离开转运地 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 01:52:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]正在（已经）安排下一站的转运 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 01:51:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]快件已完成清关手续并从海关放行 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-07 00:05:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]快件到达中转中心 HONG KONG - HONG KONG', '[HONG KONG - HONG KONG]', '2016-04-06 23:52:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[HONG KONG - HONG KONG]海关状态更新', '[HONG KONG - HONG KONG]', '2016-04-06 19:58:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]离开转运地 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 06:31:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]正在（已经）安排下一站的转运 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 02:48:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[LEIPZIG - GERMANY]快件到达中转中心 LEIPZIG - GERMANY', '[LEIPZIG - GERMANY]', '2016-04-06 02:28:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]离开转运地 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-06 00:26:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]正在（已经）安排下一站的转运 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-05 22:40:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[BERGAMO - ITALY]快件到达中转中心 BERGAMO - ITALY', '[BERGAMO - ITALY]', '2016-04-05 21:05:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]离开转运地 VERONA - ITALY', '[VERONA - ITALY]', '2016-04-05 19:43:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]正在（已经）安排下一站的转运 VERONA - ITALY', '[VERONA - ITALY]', '2016-04-05 19:43:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('7593897054', '[VERONA - ITALY]快件已从发件人处提取', '[VERONA - ITALY]', '2016-04-05 16:51:00', '2016-04-08 13:28:26', null, 'dhl', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在湖南永州公司进行签收扫描，快件已被 拍照 签收', null, '2016-04-08 11:42:21', '2016-04-08 14:03:19', 'Y', 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在湖南永州公司进行派件扫描；派送业务员：屈伟；联系电话：400-821-6789', null, '2016-04-08 11:08:12', '2016-04-08 14:03:19', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '从湖南省衡阳分拨点发出，本次转运目的地：湖南永州公司', null, '2016-04-07 08:22:10', '2016-04-08 14:03:19', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在湖南长沙分拨中心进行装车扫描，即将发往：湖南省衡阳分拨点', null, '2016-04-06 23:57:57', '2016-04-08 14:03:19', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在分拨中心湖南长沙分拨中心进行称重扫描', null, '2016-04-06 23:50:14', '2016-04-08 14:03:19', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在湖南长沙分拨中心进行中转集包扫描，将发往：湖南省衡阳分拨点', null, '2016-04-06 23:42:04', '2016-04-08 14:03:19', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华金丽衢管理公司进行装车扫描，即将发往：湖南长沙分拨中心', null, '2016-04-04 23:18:19', '2016-04-08 14:03:19', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华金丽衢管理公司进行装车扫描，即将发往：湖南长沙分拨中心', null, '2016-04-04 22:44:48', '2016-04-08 14:03:19', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行到件扫描', null, '2016-04-04 21:49:33', '2016-04-08 14:03:19', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行到件扫描', null, '2016-04-04 21:46:38', '2016-04-08 14:03:19', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行下级地点扫描，将发往：湖南省衡阳分拨点', null, '2016-04-04 20:56:09', '2016-04-08 14:03:19', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行下级地点扫描，将发往：湖南长沙分拨中心', null, '2016-04-04 20:48:12', '2016-04-08 14:03:19', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3101001894999', '在浙江金华江北公司进行到件扫描', null, '2016-04-04 15:15:45', '2016-04-08 14:03:19', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件到达 【石家庄高开集散中心】', '【石家庄高开集散中心】', '2016-04-08 14:18:28', '2016-04-08 18:25:33', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件离开【上海虹桥集散中心】,正发往 【石家庄高开集散中心】', '【上海虹桥集散中心】', '2016-04-08 03:58:44', '2016-04-08 18:25:33', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件到达 【上海虹桥集散中心】', '【上海虹桥集散中心】', '2016-04-07 22:40:55', '2016-04-08 18:25:33', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件离开【上海虹桥集散中心2】,正发往 【上海虹桥集散中心】', '【上海虹桥集散中心2】', '2016-04-07 21:42:07', '2016-04-08 18:25:33', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件到达 【上海虹桥集散中心2】', '【上海虹桥集散中心2】', '2016-04-07 21:14:50', '2016-04-08 18:25:33', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件离开【上海青浦凤溪营业点】,正发往 【上海虹桥集散中心2】', '【上海青浦凤溪营业点】', '2016-04-07 20:18:25', '2016-04-08 18:25:33', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('922846260341', '顺丰速运 已收取快件', null, '2016-04-07 19:41:01', '2016-04-08 18:25:33', null, 'shunfeng', 'Y');
INSERT INTO `t_post_detail` VALUES ('922846260341', '已签收,感谢使用顺丰,期待再次为您服务', null, '2016-04-09 10:26:04', '2016-04-11 11:41:22', 'Y', 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('922846260341', '正在派送途中,请您准备签收(派件人:赵红亮,电话:18831955650)', null, '2016-04-09 08:07:22', '2016-04-11 11:41:22', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件到达 【邢台桥西区达活泉营业点】', '【邢台桥西区达活泉营业点】', '2016-04-09 07:30:24', '2016-04-11 11:41:22', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件离开【邢台高新集散中心】,正发往 【邢台桥西区达活泉营业点】', '【邢台高新集散中心】', '2016-04-09 06:39:27', '2016-04-11 11:41:22', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件到达 【邢台高新集散中心】', '【邢台高新集散中心】', '2016-04-09 04:29:17', '2016-04-11 11:41:22', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件离开【石家庄高开集散中心】,正发往 【邢台高新集散中心】', '【石家庄高开集散中心】', '2016-04-09 00:48:09', '2016-04-11 11:41:22', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件到达 【石家庄高开集散中心】', '【石家庄高开集散中心】', '2016-04-08 14:18:28', '2016-04-11 11:41:22', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件离开【上海虹桥集散中心】,正发往 【石家庄高开集散中心】', '【上海虹桥集散中心】', '2016-04-08 03:58:44', '2016-04-11 11:41:22', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件到达 【上海虹桥集散中心】', '【上海虹桥集散中心】', '2016-04-07 22:40:55', '2016-04-11 11:41:22', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件离开【上海虹桥集散中心2】,正发往 【上海虹桥集散中心】', '【上海虹桥集散中心2】', '2016-04-07 21:42:07', '2016-04-11 11:41:22', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件到达 【上海虹桥集散中心2】', '【上海虹桥集散中心2】', '2016-04-07 21:14:50', '2016-04-11 11:41:22', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('922846260341', '快件离开【上海青浦凤溪营业点】,正发往 【上海虹桥集散中心2】', '【上海青浦凤溪营业点】', '2016-04-07 20:18:25', '2016-04-11 11:41:22', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('922846260341', '顺丰速运 已收取快件', null, '2016-04-07 19:41:01', '2016-04-11 11:41:22', null, 'shunfeng', 'N');
INSERT INTO `t_post_detail` VALUES ('3927940012289', '[广东深圳公司]进行快件扫描，将发往：广东深圳公司罗湖区东昌分拨分部', '[广东深圳公司]', '2016-04-14 05:32:58', '2016-04-14 08:16:37', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3927940012289', '[广东深圳公司]在分拨中心进行卸车扫描', '[广东深圳公司]', '2016-04-13 23:16:21', '2016-04-14 08:16:37', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3927940012289', '[江西南昌分拨中心]进行装车扫描，即将发往：广东深圳公司', '[江西南昌分拨中心]', '2016-04-12 20:53:50', '2016-04-14 08:16:37', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3927940012289', '[江西南昌分拨中心]在分拨中心进行称重扫描', '[江西南昌分拨中心]', '2016-04-12 20:52:00', '2016-04-14 08:16:37', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3927940012289', '[江西南昌青山湖区高新公司]进行揽件扫描', '[江西南昌青山湖区高新公司]', '2016-04-12 19:30:39', '2016-04-14 08:16:37', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3927940012289', '[江西南昌青山湖区高新公司京东万科分部]进行下级地点扫描，将发往：广东深圳公司', '[江西南昌青山湖区高新公司京东万科分部]', '2016-04-12 19:12:09', '2016-04-14 08:16:37', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3927940012289', '[江西南昌青山湖区高新公司]进行揽件扫描', '[江西南昌青山湖区高新公司]', '2016-04-12 18:46:49', '2016-04-14 08:16:37', null, 'yunda', 'N');
INSERT INTO `t_post_detail` VALUES ('3310511459197', '湖北武汉公司(027-83225888) 的收件员 汉口吴燕飞 已收件', '', '2016-06-29 13:53:56', '2016-06-30 10:33:55', '', 'shengtong', 'N');
INSERT INTO `t_post_detail` VALUES ('3310511459197', '湖北武汉公司(027-83225888) 的收件员 汉口吴燕飞 已收件', '', '2016-06-29 13:53:56', '2016-06-30 10:34:37', '', 'shengtong', 'N');
INSERT INTO `t_post_detail` VALUES ('3310511459197', '湖北武汉公司(027-83225888) 的收件员 汉口吴燕飞 已收件', '', '2016-06-29 13:53:56', '2016-06-30 10:34:37', '', 'shengtong', 'N');
INSERT INTO `t_post_detail` VALUES ('3310511459197', '湖北武汉公司(027-83225888) 的收件员 汉口吴燕飞 已收件', '', '2016-06-29 13:53:56', '2016-06-30 01:06:41', '', 'shengtong', 'N');
INSERT INTO `t_post_detail` VALUES ('3310511459197', '快件已到达 湖北武汉航空部', '', '2016-06-29 16:01:39', '2016-06-30 01:06:41', '', 'shengtong', 'N');
INSERT INTO `t_post_detail` VALUES ('3310511459197', '湖北武汉航空部 正在进行 装袋 扫描', '', '2016-06-29 19:06:49', '2016-06-30 01:06:41', '', 'shengtong', 'N');
INSERT INTO `t_post_detail` VALUES ('3310511459197', '由 湖北武汉航空部 发往 广东深圳公司', '', '2016-06-29 19:06:49', '2016-06-30 01:06:41', '', 'shengtong', 'N');
INSERT INTO `t_post_detail` VALUES ('3310511459197', '由 湖北武汉航空部 发往 广东东莞中转部', '', '2016-06-30 01:00:41', '2016-06-30 01:06:41', '', 'shengtong', 'N');
INSERT INTO `t_post_detail` VALUES ('3310511459197', '湖北武汉公司(027-83225888) 的收件员 汉口吴燕飞 已收件', null, '2016-06-29 13:53:56', '2016-06-30 01:06:41', null, 'shengtong', 'N');
INSERT INTO `t_post_detail` VALUES ('3310511459197', '快件已到达 湖北武汉航空部', null, '2016-06-29 16:01:39', '2016-06-30 01:06:41', null, 'shengtong', 'N');
INSERT INTO `t_post_detail` VALUES ('3310511459197', '湖北武汉航空部 正在进行 装袋 扫描', null, '2016-06-29 19:06:49', '2016-06-30 01:06:41', null, 'shengtong', 'N');
INSERT INTO `t_post_detail` VALUES ('3310511459197', '由 湖北武汉航空部 发往 广东深圳公司', null, '2016-06-29 19:06:49', '2016-06-30 01:06:41', null, 'shengtong', 'N');
INSERT INTO `t_post_detail` VALUES ('3310511459197', '由 湖北武汉航空部 发往 广东东莞中转部', null, '2016-06-30 01:00:41', '2016-06-30 01:06:41', null, 'shengtong', 'N');

-- ----------------------------
-- Table structure for t_problem
-- ----------------------------
DROP TABLE IF EXISTS `t_problem`;
CREATE TABLE `t_problem` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goods_id` int(10) DEFAULT NULL COMMENT '商品类型',
  `user_id` int(10) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `question` varchar(225) DEFAULT NULL COMMENT '活动详情',
  `answer` varchar(225) DEFAULT NULL,
  `admin_id` int(10) DEFAULT NULL,
  `admin_name` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='活动';

-- ----------------------------
-- Records of t_problem
-- ----------------------------

-- ----------------------------
-- Table structure for t_region
-- ----------------------------
DROP TABLE IF EXISTS `t_region`;
CREATE TABLE `t_region` (
  `region_id` double NOT NULL,
  `region_code` varchar(100) NOT NULL COMMENT '身份证码',
  `region_name` varchar(100) NOT NULL,
  `parent_id` double NOT NULL,
  `region_level` double NOT NULL,
  `region_order` double NOT NULL,
  `region_name_en` varchar(100) NOT NULL,
  `region_shortname_en` varchar(10) NOT NULL,
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_region
-- ----------------------------
INSERT INTO `t_region` VALUES ('1', '中国', '中国', '0', '0', '0', 'Zhong Guo', '2');
INSERT INTO `t_region` VALUES ('2', '110000', '北京市', '1', '0', '0', 'Beijing Shi', 'BJ');
INSERT INTO `t_region` VALUES ('3', '120000', '天津市', '1', '0', '0', 'Tianjin Shi', 'TJ');
INSERT INTO `t_region` VALUES ('4', '130000', '河北省', '1', '0', '0', 'Hebei Sheng', 'HE');
INSERT INTO `t_region` VALUES ('5', '140000', '山西省', '1', '0', '0', 'Shanxi Sheng ', 'SX');
INSERT INTO `t_region` VALUES ('6', '150000', '内蒙古自治区', '1', '0', '0', 'Nei Mongol Zizhiqu', 'NM');
INSERT INTO `t_region` VALUES ('7', '210000', '辽宁省', '1', '0', '0', 'Liaoning Sheng', 'LN');
INSERT INTO `t_region` VALUES ('8', '220000', '吉林省', '1', '0', '0', 'Jilin Sheng', 'JL');
INSERT INTO `t_region` VALUES ('9', '230000', '黑龙江省', '1', '0', '0', 'Heilongjiang Sheng', 'HL');
INSERT INTO `t_region` VALUES ('10', '310000', '上海市', '1', '0', '0', 'Shanghai Shi', 'SH');
INSERT INTO `t_region` VALUES ('11', '320000', '江苏省', '1', '0', '0', 'Jiangsu Sheng', 'JS');
INSERT INTO `t_region` VALUES ('12', '330000', '浙江省', '1', '0', '0', 'Zhejiang Sheng', 'ZJ');
INSERT INTO `t_region` VALUES ('13', '340000', '安徽省', '1', '0', '0', 'Anhui Sheng', 'AH');
INSERT INTO `t_region` VALUES ('14', '350000', '福建省', '1', '0', '0', 'Fujian Sheng ', 'FJ');
INSERT INTO `t_region` VALUES ('15', '360000', '江西省', '1', '0', '0', 'Jiangxi Sheng', 'JX');
INSERT INTO `t_region` VALUES ('16', '370000', '山东省', '1', '0', '0', 'Shandong Sheng ', 'SD');
INSERT INTO `t_region` VALUES ('17', '410000', '河南省', '1', '0', '0', 'Henan Sheng', 'HA');
INSERT INTO `t_region` VALUES ('18', '420000', '湖北省', '1', '0', '0', 'Hubei Sheng', 'HB');
INSERT INTO `t_region` VALUES ('19', '430000', '湖南省', '1', '0', '0', 'Hunan Sheng', 'HN');
INSERT INTO `t_region` VALUES ('20', '440000', '广东省', '1', '0', '0', 'Guangdong Sheng', 'GD');
INSERT INTO `t_region` VALUES ('21', '450000', '广西壮族自治区', '1', '0', '0', 'Guangxi Zhuangzu Zizhiqu', 'GX');
INSERT INTO `t_region` VALUES ('22', '460000', '海南省', '1', '0', '0', 'Hainan Sheng', 'HI');
INSERT INTO `t_region` VALUES ('23', '500000', '重庆市', '1', '0', '0', 'Chongqing Shi', 'CQ');
INSERT INTO `t_region` VALUES ('24', '510000', '四川省', '1', '0', '0', 'Sichuan Sheng', 'SC');
INSERT INTO `t_region` VALUES ('25', '520000', '贵州省', '1', '0', '0', 'Guizhou Sheng', 'GZ');
INSERT INTO `t_region` VALUES ('26', '530000', '云南省', '1', '0', '0', 'Yunnan Sheng', 'YN');
INSERT INTO `t_region` VALUES ('27', '540000', '西藏自治区', '1', '0', '0', 'Xizang Zizhiqu', 'XZ');
INSERT INTO `t_region` VALUES ('28', '610000', '陕西省', '1', '0', '0', 'Shanxi Sheng ', 'SN');
INSERT INTO `t_region` VALUES ('29', '620000', '甘肃省', '1', '0', '0', 'Gansu Sheng', 'GS');
INSERT INTO `t_region` VALUES ('30', '630000', '青海省', '1', '0', '0', 'Qinghai Sheng', 'QH');
INSERT INTO `t_region` VALUES ('31', '640000', '宁夏回族自治区', '1', '0', '0', 'Ningxia Huizu Zizhiqu', 'NX');
INSERT INTO `t_region` VALUES ('32', '650000', '新疆维吾尔自治区', '1', '0', '0', 'Xinjiang Uygur Zizhiqu', 'XJ');
INSERT INTO `t_region` VALUES ('33', '110100', '市辖区', '2', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('34', '110200', '县', '2', '0', '0', 'Xian', '2');
INSERT INTO `t_region` VALUES ('35', '120100', '市辖区', '3', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('36', '120200', '县', '3', '0', '0', 'Xian', '2');
INSERT INTO `t_region` VALUES ('37', '130100', '石家庄市', '4', '0', '0', 'Shijiazhuang Shi', 'SJW');
INSERT INTO `t_region` VALUES ('38', '130200', '唐山市', '4', '0', '0', 'Tangshan Shi', 'TGS');
INSERT INTO `t_region` VALUES ('39', '130300', '秦皇岛市', '4', '0', '0', 'Qinhuangdao Shi', 'SHP');
INSERT INTO `t_region` VALUES ('40', '130400', '邯郸市', '4', '0', '0', 'Handan Shi', 'HDS');
INSERT INTO `t_region` VALUES ('41', '130500', '邢台市', '4', '0', '0', 'Xingtai Shi', 'XTS');
INSERT INTO `t_region` VALUES ('42', '130600', '保定市', '4', '0', '0', 'Baoding Shi', 'BDS');
INSERT INTO `t_region` VALUES ('43', '130700', '张家口市', '4', '0', '0', 'Zhangjiakou Shi ', 'ZJK');
INSERT INTO `t_region` VALUES ('44', '130800', '承德市', '4', '0', '0', 'Chengde Shi', 'CDS');
INSERT INTO `t_region` VALUES ('45', '130900', '沧州市', '4', '0', '0', 'Cangzhou Shi', 'CGZ');
INSERT INTO `t_region` VALUES ('46', '131000', '廊坊市', '4', '0', '0', 'Langfang Shi', 'LFS');
INSERT INTO `t_region` VALUES ('47', '131100', '衡水市', '4', '0', '0', 'Hengshui Shi ', 'HGS');
INSERT INTO `t_region` VALUES ('48', '140100', '太原市', '5', '0', '0', 'Taiyuan Shi', 'TYN');
INSERT INTO `t_region` VALUES ('49', '140200', '大同市', '5', '0', '0', 'Datong Shi ', 'DTG');
INSERT INTO `t_region` VALUES ('50', '140300', '阳泉市', '5', '0', '0', 'Yangquan Shi', 'YQS');
INSERT INTO `t_region` VALUES ('51', '140400', '长治市', '5', '0', '0', 'Changzhi Shi', 'CZS');
INSERT INTO `t_region` VALUES ('52', '140500', '晋城市', '5', '0', '0', 'Jincheng Shi ', 'JCG');
INSERT INTO `t_region` VALUES ('53', '140600', '朔州市', '5', '0', '0', 'Shuozhou Shi ', 'SZJ');
INSERT INTO `t_region` VALUES ('54', '140700', '晋中市', '5', '0', '0', 'Jinzhong Shi', 'JGS');
INSERT INTO `t_region` VALUES ('55', '140800', '运城市', '5', '0', '0', 'Yuncheng Shi', 'YCS');
INSERT INTO `t_region` VALUES ('56', '140900', '忻州市', '5', '0', '0', 'Xinzhou Shi', 'XZS');
INSERT INTO `t_region` VALUES ('57', '141000', '临汾市', '5', '0', '0', 'Linfen Shi', 'LFS');
INSERT INTO `t_region` VALUES ('58', '141100', '吕梁市', '5', '0', '0', 'Lvliang Shi', 'LLS');
INSERT INTO `t_region` VALUES ('59', '150100', '呼和浩特市', '6', '0', '0', 'Hohhot Shi', 'Hhht');
INSERT INTO `t_region` VALUES ('60', '150200', '包头市', '6', '0', '0', 'Baotou Shi ', 'BTS');
INSERT INTO `t_region` VALUES ('61', '150300', '乌海市', '6', '0', '0', 'Wuhai Shi', 'WHM');
INSERT INTO `t_region` VALUES ('62', '150400', '赤峰市', '6', '0', '0', 'Chifeng (Ulanhad)Shi', 'CFS');
INSERT INTO `t_region` VALUES ('63', '150500', '通辽市', '6', '0', '0', 'Tongliao Shi', '2');
INSERT INTO `t_region` VALUES ('64', '150600', '鄂尔多斯市', '6', '0', '0', 'Eerduosi Shi', '2');
INSERT INTO `t_region` VALUES ('65', '150700', '呼伦贝尔市', '6', '0', '0', 'Hulunbeier Shi ', '2');
INSERT INTO `t_region` VALUES ('66', '150800', '巴彦淖尔市', '6', '0', '0', 'Bayannaoer Shi', '2');
INSERT INTO `t_region` VALUES ('67', '150900', '乌兰察布市', '6', '0', '0', 'Wulanchabu Shi', '2');
INSERT INTO `t_region` VALUES ('68', '152200', '兴安盟', '6', '0', '0', 'Hinggan Meng', 'HIN');
INSERT INTO `t_region` VALUES ('69', '152500', '锡林郭勒盟', '6', '0', '0', 'Xilin Gol Meng', 'XGO');
INSERT INTO `t_region` VALUES ('70', '152900', '阿拉善盟', '6', '0', '0', 'Alxa Meng', 'ALM');
INSERT INTO `t_region` VALUES ('71', '210100', '沈阳市', '7', '0', '0', 'Shenyang Shi', 'SHE');
INSERT INTO `t_region` VALUES ('72', '210200', '大连市', '7', '0', '0', 'Dalian Shi', 'DLC');
INSERT INTO `t_region` VALUES ('73', '210300', '鞍山市', '7', '0', '0', 'AnShan Shi', 'ASN');
INSERT INTO `t_region` VALUES ('74', '210400', '抚顺市', '7', '0', '0', 'Fushun Shi', 'FSN');
INSERT INTO `t_region` VALUES ('75', '210500', '本溪市', '7', '0', '0', 'Benxi Shi', 'BXS');
INSERT INTO `t_region` VALUES ('76', '210600', '丹东市', '7', '0', '0', 'Dandong Shi', 'DDG');
INSERT INTO `t_region` VALUES ('77', '210700', '锦州市', '7', '0', '0', 'Jinzhou Shi', 'JNZ');
INSERT INTO `t_region` VALUES ('78', '210800', '营口市', '7', '0', '0', 'Yingkou Shi', 'YIK');
INSERT INTO `t_region` VALUES ('79', '210900', '阜新市', '7', '0', '0', 'Fuxin Shi', 'FXS');
INSERT INTO `t_region` VALUES ('80', '211000', '辽阳市', '7', '0', '0', 'Liaoyang Shi', 'LYL');
INSERT INTO `t_region` VALUES ('81', '211100', '盘锦市', '7', '0', '0', 'Panjin Shi', 'PJS');
INSERT INTO `t_region` VALUES ('82', '211200', '铁岭市', '7', '0', '0', 'Tieling Shi', 'TLS');
INSERT INTO `t_region` VALUES ('83', '211300', '朝阳市', '7', '0', '0', 'Chaoyang Shi', 'CYS');
INSERT INTO `t_region` VALUES ('84', '211400', '葫芦岛市', '7', '0', '0', 'Huludao Shi', 'HLD');
INSERT INTO `t_region` VALUES ('85', '220100', '长春市', '8', '0', '0', 'Changchun Shi ', 'CGQ');
INSERT INTO `t_region` VALUES ('86', '220200', '吉林市', '8', '0', '0', 'Jilin Shi ', 'JLS');
INSERT INTO `t_region` VALUES ('87', '220300', '四平市', '8', '0', '0', 'Siping Shi', 'SPS');
INSERT INTO `t_region` VALUES ('88', '220400', '辽源市', '8', '0', '0', 'Liaoyuan Shi', 'LYH');
INSERT INTO `t_region` VALUES ('89', '220500', '通化市', '8', '0', '0', 'Tonghua Shi', 'THS');
INSERT INTO `t_region` VALUES ('90', '220600', '白山市', '8', '0', '0', 'Baishan Shi', 'BSN');
INSERT INTO `t_region` VALUES ('91', '220700', '松原市', '8', '0', '0', 'Songyuan Shi', 'SYU');
INSERT INTO `t_region` VALUES ('92', '220800', '白城市', '8', '0', '0', 'Baicheng Shi', 'BCS');
INSERT INTO `t_region` VALUES ('93', '222400', '延边朝鲜族自治州', '8', '0', '0', 'Yanbian Chosenzu Zizhizhou', 'YBZ');
INSERT INTO `t_region` VALUES ('94', '230100', '哈尔滨市', '9', '0', '0', 'Harbin Shi', 'HRB');
INSERT INTO `t_region` VALUES ('95', '230200', '齐齐哈尔市', '9', '0', '0', 'Qiqihar Shi', 'NDG');
INSERT INTO `t_region` VALUES ('96', '230300', '鸡西市', '9', '0', '0', 'Jixi Shi', 'JXI');
INSERT INTO `t_region` VALUES ('97', '230400', '鹤岗市', '9', '0', '0', 'Hegang Shi', 'HEG');
INSERT INTO `t_region` VALUES ('98', '230500', '双鸭山市', '9', '0', '0', 'Shuangyashan Shi', 'SYS');
INSERT INTO `t_region` VALUES ('99', '230600', '大庆市', '9', '0', '0', 'Daqing Shi', 'DQG');
INSERT INTO `t_region` VALUES ('100', '230700', '伊春市', '9', '0', '0', 'Yichun Shi', 'YCH');
INSERT INTO `t_region` VALUES ('101', '230800', '佳木斯市', '9', '0', '0', 'Jiamusi Shi', 'JMU');
INSERT INTO `t_region` VALUES ('102', '230900', '七台河市', '9', '0', '0', 'Qitaihe Shi', 'QTH');
INSERT INTO `t_region` VALUES ('103', '231000', '牡丹江市', '9', '0', '0', 'Mudanjiang Shi', 'MDG');
INSERT INTO `t_region` VALUES ('104', '231100', '黑河市', '9', '0', '0', 'Heihe Shi', 'HEK');
INSERT INTO `t_region` VALUES ('105', '231200', '绥化市', '9', '0', '0', 'Suihua Shi', '2');
INSERT INTO `t_region` VALUES ('106', '232700', '大兴安岭地区', '9', '0', '0', 'Da Hinggan Ling Diqu', 'DHL');
INSERT INTO `t_region` VALUES ('107', '310100', '市辖区', '10', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('108', '310200', '县', '10', '0', '0', 'Xian', '2');
INSERT INTO `t_region` VALUES ('109', '320100', '南京市', '11', '0', '0', 'Nanjing Shi', 'NKG');
INSERT INTO `t_region` VALUES ('110', '320200', '无锡市', '11', '0', '0', 'Wuxi Shi', 'WUX');
INSERT INTO `t_region` VALUES ('111', '320300', '徐州市', '11', '0', '0', 'Xuzhou Shi', 'XUZ');
INSERT INTO `t_region` VALUES ('112', '320400', '常州市', '11', '0', '0', 'Changzhou Shi', 'CZX');
INSERT INTO `t_region` VALUES ('113', '320500', '苏州市', '11', '0', '0', 'Suzhou Shi', 'SZH');
INSERT INTO `t_region` VALUES ('114', '320600', '南通市', '11', '0', '0', 'Nantong Shi', 'NTG');
INSERT INTO `t_region` VALUES ('115', '320700', '连云港市', '11', '0', '0', 'Lianyungang Shi', 'LYG');
INSERT INTO `t_region` VALUES ('116', '320800', '淮安市', '11', '0', '0', 'Huai,an Xian', '2');
INSERT INTO `t_region` VALUES ('117', '320900', '盐城市', '11', '0', '0', 'Yancheng Shi', 'YCK');
INSERT INTO `t_region` VALUES ('118', '321000', '扬州市', '11', '0', '0', 'Yangzhou Shi', 'YZH');
INSERT INTO `t_region` VALUES ('119', '321100', '镇江市', '11', '0', '0', 'Zhenjiang Shi', 'ZHE');
INSERT INTO `t_region` VALUES ('120', '321200', '泰州市', '11', '0', '0', 'Taizhou Shi', 'TZS');
INSERT INTO `t_region` VALUES ('121', '321300', '宿迁市', '11', '0', '0', 'Suqian Shi', 'SUQ');
INSERT INTO `t_region` VALUES ('122', '330100', '杭州市', '12', '0', '0', 'Hangzhou Shi', 'HGH');
INSERT INTO `t_region` VALUES ('123', '330200', '宁波市', '12', '0', '0', 'Ningbo Shi', 'NGB');
INSERT INTO `t_region` VALUES ('124', '330300', '温州市', '12', '0', '0', 'Wenzhou Shi', 'WNZ');
INSERT INTO `t_region` VALUES ('125', '330400', '嘉兴市', '12', '0', '0', 'Jiaxing Shi', 'JIX');
INSERT INTO `t_region` VALUES ('126', '330500', '湖州市', '12', '0', '0', 'Huzhou Shi ', 'HZH');
INSERT INTO `t_region` VALUES ('127', '330600', '绍兴市', '12', '0', '0', 'Shaoxing Shi', 'SXG');
INSERT INTO `t_region` VALUES ('128', '330700', '金华市', '12', '0', '0', 'Jinhua Shi', 'JHA');
INSERT INTO `t_region` VALUES ('129', '330800', '衢州市', '12', '0', '0', 'Quzhou Shi', 'QUZ');
INSERT INTO `t_region` VALUES ('130', '330900', '舟山市', '12', '0', '0', 'Zhoushan Shi', 'ZOS');
INSERT INTO `t_region` VALUES ('131', '331000', '台州市', '12', '0', '0', 'Taizhou Shi', 'TZZ');
INSERT INTO `t_region` VALUES ('132', '331100', '丽水市', '12', '0', '0', 'Lishui Shi', '2');
INSERT INTO `t_region` VALUES ('133', '340100', '合肥市', '13', '0', '0', 'Hefei Shi', 'HFE');
INSERT INTO `t_region` VALUES ('134', '340200', '芜湖市', '13', '0', '0', 'Wuhu Shi', 'WHI');
INSERT INTO `t_region` VALUES ('135', '340300', '蚌埠市', '13', '0', '0', 'Bengbu Shi', 'BBU');
INSERT INTO `t_region` VALUES ('136', '340400', '淮南市', '13', '0', '0', 'Huainan Shi', 'HNS');
INSERT INTO `t_region` VALUES ('137', '340500', '马鞍山市', '13', '0', '0', 'Ma,anshan Shi', 'MAA');
INSERT INTO `t_region` VALUES ('138', '340600', '淮北市', '13', '0', '0', 'Huaibei Shi', 'HBE');
INSERT INTO `t_region` VALUES ('139', '340700', '铜陵市', '13', '0', '0', 'Tongling Shi', 'TOL');
INSERT INTO `t_region` VALUES ('140', '340800', '安庆市', '13', '0', '0', 'Anqing Shi', 'AQG');
INSERT INTO `t_region` VALUES ('141', '341000', '黄山市', '13', '0', '0', 'Huangshan Shi', 'HSN');
INSERT INTO `t_region` VALUES ('142', '341100', '滁州市', '13', '0', '0', 'Chuzhou Shi', 'CUZ');
INSERT INTO `t_region` VALUES ('143', '341200', '阜阳市', '13', '0', '0', 'Fuyang Shi', 'FYS');
INSERT INTO `t_region` VALUES ('144', '341300', '宿州市', '13', '0', '0', 'Suzhou Shi', 'SUZ');
INSERT INTO `t_region` VALUES ('145', '341400', '巢湖市', '13', '0', '0', 'Chaohu Shi', '2');
INSERT INTO `t_region` VALUES ('146', '341500', '六安市', '13', '0', '0', 'Liu,an Shi', '2');
INSERT INTO `t_region` VALUES ('147', '341600', '亳州市', '13', '0', '0', 'Bozhou Shi', '2');
INSERT INTO `t_region` VALUES ('148', '341700', '池州市', '13', '0', '0', 'Chizhou Shi', '2');
INSERT INTO `t_region` VALUES ('149', '341800', '宣城市', '13', '0', '0', 'Xuancheng Shi', '2');
INSERT INTO `t_region` VALUES ('150', '350100', '福州市', '14', '0', '0', 'Fuzhou Shi', 'FOC');
INSERT INTO `t_region` VALUES ('151', '350200', '厦门市', '14', '0', '0', 'Xiamen Shi', 'XMN');
INSERT INTO `t_region` VALUES ('152', '350300', '莆田市', '14', '0', '0', 'Putian Shi', 'PUT');
INSERT INTO `t_region` VALUES ('153', '350400', '三明市', '14', '0', '0', 'Sanming Shi', 'SMS');
INSERT INTO `t_region` VALUES ('154', '350500', '泉州市', '14', '0', '0', 'Quanzhou Shi', 'QZJ');
INSERT INTO `t_region` VALUES ('155', '350600', '漳州市', '14', '0', '0', 'Zhangzhou Shi', 'ZZU');
INSERT INTO `t_region` VALUES ('156', '350700', '南平市', '14', '0', '0', 'Nanping Shi', 'NPS');
INSERT INTO `t_region` VALUES ('157', '350800', '龙岩市', '14', '0', '0', 'Longyan Shi', 'LYF');
INSERT INTO `t_region` VALUES ('158', '350900', '宁德市', '14', '0', '0', 'Ningde Shi', '2');
INSERT INTO `t_region` VALUES ('159', '360100', '南昌市', '15', '0', '0', 'Nanchang Shi', 'KHN');
INSERT INTO `t_region` VALUES ('160', '360200', '景德镇市', '15', '0', '0', 'Jingdezhen Shi', 'JDZ');
INSERT INTO `t_region` VALUES ('161', '360300', '萍乡市', '15', '0', '0', 'Pingxiang Shi', 'PXS');
INSERT INTO `t_region` VALUES ('162', '360400', '九江市', '15', '0', '0', 'Jiujiang Shi', 'JIU');
INSERT INTO `t_region` VALUES ('163', '360500', '新余市', '15', '0', '0', 'Xinyu Shi', 'XYU');
INSERT INTO `t_region` VALUES ('164', '360600', '鹰潭市', '15', '0', '0', 'Yingtan Shi', '2');
INSERT INTO `t_region` VALUES ('165', '360700', '赣州市', '15', '0', '0', 'Ganzhou Shi', 'GZH');
INSERT INTO `t_region` VALUES ('166', '360800', '吉安市', '15', '0', '0', 'Ji,an Shi', '2');
INSERT INTO `t_region` VALUES ('167', '360900', '宜春市', '15', '0', '0', 'Yichun Shi', '2');
INSERT INTO `t_region` VALUES ('168', '361000', '抚州市', '15', '0', '0', 'Wuzhou Shi', '2');
INSERT INTO `t_region` VALUES ('169', '361100', '上饶市', '15', '0', '0', 'Shangrao Shi', '2');
INSERT INTO `t_region` VALUES ('170', '370100', '济南市', '16', '0', '0', 'Jinan Shi', 'TNA');
INSERT INTO `t_region` VALUES ('171', '370200', '青岛市', '16', '0', '0', 'Qingdao Shi', 'TAO');
INSERT INTO `t_region` VALUES ('172', '370300', '淄博市', '16', '0', '0', 'Zibo Shi', 'ZBO');
INSERT INTO `t_region` VALUES ('173', '370400', '枣庄市', '16', '0', '0', 'Zaozhuang Shi', 'ZZG');
INSERT INTO `t_region` VALUES ('174', '370500', '东营市', '16', '0', '0', 'Dongying Shi', 'DYG');
INSERT INTO `t_region` VALUES ('175', '370600', '烟台市', '16', '0', '0', 'Yantai Shi', 'YNT');
INSERT INTO `t_region` VALUES ('176', '370700', '潍坊市', '16', '0', '0', 'Weifang Shi', 'WEF');
INSERT INTO `t_region` VALUES ('177', '370800', '济宁市', '16', '0', '0', 'Jining Shi', 'JNG');
INSERT INTO `t_region` VALUES ('178', '370900', '泰安市', '16', '0', '0', 'Tai,an Shi', 'TAI');
INSERT INTO `t_region` VALUES ('179', '371000', '威海市', '16', '0', '0', 'Weihai Shi', 'WEH');
INSERT INTO `t_region` VALUES ('180', '371100', '日照市', '16', '0', '0', 'Rizhao Shi', 'RZH');
INSERT INTO `t_region` VALUES ('181', '371200', '莱芜市', '16', '0', '0', 'Laiwu Shi', 'LWS');
INSERT INTO `t_region` VALUES ('182', '371300', '临沂市', '16', '0', '0', 'Linyi Shi', 'LYI');
INSERT INTO `t_region` VALUES ('183', '371400', '德州市', '16', '0', '0', 'Dezhou Shi', 'DZS');
INSERT INTO `t_region` VALUES ('184', '371500', '聊城市', '16', '0', '0', 'Liaocheng Shi', 'LCH');
INSERT INTO `t_region` VALUES ('185', '371600', '滨州市', '16', '0', '0', 'Binzhou Shi', '2');
INSERT INTO `t_region` VALUES ('186', '371700', '菏泽市', '16', '3', '0', 'Heze Shi', 'HZ');
INSERT INTO `t_region` VALUES ('187', '410100', '郑州市', '17', '0', '0', 'Zhengzhou Shi', 'CGO');
INSERT INTO `t_region` VALUES ('188', '410200', '开封市', '17', '0', '0', 'Kaifeng Shi', 'KFS');
INSERT INTO `t_region` VALUES ('189', '410300', '洛阳市', '17', '0', '0', 'Luoyang Shi', 'LYA');
INSERT INTO `t_region` VALUES ('190', '410400', '平顶山市', '17', '0', '0', 'Pingdingshan Shi', 'PDS');
INSERT INTO `t_region` VALUES ('191', '410500', '安阳市', '17', '0', '0', 'Anyang Shi', 'AYS');
INSERT INTO `t_region` VALUES ('192', '410600', '鹤壁市', '17', '0', '0', 'Hebi Shi', 'HBS');
INSERT INTO `t_region` VALUES ('193', '410700', '新乡市', '17', '0', '0', 'Xinxiang Shi', 'XXS');
INSERT INTO `t_region` VALUES ('194', '410800', '焦作市', '17', '0', '0', 'Jiaozuo Shi', 'JZY');
INSERT INTO `t_region` VALUES ('195', '410900', '濮阳市', '17', '0', '0', 'Puyang Shi', 'PYS');
INSERT INTO `t_region` VALUES ('196', '411000', '许昌市', '17', '0', '0', 'Xuchang Shi', 'XCS');
INSERT INTO `t_region` VALUES ('197', '411100', '漯河市', '17', '0', '0', 'Luohe Shi', 'LHS');
INSERT INTO `t_region` VALUES ('198', '411200', '三门峡市', '17', '0', '0', 'Sanmenxia Shi', 'SMX');
INSERT INTO `t_region` VALUES ('199', '411300', '南阳市', '17', '0', '0', 'Nanyang Shi', 'NYS');
INSERT INTO `t_region` VALUES ('200', '411400', '商丘市', '17', '0', '0', 'Shangqiu Shi', 'SQS');
INSERT INTO `t_region` VALUES ('201', '411500', '信阳市', '17', '0', '0', 'Xinyang Shi', 'XYG');
INSERT INTO `t_region` VALUES ('202', '411600', '周口市', '17', '0', '0', 'Zhoukou Shi', '2');
INSERT INTO `t_region` VALUES ('203', '411700', '驻马店市', '17', '0', '0', 'Zhumadian Shi', '2');
INSERT INTO `t_region` VALUES ('204', '420100', '武汉市', '18', '0', '0', 'Wuhan Shi', 'WUH');
INSERT INTO `t_region` VALUES ('205', '420200', '黄石市', '18', '0', '0', 'Huangshi Shi', 'HIS');
INSERT INTO `t_region` VALUES ('206', '420300', '十堰市', '18', '0', '0', 'Shiyan Shi', 'SYE');
INSERT INTO `t_region` VALUES ('207', '420500', '宜昌市', '18', '0', '0', 'Yichang Shi', 'YCO');
INSERT INTO `t_region` VALUES ('208', '420600', '襄樊市', '18', '0', '0', 'Xiangfan Shi', 'XFN');
INSERT INTO `t_region` VALUES ('209', '420700', '鄂州市', '18', '0', '0', 'Ezhou Shi', 'EZS');
INSERT INTO `t_region` VALUES ('210', '420800', '荆门市', '18', '0', '0', 'Jingmen Shi', 'JMS');
INSERT INTO `t_region` VALUES ('211', '420900', '孝感市', '18', '0', '0', 'Xiaogan Shi', 'XGE');
INSERT INTO `t_region` VALUES ('212', '421000', '荆州市', '18', '0', '0', 'Jingzhou Shi', 'JGZ');
INSERT INTO `t_region` VALUES ('213', '421100', '黄冈市', '18', '0', '0', 'Huanggang Shi', 'HE');
INSERT INTO `t_region` VALUES ('214', '421200', '咸宁市', '18', '0', '0', 'Xianning Xian', 'XNS');
INSERT INTO `t_region` VALUES ('215', '421300', '随州市', '18', '0', '0', 'Suizhou Shi', '2');
INSERT INTO `t_region` VALUES ('216', '422800', '恩施土家族苗族自治州', '18', '0', '0', 'Enshi Tujiazu Miaozu Zizhizhou', 'ESH');
INSERT INTO `t_region` VALUES ('217', '429000', '省直辖县级行政区划', '18', '0', '0', 'shengzhixiaxianjixingzhengquhua', '2');
INSERT INTO `t_region` VALUES ('218', '430100', '长沙市', '19', '0', '0', 'Changsha Shi', 'CSX');
INSERT INTO `t_region` VALUES ('219', '430200', '株洲市', '19', '0', '0', 'Zhuzhou Shi', 'ZZS');
INSERT INTO `t_region` VALUES ('220', '430300', '湘潭市', '19', '0', '0', 'Xiangtan Shi', 'XGT');
INSERT INTO `t_region` VALUES ('221', '430400', '衡阳市', '19', '0', '0', 'Hengyang Shi', 'HNY');
INSERT INTO `t_region` VALUES ('222', '430500', '邵阳市', '19', '0', '0', 'Shaoyang Shi', 'SYR');
INSERT INTO `t_region` VALUES ('223', '430600', '岳阳市', '19', '0', '0', 'Yueyang Shi', 'YYG');
INSERT INTO `t_region` VALUES ('224', '430700', '常德市', '19', '0', '0', 'Changde Shi', 'CDE');
INSERT INTO `t_region` VALUES ('225', '430800', '张家界市', '19', '0', '0', 'Zhangjiajie Shi', 'ZJJ');
INSERT INTO `t_region` VALUES ('226', '430900', '益阳市', '19', '0', '0', 'Yiyang Shi', 'YYS');
INSERT INTO `t_region` VALUES ('227', '431000', '郴州市', '19', '0', '0', 'Chenzhou Shi', 'CNZ');
INSERT INTO `t_region` VALUES ('228', '431100', '永州市', '19', '0', '0', 'Yongzhou Shi', 'YZS');
INSERT INTO `t_region` VALUES ('229', '431200', '怀化市', '19', '0', '0', 'Huaihua Shi', 'HHS');
INSERT INTO `t_region` VALUES ('230', '431300', '娄底市', '19', '0', '0', 'Loudi Shi', '2');
INSERT INTO `t_region` VALUES ('231', '433100', '湘西土家族苗族自治州', '19', '0', '0', 'Xiangxi Tujiazu Miaozu Zizhizhou ', 'XXZ');
INSERT INTO `t_region` VALUES ('232', '440100', '广州市', '20', '0', '0', 'Guangzhou Shi', 'CAN');
INSERT INTO `t_region` VALUES ('233', '440200', '韶关市', '20', '0', '0', 'Shaoguan Shi', 'HSC');
INSERT INTO `t_region` VALUES ('234', '440300', '深圳市', '20', '0', '0', 'Shenzhen Shi', 'SZX');
INSERT INTO `t_region` VALUES ('235', '440400', '珠海市', '20', '0', '0', 'Zhuhai Shi', 'ZUH');
INSERT INTO `t_region` VALUES ('236', '440500', '汕头市', '20', '0', '0', 'Shantou Shi', 'SWA');
INSERT INTO `t_region` VALUES ('237', '440600', '佛山市', '20', '0', '0', 'Foshan Shi', 'FOS');
INSERT INTO `t_region` VALUES ('238', '440700', '江门市', '20', '0', '0', 'Jiangmen Shi', 'JMN');
INSERT INTO `t_region` VALUES ('239', '440800', '湛江市', '20', '0', '0', 'Zhanjiang Shi', 'ZHA');
INSERT INTO `t_region` VALUES ('240', '440900', '茂名市', '20', '0', '0', 'Maoming Shi', 'MMI');
INSERT INTO `t_region` VALUES ('241', '441200', '肇庆市', '20', '0', '0', 'Zhaoqing Shi', 'ZQG');
INSERT INTO `t_region` VALUES ('242', '441300', '惠州市', '20', '0', '0', 'Huizhou Shi', 'HUI');
INSERT INTO `t_region` VALUES ('243', '441400', '梅州市', '20', '0', '0', 'Meizhou Shi', 'MXZ');
INSERT INTO `t_region` VALUES ('244', '441500', '汕尾市', '20', '0', '0', 'Shanwei Shi', 'SWE');
INSERT INTO `t_region` VALUES ('245', '441600', '河源市', '20', '0', '0', 'Heyuan Shi', 'HEY');
INSERT INTO `t_region` VALUES ('246', '441700', '阳江市', '20', '0', '0', 'Yangjiang Shi', 'YJI');
INSERT INTO `t_region` VALUES ('247', '441800', '清远市', '20', '0', '0', 'Qingyuan Shi', 'QYN');
INSERT INTO `t_region` VALUES ('248', '441900', '东莞市', '20', '0', '0', 'Dongguan Shi', 'DGG');
INSERT INTO `t_region` VALUES ('249', '442000', '中山市', '20', '0', '0', 'Zhongshan Shi', 'ZSN');
INSERT INTO `t_region` VALUES ('250', '445100', '潮州市', '20', '0', '0', 'Chaozhou Shi', 'CZY');
INSERT INTO `t_region` VALUES ('251', '445200', '揭阳市', '20', '0', '0', 'Jieyang Shi', 'JIY');
INSERT INTO `t_region` VALUES ('252', '445300', '云浮市', '20', '0', '0', 'Yunfu Shi', 'YFS');
INSERT INTO `t_region` VALUES ('253', '450100', '南宁市', '21', '0', '0', 'Nanning Shi', 'NNG');
INSERT INTO `t_region` VALUES ('254', '450200', '柳州市', '21', '0', '0', 'Liuzhou Shi', 'LZH');
INSERT INTO `t_region` VALUES ('255', '450300', '桂林市', '21', '0', '0', 'Guilin Shi', 'KWL');
INSERT INTO `t_region` VALUES ('256', '450400', '梧州市', '21', '0', '0', 'Wuzhou Shi', 'WUZ');
INSERT INTO `t_region` VALUES ('257', '450500', '北海市', '21', '0', '0', 'Beihai Shi', 'BHY');
INSERT INTO `t_region` VALUES ('258', '450600', '防城港市', '21', '0', '0', 'Fangchenggang Shi', 'FAN');
INSERT INTO `t_region` VALUES ('259', '450700', '钦州市', '21', '0', '0', 'Qinzhou Shi', 'QZH');
INSERT INTO `t_region` VALUES ('260', '450800', '贵港市', '21', '0', '0', 'Guigang Shi', 'GUG');
INSERT INTO `t_region` VALUES ('261', '450900', '玉林市', '21', '0', '0', 'Yulin Shi', 'YUL');
INSERT INTO `t_region` VALUES ('262', '451000', '百色市', '21', '0', '0', 'Baise Shi', '2');
INSERT INTO `t_region` VALUES ('263', '451100', '贺州市', '21', '0', '0', 'Hezhou Shi', '2');
INSERT INTO `t_region` VALUES ('264', '451200', '河池市', '21', '0', '0', 'Hechi Shi', '2');
INSERT INTO `t_region` VALUES ('265', '451300', '来宾市', '21', '0', '0', 'Laibin Shi', '2');
INSERT INTO `t_region` VALUES ('266', '451400', '崇左市', '21', '0', '0', 'Chongzuo Shi', '2');
INSERT INTO `t_region` VALUES ('267', '460100', '海口市', '22', '0', '0', 'Haikou Shi', 'HAK');
INSERT INTO `t_region` VALUES ('268', '460200', '三亚市', '22', '0', '0', 'Sanya Shi', 'SYX');
INSERT INTO `t_region` VALUES ('269', '469000', '省直辖县级行政区划', '22', '0', '0', 'shengzhixiaxianjixingzhengquhua', '2');
INSERT INTO `t_region` VALUES ('270', '500100', '市辖区', '23', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('271', '500200', '县', '23', '0', '0', 'Xian', '2');
INSERT INTO `t_region` VALUES ('273', '510100', '成都市', '24', '0', '0', 'Chengdu Shi', 'CTU');
INSERT INTO `t_region` VALUES ('274', '510300', '自贡市', '24', '0', '0', 'Zigong Shi', 'ZGS');
INSERT INTO `t_region` VALUES ('275', '510400', '攀枝花市', '24', '0', '0', 'Panzhihua Shi', 'PZH');
INSERT INTO `t_region` VALUES ('276', '510500', '泸州市', '24', '0', '0', 'Luzhou Shi', 'LUZ');
INSERT INTO `t_region` VALUES ('277', '510600', '德阳市', '24', '0', '0', 'Deyang Shi', 'DEY');
INSERT INTO `t_region` VALUES ('278', '510700', '绵阳市', '24', '0', '0', 'Mianyang Shi', 'MYG');
INSERT INTO `t_region` VALUES ('279', '510800', '广元市', '24', '0', '0', 'Guangyuan Shi', 'GYC');
INSERT INTO `t_region` VALUES ('280', '510900', '遂宁市', '24', '0', '0', 'Suining Shi', 'SNS');
INSERT INTO `t_region` VALUES ('281', '511000', '内江市', '24', '0', '0', 'Neijiang Shi', 'NJS');
INSERT INTO `t_region` VALUES ('282', '511100', '乐山市', '24', '0', '0', 'Leshan Shi', 'LES');
INSERT INTO `t_region` VALUES ('283', '511300', '南充市', '24', '0', '0', 'Nanchong Shi', 'NCO');
INSERT INTO `t_region` VALUES ('284', '511400', '眉山市', '24', '0', '0', 'Meishan Shi', '2');
INSERT INTO `t_region` VALUES ('285', '511500', '宜宾市', '24', '0', '0', 'Yibin Shi', 'YBS');
INSERT INTO `t_region` VALUES ('286', '511600', '广安市', '24', '0', '0', 'Guang,an Shi', 'GAC');
INSERT INTO `t_region` VALUES ('287', '511700', '达州市', '24', '0', '0', 'Dazhou Shi', '2');
INSERT INTO `t_region` VALUES ('288', '511800', '雅安市', '24', '0', '0', 'Ya,an Shi', '2');
INSERT INTO `t_region` VALUES ('289', '511900', '巴中市', '24', '0', '0', 'Bazhong Shi', '2');
INSERT INTO `t_region` VALUES ('290', '512000', '资阳市', '24', '0', '0', 'Ziyang Shi', '2');
INSERT INTO `t_region` VALUES ('291', '513200', '阿坝藏族羌族自治州', '24', '0', '0', 'Aba(Ngawa) Zangzu Qiangzu Zizhizhou', 'ABA');
INSERT INTO `t_region` VALUES ('292', '513300', '甘孜藏族自治州', '24', '0', '0', 'Garze Zangzu Zizhizhou', 'GAZ');
INSERT INTO `t_region` VALUES ('293', '513400', '凉山彝族自治州', '24', '0', '0', 'Liangshan Yizu Zizhizhou', 'LSY');
INSERT INTO `t_region` VALUES ('294', '520100', '贵阳市', '25', '0', '0', 'Guiyang Shi', 'KWE');
INSERT INTO `t_region` VALUES ('295', '520200', '六盘水市', '25', '0', '0', 'Liupanshui Shi', 'LPS');
INSERT INTO `t_region` VALUES ('296', '520300', '遵义市', '25', '0', '0', 'Zunyi Shi', 'ZNY');
INSERT INTO `t_region` VALUES ('297', '520400', '安顺市', '25', '0', '0', 'Anshun Xian', '2');
INSERT INTO `t_region` VALUES ('298', '522200', '铜仁地区', '25', '0', '0', 'Tongren Diqu', 'TRD');
INSERT INTO `t_region` VALUES ('299', '522300', '黔西南布依族苗族自治州', '25', '0', '0', 'Qianxinan Buyeizu Zizhizhou', 'QXZ');
INSERT INTO `t_region` VALUES ('300', '522400', '毕节地区', '25', '0', '0', 'Bijie Diqu', 'BJD');
INSERT INTO `t_region` VALUES ('301', '522600', '黔东南苗族侗族自治州', '25', '0', '0', 'Qiandongnan Miaozu Dongzu Zizhizhou', 'QND');
INSERT INTO `t_region` VALUES ('302', '522700', '黔南布依族苗族自治州', '25', '0', '0', 'Qiannan Buyeizu Miaozu Zizhizhou', 'QNZ');
INSERT INTO `t_region` VALUES ('303', '530100', '昆明市', '26', '0', '0', 'Kunming Shi', 'KMG');
INSERT INTO `t_region` VALUES ('304', '530300', '曲靖市', '26', '0', '0', 'Qujing Shi', 'QJS');
INSERT INTO `t_region` VALUES ('305', '530400', '玉溪市', '26', '0', '0', 'Yuxi Shi', 'YXS');
INSERT INTO `t_region` VALUES ('306', '530500', '保山市', '26', '0', '0', 'Baoshan Shi', '2');
INSERT INTO `t_region` VALUES ('307', '530600', '昭通市', '26', '0', '0', 'Zhaotong Shi', '2');
INSERT INTO `t_region` VALUES ('308', '530700', '丽江市', '26', '0', '0', 'Lijiang Shi', '2');
INSERT INTO `t_region` VALUES ('309', '530800', '普洱市', '26', '0', '0', 'Simao Shi', '2');
INSERT INTO `t_region` VALUES ('310', '530900', '临沧市', '26', '0', '0', 'Lincang Shi', '2');
INSERT INTO `t_region` VALUES ('311', '532300', '楚雄彝族自治州', '26', '0', '0', 'Chuxiong Yizu Zizhizhou', 'CXD');
INSERT INTO `t_region` VALUES ('312', '532500', '红河哈尼族彝族自治州', '26', '0', '0', 'Honghe Hanizu Yizu Zizhizhou', 'HHZ');
INSERT INTO `t_region` VALUES ('313', '532600', '文山壮族苗族自治州', '26', '0', '0', 'Wenshan Zhuangzu Miaozu Zizhizhou', 'WSZ');
INSERT INTO `t_region` VALUES ('314', '532800', '西双版纳傣族自治州', '26', '0', '0', 'Xishuangbanna Daizu Zizhizhou', 'XSB');
INSERT INTO `t_region` VALUES ('315', '532900', '大理白族自治州', '26', '0', '0', 'Dali Baizu Zizhizhou', 'DLZ');
INSERT INTO `t_region` VALUES ('316', '533100', '德宏傣族景颇族自治州', '26', '0', '0', 'Dehong Daizu Jingpozu Zizhizhou', 'DHG');
INSERT INTO `t_region` VALUES ('317', '533300', '怒江傈僳族自治州', '26', '0', '0', 'Nujiang Lisuzu Zizhizhou', 'NUJ');
INSERT INTO `t_region` VALUES ('318', '533400', '迪庆藏族自治州', '26', '0', '0', 'Deqen Zangzu Zizhizhou', 'DEZ');
INSERT INTO `t_region` VALUES ('319', '540100', '拉萨市', '27', '0', '0', 'Lhasa Shi', 'LXA');
INSERT INTO `t_region` VALUES ('320', '542100', '昌都地区', '27', '0', '0', 'Qamdo Diqu', 'QAD');
INSERT INTO `t_region` VALUES ('321', '542200', '山南地区', '27', '0', '0', 'Shannan Diqu', 'SND');
INSERT INTO `t_region` VALUES ('322', '542300', '日喀则地区', '27', '0', '0', 'Xigaze Diqu', 'XID');
INSERT INTO `t_region` VALUES ('323', '542400', '那曲地区', '27', '0', '0', 'Nagqu Diqu', 'NAD');
INSERT INTO `t_region` VALUES ('324', '542500', '阿里地区', '27', '0', '0', 'Ngari Diqu', 'NGD');
INSERT INTO `t_region` VALUES ('325', '542600', '林芝地区', '27', '0', '0', 'Nyingchi Diqu', 'NYD');
INSERT INTO `t_region` VALUES ('326', '610100', '西安市', '28', '0', '0', 'Xi,an Shi', 'SIA');
INSERT INTO `t_region` VALUES ('327', '610200', '铜川市', '28', '0', '0', 'Tongchuan Shi', 'TCN');
INSERT INTO `t_region` VALUES ('328', '610300', '宝鸡市', '28', '0', '0', 'Baoji Shi', 'BJI');
INSERT INTO `t_region` VALUES ('329', '610400', '咸阳市', '28', '0', '0', 'Xianyang Shi', 'XYS');
INSERT INTO `t_region` VALUES ('330', '610500', '渭南市', '28', '0', '0', 'Weinan Shi', 'WNA');
INSERT INTO `t_region` VALUES ('331', '610600', '延安市', '28', '0', '0', 'Yan,an Shi', 'YNA');
INSERT INTO `t_region` VALUES ('332', '610700', '汉中市', '28', '0', '0', 'Hanzhong Shi', 'HZJ');
INSERT INTO `t_region` VALUES ('333', '610800', '榆林市', '28', '0', '0', 'Yulin Shi', '2');
INSERT INTO `t_region` VALUES ('334', '610900', '安康市', '28', '0', '0', 'Ankang Shi', '2');
INSERT INTO `t_region` VALUES ('335', '611000', '商洛市', '28', '0', '0', 'Shangluo Shi', '2');
INSERT INTO `t_region` VALUES ('336', '620100', '兰州市', '29', '0', '0', 'Lanzhou Shi', 'LHW');
INSERT INTO `t_region` VALUES ('337', '620200', '嘉峪关市', '29', '0', '0', 'Jiayuguan Shi', 'JYG');
INSERT INTO `t_region` VALUES ('338', '620300', '金昌市', '29', '0', '0', 'Jinchang Shi', 'JCS');
INSERT INTO `t_region` VALUES ('339', '620400', '白银市', '29', '0', '0', 'Baiyin Shi', 'BYS');
INSERT INTO `t_region` VALUES ('340', '620500', '天水市', '29', '0', '0', 'Tianshui Shi', 'TSU');
INSERT INTO `t_region` VALUES ('341', '620600', '武威市', '29', '0', '0', 'Wuwei Shi', '2');
INSERT INTO `t_region` VALUES ('342', '620700', '张掖市', '29', '0', '0', 'Zhangye Shi', '2');
INSERT INTO `t_region` VALUES ('343', '620800', '平凉市', '29', '0', '0', 'Pingliang Shi', '2');
INSERT INTO `t_region` VALUES ('344', '620900', '酒泉市', '29', '0', '0', 'Jiuquan Shi', '2');
INSERT INTO `t_region` VALUES ('345', '621000', '庆阳市', '29', '0', '0', 'Qingyang Shi', '2');
INSERT INTO `t_region` VALUES ('346', '621100', '定西市', '29', '0', '0', 'Dingxi Shi', '2');
INSERT INTO `t_region` VALUES ('347', '621200', '陇南市', '29', '0', '0', 'Longnan Shi', '2');
INSERT INTO `t_region` VALUES ('348', '622900', '临夏回族自治州', '29', '0', '0', 'Linxia Huizu Zizhizhou ', 'LXH');
INSERT INTO `t_region` VALUES ('349', '623000', '甘南藏族自治州', '29', '0', '0', 'Gannan Zangzu Zizhizhou', 'GNZ');
INSERT INTO `t_region` VALUES ('350', '630100', '西宁市', '30', '0', '0', 'Xining Shi', 'XNN');
INSERT INTO `t_region` VALUES ('351', '632100', '海东地区', '30', '0', '0', 'Haidong Diqu', 'HDD');
INSERT INTO `t_region` VALUES ('352', '632200', '海北藏族自治州', '30', '0', '0', 'Haibei Zangzu Zizhizhou', 'HBZ');
INSERT INTO `t_region` VALUES ('353', '632300', '黄南藏族自治州', '30', '0', '0', 'Huangnan Zangzu Zizhizhou', 'HNZ');
INSERT INTO `t_region` VALUES ('354', '632500', '海南藏族自治州', '30', '0', '0', 'Hainan Zangzu Zizhizhou', 'HNN');
INSERT INTO `t_region` VALUES ('355', '632600', '果洛藏族自治州', '30', '0', '0', 'Golog Zangzu Zizhizhou', 'GOL');
INSERT INTO `t_region` VALUES ('356', '632700', '玉树藏族自治州', '30', '0', '0', 'Yushu Zangzu Zizhizhou', 'YSZ');
INSERT INTO `t_region` VALUES ('357', '632800', '海西蒙古族藏族自治州', '30', '0', '0', 'Haixi Mongolzu Zangzu Zizhizhou', 'HXZ');
INSERT INTO `t_region` VALUES ('358', '640100', '银川市', '31', '0', '0', 'Yinchuan Shi', 'INC');
INSERT INTO `t_region` VALUES ('359', '640200', '石嘴山市', '31', '0', '0', 'Shizuishan Shi', 'SZS');
INSERT INTO `t_region` VALUES ('360', '640300', '吴忠市', '31', '0', '0', 'Wuzhong Shi', 'WZS');
INSERT INTO `t_region` VALUES ('361', '640400', '固原市', '31', '0', '0', 'Guyuan Shi', '2');
INSERT INTO `t_region` VALUES ('362', '640500', '中卫市', '31', '0', '0', 'Zhongwei Shi', '2');
INSERT INTO `t_region` VALUES ('363', '650100', '乌鲁木齐市', '32', '0', '0', 'Urumqi Shi', 'URC');
INSERT INTO `t_region` VALUES ('364', '650200', '克拉玛依市', '32', '0', '0', 'Karamay Shi', 'KAR');
INSERT INTO `t_region` VALUES ('365', '652100', '吐鲁番地区', '32', '0', '0', 'Turpan Diqu', 'TUD');
INSERT INTO `t_region` VALUES ('366', '652200', '哈密地区', '32', '0', '0', 'Hami(kumul) Diqu', 'HMD');
INSERT INTO `t_region` VALUES ('367', '652300', '昌吉回族自治州', '32', '0', '0', 'Changji Huizu Zizhizhou', 'CJZ');
INSERT INTO `t_region` VALUES ('368', '652700', '博尔塔拉蒙古自治州', '32', '0', '0', 'Bortala Monglo Zizhizhou', 'BOR');
INSERT INTO `t_region` VALUES ('369', '652800', '巴音郭楞蒙古自治州', '32', '0', '0', 'bayinguolengmengguzizhizhou', '2');
INSERT INTO `t_region` VALUES ('370', '652900', '阿克苏地区', '32', '0', '0', 'Aksu Diqu', 'AKD');
INSERT INTO `t_region` VALUES ('371', '653000', '克孜勒苏柯尔克孜自治州', '32', '0', '0', 'Kizilsu Kirgiz Zizhizhou', 'KIZ');
INSERT INTO `t_region` VALUES ('372', '653100', '喀什地区', '32', '0', '0', 'Kashi(Kaxgar) Diqu', 'KSI');
INSERT INTO `t_region` VALUES ('373', '653200', '和田地区', '32', '0', '0', 'Hotan Diqu', 'HOD');
INSERT INTO `t_region` VALUES ('374', '654000', '伊犁哈萨克自治州', '32', '0', '0', 'Ili Kazak Zizhizhou', 'ILD');
INSERT INTO `t_region` VALUES ('375', '654200', '塔城地区', '32', '0', '0', 'Tacheng(Qoqek) Diqu', 'TCD');
INSERT INTO `t_region` VALUES ('376', '654300', '阿勒泰地区', '32', '0', '0', 'Altay Diqu', 'ALD');
INSERT INTO `t_region` VALUES ('377', '659000', '自治区直辖县级行政区划', '32', '0', '0', 'zizhiquzhixiaxianjixingzhengquhua', '2');
INSERT INTO `t_region` VALUES ('378', '110101', '东城区', '33', '0', '0', 'Dongcheng Qu', 'DCQ');
INSERT INTO `t_region` VALUES ('379', '110102', '西城区', '33', '0', '0', 'Xicheng Qu', 'XCQ');
INSERT INTO `t_region` VALUES ('382', '110105', '朝阳区', '33', '0', '0', 'Chaoyang Qu', 'CYQ');
INSERT INTO `t_region` VALUES ('383', '110106', '丰台区', '33', '0', '0', 'Fengtai Qu', 'FTQ');
INSERT INTO `t_region` VALUES ('384', '110107', '石景山区', '33', '0', '0', 'Shijingshan Qu', 'SJS');
INSERT INTO `t_region` VALUES ('385', '110108', '海淀区', '33', '0', '0', 'Haidian Qu', 'HDN');
INSERT INTO `t_region` VALUES ('386', '110109', '门头沟区', '33', '0', '0', 'Mentougou Qu', 'MTG');
INSERT INTO `t_region` VALUES ('387', '110111', '房山区', '33', '0', '0', 'Fangshan Qu', 'FSQ');
INSERT INTO `t_region` VALUES ('388', '110112', '通州区', '33', '0', '0', 'Tongzhou Qu', 'TZQ');
INSERT INTO `t_region` VALUES ('389', '110113', '顺义区', '33', '0', '0', 'Shunyi Qu', 'SYI');
INSERT INTO `t_region` VALUES ('390', '110114', '昌平区', '33', '0', '0', 'Changping Qu', 'CP Q');
INSERT INTO `t_region` VALUES ('391', '110115', '大兴区', '33', '0', '0', 'Daxing Qu', 'DX Q');
INSERT INTO `t_region` VALUES ('392', '110116', '怀柔区', '33', '0', '0', 'Huairou Qu', 'HR Q');
INSERT INTO `t_region` VALUES ('393', '110117', '平谷区', '33', '0', '0', 'Pinggu Qu', 'PG Q');
INSERT INTO `t_region` VALUES ('394', '110228', '密云县', '34', '0', '0', 'Miyun Xian ', 'MYN');
INSERT INTO `t_region` VALUES ('395', '110229', '延庆县', '34', '0', '0', 'Yanqing Xian', 'YQX');
INSERT INTO `t_region` VALUES ('396', '120101', '和平区', '35', '0', '0', 'Heping Qu', 'HPG');
INSERT INTO `t_region` VALUES ('397', '120102', '河东区', '35', '0', '0', 'Hedong Qu', 'HDQ');
INSERT INTO `t_region` VALUES ('398', '120103', '河西区', '35', '0', '0', 'Hexi Qu', 'HXQ');
INSERT INTO `t_region` VALUES ('399', '120104', '南开区', '35', '0', '0', 'Nankai Qu', 'NKQ');
INSERT INTO `t_region` VALUES ('400', '120105', '河北区', '35', '0', '0', 'Hebei Qu', 'HBQ');
INSERT INTO `t_region` VALUES ('401', '120106', '红桥区', '35', '0', '0', 'Hongqiao Qu', 'HQO');
INSERT INTO `t_region` VALUES ('404', '120116', '滨海新区', '35', '0', '0', 'Dagang Qu', '2');
INSERT INTO `t_region` VALUES ('405', '120110', '东丽区', '35', '0', '0', 'Dongli Qu', 'DLI');
INSERT INTO `t_region` VALUES ('406', '120111', '西青区', '35', '0', '0', 'Xiqing Qu', 'XQG');
INSERT INTO `t_region` VALUES ('407', '120112', '津南区', '35', '0', '0', 'Jinnan Qu', 'JNQ');
INSERT INTO `t_region` VALUES ('408', '120113', '北辰区', '35', '0', '0', 'Beichen Qu', 'BCQ');
INSERT INTO `t_region` VALUES ('409', '120114', '武清区', '35', '0', '0', 'Wuqing Qu', 'WQ Q');
INSERT INTO `t_region` VALUES ('410', '120115', '宝坻区', '35', '0', '0', 'Baodi Qu', 'BDI');
INSERT INTO `t_region` VALUES ('411', '120221', '宁河县', '36', '0', '0', 'Ninghe Xian', 'NHE');
INSERT INTO `t_region` VALUES ('412', '120223', '静海县', '36', '0', '0', 'Jinghai Xian', 'JHT');
INSERT INTO `t_region` VALUES ('413', '120225', '蓟县', '36', '0', '0', 'Ji Xian', 'JIT');
INSERT INTO `t_region` VALUES ('414', '130101', '市辖区', '37', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('415', '130102', '长安区', '37', '0', '0', 'Chang,an Qu', 'CAQ');
INSERT INTO `t_region` VALUES ('416', '130103', '桥东区', '37', '0', '0', 'Qiaodong Qu', 'QDQ');
INSERT INTO `t_region` VALUES ('417', '130104', '桥西区', '37', '0', '0', 'Qiaoxi Qu', 'QXQ');
INSERT INTO `t_region` VALUES ('418', '130105', '新华区', '37', '0', '0', 'Xinhua Qu', 'XHK');
INSERT INTO `t_region` VALUES ('419', '130107', '井陉矿区', '37', '0', '0', 'Jingxing Kuangqu', 'JXK');
INSERT INTO `t_region` VALUES ('420', '130108', '裕华区', '37', '0', '0', 'Yuhua Qu', '2');
INSERT INTO `t_region` VALUES ('421', '130121', '井陉县', '37', '0', '0', 'Jingxing Xian', 'JXJ');
INSERT INTO `t_region` VALUES ('422', '130123', '正定县', '37', '0', '0', 'Zhengding Xian', 'ZDJ');
INSERT INTO `t_region` VALUES ('423', '130124', '栾城县', '37', '0', '0', 'Luancheng Xian', 'LCG');
INSERT INTO `t_region` VALUES ('424', '130125', '行唐县', '37', '0', '0', 'Xingtang Xian', 'XTG');
INSERT INTO `t_region` VALUES ('425', '130126', '灵寿县', '37', '0', '0', 'Lingshou Xian ', 'LSO');
INSERT INTO `t_region` VALUES ('426', '130127', '高邑县', '37', '0', '0', 'Gaoyi Xian', 'GYJ');
INSERT INTO `t_region` VALUES ('427', '130128', '深泽县', '37', '0', '0', 'Shenze Xian', '2');
INSERT INTO `t_region` VALUES ('428', '130129', '赞皇县', '37', '0', '0', 'Zanhuang Xian', 'ZHG');
INSERT INTO `t_region` VALUES ('429', '130130', '无极县', '37', '0', '0', 'Wuji Xian', 'WJI');
INSERT INTO `t_region` VALUES ('430', '130131', '平山县', '37', '0', '0', 'Pingshan Xian', 'PSH');
INSERT INTO `t_region` VALUES ('431', '130132', '元氏县', '37', '0', '0', 'Yuanshi Xian', 'YSI');
INSERT INTO `t_region` VALUES ('432', '130133', '赵县', '37', '0', '0', 'Zhao Xian', 'ZAO');
INSERT INTO `t_region` VALUES ('433', '130181', '辛集市', '37', '0', '0', 'Xinji Shi', 'XJS');
INSERT INTO `t_region` VALUES ('434', '130182', '藁城市', '37', '0', '0', 'Gaocheng Shi', 'GCS');
INSERT INTO `t_region` VALUES ('435', '130183', '晋州市', '37', '0', '0', 'Jinzhou Shi', 'JZJ');
INSERT INTO `t_region` VALUES ('436', '130184', '新乐市', '37', '0', '0', 'Xinle Shi', 'XLE');
INSERT INTO `t_region` VALUES ('437', '130185', '鹿泉市', '37', '0', '0', 'Luquan Shi', 'LUQ');
INSERT INTO `t_region` VALUES ('438', '130201', '市辖区', '38', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('439', '130202', '路南区', '38', '0', '0', 'Lunan Qu', 'LNB');
INSERT INTO `t_region` VALUES ('440', '130203', '路北区', '38', '0', '0', 'Lubei Qu', 'LBQ');
INSERT INTO `t_region` VALUES ('441', '130204', '古冶区', '38', '0', '0', 'Guye Qu', 'GYE');
INSERT INTO `t_region` VALUES ('442', '130205', '开平区', '38', '0', '0', 'Kaiping Qu', 'KPQ');
INSERT INTO `t_region` VALUES ('443', '130207', '丰南区', '38', '0', '0', 'Fengnan Qu', '2');
INSERT INTO `t_region` VALUES ('444', '130208', '丰润区', '38', '0', '0', 'Fengrun Qu', '2');
INSERT INTO `t_region` VALUES ('445', '130223', '滦县', '38', '0', '0', 'Luan Xian', 'LUA');
INSERT INTO `t_region` VALUES ('446', '130224', '滦南县', '38', '0', '0', 'Luannan Xian', 'LNJ');
INSERT INTO `t_region` VALUES ('447', '130225', '乐亭县', '38', '0', '0', 'Leting Xian', 'LTJ');
INSERT INTO `t_region` VALUES ('448', '130227', '迁西县', '38', '0', '0', 'Qianxi Xian', 'QXX');
INSERT INTO `t_region` VALUES ('449', '130229', '玉田县', '38', '0', '0', 'Yutian Xian', 'YTJ');
INSERT INTO `t_region` VALUES ('450', '130230', '唐海县', '38', '0', '0', 'Tanghai Xian ', 'THA');
INSERT INTO `t_region` VALUES ('451', '130281', '遵化市', '38', '0', '0', 'Zunhua Shi', 'ZNH');
INSERT INTO `t_region` VALUES ('452', '130283', '迁安市', '38', '0', '0', 'Qian,an Shi', 'QAS');
INSERT INTO `t_region` VALUES ('453', '130301', '市辖区', '39', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('454', '130302', '海港区', '39', '0', '0', 'Haigang Qu', 'HGG');
INSERT INTO `t_region` VALUES ('455', '130303', '山海关区', '39', '0', '0', 'Shanhaiguan Qu', 'SHG');
INSERT INTO `t_region` VALUES ('456', '130304', '北戴河区', '39', '0', '0', 'Beidaihe Qu', 'BDH');
INSERT INTO `t_region` VALUES ('457', '130321', '青龙满族自治县', '39', '0', '0', 'Qinglong Manzu Zizhixian', 'QLM');
INSERT INTO `t_region` VALUES ('458', '130322', '昌黎县', '39', '0', '0', 'Changli Xian', 'CGL');
INSERT INTO `t_region` VALUES ('459', '130323', '抚宁县', '39', '0', '0', 'Funing Xian ', 'FUN');
INSERT INTO `t_region` VALUES ('460', '130324', '卢龙县', '39', '0', '0', 'Lulong Xian', 'LLG');
INSERT INTO `t_region` VALUES ('461', '130401', '市辖区', '40', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('462', '130402', '邯山区', '40', '0', '0', 'Hanshan Qu', 'HHD');
INSERT INTO `t_region` VALUES ('463', '130403', '丛台区', '40', '0', '0', 'Congtai Qu', 'CTQ');
INSERT INTO `t_region` VALUES ('464', '130404', '复兴区', '40', '0', '0', 'Fuxing Qu', 'FXQ');
INSERT INTO `t_region` VALUES ('465', '130406', '峰峰矿区', '40', '0', '0', 'Fengfeng Kuangqu', 'FFK');
INSERT INTO `t_region` VALUES ('466', '130421', '邯郸县', '40', '0', '0', 'Handan Xian ', 'HDX');
INSERT INTO `t_region` VALUES ('467', '130423', '临漳县', '40', '0', '0', 'Linzhang Xian ', 'LNZ');
INSERT INTO `t_region` VALUES ('468', '130424', '成安县', '40', '0', '0', 'Cheng,an Xian', 'CAJ');
INSERT INTO `t_region` VALUES ('469', '130425', '大名县', '40', '0', '0', 'Daming Xian', 'DMX');
INSERT INTO `t_region` VALUES ('470', '130426', '涉县', '40', '0', '0', 'She Xian', 'SEJ');
INSERT INTO `t_region` VALUES ('471', '130427', '磁县', '40', '0', '0', 'Ci Xian', 'CIX');
INSERT INTO `t_region` VALUES ('472', '130428', '肥乡县', '40', '0', '0', 'Feixiang Xian', 'FXJ');
INSERT INTO `t_region` VALUES ('473', '130429', '永年县', '40', '0', '0', 'Yongnian Xian', 'YON');
INSERT INTO `t_region` VALUES ('474', '130430', '邱县', '40', '0', '0', 'Qiu Xian', 'QIU');
INSERT INTO `t_region` VALUES ('475', '130431', '鸡泽县', '40', '0', '0', 'Jize Xian', 'JZE');
INSERT INTO `t_region` VALUES ('476', '130432', '广平县', '40', '0', '0', 'Guangping Xian ', 'GPX');
INSERT INTO `t_region` VALUES ('477', '130433', '馆陶县', '40', '0', '0', 'Guantao Xian', 'GTO');
INSERT INTO `t_region` VALUES ('478', '130434', '魏县', '40', '0', '0', 'Wei Xian ', 'WEI');
INSERT INTO `t_region` VALUES ('479', '130435', '曲周县', '40', '0', '0', 'Quzhou Xian ', 'QZX');
INSERT INTO `t_region` VALUES ('480', '130481', '武安市', '40', '0', '0', 'Wu,an Shi', 'WUA');
INSERT INTO `t_region` VALUES ('481', '130501', '市辖区', '41', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('482', '130502', '桥东区', '41', '0', '0', 'Qiaodong Qu', 'QDG');
INSERT INTO `t_region` VALUES ('483', '130503', '桥西区', '41', '0', '0', 'Qiaoxi Qu', 'QXT');
INSERT INTO `t_region` VALUES ('484', '130521', '邢台县', '41', '0', '0', 'Xingtai Xian', 'XTJ');
INSERT INTO `t_region` VALUES ('485', '130522', '临城县', '41', '0', '0', 'Lincheng Xian ', 'LNC');
INSERT INTO `t_region` VALUES ('486', '130523', '内丘县', '41', '0', '0', 'Neiqiu Xian ', 'NQU');
INSERT INTO `t_region` VALUES ('487', '130524', '柏乡县', '41', '0', '0', 'Baixiang Xian', 'BXG');
INSERT INTO `t_region` VALUES ('488', '130525', '隆尧县', '41', '0', '0', 'Longyao Xian', 'LYO');
INSERT INTO `t_region` VALUES ('489', '130526', '任县', '41', '0', '0', 'Ren Xian', 'REN');
INSERT INTO `t_region` VALUES ('490', '130527', '南和县', '41', '0', '0', 'Nanhe Xian', 'NHX');
INSERT INTO `t_region` VALUES ('491', '130528', '宁晋县', '41', '0', '0', 'Ningjin Xian', 'NJN');
INSERT INTO `t_region` VALUES ('492', '130529', '巨鹿县', '41', '0', '0', 'Julu Xian', 'JLU');
INSERT INTO `t_region` VALUES ('493', '130530', '新河县', '41', '0', '0', 'Xinhe Xian ', 'XHJ');
INSERT INTO `t_region` VALUES ('494', '130531', '广宗县', '41', '0', '0', 'Guangzong Xian ', 'GZJ');
INSERT INTO `t_region` VALUES ('495', '130532', '平乡县', '41', '0', '0', 'Pingxiang Xian', 'PXX');
INSERT INTO `t_region` VALUES ('496', '130533', '威县', '41', '0', '0', 'Wei Xian ', 'WEX');
INSERT INTO `t_region` VALUES ('497', '130534', '清河县', '41', '0', '0', 'Qinghe Xian', 'QHE');
INSERT INTO `t_region` VALUES ('498', '130535', '临西县', '41', '0', '0', 'Linxi Xian', 'LXI');
INSERT INTO `t_region` VALUES ('499', '130581', '南宫市', '41', '0', '0', 'Nangong Shi', 'NGO');
INSERT INTO `t_region` VALUES ('500', '130582', '沙河市', '41', '0', '0', 'Shahe Shi', 'SHS');
INSERT INTO `t_region` VALUES ('501', '130601', '市辖区', '42', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('502', '130600', '新市区', '42', '0', '0', 'Xinshi Qu', '2');
INSERT INTO `t_region` VALUES ('503', '130603', '北市区', '42', '0', '0', 'Beishi Qu', 'BSI');
INSERT INTO `t_region` VALUES ('504', '130604', '南市区', '42', '0', '0', 'Nanshi Qu', 'NSB');
INSERT INTO `t_region` VALUES ('505', '130621', '满城县', '42', '0', '0', 'Mancheng Xian ', 'MCE');
INSERT INTO `t_region` VALUES ('506', '130622', '清苑县', '42', '0', '0', 'Qingyuan Xian', 'QYJ');
INSERT INTO `t_region` VALUES ('507', '130623', '涞水县', '42', '0', '0', 'Laishui Xian', 'LSM');
INSERT INTO `t_region` VALUES ('508', '130624', '阜平县', '42', '0', '0', 'Fuping Xian ', 'FUP');
INSERT INTO `t_region` VALUES ('509', '130625', '徐水县', '42', '0', '0', 'Xushui Xian ', 'XSJ');
INSERT INTO `t_region` VALUES ('510', '130626', '定兴县', '42', '0', '0', 'Dingxing Xian ', 'DXG');
INSERT INTO `t_region` VALUES ('511', '130627', '唐县', '42', '0', '0', 'Tang Xian ', 'TAG');
INSERT INTO `t_region` VALUES ('512', '130628', '高阳县', '42', '0', '0', 'Gaoyang Xian ', 'GAY');
INSERT INTO `t_region` VALUES ('513', '130629', '容城县', '42', '0', '0', 'Rongcheng Xian ', 'RCX');
INSERT INTO `t_region` VALUES ('514', '130630', '涞源县', '42', '0', '0', 'Laiyuan Xian ', 'LIY');
INSERT INTO `t_region` VALUES ('515', '130631', '望都县', '42', '0', '0', 'Wangdu Xian ', 'WDU');
INSERT INTO `t_region` VALUES ('516', '130632', '安新县', '42', '0', '0', 'Anxin Xian ', 'AXX');
INSERT INTO `t_region` VALUES ('517', '130633', '易县', '42', '0', '0', 'Yi Xian', 'YII');
INSERT INTO `t_region` VALUES ('518', '130634', '曲阳县', '42', '0', '0', 'Quyang Xian ', 'QUY');
INSERT INTO `t_region` VALUES ('519', '130635', '蠡县', '42', '0', '0', 'Li Xian', 'LXJ');
INSERT INTO `t_region` VALUES ('520', '130636', '顺平县', '42', '0', '0', 'Shunping Xian ', 'SPI');
INSERT INTO `t_region` VALUES ('521', '130637', '博野县', '42', '0', '0', 'Boye Xian ', 'BYE');
INSERT INTO `t_region` VALUES ('522', '130638', '雄县', '42', '0', '0', 'Xiong Xian', 'XOX');
INSERT INTO `t_region` VALUES ('523', '130681', '涿州市', '42', '0', '0', 'Zhuozhou Shi', 'ZZO');
INSERT INTO `t_region` VALUES ('524', '130682', '定州市', '42', '0', '0', 'Dingzhou Shi ', 'DZO');
INSERT INTO `t_region` VALUES ('525', '130683', '安国市', '42', '0', '0', 'Anguo Shi ', 'AGO');
INSERT INTO `t_region` VALUES ('526', '130684', '高碑店市', '42', '0', '0', 'Gaobeidian Shi', 'GBD');
INSERT INTO `t_region` VALUES ('527', '130701', '市辖区', '43', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('528', '130702', '桥东区', '43', '0', '0', 'Qiaodong Qu', 'QDZ');
INSERT INTO `t_region` VALUES ('529', '130703', '桥西区', '43', '0', '0', 'Qiaoxi Qu', 'QXI');
INSERT INTO `t_region` VALUES ('530', '130705', '宣化区', '43', '0', '0', 'Xuanhua Qu', 'XHZ');
INSERT INTO `t_region` VALUES ('531', '130706', '下花园区', '43', '0', '0', 'Xiahuayuan Qu ', 'XHY');
INSERT INTO `t_region` VALUES ('532', '130721', '宣化县', '43', '0', '0', 'Xuanhua Xian ', 'XHX');
INSERT INTO `t_region` VALUES ('533', '130722', '张北县', '43', '0', '0', 'Zhangbei Xian ', 'ZGB');
INSERT INTO `t_region` VALUES ('534', '130723', '康保县', '43', '0', '0', 'Kangbao Xian', 'KBO');
INSERT INTO `t_region` VALUES ('535', '130724', '沽源县', '43', '0', '0', 'Guyuan Xian', '2');
INSERT INTO `t_region` VALUES ('536', '130725', '尚义县', '43', '0', '0', 'Shangyi Xian', 'SYK');
INSERT INTO `t_region` VALUES ('537', '130726', '蔚县', '43', '0', '0', 'Yu Xian', 'YXJ');
INSERT INTO `t_region` VALUES ('538', '130727', '阳原县', '43', '0', '0', 'Yangyuan Xian', 'YYN');
INSERT INTO `t_region` VALUES ('539', '130728', '怀安县', '43', '0', '0', 'Huai,an Xian', 'HAX');
INSERT INTO `t_region` VALUES ('540', '130729', '万全县', '43', '0', '0', 'Wanquan Xian ', 'WQN');
INSERT INTO `t_region` VALUES ('541', '130730', '怀来县', '43', '0', '0', 'Huailai Xian', 'HLA');
INSERT INTO `t_region` VALUES ('542', '130731', '涿鹿县', '43', '0', '0', 'Zhuolu Xian ', 'ZLU');
INSERT INTO `t_region` VALUES ('543', '130732', '赤城县', '43', '0', '0', 'Chicheng Xian', 'CCX');
INSERT INTO `t_region` VALUES ('544', '130733', '崇礼县', '43', '0', '0', 'Chongli Xian', 'COL');
INSERT INTO `t_region` VALUES ('545', '130801', '市辖区', '44', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('546', '130802', '双桥区', '44', '0', '0', 'Shuangqiao Qu ', 'SQO');
INSERT INTO `t_region` VALUES ('547', '130803', '双滦区', '44', '0', '0', 'Shuangluan Qu', 'SLQ');
INSERT INTO `t_region` VALUES ('548', '130804', '鹰手营子矿区', '44', '0', '0', 'Yingshouyingzi Kuangqu', 'YSY');
INSERT INTO `t_region` VALUES ('549', '130821', '承德县', '44', '0', '0', 'Chengde Xian', 'CDX');
INSERT INTO `t_region` VALUES ('550', '130822', '兴隆县', '44', '0', '0', 'Xinglong Xian', 'XLJ');
INSERT INTO `t_region` VALUES ('551', '130823', '平泉县', '44', '0', '0', 'Pingquan Xian', 'PQN');
INSERT INTO `t_region` VALUES ('552', '130824', '滦平县', '44', '0', '0', 'Luanping Xian ', 'LUP');
INSERT INTO `t_region` VALUES ('553', '130825', '隆化县', '44', '0', '0', 'Longhua Xian', 'LHJ');
INSERT INTO `t_region` VALUES ('554', '130826', '丰宁满族自治县', '44', '0', '0', 'Fengning Manzu Zizhixian', 'FNJ');
INSERT INTO `t_region` VALUES ('555', '130827', '宽城满族自治县', '44', '0', '0', 'Kuancheng Manzu Zizhixian', 'KCX');
INSERT INTO `t_region` VALUES ('556', '130828', '围场满族蒙古族自治县', '44', '0', '0', 'Weichang Manzu Menggolzu Zizhixian', 'WCJ');
INSERT INTO `t_region` VALUES ('557', '130901', '市辖区', '45', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('558', '130902', '新华区', '45', '0', '0', 'Xinhua Qu', 'XHF');
INSERT INTO `t_region` VALUES ('559', '130903', '运河区', '45', '0', '0', 'Yunhe Qu', 'YHC');
INSERT INTO `t_region` VALUES ('560', '130921', '沧县', '45', '0', '0', 'Cang Xian', 'CAG');
INSERT INTO `t_region` VALUES ('561', '130922', '青县', '45', '0', '0', 'Qing Xian', 'QIG');
INSERT INTO `t_region` VALUES ('562', '130923', '东光县', '45', '0', '0', 'Dongguang Xian ', 'DGU');
INSERT INTO `t_region` VALUES ('563', '130924', '海兴县', '45', '0', '0', 'Haixing Xian', 'HXG');
INSERT INTO `t_region` VALUES ('564', '130925', '盐山县', '45', '0', '0', 'Yanshan Xian', 'YNS');
INSERT INTO `t_region` VALUES ('565', '130926', '肃宁县', '45', '0', '0', 'Suning Xian ', 'SNG');
INSERT INTO `t_region` VALUES ('566', '130927', '南皮县', '45', '0', '0', 'Nanpi Xian', 'NPI');
INSERT INTO `t_region` VALUES ('567', '130928', '吴桥县', '45', '0', '0', 'Wuqiao Xian ', 'WUQ');
INSERT INTO `t_region` VALUES ('568', '130929', '献县', '45', '0', '0', 'Xian Xian ', 'XXN');
INSERT INTO `t_region` VALUES ('569', '130930', '孟村回族自治县', '45', '0', '0', 'Mengcun Huizu Zizhixian', 'MCN');
INSERT INTO `t_region` VALUES ('570', '130981', '泊头市', '45', '0', '0', 'Botou Shi ', 'BOT');
INSERT INTO `t_region` VALUES ('571', '130982', '任丘市', '45', '0', '0', 'Renqiu Shi', 'RQS');
INSERT INTO `t_region` VALUES ('572', '130983', '黄骅市', '45', '0', '0', 'Huanghua Shi', 'HHJ');
INSERT INTO `t_region` VALUES ('573', '130984', '河间市', '45', '0', '0', 'Hejian Shi', 'HJN');
INSERT INTO `t_region` VALUES ('574', '131001', '市辖区', '46', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('575', '131002', '安次区', '46', '0', '0', 'Anci Qu', 'ACI');
INSERT INTO `t_region` VALUES ('576', '131003', '广阳区', '46', '0', '0', 'Guangyang Qu', '2');
INSERT INTO `t_region` VALUES ('577', '131022', '固安县', '46', '0', '0', 'Gu,an Xian', 'GUA');
INSERT INTO `t_region` VALUES ('578', '131023', '永清县', '46', '0', '0', 'Yongqing Xian ', 'YQG');
INSERT INTO `t_region` VALUES ('579', '131024', '香河县', '46', '0', '0', 'Xianghe Xian', 'XGH');
INSERT INTO `t_region` VALUES ('580', '131025', '大城县', '46', '0', '0', 'Dacheng Xian', 'DCJ');
INSERT INTO `t_region` VALUES ('581', '131026', '文安县', '46', '0', '0', 'Wen,an Xian', 'WEA');
INSERT INTO `t_region` VALUES ('582', '131028', '大厂回族自治县', '46', '0', '0', 'Dachang Huizu Zizhixian', 'DCG');
INSERT INTO `t_region` VALUES ('583', '131081', '霸州市', '46', '0', '0', 'Bazhou Shi', 'BZO');
INSERT INTO `t_region` VALUES ('584', '131082', '三河市', '46', '0', '0', 'Sanhe Shi', 'SNH');
INSERT INTO `t_region` VALUES ('585', '131101', '市辖区', '47', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('586', '131102', '桃城区', '47', '0', '0', 'Taocheng Qu', 'TOC');
INSERT INTO `t_region` VALUES ('587', '131121', '枣强县', '47', '0', '0', 'Zaoqiang Xian ', 'ZQJ');
INSERT INTO `t_region` VALUES ('588', '131122', '武邑县', '47', '0', '0', 'Wuyi Xian', 'WYI');
INSERT INTO `t_region` VALUES ('589', '131123', '武强县', '47', '0', '0', 'Wuqiang Xian ', 'WQG');
INSERT INTO `t_region` VALUES ('590', '131124', '饶阳县', '47', '0', '0', 'Raoyang Xian', 'RYG');
INSERT INTO `t_region` VALUES ('591', '131125', '安平县', '47', '0', '0', 'Anping Xian', 'APG');
INSERT INTO `t_region` VALUES ('592', '131126', '故城县', '47', '0', '0', 'Gucheng Xian', 'GCE');
INSERT INTO `t_region` VALUES ('593', '131127', '景县', '47', '0', '0', 'Jing Xian ', 'JIG');
INSERT INTO `t_region` VALUES ('594', '131128', '阜城县', '47', '0', '0', 'Fucheng Xian ', 'FCE');
INSERT INTO `t_region` VALUES ('595', '131181', '冀州市', '47', '0', '0', 'Jizhou Shi ', 'JIZ');
INSERT INTO `t_region` VALUES ('596', '131182', '深州市', '47', '0', '0', 'Shenzhou Shi', 'SNZ');
INSERT INTO `t_region` VALUES ('597', '140101', '市辖区', '48', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('598', '140105', '小店区', '48', '0', '0', 'Xiaodian Qu', 'XDQ');
INSERT INTO `t_region` VALUES ('599', '140106', '迎泽区', '48', '0', '0', 'Yingze Qu', 'YZT');
INSERT INTO `t_region` VALUES ('600', '140107', '杏花岭区', '48', '0', '0', 'Xinghualing Qu', 'XHL');
INSERT INTO `t_region` VALUES ('601', '140108', '尖草坪区', '48', '0', '0', 'Jiancaoping Qu', 'JCP');
INSERT INTO `t_region` VALUES ('602', '140109', '万柏林区', '48', '0', '0', 'Wanbailin Qu', 'WBL');
INSERT INTO `t_region` VALUES ('603', '140110', '晋源区', '48', '0', '0', 'Jinyuan Qu', 'JYM');
INSERT INTO `t_region` VALUES ('604', '140121', '清徐县', '48', '0', '0', 'Qingxu Xian ', 'QXU');
INSERT INTO `t_region` VALUES ('605', '140122', '阳曲县', '48', '0', '0', 'Yangqu Xian ', 'YGQ');
INSERT INTO `t_region` VALUES ('606', '140123', '娄烦县', '48', '0', '0', 'Loufan Xian', 'LFA');
INSERT INTO `t_region` VALUES ('607', '140181', '古交市', '48', '0', '0', 'Gujiao Shi', 'GUJ');
INSERT INTO `t_region` VALUES ('608', '140201', '市辖区', '49', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('609', '140202', '城区', '49', '0', '0', 'Chengqu', 'CQD');
INSERT INTO `t_region` VALUES ('610', '140203', '矿区', '49', '0', '0', 'Kuangqu', 'KQD');
INSERT INTO `t_region` VALUES ('611', '140211', '南郊区', '49', '0', '0', 'Nanjiao Qu', 'NJQ');
INSERT INTO `t_region` VALUES ('612', '140212', '新荣区', '49', '0', '0', 'Xinrong Qu', 'XRQ');
INSERT INTO `t_region` VALUES ('613', '140221', '阳高县', '49', '0', '0', 'Yanggao Xian ', 'YGO');
INSERT INTO `t_region` VALUES ('614', '140222', '天镇县', '49', '0', '0', 'Tianzhen Xian ', 'TZE');
INSERT INTO `t_region` VALUES ('615', '140223', '广灵县', '49', '0', '0', 'Guangling Xian ', 'GLJ');
INSERT INTO `t_region` VALUES ('616', '140224', '灵丘县', '49', '0', '0', 'Lingqiu Xian ', 'LQX');
INSERT INTO `t_region` VALUES ('617', '140225', '浑源县', '49', '0', '0', 'Hunyuan Xian', 'HYM');
INSERT INTO `t_region` VALUES ('618', '140226', '左云县', '49', '0', '0', 'Zuoyun Xian', 'ZUY');
INSERT INTO `t_region` VALUES ('619', '140227', '大同县', '49', '0', '0', 'Datong Xian ', 'DTX');
INSERT INTO `t_region` VALUES ('620', '140301', '市辖区', '50', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('621', '140302', '城区', '50', '0', '0', 'Chengqu', 'CQU');
INSERT INTO `t_region` VALUES ('622', '140303', '矿区', '50', '0', '0', 'Kuangqu', 'KQY');
INSERT INTO `t_region` VALUES ('623', '140311', '郊区', '50', '0', '0', 'Jiaoqu', 'JQY');
INSERT INTO `t_region` VALUES ('624', '140321', '平定县', '50', '0', '0', 'Pingding Xian', 'PDG');
INSERT INTO `t_region` VALUES ('625', '140322', '盂县', '50', '0', '0', 'Yu Xian', 'YUX');
INSERT INTO `t_region` VALUES ('626', '140401', '市辖区', '51', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('627', '140402', '城区', '51', '0', '0', 'Chengqu ', 'CQC');
INSERT INTO `t_region` VALUES ('628', '140411', '郊区', '51', '0', '0', 'Jiaoqu', 'JQZ');
INSERT INTO `t_region` VALUES ('629', '140421', '长治县', '51', '0', '0', 'Changzhi Xian', 'CZI');
INSERT INTO `t_region` VALUES ('630', '140423', '襄垣县', '51', '0', '0', 'Xiangyuan Xian', 'XYJ');
INSERT INTO `t_region` VALUES ('631', '140424', '屯留县', '51', '0', '0', 'Tunliu Xian', 'TNL');
INSERT INTO `t_region` VALUES ('632', '140425', '平顺县', '51', '0', '0', 'Pingshun Xian', 'PSX');
INSERT INTO `t_region` VALUES ('633', '140426', '黎城县', '51', '0', '0', 'Licheng Xian', 'LIC');
INSERT INTO `t_region` VALUES ('634', '140427', '壶关县', '51', '0', '0', 'Huguan Xian', 'HGN');
INSERT INTO `t_region` VALUES ('635', '140428', '长子县', '51', '0', '0', 'Zhangzi Xian ', 'ZHZ');
INSERT INTO `t_region` VALUES ('636', '140429', '武乡县', '51', '0', '0', 'Wuxiang Xian', 'WXG');
INSERT INTO `t_region` VALUES ('637', '140430', '沁县', '51', '0', '0', 'Qin Xian', 'QIN');
INSERT INTO `t_region` VALUES ('638', '140431', '沁源县', '51', '0', '0', 'Qinyuan Xian ', 'QYU');
INSERT INTO `t_region` VALUES ('639', '140481', '潞城市', '51', '0', '0', 'Lucheng Shi', 'LCS');
INSERT INTO `t_region` VALUES ('640', '140501', '市辖区', '52', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('641', '140502', '城区', '52', '0', '0', 'Chengqu ', 'CQJ');
INSERT INTO `t_region` VALUES ('642', '140521', '沁水县', '52', '0', '0', 'Qinshui Xian', 'QSI');
INSERT INTO `t_region` VALUES ('643', '140522', '阳城县', '52', '0', '0', 'Yangcheng Xian ', 'YGC');
INSERT INTO `t_region` VALUES ('644', '140524', '陵川县', '52', '0', '0', 'Lingchuan Xian', 'LGC');
INSERT INTO `t_region` VALUES ('645', '140525', '泽州县', '52', '0', '0', 'Zezhou Xian', 'ZEZ');
INSERT INTO `t_region` VALUES ('646', '140581', '高平市', '52', '0', '0', 'Gaoping Shi ', 'GPG');
INSERT INTO `t_region` VALUES ('647', '140601', '市辖区', '53', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('648', '140602', '朔城区', '53', '0', '0', 'Shuocheng Qu', 'SCH');
INSERT INTO `t_region` VALUES ('649', '140603', '平鲁区', '53', '0', '0', 'Pinglu Qu', 'PLU');
INSERT INTO `t_region` VALUES ('650', '140621', '山阴县', '53', '0', '0', 'Shanyin Xian', 'SYP');
INSERT INTO `t_region` VALUES ('651', '140622', '应县', '53', '0', '0', 'Ying Xian', 'YIG');
INSERT INTO `t_region` VALUES ('652', '140623', '右玉县', '53', '0', '0', 'Youyu Xian ', 'YOY');
INSERT INTO `t_region` VALUES ('653', '140624', '怀仁县', '53', '0', '0', 'Huairen Xian', 'HRN');
INSERT INTO `t_region` VALUES ('654', '140701', '市辖区', '54', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('655', '140702', '榆次区', '54', '0', '0', 'Yuci Qu', '2');
INSERT INTO `t_region` VALUES ('656', '140721', '榆社县', '54', '0', '0', 'Yushe Xian', '2');
INSERT INTO `t_region` VALUES ('657', '140722', '左权县', '54', '0', '0', 'Zuoquan Xian', '2');
INSERT INTO `t_region` VALUES ('658', '140723', '和顺县', '54', '0', '0', 'Heshun Xian', '2');
INSERT INTO `t_region` VALUES ('659', '140724', '昔阳县', '54', '0', '0', 'Xiyang Xian', '2');
INSERT INTO `t_region` VALUES ('660', '140725', '寿阳县', '54', '0', '0', 'Shouyang Xian', '2');
INSERT INTO `t_region` VALUES ('661', '140726', '太谷县', '54', '0', '0', 'Taigu Xian', '2');
INSERT INTO `t_region` VALUES ('662', '140727', '祁县', '54', '0', '0', 'Qi Xian', '2');
INSERT INTO `t_region` VALUES ('663', '140728', '平遥县', '54', '0', '0', 'Pingyao Xian', '2');
INSERT INTO `t_region` VALUES ('664', '140729', '灵石县', '54', '0', '0', 'Lingshi Xian', '2');
INSERT INTO `t_region` VALUES ('665', '140781', '介休市', '54', '0', '0', 'Jiexiu Shi', '2');
INSERT INTO `t_region` VALUES ('666', '140801', '市辖区', '55', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('667', '140802', '盐湖区', '55', '0', '0', 'Yanhu Qu', '2');
INSERT INTO `t_region` VALUES ('668', '140821', '临猗县', '55', '0', '0', 'Linyi Xian', '2');
INSERT INTO `t_region` VALUES ('669', '140822', '万荣县', '55', '0', '0', 'Wanrong Xian', '2');
INSERT INTO `t_region` VALUES ('670', '140823', '闻喜县', '55', '0', '0', 'Wenxi Xian', '2');
INSERT INTO `t_region` VALUES ('671', '140824', '稷山县', '55', '0', '0', 'Jishan Xian', '2');
INSERT INTO `t_region` VALUES ('672', '140825', '新绛县', '55', '0', '0', 'Xinjiang Xian', '2');
INSERT INTO `t_region` VALUES ('673', '140826', '绛县', '55', '0', '0', 'Jiang Xian', '2');
INSERT INTO `t_region` VALUES ('674', '140827', '垣曲县', '55', '0', '0', 'Yuanqu Xian', '2');
INSERT INTO `t_region` VALUES ('675', '140828', '夏县', '55', '0', '0', 'Xia Xian ', '2');
INSERT INTO `t_region` VALUES ('676', '140829', '平陆县', '55', '0', '0', 'Pinglu Xian', '2');
INSERT INTO `t_region` VALUES ('677', '140830', '芮城县', '55', '0', '0', 'Ruicheng Xian', '2');
INSERT INTO `t_region` VALUES ('678', '140881', '永济市', '55', '0', '0', 'Yongji Shi ', '2');
INSERT INTO `t_region` VALUES ('679', '140882', '河津市', '55', '0', '0', 'Hejin Shi', '2');
INSERT INTO `t_region` VALUES ('680', '140901', '市辖区', '56', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('681', '140902', '忻府区', '56', '0', '0', 'Xinfu Qu', '2');
INSERT INTO `t_region` VALUES ('682', '140921', '定襄县', '56', '0', '0', 'Dingxiang Xian', '2');
INSERT INTO `t_region` VALUES ('683', '140922', '五台县', '56', '0', '0', 'Wutai Xian', '2');
INSERT INTO `t_region` VALUES ('684', '140923', '代县', '56', '0', '0', 'Dai Xian', '2');
INSERT INTO `t_region` VALUES ('685', '140924', '繁峙县', '56', '0', '0', 'Fanshi Xian', '2');
INSERT INTO `t_region` VALUES ('686', '140925', '宁武县', '56', '0', '0', 'Ningwu Xian', '2');
INSERT INTO `t_region` VALUES ('687', '140926', '静乐县', '56', '0', '0', 'Jingle Xian', '2');
INSERT INTO `t_region` VALUES ('688', '140927', '神池县', '56', '0', '0', 'Shenchi Xian', '2');
INSERT INTO `t_region` VALUES ('689', '140928', '五寨县', '56', '0', '0', 'Wuzhai Xian', '2');
INSERT INTO `t_region` VALUES ('690', '140929', '岢岚县', '56', '0', '0', 'Kelan Xian', '2');
INSERT INTO `t_region` VALUES ('691', '140930', '河曲县', '56', '0', '0', 'Hequ Xian ', '2');
INSERT INTO `t_region` VALUES ('692', '140931', '保德县', '56', '0', '0', 'Baode Xian', '2');
INSERT INTO `t_region` VALUES ('693', '140932', '偏关县', '56', '0', '0', 'Pianguan Xian', '2');
INSERT INTO `t_region` VALUES ('694', '140981', '原平市', '56', '0', '0', 'Yuanping Shi', '2');
INSERT INTO `t_region` VALUES ('695', '141001', '市辖区', '57', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('696', '141002', '尧都区', '57', '0', '0', 'Yaodu Qu', '2');
INSERT INTO `t_region` VALUES ('697', '141021', '曲沃县', '57', '0', '0', 'Quwo Xian ', '2');
INSERT INTO `t_region` VALUES ('698', '141022', '翼城县', '57', '0', '0', 'Yicheng Xian', '2');
INSERT INTO `t_region` VALUES ('699', '141023', '襄汾县', '57', '0', '0', 'Xiangfen Xian', '2');
INSERT INTO `t_region` VALUES ('700', '141024', '洪洞县', '57', '0', '0', 'Hongtong Xian', '2');
INSERT INTO `t_region` VALUES ('701', '141025', '古县', '57', '0', '0', 'Gu Xian', '2');
INSERT INTO `t_region` VALUES ('702', '141026', '安泽县', '57', '0', '0', 'Anze Xian', '2');
INSERT INTO `t_region` VALUES ('703', '141027', '浮山县', '57', '0', '0', 'Fushan Xian ', '2');
INSERT INTO `t_region` VALUES ('704', '141028', '吉县', '57', '0', '0', 'Ji Xian', '2');
INSERT INTO `t_region` VALUES ('705', '141029', '乡宁县', '57', '0', '0', 'Xiangning Xian', '2');
INSERT INTO `t_region` VALUES ('706', '141030', '大宁县', '57', '0', '0', 'Daning Xian', '2');
INSERT INTO `t_region` VALUES ('707', '141031', '隰县', '57', '0', '0', 'Xi Xian', '2');
INSERT INTO `t_region` VALUES ('708', '141032', '永和县', '57', '0', '0', 'Yonghe Xian', '2');
INSERT INTO `t_region` VALUES ('709', '141033', '蒲县', '57', '0', '0', 'Pu Xian', '2');
INSERT INTO `t_region` VALUES ('710', '141034', '汾西县', '57', '0', '0', 'Fenxi Xian', '2');
INSERT INTO `t_region` VALUES ('711', '141081', '侯马市', '57', '0', '0', 'Houma Shi ', '2');
INSERT INTO `t_region` VALUES ('712', '141082', '霍州市', '57', '0', '0', 'Huozhou Shi ', '2');
INSERT INTO `t_region` VALUES ('713', '141101', '市辖区', '58', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('714', '141102', '离石区', '58', '0', '0', 'Lishi Qu', '2');
INSERT INTO `t_region` VALUES ('715', '141121', '文水县', '58', '0', '0', 'Wenshui Xian', '2');
INSERT INTO `t_region` VALUES ('716', '141122', '交城县', '58', '0', '0', 'Jiaocheng Xian', '2');
INSERT INTO `t_region` VALUES ('717', '141123', '兴县', '58', '0', '0', 'Xing Xian', '2');
INSERT INTO `t_region` VALUES ('718', '141124', '临县', '58', '0', '0', 'Lin Xian ', '2');
INSERT INTO `t_region` VALUES ('719', '141125', '柳林县', '58', '0', '0', 'Liulin Xian', '2');
INSERT INTO `t_region` VALUES ('720', '141126', '石楼县', '58', '0', '0', 'Shilou Xian', '2');
INSERT INTO `t_region` VALUES ('721', '141127', '岚县', '58', '0', '0', 'Lan Xian', '2');
INSERT INTO `t_region` VALUES ('722', '141128', '方山县', '58', '0', '0', 'Fangshan Xian', '2');
INSERT INTO `t_region` VALUES ('723', '141129', '中阳县', '58', '0', '0', 'Zhongyang Xian', '2');
INSERT INTO `t_region` VALUES ('724', '141130', '交口县', '58', '0', '0', 'Jiaokou Xian', '2');
INSERT INTO `t_region` VALUES ('725', '141181', '孝义市', '58', '0', '0', 'Xiaoyi Shi', '2');
INSERT INTO `t_region` VALUES ('726', '141182', '汾阳市', '58', '0', '0', 'Fenyang Shi', '2');
INSERT INTO `t_region` VALUES ('727', '150101', '市辖区', '59', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('728', '150102', '新城区', '59', '0', '0', 'Xincheng Qu', 'XCN');
INSERT INTO `t_region` VALUES ('729', '150103', '回民区', '59', '0', '0', 'Huimin Qu', 'HMQ');
INSERT INTO `t_region` VALUES ('730', '150104', '玉泉区', '59', '0', '0', 'Yuquan Qu', 'YQN');
INSERT INTO `t_region` VALUES ('731', '150105', '赛罕区', '59', '0', '0', 'Saihan Qu', '2');
INSERT INTO `t_region` VALUES ('732', '150121', '土默特左旗', '59', '0', '0', 'Tumd Zuoqi', 'TUZ');
INSERT INTO `t_region` VALUES ('733', '150122', '托克托县', '59', '0', '0', 'Togtoh Xian', 'TOG');
INSERT INTO `t_region` VALUES ('734', '150123', '和林格尔县', '59', '0', '0', 'Horinger Xian', 'HOR');
INSERT INTO `t_region` VALUES ('735', '150124', '清水河县', '59', '0', '0', 'Qingshuihe Xian', 'QSH');
INSERT INTO `t_region` VALUES ('736', '150125', '武川县', '59', '0', '0', 'Wuchuan Xian', 'WCX');
INSERT INTO `t_region` VALUES ('737', '150201', '市辖区', '60', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('738', '150202', '东河区', '60', '0', '0', 'Donghe Qu', 'DHE');
INSERT INTO `t_region` VALUES ('739', '150203', '昆都仑区', '60', '0', '0', 'Kundulun Qu', '2');
INSERT INTO `t_region` VALUES ('740', '150204', '青山区', '60', '0', '0', 'Qingshan Qu', 'QSB');
INSERT INTO `t_region` VALUES ('741', '150205', '石拐区', '60', '0', '0', 'Shiguai Qu', '2');
INSERT INTO `t_region` VALUES ('742', '150206', '白云鄂博矿区', '60', '0', '0', 'Baiyun Kuangqu', '2');
INSERT INTO `t_region` VALUES ('743', '150207', '九原区', '60', '0', '0', 'Jiuyuan Qu', '2');
INSERT INTO `t_region` VALUES ('744', '150221', '土默特右旗', '60', '0', '0', 'Tumd Youqi', 'TUY');
INSERT INTO `t_region` VALUES ('745', '150222', '固阳县', '60', '0', '0', 'Guyang Xian', 'GYM');
INSERT INTO `t_region` VALUES ('746', '150223', '达尔罕茂明安联合旗', '60', '0', '0', 'Darhan Muminggan Lianheqi', 'DML');
INSERT INTO `t_region` VALUES ('747', '150301', '市辖区', '61', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('748', '150302', '海勃湾区', '61', '0', '0', 'Haibowan Qu', 'HBW');
INSERT INTO `t_region` VALUES ('749', '150303', '海南区', '61', '0', '0', 'Hainan Qu', 'HNU');
INSERT INTO `t_region` VALUES ('750', '150304', '乌达区', '61', '0', '0', 'Ud Qu', 'UDQ');
INSERT INTO `t_region` VALUES ('751', '150401', '市辖区', '62', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('752', '150402', '红山区', '62', '0', '0', 'Hongshan Qu', 'HSZ');
INSERT INTO `t_region` VALUES ('753', '150403', '元宝山区', '62', '0', '0', 'Yuanbaoshan Qu', 'YBO');
INSERT INTO `t_region` VALUES ('754', '150404', '松山区', '62', '0', '0', 'Songshan Qu', 'SSQ');
INSERT INTO `t_region` VALUES ('755', '150421', '阿鲁科尔沁旗', '62', '0', '0', 'Ar Horqin Qi', 'AHO');
INSERT INTO `t_region` VALUES ('756', '150422', '巴林左旗', '62', '0', '0', 'Bairin Zuoqi', 'BAZ');
INSERT INTO `t_region` VALUES ('757', '150423', '巴林右旗', '62', '0', '0', 'Bairin Youqi', 'BAY');
INSERT INTO `t_region` VALUES ('758', '150424', '林西县', '62', '0', '0', 'Linxi Xian', 'LXM');
INSERT INTO `t_region` VALUES ('759', '150425', '克什克腾旗', '62', '0', '0', 'Hexigten Qi', 'HXT');
INSERT INTO `t_region` VALUES ('760', '150426', '翁牛特旗', '62', '0', '0', 'Ongniud Qi', 'ONG');
INSERT INTO `t_region` VALUES ('761', '150428', '喀喇沁旗', '62', '0', '0', 'Harqin Qi', 'HAR');
INSERT INTO `t_region` VALUES ('762', '150429', '宁城县', '62', '0', '0', 'Ningcheng Xian', 'NCH');
INSERT INTO `t_region` VALUES ('763', '150430', '敖汉旗', '62', '0', '0', 'Aohan Qi', 'AHN');
INSERT INTO `t_region` VALUES ('764', '150501', '市辖区', '63', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('765', '150502', '科尔沁区', '63', '0', '0', 'Keermi Qu', '2');
INSERT INTO `t_region` VALUES ('766', '150521', '科尔沁左翼中旗', '63', '0', '0', 'Horqin Zuoyi Zhongqi', '2');
INSERT INTO `t_region` VALUES ('767', '150522', '科尔沁左翼后旗', '63', '0', '0', 'Horqin Zuoyi Houqi', '2');
INSERT INTO `t_region` VALUES ('768', '150523', '开鲁县', '63', '0', '0', 'Kailu Xian', '2');
INSERT INTO `t_region` VALUES ('769', '150524', '库伦旗', '63', '0', '0', 'Hure Qi', '2');
INSERT INTO `t_region` VALUES ('770', '150525', '奈曼旗', '63', '0', '0', 'Naiman Qi', '2');
INSERT INTO `t_region` VALUES ('771', '150526', '扎鲁特旗', '63', '0', '0', 'Jarud Qi', '2');
INSERT INTO `t_region` VALUES ('772', '150581', '霍林郭勒市', '63', '0', '0', 'Holingol Shi', '2');
INSERT INTO `t_region` VALUES ('773', '150602', '东胜区', '64', '0', '0', 'Dongsheng Qu', '2');
INSERT INTO `t_region` VALUES ('774', '150621', '达拉特旗', '64', '0', '0', 'Dalad Qi', '2');
INSERT INTO `t_region` VALUES ('775', '150622', '准格尔旗', '64', '0', '0', 'Jungar Qi', '2');
INSERT INTO `t_region` VALUES ('776', '150623', '鄂托克前旗', '64', '0', '0', 'Otog Qianqi', '2');
INSERT INTO `t_region` VALUES ('777', '150624', '鄂托克旗', '64', '0', '0', 'Otog Qi', '2');
INSERT INTO `t_region` VALUES ('778', '150625', '杭锦旗', '64', '0', '0', 'Hanggin Qi', '2');
INSERT INTO `t_region` VALUES ('779', '150626', '乌审旗', '64', '0', '0', 'Uxin Qi', '2');
INSERT INTO `t_region` VALUES ('780', '150627', '伊金霍洛旗', '64', '0', '0', 'Ejin Horo Qi', '2');
INSERT INTO `t_region` VALUES ('781', '150701', '市辖区', '65', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('782', '150702', '海拉尔区', '65', '0', '0', 'Hailaer Qu', '2');
INSERT INTO `t_region` VALUES ('783', '150721', '阿荣旗', '65', '0', '0', 'Arun Qi', '2');
INSERT INTO `t_region` VALUES ('784', '150722', '莫力达瓦达斡尔族自治旗', '65', '0', '0', 'Morin Dawa Daurzu Zizhiqi', '2');
INSERT INTO `t_region` VALUES ('785', '150723', '鄂伦春自治旗', '65', '0', '0', 'Oroqen Zizhiqi', '2');
INSERT INTO `t_region` VALUES ('786', '150724', '鄂温克族自治旗', '65', '0', '0', 'Ewenkizu Zizhiqi', '2');
INSERT INTO `t_region` VALUES ('787', '150725', '陈巴尔虎旗', '65', '0', '0', 'Chen Barag Qi', '2');
INSERT INTO `t_region` VALUES ('788', '150726', '新巴尔虎左旗', '65', '0', '0', 'Xin Barag Zuoqi', '2');
INSERT INTO `t_region` VALUES ('789', '150727', '新巴尔虎右旗', '65', '0', '0', 'Xin Barag Youqi', '2');
INSERT INTO `t_region` VALUES ('790', '150781', '满洲里市', '65', '0', '0', 'Manzhouli Shi', '2');
INSERT INTO `t_region` VALUES ('791', '150782', '牙克石市', '65', '0', '0', 'Yakeshi Shi', '2');
INSERT INTO `t_region` VALUES ('792', '150783', '扎兰屯市', '65', '0', '0', 'Zalantun Shi', '2');
INSERT INTO `t_region` VALUES ('793', '150784', '额尔古纳市', '65', '0', '0', 'Ergun Shi', '2');
INSERT INTO `t_region` VALUES ('794', '150785', '根河市', '65', '0', '0', 'Genhe Shi', '2');
INSERT INTO `t_region` VALUES ('795', '150801', '市辖区', '66', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('796', '150802', '临河区', '66', '0', '0', 'Linhe Qu', '2');
INSERT INTO `t_region` VALUES ('797', '150821', '五原县', '66', '0', '0', 'Wuyuan Xian', '2');
INSERT INTO `t_region` VALUES ('798', '150822', '磴口县', '66', '0', '0', 'Dengkou Xian', '2');
INSERT INTO `t_region` VALUES ('799', '150823', '乌拉特前旗', '66', '0', '0', 'Urad Qianqi', '2');
INSERT INTO `t_region` VALUES ('800', '150824', '乌拉特中旗', '66', '0', '0', 'Urad Zhongqi', '2');
INSERT INTO `t_region` VALUES ('801', '150825', '乌拉特后旗', '66', '0', '0', 'Urad Houqi', '2');
INSERT INTO `t_region` VALUES ('802', '150826', '杭锦后旗', '66', '0', '0', 'Hanggin Houqi', '2');
INSERT INTO `t_region` VALUES ('803', '150901', '市辖区', '67', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('804', '150902', '集宁区', '67', '0', '0', 'Jining Qu', '2');
INSERT INTO `t_region` VALUES ('805', '150921', '卓资县', '67', '0', '0', 'Zhuozi Xian', '2');
INSERT INTO `t_region` VALUES ('806', '150922', '化德县', '67', '0', '0', 'Huade Xian', '2');
INSERT INTO `t_region` VALUES ('807', '150923', '商都县', '67', '0', '0', 'Shangdu Xian', '2');
INSERT INTO `t_region` VALUES ('808', '150924', '兴和县', '67', '0', '0', 'Xinghe Xian', '2');
INSERT INTO `t_region` VALUES ('809', '150925', '凉城县', '67', '0', '0', 'Liangcheng Xian', '2');
INSERT INTO `t_region` VALUES ('810', '150926', '察哈尔右翼前旗', '67', '0', '0', 'Qahar Youyi Qianqi', '2');
INSERT INTO `t_region` VALUES ('811', '150927', '察哈尔右翼中旗', '67', '0', '0', 'Qahar Youyi Zhongqi', '2');
INSERT INTO `t_region` VALUES ('812', '150928', '察哈尔右翼后旗', '67', '0', '0', 'Qahar Youyi Houqi', '2');
INSERT INTO `t_region` VALUES ('813', '150929', '四子王旗', '67', '0', '0', 'Dorbod Qi', '2');
INSERT INTO `t_region` VALUES ('814', '150981', '丰镇市', '67', '0', '0', 'Fengzhen Shi', '2');
INSERT INTO `t_region` VALUES ('815', '152201', '乌兰浩特市', '68', '0', '0', 'Ulan Hot Shi', 'ULO');
INSERT INTO `t_region` VALUES ('816', '152202', '阿尔山市', '68', '0', '0', 'Arxan Shi', 'ARS');
INSERT INTO `t_region` VALUES ('817', '152221', '科尔沁右翼前旗', '68', '0', '0', 'Horqin Youyi Qianqi', 'HYQ');
INSERT INTO `t_region` VALUES ('818', '152222', '科尔沁右翼中旗', '68', '0', '0', 'Horqin Youyi Zhongqi', 'HYZ');
INSERT INTO `t_region` VALUES ('819', '152223', '扎赉特旗', '68', '0', '0', 'Jalaid Qi', 'JAL');
INSERT INTO `t_region` VALUES ('820', '152224', '突泉县', '68', '0', '0', 'Tuquan Xian', 'TUQ');
INSERT INTO `t_region` VALUES ('821', '152501', '二连浩特市', '69', '0', '0', 'Erenhot Shi', 'ERC');
INSERT INTO `t_region` VALUES ('822', '152502', '锡林浩特市', '69', '0', '0', 'Xilinhot Shi', 'XLI');
INSERT INTO `t_region` VALUES ('823', '152522', '阿巴嘎旗', '69', '0', '0', 'Abag Qi', 'ABG');
INSERT INTO `t_region` VALUES ('824', '152523', '苏尼特左旗', '69', '0', '0', 'Sonid Zuoqi', 'SOZ');
INSERT INTO `t_region` VALUES ('825', '152524', '苏尼特右旗', '69', '0', '0', 'Sonid Youqi', 'SOY');
INSERT INTO `t_region` VALUES ('826', '152525', '东乌珠穆沁旗', '69', '0', '0', 'Dong Ujimqin Qi', 'DUJ');
INSERT INTO `t_region` VALUES ('827', '152526', '西乌珠穆沁旗', '69', '0', '0', 'Xi Ujimqin Qi', 'XUJ');
INSERT INTO `t_region` VALUES ('828', '152527', '太仆寺旗', '69', '0', '0', 'Taibus Qi', 'TAB');
INSERT INTO `t_region` VALUES ('829', '152528', '镶黄旗', '69', '0', '0', 'Xianghuang(Hobot Xar) Qi', 'XHG');
INSERT INTO `t_region` VALUES ('830', '152529', '正镶白旗', '69', '0', '0', 'Zhengxiangbai(Xulun Hobot Qagan)Qi', 'ZXB');
INSERT INTO `t_region` VALUES ('831', '152530', '正蓝旗', '69', '0', '0', 'Zhenglan(Xulun Hoh)Qi', 'ZLM');
INSERT INTO `t_region` VALUES ('832', '152531', '多伦县', '69', '0', '0', 'Duolun (Dolonnur)Xian', 'DLM');
INSERT INTO `t_region` VALUES ('833', '152921', '阿拉善左旗', '70', '0', '0', 'Alxa Zuoqi', 'ALZ');
INSERT INTO `t_region` VALUES ('834', '152922', '阿拉善右旗', '70', '0', '0', 'Alxa Youqi', 'ALY');
INSERT INTO `t_region` VALUES ('835', '152923', '额济纳旗', '70', '0', '0', 'Ejin Qi', 'EJI');
INSERT INTO `t_region` VALUES ('836', '210101', '市辖区', '71', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('837', '210102', '和平区', '71', '0', '0', 'Heping Qu', 'HEP');
INSERT INTO `t_region` VALUES ('838', '210103', '沈河区', '71', '0', '0', 'Shenhe Qu ', 'SHQ');
INSERT INTO `t_region` VALUES ('839', '210104', '大东区', '71', '0', '0', 'Dadong Qu ', 'DDQ');
INSERT INTO `t_region` VALUES ('840', '210105', '皇姑区', '71', '0', '0', 'Huanggu Qu', 'HGU');
INSERT INTO `t_region` VALUES ('841', '210106', '铁西区', '71', '0', '0', 'Tiexi Qu', 'TXI');
INSERT INTO `t_region` VALUES ('842', '210111', '苏家屯区', '71', '0', '0', 'Sujiatun Qu', 'SJT');
INSERT INTO `t_region` VALUES ('843', '210112', '东陵区', '71', '0', '0', 'Dongling Qu ', 'DLQ');
INSERT INTO `t_region` VALUES ('844', '210113', '沈北新区', '71', '0', '0', 'Xinchengzi Qu', '2');
INSERT INTO `t_region` VALUES ('845', '210114', '于洪区', '71', '0', '0', 'Yuhong Qu ', 'YHQ');
INSERT INTO `t_region` VALUES ('846', '210122', '辽中县', '71', '0', '0', 'Liaozhong Xian', 'LZL');
INSERT INTO `t_region` VALUES ('847', '210123', '康平县', '71', '0', '0', 'Kangping Xian', 'KPG');
INSERT INTO `t_region` VALUES ('848', '210124', '法库县', '71', '0', '0', 'Faku Xian', 'FKU');
INSERT INTO `t_region` VALUES ('849', '210181', '新民市', '71', '0', '0', 'Xinmin Shi', 'XMS');
INSERT INTO `t_region` VALUES ('850', '210201', '市辖区', '72', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('851', '210202', '中山区', '72', '0', '0', 'Zhongshan Qu', 'ZSD');
INSERT INTO `t_region` VALUES ('852', '210203', '西岗区', '72', '0', '0', 'Xigang Qu', 'XGD');
INSERT INTO `t_region` VALUES ('853', '210204', '沙河口区', '72', '0', '0', 'Shahekou Qu', 'SHK');
INSERT INTO `t_region` VALUES ('854', '210211', '甘井子区', '72', '0', '0', 'Ganjingzi Qu', 'GJZ');
INSERT INTO `t_region` VALUES ('855', '210212', '旅顺口区', '72', '0', '0', 'Lvshunkou Qu ', 'LSK');
INSERT INTO `t_region` VALUES ('856', '210213', '金州区', '72', '0', '0', 'Jinzhou Qu', 'JZH');
INSERT INTO `t_region` VALUES ('857', '210224', '长海县', '72', '0', '0', 'Changhai Xian', 'CHX');
INSERT INTO `t_region` VALUES ('858', '210281', '瓦房店市', '72', '0', '0', 'Wafangdian Shi', 'WFD');
INSERT INTO `t_region` VALUES ('859', '210282', '普兰店市', '72', '0', '0', 'Pulandian Shi', 'PLD');
INSERT INTO `t_region` VALUES ('860', '210283', '庄河市', '72', '0', '0', 'Zhuanghe Shi', 'ZHH');
INSERT INTO `t_region` VALUES ('861', '210301', '市辖区', '73', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('862', '210302', '铁东区', '73', '0', '0', 'Tiedong Qu ', 'TED');
INSERT INTO `t_region` VALUES ('863', '210303', '铁西区', '73', '0', '0', 'Tiexi Qu', 'TXL');
INSERT INTO `t_region` VALUES ('864', '210304', '立山区', '73', '0', '0', 'Lishan Qu', 'LAS');
INSERT INTO `t_region` VALUES ('865', '210311', '千山区', '73', '0', '0', 'Qianshan Qu ', 'QSQ');
INSERT INTO `t_region` VALUES ('866', '210321', '台安县', '73', '0', '0', 'Tai,an Xian', 'TAX');
INSERT INTO `t_region` VALUES ('867', '210323', '岫岩满族自治县', '73', '0', '0', 'Xiuyan Manzu Zizhixian', 'XYL');
INSERT INTO `t_region` VALUES ('868', '210381', '海城市', '73', '0', '0', 'Haicheng Shi', 'HCL');
INSERT INTO `t_region` VALUES ('869', '210401', '市辖区', '74', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('870', '210402', '新抚区', '74', '0', '0', 'Xinfu Qu', 'XFU');
INSERT INTO `t_region` VALUES ('871', '210403', '东洲区', '74', '0', '0', 'Dongzhou Qu', '2');
INSERT INTO `t_region` VALUES ('872', '210404', '望花区', '74', '0', '0', 'Wanghua Qu', 'WHF');
INSERT INTO `t_region` VALUES ('873', '210411', '顺城区', '74', '0', '0', 'Shuncheng Qu', 'SCF');
INSERT INTO `t_region` VALUES ('874', '210421', '抚顺县', '74', '0', '0', 'Fushun Xian', 'FSX');
INSERT INTO `t_region` VALUES ('875', '210422', '新宾满族自治县', '74', '0', '0', 'Xinbinmanzuzizhi Xian', '2');
INSERT INTO `t_region` VALUES ('876', '210423', '清原满族自治县', '74', '0', '0', 'Qingyuanmanzuzizhi Xian', '2');
INSERT INTO `t_region` VALUES ('877', '210501', '市辖区', '75', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('878', '210502', '平山区', '75', '0', '0', 'Pingshan Qu', 'PSN');
INSERT INTO `t_region` VALUES ('879', '210503', '溪湖区', '75', '0', '0', 'Xihu Qu ', 'XHB');
INSERT INTO `t_region` VALUES ('880', '210504', '明山区', '75', '0', '0', 'Mingshan Qu', 'MSB');
INSERT INTO `t_region` VALUES ('881', '210505', '南芬区', '75', '0', '0', 'Nanfen Qu', 'NFQ');
INSERT INTO `t_region` VALUES ('882', '210521', '本溪满族自治县', '75', '0', '0', 'Benxi Manzu Zizhixian', 'BXX');
INSERT INTO `t_region` VALUES ('883', '210522', '桓仁满族自治县', '75', '0', '0', 'Huanren Manzu Zizhixian', 'HRL');
INSERT INTO `t_region` VALUES ('884', '210601', '市辖区', '76', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('885', '210602', '元宝区', '76', '0', '0', 'Yuanbao Qu', 'YBD');
INSERT INTO `t_region` VALUES ('886', '210603', '振兴区', '76', '0', '0', 'Zhenxing Qu ', 'ZXQ');
INSERT INTO `t_region` VALUES ('887', '210604', '振安区', '76', '0', '0', 'Zhen,an Qu', 'ZAQ');
INSERT INTO `t_region` VALUES ('888', '210624', '宽甸满族自治县', '76', '0', '0', 'Kuandian Manzu Zizhixian', 'KDN');
INSERT INTO `t_region` VALUES ('889', '210681', '东港市', '76', '0', '0', 'Donggang Shi', 'DGS');
INSERT INTO `t_region` VALUES ('890', '210682', '凤城市', '76', '0', '0', 'Fengcheng Shi', 'FCL');
INSERT INTO `t_region` VALUES ('891', '210701', '市辖区', '77', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('892', '210702', '古塔区', '77', '0', '0', 'Guta Qu', 'GTQ');
INSERT INTO `t_region` VALUES ('893', '210703', '凌河区', '77', '0', '0', 'Linghe Qu', 'LHF');
INSERT INTO `t_region` VALUES ('894', '210711', '太和区', '77', '0', '0', 'Taihe Qu', '2');
INSERT INTO `t_region` VALUES ('895', '210726', '黑山县', '77', '0', '0', 'Heishan Xian', 'HSL');
INSERT INTO `t_region` VALUES ('896', '210727', '义县', '77', '0', '0', 'Yi Xian', 'YXL');
INSERT INTO `t_region` VALUES ('897', '210781', '凌海市', '77', '0', '0', 'Linghai Shi ', 'LHL');
INSERT INTO `t_region` VALUES ('898', '210782', '北镇市', '77', '0', '0', 'Beining Shi', '2');
INSERT INTO `t_region` VALUES ('899', '210801', '市辖区', '78', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('900', '210802', '站前区', '78', '0', '0', 'Zhanqian Qu', 'ZQQ');
INSERT INTO `t_region` VALUES ('901', '210803', '西市区', '78', '0', '0', 'Xishi Qu', 'XII');
INSERT INTO `t_region` VALUES ('902', '210804', '鲅鱼圈区', '78', '0', '0', 'Bayuquan Qu', 'BYQ');
INSERT INTO `t_region` VALUES ('903', '210811', '老边区', '78', '0', '0', 'Laobian Qu', 'LOB');
INSERT INTO `t_region` VALUES ('904', '210881', '盖州市', '78', '0', '0', 'Gaizhou Shi', 'GZU');
INSERT INTO `t_region` VALUES ('905', '210882', '大石桥市', '78', '0', '0', 'Dashiqiao Shi', 'DSQ');
INSERT INTO `t_region` VALUES ('906', '210901', '市辖区', '79', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('907', '210902', '海州区', '79', '0', '0', 'Haizhou Qu', 'HZF');
INSERT INTO `t_region` VALUES ('908', '210903', '新邱区', '79', '0', '0', 'Xinqiu Qu', 'XQF');
INSERT INTO `t_region` VALUES ('909', '210904', '太平区', '79', '0', '0', 'Taiping Qu', 'TPG');
INSERT INTO `t_region` VALUES ('910', '210905', '清河门区', '79', '0', '0', 'Qinghemen Qu', 'QHM');
INSERT INTO `t_region` VALUES ('911', '210911', '细河区', '79', '0', '0', 'Xihe Qu', 'XHO');
INSERT INTO `t_region` VALUES ('912', '210921', '阜新蒙古族自治县', '79', '0', '0', 'Fuxin Mongolzu Zizhixian', 'FXX');
INSERT INTO `t_region` VALUES ('913', '210922', '彰武县', '79', '0', '0', 'Zhangwu Xian', 'ZWU');
INSERT INTO `t_region` VALUES ('914', '211001', '市辖区', '80', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('915', '211002', '白塔区', '80', '0', '0', 'Baita Qu', 'BTL');
INSERT INTO `t_region` VALUES ('916', '211003', '文圣区', '80', '0', '0', 'Wensheng Qu', 'WST');
INSERT INTO `t_region` VALUES ('917', '211004', '宏伟区', '80', '0', '0', 'Hongwei Qu', 'HWQ');
INSERT INTO `t_region` VALUES ('918', '211005', '弓长岭区', '80', '0', '0', 'Gongchangling Qu', 'GCL');
INSERT INTO `t_region` VALUES ('919', '211011', '太子河区', '80', '0', '0', 'Taizihe Qu', 'TZH');
INSERT INTO `t_region` VALUES ('920', '211021', '辽阳县', '80', '0', '0', 'Liaoyang Xian', 'LYX');
INSERT INTO `t_region` VALUES ('921', '211081', '灯塔市', '80', '0', '0', 'Dengta Shi', 'DTL');
INSERT INTO `t_region` VALUES ('922', '211101', '市辖区', '81', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('923', '211102', '双台子区', '81', '0', '0', 'Shuangtaizi Qu', 'STZ');
INSERT INTO `t_region` VALUES ('924', '211103', '兴隆台区', '81', '0', '0', 'Xinglongtai Qu', 'XLT');
INSERT INTO `t_region` VALUES ('925', '211121', '大洼县', '81', '0', '0', 'Dawa Xian', 'DWA');
INSERT INTO `t_region` VALUES ('926', '211122', '盘山县', '81', '0', '0', 'Panshan Xian', 'PNS');
INSERT INTO `t_region` VALUES ('927', '211201', '市辖区', '82', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('928', '211202', '银州区', '82', '0', '0', 'Yinzhou Qu', 'YZU');
INSERT INTO `t_region` VALUES ('929', '211204', '清河区', '82', '0', '0', 'Qinghe Qu', 'QHQ');
INSERT INTO `t_region` VALUES ('930', '211221', '铁岭县', '82', '0', '0', 'Tieling Xian', 'TLG');
INSERT INTO `t_region` VALUES ('931', '211223', '西丰县', '82', '0', '0', 'Xifeng Xian', 'XIF');
INSERT INTO `t_region` VALUES ('932', '211224', '昌图县', '82', '0', '0', 'Changtu Xian', 'CTX');
INSERT INTO `t_region` VALUES ('933', '211281', '调兵山市', '82', '0', '0', 'Diaobingshan Shi', '2');
INSERT INTO `t_region` VALUES ('934', '211282', '开原市', '82', '0', '0', 'Kaiyuan Shi', 'KYS');
INSERT INTO `t_region` VALUES ('935', '211301', '市辖区', '83', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('936', '211302', '双塔区', '83', '0', '0', 'Shuangta Qu', 'STQ');
INSERT INTO `t_region` VALUES ('937', '211303', '龙城区', '83', '0', '0', 'Longcheng Qu', 'LCL');
INSERT INTO `t_region` VALUES ('938', '211321', '朝阳县', '83', '0', '0', 'Chaoyang Xian', 'CYG');
INSERT INTO `t_region` VALUES ('939', '211322', '建平县', '83', '0', '0', 'Jianping Xian', 'JPG');
INSERT INTO `t_region` VALUES ('940', '211324', '喀喇沁左翼蒙古族自治县', '83', '0', '0', 'Harqin Zuoyi Mongolzu Zizhixian', 'HAZ');
INSERT INTO `t_region` VALUES ('941', '211381', '北票市', '83', '0', '0', 'Beipiao Shi', 'BPO');
INSERT INTO `t_region` VALUES ('942', '211382', '凌源市', '83', '0', '0', 'Lingyuan Shi', 'LYK');
INSERT INTO `t_region` VALUES ('943', '211401', '市辖区', '84', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('944', '211402', '连山区', '84', '0', '0', 'Lianshan Qu', 'LSQ');
INSERT INTO `t_region` VALUES ('945', '211403', '龙港区', '84', '0', '0', 'Longgang Qu', 'LGD');
INSERT INTO `t_region` VALUES ('946', '211404', '南票区', '84', '0', '0', 'Nanpiao Qu', 'NPQ');
INSERT INTO `t_region` VALUES ('947', '211421', '绥中县', '84', '0', '0', 'Suizhong Xian', 'SZL');
INSERT INTO `t_region` VALUES ('948', '211422', '建昌县', '84', '0', '0', 'Jianchang Xian', 'JCL');
INSERT INTO `t_region` VALUES ('949', '211481', '兴城市', '84', '0', '0', 'Xingcheng Shi', 'XCL');
INSERT INTO `t_region` VALUES ('950', '220101', '市辖区', '85', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('951', '220102', '南关区', '85', '0', '0', 'Nanguan Qu', 'NGN');
INSERT INTO `t_region` VALUES ('952', '220103', '宽城区', '85', '0', '0', 'Kuancheng Qu', 'KCQ');
INSERT INTO `t_region` VALUES ('953', '220104', '朝阳区', '85', '0', '0', 'Chaoyang Qu ', 'CYC');
INSERT INTO `t_region` VALUES ('954', '220105', '二道区', '85', '0', '0', 'Erdao Qu', 'EDQ');
INSERT INTO `t_region` VALUES ('955', '220106', '绿园区', '85', '0', '0', 'Lvyuan Qu', 'LYQ');
INSERT INTO `t_region` VALUES ('956', '220112', '双阳区', '85', '0', '0', 'Shuangyang Qu', 'SYQ');
INSERT INTO `t_region` VALUES ('957', '220122', '农安县', '85', '0', '0', 'Nong,an Xian ', 'NAJ');
INSERT INTO `t_region` VALUES ('958', '220181', '九台市', '85', '0', '0', 'Jiutai Shi', '2');
INSERT INTO `t_region` VALUES ('959', '220182', '榆树市', '85', '0', '0', 'Yushu Shi', 'YSS');
INSERT INTO `t_region` VALUES ('960', '220183', '德惠市', '85', '0', '0', 'Dehui Shi', 'DEH');
INSERT INTO `t_region` VALUES ('961', '220201', '市辖区', '86', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('962', '220202', '昌邑区', '86', '0', '0', 'Changyi Qu', 'CYI');
INSERT INTO `t_region` VALUES ('963', '220203', '龙潭区', '86', '0', '0', 'Longtan Qu', 'LTQ');
INSERT INTO `t_region` VALUES ('964', '220204', '船营区', '86', '0', '0', 'Chuanying Qu', 'CYJ');
INSERT INTO `t_region` VALUES ('965', '220211', '丰满区', '86', '0', '0', 'Fengman Qu', 'FMQ');
INSERT INTO `t_region` VALUES ('966', '220221', '永吉县', '86', '0', '0', 'Yongji Xian', 'YOJ');
INSERT INTO `t_region` VALUES ('967', '220281', '蛟河市', '86', '0', '0', 'Jiaohe Shi', 'JHJ');
INSERT INTO `t_region` VALUES ('968', '220282', '桦甸市', '86', '0', '0', 'Huadian Shi', 'HDJ');
INSERT INTO `t_region` VALUES ('969', '220283', '舒兰市', '86', '0', '0', 'Shulan Shi', 'SLN');
INSERT INTO `t_region` VALUES ('970', '220284', '磐石市', '86', '0', '0', 'Panshi Shi', 'PSI');
INSERT INTO `t_region` VALUES ('971', '220301', '市辖区', '87', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('972', '220302', '铁西区', '87', '0', '0', 'Tiexi Qu', 'TXS');
INSERT INTO `t_region` VALUES ('973', '220303', '铁东区', '87', '0', '0', 'Tiedong Qu ', 'TDQ');
INSERT INTO `t_region` VALUES ('974', '220322', '梨树县', '87', '0', '0', 'Lishu Xian', 'LSU');
INSERT INTO `t_region` VALUES ('975', '220323', '伊通满族自治县', '87', '0', '0', 'Yitong Manzu Zizhixian', 'YTO');
INSERT INTO `t_region` VALUES ('976', '220381', '公主岭市', '87', '0', '0', 'Gongzhuling Shi', 'GZL');
INSERT INTO `t_region` VALUES ('977', '220382', '双辽市', '87', '0', '0', 'Shuangliao Shi', 'SLS');
INSERT INTO `t_region` VALUES ('978', '220401', '市辖区', '88', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('979', '220402', '龙山区', '88', '0', '0', 'Longshan Qu', 'LGS');
INSERT INTO `t_region` VALUES ('980', '220403', '西安区', '88', '0', '0', 'Xi,an Qu', 'XAA');
INSERT INTO `t_region` VALUES ('981', '220421', '东丰县', '88', '0', '0', 'Dongfeng Xian', 'DGF');
INSERT INTO `t_region` VALUES ('982', '220422', '东辽县', '88', '0', '0', 'Dongliao Xian ', 'DLX');
INSERT INTO `t_region` VALUES ('983', '220501', '市辖区', '89', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('984', '220502', '东昌区', '89', '0', '0', 'Dongchang Qu', 'DCT');
INSERT INTO `t_region` VALUES ('985', '220503', '二道江区', '89', '0', '0', 'Erdaojiang Qu', 'EDJ');
INSERT INTO `t_region` VALUES ('986', '220521', '通化县', '89', '0', '0', 'Tonghua Xian ', 'THX');
INSERT INTO `t_region` VALUES ('987', '220523', '辉南县', '89', '0', '0', 'Huinan Xian ', 'HNA');
INSERT INTO `t_region` VALUES ('988', '220524', '柳河县', '89', '0', '0', 'Liuhe Xian ', 'LHC');
INSERT INTO `t_region` VALUES ('989', '220581', '梅河口市', '89', '0', '0', 'Meihekou Shi', 'MHK');
INSERT INTO `t_region` VALUES ('990', '220582', '集安市', '89', '0', '0', 'Ji,an Shi', 'KNC');
INSERT INTO `t_region` VALUES ('991', '220601', '市辖区', '90', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('992', '220602', '八道江区', '90', '0', '0', 'Badaojiang Qu', 'BDJ');
INSERT INTO `t_region` VALUES ('993', '220621', '抚松县', '90', '0', '0', 'Fusong Xian', 'FSG');
INSERT INTO `t_region` VALUES ('994', '220622', '靖宇县', '90', '0', '0', 'Jingyu Xian', 'JYJ');
INSERT INTO `t_region` VALUES ('995', '220623', '长白朝鲜族自治县', '90', '0', '0', 'Changbaichaoxianzuzizhi Xian', '2');
INSERT INTO `t_region` VALUES ('996', '220605', '江源区', '90', '0', '0', 'Jiangyuan Xian', '2');
INSERT INTO `t_region` VALUES ('997', '220681', '临江市', '90', '0', '0', 'Linjiang Shi', 'LIN');
INSERT INTO `t_region` VALUES ('998', '220701', '市辖区', '91', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('999', '220702', '宁江区', '91', '0', '0', 'Ningjiang Qu', 'NJA');
INSERT INTO `t_region` VALUES ('1000', '220721', '前郭尔罗斯蒙古族自治县', '91', '0', '0', 'Qian Gorlos Mongolzu Zizhixian', 'QGO');
INSERT INTO `t_region` VALUES ('1001', '220722', '长岭县', '91', '0', '0', 'Changling Xian', 'CLG');
INSERT INTO `t_region` VALUES ('1002', '220723', '乾安县', '91', '0', '0', 'Qian,an Xian', 'QAJ');
INSERT INTO `t_region` VALUES ('1003', '220724', '扶余县', '91', '0', '0', 'Fuyu Xian', 'FYU');
INSERT INTO `t_region` VALUES ('1004', '220801', '市辖区', '92', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1005', '220802', '洮北区', '92', '0', '0', 'Taobei Qu', 'TBQ');
INSERT INTO `t_region` VALUES ('1006', '220821', '镇赉县', '92', '0', '0', 'Zhenlai Xian', 'ZLA');
INSERT INTO `t_region` VALUES ('1007', '220822', '通榆县', '92', '0', '0', 'Tongyu Xian', 'TGY');
INSERT INTO `t_region` VALUES ('1008', '220881', '洮南市', '92', '0', '0', 'Taonan Shi', 'TNS');
INSERT INTO `t_region` VALUES ('1009', '220882', '大安市', '92', '0', '0', 'Da,an Shi', 'DNA');
INSERT INTO `t_region` VALUES ('1010', '222401', '延吉市', '93', '0', '0', 'Yanji Shi', 'YNJ');
INSERT INTO `t_region` VALUES ('1011', '222402', '图们市', '93', '0', '0', 'Tumen Shi', 'TME');
INSERT INTO `t_region` VALUES ('1012', '222403', '敦化市', '93', '0', '0', 'Dunhua Shi', 'DHS');
INSERT INTO `t_region` VALUES ('1013', '222404', '珲春市', '93', '0', '0', 'Hunchun Shi', 'HUC');
INSERT INTO `t_region` VALUES ('1014', '222405', '龙井市', '93', '0', '0', 'Longjing Shi', 'LJJ');
INSERT INTO `t_region` VALUES ('1015', '222406', '和龙市', '93', '0', '0', 'Helong Shi', 'HEL');
INSERT INTO `t_region` VALUES ('1016', '222424', '汪清县', '93', '0', '0', 'Wangqing Xian', 'WGQ');
INSERT INTO `t_region` VALUES ('1017', '222426', '安图县', '93', '0', '0', 'Antu Xian', 'ATU');
INSERT INTO `t_region` VALUES ('1018', '230101', '市辖区', '94', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1019', '230102', '道里区', '94', '0', '0', 'Daoli Qu', 'DLH');
INSERT INTO `t_region` VALUES ('1020', '230103', '南岗区', '94', '0', '0', 'Nangang Qu', 'NGQ');
INSERT INTO `t_region` VALUES ('1021', '230104', '道外区', '94', '0', '0', 'Daowai Qu', 'DWQ');
INSERT INTO `t_region` VALUES ('1022', '230110', '香坊区', '94', '0', '0', 'Xiangfang Qu', '2');
INSERT INTO `t_region` VALUES ('1024', '230108', '平房区', '94', '0', '0', 'Pingfang Qu', 'PFQ');
INSERT INTO `t_region` VALUES ('1025', '230109', '松北区', '94', '0', '0', 'Songbei Qu', '2');
INSERT INTO `t_region` VALUES ('1026', '230111', '呼兰区', '94', '0', '0', 'Hulan Qu', '2');
INSERT INTO `t_region` VALUES ('1027', '230123', '依兰县', '94', '0', '0', 'Yilan Xian', 'YLH');
INSERT INTO `t_region` VALUES ('1028', '230124', '方正县', '94', '0', '0', 'Fangzheng Xian', 'FZH');
INSERT INTO `t_region` VALUES ('1029', '230125', '宾县', '94', '0', '0', 'Bin Xian', 'BNX');
INSERT INTO `t_region` VALUES ('1030', '230126', '巴彦县', '94', '0', '0', 'Bayan Xian', 'BYH');
INSERT INTO `t_region` VALUES ('1031', '230127', '木兰县', '94', '0', '0', 'Mulan Xian ', 'MUL');
INSERT INTO `t_region` VALUES ('1032', '230128', '通河县', '94', '0', '0', 'Tonghe Xian', 'TOH');
INSERT INTO `t_region` VALUES ('1033', '230129', '延寿县', '94', '0', '0', 'Yanshou Xian', 'YSU');
INSERT INTO `t_region` VALUES ('1034', '230112', '阿城区', '94', '0', '0', 'Acheng Shi', '2');
INSERT INTO `t_region` VALUES ('1035', '230182', '双城市', '94', '0', '0', 'Shuangcheng Shi', 'SCS');
INSERT INTO `t_region` VALUES ('1036', '230183', '尚志市', '94', '0', '0', 'Shangzhi Shi', 'SZI');
INSERT INTO `t_region` VALUES ('1037', '230184', '五常市', '94', '0', '0', 'Wuchang Shi', 'WCA');
INSERT INTO `t_region` VALUES ('1038', '230201', '市辖区', '95', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1039', '230202', '龙沙区', '95', '0', '0', 'Longsha Qu', 'LQQ');
INSERT INTO `t_region` VALUES ('1040', '230203', '建华区', '95', '0', '0', 'Jianhua Qu', 'JHQ');
INSERT INTO `t_region` VALUES ('1041', '230204', '铁锋区', '95', '0', '0', 'Tiefeng Qu', '2');
INSERT INTO `t_region` VALUES ('1042', '230205', '昂昂溪区', '95', '0', '0', 'Ang,angxi Qu', 'AAX');
INSERT INTO `t_region` VALUES ('1043', '230206', '富拉尔基区', '95', '0', '0', 'Hulan Ergi Qu', 'HUE');
INSERT INTO `t_region` VALUES ('1044', '230207', '碾子山区', '95', '0', '0', 'Nianzishan Qu', 'NZS');
INSERT INTO `t_region` VALUES ('1045', '230208', '梅里斯达斡尔族区', '95', '0', '0', 'Meilisidawoerzu Qu', '2');
INSERT INTO `t_region` VALUES ('1046', '230221', '龙江县', '95', '0', '0', 'Longjiang Xian', 'LGJ');
INSERT INTO `t_region` VALUES ('1047', '230223', '依安县', '95', '0', '0', 'Yi,an Xian', 'YAN');
INSERT INTO `t_region` VALUES ('1048', '230224', '泰来县', '95', '0', '0', 'Tailai Xian', 'TLA');
INSERT INTO `t_region` VALUES ('1049', '230225', '甘南县', '95', '0', '0', 'Gannan Xian', 'GNX');
INSERT INTO `t_region` VALUES ('1050', '230227', '富裕县', '95', '0', '0', 'Fuyu Xian', 'FYX');
INSERT INTO `t_region` VALUES ('1051', '230229', '克山县', '95', '0', '0', 'Keshan Xian', 'KSN');
INSERT INTO `t_region` VALUES ('1052', '230230', '克东县', '95', '0', '0', 'Kedong Xian', 'KDO');
INSERT INTO `t_region` VALUES ('1053', '230231', '拜泉县', '95', '0', '0', 'Baiquan Xian', 'BQN');
INSERT INTO `t_region` VALUES ('1054', '230281', '讷河市', '95', '0', '0', 'Nehe Shi', 'NEH');
INSERT INTO `t_region` VALUES ('1055', '230301', '市辖区', '96', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1056', '230302', '鸡冠区', '96', '0', '0', 'Jiguan Qu', 'JGU');
INSERT INTO `t_region` VALUES ('1057', '230303', '恒山区', '96', '0', '0', 'Hengshan Qu', 'HSD');
INSERT INTO `t_region` VALUES ('1058', '230304', '滴道区', '96', '0', '0', 'Didao Qu', 'DDO');
INSERT INTO `t_region` VALUES ('1059', '230305', '梨树区', '96', '0', '0', 'Lishu Qu', 'LJX');
INSERT INTO `t_region` VALUES ('1060', '230306', '城子河区', '96', '0', '0', 'Chengzihe Qu', 'CZH');
INSERT INTO `t_region` VALUES ('1061', '230307', '麻山区', '96', '0', '0', 'Mashan Qu', 'MSN');
INSERT INTO `t_region` VALUES ('1062', '230321', '鸡东县', '96', '0', '0', 'Jidong Xian', 'JID');
INSERT INTO `t_region` VALUES ('1063', '230381', '虎林市', '96', '0', '0', 'Hulin Shi', 'HUL');
INSERT INTO `t_region` VALUES ('1064', '230382', '密山市', '96', '0', '0', 'Mishan Shi', 'MIS');
INSERT INTO `t_region` VALUES ('1065', '230401', '市辖区', '97', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1066', '230402', '向阳区', '97', '0', '0', 'Xiangyang  Qu ', 'XYZ');
INSERT INTO `t_region` VALUES ('1067', '230403', '工农区', '97', '0', '0', 'Gongnong Qu', 'GNH');
INSERT INTO `t_region` VALUES ('1068', '230404', '南山区', '97', '0', '0', 'Nanshan Qu', 'NSQ');
INSERT INTO `t_region` VALUES ('1069', '230405', '兴安区', '97', '0', '0', 'Xing,an Qu', 'XAH');
INSERT INTO `t_region` VALUES ('1070', '230406', '东山区', '97', '0', '0', 'Dongshan Qu', 'DSA');
INSERT INTO `t_region` VALUES ('1071', '230407', '兴山区', '97', '0', '0', 'Xingshan Qu', 'XSQ');
INSERT INTO `t_region` VALUES ('1072', '230421', '萝北县', '97', '0', '0', 'Luobei Xian', 'LUB');
INSERT INTO `t_region` VALUES ('1073', '230422', '绥滨县', '97', '0', '0', 'Suibin Xian', '2');
INSERT INTO `t_region` VALUES ('1074', '230501', '市辖区', '98', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1075', '230502', '尖山区', '98', '0', '0', 'Jianshan Qu', 'JSQ');
INSERT INTO `t_region` VALUES ('1076', '230503', '岭东区', '98', '0', '0', 'Lingdong Qu', 'LDQ');
INSERT INTO `t_region` VALUES ('1077', '230505', '四方台区', '98', '0', '0', 'Sifangtai Qu', 'SFT');
INSERT INTO `t_region` VALUES ('1078', '230506', '宝山区', '98', '0', '0', 'Baoshan Qu', 'BSQ');
INSERT INTO `t_region` VALUES ('1079', '230521', '集贤县', '98', '0', '0', 'Jixian Xian', 'JXH');
INSERT INTO `t_region` VALUES ('1080', '230522', '友谊县', '98', '0', '0', 'Youyi Xian', 'YYI');
INSERT INTO `t_region` VALUES ('1081', '230523', '宝清县', '98', '0', '0', 'Baoqing Xian', 'BQG');
INSERT INTO `t_region` VALUES ('1082', '230524', '饶河县', '98', '0', '0', 'Raohe Xian ', 'ROH');
INSERT INTO `t_region` VALUES ('1083', '230601', '市辖区', '99', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1084', '230602', '萨尔图区', '99', '0', '0', 'Sairt Qu', 'SAI');
INSERT INTO `t_region` VALUES ('1085', '230603', '龙凤区', '99', '0', '0', 'Longfeng Qu', 'LFQ');
INSERT INTO `t_region` VALUES ('1086', '230604', '让胡路区', '99', '0', '0', 'Ranghulu Qu', 'RHL');
INSERT INTO `t_region` VALUES ('1087', '230605', '红岗区', '99', '0', '0', 'Honggang Qu', 'HGD');
INSERT INTO `t_region` VALUES ('1088', '230606', '大同区', '99', '0', '0', 'Datong Qu', 'DHD');
INSERT INTO `t_region` VALUES ('1089', '230621', '肇州县', '99', '0', '0', 'Zhaozhou Xian', 'ZAZ');
INSERT INTO `t_region` VALUES ('1090', '230622', '肇源县', '99', '0', '0', 'Zhaoyuan Xian', 'ZYH');
INSERT INTO `t_region` VALUES ('1091', '230623', '林甸县', '99', '0', '0', 'Lindian Xian ', 'LDN');
INSERT INTO `t_region` VALUES ('1092', '230624', '杜尔伯特蒙古族自治县', '99', '0', '0', 'Dorbod Mongolzu Zizhixian', 'DOM');
INSERT INTO `t_region` VALUES ('1093', '230701', '市辖区', '100', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1094', '230702', '伊春区', '100', '0', '0', 'Yichun Qu', 'YYC');
INSERT INTO `t_region` VALUES ('1095', '230703', '南岔区', '100', '0', '0', 'Nancha Qu', 'NCQ');
INSERT INTO `t_region` VALUES ('1096', '230704', '友好区', '100', '0', '0', 'Youhao Qu', 'YOH');
INSERT INTO `t_region` VALUES ('1097', '230705', '西林区', '100', '0', '0', 'Xilin Qu', 'XIL');
INSERT INTO `t_region` VALUES ('1098', '230706', '翠峦区', '100', '0', '0', 'Cuiluan Qu', 'CLN');
INSERT INTO `t_region` VALUES ('1099', '230707', '新青区', '100', '0', '0', 'Xinqing Qu', 'XQQ');
INSERT INTO `t_region` VALUES ('1100', '230708', '美溪区', '100', '0', '0', 'Meixi Qu', 'MXQ');
INSERT INTO `t_region` VALUES ('1101', '230709', '金山屯区', '100', '0', '0', 'Jinshantun Qu', 'JST');
INSERT INTO `t_region` VALUES ('1102', '230710', '五营区', '100', '0', '0', 'Wuying Qu', 'WYQ');
INSERT INTO `t_region` VALUES ('1103', '230711', '乌马河区', '100', '0', '0', 'Wumahe Qu', 'WMH');
INSERT INTO `t_region` VALUES ('1104', '230712', '汤旺河区', '100', '0', '0', 'Tangwanghe Qu', 'TWH');
INSERT INTO `t_region` VALUES ('1105', '230713', '带岭区', '100', '0', '0', 'Dailing Qu', 'DLY');
INSERT INTO `t_region` VALUES ('1106', '230714', '乌伊岭区', '100', '0', '0', 'Wuyiling Qu', 'WYL');
INSERT INTO `t_region` VALUES ('1107', '230715', '红星区', '100', '0', '0', 'Hongxing Qu', 'HGX');
INSERT INTO `t_region` VALUES ('1108', '230716', '上甘岭区', '100', '0', '0', 'Shangganling Qu', 'SGL');
INSERT INTO `t_region` VALUES ('1109', '230722', '嘉荫县', '100', '0', '0', 'Jiayin Xian', '2');
INSERT INTO `t_region` VALUES ('1110', '230781', '铁力市', '100', '0', '0', 'Tieli Shi', 'TEL');
INSERT INTO `t_region` VALUES ('1111', '230801', '市辖区', '101', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1113', '230803', '向阳区', '101', '0', '0', 'Xiangyang  Qu ', 'XYQ');
INSERT INTO `t_region` VALUES ('1114', '230804', '前进区', '101', '0', '0', 'Qianjin Qu', 'QJQ');
INSERT INTO `t_region` VALUES ('1115', '230805', '东风区', '101', '0', '0', 'Dongfeng Qu', 'DFQ');
INSERT INTO `t_region` VALUES ('1116', '230811', '郊区', '101', '0', '0', 'Jiaoqu', 'JQJ');
INSERT INTO `t_region` VALUES ('1117', '230822', '桦南县', '101', '0', '0', 'Huanan Xian', 'HNH');
INSERT INTO `t_region` VALUES ('1118', '230826', '桦川县', '101', '0', '0', 'Huachuan Xian', 'HCN');
INSERT INTO `t_region` VALUES ('1119', '230828', '汤原县', '101', '0', '0', 'Tangyuan Xian', 'TYX');
INSERT INTO `t_region` VALUES ('1120', '230833', '抚远县', '101', '0', '0', 'Fuyuan Xian', 'FUY');
INSERT INTO `t_region` VALUES ('1121', '230881', '同江市', '101', '0', '0', 'Tongjiang Shi', 'TOJ');
INSERT INTO `t_region` VALUES ('1122', '230882', '富锦市', '101', '0', '0', 'Fujin Shi', 'FUJ');
INSERT INTO `t_region` VALUES ('1123', '230901', '市辖区', '102', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1124', '230902', '新兴区', '102', '0', '0', 'Xinxing Qu', 'XXQ');
INSERT INTO `t_region` VALUES ('1125', '230903', '桃山区', '102', '0', '0', 'Taoshan Qu', 'TSC');
INSERT INTO `t_region` VALUES ('1126', '230904', '茄子河区', '102', '0', '0', 'Qiezihe Qu', 'QZI');
INSERT INTO `t_region` VALUES ('1127', '230921', '勃利县', '102', '0', '0', 'Boli Xian', 'BLI');
INSERT INTO `t_region` VALUES ('1128', '231001', '市辖区', '103', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1129', '231002', '东安区', '103', '0', '0', 'Dong,an Qu', 'DGA');
INSERT INTO `t_region` VALUES ('1130', '231003', '阳明区', '103', '0', '0', 'Yangming Qu', 'YMQ');
INSERT INTO `t_region` VALUES ('1131', '231004', '爱民区', '103', '0', '0', 'Aimin Qu', 'AMQ');
INSERT INTO `t_region` VALUES ('1132', '231005', '西安区', '103', '0', '0', 'Xi,an Qu', 'XAQ');
INSERT INTO `t_region` VALUES ('1133', '231024', '东宁县', '103', '0', '0', 'Dongning Xian', 'DON');
INSERT INTO `t_region` VALUES ('1134', '231025', '林口县', '103', '0', '0', 'Linkou Xian', 'LKO');
INSERT INTO `t_region` VALUES ('1135', '231081', '绥芬河市', '103', '0', '0', 'Suifenhe Shi', 'SFE');
INSERT INTO `t_region` VALUES ('1136', '231083', '海林市', '103', '0', '0', 'Hailin Shi', 'HLS');
INSERT INTO `t_region` VALUES ('1137', '231084', '宁安市', '103', '0', '0', 'Ning,an Shi', 'NAI');
INSERT INTO `t_region` VALUES ('1138', '231085', '穆棱市', '103', '0', '0', 'Muling Shi', 'MLG');
INSERT INTO `t_region` VALUES ('1139', '231101', '市辖区', '104', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1140', '231102', '爱辉区', '104', '0', '0', 'Aihui Qu', 'AHQ');
INSERT INTO `t_region` VALUES ('1141', '231121', '嫩江县', '104', '0', '0', 'Nenjiang Xian', 'NJH');
INSERT INTO `t_region` VALUES ('1142', '231123', '逊克县', '104', '0', '0', 'Xunke Xian', 'XUK');
INSERT INTO `t_region` VALUES ('1143', '231124', '孙吴县', '104', '0', '0', 'Sunwu Xian', 'SUW');
INSERT INTO `t_region` VALUES ('1144', '231181', '北安市', '104', '0', '0', 'Bei,an Shi', 'BAS');
INSERT INTO `t_region` VALUES ('1145', '231182', '五大连池市', '104', '0', '0', 'Wudalianchi Shi', 'WDL');
INSERT INTO `t_region` VALUES ('1146', '231201', '市辖区', '105', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('1147', '231202', '北林区', '105', '0', '0', 'Beilin Qu', '2');
INSERT INTO `t_region` VALUES ('1148', '231221', '望奎县', '105', '0', '0', 'Wangkui Xian', '2');
INSERT INTO `t_region` VALUES ('1149', '231222', '兰西县', '105', '0', '0', 'Lanxi Xian', '2');
INSERT INTO `t_region` VALUES ('1150', '231223', '青冈县', '105', '0', '0', 'Qinggang Xian', '2');
INSERT INTO `t_region` VALUES ('1151', '231224', '庆安县', '105', '0', '0', 'Qing,an Xian', '2');
INSERT INTO `t_region` VALUES ('1152', '231225', '明水县', '105', '0', '0', 'Mingshui Xian', '2');
INSERT INTO `t_region` VALUES ('1153', '231226', '绥棱县', '105', '0', '0', 'Suileng Xian', '2');
INSERT INTO `t_region` VALUES ('1154', '231281', '安达市', '105', '0', '0', 'Anda Shi', '2');
INSERT INTO `t_region` VALUES ('1155', '231282', '肇东市', '105', '0', '0', 'Zhaodong Shi', '2');
INSERT INTO `t_region` VALUES ('1156', '231283', '海伦市', '105', '0', '0', 'Hailun Shi', '2');
INSERT INTO `t_region` VALUES ('1157', '232721', '呼玛县', '106', '0', '0', 'Huma Xian', 'HUM');
INSERT INTO `t_region` VALUES ('1158', '232722', '塔河县', '106', '0', '0', 'Tahe Xian', 'TAH');
INSERT INTO `t_region` VALUES ('1159', '232723', '漠河县', '106', '0', '0', 'Mohe Xian', 'MOH');
INSERT INTO `t_region` VALUES ('1160', '310101', '黄浦区', '107', '0', '0', 'Huangpu Qu', 'HGP');
INSERT INTO `t_region` VALUES ('1161', '310103', '卢湾区', '107', '0', '0', 'Luwan Qu', 'LWN');
INSERT INTO `t_region` VALUES ('1162', '310104', '徐汇区', '107', '0', '0', 'Xuhui Qu', 'XHI');
INSERT INTO `t_region` VALUES ('1163', '310105', '长宁区', '107', '0', '0', 'Changning Qu', 'CNQ');
INSERT INTO `t_region` VALUES ('1164', '310106', '静安区', '107', '0', '0', 'Jing,an Qu', 'JAQ');
INSERT INTO `t_region` VALUES ('1165', '310107', '普陀区', '107', '0', '0', 'Putuo Qu', 'PTQ');
INSERT INTO `t_region` VALUES ('1166', '310108', '闸北区', '107', '0', '0', 'Zhabei Qu', 'ZBE');
INSERT INTO `t_region` VALUES ('1167', '310109', '虹口区', '107', '0', '0', 'Hongkou Qu', 'HKQ');
INSERT INTO `t_region` VALUES ('1168', '310110', '杨浦区', '107', '0', '0', 'Yangpu Qu', 'YPU');
INSERT INTO `t_region` VALUES ('1169', '310112', '闵行区', '107', '0', '0', 'Minhang Qu', 'MHQ');
INSERT INTO `t_region` VALUES ('1170', '310113', '宝山区', '107', '0', '0', 'Baoshan Qu', 'BAO');
INSERT INTO `t_region` VALUES ('1171', '310114', '嘉定区', '107', '0', '0', 'Jiading Qu', 'JDG');
INSERT INTO `t_region` VALUES ('1172', '310115', '浦东新区', '107', '0', '0', 'Pudong Xinqu', 'PDX');
INSERT INTO `t_region` VALUES ('1173', '310116', '金山区', '107', '0', '0', 'Jinshan Qu', 'JSH');
INSERT INTO `t_region` VALUES ('1174', '310117', '松江区', '107', '0', '0', 'Songjiang Qu', 'SOJ');
INSERT INTO `t_region` VALUES ('1175', '310118', '青浦区', '107', '0', '0', 'Qingpu  Qu', 'QPU');
INSERT INTO `t_region` VALUES ('1177', '310120', '奉贤区', '107', '0', '0', 'Fengxian Qu', 'FXI');
INSERT INTO `t_region` VALUES ('1178', '310230', '崇明县', '108', '0', '0', 'Chongming Xian', 'CMI');
INSERT INTO `t_region` VALUES ('1179', '320101', '市辖区', '109', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1180', '320102', '玄武区', '109', '0', '0', 'Xuanwu Qu', 'XWU');
INSERT INTO `t_region` VALUES ('1181', '320103', '白下区', '109', '0', '0', 'Baixia Qu', 'BXQ');
INSERT INTO `t_region` VALUES ('1182', '320104', '秦淮区', '109', '0', '0', 'Qinhuai Qu', 'QHU');
INSERT INTO `t_region` VALUES ('1183', '320105', '建邺区', '109', '0', '0', 'Jianye Qu', 'JYQ');
INSERT INTO `t_region` VALUES ('1184', '320106', '鼓楼区', '109', '0', '0', 'Gulou Qu', 'GLQ');
INSERT INTO `t_region` VALUES ('1185', '320107', '下关区', '109', '0', '0', 'Xiaguan Qu', 'XGQ');
INSERT INTO `t_region` VALUES ('1186', '320111', '浦口区', '109', '0', '0', 'Pukou Qu', 'PKO');
INSERT INTO `t_region` VALUES ('1187', '320113', '栖霞区', '109', '0', '0', 'Qixia Qu', 'QAX');
INSERT INTO `t_region` VALUES ('1188', '320114', '雨花台区', '109', '0', '0', 'Yuhuatai Qu', 'YHT');
INSERT INTO `t_region` VALUES ('1189', '320115', '江宁区', '109', '0', '0', 'Jiangning Qu', '2');
INSERT INTO `t_region` VALUES ('1190', '320116', '六合区', '109', '0', '0', 'Liuhe Qu', '2');
INSERT INTO `t_region` VALUES ('1191', '320124', '溧水县', '109', '0', '0', 'Lishui Xian', 'LIS');
INSERT INTO `t_region` VALUES ('1192', '320125', '高淳县', '109', '0', '0', 'Gaochun Xian', 'GCN');
INSERT INTO `t_region` VALUES ('1193', '320201', '市辖区', '110', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1194', '320202', '崇安区', '110', '0', '0', 'Chong,an Qu', 'CGA');
INSERT INTO `t_region` VALUES ('1195', '320203', '南长区', '110', '0', '0', 'Nanchang Qu', 'NCG');
INSERT INTO `t_region` VALUES ('1196', '320204', '北塘区', '110', '0', '0', 'Beitang Qu', 'BTQ');
INSERT INTO `t_region` VALUES ('1197', '320205', '锡山区', '110', '0', '0', 'Xishan Qu', '2');
INSERT INTO `t_region` VALUES ('1198', '320206', '惠山区', '110', '0', '0', 'Huishan Qu', '2');
INSERT INTO `t_region` VALUES ('1199', '320211', '滨湖区', '110', '0', '0', 'Binhu Qu', '2');
INSERT INTO `t_region` VALUES ('1200', '320281', '江阴市', '110', '0', '0', 'Jiangyin Shi', 'JIA');
INSERT INTO `t_region` VALUES ('1201', '320282', '宜兴市', '110', '0', '0', 'Yixing Shi', 'YIX');
INSERT INTO `t_region` VALUES ('1202', '320301', '市辖区', '111', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1203', '320302', '鼓楼区', '111', '0', '0', 'Gulou Qu', 'GLU');
INSERT INTO `t_region` VALUES ('1204', '320303', '云龙区', '111', '0', '0', 'Yunlong Qu', 'YLF');
INSERT INTO `t_region` VALUES ('1206', '320305', '贾汪区', '111', '0', '0', 'Jiawang Qu', 'JWQ');
INSERT INTO `t_region` VALUES ('1207', '320311', '泉山区', '111', '0', '0', 'Quanshan Qu', 'QSX');
INSERT INTO `t_region` VALUES ('1208', '320321', '丰县', '111', '0', '0', 'Feng Xian', 'FXN');
INSERT INTO `t_region` VALUES ('1209', '320322', '沛县', '111', '0', '0', 'Pei Xian', 'PEI');
INSERT INTO `t_region` VALUES ('1210', '320312', '铜山区', '111', '0', '0', 'Tongshan Xian', '2');
INSERT INTO `t_region` VALUES ('1211', '320324', '睢宁县', '111', '0', '0', 'Suining Xian', 'SNI');
INSERT INTO `t_region` VALUES ('1212', '320381', '新沂市', '111', '0', '0', 'Xinyi Shi', 'XYW');
INSERT INTO `t_region` VALUES ('1213', '320382', '邳州市', '111', '0', '0', 'Pizhou Shi', 'PZO');
INSERT INTO `t_region` VALUES ('1214', '320401', '市辖区', '112', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1215', '320402', '天宁区', '112', '0', '0', 'Tianning Qu', 'TNQ');
INSERT INTO `t_region` VALUES ('1216', '320404', '钟楼区', '112', '0', '0', 'Zhonglou Qu', 'ZLQ');
INSERT INTO `t_region` VALUES ('1217', '320405', '戚墅堰区', '112', '0', '0', 'Qishuyan Qu', 'QSY');
INSERT INTO `t_region` VALUES ('1218', '320411', '新北区', '112', '0', '0', 'Xinbei Qu', '2');
INSERT INTO `t_region` VALUES ('1219', '320412', '武进区', '112', '0', '0', 'Wujin Qu', '2');
INSERT INTO `t_region` VALUES ('1220', '320481', '溧阳市', '112', '0', '0', 'Liyang Shi', 'LYR');
INSERT INTO `t_region` VALUES ('1221', '320482', '金坛市', '112', '0', '0', 'Jintan Shi', 'JTS');
INSERT INTO `t_region` VALUES ('1222', '320501', '市辖区', '113', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1223', '320502', '沧浪区', '113', '0', '0', 'Canglang Qu', 'CLQ');
INSERT INTO `t_region` VALUES ('1224', '320503', '平江区', '113', '0', '0', 'Pingjiang Qu', 'PJQ');
INSERT INTO `t_region` VALUES ('1225', '320504', '金阊区', '113', '0', '0', 'Jinchang Qu', 'JCA');
INSERT INTO `t_region` VALUES ('1226', '320505', '虎丘区', '113', '0', '0', 'Huqiu Qu', '2');
INSERT INTO `t_region` VALUES ('1227', '320506', '吴中区', '113', '0', '0', 'Wuzhong Qu', '2');
INSERT INTO `t_region` VALUES ('1228', '320507', '相城区', '113', '0', '0', 'Xiangcheng Qu', '2');
INSERT INTO `t_region` VALUES ('1229', '320581', '常熟市', '113', '0', '0', 'Changshu Shi', 'CGS');
INSERT INTO `t_region` VALUES ('1230', '320582', '张家港市', '113', '0', '0', 'Zhangjiagang Shi ', 'ZJG');
INSERT INTO `t_region` VALUES ('1231', '320583', '昆山市', '113', '0', '0', 'Kunshan Shi', 'KUS');
INSERT INTO `t_region` VALUES ('1232', '320584', '吴江市', '113', '0', '0', 'Wujiang Shi', 'WUJ');
INSERT INTO `t_region` VALUES ('1233', '320585', '太仓市', '113', '0', '0', 'Taicang Shi', 'TAC');
INSERT INTO `t_region` VALUES ('1234', '320601', '市辖区', '114', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1235', '320602', '崇川区', '114', '0', '0', 'Chongchuan Qu', 'CCQ');
INSERT INTO `t_region` VALUES ('1236', '320611', '港闸区', '114', '0', '0', 'Gangzha Qu', 'GZQ');
INSERT INTO `t_region` VALUES ('1237', '320621', '海安县', '114', '0', '0', 'Hai,an Xian', 'HIA');
INSERT INTO `t_region` VALUES ('1238', '320623', '如东县', '114', '0', '0', 'Rudong Xian', 'RDG');
INSERT INTO `t_region` VALUES ('1239', '320681', '启东市', '114', '0', '0', 'Qidong Shi', 'QID');
INSERT INTO `t_region` VALUES ('1240', '320682', '如皋市', '114', '0', '0', 'Rugao Shi', 'RGO');
INSERT INTO `t_region` VALUES ('1241', '320612', '通州区', '114', '0', '0', 'Tongzhou Shi', '2');
INSERT INTO `t_region` VALUES ('1242', '320684', '海门市', '114', '0', '0', 'Haimen Shi', 'HME');
INSERT INTO `t_region` VALUES ('1243', '320701', '市辖区', '115', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1244', '320703', '连云区', '115', '0', '0', 'Lianyun Qu', 'LYB');
INSERT INTO `t_region` VALUES ('1245', '320705', '新浦区', '115', '0', '0', 'Xinpu Qu', 'XPQ');
INSERT INTO `t_region` VALUES ('1246', '320706', '海州区', '115', '0', '0', 'Haizhou Qu', 'HIZ');
INSERT INTO `t_region` VALUES ('1247', '320721', '赣榆县', '115', '0', '0', 'Ganyu Xian', 'GYU');
INSERT INTO `t_region` VALUES ('1248', '320722', '东海县', '115', '0', '0', 'Donghai Xian', 'DHX');
INSERT INTO `t_region` VALUES ('1249', '320723', '灌云县', '115', '0', '0', 'Guanyun Xian', 'GYS');
INSERT INTO `t_region` VALUES ('1250', '320724', '灌南县', '115', '0', '0', 'Guannan Xian', 'GUN');
INSERT INTO `t_region` VALUES ('1251', '320801', '市辖区', '116', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1252', '320802', '清河区', '116', '0', '0', 'Qinghe Qu', 'QHH');
INSERT INTO `t_region` VALUES ('1253', '320803', '楚州区', '116', '0', '0', 'Chuzhou Qu', '2');
INSERT INTO `t_region` VALUES ('1254', '320804', '淮阴区', '116', '0', '0', 'Huaiyin Qu', '2');
INSERT INTO `t_region` VALUES ('1255', '320811', '清浦区', '116', '0', '0', 'Qingpu Qu', 'QPQ');
INSERT INTO `t_region` VALUES ('1256', '320826', '涟水县', '116', '0', '0', 'Lianshui Xian', 'LSI');
INSERT INTO `t_region` VALUES ('1257', '320829', '洪泽县', '116', '0', '0', 'Hongze Xian', 'HGZ');
INSERT INTO `t_region` VALUES ('1258', '320830', '盱眙县', '116', '0', '0', 'Xuyi Xian', 'XUY');
INSERT INTO `t_region` VALUES ('1259', '320831', '金湖县', '116', '0', '0', 'Jinhu Xian', 'JHU');
INSERT INTO `t_region` VALUES ('1260', '320901', '市辖区', '117', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1261', '320902', '亭湖区', '117', '0', '0', 'Tinghu Qu', '2');
INSERT INTO `t_region` VALUES ('1262', '320903', '盐都区', '117', '0', '0', 'Yandu Qu', '2');
INSERT INTO `t_region` VALUES ('1263', '320921', '响水县', '117', '0', '0', 'Xiangshui Xian', 'XSH');
INSERT INTO `t_region` VALUES ('1264', '320922', '滨海县', '117', '0', '0', 'Binhai Xian', 'BHI');
INSERT INTO `t_region` VALUES ('1265', '320923', '阜宁县', '117', '0', '0', 'Funing Xian', 'FNG');
INSERT INTO `t_region` VALUES ('1266', '320924', '射阳县', '117', '0', '0', 'Sheyang Xian', 'SEY');
INSERT INTO `t_region` VALUES ('1267', '320925', '建湖县', '117', '0', '0', 'Jianhu Xian', 'JIH');
INSERT INTO `t_region` VALUES ('1268', '320981', '东台市', '117', '0', '0', 'Dongtai Shi', 'DTS');
INSERT INTO `t_region` VALUES ('1269', '320982', '大丰市', '117', '0', '0', 'Dafeng Shi', 'DFS');
INSERT INTO `t_region` VALUES ('1270', '321001', '市辖区', '118', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1271', '321002', '广陵区', '118', '0', '0', 'Guangling Qu', 'GGL');
INSERT INTO `t_region` VALUES ('1272', '321003', '邗江区', '118', '0', '0', 'Hanjiang Qu', '2');
INSERT INTO `t_region` VALUES ('1273', '321011', '维扬区', '118', '0', '0', 'Weiyang Qu', '2');
INSERT INTO `t_region` VALUES ('1274', '321023', '宝应县', '118', '0', '0', 'Baoying Xian ', 'BYI');
INSERT INTO `t_region` VALUES ('1275', '321081', '仪征市', '118', '0', '0', 'Yizheng Shi', 'YZE');
INSERT INTO `t_region` VALUES ('1276', '321084', '高邮市', '118', '0', '0', 'Gaoyou Shi', 'GYO');
INSERT INTO `t_region` VALUES ('1277', '321088', '江都市', '118', '0', '0', 'Jiangdu Shi', 'JDU');
INSERT INTO `t_region` VALUES ('1278', '321101', '市辖区', '119', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1279', '321102', '京口区', '119', '0', '0', 'Jingkou Qu', '2');
INSERT INTO `t_region` VALUES ('1280', '321111', '润州区', '119', '0', '0', 'Runzhou Qu', 'RZQ');
INSERT INTO `t_region` VALUES ('1281', '321112', '丹徒区', '119', '0', '0', 'Dantu Qu', '2');
INSERT INTO `t_region` VALUES ('1282', '321181', '丹阳市', '119', '0', '0', 'Danyang Xian', 'DNY');
INSERT INTO `t_region` VALUES ('1283', '321182', '扬中市', '119', '0', '0', 'Yangzhong Shi', 'YZG');
INSERT INTO `t_region` VALUES ('1284', '321183', '句容市', '119', '0', '0', 'Jurong Shi', 'JRG');
INSERT INTO `t_region` VALUES ('1285', '321201', '市辖区', '120', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1286', '321202', '海陵区', '120', '0', '0', 'Hailing Qu', 'HIL');
INSERT INTO `t_region` VALUES ('1287', '321203', '高港区', '120', '0', '0', 'Gaogang Qu', 'GGQ');
INSERT INTO `t_region` VALUES ('1288', '321281', '兴化市', '120', '0', '0', 'Xinghua Shi', 'XHS');
INSERT INTO `t_region` VALUES ('1289', '321282', '靖江市', '120', '0', '0', 'Jingjiang Shi', 'JGJ');
INSERT INTO `t_region` VALUES ('1290', '321283', '泰兴市', '120', '0', '0', 'Taixing Shi', 'TXG');
INSERT INTO `t_region` VALUES ('1291', '321284', '姜堰市', '120', '0', '0', 'Jiangyan Shi', 'JYS');
INSERT INTO `t_region` VALUES ('1292', '321301', '市辖区', '121', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1293', '321302', '宿城区', '121', '0', '0', 'Sucheng Qu', 'SCE');
INSERT INTO `t_region` VALUES ('1294', '321311', '宿豫区', '121', '0', '0', 'Suyu Qu', '2');
INSERT INTO `t_region` VALUES ('1295', '321322', '沭阳县', '121', '0', '0', 'Shuyang Xian', 'SYD');
INSERT INTO `t_region` VALUES ('1296', '321323', '泗阳县', '121', '0', '0', 'Siyang Xian ', 'SIY');
INSERT INTO `t_region` VALUES ('1297', '321324', '泗洪县', '121', '0', '0', 'Sihong Xian', 'SIH');
INSERT INTO `t_region` VALUES ('1298', '330101', '市辖区', '122', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1299', '330102', '上城区', '122', '0', '0', 'Shangcheng Qu', 'SCQ');
INSERT INTO `t_region` VALUES ('1300', '330103', '下城区', '122', '0', '0', 'Xiacheng Qu', 'XCG');
INSERT INTO `t_region` VALUES ('1301', '330104', '江干区', '122', '0', '0', 'Jianggan Qu', 'JGQ');
INSERT INTO `t_region` VALUES ('1302', '330105', '拱墅区', '122', '0', '0', 'Gongshu Qu', 'GSQ');
INSERT INTO `t_region` VALUES ('1303', '330106', '西湖区', '122', '0', '0', 'Xihu Qu ', 'XHU');
INSERT INTO `t_region` VALUES ('1304', '330108', '滨江区', '122', '0', '0', 'Binjiang Qu', 'BJQ');
INSERT INTO `t_region` VALUES ('1305', '330109', '萧山区', '122', '0', '0', 'Xiaoshan Qu', '2');
INSERT INTO `t_region` VALUES ('1306', '330110', '余杭区', '122', '0', '0', 'Yuhang Qu', '2');
INSERT INTO `t_region` VALUES ('1307', '330122', '桐庐县', '122', '0', '0', 'Tonglu Xian', 'TLU');
INSERT INTO `t_region` VALUES ('1308', '330127', '淳安县', '122', '0', '0', 'Chun,an Xian', 'CAZ');
INSERT INTO `t_region` VALUES ('1309', '330182', '建德市', '122', '0', '0', 'Jiande Shi', 'JDS');
INSERT INTO `t_region` VALUES ('1310', '330183', '富阳市', '122', '0', '0', 'Fuyang Shi', 'FYZ');
INSERT INTO `t_region` VALUES ('1311', '330185', '临安市', '122', '0', '0', 'Lin,an Shi', 'LNA');
INSERT INTO `t_region` VALUES ('1312', '330201', '市辖区', '123', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1313', '330203', '海曙区', '123', '0', '0', 'Haishu Qu', 'HNB');
INSERT INTO `t_region` VALUES ('1314', '330204', '江东区', '123', '0', '0', 'Jiangdong Qu', 'JDO');
INSERT INTO `t_region` VALUES ('1315', '330205', '江北区', '123', '0', '0', 'Jiangbei Qu', 'JBQ');
INSERT INTO `t_region` VALUES ('1316', '330206', '北仑区', '123', '0', '0', 'Beilun Qu', 'BLN');
INSERT INTO `t_region` VALUES ('1317', '330211', '镇海区', '123', '0', '0', 'Zhenhai Qu', 'ZHF');
INSERT INTO `t_region` VALUES ('1318', '330212', '鄞州区', '123', '0', '0', 'Yinzhou Qu', '2');
INSERT INTO `t_region` VALUES ('1319', '330225', '象山县', '123', '0', '0', 'Xiangshan Xian', 'YSZ');
INSERT INTO `t_region` VALUES ('1320', '330226', '宁海县', '123', '0', '0', 'Ninghai Xian', 'NHI');
INSERT INTO `t_region` VALUES ('1321', '330281', '余姚市', '123', '0', '0', 'Yuyao Shi', 'YYO');
INSERT INTO `t_region` VALUES ('1322', '330282', '慈溪市', '123', '0', '0', 'Cixi Shi', 'CXI');
INSERT INTO `t_region` VALUES ('1323', '330283', '奉化市', '123', '0', '0', 'Fenghua Shi', 'FHU');
INSERT INTO `t_region` VALUES ('1324', '330301', '市辖区', '124', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1325', '330302', '鹿城区', '124', '0', '0', 'Lucheng Qu', 'LUW');
INSERT INTO `t_region` VALUES ('1326', '330303', '龙湾区', '124', '0', '0', 'Longwan Qu', 'LWW');
INSERT INTO `t_region` VALUES ('1327', '330304', '瓯海区', '124', '0', '0', 'Ouhai Qu', 'OHQ');
INSERT INTO `t_region` VALUES ('1328', '330322', '洞头县', '124', '0', '0', 'Dongtou Xian', 'DTO');
INSERT INTO `t_region` VALUES ('1329', '330324', '永嘉县', '124', '0', '0', 'Yongjia Xian', 'YJX');
INSERT INTO `t_region` VALUES ('1330', '330326', '平阳县', '124', '0', '0', 'Pingyang Xian', 'PYG');
INSERT INTO `t_region` VALUES ('1331', '330327', '苍南县', '124', '0', '0', 'Cangnan Xian', 'CAN');
INSERT INTO `t_region` VALUES ('1332', '330328', '文成县', '124', '0', '0', 'Wencheng Xian', 'WCZ');
INSERT INTO `t_region` VALUES ('1333', '330329', '泰顺县', '124', '0', '0', 'Taishun Xian', 'TSZ');
INSERT INTO `t_region` VALUES ('1334', '330381', '瑞安市', '124', '0', '0', 'Rui,an Xian', 'RAS');
INSERT INTO `t_region` VALUES ('1335', '330382', '乐清市', '124', '0', '0', 'Yueqing Shi', 'YQZ');
INSERT INTO `t_region` VALUES ('1336', '330401', '市辖区', '125', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1338', '330411', '秀洲区', '125', '0', '0', 'Xiuzhou Qu', '2');
INSERT INTO `t_region` VALUES ('1339', '330421', '嘉善县', '125', '0', '0', 'Jiashan Xian', 'JSK');
INSERT INTO `t_region` VALUES ('1340', '330424', '海盐县', '125', '0', '0', 'Haiyan Xian', 'HYN');
INSERT INTO `t_region` VALUES ('1341', '330481', '海宁市', '125', '0', '0', 'Haining Shi', 'HNG');
INSERT INTO `t_region` VALUES ('1342', '330482', '平湖市', '125', '0', '0', 'Pinghu Shi', 'PHU');
INSERT INTO `t_region` VALUES ('1343', '330483', '桐乡市', '125', '0', '0', 'Tongxiang Shi', 'TXZ');
INSERT INTO `t_region` VALUES ('1344', '330501', '市辖区', '126', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1345', '330502', '吴兴区', '126', '0', '0', 'Wuxing Qu', '2');
INSERT INTO `t_region` VALUES ('1346', '330503', '南浔区', '126', '0', '0', 'Nanxun Qu', '2');
INSERT INTO `t_region` VALUES ('1347', '330521', '德清县', '126', '0', '0', 'Deqing Xian', 'DQX');
INSERT INTO `t_region` VALUES ('1348', '330522', '长兴县', '126', '0', '0', 'Changxing Xian', 'CXG');
INSERT INTO `t_region` VALUES ('1349', '330523', '安吉县', '126', '0', '0', 'Anji Xian', 'AJI');
INSERT INTO `t_region` VALUES ('1350', '330601', '市辖区', '127', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1351', '330602', '越城区', '127', '0', '0', 'Yuecheng Qu', 'YSX');
INSERT INTO `t_region` VALUES ('1352', '330621', '绍兴县', '127', '0', '0', 'Shaoxing Xian', 'SXZ');
INSERT INTO `t_region` VALUES ('1353', '330624', '新昌县', '127', '0', '0', 'Xinchang Xian', 'XCX');
INSERT INTO `t_region` VALUES ('1354', '330681', '诸暨市', '127', '0', '0', 'Zhuji Shi', 'ZHJ');
INSERT INTO `t_region` VALUES ('1355', '330682', '上虞市', '127', '0', '0', 'Shangyu Shi', 'SYZ');
INSERT INTO `t_region` VALUES ('1356', '330683', '嵊州市', '127', '0', '0', 'Shengzhou Shi', 'SGZ');
INSERT INTO `t_region` VALUES ('1357', '330701', '市辖区', '128', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1358', '330702', '婺城区', '128', '0', '0', 'Wucheng Qu', 'WCF');
INSERT INTO `t_region` VALUES ('1359', '330703', '金东区', '128', '0', '0', 'Jindong Qu', '2');
INSERT INTO `t_region` VALUES ('1360', '330723', '武义县', '128', '0', '0', 'Wuyi Xian', 'WYX');
INSERT INTO `t_region` VALUES ('1361', '330726', '浦江县', '128', '0', '0', 'Pujiang Xian ', 'PJG');
INSERT INTO `t_region` VALUES ('1362', '330727', '磐安县', '128', '0', '0', 'Pan,an Xian', 'PAX');
INSERT INTO `t_region` VALUES ('1363', '330781', '兰溪市', '128', '0', '0', 'Lanxi Shi', 'LXZ');
INSERT INTO `t_region` VALUES ('1364', '330782', '义乌市', '128', '0', '0', 'Yiwu Shi', 'YWS');
INSERT INTO `t_region` VALUES ('1365', '330783', '东阳市', '128', '0', '0', 'Dongyang Shi', 'DGY');
INSERT INTO `t_region` VALUES ('1366', '330784', '永康市', '128', '0', '0', 'Yongkang Shi', 'YKG');
INSERT INTO `t_region` VALUES ('1367', '330801', '市辖区', '129', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1368', '330802', '柯城区', '129', '0', '0', 'Kecheng Qu', 'KEC');
INSERT INTO `t_region` VALUES ('1369', '330803', '衢江区', '129', '0', '0', 'Qujiang Qu', '2');
INSERT INTO `t_region` VALUES ('1370', '330822', '常山县', '129', '0', '0', 'Changshan Xian', 'CSN');
INSERT INTO `t_region` VALUES ('1371', '330824', '开化县', '129', '0', '0', 'Kaihua Xian', 'KHU');
INSERT INTO `t_region` VALUES ('1372', '330825', '龙游县', '129', '0', '0', 'Longyou Xian ', 'LGY');
INSERT INTO `t_region` VALUES ('1373', '330881', '江山市', '129', '0', '0', 'Jiangshan Shi', 'JIS');
INSERT INTO `t_region` VALUES ('1374', '330901', '市辖区', '130', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1375', '330902', '定海区', '130', '0', '0', 'Dinghai Qu', 'DHQ');
INSERT INTO `t_region` VALUES ('1376', '330903', '普陀区', '130', '0', '0', 'Putuo Qu', 'PTO');
INSERT INTO `t_region` VALUES ('1377', '330921', '岱山县', '130', '0', '0', 'Daishan Xian', 'DSH');
INSERT INTO `t_region` VALUES ('1378', '330922', '嵊泗县', '130', '0', '0', 'Shengsi Xian', 'SSZ');
INSERT INTO `t_region` VALUES ('1379', '331001', '市辖区', '131', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1380', '331002', '椒江区', '131', '0', '0', 'Jiaojiang Qu', 'JJT');
INSERT INTO `t_region` VALUES ('1381', '331003', '黄岩区', '131', '0', '0', 'Huangyan Qu', 'HYT');
INSERT INTO `t_region` VALUES ('1382', '331004', '路桥区', '131', '0', '0', 'Luqiao Qu', 'LQT');
INSERT INTO `t_region` VALUES ('1383', '331021', '玉环县', '131', '0', '0', 'Yuhuan Xian', 'YHN');
INSERT INTO `t_region` VALUES ('1384', '331022', '三门县', '131', '0', '0', 'Sanmen Xian', 'SMN');
INSERT INTO `t_region` VALUES ('1385', '331023', '天台县', '131', '0', '0', 'Tiantai Xian', 'TTA');
INSERT INTO `t_region` VALUES ('1386', '331024', '仙居县', '131', '0', '0', 'Xianju Xian', 'XJU');
INSERT INTO `t_region` VALUES ('1387', '331081', '温岭市', '131', '0', '0', 'Wenling Shi', 'WLS');
INSERT INTO `t_region` VALUES ('1388', '331082', '临海市', '131', '0', '0', 'Linhai Shi', 'LHI');
INSERT INTO `t_region` VALUES ('1389', '331101', '市辖区', '132', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('1390', '331102', '莲都区', '132', '0', '0', 'Liandu Qu', '2');
INSERT INTO `t_region` VALUES ('1391', '331121', '青田县', '132', '0', '0', 'Qingtian Xian', '2');
INSERT INTO `t_region` VALUES ('1392', '331122', '缙云县', '132', '0', '0', 'Jinyun Xian', '2');
INSERT INTO `t_region` VALUES ('1393', '331123', '遂昌县', '132', '0', '0', 'Suichang Xian', '2');
INSERT INTO `t_region` VALUES ('1394', '331124', '松阳县', '132', '0', '0', 'Songyang Xian', '2');
INSERT INTO `t_region` VALUES ('1395', '331125', '云和县', '132', '0', '0', 'Yunhe Xian', '2');
INSERT INTO `t_region` VALUES ('1396', '331126', '庆元县', '132', '0', '0', 'Qingyuan Xian', '2');
INSERT INTO `t_region` VALUES ('1397', '331127', '景宁畲族自治县', '132', '0', '0', 'Jingning Shezu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('1398', '331181', '龙泉市', '132', '0', '0', 'Longquan Shi', '2');
INSERT INTO `t_region` VALUES ('1399', '340101', '市辖区', '133', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1400', '340102', '瑶海区', '133', '0', '0', 'Yaohai Qu', '2');
INSERT INTO `t_region` VALUES ('1401', '340103', '庐阳区', '133', '0', '0', 'Luyang Qu', '2');
INSERT INTO `t_region` VALUES ('1402', '340104', '蜀山区', '133', '0', '0', 'Shushan Qu', '2');
INSERT INTO `t_region` VALUES ('1403', '340111', '包河区', '133', '0', '0', 'Baohe Qu', '2');
INSERT INTO `t_region` VALUES ('1404', '340121', '长丰县', '133', '0', '0', 'Changfeng Xian', 'CFG');
INSERT INTO `t_region` VALUES ('1405', '340122', '肥东县', '133', '0', '0', 'Feidong Xian', 'FDO');
INSERT INTO `t_region` VALUES ('1406', '340123', '肥西县', '133', '0', '0', 'Feixi Xian', 'FIX');
INSERT INTO `t_region` VALUES ('1407', '340201', '市辖区', '1412', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1408', '340202', '镜湖区', '1412', '0', '0', 'Jinghu Qu', 'JHW');
INSERT INTO `t_region` VALUES ('1409', '340208', '三山区', '1412', '0', '0', 'Matang Qu', '2');
INSERT INTO `t_region` VALUES ('1410', '340203', '弋江区', '1412', '0', '0', 'Xinwu Qu', '2');
INSERT INTO `t_region` VALUES ('1411', '340207', '鸠江区', '1412', '0', '0', 'Jiujiang Qu', 'JJW');
INSERT INTO `t_region` VALUES ('1412', '340200', '芜湖市', '134', '0', '0', 'Wuhu Shi', 'WHI');
INSERT INTO `t_region` VALUES ('1413', '340222', '繁昌县', '1412', '0', '0', 'Fanchang Xian', 'FCH');
INSERT INTO `t_region` VALUES ('1414', '340223', '南陵县', '1412', '0', '0', 'Nanling Xian', 'NLX');
INSERT INTO `t_region` VALUES ('1415', '340301', '市辖区', '135', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1416', '340302', '龙子湖区', '135', '0', '0', 'Longzihu Qu', '2');
INSERT INTO `t_region` VALUES ('1417', '340303', '蚌山区', '135', '0', '0', 'Bangshan Qu', '2');
INSERT INTO `t_region` VALUES ('1418', '340304', '禹会区', '135', '0', '0', 'Yuhui Qu', '2');
INSERT INTO `t_region` VALUES ('1419', '340311', '淮上区', '135', '0', '0', 'Huaishang Qu', '2');
INSERT INTO `t_region` VALUES ('1420', '340321', '怀远县', '135', '0', '0', 'Huaiyuan Qu', 'HYW');
INSERT INTO `t_region` VALUES ('1421', '340322', '五河县', '135', '0', '0', 'Wuhe Xian', 'WHE');
INSERT INTO `t_region` VALUES ('1422', '340323', '固镇县', '135', '0', '0', 'Guzhen Xian', 'GZX');
INSERT INTO `t_region` VALUES ('1423', '340401', '市辖区', '136', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1424', '340402', '大通区', '136', '0', '0', 'Datong Qu', 'DTQ');
INSERT INTO `t_region` VALUES ('1425', '340403', '田家庵区', '136', '0', '0', 'Tianjia,an Qu', 'TJA');
INSERT INTO `t_region` VALUES ('1426', '340404', '谢家集区', '136', '0', '0', 'Xiejiaji Qu', 'XJJ');
INSERT INTO `t_region` VALUES ('1427', '340405', '八公山区', '136', '0', '0', 'Bagongshan Qu', 'BGS');
INSERT INTO `t_region` VALUES ('1428', '340406', '潘集区', '136', '0', '0', 'Panji Qu', 'PJI');
INSERT INTO `t_region` VALUES ('1429', '340421', '凤台县', '136', '0', '0', 'Fengtai Xian', '2');
INSERT INTO `t_region` VALUES ('1430', '340501', '市辖区', '137', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1431', '340502', '金家庄区', '137', '0', '0', 'Jinjiazhuang Qu', 'JJZ');
INSERT INTO `t_region` VALUES ('1432', '340503', '花山区', '137', '0', '0', 'Huashan Qu', 'HSM');
INSERT INTO `t_region` VALUES ('1433', '340504', '雨山区', '137', '0', '0', 'Yushan Qu', 'YSQ');
INSERT INTO `t_region` VALUES ('1434', '340521', '当涂县', '137', '0', '0', 'Dangtu Xian', 'DTU');
INSERT INTO `t_region` VALUES ('1435', '340601', '市辖区', '138', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1436', '340602', '杜集区', '138', '0', '0', 'Duji Qu', 'DJQ');
INSERT INTO `t_region` VALUES ('1437', '340603', '相山区', '138', '0', '0', 'Xiangshan Qu', 'XSA');
INSERT INTO `t_region` VALUES ('1438', '340604', '烈山区', '138', '0', '0', 'Lieshan Qu', 'LHB');
INSERT INTO `t_region` VALUES ('1439', '340621', '濉溪县', '138', '0', '0', 'Suixi Xian', 'SXW');
INSERT INTO `t_region` VALUES ('1440', '340701', '市辖区', '139', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1441', '340702', '铜官山区', '139', '0', '0', 'Tongguanshan Qu', 'TGQ');
INSERT INTO `t_region` VALUES ('1442', '340703', '狮子山区', '139', '0', '0', 'Shizishan Qu', 'SZN');
INSERT INTO `t_region` VALUES ('1443', '340711', '郊区', '139', '0', '0', 'Jiaoqu', 'JTL');
INSERT INTO `t_region` VALUES ('1444', '340721', '铜陵县', '139', '0', '0', 'Tongling Xian', 'TLX');
INSERT INTO `t_region` VALUES ('1445', '340801', '市辖区', '140', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1446', '340802', '迎江区', '140', '0', '0', 'Yingjiang Qu', 'YJQ');
INSERT INTO `t_region` VALUES ('1447', '340803', '大观区', '140', '0', '0', 'Daguan Qu', 'DGQ');
INSERT INTO `t_region` VALUES ('1448', '340811', '宜秀区', '140', '0', '0', 'Yixiu Qu', '2');
INSERT INTO `t_region` VALUES ('1449', '340822', '怀宁县', '140', '0', '0', 'Huaining Xian', 'HNW');
INSERT INTO `t_region` VALUES ('1450', '340823', '枞阳县', '140', '0', '0', 'Zongyang Xian', 'ZYW');
INSERT INTO `t_region` VALUES ('1451', '340824', '潜山县', '140', '0', '0', 'Qianshan Xian', 'QSW');
INSERT INTO `t_region` VALUES ('1452', '340825', '太湖县', '140', '0', '0', 'Taihu Xian', 'THU');
INSERT INTO `t_region` VALUES ('1453', '340826', '宿松县', '140', '0', '0', 'Susong Xian', 'SUS');
INSERT INTO `t_region` VALUES ('1454', '340827', '望江县', '140', '0', '0', 'Wangjiang Xian', 'WJX');
INSERT INTO `t_region` VALUES ('1455', '340828', '岳西县', '140', '0', '0', 'Yuexi Xian', 'YXW');
INSERT INTO `t_region` VALUES ('1456', '340881', '桐城市', '140', '0', '0', 'Tongcheng Shi', 'TCW');
INSERT INTO `t_region` VALUES ('1457', '341001', '市辖区', '141', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1458', '341002', '屯溪区', '141', '0', '0', 'Tunxi Qu', 'TXN');
INSERT INTO `t_region` VALUES ('1459', '341003', '黄山区', '141', '0', '0', 'Huangshan Qu', 'HSK');
INSERT INTO `t_region` VALUES ('1460', '341004', '徽州区', '141', '0', '0', 'Huizhou Qu', 'HZQ');
INSERT INTO `t_region` VALUES ('1461', '341021', '歙县', '141', '0', '0', 'She Xian', 'SEX');
INSERT INTO `t_region` VALUES ('1462', '341022', '休宁县', '141', '0', '0', 'Xiuning Xian', 'XUN');
INSERT INTO `t_region` VALUES ('1463', '341023', '黟县', '141', '0', '0', 'Yi Xian', 'YIW');
INSERT INTO `t_region` VALUES ('1464', '341024', '祁门县', '141', '0', '0', 'Qimen Xian', 'QMN');
INSERT INTO `t_region` VALUES ('1465', '341101', '市辖区', '142', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1466', '341102', '琅琊区', '142', '0', '0', 'Langya Qu', 'LYU');
INSERT INTO `t_region` VALUES ('1467', '341103', '南谯区', '142', '0', '0', 'Nanqiao Qu', 'NQQ');
INSERT INTO `t_region` VALUES ('1468', '341122', '来安县', '142', '0', '0', 'Lai,an Xian', 'LAX');
INSERT INTO `t_region` VALUES ('1469', '341124', '全椒县', '142', '0', '0', 'Quanjiao Xian', 'QJO');
INSERT INTO `t_region` VALUES ('1470', '341125', '定远县', '142', '0', '0', 'Dingyuan Xian', 'DYW');
INSERT INTO `t_region` VALUES ('1471', '341126', '凤阳县', '142', '0', '0', 'Fengyang Xian', 'FYG');
INSERT INTO `t_region` VALUES ('1472', '341181', '天长市', '142', '0', '0', 'Tianchang Shi', 'TNC');
INSERT INTO `t_region` VALUES ('1473', '341182', '明光市', '142', '0', '0', 'Mingguang Shi', 'MGG');
INSERT INTO `t_region` VALUES ('1474', '341201', '市辖区', '143', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1475', '341202', '颍州区', '143', '0', '0', 'Yingzhou Qu', '2');
INSERT INTO `t_region` VALUES ('1476', '341203', '颍东区', '143', '0', '0', 'Yingdong Qu', '2');
INSERT INTO `t_region` VALUES ('1477', '341204', '颍泉区', '143', '0', '0', 'Yingquan Qu', '2');
INSERT INTO `t_region` VALUES ('1478', '341221', '临泉县', '143', '0', '0', 'Linquan Xian', 'LQN');
INSERT INTO `t_region` VALUES ('1479', '341222', '太和县', '143', '0', '0', 'Taihe Xian', 'TIH');
INSERT INTO `t_region` VALUES ('1480', '341225', '阜南县', '143', '0', '0', 'Funan Xian', 'FNX');
INSERT INTO `t_region` VALUES ('1481', '341226', '颍上县', '143', '0', '0', 'Yingshang Xian', '2');
INSERT INTO `t_region` VALUES ('1482', '341282', '界首市', '143', '0', '0', 'Jieshou Shi', 'JSW');
INSERT INTO `t_region` VALUES ('1483', '341301', '市辖区', '144', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1484', '341302', '埇桥区', '144', '0', '0', 'Yongqiao Qu', '2');
INSERT INTO `t_region` VALUES ('1485', '341321', '砀山县', '144', '0', '0', 'Dangshan Xian', 'DSW');
INSERT INTO `t_region` VALUES ('1486', '341322', '萧县', '144', '0', '0', 'Xiao Xian', 'XIO');
INSERT INTO `t_region` VALUES ('1487', '341323', '灵璧县', '144', '0', '0', 'Lingbi Xian', 'LBI');
INSERT INTO `t_region` VALUES ('1488', '341324', '泗县', '144', '0', '0', 'Si Xian ', 'SIX');
INSERT INTO `t_region` VALUES ('1489', '341401', '市辖区', '145', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('1490', '341402', '居巢区', '145', '0', '0', 'Juchao Qu', '2');
INSERT INTO `t_region` VALUES ('1491', '341421', '庐江县', '145', '0', '0', 'Lujiang Xian', '2');
INSERT INTO `t_region` VALUES ('1492', '341422', '无为县', '145', '0', '0', 'Wuwei Xian', '2');
INSERT INTO `t_region` VALUES ('1493', '341423', '含山县', '145', '0', '0', 'Hanshan Xian', '2');
INSERT INTO `t_region` VALUES ('1494', '341424', '和县', '145', '0', '0', 'He Xian ', '2');
INSERT INTO `t_region` VALUES ('1495', '341501', '市辖区', '146', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('1496', '341502', '金安区', '146', '0', '0', 'Jinan Qu', '2');
INSERT INTO `t_region` VALUES ('1497', '341503', '裕安区', '146', '0', '0', 'Yuan Qu', '2');
INSERT INTO `t_region` VALUES ('1498', '341521', '寿县', '146', '0', '0', 'Shou Xian', '2');
INSERT INTO `t_region` VALUES ('1499', '341522', '霍邱县', '146', '0', '0', 'Huoqiu Xian', '2');
INSERT INTO `t_region` VALUES ('1500', '341523', '舒城县', '146', '0', '0', 'Shucheng Xian', '2');
INSERT INTO `t_region` VALUES ('1501', '341524', '金寨县', '146', '0', '0', 'Jingzhai Xian', '2');
INSERT INTO `t_region` VALUES ('1502', '341525', '霍山县', '146', '0', '0', 'Huoshan Xian', '2');
INSERT INTO `t_region` VALUES ('1503', '341601', '市辖区', '147', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('1504', '341602', '谯城区', '147', '0', '0', 'Qiaocheng Qu', '2');
INSERT INTO `t_region` VALUES ('1505', '341621', '涡阳县', '147', '0', '0', 'Guoyang Xian', '2');
INSERT INTO `t_region` VALUES ('1506', '341622', '蒙城县', '147', '0', '0', 'Mengcheng Xian', '2');
INSERT INTO `t_region` VALUES ('1507', '341623', '利辛县', '147', '0', '0', 'Lixin Xian', '2');
INSERT INTO `t_region` VALUES ('1508', '341701', '市辖区', '148', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('1509', '341702', '贵池区', '148', '0', '0', 'Guichi Qu', '2');
INSERT INTO `t_region` VALUES ('1510', '341721', '东至县', '148', '0', '0', 'Dongzhi Xian', '2');
INSERT INTO `t_region` VALUES ('1511', '341722', '石台县', '148', '0', '0', 'Shitai Xian', '2');
INSERT INTO `t_region` VALUES ('1512', '341723', '青阳县', '148', '0', '0', 'Qingyang Xian', '2');
INSERT INTO `t_region` VALUES ('1513', '341801', '市辖区', '149', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('1514', '341802', '宣州区', '149', '0', '0', 'Xuanzhou Qu', '2');
INSERT INTO `t_region` VALUES ('1515', '341821', '郎溪县', '149', '0', '0', 'Langxi Xian', '2');
INSERT INTO `t_region` VALUES ('1516', '341822', '广德县', '149', '0', '0', 'Guangde Xian', '2');
INSERT INTO `t_region` VALUES ('1517', '341823', '泾县', '149', '0', '0', 'Jing Xian', '2');
INSERT INTO `t_region` VALUES ('1518', '341824', '绩溪县', '149', '0', '0', 'Jixi Xian', '2');
INSERT INTO `t_region` VALUES ('1519', '341825', '旌德县', '149', '0', '0', 'Jingde Xian', '2');
INSERT INTO `t_region` VALUES ('1520', '341881', '宁国市', '149', '0', '0', 'Ningguo Shi', '2');
INSERT INTO `t_region` VALUES ('1521', '350101', '市辖区', '150', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1522', '350102', '鼓楼区', '150', '0', '0', 'Gulou Qu', 'GLR');
INSERT INTO `t_region` VALUES ('1523', '350103', '台江区', '150', '0', '0', 'Taijiang Qu', 'TJQ');
INSERT INTO `t_region` VALUES ('1524', '350104', '仓山区', '150', '0', '0', 'Cangshan Qu', 'CSQ');
INSERT INTO `t_region` VALUES ('1525', '350105', '马尾区', '150', '0', '0', 'Mawei Qu', 'MWQ');
INSERT INTO `t_region` VALUES ('1526', '350111', '晋安区', '150', '0', '0', 'Jin,an Qu', 'JAF');
INSERT INTO `t_region` VALUES ('1527', '350121', '闽侯县', '150', '0', '0', 'Minhou Qu', 'MHO');
INSERT INTO `t_region` VALUES ('1528', '350122', '连江县', '150', '0', '0', 'Lianjiang Xian', 'LJF');
INSERT INTO `t_region` VALUES ('1529', '350123', '罗源县', '150', '0', '0', 'Luoyuan Xian', 'LOY');
INSERT INTO `t_region` VALUES ('1530', '350124', '闽清县', '150', '0', '0', 'Minqing Xian', 'MQG');
INSERT INTO `t_region` VALUES ('1531', '350125', '永泰县', '150', '0', '0', 'Yongtai Xian', 'YTX');
INSERT INTO `t_region` VALUES ('1532', '350128', '平潭县', '150', '0', '0', 'Pingtan Xian', 'PTN');
INSERT INTO `t_region` VALUES ('1533', '350181', '福清市', '150', '0', '0', 'Fuqing Shi', 'FQS');
INSERT INTO `t_region` VALUES ('1534', '350182', '长乐市', '150', '0', '0', 'Changle Shi', 'CLS');
INSERT INTO `t_region` VALUES ('1535', '350201', '市辖区', '151', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1536', '350203', '思明区', '151', '0', '0', 'Siming Qu', 'SMQ');
INSERT INTO `t_region` VALUES ('1537', '350205', '海沧区', '151', '0', '0', 'Haicang Qu', '2');
INSERT INTO `t_region` VALUES ('1538', '350206', '湖里区', '151', '0', '0', 'Huli Qu', 'HLQ');
INSERT INTO `t_region` VALUES ('1539', '350211', '集美区', '151', '0', '0', 'Jimei Qu', 'JMQ');
INSERT INTO `t_region` VALUES ('1540', '350212', '同安区', '151', '0', '0', 'Tong,an Qu', 'TAQ');
INSERT INTO `t_region` VALUES ('1541', '350213', '翔安区', '151', '0', '0', 'Xiangan Qu', '2');
INSERT INTO `t_region` VALUES ('1542', '350301', '市辖区', '152', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1543', '350302', '城厢区', '152', '0', '0', 'Chengxiang Qu', 'CXP');
INSERT INTO `t_region` VALUES ('1544', '350303', '涵江区', '152', '0', '0', 'Hanjiang Qu', 'HJQ');
INSERT INTO `t_region` VALUES ('1545', '350304', '荔城区', '152', '0', '0', 'Licheng Qu', '2');
INSERT INTO `t_region` VALUES ('1546', '350305', '秀屿区', '152', '0', '0', 'Xiuyu Qu', '2');
INSERT INTO `t_region` VALUES ('1547', '350322', '仙游县', '152', '0', '0', 'Xianyou Xian', 'XYF');
INSERT INTO `t_region` VALUES ('1548', '350401', '市辖区', '153', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1549', '350402', '梅列区', '153', '0', '0', 'Meilie Qu', 'MLQ');
INSERT INTO `t_region` VALUES ('1550', '350403', '三元区', '153', '0', '0', 'Sanyuan Qu', 'SYB');
INSERT INTO `t_region` VALUES ('1551', '350421', '明溪县', '153', '0', '0', 'Mingxi Xian', 'MXI');
INSERT INTO `t_region` VALUES ('1552', '350423', '清流县', '153', '0', '0', 'Qingliu Xian', 'QLX');
INSERT INTO `t_region` VALUES ('1553', '350424', '宁化县', '153', '0', '0', 'Ninghua Xian', 'NGH');
INSERT INTO `t_region` VALUES ('1554', '350425', '大田县', '153', '0', '0', 'Datian Xian', 'DTM');
INSERT INTO `t_region` VALUES ('1555', '350426', '尤溪县', '153', '0', '0', 'Youxi Xian', 'YXF');
INSERT INTO `t_region` VALUES ('1556', '350427', '沙县', '153', '0', '0', 'Sha Xian', 'SAX');
INSERT INTO `t_region` VALUES ('1557', '350428', '将乐县', '153', '0', '0', 'Jiangle Xian', 'JLE');
INSERT INTO `t_region` VALUES ('1558', '350429', '泰宁县', '153', '0', '0', 'Taining Xian', 'TNG');
INSERT INTO `t_region` VALUES ('1559', '350430', '建宁县', '153', '0', '0', 'Jianning Xian', 'JNF');
INSERT INTO `t_region` VALUES ('1560', '350481', '永安市', '153', '0', '0', 'Yong,an Shi', 'YAF');
INSERT INTO `t_region` VALUES ('1561', '350501', '市辖区', '154', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1562', '350502', '鲤城区', '154', '0', '0', 'Licheng Qu', 'LCQ');
INSERT INTO `t_region` VALUES ('1563', '350503', '丰泽区', '154', '0', '0', 'Fengze Qu', 'FZE');
INSERT INTO `t_region` VALUES ('1564', '350504', '洛江区', '154', '0', '0', 'Luojiang Qu', 'LJQ');
INSERT INTO `t_region` VALUES ('1565', '350505', '泉港区', '154', '0', '0', 'Quangang Qu', '2');
INSERT INTO `t_region` VALUES ('1566', '350521', '惠安县', '154', '0', '0', 'Hui,an Xian', 'HAF');
INSERT INTO `t_region` VALUES ('1567', '350524', '安溪县', '154', '0', '0', 'Anxi Xian', 'ANX');
INSERT INTO `t_region` VALUES ('1568', '350525', '永春县', '154', '0', '0', 'Yongchun Xian', 'YCM');
INSERT INTO `t_region` VALUES ('1569', '350526', '德化县', '154', '0', '0', 'Dehua Xian', 'DHA');
INSERT INTO `t_region` VALUES ('1570', '350527', '金门县', '154', '0', '0', 'Jinmen Xian', 'JME');
INSERT INTO `t_region` VALUES ('1571', '350581', '石狮市', '154', '0', '0', 'Shishi Shi', 'SHH');
INSERT INTO `t_region` VALUES ('1572', '350582', '晋江市', '154', '0', '0', 'Jinjiang Shi', 'JJG');
INSERT INTO `t_region` VALUES ('1573', '350583', '南安市', '154', '0', '0', 'Nan,an Shi', 'NAS');
INSERT INTO `t_region` VALUES ('1574', '350601', '市辖区', '155', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1575', '350602', '芗城区', '155', '0', '0', 'Xiangcheng Qu', 'XZZ');
INSERT INTO `t_region` VALUES ('1576', '350603', '龙文区', '155', '0', '0', 'Longwen Qu', 'LWZ');
INSERT INTO `t_region` VALUES ('1577', '350622', '云霄县', '155', '0', '0', 'Yunxiao Xian', 'YXO');
INSERT INTO `t_region` VALUES ('1578', '350623', '漳浦县', '155', '0', '0', 'Zhangpu Xian', 'ZPU');
INSERT INTO `t_region` VALUES ('1579', '350624', '诏安县', '155', '0', '0', 'Zhao,an Xian', 'ZAF');
INSERT INTO `t_region` VALUES ('1580', '350625', '长泰县', '155', '0', '0', 'Changtai Xian', 'CTA');
INSERT INTO `t_region` VALUES ('1581', '350626', '东山县', '155', '0', '0', 'Dongshan Xian', 'DSN');
INSERT INTO `t_region` VALUES ('1582', '350627', '南靖县', '155', '0', '0', 'Nanjing Xian', 'NJX');
INSERT INTO `t_region` VALUES ('1583', '350628', '平和县', '155', '0', '0', 'Pinghe Xian', 'PHE');
INSERT INTO `t_region` VALUES ('1584', '350629', '华安县', '155', '0', '0', 'Hua,an Xian', 'HAN');
INSERT INTO `t_region` VALUES ('1585', '350681', '龙海市', '155', '0', '0', 'Longhai Shi', 'LHM');
INSERT INTO `t_region` VALUES ('1586', '350701', '市辖区', '156', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1587', '350702', '延平区', '156', '0', '0', 'Yanping Qu', 'YPQ');
INSERT INTO `t_region` VALUES ('1588', '350721', '顺昌县', '156', '0', '0', 'Shunchang Xian', 'SCG');
INSERT INTO `t_region` VALUES ('1589', '350722', '浦城县', '156', '0', '0', 'Pucheng Xian', 'PCX');
INSERT INTO `t_region` VALUES ('1590', '350723', '光泽县', '156', '0', '0', 'Guangze Xian', 'GZE');
INSERT INTO `t_region` VALUES ('1591', '350724', '松溪县', '156', '0', '0', 'Songxi Xian', 'SOX');
INSERT INTO `t_region` VALUES ('1592', '350725', '政和县', '156', '0', '0', 'Zhenghe Xian', 'ZGH');
INSERT INTO `t_region` VALUES ('1593', '350781', '邵武市', '156', '0', '0', 'Shaowu Shi', 'SWU');
INSERT INTO `t_region` VALUES ('1594', '350782', '武夷山市', '156', '0', '0', 'Wuyishan Shi', 'WUS');
INSERT INTO `t_region` VALUES ('1595', '350783', '建瓯市', '156', '0', '0', 'Jian,ou Shi', 'JOU');
INSERT INTO `t_region` VALUES ('1596', '350784', '建阳市', '156', '0', '0', 'Jianyang Shi', 'JNY');
INSERT INTO `t_region` VALUES ('1597', '350801', '市辖区', '157', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1598', '350802', '新罗区', '157', '0', '0', 'Xinluo Qu', 'XNL');
INSERT INTO `t_region` VALUES ('1599', '350821', '长汀县', '157', '0', '0', 'Changting Xian', 'CTG');
INSERT INTO `t_region` VALUES ('1600', '350822', '永定县', '157', '0', '0', 'Yongding Xian', 'YDI');
INSERT INTO `t_region` VALUES ('1601', '350823', '上杭县', '157', '0', '0', 'Shanghang Xian', 'SHF');
INSERT INTO `t_region` VALUES ('1602', '350824', '武平县', '157', '0', '0', 'Wuping Xian', 'WPG');
INSERT INTO `t_region` VALUES ('1603', '350825', '连城县', '157', '0', '0', 'Liancheng Xian', 'LCF');
INSERT INTO `t_region` VALUES ('1604', '350881', '漳平市', '157', '0', '0', 'Zhangping Xian', 'ZGP');
INSERT INTO `t_region` VALUES ('1605', '350901', '市辖区', '158', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('1606', '350902', '蕉城区', '158', '0', '0', 'Jiaocheng Qu', '2');
INSERT INTO `t_region` VALUES ('1607', '350921', '霞浦县', '158', '0', '0', 'Xiapu Xian', '2');
INSERT INTO `t_region` VALUES ('1608', '350922', '古田县', '158', '0', '0', 'Gutian Xian', '2');
INSERT INTO `t_region` VALUES ('1609', '350923', '屏南县', '158', '0', '0', 'Pingnan Xian', '2');
INSERT INTO `t_region` VALUES ('1610', '350924', '寿宁县', '158', '0', '0', 'Shouning Xian', '2');
INSERT INTO `t_region` VALUES ('1611', '350925', '周宁县', '158', '0', '0', 'Zhouning Xian', '2');
INSERT INTO `t_region` VALUES ('1612', '350926', '柘荣县', '158', '0', '0', 'Zherong Xian', '2');
INSERT INTO `t_region` VALUES ('1613', '350981', '福安市', '158', '0', '0', 'Fu,an Shi', '2');
INSERT INTO `t_region` VALUES ('1614', '350982', '福鼎市', '158', '0', '0', 'Fuding Shi', '2');
INSERT INTO `t_region` VALUES ('1615', '360101', '市辖区', '159', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1616', '360102', '东湖区', '159', '0', '0', 'Donghu Qu', 'DHU');
INSERT INTO `t_region` VALUES ('1617', '360103', '西湖区', '159', '0', '0', 'Xihu Qu ', 'XHQ');
INSERT INTO `t_region` VALUES ('1618', '360104', '青云谱区', '159', '0', '0', 'Qingyunpu Qu', 'QYP');
INSERT INTO `t_region` VALUES ('1619', '360105', '湾里区', '159', '0', '0', 'Wanli Qu', 'WLI');
INSERT INTO `t_region` VALUES ('1620', '360111', '青山湖区', '159', '0', '0', 'Qingshanhu Qu', '2');
INSERT INTO `t_region` VALUES ('1621', '360121', '南昌县', '159', '0', '0', 'Nanchang Xian', 'NCA');
INSERT INTO `t_region` VALUES ('1622', '360122', '新建县', '159', '0', '0', 'Xinjian Xian', 'XJN');
INSERT INTO `t_region` VALUES ('1623', '360123', '安义县', '159', '0', '0', 'Anyi Xian', 'AYI');
INSERT INTO `t_region` VALUES ('1624', '360124', '进贤县', '159', '0', '0', 'Jinxian Xian', 'JXX');
INSERT INTO `t_region` VALUES ('1625', '360201', '市辖区', '160', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1626', '360202', '昌江区', '160', '0', '0', 'Changjiang Qu', 'CJG');
INSERT INTO `t_region` VALUES ('1627', '360203', '珠山区', '160', '0', '0', 'Zhushan Qu', 'ZSJ');
INSERT INTO `t_region` VALUES ('1628', '360222', '浮梁县', '160', '0', '0', 'Fuliang Xian', 'FLX');
INSERT INTO `t_region` VALUES ('1629', '360281', '乐平市', '160', '0', '0', 'Leping Shi', 'LEP');
INSERT INTO `t_region` VALUES ('1630', '360301', '市辖区', '161', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1631', '360302', '安源区', '161', '0', '0', 'Anyuan Qu', 'AYQ');
INSERT INTO `t_region` VALUES ('1632', '360313', '湘东区', '161', '0', '0', 'Xiangdong Qu', 'XDG');
INSERT INTO `t_region` VALUES ('1633', '360321', '莲花县', '161', '0', '0', 'Lianhua Xian', 'LHG');
INSERT INTO `t_region` VALUES ('1634', '360322', '上栗县', '161', '0', '0', 'Shangli Xian', 'SLI');
INSERT INTO `t_region` VALUES ('1635', '360323', '芦溪县', '161', '0', '0', 'Lixi Xian', 'LXP');
INSERT INTO `t_region` VALUES ('1636', '360401', '市辖区', '162', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1637', '360402', '庐山区', '162', '0', '0', 'Lushan Qu', 'LSV');
INSERT INTO `t_region` VALUES ('1638', '360403', '浔阳区', '162', '0', '0', 'Xunyang Qu', 'XYC');
INSERT INTO `t_region` VALUES ('1639', '360421', '九江县', '162', '0', '0', 'Jiujiang Xian', 'JUJ');
INSERT INTO `t_region` VALUES ('1640', '360423', '武宁县', '162', '0', '0', 'Wuning Xian', 'WUN');
INSERT INTO `t_region` VALUES ('1641', '360424', '修水县', '162', '0', '0', 'Xiushui Xian', 'XSG');
INSERT INTO `t_region` VALUES ('1642', '360425', '永修县', '162', '0', '0', 'Yongxiu Xian', 'YOX');
INSERT INTO `t_region` VALUES ('1643', '360426', '德安县', '162', '0', '0', 'De,an Xian', 'DEA');
INSERT INTO `t_region` VALUES ('1644', '360427', '星子县', '162', '0', '0', 'Xingzi Xian', 'XZI');
INSERT INTO `t_region` VALUES ('1645', '360428', '都昌县', '162', '0', '0', 'Duchang Xian', 'DUC');
INSERT INTO `t_region` VALUES ('1646', '360429', '湖口县', '162', '0', '0', 'Hukou Xian', 'HUK');
INSERT INTO `t_region` VALUES ('1647', '360430', '彭泽县', '162', '0', '0', 'Pengze Xian', 'PZE');
INSERT INTO `t_region` VALUES ('1648', '360481', '瑞昌市', '162', '0', '0', 'Ruichang Shi', 'RCG');
INSERT INTO `t_region` VALUES ('1649', '360501', '市辖区', '163', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1650', '360502', '渝水区', '163', '0', '0', 'Yushui Qu', 'YSR');
INSERT INTO `t_region` VALUES ('1651', '360521', '分宜县', '163', '0', '0', 'Fenyi Xian', 'FYI');
INSERT INTO `t_region` VALUES ('1652', '360601', '市辖区', '164', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1653', '360602', '月湖区', '164', '0', '0', 'Yuehu Qu', 'YHY');
INSERT INTO `t_region` VALUES ('1654', '360622', '余江县', '164', '0', '0', 'Yujiang Xian', 'YUJ');
INSERT INTO `t_region` VALUES ('1655', '360681', '贵溪市', '164', '0', '0', 'Guixi Shi', 'GXS');
INSERT INTO `t_region` VALUES ('1656', '360701', '市辖区', '165', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1657', '360702', '章贡区', '165', '0', '0', 'Zhanggong Qu', 'ZGG');
INSERT INTO `t_region` VALUES ('1658', '360721', '赣县', '165', '0', '0', 'Gan Xian', 'GXN');
INSERT INTO `t_region` VALUES ('1659', '360722', '信丰县', '165', '0', '0', 'Xinfeng Xian ', 'XNF');
INSERT INTO `t_region` VALUES ('1660', '360723', '大余县', '165', '0', '0', 'Dayu Xian', 'DYX');
INSERT INTO `t_region` VALUES ('1661', '360724', '上犹县', '165', '0', '0', 'Shangyou Xian', 'SYO');
INSERT INTO `t_region` VALUES ('1662', '360725', '崇义县', '165', '0', '0', 'Chongyi Xian', 'CYX');
INSERT INTO `t_region` VALUES ('1663', '360726', '安远县', '165', '0', '0', 'Anyuan Xian', 'AYN');
INSERT INTO `t_region` VALUES ('1664', '360727', '龙南县', '165', '0', '0', 'Longnan Xian', 'LNX');
INSERT INTO `t_region` VALUES ('1665', '360728', '定南县', '165', '0', '0', 'Dingnan Xian', 'DNN');
INSERT INTO `t_region` VALUES ('1666', '360729', '全南县', '165', '0', '0', 'Quannan Xian', 'QNN');
INSERT INTO `t_region` VALUES ('1667', '360730', '宁都县', '165', '0', '0', 'Ningdu Xian', 'NDU');
INSERT INTO `t_region` VALUES ('1668', '360731', '于都县', '165', '0', '0', 'Yudu Xian', 'YUD');
INSERT INTO `t_region` VALUES ('1669', '360732', '兴国县', '165', '0', '0', 'Xingguo Xian', 'XGG');
INSERT INTO `t_region` VALUES ('1670', '360733', '会昌县', '165', '0', '0', 'Huichang Xian', 'HIC');
INSERT INTO `t_region` VALUES ('1671', '360734', '寻乌县', '165', '0', '0', 'Xunwu Xian', 'XNW');
INSERT INTO `t_region` VALUES ('1672', '360735', '石城县', '165', '0', '0', 'Shicheng Xian', 'SIC');
INSERT INTO `t_region` VALUES ('1673', '360781', '瑞金市', '165', '0', '0', 'Ruijin Shi', 'RJS');
INSERT INTO `t_region` VALUES ('1674', '360782', '南康市', '165', '0', '0', 'Nankang Shi', 'NNK');
INSERT INTO `t_region` VALUES ('1675', '360801', '市辖区', '166', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('1676', '360802', '吉州区', '166', '0', '0', 'Jizhou Qu', '2');
INSERT INTO `t_region` VALUES ('1677', '360803', '青原区', '166', '0', '0', 'Qingyuan Qu', '2');
INSERT INTO `t_region` VALUES ('1678', '360821', '吉安县', '166', '0', '0', 'Ji,an Xian', '2');
INSERT INTO `t_region` VALUES ('1679', '360822', '吉水县', '166', '0', '0', 'Jishui Xian', '2');
INSERT INTO `t_region` VALUES ('1680', '360823', '峡江县', '166', '0', '0', 'Xiajiang Xian', '2');
INSERT INTO `t_region` VALUES ('1681', '360824', '新干县', '166', '0', '0', 'Xingan Xian', '2');
INSERT INTO `t_region` VALUES ('1682', '360825', '永丰县', '166', '0', '0', 'Yongfeng Xian', '2');
INSERT INTO `t_region` VALUES ('1683', '360826', '泰和县', '166', '0', '0', 'Taihe Xian', '2');
INSERT INTO `t_region` VALUES ('1684', '360827', '遂川县', '166', '0', '0', 'Suichuan Xian', '2');
INSERT INTO `t_region` VALUES ('1685', '360828', '万安县', '166', '0', '0', 'Wan,an Xian', '2');
INSERT INTO `t_region` VALUES ('1686', '360829', '安福县', '166', '0', '0', 'Anfu Xian', '2');
INSERT INTO `t_region` VALUES ('1687', '360830', '永新县', '166', '0', '0', 'Yongxin Xian ', '2');
INSERT INTO `t_region` VALUES ('1688', '360881', '井冈山市', '166', '0', '0', 'Jinggangshan Shi', '2');
INSERT INTO `t_region` VALUES ('1689', '360901', '市辖区', '167', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('1690', '360902', '袁州区', '167', '0', '0', 'Yuanzhou Qu', '2');
INSERT INTO `t_region` VALUES ('1691', '360921', '奉新县', '167', '0', '0', 'Fengxin Xian', '2');
INSERT INTO `t_region` VALUES ('1692', '360922', '万载县', '167', '0', '0', 'Wanzai Xian', '2');
INSERT INTO `t_region` VALUES ('1693', '360923', '上高县', '167', '0', '0', 'Shanggao Xian', '2');
INSERT INTO `t_region` VALUES ('1694', '360924', '宜丰县', '167', '0', '0', 'Yifeng Xian', '2');
INSERT INTO `t_region` VALUES ('1695', '360925', '靖安县', '167', '0', '0', 'Jing,an Xian', '2');
INSERT INTO `t_region` VALUES ('1696', '360926', '铜鼓县', '167', '0', '0', 'Tonggu Xian', '2');
INSERT INTO `t_region` VALUES ('1697', '360981', '丰城市', '167', '0', '0', 'Fengcheng Shi', '2');
INSERT INTO `t_region` VALUES ('1698', '360982', '樟树市', '167', '0', '0', 'Zhangshu Shi', '2');
INSERT INTO `t_region` VALUES ('1699', '360983', '高安市', '167', '0', '0', 'Gao,an Shi', '2');
INSERT INTO `t_region` VALUES ('1700', '361001', '市辖区', '168', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('1701', '361002', '临川区', '168', '0', '0', 'Linchuan Qu', '2');
INSERT INTO `t_region` VALUES ('1702', '361021', '南城县', '168', '0', '0', 'Nancheng Xian', '2');
INSERT INTO `t_region` VALUES ('1703', '361022', '黎川县', '168', '0', '0', 'Lichuan Xian', '2');
INSERT INTO `t_region` VALUES ('1704', '361023', '南丰县', '168', '0', '0', 'Nanfeng Xian', '2');
INSERT INTO `t_region` VALUES ('1705', '361024', '崇仁县', '168', '0', '0', 'Chongren Xian', '2');
INSERT INTO `t_region` VALUES ('1706', '361025', '乐安县', '168', '0', '0', 'Le,an Xian', '2');
INSERT INTO `t_region` VALUES ('1707', '361026', '宜黄县', '168', '0', '0', 'Yihuang Xian', '2');
INSERT INTO `t_region` VALUES ('1708', '361027', '金溪县', '168', '0', '0', 'Jinxi Xian', '2');
INSERT INTO `t_region` VALUES ('1709', '361028', '资溪县', '168', '0', '0', 'Zixi Xian', '2');
INSERT INTO `t_region` VALUES ('1710', '361029', '东乡县', '168', '0', '0', 'Dongxiang Xian', '2');
INSERT INTO `t_region` VALUES ('1711', '361030', '广昌县', '168', '0', '0', 'Guangchang Xian', '2');
INSERT INTO `t_region` VALUES ('1712', '361101', '市辖区', '169', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('1713', '361102', '信州区', '169', '0', '0', 'Xinzhou Qu', 'XZQ');
INSERT INTO `t_region` VALUES ('1714', '361121', '上饶县', '169', '0', '0', 'Shangrao Xian ', '2');
INSERT INTO `t_region` VALUES ('1715', '361122', '广丰县', '169', '0', '0', 'Guangfeng Xian', '2');
INSERT INTO `t_region` VALUES ('1716', '361123', '玉山县', '169', '0', '0', 'Yushan Xian', '2');
INSERT INTO `t_region` VALUES ('1717', '361124', '铅山县', '169', '0', '0', 'Qianshan Xian', '2');
INSERT INTO `t_region` VALUES ('1718', '361125', '横峰县', '169', '0', '0', 'Hengfeng Xian', '2');
INSERT INTO `t_region` VALUES ('1719', '361126', '弋阳县', '169', '0', '0', 'Yiyang Xian', '2');
INSERT INTO `t_region` VALUES ('1720', '361127', '余干县', '169', '0', '0', 'Yugan Xian', '2');
INSERT INTO `t_region` VALUES ('1721', '361128', '鄱阳县', '169', '0', '0', 'Poyang Xian', 'PYX');
INSERT INTO `t_region` VALUES ('1722', '361129', '万年县', '169', '0', '0', 'Wannian Xian', '2');
INSERT INTO `t_region` VALUES ('1723', '361130', '婺源县', '169', '0', '0', 'Wuyuan Xian', '2');
INSERT INTO `t_region` VALUES ('1724', '361181', '德兴市', '169', '0', '0', 'Dexing Shi', '2');
INSERT INTO `t_region` VALUES ('1725', '370101', '市辖区', '170', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1726', '370102', '历下区', '170', '0', '0', 'Lixia Qu', 'LXQ');
INSERT INTO `t_region` VALUES ('1727', '370101', '市中区', '170', '0', '0', 'Shizhong Qu', 'SZQ');
INSERT INTO `t_region` VALUES ('1728', '370104', '槐荫区', '170', '0', '0', 'Huaiyin Qu', 'HYF');
INSERT INTO `t_region` VALUES ('1729', '370105', '天桥区', '170', '0', '0', 'Tianqiao Qu', 'TQQ');
INSERT INTO `t_region` VALUES ('1730', '370112', '历城区', '170', '0', '0', 'Licheng Qu', 'LCZ');
INSERT INTO `t_region` VALUES ('1731', '370113', '长清区', '170', '0', '0', 'Changqing Qu', '2');
INSERT INTO `t_region` VALUES ('1732', '370124', '平阴县', '170', '0', '0', 'Pingyin Xian', 'PYL');
INSERT INTO `t_region` VALUES ('1733', '370125', '济阳县', '170', '0', '0', 'Jiyang Xian', 'JYL');
INSERT INTO `t_region` VALUES ('1734', '370126', '商河县', '170', '0', '0', 'Shanghe Xian', 'SGH');
INSERT INTO `t_region` VALUES ('1735', '370181', '章丘市', '170', '0', '0', 'Zhangqiu Shi', 'ZQS');
INSERT INTO `t_region` VALUES ('1736', '370201', '市辖区', '171', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1737', '370202', '市南区', '171', '0', '0', 'Shinan Qu', 'SNQ');
INSERT INTO `t_region` VALUES ('1738', '370203', '市北区', '171', '0', '0', 'Shibei Qu', 'SBQ');
INSERT INTO `t_region` VALUES ('1739', '370205', '四方区', '171', '0', '0', 'Sifang Qu', 'SFQ');
INSERT INTO `t_region` VALUES ('1740', '370211', '黄岛区', '171', '0', '0', 'Huangdao Qu', 'HDO');
INSERT INTO `t_region` VALUES ('1741', '370212', '崂山区', '171', '0', '0', 'Laoshan Qu', 'LQD');
INSERT INTO `t_region` VALUES ('1742', '370213', '李沧区', '171', '0', '0', 'Licang Qu', 'LCT');
INSERT INTO `t_region` VALUES ('1743', '370214', '城阳区', '171', '0', '0', 'Chengyang Qu', 'CEY');
INSERT INTO `t_region` VALUES ('1744', '370281', '胶州市', '171', '0', '0', 'Jiaozhou Shi', 'JZS');
INSERT INTO `t_region` VALUES ('1745', '370282', '即墨市', '171', '0', '0', 'Jimo Shi', 'JMO');
INSERT INTO `t_region` VALUES ('1746', '370283', '平度市', '171', '0', '0', 'Pingdu Shi', 'PDU');
INSERT INTO `t_region` VALUES ('1747', '370284', '胶南市', '171', '0', '0', 'Jiaonan Shi', 'JNS');
INSERT INTO `t_region` VALUES ('1748', '370285', '莱西市', '171', '0', '0', 'Laixi Shi', 'LXE');
INSERT INTO `t_region` VALUES ('1749', '370301', '市辖区', '172', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1750', '370302', '淄川区', '172', '0', '0', 'Zichuan Qu', 'ZCQ');
INSERT INTO `t_region` VALUES ('1751', '370303', '张店区', '172', '0', '0', 'Zhangdian Qu', 'ZDQ');
INSERT INTO `t_region` VALUES ('1752', '370304', '博山区', '172', '0', '0', 'Boshan Qu', 'BSZ');
INSERT INTO `t_region` VALUES ('1753', '370305', '临淄区', '172', '0', '0', 'Linzi Qu', 'LZQ');
INSERT INTO `t_region` VALUES ('1754', '370306', '周村区', '172', '0', '0', 'Zhoucun Qu', 'ZCN');
INSERT INTO `t_region` VALUES ('1755', '370321', '桓台县', '172', '0', '0', 'Huantai Xian', 'HTL');
INSERT INTO `t_region` VALUES ('1756', '370322', '高青县', '172', '0', '0', 'Gaoqing Xian', 'GQG');
INSERT INTO `t_region` VALUES ('1757', '370323', '沂源县', '172', '0', '0', 'Yiyuan Xian', 'YIY');
INSERT INTO `t_region` VALUES ('1758', '370401', '市辖区', '173', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1759', '370402', '市中区', '173', '0', '0', 'Shizhong Qu', 'SZZ');
INSERT INTO `t_region` VALUES ('1760', '370403', '薛城区', '173', '0', '0', 'Xuecheng Qu', 'XEC');
INSERT INTO `t_region` VALUES ('1761', '370404', '峄城区', '173', '0', '0', 'Yicheng Qu', 'YZZ');
INSERT INTO `t_region` VALUES ('1762', '370405', '台儿庄区', '173', '0', '0', 'Tai,erzhuang Qu', 'TEZ');
INSERT INTO `t_region` VALUES ('1763', '370406', '山亭区', '173', '0', '0', 'Shanting Qu', 'STG');
INSERT INTO `t_region` VALUES ('1764', '370481', '滕州市', '173', '0', '0', 'Tengzhou Shi', 'TZO');
INSERT INTO `t_region` VALUES ('1765', '370501', '市辖区', '174', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1766', '370502', '东营区', '174', '0', '0', 'Dongying Qu', 'DYQ');
INSERT INTO `t_region` VALUES ('1767', '370503', '河口区', '174', '0', '0', 'Hekou Qu', 'HKO');
INSERT INTO `t_region` VALUES ('1768', '370521', '垦利县', '174', '0', '0', 'Kenli Xian', 'KLI');
INSERT INTO `t_region` VALUES ('1769', '370522', '利津县', '174', '0', '0', 'Lijin Xian', 'LJN');
INSERT INTO `t_region` VALUES ('1770', '370523', '广饶县', '174', '0', '0', 'Guangrao Xian ', 'GRO');
INSERT INTO `t_region` VALUES ('1771', '370601', '市辖区', '175', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1772', '370602', '芝罘区', '175', '0', '0', 'Zhifu Qu', 'ZFQ');
INSERT INTO `t_region` VALUES ('1773', '370611', '福山区', '175', '0', '0', 'Fushan Qu', 'FUS');
INSERT INTO `t_region` VALUES ('1774', '370612', '牟平区', '175', '0', '0', 'Muping Qu', 'MPQ');
INSERT INTO `t_region` VALUES ('1775', '370613', '莱山区', '175', '0', '0', 'Laishan Qu', 'LYT');
INSERT INTO `t_region` VALUES ('1776', '370634', '长岛县', '175', '0', '0', 'Changdao Xian', 'CDO');
INSERT INTO `t_region` VALUES ('1777', '370681', '龙口市', '175', '0', '0', 'Longkou Shi', 'LKU');
INSERT INTO `t_region` VALUES ('1778', '370682', '莱阳市', '175', '0', '0', 'Laiyang Shi', 'LYD');
INSERT INTO `t_region` VALUES ('1779', '370683', '莱州市', '175', '0', '0', 'Laizhou Shi', 'LZG');
INSERT INTO `t_region` VALUES ('1780', '370684', '蓬莱市', '175', '0', '0', 'Penglai Shi', 'PLI');
INSERT INTO `t_region` VALUES ('1781', '370685', '招远市', '175', '0', '0', 'Zhaoyuan Shi', 'ZYL');
INSERT INTO `t_region` VALUES ('1782', '370686', '栖霞市', '175', '0', '0', 'Qixia Shi', 'QXS');
INSERT INTO `t_region` VALUES ('1783', '370687', '海阳市', '175', '0', '0', 'Haiyang Shi', 'HYL');
INSERT INTO `t_region` VALUES ('1784', '370701', '市辖区', '176', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1785', '370702', '潍城区', '176', '0', '0', 'Weicheng Qu', 'WCG');
INSERT INTO `t_region` VALUES ('1786', '370703', '寒亭区', '176', '0', '0', 'Hanting Qu', 'HNT');
INSERT INTO `t_region` VALUES ('1787', '370704', '坊子区', '176', '0', '0', 'Fangzi Qu', 'FZQ');
INSERT INTO `t_region` VALUES ('1788', '370705', '奎文区', '176', '0', '0', 'Kuiwen Qu', 'KWN');
INSERT INTO `t_region` VALUES ('1789', '370724', '临朐县', '176', '0', '0', 'Linqu Xian', 'LNQ');
INSERT INTO `t_region` VALUES ('1790', '370725', '昌乐县', '176', '0', '0', 'Changle Xian', 'CLX');
INSERT INTO `t_region` VALUES ('1791', '370781', '青州市', '176', '0', '0', 'Qingzhou Shi', 'QGZ');
INSERT INTO `t_region` VALUES ('1792', '370782', '诸城市', '176', '0', '0', 'Zhucheng Shi', 'ZCL');
INSERT INTO `t_region` VALUES ('1793', '370783', '寿光市', '176', '0', '0', 'Shouguang Shi', 'SGG');
INSERT INTO `t_region` VALUES ('1794', '370784', '安丘市', '176', '0', '0', 'Anqiu Shi', 'AQU');
INSERT INTO `t_region` VALUES ('1795', '370785', '高密市', '176', '0', '0', 'Gaomi Shi', 'GMI');
INSERT INTO `t_region` VALUES ('1796', '370786', '昌邑市', '176', '0', '0', 'Changyi Shi', 'CYL');
INSERT INTO `t_region` VALUES ('1797', '370801', '市辖区', '177', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1798', '370802', '市中区', '177', '0', '0', 'Shizhong Qu', 'SZU');
INSERT INTO `t_region` VALUES ('1799', '370811', '任城区', '177', '0', '0', 'Rencheng Qu', 'RCQ');
INSERT INTO `t_region` VALUES ('1800', '370826', '微山县', '177', '0', '0', 'Weishan Xian', 'WSA');
INSERT INTO `t_region` VALUES ('1801', '370827', '鱼台县', '177', '0', '0', 'Yutai Xian', 'YTL');
INSERT INTO `t_region` VALUES ('1802', '370828', '金乡县', '177', '0', '0', 'Jinxiang Xian', 'JXG');
INSERT INTO `t_region` VALUES ('1803', '370829', '嘉祥县', '177', '0', '0', 'Jiaxiang Xian', 'JXP');
INSERT INTO `t_region` VALUES ('1804', '370830', '汶上县', '177', '0', '0', 'Wenshang Xian', 'WNS');
INSERT INTO `t_region` VALUES ('1805', '370831', '泗水县', '177', '0', '0', 'Sishui Xian', 'SSH');
INSERT INTO `t_region` VALUES ('1806', '370832', '梁山县', '177', '0', '0', 'Liangshan Xian', 'LSN');
INSERT INTO `t_region` VALUES ('1807', '370881', '曲阜市', '177', '0', '0', 'Qufu Shi', 'QFU');
INSERT INTO `t_region` VALUES ('1808', '370882', '兖州市', '177', '0', '0', 'Yanzhou Shi', 'YZL');
INSERT INTO `t_region` VALUES ('1809', '370883', '邹城市', '177', '0', '0', 'Zoucheng Shi', 'ZCG');
INSERT INTO `t_region` VALUES ('1810', '370901', '市辖区', '178', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1811', '370902', '泰山区', '178', '0', '0', 'Taishan Qu', 'TSQ');
INSERT INTO `t_region` VALUES ('1812', '370911', '岱岳区', '178', '0', '0', 'Daiyue Qu', '2');
INSERT INTO `t_region` VALUES ('1813', '370921', '宁阳县', '178', '0', '0', 'Ningyang Xian', 'NGY');
INSERT INTO `t_region` VALUES ('1814', '370923', '东平县', '178', '0', '0', 'Dongping Xian', 'DPG');
INSERT INTO `t_region` VALUES ('1815', '370982', '新泰市', '178', '0', '0', 'Xintai Shi', 'XTA');
INSERT INTO `t_region` VALUES ('1816', '370983', '肥城市', '178', '0', '0', 'Feicheng Shi', 'FEC');
INSERT INTO `t_region` VALUES ('1817', '371001', '市辖区', '179', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1818', '371002', '环翠区', '179', '0', '0', 'Huancui Qu', 'HNC');
INSERT INTO `t_region` VALUES ('1819', '371081', '文登市', '179', '0', '0', 'Wendeng Shi', 'WDS');
INSERT INTO `t_region` VALUES ('1820', '371082', '荣成市', '179', '0', '0', 'Rongcheng Shi', '2');
INSERT INTO `t_region` VALUES ('1821', '371083', '乳山市', '179', '0', '0', 'Rushan Shi', 'RSN');
INSERT INTO `t_region` VALUES ('1822', '371101', '市辖区', '180', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1823', '371102', '东港区', '180', '0', '0', 'Donggang Qu', 'DGR');
INSERT INTO `t_region` VALUES ('1824', '371103', '岚山区', '180', '0', '0', 'Lanshan Qu', '2');
INSERT INTO `t_region` VALUES ('1825', '371121', '五莲县', '180', '0', '0', 'Wulian Xian', 'WLN');
INSERT INTO `t_region` VALUES ('1826', '371122', '莒县', '180', '0', '0', 'Ju Xian', 'JUX');
INSERT INTO `t_region` VALUES ('1827', '371201', '市辖区', '181', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1828', '371202', '莱城区', '181', '0', '0', 'Laicheng Qu', 'LAC');
INSERT INTO `t_region` VALUES ('1829', '371203', '钢城区', '181', '0', '0', 'Gangcheng Qu', 'GCQ');
INSERT INTO `t_region` VALUES ('1830', '371301', '市辖区', '182', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1831', '371302', '兰山区', '182', '0', '0', 'Lanshan Qu', 'LLS');
INSERT INTO `t_region` VALUES ('1832', '371311', '罗庄区', '182', '0', '0', 'Luozhuang Qu', 'LZU');
INSERT INTO `t_region` VALUES ('1833', '371301', '河东区', '182', '0', '0', 'Hedong Qu', '2');
INSERT INTO `t_region` VALUES ('1834', '371321', '沂南县', '182', '0', '0', 'Yinan Xian', 'YNN');
INSERT INTO `t_region` VALUES ('1835', '371322', '郯城县', '182', '0', '0', 'Tancheng Xian', 'TCE');
INSERT INTO `t_region` VALUES ('1836', '371323', '沂水县', '182', '0', '0', 'Yishui Xian', 'YIS');
INSERT INTO `t_region` VALUES ('1837', '371324', '苍山县', '182', '0', '0', 'Cangshan Xian', 'CSH');
INSERT INTO `t_region` VALUES ('1838', '371325', '费县', '182', '0', '0', 'Fei Xian', 'FEI');
INSERT INTO `t_region` VALUES ('1839', '371326', '平邑县', '182', '0', '0', 'Pingyi Xian', 'PYI');
INSERT INTO `t_region` VALUES ('1840', '371327', '莒南县', '182', '0', '0', 'Junan Xian', 'JNB');
INSERT INTO `t_region` VALUES ('1841', '371328', '蒙阴县', '182', '0', '0', 'Mengyin Xian', 'MYL');
INSERT INTO `t_region` VALUES ('1842', '371329', '临沭县', '182', '0', '0', 'Linshu Xian', 'LSP');
INSERT INTO `t_region` VALUES ('1843', '371401', '市辖区', '183', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1844', '371402', '德城区', '183', '0', '0', 'Decheng Qu', 'DCD');
INSERT INTO `t_region` VALUES ('1845', '371421', '陵县', '183', '0', '0', 'Ling Xian', 'LXL');
INSERT INTO `t_region` VALUES ('1846', '371422', '宁津县', '183', '0', '0', 'Ningjin Xian', 'NGJ');
INSERT INTO `t_region` VALUES ('1847', '371423', '庆云县', '183', '0', '0', 'Qingyun Xian', 'QYL');
INSERT INTO `t_region` VALUES ('1848', '371424', '临邑县', '183', '0', '0', 'Linyi xian', 'LYM');
INSERT INTO `t_region` VALUES ('1849', '371425', '齐河县', '183', '0', '0', 'Qihe Xian', 'QIH');
INSERT INTO `t_region` VALUES ('1850', '371426', '平原县', '183', '0', '0', 'Pingyuan Xian', 'PYN');
INSERT INTO `t_region` VALUES ('1851', '371427', '夏津县', '183', '0', '0', 'Xiajin Xian', 'XAJ');
INSERT INTO `t_region` VALUES ('1852', '371428', '武城县', '183', '0', '0', 'Wucheng Xian', 'WUC');
INSERT INTO `t_region` VALUES ('1853', '371481', '乐陵市', '183', '0', '0', 'Leling Shi', 'LEL');
INSERT INTO `t_region` VALUES ('1854', '371482', '禹城市', '183', '0', '0', 'Yucheng Shi', 'YCL');
INSERT INTO `t_region` VALUES ('1855', '371501', '市辖区', '184', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1856', '371502', '东昌府区', '184', '0', '0', 'Dongchangfu Qu', 'DCF');
INSERT INTO `t_region` VALUES ('1857', '371521', '阳谷县', '184', '0', '0', 'Yanggu Xian ', 'YGU');
INSERT INTO `t_region` VALUES ('1858', '371522', '莘县', '184', '0', '0', 'Shen Xian', 'SHN');
INSERT INTO `t_region` VALUES ('1859', '371523', '茌平县', '184', '0', '0', 'Chiping Xian ', 'CPG');
INSERT INTO `t_region` VALUES ('1860', '371524', '东阿县', '184', '0', '0', 'Dong,e Xian', 'DGE');
INSERT INTO `t_region` VALUES ('1861', '371525', '冠县', '184', '0', '0', 'Guan Xian', 'GXL');
INSERT INTO `t_region` VALUES ('1862', '371526', '高唐县', '184', '0', '0', 'Gaotang Xian', 'GTG');
INSERT INTO `t_region` VALUES ('1863', '371581', '临清市', '184', '0', '0', 'Linqing Xian', 'LQS');
INSERT INTO `t_region` VALUES ('1864', '371601', '市辖区', '185', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('1865', '371602', '滨城区', '185', '0', '0', 'Bincheng Qu', '2');
INSERT INTO `t_region` VALUES ('1866', '371621', '惠民县', '185', '0', '0', 'Huimin Xian', '2');
INSERT INTO `t_region` VALUES ('1867', '371622', '阳信县', '185', '0', '0', 'Yangxin Xian', '2');
INSERT INTO `t_region` VALUES ('1868', '371623', '无棣县', '185', '0', '0', 'Wudi Xian', '2');
INSERT INTO `t_region` VALUES ('1869', '371624', '沾化县', '185', '0', '0', 'Zhanhua Xian', '2');
INSERT INTO `t_region` VALUES ('1870', '371625', '博兴县', '185', '0', '0', 'Boxing Xian', '2');
INSERT INTO `t_region` VALUES ('1871', '371626', '邹平县', '185', '0', '0', 'Zouping Xian', '2');
INSERT INTO `t_region` VALUES ('1873', '371702', '牡丹区', '186', '0', '0', 'Mudan Qu', '2');
INSERT INTO `t_region` VALUES ('1874', '371721', '曹县', '186', '0', '0', 'Cao Xian', '2');
INSERT INTO `t_region` VALUES ('1875', '371722', '单县', '186', '0', '0', 'Shan Xian', '2');
INSERT INTO `t_region` VALUES ('1876', '371723', '成武县', '186', '0', '0', 'Chengwu Xian', '2');
INSERT INTO `t_region` VALUES ('1877', '371724', '巨野县', '186', '0', '0', 'Juye Xian', '2');
INSERT INTO `t_region` VALUES ('1878', '371725', '郓城县', '186', '0', '0', 'Yuncheng Xian', '2');
INSERT INTO `t_region` VALUES ('1879', '371726', '鄄城县', '186', '0', '0', 'Juancheng Xian', '2');
INSERT INTO `t_region` VALUES ('1880', '371727', '定陶县', '186', '0', '0', 'Dingtao Xian', '2');
INSERT INTO `t_region` VALUES ('1881', '371728', '东明县', '186', '0', '0', 'Dongming Xian', '2');
INSERT INTO `t_region` VALUES ('1882', '410101', '市辖区', '187', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1883', '410102', '中原区', '187', '0', '0', 'Zhongyuan Qu', 'ZYQ');
INSERT INTO `t_region` VALUES ('1884', '410103', '二七区', '187', '0', '0', 'Erqi Qu', 'EQQ');
INSERT INTO `t_region` VALUES ('1885', '410104', '管城回族区', '187', '0', '0', 'Guancheng Huizu Qu', 'GCH');
INSERT INTO `t_region` VALUES ('1886', '410105', '金水区', '187', '0', '0', 'Jinshui Qu', 'JSU');
INSERT INTO `t_region` VALUES ('1887', '410106', '上街区', '187', '0', '0', 'Shangjie Qu', 'SJE');
INSERT INTO `t_region` VALUES ('1888', '410108', '惠济区', '187', '0', '0', 'Mangshan Qu', '2');
INSERT INTO `t_region` VALUES ('1889', '410122', '中牟县', '187', '0', '0', 'Zhongmou Xian', 'ZMO');
INSERT INTO `t_region` VALUES ('1890', '410181', '巩义市', '187', '0', '0', 'Gongyi Shi', 'GYI');
INSERT INTO `t_region` VALUES ('1891', '410182', '荥阳市', '187', '0', '0', 'Xingyang Shi', 'XYK');
INSERT INTO `t_region` VALUES ('1892', '410183', '新密市', '187', '0', '0', 'Xinmi Shi', 'XMI');
INSERT INTO `t_region` VALUES ('1893', '410184', '新郑市', '187', '0', '0', 'Xinzheng Shi', 'XZG');
INSERT INTO `t_region` VALUES ('1894', '410185', '登封市', '187', '0', '0', 'Dengfeng Shi', '2');
INSERT INTO `t_region` VALUES ('1895', '410201', '市辖区', '188', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1896', '410202', '龙亭区', '188', '0', '0', 'Longting Qu', 'LTK');
INSERT INTO `t_region` VALUES ('1897', '410203', '顺河回族区', '188', '0', '0', 'Shunhe Huizu Qu', 'SHR');
INSERT INTO `t_region` VALUES ('1898', '410204', '鼓楼区', '188', '0', '0', 'Gulou Qu', 'GLK');
INSERT INTO `t_region` VALUES ('1899', '410205', '禹王台区', '188', '0', '0', 'Yuwangtai Qu', '2');
INSERT INTO `t_region` VALUES ('1900', '410211', '金明区', '188', '0', '0', 'Jinming Qu', '2');
INSERT INTO `t_region` VALUES ('1901', '410221', '杞县', '188', '0', '0', 'Qi Xian', 'QIX');
INSERT INTO `t_region` VALUES ('1902', '410222', '通许县', '188', '0', '0', 'Tongxu Xian', 'TXY');
INSERT INTO `t_region` VALUES ('1903', '410223', '尉氏县', '188', '0', '0', 'Weishi Xian', 'WSI');
INSERT INTO `t_region` VALUES ('1904', '410224', '开封县', '188', '0', '0', 'Kaifeng Xian', 'KFX');
INSERT INTO `t_region` VALUES ('1905', '410225', '兰考县', '188', '0', '0', 'Lankao Xian', 'LKA');
INSERT INTO `t_region` VALUES ('1906', '410301', '市辖区', '189', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1907', '410302', '老城区', '189', '0', '0', 'Laocheng Qu', 'LLY');
INSERT INTO `t_region` VALUES ('1908', '410303', '西工区', '189', '0', '0', 'Xigong Qu', 'XGL');
INSERT INTO `t_region` VALUES ('1909', '410304', '瀍河回族区', '189', '0', '0', 'Chanhehuizu Qu', '2');
INSERT INTO `t_region` VALUES ('1910', '410305', '涧西区', '189', '0', '0', 'Jianxi Qu', 'JXL');
INSERT INTO `t_region` VALUES ('1911', '410306', '吉利区', '189', '0', '0', 'Jili Qu', 'JLL');
INSERT INTO `t_region` VALUES ('1912', '410311', '洛龙区', '189', '0', '0', 'Luolong Qu', '2');
INSERT INTO `t_region` VALUES ('1913', '410322', '孟津县', '189', '0', '0', 'Mengjin Xian', 'MGJ');
INSERT INTO `t_region` VALUES ('1914', '410323', '新安县', '189', '0', '0', 'Xin,an Xian', 'XAX');
INSERT INTO `t_region` VALUES ('1915', '410324', '栾川县', '189', '0', '0', 'Luanchuan Xian', 'LCK');
INSERT INTO `t_region` VALUES ('1916', '410325', '嵩县', '189', '0', '0', 'Song Xian', 'SON');
INSERT INTO `t_region` VALUES ('1917', '410326', '汝阳县', '189', '0', '0', 'Ruyang Xian', 'RUY');
INSERT INTO `t_region` VALUES ('1918', '410327', '宜阳县', '189', '0', '0', 'Yiyang Xian', 'YYY');
INSERT INTO `t_region` VALUES ('1919', '410328', '洛宁县', '189', '0', '0', 'Luoning Xian', 'LNI');
INSERT INTO `t_region` VALUES ('1920', '410329', '伊川县', '189', '0', '0', 'Yichuan Xian', 'YCZ');
INSERT INTO `t_region` VALUES ('1921', '410381', '偃师市', '189', '0', '0', 'Yanshi Shi', 'YST');
INSERT INTO `t_region` VALUES ('1922', '410401', '市辖区', '190', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1923', '410402', '新华区', '190', '0', '0', 'Xinhua Qu', 'XHP');
INSERT INTO `t_region` VALUES ('1924', '410403', '卫东区', '190', '0', '0', 'Weidong Qu', 'WDG');
INSERT INTO `t_region` VALUES ('1925', '410404', '石龙区', '190', '0', '0', 'Shilong Qu', 'SIL');
INSERT INTO `t_region` VALUES ('1926', '410411', '湛河区', '190', '0', '0', 'Zhanhe Qu', 'ZHQ');
INSERT INTO `t_region` VALUES ('1927', '410421', '宝丰县', '190', '0', '0', 'Baofeng Xian', 'BFG');
INSERT INTO `t_region` VALUES ('1928', '410422', '叶县', '190', '0', '0', 'Ye Xian', 'YEX');
INSERT INTO `t_region` VALUES ('1929', '410423', '鲁山县', '190', '0', '0', 'Lushan Xian', 'LUS');
INSERT INTO `t_region` VALUES ('1930', '410425', '郏县', '190', '0', '0', 'Jia Xian', 'JXY');
INSERT INTO `t_region` VALUES ('1931', '410481', '舞钢市', '190', '0', '0', 'Wugang Shi', 'WGY');
INSERT INTO `t_region` VALUES ('1932', '410482', '汝州市', '190', '0', '0', 'Ruzhou Shi', 'RZO');
INSERT INTO `t_region` VALUES ('1933', '410501', '市辖区', '191', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1934', '410502', '文峰区', '191', '0', '0', 'Wenfeng Qu', 'WFQ');
INSERT INTO `t_region` VALUES ('1935', '410503', '北关区', '191', '0', '0', 'Beiguan Qu', 'BGQ');
INSERT INTO `t_region` VALUES ('1936', '410505', '殷都区', '191', '0', '0', 'Yindu Qu', '2');
INSERT INTO `t_region` VALUES ('1937', '410506', '龙安区', '191', '0', '0', 'Longan Qu', '2');
INSERT INTO `t_region` VALUES ('1938', '410522', '安阳县', '191', '0', '0', 'Anyang Xian', 'AYX');
INSERT INTO `t_region` VALUES ('1939', '410523', '汤阴县', '191', '0', '0', 'Tangyin Xian', 'TYI');
INSERT INTO `t_region` VALUES ('1940', '410526', '滑县', '191', '0', '0', 'Hua Xian', 'HUA');
INSERT INTO `t_region` VALUES ('1941', '410527', '内黄县', '191', '0', '0', 'Neihuang Xian', 'NHG');
INSERT INTO `t_region` VALUES ('1942', '410581', '林州市', '191', '0', '0', 'Linzhou Shi', 'LZY');
INSERT INTO `t_region` VALUES ('1943', '410601', '市辖区', '192', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1944', '410602', '鹤山区', '192', '0', '0', 'Heshan Qu', 'HSF');
INSERT INTO `t_region` VALUES ('1945', '410603', '山城区', '192', '0', '0', 'Shancheng Qu', 'SCB');
INSERT INTO `t_region` VALUES ('1946', '410611', '淇滨区', '192', '0', '0', 'Qibin Qu', '2');
INSERT INTO `t_region` VALUES ('1947', '410621', '浚县', '192', '0', '0', 'Xun Xian', 'XUX');
INSERT INTO `t_region` VALUES ('1948', '410622', '淇县', '192', '0', '0', 'Qi Xian', 'QXY');
INSERT INTO `t_region` VALUES ('1949', '410701', '市辖区', '193', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1950', '410702', '红旗区', '193', '0', '0', 'Hongqi Qu', 'HQQ');
INSERT INTO `t_region` VALUES ('1951', '410703', '卫滨区', '193', '0', '0', 'Weibin Qu', '2');
INSERT INTO `t_region` VALUES ('1952', '410704', '凤泉区', '193', '0', '0', 'Fengquan Qu', '2');
INSERT INTO `t_region` VALUES ('1953', '410711', '牧野区', '193', '0', '0', 'Muye Qu', '2');
INSERT INTO `t_region` VALUES ('1954', '410721', '新乡县', '193', '0', '0', 'Xinxiang Xian', 'XXX');
INSERT INTO `t_region` VALUES ('1955', '410724', '获嘉县', '193', '0', '0', 'Huojia Xian', 'HOJ');
INSERT INTO `t_region` VALUES ('1956', '410725', '原阳县', '193', '0', '0', 'Yuanyang Xian', 'YYA');
INSERT INTO `t_region` VALUES ('1957', '410726', '延津县', '193', '0', '0', 'Yanjin Xian', 'YJN');
INSERT INTO `t_region` VALUES ('1958', '410727', '封丘县', '193', '0', '0', 'Fengqiu Xian', 'FQU');
INSERT INTO `t_region` VALUES ('1959', '410728', '长垣县', '193', '0', '0', 'Changyuan Xian', 'CYU');
INSERT INTO `t_region` VALUES ('1960', '410781', '卫辉市', '193', '0', '0', 'Weihui Shi', 'WHS');
INSERT INTO `t_region` VALUES ('1961', '410782', '辉县市', '193', '0', '0', 'Huixian Shi', 'HXS');
INSERT INTO `t_region` VALUES ('1962', '410801', '市辖区', '194', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1963', '410802', '解放区', '194', '0', '0', 'Jiefang Qu', 'JFQ');
INSERT INTO `t_region` VALUES ('1964', '410803', '中站区', '194', '0', '0', 'Zhongzhan Qu', 'ZZQ');
INSERT INTO `t_region` VALUES ('1965', '410804', '马村区', '194', '0', '0', 'Macun Qu', 'MCQ');
INSERT INTO `t_region` VALUES ('1966', '410811', '山阳区', '194', '0', '0', 'Shanyang Qu', 'SYC');
INSERT INTO `t_region` VALUES ('1967', '410821', '修武县', '194', '0', '0', 'Xiuwu Xian', 'XUW');
INSERT INTO `t_region` VALUES ('1968', '410822', '博爱县', '194', '0', '0', 'Bo,ai Xian', 'BOA');
INSERT INTO `t_region` VALUES ('1969', '410823', '武陟县', '194', '0', '0', 'Wuzhi Xian', 'WZI');
INSERT INTO `t_region` VALUES ('1970', '410825', '温县', '194', '0', '0', 'Wen Xian', 'WEN');
INSERT INTO `t_region` VALUES ('1971', '419001', '济源市', '194', '0', '0', 'Jiyuan Shi', '2');
INSERT INTO `t_region` VALUES ('1972', '410882', '沁阳市', '194', '0', '0', 'Qinyang Shi', 'QYS');
INSERT INTO `t_region` VALUES ('1973', '410883', '孟州市', '194', '0', '0', 'Mengzhou Shi', 'MZO');
INSERT INTO `t_region` VALUES ('1974', '410901', '市辖区', '195', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1975', '410902', '华龙区', '195', '0', '0', 'Hualong Qu', '2');
INSERT INTO `t_region` VALUES ('1976', '410922', '清丰县', '195', '0', '0', 'Qingfeng Xian', 'QFG');
INSERT INTO `t_region` VALUES ('1977', '410923', '南乐县', '195', '0', '0', 'Nanle Xian', 'NLE');
INSERT INTO `t_region` VALUES ('1978', '410926', '范县', '195', '0', '0', 'Fan Xian', 'FAX');
INSERT INTO `t_region` VALUES ('1979', '410927', '台前县', '195', '0', '0', 'Taiqian Xian', 'TQN');
INSERT INTO `t_region` VALUES ('1980', '410928', '濮阳县', '195', '0', '0', 'Puyang Xian', 'PUY');
INSERT INTO `t_region` VALUES ('1981', '411001', '市辖区', '196', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1982', '411002', '魏都区', '196', '0', '0', 'Weidu Qu', 'WED');
INSERT INTO `t_region` VALUES ('1983', '411023', '许昌县', '196', '0', '0', 'Xuchang Xian', 'XUC');
INSERT INTO `t_region` VALUES ('1984', '411024', '鄢陵县', '196', '0', '0', 'Yanling Xian', 'YLY');
INSERT INTO `t_region` VALUES ('1985', '411025', '襄城县', '196', '0', '0', 'Xiangcheng Xian', 'XAC');
INSERT INTO `t_region` VALUES ('1986', '411081', '禹州市', '196', '0', '0', 'Yuzhou Shi', 'YUZ');
INSERT INTO `t_region` VALUES ('1987', '411082', '长葛市', '196', '0', '0', 'Changge Shi', 'CGE');
INSERT INTO `t_region` VALUES ('1988', '411101', '市辖区', '197', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1989', '411102', '源汇区', '197', '0', '0', 'Yuanhui Qu', 'YHI');
INSERT INTO `t_region` VALUES ('1990', '411103', '郾城区', '197', '0', '0', 'Yancheng Qu', '2');
INSERT INTO `t_region` VALUES ('1991', '411104', '召陵区', '197', '0', '0', 'Zhaoling Qu', '2');
INSERT INTO `t_region` VALUES ('1992', '411121', '舞阳县', '197', '0', '0', 'Wuyang Xian', 'WYG');
INSERT INTO `t_region` VALUES ('1993', '411122', '临颍县', '197', '0', '0', 'Linying Xian', 'LNY');
INSERT INTO `t_region` VALUES ('1994', '411201', '市辖区', '198', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('1995', '411202', '湖滨区', '198', '0', '0', 'Hubin Qu', 'HBI');
INSERT INTO `t_region` VALUES ('1996', '411221', '渑池县', '198', '0', '0', 'Mianchi Xian', 'MCI');
INSERT INTO `t_region` VALUES ('1997', '411222', '陕县', '198', '0', '0', 'Shan Xian', 'SHX');
INSERT INTO `t_region` VALUES ('1998', '411224', '卢氏县', '198', '0', '0', 'Lushi Xian', 'LUU');
INSERT INTO `t_region` VALUES ('1999', '411281', '义马市', '198', '0', '0', 'Yima Shi', 'YMA');
INSERT INTO `t_region` VALUES ('2000', '411282', '灵宝市', '198', '0', '0', 'Lingbao Shi', 'LBS');
INSERT INTO `t_region` VALUES ('2001', '411301', '市辖区', '199', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2002', '411302', '宛城区', '199', '0', '0', 'Wancheng Qu', 'WCN');
INSERT INTO `t_region` VALUES ('2003', '411303', '卧龙区', '199', '0', '0', 'Wolong Qu', 'WOL');
INSERT INTO `t_region` VALUES ('2004', '411321', '南召县', '199', '0', '0', 'Nanzhao Xian', 'NZO');
INSERT INTO `t_region` VALUES ('2005', '411322', '方城县', '199', '0', '0', 'Fangcheng Xian', 'FCX');
INSERT INTO `t_region` VALUES ('2006', '411323', '西峡县', '199', '0', '0', 'Xixia Xian', 'XXY');
INSERT INTO `t_region` VALUES ('2007', '411324', '镇平县', '199', '0', '0', 'Zhenping Xian', 'ZPX');
INSERT INTO `t_region` VALUES ('2008', '411325', '内乡县', '199', '0', '0', 'Neixiang Xian', 'NXG');
INSERT INTO `t_region` VALUES ('2009', '411326', '淅川县', '199', '0', '0', 'Xichuan Xian', 'XCY');
INSERT INTO `t_region` VALUES ('2010', '411327', '社旗县', '199', '0', '0', 'Sheqi Xian', 'SEQ');
INSERT INTO `t_region` VALUES ('2011', '411328', '唐河县', '199', '0', '0', 'Tanghe Xian', 'TGH');
INSERT INTO `t_region` VALUES ('2012', '411329', '新野县', '199', '0', '0', 'Xinye Xian', 'XYE');
INSERT INTO `t_region` VALUES ('2013', '411330', '桐柏县', '199', '0', '0', 'Tongbai Xian', 'TBX');
INSERT INTO `t_region` VALUES ('2014', '411381', '邓州市', '199', '0', '0', 'Dengzhou Shi', 'DGZ');
INSERT INTO `t_region` VALUES ('2015', '411401', '市辖区', '200', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2016', '411402', '梁园区', '200', '0', '0', 'Liangyuan Qu', 'LYY');
INSERT INTO `t_region` VALUES ('2017', '411403', '睢阳区', '200', '0', '0', 'Suiyang Qu', 'SYA');
INSERT INTO `t_region` VALUES ('2018', '411421', '民权县', '200', '0', '0', 'Minquan Xian', 'MQY');
INSERT INTO `t_region` VALUES ('2019', '411422', '睢县', '200', '0', '0', 'Sui Xian', 'SUI');
INSERT INTO `t_region` VALUES ('2020', '411423', '宁陵县', '200', '0', '0', 'Ningling Xian', 'NGL');
INSERT INTO `t_region` VALUES ('2021', '411424', '柘城县', '200', '0', '0', 'Zhecheng Xian', 'ZHC');
INSERT INTO `t_region` VALUES ('2022', '411425', '虞城县', '200', '0', '0', 'Yucheng Xian', 'YUC');
INSERT INTO `t_region` VALUES ('2023', '411426', '夏邑县', '200', '0', '0', 'Xiayi Xian', 'XAY');
INSERT INTO `t_region` VALUES ('2024', '411481', '永城市', '200', '0', '0', 'Yongcheng Shi', 'YOC');
INSERT INTO `t_region` VALUES ('2025', '411501', '市辖区', '201', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2026', '411502', '浉河区', '201', '0', '0', 'Shihe Qu', 'SHU');
INSERT INTO `t_region` VALUES ('2027', '411503', '平桥区', '201', '0', '0', 'Pingqiao Qu', 'PQQ');
INSERT INTO `t_region` VALUES ('2028', '411521', '罗山县', '201', '0', '0', 'Luoshan Xian', 'LSE');
INSERT INTO `t_region` VALUES ('2029', '411522', '光山县', '201', '0', '0', 'Guangshan Xian', 'GSX');
INSERT INTO `t_region` VALUES ('2030', '411523', '新县', '201', '0', '0', 'Xin Xian', 'XXI');
INSERT INTO `t_region` VALUES ('2031', '411524', '商城县', '201', '0', '0', 'Shangcheng Xian', 'SCX');
INSERT INTO `t_region` VALUES ('2032', '411525', '固始县', '201', '0', '0', 'Gushi Xian', 'GSI');
INSERT INTO `t_region` VALUES ('2033', '411526', '潢川县', '201', '0', '0', 'Huangchuan Xian', 'HCU');
INSERT INTO `t_region` VALUES ('2034', '411527', '淮滨县', '201', '0', '0', 'Huaibin Xian', 'HBN');
INSERT INTO `t_region` VALUES ('2035', '411528', '息县', '201', '0', '0', 'Xi Xian', 'XIX');
INSERT INTO `t_region` VALUES ('2036', '411601', '市辖区', '202', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2037', '411602', '川汇区', '202', '0', '0', 'Chuanhui Qu', '2');
INSERT INTO `t_region` VALUES ('2038', '411621', '扶沟县', '202', '0', '0', 'Fugou Xian', '2');
INSERT INTO `t_region` VALUES ('2039', '411622', '西华县', '202', '0', '0', 'Xihua Xian', '2');
INSERT INTO `t_region` VALUES ('2040', '411623', '商水县', '202', '0', '0', 'Shangshui Xian', '2');
INSERT INTO `t_region` VALUES ('2041', '411624', '沈丘县', '202', '0', '0', 'Shenqiu Xian', '2');
INSERT INTO `t_region` VALUES ('2042', '411625', '郸城县', '202', '0', '0', 'Dancheng Xian', '2');
INSERT INTO `t_region` VALUES ('2043', '411626', '淮阳县', '202', '0', '0', 'Huaiyang Xian', '2');
INSERT INTO `t_region` VALUES ('2044', '411627', '太康县', '202', '0', '0', 'Taikang Xian', '2');
INSERT INTO `t_region` VALUES ('2045', '411628', '鹿邑县', '202', '0', '0', 'Luyi Xian', '2');
INSERT INTO `t_region` VALUES ('2046', '411681', '项城市', '202', '0', '0', 'Xiangcheng Shi', '2');
INSERT INTO `t_region` VALUES ('2047', '411701', '市辖区', '203', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2048', '411702', '驿城区', '203', '0', '0', 'Yicheng Qu', '2');
INSERT INTO `t_region` VALUES ('2049', '411721', '西平县', '203', '0', '0', 'Xiping Xian', '2');
INSERT INTO `t_region` VALUES ('2050', '411722', '上蔡县', '203', '0', '0', 'Shangcai Xian', '2');
INSERT INTO `t_region` VALUES ('2051', '411723', '平舆县', '203', '0', '0', 'Pingyu Xian', '2');
INSERT INTO `t_region` VALUES ('2052', '411724', '正阳县', '203', '0', '0', 'Zhengyang Xian', '2');
INSERT INTO `t_region` VALUES ('2053', '411725', '确山县', '203', '0', '0', 'Queshan Xian', '2');
INSERT INTO `t_region` VALUES ('2054', '411726', '泌阳县', '203', '0', '0', 'Biyang Xian', '2');
INSERT INTO `t_region` VALUES ('2055', '411727', '汝南县', '203', '0', '0', 'Runan Xian', '2');
INSERT INTO `t_region` VALUES ('2056', '411728', '遂平县', '203', '0', '0', 'Suiping Xian', '2');
INSERT INTO `t_region` VALUES ('2057', '411729', '新蔡县', '203', '0', '0', 'Xincai Xian', '2');
INSERT INTO `t_region` VALUES ('2058', '420101', '市辖区', '204', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2059', '420102', '江岸区', '204', '0', '0', 'Jiang,an Qu', 'JAA');
INSERT INTO `t_region` VALUES ('2060', '420103', '江汉区', '204', '0', '0', 'Jianghan Qu', 'JHN');
INSERT INTO `t_region` VALUES ('2061', '420104', '硚口区', '204', '0', '0', 'Qiaokou Qu', 'QKQ');
INSERT INTO `t_region` VALUES ('2062', '420105', '汉阳区', '204', '0', '0', 'Hanyang Qu', 'HYA');
INSERT INTO `t_region` VALUES ('2063', '420106', '武昌区', '204', '0', '0', 'Wuchang Qu', 'WCQ');
INSERT INTO `t_region` VALUES ('2064', '420107', '青山区', '204', '0', '0', 'Qingshan Qu', 'QSN');
INSERT INTO `t_region` VALUES ('2065', '420111', '洪山区', '204', '0', '0', 'Hongshan Qu', 'HSQ');
INSERT INTO `t_region` VALUES ('2066', '420112', '东西湖区', '204', '0', '0', 'Dongxihu Qu', 'DXH');
INSERT INTO `t_region` VALUES ('2067', '420113', '汉南区', '204', '0', '0', 'Hannan Qu', 'HNQ');
INSERT INTO `t_region` VALUES ('2068', '420114', '蔡甸区', '204', '0', '0', 'Caidian Qu', 'CDN');
INSERT INTO `t_region` VALUES ('2069', '420115', '江夏区', '204', '0', '0', 'Jiangxia Qu', 'JXQ');
INSERT INTO `t_region` VALUES ('2070', '420116', '黄陂区', '204', '0', '0', 'Huangpi Qu', 'HPI');
INSERT INTO `t_region` VALUES ('2071', '420117', '新洲区', '204', '0', '0', 'Xinzhou Qu', 'XNZ');
INSERT INTO `t_region` VALUES ('2072', '420201', '市辖区', '205', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2073', '420202', '黄石港区', '205', '0', '0', 'Huangshigang Qu', 'HSG');
INSERT INTO `t_region` VALUES ('2074', '420203', '西塞山区', '205', '0', '0', 'Xisaishan Qu', '2');
INSERT INTO `t_region` VALUES ('2075', '420204', '下陆区', '205', '0', '0', 'Xialu Qu', 'XAL');
INSERT INTO `t_region` VALUES ('2076', '420205', '铁山区', '205', '0', '0', 'Tieshan Qu', 'TSH');
INSERT INTO `t_region` VALUES ('2077', '420222', '阳新县', '205', '0', '0', 'Yangxin Xian', 'YXE');
INSERT INTO `t_region` VALUES ('2078', '420281', '大冶市', '205', '0', '0', 'Daye Shi', 'DYE');
INSERT INTO `t_region` VALUES ('2079', '420301', '市辖区', '206', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2080', '420302', '茅箭区', '206', '0', '0', 'Maojian Qu', 'MJN');
INSERT INTO `t_region` VALUES ('2081', '420303', '张湾区', '206', '0', '0', 'Zhangwan Qu', 'ZWQ');
INSERT INTO `t_region` VALUES ('2082', '420321', '郧县', '206', '0', '0', 'Yun Xian', 'YUN');
INSERT INTO `t_region` VALUES ('2083', '420322', '郧西县', '206', '0', '0', 'Yunxi Xian', 'YNX');
INSERT INTO `t_region` VALUES ('2084', '420323', '竹山县', '206', '0', '0', 'Zhushan Xian', 'ZHS');
INSERT INTO `t_region` VALUES ('2085', '420324', '竹溪县', '206', '0', '0', 'Zhuxi Xian', 'ZXX');
INSERT INTO `t_region` VALUES ('2086', '420325', '房县', '206', '0', '0', 'Fang Xian', 'FAG');
INSERT INTO `t_region` VALUES ('2087', '420381', '丹江口市', '206', '0', '0', 'Danjiangkou Shi', 'DJK');
INSERT INTO `t_region` VALUES ('2088', '420501', '市辖区', '207', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2089', '420502', '西陵区', '207', '0', '0', 'Xiling Qu', 'XLQ');
INSERT INTO `t_region` VALUES ('2090', '420503', '伍家岗区', '207', '0', '0', 'Wujiagang Qu', 'WJG');
INSERT INTO `t_region` VALUES ('2091', '420504', '点军区', '207', '0', '0', 'Dianjun Qu', 'DJN');
INSERT INTO `t_region` VALUES ('2092', '420505', '猇亭区', '207', '0', '0', 'Xiaoting Qu', 'XTQ');
INSERT INTO `t_region` VALUES ('2093', '420506', '夷陵区', '207', '0', '0', 'Yiling Qu', '2');
INSERT INTO `t_region` VALUES ('2094', '420525', '远安县', '207', '0', '0', 'Yuan,an Xian', 'YAX');
INSERT INTO `t_region` VALUES ('2095', '420526', '兴山县', '207', '0', '0', 'Xingshan Xian', 'XSX');
INSERT INTO `t_region` VALUES ('2096', '420527', '秭归县', '207', '0', '0', 'Zigui Xian', 'ZGI');
INSERT INTO `t_region` VALUES ('2097', '420528', '长阳土家族自治县', '207', '0', '0', 'Changyang Tujiazu Zizhixian', 'CYA');
INSERT INTO `t_region` VALUES ('2098', '420529', '五峰土家族自治县', '207', '0', '0', 'Wufeng Tujiazu Zizhixian', 'WFG');
INSERT INTO `t_region` VALUES ('2099', '420581', '宜都市', '207', '0', '0', 'Yidu Shi', 'YID');
INSERT INTO `t_region` VALUES ('2100', '420582', '当阳市', '207', '0', '0', 'Dangyang Shi', 'DYS');
INSERT INTO `t_region` VALUES ('2101', '420583', '枝江市', '207', '0', '0', 'Zhijiang Shi', 'ZIJ');
INSERT INTO `t_region` VALUES ('2102', '420601', '市辖区', '208', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2103', '420602', '襄城区', '208', '0', '0', 'Xiangcheng Qu', 'XXF');
INSERT INTO `t_region` VALUES ('2104', '420606', '樊城区', '208', '0', '0', 'Fancheng Qu', 'FNC');
INSERT INTO `t_region` VALUES ('2105', '420607', '襄阳区', '208', '0', '0', 'Xiangyang Qu', '2');
INSERT INTO `t_region` VALUES ('2106', '420624', '南漳县', '208', '0', '0', 'Nanzhang Xian', 'NZH');
INSERT INTO `t_region` VALUES ('2107', '420625', '谷城县', '208', '0', '0', 'Gucheng Xian', 'GUC');
INSERT INTO `t_region` VALUES ('2108', '420626', '保康县', '208', '0', '0', 'Baokang Xian', 'BKG');
INSERT INTO `t_region` VALUES ('2109', '420682', '老河口市', '208', '0', '0', 'Laohekou Shi', 'LHK');
INSERT INTO `t_region` VALUES ('2110', '420683', '枣阳市', '208', '0', '0', 'Zaoyang Shi', 'ZOY');
INSERT INTO `t_region` VALUES ('2111', '420684', '宜城市', '208', '0', '0', 'Yicheng Shi', 'YCW');
INSERT INTO `t_region` VALUES ('2112', '420701', '市辖区', '209', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2113', '420702', '梁子湖区', '209', '0', '0', 'Liangzihu Qu', 'LZI');
INSERT INTO `t_region` VALUES ('2114', '420703', '华容区', '209', '0', '0', 'Huarong Qu', 'HRQ');
INSERT INTO `t_region` VALUES ('2115', '420704', '鄂城区', '209', '0', '0', 'Echeng Qu', 'ECQ');
INSERT INTO `t_region` VALUES ('2116', '420801', '市辖区', '210', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2117', '420802', '东宝区', '210', '0', '0', 'Dongbao Qu', 'DBQ');
INSERT INTO `t_region` VALUES ('2118', '420804', '掇刀区', '210', '0', '0', 'Duodao Qu', '2');
INSERT INTO `t_region` VALUES ('2119', '420821', '京山县', '210', '0', '0', 'Jingshan Xian', 'JSA');
INSERT INTO `t_region` VALUES ('2120', '420822', '沙洋县', '210', '0', '0', 'Shayang Xian', 'SYF');
INSERT INTO `t_region` VALUES ('2121', '420881', '钟祥市', '210', '0', '0', 'Zhongxiang Shi', '2');
INSERT INTO `t_region` VALUES ('2122', '420901', '市辖区', '211', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2123', '420902', '孝南区', '211', '0', '0', 'Xiaonan Qu', 'XNA');
INSERT INTO `t_region` VALUES ('2124', '420921', '孝昌县', '211', '0', '0', 'Xiaochang Xian', 'XOC');
INSERT INTO `t_region` VALUES ('2125', '420922', '大悟县', '211', '0', '0', 'Dawu Xian', 'DWU');
INSERT INTO `t_region` VALUES ('2126', '420923', '云梦县', '211', '0', '0', 'Yunmeng Xian', 'YMX');
INSERT INTO `t_region` VALUES ('2127', '420981', '应城市', '211', '0', '0', 'Yingcheng Shi', 'YCG');
INSERT INTO `t_region` VALUES ('2128', '420982', '安陆市', '211', '0', '0', 'Anlu Shi', 'ALU');
INSERT INTO `t_region` VALUES ('2129', '420984', '汉川市', '211', '0', '0', 'Hanchuan Shi', 'HCH');
INSERT INTO `t_region` VALUES ('2130', '421001', '市辖区', '212', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2131', '421002', '沙市区', '212', '0', '0', 'Shashi Qu', 'SSJ');
INSERT INTO `t_region` VALUES ('2132', '421003', '荆州区', '212', '0', '0', 'Jingzhou Qu', 'JZQ');
INSERT INTO `t_region` VALUES ('2133', '421022', '公安县', '212', '0', '0', 'Gong,an Xian', 'GGA');
INSERT INTO `t_region` VALUES ('2134', '421023', '监利县', '212', '0', '0', 'Jianli Xian', 'JLI');
INSERT INTO `t_region` VALUES ('2135', '421024', '江陵县', '212', '0', '0', 'Jiangling Xian', 'JLX');
INSERT INTO `t_region` VALUES ('2136', '421081', '石首市', '212', '0', '0', 'Shishou Shi', 'SSO');
INSERT INTO `t_region` VALUES ('2137', '421083', '洪湖市', '212', '0', '0', 'Honghu Shi', 'HHU');
INSERT INTO `t_region` VALUES ('2138', '421087', '松滋市', '212', '0', '0', 'Songzi Shi', 'SZF');
INSERT INTO `t_region` VALUES ('2139', '421101', '市辖区', '213', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2140', '421102', '黄州区', '213', '0', '0', 'Huangzhou Qu', 'HZC');
INSERT INTO `t_region` VALUES ('2141', '421121', '团风县', '213', '0', '0', 'Tuanfeng Xian', 'TFG');
INSERT INTO `t_region` VALUES ('2142', '421122', '红安县', '213', '0', '0', 'Hong,an Xian', 'HGA');
INSERT INTO `t_region` VALUES ('2143', '421123', '罗田县', '213', '0', '0', 'Luotian Xian', 'LTE');
INSERT INTO `t_region` VALUES ('2144', '421124', '英山县', '213', '0', '0', 'Yingshan Xian', 'YSE');
INSERT INTO `t_region` VALUES ('2145', '421125', '浠水县', '213', '0', '0', 'Xishui Xian', 'XSE');
INSERT INTO `t_region` VALUES ('2146', '421126', '蕲春县', '213', '0', '0', 'Qichun Xian', 'QCN');
INSERT INTO `t_region` VALUES ('2147', '421127', '黄梅县', '213', '0', '0', 'Huangmei Xian', 'HGM');
INSERT INTO `t_region` VALUES ('2148', '421181', '麻城市', '213', '0', '0', 'Macheng Shi', 'MCS');
INSERT INTO `t_region` VALUES ('2149', '421182', '武穴市', '213', '0', '0', 'Wuxue Shi', 'WXE');
INSERT INTO `t_region` VALUES ('2150', '421201', '市辖区', '214', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2151', '421202', '咸安区', '214', '0', '0', 'Xian,an Qu', 'XAN');
INSERT INTO `t_region` VALUES ('2152', '421221', '嘉鱼县', '214', '0', '0', 'Jiayu Xian', 'JYX');
INSERT INTO `t_region` VALUES ('2153', '421222', '通城县', '214', '0', '0', 'Tongcheng Xian', 'TCX');
INSERT INTO `t_region` VALUES ('2154', '421223', '崇阳县', '214', '0', '0', 'Chongyang Xian', 'CGY');
INSERT INTO `t_region` VALUES ('2155', '421224', '通山县', '214', '0', '0', 'Tongshan Xian', 'TSA');
INSERT INTO `t_region` VALUES ('2156', '421281', '赤壁市', '214', '0', '0', 'Chibi Shi', 'CBI');
INSERT INTO `t_region` VALUES ('2157', '421301', '市辖区', '215', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2158', '421303', '曾都区', '215', '0', '0', 'Zengdu Qu', '2');
INSERT INTO `t_region` VALUES ('2159', '421381', '广水市', '215', '0', '0', 'Guangshui Shi', '2');
INSERT INTO `t_region` VALUES ('2160', '422801', '恩施市', '216', '0', '0', 'Enshi Shi', 'ESS');
INSERT INTO `t_region` VALUES ('2161', '422802', '利川市', '216', '0', '0', 'Lichuan Shi', 'LCE');
INSERT INTO `t_region` VALUES ('2162', '422822', '建始县', '216', '0', '0', 'Jianshi Xian', 'JSE');
INSERT INTO `t_region` VALUES ('2163', '422823', '巴东县', '216', '0', '0', 'Badong Xian', 'BDG');
INSERT INTO `t_region` VALUES ('2164', '422825', '宣恩县', '216', '0', '0', 'Xuan,en Xian', 'XEN');
INSERT INTO `t_region` VALUES ('2165', '422826', '咸丰县', '216', '0', '0', 'Xianfeng Xian', 'XFG');
INSERT INTO `t_region` VALUES ('2166', '422827', '来凤县', '216', '0', '0', 'Laifeng Xian', 'LFG');
INSERT INTO `t_region` VALUES ('2167', '422828', '鹤峰县', '216', '0', '0', 'Hefeng Xian', 'HEF');
INSERT INTO `t_region` VALUES ('2168', '429004', '仙桃市', '217', '0', '0', 'Xiantao Shi', 'XNT');
INSERT INTO `t_region` VALUES ('2169', '429005', '潜江市', '217', '0', '0', 'Qianjiang Shi', 'QNJ');
INSERT INTO `t_region` VALUES ('2170', '429006', '天门市', '217', '0', '0', 'Tianmen Shi', 'TMS');
INSERT INTO `t_region` VALUES ('2171', '429021', '神农架林区', '217', '0', '0', 'Shennongjia Linqu', 'SNJ');
INSERT INTO `t_region` VALUES ('2172', '430101', '市辖区', '218', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2173', '430102', '芙蓉区', '218', '0', '0', 'Furong Qu', 'FRQ');
INSERT INTO `t_region` VALUES ('2174', '430103', '天心区', '218', '0', '0', 'Tianxin Qu', 'TXQ');
INSERT INTO `t_region` VALUES ('2175', '430104', '岳麓区', '218', '0', '0', 'Yuelu Qu', 'YLU');
INSERT INTO `t_region` VALUES ('2176', '430105', '开福区', '218', '0', '0', 'Kaifu Qu', 'KFQ');
INSERT INTO `t_region` VALUES ('2177', '430111', '雨花区', '218', '0', '0', 'Yuhua Qu', 'YHA');
INSERT INTO `t_region` VALUES ('2178', '430121', '长沙县', '218', '0', '0', 'Changsha Xian', 'CSA');
INSERT INTO `t_region` VALUES ('2179', '430122', '望城县', '218', '0', '0', 'Wangcheng Xian', 'WCH');
INSERT INTO `t_region` VALUES ('2180', '430124', '宁乡县', '218', '0', '0', 'Ningxiang Xian', 'NXX');
INSERT INTO `t_region` VALUES ('2181', '430181', '浏阳市', '218', '0', '0', 'Liuyang Shi', 'LYS');
INSERT INTO `t_region` VALUES ('2182', '430201', '市辖区', '219', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2183', '430202', '荷塘区', '219', '0', '0', 'Hetang Qu', 'HTZ');
INSERT INTO `t_region` VALUES ('2184', '430203', '芦淞区', '219', '0', '0', 'Lusong Qu', 'LZZ');
INSERT INTO `t_region` VALUES ('2185', '430204', '石峰区', '219', '0', '0', 'Shifeng Qu', 'SFG');
INSERT INTO `t_region` VALUES ('2186', '430211', '天元区', '219', '0', '0', 'Tianyuan Qu', 'TYQ');
INSERT INTO `t_region` VALUES ('2187', '430221', '株洲县', '219', '0', '0', 'Zhuzhou Xian', 'ZZX');
INSERT INTO `t_region` VALUES ('2188', '430223', '攸县', '219', '0', '0', 'You Xian', 'YOU');
INSERT INTO `t_region` VALUES ('2189', '430224', '茶陵县', '219', '0', '0', 'Chaling Xian', 'CAL');
INSERT INTO `t_region` VALUES ('2190', '430225', '炎陵县', '219', '0', '0', 'Yanling Xian', 'YLX');
INSERT INTO `t_region` VALUES ('2191', '430281', '醴陵市', '219', '0', '0', 'Liling Shi', 'LIL');
INSERT INTO `t_region` VALUES ('2192', '430301', '市辖区', '220', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2193', '430302', '雨湖区', '220', '0', '0', 'Yuhu Qu', 'YHU');
INSERT INTO `t_region` VALUES ('2194', '430304', '岳塘区', '220', '0', '0', 'Yuetang Qu', 'YTG');
INSERT INTO `t_region` VALUES ('2195', '430321', '湘潭县', '220', '0', '0', 'Xiangtan Qu', 'XTX');
INSERT INTO `t_region` VALUES ('2196', '430381', '湘乡市', '220', '0', '0', 'Xiangxiang Shi', 'XXG');
INSERT INTO `t_region` VALUES ('2197', '430382', '韶山市', '220', '0', '0', 'Shaoshan Shi', 'SSN');
INSERT INTO `t_region` VALUES ('2198', '430401', '市辖区', '221', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2199', '430405', '珠晖区', '221', '0', '0', 'Zhuhui Qu', '2');
INSERT INTO `t_region` VALUES ('2200', '430406', '雁峰区', '221', '0', '0', 'Yanfeng Qu', '2');
INSERT INTO `t_region` VALUES ('2201', '430407', '石鼓区', '221', '0', '0', 'Shigu Qu', '2');
INSERT INTO `t_region` VALUES ('2202', '430408', '蒸湘区', '221', '0', '0', 'Zhengxiang Qu', '2');
INSERT INTO `t_region` VALUES ('2203', '430412', '南岳区', '221', '0', '0', 'Nanyue Qu', 'NYQ');
INSERT INTO `t_region` VALUES ('2204', '430421', '衡阳县', '221', '0', '0', 'Hengyang Xian', 'HYO');
INSERT INTO `t_region` VALUES ('2205', '430422', '衡南县', '221', '0', '0', 'Hengnan Xian', 'HNX');
INSERT INTO `t_region` VALUES ('2206', '430423', '衡山县', '221', '0', '0', 'Hengshan Xian', 'HSH');
INSERT INTO `t_region` VALUES ('2207', '430424', '衡东县', '221', '0', '0', 'Hengdong Xian', 'HED');
INSERT INTO `t_region` VALUES ('2208', '430426', '祁东县', '221', '0', '0', 'Qidong Xian', 'QDX');
INSERT INTO `t_region` VALUES ('2209', '430481', '耒阳市', '221', '0', '0', 'Leiyang Shi', 'LEY');
INSERT INTO `t_region` VALUES ('2210', '430482', '常宁市', '221', '0', '0', 'Changning Shi', 'CNS');
INSERT INTO `t_region` VALUES ('2211', '430501', '市辖区', '222', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2212', '430502', '双清区', '222', '0', '0', 'Shuangqing Qu', 'SGQ');
INSERT INTO `t_region` VALUES ('2213', '430503', '大祥区', '222', '0', '0', 'Daxiang Qu', 'DXS');
INSERT INTO `t_region` VALUES ('2214', '430511', '北塔区', '222', '0', '0', 'Beita Qu', 'BET');
INSERT INTO `t_region` VALUES ('2215', '430521', '邵东县', '222', '0', '0', 'Shaodong Xian', 'SDG');
INSERT INTO `t_region` VALUES ('2216', '430522', '新邵县', '222', '0', '0', 'Xinshao Xian', 'XSO');
INSERT INTO `t_region` VALUES ('2217', '430523', '邵阳县', '222', '0', '0', 'Shaoyang Xian', 'SYW');
INSERT INTO `t_region` VALUES ('2218', '430524', '隆回县', '222', '0', '0', 'Longhui Xian', 'LGH');
INSERT INTO `t_region` VALUES ('2219', '430525', '洞口县', '222', '0', '0', 'Dongkou Xian', 'DGK');
INSERT INTO `t_region` VALUES ('2220', '430527', '绥宁县', '222', '0', '0', 'Suining Xian', 'SNX');
INSERT INTO `t_region` VALUES ('2221', '430528', '新宁县', '222', '0', '0', 'Xinning Xian', 'XNI');
INSERT INTO `t_region` VALUES ('2222', '430529', '城步苗族自治县', '222', '0', '0', 'Chengbu Miaozu Zizhixian', 'CBU');
INSERT INTO `t_region` VALUES ('2223', '430581', '武冈市', '222', '0', '0', 'Wugang Shi', 'WGS');
INSERT INTO `t_region` VALUES ('2224', '430601', '市辖区', '223', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2225', '430602', '岳阳楼区', '223', '0', '0', 'Yueyanglou Qu', 'YYL');
INSERT INTO `t_region` VALUES ('2226', '430603', '云溪区', '223', '0', '0', 'Yunxi Qu', 'YXI');
INSERT INTO `t_region` VALUES ('2227', '430611', '君山区', '223', '0', '0', 'Junshan Qu', 'JUS');
INSERT INTO `t_region` VALUES ('2228', '430621', '岳阳县', '223', '0', '0', 'Yueyang Xian', 'YYX');
INSERT INTO `t_region` VALUES ('2229', '430623', '华容县', '223', '0', '0', 'Huarong Xian', 'HRG');
INSERT INTO `t_region` VALUES ('2230', '430624', '湘阴县', '223', '0', '0', 'Xiangyin Xian', 'XYN');
INSERT INTO `t_region` VALUES ('2231', '430626', '平江县', '223', '0', '0', 'Pingjiang Xian', 'PJH');
INSERT INTO `t_region` VALUES ('2232', '430681', '汨罗市', '223', '0', '0', 'Miluo Shi', 'MLU');
INSERT INTO `t_region` VALUES ('2233', '430682', '临湘市', '223', '0', '0', 'Linxiang Shi', 'LXY');
INSERT INTO `t_region` VALUES ('2234', '430701', '市辖区', '224', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2235', '430702', '武陵区', '224', '0', '0', 'Wuling Qu', 'WLQ');
INSERT INTO `t_region` VALUES ('2236', '430703', '鼎城区', '224', '0', '0', 'Dingcheng Qu', 'DCE');
INSERT INTO `t_region` VALUES ('2237', '430721', '安乡县', '224', '0', '0', 'Anxiang Xian', 'AXG');
INSERT INTO `t_region` VALUES ('2238', '430722', '汉寿县', '224', '0', '0', 'Hanshou Xian', 'HSO');
INSERT INTO `t_region` VALUES ('2239', '430723', '澧县', '224', '0', '0', 'Li Xian', 'LXX');
INSERT INTO `t_region` VALUES ('2240', '430724', '临澧县', '224', '0', '0', 'Linli Xian', 'LNL');
INSERT INTO `t_region` VALUES ('2241', '430725', '桃源县', '224', '0', '0', 'Taoyuan Xian', 'TOY');
INSERT INTO `t_region` VALUES ('2242', '430726', '石门县', '224', '0', '0', 'Shimen Xian', 'SHM');
INSERT INTO `t_region` VALUES ('2243', '430781', '津市市', '224', '0', '0', 'Jinshi Shi', 'JSS');
INSERT INTO `t_region` VALUES ('2244', '430801', '市辖区', '225', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2245', '430802', '永定区', '225', '0', '0', 'Yongding Qu', 'YDQ');
INSERT INTO `t_region` VALUES ('2246', '430811', '武陵源区', '225', '0', '0', 'Wulingyuan Qu', 'WLY');
INSERT INTO `t_region` VALUES ('2247', '430821', '慈利县', '225', '0', '0', 'Cili Xian', 'CLI');
INSERT INTO `t_region` VALUES ('2248', '430822', '桑植县', '225', '0', '0', 'Sangzhi Xian', 'SZT');
INSERT INTO `t_region` VALUES ('2249', '430901', '市辖区', '226', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2250', '430902', '资阳区', '226', '0', '0', 'Ziyang Qu', 'ZYC');
INSERT INTO `t_region` VALUES ('2251', '430903', '赫山区', '226', '0', '0', 'Heshan Qu', 'HSY');
INSERT INTO `t_region` VALUES ('2252', '430921', '南县', '226', '0', '0', 'Nan Xian', 'NXN');
INSERT INTO `t_region` VALUES ('2253', '430922', '桃江县', '226', '0', '0', 'Taojiang Xian', 'TJG');
INSERT INTO `t_region` VALUES ('2254', '430923', '安化县', '226', '0', '0', 'Anhua Xian', 'ANH');
INSERT INTO `t_region` VALUES ('2255', '430981', '沅江市', '226', '0', '0', 'Yuanjiang Shi', 'YJS');
INSERT INTO `t_region` VALUES ('2256', '431001', '市辖区', '227', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2257', '431002', '北湖区', '227', '0', '0', 'Beihu Qu', 'BHQ');
INSERT INTO `t_region` VALUES ('2258', '431003', '苏仙区', '227', '0', '0', 'Suxian Qu', '2');
INSERT INTO `t_region` VALUES ('2259', '431021', '桂阳县', '227', '0', '0', 'Guiyang Xian', 'GYX');
INSERT INTO `t_region` VALUES ('2260', '431022', '宜章县', '227', '0', '0', 'yizhang Xian', 'YZA');
INSERT INTO `t_region` VALUES ('2261', '431023', '永兴县', '227', '0', '0', 'Yongxing Xian', 'YXX');
INSERT INTO `t_region` VALUES ('2262', '431024', '嘉禾县', '227', '0', '0', 'Jiahe Xian', 'JAH');
INSERT INTO `t_region` VALUES ('2263', '431025', '临武县', '227', '0', '0', 'Linwu Xian', 'LWX');
INSERT INTO `t_region` VALUES ('2264', '431026', '汝城县', '227', '0', '0', 'Rucheng Xian', 'RCE');
INSERT INTO `t_region` VALUES ('2265', '431027', '桂东县', '227', '0', '0', 'Guidong Xian', 'GDO');
INSERT INTO `t_region` VALUES ('2266', '431028', '安仁县', '227', '0', '0', 'Anren Xian', 'ARN');
INSERT INTO `t_region` VALUES ('2267', '431081', '资兴市', '227', '0', '0', 'Zixing Shi', 'ZXG');
INSERT INTO `t_region` VALUES ('2268', '431101', '市辖区', '228', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2270', '431103', '冷水滩区', '228', '0', '0', 'Lengshuitan Qu', 'LST');
INSERT INTO `t_region` VALUES ('2271', '431121', '祁阳县', '228', '0', '0', 'Qiyang Xian', 'QJY');
INSERT INTO `t_region` VALUES ('2272', '431122', '东安县', '228', '0', '0', 'Dong,an Xian', 'DOA');
INSERT INTO `t_region` VALUES ('2273', '431123', '双牌县', '228', '0', '0', 'Shuangpai Xian', 'SPA');
INSERT INTO `t_region` VALUES ('2274', '431124', '道县', '228', '0', '0', 'Dao Xian', 'DAO');
INSERT INTO `t_region` VALUES ('2275', '431125', '江永县', '228', '0', '0', 'Jiangyong Xian', 'JYD');
INSERT INTO `t_region` VALUES ('2276', '431126', '宁远县', '228', '0', '0', 'Ningyuan Xian', 'NYN');
INSERT INTO `t_region` VALUES ('2277', '431127', '蓝山县', '228', '0', '0', 'Lanshan Xian', 'LNS');
INSERT INTO `t_region` VALUES ('2278', '431128', '新田县', '228', '0', '0', 'Xintian Xian', 'XTN');
INSERT INTO `t_region` VALUES ('2279', '431129', '江华瑶族自治县', '228', '0', '0', 'Jianghua Yaozu Zizhixian', 'JHX');
INSERT INTO `t_region` VALUES ('2280', '431201', '市辖区', '229', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2281', '431202', '鹤城区', '229', '0', '0', 'Hecheng Qu', 'HCG');
INSERT INTO `t_region` VALUES ('2282', '431221', '中方县', '229', '0', '0', 'Zhongfang Xian', 'ZFX');
INSERT INTO `t_region` VALUES ('2283', '431222', '沅陵县', '229', '0', '0', 'Yuanling Xian', 'YNL');
INSERT INTO `t_region` VALUES ('2284', '431223', '辰溪县', '229', '0', '0', 'Chenxi Xian', 'CXX');
INSERT INTO `t_region` VALUES ('2285', '431224', '溆浦县', '229', '0', '0', 'Xupu Xian', 'XUP');
INSERT INTO `t_region` VALUES ('2286', '431225', '会同县', '229', '0', '0', 'Huitong Xian', 'HTG');
INSERT INTO `t_region` VALUES ('2287', '431226', '麻阳苗族自治县', '229', '0', '0', 'Mayang Miaozu Zizhixian', 'MYX');
INSERT INTO `t_region` VALUES ('2288', '431227', '新晃侗族自治县', '229', '0', '0', 'Xinhuang Dongzu Zizhixian', 'XHD');
INSERT INTO `t_region` VALUES ('2289', '431228', '芷江侗族自治县', '229', '0', '0', 'Zhijiang Dongzu Zizhixian', 'ZJX');
INSERT INTO `t_region` VALUES ('2290', '431229', '靖州苗族侗族自治县', '229', '0', '0', 'Jingzhou Miaozu Dongzu Zizhixian', 'JZO');
INSERT INTO `t_region` VALUES ('2291', '431230', '通道侗族自治县', '229', '0', '0', 'Tongdao Dongzu Zizhixian', 'TDD');
INSERT INTO `t_region` VALUES ('2292', '431281', '洪江市', '229', '0', '0', 'Hongjiang Shi', 'HGJ');
INSERT INTO `t_region` VALUES ('2293', '431301', '市辖区', '230', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2294', '431302', '娄星区', '230', '0', '0', 'Louxing Qu', '2');
INSERT INTO `t_region` VALUES ('2295', '431321', '双峰县', '230', '0', '0', 'Shuangfeng Xian', '2');
INSERT INTO `t_region` VALUES ('2296', '431322', '新化县', '230', '0', '0', 'Xinhua Xian', '2');
INSERT INTO `t_region` VALUES ('2297', '431381', '冷水江市', '230', '0', '0', 'Lengshuijiang Shi', '2');
INSERT INTO `t_region` VALUES ('2298', '431382', '涟源市', '230', '0', '0', 'Lianyuan Shi', '2');
INSERT INTO `t_region` VALUES ('2299', '433101', '吉首市', '231', '0', '0', 'Jishou Shi', 'JSO');
INSERT INTO `t_region` VALUES ('2300', '433122', '泸溪县', '231', '0', '0', 'Luxi Xian', 'LXW');
INSERT INTO `t_region` VALUES ('2301', '433123', '凤凰县', '231', '0', '0', 'Fenghuang Xian', 'FHX');
INSERT INTO `t_region` VALUES ('2302', '433124', '花垣县', '231', '0', '0', 'Huayuan Xian', 'HYH');
INSERT INTO `t_region` VALUES ('2303', '433125', '保靖县', '231', '0', '0', 'Baojing Xian', 'BJG');
INSERT INTO `t_region` VALUES ('2304', '433126', '古丈县', '231', '0', '0', 'Guzhang Xian', 'GZG');
INSERT INTO `t_region` VALUES ('2305', '433127', '永顺县', '231', '0', '0', 'Yongshun Xian', 'YSF');
INSERT INTO `t_region` VALUES ('2306', '433130', '龙山县', '231', '0', '0', 'Longshan Xian', 'LSR');
INSERT INTO `t_region` VALUES ('2307', '440101', '市辖区', '232', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2308', '440115', '南沙区', '232', '0', '0', 'Nansha Qu', '2');
INSERT INTO `t_region` VALUES ('2309', '440103', '荔湾区', '232', '0', '0', 'Liwan Qu', 'LWQ');
INSERT INTO `t_region` VALUES ('2310', '440104', '越秀区', '232', '0', '0', 'Yuexiu Qu', 'YXU');
INSERT INTO `t_region` VALUES ('2311', '440105', '海珠区', '232', '0', '0', 'Haizhu Qu', 'HZU');
INSERT INTO `t_region` VALUES ('2312', '440106', '天河区', '232', '0', '0', 'Tianhe Qu', 'THQ');
INSERT INTO `t_region` VALUES ('2313', '440116', '萝岗区', '232', '0', '0', 'Luogang Qu', '2');
INSERT INTO `t_region` VALUES ('2314', '440111', '白云区', '232', '0', '0', 'Baiyun Qu', 'BYN');
INSERT INTO `t_region` VALUES ('2315', '440112', '黄埔区', '232', '0', '0', 'Huangpu Qu', 'HPU');
INSERT INTO `t_region` VALUES ('2316', '440113', '番禺区', '232', '0', '0', 'Panyu Qu', 'PNY');
INSERT INTO `t_region` VALUES ('2317', '440114', '花都区', '232', '0', '0', 'Huadu Qu', 'HDU');
INSERT INTO `t_region` VALUES ('2318', '440183', '增城市', '232', '0', '0', 'Zengcheng Shi', 'ZEC');
INSERT INTO `t_region` VALUES ('2319', '440184', '从化市', '232', '0', '0', 'Conghua Shi', 'CNH');
INSERT INTO `t_region` VALUES ('2320', '440201', '市辖区', '233', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2321', '440203', '武江区', '233', '0', '0', 'Wujiang Qu', 'WJQ');
INSERT INTO `t_region` VALUES ('2322', '440204', '浈江区', '233', '0', '0', 'Zhenjiang Qu', 'ZJQ');
INSERT INTO `t_region` VALUES ('2323', '440205', '曲江区', '233', '0', '0', 'Qujiang Qu', '2');
INSERT INTO `t_region` VALUES ('2324', '440222', '始兴县', '233', '0', '0', 'Shixing Xian', 'SXX');
INSERT INTO `t_region` VALUES ('2325', '440224', '仁化县', '233', '0', '0', 'Renhua Xian', 'RHA');
INSERT INTO `t_region` VALUES ('2326', '440229', '翁源县', '233', '0', '0', 'Wengyuan Xian', 'WYN');
INSERT INTO `t_region` VALUES ('2327', '440232', '乳源瑶族自治县', '233', '0', '0', 'Ruyuan Yaozu Zizhixian', 'RYN');
INSERT INTO `t_region` VALUES ('2328', '440233', '新丰县', '233', '0', '0', 'Xinfeng Xian', 'XFY');
INSERT INTO `t_region` VALUES ('2329', '440281', '乐昌市', '233', '0', '0', 'Lechang Shi', 'LEC');
INSERT INTO `t_region` VALUES ('2330', '440282', '南雄市', '233', '0', '0', 'Nanxiong Shi', 'NXS');
INSERT INTO `t_region` VALUES ('2331', '440301', '市辖区', '234', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2332', '440303', '罗湖区', '234', '0', '0', 'Luohu Qu', 'LHQ');
INSERT INTO `t_region` VALUES ('2333', '440304', '福田区', '234', '0', '0', 'Futian Qu', 'FTN');
INSERT INTO `t_region` VALUES ('2334', '440305', '南山区', '234', '0', '0', 'Nanshan Qu', 'NSN');
INSERT INTO `t_region` VALUES ('2335', '440306', '宝安区', '234', '0', '0', 'Bao,an Qu', 'BAQ');
INSERT INTO `t_region` VALUES ('2336', '440307', '龙岗区', '234', '0', '0', 'Longgang Qu', 'LGG');
INSERT INTO `t_region` VALUES ('2337', '440308', '盐田区', '234', '0', '0', 'Yan Tian Qu', 'YTQ');
INSERT INTO `t_region` VALUES ('2338', '440401', '市辖区', '235', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2339', '440402', '香洲区', '235', '0', '0', 'Xiangzhou Qu', 'XZQ');
INSERT INTO `t_region` VALUES ('2340', '440403', '斗门区', '235', '0', '0', 'Doumen Qu', 'DOU');
INSERT INTO `t_region` VALUES ('2341', '440404', '金湾区', '235', '0', '0', 'Jinwan Qu', 'JW Q');
INSERT INTO `t_region` VALUES ('2342', '440501', '市辖区', '236', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2343', '440507', '龙湖区', '236', '0', '0', 'Longhu Qu', 'LHH');
INSERT INTO `t_region` VALUES ('2344', '440511', '金平区', '236', '0', '0', 'Jinping Qu', 'JPQ');
INSERT INTO `t_region` VALUES ('2345', '440512', '濠江区', '236', '0', '0', 'Haojiang Qu', 'HJ Q');
INSERT INTO `t_region` VALUES ('2346', '440513', '潮阳区', '236', '0', '0', 'Chaoyang  Qu', 'CHY');
INSERT INTO `t_region` VALUES ('2347', '440514', '潮南区', '236', '0', '0', 'Chaonan Qu', 'CN Q');
INSERT INTO `t_region` VALUES ('2348', '440515', '澄海区', '236', '0', '0', 'Chenghai QU', 'CHS');
INSERT INTO `t_region` VALUES ('2349', '440523', '南澳县', '236', '0', '0', 'Nan,ao Xian', 'NAN');
INSERT INTO `t_region` VALUES ('2350', '440601', '市辖区', '237', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2351', '440604', '禅城区', '237', '0', '0', 'Chancheng Qu', 'CC Q');
INSERT INTO `t_region` VALUES ('2352', '440605', '南海区', '237', '0', '0', 'Nanhai Shi', 'NAH');
INSERT INTO `t_region` VALUES ('2353', '440606', '顺德区', '237', '0', '0', 'Shunde Shi', 'SUD');
INSERT INTO `t_region` VALUES ('2354', '440607', '三水区', '237', '0', '0', 'Sanshui Shi', 'SJQ');
INSERT INTO `t_region` VALUES ('2355', '440608', '高明区', '237', '0', '0', 'Gaoming Shi', 'GOM');
INSERT INTO `t_region` VALUES ('2356', '440701', '市辖区', '238', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2357', '440703', '蓬江区', '238', '0', '0', 'Pengjiang Qu', 'PJJ');
INSERT INTO `t_region` VALUES ('2358', '440704', '江海区', '238', '0', '0', 'Jianghai Qu', 'JHI');
INSERT INTO `t_region` VALUES ('2359', '440705', '新会区', '238', '0', '0', 'Xinhui Shi', 'XIN');
INSERT INTO `t_region` VALUES ('2360', '440781', '台山市', '238', '0', '0', 'Taishan Shi', 'TSS');
INSERT INTO `t_region` VALUES ('2361', '440783', '开平市', '238', '0', '0', 'Kaiping Shi', 'KPS');
INSERT INTO `t_region` VALUES ('2362', '440784', '鹤山市', '238', '0', '0', 'Heshan Shi', 'HES');
INSERT INTO `t_region` VALUES ('2363', '440785', '恩平市', '238', '0', '0', 'Enping Shi', 'ENP');
INSERT INTO `t_region` VALUES ('2364', '440801', '市辖区', '239', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2365', '440802', '赤坎区', '239', '0', '0', 'Chikan Qu', 'CKQ');
INSERT INTO `t_region` VALUES ('2366', '440803', '霞山区', '239', '0', '0', 'Xiashan Qu', 'XAS');
INSERT INTO `t_region` VALUES ('2367', '440804', '坡头区', '239', '0', '0', 'Potou Qu', 'PTU');
INSERT INTO `t_region` VALUES ('2368', '440811', '麻章区', '239', '0', '0', 'Mazhang Qu', 'MZQ');
INSERT INTO `t_region` VALUES ('2369', '440823', '遂溪县', '239', '0', '0', 'Suixi Xian', 'SXI');
INSERT INTO `t_region` VALUES ('2370', '440825', '徐闻县', '239', '0', '0', 'Xuwen Xian', 'XWN');
INSERT INTO `t_region` VALUES ('2371', '440881', '廉江市', '239', '0', '0', 'Lianjiang Shi', 'LJS');
INSERT INTO `t_region` VALUES ('2372', '440882', '雷州市', '239', '0', '0', 'Leizhou Shi', 'LEZ');
INSERT INTO `t_region` VALUES ('2373', '440883', '吴川市', '239', '0', '0', 'Wuchuan Shi', 'WCS');
INSERT INTO `t_region` VALUES ('2374', '440901', '市辖区', '240', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2375', '440902', '茂南区', '240', '0', '0', 'Maonan Qu', 'MNQ');
INSERT INTO `t_region` VALUES ('2376', '440903', '茂港区', '240', '0', '0', 'Maogang Qu', 'MGQ');
INSERT INTO `t_region` VALUES ('2377', '440923', '电白县', '240', '0', '0', 'Dianbai Xian', 'DBI');
INSERT INTO `t_region` VALUES ('2378', '440981', '高州市', '240', '0', '0', 'Gaozhou Shi', 'GZO');
INSERT INTO `t_region` VALUES ('2379', '440982', '化州市', '240', '0', '0', 'Huazhou Shi', 'HZY');
INSERT INTO `t_region` VALUES ('2380', '440983', '信宜市', '240', '0', '0', 'Xinyi Shi', 'XYY');
INSERT INTO `t_region` VALUES ('2381', '441201', '市辖区', '241', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2382', '441202', '端州区', '241', '0', '0', 'Duanzhou Qu', 'DZQ');
INSERT INTO `t_region` VALUES ('2383', '441203', '鼎湖区', '241', '0', '0', 'Dinghu Qu', 'DGH');
INSERT INTO `t_region` VALUES ('2384', '441223', '广宁县', '241', '0', '0', 'Guangning Xian', 'GNG');
INSERT INTO `t_region` VALUES ('2385', '441224', '怀集县', '241', '0', '0', 'Huaiji Xian', 'HJX');
INSERT INTO `t_region` VALUES ('2386', '441225', '封开县', '241', '0', '0', 'Fengkai Xian', 'FKX');
INSERT INTO `t_region` VALUES ('2387', '441226', '德庆县', '241', '0', '0', 'Deqing Xian', 'DQY');
INSERT INTO `t_region` VALUES ('2388', '441283', '高要市', '241', '0', '0', 'Gaoyao Xian', 'GYY');
INSERT INTO `t_region` VALUES ('2389', '441284', '四会市', '241', '0', '0', 'Sihui Shi', 'SHI');
INSERT INTO `t_region` VALUES ('2390', '441301', '市辖区', '242', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2391', '441302', '惠城区', '242', '0', '0', 'Huicheng Qu', 'HCQ');
INSERT INTO `t_region` VALUES ('2392', '441303', '惠阳区', '242', '0', '0', 'Huiyang Shi', 'HUY');
INSERT INTO `t_region` VALUES ('2393', '441322', '博罗县', '242', '0', '0', 'Boluo Xian', 'BOL');
INSERT INTO `t_region` VALUES ('2394', '441323', '惠东县', '242', '0', '0', 'Huidong Xian', 'HID');
INSERT INTO `t_region` VALUES ('2395', '441324', '龙门县', '242', '0', '0', 'Longmen Xian', 'LMN');
INSERT INTO `t_region` VALUES ('2396', '441401', '市辖区', '243', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2397', '441402', '梅江区', '243', '0', '0', 'Meijiang Qu', 'MJQ');
INSERT INTO `t_region` VALUES ('2398', '441421', '梅县', '243', '0', '0', 'Mei Xian', 'MEX');
INSERT INTO `t_region` VALUES ('2399', '441422', '大埔县', '243', '0', '0', 'Dabu Xian', 'DBX');
INSERT INTO `t_region` VALUES ('2400', '441423', '丰顺县', '243', '0', '0', 'Fengshun Xian', 'FES');
INSERT INTO `t_region` VALUES ('2401', '441424', '五华县', '243', '0', '0', 'Wuhua Xian', 'WHY');
INSERT INTO `t_region` VALUES ('2402', '441426', '平远县', '243', '0', '0', 'Pingyuan Xian', 'PYY');
INSERT INTO `t_region` VALUES ('2403', '441427', '蕉岭县', '243', '0', '0', 'Jiaoling Xian', 'JOL');
INSERT INTO `t_region` VALUES ('2404', '441481', '兴宁市', '243', '0', '0', 'Xingning Shi', 'XNG');
INSERT INTO `t_region` VALUES ('2405', '441501', '市辖区', '244', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2406', '441502', '城区', '244', '0', '0', 'Chengqu', 'CQS');
INSERT INTO `t_region` VALUES ('2407', '441521', '海丰县', '244', '0', '0', 'Haifeng Xian', 'HIF');
INSERT INTO `t_region` VALUES ('2408', '441523', '陆河县', '244', '0', '0', 'Luhe Xian', 'LHY');
INSERT INTO `t_region` VALUES ('2409', '441581', '陆丰市', '244', '0', '0', 'Lufeng Shi', 'LUF');
INSERT INTO `t_region` VALUES ('2410', '441601', '市辖区', '245', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2411', '441602', '源城区', '245', '0', '0', 'Yuancheng Qu', 'YCQ');
INSERT INTO `t_region` VALUES ('2412', '441621', '紫金县', '245', '0', '0', 'Zijin Xian', 'ZJY');
INSERT INTO `t_region` VALUES ('2413', '441622', '龙川县', '245', '0', '0', 'Longchuan Xian', 'LCY');
INSERT INTO `t_region` VALUES ('2414', '441623', '连平县', '245', '0', '0', 'Lianping Xian', 'LNP');
INSERT INTO `t_region` VALUES ('2415', '441624', '和平县', '245', '0', '0', 'Heping Xian', 'HPY');
INSERT INTO `t_region` VALUES ('2416', '441625', '东源县', '245', '0', '0', 'Dongyuan Xian', 'DYN');
INSERT INTO `t_region` VALUES ('2417', '441701', '市辖区', '246', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2418', '441702', '江城区', '246', '0', '0', 'Jiangcheng Qu', 'JCQ');
INSERT INTO `t_region` VALUES ('2419', '441721', '阳西县', '246', '0', '0', 'Yangxi Xian', 'YXY');
INSERT INTO `t_region` VALUES ('2420', '441723', '阳东县', '246', '0', '0', 'Yangdong Xian', 'YGD');
INSERT INTO `t_region` VALUES ('2421', '441781', '阳春市', '246', '0', '0', 'Yangchun Shi', 'YCU');
INSERT INTO `t_region` VALUES ('2422', '441801', '市辖区', '247', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2423', '441802', '清城区', '247', '0', '0', 'Qingcheng Qu', 'QCQ');
INSERT INTO `t_region` VALUES ('2424', '441821', '佛冈县', '247', '0', '0', 'Fogang Xian', 'FGY');
INSERT INTO `t_region` VALUES ('2425', '441823', '阳山县', '247', '0', '0', 'Yangshan Xian', 'YSN');
INSERT INTO `t_region` VALUES ('2426', '441825', '连山壮族瑶族自治县', '247', '0', '0', 'Lianshan Zhuangzu Yaozu Zizhixian', 'LSZ');
INSERT INTO `t_region` VALUES ('2427', '441826', '连南瑶族自治县', '247', '0', '0', 'Liannanyaozuzizhi Qu', '2');
INSERT INTO `t_region` VALUES ('2428', '441827', '清新县', '247', '0', '0', 'Qingxin Xian', 'QGX');
INSERT INTO `t_region` VALUES ('2429', '441881', '英德市', '247', '0', '0', 'Yingde Shi', 'YDS');
INSERT INTO `t_region` VALUES ('2430', '441882', '连州市', '247', '0', '0', 'Lianzhou Shi', 'LZO');
INSERT INTO `t_region` VALUES ('2431', '445101', '市辖区', '250', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2432', '445102', '湘桥区', '250', '0', '0', 'Xiangqiao Qu', 'XQO');
INSERT INTO `t_region` VALUES ('2433', '445121', '潮安县', '250', '0', '0', 'Chao,an Xian', 'CAY');
INSERT INTO `t_region` VALUES ('2434', '445122', '饶平县', '250', '0', '0', 'Raoping Xian', 'RPG');
INSERT INTO `t_region` VALUES ('2435', '445201', '市辖区', '251', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2436', '445202', '榕城区', '251', '0', '0', 'Rongcheng Qu', 'RCH');
INSERT INTO `t_region` VALUES ('2437', '445221', '揭东县', '251', '0', '0', 'Jiedong Xian', 'JDX');
INSERT INTO `t_region` VALUES ('2438', '445222', '揭西县', '251', '0', '0', 'Jiexi Xian', 'JEX');
INSERT INTO `t_region` VALUES ('2439', '445224', '惠来县', '251', '0', '0', 'Huilai Xian', 'HLY');
INSERT INTO `t_region` VALUES ('2440', '445281', '普宁市', '251', '0', '0', 'Puning Shi', 'PNG');
INSERT INTO `t_region` VALUES ('2441', '445301', '市辖区', '252', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2442', '445302', '云城区', '252', '0', '0', 'Yuncheng Qu', 'YYF');
INSERT INTO `t_region` VALUES ('2443', '445321', '新兴县', '252', '0', '0', 'Xinxing Xian', 'XNX');
INSERT INTO `t_region` VALUES ('2444', '445322', '郁南县', '252', '0', '0', 'Yunan Xian', 'YNK');
INSERT INTO `t_region` VALUES ('2445', '445323', '云安县', '252', '0', '0', 'Yun,an Xian', 'YUA');
INSERT INTO `t_region` VALUES ('2446', '445381', '罗定市', '252', '0', '0', 'Luoding Shi', 'LUO');
INSERT INTO `t_region` VALUES ('2447', '450101', '市辖区', '253', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2448', '450102', '兴宁区', '253', '0', '0', 'Xingning Qu', 'XNE');
INSERT INTO `t_region` VALUES ('2449', '450103', '青秀区', '253', '0', '0', 'Qingxiu Qu', '2');
INSERT INTO `t_region` VALUES ('2450', '450105', '江南区', '253', '0', '0', 'Jiangnan Qu', 'JNA');
INSERT INTO `t_region` VALUES ('2451', '450107', '西乡塘区', '253', '0', '0', 'Xixiangtang Qu', '2');
INSERT INTO `t_region` VALUES ('2452', '450108', '良庆区', '253', '0', '0', 'Liangqing Qu', '2');
INSERT INTO `t_region` VALUES ('2453', '450109', '邕宁区', '253', '0', '0', 'Yongning Qu', '2');
INSERT INTO `t_region` VALUES ('2454', '450122', '武鸣县', '253', '0', '0', 'Wuming Xian', 'WMG');
INSERT INTO `t_region` VALUES ('2455', '450123', '隆安县', '253', '0', '0', 'Long,an Xian', '2');
INSERT INTO `t_region` VALUES ('2456', '450124', '马山县', '253', '0', '0', 'Mashan Xian', '2');
INSERT INTO `t_region` VALUES ('2457', '450125', '上林县', '253', '0', '0', 'Shanglin Xian', '2');
INSERT INTO `t_region` VALUES ('2458', '450126', '宾阳县', '253', '0', '0', 'Binyang Xian', '2');
INSERT INTO `t_region` VALUES ('2459', '450127', '横县', '253', '0', '0', 'Heng Xian', '2');
INSERT INTO `t_region` VALUES ('2460', '450201', '市辖区', '254', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2461', '450202', '城中区', '254', '0', '0', 'Chengzhong Qu', 'CZG');
INSERT INTO `t_region` VALUES ('2462', '450203', '鱼峰区', '254', '0', '0', 'Yufeng Qu', 'YFQ');
INSERT INTO `t_region` VALUES ('2463', '450204', '柳南区', '254', '0', '0', 'Liunan Qu', 'LNU');
INSERT INTO `t_region` VALUES ('2464', '450205', '柳北区', '254', '0', '0', 'Liubei Qu', 'LBE');
INSERT INTO `t_region` VALUES ('2465', '450221', '柳江县', '254', '0', '0', 'Liujiang Xian', 'LUJ');
INSERT INTO `t_region` VALUES ('2466', '450222', '柳城县', '254', '0', '0', 'Liucheng Xian', 'LCB');
INSERT INTO `t_region` VALUES ('2467', '450223', '鹿寨县', '254', '0', '0', 'Luzhai Xian', '2');
INSERT INTO `t_region` VALUES ('2468', '450224', '融安县', '254', '0', '0', 'Rong,an Xian', '2');
INSERT INTO `t_region` VALUES ('2469', '450225', '融水苗族自治县', '254', '0', '0', 'Rongshui Miaozu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2470', '450226', '三江侗族自治县', '254', '0', '0', 'Sanjiang Dongzu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2471', '450301', '市辖区', '255', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2472', '450302', '秀峰区', '255', '0', '0', 'Xiufeng Qu', 'XUF');
INSERT INTO `t_region` VALUES ('2473', '450303', '叠彩区', '255', '0', '0', 'Diecai Qu', 'DCA');
INSERT INTO `t_region` VALUES ('2474', '450304', '象山区', '255', '0', '0', 'Xiangshan Qu', 'XSK');
INSERT INTO `t_region` VALUES ('2475', '450305', '七星区', '255', '0', '0', 'Qixing Qu', 'QXG');
INSERT INTO `t_region` VALUES ('2476', '450311', '雁山区', '255', '0', '0', 'Yanshan Qu', 'YSA');
INSERT INTO `t_region` VALUES ('2477', '450321', '阳朔县', '255', '0', '0', 'Yangshuo Xian', 'YSO');
INSERT INTO `t_region` VALUES ('2478', '450322', '临桂县', '255', '0', '0', 'Lingui Xian', 'LGI');
INSERT INTO `t_region` VALUES ('2479', '450323', '灵川县', '255', '0', '0', 'Lingchuan Xian', 'LCU');
INSERT INTO `t_region` VALUES ('2480', '450324', '全州县', '255', '0', '0', 'Quanzhou Xian', 'QZO');
INSERT INTO `t_region` VALUES ('2481', '450325', '兴安县', '255', '0', '0', 'Xing,an Xian', 'XAG');
INSERT INTO `t_region` VALUES ('2482', '450326', '永福县', '255', '0', '0', 'Yongfu Xian', 'YFU');
INSERT INTO `t_region` VALUES ('2483', '450327', '灌阳县', '255', '0', '0', 'Guanyang Xian', 'GNY');
INSERT INTO `t_region` VALUES ('2484', '450328', '龙胜各族自治县', '255', '0', '0', 'Longsheng Gezu Zizhixian', 'LSG');
INSERT INTO `t_region` VALUES ('2485', '450329', '资源县', '255', '0', '0', 'Ziyuan Xian', 'ZYU');
INSERT INTO `t_region` VALUES ('2486', '450330', '平乐县', '255', '0', '0', 'Pingle Xian', 'PLE');
INSERT INTO `t_region` VALUES ('2487', '450331', '荔蒲县', '255', '0', '0', 'Lipu Xian', '2');
INSERT INTO `t_region` VALUES ('2488', '450332', '恭城瑶族自治县', '255', '0', '0', 'Gongcheng Yaozu Zizhixian', 'GGC');
INSERT INTO `t_region` VALUES ('2489', '450401', '市辖区', '256', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2490', '450403', '万秀区', '256', '0', '0', 'Wanxiu Qu', 'WXQ');
INSERT INTO `t_region` VALUES ('2491', '450404', '蝶山区', '256', '0', '0', 'Dieshan Qu', 'DES');
INSERT INTO `t_region` VALUES ('2492', '450405', '长洲区', '256', '0', '0', 'Changzhou Qu', '2');
INSERT INTO `t_region` VALUES ('2493', '450421', '苍梧县', '256', '0', '0', 'Cangwu Xian', 'CAW');
INSERT INTO `t_region` VALUES ('2494', '450422', '藤县', '256', '0', '0', 'Teng Xian', '2');
INSERT INTO `t_region` VALUES ('2495', '450423', '蒙山县', '256', '0', '0', 'Mengshan Xian', 'MSA');
INSERT INTO `t_region` VALUES ('2496', '450481', '岑溪市', '256', '0', '0', 'Cenxi Shi', 'CEX');
INSERT INTO `t_region` VALUES ('2497', '450501', '市辖区', '257', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2498', '450502', '海城区', '257', '0', '0', 'Haicheng Qu', 'HCB');
INSERT INTO `t_region` VALUES ('2499', '450503', '银海区', '257', '0', '0', 'Yinhai Qu', 'YHB');
INSERT INTO `t_region` VALUES ('2500', '450512', '铁山港区', '257', '0', '0', 'Tieshangangqu ', 'TSG');
INSERT INTO `t_region` VALUES ('2501', '450521', '合浦县', '257', '0', '0', 'Hepu Xian', 'HPX');
INSERT INTO `t_region` VALUES ('2502', '450601', '市辖区', '258', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2503', '450602', '港口区', '258', '0', '0', 'Gangkou Qu', 'GKQ');
INSERT INTO `t_region` VALUES ('2504', '450603', '防城区', '258', '0', '0', 'Fangcheng Qu', 'FCQ');
INSERT INTO `t_region` VALUES ('2505', '450621', '上思县', '258', '0', '0', 'Shangsi Xian', 'SGS');
INSERT INTO `t_region` VALUES ('2506', '450681', '东兴市', '258', '0', '0', 'Dongxing Shi', 'DOX');
INSERT INTO `t_region` VALUES ('2507', '450701', '市辖区', '259', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2508', '450702', '钦南区', '259', '0', '0', 'Qinnan Qu', 'QNQ');
INSERT INTO `t_region` VALUES ('2509', '450703', '钦北区', '259', '0', '0', 'Qinbei Qu', 'QBQ');
INSERT INTO `t_region` VALUES ('2510', '450721', '灵山县', '259', '0', '0', 'Lingshan Xian', 'LSB');
INSERT INTO `t_region` VALUES ('2511', '450722', '浦北县', '259', '0', '0', 'Pubei Xian', 'PBE');
INSERT INTO `t_region` VALUES ('2512', '450801', '市辖区', '260', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2513', '450802', '港北区', '260', '0', '0', 'Gangbei Qu', 'GBE');
INSERT INTO `t_region` VALUES ('2514', '450803', '港南区', '260', '0', '0', 'Gangnan Qu', 'GNQ');
INSERT INTO `t_region` VALUES ('2515', '450804', '覃塘区', '260', '0', '0', 'Tantang Qu', '2');
INSERT INTO `t_region` VALUES ('2516', '450821', '平南县', '260', '0', '0', 'Pingnan Xian', 'PNN');
INSERT INTO `t_region` VALUES ('2517', '450881', '桂平市', '260', '0', '0', 'Guiping Shi', 'GPS');
INSERT INTO `t_region` VALUES ('2518', '450901', '市辖区', '261', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2519', '450902', '玉州区', '261', '0', '0', 'Yuzhou Qu', 'YZO');
INSERT INTO `t_region` VALUES ('2520', '450921', '容县', '261', '0', '0', 'Rong Xian', 'ROG');
INSERT INTO `t_region` VALUES ('2521', '450922', '陆川县', '261', '0', '0', 'Luchuan Xian', 'LCJ');
INSERT INTO `t_region` VALUES ('2522', '450923', '博白县', '261', '0', '0', 'Bobai Xian', 'BBA');
INSERT INTO `t_region` VALUES ('2523', '450924', '兴业县', '261', '0', '0', 'Xingye Xian', 'XGY');
INSERT INTO `t_region` VALUES ('2524', '450981', '北流市', '261', '0', '0', 'Beiliu Shi', 'BLS');
INSERT INTO `t_region` VALUES ('2525', '451001', '市辖区', '262', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2526', '451002', '右江区', '262', '0', '0', 'Youjiang Qu', '2');
INSERT INTO `t_region` VALUES ('2527', '451021', '田阳县', '262', '0', '0', 'Tianyang Xian', '2');
INSERT INTO `t_region` VALUES ('2528', '451022', '田东县', '262', '0', '0', 'Tiandong Xian', '2');
INSERT INTO `t_region` VALUES ('2529', '451023', '平果县', '262', '0', '0', 'Pingguo Xian', '2');
INSERT INTO `t_region` VALUES ('2530', '451024', '德保县', '262', '0', '0', 'Debao Xian', '2');
INSERT INTO `t_region` VALUES ('2531', '451025', '靖西县', '262', '0', '0', 'Jingxi Xian', '2');
INSERT INTO `t_region` VALUES ('2532', '451026', '那坡县', '262', '0', '0', 'Napo Xian', '2');
INSERT INTO `t_region` VALUES ('2533', '451027', '凌云县', '262', '0', '0', 'Lingyun Xian', '2');
INSERT INTO `t_region` VALUES ('2534', '451028', '乐业县', '262', '0', '0', 'Leye Xian', '2');
INSERT INTO `t_region` VALUES ('2535', '451029', '田林县', '262', '0', '0', 'Tianlin Xian', '2');
INSERT INTO `t_region` VALUES ('2536', '451030', '西林县', '262', '0', '0', 'Xilin Xian', '2');
INSERT INTO `t_region` VALUES ('2537', '451031', '隆林各族自治县', '262', '0', '0', 'Longlin Gezu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2538', '451101', '市辖区', '263', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2539', '451102', '八步区', '263', '0', '0', 'Babu Qu', '2');
INSERT INTO `t_region` VALUES ('2540', '451121', '昭平县', '263', '0', '0', 'Zhaoping Xian', '2');
INSERT INTO `t_region` VALUES ('2541', '451122', '钟山县', '263', '0', '0', 'Zhongshan Xian', '2');
INSERT INTO `t_region` VALUES ('2542', '451123', '富川瑶族自治县', '263', '0', '0', 'Fuchuan Yaozu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2543', '451201', '市辖区', '264', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2544', '451202', '金城江区', '264', '0', '0', 'Jinchengjiang Qu', '2');
INSERT INTO `t_region` VALUES ('2545', '451221', '南丹县', '264', '0', '0', 'Nandan Xian', '2');
INSERT INTO `t_region` VALUES ('2546', '451222', '天峨县', '264', '0', '0', 'Tian,e Xian', '2');
INSERT INTO `t_region` VALUES ('2547', '451223', '凤山县', '264', '0', '0', 'Fengshan Xian', '2');
INSERT INTO `t_region` VALUES ('2548', '451224', '东兰县', '264', '0', '0', 'Donglan Xian', '2');
INSERT INTO `t_region` VALUES ('2549', '451225', '罗城仫佬族自治县', '264', '0', '0', 'Luocheng Mulaozu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2550', '451226', '环江毛南族自治县', '264', '0', '0', 'Huanjiang Maonanzu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2551', '451227', '巴马瑶族自治县', '264', '0', '0', 'Bama Yaozu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2552', '451228', '都安瑶族自治县', '264', '0', '0', 'Du,an Yaozu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2553', '451229', '大化瑶族自治县', '264', '0', '0', 'Dahua Yaozu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2554', '451281', '宜州市', '264', '0', '0', 'Yizhou Shi', '2');
INSERT INTO `t_region` VALUES ('2555', '451301', '市辖区', '265', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2556', '451302', '兴宾区', '265', '0', '0', 'Xingbin Qu', '2');
INSERT INTO `t_region` VALUES ('2557', '451321', '忻城县', '265', '0', '0', 'Xincheng Xian', '2');
INSERT INTO `t_region` VALUES ('2558', '451322', '象州县', '265', '0', '0', 'Xiangzhou Xian', '2');
INSERT INTO `t_region` VALUES ('2559', '451323', '武宣县', '265', '0', '0', 'Wuxuan Xian', '2');
INSERT INTO `t_region` VALUES ('2560', '451324', '金秀瑶族自治县', '265', '0', '0', 'Jinxiu Yaozu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2561', '451381', '合山市', '265', '0', '0', 'Heshan Shi', '2');
INSERT INTO `t_region` VALUES ('2562', '451401', '市辖区', '266', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2563', '451402', '江洲区', '266', '0', '0', 'Jiangzhou Qu', '2');
INSERT INTO `t_region` VALUES ('2564', '451421', '扶绥县', '266', '0', '0', 'Fusui Xian', '2');
INSERT INTO `t_region` VALUES ('2565', '451422', '宁明县', '266', '0', '0', 'Ningming Xian', '2');
INSERT INTO `t_region` VALUES ('2566', '451423', '龙州县', '266', '0', '0', 'Longzhou Xian', '2');
INSERT INTO `t_region` VALUES ('2567', '451424', '大新县', '266', '0', '0', 'Daxin Xian', '2');
INSERT INTO `t_region` VALUES ('2568', '451425', '天等县', '266', '0', '0', 'Tiandeng Xian', '2');
INSERT INTO `t_region` VALUES ('2569', '451481', '凭祥市', '266', '0', '0', 'Pingxiang Shi', '2');
INSERT INTO `t_region` VALUES ('2570', '460101', '市辖区', '267', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2571', '460105', '秀英区', '267', '0', '0', 'Xiuying Qu', 'XYH');
INSERT INTO `t_region` VALUES ('2572', '460106', '龙华区', '267', '0', '0', 'LongHua Qu', 'LH');
INSERT INTO `t_region` VALUES ('2573', '460107', '琼山区', '267', '0', '0', 'QiongShan Qu', 'QS');
INSERT INTO `t_region` VALUES ('2574', '460108', '美兰区', '267', '0', '0', 'MeiLan Qu', 'ML');
INSERT INTO `t_region` VALUES ('2575', '460201', '市辖区', '268', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2576', '469001', '五指山市', '269', '0', '0', 'Wuzhishan Qu', '2');
INSERT INTO `t_region` VALUES ('2577', '469002', '琼海市', '269', '0', '0', 'Qionghai Shi', '2');
INSERT INTO `t_region` VALUES ('2578', '469003', '儋州市', '269', '0', '0', 'Danzhou Shi', '2');
INSERT INTO `t_region` VALUES ('2579', '469005', '文昌市', '269', '0', '0', 'Wenchang Shi', '2');
INSERT INTO `t_region` VALUES ('2580', '469006', '万宁市', '269', '0', '0', 'Wanning Shi', '2');
INSERT INTO `t_region` VALUES ('2581', '469007', '东方市', '269', '0', '0', 'Dongfang Shi', '2');
INSERT INTO `t_region` VALUES ('2582', '469021', '定安县', '269', '0', '0', 'Ding,an Xian', '2');
INSERT INTO `t_region` VALUES ('2583', '469022', '屯昌县', '269', '0', '0', 'Tunchang Xian', '2');
INSERT INTO `t_region` VALUES ('2584', '469023', '澄迈县', '269', '0', '0', 'Chengmai Xian', '2');
INSERT INTO `t_region` VALUES ('2585', '469024', '临高县', '269', '0', '0', 'Lingao Xian', '2');
INSERT INTO `t_region` VALUES ('2586', '469025', '白沙黎族自治县', '269', '0', '0', 'Baisha Lizu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2587', '469026', '昌江黎族自治县', '269', '0', '0', 'Changjiang Lizu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2588', '469027', '乐东黎族自治县', '269', '0', '0', 'Ledong Lizu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2589', '469028', '陵水黎族自治县', '269', '0', '0', 'Lingshui Lizu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2590', '469029', '保亭黎族苗族自治县', '269', '0', '0', 'Baoting Lizu Miaozu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2591', '469030', '琼中黎族苗族自治县', '269', '0', '0', 'Qiongzhong Lizu Miaozu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2592', '469031', '西沙群岛', '269', '0', '0', 'Xisha Qundao', '2');
INSERT INTO `t_region` VALUES ('2593', '469032', '南沙群岛', '269', '0', '0', 'Nansha Qundao', '2');
INSERT INTO `t_region` VALUES ('2594', '469033', '中沙群岛的岛礁及其海域', '269', '0', '0', 'Zhongsha Qundao de Daojiao Jiqi Haiyu', '2');
INSERT INTO `t_region` VALUES ('2595', '500101', '万州区', '270', '0', '0', 'Wanzhou Qu', 'WZO ');
INSERT INTO `t_region` VALUES ('2596', '500102', '涪陵区', '270', '0', '0', 'Fuling Qu', 'FLG');
INSERT INTO `t_region` VALUES ('2597', '500103', '渝中区', '270', '0', '0', 'Yuzhong Qu', 'YZQ');
INSERT INTO `t_region` VALUES ('2598', '500104', '大渡口区', '270', '0', '0', 'Dadukou Qu', 'DDK');
INSERT INTO `t_region` VALUES ('2599', '500105', '江北区', '270', '0', '0', 'Jiangbei Qu', 'JBE');
INSERT INTO `t_region` VALUES ('2600', '500106', '沙坪坝区', '270', '0', '0', 'Shapingba Qu', 'SPB');
INSERT INTO `t_region` VALUES ('2601', '500107', '九龙坡区', '270', '0', '0', 'Jiulongpo Qu', 'JLP');
INSERT INTO `t_region` VALUES ('2602', '500108', '南岸区', '270', '0', '0', 'Nan,an Qu', 'NAQ');
INSERT INTO `t_region` VALUES ('2603', '500109', '北碚区', '270', '0', '0', 'Beibei Qu', 'BBE');
INSERT INTO `t_region` VALUES ('2604', '500110', '万盛区', '270', '0', '0', 'Wansheng Qu', 'WSQ');
INSERT INTO `t_region` VALUES ('2605', '500111', '双桥区', '270', '0', '0', 'Shuangqiao Qu', 'SQQ');
INSERT INTO `t_region` VALUES ('2606', '500112', '渝北区', '270', '0', '0', 'Yubei Qu', 'YBE');
INSERT INTO `t_region` VALUES ('2607', '500113', '巴南区', '270', '0', '0', 'Banan Qu', 'BNN');
INSERT INTO `t_region` VALUES ('2608', '500114', '黔江区', '270', '0', '0', 'Qianjiang Qu', '2');
INSERT INTO `t_region` VALUES ('2609', '500115', '长寿区', '270', '0', '0', 'Changshou Qu', '2');
INSERT INTO `t_region` VALUES ('2610', '500222', '綦江县', '271', '0', '0', 'Qijiang Xian', 'QJG');
INSERT INTO `t_region` VALUES ('2611', '500223', '潼南县', '271', '0', '0', 'Tongnan Xian', 'TNN');
INSERT INTO `t_region` VALUES ('2612', '500224', '铜梁县', '271', '0', '0', 'Tongliang Xian', 'TGL');
INSERT INTO `t_region` VALUES ('2613', '500225', '大足县', '271', '0', '0', 'Dazu Xian', 'DZX');
INSERT INTO `t_region` VALUES ('2614', '500226', '荣昌县', '271', '0', '0', 'Rongchang Xian', 'RGC');
INSERT INTO `t_region` VALUES ('2615', '500227', '璧山县', '271', '0', '0', 'Bishan Xian', 'BSY');
INSERT INTO `t_region` VALUES ('2616', '500228', '梁平县', '271', '0', '0', 'Liangping Xian', 'LGP');
INSERT INTO `t_region` VALUES ('2617', '500229', '城口县', '271', '0', '0', 'Chengkou Xian', 'CKO');
INSERT INTO `t_region` VALUES ('2618', '500230', '丰都县', '271', '0', '0', 'Fengdu Xian', 'FDU');
INSERT INTO `t_region` VALUES ('2619', '500231', '垫江县', '271', '0', '0', 'Dianjiang Xian', 'DJG');
INSERT INTO `t_region` VALUES ('2620', '500232', '武隆县', '271', '0', '0', 'Wulong Xian', 'WLG');
INSERT INTO `t_region` VALUES ('2621', '500233', '忠县', '271', '0', '0', 'Zhong Xian', 'ZHX');
INSERT INTO `t_region` VALUES ('2622', '500234', '开县', '271', '0', '0', 'Kai Xian', 'KAI');
INSERT INTO `t_region` VALUES ('2623', '500235', '云阳县', '271', '0', '0', 'Yunyang Xian', 'YNY');
INSERT INTO `t_region` VALUES ('2624', '500236', '奉节县', '271', '0', '0', 'Fengjie Xian', 'FJE');
INSERT INTO `t_region` VALUES ('2625', '500237', '巫山县', '271', '0', '0', 'Wushan Xian', 'WSN');
INSERT INTO `t_region` VALUES ('2626', '500238', '巫溪县', '271', '0', '0', 'Wuxi Xian', 'WXX');
INSERT INTO `t_region` VALUES ('2627', '500240', '石柱土家族自治县', '271', '0', '0', 'Shizhu Tujiazu Zizhixian', 'SZY');
INSERT INTO `t_region` VALUES ('2628', '500241', '秀山土家族苗族自治县', '271', '0', '0', 'Xiushan Tujiazu Miaozu Zizhixian', 'XUS');
INSERT INTO `t_region` VALUES ('2629', '500242', '酉阳土家族苗族自治县', '271', '0', '0', 'Youyang Tujiazu Miaozu Zizhixian', 'YUY');
INSERT INTO `t_region` VALUES ('2630', '500243', '彭水苗族土家族自治县', '271', '0', '0', 'Pengshui Miaozu Tujiazu Zizhixian', 'PSU');
INSERT INTO `t_region` VALUES ('2631', '500116', '江津区', '272', '0', '0', 'Jiangjin Shi', '2');
INSERT INTO `t_region` VALUES ('2632', '500117', '合川区', '272', '0', '0', 'Hechuan Shi', '2');
INSERT INTO `t_region` VALUES ('2633', '500118', '永川区', '272', '0', '0', 'Yongchuan Shi', '2');
INSERT INTO `t_region` VALUES ('2634', '500119', '南川区', '272', '0', '0', 'Nanchuan Shi', '2');
INSERT INTO `t_region` VALUES ('2635', '510101', '市辖区', '273', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2636', '510104', '锦江区', '273', '0', '0', 'Jinjiang Qu', 'JJQ');
INSERT INTO `t_region` VALUES ('2637', '510105', '青羊区', '273', '0', '0', 'Qingyang Qu', 'QYQ');
INSERT INTO `t_region` VALUES ('2638', '510106', '金牛区', '273', '0', '0', 'Jinniu Qu', 'JNU');
INSERT INTO `t_region` VALUES ('2639', '510107', '武侯区', '273', '0', '0', 'Wuhou Qu', 'WHQ');
INSERT INTO `t_region` VALUES ('2640', '510108', '成华区', '273', '0', '0', 'Chenghua Qu', 'CHQ');
INSERT INTO `t_region` VALUES ('2641', '510112', '龙泉驿区', '273', '0', '0', 'Longquanyi Qu', 'LQY');
INSERT INTO `t_region` VALUES ('2642', '510113', '青白江区', '273', '0', '0', 'Qingbaijiang Qu', 'QBJ');
INSERT INTO `t_region` VALUES ('2643', '510114', '新都区', '273', '0', '0', 'Xindu Qu', '2');
INSERT INTO `t_region` VALUES ('2644', '510115', '温江区', '273', '0', '0', 'Wenjiang Qu', '2');
INSERT INTO `t_region` VALUES ('2645', '510121', '金堂县', '273', '0', '0', 'Jintang Xian', 'JNT');
INSERT INTO `t_region` VALUES ('2646', '510122', '双流县', '273', '0', '0', 'Shuangliu Xian', 'SLU');
INSERT INTO `t_region` VALUES ('2647', '510124', '郫县', '273', '0', '0', 'Pi Xian', 'PIX');
INSERT INTO `t_region` VALUES ('2648', '510129', '大邑县', '273', '0', '0', 'Dayi Xian', 'DYI');
INSERT INTO `t_region` VALUES ('2649', '510131', '蒲江县', '273', '0', '0', 'Pujiang Xian', 'PJX');
INSERT INTO `t_region` VALUES ('2650', '510132', '新津县', '273', '0', '0', 'Xinjin Xian', 'XJC');
INSERT INTO `t_region` VALUES ('2651', '510181', '都江堰市', '273', '0', '0', 'Dujiangyan Shi', 'DJY');
INSERT INTO `t_region` VALUES ('2652', '510182', '彭州市', '273', '0', '0', 'Pengzhou Shi', 'PZS');
INSERT INTO `t_region` VALUES ('2653', '510183', '邛崃市', '273', '0', '0', 'Qionglai Shi', 'QLA');
INSERT INTO `t_region` VALUES ('2654', '510184', '崇州市', '273', '0', '0', 'Chongzhou Shi', 'CZO');
INSERT INTO `t_region` VALUES ('2655', '510301', '市辖区', '274', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2656', '510302', '自流井区', '274', '0', '0', 'Ziliujing Qu', 'ZLJ');
INSERT INTO `t_region` VALUES ('2657', '510303', '贡井区', '274', '0', '0', 'Gongjing Qu', '2');
INSERT INTO `t_region` VALUES ('2658', '510304', '大安区', '274', '0', '0', 'Da,an Qu', 'DAQ');
INSERT INTO `t_region` VALUES ('2659', '510311', '沿滩区', '274', '0', '0', 'Yantan Qu', 'YTN');
INSERT INTO `t_region` VALUES ('2660', '510321', '荣县', '274', '0', '0', 'Rong Xian', 'RGX');
INSERT INTO `t_region` VALUES ('2661', '510322', '富顺县', '274', '0', '0', 'Fushun Xian', 'FSH');
INSERT INTO `t_region` VALUES ('2662', '510401', '市辖区', '275', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2663', '510402', '东区', '275', '0', '0', 'Dong Qu', 'DQP');
INSERT INTO `t_region` VALUES ('2664', '510403', '西区', '275', '0', '0', 'Xi Qu', 'XIQ');
INSERT INTO `t_region` VALUES ('2665', '510411', '仁和区', '275', '0', '0', 'Renhe Qu', 'RHQ');
INSERT INTO `t_region` VALUES ('2666', '510421', '米易县', '275', '0', '0', 'Miyi Xian', 'MIY');
INSERT INTO `t_region` VALUES ('2667', '510422', '盐边县', '275', '0', '0', 'Yanbian Xian', 'YBN');
INSERT INTO `t_region` VALUES ('2668', '510501', '市辖区', '276', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2669', '510502', '江阳区', '276', '0', '0', 'Jiangyang Qu', 'JYB');
INSERT INTO `t_region` VALUES ('2670', '510503', '纳溪区', '276', '0', '0', 'Naxi Qu', 'NXI');
INSERT INTO `t_region` VALUES ('2671', '510504', '龙马潭区', '276', '0', '0', 'Longmatan Qu', 'LMT');
INSERT INTO `t_region` VALUES ('2672', '510521', '泸县', '276', '0', '0', 'Lu Xian', 'LUX');
INSERT INTO `t_region` VALUES ('2673', '510522', '合江县', '276', '0', '0', 'Hejiang Xian', 'HEJ');
INSERT INTO `t_region` VALUES ('2674', '510524', '叙永县', '276', '0', '0', 'Xuyong Xian', 'XYO');
INSERT INTO `t_region` VALUES ('2675', '510525', '古蔺县', '276', '0', '0', 'Gulin Xian', 'GUL');
INSERT INTO `t_region` VALUES ('2676', '510601', '市辖区', '277', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2677', '510603', '旌阳区', '277', '0', '0', 'Jingyang Qu', 'JYF');
INSERT INTO `t_region` VALUES ('2678', '510623', '中江县', '277', '0', '0', 'Zhongjiang Xian', 'ZGJ');
INSERT INTO `t_region` VALUES ('2679', '510626', '罗江县', '277', '0', '0', 'Luojiang Xian', 'LOJ');
INSERT INTO `t_region` VALUES ('2680', '510681', '广汉市', '277', '0', '0', 'Guanghan Shi', 'GHN');
INSERT INTO `t_region` VALUES ('2681', '510682', '什邡市', '277', '0', '0', 'Shifang Shi', 'SFS');
INSERT INTO `t_region` VALUES ('2682', '510683', '绵竹市', '277', '0', '0', 'Jinzhou Shi', 'MZU');
INSERT INTO `t_region` VALUES ('2683', '510701', '市辖区', '278', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2684', '510703', '涪城区', '278', '0', '0', 'Fucheng Qu', 'FCM');
INSERT INTO `t_region` VALUES ('2685', '510704', '游仙区', '278', '0', '0', 'Youxian Qu', 'YXM');
INSERT INTO `t_region` VALUES ('2686', '510722', '三台县', '278', '0', '0', 'Santai Xian', 'SNT');
INSERT INTO `t_region` VALUES ('2687', '510723', '盐亭县', '278', '0', '0', 'Yanting Xian', 'YTC');
INSERT INTO `t_region` VALUES ('2688', '510724', '安县', '278', '0', '0', 'An Xian', 'AXN');
INSERT INTO `t_region` VALUES ('2689', '510725', '梓潼县', '278', '0', '0', 'Zitong Xian', 'ZTG');
INSERT INTO `t_region` VALUES ('2690', '510726', '北川羌族自治县', '278', '0', '0', 'Beichuanqiangzuzizhi Qu', '2');
INSERT INTO `t_region` VALUES ('2691', '510727', '平武县', '278', '0', '0', 'Pingwu Xian', 'PWU');
INSERT INTO `t_region` VALUES ('2692', '510781', '江油市', '278', '0', '0', 'Jiangyou Shi', 'JYO');
INSERT INTO `t_region` VALUES ('2693', '510801', '市辖区', '279', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2694', '511002', '市中区', '279', '0', '0', 'Shizhong Qu', 'SZM');
INSERT INTO `t_region` VALUES ('2695', '510811', '元坝区', '279', '0', '0', 'Yuanba Qu', 'YBQ');
INSERT INTO `t_region` VALUES ('2696', '510812', '朝天区', '279', '0', '0', 'Chaotian Qu', 'CTN');
INSERT INTO `t_region` VALUES ('2697', '510821', '旺苍县', '279', '0', '0', 'Wangcang Xian', 'WGC');
INSERT INTO `t_region` VALUES ('2698', '510822', '青川县', '279', '0', '0', 'Qingchuan Xian', 'QCX');
INSERT INTO `t_region` VALUES ('2699', '510823', '剑阁县', '279', '0', '0', 'Jiange Xian', 'JGE');
INSERT INTO `t_region` VALUES ('2700', '510824', '苍溪县', '279', '0', '0', 'Cangxi Xian', 'CXC');
INSERT INTO `t_region` VALUES ('2701', '510901', '市辖区', '280', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2702', '510903', '船山区', '280', '0', '0', 'Chuanshan Qu', '2');
INSERT INTO `t_region` VALUES ('2703', '510904', '安居区', '280', '0', '0', 'Anju Qu', '2');
INSERT INTO `t_region` VALUES ('2704', '510921', '蓬溪县', '280', '0', '0', 'Pengxi Xian', 'PXI');
INSERT INTO `t_region` VALUES ('2705', '510922', '射洪县', '280', '0', '0', 'Shehong Xian', 'SHE');
INSERT INTO `t_region` VALUES ('2706', '510923', '大英县', '280', '0', '0', 'Daying Xian', 'DAY');
INSERT INTO `t_region` VALUES ('2707', '511001', '市辖区', '281', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2708', '511002', '市中区', '281', '0', '0', 'Shizhong Qu', 'SZM');
INSERT INTO `t_region` VALUES ('2709', '511011', '东兴区', '281', '0', '0', 'Dongxing Qu', 'DXQ');
INSERT INTO `t_region` VALUES ('2710', '511024', '威远县', '281', '0', '0', 'Weiyuan Xian', 'WYU');
INSERT INTO `t_region` VALUES ('2711', '511025', '资中县', '281', '0', '0', 'Zizhong Xian', 'ZZC');
INSERT INTO `t_region` VALUES ('2712', '511028', '隆昌县', '281', '0', '0', 'Longchang Xian', 'LCC');
INSERT INTO `t_region` VALUES ('2713', '511101', '市辖区', '282', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2714', '511102', '市中区', '282', '0', '0', 'Shizhong Qu', 'SZP');
INSERT INTO `t_region` VALUES ('2715', '511111', '沙湾区', '282', '0', '0', 'Shawan Qu', 'SWN');
INSERT INTO `t_region` VALUES ('2716', '511112', '五通桥区', '282', '0', '0', 'Wutongqiao Qu', 'WTQ');
INSERT INTO `t_region` VALUES ('2717', '511113', '金口河区', '282', '0', '0', 'Jinkouhe Qu', 'JKH');
INSERT INTO `t_region` VALUES ('2718', '511123', '犍为县', '282', '0', '0', 'Qianwei Xian', 'QWE');
INSERT INTO `t_region` VALUES ('2719', '511124', '井研县', '282', '0', '0', 'Jingyan Xian', 'JYA');
INSERT INTO `t_region` VALUES ('2720', '511126', '夹江县', '282', '0', '0', 'Jiajiang Xian', 'JJC');
INSERT INTO `t_region` VALUES ('2721', '511129', '沐川县', '282', '0', '0', 'Muchuan Xian', 'MCH');
INSERT INTO `t_region` VALUES ('2722', '511132', '峨边彝族自治县', '282', '0', '0', 'Ebian Yizu Zizhixian', 'EBN');
INSERT INTO `t_region` VALUES ('2723', '511133', '马边彝族自治县', '282', '0', '0', 'Mabian Yizu Zizhixian', 'MBN');
INSERT INTO `t_region` VALUES ('2724', '511181', '峨眉山市', '282', '0', '0', 'Emeishan Shi', 'EMS');
INSERT INTO `t_region` VALUES ('2725', '511301', '市辖区', '283', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2726', '511302', '顺庆区', '283', '0', '0', 'Shunqing Xian', 'SQG');
INSERT INTO `t_region` VALUES ('2727', '511303', '高坪区', '283', '0', '0', 'Gaoping Qu', 'GPQ');
INSERT INTO `t_region` VALUES ('2728', '511304', '嘉陵区', '283', '0', '0', 'Jialing Qu', 'JLG');
INSERT INTO `t_region` VALUES ('2729', '511321', '南部县', '283', '0', '0', 'Nanbu Xian', 'NBU');
INSERT INTO `t_region` VALUES ('2730', '511322', '营山县', '283', '0', '0', 'Yingshan Xian', 'YGS');
INSERT INTO `t_region` VALUES ('2731', '511323', '蓬安县', '283', '0', '0', 'Peng,an Xian', 'PGA');
INSERT INTO `t_region` VALUES ('2732', '511324', '仪陇县', '283', '0', '0', 'Yilong Xian', 'YLC');
INSERT INTO `t_region` VALUES ('2733', '511325', '西充县', '283', '0', '0', 'Xichong Xian', 'XCO');
INSERT INTO `t_region` VALUES ('2734', '511381', '阆中市', '283', '0', '0', 'Langzhong Shi', 'LZJ');
INSERT INTO `t_region` VALUES ('2735', '511401', '市辖区', '284', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2736', '511402', '东坡区', '284', '0', '0', 'Dongpo Qu', '2');
INSERT INTO `t_region` VALUES ('2737', '511421', '仁寿县', '284', '0', '0', 'Renshou Xian', '2');
INSERT INTO `t_region` VALUES ('2738', '511422', '彭山县', '284', '0', '0', 'Pengshan Xian', '2');
INSERT INTO `t_region` VALUES ('2739', '511423', '洪雅县', '284', '0', '0', 'Hongya Xian', '2');
INSERT INTO `t_region` VALUES ('2740', '511424', '丹棱县', '284', '0', '0', 'Danling Xian', '2');
INSERT INTO `t_region` VALUES ('2741', '511425', '青神县', '284', '0', '0', 'Qingshen Xian', '2');
INSERT INTO `t_region` VALUES ('2742', '511501', '市辖区', '285', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2743', '511502', '翠屏区', '285', '0', '0', 'Cuiping Qu', 'CPQ');
INSERT INTO `t_region` VALUES ('2744', '511521', '宜宾县', '285', '0', '0', 'Yibin Xian', 'YBX');
INSERT INTO `t_region` VALUES ('2745', '511522', '南溪县', '285', '0', '0', 'Nanxi Xian', 'NNX');
INSERT INTO `t_region` VALUES ('2746', '511523', '江安县', '285', '0', '0', 'Jiang,an Xian', 'JAC');
INSERT INTO `t_region` VALUES ('2747', '511524', '长宁县', '285', '0', '0', 'Changning Xian', 'CNX');
INSERT INTO `t_region` VALUES ('2748', '511525', '高县', '285', '0', '0', 'Gao Xian', 'GAO');
INSERT INTO `t_region` VALUES ('2749', '511526', '珙县', '285', '0', '0', 'Gong Xian', 'GOG');
INSERT INTO `t_region` VALUES ('2750', '511527', '筠连县', '285', '0', '0', 'Junlian Xian', 'JNL');
INSERT INTO `t_region` VALUES ('2751', '511528', '兴文县', '285', '0', '0', 'Xingwen Xian', 'XWC');
INSERT INTO `t_region` VALUES ('2752', '511529', '屏山县', '285', '0', '0', 'Pingshan Xian', 'PSC');
INSERT INTO `t_region` VALUES ('2753', '511601', '市辖区', '286', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2754', '511602', '广安区', '286', '0', '0', 'Guang,an Qu', 'GAQ');
INSERT INTO `t_region` VALUES ('2755', '511621', '岳池县', '286', '0', '0', 'Yuechi Xian', 'YCC');
INSERT INTO `t_region` VALUES ('2756', '511622', '武胜县', '286', '0', '0', 'Wusheng Xian', 'WSG');
INSERT INTO `t_region` VALUES ('2757', '511623', '邻水县', '286', '0', '0', 'Linshui Xian', 'LSH');
INSERT INTO `t_region` VALUES ('2759', '511701', '市辖区', '287', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2760', '511702', '通川区', '287', '0', '0', 'Tongchuan Qu', '2');
INSERT INTO `t_region` VALUES ('2761', '511721', '达县', '287', '0', '0', 'Da Xian', '2');
INSERT INTO `t_region` VALUES ('2762', '511722', '宣汉县', '287', '0', '0', 'Xuanhan Xian', '2');
INSERT INTO `t_region` VALUES ('2763', '511723', '开江县', '287', '0', '0', 'Kaijiang Xian', '2');
INSERT INTO `t_region` VALUES ('2764', '511724', '大竹县', '287', '0', '0', 'Dazhu Xian', '2');
INSERT INTO `t_region` VALUES ('2765', '511725', '渠县', '287', '0', '0', 'Qu Xian', '2');
INSERT INTO `t_region` VALUES ('2766', '511781', '万源市', '287', '0', '0', 'Wanyuan Shi', '2');
INSERT INTO `t_region` VALUES ('2767', '511801', '市辖区', '288', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2768', '511802', '雨城区', '288', '0', '0', 'Yucheg Qu', '2');
INSERT INTO `t_region` VALUES ('2769', '511821', '名山县', '288', '0', '0', 'Mingshan Xian', '2');
INSERT INTO `t_region` VALUES ('2770', '511822', '荥经县', '288', '0', '0', 'Yingjing Xian', '2');
INSERT INTO `t_region` VALUES ('2771', '511823', '汉源县', '288', '0', '0', 'Hanyuan Xian', '2');
INSERT INTO `t_region` VALUES ('2772', '511824', '石棉县', '288', '0', '0', 'Shimian Xian', '2');
INSERT INTO `t_region` VALUES ('2773', '511825', '天全县', '288', '0', '0', 'Tianquan Xian', '2');
INSERT INTO `t_region` VALUES ('2774', '511826', '芦山县', '288', '0', '0', 'Lushan Xian', '2');
INSERT INTO `t_region` VALUES ('2775', '511827', '宝兴县', '288', '0', '0', 'Baoxing Xian', '2');
INSERT INTO `t_region` VALUES ('2776', '511901', '市辖区', '289', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2777', '511902', '巴州区', '289', '0', '0', 'Bazhou Qu', '2');
INSERT INTO `t_region` VALUES ('2778', '511921', '通江县', '289', '0', '0', 'Tongjiang Xian', '2');
INSERT INTO `t_region` VALUES ('2779', '511922', '南江县', '289', '0', '0', 'Nanjiang Xian', '2');
INSERT INTO `t_region` VALUES ('2780', '511923', '平昌县', '289', '0', '0', 'Pingchang Xian', '2');
INSERT INTO `t_region` VALUES ('2781', '512001', '市辖区', '290', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2782', '512002', '雁江区', '290', '0', '0', 'Yanjiang Qu', '2');
INSERT INTO `t_region` VALUES ('2783', '512021', '安岳县', '290', '0', '0', 'Anyue Xian', '2');
INSERT INTO `t_region` VALUES ('2784', '512022', '乐至县', '290', '0', '0', 'Lezhi Xian', '2');
INSERT INTO `t_region` VALUES ('2785', '512081', '简阳市', '290', '0', '0', 'Jianyang Shi', '2');
INSERT INTO `t_region` VALUES ('2786', '513221', '汶川县', '291', '0', '0', 'Wenchuan Xian', 'WNC');
INSERT INTO `t_region` VALUES ('2787', '513222', '理县', '291', '0', '0', 'Li Xian', 'LXC');
INSERT INTO `t_region` VALUES ('2788', '513223', '茂县', '291', '0', '0', 'Mao Xian', 'MAO');
INSERT INTO `t_region` VALUES ('2789', '513224', '松潘县', '291', '0', '0', 'Songpan Xian', 'SOP');
INSERT INTO `t_region` VALUES ('2790', '513225', '九寨沟县', '291', '0', '0', 'Jiuzhaigou Xian', 'JZG');
INSERT INTO `t_region` VALUES ('2791', '513226', '金川县', '291', '0', '0', 'Jinchuan Xian', 'JCH');
INSERT INTO `t_region` VALUES ('2792', '513227', '小金县', '291', '0', '0', 'Xiaojin Xian', 'XJX');
INSERT INTO `t_region` VALUES ('2793', '513228', '黑水县', '291', '0', '0', 'Heishui Xian', 'HIS');
INSERT INTO `t_region` VALUES ('2794', '513229', '马尔康县', '291', '0', '0', 'Barkam Xian', 'BAK');
INSERT INTO `t_region` VALUES ('2795', '513230', '壤塘县', '291', '0', '0', 'Zamtang Xian', 'ZAM');
INSERT INTO `t_region` VALUES ('2796', '513231', '阿坝县', '291', '0', '0', 'Aba(Ngawa) Xian', 'ABX');
INSERT INTO `t_region` VALUES ('2797', '513232', '若尔盖县', '291', '0', '0', 'ZoigeXian', 'ZOI');
INSERT INTO `t_region` VALUES ('2798', '513233', '红原县', '291', '0', '0', 'Hongyuan Xian', 'HOY');
INSERT INTO `t_region` VALUES ('2799', '513321', '康定县', '292', '0', '0', 'Kangding(Dardo) Xian', 'KDX');
INSERT INTO `t_region` VALUES ('2800', '513322', '泸定县', '292', '0', '0', 'Luding(Jagsamka) Xian', 'LUD');
INSERT INTO `t_region` VALUES ('2801', '513323', '丹巴县', '292', '0', '0', 'Danba(Rongzhag) Xian', 'DBA');
INSERT INTO `t_region` VALUES ('2802', '513324', '九龙县', '292', '0', '0', 'Jiulong(Gyaisi) Xian', 'JLC');
INSERT INTO `t_region` VALUES ('2803', '513325', '雅江县', '292', '0', '0', 'Yajiang(Nyagquka) Xian', 'YAJ');
INSERT INTO `t_region` VALUES ('2804', '513326', '道孚县', '292', '0', '0', 'Dawu Xian', 'DAW');
INSERT INTO `t_region` VALUES ('2805', '513327', '炉霍县', '292', '0', '0', 'Luhuo(Zhaggo) Xian', 'LUH');
INSERT INTO `t_region` VALUES ('2806', '513328', '甘孜县', '292', '0', '0', 'Garze Xian', 'GRZ');
INSERT INTO `t_region` VALUES ('2807', '513329', '新龙县', '292', '0', '0', 'Xinlong(Nyagrong) Xian', 'XLG');
INSERT INTO `t_region` VALUES ('2808', '513330', '德格县', '292', '0', '0', 'DegeXian', 'DEG');
INSERT INTO `t_region` VALUES ('2809', '513331', '白玉县', '292', '0', '0', 'Baiyu Xian', 'BYC');
INSERT INTO `t_region` VALUES ('2810', '513332', '石渠县', '292', '0', '0', 'Serxv Xian', 'SER');
INSERT INTO `t_region` VALUES ('2811', '513333', '色达县', '292', '0', '0', 'Sertar Xian', 'STX');
INSERT INTO `t_region` VALUES ('2812', '513334', '理塘县', '292', '0', '0', 'Litang Xian', 'LIT');
INSERT INTO `t_region` VALUES ('2813', '513335', '巴塘县', '292', '0', '0', 'Batang Xian', 'BTC');
INSERT INTO `t_region` VALUES ('2814', '513336', '乡城县', '292', '0', '0', 'Xiangcheng(Qagcheng) Xian', 'XCC');
INSERT INTO `t_region` VALUES ('2815', '513337', '稻城县', '292', '0', '0', 'Daocheng(Dabba) Xian', 'DCX');
INSERT INTO `t_region` VALUES ('2816', '513338', '得荣县', '292', '0', '0', 'Derong Xian', 'DER');
INSERT INTO `t_region` VALUES ('2817', '513401', '西昌市', '293', '0', '0', 'Xichang Shi', 'XCA');
INSERT INTO `t_region` VALUES ('2818', '513422', '木里藏族自治县', '293', '0', '0', 'Muli Zangzu Zizhixian', 'MLI');
INSERT INTO `t_region` VALUES ('2819', '513423', '盐源县', '293', '0', '0', 'Yanyuan Xian', 'YYU');
INSERT INTO `t_region` VALUES ('2820', '513424', '德昌县', '293', '0', '0', 'Dechang Xian', 'DEC');
INSERT INTO `t_region` VALUES ('2821', '513425', '会理县', '293', '0', '0', 'Huili Xian', 'HLI');
INSERT INTO `t_region` VALUES ('2822', '513426', '会东县', '293', '0', '0', 'Huidong Xian', 'HDG');
INSERT INTO `t_region` VALUES ('2823', '513427', '宁南县', '293', '0', '0', 'Ningnan Xian', 'NIN');
INSERT INTO `t_region` VALUES ('2824', '513428', '普格县', '293', '0', '0', 'Puge Xian', 'PGE');
INSERT INTO `t_region` VALUES ('2825', '513429', '布拖县', '293', '0', '0', 'Butuo Xian', 'BTO');
INSERT INTO `t_region` VALUES ('2826', '513430', '金阳县', '293', '0', '0', 'Jinyang Xian', 'JYW');
INSERT INTO `t_region` VALUES ('2827', '513431', '昭觉县', '293', '0', '0', 'Zhaojue Xian', 'ZJE');
INSERT INTO `t_region` VALUES ('2828', '513432', '喜德县', '293', '0', '0', 'Xide Xian', 'XDE');
INSERT INTO `t_region` VALUES ('2829', '513433', '冕宁县', '293', '0', '0', 'Mianning Xian', 'MNG');
INSERT INTO `t_region` VALUES ('2830', '513434', '越西县', '293', '0', '0', 'Yuexi Xian', 'YXC');
INSERT INTO `t_region` VALUES ('2831', '513435', '甘洛县', '293', '0', '0', 'Ganluo Xian', 'GLO');
INSERT INTO `t_region` VALUES ('2832', '513436', '美姑县', '293', '0', '0', 'Meigu Xian', 'MEG');
INSERT INTO `t_region` VALUES ('2833', '513437', '雷波县', '293', '0', '0', 'Leibo Xian', 'LBX');
INSERT INTO `t_region` VALUES ('2834', '520101', '市辖区', '294', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2835', '520102', '南明区', '294', '0', '0', 'Nanming Qu', 'NMQ');
INSERT INTO `t_region` VALUES ('2836', '520103', '云岩区', '294', '0', '0', 'Yunyan Qu', 'YYQ');
INSERT INTO `t_region` VALUES ('2837', '520111', '花溪区', '294', '0', '0', 'Huaxi Qu', 'HXI');
INSERT INTO `t_region` VALUES ('2838', '520112', '乌当区', '294', '0', '0', 'Wudang Qu', 'WDQ');
INSERT INTO `t_region` VALUES ('2839', '520113', '白云区', '294', '0', '0', 'Baiyun Qu', 'BYU');
INSERT INTO `t_region` VALUES ('2840', '520114', '小河区', '294', '0', '0', 'Xiaohe Qu', '2');
INSERT INTO `t_region` VALUES ('2841', '520121', '开阳县', '294', '0', '0', 'Kaiyang Xian', 'KYG');
INSERT INTO `t_region` VALUES ('2842', '520122', '息烽县', '294', '0', '0', 'Xifeng Xian', 'XFX');
INSERT INTO `t_region` VALUES ('2843', '520123', '修文县', '294', '0', '0', 'Xiuwen Xian', 'XWX');
INSERT INTO `t_region` VALUES ('2844', '520181', '清镇市', '294', '0', '0', 'Qingzhen Shi', 'QZN');
INSERT INTO `t_region` VALUES ('2845', '520201', '钟山区', '295', '0', '0', 'Zhongshan Qu', 'ZSQ');
INSERT INTO `t_region` VALUES ('2846', '520203', '六枝特区', '295', '0', '0', 'Liuzhi Tequ', 'LZT');
INSERT INTO `t_region` VALUES ('2847', '520221', '水城县', '295', '0', '0', 'Shuicheng Xian', 'SUC');
INSERT INTO `t_region` VALUES ('2848', '520222', '盘县', '295', '0', '0', 'Pan Xian', '2');
INSERT INTO `t_region` VALUES ('2849', '520301', '市辖区', '296', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2850', '520302', '红花岗区', '296', '0', '0', 'Honghuagang Qu', 'HHG');
INSERT INTO `t_region` VALUES ('2851', '520303', '汇川区', '296', '0', '0', 'Huichuan Qu', '2');
INSERT INTO `t_region` VALUES ('2852', '520321', '遵义县', '296', '0', '0', 'Zunyi Xian', 'ZYI');
INSERT INTO `t_region` VALUES ('2853', '520322', '桐梓县', '296', '0', '0', 'Tongzi Xian', 'TZI');
INSERT INTO `t_region` VALUES ('2854', '520323', '绥阳县', '296', '0', '0', 'Suiyang Xian', 'SUY');
INSERT INTO `t_region` VALUES ('2855', '520324', '正安县', '296', '0', '0', 'Zhengan Xan', '2');
INSERT INTO `t_region` VALUES ('2856', '520325', '道真仡佬族苗族自治县', '296', '0', '0', 'Daozhen Gelaozu Miaozu Zizhixian', 'DZN');
INSERT INTO `t_region` VALUES ('2857', '520326', '务川仡佬族苗族自治县', '296', '0', '0', 'Wuchuan Gelaozu Miaozu Zizhixian', 'WCU');
INSERT INTO `t_region` VALUES ('2858', '520327', '凤冈县', '296', '0', '0', 'Fenggang Xian', 'FGG');
INSERT INTO `t_region` VALUES ('2859', '520328', '湄潭县', '296', '0', '0', 'Meitan Xian', 'MTN');
INSERT INTO `t_region` VALUES ('2860', '520329', '余庆县', '296', '0', '0', 'Yuqing Xian', 'YUQ');
INSERT INTO `t_region` VALUES ('2861', '520330', '习水县', '296', '0', '0', 'Xishui Xian', 'XSI');
INSERT INTO `t_region` VALUES ('2862', '520381', '赤水市', '296', '0', '0', 'Chishui Shi', 'CSS');
INSERT INTO `t_region` VALUES ('2863', '520382', '仁怀市', '296', '0', '0', 'Renhuai Shi', 'RHS');
INSERT INTO `t_region` VALUES ('2864', '520401', '市辖区', '297', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2865', '520402', '西秀区', '297', '0', '0', 'Xixiu Qu', '2');
INSERT INTO `t_region` VALUES ('2866', '520421', '平坝县', '297', '0', '0', 'Pingba Xian', '2');
INSERT INTO `t_region` VALUES ('2867', '520422', '普定县', '297', '0', '0', 'Puding Xian', '2');
INSERT INTO `t_region` VALUES ('2868', '520423', '镇宁布依族苗族自治县', '297', '0', '0', 'Zhenning Buyeizu Miaozu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2869', '520424', '关岭布依族苗族自治县', '297', '0', '0', 'Guanling Buyeizu Miaozu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2870', '520425', '紫云苗族布依族自治县', '297', '0', '0', 'Ziyun Miaozu Buyeizu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2871', '522201', '铜仁市', '298', '0', '0', 'Tongren Shi', 'TRS');
INSERT INTO `t_region` VALUES ('2872', '522222', '江口县', '298', '0', '0', 'Jiangkou Xian', 'JGK');
INSERT INTO `t_region` VALUES ('2873', '522223', '玉屏侗族自治县', '298', '0', '0', 'Yuping Dongzu Zizhixian', 'YPG');
INSERT INTO `t_region` VALUES ('2874', '522224', '石阡县', '298', '0', '0', 'Shiqian Xian', 'SQI');
INSERT INTO `t_region` VALUES ('2875', '522225', '思南县', '298', '0', '0', 'Sinan Xian', 'SNA');
INSERT INTO `t_region` VALUES ('2876', '522226', '印江土家族苗族自治县', '298', '0', '0', 'Yinjiang Tujiazu Miaozu Zizhixian', 'YJY');
INSERT INTO `t_region` VALUES ('2877', '522227', '德江县', '298', '0', '0', 'Dejiang Xian', 'DEJ');
INSERT INTO `t_region` VALUES ('2878', '522228', '沿河土家族自治县', '298', '0', '0', 'Yanhe Tujiazu Zizhixian', 'YHE');
INSERT INTO `t_region` VALUES ('2879', '522229', '松桃苗族自治县', '298', '0', '0', 'Songtao Miaozu Zizhixian', 'STM');
INSERT INTO `t_region` VALUES ('2880', '522230', '万山特区', '298', '0', '0', 'Wanshan Tequ', 'WAS');
INSERT INTO `t_region` VALUES ('2881', '522301', '兴义市', '299', '0', '0', 'Xingyi Shi', 'XYI');
INSERT INTO `t_region` VALUES ('2882', '522322', '兴仁县', '299', '0', '0', 'Xingren Xian', 'XRN');
INSERT INTO `t_region` VALUES ('2883', '522323', '普安县', '299', '0', '0', 'Pu,an Xian', 'PUA');
INSERT INTO `t_region` VALUES ('2884', '522324', '晴隆县', '299', '0', '0', 'Qinglong Xian', 'QLG');
INSERT INTO `t_region` VALUES ('2885', '522325', '贞丰县', '299', '0', '0', 'Zhenfeng Xian', 'ZFG');
INSERT INTO `t_region` VALUES ('2886', '522326', '望谟县', '299', '0', '0', 'Wangmo Xian', 'WMO');
INSERT INTO `t_region` VALUES ('2887', '522327', '册亨县', '299', '0', '0', 'Ceheng Xian', 'CEH');
INSERT INTO `t_region` VALUES ('2888', '522328', '安龙县', '299', '0', '0', 'Anlong Xian', 'ALG');
INSERT INTO `t_region` VALUES ('2889', '522401', '毕节市', '300', '0', '0', 'Bijie Shi', 'BJE');
INSERT INTO `t_region` VALUES ('2890', '522422', '大方县', '300', '0', '0', 'Dafang Xian', 'DAF');
INSERT INTO `t_region` VALUES ('2891', '522423', '黔西县', '300', '0', '0', 'Qianxi Xian', 'QNX');
INSERT INTO `t_region` VALUES ('2892', '522424', '金沙县', '300', '0', '0', 'Jinsha Xian', 'JSX');
INSERT INTO `t_region` VALUES ('2893', '522425', '织金县', '300', '0', '0', 'Zhijin Xian', 'ZJN');
INSERT INTO `t_region` VALUES ('2894', '522426', '纳雍县', '300', '0', '0', 'Nayong Xian', 'NYG');
INSERT INTO `t_region` VALUES ('2895', '522427', '威宁彝族回族苗族自治县', '300', '0', '0', 'Weining Yizu Huizu Miaozu Zizhixian', 'WNG');
INSERT INTO `t_region` VALUES ('2896', '522428', '赫章县', '300', '0', '0', 'Hezhang Xian', 'HZA');
INSERT INTO `t_region` VALUES ('2897', '522601', '凯里市', '301', '0', '0', 'Kaili Shi', 'KLS');
INSERT INTO `t_region` VALUES ('2898', '522622', '黄平县', '301', '0', '0', 'Huangping Xian', 'HPN');
INSERT INTO `t_region` VALUES ('2899', '522623', '施秉县', '301', '0', '0', 'Shibing Xian', 'SBG');
INSERT INTO `t_region` VALUES ('2900', '522624', '三穗县', '301', '0', '0', 'Sansui Xian', 'SAS');
INSERT INTO `t_region` VALUES ('2901', '522625', '镇远县', '301', '0', '0', 'Zhenyuan Xian', 'ZYX');
INSERT INTO `t_region` VALUES ('2902', '522626', '岑巩县', '301', '0', '0', 'Cengong Xian', 'CGX');
INSERT INTO `t_region` VALUES ('2903', '522627', '天柱县', '301', '0', '0', 'Tianzhu Xian', 'TZU');
INSERT INTO `t_region` VALUES ('2904', '522628', '锦屏县', '301', '0', '0', 'Jinping Xian', 'JPX');
INSERT INTO `t_region` VALUES ('2905', '522629', '剑河县', '301', '0', '0', 'Jianhe Xian', 'JHE');
INSERT INTO `t_region` VALUES ('2906', '522630', '台江县', '301', '0', '0', 'Taijiang Xian', 'TJX');
INSERT INTO `t_region` VALUES ('2907', '522631', '黎平县', '301', '0', '0', 'Liping Xian', 'LIP');
INSERT INTO `t_region` VALUES ('2908', '522632', '榕江县', '301', '0', '0', 'Rongjiang Xian', 'RJG');
INSERT INTO `t_region` VALUES ('2909', '522633', '从江县', '301', '0', '0', 'Congjiang Xian', 'COJ');
INSERT INTO `t_region` VALUES ('2910', '522634', '雷山县', '301', '0', '0', 'Leishan Xian', 'LSA');
INSERT INTO `t_region` VALUES ('2911', '522635', '麻江县', '301', '0', '0', 'Majiang Xian', 'MAJ');
INSERT INTO `t_region` VALUES ('2912', '522636', '丹寨县', '301', '0', '0', 'Danzhai Xian', 'DZH');
INSERT INTO `t_region` VALUES ('2913', '522701', '都匀市', '302', '0', '0', 'Duyun Shi', 'DUY');
INSERT INTO `t_region` VALUES ('2914', '522702', '福泉市', '302', '0', '0', 'Fuquan Shi', 'FQN');
INSERT INTO `t_region` VALUES ('2915', '522722', '荔波县', '302', '0', '0', 'Libo Xian', 'LBO');
INSERT INTO `t_region` VALUES ('2916', '522723', '贵定县', '302', '0', '0', 'Guiding Xian', 'GDG');
INSERT INTO `t_region` VALUES ('2917', '522725', '瓮安县', '302', '0', '0', 'Weng,an Xian', 'WGA');
INSERT INTO `t_region` VALUES ('2918', '522726', '独山县', '302', '0', '0', 'Dushan Xian', 'DSX');
INSERT INTO `t_region` VALUES ('2919', '522727', '平塘县', '302', '0', '0', 'Pingtang Xian', 'PTG');
INSERT INTO `t_region` VALUES ('2920', '522728', '罗甸县', '302', '0', '0', 'Luodian Xian', 'LOD');
INSERT INTO `t_region` VALUES ('2921', '522729', '长顺县', '302', '0', '0', 'Changshun Xian', 'CSU');
INSERT INTO `t_region` VALUES ('2922', '522730', '龙里县', '302', '0', '0', 'Longli Xian', 'LLI');
INSERT INTO `t_region` VALUES ('2923', '522731', '惠水县', '302', '0', '0', 'Huishui Xian', 'HUS');
INSERT INTO `t_region` VALUES ('2924', '522732', '三都水族自治县', '302', '0', '0', 'Sandu Suizu Zizhixian', 'SDU');
INSERT INTO `t_region` VALUES ('2925', '530101', '市辖区', '303', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2926', '530102', '五华区', '303', '0', '0', 'Wuhua Qu', 'WHA');
INSERT INTO `t_region` VALUES ('2927', '530103', '盘龙区', '303', '0', '0', 'Panlong Qu', 'PLQ');
INSERT INTO `t_region` VALUES ('2928', '530111', '官渡区', '303', '0', '0', 'Guandu Qu', 'GDU');
INSERT INTO `t_region` VALUES ('2929', '530112', '西山区', '303', '0', '0', 'Xishan Qu', 'XSN');
INSERT INTO `t_region` VALUES ('2930', '530113', '东川区', '303', '0', '0', 'Dongchuan Qu', 'DCU');
INSERT INTO `t_region` VALUES ('2931', '530121', '呈贡县', '303', '0', '0', 'Chenggong Xian', 'CGD');
INSERT INTO `t_region` VALUES ('2932', '530122', '晋宁县', '303', '0', '0', 'Jinning Xian', 'JND');
INSERT INTO `t_region` VALUES ('2933', '530124', '富民县', '303', '0', '0', 'Fumin Xian', 'FMN');
INSERT INTO `t_region` VALUES ('2934', '530125', '宜良县', '303', '0', '0', 'Yiliang Xian', 'YIL');
INSERT INTO `t_region` VALUES ('2935', '530126', '石林彝族自治县', '303', '0', '0', 'Shilin Yizu Zizhixian', 'SLY');
INSERT INTO `t_region` VALUES ('2936', '530127', '嵩明县', '303', '0', '0', 'Songming Xian', 'SMI');
INSERT INTO `t_region` VALUES ('2937', '530128', '禄劝彝族苗族自治县', '303', '0', '0', 'Luchuan Yizu Miaozu Zizhixian', 'LUC');
INSERT INTO `t_region` VALUES ('2938', '530129', '寻甸回族彝族自治县', '303', '0', '0', 'Xundian Huizu Yizu Zizhixian', 'XDN');
INSERT INTO `t_region` VALUES ('2939', '530181', '安宁市', '303', '0', '0', 'Anning Shi', 'ANG');
INSERT INTO `t_region` VALUES ('2940', '530301', '市辖区', '304', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2941', '530302', '麒麟区', '304', '0', '0', 'Qilin Xian', 'QLQ');
INSERT INTO `t_region` VALUES ('2942', '530321', '马龙县', '304', '0', '0', 'Malong Xian', 'MLO');
INSERT INTO `t_region` VALUES ('2943', '530322', '陆良县', '304', '0', '0', 'Luliang Xian', 'LLX');
INSERT INTO `t_region` VALUES ('2944', '530323', '师宗县', '304', '0', '0', 'Shizong Xian', 'SZD');
INSERT INTO `t_region` VALUES ('2945', '530324', '罗平县', '304', '0', '0', 'Luoping Xian', 'LPX');
INSERT INTO `t_region` VALUES ('2946', '530325', '富源县', '304', '0', '0', 'Fuyuan Xian', 'FYD');
INSERT INTO `t_region` VALUES ('2947', '530326', '会泽县', '304', '0', '0', 'Huize Xian', 'HUZ');
INSERT INTO `t_region` VALUES ('2948', '530328', '沾益县', '304', '0', '0', 'Zhanyi Xian', 'ZYD');
INSERT INTO `t_region` VALUES ('2949', '530381', '宣威市', '304', '0', '0', 'Xuanwei Shi', 'XWS');
INSERT INTO `t_region` VALUES ('2950', '530401', '市辖区', '305', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('2951', '530402', '红塔区', '305', '0', '0', 'Hongta Qu', 'HTA');
INSERT INTO `t_region` VALUES ('2952', '530421', '江川县', '305', '0', '0', 'Jiangchuan Xian', 'JGC');
INSERT INTO `t_region` VALUES ('2953', '530422', '澄江县', '305', '0', '0', 'Chengjiang Xian', 'CGJ');
INSERT INTO `t_region` VALUES ('2954', '530423', '通海县', '305', '0', '0', 'Tonghai Xian', 'THI');
INSERT INTO `t_region` VALUES ('2955', '530424', '华宁县', '305', '0', '0', 'Huaning Xian', 'HND');
INSERT INTO `t_region` VALUES ('2956', '530425', '易门县', '305', '0', '0', 'Yimen Xian', 'YMD');
INSERT INTO `t_region` VALUES ('2957', '530426', '峨山彝族自治县', '305', '0', '0', 'Eshan Yizu Zizhixian', 'ESN');
INSERT INTO `t_region` VALUES ('2958', '530427', '新平彝族傣族自治县', '305', '0', '0', 'Xinping Yizu Daizu Zizhixian', 'XNP');
INSERT INTO `t_region` VALUES ('2959', '530428', '元江哈尼族彝族傣族自治县', '305', '0', '0', 'Yuanjiang Hanizu Yizu Daizu Zizhixian', 'YJA');
INSERT INTO `t_region` VALUES ('2960', '530501', '市辖区', '306', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2961', '530502', '隆阳区', '306', '0', '0', 'Longyang Qu', '2');
INSERT INTO `t_region` VALUES ('2962', '530521', '施甸县', '306', '0', '0', 'Shidian Xian', '2');
INSERT INTO `t_region` VALUES ('2963', '530522', '腾冲县', '306', '0', '0', 'Tengchong Xian', '2');
INSERT INTO `t_region` VALUES ('2964', '530523', '龙陵县', '306', '0', '0', 'Longling Xian', '2');
INSERT INTO `t_region` VALUES ('2965', '530524', '昌宁县', '306', '0', '0', 'Changning Xian', '2');
INSERT INTO `t_region` VALUES ('2966', '530601', '市辖区', '307', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2967', '530602', '昭阳区', '307', '0', '0', 'Zhaoyang Qu', '2');
INSERT INTO `t_region` VALUES ('2968', '530621', '鲁甸县', '307', '0', '0', 'Ludian Xian', '2');
INSERT INTO `t_region` VALUES ('2969', '530622', '巧家县', '307', '0', '0', 'Qiaojia Xian', '2');
INSERT INTO `t_region` VALUES ('2970', '530623', '盐津县', '307', '0', '0', 'Yanjin Xian', '2');
INSERT INTO `t_region` VALUES ('2971', '530624', '大关县', '307', '0', '0', 'Daguan Xian', '2');
INSERT INTO `t_region` VALUES ('2972', '530625', '永善县', '307', '0', '0', 'Yongshan Xian', '2');
INSERT INTO `t_region` VALUES ('2973', '530626', '绥江县', '307', '0', '0', 'Suijiang Xian', '2');
INSERT INTO `t_region` VALUES ('2974', '530627', '镇雄县', '307', '0', '0', 'Zhenxiong Xian', '2');
INSERT INTO `t_region` VALUES ('2975', '530628', '彝良县', '307', '0', '0', 'Yiliang Xian', '2');
INSERT INTO `t_region` VALUES ('2976', '530629', '威信县', '307', '0', '0', 'Weixin Xian', '2');
INSERT INTO `t_region` VALUES ('2977', '530630', '水富县', '307', '0', '0', 'Shuifu Xian ', '2');
INSERT INTO `t_region` VALUES ('2978', '530701', '市辖区', '308', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2979', '530702', '古城区', '308', '0', '0', 'Gucheng Qu', '2');
INSERT INTO `t_region` VALUES ('2980', '530721', '玉龙纳西族自治县', '308', '0', '0', 'Yulongnaxizuzizhi Xian', '2');
INSERT INTO `t_region` VALUES ('2981', '530722', '永胜县', '308', '0', '0', 'Yongsheng Xian', '2');
INSERT INTO `t_region` VALUES ('2982', '530723', '华坪县', '308', '0', '0', 'Huaping Xian', '2');
INSERT INTO `t_region` VALUES ('2983', '530724', '宁蒗彝族自治县', '308', '0', '0', 'Ninglang Yizu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2984', '530801', '市辖区', '309', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2985', '530802', '思茅区', '309', '0', '0', 'Simao Qu', '2');
INSERT INTO `t_region` VALUES ('2986', '530821', '宁洱哈尼族彝族自治县', '309', '0', '0', 'Pu,er Hanizu Yizu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2987', '530822', '墨江哈尼族自治县', '309', '0', '0', 'Mojiang Hanizu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2988', '530823', '景东彝族自治县', '309', '0', '0', 'Jingdong Yizu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2989', '530824', '景谷傣族彝族自治县', '309', '0', '0', 'Jinggu Daizu Yizu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2990', '530825', '镇沅彝族哈尼族拉祜族自治县', '309', '0', '0', 'Zhenyuan Yizu Hanizu Lahuzu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2991', '530826', '江城哈尼族彝族自治县', '309', '0', '0', 'Jiangcheng Hanizu Yizu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2992', '530827', '孟连傣族拉祜族佤族自治县', '309', '0', '0', 'Menglian Daizu Lahuzu Vazu Zizixian', '2');
INSERT INTO `t_region` VALUES ('2993', '530828', '澜沧拉祜族自治县', '309', '0', '0', 'Lancang Lahuzu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2994', '530829', '西盟佤族自治县', '309', '0', '0', 'Ximeng Vazu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('2995', '530901', '市辖区', '310', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('2996', '530902', '临翔区', '310', '0', '0', 'Linxiang Qu', '2');
INSERT INTO `t_region` VALUES ('2997', '530921', '凤庆县', '310', '0', '0', 'Fengqing Xian', '2');
INSERT INTO `t_region` VALUES ('2998', '530922', '云县', '310', '0', '0', 'Yun Xian', '2');
INSERT INTO `t_region` VALUES ('2999', '530923', '永德县', '310', '0', '0', 'Yongde Xian', '2');
INSERT INTO `t_region` VALUES ('3000', '530924', '镇康县', '310', '0', '0', 'Zhenkang Xian', '2');
INSERT INTO `t_region` VALUES ('3001', '530925', '双江拉祜族佤族布朗族傣族自治县', '310', '0', '0', 'Shuangjiang Lahuzu Vazu Bulangzu Daizu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('3002', '530926', '耿马傣族佤族自治县', '310', '0', '0', 'Gengma Daizu Vazu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('3003', '530927', '沧源佤族自治县', '310', '0', '0', 'Cangyuan Vazu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('3004', '532301', '楚雄市', '311', '0', '0', 'Chuxiong Shi', 'CXS');
INSERT INTO `t_region` VALUES ('3005', '532322', '双柏县', '311', '0', '0', 'Shuangbai Xian', 'SBA');
INSERT INTO `t_region` VALUES ('3006', '532323', '牟定县', '311', '0', '0', 'Mouding Xian', 'MDI');
INSERT INTO `t_region` VALUES ('3007', '532324', '南华县', '311', '0', '0', 'Nanhua Xian', 'NHA');
INSERT INTO `t_region` VALUES ('3008', '532325', '姚安县', '311', '0', '0', 'Yao,an Xian', 'YOA');
INSERT INTO `t_region` VALUES ('3009', '532326', '大姚县', '311', '0', '0', 'Dayao Xian', 'DYO');
INSERT INTO `t_region` VALUES ('3010', '532327', '永仁县', '311', '0', '0', 'Yongren Xian', 'YRN');
INSERT INTO `t_region` VALUES ('3011', '532328', '元谋县', '311', '0', '0', 'Yuanmou Xian', 'YMO');
INSERT INTO `t_region` VALUES ('3012', '532329', '武定县', '311', '0', '0', 'Wuding Xian', 'WDX');
INSERT INTO `t_region` VALUES ('3013', '532331', '禄丰县', '311', '0', '0', 'Lufeng Xian', 'LFX');
INSERT INTO `t_region` VALUES ('3014', '532501', '个旧市', '312', '0', '0', 'Gejiu Shi', 'GJU');
INSERT INTO `t_region` VALUES ('3015', '532502', '开远市', '312', '0', '0', 'Kaiyuan Shi', 'KYD');
INSERT INTO `t_region` VALUES ('3016', '532503', '蒙自市', '312', '0', '0', 'Mengzi Xian', '2');
INSERT INTO `t_region` VALUES ('3017', '532523', '屏边苗族自治县', '312', '0', '0', 'Pingbian Miaozu Zizhixian', 'PBN');
INSERT INTO `t_region` VALUES ('3018', '532524', '建水县', '312', '0', '0', 'Jianshui Xian', 'JSD');
INSERT INTO `t_region` VALUES ('3019', '532525', '石屏县', '312', '0', '0', 'Shiping Xian', 'SPG');
INSERT INTO `t_region` VALUES ('3020', '532526', '弥勒县', '312', '0', '0', 'Mile Xian', 'MIL');
INSERT INTO `t_region` VALUES ('3021', '532527', '泸西县', '312', '0', '0', 'Luxi Xian', 'LXD');
INSERT INTO `t_region` VALUES ('3022', '532528', '元阳县', '312', '0', '0', 'Yuanyang Xian', 'YYD');
INSERT INTO `t_region` VALUES ('3023', '532529', '红河县', '312', '0', '0', 'Honghe Xian', 'HHX');
INSERT INTO `t_region` VALUES ('3024', '532530', '金平苗族瑶族傣族自治县', '312', '0', '0', 'Jinping Miaozu Yaozu Daizu Zizhixian', 'JNP');
INSERT INTO `t_region` VALUES ('3025', '532531', '绿春县', '312', '0', '0', 'Lvchun Xian', 'LCX');
INSERT INTO `t_region` VALUES ('3026', '532532', '河口瑶族自治县', '312', '0', '0', 'Hekou Yaozu Zizhixian', 'HKM');
INSERT INTO `t_region` VALUES ('3027', '532621', '文山县', '313', '0', '0', 'Wenshan Xian', 'WES');
INSERT INTO `t_region` VALUES ('3028', '532622', '砚山县', '313', '0', '0', 'Yanshan Xian', 'YSD');
INSERT INTO `t_region` VALUES ('3029', '532623', '西畴县', '313', '0', '0', 'Xichou Xian', 'XIC');
INSERT INTO `t_region` VALUES ('3030', '532624', '麻栗坡县', '313', '0', '0', 'Malipo Xian', 'MLP');
INSERT INTO `t_region` VALUES ('3031', '532625', '马关县', '313', '0', '0', 'Maguan Xian', 'MGN');
INSERT INTO `t_region` VALUES ('3032', '532626', '丘北县', '313', '0', '0', 'Qiubei Xian', 'QBE');
INSERT INTO `t_region` VALUES ('3033', '532627', '广南县', '313', '0', '0', 'Guangnan Xian', 'GGN');
INSERT INTO `t_region` VALUES ('3034', '532628', '富宁县', '313', '0', '0', 'Funing Xian', 'FND');
INSERT INTO `t_region` VALUES ('3035', '532801', '景洪市', '314', '0', '0', 'Jinghong Shi', 'JHG');
INSERT INTO `t_region` VALUES ('3036', '532822', '勐海县', '314', '0', '0', 'Menghai Xian', 'MHI');
INSERT INTO `t_region` VALUES ('3037', '532823', '勐腊县', '314', '0', '0', 'Mengla Xian', 'MLA');
INSERT INTO `t_region` VALUES ('3038', '532901', '大理市', '315', '0', '0', 'Dali Shi', 'DLS');
INSERT INTO `t_region` VALUES ('3039', '532922', '漾濞彝族自治县', '315', '0', '0', 'Yangbi Yizu Zizhixian', 'YGB');
INSERT INTO `t_region` VALUES ('3040', '532923', '祥云县', '315', '0', '0', 'Xiangyun Xian', 'XYD');
INSERT INTO `t_region` VALUES ('3041', '532924', '宾川县', '315', '0', '0', 'Binchuan Xian', 'BCD');
INSERT INTO `t_region` VALUES ('3042', '532925', '弥渡县', '315', '0', '0', 'Midu Xian', 'MDU');
INSERT INTO `t_region` VALUES ('3043', '532926', '南涧彝族自治县', '315', '0', '0', 'Nanjian Yizu Zizhixian', 'NNJ');
INSERT INTO `t_region` VALUES ('3044', '532927', '巍山彝族回族自治县', '315', '0', '0', 'Weishan Yizu Huizu Zizhixian', 'WSY');
INSERT INTO `t_region` VALUES ('3045', '532928', '永平县', '315', '0', '0', 'Yongping Xian', 'YPX');
INSERT INTO `t_region` VALUES ('3046', '532929', '云龙县', '315', '0', '0', 'Yunlong Xian', 'YLO');
INSERT INTO `t_region` VALUES ('3047', '532930', '洱源县', '315', '0', '0', 'Eryuan Xian', 'EYN');
INSERT INTO `t_region` VALUES ('3048', '532931', '剑川县', '315', '0', '0', 'Jianchuan Xian', 'JIC');
INSERT INTO `t_region` VALUES ('3049', '532932', '鹤庆县', '315', '0', '0', 'Heqing Xian', 'HQG');
INSERT INTO `t_region` VALUES ('3050', '533102', '瑞丽市', '316', '0', '0', 'Ruili Shi', 'RUI');
INSERT INTO `t_region` VALUES ('3051', '533103', '芒市', '316', '0', '0', 'Luxi Shi', '2');
INSERT INTO `t_region` VALUES ('3052', '533122', '梁河县', '316', '0', '0', 'Lianghe Xian', 'LHD');
INSERT INTO `t_region` VALUES ('3053', '533123', '盈江县', '316', '0', '0', 'Yingjiang Xian', 'YGJ');
INSERT INTO `t_region` VALUES ('3054', '533124', '陇川县', '316', '0', '0', 'Longchuan Xian', 'LCN');
INSERT INTO `t_region` VALUES ('3055', '533321', '泸水县', '317', '0', '0', 'Lushui Xian', 'LSX');
INSERT INTO `t_region` VALUES ('3056', '533323', '福贡县', '317', '0', '0', 'Fugong Xian', 'FGO');
INSERT INTO `t_region` VALUES ('3057', '533324', '贡山独龙族怒族自治县', '317', '0', '0', 'Gongshan Dulongzu Nuzu Zizhixian', 'GSN');
INSERT INTO `t_region` VALUES ('3058', '533325', '兰坪白族普米族自治县', '317', '0', '0', 'Lanping Baizu Pumizu Zizhixian', 'LPG');
INSERT INTO `t_region` VALUES ('3059', '533421', '香格里拉县', '318', '0', '0', 'Xianggelila Xian', '2');
INSERT INTO `t_region` VALUES ('3060', '533422', '德钦县', '318', '0', '0', 'Deqen Xian', 'DQN');
INSERT INTO `t_region` VALUES ('3061', '533423', '维西傈僳族自治县', '318', '0', '0', 'Weixi Lisuzu Zizhixian', 'WXI');
INSERT INTO `t_region` VALUES ('3062', '540101', '市辖区', '319', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3063', '540102', '城关区', '319', '0', '0', 'Chengguang Qu', 'CGN');
INSERT INTO `t_region` VALUES ('3064', '540121', '林周县', '319', '0', '0', 'Lhvnzhub Xian', 'LZB');
INSERT INTO `t_region` VALUES ('3065', '540122', '当雄县', '319', '0', '0', 'Damxung Xian', 'DAM');
INSERT INTO `t_region` VALUES ('3066', '540123', '尼木县', '319', '0', '0', 'Nyemo Xian', 'NYE');
INSERT INTO `t_region` VALUES ('3067', '540124', '曲水县', '319', '0', '0', 'Qvxv Xian', 'QUX');
INSERT INTO `t_region` VALUES ('3068', '540125', '堆龙德庆县', '319', '0', '0', 'Doilungdeqen Xian', 'DOI');
INSERT INTO `t_region` VALUES ('3069', '540126', '达孜县', '319', '0', '0', 'Dagze Xian', 'DAG');
INSERT INTO `t_region` VALUES ('3070', '540127', '墨竹工卡县', '319', '0', '0', 'Maizhokunggar Xian', 'MAI');
INSERT INTO `t_region` VALUES ('3071', '542121', '昌都县', '320', '0', '0', 'Qamdo Xian', 'QAX');
INSERT INTO `t_region` VALUES ('3072', '542122', '江达县', '320', '0', '0', 'Jomda Xian', 'JOM');
INSERT INTO `t_region` VALUES ('3073', '542123', '贡觉县', '320', '0', '0', 'Konjo Xian', 'KON');
INSERT INTO `t_region` VALUES ('3074', '542124', '类乌齐县', '320', '0', '0', 'Riwoqe Xian', 'RIW');
INSERT INTO `t_region` VALUES ('3075', '542125', '丁青县', '320', '0', '0', 'Dengqen Xian', 'DEN');
INSERT INTO `t_region` VALUES ('3076', '542126', '察雅县', '320', '0', '0', 'Chagyab Xian', 'CHA');
INSERT INTO `t_region` VALUES ('3077', '542127', '八宿县', '320', '0', '0', 'Baxoi Xian', 'BAX');
INSERT INTO `t_region` VALUES ('3078', '542128', '左贡县', '320', '0', '0', 'Zogang Xian', 'ZOX');
INSERT INTO `t_region` VALUES ('3079', '542129', '芒康县', '320', '0', '0', 'Mangkam Xian', 'MAN');
INSERT INTO `t_region` VALUES ('3080', '542132', '洛隆县', '320', '0', '0', 'Lhorong Xian', 'LHO');
INSERT INTO `t_region` VALUES ('3081', '542133', '边坝县', '320', '0', '0', 'Banbar Xian', 'BAN');
INSERT INTO `t_region` VALUES ('3082', '542221', '乃东县', '321', '0', '0', 'Nedong Xian', 'NED');
INSERT INTO `t_region` VALUES ('3083', '542222', '扎囊县', '321', '0', '0', 'Chanang(Chatang) Xian', 'CNG');
INSERT INTO `t_region` VALUES ('3084', '542223', '贡嘎县', '321', '0', '0', 'Gonggar Xian', 'GON');
INSERT INTO `t_region` VALUES ('3085', '542224', '桑日县', '321', '0', '0', 'Sangri Xian', 'SRI');
INSERT INTO `t_region` VALUES ('3086', '542225', '琼结县', '321', '0', '0', 'Qonggyai Xian', 'QON');
INSERT INTO `t_region` VALUES ('3087', '542226', '曲松县', '321', '0', '0', 'Qusum Xian', 'QUS');
INSERT INTO `t_region` VALUES ('3088', '542227', '措美县', '321', '0', '0', 'Comai Xian', 'COM');
INSERT INTO `t_region` VALUES ('3089', '542228', '洛扎县', '321', '0', '0', 'Lhozhag Xian', 'LHX');
INSERT INTO `t_region` VALUES ('3090', '542229', '加查县', '321', '0', '0', 'Gyaca Xian', 'GYA');
INSERT INTO `t_region` VALUES ('3091', '542231', '隆子县', '321', '0', '0', 'Lhvnze Xian', 'LHZ');
INSERT INTO `t_region` VALUES ('3092', '542232', '错那县', '321', '0', '0', 'Cona Xian', 'CON');
INSERT INTO `t_region` VALUES ('3093', '542233', '浪卡子县', '321', '0', '0', 'Nagarze Xian', 'NAX');
INSERT INTO `t_region` VALUES ('3094', '542301', '日喀则市', '322', '0', '0', 'Xigaze Shi', 'XIG');
INSERT INTO `t_region` VALUES ('3095', '542322', '南木林县', '322', '0', '0', 'Namling Xian', 'NAM');
INSERT INTO `t_region` VALUES ('3096', '542323', '江孜县', '322', '0', '0', 'Gyangze Xian', 'GYZ');
INSERT INTO `t_region` VALUES ('3097', '542324', '定日县', '322', '0', '0', 'Tingri Xian', 'TIN');
INSERT INTO `t_region` VALUES ('3098', '542325', '萨迦县', '322', '0', '0', 'Sa,gya Xian', 'SGX');
INSERT INTO `t_region` VALUES ('3099', '542326', '拉孜县', '322', '0', '0', 'Lhaze Xian', 'LAZ');
INSERT INTO `t_region` VALUES ('3100', '542327', '昂仁县', '322', '0', '0', 'Ngamring Xian', 'NGA');
INSERT INTO `t_region` VALUES ('3101', '542328', '谢通门县', '322', '0', '0', 'Xaitongmoin Xian', 'XTM');
INSERT INTO `t_region` VALUES ('3102', '542329', '白朗县', '322', '0', '0', 'Bainang Xian', 'BAI');
INSERT INTO `t_region` VALUES ('3103', '542330', '仁布县', '322', '0', '0', 'Rinbung Xian', 'RIN');
INSERT INTO `t_region` VALUES ('3104', '542331', '康马县', '322', '0', '0', 'Kangmar Xian', 'KAN');
INSERT INTO `t_region` VALUES ('3105', '542332', '定结县', '322', '0', '0', 'Dinggye Xian', 'DIN');
INSERT INTO `t_region` VALUES ('3106', '542333', '仲巴县', '322', '0', '0', 'Zhongba Xian', 'ZHB');
INSERT INTO `t_region` VALUES ('3107', '542334', '亚东县', '322', '0', '0', 'Yadong(Chomo) Xian', 'YDZ');
INSERT INTO `t_region` VALUES ('3108', '542335', '吉隆县', '322', '0', '0', 'Gyirong Xian', 'GIR');
INSERT INTO `t_region` VALUES ('3109', '542336', '聂拉木县', '322', '0', '0', 'Nyalam Xian', 'NYA');
INSERT INTO `t_region` VALUES ('3110', '542337', '萨嘎县', '322', '0', '0', 'Saga Xian', 'SAG');
INSERT INTO `t_region` VALUES ('3111', '542338', '岗巴县', '322', '0', '0', 'Gamba Xian', 'GAM');
INSERT INTO `t_region` VALUES ('3112', '542421', '那曲县', '323', '0', '0', 'Nagqu Xian', 'NAG');
INSERT INTO `t_region` VALUES ('3113', '542422', '嘉黎县', '323', '0', '0', 'Lhari Xian', 'LHR');
INSERT INTO `t_region` VALUES ('3114', '542423', '比如县', '323', '0', '0', 'Biru Xian', 'BRU');
INSERT INTO `t_region` VALUES ('3115', '542424', '聂荣县', '323', '0', '0', 'Nyainrong Xian', 'NRO');
INSERT INTO `t_region` VALUES ('3116', '542425', '安多县', '323', '0', '0', 'Amdo Xian', 'AMD');
INSERT INTO `t_region` VALUES ('3117', '542426', '申扎县', '323', '0', '0', 'Xainza Xian', 'XZX');
INSERT INTO `t_region` VALUES ('3118', '542427', '索县', '323', '0', '0', 'Sog Xian', 'SOG');
INSERT INTO `t_region` VALUES ('3119', '542428', '班戈县', '323', '0', '0', 'Bangoin Xian', 'BGX');
INSERT INTO `t_region` VALUES ('3120', '542429', '巴青县', '323', '0', '0', 'Baqen Xian', 'BQE');
INSERT INTO `t_region` VALUES ('3121', '542430', '尼玛县', '323', '0', '0', 'Nyima Xian', 'NYX');
INSERT INTO `t_region` VALUES ('3122', '542521', '普兰县', '324', '0', '0', 'Burang Xian', 'BUR');
INSERT INTO `t_region` VALUES ('3123', '542522', '札达县', '324', '0', '0', 'Zanda Xian', 'ZAN');
INSERT INTO `t_region` VALUES ('3124', '542523', '噶尔县', '324', '0', '0', 'Gar Xian', 'GAR');
INSERT INTO `t_region` VALUES ('3125', '542524', '日土县', '324', '0', '0', 'Rutog Xian', 'RUT');
INSERT INTO `t_region` VALUES ('3126', '542525', '革吉县', '324', '0', '0', 'Ge,gyai Xian', 'GEG');
INSERT INTO `t_region` VALUES ('3127', '542526', '改则县', '324', '0', '0', 'Gerze Xian', 'GER');
INSERT INTO `t_region` VALUES ('3128', '542527', '措勤县', '324', '0', '0', 'Coqen Xian', 'COQ');
INSERT INTO `t_region` VALUES ('3129', '542621', '林芝县', '325', '0', '0', 'Nyingchi Xian', 'NYI');
INSERT INTO `t_region` VALUES ('3130', '542622', '工布江达县', '325', '0', '0', 'Gongbo,gyamda Xian', 'GOX');
INSERT INTO `t_region` VALUES ('3131', '542623', '米林县', '325', '0', '0', 'Mainling Xian', 'MAX');
INSERT INTO `t_region` VALUES ('3132', '542624', '墨脱县', '325', '0', '0', 'Metog Xian', 'MET');
INSERT INTO `t_region` VALUES ('3133', '542625', '波密县', '325', '0', '0', 'Bomi(Bowo) Xian', 'BMI');
INSERT INTO `t_region` VALUES ('3134', '542626', '察隅县', '325', '0', '0', 'Zayv Xian', 'ZAY');
INSERT INTO `t_region` VALUES ('3135', '542627', '朗县', '325', '0', '0', 'Nang Xian', 'NGX');
INSERT INTO `t_region` VALUES ('3136', '610101', '市辖区', '326', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3137', '610102', '新城区', '326', '0', '0', 'Xincheng Qu', 'XCK');
INSERT INTO `t_region` VALUES ('3138', '610103', '碑林区', '326', '0', '0', 'Beilin Qu', 'BLQ');
INSERT INTO `t_region` VALUES ('3139', '610104', '莲湖区', '326', '0', '0', 'Lianhu Qu', 'LHU');
INSERT INTO `t_region` VALUES ('3140', '610111', '灞桥区', '326', '0', '0', 'Baqiao Qu', 'BQQ');
INSERT INTO `t_region` VALUES ('3141', '610112', '未央区', '326', '0', '0', 'Weiyang Qu', '2');
INSERT INTO `t_region` VALUES ('3142', '610113', '雁塔区', '326', '0', '0', 'Yanta Qu', 'YTA');
INSERT INTO `t_region` VALUES ('3143', '610114', '阎良区', '326', '0', '0', 'Yanliang Qu', 'YLQ');
INSERT INTO `t_region` VALUES ('3144', '610115', '临潼区', '326', '0', '0', 'Lintong Qu', 'LTG');
INSERT INTO `t_region` VALUES ('3145', '610116', '长安区', '326', '0', '0', 'Changan Qu', '2');
INSERT INTO `t_region` VALUES ('3146', '610122', '蓝田县', '326', '0', '0', 'Lantian Xian', 'LNT');
INSERT INTO `t_region` VALUES ('3147', '610124', '周至县', '326', '0', '0', 'Zhouzhi Xian', 'ZOZ');
INSERT INTO `t_region` VALUES ('3148', '610125', '户县', '326', '0', '0', 'Hu Xian', 'HUX');
INSERT INTO `t_region` VALUES ('3149', '610126', '高陵县', '326', '0', '0', 'Gaoling Xian', 'GLS');
INSERT INTO `t_region` VALUES ('3150', '610201', '市辖区', '327', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3151', '610202', '王益区', '327', '0', '0', 'Wangyi Qu', '2');
INSERT INTO `t_region` VALUES ('3152', '610203', '印台区', '327', '0', '0', 'Yintai Qu', '2');
INSERT INTO `t_region` VALUES ('3153', '610204', '耀州区', '327', '0', '0', 'Yaozhou Qu', '2');
INSERT INTO `t_region` VALUES ('3154', '610222', '宜君县', '327', '0', '0', 'Yijun Xian', 'YJU');
INSERT INTO `t_region` VALUES ('3155', '610301', '市辖区', '328', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3156', '610302', '渭滨区', '328', '0', '0', 'Weibin Qu', 'WBQ');
INSERT INTO `t_region` VALUES ('3157', '610303', '金台区', '328', '0', '0', 'Jintai Qu', 'JTQ');
INSERT INTO `t_region` VALUES ('3158', '610304', '陈仓区', '328', '0', '0', 'Chencang Qu', '2');
INSERT INTO `t_region` VALUES ('3159', '610322', '凤翔县', '328', '0', '0', 'Fengxiang Xian', 'FXG');
INSERT INTO `t_region` VALUES ('3160', '610323', '岐山县', '328', '0', '0', 'Qishan Xian', 'QIS');
INSERT INTO `t_region` VALUES ('3161', '610324', '扶风县', '328', '0', '0', 'Fufeng Xian', 'FFG');
INSERT INTO `t_region` VALUES ('3162', '610326', '眉县', '328', '0', '0', 'Mei Xian', 'MEI');
INSERT INTO `t_region` VALUES ('3163', '610327', '陇县', '328', '0', '0', 'Long Xian', 'LON');
INSERT INTO `t_region` VALUES ('3164', '610328', '千阳县', '328', '0', '0', 'Qianyang Xian', 'QNY');
INSERT INTO `t_region` VALUES ('3165', '610329', '麟游县', '328', '0', '0', 'Linyou Xian', 'LYP');
INSERT INTO `t_region` VALUES ('3166', '610330', '凤县', '328', '0', '0', 'Feng Xian', 'FEG');
INSERT INTO `t_region` VALUES ('3167', '610331', '太白县', '328', '0', '0', 'Taibai Xian', 'TBA');
INSERT INTO `t_region` VALUES ('3168', '610401', '市辖区', '329', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3169', '610402', '秦都区', '329', '0', '0', 'Qindu Qu', 'QDU');
INSERT INTO `t_region` VALUES ('3170', '610403', '杨陵区', '329', '0', '0', 'Yangling Qu', 'YGL');
INSERT INTO `t_region` VALUES ('3171', '610404', '渭城区', '329', '0', '0', 'Weicheng Qu', 'WIC');
INSERT INTO `t_region` VALUES ('3172', '610422', '三原县', '329', '0', '0', 'Sanyuan Xian', 'SYN');
INSERT INTO `t_region` VALUES ('3173', '610423', '泾阳县', '329', '0', '0', 'Jingyang Xian', 'JGY');
INSERT INTO `t_region` VALUES ('3174', '610424', '乾县', '329', '0', '0', 'Qian Xian', 'QIA');
INSERT INTO `t_region` VALUES ('3175', '610425', '礼泉县', '329', '0', '0', 'Liquan Xian', 'LIQ');
INSERT INTO `t_region` VALUES ('3176', '610426', '永寿县', '329', '0', '0', 'Yongshou Xian', 'YSH');
INSERT INTO `t_region` VALUES ('3177', '610427', '彬县', '329', '0', '0', 'Bin Xian', 'BIX');
INSERT INTO `t_region` VALUES ('3178', '610428', '长武县', '329', '0', '0', 'Changwu Xian', 'CWU');
INSERT INTO `t_region` VALUES ('3179', '610429', '旬邑县', '329', '0', '0', 'Xunyi Xian', 'XNY');
INSERT INTO `t_region` VALUES ('3180', '610430', '淳化县', '329', '0', '0', 'Chunhua Xian', 'CHU');
INSERT INTO `t_region` VALUES ('3181', '610431', '武功县', '329', '0', '0', 'Wugong Xian', 'WGG');
INSERT INTO `t_region` VALUES ('3182', '610481', '兴平市', '329', '0', '0', 'Xingping Shi', 'XPG');
INSERT INTO `t_region` VALUES ('3183', '610501', '市辖区', '330', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3184', '610502', '临渭区', '330', '0', '0', 'Linwei Qu', 'LWE');
INSERT INTO `t_region` VALUES ('3185', '610521', '华县', '330', '0', '0', 'Hua Xian', 'HXN');
INSERT INTO `t_region` VALUES ('3186', '610522', '潼关县', '330', '0', '0', 'Tongguan Xian', 'TGN');
INSERT INTO `t_region` VALUES ('3187', '610523', '大荔县', '330', '0', '0', 'Dali Xian', 'DAL');
INSERT INTO `t_region` VALUES ('3188', '610524', '合阳县', '330', '0', '0', 'Heyang Xian', 'HYK');
INSERT INTO `t_region` VALUES ('3189', '610525', '澄城县', '330', '0', '0', 'Chengcheng Xian', 'CCG');
INSERT INTO `t_region` VALUES ('3190', '610526', '蒲城县', '330', '0', '0', 'Pucheng Xian', 'PUC');
INSERT INTO `t_region` VALUES ('3191', '610527', '白水县', '330', '0', '0', 'Baishui Xian', 'BSU');
INSERT INTO `t_region` VALUES ('3192', '610528', '富平县', '330', '0', '0', 'Fuping Xian', 'FPX');
INSERT INTO `t_region` VALUES ('3193', '610581', '韩城市', '330', '0', '0', 'Hancheng Shi', 'HCE');
INSERT INTO `t_region` VALUES ('3194', '610582', '华阴市', '330', '0', '0', 'Huayin Shi', 'HYI');
INSERT INTO `t_region` VALUES ('3195', '610601', '市辖区', '331', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3196', '610602', '宝塔区', '331', '0', '0', 'Baota Qu', 'BTA');
INSERT INTO `t_region` VALUES ('3197', '610621', '延长县', '331', '0', '0', 'Yanchang Xian', 'YCA');
INSERT INTO `t_region` VALUES ('3198', '610622', '延川县', '331', '0', '0', 'Yanchuan Xian', 'YCT');
INSERT INTO `t_region` VALUES ('3199', '610623', '子长县', '331', '0', '0', 'Zichang Xian', 'ZCA');
INSERT INTO `t_region` VALUES ('3200', '610624', '安塞县', '331', '0', '0', 'Ansai Xian', 'ANS');
INSERT INTO `t_region` VALUES ('3201', '610625', '志丹县', '331', '0', '0', 'Zhidan Xian', 'ZDN');
INSERT INTO `t_region` VALUES ('3202', '610626', '吴起县', '331', '0', '0', 'Wuqi Xian', '2');
INSERT INTO `t_region` VALUES ('3203', '610627', '甘泉县', '331', '0', '0', 'Ganquan Xian', 'GQN');
INSERT INTO `t_region` VALUES ('3204', '610628', '富县', '331', '0', '0', 'Fu Xian', 'FUX');
INSERT INTO `t_region` VALUES ('3205', '610629', '洛川县', '331', '0', '0', 'Luochuan Xian', 'LCW');
INSERT INTO `t_region` VALUES ('3206', '610630', '宜川县', '331', '0', '0', 'Yichuan Xian', 'YIC');
INSERT INTO `t_region` VALUES ('3207', '610631', '黄龙县', '331', '0', '0', 'Huanglong Xian', 'HGL');
INSERT INTO `t_region` VALUES ('3208', '610632', '黄陵县', '331', '0', '0', 'Huangling Xian', 'HLG');
INSERT INTO `t_region` VALUES ('3209', '610701', '市辖区', '332', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3210', '610702', '汉台区', '332', '0', '0', 'Hantai Qu', 'HTQ');
INSERT INTO `t_region` VALUES ('3211', '610721', '南郑县', '332', '0', '0', 'Nanzheng Xian', 'NZG');
INSERT INTO `t_region` VALUES ('3212', '610722', '城固县', '332', '0', '0', 'Chenggu Xian', 'CGU');
INSERT INTO `t_region` VALUES ('3213', '610723', '洋县', '332', '0', '0', 'Yang Xian', 'YGX');
INSERT INTO `t_region` VALUES ('3214', '610724', '西乡县', '332', '0', '0', 'Xixiang Xian', 'XXA');
INSERT INTO `t_region` VALUES ('3215', '610725', '勉县', '332', '0', '0', 'Mian Xian', 'MIA');
INSERT INTO `t_region` VALUES ('3216', '610726', '宁强县', '332', '0', '0', 'Ningqiang Xian', 'NQG');
INSERT INTO `t_region` VALUES ('3217', '610727', '略阳县', '332', '0', '0', 'Lueyang Xian', 'LYC');
INSERT INTO `t_region` VALUES ('3218', '610728', '镇巴县', '332', '0', '0', 'Zhenba Xian', 'ZBA');
INSERT INTO `t_region` VALUES ('3219', '610729', '留坝县', '332', '0', '0', 'Liuba Xian', 'LBA');
INSERT INTO `t_region` VALUES ('3220', '610730', '佛坪县', '332', '0', '0', 'Foping Xian', 'FPG');
INSERT INTO `t_region` VALUES ('3221', '610801', '市辖区', '333', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('3222', '610802', '榆阳区', '333', '0', '0', 'Yuyang Qu', '2');
INSERT INTO `t_region` VALUES ('3223', '610821', '神木县', '333', '0', '0', 'Shenmu Xian', '2');
INSERT INTO `t_region` VALUES ('3224', '610822', '府谷县', '333', '0', '0', 'Fugu Xian', '2');
INSERT INTO `t_region` VALUES ('3225', '610823', '横山县', '333', '0', '0', 'Hengshan Xian', '2');
INSERT INTO `t_region` VALUES ('3226', '610824', '靖边县', '333', '0', '0', 'Jingbian Xian', '2');
INSERT INTO `t_region` VALUES ('3227', '610825', '定边县', '333', '0', '0', 'Dingbian Xian', '2');
INSERT INTO `t_region` VALUES ('3228', '610826', '绥德县', '333', '0', '0', 'Suide Xian', '2');
INSERT INTO `t_region` VALUES ('3229', '610827', '米脂县', '333', '0', '0', 'Mizhi Xian', '2');
INSERT INTO `t_region` VALUES ('3230', '610828', '佳县', '333', '0', '0', 'Jia Xian', '2');
INSERT INTO `t_region` VALUES ('3231', '610829', '吴堡县', '333', '0', '0', 'Wubu Xian', '2');
INSERT INTO `t_region` VALUES ('3232', '610830', '清涧县', '333', '0', '0', 'Qingjian Xian', '2');
INSERT INTO `t_region` VALUES ('3233', '610831', '子洲县', '333', '0', '0', 'Zizhou Xian', '2');
INSERT INTO `t_region` VALUES ('3234', '610901', '市辖区', '334', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('3235', '610902', '汉滨区', '334', '0', '0', 'Hanbin Qu', '2');
INSERT INTO `t_region` VALUES ('3236', '610921', '汉阴县', '334', '0', '0', 'Hanyin Xian', '2');
INSERT INTO `t_region` VALUES ('3237', '610922', '石泉县', '334', '0', '0', 'Shiquan Xian', '2');
INSERT INTO `t_region` VALUES ('3238', '610923', '宁陕县', '334', '0', '0', 'Ningshan Xian', '2');
INSERT INTO `t_region` VALUES ('3239', '610924', '紫阳县', '334', '0', '0', 'Ziyang Xian', '2');
INSERT INTO `t_region` VALUES ('3240', '610925', '岚皋县', '334', '0', '0', 'Langao Xian', '2');
INSERT INTO `t_region` VALUES ('3241', '610926', '平利县', '334', '0', '0', 'Pingli Xian', '2');
INSERT INTO `t_region` VALUES ('3242', '610927', '镇坪县', '334', '0', '0', 'Zhenping Xian', '2');
INSERT INTO `t_region` VALUES ('3243', '610928', '旬阳县', '334', '0', '0', 'Xunyang Xian', '2');
INSERT INTO `t_region` VALUES ('3244', '610929', '白河县', '334', '0', '0', 'Baihe Xian', '2');
INSERT INTO `t_region` VALUES ('3245', '611001', '市辖区', '335', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('3246', '611002', '商州区', '335', '0', '0', 'Shangzhou Qu', '2');
INSERT INTO `t_region` VALUES ('3247', '611021', '洛南县', '335', '0', '0', 'Luonan Xian', '2');
INSERT INTO `t_region` VALUES ('3248', '611022', '丹凤县', '335', '0', '0', 'Danfeng Xian', '2');
INSERT INTO `t_region` VALUES ('3249', '611023', '商南县', '335', '0', '0', 'Shangnan Xian', '2');
INSERT INTO `t_region` VALUES ('3250', '611024', '山阳县', '335', '0', '0', 'Shanyang Xian', '2');
INSERT INTO `t_region` VALUES ('3251', '611025', '镇安县', '335', '0', '0', 'Zhen,an Xian', '2');
INSERT INTO `t_region` VALUES ('3252', '611026', '柞水县', '335', '0', '0', 'Zhashui Xian', '2');
INSERT INTO `t_region` VALUES ('3253', '620101', '市辖区', '336', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3254', '620102', '城关区', '336', '0', '0', 'Chengguan Qu', 'CLZ');
INSERT INTO `t_region` VALUES ('3255', '620103', '七里河区', '336', '0', '0', 'Qilihe Qu', 'QLH');
INSERT INTO `t_region` VALUES ('3256', '620104', '西固区', '336', '0', '0', 'Xigu Qu', 'XGU');
INSERT INTO `t_region` VALUES ('3257', '620105', '安宁区', '336', '0', '0', 'Anning Qu', 'ANQ');
INSERT INTO `t_region` VALUES ('3258', '620111', '红古区', '336', '0', '0', 'Honggu Qu', 'HOG');
INSERT INTO `t_region` VALUES ('3259', '620121', '永登县', '336', '0', '0', 'Yongdeng Xian', 'YDG');
INSERT INTO `t_region` VALUES ('3260', '620122', '皋兰县', '336', '0', '0', 'Gaolan Xian', 'GAL');
INSERT INTO `t_region` VALUES ('3261', '620123', '榆中县', '336', '0', '0', 'Yuzhong Xian', 'YZX');
INSERT INTO `t_region` VALUES ('3262', '620201', '市辖区', '337', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3263', '620301', '市辖区', '338', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3264', '620302', '金川区', '338', '0', '0', 'Jinchuan Qu', 'JCU');
INSERT INTO `t_region` VALUES ('3265', '620321', '永昌县', '338', '0', '0', 'Yongchang Xian', 'YCF');
INSERT INTO `t_region` VALUES ('3266', '620401', '市辖区', '339', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3267', '620402', '白银区', '339', '0', '0', 'Baiyin Qu', 'BYB');
INSERT INTO `t_region` VALUES ('3268', '620403', '平川区', '339', '0', '0', 'Pingchuan Qu', 'PCQ');
INSERT INTO `t_region` VALUES ('3269', '620421', '靖远县', '339', '0', '0', 'Jingyuan Xian', 'JYH');
INSERT INTO `t_region` VALUES ('3270', '620422', '会宁县', '339', '0', '0', 'Huining xian', 'HNI');
INSERT INTO `t_region` VALUES ('3271', '620423', '景泰县', '339', '0', '0', 'Jingtai Xian', 'JGT');
INSERT INTO `t_region` VALUES ('3272', '620501', '市辖区', '340', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3274', '620502', '秦州区', '340', '0', '0', 'Beidao Qu', '2');
INSERT INTO `t_region` VALUES ('3275', '620521', '清水县', '340', '0', '0', 'Qingshui Xian', 'QSG');
INSERT INTO `t_region` VALUES ('3276', '620522', '秦安县', '340', '0', '0', 'Qin,an Xian', 'QNA');
INSERT INTO `t_region` VALUES ('3277', '620523', '甘谷县', '340', '0', '0', 'Gangu Xian', 'GGU');
INSERT INTO `t_region` VALUES ('3278', '620524', '武山县', '340', '0', '0', 'Wushan Xian', 'WSX');
INSERT INTO `t_region` VALUES ('3279', '620525', '张家川回族自治县', '340', '0', '0', 'Zhangjiachuan Huizu Zizhixian', 'ZJC');
INSERT INTO `t_region` VALUES ('3280', '620601', '市辖区', '341', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('3281', '620602', '凉州区', '341', '0', '0', 'Liangzhou Qu', '2');
INSERT INTO `t_region` VALUES ('3282', '620621', '民勤县', '341', '0', '0', 'Minqin Xian', '2');
INSERT INTO `t_region` VALUES ('3283', '620622', '古浪县', '341', '0', '0', 'Gulang Xian', '2');
INSERT INTO `t_region` VALUES ('3284', '620623', '天祝藏族自治县', '341', '0', '0', 'Tianzhu Zangzu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('3285', '620701', '市辖区', '342', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('3286', '620702', '甘州区', '342', '0', '0', 'Ganzhou Qu', '2');
INSERT INTO `t_region` VALUES ('3287', '620721', '肃南裕固族自治县', '342', '0', '0', 'Sunan Yugurzu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('3288', '620722', '民乐县', '342', '0', '0', 'Minle Xian', '2');
INSERT INTO `t_region` VALUES ('3289', '620723', '临泽县', '342', '0', '0', 'Linze Xian', '2');
INSERT INTO `t_region` VALUES ('3290', '620724', '高台县', '342', '0', '0', 'Gaotai Xian', '2');
INSERT INTO `t_region` VALUES ('3291', '620725', '山丹县', '342', '0', '0', 'Shandan Xian', '2');
INSERT INTO `t_region` VALUES ('3292', '620801', '市辖区', '343', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('3293', '620802', '崆峒区', '343', '0', '0', 'Kongdong Qu', '2');
INSERT INTO `t_region` VALUES ('3294', '620821', '泾川县', '343', '0', '0', 'Jingchuan Xian', '2');
INSERT INTO `t_region` VALUES ('3295', '620822', '灵台县', '343', '0', '0', 'Lingtai Xian', '2');
INSERT INTO `t_region` VALUES ('3296', '620823', '崇信县', '343', '0', '0', 'Chongxin Xian', '2');
INSERT INTO `t_region` VALUES ('3297', '620824', '华亭县', '343', '0', '0', 'Huating Xian', '2');
INSERT INTO `t_region` VALUES ('3298', '620825', '庄浪县', '343', '0', '0', 'Zhuanglang Xian', '2');
INSERT INTO `t_region` VALUES ('3299', '620826', '静宁县', '343', '0', '0', 'Jingning Xian', '2');
INSERT INTO `t_region` VALUES ('3300', '620901', '市辖区', '344', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('3301', '620902', '肃州区', '344', '0', '0', 'Suzhou Qu', '2');
INSERT INTO `t_region` VALUES ('3302', '620921', '金塔县', '344', '0', '0', 'Jinta Xian', '2');
INSERT INTO `t_region` VALUES ('3304', '620923', '肃北蒙古族自治县', '344', '0', '0', 'Subei Monguzu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('3305', '620924', '阿克塞哈萨克族自治县', '344', '0', '0', 'Aksay Kazakzu Zizhixian', '2');
INSERT INTO `t_region` VALUES ('3306', '620981', '玉门市', '344', '0', '0', 'Yumen Shi', '2');
INSERT INTO `t_region` VALUES ('3307', '620982', '敦煌市', '344', '0', '0', 'Dunhuang Shi', '2');
INSERT INTO `t_region` VALUES ('3308', '621001', '市辖区', '345', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('3309', '621002', '西峰区', '345', '0', '0', 'Xifeng Qu', '2');
INSERT INTO `t_region` VALUES ('3310', '621021', '庆城县', '345', '0', '0', 'Qingcheng Xian', '2');
INSERT INTO `t_region` VALUES ('3311', '621022', '环县', '345', '0', '0', 'Huan Xian', '2');
INSERT INTO `t_region` VALUES ('3312', '621023', '华池县', '345', '0', '0', 'Huachi Xian', '2');
INSERT INTO `t_region` VALUES ('3313', '621024', '合水县', '345', '0', '0', 'Heshui Xian', '2');
INSERT INTO `t_region` VALUES ('3314', '621025', '正宁县', '345', '0', '0', 'Zhengning Xian', '2');
INSERT INTO `t_region` VALUES ('3315', '621026', '宁县', '345', '0', '0', 'Ning Xian', '2');
INSERT INTO `t_region` VALUES ('3316', '621027', '镇原县', '345', '0', '0', 'Zhenyuan Xian', '2');
INSERT INTO `t_region` VALUES ('3317', '621101', '市辖区', '346', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('3318', '621102', '安定区', '346', '0', '0', 'Anding Qu', '2');
INSERT INTO `t_region` VALUES ('3319', '621121', '通渭县', '346', '0', '0', 'Tongwei Xian', '2');
INSERT INTO `t_region` VALUES ('3320', '621122', '陇西县', '346', '0', '0', 'Longxi Xian', '2');
INSERT INTO `t_region` VALUES ('3321', '621123', '渭源县', '346', '0', '0', 'Weiyuan Xian', '2');
INSERT INTO `t_region` VALUES ('3322', '621124', '临洮县', '346', '0', '0', 'Lintao Xian', '2');
INSERT INTO `t_region` VALUES ('3323', '621125', '漳县', '346', '0', '0', 'Zhang Xian', '2');
INSERT INTO `t_region` VALUES ('3324', '621126', '岷县', '346', '0', '0', 'Min Xian', '2');
INSERT INTO `t_region` VALUES ('3325', '621201', '市辖区', '347', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('3326', '621202', '武都区', '347', '0', '0', 'Wudu Qu', '2');
INSERT INTO `t_region` VALUES ('3327', '621221', '成县', '347', '0', '0', 'Cheng Xian', '2');
INSERT INTO `t_region` VALUES ('3328', '621222', '文县', '347', '0', '0', 'Wen Xian', '2');
INSERT INTO `t_region` VALUES ('3329', '621223', '宕昌县', '347', '0', '0', 'Dangchang Xian', '2');
INSERT INTO `t_region` VALUES ('3330', '621224', '康县', '347', '0', '0', 'Kang Xian', '2');
INSERT INTO `t_region` VALUES ('3331', '621225', '西和县', '347', '0', '0', 'Xihe Xian', '2');
INSERT INTO `t_region` VALUES ('3332', '621226', '礼县', '347', '0', '0', 'Li Xian', '2');
INSERT INTO `t_region` VALUES ('3333', '621227', '徽县', '347', '0', '0', 'Hui Xian', '2');
INSERT INTO `t_region` VALUES ('3334', '621228', '两当县', '347', '0', '0', 'Liangdang Xian', '2');
INSERT INTO `t_region` VALUES ('3335', '622901', '临夏市', '348', '0', '0', 'Linxia Shi', 'LXR');
INSERT INTO `t_region` VALUES ('3336', '622921', '临夏县', '348', '0', '0', 'Linxia Xian', 'LXF');
INSERT INTO `t_region` VALUES ('3337', '622922', '康乐县', '348', '0', '0', 'Kangle Xian', 'KLE');
INSERT INTO `t_region` VALUES ('3338', '622923', '永靖县', '348', '0', '0', 'Yongjing Xian', 'YJG');
INSERT INTO `t_region` VALUES ('3339', '622924', '广河县', '348', '0', '0', 'Guanghe Xian', 'GHX');
INSERT INTO `t_region` VALUES ('3340', '622925', '和政县', '348', '0', '0', 'Hezheng Xian', 'HZG');
INSERT INTO `t_region` VALUES ('3341', '622926', '东乡族自治县', '348', '0', '0', 'Dongxiangzu Zizhixian', 'DXZ');
INSERT INTO `t_region` VALUES ('3342', '622927', '积石山保安族东乡族撒拉族自治县', '348', '0', '0', 'Jishishan Bonanzu Dongxiangzu Salarzu Zizhixian', 'JSN');
INSERT INTO `t_region` VALUES ('3343', '623001', '合作市', '349', '0', '0', 'Hezuo Shi', 'HEZ');
INSERT INTO `t_region` VALUES ('3344', '623021', '临潭县', '349', '0', '0', 'Lintan Xian', 'LTN');
INSERT INTO `t_region` VALUES ('3345', '623022', '卓尼县', '349', '0', '0', 'Jone', 'JON');
INSERT INTO `t_region` VALUES ('3346', '623023', '舟曲县', '349', '0', '0', 'Zhugqu Xian', 'ZQU');
INSERT INTO `t_region` VALUES ('3347', '623024', '迭部县', '349', '0', '0', 'Tewo Xian', 'TEW');
INSERT INTO `t_region` VALUES ('3348', '623025', '玛曲县', '349', '0', '0', 'Maqu Xian', 'MQU');
INSERT INTO `t_region` VALUES ('3349', '623026', '碌曲县', '349', '0', '0', 'Luqu Xian', 'LQU');
INSERT INTO `t_region` VALUES ('3350', '623027', '夏河县', '349', '0', '0', 'Xiahe Xian', 'XHN');
INSERT INTO `t_region` VALUES ('3351', '630101', '市辖区', '350', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3352', '630102', '城东区', '350', '0', '0', 'Chengdong Qu', 'CDQ');
INSERT INTO `t_region` VALUES ('3353', '630103', '城中区', '350', '0', '0', 'Chengzhong Qu', 'CZQ');
INSERT INTO `t_region` VALUES ('3354', '630104', '城西区', '350', '0', '0', 'Chengxi Qu', 'CXQ');
INSERT INTO `t_region` VALUES ('3355', '630105', '城北区', '350', '0', '0', 'Chengbei Qu', 'CBE');
INSERT INTO `t_region` VALUES ('3356', '630121', '大通回族土族自治县', '350', '0', '0', 'Datong Huizu Tuzu Zizhixian', 'DAT');
INSERT INTO `t_region` VALUES ('3357', '630122', '湟中县', '350', '0', '0', 'Huangzhong Xian', '2');
INSERT INTO `t_region` VALUES ('3358', '630123', '湟源县', '350', '0', '0', 'Huangyuan Xian', '2');
INSERT INTO `t_region` VALUES ('3359', '632121', '平安县', '351', '0', '0', 'Ping,an Xian', 'PAN');
INSERT INTO `t_region` VALUES ('3360', '632122', '民和回族土族自治县', '351', '0', '0', 'Minhe Huizu Tuzu Zizhixian', 'MHE');
INSERT INTO `t_region` VALUES ('3361', '632123', '乐都县', '351', '0', '0', 'Ledu Xian', 'LDU');
INSERT INTO `t_region` VALUES ('3362', '632126', '互助土族自治县', '351', '0', '0', 'Huzhu Tuzu Zizhixian', 'HZT');
INSERT INTO `t_region` VALUES ('3363', '632127', '化隆回族自治县', '351', '0', '0', 'Hualong Huizu Zizhixian', 'HLO');
INSERT INTO `t_region` VALUES ('3364', '632128', '循化撒拉族自治县', '351', '0', '0', 'Xunhua Salazu Zizhixian', 'XUH');
INSERT INTO `t_region` VALUES ('3365', '632221', '门源回族自治县', '352', '0', '0', 'Menyuan Huizu Zizhixian', 'MYU');
INSERT INTO `t_region` VALUES ('3366', '632222', '祁连县', '352', '0', '0', 'Qilian Xian', 'QLN');
INSERT INTO `t_region` VALUES ('3367', '632223', '海晏县', '352', '0', '0', 'Haiyan Xian', 'HIY');
INSERT INTO `t_region` VALUES ('3368', '632224', '刚察县', '352', '0', '0', 'Gangca Xian', 'GAN');
INSERT INTO `t_region` VALUES ('3369', '632321', '同仁县', '353', '0', '0', 'Tongren Xian', 'TRN');
INSERT INTO `t_region` VALUES ('3370', '632322', '尖扎县', '353', '0', '0', 'Jainca Xian', 'JAI');
INSERT INTO `t_region` VALUES ('3371', '632323', '泽库县', '353', '0', '0', 'Zekog Xian', 'ZEK');
INSERT INTO `t_region` VALUES ('3372', '632324', '河南蒙古族自治县', '353', '0', '0', 'Henan Mongolzu Zizhixian', 'HNM');
INSERT INTO `t_region` VALUES ('3373', '632521', '共和县', '354', '0', '0', 'Gonghe Xian', 'GHE');
INSERT INTO `t_region` VALUES ('3374', '632522', '同德县', '354', '0', '0', 'Tongde Xian', 'TDX');
INSERT INTO `t_region` VALUES ('3375', '632523', '贵德县', '354', '0', '0', 'Guide Xian', 'GID');
INSERT INTO `t_region` VALUES ('3376', '632524', '兴海县', '354', '0', '0', 'Xinghai Xian', 'XHA');
INSERT INTO `t_region` VALUES ('3377', '632525', '贵南县', '354', '0', '0', 'Guinan Xian', 'GNN');
INSERT INTO `t_region` VALUES ('3378', '632621', '玛沁县', '355', '0', '0', 'Maqen Xian', 'MAQ');
INSERT INTO `t_region` VALUES ('3379', '632622', '班玛县', '355', '0', '0', 'Baima Xian', 'BMX');
INSERT INTO `t_region` VALUES ('3380', '632623', '甘德县', '355', '0', '0', 'Gade Xian', 'GAD');
INSERT INTO `t_region` VALUES ('3381', '632624', '达日县', '355', '0', '0', 'Tarlag Xian', 'TAR');
INSERT INTO `t_region` VALUES ('3382', '632625', '久治县', '355', '0', '0', 'Jigzhi Xian', 'JUZ');
INSERT INTO `t_region` VALUES ('3383', '632626', '玛多县', '355', '0', '0', 'Madoi Xian', 'MAD');
INSERT INTO `t_region` VALUES ('3384', '632721', '玉树县', '356', '0', '0', 'Yushu Xian', 'YSK');
INSERT INTO `t_region` VALUES ('3385', '632722', '杂多县', '356', '0', '0', 'Zadoi Xian', 'ZAD');
INSERT INTO `t_region` VALUES ('3386', '632723', '称多县', '356', '0', '0', 'Chindu Xian', 'CHI');
INSERT INTO `t_region` VALUES ('3387', '632724', '治多县', '356', '0', '0', 'Zhidoi Xian', 'ZHI');
INSERT INTO `t_region` VALUES ('3388', '632725', '囊谦县', '356', '0', '0', 'Nangqen Xian', 'NQN');
INSERT INTO `t_region` VALUES ('3389', '632726', '曲麻莱县', '356', '0', '0', 'Qumarleb Xian', 'QUM');
INSERT INTO `t_region` VALUES ('3390', '632801', '格尔木市', '357', '0', '0', 'Golmud Shi', 'GOS');
INSERT INTO `t_region` VALUES ('3391', '632802', '德令哈市', '357', '0', '0', 'Delhi Shi', 'DEL');
INSERT INTO `t_region` VALUES ('3392', '632821', '乌兰县', '357', '0', '0', 'Ulan Xian', 'ULA');
INSERT INTO `t_region` VALUES ('3393', '632822', '都兰县', '357', '0', '0', 'Dulan Xian', 'DUL');
INSERT INTO `t_region` VALUES ('3394', '632823', '天峻县', '357', '0', '0', 'Tianjun Xian', 'TJN');
INSERT INTO `t_region` VALUES ('3395', '640101', '市辖区', '358', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3396', '640104', '兴庆区', '358', '0', '0', 'Xingqing Qu', '2');
INSERT INTO `t_region` VALUES ('3397', '640105', '西夏区', '358', '0', '0', 'Xixia Qu', '2');
INSERT INTO `t_region` VALUES ('3398', '640106', '金凤区', '358', '0', '0', 'Jinfeng Qu', '2');
INSERT INTO `t_region` VALUES ('3399', '640121', '永宁县', '358', '0', '0', 'Yongning Xian', 'YGN');
INSERT INTO `t_region` VALUES ('3400', '640122', '贺兰县', '358', '0', '0', 'Helan Xian', 'HLN');
INSERT INTO `t_region` VALUES ('3401', '640181', '灵武市', '358', '0', '0', 'Lingwu Shi', '2');
INSERT INTO `t_region` VALUES ('3402', '640201', '市辖区', '359', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3403', '640202', '大武口区', '359', '0', '0', 'Dawukou Qu', 'DWK');
INSERT INTO `t_region` VALUES ('3404', '640205', '惠农区', '359', '0', '0', 'Huinong Qu', '2');
INSERT INTO `t_region` VALUES ('3405', '640221', '平罗县', '359', '0', '0', 'Pingluo Xian', 'PLO');
INSERT INTO `t_region` VALUES ('3406', '640301', '市辖区', '360', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3407', '640302', '利通区', '360', '0', '0', 'Litong Qu', 'LTW');
INSERT INTO `t_region` VALUES ('3408', '640323', '盐池县', '360', '0', '0', 'Yanchi Xian', 'YCY');
INSERT INTO `t_region` VALUES ('3409', '640324', '同心县', '360', '0', '0', 'Tongxin Xian', 'TGX');
INSERT INTO `t_region` VALUES ('3410', '640381', '青铜峡市', '360', '0', '0', 'Qingtongxia Xian', 'QTX');
INSERT INTO `t_region` VALUES ('3411', '640401', '市辖区', '361', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('3412', '640402', '原州区', '361', '0', '0', 'Yuanzhou Qu', '2');
INSERT INTO `t_region` VALUES ('3413', '640422', '西吉县', '361', '0', '0', 'Xiji Xian', '2');
INSERT INTO `t_region` VALUES ('3414', '640423', '隆德县', '361', '0', '0', 'Longde Xian', '2');
INSERT INTO `t_region` VALUES ('3415', '640424', '泾源县', '361', '0', '0', 'Jingyuan Xian', '2');
INSERT INTO `t_region` VALUES ('3416', '640425', '彭阳县', '361', '0', '0', 'Pengyang Xian', '2');
INSERT INTO `t_region` VALUES ('3417', '640501', '市辖区', '362', '0', '0', '1', '2');
INSERT INTO `t_region` VALUES ('3418', '640502', '沙坡头区', '362', '0', '0', 'Shapotou Qu', '2');
INSERT INTO `t_region` VALUES ('3419', '640521', '中宁县', '362', '0', '0', 'Zhongning Xian', '2');
INSERT INTO `t_region` VALUES ('3420', '640522', '海原县', '362', '0', '0', 'Haiyuan Xian', '2');
INSERT INTO `t_region` VALUES ('3421', '650101', '市辖区', '363', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3422', '650102', '天山区', '363', '0', '0', 'Tianshan Qu', 'TSL');
INSERT INTO `t_region` VALUES ('3423', '650103', '沙依巴克区', '363', '0', '0', 'Saybag Qu', 'SAY');
INSERT INTO `t_region` VALUES ('3424', '650104', '新市区', '363', '0', '0', 'Xinshi Qu', 'XSU');
INSERT INTO `t_region` VALUES ('3425', '650105', '水磨沟区', '363', '0', '0', 'Shuimogou Qu', 'SMG');
INSERT INTO `t_region` VALUES ('3426', '650106', '头屯河区', '363', '0', '0', 'Toutunhe Qu', 'TTH');
INSERT INTO `t_region` VALUES ('3427', '650107', '达坂城区', '363', '0', '0', 'Dabancheng Qu', '2');
INSERT INTO `t_region` VALUES ('3428', '650109', '米东区', '363', '0', '0', 'Midong Qu', '2');
INSERT INTO `t_region` VALUES ('3429', '650121', '乌鲁木齐县', '363', '0', '0', 'Urumqi Xian', 'URX');
INSERT INTO `t_region` VALUES ('3430', '650201', '市辖区', '364', '0', '0', 'Shixiaqu', '2');
INSERT INTO `t_region` VALUES ('3431', '650202', '独山子区', '364', '0', '0', 'Dushanzi Qu', 'DSZ');
INSERT INTO `t_region` VALUES ('3432', '650203', '克拉玛依区', '364', '0', '0', 'Karamay Qu', 'KRQ');
INSERT INTO `t_region` VALUES ('3433', '650204', '白碱滩区', '364', '0', '0', 'Baijiantan Qu', 'BJT');
INSERT INTO `t_region` VALUES ('3434', '650205', '乌尔禾区', '364', '0', '0', 'Orku Qu', 'ORK');
INSERT INTO `t_region` VALUES ('3435', '652101', '吐鲁番市', '365', '0', '0', 'Turpan Shi', 'TUR');
INSERT INTO `t_region` VALUES ('3436', '652122', '鄯善县', '365', '0', '0', 'Shanshan(piqan) Xian', 'SSX');
INSERT INTO `t_region` VALUES ('3437', '652123', '托克逊县', '365', '0', '0', 'Toksun Xian', 'TOK');
INSERT INTO `t_region` VALUES ('3438', '652201', '哈密市', '366', '0', '0', 'Hami(kumul) Shi', 'HAM');
INSERT INTO `t_region` VALUES ('3439', '652222', '巴里坤哈萨克自治县', '366', '0', '0', 'Barkol Kazak Zizhixian', 'BAR');
INSERT INTO `t_region` VALUES ('3440', '652223', '伊吾县', '366', '0', '0', 'Yiwu(Araturuk) Xian', 'YWX');
INSERT INTO `t_region` VALUES ('3441', '652301', '昌吉市', '367', '0', '0', 'Changji Shi', 'CJS');
INSERT INTO `t_region` VALUES ('3442', '652302', '阜康市', '367', '0', '0', 'Fukang Shi', 'FKG');
INSERT INTO `t_region` VALUES ('3444', '652323', '呼图壁县', '367', '0', '0', 'Hutubi Xian', 'HTB');
INSERT INTO `t_region` VALUES ('3445', '652324', '玛纳斯县', '367', '0', '0', 'Manas Xian', 'MAS');
INSERT INTO `t_region` VALUES ('3446', '652325', '奇台县', '367', '0', '0', 'Qitai Xian', 'QTA');
INSERT INTO `t_region` VALUES ('3447', '652327', '吉木萨尔县', '367', '0', '0', 'Jimsar Xian', 'JIM');
INSERT INTO `t_region` VALUES ('3448', '652328', '木垒哈萨克自治县', '367', '0', '0', 'Mori Kazak Zizhixian', 'MOR');
INSERT INTO `t_region` VALUES ('3449', '652701', '博乐市', '368', '0', '0', 'Bole(Bortala) Shi', 'BLE');
INSERT INTO `t_region` VALUES ('3450', '652722', '精河县', '368', '0', '0', 'Jinghe(Jing) Xian', 'JGH');
INSERT INTO `t_region` VALUES ('3451', '652723', '温泉县', '368', '0', '0', 'Wenquan(Arixang) Xian', 'WNQ');
INSERT INTO `t_region` VALUES ('3452', '652801', '库尔勒市', '369', '0', '0', 'Korla Shi', 'KOR');
INSERT INTO `t_region` VALUES ('3453', '652822', '轮台县', '369', '0', '0', 'Luntai(Bugur) Xian', 'LTX');
INSERT INTO `t_region` VALUES ('3454', '652823', '尉犁县', '369', '0', '0', 'Yuli(Lopnur) Xian', 'YLI');
INSERT INTO `t_region` VALUES ('3455', '652824', '若羌县', '369', '0', '0', 'Ruoqiang(Qakilik) Xian', 'RQG');
INSERT INTO `t_region` VALUES ('3456', '652825', '且末县', '369', '0', '0', 'Qiemo(Qarqan) Xian', 'QMO');
INSERT INTO `t_region` VALUES ('3457', '652826', '焉耆回族自治县', '369', '0', '0', 'Yanqi Huizu Zizhixian', 'YQI');
INSERT INTO `t_region` VALUES ('3458', '652827', '和静县', '369', '0', '0', 'Hejing Xian', 'HJG');
INSERT INTO `t_region` VALUES ('3459', '652828', '和硕县', '369', '0', '0', 'Hoxud Xian', 'HOX');
INSERT INTO `t_region` VALUES ('3460', '652829', '博湖县', '369', '0', '0', 'Bohu(Bagrax) Xian', 'BHU');
INSERT INTO `t_region` VALUES ('3461', '652901', '阿克苏市', '370', '0', '0', 'Aksu Shi', 'AKS');
INSERT INTO `t_region` VALUES ('3462', '652922', '温宿县', '370', '0', '0', 'Wensu Xian', 'WSU');
INSERT INTO `t_region` VALUES ('3463', '652923', '库车县', '370', '0', '0', 'Kuqa Xian', 'KUQ');
INSERT INTO `t_region` VALUES ('3464', '652924', '沙雅县', '370', '0', '0', 'Xayar Xian', 'XYR');
INSERT INTO `t_region` VALUES ('3465', '652925', '新和县', '370', '0', '0', 'Xinhe(Toksu) Xian', 'XHT');
INSERT INTO `t_region` VALUES ('3466', '652926', '拜城县', '370', '0', '0', 'Baicheng(Bay) Xian', 'BCG');
INSERT INTO `t_region` VALUES ('3467', '652927', '乌什县', '370', '0', '0', 'Wushi(Uqturpan) Xian', 'WSH');
INSERT INTO `t_region` VALUES ('3468', '652928', '阿瓦提县', '370', '0', '0', 'Awat Xian', 'AWA');
INSERT INTO `t_region` VALUES ('3469', '652929', '柯坪县', '370', '0', '0', 'Kalpin Xian', 'KAL');
INSERT INTO `t_region` VALUES ('3470', '653001', '阿图什市', '371', '0', '0', 'Artux Shi', 'ART');
INSERT INTO `t_region` VALUES ('3471', '653022', '阿克陶县', '371', '0', '0', 'Akto Xian', 'AKT');
INSERT INTO `t_region` VALUES ('3472', '653023', '阿合奇县', '371', '0', '0', 'Akqi Xian', 'AKQ');
INSERT INTO `t_region` VALUES ('3473', '653024', '乌恰县', '371', '0', '0', 'Wuqia(Ulugqat) Xian', 'WQA');
INSERT INTO `t_region` VALUES ('3474', '653101', '喀什市', '372', '0', '0', 'Kashi (Kaxgar) Shi', 'KHG');
INSERT INTO `t_region` VALUES ('3475', '653121', '疏附县', '372', '0', '0', 'Shufu Xian', 'SFU');
INSERT INTO `t_region` VALUES ('3476', '653122', '疏勒县', '372', '0', '0', 'Shule Xian', 'SHL');
INSERT INTO `t_region` VALUES ('3477', '653123', '英吉沙县', '372', '0', '0', 'Yengisar Xian', 'YEN');
INSERT INTO `t_region` VALUES ('3478', '653124', '泽普县', '372', '0', '0', 'Zepu(Poskam) Xian', 'ZEP');
INSERT INTO `t_region` VALUES ('3479', '653125', '莎车县', '372', '0', '0', 'Shache(Yarkant) Xian', 'SHC');
INSERT INTO `t_region` VALUES ('3480', '653126', '叶城县', '372', '0', '0', 'Yecheng(Kargilik) Xian', 'YEC');
INSERT INTO `t_region` VALUES ('3481', '653127', '麦盖提县', '372', '0', '0', 'Markit Xian', 'MAR');
INSERT INTO `t_region` VALUES ('3482', '653128', '岳普湖县', '372', '0', '0', 'Yopurga Xian', 'YOP');
INSERT INTO `t_region` VALUES ('3483', '653129', '伽师县', '372', '0', '0', 'Jiashi(Payzawat) Xian', 'JSI');
INSERT INTO `t_region` VALUES ('3484', '653130', '巴楚县', '372', '0', '0', 'Bachu(Maralbexi) Xian', 'BCX');
INSERT INTO `t_region` VALUES ('3485', '653131', '塔什库尔干塔吉克自治县', '372', '0', '0', 'Taxkorgan Tajik Zizhixian', 'TXK');
INSERT INTO `t_region` VALUES ('3486', '653201', '和田市', '373', '0', '0', 'Hotan Shi', 'HTS');
INSERT INTO `t_region` VALUES ('3487', '653221', '和田县', '373', '0', '0', 'Hotan Xian', 'HOT');
INSERT INTO `t_region` VALUES ('3488', '653222', '墨玉县', '373', '0', '0', 'Moyu(Karakax) Xian', 'MOY');
INSERT INTO `t_region` VALUES ('3489', '653223', '皮山县', '373', '0', '0', 'Pishan(Guma) Xian', 'PSA');
INSERT INTO `t_region` VALUES ('3490', '653224', '洛浦县', '373', '0', '0', 'Lop Xian', 'LOP');
INSERT INTO `t_region` VALUES ('3491', '653225', '策勒县', '373', '0', '0', 'Qira Xian', 'QIR');
INSERT INTO `t_region` VALUES ('3492', '653226', '于田县', '373', '0', '0', 'Yutian(Keriya) Xian', 'YUT');
INSERT INTO `t_region` VALUES ('3493', '653227', '民丰县', '373', '0', '0', 'Minfeng(Niya) Xian', 'MFG');
INSERT INTO `t_region` VALUES ('3494', '654002', '伊宁市', '374', '0', '0', 'Yining(Gulja) Shi', '2');
INSERT INTO `t_region` VALUES ('3495', '654003', '奎屯市', '374', '0', '0', 'Kuytun Shi', '2');
INSERT INTO `t_region` VALUES ('3496', '654021', '伊宁县', '374', '0', '0', 'Yining(Gulja) Xian', '2');
INSERT INTO `t_region` VALUES ('3497', '654022', '察布查尔锡伯自治县', '374', '0', '0', 'Qapqal Xibe Zizhixian', '2');
INSERT INTO `t_region` VALUES ('3498', '654023', '霍城县', '374', '0', '0', 'Huocheng Xin', '2');
INSERT INTO `t_region` VALUES ('3499', '654024', '巩留县', '374', '0', '0', 'Gongliu(Tokkuztara) Xian', '2');
INSERT INTO `t_region` VALUES ('3500', '654025', '新源县', '374', '0', '0', 'Xinyuan(Kunes) Xian', '2');
INSERT INTO `t_region` VALUES ('3501', '654026', '昭苏县', '374', '0', '0', 'Zhaosu(Mongolkure) Xian', '2');
INSERT INTO `t_region` VALUES ('3502', '654027', '特克斯县', '374', '0', '0', 'Tekes Xian', '2');
INSERT INTO `t_region` VALUES ('3503', '654028', '尼勒克县', '374', '0', '0', 'Nilka Xian', '2');
INSERT INTO `t_region` VALUES ('3504', '654201', '塔城市', '375', '0', '0', 'Tacheng(Qoqek) Shi', 'TCS');
INSERT INTO `t_region` VALUES ('3505', '654202', '乌苏市', '375', '0', '0', 'Usu Shi', 'USU');
INSERT INTO `t_region` VALUES ('3506', '654221', '额敏县', '375', '0', '0', 'Emin(Dorbiljin) Xian', 'EMN');
INSERT INTO `t_region` VALUES ('3507', '654223', '沙湾县', '375', '0', '0', 'Shawan Xian', 'SWX');
INSERT INTO `t_region` VALUES ('3508', '654224', '托里县', '375', '0', '0', 'Toli Xian', 'TLI');
INSERT INTO `t_region` VALUES ('3509', '654225', '裕民县', '375', '0', '0', 'Yumin(Qagantokay) Xian', 'YMN');
INSERT INTO `t_region` VALUES ('3510', '654226', '和布克赛尔蒙古自治县', '375', '0', '0', 'Hebukesaiermengguzizhi Xian', '2');
INSERT INTO `t_region` VALUES ('3511', '654301', '阿勒泰市', '376', '0', '0', 'Altay Shi', 'ALT');
INSERT INTO `t_region` VALUES ('3512', '654321', '布尔津县', '376', '0', '0', 'Burqin Xian', 'BUX');
INSERT INTO `t_region` VALUES ('3513', '654322', '富蕴县', '376', '0', '0', 'Fuyun(Koktokay) Xian', 'FYN');
INSERT INTO `t_region` VALUES ('3514', '654323', '福海县', '376', '0', '0', 'Fuhai(Burultokay) Xian', 'FHI');
INSERT INTO `t_region` VALUES ('3515', '654324', '哈巴河县', '376', '0', '0', 'Habahe(Kaba) Xian', 'HBH');
INSERT INTO `t_region` VALUES ('3516', '654325', '青河县', '376', '0', '0', 'Qinghe(Qinggil) Xian', 'QHX');
INSERT INTO `t_region` VALUES ('3517', '654326', '吉木乃县', '376', '0', '0', 'Jeminay Xian', 'JEM');
INSERT INTO `t_region` VALUES ('3518', '659001', '石河子市', '377', '0', '0', 'Shihezi Shi', 'SHZ');
INSERT INTO `t_region` VALUES ('3519', '659002', '阿拉尔市', '377', '0', '0', 'Alaer Shi', '2');
INSERT INTO `t_region` VALUES ('3520', '659003', '图木舒克市', '377', '0', '0', 'Tumushuke Shi', '2');
INSERT INTO `t_region` VALUES ('3521', '659004', '五家渠市', '377', '0', '0', 'Wujiaqu Shi', '2');
INSERT INTO `t_region` VALUES ('4000', '620503', '麦积区', '340', '0', '0', 'Maiji Qu', '2');
INSERT INTO `t_region` VALUES ('4001', '500116', '江津区', '270', '0', '0', 'Jiangjin Qu', '2');
INSERT INTO `t_region` VALUES ('4002', '500117', '合川区', '270', '0', '0', 'Hechuan Qu', '2');
INSERT INTO `t_region` VALUES ('4003', '500118', '永川区', '270', '0', '0', 'Yongchuan Qu', '2');
INSERT INTO `t_region` VALUES ('4004', '500119', '南川区', '270', '0', '0', 'Nanchuan Qu', '2');
INSERT INTO `t_region` VALUES ('4006', '340221', '芜湖县', '1412', '0', '0', 'Wuhu Xian', 'WHX');
INSERT INTO `t_region` VALUES ('4100', '232701', '加格达奇区', '106', '0', '0', 'Jiagedaqi Qu', '2');
INSERT INTO `t_region` VALUES ('4101', '232702', '松岭区', '106', '0', '0', 'Songling Qu', '2');
INSERT INTO `t_region` VALUES ('4102', '232703', '新林区', '106', '0', '0', 'Xinlin Qu', '2');
INSERT INTO `t_region` VALUES ('4103', '232704', '呼中区', '106', '0', '0', 'Huzhong Qu', '2');
INSERT INTO `t_region` VALUES ('4200', '330402', '南湖区', '125', '0', '0', 'Nanhu Qu', '2');
INSERT INTO `t_region` VALUES ('4300', '360482', '共青城市', '162', '0', '0', 'Gongqingcheng Shi', 'GQCS');
INSERT INTO `t_region` VALUES ('4400', '640303', '红寺堡区', '360', '0', '0', 'Hongsibao Qu', 'HSBQ');
INSERT INTO `t_region` VALUES ('4500', '620922', '瓜州县', '344', '0', '0', 'Guazhou Xian', 'GZS');
INSERT INTO `t_region` VALUES ('4600', '421321', '随县', '215', '0', '0', 'Sui Xian', 'SX');
INSERT INTO `t_region` VALUES ('4700', '431102', '零陵区', '228', '0', '0', 'Lingling Qu', 'LLQ');
INSERT INTO `t_region` VALUES ('4800', '451119', '平桂管理区', '263', '0', '0', 'Pingguiguanli Qu', 'PGGLQ');
INSERT INTO `t_region` VALUES ('4900', '510802', '利州区', '279', '0', '0', 'Lizhou Qu', 'LZQ');
INSERT INTO `t_region` VALUES ('5000', '511681', '华蓥市', '286', '0', '0', 'Huaying Shi', 'HYC');

-- ----------------------------
-- Table structure for t_sen_words
-- ----------------------------
DROP TABLE IF EXISTS `t_sen_words`;
CREATE TABLE `t_sen_words` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `word` varchar(25) NOT NULL,
  `type` int(2) DEFAULT NULL COMMENT '1政治类，2',
  `status` int(1) DEFAULT '1' COMMENT '状态(1可用)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1786 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sen_words
-- ----------------------------
INSERT INTO `t_sen_words` VALUES ('1', '第一代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('2', '第二代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('3', '第三代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('4', '第四代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('5', '第五代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('6', '第六代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('7', '第七代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('8', '第1代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('9', '第2代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('10', '第3代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('11', '第4代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('12', '第5代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('13', '第6代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('14', '第7代领导', '1', '1');
INSERT INTO `t_sen_words` VALUES ('15', '一位老同志的谈话', '1', '1');
INSERT INTO `t_sen_words` VALUES ('16', '国办发', '1', '1');
INSERT INTO `t_sen_words` VALUES ('17', '中办发', '1', '1');
INSERT INTO `t_sen_words` VALUES ('18', '腐败中国', '1', '1');
INSERT INTO `t_sen_words` VALUES ('19', '三个呆婊', '1', '1');
INSERT INTO `t_sen_words` VALUES ('20', '你办事我放心', '1', '1');
INSERT INTO `t_sen_words` VALUES ('21', '社会主义灭亡', '1', '1');
INSERT INTO `t_sen_words` VALUES ('22', '打倒中国', '1', '1');
INSERT INTO `t_sen_words` VALUES ('23', '灭亡中国', '1', '1');
INSERT INTO `t_sen_words` VALUES ('24', '亡党亡国', '1', '1');
INSERT INTO `t_sen_words` VALUES ('25', '粉碎四人帮', '1', '1');
INSERT INTO `t_sen_words` VALUES ('26', '激流中国', '1', '1');
INSERT INTO `t_sen_words` VALUES ('27', '特供', '1', '1');
INSERT INTO `t_sen_words` VALUES ('28', '特贡', '1', '1');
INSERT INTO `t_sen_words` VALUES ('29', '特共', '1', '1');
INSERT INTO `t_sen_words` VALUES ('30', 'zf大楼', '1', '1');
INSERT INTO `t_sen_words` VALUES ('31', '殃视', '1', '1');
INSERT INTO `t_sen_words` VALUES ('32', '贪污腐败', '1', '1');
INSERT INTO `t_sen_words` VALUES ('33', '强制拆除', '1', '1');
INSERT INTO `t_sen_words` VALUES ('34', '形式主义', '1', '1');
INSERT INTO `t_sen_words` VALUES ('35', '政治风波', '1', '1');
INSERT INTO `t_sen_words` VALUES ('36', '太子党', '1', '1');
INSERT INTO `t_sen_words` VALUES ('37', '上海帮', '1', '1');
INSERT INTO `t_sen_words` VALUES ('38', '北京帮', '1', '1');
INSERT INTO `t_sen_words` VALUES ('39', '清华帮', '1', '1');
INSERT INTO `t_sen_words` VALUES ('40', '红色贵族', '1', '1');
INSERT INTO `t_sen_words` VALUES ('41', '权贵集团', '1', '1');
INSERT INTO `t_sen_words` VALUES ('42', '河蟹社会', '1', '1');
INSERT INTO `t_sen_words` VALUES ('43', '喝血社会', '1', '1');
INSERT INTO `t_sen_words` VALUES ('44', '九风', '1', '1');
INSERT INTO `t_sen_words` VALUES ('45', '9风', '1', '1');
INSERT INTO `t_sen_words` VALUES ('46', '十七大', '1', '1');
INSERT INTO `t_sen_words` VALUES ('47', '十7大', '1', '1');
INSERT INTO `t_sen_words` VALUES ('48', '17da', '1', '1');
INSERT INTO `t_sen_words` VALUES ('49', '九学', '1', '1');
INSERT INTO `t_sen_words` VALUES ('50', '9学', '1', '1');
INSERT INTO `t_sen_words` VALUES ('51', '四风', '1', '1');
INSERT INTO `t_sen_words` VALUES ('52', '4风', '1', '1');
INSERT INTO `t_sen_words` VALUES ('53', '双规', '1', '1');
INSERT INTO `t_sen_words` VALUES ('54', '南街村', '1', '1');
INSERT INTO `t_sen_words` VALUES ('55', '最淫官员', '1', '1');
INSERT INTO `t_sen_words` VALUES ('56', '警匪', '1', '1');
INSERT INTO `t_sen_words` VALUES ('57', '官匪', '1', '1');
INSERT INTO `t_sen_words` VALUES ('58', '独夫民贼', '1', '1');
INSERT INTO `t_sen_words` VALUES ('59', '官商勾结', '1', '1');
INSERT INTO `t_sen_words` VALUES ('60', '城管暴力执法', '1', '1');
INSERT INTO `t_sen_words` VALUES ('61', '强制捐款', '1', '1');
INSERT INTO `t_sen_words` VALUES ('62', '毒豺', '1', '1');
INSERT INTO `t_sen_words` VALUES ('63', '一党执政', '1', '1');
INSERT INTO `t_sen_words` VALUES ('64', '一党专制', '1', '1');
INSERT INTO `t_sen_words` VALUES ('65', '一党专政', '1', '1');
INSERT INTO `t_sen_words` VALUES ('66', '专制政权', '1', '1');
INSERT INTO `t_sen_words` VALUES ('67', '宪法法院', '1', '1');
INSERT INTO `t_sen_words` VALUES ('68', '胡平', '1', '1');
INSERT INTO `t_sen_words` VALUES ('69', '苏晓康', '1', '1');
INSERT INTO `t_sen_words` VALUES ('70', '贺卫方', '1', '1');
INSERT INTO `t_sen_words` VALUES ('71', '谭作人', '1', '1');
INSERT INTO `t_sen_words` VALUES ('72', '焦国标', '1', '1');
INSERT INTO `t_sen_words` VALUES ('73', '万润南', '1', '1');
INSERT INTO `t_sen_words` VALUES ('74', '张志新', '1', '1');
INSERT INTO `t_sen_words` VALUES ('75', '辛灝年', '1', '1');
INSERT INTO `t_sen_words` VALUES ('76', '高勤荣', '1', '1');
INSERT INTO `t_sen_words` VALUES ('77', '王炳章', '1', '1');
INSERT INTO `t_sen_words` VALUES ('78', '高智晟', '1', '1');
INSERT INTO `t_sen_words` VALUES ('79', '司马璐', '1', '1');
INSERT INTO `t_sen_words` VALUES ('80', '刘晓竹', '1', '1');
INSERT INTO `t_sen_words` VALUES ('81', '刘宾雁', '1', '1');
INSERT INTO `t_sen_words` VALUES ('82', '魏京生', '1', '1');
INSERT INTO `t_sen_words` VALUES ('83', '寻找林昭的灵魂', '1', '1');
INSERT INTO `t_sen_words` VALUES ('84', '别梦成灰', '1', '1');
INSERT INTO `t_sen_words` VALUES ('85', '谁是新中国', '1', '1');
INSERT INTO `t_sen_words` VALUES ('86', '讨伐中宣部', '1', '1');
INSERT INTO `t_sen_words` VALUES ('87', '异议人士', '1', '1');
INSERT INTO `t_sen_words` VALUES ('88', '民运人士', '1', '1');
INSERT INTO `t_sen_words` VALUES ('89', '启蒙派', '1', '1');
INSERT INTO `t_sen_words` VALUES ('90', '选国家主席', '1', '1');
INSERT INTO `t_sen_words` VALUES ('91', '民一主', '1', '1');
INSERT INTO `t_sen_words` VALUES ('92', 'min主', '1', '1');
INSERT INTO `t_sen_words` VALUES ('93', '民竹', '1', '1');
INSERT INTO `t_sen_words` VALUES ('94', '民珠', '1', '1');
INSERT INTO `t_sen_words` VALUES ('95', '民猪', '1', '1');
INSERT INTO `t_sen_words` VALUES ('96', 'chinesedemocracy', '1', '1');
INSERT INTO `t_sen_words` VALUES ('97', '大赦国际', '1', '1');
INSERT INTO `t_sen_words` VALUES ('98', '国际特赦', '1', '1');
INSERT INTO `t_sen_words` VALUES ('99', 'da选', '1', '1');
INSERT INTO `t_sen_words` VALUES ('100', '投公', '1', '1');
INSERT INTO `t_sen_words` VALUES ('101', '公头', '1', '1');
INSERT INTO `t_sen_words` VALUES ('102', '宪政', '1', '1');
INSERT INTO `t_sen_words` VALUES ('103', '平反', '1', '1');
INSERT INTO `t_sen_words` VALUES ('104', '党章', '1', '1');
INSERT INTO `t_sen_words` VALUES ('105', '维权', '1', '1');
INSERT INTO `t_sen_words` VALUES ('106', '昝爱宗', '1', '1');
INSERT INTO `t_sen_words` VALUES ('107', '宪章', '1', '1');
INSERT INTO `t_sen_words` VALUES ('108', '08宪', '1', '1');
INSERT INTO `t_sen_words` VALUES ('109', '08xz', '1', '1');
INSERT INTO `t_sen_words` VALUES ('110', '觉醒的中国公民日渐清楚地认识到', '1', '1');
INSERT INTO `t_sen_words` VALUES ('111', '抿主', '1', '1');
INSERT INTO `t_sen_words` VALUES ('112', '民主', '1', '1');
INSERT INTO `t_sen_words` VALUES ('113', '敏主', '1', '1');
INSERT INTO `t_sen_words` VALUES ('114', '人拳', '1', '1');
INSERT INTO `t_sen_words` VALUES ('115', '人木又', '1', '1');
INSERT INTO `t_sen_words` VALUES ('116', '人quan', '1', '1');
INSERT INTO `t_sen_words` VALUES ('117', 'renquan', '1', '1');
INSERT INTO `t_sen_words` VALUES ('118', '中国人权', '1', '1');
INSERT INTO `t_sen_words` VALUES ('119', '中国的人权', '1', '1');
INSERT INTO `t_sen_words` VALUES ('120', '中国新民党', '1', '1');
INSERT INTO `t_sen_words` VALUES ('121', '群体事件', '1', '1');
INSERT INTO `t_sen_words` VALUES ('122', '群体性事件', '1', '1');
INSERT INTO `t_sen_words` VALUES ('123', '上中央', '1', '1');
INSERT INTO `t_sen_words` VALUES ('124', '去中央', '1', '1');
INSERT INTO `t_sen_words` VALUES ('125', '讨说法', '1', '1');
INSERT INTO `t_sen_words` VALUES ('126', '请愿', '1', '1');
INSERT INTO `t_sen_words` VALUES ('127', '请命', '1', '1');
INSERT INTO `t_sen_words` VALUES ('128', '公开信', '1', '1');
INSERT INTO `t_sen_words` VALUES ('129', '联名上书', '1', '1');
INSERT INTO `t_sen_words` VALUES ('130', '万人大签名', '1', '1');
INSERT INTO `t_sen_words` VALUES ('131', '万人骚动', '1', '1');
INSERT INTO `t_sen_words` VALUES ('132', '截访', '1', '1');
INSERT INTO `t_sen_words` VALUES ('133', '上访', '1', '1');
INSERT INTO `t_sen_words` VALUES ('134', 'shangfang', '1', '1');
INSERT INTO `t_sen_words` VALUES ('135', '信访', '1', '1');
INSERT INTO `t_sen_words` VALUES ('136', '访民', '1', '1');
INSERT INTO `t_sen_words` VALUES ('137', '集合', '1', '1');
INSERT INTO `t_sen_words` VALUES ('138', '集会', '1', '1');
INSERT INTO `t_sen_words` VALUES ('139', '组织集体', '1', '1');
INSERT INTO `t_sen_words` VALUES ('140', '静坐', '1', '1');
INSERT INTO `t_sen_words` VALUES ('141', '静zuo', '1', '1');
INSERT INTO `t_sen_words` VALUES ('142', 'jing坐', '1', '1');
INSERT INTO `t_sen_words` VALUES ('143', '示威', '1', '1');
INSERT INTO `t_sen_words` VALUES ('144', '示wei', '1', '1');
INSERT INTO `t_sen_words` VALUES ('145', '游行', '1', '1');
INSERT INTO `t_sen_words` VALUES ('146', 'you行', '1', '1');
INSERT INTO `t_sen_words` VALUES ('147', '油行', '1', '1');
INSERT INTO `t_sen_words` VALUES ('148', '游xing', '1', '1');
INSERT INTO `t_sen_words` VALUES ('149', 'youxing', '1', '1');
INSERT INTO `t_sen_words` VALUES ('150', '官逼民反', '1', '1');
INSERT INTO `t_sen_words` VALUES ('151', '反party', '1', '1');
INSERT INTO `t_sen_words` VALUES ('152', '反共', '1', '1');
INSERT INTO `t_sen_words` VALUES ('153', '抗议', '1', '1');
INSERT INTO `t_sen_words` VALUES ('154', '亢议', '1', '1');
INSERT INTO `t_sen_words` VALUES ('155', '抵制', '1', '1');
INSERT INTO `t_sen_words` VALUES ('156', '低制', '1', '1');
INSERT INTO `t_sen_words` VALUES ('157', '底制', '1', '1');
INSERT INTO `t_sen_words` VALUES ('158', 'di制', '1', '1');
INSERT INTO `t_sen_words` VALUES ('159', '抵zhi', '1', '1');
INSERT INTO `t_sen_words` VALUES ('160', 'dizhi', '1', '1');
INSERT INTO `t_sen_words` VALUES ('161', 'boycott', '1', '1');
INSERT INTO `t_sen_words` VALUES ('162', '血书', '1', '1');
INSERT INTO `t_sen_words` VALUES ('163', '焚烧中国国旗', '1', '1');
INSERT INTO `t_sen_words` VALUES ('164', 'baoluan', '1', '1');
INSERT INTO `t_sen_words` VALUES ('165', '流血冲突', '1', '1');
INSERT INTO `t_sen_words` VALUES ('166', '出现暴动', '1', '1');
INSERT INTO `t_sen_words` VALUES ('167', '发生暴动', '1', '1');
INSERT INTO `t_sen_words` VALUES ('168', '引起暴动', '1', '1');
INSERT INTO `t_sen_words` VALUES ('169', 'baodong', '1', '1');
INSERT INTO `t_sen_words` VALUES ('170', '灭共', '1', '1');
INSERT INTO `t_sen_words` VALUES ('171', '杀毙', '1', '1');
INSERT INTO `t_sen_words` VALUES ('172', '罢工', '1', '1');
INSERT INTO `t_sen_words` VALUES ('173', '霸工', '1', '1');
INSERT INTO `t_sen_words` VALUES ('174', '罢考', '1', '1');
INSERT INTO `t_sen_words` VALUES ('175', '罢餐', '1', '1');
INSERT INTO `t_sen_words` VALUES ('176', '霸餐', '1', '1');
INSERT INTO `t_sen_words` VALUES ('177', '罢参', '1', '1');
INSERT INTO `t_sen_words` VALUES ('178', '罢饭', '1', '1');
INSERT INTO `t_sen_words` VALUES ('179', '罢吃', '1', '1');
INSERT INTO `t_sen_words` VALUES ('180', '罢食', '1', '1');
INSERT INTO `t_sen_words` VALUES ('181', '罢课', '1', '1');
INSERT INTO `t_sen_words` VALUES ('182', '罢ke', '1', '1');
INSERT INTO `t_sen_words` VALUES ('183', '霸课', '1', '1');
INSERT INTO `t_sen_words` VALUES ('184', 'ba课', '1', '1');
INSERT INTO `t_sen_words` VALUES ('185', '罢教', '1', '1');
INSERT INTO `t_sen_words` VALUES ('186', '罢学', '1', '1');
INSERT INTO `t_sen_words` VALUES ('187', '罢运', '1', '1');
INSERT INTO `t_sen_words` VALUES ('188', '网特', '1', '1');
INSERT INTO `t_sen_words` VALUES ('189', '网评员', '1', '1');
INSERT INTO `t_sen_words` VALUES ('190', '网络评论员', '1', '1');
INSERT INTO `t_sen_words` VALUES ('191', '五毛党', '1', '1');
INSERT INTO `t_sen_words` VALUES ('192', '五毛们', '1', '1');
INSERT INTO `t_sen_words` VALUES ('193', '5毛党', '1', '1');
INSERT INTO `t_sen_words` VALUES ('194', '戒严', '1', '1');
INSERT INTO `t_sen_words` VALUES ('195', 'jieyan', '1', '1');
INSERT INTO `t_sen_words` VALUES ('196', 'jie严', '1', '1');
INSERT INTO `t_sen_words` VALUES ('197', '戒yan', '1', '1');
INSERT INTO `t_sen_words` VALUES ('198', '8的平方事件', '1', '1');
INSERT INTO `t_sen_words` VALUES ('199', '知道64', '1', '1');
INSERT INTO `t_sen_words` VALUES ('200', '八九年', '1', '1');
INSERT INTO `t_sen_words` VALUES ('201', '贰拾年', '1', '1');
INSERT INTO `t_sen_words` VALUES ('202', '2o年', '1', '1');
INSERT INTO `t_sen_words` VALUES ('203', '20和谐年', '1', '1');
INSERT INTO `t_sen_words` VALUES ('204', '贰拾周年', '1', '1');
INSERT INTO `t_sen_words` VALUES ('205', '六四', '1', '1');
INSERT INTO `t_sen_words` VALUES ('206', '六河蟹四', '1', '1');
INSERT INTO `t_sen_words` VALUES ('207', '六百度四', '1', '1');
INSERT INTO `t_sen_words` VALUES ('208', '六和谐四', '1', '1');
INSERT INTO `t_sen_words` VALUES ('209', '陆四', '1', '1');
INSERT INTO `t_sen_words` VALUES ('210', '陆肆', '1', '1');
INSERT INTO `t_sen_words` VALUES ('211', '198964', '1', '1');
INSERT INTO `t_sen_words` VALUES ('212', '5月35', '1', '1');
INSERT INTO `t_sen_words` VALUES ('213', '89年春夏之交', '1', '1');
INSERT INTO `t_sen_words` VALUES ('214', '64惨案', '1', '1');
INSERT INTO `t_sen_words` VALUES ('215', '64时期', '1', '1');
INSERT INTO `t_sen_words` VALUES ('216', '64运动', '1', '1');
INSERT INTO `t_sen_words` VALUES ('217', '4事件', '1', '1');
INSERT INTO `t_sen_words` VALUES ('218', '四事件', '1', '1');
INSERT INTO `t_sen_words` VALUES ('219', '北京风波', '1', '1');
INSERT INTO `t_sen_words` VALUES ('220', '学潮', '1', '1');
INSERT INTO `t_sen_words` VALUES ('221', '学chao', '1', '1');
INSERT INTO `t_sen_words` VALUES ('222', 'xuechao', '1', '1');
INSERT INTO `t_sen_words` VALUES ('223', '学百度潮', '1', '1');
INSERT INTO `t_sen_words` VALUES ('224', '门安天', '1', '1');
INSERT INTO `t_sen_words` VALUES ('225', '天按门', '1', '1');
INSERT INTO `t_sen_words` VALUES ('226', '坦克压大学生', '1', '1');
INSERT INTO `t_sen_words` VALUES ('227', '民主女神', '1', '1');
INSERT INTO `t_sen_words` VALUES ('228', '历史的伤口', '1', '1');
INSERT INTO `t_sen_words` VALUES ('229', '高自联', '1', '1');
INSERT INTO `t_sen_words` VALUES ('230', '北高联', '1', '1');
INSERT INTO `t_sen_words` VALUES ('231', '维多利亚公园', '1', '1');
INSERT INTO `t_sen_words` VALUES ('232', 'thegateofheavenlypeace', '1', '1');
INSERT INTO `t_sen_words` VALUES ('233', 'bloodisonthesquare', '1', '1');
INSERT INTO `t_sen_words` VALUES ('234', '为了忘却的纪念', '1', '1');
INSERT INTO `t_sen_words` VALUES ('235', '血洗京城', '1', '1');
INSERT INTO `t_sen_words` VALUES ('236', '四二六社论', '1', '1');
INSERT INTO `t_sen_words` VALUES ('237', '王丹', '1', '1');
INSERT INTO `t_sen_words` VALUES ('238', '柴玲', '1', '1');
INSERT INTO `t_sen_words` VALUES ('239', '沈彤', '1', '1');
INSERT INTO `t_sen_words` VALUES ('240', '封从德', '1', '1');
INSERT INTO `t_sen_words` VALUES ('241', '王超华', '1', '1');
INSERT INTO `t_sen_words` VALUES ('242', '王维林', '1', '1');
INSERT INTO `t_sen_words` VALUES ('243', '吾尔开希', '1', '1');
INSERT INTO `t_sen_words` VALUES ('244', '吾尔开西', '1', '1');
INSERT INTO `t_sen_words` VALUES ('245', '侯德健', '1', '1');
INSERT INTO `t_sen_words` VALUES ('246', '阎明复', '1', '1');
INSERT INTO `t_sen_words` VALUES ('247', '方励之', '1', '1');
INSERT INTO `t_sen_words` VALUES ('248', '蒋捷连', '1', '1');
INSERT INTO `t_sen_words` VALUES ('249', '丁子霖', '1', '1');
INSERT INTO `t_sen_words` VALUES ('250', '辛灏年', '1', '1');
INSERT INTO `t_sen_words` VALUES ('251', '蒋彦永', '1', '1');
INSERT INTO `t_sen_words` VALUES ('252', '严家其', '1', '1');
INSERT INTO `t_sen_words` VALUES ('253', '陈一咨', '1', '1');
INSERT INTO `t_sen_words` VALUES ('254', '中华局域网', '1', '1');
INSERT INTO `t_sen_words` VALUES ('255', '党的喉舌', '1', '1');
INSERT INTO `t_sen_words` VALUES ('256', '互联网审查', '1', '1');
INSERT INTO `t_sen_words` VALUES ('257', '当局严密封锁', '1', '1');
INSERT INTO `t_sen_words` VALUES ('258', '新闻封锁', '1', '1');
INSERT INTO `t_sen_words` VALUES ('259', '封锁消息', '1', '1');
INSERT INTO `t_sen_words` VALUES ('260', '爱国者同盟', '1', '1');
INSERT INTO `t_sen_words` VALUES ('261', '关闭所有论坛', '1', '1');
INSERT INTO `t_sen_words` VALUES ('262', '网络封锁', '1', '1');
INSERT INTO `t_sen_words` VALUES ('263', '金盾工程', '1', '1');
INSERT INTO `t_sen_words` VALUES ('264', 'gfw', '1', '1');
INSERT INTO `t_sen_words` VALUES ('265', '无界浏览', '1', '1');
INSERT INTO `t_sen_words` VALUES ('266', '无界网络', '1', '1');
INSERT INTO `t_sen_words` VALUES ('267', '自由门', '1', '1');
INSERT INTO `t_sen_words` VALUES ('268', '何清涟', '1', '1');
INSERT INTO `t_sen_words` VALUES ('269', '中国的陷阱', '1', '1');
INSERT INTO `t_sen_words` VALUES ('270', '汪兆钧', '1', '1');
INSERT INTO `t_sen_words` VALUES ('271', '记者无疆界', '1', '1');
INSERT INTO `t_sen_words` VALUES ('272', '境外媒体', '1', '1');
INSERT INTO `t_sen_words` VALUES ('273', '维基百科', '1', '1');
INSERT INTO `t_sen_words` VALUES ('274', '纽约时报', '1', '1');
INSERT INTO `t_sen_words` VALUES ('275', 'bbc中文网', '1', '1');
INSERT INTO `t_sen_words` VALUES ('276', '华盛顿邮报', '1', '1');
INSERT INTO `t_sen_words` VALUES ('277', '世界日报', '1', '1');
INSERT INTO `t_sen_words` VALUES ('278', '东森新闻网', '1', '1');
INSERT INTO `t_sen_words` VALUES ('279', '东森电视', '1', '1');
INSERT INTO `t_sen_words` VALUES ('280', '基督教科学箴言报', '1', '1');
INSERT INTO `t_sen_words` VALUES ('281', '星岛日报', '1', '1');
INSERT INTO `t_sen_words` VALUES ('282', '亚洲周刊', '1', '1');
INSERT INTO `t_sen_words` VALUES ('283', '泰晤士报', '1', '1');
INSERT INTO `t_sen_words` VALUES ('284', '美联社', '1', '1');
INSERT INTO `t_sen_words` VALUES ('285', '中央社', '1', '1');
INSERT INTO `t_sen_words` VALUES ('286', '雅虎香港', '1', '1');
INSERT INTO `t_sen_words` VALUES ('287', 'wikipedia', '1', '1');
INSERT INTO `t_sen_words` VALUES ('288', 'youtube', '1', '1');
INSERT INTO `t_sen_words` VALUES ('289', 'googleblogger', '1', '1');
INSERT INTO `t_sen_words` VALUES ('290', '美国之音', '1', '1');
INSERT INTO `t_sen_words` VALUES ('291', '美国广播公司', '1', '1');
INSERT INTO `t_sen_words` VALUES ('292', '英国金融时报', '1', '1');
INSERT INTO `t_sen_words` VALUES ('293', '自由亚洲', '1', '1');
INSERT INTO `t_sen_words` VALUES ('294', '中央日报', '1', '1');
INSERT INTO `t_sen_words` VALUES ('295', '自由时报', '1', '1');
INSERT INTO `t_sen_words` VALUES ('296', '中国时报', '1', '1');
INSERT INTO `t_sen_words` VALUES ('297', '反分裂', '1', '1');
INSERT INTO `t_sen_words` VALUES ('298', '威胁论', '1', '1');
INSERT INTO `t_sen_words` VALUES ('299', '左翼联盟', '1', '1');
INSERT INTO `t_sen_words` VALUES ('300', '钓鱼岛', '1', '1');
INSERT INTO `t_sen_words` VALUES ('301', '保钓组织', '1', '1');
INSERT INTO `t_sen_words` VALUES ('302', '主权', '1', '1');
INSERT INTO `t_sen_words` VALUES ('303', '弓单', '1', '1');
INSERT INTO `t_sen_words` VALUES ('304', '火乍', '1', '1');
INSERT INTO `t_sen_words` VALUES ('305', '木仓', '1', '1');
INSERT INTO `t_sen_words` VALUES ('306', '石肖', '1', '1');
INSERT INTO `t_sen_words` VALUES ('307', '核蛋', '1', '1');
INSERT INTO `t_sen_words` VALUES ('308', '步qiang', '1', '1');
INSERT INTO `t_sen_words` VALUES ('309', 'bao炸', '1', '1');
INSERT INTO `t_sen_words` VALUES ('310', '爆zha', '1', '1');
INSERT INTO `t_sen_words` VALUES ('311', 'baozha', '1', '1');
INSERT INTO `t_sen_words` VALUES ('312', 'zha药', '1', '1');
INSERT INTO `t_sen_words` VALUES ('313', 'zha弹', '1', '1');
INSERT INTO `t_sen_words` VALUES ('314', '炸dan', '1', '1');
INSERT INTO `t_sen_words` VALUES ('315', '炸yao', '1', '1');
INSERT INTO `t_sen_words` VALUES ('316', 'zhadan', '1', '1');
INSERT INTO `t_sen_words` VALUES ('317', 'zhayao', '1', '1');
INSERT INTO `t_sen_words` VALUES ('318', 'hmtd', '1', '1');
INSERT INTO `t_sen_words` VALUES ('319', '三硝基甲苯', '1', '1');
INSERT INTO `t_sen_words` VALUES ('320', '六氟化铀', '1', '1');
INSERT INTO `t_sen_words` VALUES ('321', '炸药配方', '1', '1');
INSERT INTO `t_sen_words` VALUES ('322', '弹药配方', '1', '1');
INSERT INTO `t_sen_words` VALUES ('323', '炸弹配方', '1', '1');
INSERT INTO `t_sen_words` VALUES ('324', '皮箱炸弹', '1', '1');
INSERT INTO `t_sen_words` VALUES ('325', '火药配方', '1', '1');
INSERT INTO `t_sen_words` VALUES ('326', '人体炸弹', '1', '1');
INSERT INTO `t_sen_words` VALUES ('327', '人肉炸弹', '1', '1');
INSERT INTO `t_sen_words` VALUES ('328', '解放军', '1', '1');
INSERT INTO `t_sen_words` VALUES ('329', '兵力部署', '1', '1');
INSERT INTO `t_sen_words` VALUES ('330', '军转', '1', '1');
INSERT INTO `t_sen_words` VALUES ('331', '军事社', '1', '1');
INSERT INTO `t_sen_words` VALUES ('332', '8341部队', '1', '1');
INSERT INTO `t_sen_words` VALUES ('333', '第21集团军', '1', '1');
INSERT INTO `t_sen_words` VALUES ('334', '七大军区', '1', '1');
INSERT INTO `t_sen_words` VALUES ('335', '7大军区', '1', '1');
INSERT INTO `t_sen_words` VALUES ('336', '北京军区', '1', '1');
INSERT INTO `t_sen_words` VALUES ('337', '沈阳军区', '1', '1');
INSERT INTO `t_sen_words` VALUES ('338', '济南军区', '1', '1');
INSERT INTO `t_sen_words` VALUES ('339', '成都军区', '1', '1');
INSERT INTO `t_sen_words` VALUES ('340', '广州军区', '1', '1');
INSERT INTO `t_sen_words` VALUES ('341', '南京军区', '1', '1');
INSERT INTO `t_sen_words` VALUES ('342', '兰州军区', '1', '1');
INSERT INTO `t_sen_words` VALUES ('343', '颜色革命', '1', '1');
INSERT INTO `t_sen_words` VALUES ('344', '规模冲突', '1', '1');
INSERT INTO `t_sen_words` VALUES ('345', '塔利班', '1', '1');
INSERT INTO `t_sen_words` VALUES ('346', '基地组织', '1', '1');
INSERT INTO `t_sen_words` VALUES ('347', '恐怖分子', '1', '1');
INSERT INTO `t_sen_words` VALUES ('348', '恐怖份子', '1', '1');
INSERT INTO `t_sen_words` VALUES ('349', '三股势力', '1', '1');
INSERT INTO `t_sen_words` VALUES ('350', '印尼屠华', '1', '1');
INSERT INTO `t_sen_words` VALUES ('351', '印尼事件', '1', '1');
INSERT INTO `t_sen_words` VALUES ('352', '蒋公纪念歌', '1', '1');
INSERT INTO `t_sen_words` VALUES ('353', '马英九', '1', '1');
INSERT INTO `t_sen_words` VALUES ('354', 'mayingjiu', '1', '1');
INSERT INTO `t_sen_words` VALUES ('355', '李天羽', '1', '1');
INSERT INTO `t_sen_words` VALUES ('356', '苏贞昌', '1', '1');
INSERT INTO `t_sen_words` VALUES ('357', '林文漪', '1', '1');
INSERT INTO `t_sen_words` VALUES ('358', '陈水扁', '1', '1');
INSERT INTO `t_sen_words` VALUES ('359', '陈s扁', '1', '1');
INSERT INTO `t_sen_words` VALUES ('360', '陈随便', '1', '1');
INSERT INTO `t_sen_words` VALUES ('361', '阿扁', '1', '1');
INSERT INTO `t_sen_words` VALUES ('362', 'a扁', '1', '1');
INSERT INTO `t_sen_words` VALUES ('363', '告全国同胞书', '1', '1');
INSERT INTO `t_sen_words` VALUES ('364', '台百度湾', '1', '1');
INSERT INTO `t_sen_words` VALUES ('365', '台完', '1', '1');
INSERT INTO `t_sen_words` VALUES ('366', '台wan', '1', '1');
INSERT INTO `t_sen_words` VALUES ('367', 'taiwan', '1', '1');
INSERT INTO `t_sen_words` VALUES ('368', '台弯', '1', '1');
INSERT INTO `t_sen_words` VALUES ('369', '湾台', '1', '1');
INSERT INTO `t_sen_words` VALUES ('370', '台湾国', '1', '1');
INSERT INTO `t_sen_words` VALUES ('371', '台湾共和国', '1', '1');
INSERT INTO `t_sen_words` VALUES ('372', '台军', '1', '1');
INSERT INTO `t_sen_words` VALUES ('373', '台独', '1', '1');
INSERT INTO `t_sen_words` VALUES ('374', '台毒', '1', '1');
INSERT INTO `t_sen_words` VALUES ('375', '台du', '1', '1');
INSERT INTO `t_sen_words` VALUES ('376', 'taidu', '1', '1');
INSERT INTO `t_sen_words` VALUES ('377', 'twdl', '1', '1');
INSERT INTO `t_sen_words` VALUES ('378', '一中一台', '1', '1');
INSERT INTO `t_sen_words` VALUES ('379', '打台湾', '1', '1');
INSERT INTO `t_sen_words` VALUES ('380', '两岸关系', '1', '1');
INSERT INTO `t_sen_words` VALUES ('381', '两岸战争', '1', '1');
INSERT INTO `t_sen_words` VALUES ('382', '攻占台湾', '1', '1');
INSERT INTO `t_sen_words` VALUES ('383', '支持台湾', '1', '1');
INSERT INTO `t_sen_words` VALUES ('384', '进攻台湾', '1', '1');
INSERT INTO `t_sen_words` VALUES ('385', '占领台湾', '1', '1');
INSERT INTO `t_sen_words` VALUES ('386', '统一台湾', '1', '1');
INSERT INTO `t_sen_words` VALUES ('387', '收复台湾', '1', '1');
INSERT INTO `t_sen_words` VALUES ('388', '登陆台湾', '1', '1');
INSERT INTO `t_sen_words` VALUES ('389', '解放台湾', '1', '1');
INSERT INTO `t_sen_words` VALUES ('390', '解放tw', '1', '1');
INSERT INTO `t_sen_words` VALUES ('391', '解决台湾', '1', '1');
INSERT INTO `t_sen_words` VALUES ('392', '光复民国', '1', '1');
INSERT INTO `t_sen_words` VALUES ('393', '台湾独立', '1', '1');
INSERT INTO `t_sen_words` VALUES ('394', '台湾问题', '1', '1');
INSERT INTO `t_sen_words` VALUES ('395', '台海问题', '1', '1');
INSERT INTO `t_sen_words` VALUES ('396', '台海危机', '1', '1');
INSERT INTO `t_sen_words` VALUES ('397', '台海统一', '1', '1');
INSERT INTO `t_sen_words` VALUES ('398', '台海大战', '1', '1');
INSERT INTO `t_sen_words` VALUES ('399', '台海战争', '1', '1');
INSERT INTO `t_sen_words` VALUES ('400', '台海局势', '1', '1');
INSERT INTO `t_sen_words` VALUES ('401', '入联', '1', '1');
INSERT INTO `t_sen_words` VALUES ('402', '入耳关', '1', '1');
INSERT INTO `t_sen_words` VALUES ('403', '中华联邦', '1', '1');
INSERT INTO `t_sen_words` VALUES ('404', '国民党', '1', '1');
INSERT INTO `t_sen_words` VALUES ('405', 'x民党', '1', '1');
INSERT INTO `t_sen_words` VALUES ('406', '民进党', '1', '1');
INSERT INTO `t_sen_words` VALUES ('407', '青天白日', '1', '1');
INSERT INTO `t_sen_words` VALUES ('408', '闹独立', '1', '1');
INSERT INTO `t_sen_words` VALUES ('409', 'duli', '1', '1');
INSERT INTO `t_sen_words` VALUES ('410', 'fenlie', '1', '1');
INSERT INTO `t_sen_words` VALUES ('411', '日本万岁', '1', '1');
INSERT INTO `t_sen_words` VALUES ('412', '小泽一郎', '1', '1');
INSERT INTO `t_sen_words` VALUES ('413', '劣等民族', '1', '1');
INSERT INTO `t_sen_words` VALUES ('414', '汉人', '1', '1');
INSERT INTO `t_sen_words` VALUES ('415', '汉维', '1', '1');
INSERT INTO `t_sen_words` VALUES ('416', '维汉', '1', '1');
INSERT INTO `t_sen_words` VALUES ('417', '维吾', '1', '1');
INSERT INTO `t_sen_words` VALUES ('418', '吾尔', '1', '1');
INSERT INTO `t_sen_words` VALUES ('419', '热比娅', '1', '1');
INSERT INTO `t_sen_words` VALUES ('420', '伊力哈木', '1', '1');
INSERT INTO `t_sen_words` VALUES ('421', '疆独', '1', '1');
INSERT INTO `t_sen_words` VALUES ('422', '东突厥斯坦解放组织', '1', '1');
INSERT INTO `t_sen_words` VALUES ('423', '东突解放组织', '1', '1');
INSERT INTO `t_sen_words` VALUES ('424', '蒙古分裂分子', '1', '1');
INSERT INTO `t_sen_words` VALUES ('425', '列确', '1', '1');
INSERT INTO `t_sen_words` VALUES ('426', '阿旺晋美', '1', '1');
INSERT INTO `t_sen_words` VALUES ('427', '藏人', '1', '1');
INSERT INTO `t_sen_words` VALUES ('428', '臧人', '1', '1');
INSERT INTO `t_sen_words` VALUES ('429', 'zang人', '1', '1');
INSERT INTO `t_sen_words` VALUES ('430', '藏民', '1', '1');
INSERT INTO `t_sen_words` VALUES ('431', '藏m', '1', '1');
INSERT INTO `t_sen_words` VALUES ('432', '达赖', '1', '1');
INSERT INTO `t_sen_words` VALUES ('433', '赖达', '1', '1');
INSERT INTO `t_sen_words` VALUES ('434', 'dalai', '1', '1');
INSERT INTO `t_sen_words` VALUES ('435', '哒赖', '1', '1');
INSERT INTO `t_sen_words` VALUES ('436', 'dl喇嘛', '1', '1');
INSERT INTO `t_sen_words` VALUES ('437', '丹增嘉措', '1', '1');
INSERT INTO `t_sen_words` VALUES ('438', '打砸抢', '1', '1');
INSERT INTO `t_sen_words` VALUES ('439', '西独', '1', '1');
INSERT INTO `t_sen_words` VALUES ('440', '藏独', '1', '1');
INSERT INTO `t_sen_words` VALUES ('441', '葬独', '1', '1');
INSERT INTO `t_sen_words` VALUES ('442', '臧独', '1', '1');
INSERT INTO `t_sen_words` VALUES ('443', '藏毒', '1', '1');
INSERT INTO `t_sen_words` VALUES ('444', '藏du', '1', '1');
INSERT INTO `t_sen_words` VALUES ('445', 'zangdu', '1', '1');
INSERT INTO `t_sen_words` VALUES ('446', '支持zd', '1', '1');
INSERT INTO `t_sen_words` VALUES ('447', '藏暴乱', '1', '1');
INSERT INTO `t_sen_words` VALUES ('448', '藏青会', '1', '1');
INSERT INTO `t_sen_words` VALUES ('449', '雪山狮子旗', '1', '1');
INSERT INTO `t_sen_words` VALUES ('450', '拉萨', '1', '1');
INSERT INTO `t_sen_words` VALUES ('451', '啦萨', '1', '1');
INSERT INTO `t_sen_words` VALUES ('452', '啦沙', '1', '1');
INSERT INTO `t_sen_words` VALUES ('453', '啦撒', '1', '1');
INSERT INTO `t_sen_words` VALUES ('454', '拉sa', '1', '1');
INSERT INTO `t_sen_words` VALUES ('455', 'lasa', '1', '1');
INSERT INTO `t_sen_words` VALUES ('456', 'la萨', '1', '1');
INSERT INTO `t_sen_words` VALUES ('457', '西藏', '1', '1');
INSERT INTO `t_sen_words` VALUES ('458', '藏西', '1', '1');
INSERT INTO `t_sen_words` VALUES ('459', 'xizang', '1', '1');
INSERT INTO `t_sen_words` VALUES ('460', 'xi藏', '1', '1');
INSERT INTO `t_sen_words` VALUES ('461', 'x藏', '1', '1');
INSERT INTO `t_sen_words` VALUES ('462', '西z', '1', '1');
INSERT INTO `t_sen_words` VALUES ('463', 'tibet', '1', '1');
INSERT INTO `t_sen_words` VALUES ('464', '希葬', '1', '1');
INSERT INTO `t_sen_words` VALUES ('465', '希藏', '1', '1');
INSERT INTO `t_sen_words` VALUES ('466', '硒藏', '1', '1');
INSERT INTO `t_sen_words` VALUES ('467', '稀藏', '1', '1');
INSERT INTO `t_sen_words` VALUES ('468', '西脏', '1', '1');
INSERT INTO `t_sen_words` VALUES ('469', '西奘', '1', '1');
INSERT INTO `t_sen_words` VALUES ('470', '西葬', '1', '1');
INSERT INTO `t_sen_words` VALUES ('471', '西臧', '1', '1');
INSERT INTO `t_sen_words` VALUES ('472', '援藏', '1', '1');
INSERT INTO `t_sen_words` VALUES ('473', 'bjork', '1', '1');
INSERT INTO `t_sen_words` VALUES ('474', '王千源', '1', '1');
INSERT INTO `t_sen_words` VALUES ('475', '安拉', '1', '1');
INSERT INTO `t_sen_words` VALUES ('476', '回教', '1', '1');
INSERT INTO `t_sen_words` VALUES ('477', '回族', '1', '1');
INSERT INTO `t_sen_words` VALUES ('478', '回回', '1', '1');
INSERT INTO `t_sen_words` VALUES ('479', '回民', '1', '1');
INSERT INTO `t_sen_words` VALUES ('480', '穆斯林', '1', '1');
INSERT INTO `t_sen_words` VALUES ('481', '穆罕穆德', '1', '1');
INSERT INTO `t_sen_words` VALUES ('482', '穆罕默德', '1', '1');
INSERT INTO `t_sen_words` VALUES ('483', '默罕默德', '1', '1');
INSERT INTO `t_sen_words` VALUES ('484', '伊斯兰', '1', '1');
INSERT INTO `t_sen_words` VALUES ('485', '圣战组织', '1', '1');
INSERT INTO `t_sen_words` VALUES ('486', '清真', '1', '1');
INSERT INTO `t_sen_words` VALUES ('487', '清zhen', '1', '1');
INSERT INTO `t_sen_words` VALUES ('488', 'qingzhen', '1', '1');
INSERT INTO `t_sen_words` VALUES ('489', '真主', '1', '1');
INSERT INTO `t_sen_words` VALUES ('490', '阿拉伯', '1', '1');
INSERT INTO `t_sen_words` VALUES ('491', '高丽棒子', '1', '1');
INSERT INTO `t_sen_words` VALUES ('492', '韩国狗', '1', '1');
INSERT INTO `t_sen_words` VALUES ('493', '满洲第三帝国', '1', '1');
INSERT INTO `t_sen_words` VALUES ('494', '满狗', '1', '1');
INSERT INTO `t_sen_words` VALUES ('495', '鞑子', '1', '1');
INSERT INTO `t_sen_words` VALUES ('496', '胡的接班人', '2', '1');
INSERT INTO `t_sen_words` VALUES ('497', '钦定接班人', '2', '1');
INSERT INTO `t_sen_words` VALUES ('498', '习近平', '2', '1');
INSERT INTO `t_sen_words` VALUES ('499', '平近习', '2', '1');
INSERT INTO `t_sen_words` VALUES ('500', 'xjp', '2', '1');
INSERT INTO `t_sen_words` VALUES ('501', '习太子', '2', '1');
INSERT INTO `t_sen_words` VALUES ('502', '习明泽', '2', '1');
INSERT INTO `t_sen_words` VALUES ('503', '老习', '2', '1');
INSERT INTO `t_sen_words` VALUES ('504', '温家宝', '2', '1');
INSERT INTO `t_sen_words` VALUES ('505', '温加宝', '2', '1');
INSERT INTO `t_sen_words` VALUES ('506', '温x', '2', '1');
INSERT INTO `t_sen_words` VALUES ('507', '温jia宝', '2', '1');
INSERT INTO `t_sen_words` VALUES ('508', '温宝宝', '2', '1');
INSERT INTO `t_sen_words` VALUES ('509', '温加饱', '2', '1');
INSERT INTO `t_sen_words` VALUES ('510', '温加保', '2', '1');
INSERT INTO `t_sen_words` VALUES ('511', '张培莉', '2', '1');
INSERT INTO `t_sen_words` VALUES ('512', '温云松', '2', '1');
INSERT INTO `t_sen_words` VALUES ('513', '温如春', '2', '1');
INSERT INTO `t_sen_words` VALUES ('514', '温jb', '2', '1');
INSERT INTO `t_sen_words` VALUES ('515', '胡温', '2', '1');
INSERT INTO `t_sen_words` VALUES ('516', '胡x', '2', '1');
INSERT INTO `t_sen_words` VALUES ('517', '胡jt', '2', '1');
INSERT INTO `t_sen_words` VALUES ('518', '胡boss', '2', '1');
INSERT INTO `t_sen_words` VALUES ('519', '胡总', '2', '1');
INSERT INTO `t_sen_words` VALUES ('520', '胡王八', '2', '1');
INSERT INTO `t_sen_words` VALUES ('521', 'hujintao', '2', '1');
INSERT INTO `t_sen_words` VALUES ('522', '胡jintao', '2', '1');
INSERT INTO `t_sen_words` VALUES ('523', '胡j涛', '2', '1');
INSERT INTO `t_sen_words` VALUES ('524', '胡惊涛', '2', '1');
INSERT INTO `t_sen_words` VALUES ('525', '胡景涛', '2', '1');
INSERT INTO `t_sen_words` VALUES ('526', '胡紧掏', '2', '1');
INSERT INTO `t_sen_words` VALUES ('527', '湖紧掏', '2', '1');
INSERT INTO `t_sen_words` VALUES ('528', '胡紧套', '2', '1');
INSERT INTO `t_sen_words` VALUES ('529', '锦涛', '2', '1');
INSERT INTO `t_sen_words` VALUES ('530', 'hjt', '2', '1');
INSERT INTO `t_sen_words` VALUES ('531', '胡派', '2', '1');
INSERT INTO `t_sen_words` VALUES ('532', '胡主席', '2', '1');
INSERT INTO `t_sen_words` VALUES ('533', '刘永清', '2', '1');
INSERT INTO `t_sen_words` VALUES ('534', '胡海峰', '2', '1');
INSERT INTO `t_sen_words` VALUES ('535', '胡海清', '2', '1');
INSERT INTO `t_sen_words` VALUES ('536', '江泽民', '2', '1');
INSERT INTO `t_sen_words` VALUES ('537', '民泽江', '2', '1');
INSERT INTO `t_sen_words` VALUES ('538', '江胡', '2', '1');
INSERT INTO `t_sen_words` VALUES ('539', '江哥', '2', '1');
INSERT INTO `t_sen_words` VALUES ('540', '江主席', '2', '1');
INSERT INTO `t_sen_words` VALUES ('541', '江书记', '2', '1');
INSERT INTO `t_sen_words` VALUES ('542', '江浙闽', '2', '1');
INSERT INTO `t_sen_words` VALUES ('543', '江沢民', '2', '1');
INSERT INTO `t_sen_words` VALUES ('544', '江浙民', '2', '1');
INSERT INTO `t_sen_words` VALUES ('545', '择民', '2', '1');
INSERT INTO `t_sen_words` VALUES ('546', '则民', '2', '1');
INSERT INTO `t_sen_words` VALUES ('547', '茳泽民', '2', '1');
INSERT INTO `t_sen_words` VALUES ('548', 'zemin', '2', '1');
INSERT INTO `t_sen_words` VALUES ('549', 'ze民', '2', '1');
INSERT INTO `t_sen_words` VALUES ('550', '老江', '2', '1');
INSERT INTO `t_sen_words` VALUES ('551', '老j', '2', '1');
INSERT INTO `t_sen_words` VALUES ('552', '江core', '2', '1');
INSERT INTO `t_sen_words` VALUES ('553', '江x', '2', '1');
INSERT INTO `t_sen_words` VALUES ('554', '江派', '2', '1');
INSERT INTO `t_sen_words` VALUES ('555', '江zm', '2', '1');
INSERT INTO `t_sen_words` VALUES ('556', 'jzm', '2', '1');
INSERT INTO `t_sen_words` VALUES ('557', '江戏子', '2', '1');
INSERT INTO `t_sen_words` VALUES ('558', '江蛤蟆', '2', '1');
INSERT INTO `t_sen_words` VALUES ('559', '江某某', '2', '1');
INSERT INTO `t_sen_words` VALUES ('560', '江贼', '2', '1');
INSERT INTO `t_sen_words` VALUES ('561', '江猪', '2', '1');
INSERT INTO `t_sen_words` VALUES ('562', '江氏集团', '2', '1');
INSERT INTO `t_sen_words` VALUES ('563', '江绵恒', '2', '1');
INSERT INTO `t_sen_words` VALUES ('564', '江绵康', '2', '1');
INSERT INTO `t_sen_words` VALUES ('565', '王冶坪', '2', '1');
INSERT INTO `t_sen_words` VALUES ('566', '江泽慧', '2', '1');
INSERT INTO `t_sen_words` VALUES ('567', '邓小平', '2', '1');
INSERT INTO `t_sen_words` VALUES ('568', '平小邓', '2', '1');
INSERT INTO `t_sen_words` VALUES ('569', 'xiao平', '2', '1');
INSERT INTO `t_sen_words` VALUES ('570', '邓xp', '2', '1');
INSERT INTO `t_sen_words` VALUES ('571', '邓晓平', '2', '1');
INSERT INTO `t_sen_words` VALUES ('572', '邓朴方', '2', '1');
INSERT INTO `t_sen_words` VALUES ('573', '邓榕', '2', '1');
INSERT INTO `t_sen_words` VALUES ('574', '邓质方', '2', '1');
INSERT INTO `t_sen_words` VALUES ('575', '毛泽东', '2', '1');
INSERT INTO `t_sen_words` VALUES ('576', '猫泽东', '2', '1');
INSERT INTO `t_sen_words` VALUES ('577', '猫则东', '2', '1');
INSERT INTO `t_sen_words` VALUES ('578', 'chairmanmao', '2', '1');
INSERT INTO `t_sen_words` VALUES ('579', '猫贼洞', '2', '1');
INSERT INTO `t_sen_words` VALUES ('580', '毛zd', '2', '1');
INSERT INTO `t_sen_words` VALUES ('581', '毛zx', '2', '1');
INSERT INTO `t_sen_words` VALUES ('582', 'z东', '2', '1');
INSERT INTO `t_sen_words` VALUES ('583', 'ze东', '2', '1');
INSERT INTO `t_sen_words` VALUES ('584', '泽d', '2', '1');
INSERT INTO `t_sen_words` VALUES ('585', 'zedong', '2', '1');
INSERT INTO `t_sen_words` VALUES ('586', '毛太祖', '2', '1');
INSERT INTO `t_sen_words` VALUES ('587', '毛相', '2', '1');
INSERT INTO `t_sen_words` VALUES ('588', '主席画像', '2', '1');
INSERT INTO `t_sen_words` VALUES ('589', '改革历程', '2', '1');
INSERT INTO `t_sen_words` VALUES ('590', '朱镕基', '2', '1');
INSERT INTO `t_sen_words` VALUES ('591', '朱容基', '2', '1');
INSERT INTO `t_sen_words` VALUES ('592', '朱镕鸡', '2', '1');
INSERT INTO `t_sen_words` VALUES ('593', '朱容鸡', '2', '1');
INSERT INTO `t_sen_words` VALUES ('594', '朱云来', '2', '1');
INSERT INTO `t_sen_words` VALUES ('595', '李鹏', '2', '1');
INSERT INTO `t_sen_words` VALUES ('596', '李peng', '2', '1');
INSERT INTO `t_sen_words` VALUES ('597', '里鹏', '2', '1');
INSERT INTO `t_sen_words` VALUES ('598', '李月月鸟', '2', '1');
INSERT INTO `t_sen_words` VALUES ('599', '李小鹏', '2', '1');
INSERT INTO `t_sen_words` VALUES ('600', '李小琳', '2', '1');
INSERT INTO `t_sen_words` VALUES ('601', '华主席', '2', '1');
INSERT INTO `t_sen_words` VALUES ('602', '华国', '2', '1');
INSERT INTO `t_sen_words` VALUES ('603', '国锋', '2', '1');
INSERT INTO `t_sen_words` VALUES ('604', '国峰', '2', '1');
INSERT INTO `t_sen_words` VALUES ('605', '锋同志', '2', '1');
INSERT INTO `t_sen_words` VALUES ('606', '白春礼', '2', '1');
INSERT INTO `t_sen_words` VALUES ('607', '薄熙来', '2', '1');
INSERT INTO `t_sen_words` VALUES ('608', '薄一波', '2', '1');
INSERT INTO `t_sen_words` VALUES ('609', '蔡赴朝', '2', '1');
INSERT INTO `t_sen_words` VALUES ('610', '蔡武', '2', '1');
INSERT INTO `t_sen_words` VALUES ('611', '曹刚川', '2', '1');
INSERT INTO `t_sen_words` VALUES ('612', '常万全', '2', '1');
INSERT INTO `t_sen_words` VALUES ('613', '陈炳德', '2', '1');
INSERT INTO `t_sen_words` VALUES ('614', '陈德铭', '2', '1');
INSERT INTO `t_sen_words` VALUES ('615', '陈建国', '2', '1');
INSERT INTO `t_sen_words` VALUES ('616', '陈良宇', '2', '1');
INSERT INTO `t_sen_words` VALUES ('617', '陈绍基', '2', '1');
INSERT INTO `t_sen_words` VALUES ('618', '陈同海', '2', '1');
INSERT INTO `t_sen_words` VALUES ('619', '陈至立', '2', '1');
INSERT INTO `t_sen_words` VALUES ('620', '戴秉国', '2', '1');
INSERT INTO `t_sen_words` VALUES ('621', '丁一平', '2', '1');
INSERT INTO `t_sen_words` VALUES ('622', '董建华', '2', '1');
INSERT INTO `t_sen_words` VALUES ('623', '杜德印', '2', '1');
INSERT INTO `t_sen_words` VALUES ('624', '杜世成', '2', '1');
INSERT INTO `t_sen_words` VALUES ('625', '傅锐', '2', '1');
INSERT INTO `t_sen_words` VALUES ('626', '郭伯雄', '2', '1');
INSERT INTO `t_sen_words` VALUES ('627', '郭金龙', '2', '1');
INSERT INTO `t_sen_words` VALUES ('628', '贺国强', '2', '1');
INSERT INTO `t_sen_words` VALUES ('629', '胡春华', '2', '1');
INSERT INTO `t_sen_words` VALUES ('630', '耀邦', '2', '1');
INSERT INTO `t_sen_words` VALUES ('631', '华建敏', '2', '1');
INSERT INTO `t_sen_words` VALUES ('632', '黄华华', '2', '1');
INSERT INTO `t_sen_words` VALUES ('633', '黄丽满', '2', '1');
INSERT INTO `t_sen_words` VALUES ('634', '黄兴国', '2', '1');
INSERT INTO `t_sen_words` VALUES ('635', '回良玉', '2', '1');
INSERT INTO `t_sen_words` VALUES ('636', '贾庆林', '2', '1');
INSERT INTO `t_sen_words` VALUES ('637', '贾廷安', '2', '1');
INSERT INTO `t_sen_words` VALUES ('638', '靖志远', '2', '1');
INSERT INTO `t_sen_words` VALUES ('639', '李长春', '2', '1');
INSERT INTO `t_sen_words` VALUES ('640', '李春城', '2', '1');
INSERT INTO `t_sen_words` VALUES ('641', '李建国', '2', '1');
INSERT INTO `t_sen_words` VALUES ('642', '李克强', '2', '1');
INSERT INTO `t_sen_words` VALUES ('643', '李岚清', '2', '1');
INSERT INTO `t_sen_words` VALUES ('644', '李沛瑶', '2', '1');
INSERT INTO `t_sen_words` VALUES ('645', '李荣融', '2', '1');
INSERT INTO `t_sen_words` VALUES ('646', '李瑞环', '2', '1');
INSERT INTO `t_sen_words` VALUES ('647', '李铁映', '2', '1');
INSERT INTO `t_sen_words` VALUES ('648', '李先念', '2', '1');
INSERT INTO `t_sen_words` VALUES ('649', '李学举', '2', '1');
INSERT INTO `t_sen_words` VALUES ('650', '李源潮', '2', '1');
INSERT INTO `t_sen_words` VALUES ('651', '栗智', '2', '1');
INSERT INTO `t_sen_words` VALUES ('652', '梁光烈', '2', '1');
INSERT INTO `t_sen_words` VALUES ('653', '廖锡龙', '2', '1');
INSERT INTO `t_sen_words` VALUES ('654', '林树森', '2', '1');
INSERT INTO `t_sen_words` VALUES ('655', '林炎志', '2', '1');
INSERT INTO `t_sen_words` VALUES ('656', '林左鸣', '2', '1');
INSERT INTO `t_sen_words` VALUES ('657', '令计划', '2', '1');
INSERT INTO `t_sen_words` VALUES ('658', '柳斌杰', '2', '1');
INSERT INTO `t_sen_words` VALUES ('659', '刘奇葆', '2', '1');
INSERT INTO `t_sen_words` VALUES ('660', '刘少奇', '2', '1');
INSERT INTO `t_sen_words` VALUES ('661', '刘延东', '2', '1');
INSERT INTO `t_sen_words` VALUES ('662', '刘云山', '2', '1');
INSERT INTO `t_sen_words` VALUES ('663', '刘志军', '2', '1');
INSERT INTO `t_sen_words` VALUES ('664', '龙新民', '2', '1');
INSERT INTO `t_sen_words` VALUES ('665', '路甬祥', '2', '1');
INSERT INTO `t_sen_words` VALUES ('666', '罗箭', '2', '1');
INSERT INTO `t_sen_words` VALUES ('667', '吕祖善', '2', '1');
INSERT INTO `t_sen_words` VALUES ('668', '马飚', '2', '1');
INSERT INTO `t_sen_words` VALUES ('669', '马恺', '2', '1');
INSERT INTO `t_sen_words` VALUES ('670', '孟建柱', '2', '1');
INSERT INTO `t_sen_words` VALUES ('671', '欧广源', '2', '1');
INSERT INTO `t_sen_words` VALUES ('672', '强卫', '2', '1');
INSERT INTO `t_sen_words` VALUES ('673', '沈跃跃', '2', '1');
INSERT INTO `t_sen_words` VALUES ('674', '宋平顺', '2', '1');
INSERT INTO `t_sen_words` VALUES ('675', '粟戎生', '2', '1');
INSERT INTO `t_sen_words` VALUES ('676', '苏树林', '2', '1');
INSERT INTO `t_sen_words` VALUES ('677', '孙家正', '2', '1');
INSERT INTO `t_sen_words` VALUES ('678', '铁凝', '2', '1');
INSERT INTO `t_sen_words` VALUES ('679', '屠光绍', '2', '1');
INSERT INTO `t_sen_words` VALUES ('680', '王东明', '2', '1');
INSERT INTO `t_sen_words` VALUES ('681', '汪东兴', '2', '1');
INSERT INTO `t_sen_words` VALUES ('682', '王鸿举', '2', '1');
INSERT INTO `t_sen_words` VALUES ('683', '王沪宁', '2', '1');
INSERT INTO `t_sen_words` VALUES ('684', '王乐泉', '2', '1');
INSERT INTO `t_sen_words` VALUES ('685', '王洛林', '2', '1');
INSERT INTO `t_sen_words` VALUES ('686', '王岐山', '2', '1');
INSERT INTO `t_sen_words` VALUES ('687', '王胜俊', '2', '1');
INSERT INTO `t_sen_words` VALUES ('688', '王太华', '2', '1');
INSERT INTO `t_sen_words` VALUES ('689', '王学军', '2', '1');
INSERT INTO `t_sen_words` VALUES ('690', '王兆国', '2', '1');
INSERT INTO `t_sen_words` VALUES ('691', '王振华', '2', '1');
INSERT INTO `t_sen_words` VALUES ('692', '吴邦国', '2', '1');
INSERT INTO `t_sen_words` VALUES ('693', '吴定富', '2', '1');
INSERT INTO `t_sen_words` VALUES ('694', '吴官正', '2', '1');
INSERT INTO `t_sen_words` VALUES ('695', '无官正', '2', '1');
INSERT INTO `t_sen_words` VALUES ('696', '吴胜利', '2', '1');
INSERT INTO `t_sen_words` VALUES ('697', '吴仪', '2', '1');
INSERT INTO `t_sen_words` VALUES ('698', '奚国华', '2', '1');
INSERT INTO `t_sen_words` VALUES ('699', '习仲勋', '2', '1');
INSERT INTO `t_sen_words` VALUES ('700', '徐才厚', '2', '1');
INSERT INTO `t_sen_words` VALUES ('701', '许其亮', '2', '1');
INSERT INTO `t_sen_words` VALUES ('702', '徐绍史', '2', '1');
INSERT INTO `t_sen_words` VALUES ('703', '杨洁篪', '2', '1');
INSERT INTO `t_sen_words` VALUES ('704', '叶剑英', '2', '1');
INSERT INTO `t_sen_words` VALUES ('705', '由喜贵', '2', '1');
INSERT INTO `t_sen_words` VALUES ('706', '于幼军', '2', '1');
INSERT INTO `t_sen_words` VALUES ('707', '俞正声', '2', '1');
INSERT INTO `t_sen_words` VALUES ('708', '袁纯清', '2', '1');
INSERT INTO `t_sen_words` VALUES ('709', '曾培炎', '2', '1');
INSERT INTO `t_sen_words` VALUES ('710', '曾庆红', '2', '1');
INSERT INTO `t_sen_words` VALUES ('711', '曾宪梓', '2', '1');
INSERT INTO `t_sen_words` VALUES ('712', '曾荫权', '2', '1');
INSERT INTO `t_sen_words` VALUES ('713', '张德江', '2', '1');
INSERT INTO `t_sen_words` VALUES ('714', '张定发', '2', '1');
INSERT INTO `t_sen_words` VALUES ('715', '张高丽', '2', '1');
INSERT INTO `t_sen_words` VALUES ('716', '张立昌', '2', '1');
INSERT INTO `t_sen_words` VALUES ('717', '张荣坤', '2', '1');
INSERT INTO `t_sen_words` VALUES ('718', '张志国', '2', '1');
INSERT INTO `t_sen_words` VALUES ('719', '赵洪祝', '2', '1');
INSERT INTO `t_sen_words` VALUES ('720', '紫阳', '2', '1');
INSERT INTO `t_sen_words` VALUES ('721', '周生贤', '2', '1');
INSERT INTO `t_sen_words` VALUES ('722', '周永康', '2', '1');
INSERT INTO `t_sen_words` VALUES ('723', '朱海仑', '2', '1');
INSERT INTO `t_sen_words` VALUES ('724', '政治局常委', '2', '1');
INSERT INTO `t_sen_words` VALUES ('725', '中纪委', '2', '1');
INSERT INTO `t_sen_words` VALUES ('726', '主席像', '2', '1');
INSERT INTO `t_sen_words` VALUES ('727', '总书记', '2', '1');
INSERT INTO `t_sen_words` VALUES ('728', '中南海', '2', '1');
INSERT INTO `t_sen_words` VALUES ('729', '大陆当局', '2', '1');
INSERT INTO `t_sen_words` VALUES ('730', '中国当局', '2', '1');
INSERT INTO `t_sen_words` VALUES ('731', '北京当局', '2', '1');
INSERT INTO `t_sen_words` VALUES ('732', '共产党', '2', '1');
INSERT INTO `t_sen_words` VALUES ('733', '党产共', '2', '1');
INSERT INTO `t_sen_words` VALUES ('734', 'gcd', '2', '1');
INSERT INTO `t_sen_words` VALUES ('735', '共贪党', '2', '1');
INSERT INTO `t_sen_words` VALUES ('736', 'gongchandang', '2', '1');
INSERT INTO `t_sen_words` VALUES ('737', '阿共', '2', '1');
INSERT INTO `t_sen_words` VALUES ('738', '共一产一党', '2', '1');
INSERT INTO `t_sen_words` VALUES ('739', '产党共', '2', '1');
INSERT INTO `t_sen_words` VALUES ('740', '公产党', '2', '1');
INSERT INTO `t_sen_words` VALUES ('741', '工产党', '2', '1');
INSERT INTO `t_sen_words` VALUES ('742', '共c党', '2', '1');
INSERT INTO `t_sen_words` VALUES ('743', '共x党', '2', '1');
INSERT INTO `t_sen_words` VALUES ('744', '共铲', '2', '1');
INSERT INTO `t_sen_words` VALUES ('745', '供产', '2', '1');
INSERT INTO `t_sen_words` VALUES ('746', '共惨', '2', '1');
INSERT INTO `t_sen_words` VALUES ('747', '供铲党', '2', '1');
INSERT INTO `t_sen_words` VALUES ('748', '供铲谠', '2', '1');
INSERT INTO `t_sen_words` VALUES ('749', '供铲裆', '2', '1');
INSERT INTO `t_sen_words` VALUES ('750', '共残党', '2', '1');
INSERT INTO `t_sen_words` VALUES ('751', '共残主义', '2', '1');
INSERT INTO `t_sen_words` VALUES ('752', '共产主义的幽灵', '2', '1');
INSERT INTO `t_sen_words` VALUES ('753', '拱铲', '2', '1');
INSERT INTO `t_sen_words` VALUES ('754', '老共', '2', '1');
INSERT INTO `t_sen_words` VALUES ('755', '中共', '2', '1');
INSERT INTO `t_sen_words` VALUES ('756', '中珙', '2', '1');
INSERT INTO `t_sen_words` VALUES ('757', '中gong', '2', '1');
INSERT INTO `t_sen_words` VALUES ('758', 'gc党', '2', '1');
INSERT INTO `t_sen_words` VALUES ('759', '贡挡', '2', '1');
INSERT INTO `t_sen_words` VALUES ('760', 'gong党', '2', '1');
INSERT INTO `t_sen_words` VALUES ('761', 'g产', '2', '1');
INSERT INTO `t_sen_words` VALUES ('762', '狗产蛋', '2', '1');
INSERT INTO `t_sen_words` VALUES ('763', '共残裆', '2', '1');
INSERT INTO `t_sen_words` VALUES ('764', '恶党', '2', '1');
INSERT INTO `t_sen_words` VALUES ('765', '邪党', '2', '1');
INSERT INTO `t_sen_words` VALUES ('766', '共产专制', '2', '1');
INSERT INTO `t_sen_words` VALUES ('767', '共产王朝', '2', '1');
INSERT INTO `t_sen_words` VALUES ('768', '裆中央', '2', '1');
INSERT INTO `t_sen_words` VALUES ('769', '土共', '2', '1');
INSERT INTO `t_sen_words` VALUES ('770', '土g', '2', '1');
INSERT INTO `t_sen_words` VALUES ('771', '共狗', '2', '1');
INSERT INTO `t_sen_words` VALUES ('772', 'g匪', '2', '1');
INSERT INTO `t_sen_words` VALUES ('773', '共匪', '2', '1');
INSERT INTO `t_sen_words` VALUES ('774', '仇共', '2', '1');
INSERT INTO `t_sen_words` VALUES ('775', 'communistparty', '2', '1');
INSERT INTO `t_sen_words` VALUES ('776', '政府', '2', '1');
INSERT INTO `t_sen_words` VALUES ('777', '症腐', '2', '1');
INSERT INTO `t_sen_words` VALUES ('778', '政腐', '2', '1');
INSERT INTO `t_sen_words` VALUES ('779', '政付', '2', '1');
INSERT INTO `t_sen_words` VALUES ('780', '正府', '2', '1');
INSERT INTO `t_sen_words` VALUES ('781', '政俯', '2', '1');
INSERT INTO `t_sen_words` VALUES ('782', '政一府', '2', '1');
INSERT INTO `t_sen_words` VALUES ('783', '政百度府', '2', '1');
INSERT INTO `t_sen_words` VALUES ('784', '政f', '2', '1');
INSERT INTO `t_sen_words` VALUES ('785', 'zhengfu', '2', '1');
INSERT INTO `t_sen_words` VALUES ('786', '政zhi', '2', '1');
INSERT INTO `t_sen_words` VALUES ('787', '挡中央', '2', '1');
INSERT INTO `t_sen_words` VALUES ('788', '档中央', '2', '1');
INSERT INTO `t_sen_words` VALUES ('789', '中央领导', '2', '1');
INSERT INTO `t_sen_words` VALUES ('790', '中国zf', '2', '1');
INSERT INTO `t_sen_words` VALUES ('791', '中央zf', '2', '1');
INSERT INTO `t_sen_words` VALUES ('792', '国wu院', '2', '1');
INSERT INTO `t_sen_words` VALUES ('793', '中华帝国', '2', '1');
INSERT INTO `t_sen_words` VALUES ('794', 'gong和', '2', '1');
INSERT INTO `t_sen_words` VALUES ('795', '大陆官方', '2', '1');
INSERT INTO `t_sen_words` VALUES ('796', '北京政权 ', '2', '1');
INSERT INTO `t_sen_words` VALUES ('797', '福音会', '3', '1');
INSERT INTO `t_sen_words` VALUES ('798', '中国教徒', '3', '1');
INSERT INTO `t_sen_words` VALUES ('799', '统一教', '3', '1');
INSERT INTO `t_sen_words` VALUES ('800', '观音法门', '3', '1');
INSERT INTO `t_sen_words` VALUES ('801', '清海无上师', '3', '1');
INSERT INTO `t_sen_words` VALUES ('802', '盘古', '3', '1');
INSERT INTO `t_sen_words` VALUES ('803', '李洪志', '3', '1');
INSERT INTO `t_sen_words` VALUES ('804', '志洪李', '3', '1');
INSERT INTO `t_sen_words` VALUES ('805', '李宏志', '3', '1');
INSERT INTO `t_sen_words` VALUES ('806', '轮功', '3', '1');
INSERT INTO `t_sen_words` VALUES ('807', '法轮', '3', '1');
INSERT INTO `t_sen_words` VALUES ('808', '轮法功', '3', '1');
INSERT INTO `t_sen_words` VALUES ('809', '三去车仑', '3', '1');
INSERT INTO `t_sen_words` VALUES ('810', '氵去车仑', '3', '1');
INSERT INTO `t_sen_words` VALUES ('811', '发论工', '3', '1');
INSERT INTO `t_sen_words` VALUES ('812', '法x功', '3', '1');
INSERT INTO `t_sen_words` VALUES ('813', '法o功', '3', '1');
INSERT INTO `t_sen_words` VALUES ('814', '法0功', '3', '1');
INSERT INTO `t_sen_words` VALUES ('815', '法一轮一功', '3', '1');
INSERT INTO `t_sen_words` VALUES ('816', '轮子功', '3', '1');
INSERT INTO `t_sen_words` VALUES ('817', '车仑工力', '3', '1');
INSERT INTO `t_sen_words` VALUES ('818', '法lun', '3', '1');
INSERT INTO `t_sen_words` VALUES ('819', 'fa轮', '3', '1');
INSERT INTO `t_sen_words` VALUES ('820', '法lg', '3', '1');
INSERT INTO `t_sen_words` VALUES ('821', 'flg', '3', '1');
INSERT INTO `t_sen_words` VALUES ('822', 'fl功', '3', '1');
INSERT INTO `t_sen_words` VALUES ('823', 'falungong', '3', '1');
INSERT INTO `t_sen_words` VALUES ('824', '大法弟子', '3', '1');
INSERT INTO `t_sen_words` VALUES ('825', '大纪元', '3', '1');
INSERT INTO `t_sen_words` VALUES ('826', 'dajiyuan', '3', '1');
INSERT INTO `t_sen_words` VALUES ('827', '明慧网', '3', '1');
INSERT INTO `t_sen_words` VALUES ('828', '明慧周报', '3', '1');
INSERT INTO `t_sen_words` VALUES ('829', '正见网', '3', '1');
INSERT INTO `t_sen_words` VALUES ('830', '新唐人', '3', '1');
INSERT INTO `t_sen_words` VALUES ('831', '伪火', '3', '1');
INSERT INTO `t_sen_words` VALUES ('832', '退党', '3', '1');
INSERT INTO `t_sen_words` VALUES ('833', 'tuidang', '3', '1');
INSERT INTO `t_sen_words` VALUES ('834', '退dang', '3', '1');
INSERT INTO `t_sen_words` VALUES ('835', '超越红墙', '3', '1');
INSERT INTO `t_sen_words` VALUES ('836', '自fen', '3', '1');
INSERT INTO `t_sen_words` VALUES ('837', '真善忍', '3', '1');
INSERT INTO `t_sen_words` VALUES ('838', '九评', '3', '1');
INSERT INTO `t_sen_words` VALUES ('839', '9评', '3', '1');
INSERT INTO `t_sen_words` VALUES ('840', '9ping', '3', '1');
INSERT INTO `t_sen_words` VALUES ('841', '九ping', '3', '1');
INSERT INTO `t_sen_words` VALUES ('842', 'jiuping', '3', '1');
INSERT INTO `t_sen_words` VALUES ('843', '藏字石', '3', '1');
INSERT INTO `t_sen_words` VALUES ('844', '集体自杀', '3', '1');
INSERT INTO `t_sen_words` VALUES ('845', '自sha', '3', '1');
INSERT INTO `t_sen_words` VALUES ('846', 'zi杀', '3', '1');
INSERT INTO `t_sen_words` VALUES ('847', 'suicide', '3', '1');
INSERT INTO `t_sen_words` VALUES ('848', 'titor', '3', '1');
INSERT INTO `t_sen_words` VALUES ('849', '逢8必灾', '3', '1');
INSERT INTO `t_sen_words` VALUES ('850', '逢八必灾', '3', '1');
INSERT INTO `t_sen_words` VALUES ('851', '逢9必乱', '3', '1');
INSERT INTO `t_sen_words` VALUES ('852', '逢九必乱', '3', '1');
INSERT INTO `t_sen_words` VALUES ('853', '朱瑟里诺', '3', '1');
INSERT INTO `t_sen_words` VALUES ('854', '根达亚文明', '3', '1');
INSERT INTO `t_sen_words` VALUES ('855', '诺查丹玛斯', '3', '1');
INSERT INTO `t_sen_words` VALUES ('856', '人类灭亡进程表', '3', '1');
INSERT INTO `t_sen_words` VALUES ('857', '按照马雅历法', '3', '1');
INSERT INTO `t_sen_words` VALUES ('858', '推背图', '3', '1');
INSERT INTO `t_sen_words` VALUES ('859', '推bei图', '3', '1');
INSERT INTO `t_sen_words` VALUES ('860', '济世灵文', '3', '1');
INSERT INTO `t_sen_words` VALUES ('861', '诸世纪', '3', '1');
INSERT INTO `t_sen_words` VALUES ('862', '爱女人', '4', '1');
INSERT INTO `t_sen_words` VALUES ('863', '爱液', '4', '1');
INSERT INTO `t_sen_words` VALUES ('864', '按摩棒', '4', '1');
INSERT INTO `t_sen_words` VALUES ('865', '拔出来', '4', '1');
INSERT INTO `t_sen_words` VALUES ('866', '爆草', '4', '1');
INSERT INTO `t_sen_words` VALUES ('867', '包二奶', '4', '1');
INSERT INTO `t_sen_words` VALUES ('868', '暴干', '4', '1');
INSERT INTO `t_sen_words` VALUES ('869', '暴奸', '4', '1');
INSERT INTO `t_sen_words` VALUES ('870', '暴乳', '4', '1');
INSERT INTO `t_sen_words` VALUES ('871', '爆乳', '4', '1');
INSERT INTO `t_sen_words` VALUES ('872', '暴淫', '4', '1');
INSERT INTO `t_sen_words` VALUES ('873', '屄', '4', '1');
INSERT INTO `t_sen_words` VALUES ('874', '被操', '4', '1');
INSERT INTO `t_sen_words` VALUES ('875', '被插', '4', '1');
INSERT INTO `t_sen_words` VALUES ('876', '被干', '4', '1');
INSERT INTO `t_sen_words` VALUES ('877', '逼奸', '4', '1');
INSERT INTO `t_sen_words` VALUES ('878', '仓井空', '4', '1');
INSERT INTO `t_sen_words` VALUES ('879', '插暴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('880', '操逼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('881', '操黑', '4', '1');
INSERT INTO `t_sen_words` VALUES ('882', '操烂', '4', '1');
INSERT INTO `t_sen_words` VALUES ('883', '肏你', '4', '1');
INSERT INTO `t_sen_words` VALUES ('884', '肏死', '4', '1');
INSERT INTO `t_sen_words` VALUES ('885', '操死', '4', '1');
INSERT INTO `t_sen_words` VALUES ('886', '操我', '4', '1');
INSERT INTO `t_sen_words` VALUES ('887', '厕奴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('888', '插比', '4', '1');
INSERT INTO `t_sen_words` VALUES ('889', '插b', '4', '1');
INSERT INTO `t_sen_words` VALUES ('890', '插逼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('891', '插进', '4', '1');
INSERT INTO `t_sen_words` VALUES ('892', '插你', '4', '1');
INSERT INTO `t_sen_words` VALUES ('893', '插我', '4', '1');
INSERT INTO `t_sen_words` VALUES ('894', '插阴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('895', '潮吹', '4', '1');
INSERT INTO `t_sen_words` VALUES ('896', '潮喷', '4', '1');
INSERT INTO `t_sen_words` VALUES ('897', '成人电影', '4', '1');
INSERT INTO `t_sen_words` VALUES ('898', '成人论坛', '4', '1');
INSERT INTO `t_sen_words` VALUES ('899', '成人色情', '4', '1');
INSERT INTO `t_sen_words` VALUES ('900', '成人网站', '4', '1');
INSERT INTO `t_sen_words` VALUES ('901', '成人文学', '4', '1');
INSERT INTO `t_sen_words` VALUES ('902', '成人小说', '4', '1');
INSERT INTO `t_sen_words` VALUES ('903', '艳情小说', '4', '1');
INSERT INTO `t_sen_words` VALUES ('904', '成人游戏', '4', '1');
INSERT INTO `t_sen_words` VALUES ('905', '吃精', '4', '1');
INSERT INTO `t_sen_words` VALUES ('906', '赤裸', '4', '1');
INSERT INTO `t_sen_words` VALUES ('907', '抽插', '4', '1');
INSERT INTO `t_sen_words` VALUES ('908', '扌由插', '4', '1');
INSERT INTO `t_sen_words` VALUES ('909', '抽一插', '4', '1');
INSERT INTO `t_sen_words` VALUES ('910', '春药', '4', '1');
INSERT INTO `t_sen_words` VALUES ('911', '大波', '4', '1');
INSERT INTO `t_sen_words` VALUES ('912', '大力抽送', '4', '1');
INSERT INTO `t_sen_words` VALUES ('913', '大乳', '4', '1');
INSERT INTO `t_sen_words` VALUES ('914', '荡妇', '4', '1');
INSERT INTO `t_sen_words` VALUES ('915', '荡女', '4', '1');
INSERT INTO `t_sen_words` VALUES ('916', '盗撮', '4', '1');
INSERT INTO `t_sen_words` VALUES ('917', '多人轮', '4', '1');
INSERT INTO `t_sen_words` VALUES ('918', '发浪', '4', '1');
INSERT INTO `t_sen_words` VALUES ('919', '放尿', '4', '1');
INSERT INTO `t_sen_words` VALUES ('920', '肥逼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('921', '粉穴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('922', '封面女郎', '4', '1');
INSERT INTO `t_sen_words` VALUES ('923', '风月大陆', '4', '1');
INSERT INTO `t_sen_words` VALUES ('924', '干死你', '4', '1');
INSERT INTO `t_sen_words` VALUES ('925', '干穴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('926', '肛交', '4', '1');
INSERT INTO `t_sen_words` VALUES ('927', '肛门', '4', '1');
INSERT INTO `t_sen_words` VALUES ('928', '龟头', '4', '1');
INSERT INTO `t_sen_words` VALUES ('929', '裹本', '4', '1');
INSERT INTO `t_sen_words` VALUES ('930', '国产av', '4', '1');
INSERT INTO `t_sen_words` VALUES ('931', '好嫩', '4', '1');
INSERT INTO `t_sen_words` VALUES ('932', '豪乳', '4', '1');
INSERT INTO `t_sen_words` VALUES ('933', '黑逼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('934', '后庭', '4', '1');
INSERT INTO `t_sen_words` VALUES ('935', '后穴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('936', '虎骑', '4', '1');
INSERT INTO `t_sen_words` VALUES ('937', '花花公子', '4', '1');
INSERT INTO `t_sen_words` VALUES ('938', '换妻俱乐部', '4', '1');
INSERT INTO `t_sen_words` VALUES ('939', '黄片', '4', '1');
INSERT INTO `t_sen_words` VALUES ('940', '几吧', '4', '1');
INSERT INTO `t_sen_words` VALUES ('941', '鸡吧', '4', '1');
INSERT INTO `t_sen_words` VALUES ('942', '鸡巴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('943', '鸡奸', '4', '1');
INSERT INTO `t_sen_words` VALUES ('944', '寂寞男', '4', '1');
INSERT INTO `t_sen_words` VALUES ('945', '寂寞女', '4', '1');
INSERT INTO `t_sen_words` VALUES ('946', '妓女', '4', '1');
INSERT INTO `t_sen_words` VALUES ('947', '激情', '4', '1');
INSERT INTO `t_sen_words` VALUES ('948', '集体淫', '4', '1');
INSERT INTO `t_sen_words` VALUES ('949', '奸情', '4', '1');
INSERT INTO `t_sen_words` VALUES ('950', '叫床', '4', '1');
INSERT INTO `t_sen_words` VALUES ('951', '脚交', '4', '1');
INSERT INTO `t_sen_words` VALUES ('952', '金鳞岂是池中物', '4', '1');
INSERT INTO `t_sen_words` VALUES ('953', '金麟岂是池中物', '4', '1');
INSERT INTO `t_sen_words` VALUES ('954', '精液', '4', '1');
INSERT INTO `t_sen_words` VALUES ('955', '就去日', '4', '1');
INSERT INTO `t_sen_words` VALUES ('956', '巨屌', '4', '1');
INSERT INTO `t_sen_words` VALUES ('957', '菊花洞', '4', '1');
INSERT INTO `t_sen_words` VALUES ('958', '菊门', '4', '1');
INSERT INTO `t_sen_words` VALUES ('959', '巨奶', '4', '1');
INSERT INTO `t_sen_words` VALUES ('960', '巨乳', '4', '1');
INSERT INTO `t_sen_words` VALUES ('961', '菊穴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('962', '开苞', '4', '1');
INSERT INTO `t_sen_words` VALUES ('963', '口爆', '4', '1');
INSERT INTO `t_sen_words` VALUES ('964', '口活', '4', '1');
INSERT INTO `t_sen_words` VALUES ('965', '口交', '4', '1');
INSERT INTO `t_sen_words` VALUES ('966', '口射', '4', '1');
INSERT INTO `t_sen_words` VALUES ('967', '口淫', '4', '1');
INSERT INTO `t_sen_words` VALUES ('968', '裤袜', '4', '1');
INSERT INTO `t_sen_words` VALUES ('969', '狂操', '4', '1');
INSERT INTO `t_sen_words` VALUES ('970', '狂插', '4', '1');
INSERT INTO `t_sen_words` VALUES ('971', '浪逼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('972', '浪妇', '4', '1');
INSERT INTO `t_sen_words` VALUES ('973', '浪叫', '4', '1');
INSERT INTO `t_sen_words` VALUES ('974', '浪女', '4', '1');
INSERT INTO `t_sen_words` VALUES ('975', '狼友', '4', '1');
INSERT INTO `t_sen_words` VALUES ('976', '聊性', '4', '1');
INSERT INTO `t_sen_words` VALUES ('977', '流淫', '4', '1');
INSERT INTO `t_sen_words` VALUES ('978', '铃木麻', '4', '1');
INSERT INTO `t_sen_words` VALUES ('979', '凌辱', '4', '1');
INSERT INTO `t_sen_words` VALUES ('980', '漏乳', '4', '1');
INSERT INTO `t_sen_words` VALUES ('981', '露b', '4', '1');
INSERT INTO `t_sen_words` VALUES ('982', '乱交', '4', '1');
INSERT INTO `t_sen_words` VALUES ('983', '乱伦', '4', '1');
INSERT INTO `t_sen_words` VALUES ('984', '轮暴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('985', '轮操', '4', '1');
INSERT INTO `t_sen_words` VALUES ('986', '轮奸', '4', '1');
INSERT INTO `t_sen_words` VALUES ('987', '裸陪', '4', '1');
INSERT INTO `t_sen_words` VALUES ('988', '买春', '4', '1');
INSERT INTO `t_sen_words` VALUES ('989', '美逼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('990', '美少妇', '4', '1');
INSERT INTO `t_sen_words` VALUES ('991', '美乳', '4', '1');
INSERT INTO `t_sen_words` VALUES ('992', '美腿', '4', '1');
INSERT INTO `t_sen_words` VALUES ('993', '美穴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('994', '美幼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('995', '秘唇', '4', '1');
INSERT INTO `t_sen_words` VALUES ('996', '迷奸', '4', '1');
INSERT INTO `t_sen_words` VALUES ('997', '密穴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('998', '蜜穴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('999', '蜜液', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1000', '摸奶', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1001', '摸胸', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1002', '母奸', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1003', '奈美', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1004', '奶子', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1005', '男奴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1006', '内射', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1007', '嫩逼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1008', '嫩女', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1009', '嫩穴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1010', '捏弄', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1011', '女优', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1012', '炮友', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1013', '砲友', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1014', '喷精', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1015', '屁眼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1016', '品香堂', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1017', '前凸后翘', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1018', '强jian', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1019', '强暴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1020', '强奸处女', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1021', '情趣用品', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1022', '情色', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1023', '拳交', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1024', '全裸', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1025', '群交', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1026', '惹火身材', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1027', '人妻', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1028', '人兽', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1029', '日逼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1030', '日烂', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1031', '肉棒', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1032', '肉逼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1033', '肉唇', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1034', '肉洞', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1035', '肉缝', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1036', '肉棍', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1037', '肉茎', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1038', '肉具', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1039', '揉乳', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1040', '肉穴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1041', '肉欲', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1042', '乳爆', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1043', '乳房', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1044', '乳沟', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1045', '乳交', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1046', '乳头', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1047', '三级片', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1048', '骚逼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1049', '骚比', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1050', '骚女', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1051', '骚水', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1052', '骚穴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1053', '色逼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1054', '色界', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1055', '色猫', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1056', '色盟', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1057', '色情网站', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1058', '色区', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1059', '色色', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1060', '色诱', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1061', '色欲', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1062', '色b', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1063', '少年阿宾', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1064', '少修正', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1065', '射爽', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1066', '射颜', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1067', '食精', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1068', '释欲', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1069', '兽奸', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1070', '兽交', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1071', '手淫', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1072', '兽欲', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1073', '熟妇', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1074', '熟母', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1075', '熟女', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1076', '爽片', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1077', '爽死我了', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1078', '双臀', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1079', '死逼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1080', '丝袜', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1081', '丝诱', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1082', '松岛枫', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1083', '酥痒', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1084', '汤加丽', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1085', '套弄', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1086', '体奸', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1087', '体位', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1088', '舔脚', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1089', '舔阴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1090', '调教', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1091', '偷欢', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1092', '偷拍', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1093', '推油', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1094', '脱内裤', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1095', '文做', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1096', '我就色', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1097', '无码', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1098', '舞女', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1099', '无修正', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1100', '吸精', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1101', '夏川纯', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1102', '相奸', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1103', '小逼', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1104', '校鸡', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1105', '小穴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1106', '小xue', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1107', '写真', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1108', '性感妖娆', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1109', '性感诱惑', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1110', '性虎', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1111', '性饥渴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1112', '性技巧', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1113', '性交', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1114', '性奴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1115', '性虐', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1116', '性息', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1117', '性欲', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1118', '胸推', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1119', '穴口', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1120', '学生妹', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1121', '穴图', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1122', '亚情', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1123', '颜射', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1124', '阳具', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1125', '杨思敏', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1126', '要射了', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1127', '夜勤病栋', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1128', '一本道', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1129', '一夜欢', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1130', '一夜情', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1131', '一ye情', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1132', '阴部', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1133', '淫虫', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1134', '阴唇', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1135', '淫荡', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1136', '阴道', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1137', '淫电影', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1138', '阴阜', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1139', '淫妇', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1140', '淫河', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1141', '阴核', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1142', '阴户', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1143', '淫贱', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1144', '淫叫', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1145', '淫教师', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1146', '阴茎', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1147', '阴精', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1148', '淫浪', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1149', '淫媚', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1150', '淫糜', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1151', '淫魔', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1152', '淫母', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1153', '淫女', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1154', '淫虐', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1155', '淫妻', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1156', '淫情', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1157', '淫色', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1158', '淫声浪语', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1159', '淫兽学园', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1160', '淫书', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1161', '淫术炼金士', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1162', '淫水', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1163', '淫娃', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1164', '淫威', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1165', '淫亵', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1166', '淫样', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1167', '淫液', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1168', '淫照', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1169', '阴b', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1170', '应召', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1171', '幼交', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1172', '幼男', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1173', '幼女', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1174', '欲火', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1175', '欲女', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1176', '玉女心经', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1177', '玉蒲团', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1178', '玉乳', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1179', '欲仙欲死', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1180', '玉穴', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1181', '援交', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1182', '原味内衣', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1183', '援助交际', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1184', '张筱雨', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1185', '招鸡', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1186', '招妓', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1187', '中年美妇', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1188', '抓胸', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1189', '自拍', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1190', '自慰', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1191', '作爱', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1192', '18禁', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1193', '99bb', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1194', 'a4u', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1195', 'a4y', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1196', 'adult', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1197', 'amateur', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1198', 'anal', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1199', 'a片', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1200', 'fuck', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1201', 'gay片', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1202', 'g点', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1203', 'g片', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1204', 'hardcore', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1205', 'h动画', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1206', 'h动漫', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1207', 'incest', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1208', 'porn', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1209', 'secom', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1210', 'sexinsex', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1211', 'sm女王', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1212', 'xiao77', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1213', 'xing伴侣', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1214', 'tokyohot', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1215', 'yin荡', '4', '1');
INSERT INTO `t_sen_words` VALUES ('1216', '汉芯造假', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1217', '杨树宽', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1218', '中印边界谈判结果', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1219', '喂奶门', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1220', '摸nai门', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1221', '酒瓶门', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1222', '脱裤门', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1223', '75事件', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1224', '乌鲁木齐', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1225', '新疆骚乱', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1226', '针刺', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1227', '打针', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1228', '食堂涨价', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1229', '饭菜涨价', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1230', 'h1n1', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1231', '瘟疫爆发', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1232', 'yangjia', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1233', 'y佳', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1234', 'yang佳', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1235', '杨佳', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1236', '杨j', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1237', '袭警', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1238', '杀警', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1239', '武侯祠', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1240', '川b26931', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1241', '贺立旗', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1242', '周正毅', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1243', 'px项目', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1244', '骂四川', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1245', '家l福', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1246', '家le福', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1247', '加了服', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1248', '麦当劳被砸', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1249', '豆腐渣', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1250', '这不是天灾', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1251', '龙小霞', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1252', '震其国土', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1253', 'yuce', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1254', '提前预测', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1255', '地震预测', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1256', '隐瞒地震', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1257', '李四光预测', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1258', '蟾蜍迁徙', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1259', '地震来得更猛烈', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1260', '八级地震毫无预报', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1261', '踩踏事故', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1262', '聂树斌', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1263', '万里大造林', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1264', '陈相贵', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1265', '张丹红', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1266', '尹方明', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1267', '李树菲', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1268', '王奉友', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1269', '零八奥运艰', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1270', '惨奥', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1271', '奥晕', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1272', '凹晕', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1273', '懊运', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1274', '懊孕', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1275', '奥孕', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1276', '奥你妈的运', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1277', '反奥', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1278', '628事件', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1279', 'weng安', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1280', 'wengan', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1281', '翁安', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1282', '瓮安事件', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1283', '化工厂爆炸', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1284', '讨回工资', '5', '1');
INSERT INTO `t_sen_words` VALUES ('1285', '专业代理', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1286', '帮忙点一下', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1287', '帮忙点下', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1288', '请点击进入', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1289', '详情请进入', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1290', '私人侦探', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1291', '私家侦探', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1292', '针孔摄象', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1293', '调查婚外情', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1294', '信用卡提现', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1295', '无抵押贷款', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1296', '广告代理', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1297', '原音铃声', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1298', '借腹生子', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1299', '找个妈妈', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1300', '找个爸爸', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1301', '代孕妈妈', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1302', '代生孩子', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1303', '代开发票', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1304', '腾讯客服电话', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1305', '销售热线', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1306', '免费订购热线', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1307', '低价出售', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1308', '款到发货', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1309', '回复可见', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1310', '连锁加盟', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1311', '加盟连锁', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1312', '免费二级域名', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1313', '免费使用', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1314', '免费索取', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1315', '蚁力神', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1316', '婴儿汤', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1317', '售肾', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1318', '刻章办', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1319', '买小车', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1320', '套牌车', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1321', '玛雅网', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1322', '电脑传讯', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1323', '视频来源', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1324', '下载速度', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1325', '高清在线', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1326', '全集在线', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1327', '在线播放', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1328', 'txt下载', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1329', '六位qq', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1330', '6位qq', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1331', '位的qq', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1332', '个qb', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1333', '送qb', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1334', '用刀横向切腹', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1335', '完全自杀手册', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1336', '四海帮', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1337', '足球投注', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1338', '地下钱庄', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1339', '中国复兴党', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1340', '阿波罗网', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1341', '曾道人', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1342', '六合彩', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1343', '改卷内幕', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1344', '替考试', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1345', '隐形耳机', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1346', '出售答案', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1347', '考中答案', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1348', '答an', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1349', 'da案', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1350', '资金周转', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1351', '救市', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1352', '股市圈钱', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1353', '崩盘', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1354', '资金短缺', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1355', '证监会', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1356', '质押贷款', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1357', '小额贷款', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1358', '周小川', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1359', '刘明康', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1360', '尚福林', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1361', '孔丹', '6', '1');
INSERT INTO `t_sen_words` VALUES ('1362', '安眠酮', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1363', '代药物毒品类：血浆', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1364', '普萘洛尔', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1365', '呋塞米', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1366', '西布曲明', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1367', 'testosterone', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1368', '胰岛素样生长因子', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1369', '促红细胞生成素', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1370', '地西泮', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1371', '尼可刹米', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1372', '甲睾酮', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1373', 'adrenaline', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1374', 'erythropoietin', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1375', '地奈德', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1376', '莫达非尼', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1377', '氯噻嗪', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1378', '苯巴比妥', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1379', '促性腺激素', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1380', '泼尼松', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1381', '麻黄草', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1382', '雄烯二醇', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1383', '地塞米松', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1384', 'tamoxifen', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1385', 'strychnine', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1386', 'androst', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1387', '新型毒品', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1388', '杜冷丁', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1389', '兴奋剂', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1390', 'mdma', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1391', '海洛因', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1392', '海luo因', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1393', 'heroin', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1394', 'diamorphine', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1395', 'diacetylmorphine', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1396', '鸦片', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1397', '阿芙蓉', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1398', '咖啡因', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1399', 'cocain', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1400', '三唑仑', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1401', '美沙酮', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1402', '麻古', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1403', 'k粉', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1404', '凯他敏', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1405', 'ketamine', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1406', '冰毒', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1407', '苯丙胺', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1408', 'cannabis', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1409', '大麻', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1410', '爱他死', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1411', '氯胺酮', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1412', 'benzodiazepines', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1413', '甲基安非他明', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1414', '安非他命', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1415', '吗啡', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1416', 'morphine', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1417', '摇头丸', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1418', '迷药', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1419', '乖乖粉', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1420', 'narcotic', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1421', '麻醉药', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1422', '精神药品 ', '7', '1');
INSERT INTO `t_sen_words` VALUES ('1423', '李愚蠢', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1424', '中国猪', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1425', '台湾猪', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1426', '进化不完全的生命体', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1427', '震死他们', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1428', '贱人', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1429', '装b', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1430', '大sb', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1431', '傻逼', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1432', '傻b', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1433', '煞逼', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1434', '煞笔', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1435', '刹笔', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1436', '傻比', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1437', '沙比', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1438', '欠干', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1439', '婊子养的', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1440', '我日你', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1441', '我操', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1442', '我草', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1443', '卧艹', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1444', '卧槽', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1445', '爆你菊', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1446', '艹你', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1447', 'cao你', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1448', '你他妈', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1449', '真他妈', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1450', '别他吗', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1451', '草你吗', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1452', '草你丫', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1453', '操你妈', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1454', '擦你妈', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1455', '操你娘', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1456', '操他妈', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1457', '日你妈', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1458', '干你妈', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1459', '干你娘', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1460', '娘西皮', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1461', '狗操', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1462', '狗草', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1463', '狗杂种', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1464', '狗日的', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1465', '操你祖宗', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1466', '操你全家', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1467', '操你大爷', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1468', '妈逼', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1469', '你麻痹', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1470', '麻痹的', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1471', '妈了个逼', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1472', '马勒', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1473', '狗娘养', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1474', '贱比', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1475', '贱b', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1476', '下贱', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1477', '死全家', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1478', '全家死光', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1479', '全家不得好死', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1480', '全家死绝', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1481', '白痴', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1482', '无耻', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1483', 'sb', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1484', '杀b', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1485', '你吗b', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1486', '你妈的', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1487', '婊子', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1488', '贱货', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1489', '人渣', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1490', '混蛋', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1491', '媚外', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1492', '和弦', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1493', '兼职', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1494', '限量', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1495', '铃声', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1496', '性伴侣', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1497', '男公关', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1498', '火辣', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1499', '精子', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1500', '射精', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1501', '诱奸', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1502', '强奸', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1503', '做爱', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1504', '性爱', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1505', '发生关系', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1506', '按摩', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1507', '快感', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1508', '处男', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1509', '猛男', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1510', '少妇', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1511', '屌', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1512', '屁股', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1513', '下体', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1514', 'a片', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1515', '内裤', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1516', '浑圆', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1517', '咪咪', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1518', '发情', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1519', '刺激', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1520', '白嫩', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1521', '粉嫩', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1522', '兽性', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1523', '风骚', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1524', '呻吟', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1525', 'sm', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1526', '阉割', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1527', '高潮', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1528', '裸露', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1529', '不穿', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1530', '一丝不挂', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1531', '脱光', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1532', '干你', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1533', '干死', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1534', '我干', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1535', '中日没有不友好的', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1536', '木牛流马的污染比汽车飞机大', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1537', '他们嫌我挡了城市的道路', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1538', '当官靠后台', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1539', '警察我们是为人民服务的', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1540', '中石化说亏损', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1541', '做人不能太cctv了', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1542', '领导干部吃王八', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1543', '工商税务两条狼', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1544', '公检法是流氓', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1545', '公安把秩序搞乱', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1546', '剖腹一刀五千几', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1547', '读不起选个学校三万起', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1548', '父母下岗儿下地', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1549', '裙中性运动', '8', '1');
INSERT INTO `t_sen_words` VALUES ('1550', '自制', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1551', '制造', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1552', '制作', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1553', '收购', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1554', '求购', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1555', '电话', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1556', '手机', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1557', '销售', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1558', '联系', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1559', 'qq', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1560', '出售 ', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1561', '买', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1562', '卖', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1563', '匕首', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1564', '管制刀具', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1565', '弹药', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1566', 'bb弹', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1567', '违禁品', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1568', '军用品', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1569', '电棍', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1570', '手枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1571', '机枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1572', '步枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1573', '气枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1574', '电狗', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1575', '手狗', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1576', '枪模', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1577', '模型枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1578', '仿真枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1579', '狙击枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1580', '信号枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1581', '麻醉枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1582', '来福枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1583', '来复枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1584', '冲锋枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1585', '散弹枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1586', '卡宾枪', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1587', '枪支', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1588', '枪械', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1589', '炸药', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1590', '硝铵', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1591', '火药', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1592', '燃烧瓶', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1593', '可燃物', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1594', '爆炸物', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1595', '炸弹', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1596', '雷管', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1597', '原子弹', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1598', '燃烧弹', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1599', 'tnt', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1600', '自制', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1601', '制造', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1602', '制作', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1603', '收购', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1604', '求购', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1605', '电话', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1606', '手机', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1607', '销售', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1608', '联系', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1609', 'qq', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1610', '出售', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1611', '买', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1612', '卖', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1613', 'sb', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1614', 'sm', '9', '1');
INSERT INTO `t_sen_words` VALUES ('1615', '穴海', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1616', '协警', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1617', '纳米比亚', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1618', '专业调查', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1619', '有华龙', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1620', 'jq的来', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1621', '电信路', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1622', '第一夫人', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1623', '党鞭', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1624', '黄巨', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1625', '荡尽天下', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1626', '家元自称玉皇大帝', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1627', '主席李世民', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1628', '何祚庥', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1629', '刘刚', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1630', '不要沉默', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1631', '后勤集团', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1632', '食堂涨价', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1633', '发国难财', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1634', '浪漫邂逅', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1635', '红满堂', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1636', '张小洋', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1637', '炸学校', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1638', '子宫', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1639', '叫晶晶的女孩', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1640', '回派', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1641', '社会黑暗', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1642', '国之母', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1643', '国母', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1644', '国姆', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1645', '东方微点', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1646', '震惊全球', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1647', 'nowto', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1648', 'chengdu', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1649', '徐明', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1650', '六月飞雪', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1651', '暴力虐待', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1652', '暴力袭击', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1653', '天府广场', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1654', '粮荒', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1655', '洗脑班', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1656', '复制地址到地址栏', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1657', '', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1658', '骂人、讽刺类：', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1659', '李愚蠢', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1660', '中国猪', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1661', '台湾猪', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1662', '进化不完全的生命体', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1663', '震死他们', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1664', '贱人', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1665', '装b', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1666', '大sb', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1667', '傻逼', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1668', '傻b', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1669', '煞逼', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1670', '煞笔', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1671', '刹笔', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1672', '傻比', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1673', '沙比', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1674', '欠干', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1675', '婊子养的', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1676', '我日你', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1677', '我操', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1678', '我草', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1679', '卧艹', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1680', '卧槽', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1681', '爆你菊', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1682', '艹你', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1683', 'cao你', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1684', '你他妈', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1685', '真他妈', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1686', '别他吗', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1687', '草你吗', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1688', '草你丫', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1689', '操你妈', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1690', '擦你妈', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1691', '操你娘', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1692', '操他妈', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1693', '日你妈', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1694', '干你妈', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1695', '干你娘', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1696', '娘西皮', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1697', '狗操', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1698', '狗草', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1699', '狗杂种', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1700', '狗日的', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1701', '操你祖宗', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1702', '操你全家', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1703', '操你大爷', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1704', '妈逼', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1705', '你麻痹', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1706', '麻痹的', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1707', '妈了个逼', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1708', '马勒', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1709', '狗娘养', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1710', '贱比', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1711', '贱b', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1712', '下贱', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1713', '死全家', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1714', '全家死光', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1715', '全家不得好死', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1716', '全家死绝', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1717', '白痴', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1718', '无耻', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1719', 'sb', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1720', '杀b', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1721', '你吗b', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1722', '你妈的', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1723', '婊子', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1724', '贱货', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1725', '人渣', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1726', '混蛋', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1727', '媚外', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1728', '和弦', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1729', '兼职', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1730', '限量', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1731', '铃声', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1732', '性伴侣', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1733', '男公关', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1734', '火辣', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1735', '精子', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1736', '射精', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1737', '诱奸', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1738', '强奸', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1739', '做爱', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1740', '性爱', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1741', '发生关系', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1742', '按摩', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1743', '快感', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1744', '处男', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1745', '猛男', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1746', '少妇', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1747', '屌', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1748', '屁股', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1749', '下体', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1750', 'a片', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1751', '内裤', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1752', '浑圆', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1753', '咪咪', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1754', '发情', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1755', '刺激', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1756', '白嫩', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1757', '粉嫩', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1758', '兽性', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1759', '风骚', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1760', '呻吟', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1761', 'sm', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1762', '阉割', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1763', '高潮', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1764', '裸露', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1765', '不穿', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1766', '一丝不挂', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1767', '脱光', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1768', '干你', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1769', '干死', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1770', '我干', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1771', '中日没有不友好的', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1772', '木牛流马的污染比汽车飞机大', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1773', '他们嫌我挡了城市的道路', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1774', '当官靠后台', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1775', '警察我们是为人民服务的', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1776', '中石化说亏损', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1777', '做人不能太cctv了', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1778', '领导干部吃王八', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1779', '工商税务两条狼', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1780', '公检法是流氓', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1781', '公安把秩序搞乱', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1782', '剖腹一刀五千几', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1783', '读不起选个学校三万起', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1784', '父母下岗儿下地', '10', '1');
INSERT INTO `t_sen_words` VALUES ('1785', '裙中性运动', '10', '1');

-- ----------------------------
-- Table structure for t_shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_shopping_cart`;
CREATE TABLE `t_shopping_cart` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `goods_id` int(10) NOT NULL,
  `goods_name` varchar(225) DEFAULT NULL,
  `image_url` varchar(225) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `mark_price` decimal(10,2) DEFAULT NULL,
  `format_id` int(10) DEFAULT NULL COMMENT '商品规格id',
  `format_name` varchar(225) DEFAULT NULL COMMENT '商品规格名字',
  `num` int(10) DEFAULT '0' COMMENT '数量',
  `checkbox` int(1) DEFAULT '1' COMMENT '是否选中',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shopping_cart
-- ----------------------------
INSERT INTO `t_shopping_cart` VALUES ('25', '1', '10001', null, null, null, null, null, null, '5', '1', '2016-11-02 00:00:19', '2017-02-04 01:22:03');
INSERT INTO `t_shopping_cart` VALUES ('26', '1', '10011', null, null, null, null, null, null, '6', '1', '2016-11-02 23:23:23', '2017-02-04 01:22:01');
INSERT INTO `t_shopping_cart` VALUES ('27', '1', '10032', null, null, null, null, null, null, '5', '1', '2017-01-05 01:23:20', '2017-02-04 01:22:04');
INSERT INTO `t_shopping_cart` VALUES ('28', '1', '10019', null, null, null, null, null, null, '14', '1', '2017-01-13 01:55:41', '2017-02-04 01:22:05');

-- ----------------------------
-- Table structure for t_shopping_cart_format
-- ----------------------------
DROP TABLE IF EXISTS `t_shopping_cart_format`;
CREATE TABLE `t_shopping_cart_format` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopping_cart_id` int(11) NOT NULL COMMENT '购物车ID',
  `format_sub_id` int(11) NOT NULL COMMENT '规格子类ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='购物车规格中间表';

-- ----------------------------
-- Records of t_shopping_cart_format
-- ----------------------------
INSERT INTO `t_shopping_cart_format` VALUES ('33', '23', '33');
INSERT INTO `t_shopping_cart_format` VALUES ('34', '23', '35');
INSERT INTO `t_shopping_cart_format` VALUES ('35', '23', '38');
INSERT INTO `t_shopping_cart_format` VALUES ('36', '23', '40');
INSERT INTO `t_shopping_cart_format` VALUES ('37', '24', '52');
INSERT INTO `t_shopping_cart_format` VALUES ('38', '25', '32');
INSERT INTO `t_shopping_cart_format` VALUES ('39', '25', '34');
INSERT INTO `t_shopping_cart_format` VALUES ('40', '25', '37');
INSERT INTO `t_shopping_cart_format` VALUES ('41', '25', '40');
INSERT INTO `t_shopping_cart_format` VALUES ('42', '25', '41');
INSERT INTO `t_shopping_cart_format` VALUES ('43', '27', '57');
INSERT INTO `t_shopping_cart_format` VALUES ('44', '27', '58');
INSERT INTO `t_shopping_cart_format` VALUES ('45', '28', '45');

-- ----------------------------
-- Table structure for t_society_dis
-- ----------------------------
DROP TABLE IF EXISTS `t_society_dis`;
CREATE TABLE `t_society_dis` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `society_note_id` int(10) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `content` varchar(225) DEFAULT NULL COMMENT '回复内容',
  `img_is` int(1) DEFAULT '0' COMMENT '是否有图片0没有，1有',
  `reply_is` int(1) DEFAULT '0' COMMENT '是否有回复,0没有，1有',
  `good_num` int(10) unsigned DEFAULT '0' COMMENT '点赞数量',
  `parent` int(10) DEFAULT '0' COMMENT '跟帖的上级（0表示回复帖子）',
  `status` int(1) DEFAULT '0' COMMENT '0正常',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='回帖内容，根据帖子id，分表 注意分表';

-- ----------------------------
-- Records of t_society_dis
-- ----------------------------
INSERT INTO `t_society_dis` VALUES ('1', '2', '4', null, '怎么说呢，好多好多要说的', '1', '1', '1', '0', '0', '2017-02-04 01:22:51');
INSERT INTO `t_society_dis` VALUES ('2', '2', '3', null, '电饭锅电饭锅电饭锅', '0', '1', '2', '0', '0', '2017-01-18 01:09:02');
INSERT INTO `t_society_dis` VALUES ('3', '2', '4', null, '看了看空间看规划局', '0', '0', '1', '0', '0', '2017-02-03 21:37:11');
INSERT INTO `t_society_dis` VALUES ('4', '2', '8', null, '纪念馆好几个号结构化', '0', '0', '1', '0', '0', '2017-01-18 21:30:30');
INSERT INTO `t_society_dis` VALUES ('5', '2', '10', null, '个人通过后国的法国的飞', '0', '0', '1', '0', '0', '2017-01-17 00:39:37');
INSERT INTO `t_society_dis` VALUES ('6', '2', '11', null, '不能发给你房管局南风过境你干嘛挂号费寂寞孤独还没那该多好没打过黑默丁格黑默丁格会很反感害死人挺好共和党人的风格大概大概大概', '0', '0', '1', '0', '0', '2017-01-17 00:39:39');

-- ----------------------------
-- Table structure for t_society_dis_dis
-- ----------------------------
DROP TABLE IF EXISTS `t_society_dis_dis`;
CREATE TABLE `t_society_dis_dis` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `society_dis_id` int(10) DEFAULT NULL COMMENT '评论ID',
  `user_id` int(10) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `content` varchar(225) DEFAULT NULL COMMENT '回复内容',
  `img_is` int(1) DEFAULT '0' COMMENT '是否有图片0没有，1有',
  `parent` int(10) DEFAULT '0' COMMENT '跟帖的上级（0表示回复帖子）',
  `good_num` int(50) DEFAULT '0' COMMENT '点赞数量',
  `reply_user_id` int(10) DEFAULT NULL,
  `reply_user_name` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT '0' COMMENT '0正常',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='回帖内容，根据帖子id，分表 注意分表';

-- ----------------------------
-- Records of t_society_dis_dis
-- ----------------------------
INSERT INTO `t_society_dis_dis` VALUES ('1', '1', '5', '', '这个回复好', '0', '0', '0', null, null, '0', '2017-01-04 01:03:44');
INSERT INTO `t_society_dis_dis` VALUES ('2', '1', '6', null, '这个更加棒', '0', '0', '0', '5', null, '0', '2017-01-05 00:53:45');
INSERT INTO `t_society_dis_dis` VALUES ('3', '2', '7', null, '心情不美丽', '0', '0', '0', null, null, '0', '1979-01-01 01:00:00');
INSERT INTO `t_society_dis_dis` VALUES ('4', '2', '8', null, '我爱这个社会', '0', '0', '0', null, null, '0', '2017-01-05 00:54:13');

-- ----------------------------
-- Table structure for t_society_dis_dis_like
-- ----------------------------
DROP TABLE IF EXISTS `t_society_dis_dis_like`;
CREATE TABLE `t_society_dis_dis_like` (
  `id` int(11) NOT NULL COMMENT 'ID(帖子ID,或者评论ID或者评论的评论ID）',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子和评论点赞';

-- ----------------------------
-- Records of t_society_dis_dis_like
-- ----------------------------

-- ----------------------------
-- Table structure for t_society_dis_like
-- ----------------------------
DROP TABLE IF EXISTS `t_society_dis_like`;
CREATE TABLE `t_society_dis_like` (
  `id` int(11) NOT NULL COMMENT 'ID(帖子ID,或者评论ID或者评论的评论ID）',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子和评论点赞';

-- ----------------------------
-- Records of t_society_dis_like
-- ----------------------------
INSERT INTO `t_society_dis_like` VALUES ('1', '1', '2017-02-04 01:22:51');
INSERT INTO `t_society_dis_like` VALUES ('2', '1', '2017-01-18 01:09:02');
INSERT INTO `t_society_dis_like` VALUES ('3', '1', '2017-02-03 21:37:11');
INSERT INTO `t_society_dis_like` VALUES ('4', '1', '2017-01-18 21:30:30');
INSERT INTO `t_society_dis_like` VALUES ('5', '1', '2017-01-17 00:39:37');
INSERT INTO `t_society_dis_like` VALUES ('6', '1', '2017-01-17 00:39:39');

-- ----------------------------
-- Table structure for t_society_note
-- ----------------------------
DROP TABLE IF EXISTS `t_society_note`;
CREATE TABLE `t_society_note` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `society_sub_id` int(10) DEFAULT NULL COMMENT '社区主题id',
  `society_sub_name` varchar(32) DEFAULT NULL COMMENT '帖子类型名称',
  `user_id` int(10) NOT NULL,
  `nick_name` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `detail` varchar(500) DEFAULT NULL COMMENT '帖子详情',
  `address` varchar(50) DEFAULT '' COMMENT '发表地址',
  `ip` varchar(32) DEFAULT NULL COMMENT '发表的ip地址',
  `good_num` int(10) unsigned DEFAULT '0' COMMENT '点赞数量',
  `dis_num` int(10) unsigned DEFAULT '0' COMMENT '评论数量',
  `top_is` int(1) DEFAULT '0' COMMENT '是否置顶',
  `rec_is` int(1) DEFAULT '0' COMMENT '是否推荐',
  `gifts_is` int(1) DEFAULT '0' COMMENT '是否是精品',
  `img_is` int(1) DEFAULT '0' COMMENT '是否有图片(0没有)',
  `reward_is` int(1) DEFAULT '0' COMMENT '是否打赏',
  `type` int(1) DEFAULT '1' COMMENT '0社区公告，1是社区讨论帖子，2是体验贴，',
  `ano_is` int(1) DEFAULT '0' COMMENT '是否匿名发帖',
  `ann_is` int(1) DEFAULT '0' COMMENT '是否是公告(0不是，1是)',
  `status` int(1) DEFAULT '1' COMMENT '1是待审核，2是已经审核通过',
  `tags` varchar(225) DEFAULT NULL COMMENT '帖子标签',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='帖子';

-- ----------------------------
-- Records of t_society_note
-- ----------------------------
INSERT INTO `t_society_note` VALUES ('1', '10', '我的羞羞日记', '1', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '深圳', null, '12', '45', '0', '1', '1', '1', '0', '1', '0', null, '2', null, '2016-12-10 22:05:25', '2017-02-21 00:29:14');
INSERT INTO `t_society_note` VALUES ('2', '10', '我的羞羞日记', '3', '若放弃，请彻底', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '', null, '24', '34', '1', '1', '1', '1', '1', '1', null, null, '2', null, '2015-12-11 22:05:25', '2017-02-12 23:26:14');
INSERT INTO `t_society_note` VALUES ('3', '8', '内衣间的秘密', '3', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '', null, '0', '1', '0', '0', '0', '1', '0', '1', null, null, '2', null, '2016-10-11 22:05:25', '2017-01-12 01:15:54');
INSERT INTO `t_society_note` VALUES ('4', '12', '超级性幻想', '4', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '深圳', null, '0', '3', '0', '0', '1', '1', '0', '1', null, null, '2', null, '2013-12-11 22:05:25', '2017-02-21 00:29:15');
INSERT INTO `t_society_note` VALUES ('5', '10', '我的羞羞日记', '5', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '', null, '1', '23', '0', '1', '0', '1', '0', '1', null, null, '2', null, '2016-12-11 11:05:25', '2017-02-21 00:29:26');
INSERT INTO `t_society_note` VALUES ('6', '10', '我的羞羞日记', '6', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '', null, '0', '4', '0', '1', '1', '1', '0', '1', null, null, '2', null, '2016-12-11 20:05:25', '2017-02-21 00:29:27');
INSERT INTO `t_society_note` VALUES ('7', '10', '我的羞羞日记', '7', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '', null, '0', '3', '0', '1', '1', '1', '0', '1', null, null, '2', null, '2016-11-11 15:05:25', '2017-02-21 00:29:25');
INSERT INTO `t_society_note` VALUES ('8', '10', '我的羞羞日记', '7', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '深圳', null, '0', '8', '0', '0', '1', '1', '0', '1', null, null, '2', null, '2016-10-11 22:05:25', '2017-02-21 00:29:19');
INSERT INTO `t_society_note` VALUES ('9', '10', '我的羞羞日记', '8', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '', null, '0', '2', '0', '1', '1', '1', '0', '1', null, null, '2', null, '2016-08-11 22:05:25', '2017-02-21 00:29:23');
INSERT INTO `t_society_note` VALUES ('10', '10', '我的羞羞日记', '9', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '', null, '0', '4', '0', '1', '0', '1', '0', '1', null, null, '2', null, '2016-07-11 22:05:25', '2017-02-21 00:29:24');
INSERT INTO `t_society_note` VALUES ('11', '10', '我的羞羞日记', '1', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '', null, '0', '34', '0', '0', '1', '1', '0', '1', null, null, '2', null, '2016-07-10 22:05:25', '2017-02-21 00:29:23');
INSERT INTO `t_society_note` VALUES ('12', '10', '我的羞羞日记', '3', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '深圳', null, '0', '3', '0', '1', '0', '1', '0', '1', null, null, '2', null, '2016-09-11 22:05:25', '2017-02-21 00:29:06');
INSERT INTO `t_society_note` VALUES ('13', '10', '我的羞羞日记', '4', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '', null, '0', '5', '0', '1', '1', '1', '0', '1', null, null, '2', null, '2016-11-23 22:05:25', '2017-02-21 00:29:13');
INSERT INTO `t_society_note` VALUES ('14', '10', '我的羞羞日记', '5', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '深圳', null, '0', '6', '0', '1', '1', '1', '0', '1', null, null, '2', null, '2016-11-12 22:05:25', '2017-02-21 00:29:13');
INSERT INTO `t_society_note` VALUES ('15', '10', '我的羞羞日记', '6', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '', null, '0', '7', '0', '1', '1', '1', '0', '1', null, null, '2', null, '2016-12-11 22:05:25', '2017-02-21 00:29:12');
INSERT INTO `t_society_note` VALUES ('16', '10', '我的羞羞日记', '7', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '深圳', null, '0', '11', '0', '1', '1', '1', '0', '1', '1', null, '2', null, '2016-12-11 22:05:25', '2017-02-21 00:29:12');
INSERT INTO `t_society_note` VALUES ('17', '10', '我的羞羞日记', '15', '遗城落梦', '好吧，我也讲讲我的经历', '比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的比较多吧，慢慢来想看看，那你我21，她28，她离异，我单身狗，记得我吗实在酒吧认识的', '', null, '0', '15', '0', '0', '0', '1', '0', '1', null, null, '2', null, '2016-12-11 22:05:25', '2017-01-12 01:16:02');
INSERT INTO `t_society_note` VALUES ('18', '10', '我的羞羞日记', '0', '系统', '公告', '这个是公告内容', '', null, '0', '8', '0', '0', '0', '1', '0', '0', '0', '1', '2', null, '2016-12-11 22:05:25', '2017-01-12 01:15:59');
INSERT INTO `t_society_note` VALUES ('19', '10', '我的羞羞日记', '0', '系统', '公告1', '这个是公告1内容', '', null, '0', '11', '0', '0', '0', '1', '0', '0', null, '1', '2', null, '2016-12-11 22:05:25', '2017-01-12 01:16:00');

-- ----------------------------
-- Table structure for t_society_note_like
-- ----------------------------
DROP TABLE IF EXISTS `t_society_note_like`;
CREATE TABLE `t_society_note_like` (
  `id` int(11) NOT NULL COMMENT 'ID(帖子ID,或者评论ID或者评论的评论ID）',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子和评论点赞';

-- ----------------------------
-- Records of t_society_note_like
-- ----------------------------
INSERT INTO `t_society_note_like` VALUES ('2', '1', '2017-02-12 23:26:14');
INSERT INTO `t_society_note_like` VALUES ('5', '1', '2017-02-04 01:14:07');
INSERT INTO `t_society_note_like` VALUES ('6', '1', '2017-01-02 01:23:06');

-- ----------------------------
-- Table structure for t_society_note_reward
-- ----------------------------
DROP TABLE IF EXISTS `t_society_note_reward`;
CREATE TABLE `t_society_note_reward` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `society_note_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL COMMENT '收的',
  `bus_user_id` int(10) DEFAULT NULL COMMENT '出的',
  `type` int(4) DEFAULT NULL COMMENT '1打赏类型逗币，',
  `val_num` int(10) DEFAULT '0' COMMENT '价值数量',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='社区打赏';

-- ----------------------------
-- Records of t_society_note_reward
-- ----------------------------
INSERT INTO `t_society_note_reward` VALUES ('1', '2', '3', '1', '1', '10', '2017-01-12 01:14:18');
INSERT INTO `t_society_note_reward` VALUES ('2', '2', '3', '2', '1', '5', '2017-01-12 01:14:38');
INSERT INTO `t_society_note_reward` VALUES ('3', '2', '3', '16', '1', '8', '2017-01-12 02:05:35');
INSERT INTO `t_society_note_reward` VALUES ('4', '2', '3', '4', '1', '20', '2017-01-12 02:05:18');
INSERT INTO `t_society_note_reward` VALUES ('5', '2', '3', '5', '1', '12', '2017-01-12 02:05:18');
INSERT INTO `t_society_note_reward` VALUES ('6', '2', '3', '6', '1', '18', '2017-01-12 02:05:19');
INSERT INTO `t_society_note_reward` VALUES ('7', '2', '3', '7', '1', '1', '2017-01-12 02:05:19');
INSERT INTO `t_society_note_reward` VALUES ('8', '2', '3', '8', '1', '2', '2017-01-12 02:05:20');
INSERT INTO `t_society_note_reward` VALUES ('9', '2', '3', '9', '1', '3', '2017-01-12 02:05:21');
INSERT INTO `t_society_note_reward` VALUES ('10', '2', '3', '10', '1', '5', '2017-01-12 02:05:25');
INSERT INTO `t_society_note_reward` VALUES ('11', '2', '3', '11', '1', '4', '2017-01-12 02:05:26');
INSERT INTO `t_society_note_reward` VALUES ('12', '2', '3', '12', '1', '6', '2017-01-12 02:05:27');
INSERT INTO `t_society_note_reward` VALUES ('13', '2', '3', '13', '1', '7', '2017-01-12 02:05:29');
INSERT INTO `t_society_note_reward` VALUES ('14', '2', '3', '14', '1', '8', '2017-01-12 02:05:30');
INSERT INTO `t_society_note_reward` VALUES ('15', '2', '3', '15', '1', '9', '2017-01-12 02:05:31');

-- ----------------------------
-- Table structure for t_society_sub_type
-- ----------------------------
DROP TABLE IF EXISTS `t_society_sub_type`;
CREATE TABLE `t_society_sub_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT '',
  `ico` varchar(16) DEFAULT NULL COMMENT '图标',
  `ico_color` varchar(16) DEFAULT NULL COMMENT '图标颜色',
  `image` varchar(128) DEFAULT '',
  `synopsis` varchar(225) DEFAULT NULL COMMENT '简介',
  `type` int(1) DEFAULT NULL COMMENT '类型',
  `status` int(1) DEFAULT '0' COMMENT '0正常',
  `sort` int(2) DEFAULT '0',
  `hot_num` int(10) DEFAULT '0' COMMENT '热门度，就是帖子数',
  `award_type` int(1) DEFAULT '0' COMMENT '奖励类型，（0没有奖励，1奖励逗币，2奖励积分，3是逗币和积分）',
  `award_num` int(4) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_society_sub_type
-- ----------------------------
INSERT INTO `t_society_sub_type` VALUES ('7', '情趣研究所', '&#xe63d;', '#FFBBFF', '', '成人用品晒单', '1', '0', '1', '0', null, null, '2016-01-23 18:46:44', '2016-12-01 23:47:49');
INSERT INTO `t_society_sub_type` VALUES ('8', '内衣间的秘密', '&#xe624;', '#FFBBFF', '', '情趣内衣晒单，做不同的自己', '1', '0', '2', '0', null, null, '2016-01-23 18:46:44', '2016-12-01 01:54:24');
INSERT INTO `t_society_sub_type` VALUES ('9', '蜡烛爱上鞭', '&#xe64f;', '#FFBBFF', '', '鞭笞我吧，我的女王sm爱好者', '1', '0', '3', '0', null, null, '2016-01-23 18:46:44', '2016-12-01 01:54:25');
INSERT INTO `t_society_sub_type` VALUES ('10', '我的羞羞日记', '&#xe711;', '#FFBBFF', '', '记录羞羞的故事，黄文滚出', '1', '0', '4', '0', null, null, '2016-01-23 18:46:44', '2016-12-01 01:54:28');
INSERT INTO `t_society_sub_type` VALUES ('11', 'what a funking day', '&#xe655;', '#FFBBFF', '', '那些糟糕的性体验', '1', '0', '5', '0', null, null, '2016-01-23 18:46:44', '2016-12-01 01:57:17');
INSERT INTO `t_society_sub_type` VALUES ('12', '超级性幻想', '&#xe61e;', '#FFBBFF', '', '说说那些不为人知的邪恶幻想', '1', '0', '6', '0', null, null, '2016-01-23 18:46:44', '2016-12-01 01:57:18');
INSERT INTO `t_society_sub_type` VALUES ('13', '昨晚梦到啥', '&#xe628;', '#FFBBFF', '', '你做梦我来答，周公是小徒郎', '1', '0', '7', '0', null, null, '2016-01-23 18:56:02', '2016-12-01 01:57:19');
INSERT INTO `t_society_sub_type` VALUES ('14', '奇怪性癖好', '&#xe627;', '#FFBBFF', '', '恋毛暴露，粗口脏话可撒娇不可违规', '1', '0', '8', '0', null, null, '2016-01-23 19:07:47', '2016-12-01 01:57:19');
INSERT INTO `t_society_sub_type` VALUES ('15', '拒绝性骚扰', '&#xe625;', '#FFBBFF', '', '我可以骚，你不可以扰，讲述你在各种场合碰到的性骚扰', '1', '0', '9', '0', null, null, '2016-01-23 19:07:47', '2016-12-01 01:57:20');
INSERT INTO `t_society_sub_type` VALUES ('16', '男男那些事', '&#xe646;', '#FFBBFF', '', '好基友 一被子 不约炮 不骚扰', '1', '0', '10', '0', null, null, '2016-01-23 19:07:47', '2016-12-01 01:57:20');
INSERT INTO `t_society_sub_type` VALUES ('17', '拉拉后花园', '&#xe626;', '#FFBBFF', '', '唯有女人更懂女人，LES天堂女女聚聚', '1', '0', '11', '0', null, null, '2016-01-23 19:07:47', '2016-12-01 01:57:25');
INSERT INTO `t_society_sub_type` VALUES ('27', '我们的故事', '&#xe633;', '#FFBBFF', '', '你讲故事，我送逗币', '2', '0', '1', '0', null, null, '2016-01-23 19:22:43', '2016-12-01 01:57:25');
INSERT INTO `t_society_sub_type` VALUES ('28', '谈谈情说说爱', '&#xe6c4;', '#FFBBFF', '', '晒出爱情路上的点滴', '2', '0', '2', '0', null, null, '2016-01-23 19:22:43', '2016-12-01 01:57:26');
INSERT INTO `t_society_sub_type` VALUES ('29', '分手的一万种理由', '&#xe7c4;', '#FFBBFF', '', '奇葩分手理由征集', '2', '0', '3', '0', null, null, '2016-01-23 19:22:43', '2016-12-01 01:57:26');
INSERT INTO `t_society_sub_type` VALUES ('30', '心情随笔', '&#xe676;', '#FFBBFF', '', '记录生活的感悟', '2', '0', '4', '0', null, null, '2016-01-23 19:22:43', '2016-12-01 01:57:26');
INSERT INTO `t_society_sub_type` VALUES ('31', '谁没爱过人渣', '&#xe629;', '#FFBBFF', '', '那些条腿踏n条船的故事', '2', '0', '5', '0', null, null, '2016-01-23 19:19:00', '2016-12-01 01:57:27');
INSERT INTO `t_society_sub_type` VALUES ('32', '单身狗的日常', '&#xe62a;', '#FFBBFF', '', '单身狗集中营，记录你的日常点点滴滴', '2', '0', '6', '0', null, null, '2016-01-23 19:19:00', '2016-12-01 01:57:32');
INSERT INTO `t_society_sub_type` VALUES ('33', '泡学宝典', '&#xe62b;', '#FFBBFF', '', '泡妞追男秘籍，教你推女神、追男神', '2', '0', '7', '0', null, null, '2016-01-23 19:19:00', '2016-12-01 01:57:33');
INSERT INTO `t_society_sub_type` VALUES ('34', '男闺蜜女闺蜜', '&#xe6b7;', '#FFBBFF', '', '友情幌子下的暧昧能忍多久', '2', '0', '8', '0', null, null, '2016-01-23 19:19:01', '2016-12-01 01:57:33');
INSERT INTO `t_society_sub_type` VALUES ('35', '异地恋', '&#xe848;', '#FFBBFF', '', '爱是最大的救赎', '2', '0', '9', '0', null, null, '2016-01-23 19:19:01', '2016-12-01 01:57:34');
INSERT INTO `t_society_sub_type` VALUES ('36', '情感加油站', '&#xe62c;', '#FFBBFF', '', '女教师坐镇，解答你的情感疑问', '2', '0', '10', '0', null, null, '2016-01-23 19:19:01', '2016-12-01 01:57:34');
INSERT INTO `t_society_sub_type` VALUES ('37', '婚姻保卫战', '&#xe659;', '#FFBBFF', '', '夫妻婆媳相处之道。绿帽小三攻防之战', '2', '0', '11', '0', null, null, '2016-01-23 19:19:01', '2016-12-01 01:57:35');
INSERT INTO `t_society_sub_type` VALUES ('38', '相亲那些个事', '&#xe62e;', '#FFBBFF', '', '分享各种有趣，甜蜜，奇葩的相亲遭遇', '2', '0', '12', '0', null, null, '2016-01-23 19:19:01', '2016-12-01 01:57:36');
INSERT INTO `t_society_sub_type` VALUES ('39', '闺蜜私房话', '&#xe64d;', '#FFBBFF', '', '聊一聊闺蜜想聊得话题', '2', '0', '13', '0', null, null, '2016-01-23 19:19:01', '2016-12-01 01:57:36');
INSERT INTO `t_society_sub_type` VALUES ('40', '性性相吸', '&#xe705;', '#FFBBFF', '', '最健康最好玩的性知识讨论圈', '3', '0', '0', '0', null, null, '2016-01-23 19:35:32', '2016-12-01 01:57:37');
INSERT INTO `t_society_sub_type` VALUES ('41', '兽业解惑', '&#xe68a;', '#FFBBFF', '', '叫兽解答你对性的困扰以及日常问题', '3', '0', '0', '0', null, null, '2016-01-23 19:35:33', '2016-12-01 01:57:43');
INSERT INTO `t_society_sub_type` VALUES ('42', '姨妈打卡区', '&#xe66d;', '#FFBBFF', '', '传闻发帖不痛经 欢迎男票来打卡', '3', '0', '0', '0', null, null, '2016-01-23 19:35:33', '2016-12-01 01:57:44');
INSERT INTO `t_society_sub_type` VALUES ('43', '打灰机二三事', '&#xe62f;', '#FFBBFF', '', '大多数的时候人总要靠自己', '3', '0', '0', '0', null, null, '2016-01-23 19:35:33', '2016-12-01 01:57:45');
INSERT INTO `t_society_sub_type` VALUES ('44', '丁丁历险记', '&#xe6ee;', '#FFBBFF', '', '割包皮的小伙伴们体验交流解疑', '3', '0', '0', '0', null, null, '2016-01-23 19:35:33', '2016-12-01 01:57:45');
INSERT INTO `t_society_sub_type` VALUES ('45', '青少年性教育', '&#xe6b5;', '#FFBBFF', '', '青少年青春期的性教育', '3', '0', '0', '0', null, null, '2016-01-23 19:35:33', '2016-12-01 01:57:46');
INSERT INTO `t_society_sub_type` VALUES ('46', '风流病防治中心', '&#xe6cb;', '#FFBBFF', '', '性病可以治，不敢见医生，我们先聊聊', '3', '0', '0', '0', null, null, '2016-01-23 19:35:33', '2016-12-01 01:57:47');
INSERT INTO `t_society_sub_type` VALUES ('47', '妇科保健院', '&#xe6f4;', '#FFBBFF', '', '女人身边最好的健康生活指南', '3', '0', '0', '0', null, null, '2016-01-23 19:35:33', '2016-12-01 01:57:47');
INSERT INTO `t_society_sub_type` VALUES ('48', '观日路技术讨论区', '&#xe6b6;', '#FFBBFF', '', '网罗新鲜事儿 生活综合讨论 严肃带着幽默', '4', '0', '0', '0', null, null, '2016-01-23 19:58:15', '2016-12-01 01:57:40');
INSERT INTO `t_society_sub_type` VALUES ('49', '这个点 你在做什么', '&#xe630;', '#FFBBFF', '', '一句话分享你现在做的事', '4', '0', '0', '0', null, null, '2016-01-23 19:58:15', '2016-12-01 01:57:39');
INSERT INTO `t_society_sub_type` VALUES ('50', '大学生了没', '&#xe6c1;', '#FFBBFF', '', '大学生活真好', '4', '0', '0', '0', null, null, '2016-01-23 19:58:15', '2016-12-01 01:57:39');
INSERT INTO `t_society_sub_type` VALUES ('51', '吐槽竞技场', '&#xe631;', '#FFBBFF', '', '心中有槽，不吐不快！专业吐槽圣地', '4', '0', '0', '0', null, null, '2016-01-23 19:58:15', '2016-12-01 01:57:29');
INSERT INTO `t_society_sub_type` VALUES ('52', '我要吹牛别拦着我', '&#xe662;', '#FFBBFF', '', '大力吹，不要停', '4', '0', '0', '0', null, null, '2016-01-23 19:58:15', '2016-12-01 01:57:29');
INSERT INTO `t_society_sub_type` VALUES ('53', '随手发帖升级区', '&#xe643;', '#FFBBFF', '', '这是一个随便但是不约的版块', '4', '0', '0', '0', null, null, '2016-01-23 19:58:16', '2016-12-01 01:57:22');
INSERT INTO `t_society_sub_type` VALUES ('54', '奇闻异事', '&#xe6fd;', '#FFBBFF', '', '起源鬼斧神工，发展瞠目结舌', '4', '0', '0', '0', null, null, '2016-01-23 19:58:16', '2016-12-01 01:57:21');
INSERT INTO `t_society_sub_type` VALUES ('55', '职场大家谈', '&#xe660;', '#FFBBFF', '', '啪啪啪啪说一大堆关于职场的八卦', '4', '0', '0', '0', null, null, '2016-01-23 19:58:16', '2016-12-01 01:57:37');
INSERT INTO `t_society_sub_type` VALUES ('56', '同城交友', '&#xe65f;', '#FFBBFF', '', '交友相亲 同城约会', '4', '0', '0', '0', null, null, '2016-01-23 19:58:16', '2016-12-01 23:48:00');
INSERT INTO `t_society_sub_type` VALUES ('57', '优质生活指南', '&#xe863;', '#FFBBFF', '', '体现你华丽逼格和生活品质的圈子', '4', '0', '0', '0', null, null, '2016-01-23 19:58:16', '2016-12-01 23:48:01');
INSERT INTO `t_society_sub_type` VALUES ('58', '未来研究所', '&#xe63b;', '#FFBBFF', '', '一起来竞猜未来好玩的事', '5', '0', '0', '0', null, null, '2016-01-23 20:08:00', '2016-12-01 23:48:01');
INSERT INTO `t_society_sub_type` VALUES ('59', '逗趣香蕉TV', '&#xe601;', '#FFBBFF', '', '香蕉哥带你看好玩有趣的视频', '5', '0', '0', '0', null, null, '2016-01-23 20:08:00', '2016-12-01 23:48:02');
INSERT INTO `t_society_sub_type` VALUES ('60', '路上的邂逅', '&#xe632;', '#FFBBFF', '', '分享你的美丽旅程和浪漫艳遇', '5', '0', '0', '0', null, null, '2016-01-23 20:08:01', '2016-12-01 23:48:02');
INSERT INTO `t_society_sub_type` VALUES ('61', '运动健身馆', '&#xe648;', '#FFBBFF', '', '运动健身，塑造完美身材，减肥打卡互助', '5', '0', '0', '0', null, null, '2016-01-23 20:08:01', '2016-12-01 23:48:03');
INSERT INTO `t_society_sub_type` VALUES ('62', '炮火中的游戏圈', '&#xe634;', '#FFBBFF', '', '游戏中不止有WASD，还有啪啪啪', '5', '0', '0', '0', null, null, '2016-01-23 20:08:01', '2016-12-01 23:48:04');
INSERT INTO `t_society_sub_type` VALUES ('63', '吃货的厨房', '&#xe635;', '#FFBBFF', '', '唯美食和妹子不可辜负', '5', '0', '0', '0', null, null, '2016-01-23 20:08:01', '2016-12-01 23:48:04');
INSERT INTO `t_society_sub_type` VALUES ('64', '逗聊星座', '&#xe636;', '#FFBBFF', '', '星座速配，和ta一起做美妙的事', '5', '0', '0', '0', null, null, '2016-01-23 20:08:01', '2016-12-01 23:48:05');
INSERT INTO `t_society_sub_type` VALUES ('65', '动漫宅基腐', '&#xe637;', '#FFBBFF', '', '看动漫，享激情', '5', '0', '0', '0', null, null, '2016-01-23 20:08:01', '2016-12-01 23:48:06');
INSERT INTO `t_society_sub_type` VALUES ('66', '娱乐八卦区', '&#xe638;', '#FFBBFF', '', '扒内幕揭丑闻，我们越扒越爽', '5', '0', '0', '0', null, null, '2016-01-23 20:08:01', '2016-12-01 23:48:06');
INSERT INTO `t_society_sub_type` VALUES ('67', '无节操放映社', '&#xe639;', '#FFBBFF', '', '无任何节操的，为你带来好看的AVI', '5', '0', '0', '0', null, null, '2016-01-23 20:08:01', '2016-12-01 23:48:07');
INSERT INTO `t_society_sub_type` VALUES ('68', '有图有金币', '&#xe7df;', '#FFBBFF', '', '只放ID照，有ID有逗币，没ID下边请', '6', '0', '0', '0', null, null, '2016-01-23 20:23:12', '2016-12-01 23:48:08');
INSERT INTO `t_society_sub_type` VALUES ('69', '不帅你抽我', '&#xe63a;', '#FFBBFF', '', '型男自拍，达人点评，教你逆袭白富美', '6', '0', '0', '0', null, null, '2016-01-23 20:23:12', '2016-12-01 23:48:08');
INSERT INTO `t_society_sub_type` VALUES ('70', '家有仙妻', '&#xe716;', '#FFBBFF', '', '晒老婆 晒情人 秀恩爱 图说故事', '6', '0', '0', '0', null, null, '2016-01-23 20:23:12', '2016-12-01 23:48:09');
INSERT INTO `t_society_sub_type` VALUES ('71', '晒美颜', '&#xe63c;', '#FFBBFF', '', '就是这莫美丽 就是这莫自信', '6', '0', '0', '0', null, null, '2016-01-23 20:23:12', '2016-12-01 23:48:10');
INSERT INTO `t_society_sub_type` VALUES ('72', '没有沟不会火', '&#xe608;', '#FFBBFF', '', '动如脱兔招架不住 波涛汹涌惊世骇俗', '6', '0', '0', '0', null, null, '2016-01-23 20:23:12', '2016-12-01 23:48:11');
INSERT INTO `t_society_sub_type` VALUES ('73', '姐有大长腿', '&#xe604;', '#FFBBFF', '', '晒美腿 晒高跟 晒没足', '6', '0', '0', '0', null, null, '2016-01-23 20:23:12', '2016-12-01 23:48:12');

-- ----------------------------
-- Table structure for t_society_sub_type_user
-- ----------------------------
DROP TABLE IF EXISTS `t_society_sub_type_user`;
CREATE TABLE `t_society_sub_type_user` (
  `society_sub_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `val` int(10) DEFAULT '0' COMMENT '社区圈贡献值',
  `type` int(1) DEFAULT '1' COMMENT '用在在板块的身份，1是正常，2是版主',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`society_sub_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关注的主题';

-- ----------------------------
-- Records of t_society_sub_type_user
-- ----------------------------
INSERT INTO `t_society_sub_type_user` VALUES ('10', '1', '0', '1', '2016-12-18 03:17:34', '2016-12-18 03:17:34');
INSERT INTO `t_society_sub_type_user` VALUES ('36', '1', '0', '1', '2016-12-22 23:27:18', '2016-12-22 23:27:18');
INSERT INTO `t_society_sub_type_user` VALUES ('53', '1', '0', '1', '2016-12-18 02:32:20', '2016-12-18 02:32:20');
INSERT INTO `t_society_sub_type_user` VALUES ('54', '1', '0', '1', '2016-12-18 02:32:23', '2016-12-18 02:32:23');
INSERT INTO `t_society_sub_type_user` VALUES ('63', '1', '0', '1', '2016-12-18 02:32:29', '2016-12-18 02:32:29');

-- ----------------------------
-- Table structure for t_society_type
-- ----------------------------
DROP TABLE IF EXISTS `t_society_type`;
CREATE TABLE `t_society_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `sort` int(2) DEFAULT NULL,
  `status` int(1) DEFAULT '0' COMMENT '0正常',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='社区类型';

-- ----------------------------
-- Records of t_society_type
-- ----------------------------
INSERT INTO `t_society_type` VALUES ('1', '性趣', '1', '0', '2016-01-23 00:21:05', '2016-12-08 01:06:35');
INSERT INTO `t_society_type` VALUES ('2', '情感', '2', '0', '2016-01-23 00:22:18', '2016-12-08 01:06:36');
INSERT INTO `t_society_type` VALUES ('3', '健康', '3', '0', '2016-01-23 00:24:59', '2016-12-08 01:06:37');
INSERT INTO `t_society_type` VALUES ('4', '生活', '4', '0', '2016-01-23 00:24:59', '2016-12-08 01:06:38');
INSERT INTO `t_society_type` VALUES ('5', '兴趣', '5', '0', '2016-01-23 00:24:59', '2016-12-08 01:06:39');
INSERT INTO `t_society_type` VALUES ('6', '自拍', '6', '0', '2016-01-23 00:24:59', '2016-12-08 01:06:40');

-- ----------------------------
-- Table structure for t_system_config
-- ----------------------------
DROP TABLE IF EXISTS `t_system_config`;
CREATE TABLE `t_system_config` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '参数名',
  `code` varchar(128) DEFAULT NULL COMMENT '参数代码',
  `val` text COMMENT '参数值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='系统消息';

-- ----------------------------
-- Records of t_system_config
-- ----------------------------
INSERT INTO `t_system_config` VALUES ('1', '客服电话', 'customer_telephone', '400-8000000', null, '2016-10-11 23:22:52', '2016-11-18 00:34:42');
INSERT INTO `t_system_config` VALUES ('2', '关于我们', 'about_us', '深圳技术股份有限公司，成立于2016年，是一家专业的互联网研发与运营创业公司。\r\n我们并不是简单地贩卖“成人玩具”，而是让情趣体验和感官享受到达全新的维度，以确保你的每一次情趣体验都能最大程度获得充盈的享受。我们乐于将这种情趣交到您的双手之中。\r\n将情趣脱离低俗品味，颠覆世俗偏见。我们开创一个更健康、更有趣的情趣世界。快感的种类与深浅时而千变万化，我们用玩具探索身体，用道具表达情趣。\r\n发展至今，App的激活用户超过 3000 万，除了致力于打造时尚情趣APP品牌外，他趣正为国人的两性文化而努力，每一次的深入浅出的两性对话，都能绵延至世界的尽头。未来邀你一起参与。\r\n		  ', null, '2016-10-11 23:22:52', '2016-10-15 04:59:45');
INSERT INTO `t_system_config` VALUES ('3', '发送包裹', 'jpush_pack_running', '{0}云展厅通知：您的尾号{1}的账户，您的快递{2}{3}，请您查看包裹内货品详情并注意签收。如有疑问请致电400-8888-235', null, '2016-10-11 23:22:52', '2016-10-15 04:59:47');
INSERT INTO `t_system_config` VALUES ('4', '客服中心', 'customer_center', '客服联系电话：400324324<br>客服QQ：787897979', null, '2016-10-11 23:22:52', '2016-10-15 04:59:49');
INSERT INTO `t_system_config` VALUES ('5', '红包规则', 'red_money_rule', '使用说明：<br>红包规则', null, '2016-10-11 23:22:52', '2016-10-15 04:59:52');
INSERT INTO `t_system_config` VALUES ('6', '系统货币规则', 'money_rule', '使用说明：<br>系统货币规则', null, '2016-10-11 23:22:52', '2016-10-15 04:59:51');
INSERT INTO `t_system_config` VALUES ('7', '积分规则', 'point_rule', '使用说明：<br>积分规则', null, '1979-01-01 01:00:00', '2016-10-15 05:36:52');

-- ----------------------------
-- Table structure for t_system_msg
-- ----------------------------
DROP TABLE IF EXISTS `t_system_msg`;
CREATE TABLE `t_system_msg` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL COMMENT '发送方0是系统',
  `content` varchar(225) DEFAULT NULL COMMENT '内容',
  `type` int(4) DEFAULT '1' COMMENT '消息类型1系统通知',
  `read_is` int(1) DEFAULT '0' COMMENT '是否已读0未读，1已读',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统消息';

-- ----------------------------
-- Records of t_system_msg
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `account` varchar(64) NOT NULL COMMENT '账号',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `exp` int(10) DEFAULT '0' COMMENT '社区经验',
  `level` int(4) DEFAULT '0' COMMENT '社区级别',
  `sign` varchar(50) DEFAULT NULL COMMENT '个性签名',
  `head` varchar(225) DEFAULT NULL COMMENT '头像',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `email_is` int(1) DEFAULT '0' COMMENT '是否已认证(0否,1是)',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `phone_is` int(1) DEFAULT '0' COMMENT '是否已认证(0否,1是)',
  `age` varchar(12) DEFAULT NULL COMMENT '年龄（出生年月）',
  `sex` int(1) DEFAULT '1' COMMENT '性别(1男，2女)',
  `sexu` int(1) DEFAULT NULL COMMENT '性取向(1爱好男，2爱好女，3双性恋，4无性恋，5保密)',
  `marr` int(1) DEFAULT NULL COMMENT '婚恋状态(1单身，2恋爱中，3已婚，4离异)',
  `try_is` int(1) DEFAULT '0' COMMENT '是否是体验师',
  `type` int(1) DEFAULT '1' COMMENT '用户类型，1普通，2小编',
  `status` int(1) DEFAULT '1' COMMENT '状态(0未激活,1正常，2被锁定，3被拉黑)',
  `from` varchar(50) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`),
  UNIQUE KEY `email` (`email`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '遗城落梦', 'luke', 'd9b1d7db4cd6e70935368a1efb10e377', '32', '1', '不要迷恋锅 、锅只是个炒饭的。', 'http://up.qqjia.com/z/26/tu32812_6.jpg', '361681251@qq.com', '0', '18666668629', '0', null, '2', '1', null, '0', '1', '1', null, null, '2017-01-12 01:05:45', '2015-12-25 00:56:16');
INSERT INTO `t_user` VALUES ('2', '若放弃，请彻底', '345', '14e1b600b1fd579f47433b88e8d85291', '65', '2', '那个人，是我心中的一片海。', 'http://up.qqjia.com/z/26/tu32812_1.jpg', '15920579059@139.com', '0', '15920579059', '0', null, '1', '2', null, '0', '1', '1', null, null, '2017-01-12 01:08:38', '2015-12-25 00:56:16');
INSERT INTO `t_user` VALUES ('3', '缘尽了′情淡了', 'kuke', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '3', '时间永远不会停留，停留的只会是记忆 ', 'http://up.qqjia.com/z/26/tu32812_2.jpg', null, '0', null, '0', null, '2', null, null, '0', '1', '1', null, null, '2017-01-12 01:08:39', '1979-01-01 01:00:00');
INSERT INTO `t_user` VALUES ('4', '浅唱灬幸福', 'huangting', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '4', '弱水三千只取一瓢  ||  世界之大只想要你', 'http://up.qqjia.com/z/26/tu32812_3.jpg', null, '0', null, '0', null, '1', null, null, '0', '1', '1', null, null, '2017-01-12 01:08:39', '1979-01-01 01:00:00');
INSERT INTO `t_user` VALUES ('5', '入她城、占她心', 'moren', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '5', '装逼引领时尚，犯贱成就梦想', 'http://up.qqjia.com/z/26/tu32812_4.jpg', null, '0', null, '0', null, '2', null, null, '0', '1', '1', null, null, '2017-01-12 01:08:40', '1979-01-01 01:00:00');
INSERT INTO `t_user` VALUES ('6', '╰追忆°似水流年', 'jiandan', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '6', '心脏，我跟她表白你激动个毛啊！', 'http://up.qqjia.com/z/26/tu32812_5.jpg', null, '0', null, '0', null, '1', null, null, '0', '1', '1', null, null, '2017-01-12 01:08:41', '1979-01-01 01:00:00');
INSERT INTO `t_user` VALUES ('7', '无爱无伤,无欲则刚', 'kele', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '7', '人生没有彩排，每天都是直播，不仅收视率低，而且工资不高。', 'http://up.qqjia.com/z/26/tu32812_6.jpg', null, '0', null, '0', null, '2', null, null, '0', '1', '1', null, null, '2017-01-12 01:08:41', '1979-01-01 01:00:00');
INSERT INTO `t_user` VALUES ('8', '爱是毒', 'moren1', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '8', '沵可知道,沵的一举一动牵动着峩的心跳', 'http://up.qqjia.com/z/26/tu32812_7.jpg', null, '0', null, '0', null, '1', null, null, '0', '1', '1', null, null, '2017-01-12 01:08:44', '1979-01-01 01:00:00');
INSERT INTO `t_user` VALUES ('9', '格桑花开', 'jiandan1', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '9', '时钟走着走着的会累！何况是一颗心?', 'http://up.qqjia.com/z/26/tu32812_8.jpg', null, '0', null, '0', null, '2', null, null, '0', '1', '1', null, null, '2017-01-12 01:08:47', '1979-01-01 01:00:00');
INSERT INTO `t_user` VALUES ('10', '胸小随我爸', 'kele1', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '10', '我们现在的状态、是分手前的最后的矜持。', 'http://up.qqjia.com/z/26/tu32812_9.jpg', null, '0', null, '0', null, '1', null, null, '0', '1', '1', null, null, '2017-01-12 01:08:50', '1979-01-01 01:00:00');
INSERT INTO `t_user` VALUES ('11', '吃樱桃的小丸子', 'moren2', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '11', '你娶或不娶我我都在这里允你一生。  ||  你嫁或不嫁我我都在那里诺你一世。', 'http://up.qqjia.com/z/26/tu32812_10.jpg', null, '0', null, '0', null, '2', null, null, '0', '1', '1', null, null, '2017-01-12 01:08:51', '1979-01-01 01:00:00');
INSERT INTO `t_user` VALUES ('12', '空人空心空回忆', 'jiandan2', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '12', '明明知道你不爱我,可我却不顾一切的爱你***', 'http://up.qqjia.com/z/26/tu32812_11.jpg', null, '0', null, '0', null, '1', null, null, '0', '1', '1', null, null, '2017-01-12 01:08:52', '1979-01-01 01:00:00');
INSERT INTO `t_user` VALUES ('13', '失心的骚年', 'kele2', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '13', '十年前我们期待青春，现在，或许是我们致青春的时候了。\r\n', 'http://up.qqjia.com/z/26/tu32812_12.jpg', null, '0', null, '0', null, '2', null, null, '0', '1', '1', null, null, '2017-01-12 01:08:55', '1979-01-01 01:00:00');
INSERT INTO `t_user` VALUES ('14', '似水流年', 'moren12', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '14', '一句话唤起了我对你的全部思念，原来我还是如此懦弱。\r\n', 'http://up.qqjia.com/z/26/tu32812_13.jpg', null, '0', null, '0', null, '1', null, null, '0', '1', '1', null, null, '2017-01-12 01:08:57', '1979-01-01 01:00:00');
INSERT INTO `t_user` VALUES ('15', '╰追忆°', 'jiandan12', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '15', '    ', 'http://up.qqjia.com/z/26/tu32812_14.jpg', null, '0', null, '0', null, '2', null, null, '0', '1', '1', null, null, '2017-01-12 01:08:59', '1979-01-01 01:00:00');
INSERT INTO `t_user` VALUES ('16', '浅唱灬幸福', 'kele12', 'd9b1d7db4cd6e70935368a1efb10e377', '0', '16', '初一羡慕初二的旅游、初二羡慕初三的暑假、初三羡慕初一的青春。\r\n', 'http://up.qqjia.com/z/26/tu32812_15.jpg', null, '0', null, '0', null, '1', null, null, '0', '1', '1', null, null, '2017-01-12 01:09:00', '1979-01-01 01:00:00');

-- ----------------------------
-- Table structure for t_user_address
-- ----------------------------
DROP TABLE IF EXISTS `t_user_address`;
CREATE TABLE `t_user_address` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户地址ID',
  `user_id` int(10) NOT NULL COMMENT '用户ID',
  `user_name` varchar(64) DEFAULT NULL,
  `phone` varchar(15) NOT NULL COMMENT '电话号码',
  `province_name` varchar(50) DEFAULT NULL COMMENT '省名称',
  `province_code` varchar(50) DEFAULT NULL COMMENT '省ID',
  `city_name` varchar(50) DEFAULT NULL COMMENT '市名称',
  `city_code` varchar(50) DEFAULT NULL COMMENT '市ID',
  `region_code` varchar(50) DEFAULT NULL COMMENT '区ID',
  `region_name` varchar(50) DEFAULT NULL COMMENT '区名称',
  `road` varchar(255) DEFAULT NULL COMMENT '街道',
  `zipcode` int(10) DEFAULT NULL COMMENT '邮编',
  `default_is` int(1) DEFAULT '0' COMMENT '是否是默认地址',
  `status` int(1) DEFAULT '1' COMMENT '状态(1正常，2删除)',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户地址';

-- ----------------------------
-- Records of t_user_address
-- ----------------------------
INSERT INTO `t_user_address` VALUES ('1', '1', '谭辉', '15920579059', '广东省', '440000', '深圳市', '440300', '440303', '罗湖区', '黄贝岭街道经二路龙景花园芳庭苑', '430223', '0', '1', '2017-02-17 01:11:02', '1979-01-01 01:00:00');
INSERT INTO `t_user_address` VALUES ('2', '1', '青蛙王子', '18666668629', '湖南省', '430000', '株洲市', '430200', '430223', '攸县', '菜花坪东南村', '51800', '1', '1', '2017-02-17 01:11:03', '1979-01-01 01:00:00');

-- ----------------------------
-- Table structure for t_user_atte
-- ----------------------------
DROP TABLE IF EXISTS `t_user_atte`;
CREATE TABLE `t_user_atte` (
  `user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
  `atte_user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '好友ID',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`user_id`,`atte_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关注';

-- ----------------------------
-- Records of t_user_atte
-- ----------------------------
INSERT INTO `t_user_atte` VALUES ('1', '2', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('1', '3', '2016-12-10 01:14:03');
INSERT INTO `t_user_atte` VALUES ('1', '4', '2016-12-08 00:33:38');
INSERT INTO `t_user_atte` VALUES ('1', '5', '2016-12-10 01:14:13');
INSERT INTO `t_user_atte` VALUES ('1', '6', '2016-12-10 01:14:10');
INSERT INTO `t_user_atte` VALUES ('1', '7', '2016-12-08 00:35:12');
INSERT INTO `t_user_atte` VALUES ('1', '8', '2016-12-10 01:13:49');
INSERT INTO `t_user_atte` VALUES ('1', '10', '2016-12-10 01:13:54');
INSERT INTO `t_user_atte` VALUES ('1', '11', '2016-12-10 01:13:40');
INSERT INTO `t_user_atte` VALUES ('1', '12', '2016-12-10 01:14:06');
INSERT INTO `t_user_atte` VALUES ('1', '13', '2016-12-10 01:13:51');
INSERT INTO `t_user_atte` VALUES ('1', '16', '2016-12-10 01:13:46');
INSERT INTO `t_user_atte` VALUES ('2', '1', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('2', '3', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('3', '1', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('3', '2', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('5', '1', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('5', '2', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('5', '3', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('5', '4', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('5', '6', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('5', '7', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('5', '8', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('5', '9', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('6', '1', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('6', '2', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('6', '3', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('6', '4', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('6', '6', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('6', '7', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('6', '8', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('6', '9', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('7', '1', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('7', '2', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('7', '3', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('7', '4', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('7', '6', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('7', '7', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('7', '8', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('7', '9', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('8', '1', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('8', '2', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('8', '3', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('8', '4', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('8', '6', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('8', '7', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('8', '8', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('8', '9', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('9', '1', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('9', '2', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('9', '3', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('9', '4', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('9', '6', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('9', '7', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('9', '8', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('9', '10', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('10', '1', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('10', '2', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('10', '3', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('10', '4', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('10', '6', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('10', '7', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('10', '8', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('10', '9', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('11', '1', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('11', '2', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('11', '3', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('11', '4', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('11', '6', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('11', '7', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('11', '8', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('11', '9', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('12', '1', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('12', '2', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('12', '3', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('12', '4', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('12', '6', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('12', '7', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('12', '8', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('12', '9', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('13', '1', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('13', '2', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('13', '3', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('13', '4', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('13', '6', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('13', '7', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('13', '8', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('13', '9', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '1', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '2', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '3', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '4', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '6', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '7', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '8', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '9', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '10', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '11', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '12', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '13', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '14', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '15', '1979-01-01 01:00:00');
INSERT INTO `t_user_atte` VALUES ('14', '16', '1979-01-01 01:00:00');

-- ----------------------------
-- Table structure for t_user_basis
-- ----------------------------
DROP TABLE IF EXISTS `t_user_basis`;
CREATE TABLE `t_user_basis` (
  `id` int(11) NOT NULL COMMENT '用户ID关联t_user.id',
  `virtual_money` decimal(11,2) DEFAULT '0.00' COMMENT '虚拟币(逗币)',
  `money` decimal(11,2) DEFAULT '0.00' COMMENT '账户余额',
  `point` int(11) DEFAULT '0' COMMENT '商城积分',
  `exp` int(11) DEFAULT '0' COMMENT '社区经验',
  `level` int(4) DEFAULT '0' COMMENT '社区级别',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁版本号',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_basis
-- ----------------------------
INSERT INTO `t_user_basis` VALUES ('1', '56.00', '12.00', '75', '32', '1', null, '2016-12-10 00:47:07');
INSERT INTO `t_user_basis` VALUES ('2', '12.00', '87.00', '34', '65', '5', null, '2016-12-10 00:36:52');
INSERT INTO `t_user_basis` VALUES ('3', '0.00', '2.00', '0', '0', '0', null, '2017-08-07 11:49:54');
INSERT INTO `t_user_basis` VALUES ('4', '0.00', '0.00', '0', '0', '0', null, '2016-12-10 01:11:37');
INSERT INTO `t_user_basis` VALUES ('5', '0.00', '0.00', '0', '0', '0', null, '2016-12-10 00:37:36');
INSERT INTO `t_user_basis` VALUES ('6', '0.00', '0.00', '0', '0', '0', null, '2016-12-10 01:11:28');
INSERT INTO `t_user_basis` VALUES ('7', '0.00', '0.00', '0', '0', '0', null, '2016-12-10 01:11:50');
INSERT INTO `t_user_basis` VALUES ('8', '0.00', '0.00', '0', '0', '0', null, '2016-12-10 00:38:04');
INSERT INTO `t_user_basis` VALUES ('9', '0.00', '0.00', '0', '0', '0', null, '2016-12-10 01:13:12');
INSERT INTO `t_user_basis` VALUES ('10', '0.00', '0.00', '0', '0', '0', null, '2016-12-10 01:10:59');
INSERT INTO `t_user_basis` VALUES ('11', '0.00', '0.00', '0', '0', '0', null, '2016-12-10 01:11:09');
INSERT INTO `t_user_basis` VALUES ('12', '0.00', '0.00', '0', '0', '0', null, '2016-12-10 01:11:16');
INSERT INTO `t_user_basis` VALUES ('13', '0.00', '0.00', '0', '0', '0', null, '2016-12-10 00:38:51');
INSERT INTO `t_user_basis` VALUES ('14', '0.00', '0.00', '0', '0', '0', null, '2016-12-10 01:12:05');
INSERT INTO `t_user_basis` VALUES ('15', '0.00', '0.00', '0', '0', '0', null, '2016-12-10 01:18:01');
INSERT INTO `t_user_basis` VALUES ('16', '0.00', '0.00', '0', '0', '0', null, '2016-12-10 00:39:12');

-- ----------------------------
-- Table structure for t_user_friend
-- ----------------------------
DROP TABLE IF EXISTS `t_user_friend`;
CREATE TABLE `t_user_friend` (
  `user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
  `friend_user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '好友ID',
  `type` int(4) unsigned NOT NULL DEFAULT '1' COMMENT '类型（1：好友申请，2：好友，3陌生人）',
  `friend_user_name` varchar(50) DEFAULT NULL COMMENT '好友名字',
  `friend_user_head` varchar(300) DEFAULT NULL COMMENT '好友经理头像',
  `friend_user_level` int(3) unsigned DEFAULT '0' COMMENT '好友等级',
  `friend_money` int(10) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`user_id`,`friend_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户的朋友';

-- ----------------------------
-- Records of t_user_friend
-- ----------------------------
INSERT INTO `t_user_friend` VALUES ('1', '5', '2', null, null, '0', null, '2016-12-03 12:42:13', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('1', '6', '2', null, null, '0', null, '2016-12-03 12:45:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('2', '1', '2', null, null, '0', null, '2016-12-03 12:45:58', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('2', '3', '2', null, null, '0', null, '2016-12-03 12:46:01', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('2', '4', '2', null, null, '0', null, '2016-12-03 12:46:02', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('2', '5', '2', null, null, '0', null, '2016-12-03 12:46:04', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('2', '6', '2', null, null, '0', null, '2016-12-03 12:46:06', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('3', '1', '2', null, null, '0', null, '2016-12-03 12:45:55', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('5', '3', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('5', '4', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('5', '6', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('5', '7', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('5', '8', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('5', '9', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('6', '1', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('6', '2', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('6', '3', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('6', '4', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('6', '6', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('6', '7', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('6', '8', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('6', '9', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('7', '1', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('7', '2', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('7', '3', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('7', '4', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('7', '6', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('7', '7', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('7', '8', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('7', '9', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('8', '1', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('8', '2', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('8', '3', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('8', '4', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('8', '6', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('8', '7', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('8', '8', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('8', '9', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('9', '1', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('9', '2', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('9', '3', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('9', '4', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('9', '6', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('9', '7', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('9', '8', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('9', '10', '2', null, null, '0', null, '2016-12-03 13:02:23', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('10', '1', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('10', '2', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('10', '3', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('10', '4', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('10', '6', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('10', '7', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('10', '8', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('10', '9', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('11', '1', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('11', '2', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('11', '3', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('11', '4', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('11', '6', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('11', '7', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('11', '8', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('11', '9', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('12', '1', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('12', '2', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('12', '3', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('12', '4', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('12', '6', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('12', '7', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('12', '8', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('12', '9', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('13', '1', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('13', '2', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('13', '3', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('13', '4', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('13', '6', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('13', '7', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('13', '8', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('13', '9', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '1', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '2', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '3', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '4', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '6', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '7', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '8', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '9', '2', null, null, '0', null, '2016-12-03 13:03:53', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '10', '2', null, null, '0', null, '2016-12-04 15:12:45', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '11', '2', null, null, '0', null, '2016-12-04 15:12:46', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '12', '2', null, null, '0', null, '2016-12-04 15:12:46', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '13', '2', null, null, '0', null, '2016-12-04 15:12:47', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '15', '2', null, null, '0', null, '2016-12-04 15:12:48', '1979-01-01 01:00:00');
INSERT INTO `t_user_friend` VALUES ('14', '16', '2', null, null, '0', null, '2016-12-04 15:12:49', '1979-01-01 01:00:00');

-- ----------------------------
-- Table structure for t_user_keep
-- ----------------------------
DROP TABLE IF EXISTS `t_user_keep`;
CREATE TABLE `t_user_keep` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `obj_id` int(11) DEFAULT NULL COMMENT '收藏ID(商品，帖子)',
  `obj_type` int(4) DEFAULT NULL COMMENT '类型ID',
  `obj_type_name` varchar(64) DEFAULT NULL COMMENT '类型名称',
  `type` int(1) DEFAULT NULL COMMENT '类型(1商品，2贴子)',
  `name` varchar(225) DEFAULT NULL COMMENT '名称',
  `img_url` varchar(225) DEFAULT NULL COMMENT '图片地址',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8 COMMENT='用户的收藏';

-- ----------------------------
-- Records of t_user_keep
-- ----------------------------
INSERT INTO `t_user_keep` VALUES ('127', '1', '10011', null, null, '1', '性感日式印花和服宽松深V蝴蝶结复古和服风东京美娘款', 'http://mallimg01.touchcdn.com/goods-gallery/0e65fea48479e7da41432b9bb774bca0.jpg?imageView/2/w/416/interlace/1', '29.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('128', '1', '10012', null, null, '1', '古典高档绣花年年有鱼喜庆露乳性感肚兜 2件套', 'http://mallimg01.touchcdn.com/goods-gallery/b75134196cccd1a6fc88c1bfe2627b43.jpg?imageView/2/w/416/interlace/1', '25.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('129', '1', '10013', null, null, '1', '日式和服开襟三点式绑带缎面印花和服套装 3件套', 'http://mallimg01.touchcdn.com/goods-gallery/625edf645a7c9e04ff8ef24555eb3179.jpg?imageView/2/w/416/interlace/1', '39.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('131', '1', '10015', null, null, '1', 'EVO二代加温火焰无线充电遥控加热恒温跳蛋', 'http://mallimg01.touchcdn.com/goods-gallery/cb5c8464c08fea2958a9a44fb6378585.jpg?imageView/2/w/416/interlace/1', '168.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('133', '1', '10017', null, null, '1', '【包邮】品色伸缩转珠震动按摩AV棒', 'http://mallimg01.touchcdn.com/goods-gallery/0ff07592e560f8d86f35486eeda10e63.jpg?imageView/2/w/416/interlace/1', '79.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('137', '1', '10021', null, null, '1', '【买1送2】护士装 深V紧身性感大露背小护士装制服扮演', 'http://mallimg01.touchcdn.com/goods-gallery/c60834843534de6135db5dd35caf4366.jpg?imageView/2/w/416/interlace/1', '19.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('138', '1', '10022', null, null, '1', '【买1送2】中国风古典蕾丝柔纱透明旗袍 新婚制服扮演性感睡衣', 'http://mallimg01.touchcdn.com/goods-gallery/73688eac2b67ef212af124bf52bcbbf4.jpg?imageView/2/w/416/interlace/1', '29.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('139', '1', '10023', null, null, '1', '【包邮】私享玩趣 桑巴丽影 强力变频防水静音跳蛋', 'http://mallimg01.touchcdn.com/goods-gallery/22c56205dc707ef0c4d5505dddc07f79.jpg?imageView/2/w/416/interlace/1', '65.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('140', '1', '10024', null, null, '1', '诺兰摇情AV棒 高潮静音震动按摩振动棒充电款', 'http://mallimg01.touchcdn.com/goods-gallery/89ba5d2dd2fa7cadf603db8feb06a79b.jpg?imageView/2/w/416/interlace/1', '178.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('141', '1', '10025', null, null, '1', '艾丝葵 甜蜜习惯 蕾丝刺绣透明网眼丁字开档绑带T裤内裤', 'http://mallimg01.touchcdn.com/goods-gallery/130b27b5d38de9d9c1017ed56d02dae7.jpg?imageView/2/w/416/interlace/1', '29.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('142', '1', '10026', null, null, '1', '针筒式灌肠器 肛门灌肠清洗器 SM调教后庭用品', 'http://mallimg01.touchcdn.com/goods-gallery/c294f52da9a6e0340fa7b5b867bd717b.jpg?imageView/2/w/416/interlace/1', '19.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('143', '1', '10027', null, null, '1', '荷兰COB女优签名版震动飞机杯', 'http://mallimg01.touchcdn.com/goods-gallery/dbdbae49f7d87854578c4cf52f0e5ffd.jpg?imageView/2/w/416/interlace/1', '99.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('144', '1', '10028', null, null, '1', '诺兰美人鱼蓝牙智能语音震动深喉飞机杯口交版', 'http://mallimg01.touchcdn.com/goods-gallery/4704fb20bc7dae5fe74a1e063fca4556.jpg?imageView/2/w/416/interlace/1', '499.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('145', '1', '10029', null, null, '1', 'AV女优17岁少女小萝莉双姐妹名器倒模', 'http://mallimg01.touchcdn.com/goods-gallery/2bb05b248e64ce3c79d3537bba3f26e3.jpg?imageView/2/w/416/interlace/1', '39.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('147', '1', '10031', null, null, '1', '丝质格纹开档提花连身袜 两色 selebritee', 'http://mallimg01.touchcdn.com/goods-gallery/02f98b01062aeab43ed3016039ca578c.jpg?imageView/2/w/416/interlace/1', '49.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('148', '1', '10032', null, null, '1', '【包邮】杜蕾斯经典四合一 24只装避孕套', 'http://mallimg01.touchcdn.com/goods-gallery/be760b80bcd4067931b8ce7d4f5430f9.jpg?imageView/2/w/416/interlace/1', '39.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('149', '1', '10033', null, null, '1', '【新品】LULU 噜噜 003超薄避孕套 热感激情装12只', 'http://mallimg01.touchcdn.com/goods-gallery/f6031e0efdb9d15cbacb07b572a77073.jpg?imageView/2/w/416/interlace/1', '29.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('152', '1', '1', '7', '情趣研究所', '2', '发上来的积分楼上的', null, null, '1979-01-01 01:00:00', '2016-09-18 01:21:25');
INSERT INTO `t_user_keep` VALUES ('155', '1', '10030', null, null, '1', '性感露乳露背 网纱透明裸色花仙子女仆装', 'http://mallimg01.touchcdn.com/goods-gallery/49984b72781c0d0b1b18c89ee318d07b.jpg?imageView/2/w/416/interlace/1', '59.00', '2016-10-25 01:19:54', '2016-10-25 01:19:54');
INSERT INTO `t_user_keep` VALUES ('161', '1', '10001', null, null, '1', '霏慕 中国古典肚兜性感挂脖绑带情趣诱惑肚兜T裤 2件套', 'http://mallimg01.touchcdn.com/goods-gallery/866976864088af42f9014313d06bbf77.jpg?imageView/2/w/416/interlace/1', '19.00', '2016-10-31 01:08:04', '2016-10-31 01:08:04');
INSERT INTO `t_user_keep` VALUES ('165', '1', '10011', null, null, '1', '性感日式印花和服宽松深V蝴蝶结复古和服风东京美娘款', 'http://mallimg01.touchcdn.com/goods-gallery/0e65fea48479e7da41432b9bb774bca0.jpg?imageView/2/w/416/interlace/1', '29.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('166', '1', '10012', null, null, '1', '古典高档绣花年年有鱼喜庆露乳性感肚兜 2件套', 'http://mallimg01.touchcdn.com/goods-gallery/b75134196cccd1a6fc88c1bfe2627b43.jpg?imageView/2/w/416/interlace/1', '25.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('167', '1', '10013', null, null, '1', '日式和服开襟三点式绑带缎面印花和服套装 3件套', 'http://mallimg01.touchcdn.com/goods-gallery/625edf645a7c9e04ff8ef24555eb3179.jpg?imageView/2/w/416/interlace/1', '39.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('168', '1', '10015', null, null, '1', 'EVO二代加温火焰无线充电遥控加热恒温跳蛋', 'http://mallimg01.touchcdn.com/goods-gallery/cb5c8464c08fea2958a9a44fb6378585.jpg?imageView/2/w/416/interlace/1', '168.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('169', '1', '10017', null, null, '1', '【包邮】品色伸缩转珠震动按摩AV棒', 'http://mallimg01.touchcdn.com/goods-gallery/0ff07592e560f8d86f35486eeda10e63.jpg?imageView/2/w/416/interlace/1', '79.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('170', '1', '10021', null, null, '1', '【买1送2】护士装 深V紧身性感大露背小护士装制服扮演', 'http://mallimg01.touchcdn.com/goods-gallery/c60834843534de6135db5dd35caf4366.jpg?imageView/2/w/416/interlace/1', '19.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('171', '1', '10022', null, null, '1', '【买1送2】中国风古典蕾丝柔纱透明旗袍 新婚制服扮演性感睡衣', 'http://mallimg01.touchcdn.com/goods-gallery/73688eac2b67ef212af124bf52bcbbf4.jpg?imageView/2/w/416/interlace/1', '29.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('172', '1', '10023', null, null, '1', '【包邮】私享玩趣 桑巴丽影 强力变频防水静音跳蛋', 'http://mallimg01.touchcdn.com/goods-gallery/22c56205dc707ef0c4d5505dddc07f79.jpg?imageView/2/w/416/interlace/1', '65.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('173', '1', '10024', null, null, '1', '诺兰摇情AV棒 高潮静音震动按摩振动棒充电款', 'http://mallimg01.touchcdn.com/goods-gallery/89ba5d2dd2fa7cadf603db8feb06a79b.jpg?imageView/2/w/416/interlace/1', '178.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('174', '1', '10025', null, null, '1', '艾丝葵 甜蜜习惯 蕾丝刺绣透明网眼丁字开档绑带T裤内裤', 'http://mallimg01.touchcdn.com/goods-gallery/130b27b5d38de9d9c1017ed56d02dae7.jpg?imageView/2/w/416/interlace/1', '29.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('175', '1', '10026', null, null, '1', '针筒式灌肠器 肛门灌肠清洗器 SM调教后庭用品', 'http://mallimg01.touchcdn.com/goods-gallery/c294f52da9a6e0340fa7b5b867bd717b.jpg?imageView/2/w/416/interlace/1', '19.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('176', '1', '10027', null, null, '1', '荷兰COB女优签名版震动飞机杯', 'http://mallimg01.touchcdn.com/goods-gallery/dbdbae49f7d87854578c4cf52f0e5ffd.jpg?imageView/2/w/416/interlace/1', '99.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('177', '1', '10028', null, null, '1', '诺兰美人鱼蓝牙智能语音震动深喉飞机杯口交版', 'http://mallimg01.touchcdn.com/goods-gallery/4704fb20bc7dae5fe74a1e063fca4556.jpg?imageView/2/w/416/interlace/1', '499.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('178', '1', '10029', null, null, '1', 'AV女优17岁少女小萝莉双姐妹名器倒模', 'http://mallimg01.touchcdn.com/goods-gallery/2bb05b248e64ce3c79d3537bba3f26e3.jpg?imageView/2/w/416/interlace/1', '39.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('179', '1', '10031', null, null, '1', '丝质格纹开档提花连身袜 两色 selebritee', 'http://mallimg01.touchcdn.com/goods-gallery/02f98b01062aeab43ed3016039ca578c.jpg?imageView/2/w/416/interlace/1', '49.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('180', '1', '10032', null, null, '1', '【包邮】杜蕾斯经典四合一 24只装避孕套', 'http://mallimg01.touchcdn.com/goods-gallery/be760b80bcd4067931b8ce7d4f5430f9.jpg?imageView/2/w/416/interlace/1', '39.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('181', '1', '10033', null, null, '1', '【新品】LULU 噜噜 003超薄避孕套 热感激情装12只', 'http://mallimg01.touchcdn.com/goods-gallery/f6031e0efdb9d15cbacb07b572a77073.jpg?imageView/2/w/416/interlace/1', '29.00', '1979-01-01 01:00:00', '1979-01-01 01:00:00');
INSERT INTO `t_user_keep` VALUES ('182', '1', '10030', null, null, '1', '性感露乳露背 网纱透明裸色花仙子女仆装', 'http://mallimg01.touchcdn.com/goods-gallery/49984b72781c0d0b1b18c89ee318d07b.jpg?imageView/2/w/416/interlace/1', '59.00', '2016-10-25 01:19:54', '2016-10-25 01:19:54');
INSERT INTO `t_user_keep` VALUES ('183', '1', '10001', null, null, '1', '霏慕 中国古典肚兜性感挂脖绑带情趣诱惑肚兜T裤 2件套', 'http://mallimg01.touchcdn.com/goods-gallery/866976864088af42f9014313d06bbf77.jpg?imageView/2/w/416/interlace/1', '19.00', '2016-10-31 01:08:04', '2016-10-31 01:08:04');
INSERT INTO `t_user_keep` VALUES ('186', '1', '10019', null, null, '1', '【买1送2】纯情女仆女佣装分体露乳制服 3件套', 'http://mallimg01.touchcdn.com/goods-gallery/2b4634844cbac41c89cb3d6d60f2e96b.jpg?imageView/2/w/416/interlace/1', '35.00', '2017-02-04 01:22:11', '2017-02-04 01:22:11');

-- ----------------------------
-- Table structure for t_user_msg
-- ----------------------------
DROP TABLE IF EXISTS `t_user_msg`;
CREATE TABLE `t_user_msg` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL COMMENT '发送方0是客服',
  `receive_user_id` int(10) NOT NULL COMMENT '接收消息放',
  `content` varchar(225) DEFAULT NULL COMMENT '内容',
  `type` int(4) DEFAULT '1' COMMENT '消息类型1聊天，2礼物，3逗币',
  `val_num` int(10) DEFAULT '0' COMMENT '价值数量',
  `read_is` int(1) DEFAULT '0' COMMENT '是否已读(0未读，1已读)',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户聊天记录，用户id分表 注意分表';

-- ----------------------------
-- Records of t_user_msg
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_ranking
-- ----------------------------
DROP TABLE IF EXISTS `t_user_ranking`;
CREATE TABLE `t_user_ranking` (
  `id` int(10) NOT NULL COMMENT '用户ID关联t_user.id',
  `play_reward` decimal(10,2) DEFAULT '0.00' COMMENT '打赏周',
  `play_reward_total` decimal(10,2) DEFAULT '0.00' COMMENT '打赏总',
  `play_reward_rank` int(10) DEFAULT '0' COMMENT '打赏排名',
  `get_reward` decimal(10,2) DEFAULT '0.00' COMMENT '获得奖励总',
  `get_reward_total` decimal(10,2) DEFAULT '0.00' COMMENT '账户余额',
  `get_reward_rank` int(10) DEFAULT '0' COMMENT '商城积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_ranking
-- ----------------------------
INSERT INTO `t_user_ranking` VALUES ('1', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('2', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('3', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('4', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('5', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('6', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('7', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('8', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('9', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('10', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('11', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('12', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('13', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('14', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('15', '0.00', '0.00', '0', '0.00', '0.00', '0');
INSERT INTO `t_user_ranking` VALUES ('16', '0.00', '0.00', '0', '0.00', '0.00', '0');

-- ----------------------------
-- Table structure for t_user_rec
-- ----------------------------
DROP TABLE IF EXISTS `t_user_rec`;
CREATE TABLE `t_user_rec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL DEFAULT '0' COMMENT '用户id',
  `rec_user_id` int(10) NOT NULL DEFAULT '0',
  `rec_user_name` varchar(20) DEFAULT NULL,
  `award_type` int(1) DEFAULT '1' COMMENT '奖励类型（1逗币）',
  `award_num` int(4) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='注册用户推荐奖励';

-- ----------------------------
-- Records of t_user_rec
-- ----------------------------
INSERT INTO `t_user_rec` VALUES ('1', '0', '0', '啊啊啊啊啊啊啊啊啊啊', '1', null, null);

-- ----------------------------
-- Table structure for t_user_session
-- ----------------------------
DROP TABLE IF EXISTS `t_user_session`;
CREATE TABLE `t_user_session` (
  `user_id` int(10) NOT NULL COMMENT '用户Id',
  `token` varchar(128) NOT NULL COMMENT '访问标识',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  KEY `idx_team_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户回话信息';

-- ----------------------------
-- Records of t_user_session
-- ----------------------------
INSERT INTO `t_user_session` VALUES ('1', 'e99c449b590a9fd9de946486b2a83c09', '2016-10-19 00:18:20', '2016-10-19 00:18:20');

-- ----------------------------
-- Table structure for t_user_session_log
-- ----------------------------
DROP TABLE IF EXISTS `t_user_session_log`;
CREATE TABLE `t_user_session_log` (
  `id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL COMMENT '用户Id',
  `token` varchar(128) NOT NULL COMMENT '访问标识',
  `login_ip` varchar(64) DEFAULT NULL COMMENT 'IP',
  `form` int(1) DEFAULT NULL COMMENT '1是ios，2是Android，3是微信，4是pc',
  `type` int(2) unsigned DEFAULT '0' COMMENT '类型[登入：1，登出：2]',
  `unique` varchar(64) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_team_id` (`user_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='登录日志表';

-- ----------------------------
-- Records of t_user_session_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_sign
-- ----------------------------
DROP TABLE IF EXISTS `t_user_sign`;
CREATE TABLE `t_user_sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `sign` varchar(225) DEFAULT NULL COMMENT '个性签名',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户的个性签名记录';

-- ----------------------------
-- Records of t_user_sign
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_soc_msg
-- ----------------------------
DROP TABLE IF EXISTS `t_user_soc_msg`;
CREATE TABLE `t_user_soc_msg` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `society_note_id` int(10) DEFAULT NULL,
  `user_id` int(10) NOT NULL COMMENT '收的',
  `type` int(4) DEFAULT NULL COMMENT '消息类型（1正在审核帖子，2是t帖子审核通过，3是回帖消息）',
  `content` varchar(225) DEFAULT '' COMMENT '内容',
  `create_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '1979-01-01 01:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户社区消息';

-- ----------------------------
-- Records of t_user_soc_msg
-- ----------------------------

-- ----------------------------
-- Table structure for t_version_info
-- ----------------------------
DROP TABLE IF EXISTS `t_version_info`;
CREATE TABLE `t_version_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lowest_version` varchar(50) DEFAULT NULL COMMENT '最低版本',
  `latest_version` varchar(50) DEFAULT NULL COMMENT '最新版本',
  `title` varchar(255) DEFAULT NULL,
  `update_info` varchar(225) DEFAULT NULL COMMENT '更新提示内容',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `sha` varchar(255) DEFAULT NULL COMMENT '文件的SHA-1值',
  `update_url` varchar(256) DEFAULT NULL COMMENT '更新的url',
  `file_size` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL COMMENT '系统类型，platform(平台)，company(商户版)',
  `os_type` varchar(20) DEFAULT NULL COMMENT 'android or ios',
  `enforce` bit(1) DEFAULT b'0' COMMENT '是否强制更新',
  `status` int(1) DEFAULT '1' COMMENT '状态(0,未激活，1激活)',
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='版本信息表';

-- ----------------------------
-- Records of t_version_info
-- ----------------------------
INSERT INTO `t_version_info` VALUES ('13', '25', '24', '我们升级啦', '我们升级啦！功能更强大，操作体验更顺畅！怕您错过，快更新APP吧~', '我们升级啦！功能更强大，操作体验更顺畅！怕您错过，快更新APP吧~', '', 'https://itunes.apple.com/cn/app/zhu-bao-guan-jia/id1217404370?mt=8', null, 'company', 'ios', '', '1', '2017-07-13 20:30:43', '2017-05-25 17:05:03');
INSERT INTO `t_version_info` VALUES ('14', '74', '74', '测试安卓强制下载title', '测试安卓强制下载', '测试安卓强制下载', 'F8AAE0CEECEB281161D3BBE9B2F5FE955D1387D7', 'https://cdn1.honglinktech.com/apk/zbapp-3.2.7-gamma-release_327_xiaomi.apk', null, 'company', 'android', '\0', '1', '2017-07-14 09:56:27', '2017-05-25 17:08:14');

-- ----------------------------
-- Procedure structure for fix_all_wallet_trade_single_flow_record
-- ----------------------------
DROP PROCEDURE IF EXISTS `fix_all_wallet_trade_single_flow_record`;
DELIMITER ;;
CREATE DEFINER=`zbgj`@`%` PROCEDURE `fix_all_wallet_trade_single_flow_record`(OUT out_miss_flow_count INT, OUT out_fixed_flow_count INT, OUT out_msg VARCHAR(128))
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE flow_count int DEFAULT 0;
    DECLARE fixed_flow_count int DEFAULT 0;
    -- 过程变量
    DECLARE var_trade_no VARCHAR(32);
    DECLARE var_function_rcode int;

    -- 异常处理
    -- DECLARE EXIT HANDLER FOR SQLEXCEPTION , SQLWARNING , NOT FOUND ROLLBACK;

    DECLARE cur CURSOR FOR (
      SELECT trade_no
      FROM tbl_wallet_trade
      WHERE trade_no IN (SELECT trade_no
                         FROM tbl_wallet_trade
                         GROUP BY trade_no
                         HAVING count(trade_no) = 1)
    );
    DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;

    -- 查询需要处理的个数
    SELECT count(trade_no) INTO flow_count FROM tbl_wallet_trade WHERE trade_no IN ( SELECT trade_no FROM tbl_wallet_trade GROUP BY trade_no HAVING count(trade_no) = 1);
    SET out_miss_flow_count = flow_count;

    -- 开始
    OPEN cur;
    REPEAT
      SET var_trade_no = null;
      FETCH cur INTO var_trade_no;
      IF var_trade_no is not null THEN
        CALL fix_wallet_trade_single_flow_record(var_trade_no, var_function_rcode);
        SET fixed_flow_count = fixed_flow_count + 1;
        set out_msg = var_trade_no;
      END IF;

    UNTIL done END REPEAT;
    SET out_fixed_flow_count = fixed_flow_count;

  END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for fix_wallet_trade_miss_add_single_record
-- ----------------------------
DROP PROCEDURE IF EXISTS `fix_wallet_trade_miss_add_single_record`;
DELIMITER ;;
CREATE DEFINER=`zbgj`@`%` PROCEDURE `fix_wallet_trade_miss_add_single_record`(
  IN in_user_id int,
  IN in_user_name VARCHAR(32),
  IN in_opposite_id int,
  IN in_opposite_name VARCHAR(32),
  IN in_trade_no varchar(32),
  IN in_oper_type varchar(255),
  IN in_add_money decimal(18,2),
  IN in_reset_money decimal(18,2),
  IN in_roll_in_money decimal(18,2),
  IN in_roll_out_money decimal(18,2),
  IN in_remark varchar(50),
  IN in_relate_exhibition varchar(255),
  OUT out_rcode int
)
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE result_code INTEGER DEFAULT 0;
    -- 过程变量
    DECLARE var_exist int;
    DECLARE var_ending DECIMAL(16,2);
    DECLARE var_type VARCHAR(16);
    DECLARE var_m_add DECIMAL(16,2);
    DECLARE var_m_reset DECIMAL(16,2);
    DECLARE var_m_in  DECIMAL(16,2);
    DECLARE var_m_out  DECIMAL(16,2);
    DECLARE var_new_initial DECIMAL(16,2);
    DECLARE var_new_ending DECIMAL(16,2);

    -- 事务
    START TRANSACTION;
    -- 异常处理
    -- DECLARE EXIT HANDLER FOR SQLEXCEPTION , SQLWARNING , NOT FOUND ROLLBACK;

    SET var_exist = 0;
    SELECT count(user_id) into var_exist FROM tbl_wallet WHERE user_id = in_user_id;
    IF var_exist = 0 THEN
      SET result_code = -2;
    END IF;

    IF result_code = 0 THEN
      BEGIN

        -- 设置最初的值
        SELECT ending, oper_type, add_money, reset_money, roll_in_money, roll_out_money FROM tbl_wallet_trade WHERE user_id = in_user_id ORDER BY id DESC
          INTO var_ending, var_type, var_m_add, var_m_reset, var_m_in, var_m_out;

        SET var_new_initial = var_ending;
        CASE var_type
          WHEN 'Add' THEN SET var_new_ending = var_new_initial + var_m_add;
          WHEN 'Reset' THEN SET var_new_ending = var_new_initial + var_m_reset;
          WHEN 'In' THEN SET var_new_ending = var_new_initial + var_m_in;
          WHEN 'Out' THEN SET var_new_ending = var_new_initial + var_m_out;
          ELSE SET result_code = -3;
        END CASE;

        IF result_code = 0 THEN
          INSERT INTO tbl_wallet_trade(
            user_id, user_name, opposite_id, opposite_name, oper_type, add_money, reset_money, roll_in_money, roll_out_money, trade_no, remark, relate_exhibition,
            status, time, trade_type, unit, frozen
          ) VALUES (
            in_user_id, in_user_name, in_opposite_id, in_opposite_name, in_oper_type, in_add_money, in_reset_money, in_roll_in_money, in_roll_out_money, in_trade_no, in_remark, in_relate_exhibition,
            1, now(), 'Account', '元', 0
          );

          UPDATE tbl_wallet SET balance = var_new_ending WHERE user_id = in_user_id;

        END IF;
      END;
    END IF;


    -- 事务
    IF result_code = 0 THEN
      SET out_rcode = 0;
      COMMIT ;
    ELSE
      SET out_rcode = result_code;
      ROLLBACK ;
    END IF;

  END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for fix_wallet_trade_single_flow_record
-- ----------------------------
DROP PROCEDURE IF EXISTS `fix_wallet_trade_single_flow_record`;
DELIMITER ;;
CREATE DEFINER=`zbgj`@`%` PROCEDURE `fix_wallet_trade_single_flow_record`(IN in_trade_no VARCHAR(32), OUT out_rcode INT)
BEGIN
    DECLARE result_code INTEGER DEFAULT 0;
    DECLARE flow_count int DEFAULT 0;
    -- 过程变量
    DECLARE var_user_id int;
    DECLARE var_ending DECIMAL(16,2);
    DECLARE var_type VARCHAR(16);
    DECLARE var_m_add DECIMAL(16,2);
    DECLARE var_m_reset DECIMAL(16,2);
    DECLARE var_m_in  DECIMAL(16,2);
    DECLARE var_m_out  DECIMAL(16,2);
    DECLARE var_new_initial DECIMAL(16,2);
    DECLARE var_new_ending DECIMAL(16,2);
    -- 流水变量
    DECLARE flow_user_id int;
    DECLARE flow_user_name VARCHAR(32);
    DECLARE flow_opposite_id int;
    DECLARE flow_opposite_name VARCHAR(32);
    DECLARE flow_oper_type varchar(255);
    DECLARE flow_add_money decimal(18,2);
    DECLARE flow_reset_money decimal(18,2);
    DECLARE flow_roll_in_money decimal(18,2);
    DECLARE flow_roll_out_money decimal(18,2);
    DECLARE flow_remark varchar(50);
    DECLARE flow_relate_exhibition varchar(255);

    -- 事务
    SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    START TRANSACTION;
    -- 异常处理
    -- DECLARE EXIT HANDLER FOR SQLEXCEPTION , SQLWARNING , NOT FOUND ROLLBACK;

    SET flow_count = 0;
    SELECT count(trade_no) into flow_count FROM tbl_wallet_trade WHERE trade_no = in_trade_no;
    -- 符合需要修复的条件
    IF flow_count = 1 THEN
      BEGIN
        -- 设置流水的值
        SELECT user_id, user_name, opposite_id, opposite_name, oper_type, add_money, reset_money, roll_in_money, roll_out_money, remark, relate_exhibition
        FROM tbl_wallet_trade
        WHERE trade_no = in_trade_no
        INTO flow_user_id, flow_user_name, flow_opposite_id, flow_opposite_name, flow_oper_type, flow_add_money, flow_reset_money, flow_roll_in_money, flow_roll_out_money, flow_remark, flow_relate_exhibition;
        SET var_user_id = flow_opposite_id;
        SET var_type = flow_oper_type;
        SET var_m_add = -flow_add_money;
        SET var_m_reset = -flow_reset_money;
        SET var_m_in = -flow_roll_in_money;
        SET var_m_out = -flow_roll_out_money;

        -- 设置最初的值
        SELECT ending INTO var_ending FROM tbl_wallet_trade WHERE user_id = var_user_id ORDER BY id DESC LIMIT 1;
        SET var_new_initial = var_ending;
        CASE var_type
          WHEN 'Add' THEN SET var_new_ending = var_new_initial + var_m_add;
          WHEN 'Reset' THEN SET var_new_ending = var_new_initial + var_m_reset;
          WHEN 'In' THEN SET var_new_ending = var_new_initial + var_m_in;
          WHEN 'Out' THEN SET var_new_ending = var_new_initial + var_m_out;
          ELSE SET result_code = -3;
        END CASE;

        IF result_code = 0 THEN
          INSERT INTO tbl_wallet_trade(
            user_id, user_name, opposite_id, opposite_name, initial, ending, oper_type, add_money, reset_money, roll_in_money, roll_out_money, trade_no, remark, relate_exhibition,
            status, time, trade_type, unit, frozen
          ) VALUES (
            var_user_id, flow_opposite_name, flow_user_id, flow_user_name, var_new_initial, var_new_ending, flow_oper_type, var_m_add, var_m_reset, var_m_in, var_m_out, in_trade_no, flow_remark, flow_relate_exhibition,
            1, now(), 'Account', '元', 0
          );

          UPDATE tbl_wallet SET balance = var_new_ending WHERE user_id = var_user_id;

        END IF;
      END;

    END IF;


    -- 事务
    IF result_code = 0 THEN
      SET out_rcode = 0;
      COMMIT ;
    ELSE
      SET out_rcode = result_code;
      ROLLBACK ;
    END IF;

  END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for SaoyiSao
-- ----------------------------
DROP PROCEDURE IF EXISTS `SaoyiSao`;
DELIMITER ;;
CREATE DEFINER=`zbgj`@`%` PROCEDURE `SaoyiSao`(IN start NVARCHAR(20), IN end NVARCHAR(20))
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE name_cur NVARCHAR(20);
    DECLARE name_des_cur NVARCHAR(50);
    DECLARE cur CURSOR FOR SELECT
                             item_name,
                             item_desc
                           FROM tbl_promotion_type_item_config ORDER BY  id DESC ;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    DROP  TEMPORARY  TABLE IF EXISTS  sao_tmp ;
    CREATE TEMPORARY TABLE sao_tmp AS
      (
        SELECT
          a.createDate,
          a.userCode,
          b.name,
          b.phone,
          a.supplier_name,
          a.commodity_gram_weight,
          a.commodity_price,
          a.user_rebate_price,
          a.promotion_bonus_price,
          a.bonus_bdid,
          c.name as name1,
          a.params
        FROM tbl_user b,
          tbl_supplier_rebate a LEFT JOIN tb_business_development_info c ON a.bonus_bdid = c.id
        WHERE a.userCode = b.code AND a.isConfirm = 'Y' AND
              date_format(a.createDate, '%Y-%m-%d') BETWEEN start AND end
      );

    OPEN cur;

    loop_label: LOOP
      FETCH cur
      INTO name_cur, name_des_cur;
      IF done
      THEN
        LEAVE loop_label;
      END IF;
      UPDATE sao_tmp
      SET params = REPLACE(params, name_cur, name_des_cur);
    END LOOP loop_label;
    CLOSE cur;
    SELECT
      createDate            AS 时间,
      userCode              AS 用户编码,
      name                  AS 姓名,
      phone                 AS 手机,
      supplier_name         AS 供应商名称,
      commodity_gram_weight AS 克重,
      commodity_price       AS 工费,
      user_rebate_price     AS 用户返利,
      promotion_bonus_price AS 佣金,
      bonus_bdid            AS 超级管家id,
      name1                as 超级管家姓名,
      params                AS 明细
    FROM sao_tmp;
  END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for update_wallet_trade_flow_result
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_wallet_trade_flow_result`;
DELIMITER ;;
CREATE DEFINER=`zbgj`@`%` PROCEDURE `update_wallet_trade_flow_result`(IN in_uid INT, IN in_start_fid INT)
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE result_code INTEGER DEFAULT 0;
    -- 记录当前的正确的initial值
    DECLARE next_initial DECIMAL(16,2) DEFAULT null;
    -- 循环过程变量
    DECLARE var_id int DEFAULT -1;
    DECLARE var_initial DECIMAL(16,2);
    DECLARE var_ending DECIMAL(16,2);
    DECLARE var_type VARCHAR(16);
    DECLARE var_m_add DECIMAL(16,2);
    DECLARE var_m_reset DECIMAL(16,2);
    DECLARE var_m_in  DECIMAL(16,2);
    -- 声明游标
    DECLARE cur CURSOR FOR SELECT id, initial, ending, oper_type, add_money, reset_money, roll_in_money FROM tbl_wallet_trade WHERE user_id = in_uid and id >= in_start_fid ORDER BY id asc;
    DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;
    -- 事务
    START TRANSACTION;

    OPEN cur;

    REPEAT
      FETCH cur INTO var_id, var_initial, var_ending, var_type, var_m_add, var_m_reset, var_m_in;
      IF not done THEN
      BEGIN
        IF next_initial is not null THEN
          SET var_initial = next_initial;
          CASE var_type
            WHEN 'Add' THEN SET var_ending = var_initial + var_m_add;
            WHEN 'Reset' THEN SET var_ending = var_initial + var_m_reset;
            WHEN 'In' THEN SET var_ending = var_initial + var_m_in;
            ELSE SET result_code = -1;
          END CASE;
          UPDATE tbl_wallet_trade SET initial = var_initial, ending = var_ending WHERE id = var_id;
          SET next_initial = var_ending;

        ELSE
          -- > start_id 的第一笔记录，直接获取ending
          SET next_initial = var_ending;
        END IF;
      END;
      END IF;

    UNTIL done END REPEAT;
    CLOSE cur;
    -- 事务
    IF result_code = 0 THEN
      COMMIT ;
    ELSE
      ROLLBACK ;
    END IF;

  END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for user_wallet_transcation
-- ----------------------------
DROP PROCEDURE IF EXISTS `user_wallet_transcation`;
DELIMITER ;;
CREATE DEFINER=`zbgj`@`%` PROCEDURE `user_wallet_transcation`(
    IN in_uid INT,
    IN in_reluid INT,
    IN in_type VARCHAR(16) ,
    IN in_ab_code VARCHAR (32),
    IN in_amount DECIMAL(8,2) ,
    IN in_remark VARCHAR(256)
)
    COMMENT '用户钱包交易'
BEGIN
  DECLARE var_ub DECIMAL(8,2);
  DECLARE var_rub DECIMAL(8,2);
  SELECT balance INTO var_ub
  FROM tb_user_wallet_flow tf WHERE tf.uid = in_uid ORDER BY transaction_date DESC LIMIT 1;
  if var_ub is null then
      set var_ub = 0;
   end if;
  SELECT balance INTO var_rub
  FROM tb_user_wallet_flow tf WHERE tf.uid = in_reluid ORDER BY transaction_date DESC LIMIT 1;
  if var_rub is null then
      set var_rub = 0;
   end if;

  INSERT INTO tb_user_wallet_flow(uid, rel_uid, type, ab_code, amount, balance, transaction_date, remark)
  VALUES (in_uid, in_reluid, in_type, in_ab_code, in_amount, var_ub+in_amount, now(), in_remark);
  INSERT INTO tb_user_wallet_flow(uid, rel_uid, type, ab_code, amount, balance, transaction_date, remark)
  VALUES (in_reluid, in_uid, in_type, in_ab_code, -in_amount, var_rub-in_amount, now(), in_remark);
END
;;
DELIMITER ;

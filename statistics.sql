/*
Navicat MySQL Data Transfer

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2021-08-07 10:18:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for buried_point_event
-- ----------------------------
DROP TABLE IF EXISTS `buried_point_event`;
CREATE TABLE `buried_point_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '代理的CODE',
  `cts` int(11) DEFAULT NULL COMMENT '单位：秒 （server入库的时间戳）',
  `pkg` varchar(255) DEFAULT NULL,
  `channel` varchar(255) DEFAULT NULL,
  `pn` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `platform` varchar(255) DEFAULT NULL COMMENT 'pc h5 app  vungo aw',
  `aid` varchar(255) DEFAULT NULL,
  `gaid` varchar(255) DEFAULT NULL,
  `taurus_stat_uuid` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  `ts` int(11) DEFAULT NULL COMMENT '单位：秒 （上报上来的时间戳）',
  `event_key` varchar(255) DEFAULT NULL COMMENT '事件名称',
  `event_value` text COMMENT 'JOSN串',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2393 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for buried_point_template
-- ----------------------------
DROP TABLE IF EXISTS `buried_point_template`;
CREATE TABLE `buried_point_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '代理的CODE',
  `ts` int(11) DEFAULT NULL COMMENT '单位：秒 （上报上来的时间戳）',
  `cts` int(11) DEFAULT NULL COMMENT '单位：秒 （server入库的时间戳）',
  `pkg` varchar(255) DEFAULT NULL,
  `channel` varchar(255) DEFAULT NULL,
  `pn` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `platform` varchar(255) DEFAULT NULL COMMENT 'pc h5 app  vungo aw',
  `aid` varchar(255) DEFAULT NULL,
  `gaid` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  `taurus_stat_uuid` varchar(255) DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL COMMENT '生成、分享、点击、下载生成、分享、点击、下载',
  `template_id` varchar(255) DEFAULT NULL,
  `raw_data` text COMMENT 'JOSN串',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=806 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for statistical_analysis
-- ----------------------------
DROP TABLE IF EXISTS `statistical_analysis`;
CREATE TABLE `statistical_analysis` (
  `mid` varchar(255) DEFAULT NULL COMMENT '设备ID',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_record` int(11) DEFAULT NULL COMMENT '是否登录',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `mail` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `version_code` varchar(255) DEFAULT NULL COMMENT '程序版本号',
  `version_name` varchar(255) DEFAULT NULL COMMENT '程序版本名',
  `language` varchar(255) DEFAULT NULL COMMENT '系统语言',
  `source_url` varchar(255) DEFAULT NULL COMMENT '渠道来源url',
  `target_url` varchar(255) DEFAULT NULL COMMENT '下一渠道url',
  `remain_time` varchar(255) DEFAULT NULL COMMENT '停留时长',
  `remain_module` varchar(255) DEFAULT NULL COMMENT '浏览模块',
  `os_version` varchar(255) DEFAULT NULL COMMENT '系统版本',
  `area` varchar(255) DEFAULT NULL COMMENT '区域',
  `mobile_phone` varchar(255) NOT NULL COMMENT '手机号',
  `brand` varchar(255) DEFAULT NULL COMMENT '手机品牌',
  `last_time` datetime DEFAULT NULL COMMENT '最后停留时间',
  `screen_width` varchar(255) DEFAULT NULL COMMENT '屏幕宽',
  `screen_high` varchar(255) DEFAULT NULL COMMENT '屏幕高',
  `clue_name` varchar(255) DEFAULT NULL COMMENT '线索名称',
  `event_name` varchar(255) DEFAULT NULL COMMENT '事件名称',
  `event_type` varchar(255) DEFAULT NULL COMMENT '事件类型',
  `event_id` int(11) DEFAULT NULL COMMENT '事件ID',
  `event_key` varchar(255) DEFAULT NULL COMMENT '事件_key,参数 根据不同维度计算',
  `event_value` varchar(255) DEFAULT NULL COMMENT '与key是一组，key-value，是一种数据模型方法',
  `acquisition_time` datetime DEFAULT NULL COMMENT '采集时机',
  `event_remark` varchar(255) DEFAULT NULL COMMENT '事件评论',
  PRIMARY KEY (`id`,`mobile_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

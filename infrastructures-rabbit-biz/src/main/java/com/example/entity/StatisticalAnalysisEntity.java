package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/****
 * @Author: bingai
 *****/

@Data
public class StatisticalAnalysisEntity implements Serializable{

	@ApiModelProperty(value = "设备ID",required = false)
    @TableField( "mid")
	private String mid;//设备ID

	@ApiModelProperty(value = "",required = false)
    @TableField( "id")
	private Long id;//

	@ApiModelProperty(value = "是否登录",required = false)
    @TableField( "login_record")
	private Integer loginRecord;//是否登录

	@ApiModelProperty(value = "用户id",required = false)
    @TableField( "user_id")
	private Long userId;//用户id

	@ApiModelProperty(value = "邮箱",required = false)
    @TableField( "mail")
	private String mail;//邮箱

	@ApiModelProperty(value = "程序版本号",required = false)
    @TableField( "version_code")
	private String versionCode;//程序版本号

	@ApiModelProperty(value = "程序版本名",required = false)
    @TableField( "version_name")
	private String versionName;//程序版本名

	@ApiModelProperty(value = "系统语言",required = false)
    @TableField( "language")
	private String language;//系统语言

	@ApiModelProperty(value = "渠道来源url",required = false)
    @TableField( "source_url")
	private String sourceUrl;//渠道来源url

	@ApiModelProperty(value = "下一渠道url",required = false)
    @TableField( "target_url")
	private String targetUrl;//下一渠道url

	@ApiModelProperty(value = "停留时长",required = false)
    @TableField( "remain_time")
	private String remainTime;//停留时长

	@ApiModelProperty(value = "浏览模块",required = false)
    @TableField( "remain_module")
	private String remainModule;//浏览模块

	@ApiModelProperty(value = "系统版本",required = false)
    @TableField( "os_version")
	private String osVersion;//系统版本

	@ApiModelProperty(value = "区域",required = false)
    @TableField( "area")
	private String area;//区域

	@ApiModelProperty(value = "手机号",required = false)
	@Id
    @TableField( "mobile_phone")
	private String mobilePhone;//手机号

	@ApiModelProperty(value = "手机品牌",required = false)
    @TableField( "brand")
	private String brand;//手机品牌

	@ApiModelProperty(value = "最后停留时间",required = false)
    @TableField( "last_time")
	private Date lastTime;//最后停留时间

	@ApiModelProperty(value = "屏幕宽",required = false)
    @TableField( "screen_width")
	private String screenWidth;//屏幕宽

	@ApiModelProperty(value = "屏幕高",required = false)
    @TableField( "screen_high")
	private String screenHigh;//屏幕高

	@ApiModelProperty(value = "线索名称",required = false)
    @TableField( "clue_name")
	private String clueName;//线索名称

	@ApiModelProperty(value = "事件名称",required = false)
    @TableField( "event_name")
	private String eventName;//事件名称

	@ApiModelProperty(value = "事件类型",required = false)
    @TableField( "event_type")
	private String eventType;//事件类型

	@ApiModelProperty(value = "事件ID",required = false)
    @TableField( "event_id")
	private Integer eventId;//事件ID

	@ApiModelProperty(value = "事件_key,参数 根据不同维度计算",required = false)
    @TableField( "event_key")
	private String eventKey;//事件_key,参数 根据不同维度计算

	@ApiModelProperty(value = "与key是一组，key-value，是一种数据模型方法",required = false)
    @TableField( "event_value")
	private String eventValue;//与key是一组，key-value，是一种数据模型方法

	@ApiModelProperty(value = "采集时机",required = false)
    @TableField( "acquisition_time")
	private Date acquisitionTime;//采集时机

	@ApiModelProperty(value = "事件评论",required = false)
    @TableField( "event_remark")
	private String eventRemark;//事件评论



}

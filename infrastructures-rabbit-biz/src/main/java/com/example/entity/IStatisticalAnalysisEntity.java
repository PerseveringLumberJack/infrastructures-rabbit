package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author BINGAI
 * @since 2021-07-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("statistical_analysis")
public class IStatisticalAnalysisEntity extends Model<IStatisticalAnalysisEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 设备ID
     */
    @TableField("mid")
    private String mid;

    @TableId(value = "id")
    private Long id;

    /**
     * 是否登录
     */
    @TableField("login_record")
    private Integer loginRecord;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 邮箱
     */
    @TableField("mail")
    private String mail;

    /**
     * 程序版本号
     */
    @TableField("version_code")
    private String versionCode;

    /**
     * 程序版本名
     */
    @TableField("version_name")
    private String versionName;

    /**
     * 系统语言
     */
    @TableField("language")
    private String language;

    /**
     * 渠道来源url
     */
    @TableField("source_url")
    private String sourceUrl;

    /**
     * 下一渠道url
     */
    @TableField("target_url")
    private String targetUrl;

    /**
     * 停留时长
     */
    @TableField("remain_time")
    private String remainTime;

    /**
     * 浏览模块
     */
    @TableField("remain_module")
    private String remainModule;

    /**
     * 系统版本
     */
    @TableField("os_version")
    private String osVersion;

    /**
     * 区域
     */
    @TableField("area")
    private String area;

    /**
     * 手机号
     */
    @TableField("mobile_phone")
    private String mobilePhone;

    /**
     * 手机品牌
     */
    @TableField("brand")
    private String brand;

    /**
     * 最后停留时间
     */
    @TableField("last_time")
    private LocalDateTime lastTime;

    /**
     * 屏幕宽
     */
    @TableField("screen_width")
    private String screenWidth;

    /**
     * 屏幕高
     */
    @TableField("screen_high")
    private String screenHigh;

    /**
     * 线索名称
     */
    @TableField("clue_name")
    private String clueName;

    /**
     * 事件名称
     */
    @TableField("event_name")
    private String eventName;

    /**
     * 事件类型
     */
    @TableField("event_type")
    private String eventType;

    /**
     * 事件ID
     */
    @TableField("event_id")
    private Integer eventId;

    /**
     * 事件_key,参数 根据不同维度计算
     */
    @TableField("event_key")
    private String eventKey;

    /**
     * 与key是一组，key-value，是一种数据模型方法
     */
    @TableField("event_value")
    private String eventValue;

    /**
     * 采集时机
     */
    @TableField("acquisition_time")
    private LocalDateTime acquisitionTime;

    /**
     * 事件评论
     */
    @TableField("event_remark")
    private String eventRemark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

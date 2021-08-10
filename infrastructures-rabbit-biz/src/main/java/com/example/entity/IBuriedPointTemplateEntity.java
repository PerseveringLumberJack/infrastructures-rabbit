package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("buried_point_template")
public class IBuriedPointTemplateEntity extends Model<IBuriedPointTemplateEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 代理的CODE
     */
    @TableField("code")
    private String code;


    /**
     * 单位：秒 （server入库的时间戳）
     */
    @TableField("cts")
    private Integer cts;

    @TableField("pkg")
    private String pkg;

    @TableField("channel")
    private String channel;

    @TableField("pn")
    private String pn;

    @TableField("ip")
    private String ip;

    /**
     * pc h5 app  vungo aw
     */
    @TableField("platform")
    private String platform;

    @TableField("aid")
    private String aid;

    @TableField("gaid")
    private String gaid;

    @TableField("uid")
    private String uid;

    @TableField("taurus_stat_uuid")
    private String taurusStatUuid;

    /**
     * 单位：秒 （上报上来的时间戳）
     */
    @TableField("ts")
    private Integer ts;

    /**
     * 生成、分享、点击、下载生成、分享、点击、下载
     */
    @TableField("action")
    private String action;

    @TableField("template_id")
    private String templateId;

    /**
     * JOSN串
     */
    @TableField("raw_data")
    private String rawData;

    @TableField("share_platform")
    private String sharePlatform;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

package com.example.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author BINGAI
 * @since 2021-07-27
 */
@Data
public class BuriedPointEventDto implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "代理的CODE")
    private String code;

    @ApiModelProperty(value = "单位：秒 （server入库的时间戳）")
    private Integer cts;

    @ApiModelProperty(value = "pkg")
    private String pkg;

    @ApiModelProperty(value = "channel")
    private String channel;

    @ApiModelProperty(value = "pn")
    private String pn;

    @ApiModelProperty(value = "ip")
    private String ip;//

    @ApiModelProperty(value = "pc h5 app  vungo aw")
    private String platform;

    @ApiModelProperty(value = "aid")
    private String aid;

    @ApiModelProperty(value = "gaid")
    private String gaid;

    @ApiModelProperty(value = "taurusStatUuid")
    private String taurusStatUuid;

    @ApiModelProperty(value = "uid")
    private String uid;


    @ApiModelProperty(value = "ts",example = "单位：秒 （上报上来的时间戳）")
    private Integer ts;

    @ApiModelProperty(value = "event_key",example = "事件名称")
    private String eventKey;

    @ApiModelProperty(value = "event_value",example = "JOSN串")
    private String eventValue;



}

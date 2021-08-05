package com.example.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.config.IdAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.lang.Integer;

/****
 * @Author: bingai
 *****/

@Data
public class BuriedPointStatisticsEntity implements Serializable{

	private static final long serialVersionUID = 2905753866507637927L;

	@Id
    @TableField( "id")
	private Long id;//

    @TableField( "code")
	private String code;//代理的CODE

    @TableField( "ts")
	private Integer ts;//单位：秒 （上报上来的时间戳）

    @TableField( "cts")
	private Integer cts;//单位：秒 （server入库的时间戳）

    @TableField( "pkg")
	private String pkg;//

    @TableField( "channel")
	private String channel;//

    @TableField( "pn")
	private String pn;//

    @TableField( "ip")
	private String ip;//

    @TableField( "platform")
	private String platform;//pc h5 app  vungo aw

    @TableField( "aid")
	private String aid;//

    @TableField( "gaid")
	private String gaid;//

    @TableField( "taurus_stat_uuid")
	private String taurusStatUuid;//

    @TableField( "action")
	private String action;//生成、分享、点击、下载生成、分享、点击、下载

    @TableField( "template_id")
	private String templateId;//

    @TableField( "raw_data")
	private String rawData;//JOSN

}

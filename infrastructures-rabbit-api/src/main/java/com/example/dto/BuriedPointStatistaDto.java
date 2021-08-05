package com.example.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.lang.Integer;

/****
 * @Author: bingai
 *****/
@Data
@ApiModel(value = "BuriedPointStatistaDto")
public class BuriedPointStatistaDto implements Serializable{

	private static final long serialVersionUID = 1535090714285713726L;

	@ApiModelProperty(value = "ID")
	private Long id;//

	@ApiModelProperty(value = "代理的CODE")
	private String code;

	@ApiModelProperty(value = "单位：秒 （上报上来的时间戳）")
	private Integer ts;

	@ApiModelProperty(value = "单位：秒 （server入库的时间戳）")
	private Integer cts;

	@ApiModelProperty(value = "")
	private String pkg;

	@ApiModelProperty(value = "")
	private String channel;

	@ApiModelProperty(value = "")
	private String pn;

	@ApiModelProperty(value = "")
	private String ip;//

	@ApiModelProperty(value = "pc h5 app  vungo aw")
	private String platform;

	@ApiModelProperty(value = "")
	private String aid;

	@ApiModelProperty(value = "")
	private String gaid;

	@ApiModelProperty(value = "")
	private String taurusStatUuid;

	@ApiModelProperty(value = "生成、分享、点击、下载生成、分享、点击、下载")
	private String action;

	@ApiModelProperty(value = "")
	private String templateId;

	@ApiModelProperty(value = "JOSN串")
	private String rawData;


}

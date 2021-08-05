package com.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/****
 * @Author: bingai
 *****/
@Data
public class BuriedPointStatistaDto implements Serializable{

	private static final long serialVersionUID = 1535090714285713726L;

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

	@ApiModelProperty(value = "上报来的时间戳")
	private Integer ts;

	@ApiModelProperty(value = "生成、分享、点击、下载生成、分享、点击、下载")
	private String action;

	@ApiModelProperty(value = "templateId")
	private String templateId;

	@ApiModelProperty(value = "JOSN串")
	private String rawData;


}

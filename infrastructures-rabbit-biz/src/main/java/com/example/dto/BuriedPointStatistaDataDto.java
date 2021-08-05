package com.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/****
 * @Author: bingai
 *****/
@Data
public class BuriedPointStatistaDataDto implements Serializable{

	private static final long serialVersionUID = 1535090714285713726L;

	@ApiModelProperty(value = "上报来的时间戳")
	private Integer ts;

	@ApiModelProperty(value = "生成、分享、点击、下载生成、分享、点击、下载")
	private String action;

	@ApiModelProperty(value = "templateId")
	private String templateId;

	@ApiModelProperty(value = "JOSN串")
	private String rawData;


}

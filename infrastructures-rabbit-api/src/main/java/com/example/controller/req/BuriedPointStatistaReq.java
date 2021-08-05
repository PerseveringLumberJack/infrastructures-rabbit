package com.example.controller.req;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/****
 * @Author: bingai
 *****/
@Data
@ApiModel(value = "自建埋点上报数据请求参数")
public class BuriedPointStatistaReq implements Serializable{

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


	@ApiModelProperty(value = "type类型",example = "[type]:template or event")
	private String type;

	@ApiModelProperty(value = "JOSN串",example = "listJson")
	//private String listJson;
	private JSONArray listJson;



}

package com.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
public class BuriedPointEventDataDto implements Serializable{

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "ts",example = "单位：秒 （上报上来的时间戳）")
    private Integer ts;

    @ApiModelProperty(value = "event_key",example = "事件名称")
    private String eventKey;

    @ApiModelProperty(value = "event_value",example = "JOSN串")
    private String eventValue;



}

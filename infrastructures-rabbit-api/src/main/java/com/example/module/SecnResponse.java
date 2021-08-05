package com.example.module;


import com.example.enums.SecnCodes;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecnResponse<T> implements Serializable {


    private Integer code;

    private String msg;

    private String trace;

    private T data;


    public static SecnResponse ok() {
        return new SecnResponse();
    }

    public static SecnResponse fail() {
        return new SecnResponse(SecnCodes.INTERNAL_SERVER_ERROR.getCode(), SecnCodes.INTERNAL_SERVER_ERROR.getMessage());
    }

    public static SecnResponse fail(String errMsg) {
        return new SecnResponse(SecnCodes.INTERNAL_SERVER_ERROR.getCode(), errMsg);
    }

    public static <T> SecnResponse ok(T data) {
        return new SecnResponse(data);
    }

    public SecnResponse(){
     this.code = SecnCodes.SUCCESS.getCode();
     this.msg = SecnCodes.SUCCESS.getMessage();
    }

    public SecnResponse(Integer code,String msg){
        this.code = SecnCodes.SUCCESS.getCode();
        this.msg = SecnCodes.SUCCESS.getMessage();
        this.code = code;
        this.msg = msg;
    }

    public SecnResponse(T data){
        this.code = SecnCodes.SUCCESS.getCode();
        this.msg = SecnCodes.SUCCESS.getMessage();
        this.data = data;
    }

    public SecnResponse(Integer code, String msg, String trace, T data) {
        this.code = code;
        this.msg = msg;
        this.trace = trace;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

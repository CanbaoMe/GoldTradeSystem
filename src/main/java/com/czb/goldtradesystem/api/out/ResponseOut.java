package com.czb.goldtradesystem.api.out;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResponseOut {
    final static String SUCCESS_CODE = "200";
    final static String SUCCESS_MSG = "成功";
    final static String ERR_CODE = "404";
    final static String ERR_MSG = "失败";


    @ApiModelProperty("返回编码")
    public String errCode;
    @ApiModelProperty("返回信息")
    public String errMsg;

    public String setSuccess(){
        return errCode = SUCCESS_CODE;
    }
    public String setSuccessMsg(){
        return errMsg = SUCCESS_MSG;
    }
    public String setFailure(){
        return errCode = ERR_CODE;
    }
    public String setFailureMsg(){
        return errMsg = ERR_MSG;
    }





    @Override
    public String toString() {
        return "ResponseOut{" +
                "errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}

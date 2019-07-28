package com.czb.goldtradesystem.model;

import com.czb.goldtradesystem.api.in.RequestIn;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class QueryAllTradeRecordRequest extends RequestIn {
    @ApiModelProperty("用户身份证号")
    @NotNull
    String idCardNum;

//    @ApiModelProperty("产品类型")
//    @NotNull
//    String productType;
}

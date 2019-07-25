package com.czb.goldtradesystem.model;

import com.czb.goldtradesystem.api.in.RequestIn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("卖出黄金请求参数")
public class SellRequest extends RequestIn {
    @ApiModelProperty("用户身份证号")
    @NotNull
    String idCardNum;

    @ApiModelProperty("卖出数量")
    @NotNull
    String sellAmount;

    @ApiModelProperty("产品类型")
    @NotNull
    String productType;
}

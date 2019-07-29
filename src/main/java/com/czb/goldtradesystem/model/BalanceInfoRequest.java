package com.czb.goldtradesystem.model;

import com.czb.goldtradesystem.api.in.RequestIn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
@ApiModel("余额请求参数")

public class BalanceInfoRequest extends RequestIn {
    @ApiModelProperty("用户身份证号")
    @NotNull
    String idCardNum;
}

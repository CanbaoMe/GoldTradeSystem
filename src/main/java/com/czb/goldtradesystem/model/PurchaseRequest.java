package com.czb.goldtradesystem.model;

import com.czb.goldtradesystem.api.in.RequestIn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@ApiModel("购买黄金请求参数")
public class PurchaseRequest extends RequestIn {
    @ApiModelProperty("用户身份证号")
    @NotNull
    String idCardNum;

    @ApiModelProperty("产品类型")
    @NotNull
    String productType;

    @ApiModelProperty("购买数量")
    @NotNull
    BigDecimal purchaseAmount;

}

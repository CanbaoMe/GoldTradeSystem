package com.czb.goldtradesystem.model;


import com.czb.goldtradesystem.api.in.RequestIn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("查询交易信息请求参数")
public class QueryRecordRequest extends RequestIn {

    @ApiModelProperty("用户身份证号")
    @NotNull
    String idCardNum;

    @ApiModelProperty("产品类型")
    @NotNull
    String productType;


}

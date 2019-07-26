package com.czb.goldtradesystem.model;

import com.czb.goldtradesystem.api.out.ResponseOut;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("查询交易记录返回参数")
public class QueryRecordResponse  extends ResponseOut {


    @ApiModelProperty("返回产品类型")
    public String productType;
    @ApiModelProperty("返回买入总数")
    public String purchaseAmount;
    @ApiModelProperty("返回买入价格")
    public  String uesdMoney;
    @ApiModelProperty("返回操作时间")
    public  String oprTime;
    @ApiModelProperty("返回卖出总数")
    public String sellAmount;
    @ApiModelProperty("返回赚取利润")
    public  String earnMoney;

}

package com.czb.goldtradesystem.api.out;

import com.czb.goldtradesystem.model.GoldPurchaseInfo;
import com.czb.goldtradesystem.model.GoldSellInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SellGoldInfoOut extends ResponseOut{
    private static final long serialVersionUID = 1L;
    List<GoldSellInfo> goldSellInfoList;
//    @ApiModelProperty("返回产品类型")
//    public String productType;
//    @ApiModelProperty("返回卖出总数")
//    public String sellAmount;
//    @ApiModelProperty("返回卖出价格")
//    public  String earnMoney;
//    @ApiModelProperty("返回操作时间")
//    public  String oprTime;

}

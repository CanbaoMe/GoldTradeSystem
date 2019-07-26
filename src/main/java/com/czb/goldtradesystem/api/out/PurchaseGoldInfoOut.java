package com.czb.goldtradesystem.api.out;

import com.czb.goldtradesystem.model.GoldPurchaseInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PurchaseGoldInfoOut extends ResponseOut{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("返回产品类型")
    public String productType;
    @ApiModelProperty("返回买入总数")
    public String purchaseAmount;
    @ApiModelProperty("返回买入价格")
    public  String uesdMoney;
    @ApiModelProperty("返回操作时间")
    public  String oprTime;
    List<GoldPurchaseInfo> goldPurchaseInfoList;

}

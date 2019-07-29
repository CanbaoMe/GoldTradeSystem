package com.czb.goldtradesystem.api.out;

import com.czb.goldtradesystem.model.GoldPurchaseInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PurchaseGoldInfoOut extends ResponseOut{
    private static final long serialVersionUID = 1L;

    public String productType;

    public String purchaseAmount;

    public  String uesdMoney;

    public  String oprTime;

    List<GoldPurchaseInfo> goldPurchaseInfoList;

}

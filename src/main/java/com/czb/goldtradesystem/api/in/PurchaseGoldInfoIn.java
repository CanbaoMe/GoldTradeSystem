package com.czb.goldtradesystem.api.in;

import com.czb.goldtradesystem.model.GoldPurchaseInfo;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseGoldInfoIn extends RequestIn{
    private static final long serialVersionUID = 1L;

    private String idCardNum;
    private String productType;
   // private String purchaseAmount;
}

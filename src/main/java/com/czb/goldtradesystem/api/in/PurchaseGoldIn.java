package com.czb.goldtradesystem.api.in;

import lombok.Data;

@Data
public class PurchaseGoldIn extends RequestIn{
    private static final long serialVersionUID = 1L;

    private String idCardNum;
    private String productType;
    private String purchaseAmount;
}

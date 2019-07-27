package com.czb.goldtradesystem.api;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AllUserInfo {
    private static final long serialVersionUID = 1L;

    private String idCard;

    private String sellAmount;

    private String purchaseAmount;

    private String productType;

    private BigDecimal addMoney;

    private BigDecimal uesdMoney;

    private String oprTime;
}

package com.czb.goldtradesystem.api;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MyGoldHoldInfo {

    private String idCard;

    private String holdAmount;

    private String productType;

    private String oprTime;

    private String productName;

    private BigDecimal totalWorth;

    private BigDecimal yesterdayProfit;

    private BigDecimal totalProfit;

    @Override
    public String toString() {
        return "MyGoldHoldInfo{" +
                "idCard='" + idCard + '\'' +
                ", holdAmount='" + holdAmount + '\'' +
                ", productType='" + productType + '\'' +
                ", oprTime='" + oprTime + '\'' +
                ", productName='" + productName + '\'' +
                ", totalWorth=" + totalWorth +
                ", yesterdayProfit=" + yesterdayProfit +
                ", totalProfit=" + totalProfit +
                '}';
    }
}

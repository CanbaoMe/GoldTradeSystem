package com.czb.goldtradesystem.api.in;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SellGoldIn extends RequestIn{
    private static final long serialVersionUID = 1L;
    private String idCardNum;
    private BigDecimal sellAmount;
    private String productType;
    private String inquiryDate;//查询时间

}

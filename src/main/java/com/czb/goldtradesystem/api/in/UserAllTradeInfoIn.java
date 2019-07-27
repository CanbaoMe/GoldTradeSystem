package com.czb.goldtradesystem.api.in;

import lombok.Data;

@Data
public class UserAllTradeInfoIn extends RequestIn{
    private static final long serialVersionUID = 1L;
    private String productType;
    private String idCardNum;
}

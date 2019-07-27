package com.czb.goldtradesystem.api.in;
import com.czb.goldtradesystem.model.GoldSellInfo;
import lombok.Data;


@Data
public class SellGoldInfoIn extends RequestIn{
    private static final long serialVersionUID = 1L;
    private String productType;
    private String idCardNum;

}


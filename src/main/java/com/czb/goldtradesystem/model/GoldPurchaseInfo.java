package com.czb.goldtradesystem.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "gold_purchase_info")
    public class GoldPurchaseInfo {
    @Id
    private Integer id;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "purchase_amount")
    private BigDecimal purchaseAmount;

    @Column(name = "opr_time")
    private String oprTime;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "uesd_money")
    private BigDecimal uesdMoney;

    @Override
    public String toString() {
        return "GoldPurchaseInfo{" +
                "id=" + id +
                ", idCard='" + idCard + '\'' +
                ", purchaseAmount='" + purchaseAmount + '\'' +
                ", oprTime='" + oprTime + '\'' +
                ", productType='" + productType + '\'' +
                ", uesdMoney=" + uesdMoney +
                '}';
    }

}
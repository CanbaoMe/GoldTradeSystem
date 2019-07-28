package com.czb.goldtradesystem.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "gold_sell_info")
public class GoldSellInfo {
    @Id
    private Integer id;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "sell_amount")
    private BigDecimal sellAmount;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "add_money")
    private BigDecimal addMoney;

    @Column(name = "opr_time")
    private String oprTime;
    @Override
    public String toString() {
        return "GoldSellInfo{" +
                "id=" + id +
                ", idCard='" + idCard + '\'' +
                ", sellAmount='" + sellAmount + '\'' +
                ", productType='" + productType + '\'' +
                ", addMoney=" + addMoney +
                ", oprTime='" + oprTime + '\'' +
                '}';
    }

}
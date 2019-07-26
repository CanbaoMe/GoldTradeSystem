package com.czb.goldtradesystem.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "gold_sell_info")
public class GoldSellInfo {
    @Id
    private Integer id;
    //alt+fn+insert属性信息
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

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "sell_amount")
    private String sellAmount;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "add_money")
    private BigDecimal addMoney;

    @Column(name = "opr_time")
    private String oprTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(String sellAmount) {
        this.sellAmount = sellAmount == null ? null : sellAmount.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public BigDecimal getAddMoney() {
        return addMoney;
    }

    public void setAddMoney(BigDecimal addMoney) {
        this.addMoney = addMoney;
    }

    public String getOprTime() {
        return oprTime;
    }

    public void setOprTime(String oprTime) {
        this.oprTime = oprTime == null ? null : oprTime.trim();
    }
}
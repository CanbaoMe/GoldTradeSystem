package com.czb.goldtradesystem.model;

import javax.persistence.*;

@Table(name = "gold_hold_info")
public class GoldHoldInfo {
    @Id
    private String idCard;

    @Column(name = "hold_amount")
    private String holdAmount;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "opr_time")
    private String oprTime;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getHoldAmount() {
        return holdAmount;
    }

    public void setHoldAmount(String holdAmount) {
        this.holdAmount = holdAmount == null ? null : holdAmount.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getOprTime() {
        return oprTime;
    }

    public void setOprTime(String oprTime) {
        this.oprTime = oprTime == null ? null : oprTime.trim();
    }
}
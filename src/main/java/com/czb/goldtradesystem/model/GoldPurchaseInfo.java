package com.czb.goldtradesystem.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "gold_purchase_info")
public class GoldPurchaseInfo {
    @Id
    private Integer id;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "purchase_amount")
    private String purchaseAmount;

    @Column(name = "opr_time")
    private String oprTime;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "uesd_money")
    private BigDecimal uesdMoney;

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

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount == null ? null : purchaseAmount.trim();
    }

    public String getOprTime() {
        return oprTime;
    }

    public void setOprTime(String oprTime) {
        this.oprTime = oprTime == null ? null : oprTime.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public BigDecimal getUesdMoney() {
        return uesdMoney;
    }

    public void setUesdMoney(BigDecimal uesdMoney) {
        this.uesdMoney = uesdMoney;
    }
}
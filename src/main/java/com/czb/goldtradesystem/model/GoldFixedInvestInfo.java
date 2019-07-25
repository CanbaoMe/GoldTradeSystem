package com.czb.goldtradesystem.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "gold_fixed_invest_info")
public class GoldFixedInvestInfo {
    @Id
    private String idCard;

    @Column(name = "fixed_invest_money")
    private BigDecimal fixedInvestMoney;

    @Column(name = "fixed_invest_freq")
    private String fixedInvestFreq;

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

    public BigDecimal getFixedInvestMoney() {
        return fixedInvestMoney;
    }

    public void setFixedInvestMoney(BigDecimal fixedInvestMoney) {
        this.fixedInvestMoney = fixedInvestMoney;
    }

    public String getFixedInvestFreq() {
        return fixedInvestFreq;
    }

    public void setFixedInvestFreq(String fixedInvestFreq) {
        this.fixedInvestFreq = fixedInvestFreq == null ? null : fixedInvestFreq.trim();
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
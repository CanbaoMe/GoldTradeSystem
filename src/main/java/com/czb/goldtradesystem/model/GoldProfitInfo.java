package com.czb.goldtradesystem.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "gold_profit_info")
public class GoldProfitInfo {
    @Id
    private String idCard;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "actual_rate")
    private BigDecimal actualRate;

    @Column(name = "yesterday_profit")
    private BigDecimal yesterdayProfit;

    @Column(name = "total_profit")
    private BigDecimal totalProfit;

    @Column(name = "enterprise_type")
    private String enterpriseType;

    @Column(name = "opr_time")
    private String oprTime;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public BigDecimal getActualRate() {
        return actualRate;
    }

    public void setActualRate(BigDecimal actualRate) {
        this.actualRate = actualRate;
    }

    public BigDecimal getYesterdayProfit() {
        return yesterdayProfit;
    }

    public void setYesterdayProfit(BigDecimal yesterdayProfit) {
        this.yesterdayProfit = yesterdayProfit;
    }

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType == null ? null : enterpriseType.trim();
    }

    public String getOprTime() {
        return oprTime;
    }

    public void setOprTime(String oprTime) {
        this.oprTime = oprTime == null ? null : oprTime.trim();
    }
}
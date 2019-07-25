package com.czb.goldtradesystem.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "gold_product_info")
public class GoldProductInfo {
    @Id
    private String productType;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "enterprise_rate")
    private BigDecimal enterpriseRate;

    @Column(name = "opr_time")
    private String oprTime;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public BigDecimal getEnterpriseRate() {
        return enterpriseRate;
    }

    public void setEnterpriseRate(BigDecimal enterpriseRate) {
        this.enterpriseRate = enterpriseRate;
    }

    public String getOprTime() {
        return oprTime;
    }

    public void setOprTime(String oprTime) {
        this.oprTime = oprTime == null ? null : oprTime.trim();
    }
}
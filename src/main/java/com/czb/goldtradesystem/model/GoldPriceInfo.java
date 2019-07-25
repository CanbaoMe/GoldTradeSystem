package com.czb.goldtradesystem.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "gold_price_info")
public class GoldPriceInfo {
    @Id
    private Integer id;

    @Column(name = "gold_price")
    private BigDecimal goldPrice;

    @Column(name = "time")
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getGoldPrice() {
        return goldPrice;
    }

    public void setGoldPrice(BigDecimal goldPrice) {
        this.goldPrice = goldPrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}
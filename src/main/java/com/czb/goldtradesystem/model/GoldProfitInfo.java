package com.czb.goldtradesystem.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "gold_profit_info")
public class GoldProfitInfo {
    @Id
    private String id;
    @Column(name = "id_card")
    private String idCard;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "actual_rate")
    private BigDecimal actualRate;

    @Column(name = "yesterday_profit")
    private BigDecimal yesterdayProfit;

    @Column(name = "total_profit")
    private BigDecimal totalProfit;

    @Column(name = "opr_time")
    private String oprTime;
}
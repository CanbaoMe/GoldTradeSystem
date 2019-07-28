package com.czb.goldtradesystem.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "gold_hold_info")
public class GoldHoldInfo {
    @Id
    private String id;

    @Column(name = "id_Card")
    private String idCard;

    @Column(name = "hold_amount")
    private BigDecimal holdAmount;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "opr_time")
    private String oprTime;

}